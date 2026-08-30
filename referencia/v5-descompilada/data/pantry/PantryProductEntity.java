package com.easycompra.app.data.pantry;

import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PantryProductEntity.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/easycompra/app/data/pantry/PantryProductEntity;", "", "id", "", HintConstants.AUTOFILL_HINT_NAME, "needsToBuy", "", "createdAt", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZJ)V", "getId", "()Ljava/lang/String;", "getName", "getNeedsToBuy", "()Z", "getCreatedAt", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class PantryProductEntity {
    public static final int $stable = 0;
    private final long createdAt;
    private final String id;
    private final String name;
    private final boolean needsToBuy;

    public static /* synthetic */ PantryProductEntity copy$default(PantryProductEntity pantryProductEntity, String str, String str2, boolean z, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pantryProductEntity.id;
        }
        if ((i & 2) != 0) {
            str2 = pantryProductEntity.name;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            z = pantryProductEntity.needsToBuy;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            j = pantryProductEntity.createdAt;
        }
        return pantryProductEntity.copy(str, str3, z2, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getNeedsToBuy() {
        return this.needsToBuy;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final PantryProductEntity copy(String id, String name, boolean needsToBuy, long createdAt) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        return new PantryProductEntity(id, name, needsToBuy, createdAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PantryProductEntity)) {
            return false;
        }
        PantryProductEntity pantryProductEntity = (PantryProductEntity) other;
        return Intrinsics.areEqual(this.id, pantryProductEntity.id) && Intrinsics.areEqual(this.name, pantryProductEntity.name) && this.needsToBuy == pantryProductEntity.needsToBuy && this.createdAt == pantryProductEntity.createdAt;
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + Boolean.hashCode(this.needsToBuy)) * 31) + Long.hashCode(this.createdAt);
    }

    public String toString() {
        return "PantryProductEntity(id=" + this.id + ", name=" + this.name + ", needsToBuy=" + this.needsToBuy + ", createdAt=" + this.createdAt + ")";
    }

    public PantryProductEntity(String id, String name, boolean needsToBuy, long createdAt) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = id;
        this.name = name;
        this.needsToBuy = needsToBuy;
        this.createdAt = createdAt;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PantryProductEntity(String str, String str2, boolean z, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        boolean z2;
        long jCurrentTimeMillis;
        if ((i & 4) == 0) {
            z2 = z;
        } else {
            z2 = false;
        }
        if ((i & 8) == 0) {
            jCurrentTimeMillis = j;
        } else {
            jCurrentTimeMillis = System.currentTimeMillis();
        }
        this(str, str2, z2, jCurrentTimeMillis);
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getNeedsToBuy() {
        return this.needsToBuy;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }
}
