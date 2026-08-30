package com.easycompra.app.data.recipes;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UnitConverter.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0002J%\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0007R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/easycompra/app/data/recipes/UnitConverter;", "", "<init>", "()V", "toGrams", "", "", "", "toMl", "baseGroup", "unit", "convert", "quantity", "fromUnit", "toUnit", "(FLjava/lang/String;Ljava/lang/String;)Ljava/lang/Float;", "canConvert", "", "unit1", "unit2", "formatQty", "qty", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UnitConverter {
    public static final int $stable;
    public static final UnitConverter INSTANCE = new UnitConverter();
    private static final Map<String, Float> toGrams;
    private static final Map<String, Float> toMl;

    private UnitConverter() {
    }

    static {
        Float fValueOf = Float.valueOf(1.0f);
        Float fValueOf2 = Float.valueOf(1000.0f);
        toGrams = MapsKt.mapOf(TuplesKt.to("g", fValueOf), TuplesKt.to("kg", fValueOf2));
        toMl = MapsKt.mapOf(TuplesKt.to("ml", fValueOf), TuplesKt.to("l", fValueOf2), TuplesKt.to("taza", Float.valueOf(240.0f)), TuplesKt.to("cucharada", Float.valueOf(15.0f)), TuplesKt.to("cucharadita", Float.valueOf(5.0f)));
        $stable = 8;
    }

    private final String baseGroup(String unit) {
        Map<String, Float> map = toGrams;
        String lowerCase = unit.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (map.containsKey(lowerCase)) {
            return "weight";
        }
        Map<String, Float> map2 = toMl;
        String lowerCase2 = unit.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        if (map2.containsKey(lowerCase2)) {
            return "volume";
        }
        return null;
    }

    public final Float convert(float quantity, String fromUnit, String toUnit) {
        Intrinsics.checkNotNullParameter(fromUnit, "fromUnit");
        Intrinsics.checkNotNullParameter(toUnit, "toUnit");
        String from = fromUnit.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(from, "toLowerCase(...)");
        String to = toUnit.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(to, "toLowerCase(...)");
        if (Intrinsics.areEqual(from, to)) {
            return Float.valueOf(quantity);
        }
        Float fromGrams = toGrams.get(from);
        Float toGrams2 = toGrams.get(to);
        if (fromGrams != null && toGrams2 != null) {
            return Float.valueOf((fromGrams.floatValue() * quantity) / toGrams2.floatValue());
        }
        Float fromMl = toMl.get(from);
        Float toMl2 = toMl.get(to);
        if (fromMl == null || toMl2 == null) {
            return null;
        }
        return Float.valueOf((fromMl.floatValue() * quantity) / toMl2.floatValue());
    }

    public final boolean canConvert(String unit1, String unit2) {
        Intrinsics.checkNotNullParameter(unit1, "unit1");
        Intrinsics.checkNotNullParameter(unit2, "unit2");
        String lowerCase = unit1.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String lowerCase2 = unit2.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
            return true;
        }
        return baseGroup(unit1) != null && Intrinsics.areEqual(baseGroup(unit1), baseGroup(unit2));
    }

    public final String formatQty(float qty) {
        if (qty == ((float) ((long) qty))) {
            return String.valueOf((long) qty);
        }
        String str = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(qty)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
