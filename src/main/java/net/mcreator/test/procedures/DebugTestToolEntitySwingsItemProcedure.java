package net.mcreator.test.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.test.TestMod;

public class DebugTestToolEntitySwingsItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		TestMod.LOGGER.info(ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()).toString());
	}
}
