package Gravity;

//import grim3212.mc.core.Grim3212Core;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;

public class GenericHoe extends ItemHoe
{

    public GenericHoe(net.minecraft.item.Item.ToolMaterial toolMaterial)
    {
        super(toolMaterial);
        this.setCreativeTab(Grim3212Core.tabsGrimItems);
    }
}
