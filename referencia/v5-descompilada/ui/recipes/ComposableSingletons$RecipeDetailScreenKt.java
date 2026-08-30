package com.easycompra.app.ui.recipes;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.filled.ArrowBackKt;
import androidx.compose.material.icons.filled.DeleteKt;
import androidx.compose.material.icons.filled.EditKt;
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
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecipeDetailScreen.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$RecipeDetailScreenKt {
    public static final ComposableSingletons$RecipeDetailScreenKt INSTANCE = new ComposableSingletons$RecipeDetailScreenKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f177lambda1 = ComposableLambdaKt.composableLambdaInstance(362796434, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.ComposableSingletons$RecipeDetailScreenKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation($composer, "C116@5037L35:RecipeDetailScreen.kt#y43rd3");
            if (($changed & 17) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(362796434, $changed, -1, "com.easycompra.app.ui.recipes.ComposableSingletons$RecipeDetailScreenKt.lambda-1.<anonymous> (RecipeDetailScreen.kt:116)");
            }
            TextKt.m2714Text4IGK_g("Eliminar", (Modifier) null, Color.INSTANCE.m4215getRed0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 390, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f185lambda2 = ComposableLambdaKt.composableLambdaInstance(1011389204, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.ComposableSingletons$RecipeDetailScreenKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation($composer, "C119@5214L16:RecipeDetailScreen.kt#y43rd3");
            if (($changed & 17) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1011389204, $changed, -1, "com.easycompra.app.ui.recipes.ComposableSingletons$RecipeDetailScreenKt.lambda-2.<anonymous> (RecipeDetailScreen.kt:119)");
            }
            TextKt.m2714Text4IGK_g("Cancelar", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f186lambda3 = ComposableLambdaKt.composableLambdaInstance(-5359271, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.ComposableSingletons$RecipeDetailScreenKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C109@4664L23:RecipeDetailScreen.kt#y43rd3");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-5359271, $changed, -1, "com.easycompra.app.ui.recipes.ComposableSingletons$RecipeDetailScreenKt.lambda-3.<anonymous> (RecipeDetailScreen.kt:109)");
            }
            TextKt.m2714Text4IGK_g("Eliminar receta", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-4, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f187lambda4 = ComposableLambdaKt.composableLambdaInstance(-262763640, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.ComposableSingletons$RecipeDetailScreenKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C:RecipeDetailScreen.kt#y43rd3");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-262763640, $changed, -1, "com.easycompra.app.ui.recipes.ComposableSingletons$RecipeDetailScreenKt.lambda-4.<anonymous> (RecipeDetailScreen.kt:127)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-5, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f188lambda5 = ComposableLambdaKt.composableLambdaInstance(-329194841, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.ComposableSingletons$RecipeDetailScreenKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C130@5538L71:RecipeDetailScreen.kt#y43rd3");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-329194841, $changed, -1, "com.easycompra.app.ui.recipes.ComposableSingletons$RecipeDetailScreenKt.lambda-5.<anonymous> (RecipeDetailScreen.kt:130)");
            }
            IconKt.m2171Iconww6aTOc(ArrowBackKt.getArrowBack(Icons.AutoMirrored.Filled.INSTANCE), "Volver", (Modifier) null, Color.INSTANCE.m4218getWhite0d7_KjU(), $composer, 3120, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-6, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f189lambda6 = ComposableLambdaKt.composableLambdaInstance(-991759137, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.ComposableSingletons$RecipeDetailScreenKt$lambda-6$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C142@6265L54:RecipeDetailScreen.kt#y43rd3");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-991759137, $changed, -1, "com.easycompra.app.ui.recipes.ComposableSingletons$RecipeDetailScreenKt.lambda-6.<anonymous> (RecipeDetailScreen.kt:142)");
            }
            IconKt.m2171Iconww6aTOc(EditKt.getEdit(Icons.INSTANCE.getDefault()), "Editar", (Modifier) null, Color.INSTANCE.m4218getWhite0d7_KjU(), $composer, 3120, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-7, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f190lambda7 = ComposableLambdaKt.composableLambdaInstance(1923422846, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.ComposableSingletons$RecipeDetailScreenKt$lambda-7$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C145@6463L58:RecipeDetailScreen.kt#y43rd3");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1923422846, $changed, -1, "com.easycompra.app.ui.recipes.ComposableSingletons$RecipeDetailScreenKt.lambda-7.<anonymous> (RecipeDetailScreen.kt:145)");
            }
            IconKt.m2171Iconww6aTOc(DeleteKt.getDelete(Icons.INSTANCE.getDefault()), "Eliminar", (Modifier) null, Color.INSTANCE.m4218getWhite0d7_KjU(), $composer, 3120, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-8, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f191lambda8 = ComposableLambdaKt.composableLambdaInstance(506372244, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.ComposableSingletons$RecipeDetailScreenKt$lambda-8$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            ComposerKt.sourceInformation($composer, "C203@9447L79:RecipeDetailScreen.kt#y43rd3");
            if (($changed & 17) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(506372244, $changed, -1, "com.easycompra.app.ui.recipes.ComposableSingletons$RecipeDetailScreenKt.lambda-8.<anonymous> (RecipeDetailScreen.kt:203)");
            }
            TextKt.m2714Text4IGK_g("🍳  QUIERO COCINAR ESTA", (Modifier) null, 0L, TextUnitKt.getSp(16), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 199686, 0, 131030);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-9, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f192lambda9 = ComposableLambdaKt.composableLambdaInstance(-908296025, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.ComposableSingletons$RecipeDetailScreenKt$lambda-9$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            ComposerKt.sourceInformation($composer, "C323@15639L30:RecipeDetailScreen.kt#y43rd3");
            if (($changed & 17) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-908296025, $changed, -1, "com.easycompra.app.ui.recipes.ComposableSingletons$RecipeDetailScreenKt.lambda-9.<anonymous> (RecipeDetailScreen.kt:323)");
            }
            SpacerKt.Spacer(SizeKt.m712height3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(32)), $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-10, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f178lambda10 = ComposableLambdaKt.composableLambdaInstance(1378332467, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.ComposableSingletons$RecipeDetailScreenKt$lambda-10$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            ComposerKt.sourceInformation($composer, "C382@17603L24:RecipeDetailScreen.kt#y43rd3");
            if (($changed & 17) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1378332467, $changed, -1, "com.easycompra.app.ui.recipes.ComposableSingletons$RecipeDetailScreenKt.lambda-10.<anonymous> (RecipeDetailScreen.kt:382)");
            }
            TextKt.m2714Text4IGK_g("Ver ingredientes", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-11, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f179lambda11 = ComposableLambdaKt.composableLambdaInstance(-354539900, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.ComposableSingletons$RecipeDetailScreenKt$lambda-11$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation($composer, "C385@17713L16:RecipeDetailScreen.kt#y43rd3");
            if (($changed & 17) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-354539900, $changed, -1, "com.easycompra.app.ui.recipes.ComposableSingletons$RecipeDetailScreenKt.lambda-11.<anonymous> (RecipeDetailScreen.kt:385)");
            }
            TextKt.m2714Text4IGK_g("Cancelar", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-12, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f180lambda12 = ComposableLambdaKt.composableLambdaInstance(-1605125729, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.ComposableSingletons$RecipeDetailScreenKt$lambda-12$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C359@16566L31:RecipeDetailScreen.kt#y43rd3");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1605125729, $changed, -1, "com.easycompra.app.ui.recipes.ComposableSingletons$RecipeDetailScreenKt.lambda-12.<anonymous> (RecipeDetailScreen.kt:359)");
            }
            TextKt.m2714Text4IGK_g("¿Para cuántas personas?", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-13, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f181lambda13 = ComposableLambdaKt.composableLambdaInstance(-1500139824, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.ComposableSingletons$RecipeDetailScreenKt$lambda-13$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            ComposerKt.sourceInformation($composer, "C410@18478L17:RecipeDetailScreen.kt#y43rd3");
            if (($changed & 17) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1500139824, $changed, -1, "com.easycompra.app.ui.recipes.ComposableSingletons$RecipeDetailScreenKt.lambda-13.<anonymous> (RecipeDetailScreen.kt:410)");
            }
            TextKt.m2714Text4IGK_g("Continuar", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-14, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f182lambda14 = ComposableLambdaKt.composableLambdaInstance(931559073, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.ComposableSingletons$RecipeDetailScreenKt$lambda-14$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation($composer, "C413@18581L16:RecipeDetailScreen.kt#y43rd3");
            if (($changed & 17) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(931559073, $changed, -1, "com.easycompra.app.ui.recipes.ComposableSingletons$RecipeDetailScreenKt.lambda-14.<anonymous> (RecipeDetailScreen.kt:413)");
            }
            TextKt.m2714Text4IGK_g("Cancelar", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-15, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f183lambda15 = ComposableLambdaKt.composableLambdaInstance(192364646, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.ComposableSingletons$RecipeDetailScreenKt$lambda-15$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation($composer, "C497@22266L16:RecipeDetailScreen.kt#y43rd3");
            if (($changed & 17) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(192364646, $changed, -1, "com.easycompra.app.ui.recipes.ComposableSingletons$RecipeDetailScreenKt.lambda-15.<anonymous> (RecipeDetailScreen.kt:497)");
            }
            TextKt.m2714Text4IGK_g("Cancelar", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-16, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f184lambda16 = ComposableLambdaKt.composableLambdaInstance(127086337, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.ComposableSingletons$RecipeDetailScreenKt$lambda-16$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C463@20572L38:RecipeDetailScreen.kt#y43rd3");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(127086337, $changed, -1, "com.easycompra.app.ui.recipes.ComposableSingletons$RecipeDetailScreenKt.lambda-16.<anonymous> (RecipeDetailScreen.kt:463)");
            }
            TextKt.m2714Text4IGK_g("Resumen: qué necesitas comprar", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7197getLambda1$app_debug() {
        return f177lambda1;
    }

    /* JADX INFO: renamed from: getLambda-10$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7198getLambda10$app_debug() {
        return f178lambda10;
    }

    /* JADX INFO: renamed from: getLambda-11$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7199getLambda11$app_debug() {
        return f179lambda11;
    }

    /* JADX INFO: renamed from: getLambda-12$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7200getLambda12$app_debug() {
        return f180lambda12;
    }

    /* JADX INFO: renamed from: getLambda-13$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7201getLambda13$app_debug() {
        return f181lambda13;
    }

    /* JADX INFO: renamed from: getLambda-14$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7202getLambda14$app_debug() {
        return f182lambda14;
    }

    /* JADX INFO: renamed from: getLambda-15$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7203getLambda15$app_debug() {
        return f183lambda15;
    }

    /* JADX INFO: renamed from: getLambda-16$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7204getLambda16$app_debug() {
        return f184lambda16;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7205getLambda2$app_debug() {
        return f185lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7206getLambda3$app_debug() {
        return f186lambda3;
    }

    /* JADX INFO: renamed from: getLambda-4$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7207getLambda4$app_debug() {
        return f187lambda4;
    }

    /* JADX INFO: renamed from: getLambda-5$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7208getLambda5$app_debug() {
        return f188lambda5;
    }

    /* JADX INFO: renamed from: getLambda-6$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7209getLambda6$app_debug() {
        return f189lambda6;
    }

    /* JADX INFO: renamed from: getLambda-7$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7210getLambda7$app_debug() {
        return f190lambda7;
    }

    /* JADX INFO: renamed from: getLambda-8$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7211getLambda8$app_debug() {
        return f191lambda8;
    }

    /* JADX INFO: renamed from: getLambda-9$app_debug, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m7212getLambda9$app_debug() {
        return f192lambda9;
    }
}
