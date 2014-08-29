package EspacioExterior;


import net.minecraft.util.ChunkCoordinates;

public class DungeonPortalPosition extends ChunkCoordinates
{
public long field_85087_d;
final DungeonTeleporter field_85088_e;
public DungeonPortalPosition(DungeonTeleporter dungeonteleporter, int par2, int par3, int par4, long par5)
{
super(par2, par3, par4);
this.field_85088_e = dungeonteleporter;
this.field_85087_d = par5;
}
}

