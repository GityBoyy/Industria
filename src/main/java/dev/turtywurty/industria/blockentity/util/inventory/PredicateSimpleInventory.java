package dev.turtywurty.industria.blockentity.util.inventory;

import dev.turtywurty.industria.blockentity.util.UpdatableBlockEntity;
import net.minecraft.item.ItemStack;

import java.util.function.BiPredicate;

public class PredicateSimpleInventory extends SyncingSimpleInventory {
    private final BiPredicate<ItemStack, Integer> predicate;

    public PredicateSimpleInventory(UpdatableBlockEntity blockEntity, int size, BiPredicate<ItemStack, Integer> predicate) {
        super(blockEntity, size);
        this.predicate = predicate;
    }

    public PredicateSimpleInventory(UpdatableBlockEntity blockEntity, BiPredicate<ItemStack, Integer> predicate, ItemStack... stacks) {
        super(blockEntity, stacks);
        this.predicate = predicate;
    }

    @Override
    public boolean isValid(int slot, ItemStack stack) {
        return this.predicate.test(stack, slot);
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        if(isValid(slot, stack)) {
            setStack(slot, stack);
        }
    }

    @Override
    public ItemStack addStack(ItemStack stack) {
        if(isValid(0, stack)) {
            return super.addStack(stack);
        }

        return stack;
    }

    public BiPredicate<ItemStack, Integer> getPredicate() {
        return this.predicate;
    }
}
