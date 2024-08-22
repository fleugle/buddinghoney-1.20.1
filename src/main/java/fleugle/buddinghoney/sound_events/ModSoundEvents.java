package fleugle.buddinghoney.sound_events;

import fleugle.buddinghoney.Buddinghoney;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;



public class ModSoundEvents {

	public static SoundEvent DEFAULT_SHOTGUN_SHOOT = registerSound("d_shotgun_sh");
	public static SoundEvent AMETHYST_SHOTGUN_SHOOT = registerSound("a_shotgun_sh");

	public static SoundEvent DEFAULT_SHOTGUN_RELOAD = registerSound("d_shotgun_r");
	public static SoundEvent AMETHYST_SHOTGUN_RELOAD = registerSound("a_shotgun_r");

	public static SoundEvent EMPTY_GUN_SHOT = registerSound("empty_gun_shot");

    public static SoundEvent EMPTY_SHOTGUN_SHOT = registerSound("empty_shotgun_shot");




	// actual registration of all the custom SoundEvents
    public static SoundEvent registerSound(String id) {
        SoundEvent sound = SoundEvent.of(new Identifier(Buddinghoney.MOD_ID, id));
        return Registry.register(Registries.SOUND_EVENT, new Identifier(Buddinghoney.MOD_ID, id), sound);
    }

    // called in the ModInitializer implementing class
    // to initialize the ModSoundEvents class
    public static void initializeSounds() {
		Buddinghoney.LOGGER.info("Registering " + Buddinghoney.MOD_ID + " Sounds");
    }
}
