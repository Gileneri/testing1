package net.mcreator.test.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.test.network.TestModVariables;

public class DebugTestToolEntitySwingsItemProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		boolean shouldDisplay = false;
		double testNum = 0;
		if (entity.getPersistentData().getDouble("energyStatus") != 2) {
			{
				double _setval = (entity.getCapability(TestModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TestModVariables.PlayerVariables())).PLAYER_CURRENT_ENERGY - 20;
				entity.getCapability(TestModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PLAYER_CURRENT_ENERGY = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity.getPersistentData().getDouble("energyCooldown") < 34) {
				entity.getPersistentData().putDouble("energyCooldown", 34);
			}
		}
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 60, (int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)).getCount() * (-2)), (false), (true)));
	}
}
