package com.easycompra.app.network;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApiModels.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/easycompra/app/network/MercadonaProductSummary;", "", "id", "", "thumbnail", "displayName", "priceInstructions", "Lcom/easycompra/app/network/MercadonaPrice;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/easycompra/app/network/MercadonaPrice;)V", "getId", "()Ljava/lang/String;", "getThumbnail", "getDisplayName", "getPriceInstructions", "()Lcom/easycompra/app/network/MercadonaPrice;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class MercadonaProductSummary {
    public static final int $stable = 0;

    @SerializedName("display_name")
    private final String displayName;
    private final String id;

    @SerializedName("price_instructions")
    private final MercadonaPrice priceInstructions;
    private final String thumbnail;

    public static /* synthetic */ MercadonaProductSummary copy$default(MercadonaProductSummary mercadonaProductSummary, String str, String str2, String str3, MercadonaPrice mercadonaPrice, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mercadonaProductSummary.id;
        }
        if ((i & 2) != 0) {
            str2 = mercadonaProductSummary.thumbnail;
        }
        if ((i & 4) != 0) {
            str3 = mercadonaProductSummary.displayName;
        }
        if ((i & 8) != 0) {
            mercadonaPrice = mercadonaProductSummary.priceInstructions;
        }
        return mercadonaProductSummary.copy(str, str2, str3, mercadonaPrice);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getThumbnail() {
        return this.thumbnail;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final MercadonaPrice getPriceInstructions() {
        return this.priceInstructions;
    }

    public final MercadonaProductSummary copy(String id, String thumbnail, String displayName, MercadonaPrice priceInstructions) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        return new MercadonaProductSummary(id, thumbnail, displayName, priceInstructions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MercadonaProductSummary)) {
            return false;
        }
        MercadonaProductSummary mercadonaProductSummary = (MercadonaProductSummary) other;
        return Intrinsics.areEqual(this.id, mercadonaProductSummary.id) && Intrinsics.areEqual(this.thumbnail, mercadonaProductSummary.thumbnail) && Intrinsics.areEqual(this.displayName, mercadonaProductSummary.displayName) && Intrinsics.areEqual(this.priceInstructions, mercadonaProductSummary.priceInstructions);
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + (this.thumbnail == null ? 0 : this.thumbnail.hashCode())) * 31) + this.displayName.hashCode()) * 31) + (this.priceInstructions != null ? this.priceInstructions.hashCode() : 0);
    }

    public String toString() {
        return "MercadonaProductSummary(id=" + this.id + ", thumbnail=" + this.thumbnail + ", displayName=" + this.displayName + ", priceInstructions=" + this.priceInstructions + ")";
    }

    public MercadonaProductSummary(String id, String thumbnail, String displayName, MercadonaPrice priceInstructions) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        this.id = id;
        this.thumbnail = thumbnail;
        this.displayName = displayName;
        this.priceInstructions = priceInstructions;
    }

    public final String getId() {
        return this.id;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final MercadonaPrice getPriceInstructions() {
        return this.priceInstructions;
    }
}
