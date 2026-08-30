package com.easycompra.app.ui.pantry;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PantryScreen.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class PantryScreenKt$PantryItemRow$1$1$5$3 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ MutableState<Boolean> $menuExpanded$delegate;
    final /* synthetic */ Function0<Unit> $onDelete;

    PantryScreenKt$PantryItemRow$1$1$5$3(Function0<Unit> function0, MutableState<Boolean> mutableState) {
        this.$onDelete = function0;
        this.$menuExpanded$delegate = mutableState;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
        invoke(columnScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope DropdownMenu, Composer $composer, int $changed) {
        Object value$iv;
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        ComposerKt.sourceInformation($composer, "C379@16646L36,374@16312L396:PantryScreen.kt#mq3b12");
        if (($changed & 17) != 16 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2034627235, $changed, -1, "com.easycompra.app.ui.pantry.PantryItemRow.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PantryScreen.kt:374)");
            }
            Function2<Composer, Integer, Unit> function2M7130getLambda9$app_debug = ComposableSingletons$PantryScreenKt.INSTANCE.m7130getLambda9$app_debug();
            $composer.startReplaceGroup(-485311771);
            ComposerKt.sourceInformation($composer, "CC(remember):PantryScreen.kt#9igjgp");
            boolean invalid$iv = $composer.changed(this.$onDelete);
            final Function0<Unit> function0 = this.$onDelete;
            final MutableState<Boolean> mutableState = this.$menuExpanded$delegate;
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function0() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$PantryItemRow$1$1$5$3$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PantryScreenKt$PantryItemRow$1$1$5$3.invoke$lambda$1$lambda$0(function0, mutableState);
                    }
                };
                $composer.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer.endReplaceGroup();
            AndroidMenu_androidKt.DropdownMenuItem(function2M7130getLambda9$app_debug, (Function0) value$iv, null, ComposableSingletons$PantryScreenKt.INSTANCE.m7122getLambda10$app_debug(), null, false, null, null, null, $composer, 3078, 500);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(Function0 $onDelete, MutableState $menuExpanded$delegate) {
        PantryScreenKt.PantryItemRow$lambda$10($menuExpanded$delegate, false);
        $onDelete.invoke();
        return Unit.INSTANCE;
    }
}
