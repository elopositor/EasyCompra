package com.easycompra.app.network;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApiModels.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jw\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014¨\u00061"}, d2 = {"Lcom/easycompra/app/network/MercadonaProductDetail;", "", "id", "", "ean", "displayName", "thumbnail", "photos", "", "Lcom/easycompra/app/network/MercadonaPhoto;", "details", "Lcom/easycompra/app/network/MercadonaDetails;", "priceInstructions", "Lcom/easycompra/app/network/MercadonaPrice;", "nutritionInformation", "Lcom/easycompra/app/network/MercadonaNutrition;", "shareUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/easycompra/app/network/MercadonaDetails;Lcom/easycompra/app/network/MercadonaPrice;Lcom/easycompra/app/network/MercadonaNutrition;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getEan", "getDisplayName", "getThumbnail", "getPhotos", "()Ljava/util/List;", "getDetails", "()Lcom/easycompra/app/network/MercadonaDetails;", "getPriceInstructions", "()Lcom/easycompra/app/network/MercadonaPrice;", "getNutritionInformation", "()Lcom/easycompra/app/network/MercadonaNutrition;", "getShareUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class MercadonaProductDetail {
    public static final int $stable = 8;
    private final MercadonaDetails details;

    @SerializedName("display_name")
    private final String displayName;
    private final String ean;
    private final String id;

    @SerializedName("nutrition_information")
    private final MercadonaNutrition nutritionInformation;
    private final List<MercadonaPhoto> photos;

    @SerializedName("price_instructions")
    private final MercadonaPrice priceInstructions;

    @SerializedName("share_url")
    private final String shareUrl;
    private final String thumbnail;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEan() {
        return this.ean;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final List<MercadonaPhoto> component5() {
        return this.photos;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final MercadonaDetails getDetails() {
        return this.details;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final MercadonaPrice getPriceInstructions() {
        return this.priceInstructions;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final MercadonaNutrition getNutritionInformation() {
        return this.nutritionInformation;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getShareUrl() {
        return this.shareUrl;
    }

    public final MercadonaProductDetail copy(String id, String ean, String displayName, String thumbnail, List<MercadonaPhoto> photos, MercadonaDetails details, MercadonaPrice priceInstructions, MercadonaNutrition nutritionInformation, String shareUrl) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        return new MercadonaProductDetail(id, ean, displayName, thumbnail, photos, details, priceInstructions, nutritionInformation, shareUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MercadonaProductDetail)) {
            return false;
        }
        MercadonaProductDetail mercadonaProductDetail = (MercadonaProductDetail) other;
        return Intrinsics.areEqual(this.id, mercadonaProductDetail.id) && Intrinsics.areEqual(this.ean, mercadonaProductDetail.ean) && Intrinsics.areEqual(this.displayName, mercadonaProductDetail.displayName) && Intrinsics.areEqual(this.thumbnail, mercadonaProductDetail.thumbnail) && Intrinsics.areEqual(this.photos, mercadonaProductDetail.photos) && Intrinsics.areEqual(this.details, mercadonaProductDetail.details) && Intrinsics.areEqual(this.priceInstructions, mercadonaProductDetail.priceInstructions) && Intrinsics.areEqual(this.nutritionInformation, mercadonaProductDetail.nutritionInformation) && Intrinsics.areEqual(this.shareUrl, mercadonaProductDetail.shareUrl);
    }

    public int hashCode() {
        return (((((((((((((((this.id.hashCode() * 31) + (this.ean == null ? 0 : this.ean.hashCode())) * 31) + this.displayName.hashCode()) * 31) + (this.thumbnail == null ? 0 : this.thumbnail.hashCode())) * 31) + (this.photos == null ? 0 : this.photos.hashCode())) * 31) + (this.details == null ? 0 : this.details.hashCode())) * 31) + (this.priceInstructions == null ? 0 : this.priceInstructions.hashCode())) * 31) + (this.nutritionInformation == null ? 0 : this.nutritionInformation.hashCode())) * 31) + (this.shareUrl != null ? this.shareUrl.hashCode() : 0);
    }

    public String toString() {
        return "MercadonaProductDetail(id=" + this.id + ", ean=" + this.ean + ", displayName=" + this.displayName + ", thumbnail=" + this.thumbnail + ", photos=" + this.photos + ", details=" + this.details + ", priceInstructions=" + this.priceInstructions + ", nutritionInformation=" + this.nutritionInformation + ", shareUrl=" + this.shareUrl + ")";
    }

    public MercadonaProductDetail(String id, String ean, String displayName, String thumbnail, List<MercadonaPhoto> list, MercadonaDetails details, MercadonaPrice priceInstructions, MercadonaNutrition nutritionInformation, String shareUrl) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        this.id = id;
        this.ean = ean;
        this.displayName = displayName;
        this.thumbnail = thumbnail;
        this.photos = list;
        this.details = details;
        this.priceInstructions = priceInstructions;
        this.nutritionInformation = nutritionInformation;
        this.shareUrl = shareUrl;
    }

    public final String getId() {
        return this.id;
    }

    public final String getEan() {
        return this.ean;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final List<MercadonaPhoto> getPhotos() {
        return this.photos;
    }

    public final MercadonaDetails getDetails() {
        return this.details;
    }

    public final MercadonaPrice getPriceInstructions() {
        return this.priceInstructions;
    }

    public final MercadonaNutrition getNutritionInformation() {
        return this.nutritionInformation;
    }

    public final String getShareUrl() {
        return this.shareUrl;
    }
}
