package Fleggart.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class AncientDebrisBlock extends Block {

    public AncientDebrisBlock() {
        super(Material.ROCK);  // 材质类型：ROCK（石头）、WOOD、IRON 等
        setHardness(5.0F);      // 硬度（影响挖掘时间，钻石镐约 1.5 秒）
        setResistance(10.0F);   // 爆炸抗性
        setHarvestLevel("pickaxe", 2);  // 需要镐（pickaxe）等级 2（铁镐以上）
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);  // 创造模式标签页
        setRegistryName("fleggart", "ancient_debris_block");  // 注册名
        setUnlocalizedName("ancient_debris_block");  // 未本地化名称（用于 lang 文件）
    }
}
