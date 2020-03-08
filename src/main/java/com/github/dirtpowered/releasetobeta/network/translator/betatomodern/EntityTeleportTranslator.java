package com.github.dirtpowered.releasetobeta.network.translator.betatomodern;

import com.github.dirtpowered.betaprotocollib.packet.data.EntityTeleportPacketData;
import com.github.dirtpowered.releasetobeta.network.session.BetaClientSession;
import com.github.dirtpowered.releasetobeta.network.translator.model.BetaToModern;
import com.github.dirtpowered.releasetobeta.utils.Utils;
import com.github.steveice10.mc.protocol.packet.ingame.server.entity.ServerEntityTeleportPacket;
import com.github.steveice10.packetlib.Session;
import org.pmw.tinylog.Logger;

public class EntityTeleportTranslator implements BetaToModern<EntityTeleportPacketData> {

    @Override
    public void translate(EntityTeleportPacketData packet, BetaClientSession session, Session modernSession) {
        int entityId = packet.getEntityId();
        int x = Utils.toModernPos(packet.getX());
        int y = Utils.toModernPos(packet.getY());
        int z = Utils.toModernPos(packet.getZ());

        float yaw = packet.getYaw();
        float pitch = packet.getPitch();

        Logger.info("TeleportPosition({}): X:{}, Y:{}, Z:{}", entityId, x, y, z);
        modernSession.send(new ServerEntityTeleportPacket(entityId, x, y, z, yaw, pitch, true));
    }
}