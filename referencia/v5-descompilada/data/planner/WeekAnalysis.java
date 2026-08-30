package com.easycompra.app.data.planner;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlannerEntry.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\nHÆ\u0003JC\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/easycompra/app/data/planner/WeekAnalysis;", "", "missingIngredients", "", "Lcom/easycompra/app/data/planner/IngredientNeed;", "defrostAlerts", "Lcom/easycompra/app/data/planner/DefrostAlert;", "pantryTips", "Lcom/easycompra/app/data/planner/PantryTip;", "isLoading", "", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Z)V", "getMissingIngredients", "()Ljava/util/List;", "getDefrostAlerts", "getPantryTips", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class WeekAnalysis {
    public static final int $stable = 8;
    private final List<DefrostAlert> defrostAlerts;
    private final boolean isLoading;
    private final List<IngredientNeed> missingIngredients;
    private final List<PantryTip> pantryTips;

    public WeekAnalysis() {
        this(null, null, null, false, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WeekAnalysis copy$default(WeekAnalysis weekAnalysis, List list, List list2, List list3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            list = weekAnalysis.missingIngredients;
        }
        if ((i & 2) != 0) {
            list2 = weekAnalysis.defrostAlerts;
        }
        if ((i & 4) != 0) {
            list3 = weekAnalysis.pantryTips;
        }
        if ((i & 8) != 0) {
            z = weekAnalysis.isLoading;
        }
        return weekAnalysis.copy(list, list2, list3, z);
    }

    public final List<IngredientNeed> component1() {
        return this.missingIngredients;
    }

    public final List<DefrostAlert> component2() {
        return this.defrostAlerts;
    }

    public final List<PantryTip> component3() {
        return this.pantryTips;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    public final WeekAnalysis copy(List<IngredientNeed> missingIngredients, List<DefrostAlert> defrostAlerts, List<PantryTip> pantryTips, boolean isLoading) {
        Intrinsics.checkNotNullParameter(missingIngredients, "missingIngredients");
        Intrinsics.checkNotNullParameter(defrostAlerts, "defrostAlerts");
        Intrinsics.checkNotNullParameter(pantryTips, "pantryTips");
        return new WeekAnalysis(missingIngredients, defrostAlerts, pantryTips, isLoading);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WeekAnalysis)) {
            return false;
        }
        WeekAnalysis weekAnalysis = (WeekAnalysis) other;
        return Intrinsics.areEqual(this.missingIngredients, weekAnalysis.missingIngredients) && Intrinsics.areEqual(this.defrostAlerts, weekAnalysis.defrostAlerts) && Intrinsics.areEqual(this.pantryTips, weekAnalysis.pantryTips) && this.isLoading == weekAnalysis.isLoading;
    }

    public int hashCode() {
        return (((((this.missingIngredients.hashCode() * 31) + this.defrostAlerts.hashCode()) * 31) + this.pantryTips.hashCode()) * 31) + Boolean.hashCode(this.isLoading);
    }

    public String toString() {
        return "WeekAnalysis(missingIngredients=" + this.missingIngredients + ", defrostAlerts=" + this.defrostAlerts + ", pantryTips=" + this.pantryTips + ", isLoading=" + this.isLoading + ")";
    }

    public WeekAnalysis(List<IngredientNeed> missingIngredients, List<DefrostAlert> defrostAlerts, List<PantryTip> pantryTips, boolean isLoading) {
        Intrinsics.checkNotNullParameter(missingIngredients, "missingIngredients");
        Intrinsics.checkNotNullParameter(defrostAlerts, "defrostAlerts");
        Intrinsics.checkNotNullParameter(pantryTips, "pantryTips");
        this.missingIngredients = missingIngredients;
        this.defrostAlerts = defrostAlerts;
        this.pantryTips = pantryTips;
        this.isLoading = isLoading;
    }

    public /* synthetic */ WeekAnalysis(List list, List list2, List list3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2, (i & 4) != 0 ? CollectionsKt.emptyList() : list3, (i & 8) != 0 ? false : z);
    }

    public final List<IngredientNeed> getMissingIngredients() {
        return this.missingIngredients;
    }

    public final List<DefrostAlert> getDefrostAlerts() {
        return this.defrostAlerts;
    }

    public final List<PantryTip> getPantryTips() {
        return this.pantryTips;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }
}
