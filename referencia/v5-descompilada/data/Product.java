package com.easycompra.app.data;

import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Product.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b>\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BÑ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010;\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0010HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010C\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010D\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010E\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010F\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010G\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010H\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0082\u0002\u0010J\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010KJ\u0013\u0010L\u001a\u00020\u00102\b\u0010M\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010N\u001a\u00020OHÖ\u0001J\t\u0010P\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010$\u001a\u0004\b%\u0010#R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001dR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001dR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010$\u001a\u0004\b-\u0010#R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010$\u001a\u0004\b.\u0010#R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010$\u001a\u0004\b/\u0010#R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010$\u001a\u0004\b0\u0010#R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010$\u001a\u0004\b1\u0010#R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010$\u001a\u0004\b2\u0010#R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010$\u001a\u0004\b3\u0010#R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001d¨\u0006Q"}, d2 = {"Lcom/easycompra/app/data/Product;", "", "id", "", "supermarket", HintConstants.AUTOFILL_HINT_NAME, "brand", "photoUrl", "unitPrice", "", "referencePrice", "referenceFormat", "ean", "ingredients", "allergens", "containsNata", "", "nutriscoreGrade", "energyKcal100g", "fat100g", "saturatedFat100g", "carbohydrates100g", "sugars100g", "proteins100g", "salt100g", "shareUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getSupermarket", "getName", "getBrand", "getPhotoUrl", "getUnitPrice", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getReferencePrice", "getReferenceFormat", "getEan", "getIngredients", "getAllergens", "getContainsNata", "()Z", "getNutriscoreGrade", "getEnergyKcal100g", "getFat100g", "getSaturatedFat100g", "getCarbohydrates100g", "getSugars100g", "getProteins100g", "getSalt100g", "getShareUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;)Lcom/easycompra/app/data/Product;", "equals", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class Product {
    public static final int $stable = 0;
    private final String allergens;
    private final String brand;
    private final Double carbohydrates100g;
    private final boolean containsNata;
    private final String ean;
    private final Double energyKcal100g;
    private final Double fat100g;
    private final String id;
    private final String ingredients;
    private final String name;
    private final String nutriscoreGrade;
    private final String photoUrl;
    private final Double proteins100g;
    private final String referenceFormat;
    private final Double referencePrice;
    private final Double salt100g;
    private final Double saturatedFat100g;
    private final String shareUrl;
    private final Double sugars100g;
    private final String supermarket;
    private final Double unitPrice;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getIngredients() {
        return this.ingredients;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getAllergens() {
        return this.allergens;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getContainsNata() {
        return this.containsNata;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getNutriscoreGrade() {
        return this.nutriscoreGrade;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Double getEnergyKcal100g() {
        return this.energyKcal100g;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Double getFat100g() {
        return this.fat100g;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Double getSaturatedFat100g() {
        return this.saturatedFat100g;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final Double getCarbohydrates100g() {
        return this.carbohydrates100g;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final Double getSugars100g() {
        return this.sugars100g;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final Double getProteins100g() {
        return this.proteins100g;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSupermarket() {
        return this.supermarket;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final Double getSalt100g() {
        return this.salt100g;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getShareUrl() {
        return this.shareUrl;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getBrand() {
        return this.brand;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getPhotoUrl() {
        return this.photoUrl;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Double getUnitPrice() {
        return this.unitPrice;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Double getReferencePrice() {
        return this.referencePrice;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getReferenceFormat() {
        return this.referenceFormat;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getEan() {
        return this.ean;
    }

    public final Product copy(String id, String supermarket, String name, String brand, String photoUrl, Double unitPrice, Double referencePrice, String referenceFormat, String ean, String ingredients, String allergens, boolean containsNata, String nutriscoreGrade, Double energyKcal100g, Double fat100g, Double saturatedFat100g, Double carbohydrates100g, Double sugars100g, Double proteins100g, Double salt100g, String shareUrl) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(supermarket, "supermarket");
        Intrinsics.checkNotNullParameter(name, "name");
        return new Product(id, supermarket, name, brand, photoUrl, unitPrice, referencePrice, referenceFormat, ean, ingredients, allergens, containsNata, nutriscoreGrade, energyKcal100g, fat100g, saturatedFat100g, carbohydrates100g, sugars100g, proteins100g, salt100g, shareUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Product)) {
            return false;
        }
        Product product = (Product) other;
        return Intrinsics.areEqual(this.id, product.id) && Intrinsics.areEqual(this.supermarket, product.supermarket) && Intrinsics.areEqual(this.name, product.name) && Intrinsics.areEqual(this.brand, product.brand) && Intrinsics.areEqual(this.photoUrl, product.photoUrl) && Intrinsics.areEqual((Object) this.unitPrice, (Object) product.unitPrice) && Intrinsics.areEqual((Object) this.referencePrice, (Object) product.referencePrice) && Intrinsics.areEqual(this.referenceFormat, product.referenceFormat) && Intrinsics.areEqual(this.ean, product.ean) && Intrinsics.areEqual(this.ingredients, product.ingredients) && Intrinsics.areEqual(this.allergens, product.allergens) && this.containsNata == product.containsNata && Intrinsics.areEqual(this.nutriscoreGrade, product.nutriscoreGrade) && Intrinsics.areEqual((Object) this.energyKcal100g, (Object) product.energyKcal100g) && Intrinsics.areEqual((Object) this.fat100g, (Object) product.fat100g) && Intrinsics.areEqual((Object) this.saturatedFat100g, (Object) product.saturatedFat100g) && Intrinsics.areEqual((Object) this.carbohydrates100g, (Object) product.carbohydrates100g) && Intrinsics.areEqual((Object) this.sugars100g, (Object) product.sugars100g) && Intrinsics.areEqual((Object) this.proteins100g, (Object) product.proteins100g) && Intrinsics.areEqual((Object) this.salt100g, (Object) product.salt100g) && Intrinsics.areEqual(this.shareUrl, product.shareUrl);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((this.id.hashCode() * 31) + this.supermarket.hashCode()) * 31) + this.name.hashCode()) * 31) + (this.brand == null ? 0 : this.brand.hashCode())) * 31) + (this.photoUrl == null ? 0 : this.photoUrl.hashCode())) * 31) + (this.unitPrice == null ? 0 : this.unitPrice.hashCode())) * 31) + (this.referencePrice == null ? 0 : this.referencePrice.hashCode())) * 31) + (this.referenceFormat == null ? 0 : this.referenceFormat.hashCode())) * 31) + (this.ean == null ? 0 : this.ean.hashCode())) * 31) + (this.ingredients == null ? 0 : this.ingredients.hashCode())) * 31) + (this.allergens == null ? 0 : this.allergens.hashCode())) * 31) + Boolean.hashCode(this.containsNata)) * 31) + (this.nutriscoreGrade == null ? 0 : this.nutriscoreGrade.hashCode())) * 31) + (this.energyKcal100g == null ? 0 : this.energyKcal100g.hashCode())) * 31) + (this.fat100g == null ? 0 : this.fat100g.hashCode())) * 31) + (this.saturatedFat100g == null ? 0 : this.saturatedFat100g.hashCode())) * 31) + (this.carbohydrates100g == null ? 0 : this.carbohydrates100g.hashCode())) * 31) + (this.sugars100g == null ? 0 : this.sugars100g.hashCode())) * 31) + (this.proteins100g == null ? 0 : this.proteins100g.hashCode())) * 31) + (this.salt100g == null ? 0 : this.salt100g.hashCode())) * 31) + (this.shareUrl != null ? this.shareUrl.hashCode() : 0);
    }

    public String toString() {
        return "Product(id=" + this.id + ", supermarket=" + this.supermarket + ", name=" + this.name + ", brand=" + this.brand + ", photoUrl=" + this.photoUrl + ", unitPrice=" + this.unitPrice + ", referencePrice=" + this.referencePrice + ", referenceFormat=" + this.referenceFormat + ", ean=" + this.ean + ", ingredients=" + this.ingredients + ", allergens=" + this.allergens + ", containsNata=" + this.containsNata + ", nutriscoreGrade=" + this.nutriscoreGrade + ", energyKcal100g=" + this.energyKcal100g + ", fat100g=" + this.fat100g + ", saturatedFat100g=" + this.saturatedFat100g + ", carbohydrates100g=" + this.carbohydrates100g + ", sugars100g=" + this.sugars100g + ", proteins100g=" + this.proteins100g + ", salt100g=" + this.salt100g + ", shareUrl=" + this.shareUrl + ")";
    }

    public Product(String id, String supermarket, String name, String brand, String photoUrl, Double unitPrice, Double referencePrice, String referenceFormat, String ean, String ingredients, String allergens, boolean containsNata, String nutriscoreGrade, Double energyKcal100g, Double fat100g, Double saturatedFat100g, Double carbohydrates100g, Double sugars100g, Double proteins100g, Double salt100g, String shareUrl) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(supermarket, "supermarket");
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = id;
        this.supermarket = supermarket;
        this.name = name;
        this.brand = brand;
        this.photoUrl = photoUrl;
        this.unitPrice = unitPrice;
        this.referencePrice = referencePrice;
        this.referenceFormat = referenceFormat;
        this.ean = ean;
        this.ingredients = ingredients;
        this.allergens = allergens;
        this.containsNata = containsNata;
        this.nutriscoreGrade = nutriscoreGrade;
        this.energyKcal100g = energyKcal100g;
        this.fat100g = fat100g;
        this.saturatedFat100g = saturatedFat100g;
        this.carbohydrates100g = carbohydrates100g;
        this.sugars100g = sugars100g;
        this.proteins100g = proteins100g;
        this.salt100g = salt100g;
        this.shareUrl = shareUrl;
    }

    public final String getId() {
        return this.id;
    }

    public final String getSupermarket() {
        return this.supermarket;
    }

    public final String getName() {
        return this.name;
    }

    public final String getBrand() {
        return this.brand;
    }

    public final String getPhotoUrl() {
        return this.photoUrl;
    }

    public final Double getUnitPrice() {
        return this.unitPrice;
    }

    public final Double getReferencePrice() {
        return this.referencePrice;
    }

    public final String getReferenceFormat() {
        return this.referenceFormat;
    }

    public final String getEan() {
        return this.ean;
    }

    public final String getIngredients() {
        return this.ingredients;
    }

    public final String getAllergens() {
        return this.allergens;
    }

    public final boolean getContainsNata() {
        return this.containsNata;
    }

    public final String getNutriscoreGrade() {
        return this.nutriscoreGrade;
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

    public final String getShareUrl() {
        return this.shareUrl;
    }
}
