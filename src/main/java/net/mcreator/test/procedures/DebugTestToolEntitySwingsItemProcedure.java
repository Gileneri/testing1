package net.mcreator.test.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.test.network.TestModVariables;
import net.mcreator.test.TestMod;

public class DebugTestToolEntitySwingsItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(TestModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TestModVariables.PlayerVariables())).PLAYER_CURRENT_ENERGY - 20;
			entity.getCapability(TestModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PLAYER_CURRENT_ENERGY = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((entity.getCapability(TestModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TestModVariables.PlayerVariables())).PLAYER_CURRENT_ENERGY < 0) {
			{
				double _setval = 0;
				entity.getCapability(TestModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PLAYER_CURRENT_ENERGY = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		TestMod.LOGGER.info(entity.getYRot());
	}
}
