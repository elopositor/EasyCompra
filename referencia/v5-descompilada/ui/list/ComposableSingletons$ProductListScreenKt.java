package com.easycompra.app.ui.list;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CloseKt;
import androidx.compose.material.icons.filled.RefreshKt;
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

/* JADX INFO: compiled from: ProductListScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$ProductListScreenKt {
    public static final ComposableSingletons$ProductListScreenKt INSTANCE = new ComposableSingletons$ProductListScreenKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f101lambda1 = ComposableLambdaKt.composableLambdaInstance(536928901, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.list.ComposableSingletons$ProductListScreenKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C86@3827L66:ProductListScreen.kt#c0t1xm");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(536928901, $changed, -1, "com.easycompra.app.ui.list.ComposableSingletons$ProductListScreenKt.lambda-1.<anonymous> (ProductListScreen.kt:86)");
            }
            long jM4218getWhite0d7_KjU = Color.INSTANCE.m4218getWhite0d7_KjU();
            TextKt.m2714Text4IGK_g("Buscar producto...", (Modifier) null, Color.m4179copywmQWz5c(jM4218getWhite0d7_KjU, (14 & 1) != 0 ? Color.m4183getAlphaimpl(jM4218getWhite0d7_KjU) : 0.7f, (14 & 2) != 0 ? Color.m4187getRedimpl(jM4218getWhite0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m4186getGreenimpl(jM4218getWhite0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m4184getBlueimpl(jM4218getWhite0d7_KjU) : 0.0f), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 390, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f105lambda2 = ComposableLambdaKt.composableLambdaInstance(1989862881, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.list.ComposableSingletons$ProductListScreenKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C95@4427L56:ProductListScreen.kt#c0t1xm");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1989862881, $changed, -1, "com.easycompra.app.ui.list.ComposableSingletons$ProductListScreenKt.lambda-2.<anonymous> (ProductListScreen.kt:95)");
            }
            IconKt.m2171Iconww6aTOc(CloseKt.getClose(Icons.INSTANCE.getDefault()), "Cerrar", (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f106lambda3 = ComposableLambdaKt.composableLambdaInstance(348367032, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.list.ComposableSingletons$ProductListScreenKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C99@4644L63:ProductListScreen.kt#c0t1xm");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(348367032, $changed, -1, "com.easycompra.app.ui.list.ComposableSingletons$ProductListScreenKt.lambda-3.<anonymous> (ProductListScreen.kt:99)");
            }
            IconKt.m2171Iconww6aTOc(RefreshKt.getRefresh(Icons.INSTANCE.getDefault()), "Sincronizar", (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-4, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f107lambda4 = ComposableLambdaKt.composableLambdaInstance(617701473, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.list.ComposableSingletons$ProductListScreenKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C102@4834L57:ProductListScreen.kt#c0t1xm");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(617701473, $changed, -1, "com.easycompra.app.ui.list.ComposableSingletons$ProductListScreenKt.lambda-4.<anonymous> (ProductListScreen.kt:102)");
            }
            IconKt.m2171Iconww6aTOc(SearchKt.getSearch(Icons.INSTANCE.getDefault()), "Buscar", (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-5, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f108lambda5 = ComposableLambdaKt.composableLambdaInstance(38476333, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.list.ComposableSingletons$ProductListScreenKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C162@7386L13:ProductListScreen.kt#c0t1xm");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(38476333, $changed, -1, "com.easycompra.app.ui.list.ComposableSingletons$ProductListScreenKt.lambda-5.<anonymous> (ProductListScreen.kt:162)");
            }
            TextKt.m2714Text4IGK_g("Todos", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-6, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f109lambda6 = ComposableLambdaKt.composableLambdaInstance(-1778972458, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.list.ComposableSingletons$ProductListScreenKt$lambda-6$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C169@7700L17:ProductListScreen.kt#c0t1xm");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1778972458, $changed, -1, "com.easycompra.app.ui.list.ComposableSingletons$ProductListScreenKt.lambda-6.<anonymous> (ProductListScreen.kt:169)");
            }
            TextKt.m2714Text4IGK_g("Mercadona", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-7, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f110lambda7 = ComposableLambdaKt.composableLambdaInstance(911990965, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.list.ComposableSingletons$ProductListScreenKt$lambda-7$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C176@8006L11:ProductListScreen.kt#c0t1xm");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(911990965, $changed, -1, "com.easycompra.app.ui.list.ComposableSingletons$ProductListScreenKt.lambda-7.<anonymous> (ProductListScreen.kt:176)");
            }
            TextKt.m2714Text4IGK_g("Dia", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-8, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f111lambda8 = ComposableLambdaKt.composableLambdaInstance(-692012908, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.list.ComposableSingletons$ProductListScreenKt$lambda-8$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C183@8318L17:ProductListScreen.kt#c0t1xm");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-692012908, $changed, -1, "com.easycompra.app.ui.list.ComposableSingletons$ProductListScreenKt.lambda-8.<anonymous> (ProductListScreen.kt:183)");
            }
            TextKt.m2714Text4IGK_g("Carrefour", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-9, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f112lambda9 = ComposableLambdaKt.composableLambdaInstance(1998950515, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.list.ComposableSingletons$ProductListScreenKt$lambda-9$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C190@8626L12:ProductListScreen.kt#c0t1xm");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1998950515, $changed, -1, "com.easycompra.app.ui.list.ComposableSingletons$ProductListScreenKt.lambda-9.<anonymous> (ProductListScreen.kt:190)");
            }
            TextKt.m2714Text4IGK_g("Lidl", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-10, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f102lambda10 = ComposableLambdaKt.composableLambdaInstance(394946642, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.list.ComposableSingletons$ProductListScreenKt$lambda-10$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C197@8880L16:ProductListScreen.kt#c0t1xm");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(394946642, $changed, -1, "com.easycompra.app.ui.list.ComposableSingletons$ProductListScreenKt.lambda-10.<anonymous> (ProductListScreen.kt:197)");
            }
            TextKt.m2714Text4IGK_g("Sin nata", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-11, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f103lambda11 = ComposableLambdaKt.composableLambdaInstance(-1209057231, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.list.ComposableSingletons$ProductListScreenKt$lambda-11$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C204@9156L20:ProductListScreen.kt#c0t1xm");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1209057231, $changed, -1, "com.easycompra.app.ui.list.ComposableSingletons$ProductListScreenKt.lambda-11.<anonymous> (ProductListScreen.kt:204)");
            }
            TextKt.m2714Text4IGK_g("❤️ Favoritos", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-12, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f104lambda12 = ComposableLambdaKt.composableLambdaInstance(-1729871900, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.list.ComposableSingletons$ProductListScreenKt$lambda-12$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C215@9574L20:ProductListScreen.kt#c0t1xm");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1729871900, $changed, -1, "com.easycompra.app.ui.list.ComposableSingletons$ProductListScreenKt.lambda-12.<anonymous> (ProductListScreen.kt:215)");
            }
            TextKt.m2714Text4IGK_g("Nutri: Todos", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7085getLambda1$app_debug() {
        return f101lambda1;
    }

    /* JADX INFO: renamed from: getLambda-10$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7086getLambda10$app_debug() {
        return f102lambda10;
    }

    /* JADX INFO: renamed from: getLambda-11$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7087getLambda11$app_debug() {
        return f103lambda11;
    }

    /* JADX INFO: renamed from: getLambda-12$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7088getLambda12$app_debug() {
        return f104lambda12;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7089getLambda2$app_debug() {
        return f105lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7090getLambda3$app_debug() {
        return f106lambda3;
    }

    /* JADX INFO: renamed from: getLambda-4$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7091getLambda4$app_debug() {
        return f107lambda4;
    }

    /* JADX INFO: renamed from: getLambda-5$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7092getLambda5$app_debug() {
        return f108lambda5;
    }

    /* JADX INFO: renamed from: getLambda-6$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7093getLambda6$app_debug() {
        return f109lambda6;
    }

    /* JADX INFO: renamed from: getLambda-7$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7094getLambda7$app_debug() {
        return f110lambda7;
    }

    /* JADX INFO: renamed from: getLambda-8$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7095getLambda8$app_debug() {
        return f111lambda8;
    }

    /* JADX INFO: renamed from: getLambda-9$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7096getLambda9$app_debug() {
        return f112lambda9;
    }
}
