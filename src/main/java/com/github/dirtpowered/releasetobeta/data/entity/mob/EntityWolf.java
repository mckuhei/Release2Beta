package com.github.dirtpowered.releasetobeta.data.entity.mob;

import com.github.dirtpowered.releasetobeta.data.entity.model.Entity;
import com.github.dirtpowered.releasetobeta.data.entity.model.Mob;
import com.github.steveice10.mc.protocol.data.game.entity.type.MobType;
import com.github.steveice10.mc.protocol.data.game.world.sound.BuiltinSound;
import com.github.steveice10.mc.protocol.data.game.world.sound.SoundCategory;
import com.github.steveice10.packetlib.Session;

public class EntityWolf extends Entity implements Mob {

    public EntityWolf(int entityId) {
        super(entityId, MobType.WOLF);
    }

    @Override
    public void onSpawn(Session session) {

    }

    @Override
    public void onDeath(Session session) {
        playSound(session, BuiltinSound.ENTITY_WOLF_DEATH, SoundCategory.AMBIENT);
    }

    @Override
    public void onDamage(Session session) {
        playSound(session, BuiltinSound.ENTITY_WOLF_HURT, SoundCategory.AMBIENT);
    }
}
