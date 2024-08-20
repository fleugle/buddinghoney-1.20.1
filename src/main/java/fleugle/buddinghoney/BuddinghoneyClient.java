package fleugle.buddinghoney;

import fleugle.buddinghoney.entities.ModEntityTypes;
import fleugle.buddinghoney.entities.client.*;
import fleugle.buddinghoney.particles.ModParticleTypes;
import fleugle.buddinghoney.particles.custom.AmethystBoomParticle;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class BuddinghoneyClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {


        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.BEESTANITE_BULLET_LAYER, BeestaniteBulletModel::getTexturedModelData);


        EntityRendererRegistry.register(ModEntityTypes.BEESTANITE_BULLET, BeestaniteBulletRenderer::new);

        ParticleFactoryRegistry.getInstance().register(ModParticleTypes.AMETHYST_BOOM, AmethystBoomParticle.Factory ::new);




        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.AMETHYST_BULLET_LAYER, AmethystBulletModel::getTexturedModelData);


        EntityRendererRegistry.register(ModEntityTypes.AMETHYST_BULLET, AmethystBulletRenderer::new);

    }
}
