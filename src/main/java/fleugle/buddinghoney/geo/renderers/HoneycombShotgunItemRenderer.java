package fleugle.buddinghoney.geo.renderers;

import fleugle.buddinghoney.geo.models.CogswordItemModel;
import fleugle.buddinghoney.geo.models.HoneycombShotgunItemModel;
import fleugle.buddinghoney.items.custom.CogswordItem;
import fleugle.buddinghoney.items.custom.HoneycombShotgunItem;
import mod.azure.azurelib.renderer.GeoItemRenderer;

public class HoneycombShotgunItemRenderer extends GeoItemRenderer<HoneycombShotgunItem> {
    public HoneycombShotgunItemRenderer() {
        // Register the Model class to this render
        super(new HoneycombShotgunItemModel());
    }
}
