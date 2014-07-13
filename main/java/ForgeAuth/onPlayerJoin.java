package ForgeAuth;




import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.HashMap;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;


public class onPlayerJoin extends PlayerEvent.PlayerLoggedInEvent {
	
	
	public onPlayerJoin(EntityPlayer player) {
		super(player);
		if (Vars.modEnabled) {
			Auth.print("No login, mod disabled");
			Auth.players.put(player, Boolean.valueOf(true));
		} else {
			Auth.print("Asking player to register/Login");
			Auth.players.put(player, Boolean.valueOf(false));
			boolean hasPass = Auth.hasPass(player);
			ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
			DataOutputStream outputStream = new DataOutputStream(bos);
			if (hasPass)
				try {
					outputStream.writeUTF("Login");
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			else {
				try {
					outputStream.writeUTF("Register");
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			
			//no lo pude arreglar
			
		/*	Packet250CustomPayload packet = new Packet250CustomPayload();
			packet.channel = "AuthChan1";
			packet.data = bos.toByteArray();
			packet.length = bos.size();
			PacketBuffer.sendPacketToPlayer(packet, (Player) player);
			
			**/
		}
	}
	

	public void onPlayerLogout(EntityPlayer player) {
		Auth.players.remove(player);
	}

	public void onPlayerChangedDimension(EntityPlayer player) {
	}

	public void onPlayerRespawn(EntityPlayer player) {
	}
	
}