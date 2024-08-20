package fleugle.buddinghoney.geo.renderers;

import fleugle.buddinghoney.Buddinghoney;
import fleugle.buddinghoney.geo.models.HoneycombShotgunItemModel;
import fleugle.buddinghoney.items.custom.HoneycombShotgunItem;
import mod.azure.azurelib.renderer.GeoItemRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class HoneycombShotgunItemRenderer extends GeoItemRenderer<HoneycombShotgunItem> {


    public HoneycombShotgunItemRenderer() {
        // Register the Model class to this render
        super(new HoneycombShotgunItemModel());
    }


    private static final Identifier TEXTURE = new Identifier(Buddinghoney.MOD_ID,"textures/item/honeycomb_shotgun.png");
    private static final RenderLayer LAYER = RenderLayer.getEntityTranslucent(TEXTURE, true);


    @Override
    public void render(ItemStack stack, ModelTransformationMode transformType, MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight, int packedOverlay) {
        this.animatable = (HoneycombShotgunItem) stack.getItem();
        this.currentItemStack = stack;
        this.renderPerspective = transformType;
        if (transformType == ModelTransformationMode.GUI) {
            this.renderInGui(transformType, poseStack, bufferSource, packedLight, packedOverlay);
        } else {
            //RenderLayer renderType = this.getRenderType(this.animatable, this.getTextureLocation(this.animatable), bufferSource, MinecraftClient.getInstance().getTickDelta());
            RenderLayer renderType = LAYER;


            VertexConsumer buffer = ItemRenderer.getDirectItemGlintConsumer(bufferSource, renderType, false, this.currentItemStack != null && this.currentItemStack.hasGlint());

            if (buffer == null) {
                buffer = bufferSource.getBuffer(renderType);
            }
            this.defaultRender(poseStack, this.animatable, bufferSource, renderType, buffer, 0.0F, MinecraftClient.getInstance().getTickDelta(), packedLight);
        }

    }

}
