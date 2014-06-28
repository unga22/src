package com.minecraftargentina.basemod.lib;


import com.minecraftargentina.basemod.BaseMod;
import com.minecraftargentina.basemod.EntityCyclops;
import com.minecraftargentina.basemod.ModelCyclops;
import com.minecraftargentina.basemod.RenderCyclops;
import com.minecraftargentina.basemod.RenderObsidianTable;
import com.minecraftargentina.basemod.TileEntityObsidianTable;
import com.minecraftargentina.basemod.Blocks.CreacionDeBloques;
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

		//Entities
		RenderingRegistry.registerEntityRenderingHandler(EntityCyclops.class, new RenderCyclops(new ModelCyclops(), 0.3F));
	}

	public void registerTileEntitySpecialRenderer() {

	}
}