
package net.mcreator.test.entity;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.material.Material;
import net.minecraft.nbt.Tag;
import net.minecraft.sounds.SoundEvent;

import javax.annotation.Nullable;

public class MechTestArmLeftEntity extends PathfinderMob {

	public MechTestArmLeftEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(TestModEntities.MECH_TEST_ARM_LEFT.get(), world);
	}

	public MechTestArmLeftEntity(EntityType<MechTestArmLeftEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(true);

		setPersistenceRequired();

	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
	}

	@Override
	public void baseTick() {
		super.baseTick();
		MechTestPartsOnEntityTickUpdateProcedure.execute(this.level, this.getX(), this.getY(), this.getZ(), this);
	}

	@Override
	public boolean isPushable() {
		return false;
	}

	@Override
	protected void doPush(Entity entityIn) {
	}

	@Override
	protected void pushEntities() {
	}

	public static void init() {

	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0);
		builder = builder.add(Attributes.MAX_HEALTH, 10);
		builder = builder.add(Attributes.ARMOR, 12);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 0);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);

		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 1);

		return builder;
	}

}
