package PocketDimensions;



import java.util.HashMap;
import java.util.Map;


import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;

public class PocketRegistry {

    private static Map<CoordSet, Pocket> backLinkMap = new HashMap<CoordSet, Pocket>();

    private static CoordSet currentChunk = new CoordSet(0, 0, 0);

    public static WorldServer getWorldForPockets() {
        return MinecraftServer.getServer().worldServerForDimension(Reference.DIMENSION_ID);
    }

    public static Pocket getPocket(CoordSet chunkCoords) {
        if (backLinkMap.containsKey(chunkCoords))
            return backLinkMap.get(chunkCoords);
        return null;
    }

    public static Pocket getOrCreatePocket(int dimIDSource, CoordSet coordSetSource) {

        for (Pocket pocket : backLinkMap.values()) {
            if (pocket.getBlockDim() == dimIDSource && pocket.getBlockCoords().equals(coordSetSource))
                return pocket;
        }

        if (currentChunk.getY() >= 16)
            currentChunk.setY(0).addX(1);

        Pocket pocket = new Pocket(currentChunk.copy(), dimIDSource, coordSetSource);
        backLinkMap.put(pocket.getChunkCoords(), pocket);

        // add one here, so we start at 0 with the first room
        currentChunk.addY(1);

        saveData();

        return pocket;
    }

    public static void updatePocket(CoordSet chunkCoords, int newBlockDimID, CoordSet newBlockCoords) {
        Pocket link = backLinkMap.get(chunkCoords);
        if (link == null) {
            DPLogger.severe("No Pocket for chunkCoords: " + chunkCoords);
            return;
        }

        link.setBlockDim(newBlockDimID);
        link.setBlockCoords(newBlockCoords);

        saveData();
    }

    public static void updatePocketSpawn(CoordSet chunkCoords, CoordSet spawnSet) {
        Pocket link = backLinkMap.get(chunkCoords);
        if (link == null) {
            DPLogger.severe("No Pocket for chunkCoords: " + chunkCoords);
            return;
        }

        link.setSpawnSet(spawnSet);

        saveData();
    }

    public static void saveData() {
        PocketConfig.saveBackLinkMap(backLinkMap);
        PocketConfig.saveCurrentChunk(currentChunk);
    }

    public static void loadData() {
        backLinkMap = PocketConfig.loadBackLinkMap();
        currentChunk = PocketConfig.loadCurrentChunk();

        for (Pocket pocket : backLinkMap.values()) {
            if (pocket.isSourceBlockPlaced())
                ChunkLoaderHandler.addPocketToChunkLoader(pocket);
        }
    }
}
