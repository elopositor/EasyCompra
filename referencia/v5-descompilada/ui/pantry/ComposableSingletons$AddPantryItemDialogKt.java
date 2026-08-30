package com.easycompra.app.ui.pantry;

import androidx.compose.foundation.layout.RowScope;
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

/* JADX INFO: compiled from: AddPantryItemDialog.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$AddPantryItemDialogKt {
    public static final ComposableSingletons$AddPantryItemDialogKt INSTANCE = new ComposableSingletons$AddPantryItemDialogKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f113lambda1 = ComposableLambdaKt.composableLambdaInstance(179350493, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.ComposableSingletons$AddPantryItemDialogKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C94@4038L32:AddPantryItemDialog.kt#mq3b12");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(179350493, $changed, -1, "com.easycompra.app.ui.pantry.ComposableSingletons$AddPantryItemDialogKt.lambda-1.<anonymous> (AddPantryItemDialog.kt:94)");
            }
            TextKt.m2714Text4IGK_g("El nombre es obligatorio", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f116lambda2 = ComposableLambdaKt.composableLambdaInstance(1386723827, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.ComposableSingletons$AddPantryItemDialogKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C91@3883L16:AddPantryItemDialog.kt#mq3b12");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1386723827, $changed, -1, "com.easycompra.app.ui.pantry.ComposableSingletons$AddPantryItemDialogKt.lambda-2.<anonymous> (AddPantryItemDialog.kt:91)");
            }
            TextKt.m2714Text4IGK_g("Nombre *", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f117lambda3 = ComposableLambdaKt.composableLambdaInstance(903235209, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.ComposableSingletons$AddPantryItemDialogKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C109@4734L19:AddPantryItemDialog.kt#mq3b12");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(903235209, $changed, -1, "com.easycompra.app.ui.pantry.ComposableSingletons$AddPantryItemDialogKt.lambda-3.<anonymous> (AddPantryItemDialog.kt:109)");
            }
            TextKt.m2714Text4IGK_g("Ubicación *", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-4, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f118lambda4 = ComposableLambdaKt.composableLambdaInstance(-902156928, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.ComposableSingletons$AddPantryItemDialogKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C139@6260L19:AddPantryItemDialog.kt#mq3b12");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-902156928, $changed, -1, "com.easycompra.app.ui.pantry.ComposableSingletons$AddPantryItemDialogKt.lambda-4.<anonymous> (AddPantryItemDialog.kt:139)");
            }
            TextKt.m2714Text4IGK_g("Categoría *", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-5, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f119lambda5 = ComposableLambdaKt.composableLambdaInstance(-126062998, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.ComposableSingletons$AddPantryItemDialogKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C157@7236L30:AddPantryItemDialog.kt#mq3b12");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-126062998, $changed, -1, "com.easycompra.app.ui.pantry.ComposableSingletons$AddPantryItemDialogKt.lambda-5.<anonymous> (AddPantryItemDialog.kt:157)");
            }
            TextKt.m2714Text4IGK_g("Descripción (opcional)", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-6, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f120lambda6 = ComposableLambdaKt.composableLambdaInstance(-1175434999, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.ComposableSingletons$AddPantryItemDialogKt$lambda-6$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C158@7306L40:AddPantryItemDialog.kt#mq3b12");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1175434999, $changed, -1, "com.easycompra.app.ui.pantry.ComposableSingletons$AddPantryItemDialogKt.lambda-6.<anonymous> (AddPantryItemDialog.kt:158)");
            }
            TextKt.m2714Text4IGK_g("ej: abierto, cerrado, congelado…", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-7, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f121lambda7 = ComposableLambdaKt.composableLambdaInstance(-1350423593, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.ComposableSingletons$AddPantryItemDialogKt$lambda-7$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C173@7958L18:AddPantryItemDialog.kt#mq3b12");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1350423593, $changed, -1, "com.easycompra.app.ui.pantry.ComposableSingletons$AddPantryItemDialogKt.lambda-7.<anonymous> (AddPantryItemDialog.kt:173)");
            }
            TextKt.m2714Text4IGK_g("Cantidad *", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-8, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f122lambda8 = ComposableLambdaKt.composableLambdaInstance(1072681974, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.ComposableSingletons$AddPantryItemDialogKt$lambda-8$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C174@8020L15:AddPantryItemDialog.kt#mq3b12");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1072681974, $changed, -1, "com.easycompra.app.ui.pantry.ComposableSingletons$AddPantryItemDialogKt.lambda-8.<anonymous> (AddPantryItemDialog.kt:174)");
            }
            TextKt.m2714Text4IGK_g("ej: 1/2", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-9, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f123lambda9 = ComposableLambdaKt.composableLambdaInstance(-726785555, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.ComposableSingletons$AddPantryItemDialogKt$lambda-9$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C189@8718L14:AddPantryItemDialog.kt#mq3b12");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-726785555, $changed, -1, "com.easycompra.app.ui.pantry.ComposableSingletons$AddPantryItemDialogKt.lambda-9.<anonymous> (AddPantryItemDialog.kt:189)");
            }
            TextKt.m2714Text4IGK_g("Unidad", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-10, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f114lambda10 = ComposableLambdaKt.composableLambdaInstance(-60459225, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.ComposableSingletons$AddPantryItemDialogKt$lambda-10$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope OutlinedButton, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
            ComposerKt.sourceInformation($composer, "C230@10823L16:AddPantryItemDialog.kt#mq3b12");
            if (($changed & 17) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-60459225, $changed, -1, "com.easycompra.app.ui.pantry.ComposableSingletons$AddPantryItemDialogKt.lambda-10.<anonymous> (AddPantryItemDialog.kt:230)");
            }
            TextKt.m2714Text4IGK_g("Cancelar", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda-11, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f115lambda11 = ComposableLambdaKt.composableLambdaInstance(64336933, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.ComposableSingletons$AddPantryItemDialogKt$lambda-11$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            ComposerKt.sourceInformation($composer, "C240@11361L15:AddPantryItemDialog.kt#mq3b12");
            if (($changed & 17) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(64336933, $changed, -1, "com.easycompra.app.ui.pantry.ComposableSingletons$AddPantryItemDialogKt.lambda-11.<anonymous> (AddPantryItemDialog.kt:240)");
            }
            TextKt.m2714Text4IGK_g("Guardar", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7110getLambda1$app_debug() {
        return f113lambda1;
    }

    /* JADX INFO: renamed from: getLambda-10$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7111getLambda10$app_debug() {
        return f114lambda10;
    }

    /* JADX INFO: renamed from: getLambda-11$app_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m7112getLambda11$app_debug() {
        return f115lambda11;
    }

    /* JADX INFO: renamed from: getLambda-2$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7113getLambda2$app_debug() {
        return f116lambda2;
    }

    /* JADX INFO: renamed from: getLambda-3$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7114getLambda3$app_debug() {
        return f117lambda3;
    }

    /* JADX INFO: renamed from: getLambda-4$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7115getLambda4$app_debug() {
        return f118lambda4;
    }

    /* JADX INFO: renamed from: getLambda-5$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7116getLambda5$app_debug() {
        return f119lambda5;
    }

    /* JADX INFO: renamed from: getLambda-6$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7117getLambda6$app_debug() {
        return f120lambda6;
    }

    /* JADX INFO: renamed from: getLambda-7$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7118getLambda7$app_debug() {
        return f121lambda7;
    }

    /* JADX INFO: renamed from: getLambda-8$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7119getLambda8$app_debug() {
        return f122lambda8;
    }

    /* JADX INFO: renamed from: getLambda-9$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7120getLambda9$app_debug() {
        return f123lambda9;
    }
}
