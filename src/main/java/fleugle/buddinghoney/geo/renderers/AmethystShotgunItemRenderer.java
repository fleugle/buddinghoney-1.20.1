package fleugle.buddinghoney.geo.renderers;

import fleugle.buddinghoney.geo.models.AmethystShotgunItemModel;
import fleugle.buddinghoney.geo.models.HoneycombShotgunItemModel;
import fleugle.buddinghoney.items.custom.HoneycombShotgunItem;
import mod.azure.azurelib.renderer.GeoItemRenderer;

public class AmethystShotgunItemRenderer extends GeoItemRenderer<HoneycombShotgunItem> {
    public AmethystShotgunItemRenderer() {
        // Register the Model class to this render
        super(new AmethystShotgunItemModel());
    }
}
