package PocketDimensions;

import PocketDimensions.GuiInfoBook;
import PocketDimensions.CommonProxy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ClientProxy extends CommonProxy {

    public static int currentPage = 0;

    @Override
    public void runClientSide() {

    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case 0:
                return new GuiInfoBook();
            default:
                return null;
        }
    }

}
