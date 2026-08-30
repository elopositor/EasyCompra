package com.easycompra.app.data.planner;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlannerEntry.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/easycompra/app/data/planner/DefrostAlert;", "", "productName", "", "neededFor", "neededOnDate", "daysUntil", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getProductName", "()Ljava/lang/String;", "getNeededFor", "getNeededOnDate", "getDaysUntil", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class DefrostAlert {
    public static final int $stable = 0;
    private final int daysUntil;
    private final String neededFor;
    private final String neededOnDate;
    private final String productName;

    public static /* synthetic */ DefrostAlert copy$default(DefrostAlert defrostAlert, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = defrostAlert.productName;
        }
        if ((i2 & 2) != 0) {
            str2 = defrostAlert.neededFor;
        }
        if ((i2 & 4) != 0) {
            str3 = defrostAlert.neededOnDate;
        }
        if ((i2 & 8) != 0) {
            i = defrostAlert.daysUntil;
        }
        return defrostAlert.copy(str, str2, str3, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getProductName() {
        return this.productName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getNeededFor() {
        return this.neededFor;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getNeededOnDate() {
        return this.neededOnDate;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getDaysUntil() {
        return this.daysUntil;
    }

    public final DefrostAlert copy(String productName, String neededFor, String neededOnDate, int daysUntil) {
        Intrinsics.checkNotNullParameter(productName, "productName");
        Intrinsics.checkNotNullParameter(neededFor, "neededFor");
        Intrinsics.checkNotNullParameter(neededOnDate, "neededOnDate");
        return new DefrostAlert(productName, neededFor, neededOnDate, daysUntil);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DefrostAlert)) {
            return false;
        }
        DefrostAlert defrostAlert = (DefrostAlert) other;
        return Intrinsics.areEqual(this.productName, defrostAlert.productName) && Intrinsics.areEqual(this.neededFor, defrostAlert.neededFor) && Intrinsics.areEqual(this.neededOnDate, defrostAlert.neededOnDate) && this.daysUntil == defrostAlert.daysUntil;
    }

    public int hashCode() {
        return (((((this.productName.hashCode() * 31) + this.neededFor.hashCode()) * 31) + this.neededOnDate.hashCode()) * 31) + Integer.hashCode(this.daysUntil);
    }

    public String toString() {
        return "DefrostAlert(productName=" + this.productName + ", neededFor=" + this.neededFor + ", neededOnDate=" + this.neededOnDate + ", daysUntil=" + this.daysUntil + ")";
    }

    public DefrostAlert(String productName, String neededFor, String neededOnDate, int daysUntil) {
        Intrinsics.checkNotNullParameter(productName, "productName");
        Intrinsics.checkNotNullParameter(neededFor, "neededFor");
        Intrinsics.checkNotNullParameter(neededOnDate, "neededOnDate");
        this.productName = productName;
        this.neededFor = neededFor;
        this.neededOnDate = neededOnDate;
        this.daysUntil = daysUntil;
    }

    public final String getProductName() {
        return this.productName;
    }

    public final String getNeededFor() {
        return this.neededFor;
    }

    public final String getNeededOnDate() {
        return this.neededOnDate;
    }

    public final int getDaysUntil() {
        return this.daysUntil;
    }
}
