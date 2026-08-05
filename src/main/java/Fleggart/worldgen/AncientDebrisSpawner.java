package Fleggart.worldgen;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class AncientDebrisSpawner implements IWorldGenerator {

    private final WorldGenerator generator = new AncientDebrisGenerator();
    private static final int CHANCE = 1;

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
                         IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

        if (world.provider.getDimension() != -1) return;
        if (random.nextInt(CHANCE) != 0) return;

        int x = chunkX * 16 + 8;
        int z = chunkZ * 16 + 8;
        
        int y = 16;

        generator.generate(world, random, new BlockPos(x, y, z));
    }
}
