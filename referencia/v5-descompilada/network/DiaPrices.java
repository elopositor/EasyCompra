package com.easycompra.app.network;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApiModels.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/easycompra/app/network/DiaPrices;", "", "price", "", "pricePerUnit", "measureUnit", "", "<init>", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;)V", "getPrice", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getPricePerUnit", "getMeasureUnit", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;)Lcom/easycompra/app/network/DiaPrices;", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class DiaPrices {
    public static final int $stable = 0;

    @SerializedName("measure_unit")
    private final String measureUnit;
    private final Double price;

    @SerializedName("price_per_unit")
    private final Double pricePerUnit;

    public static /* synthetic */ DiaPrices copy$default(DiaPrices diaPrices, Double d, Double d2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            d = diaPrices.price;
        }
        if ((i & 2) != 0) {
            d2 = diaPrices.pricePerUnit;
        }
        if ((i & 4) != 0) {
            str = diaPrices.measureUnit;
        }
        return diaPrices.copy(d, d2, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Double getPrice() {
        return this.price;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Double getPricePerUnit() {
        return this.pricePerUnit;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMeasureUnit() {
        return this.measureUnit;
    }

    public final DiaPrices copy(Double price, Double pricePerUnit, String measureUnit) {
        return new DiaPrices(price, pricePerUnit, measureUnit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DiaPrices)) {
            return false;
        }
        DiaPrices diaPrices = (DiaPrices) other;
        return Intrinsics.areEqual((Object) this.price, (Object) diaPrices.price) && Intrinsics.areEqual((Object) this.pricePerUnit, (Object) diaPrices.pricePerUnit) && Intrinsics.areEqual(this.measureUnit, diaPrices.measureUnit);
    }

    public int hashCode() {
        return ((((this.price == null ? 0 : this.price.hashCode()) * 31) + (this.pricePerUnit == null ? 0 : this.pricePerUnit.hashCode())) * 31) + (this.measureUnit != null ? this.measureUnit.hashCode() : 0);
    }

    public String toString() {
        return "DiaPrices(price=" + this.price + ", pricePerUnit=" + this.pricePerUnit + ", measureUnit=" + this.measureUnit + ")";
    }

    public DiaPrices(Double price, Double pricePerUnit, String measureUnit) {
        this.price = price;
        this.pricePerUnit = pricePerUnit;
        this.measureUnit = measureUnit;
    }

    public final Double getPrice() {
        return this.price;
    }

    public final Double getPricePerUnit() {
        return this.pricePerUnit;
    }

    public final String getMeasureUnit() {
        return this.measureUnit;
    }
}
