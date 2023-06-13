package net.mcreator.test.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class MMWhenInHandTickProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double raytraceDistance = 0;
		double targetX = 0;
		double targetY = 0;
		double targetZ = 0;
		double zPos = 0;
		double yPos = 0;
		double counter2 = 0;
		double counter1 = 0;
		double range = 0;
		double xPos = 0;
		double height = 0;
		boolean toggleXorZ = false;
		boolean toggleNorP = false;
		boolean inverseDirection = false;
		raytraceDistance = 10 + itemstack.getOrCreateTag().getDouble("MMrangeLevel") * 2;
		if (itemstack.getOrCreateTag().getBoolean("hasMMliquidUpgrade") == true && entity.isShiftKeyDown()) {
			if (entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.SOURCE_ONLY, entity))
					.getType() == HitResult.Type.BLOCK) {
				targetX = entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.SOURCE_ONLY, entity)).getBlockPos()
						.getX() + 0.5;
				targetY = entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.SOURCE_ONLY, entity)).getBlockPos()
						.getY();
				targetZ = entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.SOURCE_ONLY, entity)).getBlockPos()
						.getZ() + 0.5;
				if (!world.isEmptyBlock(new BlockPos(targetX, targetY + 0.5, targetZ))) {
					if (!world.getEntitiesOfClass(BlockIndicatorEntity1Entity.class, AABB.ofSize(new Vec3(targetX, (targetY + 0.5), targetZ), 0.2, 0.2, 0.2), e -> true).isEmpty()) {
						if (((Entity) world.getEntitiesOfClass(BlockIndicatorEntity1Entity.class, AABB.ofSize(new Vec3(targetX, (targetY + 0.5), targetZ), 0.2, 0.2, 0.2), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(targetX, (targetY + 0.5), targetZ)).findFirst().orElse(null)) instanceof LivingEntity _entity)
							_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 2, 0, (false), (false)));
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = new BlockIndicatorEntity1Entity(TestModEntities.BLOCK_INDICATOR_ENTITY_1.get(), _level);
							entityToSpawn.moveTo(targetX, targetY, targetZ, 0, 0);
							entityToSpawn.setYBodyRot(0);
							entityToSpawn.setYHeadRot(0);
							entityToSpawn.setDeltaMovement(0, 0, 0);
							if (entityToSpawn instanceof Mob _mobToSpawn)
								_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
							world.addFreshEntity(entityToSpawn);
						}
					}
				}
			}
		} else {
			if (entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
					.getType() == HitResult.Type.BLOCK) {
				targetX = entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()
						+ 0.5;
				targetY = entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY();
				targetZ = entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()
						+ 0.5;
				if (itemstack.getOrCreateTag().getDouble("MMradiusLevel") < 1 || entity.isShiftKeyDown()) {
					if (!world.isEmptyBlock(new BlockPos(targetX, targetY + 0.5, targetZ)) && !((world.getBlockState(new BlockPos(targetX, targetY + 0.5, targetZ))).getBlock() instanceof LiquidBlock)) {
						if (!world.getEntitiesOfClass(BlockIndicatorEntity1Entity.class, AABB.ofSize(new Vec3(targetX, (targetY + 0.5), targetZ), 0.2, 0.2, 0.2), e -> true).isEmpty()) {
							if (((Entity) world.getEntitiesOfClass(BlockIndicatorEntity1Entity.class, AABB.ofSize(new Vec3(targetX, (targetY + 0.5), targetZ), 0.2, 0.2, 0.2), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(targetX, (targetY + 0.5), targetZ)).findFirst().orElse(null)) instanceof LivingEntity _entity)
								_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 2, 0, (false), (false)));
						} else {
							if (world instanceof ServerLevel _level) {
								Entity entityToSpawn = new BlockIndicatorEntity1Entity(TestModEntities.BLOCK_INDICATOR_ENTITY_1.get(), _level);
								entityToSpawn.moveTo(targetX, targetY, targetZ, 0, 0);
								entityToSpawn.setYBodyRot(0);
								entityToSpawn.setYHeadRot(0);
								entityToSpawn.setDeltaMovement(0, 0, 0);
								if (entityToSpawn instanceof Mob _mobToSpawn)
									_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
								world.addFreshEntity(entityToSpawn);
							}
						}
					}
				} else if (itemstack.getOrCreateTag().getDouble("MMradiusLevel") == 1 && !entity.isShiftKeyDown()) {
					yPos = targetY;
					height = 1;
					range = 3;
				} else if (itemstack.getOrCreateTag().getDouble("MMradiusLevel") == 2 && !entity.isShiftKeyDown()) {
					if ((entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
							.getDirection()) == Direction.UP
							|| !((entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getDirection()) == Direction.UP) && targetY < entity.getY() + entity.getBbHeight() / 2) {
						yPos = targetY - 1;
					} else {
						yPos = targetY;
					}
					height = 2;
					range = 3;
				} else if (itemstack.getOrCreateTag().getDouble("MMradiusLevel") == 3 && !entity.isShiftKeyDown()) {
					if ((entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
							.getDirection()) == Direction.UP
							|| !((entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getDirection()) == Direction.UP) && targetY < entity.getY() + entity.getBbHeight() / 2) {
						yPos = targetY - 1;
					} else {
						yPos = targetY;
					}
					height = 2;
					range = 5;
				}
				if (((entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.NORTH
						|| !((entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
								.getDirection()) == Direction.NORTH) && targetZ > entity.getZ())
						&& ((entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
								.getDirection()) == Direction.WEST
								|| !((entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
										.getDirection()) == Direction.WEST) && targetX > entity.getX())
						|| itemstack.getOrCreateTag().getDouble("MMradiusLevel") == 3 && !entity.isShiftKeyDown()) {
					toggleNorP = true;
					inverseDirection = false;
				} else if (((entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.NORTH
						|| !((entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
								.getDirection()) == Direction.NORTH) && targetZ > entity.getZ())
						&& ((entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
								.getDirection()) == Direction.EAST
								|| !((entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
										.getDirection()) == Direction.EAST) && targetX < entity.getX())) {
					toggleNorP = false;
					inverseDirection = true;
				} else if (((entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
						.getDirection()) == Direction.SOUTH
						|| !((entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
								.getDirection()) == Direction.SOUTH) && targetZ < entity.getZ())
						&& ((entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
								.getDirection()) == Direction.WEST
								|| !((entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
										.getDirection()) == Direction.WEST) && targetX > entity.getX())) {
					toggleNorP = true;
					inverseDirection = true;
				} else {
					toggleNorP = false;
					inverseDirection = false;
				}
				if (itemstack.getOrCreateTag().getDouble("MMradiusLevel") >= 1 && !entity.isShiftKeyDown()) {
					toggleXorZ = true;
					xPos = targetX;
					zPos = targetZ;
					counter1 = 1;
					counter2 = 2;
					for (int index0 = 0; index0 < (int) (range); index0++) {
						for (int index1 = 0; index1 < (int) (counter1); index1++) {
							for (int index2 = 0; index2 < (int) (height); index2++) {
								if (!world.isEmptyBlock(new BlockPos(xPos, yPos + 0.5, zPos)) && !((world.getBlockState(new BlockPos(xPos, yPos + 0.5, zPos))).getBlock() instanceof LiquidBlock)) {
									if (!world.getEntitiesOfClass(BlockIndicatorEntity1Entity.class, AABB.ofSize(new Vec3(xPos, (yPos + 0.5), zPos), 0.2, 0.2, 0.2), e -> true).isEmpty()) {
										if (((Entity) world.getEntitiesOfClass(BlockIndicatorEntity1Entity.class, AABB.ofSize(new Vec3(xPos, (yPos + 0.5), zPos), 0.2, 0.2, 0.2), e -> true).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
											}
										}.compareDistOf(xPos, (yPos + 0.5), zPos)).findFirst().orElse(null)) instanceof LivingEntity _entity)
											_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 2, 0, (false), (false)));
									} else {
										if (world instanceof ServerLevel _level) {
											Entity entityToSpawn = new BlockIndicatorEntity1Entity(TestModEntities.BLOCK_INDICATOR_ENTITY_1.get(), _level);
											entityToSpawn.moveTo(xPos, yPos, zPos, 0, 0);
											entityToSpawn.setYBodyRot(0);
											entityToSpawn.setYHeadRot(0);
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob _mobToSpawn)
												_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
											world.addFreshEntity(entityToSpawn);
										}
									}
								}
								yPos = yPos + 1;
							}
							if (toggleXorZ == true) {
								if (toggleNorP == true) {
									xPos = xPos + 1;
								} else if (toggleNorP == false) {
									xPos = xPos - 1;
								}
							} else if (toggleXorZ == false) {
								if (toggleNorP == true) {
									zPos = zPos + 1;
								} else if (toggleNorP == false) {
									zPos = zPos - 1;
								}
							}
							yPos = yPos - height;
						}
						if (toggleXorZ == true) {
							toggleXorZ = false;
						} else if (toggleXorZ == false) {
							toggleXorZ = true;
						}
						if (inverseDirection != true) {
							counter2 = counter2 - 1;
							if (counter2 == 0) {
								if (toggleNorP == true) {
									toggleNorP = false;
								} else if (toggleNorP == false) {
									toggleNorP = true;
								}
								counter1 = counter1 + 1;
								counter2 = 2;
							}
						} else if (inverseDirection == true) {
							if (toggleNorP == true) {
								toggleNorP = false;
							} else if (toggleNorP == false) {
								toggleNorP = true;
							}
							range = range + 1;
							counter2 = counter2 + 1;
							inverseDirection = false;
						}
					}
				}
			}
		}
	}
}
