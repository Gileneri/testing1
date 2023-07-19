
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.test.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.test.block.TextureBlock;
import net.mcreator.test.block.TestnoisePortalBlock;
import net.mcreator.test.block.TestRedstoneOnBlock;
import net.mcreator.test.block.TestRedstoneOffBlock;
import net.mcreator.test.block.TestPressurePlateBlock;
import net.mcreator.test.block.TestLightOnBlock;
import net.mcreator.test.block.TestLightOffBlock;
import net.mcreator.test.block.TestLightBlockBlock;
import net.mcreator.test.block.TestDoorBlock;
import net.mcreator.test.block.TestButtonBlock;
import net.mcreator.test.block.PoisonBlock;
import net.mcreator.test.block.HigherPortalBlock;
import net.mcreator.test.block.CoreLavaBlock;
import net.mcreator.test.block.Biomes4PortalBlock;
import net.mcreator.test.TestMod;

public class TestModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, TestMod.MODID);
	public static final RegistryObject<Block> HIGHER_PORTAL = REGISTRY.register("higher_portal", () -> new HigherPortalBlock());
	public static final RegistryObject<Block> POISON = REGISTRY.register("poison", () -> new PoisonBlock());
	public static final RegistryObject<Block> TESTNOISE_PORTAL = REGISTRY.register("testnoise_portal", () -> new TestnoisePortalBlock());
	public static final RegistryObject<Block> BIOMES_4_PORTAL = REGISTRY.register("biomes_4_portal", () -> new Biomes4PortalBlock());
	public static final RegistryObject<Block> TEXTURE = REGISTRY.register("texture", () -> new TextureBlock());
	public static final RegistryObject<Block> TEST_LIGHT_BLOCK = REGISTRY.register("test_light_block", () -> new TestLightBlockBlock());
	public static final RegistryObject<Block> TEST_BUTTON = REGISTRY.register("test_button", () -> new TestButtonBlock());
	public static final RegistryObject<Block> TEST_DOOR = REGISTRY.register("test_door", () -> new TestDoorBlock());
	public static final RegistryObject<Block> TEST_PRESSURE_PLATE = REGISTRY.register("test_pressure_plate", () -> new TestPressurePlateBlock());
	public static final RegistryObject<Block> TEST_LIGHT_OFF = REGISTRY.register("test_light_off", () -> new TestLightOffBlock());
	public static final RegistryObject<Block> TEST_LIGHT_ON = REGISTRY.register("test_light_on", () -> new TestLightOnBlock());
	public static final RegistryObject<Block> TEST_REDSTONE_OFF = REGISTRY.register("test_redstone_off", () -> new TestRedstoneOffBlock());
	public static final RegistryObject<Block> TEST_REDSTONE_ON = REGISTRY.register("test_redstone_on", () -> new TestRedstoneOnBlock());
	public static final RegistryObject<Block> CORE_LAVA = REGISTRY.register("core_lava", () -> new CoreLavaBlock());
}
