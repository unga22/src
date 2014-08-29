package EspacioExterior;

import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;

public class BiomeHelper
{

 public BiomeHelper()
 {
 }

 public static void init()
 {
     if(init)
     {
         
         return;
     } else
     {
         init = true;
         dungeonBiome = (new BiomeGenBase(99) {

             public boolean func_76738_d()
             {
                 return false;
             }

             public List func_76747_a(EnumCreatureType par1EnumCreatureType)
             {
                 return Lists.newArrayList();
             }

         }
).setBiomeName("Dungeon");
         BiomeDictionary.registerBiomeType(dungeonBiome, new net.minecraftforge.common.BiomeDictionary.Type[] {
             net.minecraftforge.common.BiomeDictionary.Type.MAGICAL
         });
         return;
     }
 }

 public static BiomeGenBase getPocketBiome()
 {
     return dungeonBiome;
 }

 private static BiomeGenBase dungeonBiome;
 static boolean init = false;

}
