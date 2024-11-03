package pl.nadwey.sereneweather;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.BiomeColors;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(SereneWeather.MODID)
public class SereneWeather {
    public static final String MODID = "sereneweather";
    private static final Logger LOGGER = LogUtils.getLogger();

    public SereneWeather(IEventBus modEventBus, ModContainer modContainer) {
        // NeoForge.EVENT_BUS.register(this);
    }
}
