package net.mcreator.test.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class DebugTestToolEntitySwingsItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		TestMod.LOGGER.info(ForgeRegistries.ITEMS.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem()).toString());
	}
}
