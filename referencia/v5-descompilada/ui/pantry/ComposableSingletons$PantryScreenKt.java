package com.easycompra.app.ui.pantry;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.AddKt;
import androidx.compose.material.icons.filled.CloseKt;
import androidx.compose.material.icons.filled.DeleteKt;
import androidx.compose.material.icons.filled.RemoveKt;
import androidx.compose.material.icons.filled.SearchKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PantryScreen.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$PantryScreenKt {
    public static final ComposableSingletons$PantryScreenKt INSTANCE = new ComposableSingletons$PantryScreenKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f124lambda1 = ComposableLambdaKt.composableLambdaInstance(-1702520815, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.ComposableSingletons$PantryScreenKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C113@5101L47:PantryScreen.kt#mq3b12");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1702520815, $changed, -1, "com.easycompra.app.ui.pantry.ComposableSingletons$PantryScreenKt.lambda-1.<anonymous> (PantryScreen.kt:113)");
            }
            long jM4218getWhite0d7_KjU = Color.INSTANCE.m4218getWhite0d7_KjU();
            TextKt.m2714Text4IGK_g("Buscar…", (Modifier) null, Color.m4179copywmQWz5c(jM4218getWhite0d7_KjU, (14 & 1) != 0 ? Color.m4183getAlphaimpl(jM4218getWhite0d7_KjU) : 0.7f, (14 & 2) != 0 ? Color.m4187getRedimpl(jM4218getWhite0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m4186getGreenimpl(jM4218getWhite0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m4184getBlueimpl(jM4218getWhite0d7_KjU) : 0.0f), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 390, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f126lambda2 = ComposableLambdaKt.composableLambdaInstance(1759325237, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.ComposableSingletons$PantryScreenKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C120@5607L44:PantryScreen.kt#mq3b12");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1759325237, $changed, -1, "com.easycompra.app.ui.pantry.ComposableSingletons$PantryScreenKt.lambda-2.<anonymous> (PantryScreen.kt:120)");
            }
            IconKt.m2171Iconww6aTOc(CloseKt.getClose(Icons.INSTANCE.getDefault()), "Cerrar búsqueda", (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f127lambda3 = ComposableLambdaKt.composableLambdaInstance(-1296137803, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.ComposableSingletons$PantryScreenKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C132@6227L36:PantryScreen.kt#mq3b12");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1296137803, $changed, -1, "com.easycompra.app.ui.pantry.ComposableSingletons$PantryScreenKt.lambda-3.<anonymous> (PantryScreen.kt:132)");
            }
            IconKt.m2171Iconww6aTOc(SearchKt.getSearch(Icons.INSTANCE.getDefault()), "Buscar", (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-4, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f128lambda4 = ComposableLambdaKt.composableLambdaInstance(2049665516, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.ComposableSingletons$PantryScreenKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C141@6530L42:PantryScreen.kt#mq3b12");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2049665516, $changed, -1, "com.easycompra.app.ui.pantry.ComposableSingletons$PantryScreenKt.lambda-4.<anonymous> (PantryScreen.kt:141)");
            }
            IconKt.m2171Iconww6aTOc(AddKt.getAdd(Icons.INSTANCE.getDefault()), "Añadir producto", (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-5, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f129lambda5 = ComposableLambdaKt.composableLambdaInstance(388315410, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.ComposableSingletons$PantryScreenKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C215@10451L28:PantryScreen.kt#mq3b12");
            if (($changed & 17) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(388315410, $changed, -1, "com.easycompra.app.ui.pantry.ComposableSingletons$PantryScreenKt.lambda-5.<anonymous> (PantryScreen.kt:215)");
            }
            SpacerKt.Spacer(SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(80)), $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-6, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f130lambda6 = ComposableLambdaKt.composableLambdaInstance(-1075961394, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.ComposableSingletons$PantryScreenKt$lambda-6$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C352@15219L69:PantryScreen.kt#mq3b12");
            if (($changed & 3) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1075961394, $changed, -1, "com.easycompra.app.ui.pantry.ComposableSingletons$PantryScreenKt.lambda-6.<anonymous> (PantryScreen.kt:352)");
                }
                IconKt.m2171Iconww6aTOc(RemoveKt.getRemove(Icons.INSTANCE.getDefault()), "Quitar", SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(14)), 0L, $composer, 432, 8);
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
    public static Function2<Composer, Integer, Unit> f131lambda7 = ComposableLambdaKt.composableLambdaInstance(280594935, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.ComposableSingletons$PantryScreenKt$lambda-7$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C365@15810L66:PantryScreen.kt#mq3b12");
            if (($changed & 3) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(280594935, $changed, -1, "com.easycompra.app.ui.pantry.ComposableSingletons$PantryScreenKt.lambda-7.<anonymous> (PantryScreen.kt:365)");
                }
                IconKt.m2171Iconww6aTOc(AddKt.getAdd(Icons.INSTANCE.getDefault()), "Añadir", SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(14)), 0L, $composer, 432, 8);
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
    public static Function2<Composer, Integer, Unit> f132lambda8 = ComposableLambdaKt.composableLambdaInstance(-1875640795, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.ComposableSingletons$PantryScreenKt$lambda-8$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C371@16065L95:PantryScreen.kt#mq3b12");
            if (($changed & 3) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1875640795, $changed, -1, "com.easycompra.app.ui.pantry.ComposableSingletons$PantryScreenKt.lambda-8.<anonymous> (PantryScreen.kt:371)");
                }
                IconKt.m2171Iconww6aTOc(DeleteKt.getDelete(Icons.INSTANCE.getDefault()), "Eliminar", SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(18)), Color.INSTANCE.m4213getLightGray0d7_KjU(), $composer, 3504, 0);
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
    public static Function2<Composer, Integer, Unit> f133lambda9 = ComposableLambdaKt.composableLambdaInstance(-2059952851, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.ComposableSingletons$PantryScreenKt$lambda-9$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C375@16406L11,375@16367L57:PantryScreen.kt#mq3b12");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2059952851, $changed, -1, "com.easycompra.app.ui.pantry.ComposableSingletons$PantryScreenKt.lambda-9.<anonymous> (PantryScreen.kt:375)");
            }
            TextKt.m2714Text4IGK_g("Eliminar", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).m1914getError0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-10, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f125lambda10 = ComposableLambdaKt.composableLambdaInstance(-90272208, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.ComposableSingletons$PantryScreenKt$lambda-10$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C377@16558L11,377@16504L72:PantryScreen.kt#mq3b12");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-90272208, $changed, -1, "com.easycompra.app.ui.pantry.ComposableSingletons$PantryScreenKt.lambda-10.<anonymous> (PantryScreen.kt:377)");
            }
            IconKt.m2171Iconww6aTOc(DeleteKt.getDelete(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).m1914getError0d7_KjU(), $composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7121getLambda1$app_debug() {
        return f124lambda1;
    }

    /* JADX INFO: renamed from: getLambda-10$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7122getLambda10$app_debug() {
        return f125lambda10;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7123getLambda2$app_debug() {
        return f126lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7124getLambda3$app_debug() {
        return f127lambda3;
    }

    /* JADX INFO: renamed from: getLambda-4$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7125getLambda4$app_debug() {
        return f128lambda4;
    }

    /* JADX INFO: renamed from: getLambda-5$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7126getLambda5$app_debug() {
        return f129lambda5;
    }

    /* JADX INFO: renamed from: getLambda-6$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7127getLambda6$app_debug() {
        return f130lambda6;
    }

    /* JADX INFO: renamed from: getLambda-7$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7128getLambda7$app_debug() {
        return f131lambda7;
    }

    /* JADX INFO: renamed from: getLambda-8$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7129getLambda8$app_debug() {
        return f132lambda8;
    }

    /* JADX INFO: renamed from: getLambda-9$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7130getLambda9$app_debug() {
        return f133lambda9;
    }
}
