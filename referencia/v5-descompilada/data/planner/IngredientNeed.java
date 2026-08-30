package com.easycompra.app.data.planner;

import androidx.autofill.HintConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlannerEntry.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003JC\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006 "}, d2 = {"Lcom/easycompra/app/data/planner/IngredientNeed;", "", HintConstants.AUTOFILL_HINT_NAME, "", "unit", "deficit", "", "recipeNames", "", "linkedProductId", "<init>", "(Ljava/lang/String;Ljava/lang/String;FLjava/util/List;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getUnit", "getDeficit", "()F", "getRecipeNames", "()Ljava/util/List;", "getLinkedProductId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class IngredientNeed {
    public static final int $stable = 8;
    private final float deficit;
    private final String linkedProductId;
    private final String name;
    private final List<String> recipeNames;
    private final String unit;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IngredientNeed copy$default(IngredientNeed ingredientNeed, String str, String str2, float f, List list, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ingredientNeed.name;
        }
        if ((i & 2) != 0) {
            str2 = ingredientNeed.unit;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            f = ingredientNeed.deficit;
        }
        float f2 = f;
        if ((i & 8) != 0) {
            list = ingredientNeed.recipeNames;
        }
        List list2 = list;
        if ((i & 16) != 0) {
            str3 = ingredientNeed.linkedProductId;
        }
        return ingredientNeed.copy(str, str4, f2, list2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUnit() {
        return this.unit;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final float getDeficit() {
        return this.deficit;
    }

    public final List<String> component4() {
        return this.recipeNames;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLinkedProductId() {
        return this.linkedProductId;
    }

    public final IngredientNeed copy(String name, String unit, float deficit, List<String> recipeNames, String linkedProductId) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(recipeNames, "recipeNames");
        return new IngredientNeed(name, unit, deficit, recipeNames, linkedProductId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IngredientNeed)) {
            return false;
        }
        IngredientNeed ingredientNeed = (IngredientNeed) other;
        return Intrinsics.areEqual(this.name, ingredientNeed.name) && Intrinsics.areEqual(this.unit, ingredientNeed.unit) && Float.compare(this.deficit, ingredientNeed.deficit) == 0 && Intrinsics.areEqual(this.recipeNames, ingredientNeed.recipeNames) && Intrinsics.areEqual(this.linkedProductId, ingredientNeed.linkedProductId);
    }

    public int hashCode() {
        return (((((((this.name.hashCode() * 31) + this.unit.hashCode()) * 31) + Float.hashCode(this.deficit)) * 31) + this.recipeNames.hashCode()) * 31) + (this.linkedProductId == null ? 0 : this.linkedProductId.hashCode());
    }

    public String toString() {
        return "IngredientNeed(name=" + this.name + ", unit=" + this.unit + ", deficit=" + this.deficit + ", recipeNames=" + this.recipeNames + ", linkedProductId=" + this.linkedProductId + ")";
    }

    public IngredientNeed(String name, String unit, float deficit, List<String> recipeNames, String linkedProductId) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(recipeNames, "recipeNames");
        this.name = name;
        this.unit = unit;
        this.deficit = deficit;
        this.recipeNames = recipeNames;
        this.linkedProductId = linkedProductId;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ IngredientNeed(String str, String str2, float f, List list, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        String str4;
        if ((i & 16) == 0) {
            str4 = str3;
        } else {
            str4 = null;
        }
        this(str, str2, f, list, str4);
    }

    public final String getName() {
        return this.name;
    }

    public final String getUnit() {
        return this.unit;
    }

    public final float getDeficit() {
        return this.deficit;
    }

    public final List<String> getRecipeNames() {
        return this.recipeNames;
    }

    public final String getLinkedProductId() {
        return this.linkedProductId;
    }
}
