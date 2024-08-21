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
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
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

				} else if (itemStack.getItem() instanceof CogswordItem
						&& isNotInCD
						&& hand == Hand.MAIN_HAND
						&& !tag.getBoolean(CogswordItem.COGSWORD_AMETHYST_TAG)) {
					if (target instanceof LivingEntity livingEntityTarget){


						if (!livingEntityTarget.hasStatusEffect(ModStatusEffects.RUSTING)) {
							livingEntityTarget.addStatusEffect(new StatusEffectInstance(ModStatusEffects.RUSTING, 200, 0));
						}
						else if (livingEntityTarget.getStatusEffect(ModStatusEffects.RUSTING).getAmplifier() < 2){
							livingEntityTarget.addStatusEffect(new StatusEffectInstance(ModStatusEffects.RUSTING, 200, livingEntityTarget.getStatusEffect(ModStatusEffects.RUSTING).getAmplifier() + 1));
						}

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
							livingEntityTarget.addStatusEffect(new StatusEffectInstance(ModStatusEffects.AMETHYSTIFICATION, 200, 0));
						}
						else if (livingEntityTarget.getStatusEffect(ModStatusEffects.AMETHYSTIFICATION).getAmplifier() < 4){
							livingEntityTarget.addStatusEffect(new StatusEffectInstance(ModStatusEffects.AMETHYSTIFICATION, 200, livingEntityTarget.getStatusEffect(ModStatusEffects.AMETHYSTIFICATION).getAmplifier() + 1));
						}

					}

				}
				//*
				//Desecration
				if (itemStack.getItem() instanceof CogswordItem
						&& isNotInCD
						&& hand == Hand.MAIN_HAND
						&& EnchantmentHelper.getLevel(ModEnchantments.DESECRATION, itemStack) > 0
				)
				{
					if (target instanceof LivingEntity livingEntityTarget){


						EntityAttributeInstance attackDamage = player.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);

						if (attackDamage != null ){
							int multiplier = EnchantmentHelper.getLevel(ModEnchantments.DESECRATION, itemStack);
							attackDamage.addTemporaryModifier( new EntityAttributeModifier(
									UUID.fromString("A23B67E4-5D8C-4F2B-83D4-7E81F65B8D33"),
									"desecrationDamageModifier",
									(0.1 * multiplier),
									EntityAttributeModifier.Operation.MULTIPLY_TOTAL
							));
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
