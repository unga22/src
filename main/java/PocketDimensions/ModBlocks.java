package PocketDimensions;



import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {

    public static Block dimensionalPocket;
    public static Block dimensionalPocketFrame;

    public static void init() {
        dimensionalPocket = new BlockDimensionalPocket(Material.anvil, Strings.BLOCK_POCKET);

        dimensionalPocketFrame = new BlockDimensionalPocketFrame(Material.anvil, Strings.BLOCK_POCKET_FRAME);
    }
}
