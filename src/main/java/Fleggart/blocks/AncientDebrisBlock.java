package Fleggart.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class AncientDebrisBlock extends Block {

    public AncientDebrisBlock() {
        super(Material.ROCK);
        setHardness(5.0F);
        setResistance(10.0F);
        setHarvestLevel("pickaxe", 2);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setRegistryName("fleggart", "ancient_debris_block");
        setUnlocalizedName("ancient_debris_block");
    }
}
