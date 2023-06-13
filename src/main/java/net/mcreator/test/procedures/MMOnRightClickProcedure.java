package net.mcreator.test.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class MMOnRightClickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean toggleXorZ = false;
		boolean inverseDirection = false;
		boolean toggleNorP = false;
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
		double powerMultiplier = 0;
		powerMultiplier = 0.455;
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
				if ((world.getFluidState(new BlockPos(targetX, targetY, targetZ)).createLegacyBlock()).getBlock() instanceof LiquidBlock) {
					if ((world.getFluidState(new BlockPos(targetX, targetY, targetZ)).createLegacyBlock()).getBlock() == Blocks.WATER) {
						for (int index0 = 0; index0 < (int) (4); index0++) {
							if (world instanceof Level _level && !_level.isClientSide()) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.OAK_BUTTON));
								entityToSpawn.setPickUpDelay(0);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((world.getFluidState(new BlockPos(targetX, targetY, targetZ)).createLegacyBlock()).getBlock() == Blocks.LAVA) {
						for (int index1 = 0; index1 < (int) (4); index1++) {
							if (world instanceof Level _level && !_level.isClientSide()) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.ACACIA_BUTTON));
								entityToSpawn.setPickUpDelay(0);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((world.getFluidState(new BlockPos(targetX, targetY, targetZ)).createLegacyBlock()).getBlock() == TestModBlocks.POISON.get()) {
						for (int index2 = 0; index2 < (int) (4); index2++) {
							if (world instanceof Level _level && !_level.isClientSide()) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.WARPED_BUTTON));
								entityToSpawn.setPickUpDelay(0);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					}
					world.levelEvent(2001, new BlockPos(targetX, targetY, targetZ), Block.getId((world.getFluidState(new BlockPos(targetX, targetY, targetZ)).createLegacyBlock())));
					world.setBlock(new BlockPos(targetX, targetY, targetZ), Blocks.AIR.defaultBlockState(), 3);
				} else {
					if (world instanceof Level _level && !_level.isClientSide()) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack((world.getBlockState(new BlockPos(targetX, targetY, targetZ))).getBlock())));
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
					world.destroyBlock(new BlockPos(targetX, targetY, targetZ), false);
				}
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
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
					if (!world.isEmptyBlock(new BlockPos(targetX, targetY, targetZ))) {
						if (!world.getEntitiesOfClass(BlockIndicatorEntity1Entity.class, AABB.ofSize(new Vec3(targetX, targetY, targetZ), 0.2, 0.2, 0.2), e -> true).isEmpty()) {
							if (((Entity) world.getEntitiesOfClass(BlockIndicatorEntity1Entity.class, AABB.ofSize(new Vec3(targetX, targetY, targetZ), 0.2, 0.2, 0.2), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
								}
							}.compareDistOf(targetX, targetY, targetZ)).findFirst().orElse(null)).getPersistentData().getDouble("MMminingProgress") <= 0) {
								if (world.getBlockState(new BlockPos(targetX, targetY, targetZ)).getDestroySpeed(world, new BlockPos(targetX, targetY, targetZ)) < 20) {
									((Entity) world.getEntitiesOfClass(BlockIndicatorEntity1Entity.class, AABB.ofSize(new Vec3(targetX, targetY, targetZ), 0.2, 0.2, 0.2), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf(targetX, targetY, targetZ)).findFirst().orElse(null)).getPersistentData().putDouble("MMminingProgress",
											(world.getBlockState(new BlockPos(targetX, targetY, targetZ)).getDestroySpeed(world, new BlockPos(targetX, targetY, targetZ))));
								} else {
									((Entity) world.getEntitiesOfClass(BlockIndicatorEntity1Entity.class, AABB.ofSize(new Vec3(targetX, targetY, targetZ), 0.2, 0.2, 0.2), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
										}
									}.compareDistOf(targetX, targetY, targetZ)).findFirst().orElse(null)).getPersistentData().putDouble("MMminingProgress",
											(16 + world.getBlockState(new BlockPos(targetX, targetY, targetZ)).getDestroySpeed(world, new BlockPos(targetX, targetY, targetZ)) / 5));
								}
							} else {
								((Entity) world.getEntitiesOfClass(BlockIndicatorEntity1Entity.class, AABB.ofSize(new Vec3(targetX, targetY, targetZ), 0.2, 0.2, 0.2), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(targetX, targetY, targetZ)).findFirst().orElse(null)).getPersistentData().putDouble("MMminingProgress",
										(((Entity) world.getEntitiesOfClass(BlockIndicatorEntity1Entity.class, AABB.ofSize(new Vec3(targetX, targetY, targetZ), 0.2, 0.2, 0.2), e -> true).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
											}
										}.compareDistOf(targetX, targetY, targetZ)).findFirst().orElse(null)).getPersistentData().getDouble("MMminingProgress") - (itemstack.getOrCreateTag().getDouble("MMpowerLevel") + 1) * powerMultiplier));
								if (((Entity) world.getEntitiesOfClass(BlockIndicatorEntity1Entity.class, AABB.ofSize(new Vec3(targetX, targetY, targetZ), 0.2, 0.2, 0.2), e -> true).stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
									}
								}.compareDistOf(targetX, targetY, targetZ)).findFirst().orElse(null)).getPersistentData().getDouble("MMminingProgress") > 0) {
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, new BlockPos(targetX, targetY, targetZ), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.step")), SoundSource.BLOCKS, 1, 1);
										} else {
											_level.playLocalSound(targetX, targetY, targetZ, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.step")), SoundSource.BLOCKS, 1, 1, false);
										}
									}
									world.levelEvent(2001, new BlockPos(targetX, targetY, targetZ), Block.getId((world.getFluidState(new BlockPos(targetX, targetY, targetZ)).createLegacyBlock())));
								} else {
									if (world instanceof Level _level && !_level.isClientSide()) {
										ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack((world.getBlockState(new BlockPos(targetX, targetY, targetZ))).getBlock())));
										entityToSpawn.setPickUpDelay(0);
										_level.addFreshEntity(entityToSpawn);
									}
									world.destroyBlock(new BlockPos(targetX, targetY, targetZ), false);
								}
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
										.getDirection()) == Direction.WEST) && targetX > entity.getX())) {
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
					for (int index3 = 0; index3 < (int) (range); index3++) {
						for (int index4 = 0; index4 < (int) (counter1); index4++) {
							for (int index5 = 0; index5 < (int) (height); index5++) {
								if (!world.isEmptyBlock(new BlockPos(xPos, yPos, zPos))) {
									if (!world.getEntitiesOfClass(BlockIndicatorEntity1Entity.class, AABB.ofSize(new Vec3(xPos, yPos, zPos), 0.2, 0.2, 0.2), e -> true).isEmpty()) {
										if (((Entity) world.getEntitiesOfClass(BlockIndicatorEntity1Entity.class, AABB.ofSize(new Vec3(xPos, yPos, zPos), 0.2, 0.2, 0.2), e -> true).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
											}
										}.compareDistOf(xPos, yPos, zPos)).findFirst().orElse(null)).getPersistentData().getDouble("MMminingProgress") <= 0) {
											if (world.getBlockState(new BlockPos(xPos, yPos, zPos)).getDestroySpeed(world, new BlockPos(xPos, yPos, zPos)) < 20) {
												((Entity) world.getEntitiesOfClass(BlockIndicatorEntity1Entity.class, AABB.ofSize(new Vec3(xPos, yPos, zPos), 0.2, 0.2, 0.2), e -> true).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
													}
												}.compareDistOf(xPos, yPos, zPos)).findFirst().orElse(null)).getPersistentData().putDouble("MMminingProgress",
														(world.getBlockState(new BlockPos(xPos, yPos, zPos)).getDestroySpeed(world, new BlockPos(xPos, yPos, zPos))));
											} else {
												((Entity) world.getEntitiesOfClass(BlockIndicatorEntity1Entity.class, AABB.ofSize(new Vec3(xPos, yPos, zPos), 0.2, 0.2, 0.2), e -> true).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
													}
												}.compareDistOf(xPos, yPos, zPos)).findFirst().orElse(null)).getPersistentData().putDouble("MMminingProgress",
														(16 + world.getBlockState(new BlockPos(xPos, yPos, zPos)).getDestroySpeed(world, new BlockPos(xPos, yPos, zPos)) / 5));
											}
										} else {
											((Entity) world.getEntitiesOfClass(BlockIndicatorEntity1Entity.class, AABB.ofSize(new Vec3(xPos, yPos, zPos), 0.2, 0.2, 0.2), e -> true).stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
												}
											}.compareDistOf(xPos, yPos, zPos)).findFirst().orElse(null)).getPersistentData().putDouble("MMminingProgress",
													(((Entity) world.getEntitiesOfClass(BlockIndicatorEntity1Entity.class, AABB.ofSize(new Vec3(xPos, yPos, zPos), 0.2, 0.2, 0.2), e -> true).stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
														}
													}.compareDistOf(xPos, yPos, zPos)).findFirst().orElse(null)).getPersistentData().getDouble("MMminingProgress") - (itemstack.getOrCreateTag().getDouble("MMpowerLevel") + 1) * powerMultiplier));
											if (((Entity) world.getEntitiesOfClass(BlockIndicatorEntity1Entity.class, AABB.ofSize(new Vec3(xPos, yPos, zPos), 0.2, 0.2, 0.2), e -> true).stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
												}
											}.compareDistOf(xPos, yPos, zPos)).findFirst().orElse(null)).getPersistentData().getDouble("MMminingProgress") > 0) {
												if (world instanceof Level _level) {
													if (!_level.isClientSide()) {
														_level.playSound(null, new BlockPos(xPos, yPos, zPos), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.step")), SoundSource.BLOCKS, 1, 1);
													} else {
														_level.playLocalSound(xPos, yPos, zPos, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.stone.step")), SoundSource.BLOCKS, 1, 1, false);
													}
												}
												world.levelEvent(2001, new BlockPos(xPos, yPos, zPos), Block.getId((world.getFluidState(new BlockPos(xPos, yPos, zPos)).createLegacyBlock())));
											} else {
												if (world instanceof Level _level && !_level.isClientSide()) {
													ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack((world.getBlockState(new BlockPos(xPos, yPos, zPos))).getBlock())));
													entityToSpawn.setPickUpDelay(0);
													_level.addFreshEntity(entityToSpawn);
												}
												world.destroyBlock(new BlockPos(xPos, yPos, zPos), false);
											}
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
