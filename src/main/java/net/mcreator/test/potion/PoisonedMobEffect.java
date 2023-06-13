
package net.mcreator.test.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class PoisonedMobEffect extends MobEffect {
	public PoisonedMobEffect() {
		super(MobEffectCategory.HARMFUL, -3022496);
	}

	@Override
	public String getDescriptionId() {
		return "effect.test.poisoned";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
