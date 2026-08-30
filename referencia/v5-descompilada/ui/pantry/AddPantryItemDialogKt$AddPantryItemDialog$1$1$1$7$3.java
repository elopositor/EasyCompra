package com.easycompra.app.ui.pantry;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
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
import com.easycompra.app.data.pantry.PantryCategories;
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
final class AddPantryItemDialogKt$AddPantryItemDialog$1$1$1$7$3 implements Function3<ExposedDropdownMenuBoxScope, Composer, Integer, Unit> {
    final /* synthetic */ MutableState<String> $selectedUnit$delegate;
    final /* synthetic */ MutableState<Boolean> $unitExpanded$delegate;

    AddPantryItemDialogKt$AddPantryItemDialog$1$1$1$7$3(MutableState<String> mutableState, MutableState<Boolean> mutableState2) {
        this.$selectedUnit$delegate = mutableState;
        this.$unitExpanded$delegate = mutableState2;
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
        ComposerKt.sourceInformation($composer, "C187@8631L2,190@8779L58,185@8518L440,193@9047L24,193@9073L462,193@8983L552:AddPantryItemDialog.kt#mq3b12");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer.changed(ExposedDropdownMenuBox) : $composer.changedInstance(ExposedDropdownMenuBox) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 19) != 18 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-536695597, $dirty2, -1, "com.easycompra.app.ui.pantry.AddPantryItemDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AddPantryItemDialog.kt:185)");
            }
            String strAddPantryItemDialog$lambda$23 = AddPantryItemDialogKt.AddPantryItemDialog$lambda$23(this.$selectedUnit$delegate);
            Modifier modifierM2100menuAnchorfsE2BvY$default = ExposedDropdownMenuBoxScope.m2100menuAnchorfsE2BvY$default(ExposedDropdownMenuBox, Modifier.INSTANCE, MenuAnchorType.INSTANCE.m2246getPrimaryNotEditableMg6Rgbw(), false, 2, null);
            $composer.startReplaceGroup(145475667);
            ComposerKt.sourceInformation($composer, "CC(remember):AddPantryItemDialog.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function1() { // from class: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$AddPantryItemDialog$1$1$1$7$3$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AddPantryItemDialogKt$AddPantryItemDialog$1$1$1$7$3.invoke$lambda$1$lambda$0((String) obj);
                    }
                };
                $composer.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer.endReplaceGroup();
            Function2<Composer, Integer, Unit> function2M7120getLambda9$app_debug = ComposableSingletons$AddPantryItemDialogKt.INSTANCE.m7120getLambda9$app_debug();
            final MutableState<Boolean> mutableState = this.$unitExpanded$delegate;
            OutlinedTextFieldKt.OutlinedTextField(strAddPantryItemDialog$lambda$23, (Function1<? super String, Unit>) value$iv, modifierM2100menuAnchorfsE2BvY$default, false, true, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) function2M7120getLambda9$app_debug, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1393630774, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$AddPantryItemDialog$1$1$1$7$3.2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer2, int $changed2) {
                    ComposerKt.sourceInformation($composer2, "C190@8809L26:AddPantryItemDialog.kt#mq3b12");
                    if (($changed2 & 3) == 2 && $composer2.getSkipping()) {
                        $composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1393630774, $changed2, -1, "com.easycompra.app.ui.pantry.AddPantryItemDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AddPantryItemDialog.kt:190)");
                    }
                    ExposedDropdownMenuDefaults.INSTANCE.TrailingIcon(AddPantryItemDialogKt.AddPantryItemDialog$lambda$32(mutableState), null, $composer2, ExposedDropdownMenuDefaults.$stable << 6, 2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer, 806903856, 0, 0, 8388008);
            boolean zAddPantryItemDialog$lambda$32 = AddPantryItemDialogKt.AddPantryItemDialog$lambda$32(this.$unitExpanded$delegate);
            $composer.startReplaceGroup(145489001);
            ComposerKt.sourceInformation($composer, "CC(remember):AddPantryItemDialog.kt#9igjgp");
            final MutableState<Boolean> mutableState2 = this.$unitExpanded$delegate;
            Object it$iv2 = $composer.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new Function0() { // from class: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$AddPantryItemDialog$1$1$1$7$3$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AddPantryItemDialogKt$AddPantryItemDialog$1$1$1$7$3.invoke$lambda$3$lambda$2(mutableState2);
                    }
                };
                $composer.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            $composer.endReplaceGroup();
            ExposedDropdownMenuBox.m2102ExposedDropdownMenuvNxi1II(zAddPantryItemDialog$lambda$32, (Function0) value$iv2, null, null, false, null, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-865149807, true, new AnonymousClass4(this.$selectedUnit$delegate, this.$unitExpanded$delegate), $composer, 54), $composer, 48, (ExposedDropdownMenuBoxScope.$stable << 3) | 6 | (($dirty2 << 3) & 112), PointerIconCompat.TYPE_GRAB);
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

    /* JADX INFO: renamed from: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$AddPantryItemDialog$1$1$1$7$3$4, reason: invalid class name */
    /* JADX INFO: compiled from: AddPantryItemDialog.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass4 implements Function3<ColumnScope, Composer, Integer, Unit> {
        final /* synthetic */ MutableState<String> $selectedUnit$delegate;
        final /* synthetic */ MutableState<Boolean> $unitExpanded$delegate;

        AnonymousClass4(MutableState<String> mutableState, MutableState<Boolean> mutableState2) {
            this.$selectedUnit$delegate = mutableState;
            this.$unitExpanded$delegate = mutableState2;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
            invoke(columnScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(ColumnScope ExposedDropdownMenu, Composer $composer, int $changed) {
            Object value$iv;
            Intrinsics.checkNotNullParameter(ExposedDropdownMenu, "$this$ExposedDropdownMenu");
            ComposerKt.sourceInformation($composer, "C*196@9237L14,197@9299L45,195@9176L303:AddPantryItemDialog.kt#mq3b12");
            if (($changed & 17) != 16 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-865149807, $changed, -1, "com.easycompra.app.ui.pantry.AddPantryItemDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AddPantryItemDialog.kt:194)");
                }
                Iterable $this$forEach$iv = PantryCategories.INSTANCE.getUnits();
                final MutableState<String> mutableState = this.$selectedUnit$delegate;
                final MutableState<Boolean> mutableState2 = this.$unitExpanded$delegate;
                for (Object element$iv : $this$forEach$iv) {
                    final String unit = (String) element$iv;
                    ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-172399855, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$AddPantryItemDialog$1$1$1$7$3$4$1$1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer2, int $changed2) {
                            ComposerKt.sourceInformation($composer2, "C196@9239L10:AddPantryItemDialog.kt#mq3b12");
                            if (($changed2 & 3) == 2 && $composer2.getSkipping()) {
                                $composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-172399855, $changed2, -1, "com.easycompra.app.ui.pantry.AddPantryItemDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AddPantryItemDialog.kt:196)");
                            }
                            TextKt.m2714Text4IGK_g(unit, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 0, 0, 131070);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer, 54);
                    $composer.startReplaceGroup(135763580);
                    ComposerKt.sourceInformation($composer, "CC(remember):AddPantryItemDialog.kt#9igjgp");
                    boolean invalid$iv = $composer.changed(unit);
                    Object it$iv = $composer.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = new Function0() { // from class: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$AddPantryItemDialog$1$1$1$7$3$4$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return AddPantryItemDialogKt$AddPantryItemDialog$1$1$1$7$3.AnonymousClass4.invoke$lambda$2$lambda$1$lambda$0(unit, mutableState, mutableState2);
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
        public static final Unit invoke$lambda$2$lambda$1$lambda$0(String $unit, MutableState $selectedUnit$delegate, MutableState $unitExpanded$delegate) {
            $selectedUnit$delegate.setValue($unit);
            AddPantryItemDialogKt.AddPantryItemDialog$lambda$33($unitExpanded$delegate, false);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$3$lambda$2(MutableState $unitExpanded$delegate) {
        AddPantryItemDialogKt.AddPantryItemDialog$lambda$33($unitExpanded$delegate, false);
        return Unit.INSTANCE;
    }
}
