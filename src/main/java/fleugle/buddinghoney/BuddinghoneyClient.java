package fleugle.buddinghoney;

import fleugle.buddinghoney.entities.ModEntityTypes;
import fleugle.buddinghoney.entities.client.BeestaniteBulletModel;
import fleugle.buddinghoney.entities.client.BeestaniteBulletRenderer;
import fleugle.buddinghoney.entities.client.ModModelLayers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class BuddinghoneyClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {


        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.BEESTANITE_BULLET_LAYER, BeestaniteBulletModel::getTexturedModelData);//breeze


        EntityRendererRegistry.register(ModEntityTypes.BEESTANITE_BULLET, BeestaniteBulletRenderer::new);

    }
}
