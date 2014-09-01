package Gravity;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class CommonProxy
    implements IGuiHandler
{

    public CommonProxy()
    {
    }

    public void registerRenderInformation()
    {
    }

    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int i, int j, int k)
    {
        return null;
    }

    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int i, int j, int k)
    {
        return null;
    }
}
