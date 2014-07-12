package PocketDimensions;




import net.minecraft.tileentity.TileEntity;

public class TileDP extends TileEntity {

    public CoordSet getCoordSet() {
        return new CoordSet(xCoord, yCoord, zCoord);
    }

}
