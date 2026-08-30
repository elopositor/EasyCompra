package com.easycompra.app.ui.recipes;

import com.easycompra.app.data.recipes.IngredientResult;
import com.easycompra.app.data.recipes.RecipeWithDetails;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecipeViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/easycompra/app/ui/recipes/CookingWorkflow;", "", "<init>", "()V", "SelectServings", "ShowComparison", "ShowSummary", "Lcom/easycompra/app/ui/recipes/CookingWorkflow$SelectServings;", "Lcom/easycompra/app/ui/recipes/CookingWorkflow$ShowComparison;", "Lcom/easycompra/app/ui/recipes/CookingWorkflow$ShowSummary;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class CookingWorkflow {
    public static final int $stable = 0;

    public /* synthetic */ CookingWorkflow(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: RecipeViewModel.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/easycompra/app/ui/recipes/CookingWorkflow$SelectServings;", "Lcom/easycompra/app/ui/recipes/CookingWorkflow;", "recipe", "Lcom/easycompra/app/data/recipes/RecipeWithDetails;", "servings", "", "<init>", "(Lcom/easycompra/app/data/recipes/RecipeWithDetails;F)V", "getRecipe", "()Lcom/easycompra/app/data/recipes/RecipeWithDetails;", "getServings", "()F", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class SelectServings extends CookingWorkflow {
        public static final int $stable = 8;
        private final RecipeWithDetails recipe;
        private final float servings;

        public static /* synthetic */ SelectServings copy$default(SelectServings selectServings, RecipeWithDetails recipeWithDetails, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                recipeWithDetails = selectServings.recipe;
            }
            if ((i & 2) != 0) {
                f = selectServings.servings;
            }
            return selectServings.copy(recipeWithDetails, f);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final RecipeWithDetails getRecipe() {
            return this.recipe;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getServings() {
            return this.servings;
        }

        public final SelectServings copy(RecipeWithDetails recipe, float servings) {
            Intrinsics.checkNotNullParameter(recipe, "recipe");
            return new SelectServings(recipe, servings);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SelectServings)) {
                return false;
            }
            SelectServings selectServings = (SelectServings) other;
            return Intrinsics.areEqual(this.recipe, selectServings.recipe) && Float.compare(this.servings, selectServings.servings) == 0;
        }

        public int hashCode() {
            return (this.recipe.hashCode() * 31) + Float.hashCode(this.servings);
        }

        public String toString() {
            return "SelectServings(recipe=" + this.recipe + ", servings=" + this.servings + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SelectServings(RecipeWithDetails recipe, float servings) {
            super(null);
            Intrinsics.checkNotNullParameter(recipe, "recipe");
            this.recipe = recipe;
            this.servings = servings;
        }

        public final RecipeWithDetails getRecipe() {
            return this.recipe;
        }

        public final float getServings() {
            return this.servings;
        }
    }

    private CookingWorkflow() {
    }

    /* JADX INFO: compiled from: RecipeViewModel.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/easycompra/app/ui/recipes/CookingWorkflow$ShowComparison;", "Lcom/easycompra/app/ui/recipes/CookingWorkflow;", "recipe", "Lcom/easycompra/app/data/recipes/RecipeWithDetails;", "servings", "", "results", "", "Lcom/easycompra/app/data/recipes/IngredientResult;", "<init>", "(Lcom/easycompra/app/data/recipes/RecipeWithDetails;FLjava/util/List;)V", "getRecipe", "()Lcom/easycompra/app/data/recipes/RecipeWithDetails;", "getServings", "()F", "getResults", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class ShowComparison extends CookingWorkflow {
        public static final int $stable = 8;
        private final RecipeWithDetails recipe;
        private final List<IngredientResult> results;
        private final float servings;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ShowComparison copy$default(ShowComparison showComparison, RecipeWithDetails recipeWithDetails, float f, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                recipeWithDetails = showComparison.recipe;
            }
            if ((i & 2) != 0) {
                f = showComparison.servings;
            }
            if ((i & 4) != 0) {
                list = showComparison.results;
            }
            return showComparison.copy(recipeWithDetails, f, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final RecipeWithDetails getRecipe() {
            return this.recipe;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getServings() {
            return this.servings;
        }

        public final List<IngredientResult> component3() {
            return this.results;
        }

        public final ShowComparison copy(RecipeWithDetails recipe, float servings, List<IngredientResult> results) {
            Intrinsics.checkNotNullParameter(recipe, "recipe");
            Intrinsics.checkNotNullParameter(results, "results");
            return new ShowComparison(recipe, servings, results);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShowComparison)) {
                return false;
            }
            ShowComparison showComparison = (ShowComparison) other;
            return Intrinsics.areEqual(this.recipe, showComparison.recipe) && Float.compare(this.servings, showComparison.servings) == 0 && Intrinsics.areEqual(this.results, showComparison.results);
        }

        public int hashCode() {
            return (((this.recipe.hashCode() * 31) + Float.hashCode(this.servings)) * 31) + this.results.hashCode();
        }

        public String toString() {
            return "ShowComparison(recipe=" + this.recipe + ", servings=" + this.servings + ", results=" + this.results + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowComparison(RecipeWithDetails recipe, float servings, List<IngredientResult> results) {
            super(null);
            Intrinsics.checkNotNullParameter(recipe, "recipe");
            Intrinsics.checkNotNullParameter(results, "results");
            this.recipe = recipe;
            this.servings = servings;
            this.results = results;
        }

        public final RecipeWithDetails getRecipe() {
            return this.recipe;
        }

        public final List<IngredientResult> getResults() {
            return this.results;
        }

        public final float getServings() {
            return this.servings;
        }
    }

    /* JADX INFO: compiled from: RecipeViewModel.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/easycompra/app/ui/recipes/CookingWorkflow$ShowSummary;", "Lcom/easycompra/app/ui/recipes/CookingWorkflow;", "recipe", "Lcom/easycompra/app/data/recipes/RecipeWithDetails;", "servings", "", "toShop", "", "Lcom/easycompra/app/data/recipes/IngredientResult;", "<init>", "(Lcom/easycompra/app/data/recipes/RecipeWithDetails;FLjava/util/List;)V", "getRecipe", "()Lcom/easycompra/app/data/recipes/RecipeWithDetails;", "getServings", "()F", "getToShop", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class ShowSummary extends CookingWorkflow {
        public static final int $stable = 8;
        private final RecipeWithDetails recipe;
        private final float servings;
        private final List<IngredientResult> toShop;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ShowSummary copy$default(ShowSummary showSummary, RecipeWithDetails recipeWithDetails, float f, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                recipeWithDetails = showSummary.recipe;
            }
            if ((i & 2) != 0) {
                f = showSummary.servings;
            }
            if ((i & 4) != 0) {
                list = showSummary.toShop;
            }
            return showSummary.copy(recipeWithDetails, f, list);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final RecipeWithDetails getRecipe() {
            return this.recipe;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getServings() {
            return this.servings;
        }

        public final List<IngredientResult> component3() {
            return this.toShop;
        }

        public final ShowSummary copy(RecipeWithDetails recipe, float servings, List<IngredientResult> toShop) {
            Intrinsics.checkNotNullParameter(recipe, "recipe");
            Intrinsics.checkNotNullParameter(toShop, "toShop");
            return new ShowSummary(recipe, servings, toShop);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShowSummary)) {
                return false;
            }
            ShowSummary showSummary = (ShowSummary) other;
            return Intrinsics.areEqual(this.recipe, showSummary.recipe) && Float.compare(this.servings, showSummary.servings) == 0 && Intrinsics.areEqual(this.toShop, showSummary.toShop);
        }

        public int hashCode() {
            return (((this.recipe.hashCode() * 31) + Float.hashCode(this.servings)) * 31) + this.toShop.hashCode();
        }

        public String toString() {
            return "ShowSummary(recipe=" + this.recipe + ", servings=" + this.servings + ", toShop=" + this.toShop + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowSummary(RecipeWithDetails recipe, float servings, List<IngredientResult> toShop) {
            super(null);
            Intrinsics.checkNotNullParameter(recipe, "recipe");
            Intrinsics.checkNotNullParameter(toShop, "toShop");
            this.recipe = recipe;
            this.servings = servings;
            this.toShop = toShop;
        }

        public final RecipeWithDetails getRecipe() {
            return this.recipe;
        }

        public final float getServings() {
            return this.servings;
        }

        public final List<IngredientResult> getToShop() {
            return this.toShop;
        }
    }
}
