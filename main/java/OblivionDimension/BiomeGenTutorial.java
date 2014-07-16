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
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenForest;
import net.minecraft.world.gen.feature.WorldGenHugeTrees;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import com.minecraftargentina.basemod.Biomes.WorldGenOlvidoTree;

public class BiomeGenTutorial extends BiomeGenBase
{
public final Material blockMaterial;


private Object worldGeneratorTutorialBigTree;

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
}