package fleugle.buddinghoney.geo.models;

import fleugle.buddinghoney.Buddinghoney;
import fleugle.buddinghoney.items.custom.AmethystShotgunItem;
import fleugle.buddinghoney.items.custom.HoneycombShotgunItem;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.util.Identifier;

public class AmethystShotgunItemModel extends GeoModel<AmethystShotgunItem> {
    // Models must be stored in assets/<modid>/geo with subfolders supported inside the geo folder
    private static final Identifier model = new Identifier(Buddinghoney.MOD_ID, "geo/item/honeycomb_shotgun.geo.json");
    // Textures must be stored in assets/<modid>/textures with subfolders supported inside the textures folder
    private static final Identifier texture = new Identifier(Buddinghoney.MOD_ID, "textures/item/amethyst_shotgun.png");
    // Animations must be stored in assets/<modid>/animations with subfolders supported inside the animations folder
    private static final Identifier animation = new Identifier(Buddinghoney.MOD_ID, "animations/honeycomb_shotgun.animation.json");

    @Override
    public Identifier getModelResource(AmethystShotgunItem object) {
        return this.model;
    }

    @Override
    public Identifier getTextureResource(AmethystShotgunItem object) {
        return this.texture;
    }

    @Override
    public Identifier getAnimationResource(AmethystShotgunItem object) {
        return this.animation;
    }
}

