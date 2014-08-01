package OblivionDimension;



import java.util.List;
import java.util.Random;









import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.StatisticsFile;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenCactus;
import net.minecraft.world.gen.feature.WorldGenForest;
import net.minecraft.world.gen.feature.WorldGenHugeTrees;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.minecraftargentina.basemod.Biomes.WorldGenOlvidoTree;
import com.minecraftargentina.basemod.Blocks.CreacionDeBloques;
import com.minecraftargentina.basemod.Fluidos.CreacionDeFluidos;

public class BiomeGenTutorial extends BiomeGenBase
{
	
	
public final Material blockMaterial;
private WorldGenerator WorldGenTrees;
private WorldGenerator WorldGenLakes;



private float minHeight;

private float maxHeight;


private WorldGenTrees WorldGenOlvidoTree;
public BiomeGenTutorial(int par1)
{
super(par1);
this.blockMaterial = Material.water;
this.minHeight = 0.1F;
this.maxHeight = 0.6F;
this.spawnableMonsterList.clear();
this.spawnableCreatureList.clear();
this.theBiomeDecorator.treesPerChunk = 25;
this.topBlock = Blocks.grass;
this.fillerBlock = Blocks.dirt;
this.WorldGenOlvidoTree = worldGeneratorTrees;
this.setBiomeName("Tutorial");

/** this changes the water colour, its set to red now but google the java colours **/
this.waterColorMultiplier = 0xE42D17;
}

/**
* Gets a WorldGen appropriate for this biome.
*/



public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
{
return (WorldGenerator)(par1Random.nextInt(5) == 0 ? this.worldGeneratorTrees : (par1Random.nextInt(10) == 0 ? this.WorldGenOlvidoTree : this.worldGeneratorTrees));
}


public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
	switch(world.provider.dimensionId) {
	case 32 :
		//Generate our surface world
		generateSurface(world, random, chunkX*16, chunkZ*16);
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


private void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY) {
	for(int i = 0; i < chanceToSpawn; i++) {
		int posX = blockXPos + random.nextInt(maxX);
		int posY = minY + random.nextInt(maxY - minY);
		int posZ = blockZPos + random.nextInt(maxZ);
		(new WorldGenMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
	}
}

}