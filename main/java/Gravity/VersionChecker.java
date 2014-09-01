package Gravity;

import cpw.mods.fml.common.FMLLog;
import java.net.URL;
import java.util.logging.Logger;

// Referenced classes of package grim3212.mc.core.util:
//            Utils

public class VersionChecker
{

    /**
     * @deprecated Method VersionChecker is deprecated
     */

    public VersionChecker(String modName, String oldVer, String versionURL, String updateURL, String loadMsg[], String inGameMsg[], Logger logger)
    {
        this(modName, oldVer, versionURL, updateURL, loadMsg, inGameMsg);
    }

    public VersionChecker(String modName, String oldVer, String versionURL, String updateURL, String loadMsg[], String inGameMsg[])
    {
        this(modName, oldVer, versionURL, updateURL, loadMsg, inGameMsg, 500);
    }

    public VersionChecker(String modName, String oldVer, String versionURL, String updateURL, String loadMsg[], String inGameMsg[], int timeoutMS)
    {
        remoteEndIndex = -1;
        useRemoteStringIndices = false;
        this.modName = modName;
        this.oldVer = oldVer;
        this.updateURL = updateURL;
        this.loadMsg = loadMsg;
        this.inGameMsg = inGameMsg;
        try
        {
            this.versionURL = new URL(versionURL);
            FMLLog.info("Initializing Version Checker for %s", new Object[] {
                modName
            });
        }
        catch(Throwable e)
        {
            FMLLog.warning("Error initializing Version Checker for %s: %s", new Object[] {
                modName, e.getMessage()
            });
        }
        String versionLines[] = Utils.loadTextFromURL(this.versionURL, Logger.getLogger("Grim3212Core"), new String[] {
            oldVer
        }, timeoutMS);
        newVer = versionLines[0].trim();
        if(versionLines.length > 1 && versionLines[1].trim().length() != 0)
            this.updateURL = versionLines[1];
        if(versionLines.length > 2 && versionLines[2].trim().length() != 0 && versionLines[2].contains(","))
            try
            {
                String indices[] = versionLines[2].split(",");
                remoteBeginIndex = Integer.parseInt(indices[0]);
                remoteEndIndex = Integer.parseInt(indices[1]);
                useRemoteStringIndices = remoteBeginIndex <= remoteEndIndex;
            }
            catch(Throwable e)
            {
                remoteBeginIndex = remoteEndIndex = -1;
            }
        setLoadMessage(loadMsg);
        setInGameMessage(inGameMsg);
    }

    public VersionChecker(String modName, String oldVer, String versionURL, String updateURL)
    {
        this(modName, oldVer, versionURL, updateURL, new String[] {
            "{modName} {oldVer} is out of date! Visit {updateURL} to download the latest release ({newVer})."
        }, new String[] {
            "{modName} {newVer}"
        });
    }

    public void checkVersionWithLogging()
    {
        if(!isCurrentVersion())
        {
            String arr$[] = loadMsg;
            int len$ = arr$.length;
            for(int i$ = 0; i$ < len$; i$++)
            {
                String msg = arr$[i$];
                FMLLog.info(msg, new Object[0]);
            }

        }
    }

    public void checkVersionWithLoggingBySubStringAsFloat(int beginIndex, int endIndex)
    {
        if(!isCurrentVersionBySubStringAsFloatNewer(beginIndex, endIndex))
        {
            String arr$[] = loadMsg;
            int len$ = arr$.length;
            for(int i$ = 0; i$ < len$; i$++)
            {
                String msg = arr$[i$];
                FMLLog.info(msg, new Object[0]);
            }

        }
    }

    public void setLoadMessage(String loadMsg[])
    {
        this.loadMsg = loadMsg;
        for(int i = 0; i < this.loadMsg.length; i++)
            this.loadMsg[i] = replaceAllTags(this.loadMsg[i]);

    }

    public void setInGameMessage(String inGameMsg[])
    {
        this.inGameMsg = inGameMsg;
        for(int i = 0; i < this.inGameMsg.length; i++)
            this.inGameMsg[i] = replaceAllTags(this.inGameMsg[i]);

    }

    public String[] getLoadMessage()
    {
        return loadMsg;
    }

    public String[] getInGameMessage()
    {
        return inGameMsg;
    }

    public boolean isCurrentVersion()
    {
        return newVer.equalsIgnoreCase(oldVer);
    }

    public boolean isCurrentVersionBySubStringAsFloatNewer(int beginIndex, int endIndex)
    {
        if(useRemoteStringIndices)
            return Float.valueOf(newVer.substring(remoteBeginIndex, remoteEndIndex)).floatValue() <= Float.valueOf(oldVer.substring(beginIndex, endIndex)).floatValue();
        try
        {
            return Float.valueOf(newVer.substring(beginIndex, endIndex)).floatValue() <= Float.valueOf(oldVer.substring(beginIndex, endIndex)).floatValue();
        }
        catch(Throwable e)
        {
            FMLLog.warning("Method isCurrentVersionBySubStringAsFloatNewer() encountered an error while comparing version substrings for mod %s: %s", new Object[] {
                modName, e.getMessage()
            });
        }
        return true;
    }

    private String replaceAllTags(String s)
    {
        return s.replace("{oldVer}", oldVer).replace("{newVer}", newVer).replace("{modName}", modName).replace("{updateURL}", updateURL);
    }

    private URL versionURL;
    private final String modName;
    private final String newVer;
    private final String oldVer;
    private String updateURL;
    private String loadMsg[];
    private String inGameMsg[];
    private int remoteBeginIndex;
    private int remoteEndIndex;
    private boolean useRemoteStringIndices;
}
