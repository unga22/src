package OblivionDimension;



import com.minecraftargentina.basemod.BaseMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderOblivion extends WorldProvider{

	@Override
	public String getDimensionName() {

		return "Oblivion";
	}
	
	public void registerWorldChunkManager()
	{
	       this.worldChunkMgr = new WorldChunkManagerHell(BaseMod.oblivionDesert, 0.8F);
	       this.dimensionId = BaseMod.DimID;
	       
	}
	
	public IChunkProvider createChunkGenerator()
	{
	       return new OblivionDimension.ChunkProviderOblivion2(worldObj, worldObj.getSeed(), true);
	}
	
	 /**
     * Creates the light to brightness table
     */
    @Override
    protected void generateLightBrightnessTable()
    {
        float f = 0.0F;

        for (int i = 0; i <= 15; ++i)
        {
        	float scaledBrightness = i / 15.0F;
            float f1 = 1.0F - scaledBrightness;
            if(i < 5)
            	this.lightBrightnessTable[i] = 0.5F * scaledBrightness / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
            else
            	this.lightBrightnessTable[i] = scaledBrightness / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
            	
            
        }
    }
	
	
    @Override
    public float calculateCelestialAngle(long par1, float par3)
    {
        int j = (int)(par1 % 48000L);
        float f1 = ((float)j + par3) / 48000.0F - 0.25F;

        if (f1 < 0.0F)
        {
            ++f1;
        }

        if (f1 > 1.0F)
        {
            --f1;
        }

        float f2 = f1;
        f1 = 1.0F - (float)((Math.cos((double)f1 * Math.PI) + 1.0D) / 2.0D);
        f1 = f2 + (f1 - f2) / 3.0F;
        return f1;
        //return (float) Math.sin(f2);
        //return 1F;
    }
    
    @SideOnly(Side.CLIENT)
    /**
     * Return Vec3D with biome specific fog color
     */
    @Override
    public Vec3 getFogColor(float par1, float par2)
    {
        float f2 = MathHelper.cos(par1 * (float)Math.PI * 2.0F) * 2.0F + 0.5F;

        if (f2 < 0.2F)
        {
            f2 = 0.2F;
        }

        if (f2 > 1.0F)
        {
            f2 = 1.0F;
        }
        
        float f3 = 0.7529412F;
        float f4 = 0.84705883F;
        float f5 = 1.0F;
        f3 *= f2 * 0.94F + 0.06F;
        f4 *= f2 * 0.94F + 0.06F;
        f5 *= f2 * 0.91F + 0.09F;
        f3 = 0.9F * f2;
        f4 = 0.75F * f2;
        f5 = 0.6F * f2;
        return this.worldObj.getWorldVec3Pool().getVecFromPool((double)f3, (double)f4, (double)f5);
    }
    
    @Override
    public boolean doesXZShowFog(int par1, int par2)
    {
    	return false;
    }
    
    @Override
    public String getWelcomeMessage()
    {
    	return "Entrando al Oblivion";
    }
    
    @Override
    public String getDepartMessage()
    {
    	return "Saliendo del Oblivion";
    }

}