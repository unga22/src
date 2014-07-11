package OblivionDimension;

import java.util.List;

import com.minecraftargentina.basemod.Biomes.WorldGenOlvidoTree;
import com.minecraftargentina.basemod.Blocks.CreacionDeBloques;

import cpw.mods.fml.common.eventhandler.Event.Result;
import scala.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.NoiseGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.MapGenScatteredFeature;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;


public abstract class ChunkProviderOblivion implements IChunkProvider {

	private java.util.Random rand;
	private NoiseGeneratorOctaves noiseGen1, noiseGen2, noiseGen3, noiseGen5, noiseGen6;
	private NoiseGeneratorPerlin noiseGen4;
	private World worldObj;
	private final boolean mapFeaturesEnabled;
	private WorldType type;
	private final double[] da;
	private final float[] parabolicField;
	private double[] stoneNoise = new double[256];
	private MapGenBase caveGenerator = new MapGenBase();
	private MapGenVillage villageGenerator = new MapGenVillage();
	private MapGenScatteredFeature scatteredFeatureGenerator = new MapGenScatteredFeature();
	private BiomeGenBase[] biomesForGeneration;
	double[] gen1, gen2, gen3, gen4;
	int[][] ia = new int[32][32];
	public WorldGenerator coalGen, emeraldGen, diamondGen, ironGen, lapisGen, goldGen, redstoneGen;

	{caveGenerator = TerrainGen.getModdedMapGen(caveGenerator, null); villageGenerator = (MapGenVillage) TerrainGen.getModdedMapGen(villageGenerator, null);
		scatteredFeatureGenerator = (MapGenScatteredFeature) TerrainGen.getModdedMapGen(scatteredFeatureGenerator, null);}    

	public ChunkProviderOblivion(World par1World, long par2, boolean par4) {
		this.worldObj = par1World;
		this.mapFeaturesEnabled = par4;
		this.type = par1World.getWorldInfo().getTerrainType();
		this.rand = new java.util.Random(par2);
		this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
		this.noiseGen4 = new NoiseGeneratorPerlin(this.rand, 4);
		this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
		this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
		this.da = new double[825];
		this.parabolicField = new float[25];
		
		/*lapisGen = new WorldGenMinable(BlockHelper.Lapis, 4, BlockHelper.flylightStone);
		coalGen = new WorldGenMinable(BlockHelper.Coal, 4, BlockHelper.flylightStone);
		emeraldGen = new WorldGenMinable(BlockHelper.Emerald, 4, BlockHelper.flylightStone);
		diamondGen = new WorldGenMinable(BlockHelper.Diamond, 4, BlockHelper.flylightStone);
		ironGen = new WorldGenMinable(BlockHelper.Iron, 4, BlockHelper.flylightStone);
		goldGen = new WorldGenMinable(BlockHelper.Gold, 4, BlockHelper.flylightStone);
		redstoneGen = new WorldGenMinable(BlockHelper.Redstone, 4, BlockHelper.flylightStone);
		
		*/

		for(int j = -2; j <= 2; ++j) {
			for(int k = -2; k <= 2; ++k) {
				float f = 10.0F / MathHelper.sqrt_float((float)(j * j + k * k) + 0.2F);
				this.parabolicField[j + 2 + (k + 2) * 5] = f;
			}
		}

		NoiseGenerator[] noiseGens = {noiseGen1, noiseGen2, noiseGen3, noiseGen4, noiseGen5, noiseGen6};
		noiseGens = TerrainGen.getModdedNoiseGenerators(par1World, this.rand, noiseGens);
		this.noiseGen1 = (NoiseGeneratorOctaves)noiseGens[0];
		this.noiseGen2 = (NoiseGeneratorOctaves)noiseGens[1];
		this.noiseGen3 = (NoiseGeneratorOctaves)noiseGens[2];
		this.noiseGen4 = (NoiseGeneratorPerlin)noiseGens[3];
		this.noiseGen5 = (NoiseGeneratorOctaves)noiseGens[4];
		this.noiseGen6 = (NoiseGeneratorOctaves)noiseGens[5];
	}

