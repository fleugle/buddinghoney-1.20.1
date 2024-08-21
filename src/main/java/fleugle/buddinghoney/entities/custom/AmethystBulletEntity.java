package fleugle.buddinghoney.entities.custom;

import fleugle.buddinghoney.Buddinghoney;
import fleugle.buddinghoney.damage_types.ModDamageTypes;
import fleugle.buddinghoney.entities.ModEntityTypes;
import fleugle.buddinghoney.particles.ModParticleTypes;
import fleugle.buddinghoney.status_effects.ModStatusEffects;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.EndGatewayBlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

public class AmethystBulletEntity extends ThrownItemEntity {
	private PlayerEntity user = null;
	//private final Set<StatusEffectInstance> effects = Sets.newHashSet();
	private final World world;

	 private Vector3f color = new Vector3f(0.835f, 0.412f, 0.839f);



	public AmethystBulletEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
		super(entityType, world);


		this.world = world;

		this.setNoGravity(true);


	}

	@Override
	protected Item getDefaultItem() {
		return null;
	}


	public AmethystBulletEntity(World world, LivingEntity owner) {
		super(ModEntityTypes.AMETHYST_BULLET, owner, world);



		if (owner instanceof PlayerEntity user) {
			this.user = user;


			// Add all status effects from the user to the effects set

		}
		this.world = world;

		this.setNoGravity(true);

	}

	public void setBulletProperties(Entity user, float pitch, float yaw, float roll, float modifierZ, float modifierXYZ) {
		float f = -MathHelper.sin(yaw * (float) (Math.PI / 180.0)) * MathHelper.cos(pitch * (float) (Math.PI / 180.0));
		float g = -MathHelper.sin((pitch + roll) * (float) (Math.PI / 180.0));
		float h = MathHelper.cos(yaw * (float) (Math.PI / 180.0)) * MathHelper.cos(pitch * (float) (Math.PI / 180.0));
		this.setVelocity((double)f, (double)g, (double)h, modifierZ, modifierXYZ);
		Vec3d vec3d = user.getVelocity();
		this.setVelocity(this.getVelocity().add(vec3d.x, user.isOnGround() ? 0.0 : vec3d.y, vec3d.z));
	}

	@Override
	protected void onCollision(@NotNull HitResult hitResult) {
		//super.onCollision(hitResult);




			if (!this.getWorld().isClient && this.user != null) {
				if (hitResult.getType() == HitResult.Type.ENTITY) {
					EntityHitResult entityHitResult = (EntityHitResult) hitResult;
					if (entityHitResult.getEntity() instanceof LivingEntity && entityHitResult.getEntity() != this.user) {
						LivingEntity target = (LivingEntity) entityHitResult.getEntity();

						if (this.world instanceof ServerWorld serverWorld) {
							Vec3d pos = target.getPos();
							serverWorld.spawnParticles(ModParticleTypes.AMETHYST_BOOM,
									pos.x,
									pos.y  + target.getHeight()/2 + 0.1,
									pos.z,
									1, 0, 0, 0, 0);
						}

						DamageSource source = new DamageSource(
								user.getWorld().getRegistryManager()
										.get(RegistryKeys.DAMAGE_TYPE)
										.entryOf(ModDamageTypes.AMETHYSTICAL_STRIKE)
						);

						target.damage(source, 7);
						target.takeKnockback(
								1F, (double)MathHelper.sin(user.getYaw() * (float) (Math.PI / 180.0)), (double)(-MathHelper.cos(user.getYaw() * (float) (Math.PI / 180.0)))
						);
						target.setStatusEffect(new StatusEffectInstance(ModStatusEffects.BUDDING, 40, 0, false, true, true), user);


						Buddinghoney.LOGGER.info("Collide with entity");
						this.discard();

					}

				}else if (hitResult.getType() == HitResult.Type.BLOCK) {




					DustParticleEffect effect = new DustParticleEffect(color, 1);

					Buddinghoney.LOGGER.info("Collide with block");
					/*if (this.world instanceof ServerWorld serverWorld) {
						BlockPos pos = BlockPos.ofFloored(this.getPos());
						serverWorld.spawnParticles(effect,
							pos.getX()  + 0.5,
							pos.getY()  + 0.5,
							pos.getZ()  + 0.5,
							100, 0.5, 0.5, 0.5, 0);
					}*/

					this.discard();

				}

			}




	}


	@Override
	public void tick() {

		this.baseTick();



		HitResult hitResult = ProjectileUtil.getCollision(this, this::canHit);
		boolean bl = false;
		if (hitResult.getType() == HitResult.Type.BLOCK) {
			BlockPos blockPos = ((BlockHitResult)hitResult).getBlockPos();
			BlockState blockState = this.getWorld().getBlockState(blockPos);
			if (blockState.isOf(Blocks.NETHER_PORTAL)) {
				this.setInNetherPortal(blockPos);
				bl = true;
			} else if (blockState.isOf(Blocks.END_GATEWAY)) {
				BlockEntity blockEntity = this.getWorld().getBlockEntity(blockPos);
				if (blockEntity instanceof EndGatewayBlockEntity && EndGatewayBlockEntity.canTeleport(this)) {
					EndGatewayBlockEntity.tryTeleportingEntity(this.getWorld(), blockPos, blockState, this, (EndGatewayBlockEntity)blockEntity);
				}

				bl = true;
			}
		}

		if (hitResult.getType() != HitResult.Type.MISS && !bl) {
			this.onCollision(hitResult);
		}

		this.checkBlockCollision();
		Vec3d vec3d = this.getVelocity();
		double d = this.getX() + vec3d.x;
		double e = this.getY() + vec3d.y;
		double f = this.getZ() + vec3d.z;
		this.updateRotation();
		float h = 1;

		this.setVelocity(vec3d.multiply((double)h));
		if (!this.hasNoGravity()) {
			Vec3d vec3d2 = this.getVelocity();
			this.setVelocity(vec3d2.x, vec3d2.y, vec3d2.z);
		}

		if (world instanceof ServerWorld serverWorld) {
			double x = this.getX();
			double y = this.getY();
			double z = this.getZ();
			double dx = -this.getVelocity().x;
			double dy = -this.getVelocity().y;
			double dz = -this.getVelocity().z;

			double devider = 3.0;


			DustParticleEffect effect = new DustParticleEffect(color, 1);

			for (int i = 0; i < 5; i++) {


				/*serverWorld.spawnParticles(effect,
						x + dx * i / devider,
						y + dy * i / devider,
						z + dz * i / devider,
						0.0, 0.0, 0.0);*/

				serverWorld.spawnParticles(effect,
						x + dx * i / devider,
						y + dy * i / devider,
						z + dz * i / devider,
						1, 0, 0, 0, 0);
			}
		}


		this.setPosition(d, e, f);

	}




}
