package Prueba.olivecraft;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.registry.GameRegistry;

public class OliveBlocks {
    public static Block oliveLog;
    public static Block oliveLeaves;
    public static Block fryer;
    public static Block barrel;

	public static void init() {
        oliveLog = new BlockOliveLog(Material.wood);
        GameRegistry.registerBlock(oliveLog, ItemBlockOliveLog.class, Strings.MODID + ":oliveLog");
        Blocks.fire.setFireInfo(oliveLog, 5, 5);
        oliveLog.setHarvestLevel("axe", 0);

        oliveLeaves = new BlockOliveLeaves(Material.leaves);
        GameRegistry.registerBlock(oliveLeaves, Strings.MODID + ":oliveLeaves");
        Blocks.fire.setFireInfo(oliveLeaves, 30, 60);

        fryer = new BlockFryer(Material.iron);
        GameRegistry.registerBlock(fryer, "fryer");
        fryer.setHarvestLevel("pickaxe", 1);
        
        barrel = new BlockBarrel(Material.wood);
        GameRegistry.registerBlock(barrel, Strings.MODID + ":barrel");
        barrel.setHarvestLevel("axe", 0);
	}
}
