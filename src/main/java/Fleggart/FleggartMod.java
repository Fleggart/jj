package Fleggart;

import Fleggart.blocks.AncientDebrisBlock;
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

    // 声明方块实例
    public static AncientDebrisBlock ANCIENT_DEBRIS_BLOCK;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // 注册世界生成器（保留之前的）
        GameRegistry.registerWorldGenerator(new AncientDebrisSpawner(), 0);
        System.out.println("✅ 世界生成器注册成功！");
        
        // 注册事件监听（用于方块注册和模型注册）
        MinecraftForge.EVENT_BUS.register(this);
    }

    // 注册方块（RegistryEvent.Register<Block> 事件）
    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        ANCIENT_DEBRIS_BLOCK = new AncientDebrisBlock();
        event.getRegistry().register(ANCIENT_DEBRIS_BLOCK);
        System.out.println("✅ 方块注册成功！");
    }

    // 注册物品形态（ItemBlock）
    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        // 每个方块都需要对应的 ItemBlock 才能在背包中显示
        ItemBlock itemBlock = new ItemBlock(ANCIENT_DEBRIS_BLOCK);
        itemBlock.setRegistryName(ANCIENT_DEBRIS_BLOCK.getRegistryName());
        event.getRegistry().register(itemBlock);
        System.out.println("✅ 物品形态注册成功！");
    }

    // 注册模型（ModelRegistryEvent 事件）
    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {
        // 告诉游戏使用哪个模型文件
        ModelLoader.setCustomModelResourceLocation(
                Item.getItemFromBlock(ANCIENT_DEBRIS_BLOCK),  // 方块对应的物品
                0,                                             // 数据值（metadata，通常为 0）
                new ModelResourceLocation(
                        ANCIENT_DEBRIS_BLOCK.getRegistryName(),  // 资源路径
                        "inventory"                               // 模型类型
                )
        );
        System.out.println("✅ 模型注册成功！");
    }
}
