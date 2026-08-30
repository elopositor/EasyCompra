package com.easycompra.app.network;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApiModels.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/easycompra/app/network/MercadonaNutrition;", "", "ingredients", "", "allergens", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getIngredients", "()Ljava/lang/String;", "getAllergens", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class MercadonaNutrition {
    public static final int $stable = 0;
    private final String allergens;
    private final String ingredients;

    public static /* synthetic */ MercadonaNutrition copy$default(MercadonaNutrition mercadonaNutrition, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mercadonaNutrition.ingredients;
        }
        if ((i & 2) != 0) {
            str2 = mercadonaNutrition.allergens;
        }
        return mercadonaNutrition.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getIngredients() {
        return this.ingredients;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAllergens() {
        return this.allergens;
    }

    public final MercadonaNutrition copy(String ingredients, String allergens) {
        return new MercadonaNutrition(ingredients, allergens);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MercadonaNutrition)) {
            return false;
        }
        MercadonaNutrition mercadonaNutrition = (MercadonaNutrition) other;
        return Intrinsics.areEqual(this.ingredients, mercadonaNutrition.ingredients) && Intrinsics.areEqual(this.allergens, mercadonaNutrition.allergens);
    }

    public int hashCode() {
        return ((this.ingredients == null ? 0 : this.ingredients.hashCode()) * 31) + (this.allergens != null ? this.allergens.hashCode() : 0);
    }

    public String toString() {
        return "MercadonaNutrition(ingredients=" + this.ingredients + ", allergens=" + this.allergens + ")";
    }

    public MercadonaNutrition(String ingredients, String allergens) {
        this.ingredients = ingredients;
        this.allergens = allergens;
    }

    public final String getIngredients() {
        return this.ingredients;
    }

    public final String getAllergens() {
        return this.allergens;
    }
}
