package fleugle.buddinghoney.entities.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class AmethystBulletModel extends EntityModel<Entity> {
	private final ModelPart bone3;
	private final ModelPart bone;
	private final ModelPart bone2;
	public AmethystBulletModel(ModelPart root) {
		this.bone3 = root.getChild("bone3");
		this.bone = this.bone3.getChild("bone");  // Retrieve bone from bone3
		this.bone2 = this.bone3.getChild("bone2"); // Retrieve bone2 from bone3
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bone3 = modelPartData.addChild("bone3", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 0.0F, -1.5708F, 0.0F, 1.5708F));

		ModelPartData bone = bone3.addChild("bone", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		ModelPartData cube_r1 = bone.addChild("cube_r1", ModelPartBuilder.create().uv(-10, 10).cuboid(-5.0F, 0.0F, -5.0F, 10.0F, 0.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		ModelPartData bone2 = bone3.addChild("bone2", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		ModelPartData cube_r2 = bone2.addChild("cube_r2", ModelPartBuilder.create().uv(-10, 0).cuboid(-5.0F, 0.0F, -5.0F, 10.0F, 0.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));
		return TexturedModelData.of(modelData, 20, 20);
	}
	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bone3.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}
