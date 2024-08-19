package fleugle.buddinghoney.mixin;

import fleugle.buddinghoney.items.custom.AbstractGunItem;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel.ArmPose;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(PlayerEntityRenderer.class)
public class PlayerEntityRendererMixin {
	@Inject(
		method = "getArmPose(Lnet/minecraft/client/network/AbstractClientPlayerEntity;Lnet/minecraft/util/Hand;)Lnet/minecraft/client/render/entity/model/BipedEntityModel$ArmPose;",
		at = @At("TAIL"),
		cancellable = true
	)
	private static void gunInArms(AbstractClientPlayerEntity player, Hand hand, CallbackInfoReturnable<ArmPose> ci) {

		ItemStack itemStack = player.getStackInHand(hand);


		if(itemStack.getItem() instanceof AbstractGunItem) {//don't forget to edit values here as well
			ci.setReturnValue(ArmPose.CROSSBOW_HOLD);
			ci.cancel();
		}
	}


}
