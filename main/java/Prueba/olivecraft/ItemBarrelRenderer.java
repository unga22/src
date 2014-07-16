package Prueba.olivecraft;


import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemBarrelRenderer implements IItemRenderer {
	
	private TileEntitySpecialRenderer render;
	
	public ItemBarrelRenderer(TileEntitySpecialRenderer render) {
		this.render = render;
	}

	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}
	
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch (type) {
			case ENTITY: {
				render.renderTileEntityAt(new TileEntityBarrel(), -0.5D, -0.5D, -0.5D, 0.0F);
				return;
			} default: {
				render.renderTileEntityAt(new TileEntityBarrel(), 0.0D, -0.1D, 0.0D, 0.0F);
				return;
			}
		}
			
	}

}
