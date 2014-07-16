package com.minecraftargentina.basemod;


import java.util.Random;

import com.minecraftargentina.basemod.Blocks.CreacionDeBloques;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class OblivionWorldGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId) {
		case 0 :
			//Generate our surface world
			generateSurface(world, random, chunkX*16, chunkZ*16);

		case -1 :
			//Generate our surface world
			generateNether(world, random, chunkX*16, chunkZ*16);

		case 1 :
			//Generate our surface world
			generateEnd(world, random, chunkX*16, chunkZ*16);
			
		case 32 :
			//Generate our surface world
			generateEnd(world, random, chunkX*16, chunkZ*16);
		}

	}

	private void generateSurface(World world, Random random, int x, int z) {
		//this.addOreSpawn(Nealecraft.oreWhatever, world, random, i=blockXPos, j= blockZPos, maxX, maxZ, maxVeinSize, chancetospawn, minY, maxY); 
		this.addOreSpawn(CreacionDeBloques.oreCopperOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 25, 38, 100);
		this.addOreSpawn(CreacionDeBloques.oreTinOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 25, 38, 100);
		this.addOreSpawn(CreacionDeBloques.oreZincOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 25, 38, 100);
		this.addOreSpawn(CreacionDeBloques.oreNickelOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 25, 38, 100);
		this.addOreSpawn(CreacionDeBloques.oreManganeseOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 25, 38, 100);
		this.addOreSpawn(CreacionDeBloques.oreVanadiumOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 25, 38, 100);
		this.addOreSpawn(CreacionDeBloques.oreTopazOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 25, 38, 100);

	}

	private void generateNether(World world, Random random, int x, int z) {
		// TODO Auto-generated method stub
		this.addNetherOreSpawn(CreacionDeBloques.oreNetherCopperOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 25, 38, 100);
		this.addNetherOreSpawn(CreacionDeBloques.oreNetherTinOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 25, 38, 100);
		this.addNetherOreSpawn(CreacionDeBloques.oreNetherZincOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 25, 38, 100);
		this.addNetherOreSpawn(CreacionDeBloques.oreNetherNickelOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 25, 38, 100);
		this.addNetherOreSpawn(CreacionDeBloques.oreNetherManganeseOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 25, 38, 100);
		this.addNetherOreSpawn(CreacionDeBloques.oreNetherVanadiumOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 25, 38, 100);
		this.addNetherOreSpawn(CreacionDeBloques.oreNetherTopazOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 25, 38, 100);
	}

	private void generateEnd(World world, Random random, int x, int z) {
		// TODO Auto-generated method stub

	}

	private void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY) {
		for(int i = 0; i < chanceToSpawn; i++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(maxY - minY);
			int posZ = blockZPos + random.nextInt(maxZ);
			(new WorldGenMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
		}
	}

	private void addNetherOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY) {
		for(int i = 0; i < chanceToSpawn; i++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(maxY - minY);
			int posZ = blockZPos + random.nextInt(maxZ);
			(new WorldGenNetherMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
		}
	}
}