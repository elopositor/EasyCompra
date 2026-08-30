package com.easycompra.app.network;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApiModels.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/easycompra/app/network/OffProduct;", "", "nutriscoreGrade", "", "nutriments", "Lcom/easycompra/app/network/OffNutriments;", "<init>", "(Ljava/lang/String;Lcom/easycompra/app/network/OffNutriments;)V", "getNutriscoreGrade", "()Ljava/lang/String;", "getNutriments", "()Lcom/easycompra/app/network/OffNutriments;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class OffProduct {
    public static final int $stable = 0;
    private final OffNutriments nutriments;

    @SerializedName("nutriscore_grade")
    private final String nutriscoreGrade;

    public static /* synthetic */ OffProduct copy$default(OffProduct offProduct, String str, OffNutriments offNutriments, int i, Object obj) {
        if ((i & 1) != 0) {
            str = offProduct.nutriscoreGrade;
        }
        if ((i & 2) != 0) {
            offNutriments = offProduct.nutriments;
        }
        return offProduct.copy(str, offNutriments);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getNutriscoreGrade() {
        return this.nutriscoreGrade;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final OffNutriments getNutriments() {
        return this.nutriments;
    }

    public final OffProduct copy(String nutriscoreGrade, OffNutriments nutriments) {
        return new OffProduct(nutriscoreGrade, nutriments);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OffProduct)) {
            return false;
        }
        OffProduct offProduct = (OffProduct) other;
        return Intrinsics.areEqual(this.nutriscoreGrade, offProduct.nutriscoreGrade) && Intrinsics.areEqual(this.nutriments, offProduct.nutriments);
    }

    public int hashCode() {
        return ((this.nutriscoreGrade == null ? 0 : this.nutriscoreGrade.hashCode()) * 31) + (this.nutriments != null ? this.nutriments.hashCode() : 0);
    }

    public String toString() {
        return "OffProduct(nutriscoreGrade=" + this.nutriscoreGrade + ", nutriments=" + this.nutriments + ")";
    }

    public OffProduct(String nutriscoreGrade, OffNutriments nutriments) {
        this.nutriscoreGrade = nutriscoreGrade;
        this.nutriments = nutriments;
    }

    public final String getNutriscoreGrade() {
        return this.nutriscoreGrade;
    }

    public final OffNutriments getNutriments() {
        return this.nutriments;
    }
}
