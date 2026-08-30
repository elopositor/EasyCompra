package com.easycompra.app.ui.theme;

import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Theme.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0002\u001a\u00020\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u0006H\u0007¢\u0006\u0002\u0010\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"AppColorScheme", "Landroidx/compose/material3/ColorScheme;", "EasyCompraTheme", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "app_debug"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ThemeKt {
    private static final ColorScheme AppColorScheme = ColorSchemeKt.m1957lightColorSchemeCXl9yA$default(androidx.compose.ui.graphics.ColorKt.Color(4278225275L), Color.INSTANCE.m4218getWhite0d7_KjU(), androidx.compose.ui.graphics.ColorKt.Color(4289912795L), 0, 0, androidx.compose.ui.graphics.ColorKt.Color(4280723098L), 0, 0, 0, 0, 0, 0, 0, androidx.compose.ui.graphics.ColorKt.Color(4294309365L), 0, Color.INSTANCE.m4218getWhite0d7_KjU(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -41000, 15, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit EasyCompraTheme$lambda$0(Function2 function2, int i, Composer composer, int i2) {
        EasyCompraTheme(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void EasyCompraTheme(final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(807258476);
        ComposerKt.sourceInformation($composer2, "C(EasyCompraTheme)18@545L62:Theme.kt#hnttct");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(content) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 3) != 2 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(807258476, $dirty2, -1, "com.easycompra.app.ui.theme.EasyCompraTheme (Theme.kt:17)");
            }
            MaterialThemeKt.MaterialTheme(AppColorScheme, null, null, content, $composer2, (($dirty2 << 9) & 7168) | 6, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.theme.ThemeKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ThemeKt.EasyCompraTheme$lambda$0(content, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
