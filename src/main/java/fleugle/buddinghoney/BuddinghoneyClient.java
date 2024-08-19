package fleugle.buddinghoney;

import fleugle.buddinghoney.entities.ModEntityTypes;
import fleugle.buddinghoney.entities.client.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class BuddinghoneyClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {


        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.BEESTANITE_BULLET_LAYER, BeestaniteBulletModel::getTexturedModelData);


        EntityRendererRegistry.register(ModEntityTypes.BEESTANITE_BULLET, BeestaniteBulletRenderer::new);




        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.AMETHYST_BULLET_LAYER, AmethystBulletModel::getTexturedModelData);


        EntityRendererRegistry.register(ModEntityTypes.AMETHYST_BULLET, AmethystBulletRenderer::new);

    }
}
