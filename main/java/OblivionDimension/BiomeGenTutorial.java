package OblivionDimension;



import java.util.List;
import java.util.Random;

import com.minecraftargentina.basemod.Biomes.WorldGenOlvidoTree;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenHugeTrees;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;


public class BiomeGenTutorial extends BiomeGenBase
{
public final Material blockMaterial;

private WorldGenerator WorldGenTutorialTrees;
private Object worldGeneratorTutorialBigTree;

private float minHeight;

private float maxHeight;

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
this.WorldGenTutorialTrees = worldGeneratorBigTree;
this.setBiomeName("OblivionBiome");

/** this changes the water colour, its set to red now but google the java colours **/
this.waterColorMultiplier = 0xE42D17;
}

/**
* Gets a WorldGen appropriate for this biome.
*/
public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
{
return (WorldGenerator)(par1Random.nextInt(5) == 0 ? this.WorldGenTutorialTrees : (par1Random.nextInt(10) == 0 ? this.WorldGenTutorialTrees : this.worldGeneratorTrees));
}
}