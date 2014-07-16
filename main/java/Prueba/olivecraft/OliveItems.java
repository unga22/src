package Prueba.olivecraft;


import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class OliveItems {
    public static Item olive;
    public static Item oil;
    public static Item toast;
    public static Item rod;
    public static Item burnt;
    public static Item chip;
    public static Item bagEmpty;
    public static Item bagFull;
    public static Item oliveEdible;
    
	public static void init() {
        olive = new ItemOlive();
        GameRegistry.registerItem(olive, Strings.MODID + ":olive");
        OreDictionary.registerOre("cropOlive", new ItemStack(olive));
        
        oil = new ItemOil();
        GameRegistry.registerItem(oil, Strings.MODID + ":oil");
        OreDictionary.registerOre("foodOliveoil", new ItemStack(oil));
        
        toast = new ItemToast();
        GameRegistry.registerItem(toast, Strings.MODID + ":toast");
        
        rod = new ItemRod();
        GameRegistry.registerItem(rod, Strings.MODID + ":rod");
        
        burnt = new ItemBurnt();
        GameRegistry.registerItem(burnt, Strings.MODID + ":burnt");
        
        chip = new ItemChip();
        GameRegistry.registerItem(chip, Strings.MODID + ":chip");
        
        bagEmpty = new ItemBagEmpty();
        GameRegistry.registerItem(bagEmpty, Strings.MODID + ":bagEmpty");
        
        bagFull = new ItemBagFull();
        GameRegistry.registerItem(bagFull, Strings.MODID + ":bagFull");
        
        oliveEdible = new ItemOliveEdible();
        GameRegistry.registerItem(oliveEdible, Strings.MODID + ":oliveEdible");
	}
}
