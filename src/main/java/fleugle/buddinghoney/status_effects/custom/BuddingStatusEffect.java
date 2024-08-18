package fleugle.buddinghoney.status_effects.custom;

import fleugle.buddinghoney.damage_types.ModDamageTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.RegistryKeys;

public class BuddingStatusEffect extends StatusEffect {

    int tick = 0;

    int maxTick = 10;


    public BuddingStatusEffect() {
        super(
                StatusEffectCategory.HARMFUL,
                0x490441
        );
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // In our case, we just make it return true so that it applies the status effect every tick.
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.getWorld().isClient){

            doBuddingTick(entity, amplifier);

        }
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onApplied(entity, attributes, amplifier);

        tick = 0;

    }



    public void doBuddingTick(LivingEntity entity, int amplifier){


        if (tick < maxTick) {

            tick++;
        }
        else {

            tick = 0;

            DamageSource source = new DamageSource(
                    entity.getWorld().getRegistryManager()
                            .get(RegistryKeys.DAMAGE_TYPE)
                            .entryOf(ModDamageTypes.BUDDING_ALIVE)
            );
            entity.damage(source, 0.5f * (1 + amplifier));
        }


    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onRemoved(entity, attributes, amplifier);

        tick = 0;

    }
}
