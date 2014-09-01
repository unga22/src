package Gravity;

//import grim3212.mc.core.Grim3212Core;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabGrimBlocks extends CreativeTabs
{

    public CreativeTabGrimBlocks(int tabID, String tabLabel)
    {
        super(tabID, tabLabel);
    }

    public String func_78024_c()
    {
        return "Grims Mods Blocks";
    }
  

	@Override
	public Item getTabIconItem() {
		// TODO Auto-generated method stub
		return Item.getItemFromBlock(Grim3212Core.grimCoreBlock);
	}
}
