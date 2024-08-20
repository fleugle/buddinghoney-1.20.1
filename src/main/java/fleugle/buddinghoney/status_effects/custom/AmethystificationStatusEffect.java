package fleugle.buddinghoney.status_effects.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class AmethystificationStatusEffect extends StatusEffect {

    public AmethystificationStatusEffect() {
        super(
                StatusEffectCategory.HARMFUL,
                0x490441
        );

    }

    public static int amplifier = 0;


    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // In our case, we just make it return true so that it applies the status effect every tick.
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.getWorld().isClient){



        }
    }



    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {

        super.onApplied(entity, attributes, amplifier);


        this.amplifier = amplifier;


    }



    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onRemoved(entity, attributes, amplifier);


    }
}
