package ForgeAuth;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.relauncher.Side;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.config.Configuration;


@Mod(modid=Vars.modid, name=Vars.name, version=Vars.version)
//@NetworkMod(clientSideRequired=true, serverSideRequired=true, clientPacketHandlerSpec=@NetworkMod.SidedPacketHandler(channels={"AuthChan1"}, packetHandler=PacketHandlerClient.class), serverPacketHandlerSpec=@NetworkMod.SidedPacketHandler(channels={"AuthChan1"}, packetHandler=PacketHandlerServer.class))
public class Auth
{
  public static HashMap<EntityPlayer, Boolean> players = new HashMap();

  @Mod.Instance("ForgeAuth")
  public static Auth instance;

  
  //probando algo
  public static final String networkChannelName = "ForgeAuth";
  public static FMLEventChannel ForgeAuth;
  
  
  
  @SidedProxy(clientSide="ForgeAuth.ClientProxy", serverSide="ForgeAuth.CommonProxy")
  public static CommonProxy proxy;
  public static Configuration config;
  
  @Mod.EventHandler
  public void preInit(FMLPreInitializationEvent e) { config = new Configuration(e.getSuggestedConfigurationFile());
    Vars.userfolder = new File(e.getSuggestedConfigurationFile().getParentFile(), "AuthPlayers");
    if ((e.getSide() == Side.SERVER) && 
      (!Vars.userfolder.exists())) Vars.userfolder.mkdir();
  }

  @Mod.EventHandler
  public void load(FMLInitializationEvent e)
  {
    proxy.registerRenderers();
    Vars.debug = config.get(Configuration.CATEGORY_GENERAL, "Debug", false).getBoolean(false);
    Vars.useMYSQL = config.get(Configuration.CATEGORY_GENERAL, "Use mysql", false).getBoolean(false);
    Vars.mysql.put("host", config.get(Configuration.CATEGORY_GENERAL, "MYSQL-Host", "localhost").getString());
    Vars.mysql.put("user", config.get(Configuration.CATEGORY_GENERAL, "MYSQL-User", "username").getString());
    Vars.mysql.put("pass", config.get(Configuration.CATEGORY_GENERAL, "MYSQL-Password", "psswd").getString());
    Vars.mysql.put("port", config.get(Configuration.CATEGORY_GENERAL, "MYSQL-Port", "3306").getString());
    
    
    
  }

  @Mod.EventHandler
  public void postInit(FMLPostInitializationEvent e)
  {
	  if (config.hasChanged()) config.save();
  }
  
  

  @Mod.EventHandler
  public void serverStart(FMLServerStartingEvent event)
  {
    event.registerServerCommand(new Command());
  }

  public static String readPlayer(String player) {
    return readFile(new File(Vars.userfolder, player));
  }

  public static String readFile(File f) {
    try {
      InputStream ips = new FileInputStream(f);
      InputStreamReader ipsr = new InputStreamReader(ips);
      BufferedReader br = new BufferedReader(ipsr);
      String ligne = br.readLine();
      br.close();
      return ligne;
    }
    catch (Exception e) {
    	print(e.getLocalizedMessage());
        return null;
    }
  }

  public static boolean hasPass(EntityPlayer pl)
  {
    String username = pl.PERSISTED_NBT_TAG;
    File playerFile = new File(Vars.userfolder, username);
    if (playerFile.exists()) {
      if (readPlayer(username).isEmpty()) {
    	  Auth.print("Player doesn't exists");
        return false;
      }
      Auth.print("Player exists");
      return true;
    }
    Auth.print("Plyer doesn't exists");
    return false;
  }

  public static boolean checkPass(EntityPlayer pl, String passwd)
  {
    String username = pl.PERSISTED_NBT_TAG;
    File playerFile = new File(Vars.userfolder, username);
    if (playerFile.exists()) {
      String savedPass = readPlayer(pl.PERSISTED_NBT_TAG);
      if (savedPass.equals(passwd)) {
    	  Auth.print("Password correct: ");
    	  Auth.print(passwd);
    	  Auth.print(savedPass);
    	  return true;
      }
      Auth.print("Password incorrect: ");
	  Auth.print(passwd);
	  Auth.print(savedPass);
    } else {
    	Auth.print("Player doesn't exists");
    }    
    return false;
  }

  public static boolean savePlayer(EntityPlayer pl, String pass)
  {
	  Auth.print("Saving player password");
	  return saveFile(new File(Vars.userfolder, pl.PERSISTED_NBT_TAG), pass);
  }

  public static boolean saveFile(File f, String str) {
    try {
      if (f.exists()) f.delete();
      f.createNewFile();
      FileWriter fw = new FileWriter(f);
      fw.write(str);
      fw.close();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
    }return false;
  }
  
  public static String hash (String pass) {
	MessageDigest cr;
	try {
		cr = MessageDigest.getInstance("SHA-1");
	    cr.reset();
	    cr.update(pass.getBytes());
		return new String(HexBin.encode(cr.digest()));
	} catch (NoSuchAlgorithmException e) {
		e.printStackTrace();
		return null;
	}
  }
  
  public static void print(String s) {
	  if (Vars.debug) {
		  System.out.println(s);
	  }
  }
}