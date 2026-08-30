package com.easycompra.app.ui.planner;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.easycompra.app.data.planner.PlannerEntry;
import com.easycompra.app.data.planner.WeekAnalysis;
import java.time.LocalDate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlannerScreen.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class PlannerScreenKt$PlannerScreen$3$1$3$1$2$1 implements Function3<LazyItemScope, Composer, Integer, Unit> {
    final /* synthetic */ WeekAnalysis $analysis;
    final /* synthetic */ Map<String, PlannerEntry> $dayEntries;
    final /* synthetic */ LocalDate $selectedDate;
    final /* synthetic */ String $slot;
    final /* synthetic */ PlannerViewModel $viewModel;

    PlannerScreenKt$PlannerScreen$3$1$3$1$2$1(String str, Map<String, PlannerEntry> map, WeekAnalysis weekAnalysis, PlannerViewModel plannerViewModel, LocalDate localDate) {
        this.$slot = str;
        this.$dayEntries = map;
        this.$analysis = weekAnalysis;
        this.$viewModel = plannerViewModel;
        this.$selectedDate = localDate;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
        invoke(lazyItemScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
        Object value$iv;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C160@7023L42,156@6827L264:PlannerScreen.kt#auin6u");
        if (($changed & 17) != 16 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1622605941, $changed, -1, "com.easycompra.app.ui.planner.PlannerScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PlannerScreen.kt:156)");
            }
            String str = this.$slot;
            PlannerEntry plannerEntry = this.$dayEntries.get(this.$slot);
            WeekAnalysis weekAnalysis = this.$analysis;
            $composer.startReplaceGroup(-390360646);
            ComposerKt.sourceInformation($composer, "CC(remember):PlannerScreen.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(this.$viewModel) | $composer.changedInstance(this.$selectedDate) | $composer.changed(this.$slot);
            final PlannerViewModel plannerViewModel = this.$viewModel;
            final LocalDate localDate = this.$selectedDate;
            final String str2 = this.$slot;
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function0() { // from class: com.easycompra.app.ui.planner.PlannerScreenKt$PlannerScreen$3$1$3$1$2$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PlannerScreenKt$PlannerScreen$3$1$3$1$2$1.invoke$lambda$1$lambda$0(plannerViewModel, localDate, str2);
                    }
                };
                $composer.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer.endReplaceGroup();
            PlannerScreenKt.MealSlotCard(str, plannerEntry, weekAnalysis, (Function0) value$iv, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(PlannerViewModel $viewModel, LocalDate $selectedDate, String $slot) {
        $viewModel.openSlot($selectedDate, $slot);
        return Unit.INSTANCE;
    }
}
