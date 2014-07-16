package Prueba.olivecraft;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockOliveLog extends Block {
    private IIcon topIcon, deadIcon;

    public BlockOliveLog(Material par2Material) {
        super(par2Material);
        setHardness(2.0F);
        setStepSound(soundTypeWood);
        setBlockName("oliveLog");
        setCreativeTab(OliveCraft.oliveTab);
        setTickRandomly(true);
    }

    public void updateTick(World world, int x, int y, int z, Random random) {
        int meta = world.getBlockMetadata(x, y, z);
        if (meta <= 4) {
            if (!(world.getBlock(x, y - 1, z) == Blocks.dirt || world.getBlock(x, y - 1, z) == Blocks.grass)) {
                meta = 15;
            }
        } else if (meta <= 11) {
        	if (world.getBlock(x, y - 1, z) != this) {
        		meta = 15;
        	}
        } else if (meta <= 13) {
            if (!(world.getBlock(x, y - 1, z) == this || world.getBlock(x + 1, y, z) == this || world.getBlock(x - 1, y, z) == this || world.getBlock(x, y, z + 1) == this || world.getBlock(x, y, z - 1) == this)) {
                meta = 15;
            }
        }

        if (meta == 4) {
            if (world.isAirBlock(x, y + 1, z)) {
                world.setBlock(x, y + 1, z, this, 5, 2);
            }
           	meta = 14;
        } else if (meta == 8) {
            if (world.isAirBlock(x, y + 1, z)) {
                world.setBlock(x, y + 1, z, this, 9, 2);
            }
            meta = 14;
        } else if (meta == 11) {
            if (world.isAirBlock(x, y + 1, z) && world.isAirBlock(x + 1, y, z) && world.isAirBlock(x - 1, y, z) && world.isAirBlock(x, y, z + 1) && world.isAirBlock(x, y, z - 1)) {
                world.setBlock(x, y + 1, z, this, 12, 2);
                world.setBlock(x + 1, y, z, this, 12, 2);
                world.setBlock(x - 1, y, z, this, 12, 2);
                world.setBlock(x, y, z + 1, this, 12, 2);
                world.setBlock(x, y, z - 1, this, 12, 2);
            }
            meta = 14;
        } else if (meta == 13) {
            if (world.isAirBlock(x, y + 1, z)) {
                world.setBlock(x, y + 1, z, OliveBlocks.oliveLeaves, 1, 2);
            }
            if (world.isAirBlock(x + 1, y, z)) {
                world.setBlock(x + 1, y, z, OliveBlocks.oliveLeaves, 1, 2);
            }
            if (world.isAirBlock(x - 1, y, z)) {
                world.setBlock(x - 1, y, z, OliveBlocks.oliveLeaves, 1, 2);
            }
            if (world.isAirBlock(x, y, z + 1)) {
                world.setBlock(x, y, z + 1, OliveBlocks.oliveLeaves, 1, 2);
            }
            if (world.isAirBlock(x, y, z - 1)) {
                world.setBlock(x, y, z - 1, OliveBlocks.oliveLeaves, 1, 2);
            }
            meta = 14;
        }
        if (meta < 14 && random.nextInt(3) == 2) {
        	meta++;
        }
        world.setBlockMetadataWithNotify(x, y, z, meta, 2);
    }

    public int damageDropped(int meta) {
        return 15;
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list) {
        list.add(new ItemStack(item, 1, 0));
        list.add(new ItemStack(item, 1, 15));
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)  {
        if (side == 0 || side == 1) {
            return this.topIcon;
        } else {
        	return meta == 15 ? this.deadIcon : this.blockIcon;
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.topIcon = iconRegister.registerIcon(Strings.MODID + ":oliveLog_top");
        this.blockIcon = iconRegister.registerIcon(Strings.MODID + ":oliveLog_side");
        this.deadIcon = iconRegister.registerIcon(Strings.MODID + ":oliveLog_dead");
    }
    
    /*/Debug
    public boolean onBlockActivated (World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
    	this.updateTick(world, x, y, z, new Random());
    	System.out.println(world.getBlockMetadata(x, y, z));
    	return true;
    }//*/
}
