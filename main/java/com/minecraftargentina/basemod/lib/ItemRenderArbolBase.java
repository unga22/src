package com.minecraftargentina.basemod.lib;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderArbolBase implements IItemRenderer {
	
	
	TileEntitySpecialRenderer render1;
	private TileEntity entity;
	
	
	public ItemRenderArbolBase(TileEntitySpecialRenderer render1, TileEntity entity){
		this.entity = entity;
		this.render1 = render1;
		
		
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		
		if (type == IItemRenderer.ItemRenderType.ENTITY)
			GL11.glTranslatef(-0.5F, 0.0F, -0.5F);
		
		this.render1.renderTileEntityAt(this.entity, 0.0D, 0.0D, 0.0D, 0.0F);

	}

}
