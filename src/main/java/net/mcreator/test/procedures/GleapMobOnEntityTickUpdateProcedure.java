package net.mcreator.test.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.test.init.TestModMobEffects;
import net.mcreator.test.TestMod;

public class GleapMobOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double targetX = 0;
		double targetY = 0;
		double targetZ = 0;
		double offsetX = 0;
		double offsetZ = 0;
		double yawAngle = 0;
		if (entity.isAlive() && !world.isClientSide()) {
			if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) == null)) {
				targetX = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX();
				targetY = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY();
				targetZ = (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ();
				yawAngle = (-1) * Math.atan2(targetX - entity.getX(), targetZ - entity.getZ()) * (180 / Math.PI);
				{
					Entity _ent = entity;
					_ent.setYRot((float) yawAngle);
					_ent.setXRot(entity.getXRot());
					_ent.setYBodyRot(_ent.getYRot());
					_ent.setYHeadRot(_ent.getYRot());
					_ent.yRotO = _ent.getYRot();
					_ent.xRotO = _ent.getXRot();
					if (_ent instanceof LivingEntity _entity) {
						_entity.yBodyRotO = _entity.getYRot();
						_entity.yHeadRotO = _entity.getYRot();
					}
				}
			} else {
				yawAngle = entity.getYRot();
				if (true == true) {
					if (yawAngle < 0) {
						yawAngle = yawAngle + 360;
					}
					if (yawAngle > 180) {
						yawAngle = 180 - (yawAngle - 180);
						yawAngle = yawAngle * (-1);
					}
					offsetX = yawAngle / (-90);
					if (offsetX > 1) {
						offsetX = 1 - (offsetX - 1);
					} else if (offsetX < -1) {
						offsetX = (-1) - (offsetX + 1);
					}
					offsetZ = yawAngle - 90;
					if (offsetZ < -180) {
						offsetZ = offsetZ + 360;
					}
					offsetZ = offsetZ / (-90);
					if (offsetZ > 1) {
						offsetZ = 1 - (offsetZ - 1);
					} else if (offsetZ < -1) {
						offsetZ = (-1) - (offsetZ + 1);
					}
					offsetX = offsetX * 10;
					offsetZ = offsetZ * 10;
				}
				targetX = entity.getX() + offsetX;
				targetY = entity.getY();
				targetZ = entity.getZ() + offsetZ;
				if (entity instanceof Mob _entity)
					_entity.getNavigation().moveTo(targetX, targetY, targetZ, 1);
			}
			if (!(entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(TestModMobEffects.SHIELD_GENERATOR_EFFECT.get()) : false)) {
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(TestModMobEffects.SHIELD_GENERATOR_EFFECT.get(), 30, 0, (false), (false)));
				if (entity instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 40, -3, (false), (false)));
				if (Math.abs(entity.getDeltaMovement().y()) < 0.255) {
					entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() + 0.55), (entity.getDeltaMovement().z())));
				}
				TestMod.queueServerWork(5, () -> {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 25, 9, (false), (false)));
				});
			}
		}
	}
}
