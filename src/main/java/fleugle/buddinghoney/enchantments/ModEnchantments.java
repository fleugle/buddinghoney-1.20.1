package fleugle.buddinghoney.enchantments;

import fleugle.buddinghoney.Buddinghoney;
import fleugle.buddinghoney.enchantments.custom.AmethystificationEnchantment;
import fleugle.buddinghoney.enchantments.custom.AspirationEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantments {



	public static final Enchantment ASPIRATION = new AspirationEnchantment();

	public static final Enchantment AMETHYSTIFICATION = new AmethystificationEnchantment();


	static Enchantment registerEnchantment(String name, Enchantment enchantment){
		return Registry.register(Registries.ENCHANTMENT, new Identifier(Buddinghoney.MOD_ID, name), enchantment);
	}

	public static void initialiseModEnchantments(){
		Buddinghoney.LOGGER.warn("Registering " + Buddinghoney.MOD_ID + " some ILLEGAL and definitely AGE RESTRICTED enchanments. (remember, goodby highschool hello drugdealing and SEXXX)");


		registerEnchantment("aspiration", ASPIRATION);
		registerEnchantment("amethystification", AMETHYSTIFICATION);
	}
}
