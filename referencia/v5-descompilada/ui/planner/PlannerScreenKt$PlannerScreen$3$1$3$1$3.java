package com.easycompra.app.ui.planner;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.easycompra.app.data.planner.IngredientNeed;
import com.easycompra.app.data.planner.WeekAnalysis;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlannerScreen.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class PlannerScreenKt$PlannerScreen$3$1$3$1$3 implements Function3<LazyItemScope, Composer, Integer, Unit> {
    final /* synthetic */ WeekAnalysis $analysis;
    final /* synthetic */ PlannerViewModel $viewModel;

    PlannerScreenKt$PlannerScreen$3$1$3$1$3(WeekAnalysis weekAnalysis, PlannerViewModel plannerViewModel) {
        this.$analysis = weekAnalysis;
        this.$viewModel = plannerViewModel;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
        invoke(lazyItemScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
        Object value$iv;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C169@7458L29,172@7618L142,170@7512L274:PlannerScreen.kt#auin6u");
        if (($changed & 17) != 16 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1147413698, $changed, -1, "com.easycompra.app.ui.planner.PlannerScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PlannerScreen.kt:169)");
            }
            SpacerKt.Spacer(SizeKt.m712height3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(8)), $composer, 6);
            WeekAnalysis weekAnalysis = this.$analysis;
            $composer.startReplaceGroup(-1134896129);
            ComposerKt.sourceInformation($composer, "CC(remember):PlannerScreen.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(this.$viewModel);
            final PlannerViewModel plannerViewModel = this.$viewModel;
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function1() { // from class: com.easycompra.app.ui.planner.PlannerScreenKt$PlannerScreen$3$1$3$1$3$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PlannerScreenKt$PlannerScreen$3$1$3$1$3.invoke$lambda$1$lambda$0(plannerViewModel, (IngredientNeed) obj);
                    }
                };
                $composer.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer.endReplaceGroup();
            PlannerScreenKt.AnalysisPanel(weekAnalysis, (Function1) value$iv, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(PlannerViewModel $viewModel, IngredientNeed need) {
        Intrinsics.checkNotNullParameter(need, "need");
        $viewModel.addMissingToShoppingList(need.getName(), need.getUnit(), need.getDeficit());
        return Unit.INSTANCE;
    }
}
