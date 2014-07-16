package Prueba.olivecraft;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class OliveGen implements IWorldGenerator
{
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.dimensionId == 0) {
            generateSurface(world, random, chunkX * 16, chunkZ * 16);
        }
    }

    private void generateSurface(World world, Random random, int x, int z) {
        if (random.nextInt(3) == 2 & world.getBiomeGenForCoords(x, z).biomeName.equals("Forest")) {
            int oX = x + random.nextInt(16);
            int oY = 256;
            int oZ = z + random.nextInt(16);
            (new OliveTreeStructure()).generate(world, random, oX, oY, oZ);
        }
    }
}
