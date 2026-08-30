package com.easycompra.app.network;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApiModels.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J,\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/easycompra/app/network/DiaNutritionalValues;", "", "energyValue", "", "values", "", "Lcom/easycompra/app/network/DiaNutrientEntry;", "<init>", "(Ljava/lang/Double;Ljava/util/List;)V", "getEnergyValue", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getValues", "()Ljava/util/List;", "component1", "component2", "copy", "(Ljava/lang/Double;Ljava/util/List;)Lcom/easycompra/app/network/DiaNutritionalValues;", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class DiaNutritionalValues {
    public static final int $stable = 8;

    @SerializedName("energy_value")
    private final Double energyValue;
    private final List<DiaNutrientEntry> values;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DiaNutritionalValues copy$default(DiaNutritionalValues diaNutritionalValues, Double d, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            d = diaNutritionalValues.energyValue;
        }
        if ((i & 2) != 0) {
            list = diaNutritionalValues.values;
        }
        return diaNutritionalValues.copy(d, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Double getEnergyValue() {
        return this.energyValue;
    }

    public final List<DiaNutrientEntry> component2() {
        return this.values;
    }

    public final DiaNutritionalValues copy(Double energyValue, List<DiaNutrientEntry> values) {
        return new DiaNutritionalValues(energyValue, values);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DiaNutritionalValues)) {
            return false;
        }
        DiaNutritionalValues diaNutritionalValues = (DiaNutritionalValues) other;
        return Intrinsics.areEqual((Object) this.energyValue, (Object) diaNutritionalValues.energyValue) && Intrinsics.areEqual(this.values, diaNutritionalValues.values);
    }

    public int hashCode() {
        return ((this.energyValue == null ? 0 : this.energyValue.hashCode()) * 31) + (this.values != null ? this.values.hashCode() : 0);
    }

    public String toString() {
        return "DiaNutritionalValues(energyValue=" + this.energyValue + ", values=" + this.values + ")";
    }

    public DiaNutritionalValues(Double energyValue, List<DiaNutrientEntry> list) {
        this.energyValue = energyValue;
        this.values = list;
    }

    public final Double getEnergyValue() {
        return this.energyValue;
    }

    public final List<DiaNutrientEntry> getValues() {
        return this.values;
    }
}
