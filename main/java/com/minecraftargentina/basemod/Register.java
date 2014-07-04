package com.minecraftargentina.basemod;

import com.minecraftargentina.basemod.Cubos.BucketHandler;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class Register {

	public static void addFluidRegistrations(){
		DrugMod m = new DrugMod();

	}

	public static void addTileEntityRegistrations(){
		DrugMod m = new DrugMod();

	    GameRegistry.registerTileEntity(TileEntityChemicalExtractor.class, "Chemical Extractor");

	}

	public static void addEventRegistrations(){
		DrugMod m = new DrugMod();

    	MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);

    }

	public static void addNetworkRegistrations(){
		DrugMod m = new DrugMod();

    }

	public static void addBlockRegistrations(){
		DrugMod m = new DrugMod();

    	
		GameRegistry.registerBlock(m.ChemicalExtractorIdle, "ChemicalExtractorIdle");
		GameRegistry.registerBlock(m.ChemicalExtractorActive, "ChemicalExtractorActive");

    }

	public static void addItemRegistrations(){
		DrugMod m = new DrugMod();

    	

    }


}