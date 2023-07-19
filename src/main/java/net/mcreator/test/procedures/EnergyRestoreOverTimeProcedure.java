package net.mcreator.test.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.test.network.TestModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EnergyRestoreOverTimeProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(TestModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TestModVariables.PlayerVariables())).PLAYER_CURRENT_ENERGY < (entity.getCapability(TestModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TestModVariables.PlayerVariables())).PLAYER_MAX_ENERGY) {
			{
				double _setval = (entity.getCapability(TestModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TestModVariables.PlayerVariables())).PLAYER_CURRENT_ENERGY + 0.5;
				entity.getCapability(TestModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PLAYER_CURRENT_ENERGY = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((entity.getCapability(TestModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TestModVariables.PlayerVariables())).PLAYER_CURRENT_ENERGY > (entity.getCapability(TestModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TestModVariables.PlayerVariables())).PLAYER_MAX_ENERGY) {
				{
					double _setval = (entity.getCapability(TestModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TestModVariables.PlayerVariables())).PLAYER_MAX_ENERGY;
					entity.getCapability(TestModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PLAYER_CURRENT_ENERGY = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
