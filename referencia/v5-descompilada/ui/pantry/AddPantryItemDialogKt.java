package com.easycompra.app.ui.pantry;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.ExposedDropdownMenu_androidKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.exifinterface.media.ExifInterface;
import coil.disk.DiskLruCache;
import com.easycompra.app.data.pantry.PantryCategories;
import com.easycompra.app.data.pantry.PantryLocationEntityKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: AddPantryItemDialog.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a©\u0001\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u008b\u0001\u0010\t\u001a\u0086\u0001\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00060\nH\u0007¢\u0006\u0002\u0010\u0012\" \u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013²\u0006\n\u0010\f\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010\u000f\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010\u0014\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010\u0015\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\u0010\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0001X\u008a\u008e\u0002²\u0006\n\u0010\u0019\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010\u001a\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010\u001b\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\n\u0010\u001c\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\n\u0010\u001d\u001a\u00020\u0016X\u008a\u008e\u0002"}, d2 = {"QUICK_FRACTIONS", "", "Lkotlin/Pair;", "", "", "AddPantryItemDialog", "", "onDismiss", "Lkotlin/Function0;", "onConfirm", "Lkotlin/Function6;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "category", "subcategory", "description", "quantity", "unit", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function6;Landroidx/compose/runtime/Composer;I)V", "app_debug", "quantityText", "nameError", "", "selectedCategory", "subcategories", "selectedSubcategory", "selectedUnit", "catExpanded", "subcatExpanded", "unitExpanded"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AddPantryItemDialogKt {
    private static final List<Pair<String, Float>> QUICK_FRACTIONS = CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("¼", Float.valueOf(0.25f)), TuplesKt.to("½", Float.valueOf(0.5f)), TuplesKt.to("¾", Float.valueOf(0.75f)), TuplesKt.to("1½", Float.valueOf(1.5f)), TuplesKt.to(ExifInterface.GPS_MEASUREMENT_2D, Float.valueOf(2.0f)), TuplesKt.to(ExifInterface.GPS_MEASUREMENT_3D, Float.valueOf(3.0f))});

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddPantryItemDialog$lambda$34(Function0 function0, Function6 function6, int i, Composer composer, int i2) {
        AddPantryItemDialog(function0, function6, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void AddPantryItemDialog(final Function0<Unit> onDismiss, final Function6<? super String, ? super String, ? super String, ? super String, ? super Float, ? super String, Unit> onConfirm, Composer $composer, final int $changed) {
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        Object value$iv4;
        Object value$iv5;
        Object value$iv6;
        Object value$iv7;
        Object value$iv8;
        Object value$iv9;
        Object value$iv10;
        Object value$iv11;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Composer $composer3 = $composer.startRestartGroup(-1175422374);
        ComposerKt.sourceInformation($composer3, "C(AddPantryItemDialog)P(1)54@2174L31,55@2229L31,56@2285L32,57@2339L34,60@2494L47,61@2567L71,62@2670L50,63@2745L37,65@2807L34,66@2868L34,67@2927L34,69@3004L8442,69@2967L8479:AddPantryItemDialog.kt#mq3b12");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(onDismiss) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(onConfirm) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 19) != 18 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1175422374, $dirty2, -1, "com.easycompra.app.ui.pantry.AddPantryItemDialog (AddPantryItemDialog.kt:53)");
            }
            $composer3.startReplaceGroup(69115221);
            ComposerKt.sourceInformation($composer3, "CC(remember):AddPantryItemDialog.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState name$delegate = (MutableState) value$iv;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(69116981);
            ComposerKt.sourceInformation($composer3, "CC(remember):AddPantryItemDialog.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            final MutableState description$delegate = (MutableState) value$iv2;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(69118774);
            ComposerKt.sourceInformation($composer3, "CC(remember):AddPantryItemDialog.kt#9igjgp");
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(DiskLruCache.VERSION, null, 2, null);
                $composer3.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            final MutableState quantityText$delegate = (MutableState) value$iv3;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(69120504);
            ComposerKt.sourceInformation($composer3, "CC(remember):AddPantryItemDialog.kt#9igjgp");
            Object it$iv4 = $composer3.rememberedValue();
            if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv4;
            }
            final MutableState nameError$delegate = (MutableState) value$iv4;
            $composer3.endReplaceGroup();
            Iterable $this$filter$iv = PantryCategories.INSTANCE.getAll().keySet();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                String it = (String) element$iv$iv;
                if (!Intrinsics.areEqual(it, "Bebidas y Otros")) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            final List categories = CollectionsKt.toList((List) destination$iv$iv);
            $composer3.startReplaceGroup(69125477);
            ComposerKt.sourceInformation($composer3, "CC(remember):AddPantryItemDialog.kt#9igjgp");
            Object it$iv5 = $composer3.rememberedValue();
            if (it$iv5 == Composer.INSTANCE.getEmpty()) {
                value$iv5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.first(categories), null, 2, null);
                $composer3.updateRememberedValue(value$iv5);
            } else {
                value$iv5 = it$iv5;
            }
            final MutableState selectedCategory$delegate = (MutableState) value$iv5;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(69127837);
            ComposerKt.sourceInformation($composer3, "CC(remember):AddPantryItemDialog.kt#9igjgp");
            Object it$iv6 = $composer3.rememberedValue();
            if (it$iv6 == Composer.INSTANCE.getEmpty()) {
                List<String> list = PantryCategories.INSTANCE.getAll().get(CollectionsKt.first(categories));
                Intrinsics.checkNotNull(list);
                value$iv6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(list, null, 2, null);
                $composer3.updateRememberedValue(value$iv6);
            } else {
                value$iv6 = it$iv6;
            }
            final MutableState subcategories$delegate = (MutableState) value$iv6;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(69131112);
            ComposerKt.sourceInformation($composer3, "CC(remember):AddPantryItemDialog.kt#9igjgp");
            Object it$iv7 = $composer3.rememberedValue();
            if (it$iv7 == Composer.INSTANCE.getEmpty()) {
                value$iv7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.first((List) AddPantryItemDialog$lambda$17(subcategories$delegate)), null, 2, null);
                $composer3.updateRememberedValue(value$iv7);
            } else {
                value$iv7 = it$iv7;
            }
            final MutableState selectedSubcategory$delegate = (MutableState) value$iv7;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(69133499);
            ComposerKt.sourceInformation($composer3, "CC(remember):AddPantryItemDialog.kt#9igjgp");
            Object it$iv8 = $composer3.rememberedValue();
            if (it$iv8 == Composer.INSTANCE.getEmpty()) {
                value$iv8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("unidad", null, 2, null);
                $composer3.updateRememberedValue(value$iv8);
            } else {
                value$iv8 = it$iv8;
            }
            final MutableState selectedUnit$delegate = (MutableState) value$iv8;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(69135480);
            ComposerKt.sourceInformation($composer3, "CC(remember):AddPantryItemDialog.kt#9igjgp");
            Object it$iv9 = $composer3.rememberedValue();
            if (it$iv9 == Composer.INSTANCE.getEmpty()) {
                value$iv9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv9);
            } else {
                value$iv9 = it$iv9;
            }
            final MutableState catExpanded$delegate = (MutableState) value$iv9;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(69137432);
            ComposerKt.sourceInformation($composer3, "CC(remember):AddPantryItemDialog.kt#9igjgp");
            Object it$iv10 = $composer3.rememberedValue();
            if (it$iv10 == Composer.INSTANCE.getEmpty()) {
                value$iv10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv10);
            } else {
                value$iv10 = it$iv10;
            }
            final MutableState subcatExpanded$delegate = (MutableState) value$iv10;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(69139320);
            ComposerKt.sourceInformation($composer3, "CC(remember):AddPantryItemDialog.kt#9igjgp");
            Object it$iv11 = $composer3.rememberedValue();
            if (it$iv11 == Composer.INSTANCE.getEmpty()) {
                value$iv11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv11);
            } else {
                value$iv11 = it$iv11;
            }
            final MutableState unitExpanded$delegate = (MutableState) value$iv11;
            $composer3.endReplaceGroup();
            $composer2 = $composer3;
            AndroidDialog_androidKt.Dialog(onDismiss, null, ComposableLambdaKt.rememberComposableLambda(-1761992975, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.AddPantryItemDialogKt.AddPantryItemDialog.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C73@3191L11,73@3149L62,74@3222L8218,70@3014L8426:AddPantryItemDialog.kt#mq3b12");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1761992975, $changed2, -1, "com.easycompra.app.ui.pantry.AddPantryItemDialog.<anonymous> (AddPantryItemDialog.kt:70)");
                        }
                        CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m964RoundedCornerShape0680j_4(Dp.m6663constructorimpl(16)), CardDefaults.INSTANCE.m1850cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getSurface(), 0L, 0L, 0L, $composer4, CardDefaults.$stable << 12, 14), null, null, ComposableLambdaKt.rememberComposableLambda(693726051, true, new C01681(name$delegate, nameError$delegate, catExpanded$delegate, selectedCategory$delegate, categories, subcategories$delegate, selectedSubcategory$delegate, subcatExpanded$delegate, description$delegate, quantityText$delegate, unitExpanded$delegate, selectedUnit$delegate, onDismiss, onConfirm), $composer4, 54), $composer4, 196614, 24);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }

                /* JADX INFO: renamed from: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$AddPantryItemDialog$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: AddPantryItemDialog.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                static final class C01681 implements Function3<ColumnScope, Composer, Integer, Unit> {
                    final /* synthetic */ MutableState<Boolean> $catExpanded$delegate;
                    final /* synthetic */ List<String> $categories;
                    final /* synthetic */ MutableState<String> $description$delegate;
                    final /* synthetic */ MutableState<String> $name$delegate;
                    final /* synthetic */ MutableState<Boolean> $nameError$delegate;
                    final /* synthetic */ Function6<String, String, String, String, Float, String, Unit> $onConfirm;
                    final /* synthetic */ Function0<Unit> $onDismiss;
                    final /* synthetic */ MutableState<String> $quantityText$delegate;
                    final /* synthetic */ MutableState<String> $selectedCategory$delegate;
                    final /* synthetic */ MutableState<String> $selectedSubcategory$delegate;
                    final /* synthetic */ MutableState<String> $selectedUnit$delegate;
                    final /* synthetic */ MutableState<Boolean> $subcatExpanded$delegate;
                    final /* synthetic */ MutableState<List<String>> $subcategories$delegate;
                    final /* synthetic */ MutableState<Boolean> $unitExpanded$delegate;

                    /* JADX WARN: Multi-variable type inference failed */
                    C01681(MutableState<String> mutableState, MutableState<Boolean> mutableState2, MutableState<Boolean> mutableState3, MutableState<String> mutableState4, List<String> list, MutableState<List<String>> mutableState5, MutableState<String> mutableState6, MutableState<Boolean> mutableState7, MutableState<String> mutableState8, MutableState<String> mutableState9, MutableState<Boolean> mutableState10, MutableState<String> mutableState11, Function0<Unit> function0, Function6<? super String, ? super String, ? super String, ? super String, ? super Float, ? super String, Unit> function6) {
                        this.$name$delegate = mutableState;
                        this.$nameError$delegate = mutableState2;
                        this.$catExpanded$delegate = mutableState3;
                        this.$selectedCategory$delegate = mutableState4;
                        this.$categories = list;
                        this.$subcategories$delegate = mutableState5;
                        this.$selectedSubcategory$delegate = mutableState6;
                        this.$subcatExpanded$delegate = mutableState7;
                        this.$description$delegate = mutableState8;
                        this.$quantityText$delegate = mutableState9;
                        this.$unitExpanded$delegate = mutableState10;
                        this.$selectedUnit$delegate = mutableState11;
                        this.$onDismiss = function0;
                        this.$onConfirm = function6;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                        invoke(columnScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Code duplicated, block: B:101:0x091e  */
                    /* JADX WARN: Code duplicated, block: B:102:0x0922  */
                    /* JADX WARN: Code duplicated, block: B:105:0x0950  */
                    /* JADX WARN: Code duplicated, block: B:108:0x0963  */
                    /* JADX WARN: Code duplicated, block: B:109:0x0966  */
                    /* JADX WARN: Code duplicated, block: B:113:0x09f6  */
                    /* JADX WARN: Code duplicated, block: B:117:0x0a0f A[ADDED_TO_REGION] */
                    /* JADX WARN: Code duplicated, block: B:121:0x0aa7  */
                    /* JADX WARN: Code duplicated, block: B:127:? A[RETURN, SYNTHETIC] */
                    /* JADX WARN: Code duplicated, block: B:28:0x01ef  */
                    /* JADX WARN: Code duplicated, block: B:29:0x01f8  */
                    /* JADX WARN: Code duplicated, block: B:32:0x0244  */
                    /* JADX WARN: Code duplicated, block: B:33:0x0252  */
                    /* JADX WARN: Code duplicated, block: B:36:0x02b9  */
                    /* JADX WARN: Code duplicated, block: B:37:0x02c7  */
                    /* JADX WARN: Code duplicated, block: B:40:0x0328  */
                    /* JADX WARN: Code duplicated, block: B:41:0x0336  */
                    /* JADX WARN: Code duplicated, block: B:44:0x0393  */
                    /* JADX WARN: Code duplicated, block: B:45:0x039f  */
                    /* JADX WARN: Code duplicated, block: B:48:0x0464  */
                    /* JADX WARN: Code duplicated, block: B:51:0x0470  */
                    /* JADX WARN: Code duplicated, block: B:52:0x0476  */
                    /* JADX WARN: Code duplicated, block: B:63:0x0562  */
                    /* JADX WARN: Code duplicated, block: B:64:0x0574  */
                    /* JADX WARN: Code duplicated, block: B:67:0x05e4  */
                    /* JADX WARN: Code duplicated, block: B:68:0x05f6  */
                    /* JADX WARN: Code duplicated, block: B:71:0x0700  */
                    /* JADX WARN: Code duplicated, block: B:74:0x070c  */
                    /* JADX WARN: Code duplicated, block: B:75:0x0712  */
                    /* JADX WARN: Code duplicated, block: B:87:0x07c3  */
                    /* JADX WARN: Code duplicated, block: B:98:0x0912  */
                    public final void invoke(ColumnScope Card, Composer $composer, int $changed) {
                        Function0<ComposeUiNode> function0;
                        MeasurePolicy measurePolicy$iv;
                        Function2<Composer, Integer, Unit> function2M7110getLambda1$app_debug;
                        Object value$iv;
                        Object value$iv2;
                        Object it$iv;
                        Object value$iv3;
                        Object it$iv2;
                        Object value$iv4;
                        int compositeKeyHash$iv$iv;
                        Function0<ComposeUiNode> constructor;
                        Function0<ComposeUiNode> function1;
                        Composer $this$Layout_u24lambda_u240$iv$iv;
                        Object value$iv5;
                        final MutableState<String> mutableState;
                        Object it$iv3;
                        final MutableState<Boolean> mutableState2;
                        Object value$iv6;
                        int $changed$iv;
                        int compositeKeyHash$iv$iv2;
                        Function0<ComposeUiNode> constructor2;
                        Function0<ComposeUiNode> function2;
                        Composer $this$Layout_u24lambda_u240$iv$iv2;
                        int i;
                        RowScope $this$invoke_u24lambda_u2421_u24lambda_u2417;
                        Iterable $this$forEach$iv;
                        int $i$f$forEach;
                        int compositeKeyHash$iv$iv3;
                        Function0<ComposeUiNode> constructor3;
                        Composer $this$Layout_u24lambda_u240$iv$iv3;
                        Function0<ComposeUiNode> function3;
                        boolean invalid$iv;
                        Object value$iv7;
                        boolean invalid$iv2;
                        Object value$iv8;
                        Intrinsics.checkNotNullParameter(Card, "$this$Card");
                        ComposerKt.sourceInformation($composer, "C78@3352L21,75@3236L8194:AddPantryItemDialog.kt#mq3b12");
                        if (($changed & 17) != 16 || !$composer.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(693726051, $changed, -1, "com.easycompra.app.ui.pantry.AddPantryItemDialog.<anonymous>.<anonymous> (AddPantryItemDialog.kt:75)");
                            }
                            Modifier modifier$iv = ScrollKt.verticalScroll$default(PaddingKt.m681padding3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(20)), ScrollKt.rememberScrollState(0, $composer, 0, 1), false, null, false, 14, null);
                            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(12));
                            final MutableState<String> mutableState3 = this.$name$delegate;
                            final MutableState<Boolean> mutableState4 = this.$nameError$delegate;
                            final MutableState<Boolean> mutableState5 = this.$catExpanded$delegate;
                            final MutableState<String> mutableState6 = this.$selectedCategory$delegate;
                            List<String> list = this.$categories;
                            MutableState<List<String>> mutableState7 = this.$subcategories$delegate;
                            final MutableState<String> mutableState8 = this.$selectedSubcategory$delegate;
                            final MutableState<Boolean> mutableState9 = this.$subcatExpanded$delegate;
                            final MutableState<String> mutableState10 = this.$description$delegate;
                            MutableState<String> mutableState11 = this.$quantityText$delegate;
                            MutableState<Boolean> mutableState12 = this.$unitExpanded$delegate;
                            final MutableState<String> mutableState13 = this.$selectedUnit$delegate;
                            Function0<Unit> function4 = this.$onDismiss;
                            final Function6<String, String, String, String, Float, String, Unit> function6 = this.$onConfirm;
                            ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                            int $changed$iv$iv = (48 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
                            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!($composer.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer.startReusableNode();
                            if ($composer.getInserting()) {
                                function0 = constructor4;
                                $composer.createNode(function0);
                            } else {
                                function0 = constructor4;
                                $composer.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.m3674constructorimpl($composer);
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!$this$Layout_u24lambda_u240$iv$iv4.getInserting()) {
                                measurePolicy$iv = measurePolicy$iv2;
                                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv4.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv4))) {
                                }
                                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                int i2 = ($changed$iv$iv$iv >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                int i3 = ((48 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer, 1584527594, "C83@3560L10,85@3675L11,81@3474L238,90@3819L32,88@3730L533,102@4429L20,104@4524L1265,100@4322L1467,132@5949L23,134@6047L1023,130@5839L1231,156@7184L20,154@7088L373,164@7516L2059,206@9705L11,206@9640L94,207@9751L788,225@10557L859:AddPantryItemDialog.kt#mq3b12");
                                TextKt.m2714Text4IGK_g("Nuevo producto", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary(), 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getTitleLarge(), $composer, 196614, 0, 65498);
                                String strAddPantryItemDialog$lambda$1 = AddPantryItemDialogKt.AddPantryItemDialog$lambda$1(mutableState3);
                                boolean zAddPantryItemDialog$lambda$10 = AddPantryItemDialogKt.AddPantryItemDialog$lambda$10(mutableState4);
                                if (AddPantryItemDialogKt.AddPantryItemDialog$lambda$10(mutableState4)) {
                                    function2M7110getLambda1$app_debug = ComposableSingletons$AddPantryItemDialogKt.INSTANCE.m7110getLambda1$app_debug();
                                } else {
                                    function2M7110getLambda1$app_debug = null;
                                }
                                KeyboardOptions keyboardOptions = new KeyboardOptions(KeyboardCapitalization.INSTANCE.m6338getSentencesIUNYP9k(), (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, WebSocketProtocol.PAYLOAD_SHORT, (DefaultConstructorMarker) null);
                                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                $composer.startReplaceGroup(-225977741);
                                ComposerKt.sourceInformation($composer, "CC(remember):AddPantryItemDialog.kt#9igjgp");
                                value$iv = $composer.rememberedValue();
                                if (value$iv == Composer.INSTANCE.getEmpty()) {
                                    value$iv = new Function1() { // from class: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$AddPantryItemDialog$1$1$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return AddPantryItemDialogKt.AnonymousClass1.C01681.invoke$lambda$21$lambda$1$lambda$0(mutableState3, mutableState4, (String) obj);
                                        }
                                    };
                                    $composer.updateRememberedValue(value$iv);
                                }
                                $composer.endReplaceGroup();
                                OutlinedTextFieldKt.OutlinedTextField(strAddPantryItemDialog$lambda$1, (Function1<? super String, Unit>) value$iv, modifierFillMaxWidth$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$AddPantryItemDialogKt.INSTANCE.m7113getLambda2$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function2M7110getLambda1$app_debug, zAddPantryItemDialog$lambda$10, (VisualTransformation) null, keyboardOptions, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer, 1573296, 12779520, 0, 8212408);
                                boolean zAddPantryItemDialog$lambda$26 = AddPantryItemDialogKt.AddPantryItemDialog$lambda$26(mutableState5);
                                $composer.startReplaceGroup(-225958233);
                                ComposerKt.sourceInformation($composer, "CC(remember):AddPantryItemDialog.kt#9igjgp");
                                value$iv2 = $composer.rememberedValue();
                                if (value$iv2 == Composer.INSTANCE.getEmpty()) {
                                    value$iv2 = new Function1() { // from class: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$AddPantryItemDialog$1$1$$ExternalSyntheticLambda1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return AddPantryItemDialogKt.AnonymousClass1.C01681.invoke$lambda$21$lambda$3$lambda$2(mutableState5, ((Boolean) obj).booleanValue());
                                        }
                                    };
                                    $composer.updateRememberedValue(value$iv2);
                                }
                                $composer.endReplaceGroup();
                                ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox(zAddPantryItemDialog$lambda$26, (Function1) value$iv2, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), ComposableLambdaKt.rememberComposableLambda(1083069423, true, new AddPantryItemDialogKt$AddPantryItemDialog$1$1$1$3(mutableState6, mutableState5, list, mutableState7, mutableState8), $composer, 54), $composer, 3504, 0);
                                boolean zAddPantryItemDialog$lambda$29 = AddPantryItemDialogKt.AddPantryItemDialog$lambda$29(mutableState9);
                                $composer.startReplaceGroup(-225909590);
                                ComposerKt.sourceInformation($composer, "CC(remember):AddPantryItemDialog.kt#9igjgp");
                                it$iv = $composer.rememberedValue();
                                if (it$iv == Composer.INSTANCE.getEmpty()) {
                                    value$iv3 = new Function1() { // from class: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$AddPantryItemDialog$1$1$$ExternalSyntheticLambda2
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return AddPantryItemDialogKt.AnonymousClass1.C01681.invoke$lambda$21$lambda$5$lambda$4(mutableState9, ((Boolean) obj).booleanValue());
                                        }
                                    };
                                    $composer.updateRememberedValue(value$iv3);
                                } else {
                                    value$iv3 = it$iv;
                                }
                                $composer.endReplaceGroup();
                                ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox(zAddPantryItemDialog$lambda$29, (Function1) value$iv3, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), ComposableLambdaKt.rememberComposableLambda(119830886, true, new AddPantryItemDialogKt$AddPantryItemDialog$1$1$1$5(mutableState8, mutableState9, mutableState7), $composer, 54), $composer, 3504, 0);
                                String strAddPantryItemDialog$lambda$4 = AddPantryItemDialogKt.AddPantryItemDialog$lambda$4(mutableState10);
                                Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                $composer.startReplaceGroup(-225870073);
                                ComposerKt.sourceInformation($composer, "CC(remember):AddPantryItemDialog.kt#9igjgp");
                                it$iv2 = $composer.rememberedValue();
                                if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                                    value$iv4 = new Function1() { // from class: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$AddPantryItemDialog$1$1$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return AddPantryItemDialogKt.AnonymousClass1.C01681.invoke$lambda$21$lambda$7$lambda$6(mutableState10, (String) obj);
                                        }
                                    };
                                    $composer.updateRememberedValue(value$iv4);
                                } else {
                                    value$iv4 = it$iv2;
                                }
                                $composer.endReplaceGroup();
                                OutlinedTextFieldKt.OutlinedTextField(strAddPantryItemDialog$lambda$4, (Function1<? super String, Unit>) value$iv4, modifierFillMaxWidth$default2, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$AddPantryItemDialogKt.INSTANCE.m7116getLambda5$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$AddPantryItemDialogKt.INSTANCE.m7117getLambda6$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer, 14156208, 12582912, 0, 8257336);
                                Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(8));
                                ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                                Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                                MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                                int $changed$iv$iv2 = (54 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                                CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
                                constructor = ComposeUiNode.INSTANCE.getConstructor();
                                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!($composer.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer.startReusableNode();
                                if ($composer.getInserting()) {
                                    function1 = constructor;
                                    $composer.createNode(function1);
                                } else {
                                    function1 = constructor;
                                    $composer.useNode();
                                }
                                $this$Layout_u24lambda_u240$iv$iv = Updater.m3674constructorimpl($composer);
                                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (!$this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                    $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                    $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash2);
                                }
                                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                                int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                                int i5 = ((54 >> 6) & 112) | 6;
                                RowScope $this$invoke_u24lambda_u2421_u24lambda_u2413 = RowScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart($composer, 491660580, "C170@7793L129,168@7688L566,182@8392L21,184@8492L1065,180@8276L1281:AddPantryItemDialog.kt#mq3b12");
                                String strAddPantryItemDialog$lambda$7 = AddPantryItemDialogKt.AddPantryItemDialog$lambda$7(mutableState11);
                                KeyboardOptions keyboardOptions2 = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m6359getDecimalPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 123, (DefaultConstructorMarker) null);
                                Modifier modifierWeight$default = RowScope.weight$default($this$invoke_u24lambda_u2421_u24lambda_u2413, Modifier.INSTANCE, 1.0f, false, 2, null);
                                $composer.startReplaceGroup(431503635);
                                ComposerKt.sourceInformation($composer, "CC(remember):AddPantryItemDialog.kt#9igjgp");
                                value$iv5 = $composer.rememberedValue();
                                if (value$iv5 == Composer.INSTANCE.getEmpty()) {
                                    mutableState = mutableState11;
                                    value$iv5 = new Function1() { // from class: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$AddPantryItemDialog$1$1$$ExternalSyntheticLambda4
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return AddPantryItemDialogKt.AnonymousClass1.C01681.invoke$lambda$21$lambda$13$lambda$10$lambda$9(mutableState, (String) obj);
                                        }
                                    };
                                    $composer.updateRememberedValue(value$iv5);
                                } else {
                                    mutableState = mutableState11;
                                }
                                $composer.endReplaceGroup();
                                OutlinedTextFieldKt.OutlinedTextField(strAddPantryItemDialog$lambda$7, (Function1<? super String, Unit>) value$iv5, modifierWeight$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$AddPantryItemDialogKt.INSTANCE.m7118getLambda7$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$AddPantryItemDialogKt.INSTANCE.m7119getLambda8$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptions2, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer, 14155824, 12779520, 0, 8224568);
                                boolean zAddPantryItemDialog$lambda$32 = AddPantryItemDialogKt.AddPantryItemDialog$lambda$32(mutableState12);
                                $composer.startReplaceGroup(431522695);
                                ComposerKt.sourceInformation($composer, "CC(remember):AddPantryItemDialog.kt#9igjgp");
                                it$iv3 = $composer.rememberedValue();
                                if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                                    mutableState2 = mutableState12;
                                    value$iv6 = new Function1() { // from class: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$AddPantryItemDialog$1$1$$ExternalSyntheticLambda5
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return AddPantryItemDialogKt.AnonymousClass1.C01681.invoke$lambda$21$lambda$13$lambda$12$lambda$11(mutableState2, ((Boolean) obj).booleanValue());
                                        }
                                    };
                                    $composer.updateRememberedValue(value$iv6);
                                } else {
                                    mutableState2 = mutableState12;
                                    value$iv6 = it$iv3;
                                }
                                $composer.endReplaceGroup();
                                ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox(zAddPantryItemDialog$lambda$32, (Function1) value$iv6, RowScope.weight$default($this$invoke_u24lambda_u2421_u24lambda_u2413, Modifier.INSTANCE, 1.0f, false, 2, null), ComposableLambdaKt.rememberComposableLambda(-536695597, true, new AddPantryItemDialogKt$AddPantryItemDialog$1$1$1$7$3(mutableState13, mutableState2), $composer, 54), $composer, 3120, 0);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                $composer.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                TextKt.m2714Text4IGK_g("Cantidad rápida:", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurfaceVariant(), TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 3078, 0, 131058);
                                Arrangement.HorizontalOrVertical horizontalOrVerticalM561spacedBy0680j_4 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(6));
                                Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                $changed$iv = 54;
                                ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                                Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getTop();
                                MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalOrVerticalM561spacedBy0680j_4, verticalAlignment$iv2, $composer, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                                int $changed$iv$iv3 = (54 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                                CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifierFillMaxWidth$default3);
                                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                int $i$f$Row = $changed$iv$iv3 << 6;
                                int $changed$iv$iv$iv3 = ($i$f$Row & 896) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!($composer.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer.startReusableNode();
                                if ($composer.getInserting()) {
                                    function2 = constructor2;
                                    $composer.createNode(function2);
                                } else {
                                    function2 = constructor2;
                                    $composer.useNode();
                                }
                                $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3674constructorimpl($composer);
                                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash3);
                                }
                                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                                int i6 = ($changed$iv$iv$iv3 >> 6) & 14;
                                i = 0;
                                ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                                int i7 = ((54 >> 6) & 112) | 6;
                                $this$invoke_u24lambda_u2421_u24lambda_u2417 = RowScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart($composer, 493838299, "C:AddPantryItemDialog.kt#mq3b12");
                                $composer.startReplaceGroup(431572760);
                                ComposerKt.sourceInformation($composer, "*215@10171L231,220@10440L33,213@10070L429");
                                $this$forEach$iv = AddPantryItemDialogKt.QUICK_FRACTIONS;
                                $i$f$forEach = 0;
                                for (Object element$iv : $this$forEach$iv) {
                                    Pair pair = (Pair) element$iv;
                                    Iterable $this$forEach$iv2 = $this$forEach$iv;
                                    final String label = (String) pair.component1();
                                    int $i$f$forEach2 = $i$f$forEach;
                                    final float value = ((Number) pair.component2()).floatValue();
                                    int $changed$iv2 = $changed$iv;
                                    boolean isSelected = Intrinsics.areEqual(PantryLocationEntityKt.parsePantryQty(AddPantryItemDialogKt.AddPantryItemDialog$lambda$7(mutableState)), value);
                                    int i8 = i;
                                    $composer.startReplaceGroup(145525176);
                                    ComposerKt.sourceInformation($composer, "CC(remember):AddPantryItemDialog.kt#9igjgp");
                                    invalid$iv2 = $composer.changed(value);
                                    RowScope $this$invoke_u24lambda_u2421_u24lambda_u2418 = $this$invoke_u24lambda_u2421_u24lambda_u2417;
                                    Object it$iv4 = $composer.rememberedValue();
                                    if (!invalid$iv2 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                                        value$iv8 = new Function0() { // from class: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$AddPantryItemDialog$1$1$$ExternalSyntheticLambda6
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return AddPantryItemDialogKt.AnonymousClass1.C01681.invoke$lambda$21$lambda$17$lambda$16$lambda$15$lambda$14(value, mutableState);
                                            }
                                        };
                                        $composer.updateRememberedValue(value$iv8);
                                    } else {
                                        value$iv8 = it$iv4;
                                    }
                                    $composer.endReplaceGroup();
                                    ChipKt.FilterChip(isSelected, (Function0) value$iv8, ComposableLambdaKt.rememberComposableLambda(1433572346, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$AddPantryItemDialog$1$1$1$8$1$2
                                        @Override // kotlin.jvm.functions.Function2
                                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                            invoke(composer, num.intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer $composer2, int $changed2) {
                                            ComposerKt.sourceInformation($composer2, "C220@10442L29:AddPantryItemDialog.kt#mq3b12");
                                            if (($changed2 & 3) == 2 && $composer2.getSkipping()) {
                                                $composer2.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1433572346, $changed2, -1, "com.easycompra.app.ui.pantry.AddPantryItemDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AddPantryItemDialog.kt:220)");
                                            }
                                            TextKt.m2714Text4IGK_g(label, (Modifier) null, 0L, TextUnitKt.getSp(13), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 3072, 0, 131062);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }, $composer, 54), null, false, null, null, null, null, null, null, null, $composer, 384, 0, 4088);
                                    $this$forEach$iv = $this$forEach$iv2;
                                    $i$f$forEach = $i$f$forEach2;
                                    $changed$iv = $changed$iv2;
                                    i = i8;
                                    $this$invoke_u24lambda_u2421_u24lambda_u2417 = $this$invoke_u24lambda_u2421_u24lambda_u2418;
                                }
                                $composer.endReplaceGroup();
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                $composer.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                Modifier modifier$iv3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(8));
                                ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                                Alignment.Vertical verticalAlignment$iv3 = Alignment.INSTANCE.getTop();
                                MeasurePolicy measurePolicy$iv5 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv3, $composer, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                                int $changed$iv$iv4 = (54 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                                CompositionLocalMap localMap$iv$iv4 = $composer.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
                                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!($composer.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer.startReusableNode();
                                if ($composer.getInserting()) {
                                    $composer.createNode(constructor3);
                                } else {
                                    $composer.useNode();
                                }
                                $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3674constructorimpl($composer);
                                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                                    function3 = constructor3;
                                    if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                                    }
                                    Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                                    int i9 = ($changed$iv$iv$iv4 >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                                    int i10 = ((54 >> 6) & 112) | 6;
                                    RowScope $this$invoke_u24lambda_u2421_u24lambda_u2420 = RowScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart($composer, 494640052, "C229@10729L132,233@10924L332,232@10882L516:AddPantryItemDialog.kt#mq3b12");
                                    ButtonKt.OutlinedButton(function4, RowScope.weight$default($this$invoke_u24lambda_u2421_u24lambda_u2420, Modifier.INSTANCE, 1.0f, false, 2, null), false, null, null, null, null, null, null, ComposableSingletons$AddPantryItemDialogKt.INSTANCE.m7111getLambda10$app_debug(), $composer, 805306368, 508);
                                    $composer.startReplaceGroup(431604030);
                                    ComposerKt.sourceInformation($composer, "CC(remember):AddPantryItemDialog.kt#9igjgp");
                                    invalid$iv = $composer.changed(function6);
                                    Object it$iv5 = $composer.rememberedValue();
                                    if (!invalid$iv || it$iv5 == Composer.INSTANCE.getEmpty()) {
                                        value$iv7 = new Function0() { // from class: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$AddPantryItemDialog$1$1$$ExternalSyntheticLambda7
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return AddPantryItemDialogKt.AnonymousClass1.C01681.invoke$lambda$21$lambda$20$lambda$19$lambda$18(function6, mutableState3, mutableState4, mutableState, mutableState6, mutableState8, mutableState10, mutableState13);
                                            }
                                        };
                                        $composer.updateRememberedValue(value$iv7);
                                    } else {
                                        value$iv7 = it$iv5;
                                    }
                                    r9.endReplaceGroup();
                                    ButtonKt.Button((Function0) value$iv7, RowScope.weight$default($this$invoke_u24lambda_u2421_u24lambda_u2420, Modifier.INSTANCE, 1.0f, false, 2, null), false, null, null, null, null, null, null, ComposableSingletons$AddPantryItemDialogKt.INSTANCE.m7112getLambda11$app_debug(), r9, 805306368, 508);
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    $composer.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    $composer.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                function3 = constructor3;
                                $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                                $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash4);
                                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                                int i11 = ($changed$iv$iv$iv4 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                                int i12 = ((54 >> 6) & 112) | 6;
                                RowScope $this$invoke_u24lambda_u2421_u24lambda_u2421 = RowScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart($composer, 494640052, "C229@10729L132,233@10924L332,232@10882L516:AddPantryItemDialog.kt#mq3b12");
                                ButtonKt.OutlinedButton(function4, RowScope.weight$default($this$invoke_u24lambda_u2421_u24lambda_u2421, Modifier.INSTANCE, 1.0f, false, 2, null), false, null, null, null, null, null, null, ComposableSingletons$AddPantryItemDialogKt.INSTANCE.m7111getLambda10$app_debug(), $composer, 805306368, 508);
                                $composer.startReplaceGroup(431604030);
                                ComposerKt.sourceInformation($composer, "CC(remember):AddPantryItemDialog.kt#9igjgp");
                                invalid$iv = $composer.changed(function6);
                                Object it$iv6 = $composer.rememberedValue();
                                if (invalid$iv) {
                                }
                                value$iv7 = new Function0() { // from class: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$AddPantryItemDialog$1$1$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return AddPantryItemDialogKt.AnonymousClass1.C01681.invoke$lambda$21$lambda$20$lambda$19$lambda$18(function6, mutableState3, mutableState4, mutableState, mutableState6, mutableState8, mutableState10, mutableState13);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv7);
                                r9.endReplaceGroup();
                                ButtonKt.Button((Function0) value$iv7, RowScope.weight$default($this$invoke_u24lambda_u2421_u24lambda_u2421, Modifier.INSTANCE, 1.0f, false, 2, null), false, null, null, null, null, null, null, ComposableSingletons$AddPantryItemDialogKt.INSTANCE.m7112getLambda11$app_debug(), r9, 805306368, 508);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                $composer.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                $composer.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            measurePolicy$iv = measurePolicy$iv2;
                            $this$Layout_u24lambda_u240$iv$iv4.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv4));
                            $this$Layout_u24lambda_u240$iv$iv4.apply(Integer.valueOf(compositeKeyHash$iv$iv4), setCompositeKeyHash);
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                            int i13 = ($changed$iv$iv$iv >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                            int i14 = ((48 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer, 1584527594, "C83@3560L10,85@3675L11,81@3474L238,90@3819L32,88@3730L533,102@4429L20,104@4524L1265,100@4322L1467,132@5949L23,134@6047L1023,130@5839L1231,156@7184L20,154@7088L373,164@7516L2059,206@9705L11,206@9640L94,207@9751L788,225@10557L859:AddPantryItemDialog.kt#mq3b12");
                            TextKt.m2714Text4IGK_g("Nuevo producto", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary(), 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getTitleLarge(), $composer, 196614, 0, 65498);
                            String strAddPantryItemDialog$lambda$2 = AddPantryItemDialogKt.AddPantryItemDialog$lambda$1(mutableState3);
                            boolean zAddPantryItemDialog$lambda$11 = AddPantryItemDialogKt.AddPantryItemDialog$lambda$10(mutableState4);
                            if (AddPantryItemDialogKt.AddPantryItemDialog$lambda$10(mutableState4)) {
                                function2M7110getLambda1$app_debug = ComposableSingletons$AddPantryItemDialogKt.INSTANCE.m7110getLambda1$app_debug();
                            } else {
                                function2M7110getLambda1$app_debug = null;
                            }
                            KeyboardOptions keyboardOptions3 = new KeyboardOptions(KeyboardCapitalization.INSTANCE.m6338getSentencesIUNYP9k(), (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, WebSocketProtocol.PAYLOAD_SHORT, (DefaultConstructorMarker) null);
                            Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                            $composer.startReplaceGroup(-225977741);
                            ComposerKt.sourceInformation($composer, "CC(remember):AddPantryItemDialog.kt#9igjgp");
                            value$iv = $composer.rememberedValue();
                            if (value$iv == Composer.INSTANCE.getEmpty()) {
                                value$iv = new Function1() { // from class: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$AddPantryItemDialog$1$1$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AddPantryItemDialogKt.AnonymousClass1.C01681.invoke$lambda$21$lambda$1$lambda$0(mutableState3, mutableState4, (String) obj);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv);
                            }
                            $composer.endReplaceGroup();
                            OutlinedTextFieldKt.OutlinedTextField(strAddPantryItemDialog$lambda$2, (Function1<? super String, Unit>) value$iv, modifierFillMaxWidth$default4, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$AddPantryItemDialogKt.INSTANCE.m7113getLambda2$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) function2M7110getLambda1$app_debug, zAddPantryItemDialog$lambda$11, (VisualTransformation) null, keyboardOptions3, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer, 1573296, 12779520, 0, 8212408);
                            boolean zAddPantryItemDialog$lambda$27 = AddPantryItemDialogKt.AddPantryItemDialog$lambda$26(mutableState5);
                            $composer.startReplaceGroup(-225958233);
                            ComposerKt.sourceInformation($composer, "CC(remember):AddPantryItemDialog.kt#9igjgp");
                            value$iv2 = $composer.rememberedValue();
                            if (value$iv2 == Composer.INSTANCE.getEmpty()) {
                                value$iv2 = new Function1() { // from class: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$AddPantryItemDialog$1$1$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AddPantryItemDialogKt.AnonymousClass1.C01681.invoke$lambda$21$lambda$3$lambda$2(mutableState5, ((Boolean) obj).booleanValue());
                                    }
                                };
                                $composer.updateRememberedValue(value$iv2);
                            }
                            $composer.endReplaceGroup();
                            ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox(zAddPantryItemDialog$lambda$27, (Function1) value$iv2, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), ComposableLambdaKt.rememberComposableLambda(1083069423, true, new AddPantryItemDialogKt$AddPantryItemDialog$1$1$1$3(mutableState6, mutableState5, list, mutableState7, mutableState8), $composer, 54), $composer, 3504, 0);
                            boolean zAddPantryItemDialog$lambda$210 = AddPantryItemDialogKt.AddPantryItemDialog$lambda$29(mutableState9);
                            $composer.startReplaceGroup(-225909590);
                            ComposerKt.sourceInformation($composer, "CC(remember):AddPantryItemDialog.kt#9igjgp");
                            it$iv = $composer.rememberedValue();
                            if (it$iv == Composer.INSTANCE.getEmpty()) {
                                value$iv3 = new Function1() { // from class: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$AddPantryItemDialog$1$1$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AddPantryItemDialogKt.AnonymousClass1.C01681.invoke$lambda$21$lambda$5$lambda$4(mutableState9, ((Boolean) obj).booleanValue());
                                    }
                                };
                                $composer.updateRememberedValue(value$iv3);
                            } else {
                                value$iv3 = it$iv;
                            }
                            $composer.endReplaceGroup();
                            ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox(zAddPantryItemDialog$lambda$210, (Function1) value$iv3, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), ComposableLambdaKt.rememberComposableLambda(119830886, true, new AddPantryItemDialogKt$AddPantryItemDialog$1$1$1$5(mutableState8, mutableState9, mutableState7), $composer, 54), $composer, 3504, 0);
                            String strAddPantryItemDialog$lambda$5 = AddPantryItemDialogKt.AddPantryItemDialog$lambda$4(mutableState10);
                            Modifier modifierFillMaxWidth$default5 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                            $composer.startReplaceGroup(-225870073);
                            ComposerKt.sourceInformation($composer, "CC(remember):AddPantryItemDialog.kt#9igjgp");
                            it$iv2 = $composer.rememberedValue();
                            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                                value$iv4 = new Function1() { // from class: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$AddPantryItemDialog$1$1$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AddPantryItemDialogKt.AnonymousClass1.C01681.invoke$lambda$21$lambda$7$lambda$6(mutableState10, (String) obj);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv4);
                            } else {
                                value$iv4 = it$iv2;
                            }
                            $composer.endReplaceGroup();
                            OutlinedTextFieldKt.OutlinedTextField(strAddPantryItemDialog$lambda$5, (Function1<? super String, Unit>) value$iv4, modifierFillMaxWidth$default5, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$AddPantryItemDialogKt.INSTANCE.m7116getLambda5$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$AddPantryItemDialogKt.INSTANCE.m7117getLambda6$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer, 14156208, 12582912, 0, 8257336);
                            Modifier modifier$iv4 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                            Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(8));
                            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                            Alignment.Vertical verticalAlignment$iv4 = Alignment.INSTANCE.getTop();
                            MeasurePolicy measurePolicy$iv6 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv4, $composer, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                            int $changed$iv$iv5 = (54 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                            compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                            CompositionLocalMap localMap$iv$iv5 = $composer.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer, modifier$iv4);
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!($composer.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer.startReusableNode();
                            if ($composer.getInserting()) {
                                function1 = constructor;
                                $composer.createNode(function1);
                            } else {
                                function1 = constructor;
                                $composer.useNode();
                            }
                            $this$Layout_u24lambda_u240$iv$iv = Updater.m3674constructorimpl($composer);
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!$this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                            }
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash5);
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv5, ComposeUiNode.INSTANCE.getSetModifier());
                            int i15 = ($changed$iv$iv$iv5 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                            int i16 = ((54 >> 6) & 112) | 6;
                            RowScope $this$invoke_u24lambda_u2421_u24lambda_u2414 = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer, 491660580, "C170@7793L129,168@7688L566,182@8392L21,184@8492L1065,180@8276L1281:AddPantryItemDialog.kt#mq3b12");
                            String strAddPantryItemDialog$lambda$8 = AddPantryItemDialogKt.AddPantryItemDialog$lambda$7(mutableState11);
                            KeyboardOptions keyboardOptions4 = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m6359getDecimalPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 123, (DefaultConstructorMarker) null);
                            Modifier modifierWeight$default2 = RowScope.weight$default($this$invoke_u24lambda_u2421_u24lambda_u2414, Modifier.INSTANCE, 1.0f, false, 2, null);
                            $composer.startReplaceGroup(431503635);
                            ComposerKt.sourceInformation($composer, "CC(remember):AddPantryItemDialog.kt#9igjgp");
                            value$iv5 = $composer.rememberedValue();
                            if (value$iv5 == Composer.INSTANCE.getEmpty()) {
                                mutableState = mutableState11;
                                value$iv5 = new Function1() { // from class: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$AddPantryItemDialog$1$1$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AddPantryItemDialogKt.AnonymousClass1.C01681.invoke$lambda$21$lambda$13$lambda$10$lambda$9(mutableState, (String) obj);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv5);
                            } else {
                                mutableState = mutableState11;
                            }
                            $composer.endReplaceGroup();
                            OutlinedTextFieldKt.OutlinedTextField(strAddPantryItemDialog$lambda$8, (Function1<? super String, Unit>) value$iv5, modifierWeight$default2, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$AddPantryItemDialogKt.INSTANCE.m7118getLambda7$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$AddPantryItemDialogKt.INSTANCE.m7119getLambda8$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptions4, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer, 14155824, 12779520, 0, 8224568);
                            boolean zAddPantryItemDialog$lambda$33 = AddPantryItemDialogKt.AddPantryItemDialog$lambda$32(mutableState12);
                            $composer.startReplaceGroup(431522695);
                            ComposerKt.sourceInformation($composer, "CC(remember):AddPantryItemDialog.kt#9igjgp");
                            it$iv3 = $composer.rememberedValue();
                            if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                                mutableState2 = mutableState12;
                                value$iv6 = new Function1() { // from class: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$AddPantryItemDialog$1$1$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return AddPantryItemDialogKt.AnonymousClass1.C01681.invoke$lambda$21$lambda$13$lambda$12$lambda$11(mutableState2, ((Boolean) obj).booleanValue());
                                    }
                                };
                                $composer.updateRememberedValue(value$iv6);
                            } else {
                                mutableState2 = mutableState12;
                                value$iv6 = it$iv3;
                            }
                            $composer.endReplaceGroup();
                            ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox(zAddPantryItemDialog$lambda$33, (Function1) value$iv6, RowScope.weight$default($this$invoke_u24lambda_u2421_u24lambda_u2414, Modifier.INSTANCE, 1.0f, false, 2, null), ComposableLambdaKt.rememberComposableLambda(-536695597, true, new AddPantryItemDialogKt$AddPantryItemDialog$1$1$1$7$3(mutableState13, mutableState2), $composer, 54), $composer, 3120, 0);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            $composer.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            TextKt.m2714Text4IGK_g("Cantidad rápida:", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurfaceVariant(), TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 3078, 0, 131058);
                            Arrangement.HorizontalOrVertical horizontalOrVerticalM561spacedBy0680j_5 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(6));
                            Modifier modifierFillMaxWidth$default6 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                            $changed$iv = 54;
                            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                            Alignment.Vertical verticalAlignment$iv5 = Alignment.INSTANCE.getTop();
                            MeasurePolicy measurePolicy$iv7 = RowKt.rowMeasurePolicy(horizontalOrVerticalM561spacedBy0680j_5, verticalAlignment$iv5, $composer, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                            int $changed$iv$iv6 = (54 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                            compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                            CompositionLocalMap localMap$iv$iv6 = $composer.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer, modifierFillMaxWidth$default6);
                            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            int $i$f$Row2 = $changed$iv$iv6 << 6;
                            int $changed$iv$iv$iv6 = ($i$f$Row2 & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!($composer.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer.startReusableNode();
                            if ($composer.getInserting()) {
                                function2 = constructor2;
                                $composer.createNode(function2);
                            } else {
                                function2 = constructor2;
                                $composer.useNode();
                            }
                            $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3674constructorimpl($composer);
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                            }
                            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash6);
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv6, ComposeUiNode.INSTANCE.getSetModifier());
                            int i17 = ($changed$iv$iv$iv6 >> 6) & 14;
                            i = 0;
                            ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                            int i18 = ((54 >> 6) & 112) | 6;
                            $this$invoke_u24lambda_u2421_u24lambda_u2417 = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer, 493838299, "C:AddPantryItemDialog.kt#mq3b12");
                            $composer.startReplaceGroup(431572760);
                            ComposerKt.sourceInformation($composer, "*215@10171L231,220@10440L33,213@10070L429");
                            $this$forEach$iv = AddPantryItemDialogKt.QUICK_FRACTIONS;
                            $i$f$forEach = 0;
                            while (r32.hasNext()) {
                                Pair pair2 = (Pair) element$iv;
                                Iterable $this$forEach$iv3 = $this$forEach$iv;
                                final String label2 = (String) pair2.component1();
                                int $i$f$forEach3 = $i$f$forEach;
                                final float value2 = ((Number) pair2.component2()).floatValue();
                                int $changed$iv3 = $changed$iv;
                                boolean isSelected2 = Intrinsics.areEqual(PantryLocationEntityKt.parsePantryQty(AddPantryItemDialogKt.AddPantryItemDialog$lambda$7(mutableState)), value2);
                                int i19 = i;
                                $composer.startReplaceGroup(145525176);
                                ComposerKt.sourceInformation($composer, "CC(remember):AddPantryItemDialog.kt#9igjgp");
                                invalid$iv2 = $composer.changed(value2);
                                RowScope $this$invoke_u24lambda_u2421_u24lambda_u2419 = $this$invoke_u24lambda_u2421_u24lambda_u2417;
                                Object it$iv7 = $composer.rememberedValue();
                                if (invalid$iv2) {
                                }
                                value$iv8 = new Function0() { // from class: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$AddPantryItemDialog$1$1$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return AddPantryItemDialogKt.AnonymousClass1.C01681.invoke$lambda$21$lambda$17$lambda$16$lambda$15$lambda$14(value2, mutableState);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv8);
                                $composer.endReplaceGroup();
                                ChipKt.FilterChip(isSelected2, (Function0) value$iv8, ComposableLambdaKt.rememberComposableLambda(1433572346, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$AddPantryItemDialog$1$1$1$8$1$2
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                        invoke(composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer $composer2, int $changed2) {
                                        ComposerKt.sourceInformation($composer2, "C220@10442L29:AddPantryItemDialog.kt#mq3b12");
                                        if (($changed2 & 3) == 2 && $composer2.getSkipping()) {
                                            $composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1433572346, $changed2, -1, "com.easycompra.app.ui.pantry.AddPantryItemDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AddPantryItemDialog.kt:220)");
                                        }
                                        TextKt.m2714Text4IGK_g(label2, (Modifier) null, 0L, TextUnitKt.getSp(13), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 3072, 0, 131062);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, $composer, 54), null, false, null, null, null, null, null, null, null, $composer, 384, 0, 4088);
                                $this$forEach$iv = $this$forEach$iv3;
                                $i$f$forEach = $i$f$forEach3;
                                $changed$iv = $changed$iv3;
                                i = i19;
                                $this$invoke_u24lambda_u2421_u24lambda_u2417 = $this$invoke_u24lambda_u2421_u24lambda_u2419;
                            }
                            $composer.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            $composer.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            Modifier modifier$iv5 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                            Arrangement.Horizontal horizontalArrangement$iv4 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(8));
                            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                            Alignment.Vertical verticalAlignment$iv6 = Alignment.INSTANCE.getTop();
                            MeasurePolicy measurePolicy$iv8 = RowKt.rowMeasurePolicy(horizontalArrangement$iv4, verticalAlignment$iv6, $composer, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                            int $changed$iv$iv7 = (54 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                            compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                            CompositionLocalMap localMap$iv$iv7 = $composer.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv7 = ComposedModifierKt.materializeModifier($composer, modifier$iv5);
                            constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv7 = (($changed$iv$iv7 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!($composer.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer.startReusableNode();
                            if ($composer.getInserting()) {
                                $composer.createNode(constructor3);
                            } else {
                                $composer.useNode();
                            }
                            $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3674constructorimpl($composer);
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                                function3 = constructor3;
                                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                                }
                                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv7, ComposeUiNode.INSTANCE.getSetModifier());
                                int i110 = ($changed$iv$iv$iv7 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                                int i111 = ((54 >> 6) & 112) | 6;
                                RowScope $this$invoke_u24lambda_u2421_u24lambda_u2422 = RowScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart($composer, 494640052, "C229@10729L132,233@10924L332,232@10882L516:AddPantryItemDialog.kt#mq3b12");
                                ButtonKt.OutlinedButton(function4, RowScope.weight$default($this$invoke_u24lambda_u2421_u24lambda_u2422, Modifier.INSTANCE, 1.0f, false, 2, null), false, null, null, null, null, null, null, ComposableSingletons$AddPantryItemDialogKt.INSTANCE.m7111getLambda10$app_debug(), $composer, 805306368, 508);
                                $composer.startReplaceGroup(431604030);
                                ComposerKt.sourceInformation($composer, "CC(remember):AddPantryItemDialog.kt#9igjgp");
                                invalid$iv = $composer.changed(function6);
                                Object it$iv8 = $composer.rememberedValue();
                                if (invalid$iv) {
                                }
                                value$iv7 = new Function0() { // from class: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$AddPantryItemDialog$1$1$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return AddPantryItemDialogKt.AnonymousClass1.C01681.invoke$lambda$21$lambda$20$lambda$19$lambda$18(function6, mutableState3, mutableState4, mutableState, mutableState6, mutableState8, mutableState10, mutableState13);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv7);
                                r9.endReplaceGroup();
                                ButtonKt.Button((Function0) value$iv7, RowScope.weight$default($this$invoke_u24lambda_u2421_u24lambda_u2422, Modifier.INSTANCE, 1.0f, false, 2, null), false, null, null, null, null, null, null, ComposableSingletons$AddPantryItemDialogKt.INSTANCE.m7112getLambda11$app_debug(), r9, 805306368, 508);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                $composer.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                $composer.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            function3 = constructor3;
                            $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                            $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash7);
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv7, ComposeUiNode.INSTANCE.getSetModifier());
                            int i112 = ($changed$iv$iv$iv7 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                            int i113 = ((54 >> 6) & 112) | 6;
                            RowScope $this$invoke_u24lambda_u2421_u24lambda_u2423 = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer, 494640052, "C229@10729L132,233@10924L332,232@10882L516:AddPantryItemDialog.kt#mq3b12");
                            ButtonKt.OutlinedButton(function4, RowScope.weight$default($this$invoke_u24lambda_u2421_u24lambda_u2423, Modifier.INSTANCE, 1.0f, false, 2, null), false, null, null, null, null, null, null, ComposableSingletons$AddPantryItemDialogKt.INSTANCE.m7111getLambda10$app_debug(), $composer, 805306368, 508);
                            $composer.startReplaceGroup(431604030);
                            ComposerKt.sourceInformation($composer, "CC(remember):AddPantryItemDialog.kt#9igjgp");
                            invalid$iv = $composer.changed(function6);
                            Object it$iv9 = $composer.rememberedValue();
                            if (invalid$iv) {
                            }
                            value$iv7 = new Function0() { // from class: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$AddPantryItemDialog$1$1$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return AddPantryItemDialogKt.AnonymousClass1.C01681.invoke$lambda$21$lambda$20$lambda$19$lambda$18(function6, mutableState3, mutableState4, mutableState, mutableState6, mutableState8, mutableState10, mutableState13);
                                }
                            };
                            $composer.updateRememberedValue(value$iv7);
                            r9.endReplaceGroup();
                            ButtonKt.Button((Function0) value$iv7, RowScope.weight$default($this$invoke_u24lambda_u2421_u24lambda_u2423, Modifier.INSTANCE, 1.0f, false, 2, null), false, null, null, null, null, null, null, ComposableSingletons$AddPantryItemDialogKt.INSTANCE.m7112getLambda11$app_debug(), r9, 805306368, 508);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            $composer.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            $composer.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer.skipToGroupEnd();
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$21$lambda$1$lambda$0(MutableState $name$delegate, MutableState $nameError$delegate, String it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        AddPantryItemDialogKt.AddPantryItemDialog$lambda$2($name$delegate, it);
                        AddPantryItemDialogKt.AddPantryItemDialog$lambda$11($nameError$delegate, false);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$21$lambda$3$lambda$2(MutableState $catExpanded$delegate, boolean it) {
                        AddPantryItemDialogKt.AddPantryItemDialog$lambda$27($catExpanded$delegate, it);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$21$lambda$5$lambda$4(MutableState $subcatExpanded$delegate, boolean it) {
                        AddPantryItemDialogKt.AddPantryItemDialog$lambda$30($subcatExpanded$delegate, it);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$21$lambda$7$lambda$6(MutableState $description$delegate, String it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        AddPantryItemDialogKt.AddPantryItemDialog$lambda$5($description$delegate, it);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$21$lambda$13$lambda$10$lambda$9(MutableState $quantityText$delegate, String v) throws IOException {
                        Intrinsics.checkNotNullParameter(v, "v");
                        String $this$filterTo$iv$iv = v;
                        Appendable destination$iv$iv = new StringBuilder();
                        int length = $this$filterTo$iv$iv.length();
                        for (int index$iv$iv = 0; index$iv$iv < length; index$iv$iv++) {
                            char element$iv$iv = $this$filterTo$iv$iv.charAt(index$iv$iv);
                            if (Character.isDigit(element$iv$iv) || element$iv$iv == '.' || element$iv$iv == '/') {
                                destination$iv$iv.append(element$iv$iv);
                            }
                        }
                        String string = ((StringBuilder) destination$iv$iv).toString();
                        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                        AddPantryItemDialogKt.AddPantryItemDialog$lambda$8($quantityText$delegate, string);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$21$lambda$13$lambda$12$lambda$11(MutableState $unitExpanded$delegate, boolean it) {
                        AddPantryItemDialogKt.AddPantryItemDialog$lambda$33($unitExpanded$delegate, it);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$21$lambda$17$lambda$16$lambda$15$lambda$14(float $value, MutableState $quantityText$delegate) {
                        String strValueOf;
                        if ($value == ((float) ((int) $value))) {
                            strValueOf = String.valueOf((int) $value);
                        } else {
                            strValueOf = String.valueOf($value);
                        }
                        AddPantryItemDialogKt.AddPantryItemDialog$lambda$8($quantityText$delegate, strValueOf);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$21$lambda$20$lambda$19$lambda$18(Function6 $onConfirm, MutableState $name$delegate, MutableState $nameError$delegate, MutableState $quantityText$delegate, MutableState $selectedCategory$delegate, MutableState $selectedSubcategory$delegate, MutableState $description$delegate, MutableState $selectedUnit$delegate) {
                        if (StringsKt.isBlank(AddPantryItemDialogKt.AddPantryItemDialog$lambda$1($name$delegate))) {
                            AddPantryItemDialogKt.AddPantryItemDialog$lambda$11($nameError$delegate, true);
                            return Unit.INSTANCE;
                        }
                        Float pantryQty = PantryLocationEntityKt.parsePantryQty(AddPantryItemDialogKt.AddPantryItemDialog$lambda$7($quantityText$delegate));
                        float qty = pantryQty != null ? RangesKt.coerceAtLeast(pantryQty.floatValue(), 0.0f) : 1.0f;
                        $onConfirm.invoke(StringsKt.trim((CharSequence) AddPantryItemDialogKt.AddPantryItemDialog$lambda$1($name$delegate)).toString(), AddPantryItemDialogKt.AddPantryItemDialog$lambda$14($selectedCategory$delegate), AddPantryItemDialogKt.AddPantryItemDialog$lambda$20($selectedSubcategory$delegate), StringsKt.trim((CharSequence) AddPantryItemDialogKt.AddPantryItemDialog$lambda$4($description$delegate)).toString(), Float.valueOf(qty), AddPantryItemDialogKt.AddPantryItemDialog$lambda$23($selectedUnit$delegate));
                        return Unit.INSTANCE;
                    }
                }
            }, $composer2, 54), $composer2, ($dirty2 & 14) | 384, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.pantry.AddPantryItemDialogKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AddPantryItemDialogKt.AddPantryItemDialog$lambda$34(onDismiss, onConfirm, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AddPantryItemDialog$lambda$1(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AddPantryItemDialog$lambda$2(MutableState<String> mutableState, String str) {
        mutableState.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AddPantryItemDialog$lambda$4(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AddPantryItemDialog$lambda$5(MutableState<String> mutableState, String str) {
        mutableState.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AddPantryItemDialog$lambda$7(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AddPantryItemDialog$lambda$8(MutableState<String> mutableState, String str) {
        mutableState.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean AddPantryItemDialog$lambda$10(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AddPantryItemDialog$lambda$11(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AddPantryItemDialog$lambda$14(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<String> AddPantryItemDialog$lambda$17(MutableState<List<String>> mutableState) {
        MutableState<List<String>> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AddPantryItemDialog$lambda$20(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AddPantryItemDialog$lambda$23(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean AddPantryItemDialog$lambda$26(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AddPantryItemDialog$lambda$27(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean AddPantryItemDialog$lambda$29(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AddPantryItemDialog$lambda$30(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean AddPantryItemDialog$lambda$32(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AddPantryItemDialog$lambda$33(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }
}
