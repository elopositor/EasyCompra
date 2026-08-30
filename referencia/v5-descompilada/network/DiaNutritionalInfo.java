package com.easycompra.app.network;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApiModels.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/easycompra/app/network/DiaNutritionalInfo;", "", "nutritionalValues", "Lcom/easycompra/app/network/DiaNutritionalValues;", "<init>", "(Lcom/easycompra/app/network/DiaNutritionalValues;)V", "getNutritionalValues", "()Lcom/easycompra/app/network/DiaNutritionalValues;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class DiaNutritionalInfo {
    public static final int $stable = 8;

    @SerializedName("nutritional_values")
    private final DiaNutritionalValues nutritionalValues;

    public static /* synthetic */ DiaNutritionalInfo copy$default(DiaNutritionalInfo diaNutritionalInfo, DiaNutritionalValues diaNutritionalValues, int i, Object obj) {
        if ((i & 1) != 0) {
            diaNutritionalValues = diaNutritionalInfo.nutritionalValues;
        }
        return diaNutritionalInfo.copy(diaNutritionalValues);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final DiaNutritionalValues getNutritionalValues() {
        return this.nutritionalValues;
    }

    public final DiaNutritionalInfo copy(DiaNutritionalValues nutritionalValues) {
        return new DiaNutritionalInfo(nutritionalValues);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DiaNutritionalInfo) && Intrinsics.areEqual(this.nutritionalValues, ((DiaNutritionalInfo) other).nutritionalValues);
    }

    public int hashCode() {
        if (this.nutritionalValues == null) {
            return 0;
        }
        return this.nutritionalValues.hashCode();
    }

    public String toString() {
        return "DiaNutritionalInfo(nutritionalValues=" + this.nutritionalValues + ")";
    }

    public DiaNutritionalInfo(DiaNutritionalValues nutritionalValues) {
        this.nutritionalValues = nutritionalValues;
    }

    public final DiaNutritionalValues getNutritionalValues() {
        return this.nutritionalValues;
    }
}
