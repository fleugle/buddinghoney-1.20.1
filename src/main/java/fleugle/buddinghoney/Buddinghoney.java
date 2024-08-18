package fleugle.buddinghoney;

import fleugle.buddinghoney.items.ModItems;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Buddinghoney implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "uniquescythe";//mod id for further usage
	public static final String GAME_ID = "minecraft";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}

	@Override
	public void onInitialize() {

		ModItems.registerModItems();

		LOGGER.info("People say honey is for loosers in pvp? HAHAHAHA, it's not the purpose! Honey mixed with amethyst is a drug! So the reason is drug dealing, yoo hoo!");

	}
}