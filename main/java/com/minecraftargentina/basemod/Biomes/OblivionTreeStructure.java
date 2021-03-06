package com.minecraftargentina.basemod.Biomes;

import java.util.Random;



import com.minecraftargentina.basemod.Blocks.CreacionDeBloques;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class OblivionTreeStructure extends WorldGenerator {
    public boolean generate(World world, Random random, int x, int y, int z) {
        while (world.isAirBlock(x, y, z) && y > 2) {
            --y;
        }
        
        if (world.getBlock(x, y, z) == Blocks.dirt || world.getBlock(x, y, z) == Blocks.grass) {
            y++;
            world.setBlock(x, y, z, CreacionDeBloques.ToconBlock, 14, 2); //BASE
            y++;
            world.setBlock(x, y, z, CreacionDeBloques.ToconBlock2, 14, 2); //TRONCO 1
            y++;
            world.setBlock(x, y, z, CreacionDeBloques.ToconBlock3, 14, 2); //TRONCO 2
            y++;
            world.setBlock(x, y, z, CreacionDeBloques.ToconBlock4, 14, 2); //TRONCO 3
            y++;
            world.setBlock(x, y, z, CreacionDeBloques.ToconBlock5, 14, 2); //RAMAS
            y++;
            world.setBlock(x, y, z, CreacionDeBloques.ToconBlock10, 14, 2); //HOJAS
            y++;
            /*
            world.setBlock(x, y, z, CreacionDeBloques.OblivionTreelog, 14, 2);
            y++;
            world.setBlock(x, y, z, CreacionDeBloques.OblivionTreelog, 14, 2);
            y++;
            world.setBlock(x, y, z, CreacionDeBloques.OblivionTreelog, 14, 2);
            y++;
            world.setBlock(x, y, z, CreacionDeBloques.OblivionTreelog, 14, 2);
            world.setBlock(x + 1, y, z, CreacionDeBloques.OblivionTreelog, 14, 2);
            world.setBlock(x - 1, y, z, CreacionDeBloques.OblivionTreelog, 14, 2);
            world.setBlock(x, y, z + 1, CreacionDeBloques.OblivionTreelog, 14, 2);
            world.setBlock(x, y, z - 1, CreacionDeBloques.OblivionTreelog, 14, 2);
            world.setBlock(x + 2, y, z, CreacionDeBloques.OblivionTreeLeaves, random.nextInt(10) + 1, 2);
            world.setBlock(x - 2, y, z, CreacionDeBloques.OblivionTreeLeaves, random.nextInt(10) + 1, 2);
            world.setBlock(x, y, z + 2, CreacionDeBloques.OblivionTreeLeaves, random.nextInt(10) + 1, 2);
            world.setBlock(x, y, z - 2, CreacionDeBloques.OblivionTreeLeaves, random.nextInt(10) + 1, 2);
            world.setBlock(x + 1, y, z + 1, CreacionDeBloques.OblivionTreeLeaves, random.nextInt(10) + 1, 2);
            world.setBlock(x + 1, y, z - 1, CreacionDeBloques.OblivionTreeLeaves, random.nextInt(10) + 1, 2);
            world.setBlock(x - 1, y, z + 1, CreacionDeBloques.OblivionTreeLeaves, random.nextInt(10) + 1, 2);
            world.setBlock(x - 1, y, z - 1, CreacionDeBloques.OblivionTreeLeaves, random.nextInt(10) + 1, 2);
            y++;
            world.setBlock(x, y, z, CreacionDeBloques.OblivionTreelog, 14, 2);
            world.setBlock(x + 1, y, z, CreacionDeBloques.OblivionTreeLeaves, random.nextInt(10) + 1, 2);
            world.setBlock(x - 1, y, z, CreacionDeBloques.OblivionTreeLeaves, random.nextInt(10) + 1, 2);
            world.setBlock(x, y, z + 1, CreacionDeBloques.OblivionTreeLeaves, random.nextInt(10) + 1, 2);
            world.setBlock(x, y, z - 1, CreacionDeBloques.OblivionTreeLeaves, random.nextInt(10) + 1, 2);
            y++;
            world.setBlock(x, y, z, CreacionDeBloques.OblivionTreelog, 14, 2);
            world.setBlock(x + 1, y, z, CreacionDeBloques.OblivionTreelog, 14, 2);
            world.setBlock(x - 1, y, z, CreacionDeBloques.OblivionTreelog, 14, 2);
            world.setBlock(x, y, z + 1, CreacionDeBloques.OblivionTreelog, 14, 2);
            world.setBlock(x, y, z - 1, CreacionDeBloques.OblivionTreelog, 14, 2);
            y++;
            world.setBlock(x + 1, y, z, CreacionDeBloques.OblivionTreeLeaves, random.nextInt(10) + 1, 2);
            world.setBlock(x - 1, y, z, CreacionDeBloques.OblivionTreeLeaves, random.nextInt(10) + 1, 2);
            world.setBlock(x, y, z + 1, CreacionDeBloques.OblivionTreeLeaves, random.nextInt(10) + 1, 2);
            world.setBlock(x, y, z - 1, CreacionDeBloques.OblivionTreeLeaves, random.nextInt(10) + 1, 2);
            y++;
            world.setBlock(x, y, z, CreacionDeBloques.OblivionTreeLeaves, random.nextInt(10) + 1, 2);
            
            **/
            return true;
        } else {
            return false;
        }
    }
}
