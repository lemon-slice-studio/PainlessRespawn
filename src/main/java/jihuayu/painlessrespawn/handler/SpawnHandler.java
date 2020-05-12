package jihuayu.painlessrespawn.handler;

import jihuayu.painlessrespawn.ModMainConfig;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber
public class SpawnHandler {
    @SubscribeEvent
    public static void onClone(PlayerEvent.Clone event) {
        ModMainConfig.refresh();
        PlayerEntity player = event.getPlayer();
        Effect e = ForgeRegistries.POTIONS.getValue(new ResourceLocation(ModMainConfig.effect));
        if (e != null)
            player.addPotionEffect(new EffectInstance(e, ModMainConfig.time, ModMainConfig.effectLevel));
    }
}
