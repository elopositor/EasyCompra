package com.easycompra.app.network;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApiModels.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/easycompra/app/network/MercadonaSubcategory;", "", "products", "", "Lcom/easycompra/app/network/MercadonaProductSummary;", "<init>", "(Ljava/util/List;)V", "getProducts", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class MercadonaSubcategory {
    public static final int $stable = 8;
    private final List<MercadonaProductSummary> products;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MercadonaSubcategory copy$default(MercadonaSubcategory mercadonaSubcategory, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = mercadonaSubcategory.products;
        }
        return mercadonaSubcategory.copy(list);
    }

    public final List<MercadonaProductSummary> component1() {
        return this.products;
    }

    public final MercadonaSubcategory copy(List<MercadonaProductSummary> products) {
        Intrinsics.checkNotNullParameter(products, "products");
        return new MercadonaSubcategory(products);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MercadonaSubcategory) && Intrinsics.areEqual(this.products, ((MercadonaSubcategory) other).products);
    }

    public int hashCode() {
        return this.products.hashCode();
    }

    public String toString() {
        return "MercadonaSubcategory(products=" + this.products + ")";
    }

    public MercadonaSubcategory(List<MercadonaProductSummary> products) {
        Intrinsics.checkNotNullParameter(products, "products");
        this.products = products;
    }

    public final List<MercadonaProductSummary> getProducts() {
        return this.products;
    }
}
