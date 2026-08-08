package Fleggart;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientEventHandler {

    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {

        ModelLoader.setCustomModelResourceLocation(
                Item.getItemFromBlock(FleggartMod.ANCIENT_DEBRIS_BLOCK),
                0,
                new ModelResourceLocation(
                        "fleggart:ancient_debris_block",
                        "inventory"
                )
        );
    }
}
