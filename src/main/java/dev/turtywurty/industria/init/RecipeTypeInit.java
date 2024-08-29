package dev.turtywurty.industria.init;

import dev.turtywurty.industria.Industria;
import dev.turtywurty.industria.recipe.AlloyFurnaceRecipe;
import dev.turtywurty.industria.recipe.CrusherRecipe;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class RecipeTypeInit {
    public static final RecipeType<AlloyFurnaceRecipe> ALLOY_FURNACE =
            register("alloy_furnace", AlloyFurnaceRecipe.Type.INSTANCE);

    public static final RecipeType<CrusherRecipe> CRUSHER =
            register("crusher", CrusherRecipe.Type.INSTANCE);

    public static <T extends Recipe<?>> RecipeType<T> register(String name, RecipeType<T> type) {
        return Registry.register(Registries.RECIPE_TYPE, Industria.id(name), type);
    }

    public static void init() {}
}
