package com.easycompra.app.network;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApiModels.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJb\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0011\u0010\rR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\rR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0014\u0010\r¨\u0006%"}, d2 = {"Lcom/easycompra/app/network/OffNutriments;", "", "energyKcal100g", "", "fat100g", "saturatedFat100g", "carbohydrates100g", "sugars100g", "proteins100g", "salt100g", "<init>", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V", "getEnergyKcal100g", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getFat100g", "getSaturatedFat100g", "getCarbohydrates100g", "getSugars100g", "getProteins100g", "getSalt100g", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)Lcom/easycompra/app/network/OffNutriments;", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class OffNutriments {
    public static final int $stable = 0;

    @SerializedName("carbohydrates_100g")
    private final Double carbohydrates100g;

    @SerializedName("energy-kcal_100g")
    private final Double energyKcal100g;

    @SerializedName("fat_100g")
    private final Double fat100g;

    @SerializedName("proteins_100g")
    private final Double proteins100g;

    @SerializedName("salt_100g")
    private final Double salt100g;

    @SerializedName("saturated-fat_100g")
    private final Double saturatedFat100g;

    @SerializedName("sugars_100g")
    private final Double sugars100g;

    public static /* synthetic */ OffNutriments copy$default(OffNutriments offNutriments, Double d, Double d2, Double d3, Double d4, Double d5, Double d6, Double d7, int i, Object obj) {
        if ((i & 1) != 0) {
            d = offNutriments.energyKcal100g;
        }
        if ((i & 2) != 0) {
            d2 = offNutriments.fat100g;
        }
        Double d8 = d2;
        if ((i & 4) != 0) {
            d3 = offNutriments.saturatedFat100g;
        }
        Double d9 = d3;
        if ((i & 8) != 0) {
            d4 = offNutriments.carbohydrates100g;
        }
        Double d10 = d4;
        if ((i & 16) != 0) {
            d5 = offNutriments.sugars100g;
        }
        Double d11 = d5;
        if ((i & 32) != 0) {
            d6 = offNutriments.proteins100g;
        }
        Double d12 = d6;
        if ((i & 64) != 0) {
            d7 = offNutriments.salt100g;
        }
        return offNutriments.copy(d, d8, d9, d10, d11, d12, d7);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Double getEnergyKcal100g() {
        return this.energyKcal100g;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Double getFat100g() {
        return this.fat100g;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Double getSaturatedFat100g() {
        return this.saturatedFat100g;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Double getCarbohydrates100g() {
        return this.carbohydrates100g;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Double getSugars100g() {
        return this.sugars100g;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Double getProteins100g() {
        return this.proteins100g;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Double getSalt100g() {
        return this.salt100g;
    }

    public final OffNutriments copy(Double energyKcal100g, Double fat100g, Double saturatedFat100g, Double carbohydrates100g, Double sugars100g, Double proteins100g, Double salt100g) {
        return new OffNutriments(energyKcal100g, fat100g, saturatedFat100g, carbohydrates100g, sugars100g, proteins100g, salt100g);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OffNutriments)) {
            return false;
        }
        OffNutriments offNutriments = (OffNutriments) other;
        return Intrinsics.areEqual((Object) this.energyKcal100g, (Object) offNutriments.energyKcal100g) && Intrinsics.areEqual((Object) this.fat100g, (Object) offNutriments.fat100g) && Intrinsics.areEqual((Object) this.saturatedFat100g, (Object) offNutriments.saturatedFat100g) && Intrinsics.areEqual((Object) this.carbohydrates100g, (Object) offNutriments.carbohydrates100g) && Intrinsics.areEqual((Object) this.sugars100g, (Object) offNutriments.sugars100g) && Intrinsics.areEqual((Object) this.proteins100g, (Object) offNutriments.proteins100g) && Intrinsics.areEqual((Object) this.salt100g, (Object) offNutriments.salt100g);
    }

    public int hashCode() {
        return ((((((((((((this.energyKcal100g == null ? 0 : this.energyKcal100g.hashCode()) * 31) + (this.fat100g == null ? 0 : this.fat100g.hashCode())) * 31) + (this.saturatedFat100g == null ? 0 : this.saturatedFat100g.hashCode())) * 31) + (this.carbohydrates100g == null ? 0 : this.carbohydrates100g.hashCode())) * 31) + (this.sugars100g == null ? 0 : this.sugars100g.hashCode())) * 31) + (this.proteins100g == null ? 0 : this.proteins100g.hashCode())) * 31) + (this.salt100g != null ? this.salt100g.hashCode() : 0);
    }

    public String toString() {
        return "OffNutriments(energyKcal100g=" + this.energyKcal100g + ", fat100g=" + this.fat100g + ", saturatedFat100g=" + this.saturatedFat100g + ", carbohydrates100g=" + this.carbohydrates100g + ", sugars100g=" + this.sugars100g + ", proteins100g=" + this.proteins100g + ", salt100g=" + this.salt100g + ")";
    }

    public OffNutriments(Double energyKcal100g, Double fat100g, Double saturatedFat100g, Double carbohydrates100g, Double sugars100g, Double proteins100g, Double salt100g) {
        this.energyKcal100g = energyKcal100g;
        this.fat100g = fat100g;
        this.saturatedFat100g = saturatedFat100g;
        this.carbohydrates100g = carbohydrates100g;
        this.sugars100g = sugars100g;
        this.proteins100g = proteins100g;
        this.salt100g = salt100g;
    }

    public final Double getEnergyKcal100g() {
        return this.energyKcal100g;
    }

    public final Double getFat100g() {
        return this.fat100g;
    }

    public final Double getSaturatedFat100g() {
        return this.saturatedFat100g;
    }

    public final Double getCarbohydrates100g() {
        return this.carbohydrates100g;
    }

    public final Double getSugars100g() {
        return this.sugars100g;
    }

    public final Double getProteins100g() {
        return this.proteins100g;
    }

    public final Double getSalt100g() {
        return this.salt100g;
    }
}
