package net.mcreator.test.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class MechTestBodyOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(!world.getEntitiesOfClass(MechTestArmLeftEntity.class, AABB.ofSize(new Vec3(x, y, z), 2, 2, 2), e -> true).isEmpty())) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new MechTestArmLeftEntity(TestModEntities.DELETED_MOD_ELEMENT.get(), _level);
				entityToSpawn.moveTo(x, y, z, entity.getYRot(), 0);
				entityToSpawn.setYBodyRot(entity.getYRot());
				entityToSpawn.setYHeadRot(entity.getYRot());
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
		}
		if (!(!world.getEntitiesOfClass(MechTestArmRightEntity.class, AABB.ofSize(new Vec3(x, y, z), 2, 2, 2), e -> true).isEmpty())) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new MechTestArmRightEntity(TestModEntities.DELETED_MOD_ELEMENT.get(), _level);
				entityToSpawn.moveTo(x, y, z, entity.getYRot(), 0);
				entityToSpawn.setYBodyRot(entity.getYRot());
				entityToSpawn.setYHeadRot(entity.getYRot());
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
		}
		if (!(!world.getEntitiesOfClass(MechTestLegLeftEntity.class, AABB.ofSize(new Vec3(x, y, z), 2, 2, 2), e -> true).isEmpty())) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new MechTestLegLeftEntity(TestModEntities.MECH_TEST_LEG_LEFT.get(), _level);
				entityToSpawn.moveTo(x, y, z, entity.getYRot(), 0);
				entityToSpawn.setYBodyRot(entity.getYRot());
				entityToSpawn.setYHeadRot(entity.getYRot());
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
		}
		if (!(!world.getEntitiesOfClass(MechTestLegRightEntity.class, AABB.ofSize(new Vec3(x, y, z), 2, 2, 2), e -> true).isEmpty())) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new MechTestLegRightEntity(TestModEntities.MECH_TEST_LEG_RIGHT.get(), _level);
				entityToSpawn.moveTo(x, y, z, entity.getYRot(), 0);
				entityToSpawn.setYBodyRot(entity.getYRot());
				entityToSpawn.setYHeadRot(entity.getYRot());
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
		}
	}
}
