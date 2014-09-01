package Gravity;

import cpw.mods.fml.common.FMLLog;
import java.io.File;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class Config
{

    public Config()
    {
    }

    public static void init(File configFile)
    {
        configuration = new Configuration(configFile);
        configuration.load();
        allowVersionCheckGlobal = configuration.get("general", "Allow Version Checking For GrimsMods", true).getBoolean(true);
        configuration.save();
        break MISSING_BLOCK_LABEL_77;
        Exception e;
        e;
        FMLLog.severe(errMsg, new Object[] {
            e
        });
        configuration.save();
        break MISSING_BLOCK_LABEL_77;
        Exception exception;
        exception;
        configuration.save();
        throw exception;
    }

    public static Configuration configuration;
    public static boolean allowVersionCheckGlobal;
    private static String errMsg = "grim3212core has had a problem loading its configuration";

}