	public void generate(int i, int j, Block[] b) {
		byte b0 = 63;
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, i * 4 - 2, j * 4 - 2, 10, 10);
		this.generate(i * 4, 0, j * 4);

		for(int k = 0; k < 4; ++k) {
			int l = k * 5;
			int i1 = (k + 1) * 5;

			for(int j1 = 0; j1 < 4; ++j1) {
				int k1 = (l + j1) * 33;
				int l1 = (l + j1 + 1) * 33;
				int i2 = (i1 + j1) * 33;
				int j2 = (i1 + j1 + 1) * 33;

				for(int k2 = 0; k2 < 32; ++k2) {
					double d0 = 0.125D;
					double d1 = this.da[k1 + k2];
					double d2 = this.da[l1 + k2];
					double d3 = this.da[i2 + k2];
					double d4 = this.da[j2 + k2];
					double d5 = (this.da[k1 + k2 + 1] - d1) * d0;
					double d6 = (this.da[l1 + k2 + 1] - d2) * d0;
					double d7 = (this.da[i2 + k2 + 1] - d3) * d0;
					double d8 = (this.da[j2 + k2 + 1] - d4) * d0;

					for(int l2 = 0; l2 < 8; ++l2) {
						double d9 = 0.25D;
						double d10 = d1;
						double d11 = d2;
						double d12 = (d3 - d1) * d9;
						double d13 = (d4 - d2) * d9;

						for(int i3 = 0; i3 < 4; ++i3) {
							int j3 = i3 + k * 4 << 12 | 0 + j1 * 4 << 8 | k2 * 8 + l2;
							short short1 = 256;
							j3 -= short1;
							double d14 = 0.25D;
							double d16 = (d11 - d10) * d14;
							double d15 = d10 - d16;

							for(int k3 = 0; k3 < 4; ++k3) {
								if((d15 += d16) > 0.0D) 
									b[j3 += short1] = Blocks.stone;

								else if(k2 * 8 + l2 < b0) 
									b[j3 += short1] = Blocks.water;
								else 
									b[j3 += short1] = null;

							}

							d10 += d12;
							d11 += d13;
						}

						d1 += d5;
						d2 += d6;
						d3 += d7;
						d4 += d8;
					}
				}
			}
		}
	}

	public void replaceBlocksForBiome(int i, int j, Block[] ba, byte[] by, BiomeGenBase[] b) {
		ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks(this, i, j, ba, b);
		MinecraftForge.EVENT_BUS.post(event);
		if(event.getResult() == Result.DENY) return;

		double d0 = 0.03125D;
		this.stoneNoise = this.noiseGen4.func_151599_a(this.stoneNoise, (double)(i * 16), (double)(j * 16), 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);

		for(int k = 0; k < 16; ++k) {
			for(int l = 0; l < 16; ++l) {
				BiomeGenBase biomegenbase = b[l + k * 16];
				biomegenbase.genTerrainBlocks(this.worldObj, this.rand, ba, by, i * 16 + k, j * 16 + l, this.stoneNoise[l + k * 16]);
			}
		}
	}

	@Override
	public Chunk loadChunk(int par1, int par2) {
		return this.provideChunk(par1, par2);
	}

	@Override
	public Chunk provideChunk(int par1, int par2) {
		this.rand.setSeed((long)par1 * 341873128712L + (long)par2 * 132897987541L);
		Block[] ablock = new Block[65536];
		byte[] abyte = new byte[65536];
		this.generate(par1, par2, ablock);
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, par1 * 16, par2 * 16, 16, 16);
		this.replaceBlocksForBiome(par1, par2, ablock, abyte, this.biomesForGeneration);
		this.caveGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);

		if(this.mapFeaturesEnabled) {
			this.villageGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
			this.scatteredFeatureGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
		}
		Chunk chunk = new Chunk(this.worldObj, ablock, abyte, par1, par2);
		byte[] abyte1 = chunk.getBiomeArray();

		for(int k = 0; k < abyte1.length; ++k) 
			abyte1[k] = (byte)this.biomesForGeneration[k].biomeID;

		chunk.generateSkylightMap();
		return chunk;
	}

	private void generate(int x, int y, int z) {
		double d0 = 684.412D;
		double d1 = 684.412D;
		double d2 = 512.0D;
		double d3 = 512.0D;
		this.gen4 = this.noiseGen6.generateNoiseOctaves(this.gen4, x, z, 5, 5, 200.0D, 200.0D, 0.5D);
		this.gen1 = this.noiseGen3.generateNoiseOctaves(this.gen1, x, y, z, 5, 33, 5, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D);
		this.gen2 = this.noiseGen1.generateNoiseOctaves(this.gen2, x, y, z, 5, 33, 5, 684.412D, 684.412D, 684.412D);
		this.gen3 = this.noiseGen2.generateNoiseOctaves(this.gen3, x, y, z, 5, 33, 5, 684.412D, 684.412D, 684.412D);
		boolean flag1 = false;
		boolean flag = false;
		int l = 0;
		int i1 = 0;
		double d4 = 8.5D;

		for(int j1 = 0; j1 < 5; ++j1) {
			for(int k1 = 0; k1 < 5; ++k1) {
				float f = 0.0F;
				float f1 = 0.0F;
				float f2 = 0.0F;
				byte b0 = 2;
				BiomeGenBase biomegenbase = this.biomesForGeneration[j1 + 2 + (k1 + 2) * 10];

				for(int l1 = -b0; l1 <= b0; ++l1) {
					for(int i2 = -b0; i2 <= b0; ++i2) {
						BiomeGenBase biomegenbase1 = this.biomesForGeneration[j1 + l1 + 2 + (k1 + i2 + 2) * 10];
						float f3 = biomegenbase1.rootHeight;
						float f4 = biomegenbase1.heightVariation;

						if(this.type == WorldType.AMPLIFIED && f3 > 0.0F) {
							f3 = 1.0F + f3 * 2.0F;
							f4 = 1.0F + f4 * 4.0F;
						}

						float f5 = this.parabolicField[l1 + 2 + (i2 + 2) * 5] / (f3 + 2.0F);

						if(biomegenbase1.rootHeight > biomegenbase.rootHeight)
							f5 /= 2.0F;

						f += f4 * f5;
						f1 += f3 * f5;
						f2 += f5;
					}
				}

				f /= f2;
				f1 /= f2;
				f = f * 0.9F + 0.1F;
				f1 = (f1 * 4.0F - 1.0F) / 8.0F;
				double d12 = this.gen4[i1] / 8000.0D;

				if(d12 < 0.0D) {
					d12 = -d12 * 0.3D;
				}

				d12 = d12 * 3.0D - 2.0D;

				if(d12 < 0.0D) {
					d12 /= 2.0D;

					if(d12 < -1.0D) 
						d12 = -1.0D;

					d12 /= 1.4D;
					d12 /= 2.0D;
				} else {
					if(d12 > 1.0D) 
						d12 = 1.0D;

					d12 /= 8.0D;
				}

				++i1;
				double d13 = (double)f1;
				double d14 = (double)f;
				d13 += d12 * 0.2D;
				d13 = d13 * 8.5D / 8.0D;
				double d5 = 8.5D + d13 * 4.0D;

				for(int j2 = 0; j2 < 33; ++j2) {
					double d6 = ((double)j2 - d5) * 12.0D * 128.0D / 256.0D / d14;

					if(d6 < 0.0D) 
						d6 *= 4.0D;


					double d7 = this.gen2[l] / 512.0D;
					double d8 = this.gen3[l] / 512.0D;
					double d9 = (this.gen1[l] / 10.0D + 1.0D) / 2.0D;
					double d10 = MathHelper.denormalizeClamp(d7, d8, d9) - d6;

					if(j2 > 29) {
						double d11 = (double)((float)(j2 - 29) / 3.0F);
						d10 = d10 * (1.0D - d11) + -10.0D * d11;
					}

					this.da[l] = d10;
					++l;
				}
			}
		}
	}

	@Override
	public boolean chunkExists(int par1, int par2) {
		return true;
	}

	@Override
	public void populate(IChunkProvider par1IChunkProvider, int par2, int par3) {
		int var4 = par2 * 16;
		int var5 = par3 * 16;
		BlockFalling.fallInstantly = true;
		BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(var4 + 16, var5 + 16);
		this.rand.setSeed(this.worldObj.getSeed());
		long p1 = this.rand.nextLong() / 2L * 2L + 1L;
		long j1 = this.rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed((long)par2 * p1 + (long)par3 * j1 ^ this.worldObj.getSeed());
		boolean flag = false;
		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(par1IChunkProvider, worldObj, rand, par2, par3, flag));
		int j, var12, var13, var14;
		if(this.mapFeaturesEnabled) {
			flag = this.villageGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
			this.scatteredFeatureGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
		}

		if(rand.nextInt(8) == 0) {
			int var18 = var4 + rand.nextInt(16) + 8;
			int var19 = rand.nextInt(128);
			int var20 = var4 + rand.nextInt(16) + 8;

			if(var19 < 63 || rand.nextInt(10) == 0) {
				(new WorldGenLakes(Blocks.water)).generate(worldObj, rand, var18, var19, var20);
			}
		}

		for(j = 0; j < 13; j++){
			var12 = var4 + rand.nextInt(16);
			var13 = rand.nextInt(250);
			var14 = var5 + rand.nextInt(16);
			coalGen.generate(worldObj, rand, var12, var13, var14);
		}

		for(int i = 0; i < 20; i++){
			var12 = var4 + this.rand.nextInt(16);
			var13 = this.rand.nextInt(300);
			var14 = var5 + this.rand.nextInt(16);
			(new WorldGenMinable(CreacionDeBloques.oreCopperOre, 6, CreacionDeBloques.oreManganeseOre)).generate(worldObj, rand, var12, var13, var14);
		}

		for(j = 0; j < 8; j++){
			var12 = var4 + rand.nextInt(16);
			var13 = rand.nextInt(200);
			var14 = var5 + rand.nextInt(16);
			ironGen.generate(worldObj, rand, var12, var13, var14);
		}

		for(j = 0; j < 6; j++){
			var12 = var4 + rand.nextInt(16);
			var13 = rand.nextInt(100);
			var14 = var5 + rand.nextInt(16);
			goldGen.generate(worldObj, rand, var12, var13, var14);
		}

		for(j = 0; j < 5; j++){
			var12 = var4 + rand.nextInt(16);
			var13 = rand.nextInt(50);
			var14 = var5 + rand.nextInt(16);
			diamondGen.generate(worldObj, rand, var12, var13, var14);
		}

		for(j = 0; j < 8; j++){
			var12 = var4 + rand.nextInt(16);
			var13 = rand.nextInt(60);
			var14 = var5 + rand.nextInt(16);
			redstoneGen.generate(worldObj, rand, var12, var13, var14);
		}

		for(j = 0; j < 5; j++){
			var12 = var4 + rand.nextInt(16);
			var13 = rand.nextInt(50);
			var14 = var5 + rand.nextInt(16);
			emeraldGen.generate(worldObj, rand, var12, var13, var14);
		}

		for(j = 0; j < 4; j++){
			var12 = var4 + rand.nextInt(16);
			var13 = rand.nextInt(50);
			var14 = var5 + rand.nextInt(16);
			lapisGen.generate(worldObj, rand, var12, var13, var14);
		}

		WorldGenOlvidoTree var17 = new WorldGenOlvidoTree(CreacionDeBloques.blockLog, CreacionDeBloques.blockLeaf, j, par2, false, 4, 3, false);
		int var19, var18, var21, var20, i, xMin = par2 << 4, zMin = par3 << 4;

		int startX = xMin + rand.nextInt(16), startZ = zMin + rand.nextInt(16);

		int tries = rand.nextInt(2), x = startX + rand.nextInt(8) - rand.nextInt(8), z = startZ + rand.nextInt(8) - rand.nextInt(8), y = worldObj.getHeightValue(x, z);

		for(var18 = 0; var18 < 1; ++var18) {
			var19 = var4 + this.rand.nextInt(16);
			var20 = var5 + this.rand.nextInt(16);
			var21 = this.worldObj.getHeightValue(var19, var20);
			var17.generate(this.worldObj, this.rand, var19, var21, var20);
		}

		for(i = 0; i < 60; i++) { 
			if((worldObj.isAirBlock(x, y, z) || Blocks.red_flower.canBlockStay(worldObj, x, y, z))) {
				if(rand.nextInt(50) > 1)
					continue;
				worldObj.setBlock(x, y, z, Blocks.red_flower, 0, 0);
			}
		}

		for(i = 0; i < 60; i++) {
			if((worldObj.isAirBlock(x, y, z) ||  Blocks.red_flower.canBlockStay(worldObj, x, y, z))) {
				if(rand.nextInt(50) > 1)
					continue;
				worldObj.setBlock(x, y, z,  Blocks.red_flower, 0, 0);
			}
		}

		for(i = 0; i < 70; i++) {
			if((worldObj.isAirBlock(x, y, z) || Blocks.grass.canBlockStay(worldObj, x, y, z))) {
				if(rand.nextInt(50) > 1)
					continue;
				worldObj.setBlock(x, y, z, Blocks.grass, 0, 0);
			}
		}

		for(i = 0; i < 80; i++) {          
			if((worldObj.isAirBlock(x, y, z) || Blocks.bedrock.canBlockStay(worldObj, x, y, z))) {
				if(rand.nextInt(50) > 1)
					continue;
				worldObj.setBlock(x, y, z, Blocks.bedrock, 0, 0);
			}
		}

		biomegenbase.decorate(this.worldObj, this.rand, var4, var5);

		if(TerrainGen.populate(par1IChunkProvider, worldObj, rand, par2, par3, flag, null)) 
			SpawnerAnimals.performWorldGenSpawning(this.worldObj, biomegenbase, var4 + 8, var5 + 8, 16, 16, this.rand);

		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(par1IChunkProvider, worldObj, rand, par2, par3, flag));
		BlockFalling.fallInstantly = false;
	}

	@Override
	public boolean saveChunks(boolean par1, IProgressUpdate par2IProgressUpdate) {
		return true;
	}

	@Override
	public void saveExtraData() { }

	@Override
	public boolean unloadQueuedChunks() {
		return false;
	}

	@Override
	public boolean canSave() {
		return true;
	}

	@Override
	public String makeString() {
		return "RandomLevelSource";
	}

	@Override
	public List getPossibleCreatures(EnumCreatureType par1EnumCreatureType, int par2, int par3, int par4) {
		BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(par2, par4);
		return par1EnumCreatureType == EnumCreatureType.monster && this.scatteredFeatureGenerator.func_143030_a(par2, par3, par4) ? this.scatteredFeatureGenerator.getScatteredFeatureSpawnList() : biomegenbase.getSpawnableList(par1EnumCreatureType);
	}

	@Override
	public ChunkPosition func_147416_a(World p_147416_1_, String p_147416_2_, int p_147416_3_, int p_147416_4_, int p_147416_5_) {
		return null;
	}

	@Override
	public int getLoadedChunkCount() {
		return 0;
	}

	@Override
	public void recreateStructures(int par1, int par2) {
		if(this.mapFeaturesEnabled) {
			this.villageGenerator.func_151539_a(this, this.worldObj, par1, par2, (Block[])null);
			this.scatteredFeatureGenerator.func_151539_a(this, this.worldObj, par1, par2, (Block[])null);
		}
	}
}