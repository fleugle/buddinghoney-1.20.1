package fleugle.buddinghoney.status_effects;

import fleugle.buddinghoney.Buddinghoney;
import fleugle.buddinghoney.status_effects.custom.BuddingStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;



public class ModStatusEffects {

	public static final StatusEffect BUDDING = new BuddingStatusEffect();



	private static StatusEffect registerStatusEffect(String name, StatusEffect statusEffect){
		return Registry.register(Registries.STATUS_EFFECT, new Identifier(Buddinghoney.MOD_ID, name), statusEffect);
	}

	public static void initialiseStatusEffects(){
		registerStatusEffect("budding", BUDDING);

	}
}
