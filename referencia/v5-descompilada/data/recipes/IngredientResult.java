package com.easycompra.app.data.recipes;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecipeRepository.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/easycompra/app/data/recipes/IngredientResult;", "", "ingredient", "Lcom/easycompra/app/data/recipes/IngredientEntity;", "scaledQuantity", "", NotificationCompat.CATEGORY_STATUS, "Lcom/easycompra/app/data/recipes/IngredientStatus;", "addToCart", "", "<init>", "(Lcom/easycompra/app/data/recipes/IngredientEntity;FLcom/easycompra/app/data/recipes/IngredientStatus;Z)V", "getIngredient", "()Lcom/easycompra/app/data/recipes/IngredientEntity;", "getScaledQuantity", "()F", "getStatus", "()Lcom/easycompra/app/data/recipes/IngredientStatus;", "getAddToCart", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class IngredientResult {
    public static final int $stable = 0;
    private final boolean addToCart;
    private final IngredientEntity ingredient;
    private final float scaledQuantity;
    private final IngredientStatus status;

    public static /* synthetic */ IngredientResult copy$default(IngredientResult ingredientResult, IngredientEntity ingredientEntity, float f, IngredientStatus ingredientStatus, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            ingredientEntity = ingredientResult.ingredient;
        }
        if ((i & 2) != 0) {
            f = ingredientResult.scaledQuantity;
        }
        if ((i & 4) != 0) {
            ingredientStatus = ingredientResult.status;
        }
        if ((i & 8) != 0) {
            z = ingredientResult.addToCart;
        }
        return ingredientResult.copy(ingredientEntity, f, ingredientStatus, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final IngredientEntity getIngredient() {
        return this.ingredient;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final float getScaledQuantity() {
        return this.scaledQuantity;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final IngredientStatus getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getAddToCart() {
        return this.addToCart;
    }

    public final IngredientResult copy(IngredientEntity ingredient, float scaledQuantity, IngredientStatus status, boolean addToCart) {
        Intrinsics.checkNotNullParameter(ingredient, "ingredient");
        Intrinsics.checkNotNullParameter(status, "status");
        return new IngredientResult(ingredient, scaledQuantity, status, addToCart);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IngredientResult)) {
            return false;
        }
        IngredientResult ingredientResult = (IngredientResult) other;
        return Intrinsics.areEqual(this.ingredient, ingredientResult.ingredient) && Float.compare(this.scaledQuantity, ingredientResult.scaledQuantity) == 0 && Intrinsics.areEqual(this.status, ingredientResult.status) && this.addToCart == ingredientResult.addToCart;
    }

    public int hashCode() {
        return (((((this.ingredient.hashCode() * 31) + Float.hashCode(this.scaledQuantity)) * 31) + this.status.hashCode()) * 31) + Boolean.hashCode(this.addToCart);
    }

    public String toString() {
        return "IngredientResult(ingredient=" + this.ingredient + ", scaledQuantity=" + this.scaledQuantity + ", status=" + this.status + ", addToCart=" + this.addToCart + ")";
    }

    public IngredientResult(IngredientEntity ingredient, float scaledQuantity, IngredientStatus status, boolean addToCart) {
        Intrinsics.checkNotNullParameter(ingredient, "ingredient");
        Intrinsics.checkNotNullParameter(status, "status");
        this.ingredient = ingredient;
        this.scaledQuantity = scaledQuantity;
        this.status = status;
        this.addToCart = addToCart;
    }

    public /* synthetic */ IngredientResult(IngredientEntity ingredientEntity, float f, IngredientStatus ingredientStatus, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(ingredientEntity, f, ingredientStatus, (i & 8) != 0 ? true : z);
    }

    public final IngredientEntity getIngredient() {
        return this.ingredient;
    }

    public final float getScaledQuantity() {
        return this.scaledQuantity;
    }

    public final IngredientStatus getStatus() {
        return this.status;
    }

    public final boolean getAddToCart() {
        return this.addToCart;
    }
}
