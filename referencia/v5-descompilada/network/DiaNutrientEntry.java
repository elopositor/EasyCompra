package com.easycompra.app.network;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApiModels.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0007HÆ\u0003J8\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/easycompra/app/network/DiaNutrientEntry;", "", "title", "", "valuePer100g", "", "items", "", "<init>", "(Ljava/lang/String;Ljava/lang/Double;Ljava/util/List;)V", "getTitle", "()Ljava/lang/String;", "getValuePer100g", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Double;Ljava/util/List;)Lcom/easycompra/app/network/DiaNutrientEntry;", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class DiaNutrientEntry {
    public static final int $stable = 8;
    private final List<DiaNutrientEntry> items;
    private final String title;

    @SerializedName("value_per_100_g")
    private final Double valuePer100g;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DiaNutrientEntry copy$default(DiaNutrientEntry diaNutrientEntry, String str, Double d, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = diaNutrientEntry.title;
        }
        if ((i & 2) != 0) {
            d = diaNutrientEntry.valuePer100g;
        }
        if ((i & 4) != 0) {
            list = diaNutrientEntry.items;
        }
        return diaNutrientEntry.copy(str, d, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Double getValuePer100g() {
        return this.valuePer100g;
    }

    public final List<DiaNutrientEntry> component3() {
        return this.items;
    }

    public final DiaNutrientEntry copy(String title, Double valuePer100g, List<DiaNutrientEntry> items) {
        return new DiaNutrientEntry(title, valuePer100g, items);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DiaNutrientEntry)) {
            return false;
        }
        DiaNutrientEntry diaNutrientEntry = (DiaNutrientEntry) other;
        return Intrinsics.areEqual(this.title, diaNutrientEntry.title) && Intrinsics.areEqual((Object) this.valuePer100g, (Object) diaNutrientEntry.valuePer100g) && Intrinsics.areEqual(this.items, diaNutrientEntry.items);
    }

    public int hashCode() {
        return ((((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.valuePer100g == null ? 0 : this.valuePer100g.hashCode())) * 31) + (this.items != null ? this.items.hashCode() : 0);
    }

    public String toString() {
        return "DiaNutrientEntry(title=" + this.title + ", valuePer100g=" + this.valuePer100g + ", items=" + this.items + ")";
    }

    public DiaNutrientEntry(String title, Double valuePer100g, List<DiaNutrientEntry> list) {
        this.title = title;
        this.valuePer100g = valuePer100g;
        this.items = list;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Double getValuePer100g() {
        return this.valuePer100g;
    }

    public final List<DiaNutrientEntry> getItems() {
        return this.items;
    }
}
