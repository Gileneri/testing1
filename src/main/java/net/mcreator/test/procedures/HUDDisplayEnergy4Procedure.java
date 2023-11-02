package net.mcreator.test.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.test.network.TestModVariables;

public class HUDDisplayEnergy4Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		boolean shouldDisplay = false;
		shouldDisplay = false;
		if (Math.round((entity.getCapability(TestModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TestModVariables.PlayerVariables())).PLAYER_CURRENT_ENERGY)
				/ (entity.getCapability(TestModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TestModVariables.PlayerVariables())).PLAYER_MAX_ENERGY >= 0.86667) {
			shouldDisplay = true;
		}
		return shouldDisplay;
	}
}
