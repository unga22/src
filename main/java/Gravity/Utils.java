package Gravity;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils
{

    public Utils()
    {
    }

    public static String stringArrayToString(String sa[])
    {
        return stringArrayToString(sa, "#");
    }

    public static String stringArrayToString(String sa[], String separator)
    {
        String ret = "";
        String arr$[] = sa;
        int len$ = arr$.length;
        for(int i$ = 0; i$ < len$; i$++)
        {
            String s = arr$[i$];
            ret = (new StringBuilder()).append(ret).append(separator).append(" ").append(s).toString();
        }

        return ret.replaceFirst((new StringBuilder()).append(separator).append(" ").toString(), "");
    }

    public static String[] loadTextFromURL(URL url, Logger logger, String defaultValue[], int timeoutMS)
    {
        ArrayList arraylist = new ArrayList();
        Scanner scanner = null;
        try
        {
            URLConnection uc = url.openConnection();
            uc.setReadTimeout(timeoutMS);
            uc.setConnectTimeout(timeoutMS);
            scanner = new Scanner(uc.getInputStream(), "UTF-8");
        }
        catch(Throwable e)
        {
            logger.log(Level.WARNING, String.format("Error retrieving remote string value! Defaulting to %s", new Object[] {
                stringArrayToString(defaultValue)
            }));
            return defaultValue;
        }
        for(; scanner.hasNextLine(); arraylist.add(scanner.nextLine()));
        scanner.close();
        return (String[])(String[])arraylist.toArray(new String[arraylist.size()]);
    }
}
