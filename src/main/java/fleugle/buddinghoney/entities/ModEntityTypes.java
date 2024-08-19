package fleugle.buddinghoney.entities;

import fleugle.buddinghoney.Buddinghoney;
import fleugle.buddinghoney.entities.custom.BeestaniteBulletEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntityTypes {

    public static final EntityType<BeestaniteBulletEntity> BEESTANITE_BULLET = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Buddinghoney.MOD_ID, "beestanite_bullet"),
            FabricEntityTypeBuilder.<BeestaniteBulletEntity>create(SpawnGroup.MISC, BeestaniteBulletEntity:: new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());

    public static final EntityType<BeestaniteBulletEntity> AMETHYST_BULLET = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Buddinghoney.MOD_ID, "amethyst_bullet"),
            FabricEntityTypeBuilder.<BeestaniteBulletEntity>create(SpawnGroup.MISC, BeestaniteBulletEntity:: new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());
}
