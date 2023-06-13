package net.mcreator.test.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class FlashlightTestProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double raytraceDistance = 0;
		double xPos = 0;
		double yPos = 0;
		double zPos = 0;
		double counter = 0;
		if (!world.isClientSide()) {
			raytraceDistance = 5;
			xPos = entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.SOURCE_ONLY, entity)).getBlockPos().getX();
			yPos = entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.SOURCE_ONLY, entity)).getBlockPos().getY();
			zPos = entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.SOURCE_ONLY, entity)).getBlockPos().getZ();
			if ((world.isEmptyBlock(new BlockPos(xPos, yPos, zPos)) || (world.getBlockState(new BlockPos(xPos, yPos, zPos))).getBlock() instanceof LiquidBlock) && world.getMaxLocalRawBrightness(new BlockPos(xPos, yPos, zPos)) < 14) {
				if ((world.getFluidState(new BlockPos(xPos, yPos, zPos)).createLegacyBlock()).getBlock() == Blocks.WATER) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(xPos, yPos, zPos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"setblock ~ ~ ~ test:test_light_block[waterlogged=true]");
				} else {
					world.setBlock(new BlockPos(xPos, yPos, zPos), TestModBlocks.TEST_LIGHT_BLOCK.get().defaultBlockState(), 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = new BlockPos(xPos, yPos, zPos);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("flashlightCounter", 0);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			} else if ((world.getBlockState(new BlockPos(xPos, yPos, zPos))).getBlock() == TestModBlocks.TEST_LIGHT_BLOCK.get()) {
				if (!world.isClientSide()) {
					BlockPos _bp = new BlockPos(xPos, yPos, zPos);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putDouble("flashlightCounter", 0);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			} else {
				counter = Math.ceil(raytraceDistance / 2);
				for (int index0 = 0; index0 < (int) (counter); index0++) {
					raytraceDistance = raytraceDistance - 2;
					if (raytraceDistance <= 0) {
						raytraceDistance = 0.00001;
					}
					xPos = entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.SOURCE_ONLY, entity)).getBlockPos()
							.getX();
					yPos = entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.SOURCE_ONLY, entity)).getBlockPos()
							.getY();
					zPos = entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(raytraceDistance)), ClipContext.Block.OUTLINE, ClipContext.Fluid.SOURCE_ONLY, entity)).getBlockPos()
							.getZ();
					if ((world.isEmptyBlock(new BlockPos(xPos, yPos, zPos)) || (world.getBlockState(new BlockPos(xPos, yPos, zPos))).getBlock() instanceof LiquidBlock) && world.getMaxLocalRawBrightness(new BlockPos(xPos, yPos, zPos)) < 14) {
						if ((world.getFluidState(new BlockPos(xPos, yPos, zPos)).createLegacyBlock()).getBlock() == Blocks.WATER) {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(
										new CommandSourceStack(CommandSource.NULL, new Vec3(xPos, yPos, zPos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"setblock ~ ~ ~ test:test_light_block[waterlogged=true]");
						} else {
							world.setBlock(new BlockPos(xPos, yPos, zPos), TestModBlocks.TEST_LIGHT_BLOCK.get().defaultBlockState(), 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = new BlockPos(xPos, yPos, zPos);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("flashlightCounter", 0);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					} else if ((world.getBlockState(new BlockPos(xPos, yPos, zPos))).getBlock() == TestModBlocks.TEST_LIGHT_BLOCK.get()) {
						if (!world.isClientSide()) {
							BlockPos _bp = new BlockPos(xPos, yPos, zPos);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("flashlightCounter", 0);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
				}
			}
		}
	}
}
