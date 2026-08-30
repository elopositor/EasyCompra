package com.easycompra.app.network;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApiModels.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/easycompra/app/network/MercadonaPhoto;", "", "zoom", "", "<init>", "(Ljava/lang/String;)V", "getZoom", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class MercadonaPhoto {
    public static final int $stable = 0;
    private final String zoom;

    public static /* synthetic */ MercadonaPhoto copy$default(MercadonaPhoto mercadonaPhoto, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mercadonaPhoto.zoom;
        }
        return mercadonaPhoto.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getZoom() {
        return this.zoom;
    }

    public final MercadonaPhoto copy(String zoom) {
        return new MercadonaPhoto(zoom);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MercadonaPhoto) && Intrinsics.areEqual(this.zoom, ((MercadonaPhoto) other).zoom);
    }

    public int hashCode() {
        if (this.zoom == null) {
            return 0;
        }
        return this.zoom.hashCode();
    }

    public String toString() {
        return "MercadonaPhoto(zoom=" + this.zoom + ")";
    }

    public MercadonaPhoto(String zoom) {
        this.zoom = zoom;
    }

    public final String getZoom() {
        return this.zoom;
    }
}
