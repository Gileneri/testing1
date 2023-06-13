package net.mcreator.test.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class MMUpgradeGUIButtonWhenClicked11Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double upgradeCost = 0;
		upgradeCost = 12;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TestModItems.MATTERMANIPULATORBETA.get()
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("MMrangeLevel") == 1) {
			if (MMUpgradeGUIButtonsCheckPlayerForCurrencyProcedure.execute(world, entity) >= upgradeCost) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(Blocks.SUNFLOWER);
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) upgradeCost, _player.inventoryMenu.getCraftSlots());
				}
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("MMrangeLevel", 2);
			}
		}
	}
}
