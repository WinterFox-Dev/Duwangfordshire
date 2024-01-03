package com.sheppard.entity;

import com.sheppard.registry.EntityRegistry;
import com.sheppard.registry.ItemRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class TorchArrowEntity extends PersistentProjectileEntity {
    private static final ItemStack DEFAULT_STACK = new ItemStack(ItemRegistry.TORCH_ARROW);

    public TorchArrowEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world, DEFAULT_STACK);
    }

    public TorchArrowEntity(World world, double x, double y, double z) {
        super(EntityRegistry.TORCH_ARROW, x, y, z, world, DEFAULT_STACK);
    }

    public TorchArrowEntity(World world, LivingEntity owner) {
        super(EntityRegistry.TORCH_ARROW, owner, world, DEFAULT_STACK);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        super.onBlockHit(blockHitResult);
        Direction dir = blockHitResult.getSide();
        if(dir == Direction.UP) {
            this.getWorld().setBlockState(blockHitResult.getBlockPos().up(), Blocks.TORCH.getDefaultState());
            this.getWorld().playSound(this, blockHitResult.getBlockPos(), this.getWorld().getBlockState(blockHitResult.getBlockPos()).getSoundGroup().getPlaceSound(), SoundCategory.BLOCKS,1.0F, 1.0F);
            this.discard();
        } else if (dir == Direction.DOWN) {
            this.getWorld().spawnEntity(new ItemEntity(this.getWorld(), this.getX(), this.getY(), this.getZ(), new ItemStack(ItemRegistry.TORCH_ARROW)));
            this.discard();
        } else {
            this.getWorld().setBlockState(getPosDirectionFromDirection(blockHitResult.getBlockPos(), blockHitResult.getSide()), Blocks.WALL_TORCH.getDefaultState().with(WallTorchBlock.FACING, blockHitResult.getSide()));
            this.getWorld().playSound(this, blockHitResult.getBlockPos(), this.getWorld().getBlockState(blockHitResult.getBlockPos()).getSoundGroup().getPlaceSound(), SoundCategory.BLOCKS,1.0F, 1.0F);
            this.discard();
        }
    }

    private BlockPos getPosDirectionFromDirection(BlockPos pos, Direction d) {
        return switch (d) {
            case EAST -> pos.east();
            case WEST -> pos.west();
            case SOUTH -> pos.south();
            case NORTH -> pos.north();
            case UP -> pos.up();
            case DOWN -> pos.down();
            default -> pos;
        };
    }

}
