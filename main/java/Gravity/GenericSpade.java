package Gravity;
//import grim3212.mc.core.Grim3212Core;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;

public class GenericSpade extends ItemSpade
{

    public GenericSpade(net.minecraft.item.Item.ToolMaterial toolMaterial)
    {
        super(toolMaterial);
        this.setCreativeTab(Grim3212Core.tabsGrimItems);
    }
}
