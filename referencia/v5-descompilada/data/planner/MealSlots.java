package com.easycompra.app.data.planner;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlannerEntry.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/easycompra/app/data/planner/MealSlots;", "", "<init>", "()V", "all", "", "", "getAll", "()Ljava/util/List;", "icon", "slot", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MealSlots {
    public static final MealSlots INSTANCE = new MealSlots();
    private static final List<String> all = CollectionsKt.listOf((Object[]) new String[]{"Desayuno", "Comida", "Merienda", "Cena"});
    public static final int $stable = 8;

    private MealSlots() {
    }

    public final List<String> getAll() {
        return all;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:16:0x0030 A[ORIG_RETURN, RETURN] */
    public final String icon(String slot) {
        Intrinsics.checkNotNullParameter(slot, "slot");
        switch (slot) {
            case "Merienda":
                return "☕";
            case "Desayuno":
                return "☀️";
            case "Comida":
                return "🍽️";
            default:
                return "🌙";
        }
    }
}
