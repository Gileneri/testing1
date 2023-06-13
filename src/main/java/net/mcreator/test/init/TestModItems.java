
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.test.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.test.item.TestnoiseItem;
import net.mcreator.test.item.PoisonItem;
import net.mcreator.test.item.MattermanipulatorbetaItem;
import net.mcreator.test.item.HigherItem;
import net.mcreator.test.item.DebugTestToolItem;
import net.mcreator.test.item.Biomes4Item;
import net.mcreator.test.TestMod;

public class TestModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MODID);
	public static final RegistryObject<Item> HIGHER = REGISTRY.register("higher", () -> new HigherItem());
	public static final RegistryObject<Item> POISON_BUCKET = REGISTRY.register("poison_bucket", () -> new PoisonItem());
	public static final RegistryObject<Item> MATTERMANIPULATORBETA = REGISTRY.register("mattermanipulatorbeta", () -> new MattermanipulatorbetaItem());
	public static final RegistryObject<Item> TESTNOISE = REGISTRY.register("testnoise", () -> new TestnoiseItem());
	public static final RegistryObject<Item> BIOMES_4 = REGISTRY.register("biomes_4", () -> new Biomes4Item());
	public static final RegistryObject<Item> TEXTURE = block(TestModBlocks.TEXTURE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final RegistryObject<Item> DEBUG_TEST_TOOL = REGISTRY.register("debug_test_tool", () -> new DebugTestToolItem());
	public static final RegistryObject<Item> TEST_LIGHT_BLOCK = block(TestModBlocks.TEST_LIGHT_BLOCK, null);
	public static final RegistryObject<Item> MECH_TEST_BODY_SPAWN_EGG = REGISTRY.register("mech_test_body_spawn_egg", () -> new ForgeSpawnEggItem(TestModEntities.MECH_TEST_BODY, -1, -1, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
