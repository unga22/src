package Gravity;

//import grim3212.mc.core.Grim3212Core;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabGrimItems extends CreativeTabs
{

    public CreativeTabGrimItems(int tabID, String tabLabel)
    {
        super(tabID, tabLabel);
    }

    public String func_78024_c()
    {
        return "Grims Mods Items";
    }

    public Item func_78016_d()
    {
        return Grim3212Core.grimCoreItem;
    }

	@Override
	public Item getTabIconItem() {
		// TODO Auto-generated method stub
		return Grim3212Core.grimCoreItem;
	}
}
