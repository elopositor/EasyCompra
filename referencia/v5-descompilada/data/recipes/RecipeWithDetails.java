package com.easycompra.app.data.recipes;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecipeDao.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/easycompra/app/data/recipes/RecipeWithDetails;", "", "recipe", "Lcom/easycompra/app/data/recipes/RecipeEntity;", "ingredients", "", "Lcom/easycompra/app/data/recipes/IngredientEntity;", "steps", "Lcom/easycompra/app/data/recipes/RecipeStepEntity;", "<init>", "(Lcom/easycompra/app/data/recipes/RecipeEntity;Ljava/util/List;Ljava/util/List;)V", "getRecipe", "()Lcom/easycompra/app/data/recipes/RecipeEntity;", "getIngredients", "()Ljava/util/List;", "getSteps", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class RecipeWithDetails {
    public static final int $stable = 8;
    private final List<IngredientEntity> ingredients;
    private final RecipeEntity recipe;
    private final List<RecipeStepEntity> steps;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RecipeWithDetails copy$default(RecipeWithDetails recipeWithDetails, RecipeEntity recipeEntity, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            recipeEntity = recipeWithDetails.recipe;
        }
        if ((i & 2) != 0) {
            list = recipeWithDetails.ingredients;
        }
        if ((i & 4) != 0) {
            list2 = recipeWithDetails.steps;
        }
        return recipeWithDetails.copy(recipeEntity, list, list2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final RecipeEntity getRecipe() {
        return this.recipe;
    }

    public final List<IngredientEntity> component2() {
        return this.ingredients;
    }

    public final List<RecipeStepEntity> component3() {
        return this.steps;
    }

    public final RecipeWithDetails copy(RecipeEntity recipe, List<IngredientEntity> ingredients, List<RecipeStepEntity> steps) {
        Intrinsics.checkNotNullParameter(recipe, "recipe");
        Intrinsics.checkNotNullParameter(ingredients, "ingredients");
        Intrinsics.checkNotNullParameter(steps, "steps");
        return new RecipeWithDetails(recipe, ingredients, steps);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecipeWithDetails)) {
            return false;
        }
        RecipeWithDetails recipeWithDetails = (RecipeWithDetails) other;
        return Intrinsics.areEqual(this.recipe, recipeWithDetails.recipe) && Intrinsics.areEqual(this.ingredients, recipeWithDetails.ingredients) && Intrinsics.areEqual(this.steps, recipeWithDetails.steps);
    }

    public int hashCode() {
        return (((this.recipe.hashCode() * 31) + this.ingredients.hashCode()) * 31) + this.steps.hashCode();
    }

    public String toString() {
        return "RecipeWithDetails(recipe=" + this.recipe + ", ingredients=" + this.ingredients + ", steps=" + this.steps + ")";
    }

    public RecipeWithDetails(RecipeEntity recipe, List<IngredientEntity> ingredients, List<RecipeStepEntity> steps) {
        Intrinsics.checkNotNullParameter(recipe, "recipe");
        Intrinsics.checkNotNullParameter(ingredients, "ingredients");
        Intrinsics.checkNotNullParameter(steps, "steps");
        this.recipe = recipe;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public final RecipeEntity getRecipe() {
        return this.recipe;
    }

    public final List<IngredientEntity> getIngredients() {
        return this.ingredients;
    }

    public final List<RecipeStepEntity> getSteps() {
        return this.steps;
    }
}
