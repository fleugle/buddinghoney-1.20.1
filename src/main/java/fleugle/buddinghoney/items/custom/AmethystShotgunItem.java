package fleugle.buddinghoney.items.custom;

import fleugle.buddinghoney.entities.custom.AmethystBulletEntity;
import fleugle.buddinghoney.entities.custom.BeestaniteBulletEntity;
import fleugle.buddinghoney.geo.renderers.AmethystShotgunItemRenderer;
import fleugle.buddinghoney.geo.renderers.HoneycombShotgunItemRenderer;
import fleugle.buddinghoney.items.ModItems;
import fleugle.buddinghoney.sound_events.ModSoundEvents;
import fleugle.buddinghoney.utility.SoundsManager;
import mod.azure.azurelib.animatable.GeoItem;
import mod.azure.azurelib.animatable.SingletonGeoAnimatable;
import mod.azure.azurelib.animatable.client.RenderProvider;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class AmethystShotgunItem extends AbstractGunItem {

    boolean isAmethyst;

    //CONSTRUCTOR\\
    public AmethystShotgunItem(Settings properties, boolean isAmethyst) {
        super(
                2,
                10,
                80,
                "§dYou need to charge it",
                "§2 - Deals 5 damage. Applies \"Budding\" effect on hit.",
                "§2 - Amethyst Bullet",
                properties);
        SingletonGeoAnimatable.registerSyncedAnimatable(this);

        this.isAmethyst = isAmethyst;
    }





    //GUN ITEM CLASS OVERRIDES\\
    @Override
    public Item getAmmoItem(){


        if (!isAmethyst) {
            return ModItems.BEESTANITE_BULLET;
        }
        else return ModItems.AMETHYST_BULLET;
    }

    @Override
    public SoundEvent getShootingSound(){
        if (!isAmethyst) {
            return ModSoundEvents.DEFAULT_SHOTGUN_SHOOT;
        }
        else return ModSoundEvents.AMETHYST_SHOTGUN_SHOOT;
    }

    @Override
    public SoundEvent getReloadSound(){
        if (!isAmethyst) {
            return ModSoundEvents.DEFAULT_SHOTGUN_RELOAD;
        }
        else  return ModSoundEvents.AMETHYST_SHOTGUN_RELOAD;
    }

    @Override
    public SoundEvent getEmptySound(){
        return ModSoundEvents.EMPTY_GUN_SHOT;
    }


    @Override
    public void createProjectile(World world, PlayerEntity shooter, ItemStack stackWithGun){

        summonBullets(world,shooter,stackWithGun,isAmethyst,getAmmoAmount(stackWithGun));


    }

    public void summonBullets(World world, PlayerEntity shooter, ItemStack stackWithGun, boolean isAmethyst, int spawnCount){
        if(!isAmethyst){
            BeestaniteBulletEntity bulletEntity = new BeestaniteBulletEntity(world, shooter);
            BeestaniteBulletEntity bulletEntity2 = new BeestaniteBulletEntity(world, shooter);
            switch (spawnCount){
                case 0:

                    bulletEntity.setItem(stackWithGun);
                    bulletEntity.setBulletProperties(shooter, shooter.getPitch(), shooter.getYaw() + 3f, 1.0F, 3.5F, 0F);
                    world.spawnEntity(bulletEntity);

                    bulletEntity2.setItem(stackWithGun);
                    bulletEntity2.setBulletProperties(shooter, shooter.getPitch(), shooter.getYaw() - 3f, 1.0F, 3.5F, 0F);
                    world.spawnEntity(bulletEntity2);
                    break;
                case 1:
                    bulletEntity.setItem(stackWithGun);
                    bulletEntity.setBulletProperties(shooter, shooter.getPitch(), shooter.getYaw(), 1.0F, 3.5F, 0F);
                    world.spawnEntity(bulletEntity);
                    break;
                case 2:

                    bulletEntity.setItem(stackWithGun);
                    bulletEntity.setBulletProperties(shooter, shooter.getPitch(), shooter.getYaw() + 3f, 1.0F, 3.5F, 0F);
                    world.spawnEntity(bulletEntity);

                    bulletEntity2.setItem(stackWithGun);
                    bulletEntity2.setBulletProperties(shooter, shooter.getPitch(), shooter.getYaw() - 3f, 1.0F, 3.5F, 0F);
                    world.spawnEntity(bulletEntity2);
                    break;

            }
        }
        else {
            AmethystBulletEntity bulletEntity = new AmethystBulletEntity(world, shooter);
            AmethystBulletEntity bulletEntity2 = new AmethystBulletEntity(world, shooter);
            switch (spawnCount){

                case 0:

                    bulletEntity.setItem(stackWithGun);
                    bulletEntity.setBulletProperties(shooter, shooter.getPitch(), shooter.getYaw() + 3f, 1.0F, 3.5F, 0F);
                    world.spawnEntity(bulletEntity);

                    bulletEntity2.setItem(stackWithGun);
                    bulletEntity2.setBulletProperties(shooter, shooter.getPitch(), shooter.getYaw() - 3f, 1.0F, 3.5F, 0F);
                    world.spawnEntity(bulletEntity2);
                    break;
                case 1:
                    bulletEntity.setItem(stackWithGun);
                    bulletEntity.setBulletProperties(shooter, shooter.getPitch(), shooter.getYaw(), 1.0F, 3.5F, 0F);
                    world.spawnEntity(bulletEntity);
                    break;
                case 2:

                    bulletEntity.setItem(stackWithGun);
                    bulletEntity.setBulletProperties(shooter, shooter.getPitch(), shooter.getYaw() + 3f, 1.0F, 3.5F, 0F);
                    world.spawnEntity(bulletEntity);

                    bulletEntity2.setItem(stackWithGun);
                    bulletEntity2.setBulletProperties(shooter, shooter.getPitch(), shooter.getYaw() - 3f, 1.0F, 3.5F, 0F);
                    world.spawnEntity(bulletEntity2);
                    break;

            }
        }
    }

    @Override
    public void projectileShoot(World world, PlayerEntity shooter, ItemStack stackWithGun, Hand hand){

        int ifHasInfinityEnchantment = EnchantmentHelper.getLevel(Enchantments.INFINITY, stackWithGun);


        if (!world.isClient) {

            if (hasEnoughAmmoInWeapon(stackWithGun) || shooter.getAbilities().creativeMode || ifHasInfinityEnchantment >= 1){
                createProjectile(world, shooter, stackWithGun);
                shooter.getItemCooldownManager().set(this, this.shootingDelay);

                createFiringParticles(world, shooter);

                if (!shooter.getAbilities().creativeMode && ifHasInfinityEnchantment == 0) {
                    setAmmoAmount(stackWithGun, getAmmoAmount(stackWithGun) - 2);
                }
                triggerAnim(shooter, GeoItem.getOrAssignId(stackWithGun, (ServerWorld) world), "shooting_controller", "shoot");
                SoundsManager.playPlayersSoundFromPlayer(shooter, getShootingSound(), 1f);



                Hand currentHand = hand == Hand.MAIN_HAND ? this.mainHand : this.offHand;
                ItemStack stackInCurrentHand = shooter.getStackInHand(currentHand);
                if (!shooter.getAbilities().creativeMode) {
                    stackWithGun.damage(1, shooter, e -> e.sendEquipmentBreakStatus(
                            currentHand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND
                    ));
                }
            }
            else {
                notifyShooterAboutAmmo(shooter);
                shooter.getItemCooldownManager().set(this, this.shootingDelay);
                triggerAnim(shooter, GeoItem.getOrAssignId(stackWithGun, (ServerWorld) world), "shooting_controller", "empty_shoot");
                SoundsManager.playPlayersSoundFromPlayer(shooter, getEmptySound(), 1f);
            }




            shooter.getItemCooldownManager().set(this, this.shootingDelay); // Set cooldown

        }

        shooter.incrementStat(Stats.USED.getOrCreateStat(this));


    }





    //DEFAULT ITEM CLASSES OVERRIDES\\
    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(ModItems.BEESTANITE);
    }




    //AZURELIB PART\\

    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);

    @Override
    public void createRenderer(Consumer<Object> consumer) {

        // Accepts a consumer to create a new renderer
        consumer.accept(new RenderProvider() {
            // Your render class made above
            private HoneycombShotgunItemRenderer renderer = null;
            private AmethystShotgunItemRenderer renderer2 = null;

            @Override
            public BuiltinModelItemRenderer getCustomRenderer() {
                // Check if renderer is null, create a new instance if so
                if (!isAmethyst) {
                    if (renderer == null)
                        return new HoneycombShotgunItemRenderer();
                }
                else if (renderer2 == null)
                    return new AmethystShotgunItemRenderer();
                // Return the existing renderer if it's not null
                if (!isAmethyst) {
                    return this.renderer;
                }
                else return this.renderer2;
            }
        });
    }

    @Override
    public Supplier<Object> getRenderProvider() {
        return renderProvider;
    }

}
