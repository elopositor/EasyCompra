package com.easycompra.app.ui.planner;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.ClickableKt;
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
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.SliderKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.easycompra.app.data.planner.MealSlots;
import com.easycompra.app.data.planner.PlannerEntry;
import com.easycompra.app.data.recipes.RecipeEntity;
import com.easycompra.app.data.recipes.RecipeWithDetails;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: PlannerEntryDialog.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a§\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\u008d\u0001\u0010\f\u001a\u0088\u0001\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0004\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u001626\u0010\u0017\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00010\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016H\u0007¢\u0006\u0002\u0010\u001c\u001a+\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016H\u0003¢\u0006\u0002\u0010\"\u001a=\u0010#\u001a\u00020\u00012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010&2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016H\u0003¢\u0006\u0002\u0010'\u001aS\u0010(\u001a\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\u0006\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00032\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016H\u0003¢\u0006\u0002\u0010+\u001a\u0010\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0012H\u0002¨\u0006.²\u0006\n\u0010/\u001a\u00020 X\u008a\u008e\u0002²\u0006\f\u00100\u001a\u0004\u0018\u00010\tX\u008a\u008e\u0002²\u0006\n\u00101\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010\u0013\u001a\u00020\u0012X\u008a\u008e\u0002²\u0006\n\u0010\u0014\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u00102\u001a\u00020 X\u008a\u008e\u0002²\u0006\n\u00103\u001a\u00020 X\u008a\u008e\u0002²\u0006\n\u00104\u001a\u00020\u0003X\u008a\u008e\u0002"}, d2 = {"PlannerEntryDialog", "", "date", "", "slot", "existing", "Lcom/easycompra/app/data/planner/PlannerEntry;", "allRecipes", "", "Lcom/easycompra/app/data/recipes/RecipeWithDetails;", "weekDates", "Ljava/time/LocalDate;", "onSave", "Lkotlin/Function6;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "recipeId", "displayName", "", "servings", "notes", "onClear", "Lkotlin/Function0;", "onMove", "Lkotlin/Function2;", "newDate", "newSlot", "onDismiss", "(Ljava/lang/String;Ljava/lang/String;Lcom/easycompra/app/data/planner/PlannerEntry;Ljava/util/List;Ljava/util/List;Lkotlin/jvm/functions/Function6;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "FilterButton", "label", "selected", "", "onClick", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "RecipePickerDialog", "recipes", "onSelect", "Lkotlin/Function1;", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "MoveEntryDialog", "currentDate", "currentSlot", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "formatServings", "v", "app_debug", "useRecipe", "selectedRecipe", "customText", "showRecipePicker", "showMover", "query"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PlannerEntryDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilterButton$lambda$35(String str, boolean z, Function0 function0, int i, Composer composer, int i2) {
        FilterButton(str, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MoveEntryDialog$lambda$42(List list, String str, String str2, Function2 function2, Function0 function0, int i, Composer composer, int i2) {
        MoveEntryDialog(list, str, str2, function2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlannerEntryDialog$lambda$28(String str, String str2, PlannerEntry plannerEntry, List list, List list2, Function6 function6, Function0 function0, Function2 function2, Function0 function1, int i, Composer composer, int i2) {
        PlannerEntryDialog(str, str2, plannerEntry, list, list2, function6, function0, function2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlannerEntryDialog$lambda$33(String str, String str2, PlannerEntry plannerEntry, List list, List list2, Function6 function6, Function0 function0, Function2 function2, Function0 function1, int i, Composer composer, int i2) {
        PlannerEntryDialog(str, str2, plannerEntry, list, list2, function6, function0, function2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlannerEntryDialog$lambda$34(String str, String str2, PlannerEntry plannerEntry, List list, List list2, Function6 function6, Function0 function0, Function2 function2, Function0 function1, int i, Composer composer, int i2) {
        PlannerEntryDialog(str, str2, plannerEntry, list, list2, function6, function0, function2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecipePickerDialog$lambda$41(List list, Function1 function1, Function0 function0, int i, Composer composer, int i2) {
        RecipePickerDialog(list, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void PlannerEntryDialog(final String date, final String slot, final PlannerEntry existing, final List<RecipeWithDetails> allRecipes, final List<LocalDate> weekDates, final Function6<? super String, ? super String, ? super String, ? super String, ? super Float, ? super String, Unit> onSave, final Function0<Unit> onClear, final Function2<? super String, ? super String, Unit> onMove, final Function0<Unit> onDismiss, Composer $composer, final int $changed) {
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        Object value$iv4;
        Object value$iv5;
        Object value$iv6;
        Object value$iv7;
        Composer $composer2;
        Object value$iv8;
        final MutableState showMover$delegate;
        Object value$iv9;
        String notes;
        String displayName;
        Object obj;
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(allRecipes, "allRecipes");
        Intrinsics.checkNotNullParameter(weekDates, "weekDates");
        Intrinsics.checkNotNullParameter(onSave, "onSave");
        Intrinsics.checkNotNullParameter(onClear, "onClear");
        Intrinsics.checkNotNullParameter(onMove, "onMove");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer $composer3 = $composer.startRestartGroup(-1557250956);
        ComposerKt.sourceInformation($composer3, "C(PlannerEntryDialog)P(1,7,2!1,8,6!1,5)66@2809L235,72@3067L55,73@3149L95,76@3267L96,77@3384L58,78@3460L50,79@3539L34,80@3595L34,106@4356L5734,106@4319L5771:PlannerEntryDialog.kt#auin6u");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(date) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(slot) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(existing) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(allRecipes) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changedInstance(weekDates) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(onSave) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(onClear) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(onMove) ? 8388608 : 4194304;
        }
        if ((100663296 & $changed) == 0) {
            $dirty |= $composer3.changedInstance(onDismiss) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int $dirty2 = $dirty;
        if ((38347923 & $dirty2) != 38347922 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1557250956, $dirty2, -1, "com.easycompra.app.ui.planner.PlannerEntryDialog (PlannerEntryDialog.kt:65)");
            }
            $composer3.startReplaceGroup(-1781028261);
            ComposerKt.sourceInformation($composer3, "CC(remember):PlannerEntryDialog.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 14) == 4;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                LocalDate ld = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
                String displayName2 = ld.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("es"));
                Intrinsics.checkNotNullExpressionValue(displayName2, "getDisplayName(...)");
                if (displayName2.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    char it = displayName2.charAt(0);
                    String strValueOf = String.valueOf(it);
                    Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
                    String upperCase = strValueOf.toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    StringBuilder sbAppend = sb.append((Object) upperCase);
                    String strSubstring = displayName2.substring(1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    displayName2 = sbAppend.append(strSubstring).toString();
                }
                value$iv = displayName2 + " " + ld.getDayOfMonth();
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final String dateLabel = (String) value$iv;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-1781020185);
            ComposerKt.sourceInformation($composer3, "CC(remember):PlannerEntryDialog.kt#9igjgp");
            Object it$iv2 = $composer3.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf((existing != null ? existing.getRecipeId() : null) != null), null, 2, null);
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            final MutableState useRecipe$delegate = (MutableState) value$iv2;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-1781017521);
            ComposerKt.sourceInformation($composer3, "CC(remember):PlannerEntryDialog.kt#9igjgp");
            int $i$f$cache = 0;
            Object it$iv3 = $composer3.rememberedValue();
            if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                int i = 0;
                Iterator<T> it2 = allRecipes.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    Object next = it2.next();
                    RecipeWithDetails it3 = (RecipeWithDetails) next;
                    int i2 = i;
                    if (Intrinsics.areEqual(it3.getRecipe().getId(), existing != null ? existing.getRecipeId() : null)) {
                        obj = next;
                        break;
                    } else {
                        $i$f$cache = $i$f$cache;
                        i = i2;
                    }
                }
                value$iv3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(obj, null, 2, null);
                $composer3.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            final MutableState selectedRecipe$delegate = (MutableState) value$iv3;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-1781013744);
            ComposerKt.sourceInformation($composer3, "CC(remember):PlannerEntryDialog.kt#9igjgp");
            Object it$iv4 = $composer3.rememberedValue();
            if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(((existing != null ? existing.getRecipeId() : null) != null || existing == null || (displayName = existing.getDisplayName()) == null) ? "" : displayName, null, 2, null);
                $composer3.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv4;
            }
            final MutableState customText$delegate = (MutableState) value$iv4;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-1781010038);
            ComposerKt.sourceInformation($composer3, "CC(remember):PlannerEntryDialog.kt#9igjgp");
            Object it$iv5 = $composer3.rememberedValue();
            if (it$iv5 == Composer.INSTANCE.getEmpty()) {
                value$iv5 = PrimitiveSnapshotStateKt.mutableFloatStateOf(existing != null ? existing.getServings() : 1.0f);
                $composer3.updateRememberedValue(value$iv5);
            } else {
                value$iv5 = it$iv5;
            }
            final MutableFloatState servings$delegate = (MutableFloatState) value$iv5;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-1781007614);
            ComposerKt.sourceInformation($composer3, "CC(remember):PlannerEntryDialog.kt#9igjgp");
            Object it$iv6 = $composer3.rememberedValue();
            if (it$iv6 == Composer.INSTANCE.getEmpty()) {
                value$iv6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((existing == null || (notes = existing.getNotes()) == null) ? "" : notes, null, 2, null);
                $composer3.updateRememberedValue(value$iv6);
            } else {
                value$iv6 = it$iv6;
            }
            final MutableState notes$delegate = (MutableState) value$iv6;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-1781005102);
            ComposerKt.sourceInformation($composer3, "CC(remember):PlannerEntryDialog.kt#9igjgp");
            Object it$iv7 = $composer3.rememberedValue();
            if (it$iv7 == Composer.INSTANCE.getEmpty()) {
                value$iv7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv7);
            } else {
                value$iv7 = it$iv7;
            }
            final MutableState showRecipePicker$delegate = (MutableState) value$iv7;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-1781003310);
            ComposerKt.sourceInformation($composer3, "CC(remember):PlannerEntryDialog.kt#9igjgp");
            Object value$iv10 = $composer3.rememberedValue();
            if (value$iv10 == Composer.INSTANCE.getEmpty()) {
                value$iv10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv10);
            }
            final MutableState showMover$delegate2 = (MutableState) value$iv10;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-1781001700);
            ComposerKt.sourceInformation($composer3, "85@3744L170,90@3940L28,83@3667L311");
            if (PlannerEntryDialog$lambda$19(showRecipePicker$delegate)) {
                $composer3.startReplaceGroup(-1780998406);
                ComposerKt.sourceInformation($composer3, "CC(remember):PlannerEntryDialog.kt#9igjgp");
                Object value$iv11 = $composer3.rememberedValue();
                if (value$iv11 == Composer.INSTANCE.getEmpty()) {
                    value$iv11 = new Function1() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return PlannerEntryDialogKt.PlannerEntryDialog$lambda$25$lambda$24(selectedRecipe$delegate, servings$delegate, showRecipePicker$delegate, (RecipeWithDetails) obj2);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv11);
                }
                Function1 function1 = (Function1) value$iv11;
                $composer3.endReplaceGroup();
                $composer3.startReplaceGroup(-1780992276);
                ComposerKt.sourceInformation($composer3, "CC(remember):PlannerEntryDialog.kt#9igjgp");
                Object value$iv12 = $composer3.rememberedValue();
                if (value$iv12 == Composer.INSTANCE.getEmpty()) {
                    value$iv12 = new Function0() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PlannerEntryDialogKt.PlannerEntryDialog$lambda$27$lambda$26(showRecipePicker$delegate);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv12);
                }
                $composer3.endReplaceGroup();
                RecipePickerDialog(allRecipes, function1, (Function0) value$iv12, $composer3, (($dirty2 >> 9) & 14) | 432);
                $composer3.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return PlannerEntryDialogKt.PlannerEntryDialog$lambda$28(date, slot, existing, allRecipes, weekDates, onSave, onClear, onMove, onDismiss, $changed, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-1780989916);
            ComposerKt.sourceInformation($composer3, "100@4187L48,101@4261L21,96@4050L242");
            if (PlannerEntryDialog$lambda$22(showMover$delegate2) && existing != null) {
                $composer3.startReplaceGroup(-1780984352);
                ComposerKt.sourceInformation($composer3, "CC(remember):PlannerEntryDialog.kt#9igjgp");
                boolean invalid$iv2 = ($dirty2 & 29360128) == 8388608;
                Object it$iv8 = $composer3.rememberedValue();
                if (invalid$iv2 || it$iv8 == Composer.INSTANCE.getEmpty()) {
                    value$iv8 = new Function2() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return PlannerEntryDialogKt.PlannerEntryDialog$lambda$30$lambda$29(onMove, (String) obj2, (String) obj3);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv8);
                } else {
                    value$iv8 = it$iv8;
                }
                Function2 function2 = (Function2) value$iv8;
                $composer3.endReplaceGroup();
                $composer3.startReplaceGroup(-1780982011);
                ComposerKt.sourceInformation($composer3, "CC(remember):PlannerEntryDialog.kt#9igjgp");
                Object it$iv9 = $composer3.rememberedValue();
                if (it$iv9 == Composer.INSTANCE.getEmpty()) {
                    showMover$delegate = showMover$delegate2;
                    value$iv9 = new Function0() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PlannerEntryDialogKt.PlannerEntryDialog$lambda$32$lambda$31(showMover$delegate);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv9);
                } else {
                    showMover$delegate = showMover$delegate2;
                    value$iv9 = it$iv9;
                }
                $composer3.endReplaceGroup();
                MoveEntryDialog(weekDates, date, slot, function2, (Function0) value$iv9, $composer3, (($dirty2 >> 12) & 14) | 24576 | (($dirty2 << 3) & 112) | (($dirty2 << 3) & 896));
                $composer3.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = $composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup2 != null) {
                    scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return PlannerEntryDialogKt.PlannerEntryDialog$lambda$33(date, slot, existing, allRecipes, weekDates, onSave, onClear, onMove, onDismiss, $changed, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            $composer3.endReplaceGroup();
            $composer2 = $composer3;
            AndroidDialog_androidKt.Dialog(onDismiss, null, ComposableLambdaKt.rememberComposableLambda(-783470581, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt.PlannerEntryDialog.7
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C109@4495L11,109@4453L62,111@4574L5510,107@4366L5718:PlannerEntryDialog.kt#auin6u");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-783470581, $changed2, -1, "com.easycompra.app.ui.planner.PlannerEntryDialog.<anonymous> (PlannerEntryDialog.kt:107)");
                        }
                        CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m964RoundedCornerShape0680j_4(Dp.m6663constructorimpl(16)), CardDefaults.INSTANCE.m1850cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getSurface(), 0L, 0L, 0L, $composer4, CardDefaults.$stable << 12, 14), null, null, ComposableLambdaKt.rememberComposableLambda(1766096509, true, new AnonymousClass1(existing, slot, dateLabel, useRecipe$delegate, showRecipePicker$delegate, selectedRecipe$delegate, servings$delegate, customText$delegate, notes$delegate, onClear, showMover$delegate2, onDismiss, onSave, date), $composer4, 54), $composer4, 196614, 24);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }

                /* JADX INFO: renamed from: com.easycompra.app.ui.planner.PlannerEntryDialogKt$PlannerEntryDialog$7$1, reason: invalid class name */
                /* JADX INFO: compiled from: PlannerEntryDialog.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                static final class AnonymousClass1 implements Function3<ColumnScope, Composer, Integer, Unit> {
                    final /* synthetic */ MutableState<String> $customText$delegate;
                    final /* synthetic */ String $date;
                    final /* synthetic */ String $dateLabel;
                    final /* synthetic */ PlannerEntry $existing;
                    final /* synthetic */ MutableState<String> $notes$delegate;
                    final /* synthetic */ Function0<Unit> $onClear;
                    final /* synthetic */ Function0<Unit> $onDismiss;
                    final /* synthetic */ Function6<String, String, String, String, Float, String, Unit> $onSave;
                    final /* synthetic */ MutableState<RecipeWithDetails> $selectedRecipe$delegate;
                    final /* synthetic */ MutableFloatState $servings$delegate;
                    final /* synthetic */ MutableState<Boolean> $showMover$delegate;
                    final /* synthetic */ MutableState<Boolean> $showRecipePicker$delegate;
                    final /* synthetic */ String $slot;
                    final /* synthetic */ MutableState<Boolean> $useRecipe$delegate;

                    /* JADX WARN: Multi-variable type inference failed */
                    AnonymousClass1(PlannerEntry plannerEntry, String str, String str2, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, MutableState<RecipeWithDetails> mutableState3, MutableFloatState mutableFloatState, MutableState<String> mutableState4, MutableState<String> mutableState5, Function0<Unit> function0, MutableState<Boolean> mutableState6, Function0<Unit> function1, Function6<? super String, ? super String, ? super String, ? super String, ? super Float, ? super String, Unit> function6, String str3) {
                        this.$existing = plannerEntry;
                        this.$slot = str;
                        this.$dateLabel = str2;
                        this.$useRecipe$delegate = mutableState;
                        this.$showRecipePicker$delegate = mutableState2;
                        this.$selectedRecipe$delegate = mutableState3;
                        this.$servings$delegate = mutableFloatState;
                        this.$customText$delegate = mutableState4;
                        this.$notes$delegate = mutableState5;
                        this.$onClear = function0;
                        this.$showMover$delegate = mutableState6;
                        this.$onDismiss = function1;
                        this.$onSave = function6;
                        this.$date = str3;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                        invoke(columnScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Code duplicated, block: B:108:0x0990  */
                    /* JADX WARN: Code duplicated, block: B:109:0x09a2  */
                    /* JADX WARN: Code duplicated, block: B:111:0x09e6  */
                    /* JADX WARN: Code duplicated, block: B:113:0x09f1  */
                    /* JADX WARN: Code duplicated, block: B:115:0x0a46  */
                    /* JADX WARN: Code duplicated, block: B:116:0x0a58  */
                    /* JADX WARN: Code duplicated, block: B:120:0x0ad5  */
                    /* JADX WARN: Code duplicated, block: B:121:0x0ae3  */
                    /* JADX WARN: Code duplicated, block: B:124:0x0b3a  */
                    /* JADX WARN: Code duplicated, block: B:126:0x0bb5  */
                    /* JADX WARN: Code duplicated, block: B:129:0x0bc1  */
                    /* JADX WARN: Code duplicated, block: B:130:0x0bc7  */
                    /* JADX WARN: Code duplicated, block: B:141:0x0c7c  */
                    /* JADX WARN: Code duplicated, block: B:142:0x0c8e  */
                    /* JADX WARN: Code duplicated, block: B:144:0x0d07  */
                    /* JADX WARN: Code duplicated, block: B:147:0x0d80  */
                    /* JADX WARN: Code duplicated, block: B:150:0x0d8c  */
                    /* JADX WARN: Code duplicated, block: B:151:0x0d90  */
                    /* JADX WARN: Code duplicated, block: B:179:0x0f4b  */
                    /* JADX WARN: Code duplicated, block: B:182:? A[RETURN, SYNTHETIC] */
                    /* JADX WARN: Code duplicated, block: B:58:0x059e  */
                    /* JADX WARN: Code duplicated, block: B:61:0x05aa  */
                    /* JADX WARN: Code duplicated, block: B:62:0x05b0  */
                    /* JADX WARN: Code duplicated, block: B:73:0x066e  */
                    /* JADX WARN: Code duplicated, block: B:74:0x0682  */
                    /* JADX WARN: Code duplicated, block: B:77:0x06be  */
                    /* JADX WARN: Code duplicated, block: B:78:0x06cc  */
                    /* JADX WARN: Code duplicated, block: B:81:0x06fb  */
                    /* JADX WARN: Code duplicated, block: B:83:0x0729  */
                    /* JADX WARN: Code duplicated, block: B:84:0x073b  */
                    /* JADX WARN: Code duplicated, block: B:87:0x0760  */
                    /* JADX WARN: Code duplicated, block: B:88:0x078e  */
                    /* JADX WARN: Code duplicated, block: B:91:0x07e6  */
                    /* JADX WARN: Code duplicated, block: B:93:0x0850  */
                    /* JADX WARN: Code duplicated, block: B:96:0x085c  */
                    /* JADX WARN: Code duplicated, block: B:97:0x0862  */
                    public final void invoke(ColumnScope Card, Composer $composer, int $changed) {
                        Function0<ComposeUiNode> function0;
                        Function0<ComposeUiNode> function1;
                        Function0<ComposeUiNode> function2;
                        Function0<ComposeUiNode> function3;
                        int compositeKeyHash$iv$iv;
                        Function0<ComposeUiNode> constructor;
                        Function0<ComposeUiNode> function4;
                        Composer $this$Layout_u24lambda_u240$iv$iv;
                        Object value$iv;
                        final MutableState<Boolean> mutableState;
                        Object value$iv2;
                        final MutableFloatState mutableFloatState;
                        Object it$iv;
                        final MutableState<String> mutableState2;
                        Object value$iv3;
                        Object it$iv2;
                        Object value$iv4;
                        int compositeKeyHash$iv$iv2;
                        Function0<ComposeUiNode> constructor2;
                        Composer $this$Layout_u24lambda_u240$iv$iv2;
                        boolean invalid$iv;
                        Object value$iv5;
                        boolean z;
                        boolean z2;
                        int compositeKeyHash$iv$iv3;
                        Function0<ComposeUiNode> constructor3;
                        Function0<ComposeUiNode> function5;
                        Composer $this$Layout_u24lambda_u240$iv$iv3;
                        Object value$iv6;
                        Object it$iv3;
                        Object value$iv7;
                        long j;
                        int compositeKeyHash$iv$iv4;
                        Function0<ComposeUiNode> constructor4;
                        Function0<ComposeUiNode> function6;
                        Composer $this$Layout_u24lambda_u240$iv$iv4;
                        Object it$iv4;
                        Object value$iv8;
                        Intrinsics.checkNotNullParameter(Card, "$this$Card");
                        ComposerKt.sourceInformation($composer, "C115@4704L21,112@4588L5486:PlannerEntryDialog.kt#auin6u");
                        if (($changed & 17) == 16 && $composer.getSkipping()) {
                            $composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1766096509, $changed, -1, "com.easycompra.app.ui.planner.PlannerEntryDialog.<anonymous>.<anonymous> (PlannerEntryDialog.kt:112)");
                        }
                        Modifier modifier$iv = ScrollKt.verticalScroll$default(PaddingKt.m681padding3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(20)), ScrollKt.rememberScrollState(0, $composer, 0, 1), false, null, false, 14, null);
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(12));
                        PlannerEntry plannerEntry = this.$existing;
                        final String str = this.$slot;
                        String str2 = this.$dateLabel;
                        MutableState<Boolean> mutableState3 = this.$useRecipe$delegate;
                        final MutableState<Boolean> mutableState4 = this.$showRecipePicker$delegate;
                        final MutableState<RecipeWithDetails> mutableState5 = this.$selectedRecipe$delegate;
                        MutableFloatState mutableFloatState2 = this.$servings$delegate;
                        MutableState<String> mutableState6 = this.$customText$delegate;
                        final MutableState<String> mutableState7 = this.$notes$delegate;
                        Function0<Unit> function7 = this.$onClear;
                        final MutableState<Boolean> mutableState8 = this.$showMover$delegate;
                        Function0<Unit> function8 = this.$onDismiss;
                        final Function6<String, String, String, String, Float, String, Unit> function9 = this.$onSave;
                        final String str3 = this.$date;
                        ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                        int $changed$iv$iv = (48 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv5 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                        CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
                        Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer.startReusableNode();
                        if ($composer.getInserting()) {
                            function0 = constructor5;
                            $composer.createNode(function0);
                        } else {
                            function0 = constructor5;
                            $composer.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.m3674constructorimpl($composer);
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv5.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv5.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv5))) {
                            $this$Layout_u24lambda_u240$iv$iv5.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv5));
                            $this$Layout_u24lambda_u240$iv$iv5.apply(Integer.valueOf(compositeKeyHash$iv$iv5), setCompositeKeyHash);
                        }
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i2 = ((48 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, -1960071938, "C119@4852L427,128@5297L19,131@5380L243,183@7904L14,181@7814L354,211@9089L971:PlannerEntryDialog.kt#auin6u");
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                        Modifier modifier$iv2 = Modifier.INSTANCE;
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        int $changed$iv$iv$iv2 = ((384 >> 3) & 14) | ((384 >> 3) & 112);
                        MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, $changed$iv$iv$iv2);
                        int $changed$iv$iv2 = (384 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv6 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                        CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
                        Function0<ComposeUiNode> constructor6 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv3 = (($changed$iv$iv2 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer.startReusableNode();
                        if ($composer.getInserting()) {
                            function1 = constructor6;
                            $composer.createNode(function1);
                        } else {
                            function1 = constructor6;
                            $composer.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv6 = Updater.m3674constructorimpl($composer);
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv6, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv6, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv6.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv6.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv6))) {
                            $this$Layout_u24lambda_u240$iv$iv6.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv6));
                            $this$Layout_u24lambda_u240$iv$iv6.apply(Integer.valueOf(compositeKeyHash$iv$iv6), setCompositeKeyHash2);
                        }
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv6, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                        int i3 = ($changed$iv$iv$iv3 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        int i4 = ((384 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, 1927403272, "C120@4926L44,121@4991L30,122@5042L219:PlannerEntryDialog.kt#auin6u");
                        TextKt.m2714Text4IGK_g(MealSlots.INSTANCE.icon(str), (Modifier) null, 0L, TextUnitKt.getSp(20), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (androidx.compose.ui.text.TextStyle) null, $composer, 3072, 0, 131062);
                        SpacerKt.Spacer(PaddingKt.m681padding3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(4)), $composer, 6);
                        ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                        Modifier modifier$iv3 = Modifier.INSTANCE;
                        Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getStart();
                        int $i$f$Column = ((0 >> 3) & 14) | ((0 >> 3) & 112);
                        MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer, $i$f$Column);
                        int $changed$iv$iv3 = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv7 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                        CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
                        Function0<ComposeUiNode> constructor7 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv = $changed$iv$iv3 << 6;
                        int $changed$iv$iv$iv4 = ($changed$iv & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer.startReusableNode();
                        if ($composer.getInserting()) {
                            function2 = constructor7;
                            $composer.createNode(function2);
                        } else {
                            function2 = constructor7;
                            $composer.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv7 = Updater.m3674constructorimpl($composer);
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv7, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv7, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!$this$Layout_u24lambda_u240$iv$iv7.getInserting()) {
                            function3 = function2;
                            if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv7.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv7))) {
                            }
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv7, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                            int i5 = ($changed$iv$iv$iv4 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                            int i6 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer, 1828934548, "C123@5138L10,123@5075L86,124@5186L53:PlannerEntryDialog.kt#auin6u");
                            TextKt.m2714Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getTitleMedium(), $composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 65502);
                            TextKt.m2714Text4IGK_g(str2, (Modifier) null, Color.INSTANCE.m4211getGray0d7_KjU(), TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (androidx.compose.ui.text.TextStyle) null, $composer, 3456, 0, 131058);
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
                            DividerKt.m2093HorizontalDivider9IZ8Weo(null, 0.0f, 0L, $composer, 0, 7);
                            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(8));
                            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                            Modifier modifier$iv4 = Modifier.INSTANCE;
                            Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getTop();
                            MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                            int $changed$iv$iv4 = (48 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                            compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                            CompositionLocalMap localMap$iv$iv4 = $composer.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer, modifier$iv4);
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv5 = (($changed$iv$iv4 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!($composer.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer.startReusableNode();
                            if ($composer.getInserting()) {
                                function4 = constructor;
                                $composer.createNode(function4);
                            } else {
                                function4 = constructor;
                                $composer.useNode();
                            }
                            $this$Layout_u24lambda_u240$iv$iv = Updater.m3674constructorimpl($composer);
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!$this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash4);
                            }
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                            int i7 = ($changed$iv$iv$iv5 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                            int i8 = ((48 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer, 1927925188, "C132@5501L20,132@5458L63,133@5584L21,133@5542L63:PlannerEntryDialog.kt#auin6u");
                            boolean zPlannerEntryDialog$lambda$3 = PlannerEntryDialogKt.PlannerEntryDialog$lambda$3(mutableState3);
                            $composer.startReplaceGroup(62192384);
                            ComposerKt.sourceInformation($composer, "CC(remember):PlannerEntryDialog.kt#9igjgp");
                            value$iv = $composer.rememberedValue();
                            if (value$iv == Composer.INSTANCE.getEmpty()) {
                                mutableState = mutableState3;
                                value$iv = new Function0() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$PlannerEntryDialog$7$1$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return PlannerEntryDialogKt.AnonymousClass7.AnonymousClass1.invoke$lambda$23$lambda$6$lambda$3$lambda$2(mutableState);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv);
                            } else {
                                mutableState = mutableState3;
                            }
                            $composer.endReplaceGroup();
                            PlannerEntryDialogKt.FilterButton("Receta guardada", zPlannerEntryDialog$lambda$3, (Function0) value$iv, $composer, 390);
                            boolean z3 = !PlannerEntryDialogKt.PlannerEntryDialog$lambda$3(mutableState);
                            $composer.startReplaceGroup(62195041);
                            ComposerKt.sourceInformation($composer, "CC(remember):PlannerEntryDialog.kt#9igjgp");
                            value$iv2 = $composer.rememberedValue();
                            if (value$iv2 == Composer.INSTANCE.getEmpty()) {
                                value$iv2 = new Function0() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$PlannerEntryDialog$7$1$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return PlannerEntryDialogKt.AnonymousClass7.AnonymousClass1.invoke$lambda$23$lambda$6$lambda$5$lambda$4(mutableState);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv2);
                            }
                            $composer.endReplaceGroup();
                            PlannerEntryDialogKt.FilterButton("Personalizado", z3, (Function0) value$iv2, $composer, 390);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            $composer.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            if (PlannerEntryDialogKt.PlannerEntryDialog$lambda$3(mutableState)) {
                                $composer.startReplaceGroup(-1959386219);
                                ComposerKt.sourceInformation($composer, "141@5851L27,142@5926L270,147@6219L350,138@5718L851,156@6645L571");
                                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                $composer.startReplaceGroup(75345992);
                                ComposerKt.sourceInformation($composer, "CC(remember):PlannerEntryDialog.kt#9igjgp");
                                it$iv3 = $composer.rememberedValue();
                                if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                                    value$iv7 = new Function0() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$PlannerEntryDialog$7$1$$ExternalSyntheticLambda2
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return PlannerEntryDialogKt.AnonymousClass7.AnonymousClass1.invoke$lambda$23$lambda$8$lambda$7(mutableState4);
                                        }
                                    };
                                    $composer.updateRememberedValue(value$iv7);
                                } else {
                                    value$iv7 = it$iv3;
                                }
                                $composer.endReplaceGroup();
                                Modifier modifierM269clickableXHw0xAI$default = ClickableKt.m269clickableXHw0xAI$default(modifierFillMaxWidth$default, false, null, null, (Function0) value$iv7, 7, null);
                                CardDefaults cardDefaults = CardDefaults.INSTANCE;
                                if (PlannerEntryDialogKt.PlannerEntryDialog$lambda$7(mutableState5) != null) {
                                    $composer.startReplaceGroup(75353495);
                                    ComposerKt.sourceInformation($composer, "144@6057L11");
                                    long primaryContainer = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimaryContainer();
                                    long jM4179copywmQWz5c = Color.m4179copywmQWz5c(primaryContainer, (14 & 1) != 0 ? Color.m4183getAlphaimpl(primaryContainer) : 0.4f, (14 & 2) != 0 ? Color.m4187getRedimpl(primaryContainer) : 0.0f, (14 & 4) != 0 ? Color.m4186getGreenimpl(primaryContainer) : 0.0f, (14 & 8) != 0 ? Color.m4184getBlueimpl(primaryContainer) : 0.0f);
                                    $composer.endReplaceGroup();
                                    j = jM4179copywmQWz5c;
                                } else {
                                    $composer.startReplaceGroup(75355739);
                                    ComposerKt.sourceInformation($composer, "145@6144L11");
                                    long surfaceVariant = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceVariant();
                                    $composer.endReplaceGroup();
                                    j = surfaceVariant;
                                }
                                CardKt.Card(modifierM269clickableXHw0xAI$default, null, cardDefaults.m1850cardColorsro_MJ88(j, 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14), null, null, ComposableLambdaKt.rememberComposableLambda(-1129765632, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$PlannerEntryDialog$7$1$1$4
                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                                        invoke(columnScope, composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(ColumnScope Card2, Composer $composer2, int $changed2) {
                                        String name;
                                        RecipeEntity recipe;
                                        Intrinsics.checkNotNullParameter(Card2, "$this$Card");
                                        ComposerKt.sourceInformation($composer2, "C148@6245L302:PlannerEntryDialog.kt#auin6u");
                                        if (($changed2 & 17) != 16 || !$composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1129765632, $changed2, -1, "com.easycompra.app.ui.planner.PlannerEntryDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PlannerEntryDialog.kt:148)");
                                            }
                                            RecipeWithDetails recipeWithDetailsPlannerEntryDialog$lambda$7 = PlannerEntryDialogKt.PlannerEntryDialog$lambda$7(mutableState5);
                                            if (recipeWithDetailsPlannerEntryDialog$lambda$7 == null || (recipe = recipeWithDetailsPlannerEntryDialog$lambda$7.getRecipe()) == null || (name = recipe.getName()) == null) {
                                                name = "Seleccionar receta →";
                                            }
                                            Modifier modifierM681padding3ABfNKs = PaddingKt.m681padding3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(12));
                                            $composer2.startReplaceGroup(62222555);
                                            ComposerKt.sourceInformation($composer2, "151@6484L11");
                                            long onSurface = PlannerEntryDialogKt.PlannerEntryDialog$lambda$7(mutableState5) != null ? MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurface() : Color.INSTANCE.m4211getGray0d7_KjU();
                                            $composer2.endReplaceGroup();
                                            TextKt.m2714Text4IGK_g(name, modifierM681padding3ABfNKs, onSurface, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (androidx.compose.ui.text.TextStyle) null, $composer2, 48, 0, 131064);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer2.skipToGroupEnd();
                                    }
                                }, $composer, 54), $composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 26);
                                if (PlannerEntryDialogKt.PlannerEntryDialog$lambda$7(mutableState5) != null) {
                                    ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                                    Modifier modifier$iv5 = Modifier.INSTANCE;
                                    Arrangement.Vertical verticalArrangement$iv3 = Arrangement.INSTANCE.getTop();
                                    Alignment.Horizontal horizontalAlignment$iv3 = Alignment.INSTANCE.getStart();
                                    MeasurePolicy measurePolicy$iv5 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv3, horizontalAlignment$iv3, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                    int $changed$iv$iv5 = (0 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                    compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                                    CompositionLocalMap localMap$iv$iv5 = $composer.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer, modifier$iv5);
                                    constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                                    int $changed$iv$iv$iv6 = (($changed$iv$iv5 << 6) & 896) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                    if (!($composer.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer.startReusableNode();
                                    if ($composer.getInserting()) {
                                        function6 = constructor4;
                                        $composer.createNode(function6);
                                    } else {
                                        function6 = constructor4;
                                        $composer.useNode();
                                    }
                                    $this$Layout_u24lambda_u240$iv$iv4 = Updater.m3674constructorimpl($composer);
                                    Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if (!$this$Layout_u24lambda_u240$iv$iv4.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv4.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv4))) {
                                        $this$Layout_u24lambda_u240$iv$iv4.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv4));
                                        $this$Layout_u24lambda_u240$iv$iv4.apply(Integer.valueOf(compositeKeyHash$iv$iv4), setCompositeKeyHash5);
                                    }
                                    Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv5, ComposeUiNode.INSTANCE.getSetModifier());
                                    int i9 = ($changed$iv$iv$iv6 >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                                    ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                                    int i10 = ((0 >> 6) & 112) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer, 1929150587, "C157@6682L226,163@7043L17,161@6937L253:PlannerEntryDialog.kt#auin6u");
                                    String servings = PlannerEntryDialogKt.formatServings(PlannerEntryDialogKt.PlannerEntryDialog$lambda$13(mutableFloatState2));
                                    RecipeWithDetails recipeWithDetailsPlannerEntryDialog$lambda$7 = PlannerEntryDialogKt.PlannerEntryDialog$lambda$7(mutableState5);
                                    Intrinsics.checkNotNull(recipeWithDetailsPlannerEntryDialog$lambda$7);
                                    TextKt.m2714Text4IGK_g("Porciones: " + servings + " (base: " + recipeWithDetailsPlannerEntryDialog$lambda$7.getRecipe().getBaseServings() + ")", (Modifier) null, Color.INSTANCE.m4211getGray0d7_KjU(), TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (androidx.compose.ui.text.TextStyle) null, $composer, 3456, 0, 131058);
                                    float fPlannerEntryDialog$lambda$13 = PlannerEntryDialogKt.PlannerEntryDialog$lambda$13(mutableFloatState2);
                                    $composer.startReplaceGroup(62241725);
                                    ComposerKt.sourceInformation($composer, "CC(remember):PlannerEntryDialog.kt#9igjgp");
                                    it$iv4 = $composer.rememberedValue();
                                    if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                                        mutableFloatState = mutableFloatState2;
                                        value$iv8 = new Function1() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$PlannerEntryDialog$7$1$$ExternalSyntheticLambda3
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return PlannerEntryDialogKt.AnonymousClass7.AnonymousClass1.invoke$lambda$23$lambda$11$lambda$10$lambda$9(mutableFloatState, ((Float) obj).floatValue());
                                            }
                                        };
                                        $composer.updateRememberedValue(value$iv8);
                                    } else {
                                        mutableFloatState = mutableFloatState2;
                                        value$iv8 = it$iv4;
                                    }
                                    $composer.endReplaceGroup();
                                    SliderKt.Slider(fPlannerEntryDialog$lambda$13, (Function1) value$iv8, null, false, RangesKt.rangeTo(0.5f, 12.0f), 22, null, null, null, $composer, 196656, 460);
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    $composer.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                    ComposerKt.sourceInformationMarkerEnd($composer);
                                } else {
                                    mutableFloatState = mutableFloatState2;
                                }
                                $composer.endReplaceGroup();
                                mutableState2 = mutableState6;
                            } else {
                                mutableState = mutableState;
                                mutableFloatState = mutableFloatState2;
                                $composer.startReplaceGroup(-1957826113);
                                ComposerKt.sourceInformation($composer, "172@7387L19,170@7284L494");
                                String strPlannerEntryDialog$lambda$10 = PlannerEntryDialogKt.PlannerEntryDialog$lambda$10(mutableState6);
                                KeyboardOptions keyboardOptions = new KeyboardOptions(KeyboardCapitalization.INSTANCE.m6338getSentencesIUNYP9k(), (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, WebSocketProtocol.PAYLOAD_SHORT, (DefaultConstructorMarker) null);
                                Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                $composer.startReplaceGroup(75395136);
                                ComposerKt.sourceInformation($composer, "CC(remember):PlannerEntryDialog.kt#9igjgp");
                                it$iv = $composer.rememberedValue();
                                if (it$iv == Composer.INSTANCE.getEmpty()) {
                                    mutableState2 = mutableState6;
                                    value$iv3 = new Function1() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$PlannerEntryDialog$7$1$$ExternalSyntheticLambda4
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return PlannerEntryDialogKt.AnonymousClass7.AnonymousClass1.invoke$lambda$23$lambda$13$lambda$12(mutableState2, (String) obj);
                                        }
                                    };
                                    $composer.updateRememberedValue(value$iv3);
                                } else {
                                    mutableState2 = mutableState6;
                                    value$iv3 = it$iv;
                                }
                                $composer.endReplaceGroup();
                                OutlinedTextFieldKt.OutlinedTextField(strPlannerEntryDialog$lambda$10, (Function1<? super String, Unit>) value$iv3, modifierFillMaxWidth$default2, false, false, (androidx.compose.ui.text.TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$PlannerEntryDialogKt.INSTANCE.m7139getLambda1$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$PlannerEntryDialogKt.INSTANCE.m7147getLambda2$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptions, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer, 14156208, 12779520, 0, 8224568);
                                $composer.endReplaceGroup();
                            }
                            String strPlannerEntryDialog$lambda$16 = PlannerEntryDialogKt.PlannerEntryDialog$lambda$16(mutableState7);
                            Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                            $composer.startReplaceGroup(75411675);
                            ComposerKt.sourceInformation($composer, "CC(remember):PlannerEntryDialog.kt#9igjgp");
                            it$iv2 = $composer.rememberedValue();
                            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                                value$iv4 = new Function1() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$PlannerEntryDialog$7$1$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return PlannerEntryDialogKt.AnonymousClass7.AnonymousClass1.invoke$lambda$23$lambda$15$lambda$14(mutableState7, (String) obj);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv4);
                            } else {
                                value$iv4 = it$iv2;
                            }
                            $composer.endReplaceGroup();
                            OutlinedTextFieldKt.OutlinedTextField(strPlannerEntryDialog$lambda$16, (Function1<? super String, Unit>) value$iv4, modifierFillMaxWidth$default3, false, false, (androidx.compose.ui.text.TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$PlannerEntryDialogKt.INSTANCE.m7148getLambda3$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$PlannerEntryDialogKt.INSTANCE.m7149getLambda4$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer, 14156208, 12582912, 0, 8257336);
                            $composer.startReplaceGroup(75423175);
                            ComposerKt.sourceInformation($composer, "192@8283L732");
                            if (plannerEntry != null) {
                                Modifier modifier$iv6 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(8));
                                ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                                Alignment.Vertical verticalAlignment$iv3 = Alignment.INSTANCE.getTop();
                                MeasurePolicy measurePolicy$iv6 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                                int $changed$iv$iv6 = (54 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                                CompositionLocalMap localMap$iv$iv6 = $composer.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer, modifier$iv6);
                                constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                int $changed$iv$iv$iv7 = (($changed$iv$iv6 << 6) & 896) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!($composer.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer.startReusableNode();
                                if ($composer.getInserting()) {
                                    function5 = constructor3;
                                    $composer.createNode(function5);
                                } else {
                                    function5 = constructor3;
                                    $composer.useNode();
                                }
                                $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3674constructorimpl($composer);
                                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                                    $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                                    $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash6);
                                }
                                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv6, ComposeUiNode.INSTANCE.getSetModifier());
                                int i11 = ($changed$iv$iv$iv7 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                                int i12 = ((54 >> 6) & 112) | 6;
                                RowScope $this$invoke_u24lambda_u2423_u24lambda_u2418 = RowScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart($composer, 1930925709, "C197@8525L20,196@8471L181,200@8677L316:PlannerEntryDialog.kt#auin6u");
                                $composer.startReplaceGroup(62289152);
                                ComposerKt.sourceInformation($composer, "CC(remember):PlannerEntryDialog.kt#9igjgp");
                                value$iv6 = $composer.rememberedValue();
                                if (value$iv6 == Composer.INSTANCE.getEmpty()) {
                                    value$iv6 = new Function0() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$PlannerEntryDialog$7$1$$ExternalSyntheticLambda6
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return PlannerEntryDialogKt.AnonymousClass7.AnonymousClass1.invoke$lambda$23$lambda$18$lambda$17$lambda$16(mutableState8);
                                        }
                                    };
                                    $composer.updateRememberedValue(value$iv6);
                                }
                                $composer.endReplaceGroup();
                                ButtonKt.OutlinedButton((Function0) value$iv6, RowScope.weight$default($this$invoke_u24lambda_u2423_u24lambda_u2418, Modifier.INSTANCE, 1.0f, false, 2, null), false, null, null, null, null, null, null, ComposableSingletons$PlannerEntryDialogKt.INSTANCE.m7150getLambda5$app_debug(), $composer, 805306374, 508);
                                ButtonKt.OutlinedButton(function7, RowScope.weight$default($this$invoke_u24lambda_u2423_u24lambda_u2418, Modifier.INSTANCE, 1.0f, false, 2, null), false, null, null, null, null, null, null, ComposableSingletons$PlannerEntryDialogKt.INSTANCE.m7151getLambda6$app_debug(), $composer, 805306368, 508);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                $composer.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                            }
                            $composer.endReplaceGroup();
                            Modifier modifier$iv7 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                            Arrangement.Horizontal horizontalArrangement$iv4 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(8));
                            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                            Alignment.Vertical verticalAlignment$iv4 = Alignment.INSTANCE.getTop();
                            MeasurePolicy measurePolicy$iv7 = RowKt.rowMeasurePolicy(horizontalArrangement$iv4, verticalAlignment$iv4, $composer, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                            int $changed$iv$iv7 = (54 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                            compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                            CompositionLocalMap localMap$iv$iv7 = $composer.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv7 = ComposedModifierKt.materializeModifier($composer, modifier$iv7);
                            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv8 = (($changed$iv$iv7 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!($composer.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer.startReusableNode();
                            if ($composer.getInserting()) {
                                $composer.createNode(constructor2);
                            } else {
                                $composer.useNode();
                            }
                            $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3674constructorimpl($composer);
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash7);
                            }
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv7, ComposeUiNode.INSTANCE.getSetModifier());
                            int i13 = ($changed$iv$iv$iv8 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                            int i14 = ((54 >> 6) & 112) | 6;
                            RowScope $this$invoke_u24lambda_u2423_u24lambda_u2422 = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer, 1931717418, "C215@9261L132,219@9456L386,218@9414L628:PlannerEntryDialog.kt#auin6u");
                            ButtonKt.OutlinedButton(function8, RowScope.weight$default($this$invoke_u24lambda_u2423_u24lambda_u2422, Modifier.INSTANCE, 1.0f, false, 2, null), false, null, null, null, null, null, null, ComposableSingletons$PlannerEntryDialogKt.INSTANCE.m7152getLambda7$app_debug(), $composer, 805306368, 508);
                            $composer.startReplaceGroup(62319310);
                            ComposerKt.sourceInformation($composer, "CC(remember):PlannerEntryDialog.kt#9igjgp");
                            invalid$iv = $composer.changed(function9) | $composer.changed(str3) | $composer.changed(str);
                            value$iv5 = $composer.rememberedValue();
                            if (!invalid$iv || value$iv5 == Composer.INSTANCE.getEmpty()) {
                                z = false;
                                final MutableState<Boolean> mutableState9 = mutableState;
                                final MutableFloatState mutableFloatState3 = mutableFloatState;
                                z2 = true;
                                final MutableState<String> mutableState10 = mutableState2;
                                value$iv5 = new Function0() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$PlannerEntryDialog$7$1$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return PlannerEntryDialogKt.AnonymousClass7.AnonymousClass1.invoke$lambda$23$lambda$22$lambda$21$lambda$20(function9, str3, str, mutableState9, mutableState5, mutableState10, mutableFloatState3, mutableState7);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv5);
                            } else {
                                z = false;
                                z2 = true;
                            }
                            Function0 function10 = (Function0) value$iv5;
                            r15.endReplaceGroup();
                            ButtonKt.Button(function10, RowScope.weight$default($this$invoke_u24lambda_u2423_u24lambda_u2422, Modifier.INSTANCE, 1.0f, false, 2, null), (PlannerEntryDialogKt.PlannerEntryDialog$lambda$3(mutableState) ? StringsKt.isBlank(PlannerEntryDialogKt.PlannerEntryDialog$lambda$10(mutableState2)) : PlannerEntryDialogKt.PlannerEntryDialog$lambda$7(mutableState5) == null) ? z : z2, null, null, null, null, null, null, ComposableSingletons$PlannerEntryDialogKt.INSTANCE.m7153getLambda8$app_debug(), r15, 805306368, 504);
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
                            }
                        }
                        function3 = function2;
                        $this$Layout_u24lambda_u240$iv$iv7.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv7));
                        $this$Layout_u24lambda_u240$iv$iv7.apply(Integer.valueOf(compositeKeyHash$iv$iv7), setCompositeKeyHash3);
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv7, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                        int i15 = ($changed$iv$iv$iv4 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
                        int i16 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, 1828934548, "C123@5138L10,123@5075L86,124@5186L53:PlannerEntryDialog.kt#auin6u");
                        TextKt.m2714Text4IGK_g(str, (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getTitleMedium(), $composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 65502);
                        TextKt.m2714Text4IGK_g(str2, (Modifier) null, Color.INSTANCE.m4211getGray0d7_KjU(), TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (androidx.compose.ui.text.TextStyle) null, $composer, 3456, 0, 131058);
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
                        DividerKt.m2093HorizontalDivider9IZ8Weo(null, 0.0f, 0L, $composer, 0, 7);
                        Arrangement.Horizontal horizontalArrangement$iv5 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(8));
                        ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                        Modifier modifier$iv8 = Modifier.INSTANCE;
                        Alignment.Vertical verticalAlignment$iv5 = Alignment.INSTANCE.getTop();
                        MeasurePolicy measurePolicy$iv8 = RowKt.rowMeasurePolicy(horizontalArrangement$iv5, verticalAlignment$iv5, $composer, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                        int $changed$iv$iv8 = (48 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                        CompositionLocalMap localMap$iv$iv8 = $composer.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv8 = ComposedModifierKt.materializeModifier($composer, modifier$iv8);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv9 = (($changed$iv$iv8 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer.startReusableNode();
                        if ($composer.getInserting()) {
                            function4 = constructor;
                            $composer.createNode(function4);
                        } else {
                            function4 = constructor;
                            $composer.useNode();
                        }
                        $this$Layout_u24lambda_u240$iv$iv = Updater.m3674constructorimpl($composer);
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash8 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!$this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                        }
                        $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                        $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash8);
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv8, ComposeUiNode.INSTANCE.getSetModifier());
                        int i17 = ($changed$iv$iv$iv9 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                        int i18 = ((48 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, 1927925188, "C132@5501L20,132@5458L63,133@5584L21,133@5542L63:PlannerEntryDialog.kt#auin6u");
                        boolean zPlannerEntryDialog$lambda$4 = PlannerEntryDialogKt.PlannerEntryDialog$lambda$3(mutableState3);
                        $composer.startReplaceGroup(62192384);
                        ComposerKt.sourceInformation($composer, "CC(remember):PlannerEntryDialog.kt#9igjgp");
                        value$iv = $composer.rememberedValue();
                        if (value$iv == Composer.INSTANCE.getEmpty()) {
                            mutableState = mutableState3;
                            value$iv = new Function0() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$PlannerEntryDialog$7$1$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return PlannerEntryDialogKt.AnonymousClass7.AnonymousClass1.invoke$lambda$23$lambda$6$lambda$3$lambda$2(mutableState);
                                }
                            };
                            $composer.updateRememberedValue(value$iv);
                        } else {
                            mutableState = mutableState3;
                        }
                        $composer.endReplaceGroup();
                        PlannerEntryDialogKt.FilterButton("Receta guardada", zPlannerEntryDialog$lambda$4, (Function0) value$iv, $composer, 390);
                        boolean z4 = !PlannerEntryDialogKt.PlannerEntryDialog$lambda$3(mutableState);
                        $composer.startReplaceGroup(62195041);
                        ComposerKt.sourceInformation($composer, "CC(remember):PlannerEntryDialog.kt#9igjgp");
                        value$iv2 = $composer.rememberedValue();
                        if (value$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = new Function0() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$PlannerEntryDialog$7$1$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return PlannerEntryDialogKt.AnonymousClass7.AnonymousClass1.invoke$lambda$23$lambda$6$lambda$5$lambda$4(mutableState);
                                }
                            };
                            $composer.updateRememberedValue(value$iv2);
                        }
                        $composer.endReplaceGroup();
                        PlannerEntryDialogKt.FilterButton("Personalizado", z4, (Function0) value$iv2, $composer, 390);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        $composer.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        if (PlannerEntryDialogKt.PlannerEntryDialog$lambda$3(mutableState)) {
                            $composer.startReplaceGroup(-1959386219);
                            ComposerKt.sourceInformation($composer, "141@5851L27,142@5926L270,147@6219L350,138@5718L851,156@6645L571");
                            Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                            $composer.startReplaceGroup(75345992);
                            ComposerKt.sourceInformation($composer, "CC(remember):PlannerEntryDialog.kt#9igjgp");
                            it$iv3 = $composer.rememberedValue();
                            if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                                value$iv7 = new Function0() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$PlannerEntryDialog$7$1$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return PlannerEntryDialogKt.AnonymousClass7.AnonymousClass1.invoke$lambda$23$lambda$8$lambda$7(mutableState4);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv7);
                            } else {
                                value$iv7 = it$iv3;
                            }
                            $composer.endReplaceGroup();
                            Modifier modifierM269clickableXHw0xAI$default2 = ClickableKt.m269clickableXHw0xAI$default(modifierFillMaxWidth$default4, false, null, null, (Function0) value$iv7, 7, null);
                            CardDefaults cardDefaults2 = CardDefaults.INSTANCE;
                            if (PlannerEntryDialogKt.PlannerEntryDialog$lambda$7(mutableState5) != null) {
                                $composer.startReplaceGroup(75353495);
                                ComposerKt.sourceInformation($composer, "144@6057L11");
                                long primaryContainer2 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimaryContainer();
                                long jM4179copywmQWz5c2 = Color.m4179copywmQWz5c(primaryContainer2, (14 & 1) != 0 ? Color.m4183getAlphaimpl(primaryContainer2) : 0.4f, (14 & 2) != 0 ? Color.m4187getRedimpl(primaryContainer2) : 0.0f, (14 & 4) != 0 ? Color.m4186getGreenimpl(primaryContainer2) : 0.0f, (14 & 8) != 0 ? Color.m4184getBlueimpl(primaryContainer2) : 0.0f);
                                $composer.endReplaceGroup();
                                j = jM4179copywmQWz5c2;
                            } else {
                                $composer.startReplaceGroup(75355739);
                                ComposerKt.sourceInformation($composer, "145@6144L11");
                                long surfaceVariant2 = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceVariant();
                                $composer.endReplaceGroup();
                                j = surfaceVariant2;
                            }
                            CardKt.Card(modifierM269clickableXHw0xAI$default2, null, cardDefaults2.m1850cardColorsro_MJ88(j, 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14), null, null, ComposableLambdaKt.rememberComposableLambda(-1129765632, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$PlannerEntryDialog$7$1$1$4
                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                                    invoke(columnScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(ColumnScope Card2, Composer $composer2, int $changed2) {
                                    String name;
                                    RecipeEntity recipe;
                                    Intrinsics.checkNotNullParameter(Card2, "$this$Card");
                                    ComposerKt.sourceInformation($composer2, "C148@6245L302:PlannerEntryDialog.kt#auin6u");
                                    if (($changed2 & 17) != 16 || !$composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1129765632, $changed2, -1, "com.easycompra.app.ui.planner.PlannerEntryDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PlannerEntryDialog.kt:148)");
                                        }
                                        RecipeWithDetails recipeWithDetailsPlannerEntryDialog$lambda$8 = PlannerEntryDialogKt.PlannerEntryDialog$lambda$7(mutableState5);
                                        if (recipeWithDetailsPlannerEntryDialog$lambda$8 == null || (recipe = recipeWithDetailsPlannerEntryDialog$lambda$8.getRecipe()) == null || (name = recipe.getName()) == null) {
                                            name = "Seleccionar receta →";
                                        }
                                        Modifier modifierM681padding3ABfNKs = PaddingKt.m681padding3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(12));
                                        $composer2.startReplaceGroup(62222555);
                                        ComposerKt.sourceInformation($composer2, "151@6484L11");
                                        long onSurface = PlannerEntryDialogKt.PlannerEntryDialog$lambda$7(mutableState5) != null ? MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSurface() : Color.INSTANCE.m4211getGray0d7_KjU();
                                        $composer2.endReplaceGroup();
                                        TextKt.m2714Text4IGK_g(name, modifierM681padding3ABfNKs, onSurface, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (androidx.compose.ui.text.TextStyle) null, $composer2, 48, 0, 131064);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer2.skipToGroupEnd();
                                }
                            }, $composer, 54), $composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 26);
                            if (PlannerEntryDialogKt.PlannerEntryDialog$lambda$7(mutableState5) != null) {
                                ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                                Modifier modifier$iv9 = Modifier.INSTANCE;
                                Arrangement.Vertical verticalArrangement$iv4 = Arrangement.INSTANCE.getTop();
                                Alignment.Horizontal horizontalAlignment$iv4 = Alignment.INSTANCE.getStart();
                                MeasurePolicy measurePolicy$iv9 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv4, horizontalAlignment$iv4, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                int $changed$iv$iv9 = (0 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                                CompositionLocalMap localMap$iv$iv9 = $composer.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv9 = ComposedModifierKt.materializeModifier($composer, modifier$iv9);
                                constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                                int $changed$iv$iv$iv10 = (($changed$iv$iv9 << 6) & 896) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!($composer.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer.startReusableNode();
                                if ($composer.getInserting()) {
                                    function6 = constructor4;
                                    $composer.createNode(function6);
                                } else {
                                    function6 = constructor4;
                                    $composer.useNode();
                                }
                                $this$Layout_u24lambda_u240$iv$iv4 = Updater.m3674constructorimpl($composer);
                                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash9 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if (!$this$Layout_u24lambda_u240$iv$iv4.getInserting()) {
                                }
                                $this$Layout_u24lambda_u240$iv$iv4.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv4));
                                $this$Layout_u24lambda_u240$iv$iv4.apply(Integer.valueOf(compositeKeyHash$iv$iv4), setCompositeKeyHash9);
                                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv9, ComposeUiNode.INSTANCE.getSetModifier());
                                int i19 = ($changed$iv$iv$iv10 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance5 = ColumnScopeInstance.INSTANCE;
                                int i110 = ((0 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer, 1929150587, "C157@6682L226,163@7043L17,161@6937L253:PlannerEntryDialog.kt#auin6u");
                                String servings2 = PlannerEntryDialogKt.formatServings(PlannerEntryDialogKt.PlannerEntryDialog$lambda$13(mutableFloatState2));
                                RecipeWithDetails recipeWithDetailsPlannerEntryDialog$lambda$8 = PlannerEntryDialogKt.PlannerEntryDialog$lambda$7(mutableState5);
                                Intrinsics.checkNotNull(recipeWithDetailsPlannerEntryDialog$lambda$8);
                                TextKt.m2714Text4IGK_g("Porciones: " + servings2 + " (base: " + recipeWithDetailsPlannerEntryDialog$lambda$8.getRecipe().getBaseServings() + ")", (Modifier) null, Color.INSTANCE.m4211getGray0d7_KjU(), TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (androidx.compose.ui.text.TextStyle) null, $composer, 3456, 0, 131058);
                                float fPlannerEntryDialog$lambda$14 = PlannerEntryDialogKt.PlannerEntryDialog$lambda$13(mutableFloatState2);
                                $composer.startReplaceGroup(62241725);
                                ComposerKt.sourceInformation($composer, "CC(remember):PlannerEntryDialog.kt#9igjgp");
                                it$iv4 = $composer.rememberedValue();
                                if (it$iv4 == Composer.INSTANCE.getEmpty()) {
                                    mutableFloatState = mutableFloatState2;
                                    value$iv8 = new Function1() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$PlannerEntryDialog$7$1$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return PlannerEntryDialogKt.AnonymousClass7.AnonymousClass1.invoke$lambda$23$lambda$11$lambda$10$lambda$9(mutableFloatState, ((Float) obj).floatValue());
                                        }
                                    };
                                    $composer.updateRememberedValue(value$iv8);
                                } else {
                                    mutableFloatState = mutableFloatState2;
                                    value$iv8 = it$iv4;
                                }
                                $composer.endReplaceGroup();
                                SliderKt.Slider(fPlannerEntryDialog$lambda$14, (Function1) value$iv8, null, false, RangesKt.rangeTo(0.5f, 12.0f), 22, null, null, null, $composer, 196656, 460);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                $composer.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                                ComposerKt.sourceInformationMarkerEnd($composer);
                            } else {
                                mutableFloatState = mutableFloatState2;
                            }
                            $composer.endReplaceGroup();
                            mutableState2 = mutableState6;
                        } else {
                            mutableState = mutableState;
                            mutableFloatState = mutableFloatState2;
                            $composer.startReplaceGroup(-1957826113);
                            ComposerKt.sourceInformation($composer, "172@7387L19,170@7284L494");
                            String strPlannerEntryDialog$lambda$11 = PlannerEntryDialogKt.PlannerEntryDialog$lambda$10(mutableState6);
                            KeyboardOptions keyboardOptions2 = new KeyboardOptions(KeyboardCapitalization.INSTANCE.m6338getSentencesIUNYP9k(), (Boolean) null, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, WebSocketProtocol.PAYLOAD_SHORT, (DefaultConstructorMarker) null);
                            Modifier modifierFillMaxWidth$default5 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                            $composer.startReplaceGroup(75395136);
                            ComposerKt.sourceInformation($composer, "CC(remember):PlannerEntryDialog.kt#9igjgp");
                            it$iv = $composer.rememberedValue();
                            if (it$iv == Composer.INSTANCE.getEmpty()) {
                                mutableState2 = mutableState6;
                                value$iv3 = new Function1() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$PlannerEntryDialog$7$1$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return PlannerEntryDialogKt.AnonymousClass7.AnonymousClass1.invoke$lambda$23$lambda$13$lambda$12(mutableState2, (String) obj);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv3);
                            } else {
                                mutableState2 = mutableState6;
                                value$iv3 = it$iv;
                            }
                            $composer.endReplaceGroup();
                            OutlinedTextFieldKt.OutlinedTextField(strPlannerEntryDialog$lambda$11, (Function1<? super String, Unit>) value$iv3, modifierFillMaxWidth$default5, false, false, (androidx.compose.ui.text.TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$PlannerEntryDialogKt.INSTANCE.m7139getLambda1$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$PlannerEntryDialogKt.INSTANCE.m7147getLambda2$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptions2, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer, 14156208, 12779520, 0, 8224568);
                            $composer.endReplaceGroup();
                        }
                        String strPlannerEntryDialog$lambda$17 = PlannerEntryDialogKt.PlannerEntryDialog$lambda$16(mutableState7);
                        Modifier modifierFillMaxWidth$default6 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        $composer.startReplaceGroup(75411675);
                        ComposerKt.sourceInformation($composer, "CC(remember):PlannerEntryDialog.kt#9igjgp");
                        it$iv2 = $composer.rememberedValue();
                        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv4 = new Function1() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$PlannerEntryDialog$7$1$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return PlannerEntryDialogKt.AnonymousClass7.AnonymousClass1.invoke$lambda$23$lambda$15$lambda$14(mutableState7, (String) obj);
                                }
                            };
                            $composer.updateRememberedValue(value$iv4);
                        } else {
                            value$iv4 = it$iv2;
                        }
                        $composer.endReplaceGroup();
                        OutlinedTextFieldKt.OutlinedTextField(strPlannerEntryDialog$lambda$17, (Function1<? super String, Unit>) value$iv4, modifierFillMaxWidth$default6, false, false, (androidx.compose.ui.text.TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$PlannerEntryDialogKt.INSTANCE.m7148getLambda3$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$PlannerEntryDialogKt.INSTANCE.m7149getLambda4$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer, 14156208, 12582912, 0, 8257336);
                        $composer.startReplaceGroup(75423175);
                        ComposerKt.sourceInformation($composer, "192@8283L732");
                        if (plannerEntry != null) {
                            Modifier modifier$iv10 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                            Arrangement.Horizontal horizontalArrangement$iv6 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(8));
                            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                            Alignment.Vertical verticalAlignment$iv6 = Alignment.INSTANCE.getTop();
                            MeasurePolicy measurePolicy$iv10 = RowKt.rowMeasurePolicy(horizontalArrangement$iv6, verticalAlignment$iv6, $composer, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                            int $changed$iv$iv10 = (54 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                            compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                            CompositionLocalMap localMap$iv$iv10 = $composer.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv10 = ComposedModifierKt.materializeModifier($composer, modifier$iv10);
                            constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv11 = (($changed$iv$iv10 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!($composer.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer.startReusableNode();
                            if ($composer.getInserting()) {
                                function5 = constructor3;
                                $composer.createNode(function5);
                            } else {
                                function5 = constructor3;
                                $composer.useNode();
                            }
                            $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3674constructorimpl($composer);
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash10 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!$this$Layout_u24lambda_u240$iv$iv3.getInserting()) {
                            }
                            $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                            $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash10);
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv10, ComposeUiNode.INSTANCE.getSetModifier());
                            int i111 = ($changed$iv$iv$iv11 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                            int i112 = ((54 >> 6) & 112) | 6;
                            RowScope $this$invoke_u24lambda_u2423_u24lambda_u2419 = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer, 1930925709, "C197@8525L20,196@8471L181,200@8677L316:PlannerEntryDialog.kt#auin6u");
                            $composer.startReplaceGroup(62289152);
                            ComposerKt.sourceInformation($composer, "CC(remember):PlannerEntryDialog.kt#9igjgp");
                            value$iv6 = $composer.rememberedValue();
                            if (value$iv6 == Composer.INSTANCE.getEmpty()) {
                                value$iv6 = new Function0() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$PlannerEntryDialog$7$1$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return PlannerEntryDialogKt.AnonymousClass7.AnonymousClass1.invoke$lambda$23$lambda$18$lambda$17$lambda$16(mutableState8);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv6);
                            }
                            $composer.endReplaceGroup();
                            ButtonKt.OutlinedButton((Function0) value$iv6, RowScope.weight$default($this$invoke_u24lambda_u2423_u24lambda_u2419, Modifier.INSTANCE, 1.0f, false, 2, null), false, null, null, null, null, null, null, ComposableSingletons$PlannerEntryDialogKt.INSTANCE.m7150getLambda5$app_debug(), $composer, 805306374, 508);
                            ButtonKt.OutlinedButton(function7, RowScope.weight$default($this$invoke_u24lambda_u2423_u24lambda_u2419, Modifier.INSTANCE, 1.0f, false, 2, null), false, null, null, null, null, null, null, ComposableSingletons$PlannerEntryDialogKt.INSTANCE.m7151getLambda6$app_debug(), $composer, 805306368, 508);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            $composer.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                        }
                        $composer.endReplaceGroup();
                        Modifier modifier$iv11 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.Horizontal horizontalArrangement$iv7 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(8));
                        ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                        Alignment.Vertical verticalAlignment$iv7 = Alignment.INSTANCE.getTop();
                        MeasurePolicy measurePolicy$iv11 = RowKt.rowMeasurePolicy(horizontalArrangement$iv7, verticalAlignment$iv7, $composer, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                        int $changed$iv$iv11 = (54 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                        CompositionLocalMap localMap$iv$iv11 = $composer.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv11 = ComposedModifierKt.materializeModifier($composer, modifier$iv11);
                        constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv12 = (($changed$iv$iv11 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer.startReusableNode();
                        if ($composer.getInserting()) {
                            $composer.createNode(constructor2);
                        } else {
                            $composer.useNode();
                        }
                        $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3674constructorimpl($composer);
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash11 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                        }
                        $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                        $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash11);
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv11, ComposeUiNode.INSTANCE.getSetModifier());
                        int i113 = ($changed$iv$iv$iv12 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                        int i114 = ((54 >> 6) & 112) | 6;
                        RowScope $this$invoke_u24lambda_u2423_u24lambda_u2423 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer, 1931717418, "C215@9261L132,219@9456L386,218@9414L628:PlannerEntryDialog.kt#auin6u");
                        ButtonKt.OutlinedButton(function8, RowScope.weight$default($this$invoke_u24lambda_u2423_u24lambda_u2423, Modifier.INSTANCE, 1.0f, false, 2, null), false, null, null, null, null, null, null, ComposableSingletons$PlannerEntryDialogKt.INSTANCE.m7152getLambda7$app_debug(), $composer, 805306368, 508);
                        $composer.startReplaceGroup(62319310);
                        ComposerKt.sourceInformation($composer, "CC(remember):PlannerEntryDialog.kt#9igjgp");
                        invalid$iv = $composer.changed(function9) | $composer.changed(str3) | $composer.changed(str);
                        value$iv5 = $composer.rememberedValue();
                        if (invalid$iv) {
                        }
                        z = false;
                        final MutableState mutableState11 = mutableState;
                        final MutableFloatState mutableFloatState4 = mutableFloatState;
                        z2 = true;
                        final MutableState mutableState12 = mutableState2;
                        value$iv5 = new Function0() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$PlannerEntryDialog$7$1$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return PlannerEntryDialogKt.AnonymousClass7.AnonymousClass1.invoke$lambda$23$lambda$22$lambda$21$lambda$20(function9, str3, str, mutableState11, mutableState5, mutableState12, mutableFloatState4, mutableState7);
                            }
                        };
                        $composer.updateRememberedValue(value$iv5);
                        Function0 function11 = (Function0) value$iv5;
                        r15.endReplaceGroup();
                        ButtonKt.Button(function11, RowScope.weight$default($this$invoke_u24lambda_u2423_u24lambda_u2423, Modifier.INSTANCE, 1.0f, false, 2, null), (PlannerEntryDialogKt.PlannerEntryDialog$lambda$3(mutableState) ? StringsKt.isBlank(PlannerEntryDialogKt.PlannerEntryDialog$lambda$10(mutableState2)) : PlannerEntryDialogKt.PlannerEntryDialog$lambda$7(mutableState5) == null) ? z : z2, null, null, null, null, null, null, ComposableSingletons$PlannerEntryDialogKt.INSTANCE.m7153getLambda8$app_debug(), r15, 805306368, 504);
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
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$23$lambda$6$lambda$3$lambda$2(MutableState $useRecipe$delegate) {
                        PlannerEntryDialogKt.PlannerEntryDialog$lambda$4($useRecipe$delegate, true);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$23$lambda$6$lambda$5$lambda$4(MutableState $useRecipe$delegate) {
                        PlannerEntryDialogKt.PlannerEntryDialog$lambda$4($useRecipe$delegate, false);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$23$lambda$8$lambda$7(MutableState $showRecipePicker$delegate) {
                        PlannerEntryDialogKt.PlannerEntryDialog$lambda$20($showRecipePicker$delegate, true);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$23$lambda$11$lambda$10$lambda$9(MutableFloatState $servings$delegate, float it) {
                        PlannerEntryDialogKt.PlannerEntryDialog$lambda$14($servings$delegate, it);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$23$lambda$13$lambda$12(MutableState $customText$delegate, String it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        PlannerEntryDialogKt.PlannerEntryDialog$lambda$11($customText$delegate, it);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$23$lambda$15$lambda$14(MutableState $notes$delegate, String it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        PlannerEntryDialogKt.PlannerEntryDialog$lambda$17($notes$delegate, it);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$23$lambda$18$lambda$17$lambda$16(MutableState $showMover$delegate) {
                        PlannerEntryDialogKt.PlannerEntryDialog$lambda$23($showMover$delegate, true);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$23$lambda$22$lambda$21$lambda$20(Function6 $onSave, String $date, String $slot, MutableState $useRecipe$delegate, MutableState $selectedRecipe$delegate, MutableState $customText$delegate, MutableFloatState $servings$delegate, MutableState $notes$delegate) {
                        String name;
                        RecipeWithDetails recipeWithDetailsPlannerEntryDialog$lambda$7;
                        RecipeEntity recipe;
                        RecipeEntity recipe2;
                        String name2;
                        if (PlannerEntryDialogKt.PlannerEntryDialog$lambda$3($useRecipe$delegate)) {
                            RecipeWithDetails recipeWithDetailsPlannerEntryDialog$lambda$8 = PlannerEntryDialogKt.PlannerEntryDialog$lambda$7($selectedRecipe$delegate);
                            if (recipeWithDetailsPlannerEntryDialog$lambda$8 == null || (recipe2 = recipeWithDetailsPlannerEntryDialog$lambda$8.getRecipe()) == null || (name2 = recipe2.getName()) == null) {
                                return Unit.INSTANCE;
                            }
                            name = name2;
                        } else {
                            String string = StringsKt.trim((CharSequence) PlannerEntryDialogKt.PlannerEntryDialog$lambda$10($customText$delegate)).toString();
                            if (StringsKt.isBlank(string)) {
                                return Unit.INSTANCE;
                            }
                            name = string;
                        }
                        String recipeId = (!PlannerEntryDialogKt.PlannerEntryDialog$lambda$3($useRecipe$delegate) || (recipeWithDetailsPlannerEntryDialog$lambda$7 = PlannerEntryDialogKt.PlannerEntryDialog$lambda$7($selectedRecipe$delegate)) == null || (recipe = recipeWithDetailsPlannerEntryDialog$lambda$7.getRecipe()) == null) ? null : recipe.getId();
                        $onSave.invoke($date, $slot, recipeId, name, Float.valueOf(PlannerEntryDialogKt.PlannerEntryDialog$lambda$13($servings$delegate)), StringsKt.trim((CharSequence) PlannerEntryDialogKt.PlannerEntryDialog$lambda$16($notes$delegate)).toString());
                        return Unit.INSTANCE;
                    }
                }
            }, $composer2, 54), $composer2, (($dirty2 >> 24) & 14) | 384, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup3 = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup3 != null) {
            scopeUpdateScopeEndRestartGroup3.updateScope(new Function2() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return PlannerEntryDialogKt.PlannerEntryDialog$lambda$34(date, slot, existing, allRecipes, weekDates, onSave, onClear, onMove, onDismiss, $changed, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PlannerEntryDialog$lambda$3(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PlannerEntryDialog$lambda$4(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RecipeWithDetails PlannerEntryDialog$lambda$7(MutableState<RecipeWithDetails> mutableState) {
        MutableState<RecipeWithDetails> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String PlannerEntryDialog$lambda$10(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PlannerEntryDialog$lambda$11(MutableState<String> mutableState, String str) {
        mutableState.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float PlannerEntryDialog$lambda$13(MutableFloatState $servings$delegate) {
        MutableFloatState $this$getValue$iv = $servings$delegate;
        return $this$getValue$iv.getFloatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PlannerEntryDialog$lambda$14(MutableFloatState $servings$delegate, float f) {
        $servings$delegate.setFloatValue(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String PlannerEntryDialog$lambda$16(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PlannerEntryDialog$lambda$17(MutableState<String> mutableState, String str) {
        mutableState.setValue(str);
    }

    private static final boolean PlannerEntryDialog$lambda$19(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PlannerEntryDialog$lambda$20(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean PlannerEntryDialog$lambda$22(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PlannerEntryDialog$lambda$23(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlannerEntryDialog$lambda$25$lambda$24(MutableState $selectedRecipe$delegate, MutableFloatState $servings$delegate, MutableState $showRecipePicker$delegate, RecipeWithDetails recipe) {
        Intrinsics.checkNotNullParameter(recipe, "recipe");
        $selectedRecipe$delegate.setValue(recipe);
        $servings$delegate.setFloatValue(recipe.getRecipe().getBaseServings());
        PlannerEntryDialog$lambda$20($showRecipePicker$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlannerEntryDialog$lambda$27$lambda$26(MutableState $showRecipePicker$delegate) {
        PlannerEntryDialog$lambda$20($showRecipePicker$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlannerEntryDialog$lambda$30$lambda$29(Function2 $onMove, String newDate, String newSlot) {
        Intrinsics.checkNotNullParameter(newDate, "newDate");
        Intrinsics.checkNotNullParameter(newSlot, "newSlot");
        $onMove.invoke(newDate, newSlot);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlannerEntryDialog$lambda$32$lambda$31(MutableState $showMover$delegate) {
        PlannerEntryDialog$lambda$23($showMover$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FilterButton(final String label, final boolean selected, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-1429873997);
        ComposerKt.sourceInformation($composer3, "C(FilterButton)P(!1,2):PlannerEntryDialog.kt#auin6u");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(label) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(selected) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 147) != 146 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1429873997, $dirty2, -1, "com.easycompra.app.ui.planner.FilterButton (PlannerEntryDialog.kt:235)");
            }
            if (selected) {
                $composer3.startReplaceGroup(-2065888731);
                ComposerKt.sourceInformation($composer3, "237@10242L33,237@10216L59");
                ButtonKt.Button(function0, null, false, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(884302014, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt.FilterButton.1
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                        invoke(rowScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope Button, Composer $composer4, int $changed2) {
                        Intrinsics.checkNotNullParameter(Button, "$this$Button");
                        ComposerKt.sourceInformation($composer4, "C237@10244L29:PlannerEntryDialog.kt#auin6u");
                        if (($changed2 & 17) == 16 && $composer4.getSkipping()) {
                            $composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(884302014, $changed2, -1, "com.easycompra.app.ui.planner.FilterButton.<anonymous> (PlannerEntryDialog.kt:237)");
                        }
                        TextKt.m2714Text4IGK_g(label, (Modifier) null, 0L, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (androidx.compose.ui.text.TextStyle) null, $composer4, 3072, 0, 131062);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer3, 54), $composer3, (($dirty2 >> 6) & 14) | 805306368, 510);
                $composer3.endReplaceGroup();
                $composer2 = $composer3;
            } else {
                $composer3.startReplaceGroup(-2065808131);
                ComposerKt.sourceInformation($composer3, "239@10331L33,239@10297L67");
                $composer2 = $composer3;
                ButtonKt.OutlinedButton(function0, null, false, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-831858359, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt.FilterButton.2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                        invoke(rowScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope OutlinedButton, Composer $composer4, int $changed2) {
                        Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
                        ComposerKt.sourceInformation($composer4, "C239@10333L29:PlannerEntryDialog.kt#auin6u");
                        if (($changed2 & 17) == 16 && $composer4.getSkipping()) {
                            $composer4.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-831858359, $changed2, -1, "com.easycompra.app.ui.planner.FilterButton.<anonymous> (PlannerEntryDialog.kt:239)");
                        }
                        TextKt.m2714Text4IGK_g(label, (Modifier) null, 0L, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (androidx.compose.ui.text.TextStyle) null, $composer4, 3072, 0, 131062);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer3, 54), $composer3, (($dirty2 >> 6) & 14) | 805306368, 510);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PlannerEntryDialogKt.FilterButton$lambda$35(label, selected, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void RecipePickerDialog(final List<RecipeWithDetails> list, final Function1<? super RecipeWithDetails, Unit> function1, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Object value$iv;
        Object value$iv2;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-2027846953);
        ComposerKt.sourceInformation($composer3, "C(RecipePickerDialog)P(2,1)249@10546L31,250@10597L151,290@12340L56,258@10868L1418,255@10754L1648:PlannerEntryDialog.kt#auin6u");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 147) != 146 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2027846953, $dirty2, -1, "com.easycompra.app.ui.planner.RecipePickerDialog (PlannerEntryDialog.kt:248)");
            }
            $composer3.startReplaceGroup(52335275);
            ComposerKt.sourceInformation($composer3, "CC(remember):PlannerEntryDialog.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MutableState query$delegate = (MutableState) value$iv;
            $composer3.endReplaceGroup();
            String strRecipePickerDialog$lambda$37 = RecipePickerDialog$lambda$37(query$delegate);
            $composer3.startReplaceGroup(52337027);
            ComposerKt.sourceInformation($composer3, "CC(remember):PlannerEntryDialog.kt#9igjgp");
            boolean invalid$iv = $composer3.changed(strRecipePickerDialog$lambda$37) | $composer3.changed(list);
            int $i$f$cache = 0;
            Object it$iv2 = $composer3.rememberedValue();
            int i = 0;
            if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                if (StringsKt.isBlank(RecipePickerDialog$lambda$37(query$delegate))) {
                    value$iv2 = list;
                } else {
                    List<RecipeWithDetails> $this$filter$iv = list;
                    Collection destination$iv$iv = new ArrayList();
                    for (Object element$iv$iv : $this$filter$iv) {
                        boolean invalid$iv2 = invalid$iv;
                        RecipeWithDetails it = (RecipeWithDetails) element$iv$iv;
                        int $i$f$cache2 = $i$f$cache;
                        Object it$iv3 = it$iv2;
                        int i2 = i;
                        if (StringsKt.contains((CharSequence) it.getRecipe().getName(), (CharSequence) RecipePickerDialog$lambda$37(query$delegate), true)) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                        invalid$iv = invalid$iv2;
                        i = i2;
                        $i$f$cache = $i$f$cache2;
                        it$iv2 = it$iv3;
                    }
                    value$iv2 = (List) destination$iv$iv;
                }
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            List filtered = (List) value$iv2;
            $composer3.endReplaceGroup();
            $composer2 = $composer3;
            AndroidAlertDialog_androidKt.m1782AlertDialogOix01E0(function0, ComposableSingletons$PlannerEntryDialogKt.INSTANCE.m7154getLambda9$app_debug(), null, ComposableLambdaKt.rememberComposableLambda(-458106803, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt.RecipePickerDialog.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C290@12342L52:PlannerEntryDialog.kt#auin6u");
                    if (($changed2 & 3) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-458106803, $changed2, -1, "com.easycompra.app.ui.planner.RecipePickerDialog.<anonymous> (PlannerEntryDialog.kt:290)");
                    }
                    ButtonKt.TextButton(function0, null, false, null, null, null, null, null, null, ComposableSingletons$PlannerEntryDialogKt.INSTANCE.m7140getLambda10$app_debug(), $composer4, 805306368, 510);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), null, ComposableSingletons$PlannerEntryDialogKt.INSTANCE.m7141getLambda11$app_debug(), ComposableLambdaKt.rememberComposableLambda(-24877718, true, new C07272(filtered, function1, query$delegate), $composer3, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, (($dirty2 >> 6) & 14) | 1772592, 0, 16276);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PlannerEntryDialogKt.RecipePickerDialog$lambda$41(list, function1, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String RecipePickerDialog$lambda$37(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RecipePickerDialog$lambda$38(MutableState<String> mutableState, String str) {
        mutableState.setValue(str);
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.planner.PlannerEntryDialogKt$RecipePickerDialog$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PlannerEntryDialog.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class C07272 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ List<RecipeWithDetails> $filtered;
        final /* synthetic */ Function1<RecipeWithDetails, Unit> $onSelect;
        final /* synthetic */ MutableState<String> $query$delegate;

        /* JADX WARN: Multi-variable type inference failed */
        C07272(List<RecipeWithDetails> list, Function1<? super RecipeWithDetails, Unit> function1, MutableState<String> mutableState) {
            this.$filtered = list;
            this.$onSelect = function1;
            this.$query$delegate = mutableState;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            Function0<ComposeUiNode> function0;
            Object value$iv;
            Object value$iv2;
            ComposerKt.sourceInformation($composer, "C259@10882L1394:PlannerEntryDialog.kt#auin6u");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-24877718, $changed, -1, "com.easycompra.app.ui.planner.RecipePickerDialog.<anonymous> (PlannerEntryDialog.kt:259)");
            }
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(8));
            final List<RecipeWithDetails> list = this.$filtered;
            final Function1<RecipeWithDetails, Unit> function1 = this.$onSelect;
            final MutableState<String> mutableState = this.$query$delegate;
            ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            Modifier modifier$iv = Modifier.INSTANCE;
            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                function0 = constructor;
                $composer.createNode(function0);
            } else {
                function0 = constructor;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3674constructorimpl($composer);
            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i2 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1755943968, "C262@11047L14,260@10957L272,267@11293L969,267@11246L1016:PlannerEntryDialog.kt#auin6u");
            String strRecipePickerDialog$lambda$37 = PlannerEntryDialogKt.RecipePickerDialog$lambda$37(mutableState);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            $composer.startReplaceGroup(913189560);
            ComposerKt.sourceInformation($composer, "CC(remember):PlannerEntryDialog.kt#9igjgp");
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function1() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$RecipePickerDialog$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PlannerEntryDialogKt.C07272.invoke$lambda$8$lambda$1$lambda$0(mutableState, (String) obj);
                    }
                };
                $composer.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer.endReplaceGroup();
            OutlinedTextFieldKt.OutlinedTextField(strRecipePickerDialog$lambda$37, (Function1<? super String, Unit>) value$iv, modifierFillMaxWidth$default, false, false, (androidx.compose.ui.text.TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$PlannerEntryDialogKt.INSTANCE.m7142getLambda12$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer, 12583344, 12582912, 0, 8257400);
            Modifier modifierM712height3ABfNKs = SizeKt.m712height3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(280));
            $composer.startReplaceGroup(913198387);
            ComposerKt.sourceInformation($composer, "CC(remember):PlannerEntryDialog.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(list) | $composer.changed(function1);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new Function1() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$RecipePickerDialog$2$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PlannerEntryDialogKt.C07272.invoke$lambda$8$lambda$7$lambda$6(list, function1, (LazyListScope) obj);
                    }
                };
                $composer.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            $composer.endReplaceGroup();
            LazyDslKt.LazyColumn(modifierM712height3ABfNKs, null, null, false, null, null, null, false, (Function1) value$iv2, $composer, 6, 254);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$8$lambda$1$lambda$0(MutableState $query$delegate, String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            PlannerEntryDialogKt.RecipePickerDialog$lambda$38($query$delegate, it);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$8$lambda$7$lambda$6(final List $filtered, final Function1 $onSelect, LazyListScope LazyColumn) {
            Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
            final Function1 key$iv = new Function1() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$RecipePickerDialog$2$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PlannerEntryDialogKt.C07272.invoke$lambda$8$lambda$7$lambda$6$lambda$2((RecipeWithDetails) obj);
                }
            };
            final Function1 contentType$iv = new Function1() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$RecipePickerDialog$2$invoke$lambda$8$lambda$7$lambda$6$$inlined$items$default$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    return invoke((RecipeWithDetails) p1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(RecipeWithDetails recipeWithDetails) {
                    return null;
                }
            };
            LazyColumn.items($filtered.size(), new Function1<Integer, Object>() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$RecipePickerDialog$2$invoke$lambda$8$lambda$7$lambda$6$$inlined$items$default$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int index) {
                    return key$iv.invoke($filtered.get(index));
                }
            }, new Function1<Integer, Object>() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$RecipePickerDialog$2$invoke$lambda$8$lambda$7$lambda$6$$inlined$items$default$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int index) {
                    return contentType$iv.invoke($filtered.get(index));
                }
            }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$RecipePickerDialog$2$invoke$lambda$8$lambda$7$lambda$6$$inlined$items$default$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                    invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                    Object value$iv;
                    Function0<ComposeUiNode> function0;
                    ComposerKt.sourceInformation($composer, "C152@7074L22:LazyDsl.kt#428nma");
                    int $dirty = $changed;
                    if (($changed & 6) == 0) {
                        $dirty |= $composer.changed($this$items) ? 4 : 2;
                    }
                    if (($changed & 48) == 0) {
                        $dirty |= $composer.changed(it) ? 32 : 16;
                    }
                    if (($dirty & 147) == 146 && $composer.getSkipping()) {
                        $composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-632812321, $dirty, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:152)");
                    }
                    int $changed2 = $dirty & 14;
                    final RecipeWithDetails recipe = (RecipeWithDetails) $filtered.get(it);
                    $composer.startReplaceGroup(1356433584);
                    ComposerKt.sourceInformation($composer, "C*272@11538L20,269@11391L608,281@12024L19:PlannerEntryDialog.kt#auin6u");
                    boolean z = true;
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    $composer.startReplaceGroup(1152138651);
                    ComposerKt.sourceInformation($composer, "CC(remember):PlannerEntryDialog.kt#9igjgp");
                    boolean zChanged = $composer.changed($onSelect);
                    if (((($changed2 & 112) ^ 48) <= 32 || !$composer.changedInstance(recipe)) && ($changed2 & 48) != 32) {
                        z = false;
                    }
                    boolean invalid$iv = zChanged | z;
                    Object it$iv = $composer.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        final Function1 function1 = $onSelect;
                        value$iv = new Function0<Unit>() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$RecipePickerDialog$2$1$2$1$2$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                function1.invoke(recipe);
                            }
                        };
                        $composer.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer.endReplaceGroup();
                    Modifier modifier$iv = PaddingKt.m682paddingVpY3zN4(ClickableKt.m269clickableXHw0xAI$default(modifierFillMaxWidth$default, false, null, null, (Function0) value$iv, 7, null), Dp.m6663constructorimpl(4), Dp.m6663constructorimpl(10));
                    ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                    CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!($composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer.startReusableNode();
                    if ($composer.getInserting()) {
                        function0 = constructor;
                        $composer.createNode(function0);
                    } else {
                        function0 = constructor;
                        $composer.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3674constructorimpl($composer);
                    Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                        $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                        $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                    }
                    Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                    int i = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    int i2 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, 1050693189, "C275@11693L56,276@11778L195:PlannerEntryDialog.kt#auin6u");
                    TextKt.m2714Text4IGK_g(recipe.getRecipe().getName(), (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (androidx.compose.ui.text.TextStyle) null, $composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 131038);
                    TextKt.m2714Text4IGK_g(recipe.getRecipe().getCategory() + " · " + recipe.getRecipe().getDifficulty(), (Modifier) null, Color.INSTANCE.m4211getGray0d7_KjU(), TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (androidx.compose.ui.text.TextStyle) null, $composer, 3456, 0, 131058);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    DividerKt.m2093HorizontalDivider9IZ8Weo(null, 0.0f, 0L, $composer, 0, 7);
                    $composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            if ($filtered.isEmpty()) {
                LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$PlannerEntryDialogKt.INSTANCE.m7143getLambda13$app_debug(), 3, null);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object invoke$lambda$8$lambda$7$lambda$6$lambda$2(RecipeWithDetails it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getRecipe().getId();
        }
    }

    private static final void MoveEntryDialog(final List<LocalDate> list, final String currentDate, final String currentSlot, final Function2<? super String, ? super String, Unit> function2, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-542676529);
        ComposerKt.sourceInformation($composer3, "C(MoveEntryDialog)P(4!2,3)346@14777L56,306@12752L1971,303@12648L2191:PlannerEntryDialog.kt#auin6u");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(currentDate) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(currentSlot) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 16384 : 8192;
        }
        if (($dirty & 9363) != 9362 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-542676529, $dirty, -1, "com.easycompra.app.ui.planner.MoveEntryDialog (PlannerEntryDialog.kt:301)");
            }
            DateTimeFormatter fmt = DateTimeFormatter.ISO_LOCAL_DATE;
            $composer2 = $composer3;
            AndroidAlertDialog_androidKt.m1782AlertDialogOix01E0(function0, ComposableSingletons$PlannerEntryDialogKt.INSTANCE.m7144getLambda14$app_debug(), null, ComposableLambdaKt.rememberComposableLambda(-270389607, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt.MoveEntryDialog.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C346@14779L52:PlannerEntryDialog.kt#auin6u");
                    if (($changed2 & 3) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-270389607, $changed2, -1, "com.easycompra.app.ui.planner.MoveEntryDialog.<anonymous> (PlannerEntryDialog.kt:346)");
                    }
                    ButtonKt.TextButton(function0, null, false, null, null, null, null, null, null, ComposableSingletons$PlannerEntryDialogKt.INSTANCE.m7145getLambda15$app_debug(), $composer4, 805306368, 510);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), null, ComposableSingletons$PlannerEntryDialogKt.INSTANCE.m7146getLambda16$app_debug(), ComposableLambdaKt.rememberComposableLambda(-1778041508, true, new C07252(list, currentDate, currentSlot, function2, fmt), $composer3, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, (($dirty >> 12) & 14) | 1772592, 0, 16276);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PlannerEntryDialogKt.MoveEntryDialog$lambda$42(list, currentDate, currentSlot, function2, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.planner.PlannerEntryDialogKt$MoveEntryDialog$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PlannerEntryDialog.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class C07252 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ String $currentDate;
        final /* synthetic */ String $currentSlot;
        final /* synthetic */ DateTimeFormatter $fmt;
        final /* synthetic */ Function2<String, String, Unit> $onMove;
        final /* synthetic */ List<LocalDate> $weekDates;

        /* JADX WARN: Multi-variable type inference failed */
        C07252(List<LocalDate> list, String str, String str2, Function2<? super String, ? super String, Unit> function2, DateTimeFormatter dateTimeFormatter) {
            this.$weekDates = list;
            this.$currentDate = str;
            this.$currentSlot = str2;
            this.$onMove = function2;
            this.$fmt = dateTimeFormatter;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            Object value$iv;
            ComposerKt.sourceInformation($composer, "C307@12777L1936,307@12766L1947:PlannerEntryDialog.kt#auin6u");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1778041508, $changed, -1, "com.easycompra.app.ui.planner.MoveEntryDialog.<anonymous> (PlannerEntryDialog.kt:307)");
            }
            $composer.startReplaceGroup(470553232);
            ComposerKt.sourceInformation($composer, "CC(remember):PlannerEntryDialog.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(this.$weekDates) | $composer.changed(this.$currentDate) | $composer.changed(this.$currentSlot) | $composer.changed(this.$onMove);
            final List<LocalDate> list = this.$weekDates;
            final DateTimeFormatter dateTimeFormatter = this.$fmt;
            final String str = this.$currentDate;
            final String str2 = this.$currentSlot;
            final Function2<String, String, Unit> function2 = this.$onMove;
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function1() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$MoveEntryDialog$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PlannerEntryDialogKt.C07252.invoke$lambda$4$lambda$3(list, dateTimeFormatter, str, str2, function2, (LazyListScope) obj);
                    }
                };
                $composer.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer.endReplaceGroup();
            LazyDslKt.LazyColumn(null, null, null, false, null, null, null, false, (Function1) value$iv, $composer, 0, 255);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$4$lambda$3(List $weekDates, DateTimeFormatter $fmt, String $currentDate, String $currentSlot, Function2 $onMove, LazyListScope LazyColumn) {
            Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
            List $this$forEach$iv = $weekDates;
            for (Object element$iv : $this$forEach$iv) {
                LocalDate date = (LocalDate) element$iv;
                String dateStr = date.format($fmt);
                String displayName = date.getDayOfWeek().getDisplayName(TextStyle.SHORT, new Locale("es"));
                Intrinsics.checkNotNullExpressionValue(displayName, "getDisplayName(...)");
                if (displayName.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    char it = displayName.charAt(0);
                    String strValueOf = String.valueOf(it);
                    Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
                    String upperCase = strValueOf.toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    StringBuilder sbAppend = sb.append((Object) upperCase);
                    String strSubstring = displayName.substring(1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    displayName = sbAppend.append(strSubstring).toString();
                }
                final String dayName = displayName + " " + date.getDayOfMonth();
                Iterable $this$forEach$iv2 = $this$forEach$iv;
                LazyListScope.item$default(LazyColumn, dateStr, null, ComposableLambdaKt.composableLambdaInstance(311594962, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$MoveEntryDialog$2$1$1$1$1
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                        invoke(lazyItemScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
                        Intrinsics.checkNotNullParameter(item, "$this$item");
                        ComposerKt.sourceInformation($composer, "C317@13296L11,314@13145L280:PlannerEntryDialog.kt#auin6u");
                        if (($changed & 17) == 16 && $composer.getSkipping()) {
                            $composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(311594962, $changed, -1, "com.easycompra.app.ui.planner.MoveEntryDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PlannerEntryDialog.kt:314)");
                        }
                        FontWeight bold = FontWeight.INSTANCE.getBold();
                        TextKt.m2714Text4IGK_g(dayName, PaddingKt.m685paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6663constructorimpl(8), 0.0f, Dp.m6663constructorimpl(4), 5, null), MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary(), 0L, (FontStyle) null, bold, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (androidx.compose.ui.text.TextStyle) null, $composer, 196656, 0, 131032);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), 2, null);
                for (Object element$iv2 : MealSlots.INSTANCE.getAll()) {
                    String slot = (String) element$iv2;
                    boolean isCurrent = Intrinsics.areEqual(dateStr, $currentDate) && Intrinsics.areEqual(slot, $currentSlot);
                    LazyListScope.item$default(LazyColumn, dateStr + "_" + slot, null, ComposableLambdaKt.composableLambdaInstance(658705984, true, new PlannerEntryDialogKt$MoveEntryDialog$2$1$1$1$2$1(isCurrent, $onMove, dateStr, slot)), 2, null);
                }
                $this$forEach$iv = $this$forEach$iv2;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String formatServings(float v) {
        if (v == ((float) ((int) v))) {
            return String.valueOf((int) v);
        }
        String str = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(v)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
