package net.mcreator.test.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class MMPaintingProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean isBlockDyeable = false;
		double dyeColor = 0;
		double blockColor = 0;
		double typeOfBlock = 0;
		String colorName = "";
		String blockTypeName = "";
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("test:vanilla_dye_item_tag")))) {
			if ((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()).toString()).contains("pink")) {
				dyeColor = 16;
				colorName = "pink";
			} else if ((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()).toString()).contains("magenta")) {
				dyeColor = 15;
				colorName = "magenta";
			} else if ((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()).toString()).contains("purple")) {
				dyeColor = 14;
				colorName = "purple";
			} else if ((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()).toString()).contains("light_blue")) {
				dyeColor = 12;
				colorName = "light_blue";
			} else if ((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()).toString()).contains("blue")) {
				dyeColor = 13;
				colorName = "blue";
			} else if ((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()).toString()).contains("cyan")) {
				dyeColor = 11;
				colorName = "cyan";
			} else if ((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()).toString()).contains("lime_green")) {
				dyeColor = 9;
				colorName = "lime_green";
			} else if ((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()).toString()).contains("green")) {
				dyeColor = 10;
				colorName = "green";
			} else if ((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()).toString()).contains("yellow")) {
				dyeColor = 8;
				colorName = "yellow";
			} else if ((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()).toString()).contains("orange")) {
				dyeColor = 7;
				colorName = "orange";
			} else if ((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()).toString()).contains("red")) {
				dyeColor = 6;
				colorName = "red";
			} else if ((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()).toString()).contains("brown")) {
				dyeColor = 5;
				colorName = "brown";
			} else if ((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()).toString()).contains("black")) {
				dyeColor = 4;
				colorName = "black";
			} else if ((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()).toString()).contains("light_gray")) {
				dyeColor = 2;
				colorName = "light_gray";
			} else if ((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()).toString()).contains("gray")) {
				dyeColor = 3;
				colorName = "gray";
			} else if ((ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()).toString()).contains("white")) {
				dyeColor = 1;
				colorName = "white";
			}
			if ((world.getBlockState(new BlockPos(x, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:wool")))) {
				isBlockDyeable = isBlockDyeable;
				blockTypeName = "_wool";
			} else if ((world.getBlockState(new BlockPos(x, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:wool_carpets")))) {
				isBlockDyeable = isBlockDyeable;
				blockTypeName = "_carpet";
			} else if ((world.getBlockState(new BlockPos(x, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:impermeable")))) {
				isBlockDyeable = isBlockDyeable;
				blockTypeName = "_stained_glass";
			} else if ((world.getBlockState(new BlockPos(x, y, z))).is(BlockTags.create(new ResourceLocation("test:vanilla_stained_glass_pane_block_tag")))) {
				isBlockDyeable = isBlockDyeable;
				blockTypeName = "_stained_glass_pane";
			} else if ((world.getBlockState(new BlockPos(x, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:terracotta")))) {
				isBlockDyeable = isBlockDyeable;
				blockTypeName = "_terracotta";
			} else if ((world.getBlockState(new BlockPos(x, y, z))).is(BlockTags.create(new ResourceLocation("test:vanilla_glazed_terracotta_block_tag")))) {
				isBlockDyeable = isBlockDyeable;
				blockTypeName = "_glazed_terracotta";
			} else if ((world.getBlockState(new BlockPos(x, y, z))).is(BlockTags.create(new ResourceLocation("test:vanilla_concrete_block_tag")))) {
				isBlockDyeable = isBlockDyeable;
				if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(new BlockPos(x, y, z))).getBlock()).toString()).contains("powder")) {
					blockTypeName = "_concrete_powder";
				} else {
					blockTypeName = "_powder";
				}
			} else if ((world.getBlockState(new BlockPos(x, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:shulker_boxes")))) {
				isBlockDyeable = isBlockDyeable;
				blockTypeName = "_shulker_box";
			}
			if (isBlockDyeable == true) {
				if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(new BlockPos(x, y, z))).getBlock()).toString()).contains("pink")) {
					blockColor = 16;
				} else if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(new BlockPos(x, y, z))).getBlock()).toString()).contains("magenta")) {
					blockColor = 15;
				} else if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(new BlockPos(x, y, z))).getBlock()).toString()).contains("purple")) {
					blockColor = 14;
				} else if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(new BlockPos(x, y, z))).getBlock()).toString()).contains("light_blue")) {
					blockColor = 12;
				} else if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(new BlockPos(x, y, z))).getBlock()).toString()).contains("blue")) {
					blockColor = 13;
				} else if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(new BlockPos(x, y, z))).getBlock()).toString()).contains("cyan")) {
					blockColor = 11;
				} else if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(new BlockPos(x, y, z))).getBlock()).toString()).contains("lime_green")) {
					blockColor = 9;
				} else if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(new BlockPos(x, y, z))).getBlock()).toString()).contains("green")) {
					blockColor = 10;
				} else if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(new BlockPos(x, y, z))).getBlock()).toString()).contains("yellow")) {
					blockColor = 8;
				} else if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(new BlockPos(x, y, z))).getBlock()).toString()).contains("orange")) {
					blockColor = 7;
				} else if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(new BlockPos(x, y, z))).getBlock()).toString()).contains("red")) {
					blockColor = 6;
				} else if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(new BlockPos(x, y, z))).getBlock()).toString()).contains("brown")) {
					blockColor = 5;
				} else if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(new BlockPos(x, y, z))).getBlock()).toString()).contains("black")) {
					blockColor = 4;
				} else if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(new BlockPos(x, y, z))).getBlock()).toString()).contains("light_gray")) {
					blockColor = 2;
				} else if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(new BlockPos(x, y, z))).getBlock()).toString()).contains("gray")) {
					blockColor = 3;
				} else if ((ForgeRegistries.BLOCKS.getKey((world.getBlockState(new BlockPos(x, y, z))).getBlock()).toString()).contains("white")) {
					blockColor = 1;
				}
				if (dyeColor != blockColor) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("setblock ~ ~ ~ minecraft:" + colorName + blockTypeName));
				}
			}
		}
	}
}
