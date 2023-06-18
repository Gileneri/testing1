
package net.mcreator.test.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.test.procedures.ShieldGeneratorEffectOnEffectActiveTickProcedure;
import net.mcreator.test.procedures.ShieldGeneratorEffectEffectExpiresProcedure;

public class ShieldGeneratorEffectMobEffect extends MobEffect {
	public ShieldGeneratorEffectMobEffect() {
		super(MobEffectCategory.HARMFUL, -13382401);
	}

	@Override
	public String getDescriptionId() {
		return "effect.test.shield_generator_effect";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		ShieldGeneratorEffectOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		ShieldGeneratorEffectEffectExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
