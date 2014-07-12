package OblivionDimension;



import com.minecraftargentina.basemod.BaseMod;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderOblivion extends WorldProvider{

	@Override
	public String getDimensionName() {
		// TODO Auto-generated method stub
		return("DimenisonShiftBasicDimenison");
	}
	
	public void registerWorldChunkManager()
	{
	       this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.desertHills, 0.8F);
	       this.dimensionId = BaseMod.DimID;
	       
	}
	
	public IChunkProvider createChunkGenerator()
	{
	       return new OblivionDimension.ChunkProviderOblivion2(worldObj, worldObj.getSeed(), true);
	}
	

}