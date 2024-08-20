package fleugle.buddinghoney.particles;

import fleugle.buddinghoney.Buddinghoney;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModParticleTypes {


	public static final DefaultParticleType AMETHYST_BOOM = FabricParticleTypes.simple();
	//public static final DefaultParticleType JUSTICE_HIT = FabricParticleTypes.simple();

	static DefaultParticleType modParticleTypesRegistry(String name, DefaultParticleType particleType){
		return Registry.register(Registries.PARTICLE_TYPE, new Identifier(Buddinghoney.MOD_ID, name), particleType);
	}



	public static void initialiseModParticleTypes(){

		Buddinghoney.LOGGER.info("Registering " + Buddinghoney.MOD_ID + " Particle Types for LOOOOTS of FUNN (like yk, those 'whuhuhu' float variables with a value 1.0f)");

		//modParticleTypesRegistry("name", FabricParticleTypes.simple()); -> for simple particles
		modParticleTypesRegistry("amethyst_boom", AMETHYST_BOOM);
		//modParticleTypesRegistry("justice_hit", JUSTICE_HIT);

	}
}
