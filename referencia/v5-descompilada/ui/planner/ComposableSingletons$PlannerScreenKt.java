package com.easycompra.app.ui.planner;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ChevronLeftKt;
import androidx.compose.material.icons.filled.ChevronRightKt;
import androidx.compose.material.icons.filled.TodayKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlannerScreen.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$PlannerScreenKt {
    public static final ComposableSingletons$PlannerScreenKt INSTANCE = new ComposableSingletons$PlannerScreenKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f150lambda1 = ComposableLambdaKt.composableLambdaInstance(444318069, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.planner.ComposableSingletons$PlannerScreenKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C106@4557L50:PlannerScreen.kt#auin6u");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(444318069, $changed, -1, "com.easycompra.app.ui.planner.ComposableSingletons$PlannerScreenKt.lambda-1.<anonymous> (PlannerScreen.kt:106)");
            }
            IconKt.m2171Iconww6aTOc(ChevronLeftKt.getChevronLeft(Icons.INSTANCE.getDefault()), "Semana anterior", (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f151lambda2 = ComposableLambdaKt.composableLambdaInstance(1360420934, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.planner.ComposableSingletons$PlannerScreenKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C111@4777L32:PlannerScreen.kt#auin6u");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1360420934, $changed, -1, "com.easycompra.app.ui.planner.ComposableSingletons$PlannerScreenKt.lambda-2.<anonymous> (PlannerScreen.kt:111)");
            }
            IconKt.m2171Iconww6aTOc(TodayKt.getToday(Icons.INSTANCE.getDefault()), "Hoy", (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f152lambda3 = ComposableLambdaKt.composableLambdaInstance(1267967549, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.planner.ComposableSingletons$PlannerScreenKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C114@4925L52:PlannerScreen.kt#auin6u");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1267967549, $changed, -1, "com.easycompra.app.ui.planner.ComposableSingletons$PlannerScreenKt.lambda-3.<anonymous> (PlannerScreen.kt:114)");
            }
            IconKt.m2171Iconww6aTOc(ChevronRightKt.getChevronRight(Icons.INSTANCE.getDefault()), "Semana siguiente", (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-4, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f153lambda4 = ComposableLambdaKt.composableLambdaInstance(-1837117726, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.planner.ComposableSingletons$PlannerScreenKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C179@7851L30:PlannerScreen.kt#auin6u");
            if (($changed & 17) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1837117726, $changed, -1, "com.easycompra.app.ui.planner.ComposableSingletons$PlannerScreenKt.lambda-4.<anonymous> (PlannerScreen.kt:179)");
            }
            SpacerKt.Spacer(SizeKt.m712height3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(32)), $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-5, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f154lambda5 = ComposableLambdaKt.composableLambdaInstance(1206999584, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.planner.ComposableSingletons$PlannerScreenKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation($composer, "C415@17361L33:PlannerScreen.kt#auin6u");
            if (($changed & 17) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1206999584, $changed, -1, "com.easycompra.app.ui.planner.ComposableSingletons$PlannerScreenKt.lambda-5.<anonymous> (PlannerScreen.kt:415)");
            }
            TextKt.m2714Text4IGK_g("+ Lista", (Modifier) null, 0L, TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 3078, 0, 131062);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7155getLambda1$app_debug() {
        return f150lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7156getLambda2$app_debug() {
        return f151lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7157getLambda3$app_debug() {
        return f152lambda3;
    }

    /* JADX INFO: renamed from: getLambda-4$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7158getLambda4$app_debug() {
        return f153lambda4;
    }

    /* JADX INFO: renamed from: getLambda-5$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7159getLambda5$app_debug() {
        return f154lambda5;
    }
}
