package com.easycompra.app.ui.recipes;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.AddKt;
import androidx.compose.material.icons.filled.CloseKt;
import androidx.compose.material.icons.filled.SearchKt;
import androidx.compose.material3.IconKt;
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: RecipeListScreen.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$RecipeListScreenKt {
    public static final ComposableSingletons$RecipeListScreenKt INSTANCE = new ComposableSingletons$RecipeListScreenKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f193lambda1 = ComposableLambdaKt.composableLambdaInstance(-409036993, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.ComposableSingletons$RecipeListScreenKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C91@3832L54:RecipeListScreen.kt#y43rd3");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-409036993, $changed, -1, "com.easycompra.app.ui.recipes.ComposableSingletons$RecipeListScreenKt.lambda-1.<anonymous> (RecipeListScreen.kt:91)");
            }
            long jM4218getWhite0d7_KjU = Color.INSTANCE.m4218getWhite0d7_KjU();
            TextKt.m2714Text4IGK_g("Buscar receta…", (Modifier) null, Color.m4179copywmQWz5c(jM4218getWhite0d7_KjU, (14 & 1) != 0 ? Color.m4183getAlphaimpl(jM4218getWhite0d7_KjU) : 0.7f, (14 & 2) != 0 ? Color.m4187getRedimpl(jM4218getWhite0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m4186getGreenimpl(jM4218getWhite0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m4184getBlueimpl(jM4218getWhite0d7_KjU) : 0.0f), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 390, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f194lambda2 = ComposableLambdaKt.composableLambdaInstance(1452845211, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.ComposableSingletons$RecipeListScreenKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C98@4344L35:RecipeListScreen.kt#y43rd3");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1452845211, $changed, -1, "com.easycompra.app.ui.recipes.ComposableSingletons$RecipeListScreenKt.lambda-2.<anonymous> (RecipeListScreen.kt:98)");
            }
            IconKt.m2171Iconww6aTOc(CloseKt.getClose(Icons.INSTANCE.getDefault()), "Cerrar", (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f195lambda3 = ComposableLambdaKt.composableLambdaInstance(1246392050, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.ComposableSingletons$RecipeListScreenKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C102@4547L36:RecipeListScreen.kt#y43rd3");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1246392050, $changed, -1, "com.easycompra.app.ui.recipes.ComposableSingletons$RecipeListScreenKt.lambda-3.<anonymous> (RecipeListScreen.kt:102)");
            }
            IconKt.m2171Iconww6aTOc(SearchKt.getSearch(Icons.INSTANCE.getDefault()), "Buscar", (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-4, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f196lambda4 = ComposableLambdaKt.composableLambdaInstance(-504523457, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.ComposableSingletons$RecipeListScreenKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C110@4797L39:RecipeListScreen.kt#y43rd3");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-504523457, $changed, -1, "com.easycompra.app.ui.recipes.ComposableSingletons$RecipeListScreenKt.lambda-4.<anonymous> (RecipeListScreen.kt:110)");
            }
            IconKt.m2171Iconww6aTOc(AddKt.getAdd(Icons.INSTANCE.getDefault()), "Nueva receta", (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7213getLambda1$app_debug() {
        return f193lambda1;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7214getLambda2$app_debug() {
        return f194lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7215getLambda3$app_debug() {
        return f195lambda3;
    }

    /* JADX INFO: renamed from: getLambda-4$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7216getLambda4$app_debug() {
        return f196lambda4;
    }
}
