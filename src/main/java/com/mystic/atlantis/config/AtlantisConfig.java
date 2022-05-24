package com.mystic.atlantis.config;

import me.shedaniel.autoconfig.ConfigData;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class AtlantisConfig implements ConfigData {

    public static final ForgeConfigSpec CONFIG_SPEC;
    public static final AtlantisConfig INSTANCE;

    static {
        Pair<AtlantisConfig, ForgeConfigSpec> pair = new ForgeConfigSpec.Builder().configure(AtlantisConfig::new);
        CONFIG_SPEC = pair.getRight();
        INSTANCE = pair.getLeft();
    }

    public ForgeConfigSpec.BooleanValue islandsOn;
    public ForgeConfigSpec.BooleanValue volcanoesOn;
    public ForgeConfigSpec.IntValue minCrabSpawnHeight;
    public ForgeConfigSpec.IntValue maxCrabSpawnHeight;
    public ForgeConfigSpec.DoubleValue magmaAcceleration;
    public ForgeConfigSpec.DoubleValue magmaThreshold;
    public ForgeConfigSpec.BooleanValue startInAtlantis;



    private AtlantisConfig(ForgeConfigSpec.Builder builder) {

        this.islandsOn = builder.comment("Should Islands Generate?").define("islandsOn", false);
        this.volcanoesOn = builder.comment("Should Volcanoes Generate?").define("volcanoesOn", false);
        this.minCrabSpawnHeight = builder.comment("Minimum Crab Spawn Height").defineInRange("minCrabSpawnHeight", 75,0,128);
        this.maxCrabSpawnHeight = builder.comment("Maximum Crab Spawn Height").defineInRange("maxCrabSpawnHeight", 85,0,128);
        this.magmaAcceleration = builder.comment("Rate at which Magma Accelerates you").defineInRange("magmaAcceleration", 0.1d,0.0d,100.0d);
        this.magmaThreshold = builder.comment("Max Magma Velocity ").defineInRange("magmaThreshold", 1.8d,0.0d,100.0d);
        this.startInAtlantis = builder.comment("Start In Atlantis?").define("startInAtlantis", false);
    }
}