package com.github.dirtpowered.releasetobeta.data.player;

import com.github.dirtpowered.releasetobeta.data.inventory.PlayerInventory;
import com.github.dirtpowered.releasetobeta.network.session.BetaClientSession;
import com.github.dirtpowered.releasetobeta.utils.Utils;
import com.github.steveice10.mc.auth.data.GameProfile;
import com.github.steveice10.mc.protocol.data.game.PlayerListEntry;
import com.github.steveice10.mc.protocol.data.game.entity.player.GameMode;
import com.github.steveice10.mc.protocol.data.message.Message;
import com.github.steveice10.mc.protocol.packet.ingame.server.ServerDisconnectPacket;
import com.github.steveice10.mc.protocol.packet.ingame.server.window.ServerWindowItemsPacket;
import com.github.steveice10.packetlib.packet.Packet;

public class ModernPlayer {
    private String username;
    private int entityId;
    private BetaClientSession session;
    private String clientId;
    private GameProfile gameProfile;
    private int dimension;
    private boolean sneaking;
    private PlayerInventory inventory;

    public ModernPlayer(BetaClientSession session) {
        this.session = session;
        this.inventory = new PlayerInventory();
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public GameProfile getGameProfile() {
        return gameProfile;
    }

    public PlayerListEntry getTabEntry() {
        return new PlayerListEntry(getGameProfile(), GameMode.SURVIVAL, 0, Message.fromString(username));
    }

    public BetaClientSession getSession() {
        return session;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        if (session.getMain().getConfiguration().isSkinFixEnabled()) {
            this.gameProfile = new GameProfile(Utils.getOfflineUUID(username), username);
            //TODO: fetch uuid/skin from mojang api
        } else {
            this.gameProfile = new GameProfile(Utils.getOfflineUUID(username), username);
        }
    }

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void sendPacket(Packet modernPacket) {
        session.getMain().getSessionRegistry().getSession(clientId).getModernSession().send(modernPacket);
    }

    public void kick(String reason) {
        sendPacket(new ServerDisconnectPacket(reason));
    }

    public boolean isSneaking() {
        return sneaking;
    }

    public void setSneaking(boolean sneaking) {
        this.sneaking = sneaking;
    }

    public PlayerInventory getInventory() {
        return inventory;
    }

    //TODO: Send when client used not existing inventory action
    public void updateInventory() {
        sendPacket(new ServerWindowItemsPacket(0, inventory.getItems()));
    }
}