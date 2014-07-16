package Prueba.olivecraft;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabOlive extends CreativeTabs {
	public CreativeTabOlive(String tabLabel) {
        super(tabLabel);
    }
	
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() {
        return OliveItems.olive;
    }

    @SideOnly(Side.CLIENT)
    public String getTranslatedTabLabel() {
    	return "OliveCraft";
    }
}
