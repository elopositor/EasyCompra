package com.easycompra.app.data.recipes;

import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IngredientEntity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003JQ\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006$"}, d2 = {"Lcom/easycompra/app/data/recipes/IngredientEntity;", "", "id", "", "recipeId", HintConstants.AUTOFILL_HINT_NAME, "baseQuantity", "", "unit", "linkedProductId", "ingredientNotes", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getRecipeId", "getName", "getBaseQuantity", "()F", "getUnit", "getLinkedProductId", "getIngredientNotes", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class IngredientEntity {
    public static final int $stable = 0;
    private final float baseQuantity;
    private final String id;
    private final String ingredientNotes;
    private final String linkedProductId;
    private final String name;
    private final String recipeId;
    private final String unit;

    public static /* synthetic */ IngredientEntity copy$default(IngredientEntity ingredientEntity, String str, String str2, String str3, float f, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ingredientEntity.id;
        }
        if ((i & 2) != 0) {
            str2 = ingredientEntity.recipeId;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = ingredientEntity.name;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            f = ingredientEntity.baseQuantity;
        }
        float f2 = f;
        if ((i & 16) != 0) {
            str4 = ingredientEntity.unit;
        }
        String str9 = str4;
        if ((i & 32) != 0) {
            str5 = ingredientEntity.linkedProductId;
        }
        String str10 = str5;
        if ((i & 64) != 0) {
            str6 = ingredientEntity.ingredientNotes;
        }
        return ingredientEntity.copy(str, str7, str8, f2, str9, str10, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRecipeId() {
        return this.recipeId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final float getBaseQuantity() {
        return this.baseQuantity;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getUnit() {
        return this.unit;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getLinkedProductId() {
        return this.linkedProductId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getIngredientNotes() {
        return this.ingredientNotes;
    }

    public final IngredientEntity copy(String id, String recipeId, String name, float baseQuantity, String unit, String linkedProductId, String ingredientNotes) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(recipeId, "recipeId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(ingredientNotes, "ingredientNotes");
        return new IngredientEntity(id, recipeId, name, baseQuantity, unit, linkedProductId, ingredientNotes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IngredientEntity)) {
            return false;
        }
        IngredientEntity ingredientEntity = (IngredientEntity) other;
        return Intrinsics.areEqual(this.id, ingredientEntity.id) && Intrinsics.areEqual(this.recipeId, ingredientEntity.recipeId) && Intrinsics.areEqual(this.name, ingredientEntity.name) && Float.compare(this.baseQuantity, ingredientEntity.baseQuantity) == 0 && Intrinsics.areEqual(this.unit, ingredientEntity.unit) && Intrinsics.areEqual(this.linkedProductId, ingredientEntity.linkedProductId) && Intrinsics.areEqual(this.ingredientNotes, ingredientEntity.ingredientNotes);
    }

    public int hashCode() {
        return (((((((((((this.id.hashCode() * 31) + this.recipeId.hashCode()) * 31) + this.name.hashCode()) * 31) + Float.hashCode(this.baseQuantity)) * 31) + this.unit.hashCode()) * 31) + (this.linkedProductId == null ? 0 : this.linkedProductId.hashCode())) * 31) + this.ingredientNotes.hashCode();
    }

    public String toString() {
        return "IngredientEntity(id=" + this.id + ", recipeId=" + this.recipeId + ", name=" + this.name + ", baseQuantity=" + this.baseQuantity + ", unit=" + this.unit + ", linkedProductId=" + this.linkedProductId + ", ingredientNotes=" + this.ingredientNotes + ")";
    }

    public IngredientEntity(String id, String recipeId, String name, float baseQuantity, String unit, String linkedProductId, String ingredientNotes) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(recipeId, "recipeId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(ingredientNotes, "ingredientNotes");
        this.id = id;
        this.recipeId = recipeId;
        this.name = name;
        this.baseQuantity = baseQuantity;
        this.unit = unit;
        this.linkedProductId = linkedProductId;
        this.ingredientNotes = ingredientNotes;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ IngredientEntity(String str, String str2, String str3, float f, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        String str7;
        String str8;
        if ((i & 32) == 0) {
            str7 = str5;
        } else {
            str7 = null;
        }
        if ((i & 64) == 0) {
            str8 = str6;
        } else {
            str8 = "";
        }
        this(str, str2, str3, f, str4, str7, str8);
    }

    public final String getId() {
        return this.id;
    }

    public final String getRecipeId() {
        return this.recipeId;
    }

    public final String getName() {
        return this.name;
    }

    public final float getBaseQuantity() {
        return this.baseQuantity;
    }

    public final String getUnit() {
        return this.unit;
    }

    public final String getLinkedProductId() {
        return this.linkedProductId;
    }

    public final String getIngredientNotes() {
        return this.ingredientNotes;
    }
}
