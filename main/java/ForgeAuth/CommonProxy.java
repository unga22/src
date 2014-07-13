package ForgeAuth;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;


public class CommonProxy {

	@SubscribeEvent
	public void registerRenderers() {
		Auth.print("Registering proxies");
//		Auth.instance.modEnabled = !Minecraft.getMinecraft().getIntegratedServer().isServerInOnlineMode();
		Auth.print("Mod " + (Vars.modEnabled ? "enabled" : "disabled") + " because onlinemode = " + !Vars.modEnabled);
		
		//no creo que este bien esto pero no se como ponerlo..
		MinecraftForge.EVENT_BUS.register(new onPlayerJoin(null));
		
		
		
		MinecraftForge.EVENT_BUS.register(new CancelledEvents());
	}
}