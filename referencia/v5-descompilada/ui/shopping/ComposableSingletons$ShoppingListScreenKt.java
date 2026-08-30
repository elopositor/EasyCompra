package com.easycompra.app.ui.shopping;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.AddKt;
import androidx.compose.material.icons.filled.CloseKt;
import androidx.compose.material.icons.filled.DeleteSweepKt;
import androidx.compose.material.icons.filled.RemoveKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ShoppingListScreen.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$ShoppingListScreenKt {
    public static final ComposableSingletons$ShoppingListScreenKt INSTANCE = new ComposableSingletons$ShoppingListScreenKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f197lambda1 = ComposableLambdaKt.composableLambdaInstance(90694351, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.shopping.ComposableSingletons$ShoppingListScreenKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C96@4372L62:ShoppingListScreen.kt#fjjmxg");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(90694351, $changed, -1, "com.easycompra.app.ui.shopping.ComposableSingletons$ShoppingListScreenKt.lambda-1.<anonymous> (ShoppingListScreen.kt:96)");
            }
            IconKt.m2171Iconww6aTOc(DeleteSweepKt.getDeleteSweep(Icons.INSTANCE.getDefault()), "Vaciar lista de comparación", (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f198lambda2 = ComposableLambdaKt.composableLambdaInstance(1486028992, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.shopping.ComposableSingletons$ShoppingListScreenKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C139@6158L34:ShoppingListScreen.kt#fjjmxg");
            if (($changed & 17) != 16 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1486028992, $changed, -1, "com.easycompra.app.ui.shopping.ComposableSingletons$ShoppingListScreenKt.lambda-2.<anonymous> (ShoppingListScreen.kt:139)");
                }
                ShoppingListScreenKt.SectionHeader("Desde tu Despensa", $composer, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f199lambda3 = ComposableLambdaKt.composableLambdaInstance(-417849445, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.shopping.ComposableSingletons$ShoppingListScreenKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C148@6603L29:ShoppingListScreen.kt#fjjmxg");
            if (($changed & 17) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-417849445, $changed, -1, "com.easycompra.app.ui.shopping.ComposableSingletons$ShoppingListScreenKt.lambda-3.<anonymous> (ShoppingListScreen.kt:148)");
            }
            SpacerKt.Spacer(SizeKt.m712height3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(4)), $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-4, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f200lambda4 = ComposableLambdaKt.composableLambdaInstance(-398835337, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.shopping.ComposableSingletons$ShoppingListScreenKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C155@6818L30:ShoppingListScreen.kt#fjjmxg");
            if (($changed & 17) != 16 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-398835337, $changed, -1, "com.easycompra.app.ui.shopping.ComposableSingletons$ShoppingListScreenKt.lambda-4.<anonymous> (ShoppingListScreen.kt:155)");
                }
                ShoppingListScreenKt.SectionHeader("Desde recetas", $composer, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-5, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f201lambda5 = ComposableLambdaKt.composableLambdaInstance(-369945198, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.shopping.ComposableSingletons$ShoppingListScreenKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C164@7262L29:ShoppingListScreen.kt#fjjmxg");
            if (($changed & 17) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-369945198, $changed, -1, "com.easycompra.app.ui.shopping.ComposableSingletons$ShoppingListScreenKt.lambda-5.<anonymous> (ShoppingListScreen.kt:164)");
            }
            SpacerKt.Spacer(SizeKt.m712height3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(4)), $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-6, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f202lambda6 = ComposableLambdaKt.composableLambdaInstance(1856668472, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.shopping.ComposableSingletons$ShoppingListScreenKt$lambda-6$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C171@7478L39:ShoppingListScreen.kt#fjjmxg");
            if (($changed & 17) != 16 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1856668472, $changed, -1, "com.easycompra.app.ui.shopping.ComposableSingletons$ShoppingListScreenKt.lambda-6.<anonymous> (ShoppingListScreen.kt:171)");
                }
                ShoppingListScreenKt.SectionHeader("Comparación de precios", $composer, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-7, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f203lambda7 = ComposableLambdaKt.composableLambdaInstance(619462243, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.shopping.ComposableSingletons$ShoppingListScreenKt$lambda-7$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C280@11507L89:ShoppingListScreen.kt#fjjmxg");
            if (($changed & 3) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(619462243, $changed, -1, "com.easycompra.app.ui.shopping.ComposableSingletons$ShoppingListScreenKt.lambda-7.<anonymous> (ShoppingListScreen.kt:280)");
                }
                IconKt.m2171Iconww6aTOc(CloseKt.getClose(Icons.INSTANCE.getDefault()), "Eliminar", SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(18)), Color.INSTANCE.m4211getGray0d7_KjU(), $composer, 3504, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-8, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f204lambda8 = ComposableLambdaKt.composableLambdaInstance(-1471038399, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.shopping.ComposableSingletons$ShoppingListScreenKt$lambda-8$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C333@13552L73:ShoppingListScreen.kt#fjjmxg");
            if (($changed & 3) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1471038399, $changed, -1, "com.easycompra.app.ui.shopping.ComposableSingletons$ShoppingListScreenKt.lambda-8.<anonymous> (ShoppingListScreen.kt:333)");
                }
                IconKt.m2171Iconww6aTOc(RemoveKt.getRemove(Icons.INSTANCE.getDefault()), "Quitar uno", SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(16)), 0L, $composer, 432, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: lambda-9, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f205lambda9 = ComposableLambdaKt.composableLambdaInstance(-104287382, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.shopping.ComposableSingletons$ShoppingListScreenKt$lambda-9$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C343@14045L70:ShoppingListScreen.kt#fjjmxg");
            if (($changed & 3) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-104287382, $changed, -1, "com.easycompra.app.ui.shopping.ComposableSingletons$ShoppingListScreenKt.lambda-9.<anonymous> (ShoppingListScreen.kt:343)");
                }
                IconKt.m2171Iconww6aTOc(AddKt.getAdd(Icons.INSTANCE.getDefault()), "Añadir uno", SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(16)), 0L, $composer, 432, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* JADX INFO: renamed from: getLambda-1$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7239getLambda1$app_debug() {
        return f197lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7240getLambda2$app_debug() {
        return f198lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7241getLambda3$app_debug() {
        return f199lambda3;
    }

    /* JADX INFO: renamed from: getLambda-4$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7242getLambda4$app_debug() {
        return f200lambda4;
    }

    /* JADX INFO: renamed from: getLambda-5$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7243getLambda5$app_debug() {
        return f201lambda5;
    }

    /* JADX INFO: renamed from: getLambda-6$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7244getLambda6$app_debug() {
        return f202lambda6;
    }

    /* JADX INFO: renamed from: getLambda-7$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7245getLambda7$app_debug() {
        return f203lambda7;
    }

    /* JADX INFO: renamed from: getLambda-8$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7246getLambda8$app_debug() {
        return f204lambda8;
    }

    /* JADX INFO: renamed from: getLambda-9$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7247getLambda9$app_debug() {
        return f205lambda9;
    }
}
