package fleugle.buddinghoney.damage_types;

import fleugle.buddinghoney.Buddinghoney;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModDamageTypes {


	public static final RegistryKey<DamageType> BUDDING_ALIVE =
		RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(Buddinghoney.MOD_ID, "budding_alive"));




}
