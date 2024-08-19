package fleugle.buddinghoney;

import fleugle.buddinghoney.items.custom.CogswordItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class LetThemEnchantCogsword extends CogswordEnchantmentTargetMixin {
    @Override
    public boolean isAcceptableItem(Item item) {
        return item instanceof CogswordItem;
    }
}

@Mixin(EnchantmentTarget.class)
abstract class CogswordEnchantmentTargetMixin {
    @Shadow
    abstract boolean isAcceptableItem(Item item);
}