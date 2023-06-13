package net.mcreator.test.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class MechTestPartsOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double searchRadius = 0;
		Entity attachedBody = null;
		searchRadius = 8;
		if (!world.getEntitiesOfClass(MechTestBodyEntity.class, AABB.ofSize(new Vec3(x, y, z), searchRadius, searchRadius, searchRadius), e -> true).isEmpty()) {
			if (((Entity) world.getEntitiesOfClass(MechTestBodyEntity.class, AABB.ofSize(new Vec3(x, y, z), searchRadius, searchRadius, searchRadius), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)).isAlive()) {
				{
					Entity _ent = entity;
					_ent.teleportTo((((Entity) world.getEntitiesOfClass(MechTestBodyEntity.class, AABB.ofSize(new Vec3(x, y, z), searchRadius, searchRadius, searchRadius), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()),
							(((Entity) world.getEntitiesOfClass(MechTestBodyEntity.class, AABB.ofSize(new Vec3(x, y, z), searchRadius, searchRadius, searchRadius), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()),
							(((Entity) world.getEntitiesOfClass(MechTestBodyEntity.class, AABB.ofSize(new Vec3(x, y, z), searchRadius, searchRadius, searchRadius), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport((((Entity) world.getEntitiesOfClass(MechTestBodyEntity.class, AABB.ofSize(new Vec3(x, y, z), searchRadius, searchRadius, searchRadius), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)).getX()),
								(((Entity) world.getEntitiesOfClass(MechTestBodyEntity.class, AABB.ofSize(new Vec3(x, y, z), searchRadius, searchRadius, searchRadius), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null)).getY()),
								(((Entity) world.getEntitiesOfClass(MechTestBodyEntity.class, AABB.ofSize(new Vec3(x, y, z), searchRadius, searchRadius, searchRadius), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(x, y, z)).findFirst().orElse(null)).getZ()), _ent.getYRot(), _ent.getXRot());
				}
				{
					Entity _ent = entity;
					_ent.setYRot(((Entity) world.getEntitiesOfClass(MechTestBodyEntity.class, AABB.ofSize(new Vec3(x, y, z), searchRadius, searchRadius, searchRadius), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).getYRot());
					_ent.setXRot(0);
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
				if (!entity.level.isClientSide())
					entity.discard();
			}
		} else {
			if (!entity.level.isClientSide())
				entity.discard();
		}
	}
}
