package com.easycompra.app.ui.planner;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: PlannerViewModel.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0002\u001a\b\u0010\u0002\u001a\u00020\u0003H\u0002¨\u0006\u0004"}, d2 = {"currentWeekStart", "Ljava/time/LocalDate;", "todayIndex", "", "app_debug"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PlannerViewModelKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final LocalDate currentWeekStart() {
        LocalDate localDateWith = LocalDate.now().with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        Intrinsics.checkNotNullExpressionValue(localDateWith, "with(...)");
        return localDateWith;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int todayIndex() {
        LocalDate today = LocalDate.now();
        LocalDate weekStart = currentWeekStart();
        long diff = today.toEpochDay() - weekStart.toEpochDay();
        return RangesKt.coerceIn((int) diff, 0, 6);
    }
}
