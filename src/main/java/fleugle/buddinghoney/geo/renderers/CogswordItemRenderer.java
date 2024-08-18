package fleugle.buddinghoney.geo.renderers;

import fleugle.buddinghoney.geo.models.CogswordItemModel;
import fleugle.buddinghoney.items.custom.CogswordItem;
import mod.azure.azurelib.renderer.GeoItemRenderer;

public class CogswordItemRenderer extends GeoItemRenderer<CogswordItem> {
    public CogswordItemRenderer() {
        // Register the Model class to this render
        super(new CogswordItemModel());
    }
}
