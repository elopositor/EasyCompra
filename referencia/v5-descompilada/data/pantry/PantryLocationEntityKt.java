package com.easycompra.app.data.pantry;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PantryLocationEntity.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0002\u0010\u0006\u001a\u0014\u0010\u0007\u001a\u00020\b*\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0003¨\u0006\u000b"}, d2 = {"formatPantryQty", "", "qty", "", "parsePantryQty", "text", "(Ljava/lang/String;)Ljava/lang/Float;", "stockStatus", "Lcom/easycompra/app/data/pantry/StockStatus;", "Lcom/easycompra/app/data/pantry/PantryLocationEntity;", "limiteBajo", "app_debug"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PantryLocationEntityKt {
    public static final String formatPantryQty(float qty) {
        String fracStr;
        int whole = (int) qty;
        float frac = qty - whole;
        if (frac == 0.0f) {
            fracStr = "";
        } else if (frac >= 0.74f) {
            fracStr = "¾";
        } else {
            fracStr = frac >= 0.49f ? "½" : "¼";
        }
        if (whole == 0) {
            if (fracStr.length() > 0) {
                return fracStr;
            }
        }
        return fracStr.length() == 0 ? String.valueOf(whole) : whole + fracStr;
    }

    public static final Float parsePantryQty(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        String t = StringsKt.trim((CharSequence) text).toString();
        if (StringsKt.contains$default((CharSequence) t, '/', false, 2, (Object) null)) {
            List parts = StringsKt.split$default((CharSequence) t, new char[]{'/'}, false, 0, 6, (Object) null);
            if (parts.size() == 2) {
                Float floatOrNull = StringsKt.toFloatOrNull(StringsKt.trim((CharSequence) parts.get(0)).toString());
                if (floatOrNull == null) {
                    return null;
                }
                float num = floatOrNull.floatValue();
                Float floatOrNull2 = StringsKt.toFloatOrNull(StringsKt.trim((CharSequence) parts.get(1)).toString());
                if (floatOrNull2 != null) {
                    float it = floatOrNull2.floatValue();
                    if (!(true ^ (it == 0.0f))) {
                        floatOrNull2 = null;
                    }
                    if (floatOrNull2 != null) {
                        float den = floatOrNull2.floatValue();
                        return Float.valueOf(num / den);
                    }
                }
                return null;
            }
        }
        return StringsKt.toFloatOrNull(t);
    }

    public static final StockStatus stockStatus(PantryLocationEntity $this$stockStatus, float limiteBajo) {
        Intrinsics.checkNotNullParameter($this$stockStatus, "<this>");
        if ($this$stockStatus.getQuantity() <= 0.0f) {
            return StockStatus.EMPTY;
        }
        return $this$stockStatus.getQuantity() <= limiteBajo ? StockStatus.LOW : StockStatus.OK;
    }

    public static /* synthetic */ StockStatus stockStatus$default(PantryLocationEntity pantryLocationEntity, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 2.0f;
        }
        return stockStatus(pantryLocationEntity, f);
    }
}
