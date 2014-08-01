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
	       this.worldChunkMgr = new WorldChunkManagerHell(BaseMod.BiomeGenTutorial, 0.8F);
	       this.dimensionId = BaseMod.DimID;
	       
	}
	
	public IChunkProvider createChunkGenerator()
	{
	       return new OblivionDimension.ChunkProviderOblivion2(worldObj, worldObj.getSeed(), true);
	}


}