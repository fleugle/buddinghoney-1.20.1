package fleugle.buddinghoney.entities.client;

import fleugle.buddinghoney.Buddinghoney;
import fleugle.buddinghoney.entities.custom.BeestaniteBulletEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import org.joml.Quaternionf;


public class BeestaniteBulletRenderer extends EntityRenderer<BeestaniteBulletEntity> {
	private static final Identifier TEXTURE = new Identifier(Buddinghoney.MOD_ID, "textures/entity/beestanite_bullet_entity.png");

	private static final RenderLayer LAYER = RenderLayer.getEntityTranslucent(TEXTURE);

	private final BeestaniteBulletModel model;


	public BeestaniteBulletRenderer(EntityRendererFactory.Context ctx) {
		super(ctx);
		this.model = new BeestaniteBulletModel(ctx.getPart(ModModelLayers.BEESTANITE_BULLET_LAYER));
	}

	@Override
	public void render(BeestaniteBulletEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
		matrices.push();
		// Apply scaling
		float scale = 1.5f; // Adjust the scale factor as needed
		matrices.scale(scale, scale, scale);


		//float rotationSpeed = /*entity.shouldRotateClockwise() ?*/ 1.4f /*: -3.2f*/;


		matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(tickDelta, entity.prevYaw, entity.getYaw()) - 90.0f));
		matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(tickDelta, entity.prevPitch, entity.getPitch()) + 90.0f));
		// Add rotation around the Z axis for the rolling effect
		//matrices.multiply(new Quaternionf().rotateY((float) Math.toRadians(entity.age * rotationSpeed))); // Adjust the rotation speed as needed

		VertexConsumer vertexConsumer = vertexConsumers.getBuffer(LAYER);
		this.model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);


		matrices.pop();
		super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
	}

	@Override
	public Identifier getTexture(BeestaniteBulletEntity entity) {
		return TEXTURE;
	}


}
