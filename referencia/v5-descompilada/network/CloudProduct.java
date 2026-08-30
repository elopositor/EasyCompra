package com.easycompra.app.network;

import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApiServices.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b@\b\u0087\b\u0018\u00002\u00020\u0001BÇ\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010&J\u0010\u0010=\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010&J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010@\u001a\u00020\u0010HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010&J\u0010\u0010C\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010&J\u0010\u0010D\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010&J\u0010\u0010E\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010&J\u0010\u0010F\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010&J\u0010\u0010G\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010&J\u0010\u0010H\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010&J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jö\u0001\u0010J\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010KJ\u0013\u0010L\u001a\u00020\u00102\b\u0010M\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010N\u001a\u00020\u0003HÖ\u0001J\t\u0010O\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u0015\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010'\u001a\u0004\b(\u0010&R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010 R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010 R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010 R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010'\u001a\u0004\b.\u0010&R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010'\u001a\u0004\b/\u0010&R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010'\u001a\u0004\b0\u0010&R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010'\u001a\u0004\b1\u0010&R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010'\u001a\u0004\b2\u0010&R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010'\u001a\u0004\b3\u0010&R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010'\u001a\u0004\b4\u0010&R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010 ¨\u0006P"}, d2 = {"Lcom/easycompra/app/network/CloudProduct;", "", "id", "", "supermarket", "", "external_id", HintConstants.AUTOFILL_HINT_NAME, "brand", "photo_url", "unit_price", "", "reference_price", "reference_format", "ingredients", "contains_nata", "", "nutriscore_grade", "energy_kcal_100g", "fat_100g", "saturated_fat_100g", "carbohydrates_100g", "sugars_100g", "proteins_100g", "salt_100g", "share_url", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSupermarket", "()Ljava/lang/String;", "getExternal_id", "getName", "getBrand", "getPhoto_url", "getUnit_price", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getReference_price", "getReference_format", "getIngredients", "getContains_nata", "()Z", "getNutriscore_grade", "getEnergy_kcal_100g", "getFat_100g", "getSaturated_fat_100g", "getCarbohydrates_100g", "getSugars_100g", "getProteins_100g", "getSalt_100g", "getShare_url", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/String;)Lcom/easycompra/app/network/CloudProduct;", "equals", "other", "hashCode", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class CloudProduct {
    public static final int $stable = 0;
    private final String brand;
    private final Double carbohydrates_100g;
    private final boolean contains_nata;
    private final Double energy_kcal_100g;
    private final String external_id;
    private final Double fat_100g;
    private final Integer id;
    private final String ingredients;
    private final String name;
    private final String nutriscore_grade;
    private final String photo_url;
    private final Double proteins_100g;
    private final String reference_format;
    private final Double reference_price;
    private final Double salt_100g;
    private final Double saturated_fat_100g;
    private final String share_url;
    private final Double sugars_100g;
    private final String supermarket;
    private final Double unit_price;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getIngredients() {
        return this.ingredients;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getContains_nata() {
        return this.contains_nata;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getNutriscore_grade() {
        return this.nutriscore_grade;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Double getEnergy_kcal_100g() {
        return this.energy_kcal_100g;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Double getFat_100g() {
        return this.fat_100g;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Double getSaturated_fat_100g() {
        return this.saturated_fat_100g;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Double getCarbohydrates_100g() {
        return this.carbohydrates_100g;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final Double getSugars_100g() {
        return this.sugars_100g;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final Double getProteins_100g() {
        return this.proteins_100g;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final Double getSalt_100g() {
        return this.salt_100g;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSupermarket() {
        return this.supermarket;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getShare_url() {
        return this.share_url;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getExternal_id() {
        return this.external_id;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getBrand() {
        return this.brand;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getPhoto_url() {
        return this.photo_url;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Double getUnit_price() {
        return this.unit_price;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Double getReference_price() {
        return this.reference_price;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getReference_format() {
        return this.reference_format;
    }

    public final CloudProduct copy(Integer id, String supermarket, String external_id, String name, String brand, String photo_url, Double unit_price, Double reference_price, String reference_format, String ingredients, boolean contains_nata, String nutriscore_grade, Double energy_kcal_100g, Double fat_100g, Double saturated_fat_100g, Double carbohydrates_100g, Double sugars_100g, Double proteins_100g, Double salt_100g, String share_url) {
        Intrinsics.checkNotNullParameter(supermarket, "supermarket");
        Intrinsics.checkNotNullParameter(external_id, "external_id");
        Intrinsics.checkNotNullParameter(name, "name");
        return new CloudProduct(id, supermarket, external_id, name, brand, photo_url, unit_price, reference_price, reference_format, ingredients, contains_nata, nutriscore_grade, energy_kcal_100g, fat_100g, saturated_fat_100g, carbohydrates_100g, sugars_100g, proteins_100g, salt_100g, share_url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CloudProduct)) {
            return false;
        }
        CloudProduct cloudProduct = (CloudProduct) other;
        return Intrinsics.areEqual(this.id, cloudProduct.id) && Intrinsics.areEqual(this.supermarket, cloudProduct.supermarket) && Intrinsics.areEqual(this.external_id, cloudProduct.external_id) && Intrinsics.areEqual(this.name, cloudProduct.name) && Intrinsics.areEqual(this.brand, cloudProduct.brand) && Intrinsics.areEqual(this.photo_url, cloudProduct.photo_url) && Intrinsics.areEqual((Object) this.unit_price, (Object) cloudProduct.unit_price) && Intrinsics.areEqual((Object) this.reference_price, (Object) cloudProduct.reference_price) && Intrinsics.areEqual(this.reference_format, cloudProduct.reference_format) && Intrinsics.areEqual(this.ingredients, cloudProduct.ingredients) && this.contains_nata == cloudProduct.contains_nata && Intrinsics.areEqual(this.nutriscore_grade, cloudProduct.nutriscore_grade) && Intrinsics.areEqual((Object) this.energy_kcal_100g, (Object) cloudProduct.energy_kcal_100g) && Intrinsics.areEqual((Object) this.fat_100g, (Object) cloudProduct.fat_100g) && Intrinsics.areEqual((Object) this.saturated_fat_100g, (Object) cloudProduct.saturated_fat_100g) && Intrinsics.areEqual((Object) this.carbohydrates_100g, (Object) cloudProduct.carbohydrates_100g) && Intrinsics.areEqual((Object) this.sugars_100g, (Object) cloudProduct.sugars_100g) && Intrinsics.areEqual((Object) this.proteins_100g, (Object) cloudProduct.proteins_100g) && Intrinsics.areEqual((Object) this.salt_100g, (Object) cloudProduct.salt_100g) && Intrinsics.areEqual(this.share_url, cloudProduct.share_url);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + this.supermarket.hashCode()) * 31) + this.external_id.hashCode()) * 31) + this.name.hashCode()) * 31) + (this.brand == null ? 0 : this.brand.hashCode())) * 31) + (this.photo_url == null ? 0 : this.photo_url.hashCode())) * 31) + (this.unit_price == null ? 0 : this.unit_price.hashCode())) * 31) + (this.reference_price == null ? 0 : this.reference_price.hashCode())) * 31) + (this.reference_format == null ? 0 : this.reference_format.hashCode())) * 31) + (this.ingredients == null ? 0 : this.ingredients.hashCode())) * 31) + Boolean.hashCode(this.contains_nata)) * 31) + (this.nutriscore_grade == null ? 0 : this.nutriscore_grade.hashCode())) * 31) + (this.energy_kcal_100g == null ? 0 : this.energy_kcal_100g.hashCode())) * 31) + (this.fat_100g == null ? 0 : this.fat_100g.hashCode())) * 31) + (this.saturated_fat_100g == null ? 0 : this.saturated_fat_100g.hashCode())) * 31) + (this.carbohydrates_100g == null ? 0 : this.carbohydrates_100g.hashCode())) * 31) + (this.sugars_100g == null ? 0 : this.sugars_100g.hashCode())) * 31) + (this.proteins_100g == null ? 0 : this.proteins_100g.hashCode())) * 31) + (this.salt_100g == null ? 0 : this.salt_100g.hashCode())) * 31) + (this.share_url != null ? this.share_url.hashCode() : 0);
    }

    public String toString() {
        return "CloudProduct(id=" + this.id + ", supermarket=" + this.supermarket + ", external_id=" + this.external_id + ", name=" + this.name + ", brand=" + this.brand + ", photo_url=" + this.photo_url + ", unit_price=" + this.unit_price + ", reference_price=" + this.reference_price + ", reference_format=" + this.reference_format + ", ingredients=" + this.ingredients + ", contains_nata=" + this.contains_nata + ", nutriscore_grade=" + this.nutriscore_grade + ", energy_kcal_100g=" + this.energy_kcal_100g + ", fat_100g=" + this.fat_100g + ", saturated_fat_100g=" + this.saturated_fat_100g + ", carbohydrates_100g=" + this.carbohydrates_100g + ", sugars_100g=" + this.sugars_100g + ", proteins_100g=" + this.proteins_100g + ", salt_100g=" + this.salt_100g + ", share_url=" + this.share_url + ")";
    }

    public CloudProduct(Integer id, String supermarket, String external_id, String name, String brand, String photo_url, Double unit_price, Double reference_price, String reference_format, String ingredients, boolean contains_nata, String nutriscore_grade, Double energy_kcal_100g, Double fat_100g, Double saturated_fat_100g, Double carbohydrates_100g, Double sugars_100g, Double proteins_100g, Double salt_100g, String share_url) {
        Intrinsics.checkNotNullParameter(supermarket, "supermarket");
        Intrinsics.checkNotNullParameter(external_id, "external_id");
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = id;
        this.supermarket = supermarket;
        this.external_id = external_id;
        this.name = name;
        this.brand = brand;
        this.photo_url = photo_url;
        this.unit_price = unit_price;
        this.reference_price = reference_price;
        this.reference_format = reference_format;
        this.ingredients = ingredients;
        this.contains_nata = contains_nata;
        this.nutriscore_grade = nutriscore_grade;
        this.energy_kcal_100g = energy_kcal_100g;
        this.fat_100g = fat_100g;
        this.saturated_fat_100g = saturated_fat_100g;
        this.carbohydrates_100g = carbohydrates_100g;
        this.sugars_100g = sugars_100g;
        this.proteins_100g = proteins_100g;
        this.salt_100g = salt_100g;
        this.share_url = share_url;
    }

    public final Integer getId() {
        return this.id;
    }

    public final String getSupermarket() {
        return this.supermarket;
    }

    public final String getExternal_id() {
        return this.external_id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getBrand() {
        return this.brand;
    }

    public final String getPhoto_url() {
        return this.photo_url;
    }

    public final Double getUnit_price() {
        return this.unit_price;
    }

    public final Double getReference_price() {
        return this.reference_price;
    }

    public final String getReference_format() {
        return this.reference_format;
    }

    public final String getIngredients() {
        return this.ingredients;
    }

    public final boolean getContains_nata() {
        return this.contains_nata;
    }

    public final String getNutriscore_grade() {
        return this.nutriscore_grade;
    }

    public final Double getEnergy_kcal_100g() {
        return this.energy_kcal_100g;
    }

    public final Double getFat_100g() {
        return this.fat_100g;
    }

    public final Double getSaturated_fat_100g() {
        return this.saturated_fat_100g;
    }

    public final Double getCarbohydrates_100g() {
        return this.carbohydrates_100g;
    }

    public final Double getSugars_100g() {
        return this.sugars_100g;
    }

    public final Double getProteins_100g() {
        return this.proteins_100g;
    }

    public final Double getSalt_100g() {
        return this.salt_100g;
    }

    public final String getShare_url() {
        return this.share_url;
    }
}
