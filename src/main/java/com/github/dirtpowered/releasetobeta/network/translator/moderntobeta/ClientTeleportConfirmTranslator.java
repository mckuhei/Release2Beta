package com.github.dirtpowered.releasetobeta.network.translator.moderntobeta;

import com.github.dirtpowered.releasetobeta.network.session.BetaClientSession;
import com.github.dirtpowered.releasetobeta.network.translator.model.ModernToBeta;
import com.github.dirtpowered.releasetobeta.utils.Utils;
import com.github.steveice10.mc.protocol.packet.ingame.client.world.ClientTeleportConfirmPacket;
import com.github.steveice10.packetlib.Session;

public class ClientTeleportConfirmTranslator implements ModernToBeta<ClientTeleportConfirmPacket> {

    @Override
    public void translate(ClientTeleportConfirmPacket packet, Session modernSession, BetaClientSession betaSession) {
        Utils.debug(packet);
        //TODO: send ClientPlayerPositionRotationPacket when stuck in invisible/not mapped block
    }
}