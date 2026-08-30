package com.easycompra.app.data.pantry;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PantryDao.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/easycompra/app/data/pantry/PantryProductWithLocations;", "", "product", "Lcom/easycompra/app/data/pantry/PantryProductEntity;", "locations", "", "Lcom/easycompra/app/data/pantry/PantryLocationEntity;", "<init>", "(Lcom/easycompra/app/data/pantry/PantryProductEntity;Ljava/util/List;)V", "getProduct", "()Lcom/easycompra/app/data/pantry/PantryProductEntity;", "getLocations", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class PantryProductWithLocations {
    public static final int $stable = 8;
    private final List<PantryLocationEntity> locations;
    private final PantryProductEntity product;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PantryProductWithLocations copy$default(PantryProductWithLocations pantryProductWithLocations, PantryProductEntity pantryProductEntity, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            pantryProductEntity = pantryProductWithLocations.product;
        }
        if ((i & 2) != 0) {
            list = pantryProductWithLocations.locations;
        }
        return pantryProductWithLocations.copy(pantryProductEntity, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PantryProductEntity getProduct() {
        return this.product;
    }

    public final List<PantryLocationEntity> component2() {
        return this.locations;
    }

    public final PantryProductWithLocations copy(PantryProductEntity product, List<PantryLocationEntity> locations) {
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(locations, "locations");
        return new PantryProductWithLocations(product, locations);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PantryProductWithLocations)) {
            return false;
        }
        PantryProductWithLocations pantryProductWithLocations = (PantryProductWithLocations) other;
        return Intrinsics.areEqual(this.product, pantryProductWithLocations.product) && Intrinsics.areEqual(this.locations, pantryProductWithLocations.locations);
    }

    public int hashCode() {
        return (this.product.hashCode() * 31) + this.locations.hashCode();
    }

    public String toString() {
        return "PantryProductWithLocations(product=" + this.product + ", locations=" + this.locations + ")";
    }

    public PantryProductWithLocations(PantryProductEntity product, List<PantryLocationEntity> locations) {
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(locations, "locations");
        this.product = product;
        this.locations = locations;
    }

    public final PantryProductEntity getProduct() {
        return this.product;
    }

    public final List<PantryLocationEntity> getLocations() {
        return this.locations;
    }
}
