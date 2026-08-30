package com.easycompra.app.network;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApiModels.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/easycompra/app/network/MercadonaPrice;", "", "unitPrice", "", "referencePrice", "referenceFormat", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUnitPrice", "()Ljava/lang/String;", "getReferencePrice", "getReferenceFormat", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class MercadonaPrice {
    public static final int $stable = 0;

    @SerializedName("reference_format")
    private final String referenceFormat;

    @SerializedName("reference_price")
    private final String referencePrice;

    @SerializedName("unit_price")
    private final String unitPrice;

    public static /* synthetic */ MercadonaPrice copy$default(MercadonaPrice mercadonaPrice, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mercadonaPrice.unitPrice;
        }
        if ((i & 2) != 0) {
            str2 = mercadonaPrice.referencePrice;
        }
        if ((i & 4) != 0) {
            str3 = mercadonaPrice.referenceFormat;
        }
        return mercadonaPrice.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUnitPrice() {
        return this.unitPrice;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getReferencePrice() {
        return this.referencePrice;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getReferenceFormat() {
        return this.referenceFormat;
    }

    public final MercadonaPrice copy(String unitPrice, String referencePrice, String referenceFormat) {
        return new MercadonaPrice(unitPrice, referencePrice, referenceFormat);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MercadonaPrice)) {
            return false;
        }
        MercadonaPrice mercadonaPrice = (MercadonaPrice) other;
        return Intrinsics.areEqual(this.unitPrice, mercadonaPrice.unitPrice) && Intrinsics.areEqual(this.referencePrice, mercadonaPrice.referencePrice) && Intrinsics.areEqual(this.referenceFormat, mercadonaPrice.referenceFormat);
    }

    public int hashCode() {
        return ((((this.unitPrice == null ? 0 : this.unitPrice.hashCode()) * 31) + (this.referencePrice == null ? 0 : this.referencePrice.hashCode())) * 31) + (this.referenceFormat != null ? this.referenceFormat.hashCode() : 0);
    }

    public String toString() {
        return "MercadonaPrice(unitPrice=" + this.unitPrice + ", referencePrice=" + this.referencePrice + ", referenceFormat=" + this.referenceFormat + ")";
    }

    public MercadonaPrice(String unitPrice, String referencePrice, String referenceFormat) {
        this.unitPrice = unitPrice;
        this.referencePrice = referencePrice;
        this.referenceFormat = referenceFormat;
    }

    public final String getUnitPrice() {
        return this.unitPrice;
    }

    public final String getReferencePrice() {
        return this.referencePrice;
    }

    public final String getReferenceFormat() {
        return this.referenceFormat;
    }
}
