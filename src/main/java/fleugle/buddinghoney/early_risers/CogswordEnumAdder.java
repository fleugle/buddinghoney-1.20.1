package fleugle.buddinghoney.early_risers;

import com.chocohead.mm.api.ClassTinkerers;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;


public class CogswordEnumAdder implements Runnable{
	@Override
	public void run() {

		MappingResolver remapper = FabricLoader.getInstance().getMappingResolver();
		String enchantmentTarget = remapper.mapClassName("intermediary", "net.minecraft.class_1886");
		ClassTinkerers.enumBuilder(enchantmentTarget).addEnumSubclass("COGSWORD", "fleugle.buddinghoney.LetThemEnchantCogsword").build();
	}
}
