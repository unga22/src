package ForgeAuth;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;

public class Command extends CommandBase {

	public String getCommandName() {
		return "authreset";
	}

	public String getCommandUsage(ICommandSender icommandsender) {
		return "/authreset <player>";
	}
	
    @Override
	public List getCommandAliases() {
		return Arrays.asList("ar", "authr");
	}
	
    @Override
	public void processCommand(ICommandSender sender, String[] args) {
    	
    	EntityPlayerMP player = MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(sender.getCommandSenderName());
		if (args.length < 1) {
			player.addChatComponentMessage(new ChatComponentText("$4[ForgeAuth] Use: /authreset <user>"));
		} else {
	    	File f = new File(Vars.userfolder, args[0]);
			if (f.exists()) {
				f.delete();
				player.addChatComponentMessage(new ChatComponentText("§4[ForgeAuth] " + args[0]	+ "'s password reset."));
			} else {
				player.addChatComponentMessage(new ChatComponentText("§4[ForgeAuth] " + "This player doesn't exists."));
			}
		}
	}
    

    @Override
    public int getRequiredPermissionLevel()
    {
            return 4;
    }

}