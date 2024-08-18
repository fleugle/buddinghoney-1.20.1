package fleugle.buddinghoney.items.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import fleugle.buddinghoney.geo.renderers.AmethystCogswordItemRenderer;
import fleugle.buddinghoney.geo.renderers.CogswordItemRenderer;
import mod.azure.azurelib.animatable.GeoItem;
import mod.azure.azurelib.animatable.client.RenderProvider;
import mod.azure.azurelib.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.core.animation.AnimatableManager;
import mod.azure.azurelib.core.animation.AnimationController;
import mod.azure.azurelib.core.animation.RawAnimation;
import mod.azure.azurelib.core.object.PlayState;
import mod.azure.azurelib.util.AzureLibUtil;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class CogswordItem extends Item implements GeoItem {
    private final ToolMaterial material;
    private final float attackDamage;
    public boolean isAmethyst;

    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "cog_scroll",
                event -> {
                    return event.setAndContinue( RawAnimation.begin().thenLoop("cog_spin"));
                }));
    }

    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);

    @Override
    public void createRenderer(Consumer<Object> consumer) {

        // Accepts a consumer to create a new renderer
        consumer.accept(new RenderProvider() {
            // Your render class made above
            private CogswordItemRenderer renderer = null;

            private AmethystCogswordItemRenderer renderer1 = null;

            @Override
            public BuiltinModelItemRenderer getCustomRenderer() {
                // Check if renderer is null, create a new instance if so
                if (renderer == null && !isAmethyst)
                    return new CogswordItemRenderer();
                else if (renderer1 == null && isAmethyst) {
                    return new AmethystCogswordItemRenderer();
                }
                // Return the existing renderer if it's not null

                if (isAmethyst) {
                    return this.renderer;
                }
                else  return this.renderer1;
            }
        });
    }

    @Override
    public Supplier<Object> getRenderProvider() {
        return renderProvider;
    }

    public static final String COGSWORD_AMETHYST_TAG = "isAmethystCockSword";

    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public CogswordItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings, boolean isAmethyst) {
        super(settings.maxDamageIfAbsent(material.getDurability()));

        this.material = material;

        this.isAmethyst = isAmethyst;

        this.attackDamage = (float)attackDamage + material.getAttackDamage();
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(
                EntityAttributes.GENERIC_ATTACK_DAMAGE,
                new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Weapon modifier", (double)this.attackDamage, EntityAttributeModifier.Operation.ADDITION)
        );
        builder.put(
                EntityAttributes.GENERIC_ATTACK_SPEED,
                new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Weapon modifier", (double)attackSpeed, EntityAttributeModifier.Operation.ADDITION)
        );
        this.attributeModifiers = builder.build();

    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers(slot);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected){
        if (!world.isClient) {
            NbtCompound tag = stack.getOrCreateNbt();

            tag.putBoolean(COGSWORD_AMETHYST_TAG, this.isAmethyst);

        }
    }






}
