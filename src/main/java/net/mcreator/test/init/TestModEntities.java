
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.test.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.test.entity.BlockIndicatorEntity1Entity;
import net.mcreator.test.TestMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TestModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TestMod.MODID);
	public static final RegistryObject<EntityType<BlockIndicatorEntity1Entity>> BLOCK_INDICATOR_ENTITY_1 = register("block_indicator_entity_1", EntityType.Builder.<BlockIndicatorEntity1Entity>of(BlockIndicatorEntity1Entity::new, MobCategory.MISC)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BlockIndicatorEntity1Entity::new).fireImmune().sized(1.01f, 1.01f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			BlockIndicatorEntity1Entity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(BLOCK_INDICATOR_ENTITY_1.get(), BlockIndicatorEntity1Entity.createAttributes().build());
	}
}
