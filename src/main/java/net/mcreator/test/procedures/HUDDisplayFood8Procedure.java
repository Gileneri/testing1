package net.mcreator.test.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class HUDDisplayFood8Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		boolean shouldDisplay = false;
		shouldDisplay = false;
		if ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) >= 13) {
			shouldDisplay = true;
		}
		return shouldDisplay;
	}
}
