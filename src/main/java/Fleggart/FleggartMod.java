package Fleggart;

import Fleggart.blocks.AncientDebrisBlock;
import Fleggart.worldgen.AncientDebrisSpawner;  // ← 添加这行
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
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

    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(
                Item.getItemFromBlock(ANCIENT_DEBRIS_BLOCK),
                0,
                new ModelResourceLocation(
                        ANCIENT_DEBRIS_BLOCK.getRegistryName(),
                        "inventory"
                )
        );
        System.out.println("✅ 模型注册成功！");
    }
}
