package com.github.dirtpowered.releasetobeta.network.server;

import com.github.dirtpowered.releasetobeta.data.player.ModernPlayer;
import com.github.dirtpowered.releasetobeta.network.session.MultiSession;
import com.github.dirtpowered.releasetobeta.utils.MapUtil;
import com.github.steveice10.mc.auth.data.GameProfile;
import com.github.steveice10.mc.protocol.data.game.PlayerListEntry;
import com.github.steveice10.mc.protocol.data.game.PlayerListEntryAction;
import com.github.steveice10.mc.protocol.packet.ingame.server.ServerPlayerListEntryPacket;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;

public class PlayerList {
    private ServerConnection serverConnection;

    PlayerList(ServerConnection serverConnection) {
        this.serverConnection = serverConnection;
    }

    public List<ModernPlayer> getPlayers() {
        Map<String, MultiSession> sessionMap = serverConnection.getMain().getSessionRegistry().getSessions();
        List<MultiSession> players = new ArrayList<>(sessionMap.values());

        return MapUtil.transform(players, new Function<MultiSession, ModernPlayer>() {
            @Nullable
            @Override
            public ModernPlayer apply(@Nullable MultiSession multiSession) {
                return Objects.requireNonNull(multiSession).getBetaClientSession().getPlayer();
            }
        });
    }

    List<GameProfile> getProfiles() {
        return MapUtil.transform(getPlayers(), new Function<ModernPlayer, GameProfile>() {
            @Nullable
            @Override
            public GameProfile apply(@Nullable ModernPlayer player) {
                return Objects.requireNonNull(player).getGameProfile();
            }
        });
    }

    private List<PlayerListEntry> getTabEntries() {
        return MapUtil.transform(getPlayers(), new Function<ModernPlayer, PlayerListEntry>() {
            @Nullable
            @Override
            public PlayerListEntry apply(@Nullable ModernPlayer player) {
                return Objects.requireNonNull(player).getTabEntry();
            }
        });
    }

    public void removeTabEntry(ModernPlayer player) {
        if (player.getGameProfile() == null)
            return;

        ServerPlayerListEntryPacket entryPacket =
                new ServerPlayerListEntryPacket(PlayerListEntryAction.REMOVE_PLAYER, new PlayerListEntry[]{
                        new PlayerListEntry(player.getGameProfile())
                });

        serverConnection.broadcastPacket(entryPacket);
    }

    public void addTabEntry(ModernPlayer player) {
        if (player.getTabEntry() == null)
            return;

        player.sendPacket(new ServerPlayerListEntryPacket(PlayerListEntryAction.ADD_PLAYER, getTabEntries().toArray(new PlayerListEntry[0])));
        ServerPlayerListEntryPacket entryPacket =
                new ServerPlayerListEntryPacket(PlayerListEntryAction.ADD_PLAYER, new PlayerListEntry[]{
                        player.getTabEntry()
                });

        serverConnection.broadcastPacket(entryPacket);
    }

    public UUID getUUIDFromUsername(String username) {
        for (ModernPlayer player : getPlayers()) {
            if (player.getUsername() != null) {
                if (player.getUsername().equals(username)) {
                    return player.getGameProfile().getId();
                }
            } else {
                player.getSession().disconnect();
            }
        }

        return UUID.randomUUID();
    }
}
