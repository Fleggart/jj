package Fleggart;

import Fleggart.worldgen.AncientDebrisSpawner;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = "fleggart")
public class FleggartMod {

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new AncientDebrisSpawner(), 0);
    }
}
