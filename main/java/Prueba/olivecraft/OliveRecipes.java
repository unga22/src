package Prueba.olivecraft;


import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class OliveRecipes {
	
	public static void init() {
        ItemStack bagEmpty = new ItemStack(OliveItems.bagEmpty);
        
        GameRegistry.addShapedRecipe(new ItemStack(OliveBlocks.oliveLog, 1, 0), " b ", "blb", " b ", 'b', new ItemStack(Items.dye, 1, 15), 'l', new ItemStack(OliveBlocks.oliveLog, 1, 15));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(OliveItems.oil), "cropOlive", "cropOlive", "cropOlive", new ItemStack(Items.glass_bottle)));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(OliveItems.toast), "foodOliveoil", new ItemStack(Items.bread)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(OliveItems.rod), "  s", " s ", "w  ", 's', "stickWood", 'w', "plankWood"));
        GameRegistry.addShapedRecipe(new ItemStack(OliveBlocks.fryer), "b", "f", 'b', new ItemStack(Items.bucket), 'f', new ItemStack(Blocks.furnace));
        GameRegistry.addShapedRecipe(bagEmpty, "p p", "p p", "ppp", 'p', new ItemStack(Items.paper));
        GameRegistry.addRecipe(new FillingRecipe(bagEmpty, new ItemStack(OliveItems.bagFull), new ItemStack(OliveItems.chip)));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(OliveBlocks.barrel), "w w", "w w", "wpw", 'w', "logWood", 'p', "plankWood"));
	}
}
