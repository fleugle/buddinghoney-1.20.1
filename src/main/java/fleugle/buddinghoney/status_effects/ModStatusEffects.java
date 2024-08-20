package fleugle.buddinghoney.status_effects;

import fleugle.buddinghoney.Buddinghoney;
import fleugle.buddinghoney.status_effects.custom.BuddingStatusEffect;
import fleugle.buddinghoney.status_effects.custom.AmethystificationStatusEffect;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;



public class ModStatusEffects {

	public static final StatusEffect BUDDING = new BuddingStatusEffect();

	public static final StatusEffect AMETHYSTIFICATION = new AmethystificationStatusEffect()
			.addAttributeModifier(
			EntityAttributes.GENERIC_ATTACK_SPEED,
			"F0E1D2C3-B4A5-6789-0123-456789ABCDEF",
			-0.15F * AmethystificationStatusEffect.amplifier, EntityAttributeModifier.Operation.MULTIPLY_TOTAL
	);



	private static StatusEffect registerStatusEffect(String name, StatusEffect statusEffect){
		return Registry.register(Registries.STATUS_EFFECT, new Identifier(Buddinghoney.MOD_ID, name), statusEffect);
	}

	public static void initialiseStatusEffects(){
		registerStatusEffect("budding", BUDDING);

		registerStatusEffect("amethystification", AMETHYSTIFICATION);

	}
}
