package jihuayu.painlessrespawn.handler;

import jihuayu.painlessrespawn.ModMainConfig;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class SpawnHandler {
    @SubscribeEvent
    public static void onClone(PlayerEvent.Clone event){
        ModMainConfig.refresh();
        PlayerEntity player = event.getPlayer();
        player.addPotionEffect(new EffectInstance(Effects.RESISTANCE,ModMainConfig.time,5));
    }
}
