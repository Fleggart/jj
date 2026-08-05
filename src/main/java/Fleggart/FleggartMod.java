package Fleggart;

import Fleggart.blocks.AncientDebrisBlock;
import Fleggart.worldgen.AncientDebrisSpawner;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = "fleggart")
public class FleggartMod {

    public static AncientDebrisBlock ANCIENT_DEBRIS_BLOCK;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new AncientDebrisSpawner(), 0);
        System.out.println("✅ 世界生成器注册成功！");
        
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        ANCIENT_DEBRIS_BLOCK = new AncientDebrisBlock();
        event.getRegistry().register(ANCIENT_DEBRIS_BLOCK);
        System.out.println("✅ 方块注册成功！");
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        ItemBlock itemBlock = new ItemBlock(ANCIENT_DEBRIS_BLOCK);
        itemBlock.setRegistryName(ANCIENT_DEBRIS_BLOCK.getRegistryName());
        event.getRegistry().register(itemBlock);
        System.out.println("✅ 物品形态注册成功！");
    }
}
