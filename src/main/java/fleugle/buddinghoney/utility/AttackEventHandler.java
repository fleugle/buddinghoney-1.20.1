package fleugle.buddinghoney.utility;

import com.terraformersmc.modmenu.util.mod.Mod;
import fleugle.buddinghoney.enchantments.ModEnchantments;
import fleugle.buddinghoney.items.custom.CogswordItem;
import fleugle.buddinghoney.status_effects.ModStatusEffects;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;


import java.util.UUID;

public class AttackEventHandler {

	public static void register() {

		AttackEntityCallback.EVENT.register((player, world, hand, target, hitResult) -> {
			ItemStack itemStack = player.getStackInHand(hand);

			if (!world.isClient){
				float attackCooldownProgress = player.getAttackCooldownProgress(0.5F);
				boolean isNotInCD = attackCooldownProgress > 0.9F;

				boolean isCritical = !player.isOnGround() && !player.isClimbing() && !player.isTouchingWater()  && !player.hasVehicle() && player.fallDistance > 0.0F && player.getVelocity().y < 0.0D && !player.isSprinting() && isNotInCD ;

				NbtCompound tag = itemStack.getOrCreateNbt();


				//Cogsword budding handler
				if (itemStack.getItem() instanceof CogswordItem
						&& isNotInCD
						&& hand == Hand.MAIN_HAND
						&& tag.getBoolean(CogswordItem.COGSWORD_AMETHYST_TAG)
				)
				{
					if (target instanceof LivingEntity livingEntityTarget){
						livingEntityTarget.addStatusEffect(new StatusEffectInstance(ModStatusEffects.BUDDING, 80, 0));
					}

				}


				//Cogsword enchants handler
				//*
				//aspiration
				if (itemStack.getItem() instanceof CogswordItem
						&& isNotInCD
						&& hand == Hand.MAIN_HAND
						&& EnchantmentHelper.getLevel(ModEnchantments.ASPIRATION, itemStack) > 0
				)
				{
					if (target instanceof LivingEntity livingEntityTarget){
						player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 40 * EnchantmentHelper.getLevel(ModEnchantments.ASPIRATION, itemStack), 0));
					}

				}
				//*
				//Amethystification
				if (itemStack.getItem() instanceof CogswordItem
						&& isNotInCD
						&& hand == Hand.MAIN_HAND
						&& EnchantmentHelper.getLevel(ModEnchantments.AMETHYSTIFICATION, itemStack) > 0
				)
				{
					if (target instanceof LivingEntity livingEntityTarget){


						if (!livingEntityTarget.hasStatusEffect(ModStatusEffects.AMETHYSTIFICATION)) {
							player.addStatusEffect(new StatusEffectInstance(ModStatusEffects.AMETHYSTIFICATION, 200, 0));
						}
						else if (livingEntityTarget.getStatusEffect(ModStatusEffects.AMETHYSTIFICATION).getAmplifier() < 4){
							player.addStatusEffect(new StatusEffectInstance(ModStatusEffects.AMETHYSTIFICATION, 200, livingEntityTarget.getStatusEffect(ModStatusEffects.AMETHYSTIFICATION).getAmplifier() + 1));
						}

					}

				}

			}

			return ActionResult.PASS;
		});
	}

	private static ItemStack getItemStackInArmorSlot(PlayerEntity player, int i){
		return player.getInventory().armor.get(i);
	}




}
