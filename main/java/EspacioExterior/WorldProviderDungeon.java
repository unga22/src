package EspacioExterior;



import com.minecraftargentina.basemod.BaseMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;
 
public class WorldProviderDungeon extends WorldProvider {	
	
	
	public WorldProviderDungeon() {
	      super();
	            
	      // Setup parameters
	      hasNoSky = true;
	   }
	
    public void registerWorldChunkManager()
    {
        this.worldChunkMgr = new WorldChunkManagerHell(BaseMod.BiomeGenBaseOrbit, 0.1F);
        this.dimensionId = BaseMod.DimID0;
        
    }
    
    public IChunkProvider createChunkGenerator()
    {
       return new ChunkProviderDungeon(worldObj, worldObj.getSeed(), true);
    }
    
    public float getGravity()
	{
		return 0.072F;
	}
    
    @Override
    @SideOnly(Side.CLIENT)
    public float getStarBrightness(float par1) {
       
        return 1.0F;
    
    }
    
    @SideOnly(Side.CLIENT)
    public float calculateCelestialAngle(long par1, float par3) {
       
        return 0.90F;
        
    }
    
    
    @Override
    protected void generateLightBrightnessTable() {
    	
    	float f = 0.1F;
		for(int i = 0; i <= 15; ++i) {
			float f1 = 1.0F - (float) i / 15.0F;
			this.lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
            
        }
        
    }
    
    
    @Override
    @SideOnly(Side.CLIENT)
    public IRenderHandler getSkyRenderer() {
       
            return new SpaceSkyRender3();
            
    }
    
    
    @Override
    @SideOnly(Side.CLIENT)
    public Vec3 getSkyColor(Entity cameraEntity, float partialTicks) {
       
       // Return pitch Black
       return this.worldObj.getWorldVec3Pool().getVecFromPool(0, 0, 0);

    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public float getCloudHeight() {
       
        return 256.0f;
        
    }
    
    @Override
    public String getDimensionName()
    {
        return "Space";
    }
}
