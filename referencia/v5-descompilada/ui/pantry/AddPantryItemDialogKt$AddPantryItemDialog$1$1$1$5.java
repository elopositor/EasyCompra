package com.easycompra.app.ui.pantry;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.ExposedDropdownMenuBoxScope;
import androidx.compose.material3.ExposedDropdownMenuDefaults;
import androidx.compose.material3.MenuAnchorType;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.core.view.PointerIconCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AddPantryItemDialog.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class AddPantryItemDialogKt$AddPantryItemDialog$1$1$1$5 implements Function3<ExposedDropdownMenuBoxScope, Composer, Integer, Unit> {
    final /* synthetic */ MutableState<String> $selectedSubcategory$delegate;
    final /* synthetic */ MutableState<Boolean> $subcatExpanded$delegate;
    final /* synthetic */ MutableState<List<String>> $subcategories$delegate;

    AddPantryItemDialogKt$AddPantryItemDialog$1$1$1$5(MutableState<String> mutableState, MutableState<Boolean> mutableState2, MutableState<List<String>> mutableState3) {
        this.$selectedSubcategory$delegate = mutableState;
        this.$subcatExpanded$delegate = mutableState2;
        this.$subcategories$delegate = mutableState3;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope, Composer composer, Integer num) {
        invoke(exposedDropdownMenuBoxScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ExposedDropdownMenuBoxScope ExposedDropdownMenuBox, Composer $composer, int $changed) {
        Object value$iv;
        Object value$iv2;
        Intrinsics.checkNotNullParameter(ExposedDropdownMenuBox, "$this$ExposedDropdownMenuBox");
        ComposerKt.sourceInformation($composer, "C137@6181L2,140@6322L60,135@6069L441,143@6597L26,143@6625L427,143@6531L521:AddPantryItemDialog.kt#mq3b12");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer.changed(ExposedDropdownMenuBox) : $composer.changedInstance(ExposedDropdownMenuBox) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 19) != 18 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(119830886, $dirty2, -1, "com.easycompra.app.ui.pantry.AddPantryItemDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AddPantryItemDialog.kt:135)");
            }
            String strAddPantryItemDialog$lambda$20 = AddPantryItemDialogKt.AddPantryItemDialog$lambda$20(this.$selectedSubcategory$delegate);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(ExposedDropdownMenuBoxScope.m2100menuAnchorfsE2BvY$default(ExposedDropdownMenuBox, Modifier.INSTANCE, MenuAnchorType.INSTANCE.m2246getPrimaryNotEditableMg6Rgbw(), false, 2, null), 0.0f, 1, null);
            $composer.startReplaceGroup(431451924);
            ComposerKt.sourceInformation($composer, "CC(remember):AddPantryItemDialog.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function1() { // from class: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$AddPantryItemDialog$1$1$1$5$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AddPantryItemDialogKt$AddPantryItemDialog$1$1$1$5.invoke$lambda$1$lambda$0((String) obj);
                    }
                };
                $composer.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer.endReplaceGroup();
            Function2<Composer, Integer, Unit> function2M7115getLambda4$app_debug = ComposableSingletons$AddPantryItemDialogKt.INSTANCE.m7115getLambda4$app_debug();
            final MutableState<Boolean> mutableState = this.$subcatExpanded$delegate;
            OutlinedTextFieldKt.OutlinedTextField(strAddPantryItemDialog$lambda$20, (Function1<? super String, Unit>) value$iv, modifierFillMaxWidth$default, false, true, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) function2M7115getLambda4$app_debug, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-749026083, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$AddPantryItemDialog$1$1$1$5.2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer2, int $changed2) {
                    ComposerKt.sourceInformation($composer2, "C140@6352L28:AddPantryItemDialog.kt#mq3b12");
                    if (($changed2 & 3) == 2 && $composer2.getSkipping()) {
                        $composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-749026083, $changed2, -1, "com.easycompra.app.ui.pantry.AddPantryItemDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AddPantryItemDialog.kt:140)");
                    }
                    ExposedDropdownMenuDefaults.INSTANCE.TrailingIcon(AddPantryItemDialogKt.AddPantryItemDialog$lambda$29(mutableState), null, $composer2, ExposedDropdownMenuDefaults.$stable << 6, 2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer, 806903856, 0, 0, 8388008);
            boolean zAddPantryItemDialog$lambda$29 = AddPantryItemDialogKt.AddPantryItemDialog$lambda$29(this.$subcatExpanded$delegate);
            $composer.startReplaceGroup(431465260);
            ComposerKt.sourceInformation($composer, "CC(remember):AddPantryItemDialog.kt#9igjgp");
            final MutableState<Boolean> mutableState2 = this.$subcatExpanded$delegate;
            Object it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new Function0() { // from class: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$AddPantryItemDialog$1$1$1$5$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AddPantryItemDialogKt$AddPantryItemDialog$1$1$1$5.invoke$lambda$3$lambda$2(mutableState2);
                    }
                };
                $composer.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            $composer.endReplaceGroup();
            ExposedDropdownMenuBox.m2102ExposedDropdownMenuvNxi1II(zAddPantryItemDialog$lambda$29, (Function0) value$iv2, null, null, false, null, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(2024689188, true, new AnonymousClass4(this.$subcategories$delegate, this.$selectedSubcategory$delegate, this.$subcatExpanded$delegate), $composer, 54), $composer, 48, (ExposedDropdownMenuBoxScope.$stable << 3) | 6 | (($dirty2 << 3) & 112), PointerIconCompat.TYPE_GRAB);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$AddPantryItemDialog$1$1$1$5$4, reason: invalid class name */
    /* JADX INFO: compiled from: AddPantryItemDialog.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass4 implements Function3<ColumnScope, Composer, Integer, Unit> {
        final /* synthetic */ MutableState<String> $selectedSubcategory$delegate;
        final /* synthetic */ MutableState<Boolean> $subcatExpanded$delegate;
        final /* synthetic */ MutableState<List<String>> $subcategories$delegate;

        AnonymousClass4(MutableState<List<String>> mutableState, MutableState<String> mutableState2, MutableState<Boolean> mutableState3) {
            this.$subcategories$delegate = mutableState;
            this.$selectedSubcategory$delegate = mutableState2;
            this.$subcatExpanded$delegate = mutableState3;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
            invoke(columnScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(ColumnScope ExposedDropdownMenu, Composer $composer, int $changed) {
            Object value$iv;
            Intrinsics.checkNotNullParameter(ExposedDropdownMenu, "$this$ExposedDropdownMenu");
            ComposerKt.sourceInformation($composer, "C*146@6767L13,147@6824L53,145@6710L294:AddPantryItemDialog.kt#mq3b12");
            if (($changed & 17) != 16 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2024689188, $changed, -1, "com.easycompra.app.ui.pantry.AddPantryItemDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AddPantryItemDialog.kt:144)");
                }
                Iterable $this$forEach$iv = AddPantryItemDialogKt.AddPantryItemDialog$lambda$17(this.$subcategories$delegate);
                final MutableState<String> mutableState = this.$selectedSubcategory$delegate;
                final MutableState<Boolean> mutableState2 = this.$subcatExpanded$delegate;
                for (Object element$iv : $this$forEach$iv) {
                    final String sub = (String) element$iv;
                    ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(191403172, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$AddPantryItemDialog$1$1$1$5$4$1$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer2, int $changed2) {
                            ComposerKt.sourceInformation($composer2, "C146@6769L9:AddPantryItemDialog.kt#mq3b12");
                            if (($changed2 & 3) == 2 && $composer2.getSkipping()) {
                                $composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(191403172, $changed2, -1, "com.easycompra.app.ui.pantry.AddPantryItemDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AddPantryItemDialog.kt:146)");
                            }
                            TextKt.m2714Text4IGK_g(sub, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 0, 0, 131070);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer, 54);
                    $composer.startReplaceGroup(714639141);
                    ComposerKt.sourceInformation($composer, "CC(remember):AddPantryItemDialog.kt#9igjgp");
                    boolean invalid$iv = $composer.changed(sub);
                    Object it$iv = $composer.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = new Function0() { // from class: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$AddPantryItemDialog$1$1$1$5$4$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return AddPantryItemDialogKt$AddPantryItemDialog$1$1$1$5.AnonymousClass4.invoke$lambda$2$lambda$1$lambda$0(sub, mutableState, mutableState2);
                            }
                        };
                        $composer.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer.endReplaceGroup();
                    AndroidMenu_androidKt.DropdownMenuItem(composableLambdaRememberComposableLambda, (Function0) value$iv, null, null, null, false, null, ExposedDropdownMenuDefaults.INSTANCE.getItemContentPadding(), null, $composer, 6, 380);
                    mutableState = mutableState;
                    mutableState2 = mutableState2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$2$lambda$1$lambda$0(String $sub, MutableState $selectedSubcategory$delegate, MutableState $subcatExpanded$delegate) {
            $selectedSubcategory$delegate.setValue($sub);
            AddPantryItemDialogKt.AddPantryItemDialog$lambda$30($subcatExpanded$delegate, false);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2(MutableState $subcatExpanded$delegate) {
        AddPantryItemDialogKt.AddPantryItemDialog$lambda$30($subcatExpanded$delegate, false);
        return Unit.INSTANCE;
    }
}
