package fleugle.buddinghoney.utility;

import fleugle.buddinghoney.items.custom.AbstractGunItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
public class ItemsPosing {

	public static void pointGun(ModelPart holdingArm, ModelPart otherArm, ModelPart head, LivingEntity entity, CallbackInfo callbackInfo, boolean rightArmed) {
		if(entity.getMainHandStack().getItem() instanceof AbstractGunItem || entity.getOffHandStack().getItem() instanceof AbstractGunItem) {//change it in advance, as well as AbstractGunItem class
			ModelPart modelPart = rightArmed ? holdingArm : otherArm;
			ModelPart modelPart2 = rightArmed ? otherArm : holdingArm;

			//inn or away of the players body.
			modelPart.yaw = (rightArmed ? -0.3F : 0.3F) + head.yaw;
			modelPart2.yaw = (rightArmed ? 0.6F : -0.6F) + head.yaw;
			//this one seems to respond for a horizontal axis(is arm towards ceiling or floor)
			modelPart.pitch = (float) (-Math.PI / 2) + head.pitch /*+ 0.1F*/;
			modelPart2.pitch = -1.5F + head.pitch;

			callbackInfo.cancel();
		}
	}



}
