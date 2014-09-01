package Gravity;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.network.IGuiHandler;
//import grim3212.mc.core.proxy.CommonProxy;
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;

public abstract class GrimModule
    implements IGuiHandler, IWorldGenerator
{

    public GrimModule()
    {
        versionUrl = (new StringBuilder()).append("https://dl.dropboxusercontent.com/u/37637724/MinecraftModVersions/").append(getModID()).append(".version").toString();
    }

    public abstract String getModID();

    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int i, int j, int k)
    {
        return null;
    }

    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int i, int j, int k)
    {
        return null;
    }

    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        switch(world.provider.dimensionId)
        {
        case -1: 
            generateNether(world, random, chunkX * 16, chunkZ * 16);
            // fall through

        case 0: // '\0'
            generateSurface(world, random, chunkX * 16, chunkZ * 16);
            // fall through

        default:
            return;
        }
    }

    protected void generateSurface(World world1, Random random1, int i, int j)
    {
    }

    protected void generateNether(World world1, Random random1, int i, int j)
    {
    }

    public static CommonProxy proxy;
    protected String versionUrl;
}
