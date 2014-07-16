package Prueba.olivecraft;

import cpw.mods.fml.common.registry.GameRegistry;

public class OliveTileEntities {
	public static void init() {
		GameRegistry.registerTileEntity(TileEntityFryer.class, "fryer");
		GameRegistry.registerTileEntity(TileEntityBarrel.class, "barrel");
	}
}
