package jihuayu.painlessrespawn;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

import static jihuayu.painlessrespawn.ModMain.MOD_ID;

@Mod(MOD_ID)
public class ModMain {
    public static final String MOD_ID = "painlessrespawn";
    public ModMain(){
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ModMainConfig.spec, MOD_ID+".toml");
    }
}
