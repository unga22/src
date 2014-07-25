package com.minecraftargentina.basemod.lib;


import Models.RenderArbolBase;
import Models.RenderToconBlock;
import Models.RenderToconBlock2;
import Models.RenderToconBlock3;
import Models.RenderToconBlock4;
import Models.RenderToconBlock5;
import Models.RenderToconBlock6;
import Models.RenderToconBlock7;
import Models.RenderToconBlock8;
import Models.TileEntityArbolTocon4;
import Models.TileEntityArbolTocon5;
import Models.TileEntityArbolTocon6;
import Models.TileEntityArbolTocon7;
import Models.TileEntityArbolTocon8;

import com.minecraftargentina.basemod.BaseMod;
import com.minecraftargentina.basemod.EntityCyclops;
import com.minecraftargentina.basemod.ModelCyclops;
import com.minecraftargentina.basemod.RenderCyclops;
import com.minecraftargentina.basemod.RenderObsidianTable;
import com.minecraftargentina.basemod.TileEntityObsidianTable;
import com.minecraftargentina.basemod.Blocks.CreacionDeBloques;
import com.minecraftargentina.basemod.Blocks.TileEntityArbolBase;
import com.minecraftargentina.basemod.Blocks.TileEntityArbolTocon;
import com.minecraftargentina.basemod.Blocks.TileEntityArbolTocon2;
import com.minecraftargentina.basemod.Blocks.TileEntityArbolTocon3;
import com.minecraftargentina.basemod.Items.ItemRenderObsidianTable;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	public void registerRenderThings() {
		
		//ObsidianTable
		TileEntitySpecialRenderer render = new RenderObsidianTable();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityObsidianTable.class, render);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(CreacionDeBloques.blockObsidianTable), new ItemRenderObsidianTable(render, new TileEntityObsidianTable()));

		//ArbolBase
		TileEntitySpecialRenderer render1 = new RenderArbolBase();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityArbolBase.class, render1);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(CreacionDeBloques.ArbolBaseBlock), new ItemRenderArbolBase(render1, new TileEntityArbolBase()));
		
		//ToconBlock
				TileEntitySpecialRenderer render2 = new RenderToconBlock();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityArbolTocon.class, render2);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(CreacionDeBloques.ToconBlock), new ItemRenderTocon(render2, new TileEntityArbolTocon()));
		
		//ToconBlock2
				TileEntitySpecialRenderer render3 = new RenderToconBlock2();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityArbolTocon2.class, render3);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(CreacionDeBloques.ToconBlock2), new ItemRenderTocon2(render3, new TileEntityArbolTocon2()));
				
		//ToconBlock3
				TileEntitySpecialRenderer render4 = new RenderToconBlock3();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityArbolTocon3.class, render4);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(CreacionDeBloques.ToconBlock3), new ItemRenderTocon3(render4, new TileEntityArbolTocon3()));
		//ToconBlock4
				TileEntitySpecialRenderer render5 = new RenderToconBlock4();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityArbolTocon4.class, render5);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(CreacionDeBloques.ToconBlock4), new ItemRenderTocon4(render5, new TileEntityArbolTocon4()));
		//Rama1
				TileEntitySpecialRenderer render6 = new RenderToconBlock5();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityArbolTocon5.class, render6);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(CreacionDeBloques.ToconBlock5), new ItemRenderTocon5(render6, new TileEntityArbolTocon5()));
		//Rama2
				TileEntitySpecialRenderer render7 = new RenderToconBlock6();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityArbolTocon6.class, render7);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(CreacionDeBloques.ToconBlock6), new ItemRenderTocon6(render7, new TileEntityArbolTocon6()));
		//Hojas1
				TileEntitySpecialRenderer render8 = new RenderToconBlock7();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityArbolTocon7.class, render8);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(CreacionDeBloques.ToconBlock7), new ItemRenderTocon7(render8, new TileEntityArbolTocon7()));
		//Hojas2
				TileEntitySpecialRenderer render9 = new RenderToconBlock8();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityArbolTocon8.class, render9);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(CreacionDeBloques.ToconBlock8), new ItemRenderTocon8(render9, new TileEntityArbolTocon8()));
																
		//Entities
		RenderingRegistry.registerEntityRenderingHandler(EntityCyclops.class, new RenderCyclops(new ModelCyclops(), 0.3F));
	}

	public void registerTileEntitySpecialRenderer() {

	}
}