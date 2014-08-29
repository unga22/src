package com.minecraftargentina.basemod.lib;


import com.minecraftargentina.basemod.BaseMod;
import com.minecraftargentina.basemod.EntityCyclops;
import com.minecraftargentina.basemod.ModelCyclops;
import com.minecraftargentina.basemod.RenderCyclops;
import com.minecraftargentina.basemod.RenderObsidianTable;
import com.minecraftargentina.basemod.TileEntityObsidianTable;
import com.minecraftargentina.basemod.Blocks.CreacionDeBloques;
import com.minecraftargentina.basemod.Blocks.TileEntityArbolBase;
import com.minecraftargentina.basemod.Blocks.TileEntityArbolTocon2;
import com.minecraftargentina.basemod.Blocks.TileEntityArbolTocon3;
import com.minecraftargentina.basemod.Items.ItemRenderObsidianTable;
import com.minecraftargentina.basemod.Models.RenderArbolBase;
import com.minecraftargentina.basemod.Models.RenderRoca3D1Block;
import com.minecraftargentina.basemod.Models.RenderToconBlock;
import com.minecraftargentina.basemod.Models.RenderToconBlock10;
import com.minecraftargentina.basemod.Models.RenderToconBlock11;
import com.minecraftargentina.basemod.Models.RenderToconBlock2;
import com.minecraftargentina.basemod.Models.RenderToconBlock3;
import com.minecraftargentina.basemod.Models.RenderToconBlock4;
import com.minecraftargentina.basemod.Models.RenderToconBlock5;
import com.minecraftargentina.basemod.Models.RenderToconBlock6;
import com.minecraftargentina.basemod.Models.RenderToconBlock7;
import com.minecraftargentina.basemod.Models.RenderToconBlock8;
import com.minecraftargentina.basemod.Models.RenderToconBlock9;
import com.minecraftargentina.basemod.Models.TileEntityArbolTocon;
import com.minecraftargentina.basemod.Models.TileEntityArbolTocon10;
import com.minecraftargentina.basemod.Models.TileEntityArbolTocon11;
import com.minecraftargentina.basemod.Models.TileEntityArbolTocon4;
import com.minecraftargentina.basemod.Models.TileEntityArbolTocon5;
import com.minecraftargentina.basemod.Models.TileEntityArbolTocon6;
import com.minecraftargentina.basemod.Models.TileEntityArbolTocon7;
import com.minecraftargentina.basemod.Models.TileEntityArbolTocon8;
import com.minecraftargentina.basemod.Models.TileEntityArbolTocon9;
import com.minecraftargentina.basemod.Models.TileEntityRoca1;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	
	public static int currentPage = 0;
	
	   @Override
	    public void runClientSide() {

	    }

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
		//Hojas3
				TileEntitySpecialRenderer render10 = new RenderToconBlock9();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityArbolTocon9.class, render10);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(CreacionDeBloques.ToconBlock9), new ItemRenderTocon9(render10, new TileEntityArbolTocon9()));
		//Hojas3
				TileEntitySpecialRenderer render11 = new RenderToconBlock10();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityArbolTocon10.class, render11);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(CreacionDeBloques.ToconBlock10), new ItemRenderTocon10(render11, new TileEntityArbolTocon10()));
		
		//ARBOLFULL3D
				TileEntitySpecialRenderer render12 = new RenderToconBlock11();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityArbolTocon11.class, render12);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(CreacionDeBloques.ToconBlock11), new ItemRenderTocon11(render12, new TileEntityArbolTocon11()));
	
				
	//Rocas3D
				TileEntitySpecialRenderer render13 = new RenderRoca3D1Block();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoca1.class, render13);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(CreacionDeBloques.Roca3D1), new ItemRenderRoca3D1(render13, new TileEntityRoca1()));
				
				
				
		//Entities
		RenderingRegistry.registerEntityRenderingHandler(EntityCyclops.class, new RenderCyclops(new ModelCyclops(), 0.3F));
	}
		
	
	
}