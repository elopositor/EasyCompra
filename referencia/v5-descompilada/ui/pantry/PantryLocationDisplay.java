package com.easycompra.app.ui.pantry;

import com.easycompra.app.data.pantry.PantryLocationEntity;
import com.easycompra.app.data.pantry.PantryProductEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PantryViewModel.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/easycompra/app/ui/pantry/PantryLocationDisplay;", "", "location", "Lcom/easycompra/app/data/pantry/PantryLocationEntity;", "product", "Lcom/easycompra/app/data/pantry/PantryProductEntity;", "<init>", "(Lcom/easycompra/app/data/pantry/PantryLocationEntity;Lcom/easycompra/app/data/pantry/PantryProductEntity;)V", "getLocation", "()Lcom/easycompra/app/data/pantry/PantryLocationEntity;", "getProduct", "()Lcom/easycompra/app/data/pantry/PantryProductEntity;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class PantryLocationDisplay {
    public static final int $stable = 0;
    private final PantryLocationEntity location;
    private final PantryProductEntity product;

    public static /* synthetic */ PantryLocationDisplay copy$default(PantryLocationDisplay pantryLocationDisplay, PantryLocationEntity pantryLocationEntity, PantryProductEntity pantryProductEntity, int i, Object obj) {
        if ((i & 1) != 0) {
            pantryLocationEntity = pantryLocationDisplay.location;
        }
        if ((i & 2) != 0) {
            pantryProductEntity = pantryLocationDisplay.product;
        }
        return pantryLocationDisplay.copy(pantryLocationEntity, pantryProductEntity);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PantryLocationEntity getLocation() {
        return this.location;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PantryProductEntity getProduct() {
        return this.product;
    }

    public final PantryLocationDisplay copy(PantryLocationEntity location, PantryProductEntity product) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(product, "product");
        return new PantryLocationDisplay(location, product);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PantryLocationDisplay)) {
            return false;
        }
        PantryLocationDisplay pantryLocationDisplay = (PantryLocationDisplay) other;
        return Intrinsics.areEqual(this.location, pantryLocationDisplay.location) && Intrinsics.areEqual(this.product, pantryLocationDisplay.product);
    }

    public int hashCode() {
        return (this.location.hashCode() * 31) + this.product.hashCode();
    }

    public String toString() {
        return "PantryLocationDisplay(location=" + this.location + ", product=" + this.product + ")";
    }

    public PantryLocationDisplay(PantryLocationEntity location, PantryProductEntity product) {
        Intrinsics.checkNotNullParameter(location, "location");
        Intrinsics.checkNotNullParameter(product, "product");
        this.location = location;
        this.product = product;
    }

    public final PantryLocationEntity getLocation() {
        return this.location;
    }

    public final PantryProductEntity getProduct() {
        return this.product;
    }
}
