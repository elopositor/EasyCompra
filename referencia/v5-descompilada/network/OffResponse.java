package com.easycompra.app.network;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApiModels.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/easycompra/app/network/OffResponse;", "", NotificationCompat.CATEGORY_STATUS, "", "product", "Lcom/easycompra/app/network/OffProduct;", "<init>", "(ILcom/easycompra/app/network/OffProduct;)V", "getStatus", "()I", "getProduct", "()Lcom/easycompra/app/network/OffProduct;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class OffResponse {
    public static final int $stable = 0;
    private final OffProduct product;
    private final int status;

    public static /* synthetic */ OffResponse copy$default(OffResponse offResponse, int i, OffProduct offProduct, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = offResponse.status;
        }
        if ((i2 & 2) != 0) {
            offProduct = offResponse.product;
        }
        return offResponse.copy(i, offProduct);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final OffProduct getProduct() {
        return this.product;
    }

    public final OffResponse copy(int status, OffProduct product) {
        return new OffResponse(status, product);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OffResponse)) {
            return false;
        }
        OffResponse offResponse = (OffResponse) other;
        return this.status == offResponse.status && Intrinsics.areEqual(this.product, offResponse.product);
    }

    public int hashCode() {
        return (Integer.hashCode(this.status) * 31) + (this.product == null ? 0 : this.product.hashCode());
    }

    public String toString() {
        return "OffResponse(status=" + this.status + ", product=" + this.product + ")";
    }

    public OffResponse(int status, OffProduct product) {
        this.status = status;
        this.product = product;
    }

    public final int getStatus() {
        return this.status;
    }

    public final OffProduct getProduct() {
        return this.product;
    }
}
