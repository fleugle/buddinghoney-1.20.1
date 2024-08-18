package fleugle.buddinghoney.geo.renderers;

import fleugle.buddinghoney.geo.models.AmethystCogswordItemModel;
import fleugle.buddinghoney.geo.models.CogswordItemModel;
import fleugle.buddinghoney.items.custom.CogswordItem;
import mod.azure.azurelib.renderer.GeoItemRenderer;

public class AmethystCogswordItemRenderer extends GeoItemRenderer<CogswordItem> {
    public AmethystCogswordItemRenderer() {
        // Register the Model class to this render
        super(new AmethystCogswordItemModel());
    }
}
