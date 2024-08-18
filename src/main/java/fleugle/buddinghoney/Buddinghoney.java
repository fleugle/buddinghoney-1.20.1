package fleugle.buddinghoney;

import fleugle.buddinghoney.items.ModItems;
import fleugle.buddinghoney.sound_events.ModSoundEvents;
import fleugle.buddinghoney.status_effects.ModStatusEffects;
import fleugle.buddinghoney.utility.AttackEventHandler;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Buddinghoney implements ModInitializer {

	public static final String MOD_ID = "buddinghoney";//mod id for further usage
	public static final String GAME_ID = "minecraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		//items
		ModItems.registerModItems();

		//status effects
		ModStatusEffects.initialiseStatusEffects();

		//calling for sound registry method in mod sounds
		ModSoundEvents.initializeSounds();


		AttackEventHandler.register();


		LOGGER.info("People say honey is for loosers in pvp? HAHAHAHA, it's not the purpose! Honey mixed with amethyst is a drug! So the reason is drug dealing, yippee! (Goodbye high-school hello drug dealing!)");

	}
}