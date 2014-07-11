package com.minecraftargentina.basemod.Biomes;


import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import OblivionDimension.ChunkProviderOblivion;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;




	 public class WorldProviderOblivion implements IWorldGenerator
	 {
	 public void generate(World world, Random random, int x, int y, int z)
	 {
	 //Look at my Custom Instant structure generation tutorial to learn how to generate structures
	 }

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		// TODO Auto-generated method stub
		
	}
	 }