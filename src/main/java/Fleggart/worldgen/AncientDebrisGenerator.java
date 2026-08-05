package Fleggart.worldgen;

import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

import java.util.Random;

public class AncientDebrisGenerator extends WorldGenerator {

    private static final ResourceLocation STRUCTURE = new ResourceLocation("fleggart", "ancient_debris");

    @Override
    public boolean generate(World world, Random rand, BlockPos position) {
        TemplateManager manager = world.getSaveHandler().getStructureTemplateManager();
        Template template = manager.getTemplate(world.getMinecraftServer(), STRUCTURE);

        if (template == null) {
            System.out.println("❌ 结构文件加载失败！检查路径: " + STRUCTURE);
            return false;
        }

        Rotation rotation = Rotation.values()[rand.nextInt(Rotation.values().length)];
        Mirror mirror = Mirror.values()[rand.nextInt(Mirror.values().length)];

        PlacementSettings settings = new PlacementSettings()
                .setRotation(rotation)
                .setMirror(mirror)
                .setIgnoreEntities(false)
                .setChunk(null);

        BlockPos offset = new BlockPos(
                -template.getSize().getX() / 2,
                0,
                -template.getSize().getZ() / 2
        );

        template.addBlocksToWorld(world, position.add(offset), settings);
        return true;
    }
}
