package fleugle.buddinghoney.particles.custom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.ExplosionLargeParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleFactory;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;

@Environment(EnvType.CLIENT)
public class BeestaniteBoomParticle extends ExplosionLargeParticle {
	protected BeestaniteBoomParticle(ClientWorld clientWorld, double d, double e, double f, double g, SpriteProvider spriteProvider) {
		super(clientWorld, d, e, f, g, spriteProvider);
		this.maxAge = 9;
		this.scale = 2F;
		this.setSpriteForAge(spriteProvider);
	}

	@Environment(EnvType.CLIENT)
	public static class Factory implements ParticleFactory<DefaultParticleType> {
		private final SpriteProvider spriteProvider;

		public Factory(SpriteProvider spriteProvider) {
			this.spriteProvider = spriteProvider;
		}

		public Particle createParticle(DefaultParticleType defaultParticleType, ClientWorld clientWorld, double d, double e, double f, double g, double h, double i) {
			return new BeestaniteBoomParticle(clientWorld, d, e, f, g, this.spriteProvider);
		}
	}
}
