package jihuayu.painlessrespawn;

import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(bus = Bus.MOD)
public final class ModMainConfig {
    static final ForgeConfigSpec spec;

    public static int time = 100;
    public static String effect = "regeneration";
    public static int effectLevel = 5;
    private static ForgeConfigSpec.IntValue timeCfg;
    private static ForgeConfigSpec.IntValue effectsLevelCfg;
    private static ForgeConfigSpec.ConfigValue<String> effectsCfg;

    static {
        final Pair<ModMainConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ModMainConfig::new);
        spec = specPair.getRight();
    }

    private ModMainConfig(ForgeConfigSpec.Builder builder) {
        timeCfg = builder
                .comment("Time(ticks) of effect.")
                .defineInRange("time",time,20, Integer.MAX_VALUE);
        effectsLevelCfg = builder
                .comment("Level of effect.")
                .defineInRange("level",effectLevel,1, 5);
        effectsCfg = builder
                .comment("The effect will give.")
                .define("effect",effect);
    }

    public static void refresh() {
        time = timeCfg.get();
        effect = effectsCfg.get();
        effectLevel = effectsLevelCfg.get();
    }
    @SubscribeEvent
    public static void onFileChange(ModConfig.Reloading event) {
        ((CommentedFileConfig) event.getConfig().getConfigData()).load();
        refresh();
    }
}