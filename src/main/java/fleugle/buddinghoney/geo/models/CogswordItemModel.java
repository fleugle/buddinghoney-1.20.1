package fleugle.buddinghoney.geo.models;

import fleugle.buddinghoney.Buddinghoney;
import fleugle.buddinghoney.items.custom.CogswordItem;
import mod.azure.azurelib.model.GeoModel;
import net.minecraft.util.Identifier;

public class CogswordItemModel extends GeoModel<CogswordItem> {
    // Models must be stored in assets/<modid>/geo with subfolders supported inside the geo folder
    private static final Identifier model = new Identifier(Buddinghoney.MOD_ID, "geo/item/cog_sword.geo.json");
    // Textures must be stored in assets/<modid>/textures with subfolders supported inside the textures folder
    private static final Identifier texture = new Identifier(Buddinghoney.MOD_ID, "textures/item/cogsword.png");
    // Animations must be stored in assets/<modid>/animations with subfolders supported inside the animations folder
    private static final Identifier animation = new Identifier(Buddinghoney.MOD_ID, "animations/cog_sword.animation.json");

    @Override
    public Identifier getModelResource(CogswordItem object) {
        return this.model;
    }

    @Override
    public Identifier getTextureResource(CogswordItem object) {
        return this.texture;
    }

    @Override
    public Identifier getAnimationResource(CogswordItem object) {
        return this.animation;
    }
}

