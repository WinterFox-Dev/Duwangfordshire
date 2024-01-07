package com.sheppard.entity;

import com.sheppard.DuwangfordshireMod;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Random;

public class DuckEntity extends AnimalEntity implements GeoEntity {

    private Random rand = new Random();

    protected int flapTimer;
    protected int diveTimer;

    protected static final RawAnimation WALK_ANIM = RawAnimation.begin().thenLoop("Walking");
    protected static final RawAnimation SWIM_ANIM = RawAnimation.begin().thenLoop("Swimming");

    protected static final RawAnimation IDLE_ANIM = RawAnimation.begin().thenLoop("Idle");
    protected static final RawAnimation FLY_ANIM = RawAnimation.begin().thenLoop("Flying");
    protected static final RawAnimation DIVING_ANIM = RawAnimation.begin().thenPlay("Diving");
    protected static final RawAnimation FLAPPING_ANIM = RawAnimation.begin().thenLoop("Flapping");

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    private static final Ingredient BREEDING_INGREDIENT = Ingredient.ofItems(Items.SEAGRASS);
    public DuckEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return this.isBaby() ? dimensions.height * 0.85f : dimensions.height * 0.92f;
    }

    @Override
    protected void initGoals() {
        //HAS to do these things
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 1.4));
        this.goalSelector.add(2, new AnimalMateGoal(this, 1.0));
        this.goalSelector.add(3, new TemptGoal(this, 1.5, BREEDING_INGREDIENT, false));
        this.goalSelector.add(4, new FollowParentGoal(this, 1.1));

        //for fun things
        this.goalSelector.add(5, new FlapGoal(this));
        this.goalSelector.add(6, new DivingGoal(this));
        this.goalSelector.add(7, new FlyGoal(this, 1.0));
        this.goalSelector.add(8, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(9, new LookAtEntityGoal(this, PlayerEntity.class, 6.0f));
        this.goalSelector.add(10, new LookAroundGoal(this));
    }

    public boolean shouldFlap() {
        return true;
    }

    public boolean isFlapping() {
        return flapTimer > 0;
    }

    public boolean isDiving() {
        return diveTimer >0;
    }

    public boolean shouldDive() {
        return true;
    }

    public void flap() {
        this.triggerAnim("DuckAnimationController", "Flapping");
        this.flapTimer = rand.nextInt(20, 81);
    }

    public void dive() {
        this.triggerAnim("DuckAnimationController", "Diving");
        this.diveTimer = 400;
    }

    @Override
    public void tickMovement() {
        super.tickMovement();
        if(this.flapTimer >= 0) {
            flapTimer--;
        }else if(this.diveTimer >= 0) {
            diveTimer--;
        } else if(this.isTouchingWater()) {
            this.triggerAnim("DuckAnimationController", "Swimming");
        }else if(this.isOnGround() && (this.getVelocity().getX() > 0 || this.getVelocity().getZ() > 0)) {
            this.triggerAnim("DuckAnimationController", "Walking");
        //}else if (!this.isOnGround()) {
            //this.triggerAnim("DuckAnimationController", "Flying");
        }else if(this.isOnGround() && this.getVelocity().getX() == 0 && this.getVelocity().getZ() == 0) {
            this.triggerAnim("DuckAnimationController", "Idle");
        }
    }

    protected <E extends DuckEntity> PlayState animationController(final AnimationState<E> event) {
        if(event.isCurrentAnimation(WALK_ANIM)) {
            event.setAnimation(WALK_ANIM);
            return PlayState.CONTINUE;
        } else if (event.isCurrentAnimation(SWIM_ANIM)) {
            event.setAnimation(SWIM_ANIM);
            return PlayState.CONTINUE;
        }else if(event.isCurrentAnimation(FLY_ANIM)) {
            return PlayState.CONTINUE;
        } else if(event.isCurrentAnimation(FLAPPING_ANIM)) {
            event.setAnimation(FLAPPING_ANIM);
            return PlayState.CONTINUE;
        } else if(event.isCurrentAnimation(DIVING_ANIM)) {
            event.setAnimation(DIVING_ANIM);
            return PlayState.CONTINUE;
        } else {
            event.setAnimation(IDLE_ANIM);
            return PlayState.STOP;
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_CHICKEN_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_CHICKEN_HURT;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15f, 1.0f);
    }

    //@Override
    public boolean isBreedingItem(ItemStack stack) {
        return BREEDING_INGREDIENT.test(stack);
    }

    @Override
    public int getXpToDrop() {
        Random rand = new Random();
        return rand.nextInt(1, 4);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_CHICKEN_DEATH;
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(
                this,
                "DuckAnimationController",
                this::animationController)
                .triggerableAnim("Walking", WALK_ANIM)
                .triggerableAnim("Swimming", SWIM_ANIM)
                .triggerableAnim("Idle", IDLE_ANIM)
                .triggerableAnim("Flapping", FLAPPING_ANIM)
                .triggerableAnim("Diving", DIVING_ANIM)
                .triggerableAnim("Flying", FLY_ANIM)
        );



    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
