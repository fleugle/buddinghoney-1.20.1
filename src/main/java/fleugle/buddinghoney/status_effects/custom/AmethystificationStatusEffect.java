package fleugle.buddinghoney.status_effects.custom;

import fleugle.buddinghoney.enchantments.ModEnchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

import java.util.UUID;

public class AmethystificationStatusEffect extends StatusEffect {

    public AmethystificationStatusEffect() {
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

        EntityAttributeInstance attackSpeed = entity.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_SPEED);

        if (attackSpeed != null){
            EntityAttributeModifier amethystificationModifier = attackSpeed.getModifier(UUID.fromString("468235C6-A817-4ACD-8168-9A4A73029299"));

            if (amethystificationModifier != null){
                attackSpeed.removeModifier(amethystificationModifier);
            }

        }

        if (attackSpeed != null ){

            attackSpeed.addTemporaryModifier( new EntityAttributeModifier(
                    UUID.fromString("468235C6-A817-4ACD-8168-9A4A73029299"),
                    "amethystificationAttackSpeedModifier",
                    (-0.15 * amplifier),
                    EntityAttributeModifier.Operation.MULTIPLY_TOTAL
            ));
        }




    }



    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onRemoved(entity, attributes, amplifier);

        EntityAttributeInstance attackSpeed = entity.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_SPEED);

        if (attackSpeed != null){
            EntityAttributeModifier amethystificationModifier = attackSpeed.getModifier(UUID.fromString("468235C6-A817-4ACD-8168-9A4A73029299"));

            if (amethystificationModifier != null){
                attackSpeed.removeModifier(amethystificationModifier);
            }

        }




    }
}
