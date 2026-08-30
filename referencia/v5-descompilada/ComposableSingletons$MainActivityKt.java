package com.easycompra.app;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CalendarMonthKt;
import androidx.compose.material.icons.filled.HomeKt;
import androidx.compose.material.icons.filled.KitchenKt;
import androidx.compose.material.icons.filled.MenuBookKt;
import androidx.compose.material.icons.filled.ShoppingCartKt;
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$MainActivityKt {
    public static final ComposableSingletons$MainActivityKt INSTANCE = new ComposableSingletons$MainActivityKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f90lambda1 = ComposableLambdaKt.composableLambdaInstance(-109575084, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ComposableSingletons$MainActivityKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C73@3598L51:MainActivity.kt#t7ni9s");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-109575084, $changed, -1, "com.easycompra.app.ComposableSingletons$MainActivityKt.lambda-1.<anonymous> (MainActivity.kt:73)");
            }
            IconKt.m2171Iconww6aTOc(HomeKt.getHome(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f92lambda2 = ComposableLambdaKt.composableLambdaInstance(-364003497, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ComposableSingletons$MainActivityKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C74@3699L17:MainActivity.kt#t7ni9s");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-364003497, $changed, -1, "com.easycompra.app.ComposableSingletons$MainActivityKt.lambda-2.<anonymous> (MainActivity.kt:74)");
            }
            TextKt.m2714Text4IGK_g("Productos", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function3<BoxScope, Composer, Integer, Unit> f93lambda3 = ComposableLambdaKt.composableLambdaInstance(-1942294845, false, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ComposableSingletons$MainActivityKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer, Integer num) {
            invoke(boxScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(BoxScope BadgedBox, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(BadgedBox, "$this$BadgedBox");
            ComposerKt.sourceInformation($composer, "C90@4629L59:MainActivity.kt#t7ni9s");
            if (($changed & 17) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1942294845, $changed, -1, "com.easycompra.app.ComposableSingletons$MainActivityKt.lambda-3.<anonymous> (MainActivity.kt:90)");
            }
            IconKt.m2171Iconww6aTOc(ShoppingCartKt.getShoppingCart(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-4, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f94lambda4 = ComposableLambdaKt.composableLambdaInstance(-2010406080, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ComposableSingletons$MainActivityKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C93@4816L16:MainActivity.kt#t7ni9s");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2010406080, $changed, -1, "com.easycompra.app.ComposableSingletons$MainActivityKt.lambda-4.<anonymous> (MainActivity.kt:93)");
            }
            TextKt.m2714Text4IGK_g("Mi lista", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-5, reason: not valid java name */
    public static Function3<BoxScope, Composer, Integer, Unit> f95lambda5 = ComposableLambdaKt.composableLambdaInstance(1880675042, false, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ComposableSingletons$MainActivityKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer, Integer num) {
            invoke(boxScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(BoxScope BadgedBox, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(BadgedBox, "$this$BadgedBox");
            ComposerKt.sourceInformation($composer, "C109@5745L54:MainActivity.kt#t7ni9s");
            if (($changed & 17) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1880675042, $changed, -1, "com.easycompra.app.ComposableSingletons$MainActivityKt.lambda-5.<anonymous> (MainActivity.kt:109)");
            }
            IconKt.m2171Iconww6aTOc(KitchenKt.getKitchen(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-6, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f96lambda6 = ComposableLambdaKt.composableLambdaInstance(1812563807, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ComposableSingletons$MainActivityKt$lambda-6$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C112@5927L16:MainActivity.kt#t7ni9s");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1812563807, $changed, -1, "com.easycompra.app.ComposableSingletons$MainActivityKt.lambda-6.<anonymous> (MainActivity.kt:112)");
            }
            TextKt.m2714Text4IGK_g("Despensa", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-7, reason: not valid java name */
    public static Function3<BoxScope, Composer, Integer, Unit> f97lambda7 = ComposableLambdaKt.composableLambdaInstance(1408677633, false, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ComposableSingletons$MainActivityKt$lambda-7$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer, Integer num) {
            invoke(boxScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(BoxScope BadgedBox, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(BadgedBox, "$this$BadgedBox");
            ComposerKt.sourceInformation($composer, "C128@6891L55:MainActivity.kt#t7ni9s");
            if (($changed & 17) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1408677633, $changed, -1, "com.easycompra.app.ComposableSingletons$MainActivityKt.lambda-7.<anonymous> (MainActivity.kt:128)");
            }
            IconKt.m2171Iconww6aTOc(MenuBookKt.getMenuBook(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-8, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f98lambda8 = ComposableLambdaKt.composableLambdaInstance(1340566398, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ComposableSingletons$MainActivityKt$lambda-8$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C131@7074L15:MainActivity.kt#t7ni9s");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1340566398, $changed, -1, "com.easycompra.app.ComposableSingletons$MainActivityKt.lambda-8.<anonymous> (MainActivity.kt:131)");
            }
            TextKt.m2714Text4IGK_g("Recetas", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-9, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f99lambda9 = ComposableLambdaKt.composableLambdaInstance(561138010, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ComposableSingletons$MainActivityKt$lambda-9$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C140@7596L60:MainActivity.kt#t7ni9s");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(561138010, $changed, -1, "com.easycompra.app.ComposableSingletons$MainActivityKt.lambda-9.<anonymous> (MainActivity.kt:140)");
            }
            IconKt.m2171Iconww6aTOc(CalendarMonthKt.getCalendarMonth(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-10, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f91lambda10 = ComposableLambdaKt.composableLambdaInstance(868568989, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ComposableSingletons$MainActivityKt$lambda-10$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C141@7706L14:MainActivity.kt#t7ni9s");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(868568989, $changed, -1, "com.easycompra.app.ComposableSingletons$MainActivityKt.lambda-10.<anonymous> (MainActivity.kt:141)");
            }
            TextKt.m2714Text4IGK_g("Semana", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7037getLambda1$app_debug() {
        return f90lambda1;
    }

    /* JADX INFO: renamed from: getLambda-10$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7038getLambda10$app_debug() {
        return f91lambda10;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7039getLambda2$app_debug() {
        return f92lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$app_debug, reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m7040getLambda3$app_debug() {
        return f93lambda3;
    }

    /* JADX INFO: renamed from: getLambda-4$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7041getLambda4$app_debug() {
        return f94lambda4;
    }

    /* JADX INFO: renamed from: getLambda-5$app_debug, reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m7042getLambda5$app_debug() {
        return f95lambda5;
    }

    /* JADX INFO: renamed from: getLambda-6$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7043getLambda6$app_debug() {
        return f96lambda6;
    }

    /* JADX INFO: renamed from: getLambda-7$app_debug, reason: not valid java name */
    public final Function3<BoxScope, Composer, Integer, Unit> m7044getLambda7$app_debug() {
        return f97lambda7;
    }

    /* JADX INFO: renamed from: getLambda-8$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7045getLambda8$app_debug() {
        return f98lambda8;
    }

    /* JADX INFO: renamed from: getLambda-9$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7046getLambda9$app_debug() {
        return f99lambda9;
    }
}
