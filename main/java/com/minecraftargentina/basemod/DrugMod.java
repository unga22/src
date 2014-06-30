package com.minecraftargentina.basemod;



import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.minecraftargentina.basemod.Blocks.CreacionDeBloques;
import com.minecraftargentina.basemod.Cubos.BucketHandler;
import com.minecraftargentina.basemod.Cubos.CreacionDeCubos;
import com.minecraftargentina.basemod.Maquinas.CreacionDeMaquinas;
import com.minecraftargentina.basemod.lib.ClientProxy;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;



@Mod(modid="drugmod", name="drugmod", version="1.0")
public class DrugMod {

	//modid = CostumeCraft
	public static final String modid = "drugmod";

        // The instance of your mod that Forge uses.
        @Instance("DrugMod")
        public static DrugMod instance;
       
      //Creative tab
        public static CreativeTabs drugTab = new CreativeTabs("drugTab"){
    		public Item getTabIconItem() {
    			return CreacionDeCubos.HotWaterBueketItem;
    		}
    		
    	};
        public static final int hotwaterID = 4051;
        public static final int guiIdChemicalExtractor = 0;

         public static Item CocaSeeds;
         public static Item CocaLeaf;
         public static Item HotWaterBucket;

         public static Block CocaCrop;
         public static Block HotWaterBlock;
         public static Block ChemicalExtractorIdle;
         public static Block ChemicalExtractorActive;
         
         public static Fluid HotWaterFluid;
         
         public static Material HotWaterMaterial;     
         
         public static Potion waterHot;
         




     	@SidedProxy(clientSide = "com.minecraftargentina.basemod.lib.ClientProxy", serverSide = "com.minecraftargentina.basemod.lib.CommonProxy")
     	public static ClientProxy nealeProxy;
 
        
        @EventHandler // used in 1.6.2
        public void preInit(FMLPreInitializationEvent event){ 
        	instance = this;

        	//Potion
        	Potion[] potionTypes = null;

        	for (Field f : Potion.class.getDeclaredFields()) {
        	f.setAccessible(true);
        	try {
        	if (f.getName().equals("potionTypes") || f.getName().equals("field_76425_a")) {
        	Field modfield = Field.class.getDeclaredField("modifiers");
        	modfield.setAccessible(true);
        	modfield.setInt(f, f.getModifiers() & ~Modifier.FINAL);

        	potionTypes = (Potion[])f.get(null);
        	final Potion[] newPotionTypes = new Potion[256];
        	System.arraycopy(potionTypes, 0, newPotionTypes, 0, potionTypes.length);
        	f.set(null, newPotionTypes);
        	}
        	}
        	catch (Exception e) {
        	System.err.println("Severe error, please report this to the mod author:");
        	System.err.println(e);
        	}
        	}
        	
        	Register.addTileEntityRegistrations();
        	
        	Register.addEventRegistrations();
    		NetworkRegistry.INSTANCE.registerGuiHandler( this, new GuiHandler());

        	Register.addNetworkRegistrations();
        	
    		Definer.addFluidDefinitions();
    		
        	Register.addFluidRegistrations();
        	
        	Definer.addBlockDefinitions();
        	
        	Definer.addItemDefinitions();
        	
        	Definer.addPotionDefinitions();
        	
        	BucketHandler.INSTANCE.buckets.put(HotWaterBlock, HotWaterBucket);

        	MinecraftForge.addGrassSeed(new ItemStack(CocaSeeds), 10);
        	
        	Register.addBlockRegistrations();
        	
        	Register.addItemRegistrations();

        	
        }
        

		@EventHandler
        public void load(FMLInitializationEvent event) {
                nealeProxy.registerRenderThings();
                

        }      

}
