package Prueba.olivecraft;


import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;

public class OliveClientProxy extends OliveCommonProxy {

	@Override
	public void registerTileRenderers() {
		TileEntityBarrelRenderer barrelRenderer = new TileEntityBarrelRenderer();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBarrel.class, barrelRenderer);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(OliveBlocks.barrel), new ItemBarrelRenderer(barrelRenderer));
	}
}
