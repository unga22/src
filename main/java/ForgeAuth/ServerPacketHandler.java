
 
package ForgeAuth;


import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.common.network.FMLNetworkEvent.ServerCustomPacketEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.NetHandlerPlayServer;


public class ServerPacketHandler 
{
   protected String channelName;
   protected EntityPlayerMP thePlayer;
 
   @SubscribeEvent
   public void onServerPacket(ServerCustomPacketEvent event) throws IOException 
   {
      channelName = event.packet.channel();
  
      // Thanks to GoToLink for helping figure out how to get player entity
      NetHandlerPlayServer theNetHandlerPlayServer = (NetHandlerPlayServer)event.handler;
      thePlayer = theNetHandlerPlayServer.playerEntity;
  
      // if you want the server (the configurationManager is useful as it has player lists and such
      // you can use something like
      // MinecraftServer server MinecraftServer.getServer();
      if (channelName.equals("ForgeAuth"))

    	  
      {
         // DEBUG
         System.out.println("Server received packet from player = "+thePlayer.getEntityId());
    // NO SE ARREGLAR ESTO     ProcessPacketServerSide.processPacketOnServer(event.packet.payload(), event.packet.getTarget(), thePlayer);
      }
   }
}

