package com.easycompra.app.data.recipes;

import androidx.autofill.HintConstants;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecipeShoppingStore.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/easycompra/app/data/recipes/RecipeShoppingItem;", "", "id", "", HintConstants.AUTOFILL_HINT_NAME, "quantity", "", "unit", "fromRecipe", "<init>", "(Ljava/lang/String;Ljava/lang/String;FLjava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getQuantity", "()F", "getUnit", "getFromRecipe", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class RecipeShoppingItem {
    public static final int $stable = 0;
    private final String fromRecipe;
    private final String id;
    private final String name;
    private final float quantity;
    private final String unit;

    public static /* synthetic */ RecipeShoppingItem copy$default(RecipeShoppingItem recipeShoppingItem, String str, String str2, float f, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = recipeShoppingItem.id;
        }
        if ((i & 2) != 0) {
            str2 = recipeShoppingItem.name;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            f = recipeShoppingItem.quantity;
        }
        float f2 = f;
        if ((i & 8) != 0) {
            str3 = recipeShoppingItem.unit;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            str4 = recipeShoppingItem.fromRecipe;
        }
        return recipeShoppingItem.copy(str, str5, f2, str6, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getQuantity() {
        return this.quantity;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUnit() {
        return this.unit;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getFromRecipe() {
        return this.fromRecipe;
    }

    public final RecipeShoppingItem copy(String id, String name, float quantity, String unit, String fromRecipe) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(fromRecipe, "fromRecipe");
        return new RecipeShoppingItem(id, name, quantity, unit, fromRecipe);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecipeShoppingItem)) {
            return false;
        }
        RecipeShoppingItem recipeShoppingItem = (RecipeShoppingItem) other;
        return Intrinsics.areEqual(this.id, recipeShoppingItem.id) && Intrinsics.areEqual(this.name, recipeShoppingItem.name) && Float.compare(this.quantity, recipeShoppingItem.quantity) == 0 && Intrinsics.areEqual(this.unit, recipeShoppingItem.unit) && Intrinsics.areEqual(this.fromRecipe, recipeShoppingItem.fromRecipe);
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + Float.hashCode(this.quantity)) * 31) + this.unit.hashCode()) * 31) + this.fromRecipe.hashCode();
    }

    public String toString() {
        return "RecipeShoppingItem(id=" + this.id + ", name=" + this.name + ", quantity=" + this.quantity + ", unit=" + this.unit + ", fromRecipe=" + this.fromRecipe + ")";
    }

    public RecipeShoppingItem(String id, String name, float quantity, String unit, String fromRecipe) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(fromRecipe, "fromRecipe");
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.fromRecipe = fromRecipe;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ RecipeShoppingItem(String str, String str2, float f, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        String string;
        if ((i & 1) == 0) {
            string = str;
        } else {
            string = UUID.randomUUID().toString();
        }
        this(string, str2, f, str3, str4);
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final float getQuantity() {
        return this.quantity;
    }

    public final String getUnit() {
        return this.unit;
    }

    public final String getFromRecipe() {
        return this.fromRecipe;
    }
}
