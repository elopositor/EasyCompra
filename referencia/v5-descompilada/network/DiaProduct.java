package com.easycompra.app.network;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApiModels.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\rHÆ\u0003JU\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006)"}, d2 = {"Lcom/easycompra/app/network/DiaProduct;", "", "skuId", "", "primaryInfo", "Lcom/easycompra/app/network/DiaPrimaryInfo;", "images", "", "prices", "Lcom/easycompra/app/network/DiaPrices;", "ingredients", "Lcom/easycompra/app/network/DiaIngredients;", "nutritionalInfo", "Lcom/easycompra/app/network/DiaNutritionalInfo;", "<init>", "(Ljava/lang/String;Lcom/easycompra/app/network/DiaPrimaryInfo;Ljava/util/List;Lcom/easycompra/app/network/DiaPrices;Lcom/easycompra/app/network/DiaIngredients;Lcom/easycompra/app/network/DiaNutritionalInfo;)V", "getSkuId", "()Ljava/lang/String;", "getPrimaryInfo", "()Lcom/easycompra/app/network/DiaPrimaryInfo;", "getImages", "()Ljava/util/List;", "getPrices", "()Lcom/easycompra/app/network/DiaPrices;", "getIngredients", "()Lcom/easycompra/app/network/DiaIngredients;", "getNutritionalInfo", "()Lcom/easycompra/app/network/DiaNutritionalInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class DiaProduct {
    public static final int $stable = 8;
    private final List<String> images;
    private final DiaIngredients ingredients;

    @SerializedName("nutritional_info")
    private final DiaNutritionalInfo nutritionalInfo;
    private final DiaPrices prices;

    @SerializedName("primary_info")
    private final DiaPrimaryInfo primaryInfo;

    @SerializedName("sku_id")
    private final String skuId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DiaProduct copy$default(DiaProduct diaProduct, String str, DiaPrimaryInfo diaPrimaryInfo, List list, DiaPrices diaPrices, DiaIngredients diaIngredients, DiaNutritionalInfo diaNutritionalInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = diaProduct.skuId;
        }
        if ((i & 2) != 0) {
            diaPrimaryInfo = diaProduct.primaryInfo;
        }
        DiaPrimaryInfo diaPrimaryInfo2 = diaPrimaryInfo;
        if ((i & 4) != 0) {
            list = diaProduct.images;
        }
        List list2 = list;
        if ((i & 8) != 0) {
            diaPrices = diaProduct.prices;
        }
        DiaPrices diaPrices2 = diaPrices;
        if ((i & 16) != 0) {
            diaIngredients = diaProduct.ingredients;
        }
        DiaIngredients diaIngredients2 = diaIngredients;
        if ((i & 32) != 0) {
            diaNutritionalInfo = diaProduct.nutritionalInfo;
        }
        return diaProduct.copy(str, diaPrimaryInfo2, list2, diaPrices2, diaIngredients2, diaNutritionalInfo);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSkuId() {
        return this.skuId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final DiaPrimaryInfo getPrimaryInfo() {
        return this.primaryInfo;
    }

    public final List<String> component3() {
        return this.images;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final DiaPrices getPrices() {
        return this.prices;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final DiaIngredients getIngredients() {
        return this.ingredients;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final DiaNutritionalInfo getNutritionalInfo() {
        return this.nutritionalInfo;
    }

    public final DiaProduct copy(String skuId, DiaPrimaryInfo primaryInfo, List<String> images, DiaPrices prices, DiaIngredients ingredients, DiaNutritionalInfo nutritionalInfo) {
        Intrinsics.checkNotNullParameter(skuId, "skuId");
        return new DiaProduct(skuId, primaryInfo, images, prices, ingredients, nutritionalInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DiaProduct)) {
            return false;
        }
        DiaProduct diaProduct = (DiaProduct) other;
        return Intrinsics.areEqual(this.skuId, diaProduct.skuId) && Intrinsics.areEqual(this.primaryInfo, diaProduct.primaryInfo) && Intrinsics.areEqual(this.images, diaProduct.images) && Intrinsics.areEqual(this.prices, diaProduct.prices) && Intrinsics.areEqual(this.ingredients, diaProduct.ingredients) && Intrinsics.areEqual(this.nutritionalInfo, diaProduct.nutritionalInfo);
    }

    public int hashCode() {
        return (((((((((this.skuId.hashCode() * 31) + (this.primaryInfo == null ? 0 : this.primaryInfo.hashCode())) * 31) + (this.images == null ? 0 : this.images.hashCode())) * 31) + (this.prices == null ? 0 : this.prices.hashCode())) * 31) + (this.ingredients == null ? 0 : this.ingredients.hashCode())) * 31) + (this.nutritionalInfo != null ? this.nutritionalInfo.hashCode() : 0);
    }

    public String toString() {
        return "DiaProduct(skuId=" + this.skuId + ", primaryInfo=" + this.primaryInfo + ", images=" + this.images + ", prices=" + this.prices + ", ingredients=" + this.ingredients + ", nutritionalInfo=" + this.nutritionalInfo + ")";
    }

    public DiaProduct(String skuId, DiaPrimaryInfo primaryInfo, List<String> list, DiaPrices prices, DiaIngredients ingredients, DiaNutritionalInfo nutritionalInfo) {
        Intrinsics.checkNotNullParameter(skuId, "skuId");
        this.skuId = skuId;
        this.primaryInfo = primaryInfo;
        this.images = list;
        this.prices = prices;
        this.ingredients = ingredients;
        this.nutritionalInfo = nutritionalInfo;
    }

    public final String getSkuId() {
        return this.skuId;
    }

    public final DiaPrimaryInfo getPrimaryInfo() {
        return this.primaryInfo;
    }

    public final List<String> getImages() {
        return this.images;
    }

    public final DiaPrices getPrices() {
        return this.prices;
    }

    public final DiaIngredients getIngredients() {
        return this.ingredients;
    }

    public final DiaNutritionalInfo getNutritionalInfo() {
        return this.nutritionalInfo;
    }
}
