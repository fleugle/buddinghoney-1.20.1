package fleugle.buddinghoney.enchantments.custom;

import com.chocohead.mm.api.ClassTinkerers;
import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class DesecrationEnchantment extends Enchantment {

	public DesecrationEnchantment() {
		super(Rarity.UNCOMMON,
			ClassTinkerers.getEnum(EnchantmentTarget.class, "COGSWORD")
			,new EquipmentSlot[] {EquipmentSlot.MAINHAND});
	}

	@Override
	public int getMaxLevel() {
		return 5;
	}

	@Override
	public int getMinPower(int level) {
		return 25;
	}

	@Override
	public boolean canAccept(Enchantment other) {
		return !(other instanceof AmethystificationEnchantment || other instanceof AspirationEnchantment || other instanceof DamageEnchantment);
	}




}
