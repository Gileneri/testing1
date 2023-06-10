
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
import net.mcreator.test.block.PoisonBlock;
import net.mcreator.test.block.HigherPortalBlock;
import net.mcreator.test.block.Biomes4PortalBlock;
import net.mcreator.test.TestMod;

public class TestModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, TestMod.MODID);
	public static final RegistryObject<Block> HIGHER_PORTAL = REGISTRY.register("higher_portal", () -> new HigherPortalBlock());
	public static final RegistryObject<Block> POISON = REGISTRY.register("poison", () -> new PoisonBlock());
	public static final RegistryObject<Block> TESTNOISE_PORTAL = REGISTRY.register("testnoise_portal", () -> new TestnoisePortalBlock());
	public static final RegistryObject<Block> BIOMES_4_PORTAL = REGISTRY.register("biomes_4_portal", () -> new Biomes4PortalBlock());
	public static final RegistryObject<Block> TEXTURE = REGISTRY.register("texture", () -> new TextureBlock());
}
