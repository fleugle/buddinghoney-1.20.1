package fleugle.buddinghoney.utility;

import net.minecraft.entity.Entity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class SoundsManager {



	public static void playSoundOnSpot(@NotNull Entity entity, SoundEvent soundEvent, SoundCategory soundCategory, float volume, float pitch){
		entity.getWorld().playSound(null, entity.getBlockPos(), soundEvent, soundCategory, volume, pitch);
	}

	public static void playSoundOnSpot(@NotNull Entity entity, SoundEvent soundEvent, SoundCategory soundCategory, float volume){
		entity.getWorld().playSound(null, entity.getBlockPos(), soundEvent, soundCategory, volume, 1f);
	}

	public static void playAmbientSoundOnSpot(@NotNull Entity entity, SoundEvent soundEvent, float volume, float pitch){
		entity.getWorld().playSound(null, entity.getBlockPos(), soundEvent, SoundCategory.AMBIENT, volume, pitch);
	}

	public static void playPlayersSoundOnSpot(@NotNull Entity entity, SoundEvent soundEvent, float volume, float pitch){
		entity.getWorld().playSound(null, entity.getBlockPos(), soundEvent, SoundCategory.PLAYERS, volume, pitch);
	}

	public static void playBlocksSoundOnSpot(World world, BlockPos pos, SoundEvent soundEvent, float volume, float pitch){
		world.playSound(null, pos, soundEvent, SoundCategory.BLOCKS, volume, pitch);
	}

	public static void playPlayersSoundFromPlayer(@NotNull Entity entity, SoundEvent soundEvent, float volume, float pitch){
		entity.getWorld().playSoundFromEntity(null, entity, soundEvent, SoundCategory.PLAYERS, volume, pitch);
	}

	public static void playNeutralSoundOnSpot(@NotNull BlockPos pos, @NotNull World world, SoundEvent soundEvent, float volume, float pitch){
		world.playSound(null, pos, soundEvent, SoundCategory.NEUTRAL, volume, pitch);
	}

	public static void playNeutralSoundFromPlayer(@NotNull Entity entity, SoundEvent soundEvent, float volume, float pitch){
		entity.getWorld().playSoundFromEntity(null, entity, soundEvent, SoundCategory.NEUTRAL, volume, pitch);
	}

	public static void playAmbientSoundOnSpot(@NotNull Entity entity, SoundEvent soundEvent, float volume){
		entity.getWorld().playSound(null, entity.getBlockPos(), soundEvent, SoundCategory.AMBIENT, volume, 1f);
	}

	public static void playPlayersSoundOnSpot(@NotNull Entity entity, SoundEvent soundEvent, float volume){
		entity.getWorld().playSound(null, entity.getBlockPos(), soundEvent, SoundCategory.PLAYERS, volume, 1f);
	}

	public static void playNeutralSoundOnSpot(@NotNull BlockPos pos, @NotNull World world, SoundEvent soundEvent, float volume){
		world.playSound(null, pos, soundEvent, SoundCategory.NEUTRAL, volume, 1f);
	}

	public static void playPlayersSoundFromPlayer(@NotNull Entity entity, SoundEvent soundEvent, float volume){
		entity.getWorld().playSoundFromEntity(null, entity, soundEvent, SoundCategory.PLAYERS, volume, 1f);
	}

	public static void playNeutralSoundFromPlayer(@NotNull Entity entity, SoundEvent soundEvent, float volume){
		entity.getWorld().playSoundFromEntity(null, entity, soundEvent, SoundCategory.NEUTRAL, volume, 1f);
	}

	public static void playBlocksSoundOnSpot(World world, BlockPos pos, SoundEvent soundEvent, float volume){
		world.playSound(null, pos, soundEvent, SoundCategory.BLOCKS, volume, 1f);
	}
}
