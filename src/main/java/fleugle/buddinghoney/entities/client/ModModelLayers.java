package fleugle.buddinghoney.entities.client;

import fleugle.buddinghoney.Buddinghoney;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {


	public static final EntityModelLayer BEESTANITE_BULLET_LAYER =
		new EntityModelLayer(new Identifier(Buddinghoney.MOD_ID, "beestanite_bullet"), "main");

	public static final EntityModelLayer AMETHYST_BULLET_LAYER =
			new EntityModelLayer(new Identifier(Buddinghoney.MOD_ID, "amethyst_bullet"), "main");

}
