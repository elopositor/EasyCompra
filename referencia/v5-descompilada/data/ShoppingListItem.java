package com.easycompra.app.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ShoppingListStore.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/easycompra/app/data/ShoppingListItem;", "", "product", "Lcom/easycompra/app/data/Product;", "quantity", "", "<init>", "(Lcom/easycompra/app/data/Product;I)V", "getProduct", "()Lcom/easycompra/app/data/Product;", "getQuantity", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class ShoppingListItem {
    public static final int $stable = 0;
    private final Product product;
    private final int quantity;

    public static /* synthetic */ ShoppingListItem copy$default(ShoppingListItem shoppingListItem, Product product, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            product = shoppingListItem.product;
        }
        if ((i2 & 2) != 0) {
            i = shoppingListItem.quantity;
        }
        return shoppingListItem.copy(product, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Product getProduct() {
        return this.product;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getQuantity() {
        return this.quantity;
    }

    public final ShoppingListItem copy(Product product, int quantity) {
        Intrinsics.checkNotNullParameter(product, "product");
        return new ShoppingListItem(product, quantity);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ShoppingListItem)) {
            return false;
        }
        ShoppingListItem shoppingListItem = (ShoppingListItem) other;
        return Intrinsics.areEqual(this.product, shoppingListItem.product) && this.quantity == shoppingListItem.quantity;
    }

    public int hashCode() {
        return (this.product.hashCode() * 31) + Integer.hashCode(this.quantity);
    }

    public String toString() {
        return "ShoppingListItem(product=" + this.product + ", quantity=" + this.quantity + ")";
    }

    public ShoppingListItem(Product product, int quantity) {
        Intrinsics.checkNotNullParameter(product, "product");
        this.product = product;
        this.quantity = quantity;
    }

    public /* synthetic */ ShoppingListItem(Product product, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(product, (i2 & 2) != 0 ? 1 : i);
    }

    public final Product getProduct() {
        return this.product;
    }

    public final int getQuantity() {
        return this.quantity;
    }
}
