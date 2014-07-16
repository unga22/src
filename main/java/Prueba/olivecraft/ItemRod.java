package Prueba.olivecraft;


import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRod extends Item {
    public ItemRod() {
        super();
        setMaxStackSize(1);
        setMaxDamage(58);
        setCreativeTab(OliveCraft.oliveTab);
        setUnlocalizedName("rod");
    }

    public boolean isFull3D() {
        return false;
    }

    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, int side, float px, float py, float pz) {
        if (world.getBlock(x, y, z) == OliveBlocks.oliveLeaves) {
            if (world.getBlockMetadata(x, y, z) >= 11) {
                world.setBlockMetadataWithNotify(x, y, z, 0, 2);
                itemStack.damageItem(1, entityPlayer);
                if (!world.isRemote) {
                    EntityItem olive = new EntityItem(world, (double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), new ItemStack(OliveItems.olive, 1, 0));
                    world.spawnEntityInWorld(olive);
                }
                return true;
            }
        }
        return false;
    }
    
	public String getUnlocalizedName() {
		return Strings.MODID.toLowerCase() + "." + super.getUnlocalizedName();
	}

	public String getUnlocalizedName(ItemStack itemStack) {
		return Strings.MODID.toLowerCase() + "." + super.getUnlocalizedName(itemStack);
	}

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(Strings.MODID + ":rod");
    }
}
