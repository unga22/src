package EspacioExterior;


import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenBaseOrbit extends BiomeGenBase
{
	public static final BiomeGenBase space = new BiomeGenBaseOrbit(105).setBiomeName("space");

	@SuppressWarnings("unchecked")
	public BiomeGenBaseOrbit(int var1)
	{
		super(var1);
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.clear();
	//	this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedZombie.class, 10, 4, 4));
	//	this.spawnableMonsterList.add(new SpawnListEntry(EntityEvolvedSpider.class, 10, 4, 4));
		this.rainfall = 0F;
	}

	@Override
	public BiomeGenBaseOrbit setColor(int var1)
	{
		return (BiomeGenBaseOrbit) super.setColor(var1);
	}

	@Override
	public float getSpawningChance()
	{
		return 0.01F;
	}
}