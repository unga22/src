package Prueba.olivecraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Strings.MODID, name = Strings.MODNAME, version = Strings.VERSION)
public class OliveCraft {
	
    @Instance(Strings.MODID)
    public static OliveCraft instance;
    
    @SidedProxy(clientSide="Prueba.olivecraft.OliveClientProxy", serverSide="Prueba.olivecraft.OliveCommonProxy.java")
    public static OliveCommonProxy proxy;

    public static CreativeTabOlive oliveTab = new CreativeTabOlive(Strings.MODID);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        OliveBlocks.init();
        OliveItems.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    	NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
    	proxy.registerTileRenderers();
        GameRegistry.registerWorldGenerator(new OliveGen(), 1);
    	OliveRecipes.init();
        OliveTileEntities.init();
    }
}
