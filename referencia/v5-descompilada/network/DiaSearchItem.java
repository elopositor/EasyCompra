package com.easycompra.app.network;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApiModels.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JM\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006!"}, d2 = {"Lcom/easycompra/app/network/DiaSearchItem;", "", "objectId", "", "displayName", "brand", "image", "prices", "Lcom/easycompra/app/network/DiaPrices;", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/easycompra/app/network/DiaPrices;Ljava/lang/String;)V", "getObjectId", "()Ljava/lang/String;", "getDisplayName", "getBrand", "getImage", "getPrices", "()Lcom/easycompra/app/network/DiaPrices;", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class DiaSearchItem {
    public static final int $stable = 0;
    private final String brand;

    @SerializedName("display_name")
    private final String displayName;
    private final String image;

    @SerializedName("object_id")
    private final String objectId;
    private final DiaPrices prices;
    private final String url;

    public static /* synthetic */ DiaSearchItem copy$default(DiaSearchItem diaSearchItem, String str, String str2, String str3, String str4, DiaPrices diaPrices, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = diaSearchItem.objectId;
        }
        if ((i & 2) != 0) {
            str2 = diaSearchItem.displayName;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = diaSearchItem.brand;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = diaSearchItem.image;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            diaPrices = diaSearchItem.prices;
        }
        DiaPrices diaPrices2 = diaPrices;
        if ((i & 32) != 0) {
            str5 = diaSearchItem.url;
        }
        return diaSearchItem.copy(str, str6, str7, str8, diaPrices2, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getObjectId() {
        return this.objectId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getBrand() {
        return this.brand;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final DiaPrices getPrices() {
        return this.prices;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final DiaSearchItem copy(String objectId, String displayName, String brand, String image, DiaPrices prices, String url) {
        Intrinsics.checkNotNullParameter(objectId, "objectId");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        return new DiaSearchItem(objectId, displayName, brand, image, prices, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DiaSearchItem)) {
            return false;
        }
        DiaSearchItem diaSearchItem = (DiaSearchItem) other;
        return Intrinsics.areEqual(this.objectId, diaSearchItem.objectId) && Intrinsics.areEqual(this.displayName, diaSearchItem.displayName) && Intrinsics.areEqual(this.brand, diaSearchItem.brand) && Intrinsics.areEqual(this.image, diaSearchItem.image) && Intrinsics.areEqual(this.prices, diaSearchItem.prices) && Intrinsics.areEqual(this.url, diaSearchItem.url);
    }

    public int hashCode() {
        return (((((((((this.objectId.hashCode() * 31) + this.displayName.hashCode()) * 31) + (this.brand == null ? 0 : this.brand.hashCode())) * 31) + (this.image == null ? 0 : this.image.hashCode())) * 31) + (this.prices == null ? 0 : this.prices.hashCode())) * 31) + (this.url != null ? this.url.hashCode() : 0);
    }

    public String toString() {
        return "DiaSearchItem(objectId=" + this.objectId + ", displayName=" + this.displayName + ", brand=" + this.brand + ", image=" + this.image + ", prices=" + this.prices + ", url=" + this.url + ")";
    }

    public DiaSearchItem(String objectId, String displayName, String brand, String image, DiaPrices prices, String url) {
        Intrinsics.checkNotNullParameter(objectId, "objectId");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        this.objectId = objectId;
        this.displayName = displayName;
        this.brand = brand;
        this.image = image;
        this.prices = prices;
        this.url = url;
    }

    public final String getObjectId() {
        return this.objectId;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getBrand() {
        return this.brand;
    }

    public final String getImage() {
        return this.image;
    }

    public final DiaPrices getPrices() {
        return this.prices;
    }

    public final String getUrl() {
        return this.url;
    }
}
