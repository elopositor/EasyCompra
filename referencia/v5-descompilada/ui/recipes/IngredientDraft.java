package com.easycompra.app.ui.recipes;

import androidx.autofill.HintConstants;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateEditRecipeScreen.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003JS\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\""}, d2 = {"Lcom/easycompra/app/ui/recipes/IngredientDraft;", "", "id", "", HintConstants.AUTOFILL_HINT_NAME, "qty", "unit", "notes", "linkedProductId", "linkedProductName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getQty", "getUnit", "getNotes", "getLinkedProductId", "getLinkedProductName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
final /* data */ class IngredientDraft {
    private final String id;
    private final String linkedProductId;
    private final String linkedProductName;
    private final String name;
    private final String notes;
    private final String qty;
    private final String unit;

    public IngredientDraft() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ IngredientDraft copy$default(IngredientDraft ingredientDraft, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ingredientDraft.id;
        }
        if ((i & 2) != 0) {
            str2 = ingredientDraft.name;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = ingredientDraft.qty;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = ingredientDraft.unit;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = ingredientDraft.notes;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = ingredientDraft.linkedProductId;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = ingredientDraft.linkedProductName;
        }
        return ingredientDraft.copy(str, str8, str9, str10, str11, str12, str7);
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
    public final String getQty() {
        return this.qty;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUnit() {
        return this.unit;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getNotes() {
        return this.notes;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getLinkedProductId() {
        return this.linkedProductId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getLinkedProductName() {
        return this.linkedProductName;
    }

    public final IngredientDraft copy(String id, String name, String qty, String unit, String notes, String linkedProductId, String linkedProductName) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(qty, "qty");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(notes, "notes");
        return new IngredientDraft(id, name, qty, unit, notes, linkedProductId, linkedProductName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IngredientDraft)) {
            return false;
        }
        IngredientDraft ingredientDraft = (IngredientDraft) other;
        return Intrinsics.areEqual(this.id, ingredientDraft.id) && Intrinsics.areEqual(this.name, ingredientDraft.name) && Intrinsics.areEqual(this.qty, ingredientDraft.qty) && Intrinsics.areEqual(this.unit, ingredientDraft.unit) && Intrinsics.areEqual(this.notes, ingredientDraft.notes) && Intrinsics.areEqual(this.linkedProductId, ingredientDraft.linkedProductId) && Intrinsics.areEqual(this.linkedProductName, ingredientDraft.linkedProductName);
    }

    public int hashCode() {
        return (((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.qty.hashCode()) * 31) + this.unit.hashCode()) * 31) + this.notes.hashCode()) * 31) + (this.linkedProductId == null ? 0 : this.linkedProductId.hashCode())) * 31) + (this.linkedProductName != null ? this.linkedProductName.hashCode() : 0);
    }

    public String toString() {
        return "IngredientDraft(id=" + this.id + ", name=" + this.name + ", qty=" + this.qty + ", unit=" + this.unit + ", notes=" + this.notes + ", linkedProductId=" + this.linkedProductId + ", linkedProductName=" + this.linkedProductName + ")";
    }

    public IngredientDraft(String id, String name, String qty, String unit, String notes, String linkedProductId, String linkedProductName) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(qty, "qty");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(notes, "notes");
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.unit = unit;
        this.notes = notes;
        this.linkedProductId = linkedProductId;
        this.linkedProductName = linkedProductName;
    }

    public /* synthetic */ IngredientDraft(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? UUID.randomUUID().toString() : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "g" : str4, (i & 16) == 0 ? str5 : "", (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7);
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getQty() {
        return this.qty;
    }

    public final String getUnit() {
        return this.unit;
    }

    public final String getNotes() {
        return this.notes;
    }

    public final String getLinkedProductId() {
        return this.linkedProductId;
    }

    public final String getLinkedProductName() {
        return this.linkedProductName;
    }
}
