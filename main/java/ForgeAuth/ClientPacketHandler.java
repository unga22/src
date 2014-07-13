package ForgeAuth;

import java.io.IOException;



import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ClientCustomPacketEvent;

// Remember "client" run configuration includes server side execution too
public class ClientPacketHandler extends ServerPacketHandler
{
   @SubscribeEvent
   public void onClientPacket(ClientCustomPacketEvent event) throws IOException 
   {
      channelName = event.packet.channel();
      if (channelName.equals("ForgeAuth"))
      {
         // DEBUG
         System.out.println("Client received packet from server");
   
       //  ProcessPacketClientSide.processPacketOnClient(event.packet.payload(), event.packet.getTarget());
      }
   }  
}