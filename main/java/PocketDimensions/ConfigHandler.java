package PocketDimensions;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {

    private static final String GAMEPLAY = "Gameplay";

    private static Configuration config;

    public static void init(File configFile) {
        config = new Configuration(configFile);

        try {

            Reference.DIMENSION_ID = config.get(GAMEPLAY, "Pocket Dimension ID", Reference.DIMENSION_ID_DEFAULT).getInt();
            Reference.SHOULD_SPAWN_WITH_BOOK = config.get(GAMEPLAY, "Spawning with book", true).getBoolean(true);

        } catch (Exception e) {
            DPLogger.severe(e);
        } finally {
            config.save();
        }
    }
}
