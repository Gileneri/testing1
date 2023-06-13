package net.mcreator.test.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class MechJumpOnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.isPassenger()) {
			if ((entity.getVehicle()) instanceof MechTestBodyEntity) {
				if ((entity.getVehicle()).isOnGround()) {
					(entity.getVehicle()).setDeltaMovement(new Vec3(((entity.getVehicle()).getDeltaMovement().x()), 0.8, ((entity.getVehicle()).getDeltaMovement().z())));
				} else if ((entity.getVehicle()).isInWater()) {
					(entity.getVehicle()).setDeltaMovement(new Vec3(((entity.getVehicle()).getDeltaMovement().x()), 0.2, ((entity.getVehicle()).getDeltaMovement().z())));
				}
			}
		}
	}
}
