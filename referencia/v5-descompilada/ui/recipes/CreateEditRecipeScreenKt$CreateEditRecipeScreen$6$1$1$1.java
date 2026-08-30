package com.easycompra.app.ui.recipes;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateEditRecipeScreen.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$1$1$1 implements Function3<LazyItemScope, Composer, Integer, Unit> {
    final /* synthetic */ MutableState<String> $name$delegate;
    final /* synthetic */ MutableState<Boolean> $nameError$delegate;

    CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$1$1$1(MutableState<String> mutableState, MutableState<Boolean> mutableState2) {
        this.$name$delegate = mutableState;
        this.$nameError$delegate = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
        invoke(lazyItemScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
        Object value$iv;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C264@12018L32,262@11929L440:CreateEditRecipeScreen.kt#y43rd3");
        if (($changed & 17) != 16 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1562082277, $changed, -1, "com.easycompra.app.ui.recipes.CreateEditRecipeScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CreateEditRecipeScreen.kt:262)");
            }
            String strCreateEditRecipeScreen$lambda$3 = CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$3(this.$name$delegate);
            boolean zCreateEditRecipeScreen$lambda$32 = CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$32(this.$nameError$delegate);
            Function2<Composer, Integer, Unit> function2M7196getLambda9$app_debug = CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$32(this.$nameError$delegate) ? ComposableSingletons$CreateEditRecipeScreenKt.INSTANCE.m7196getLambda9$app_debug() : null;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            $composer.startReplaceGroup(-888717583);
            ComposerKt.sourceInformation($composer, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
            boolean invalid$iv = $composer.changed(this.$name$delegate) | $composer.changed(this.$nameError$delegate);
            final MutableState<String> mutableState = this.$name$delegate;
            final MutableState<Boolean> mutableState2 = this.$nameError$delegate;
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function1() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$1$1$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$1$1$1.invoke$lambda$1$lambda$0(mutableState, mutableState2, (String) obj);
                    }
                };
                $composer.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer.endReplaceGroup();
            OutlinedTextFieldKt.OutlinedTextField(strCreateEditRecipeScreen$lambda$3, (Function1<? super String, Unit>) value$iv, modifierFillMaxWidth$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$CreateEditRecipeScreenKt.INSTANCE.m7176getLambda10$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function2M7196getLambda9$app_debug, zCreateEditRecipeScreen$lambda$32, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer, 1573248, 12582912, 0, 8245176);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(MutableState $name$delegate, MutableState $nameError$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $name$delegate.setValue(it);
        CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$33($nameError$delegate, false);
        return Unit.INSTANCE;
    }
}
