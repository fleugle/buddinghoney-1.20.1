package fleugle.buddinghoney.status_effects.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

import java.util.UUID;

public class RustingStatusEffect extends StatusEffect {

    public RustingStatusEffect() {
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



        }
    }



    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {



        super.onApplied(entity, attributes, amplifier);

        EntityAttributeInstance movementSpeedAttribute = entity.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);

        if (movementSpeedAttribute != null){
            EntityAttributeModifier rustingModifier = movementSpeedAttribute.getModifier(UUID.fromString("6E5BD009-3D93-4DED-AA6B-0F89003526B7"));

            if (rustingModifier != null){
                movementSpeedAttribute.removeModifier(rustingModifier);
            }

        }

        if (movementSpeedAttribute != null ){

            movementSpeedAttribute.addTemporaryModifier( new EntityAttributeModifier(
                    UUID.fromString("6E5BD009-3D93-4DED-AA6B-0F89003526B7"),
                    "rustingSpeedModifier",
                    (-0.15 * (amplifier + 1)),
                    EntityAttributeModifier.Operation.MULTIPLY_TOTAL
            ));
        }




    }



    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onRemoved(entity, attributes, amplifier);

        EntityAttributeInstance movementSpeedAttribute = entity.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED);

        if (movementSpeedAttribute != null){
            EntityAttributeModifier rustingModifier = movementSpeedAttribute.getModifier(UUID.fromString("6E5BD009-3D93-4DED-AA6B-0F89003526B7"));

            if (rustingModifier != null){
                movementSpeedAttribute.removeModifier(rustingModifier);
            }

        }




    }
}
