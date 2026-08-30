package com.easycompra.app.data.pantry;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PantryLocationEntity.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\fHÆ\u0003JY\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006)"}, d2 = {"Lcom/easycompra/app/data/pantry/PantryLocationEntity;", "", "id", "", "productId", "category", "subcategory", "description", "quantity", "", "unit", "updatedAt", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FLjava/lang/String;J)V", "getId", "()Ljava/lang/String;", "getProductId", "getCategory", "getSubcategory", "getDescription", "getQuantity", "()F", "getUnit", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class PantryLocationEntity {
    public static final int $stable = 0;
    private final String category;
    private final String description;
    private final String id;
    private final String productId;
    private final float quantity;
    private final String subcategory;
    private final String unit;
    private final long updatedAt;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSubcategory() {
        return this.subcategory;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final float getQuantity() {
        return this.quantity;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getUnit() {
        return this.unit;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public final PantryLocationEntity copy(String id, String productId, String category, String subcategory, String description, float quantity, String unit, long updatedAt) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(subcategory, "subcategory");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return new PantryLocationEntity(id, productId, category, subcategory, description, quantity, unit, updatedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PantryLocationEntity)) {
            return false;
        }
        PantryLocationEntity pantryLocationEntity = (PantryLocationEntity) other;
        return Intrinsics.areEqual(this.id, pantryLocationEntity.id) && Intrinsics.areEqual(this.productId, pantryLocationEntity.productId) && Intrinsics.areEqual(this.category, pantryLocationEntity.category) && Intrinsics.areEqual(this.subcategory, pantryLocationEntity.subcategory) && Intrinsics.areEqual(this.description, pantryLocationEntity.description) && Float.compare(this.quantity, pantryLocationEntity.quantity) == 0 && Intrinsics.areEqual(this.unit, pantryLocationEntity.unit) && this.updatedAt == pantryLocationEntity.updatedAt;
    }

    public int hashCode() {
        return (((((((((((((this.id.hashCode() * 31) + this.productId.hashCode()) * 31) + this.category.hashCode()) * 31) + this.subcategory.hashCode()) * 31) + this.description.hashCode()) * 31) + Float.hashCode(this.quantity)) * 31) + this.unit.hashCode()) * 31) + Long.hashCode(this.updatedAt);
    }

    public String toString() {
        return "PantryLocationEntity(id=" + this.id + ", productId=" + this.productId + ", category=" + this.category + ", subcategory=" + this.subcategory + ", description=" + this.description + ", quantity=" + this.quantity + ", unit=" + this.unit + ", updatedAt=" + this.updatedAt + ")";
    }

    public PantryLocationEntity(String id, String productId, String category, String subcategory, String description, float quantity, String unit, long updatedAt) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(subcategory, "subcategory");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.id = id;
        this.productId = productId;
        this.category = category;
        this.subcategory = subcategory;
        this.description = description;
        this.quantity = quantity;
        this.unit = unit;
        this.updatedAt = updatedAt;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PantryLocationEntity(String str, String str2, String str3, String str4, String str5, float f, String str6, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        String str7;
        long jCurrentTimeMillis;
        if ((i & 16) == 0) {
            str7 = str5;
        } else {
            str7 = "";
        }
        if ((i & 128) == 0) {
            jCurrentTimeMillis = j;
        } else {
            jCurrentTimeMillis = System.currentTimeMillis();
        }
        this(str, str2, str3, str4, str7, f, str6, jCurrentTimeMillis);
    }

    public final String getId() {
        return this.id;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getSubcategory() {
        return this.subcategory;
    }

    public final String getDescription() {
        return this.description;
    }

    public final float getQuantity() {
        return this.quantity;
    }

    public final String getUnit() {
        return this.unit;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }
}
