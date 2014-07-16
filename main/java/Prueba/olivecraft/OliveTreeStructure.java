package Prueba.olivecraft;

import java.util.Random;


import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class OliveTreeStructure extends WorldGenerator {
    public boolean generate(World world, Random random, int x, int y, int z) {
        while (world.isAirBlock(x, y, z) && y > 2) {
            --y;
        }
        
        if (world.getBlock(x, y, z) == Blocks.dirt || world.getBlock(x, y, z) == Blocks.grass) {
            y++;
            world.setBlock(x, y, z, OliveBlocks.oliveLog, 14, 2);
            y++;
            world.setBlock(x, y, z, OliveBlocks.oliveLog, 14, 2);
            y++;
            world.setBlock(x, y, z, OliveBlocks.oliveLog, 14, 2);
            world.setBlock(x + 1, y, z, OliveBlocks.oliveLog, 14, 2);
            world.setBlock(x - 1, y, z, OliveBlocks.oliveLog, 14, 2);
            world.setBlock(x, y, z + 1, OliveBlocks.oliveLog, 14, 2);
            world.setBlock(x, y, z - 1, OliveBlocks.oliveLog, 14, 2);
            world.setBlock(x + 2, y, z, OliveBlocks.oliveLeaves, random.nextInt(10) + 1, 2);
            world.setBlock(x - 2, y, z, OliveBlocks.oliveLeaves, random.nextInt(10) + 1, 2);
            world.setBlock(x, y, z + 2, OliveBlocks.oliveLeaves, random.nextInt(10) + 1, 2);
            world.setBlock(x, y, z - 2, OliveBlocks.oliveLeaves, random.nextInt(10) + 1, 2);
            world.setBlock(x + 1, y, z + 1, OliveBlocks.oliveLeaves, random.nextInt(10) + 1, 2);
            world.setBlock(x + 1, y, z - 1, OliveBlocks.oliveLeaves, random.nextInt(10) + 1, 2);
            world.setBlock(x - 1, y, z + 1, OliveBlocks.oliveLeaves, random.nextInt(10) + 1, 2);
            world.setBlock(x - 1, y, z - 1, OliveBlocks.oliveLeaves, random.nextInt(10) + 1, 2);
            y++;
            world.setBlock(x, y, z, OliveBlocks.oliveLog, 14, 2);
            world.setBlock(x + 1, y, z, OliveBlocks.oliveLeaves, random.nextInt(10) + 1, 2);
            world.setBlock(x - 1, y, z, OliveBlocks.oliveLeaves, random.nextInt(10) + 1, 2);
            world.setBlock(x, y, z + 1, OliveBlocks.oliveLeaves, random.nextInt(10) + 1, 2);
            world.setBlock(x, y, z - 1, OliveBlocks.oliveLeaves, random.nextInt(10) + 1, 2);
            y++;
            world.setBlock(x, y, z, OliveBlocks.oliveLeaves, random.nextInt(10) + 1, 2);
            return true;
        } else {
            return false;
        }
    }
}
