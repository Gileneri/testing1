package net.mcreator.test.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.ServerChatEvent;

import net.minecraft.world.entity.Entity;

import net.mcreator.test.network.TestModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AddScoreProcedure {
	@SubscribeEvent
	public static void onChat(ServerChatEvent.Submitted event) {
		execute(event, event.getPlayer());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(TestModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TestModVariables.PlayerVariables())).PLAYER_PIXEL_CURRENCY + 1;
			entity.getCapability(TestModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PLAYER_PIXEL_CURRENCY = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
