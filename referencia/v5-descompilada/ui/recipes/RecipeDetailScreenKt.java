package com.easycompra.app.ui.recipes;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CheckCircleKt;
import androidx.compose.material.icons.filled.FavoriteBorderKt;
import androidx.compose.material.icons.filled.FavoriteKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.CheckboxKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SliderKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.profileinstaller.ProfileVerifier;
import coil.compose.SingletonAsyncImageKt;
import com.easycompra.app.data.recipes.IngredientEntity;
import com.easycompra.app.data.recipes.IngredientResult;
import com.easycompra.app.data.recipes.IngredientStatus;
import com.easycompra.app.data.recipes.RecipeEntity;
import com.easycompra.app.data.recipes.RecipeStepEntity;
import com.easycompra.app.data.recipes.RecipeWithDetails;
import com.easycompra.app.data.recipes.UnitConverter;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: RecipeDetailScreen.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\u001d\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\r\u001a\u001f\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0003¢\u0006\u0002\u0010\u0012\u001aE\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00010\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010\u001b\u001aE\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010\u001f\u001a)\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\"2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u0017H\u0003¢\u0006\u0002\u0010#\u001a1\u0010$\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020%2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010&¨\u0006'²\u0006\n\u0010(\u001a\u00020)X\u008a\u0084\u0002²\u0006\n\u0010*\u001a\u00020+X\u008a\u008e\u0002"}, d2 = {"RecipeDetailScreen", "", "recipe", "Lcom/easycompra/app/data/recipes/RecipeWithDetails;", "viewModel", "Lcom/easycompra/app/ui/recipes/RecipeViewModel;", "onBack", "Lkotlin/Function0;", "(Lcom/easycompra/app/data/recipes/RecipeWithDetails;Lcom/easycompra/app/ui/recipes/RecipeViewModel;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "InfoItem", "label", "", "value", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "SectionHeader", "title", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SelectServingsDialog", "workflow", "Lcom/easycompra/app/ui/recipes/CookingWorkflow$SelectServings;", "onServingsChange", "Lkotlin/Function1;", "", "onConfirm", "onDismiss", "(Lcom/easycompra/app/ui/recipes/CookingWorkflow$SelectServings;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ComparisonDialog", "Lcom/easycompra/app/ui/recipes/CookingWorkflow$ShowComparison;", "onToggle", "(Lcom/easycompra/app/ui/recipes/CookingWorkflow$ShowComparison;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "IngredientResultRow", "result", "Lcom/easycompra/app/data/recipes/IngredientResult;", "(Lcom/easycompra/app/data/recipes/IngredientResult;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "SummaryDialog", "Lcom/easycompra/app/ui/recipes/CookingWorkflow$ShowSummary;", "(Lcom/easycompra/app/ui/recipes/CookingWorkflow$ShowSummary;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_debug", "state", "Lcom/easycompra/app/ui/recipes/RecipeUiState;", "showDeleteConfirm", ""}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RecipeDetailScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ComparisonDialog$lambda$29(CookingWorkflow.ShowComparison showComparison, Function1 function1, Function0 function0, Function0 function2, int i, Composer composer, int i2) {
        ComparisonDialog(showComparison, function1, function0, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit InfoItem$lambda$26(String str, String str2, int i, Composer composer, int i2) {
        InfoItem(str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IngredientResultRow$lambda$34(IngredientResult ingredientResult, Function1 function1, int i, Composer composer, int i2) {
        IngredientResultRow(ingredientResult, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecipeDetailScreen$lambda$24(RecipeWithDetails recipeWithDetails, RecipeViewModel recipeViewModel, Function0 function0, int i, Composer composer, int i2) throws Throwable {
        RecipeDetailScreen(recipeWithDetails, recipeViewModel, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SectionHeader$lambda$27(String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SectionHeader(str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectServingsDialog$lambda$28(CookingWorkflow.SelectServings selectServings, Function1 function1, Function0 function0, Function0 function2, int i, Composer composer, int i2) {
        SelectServingsDialog(selectServings, function1, function0, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SummaryDialog$lambda$35(CookingWorkflow.ShowSummary showSummary, Function0 function0, Function0 function1, int i, Composer composer, int i2) {
        SummaryDialog(showSummary, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void RecipeDetailScreen(final RecipeWithDetails recipe, final RecipeViewModel viewModel, final Function0<Unit> onBack, Composer $composer, final int $changed) throws Throwable {
        Object value$iv;
        Composer $composer2;
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
        Intrinsics.checkNotNullParameter(recipe, "recipe");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Composer $composer3 = $composer.startRestartGroup(302380457);
        ComposerKt.sourceInformation($composer3, "C(RecipeDetailScreen)P(1,2)70@3085L16,72@3157L34:RecipeDetailScreen.kt#y43rd3");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(recipe) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(viewModel) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(onBack) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 147) != 146 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(302380457, $dirty2, -1, "com.easycompra.app.ui.recipes.RecipeDetailScreen (RecipeDetailScreen.kt:69)");
            }
            State state$delegate = SnapshotStateKt.collectAsState(viewModel.getState(), null, $composer3, 0, 1);
            final RecipeEntity r = recipe.getRecipe();
            $composer3.startReplaceGroup(-282217214);
            ComposerKt.sourceInformation($composer3, "CC(remember):RecipeDetailScreen.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState showDeleteConfirm$delegate = (MutableState) value$iv;
            $composer3.endReplaceGroup();
            if (RecipeDetailScreen$lambda$0(state$delegate).getCooking() != null) {
                $composer3.startReplaceGroup(-158689796);
                ComposerKt.sourceInformation($composer3, "");
                CookingWorkflow workflow = RecipeDetailScreen$lambda$0(state$delegate).getCooking();
                Intrinsics.checkNotNull(workflow);
                if (workflow instanceof CookingWorkflow.SelectServings) {
                    $composer3.startReplaceGroup(-282210983);
                    ComposerKt.sourceInformation($composer3, "79@3446L32,80@3512L31,81@3577L30,77@3344L281");
                    CookingWorkflow.SelectServings selectServings = (CookingWorkflow.SelectServings) workflow;
                    $composer3.startReplaceGroup(-282207968);
                    ComposerKt.sourceInformation($composer3, "CC(remember):RecipeDetailScreen.kt#9igjgp");
                    boolean invalid$iv = $composer3.changedInstance(viewModel);
                    Object it$iv2 = $composer3.rememberedValue();
                    if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                        value$iv9 = new Function1() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$$ExternalSyntheticLambda13
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RecipeDetailScreenKt.RecipeDetailScreen$lambda$5$lambda$4(viewModel, ((Float) obj).floatValue());
                            }
                        };
                        $composer3.updateRememberedValue(value$iv9);
                    } else {
                        value$iv9 = it$iv2;
                    }
                    Function1 function1 = (Function1) value$iv9;
                    $composer3.endReplaceGroup();
                    $composer3.startReplaceGroup(-282205857);
                    ComposerKt.sourceInformation($composer3, "CC(remember):RecipeDetailScreen.kt#9igjgp");
                    boolean invalid$iv2 = $composer3.changedInstance(viewModel);
                    Object it$iv3 = $composer3.rememberedValue();
                    if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                        value$iv10 = new Function0() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return RecipeDetailScreenKt.RecipeDetailScreen$lambda$7$lambda$6(viewModel);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv10);
                    } else {
                        value$iv10 = it$iv3;
                    }
                    Function0 function0 = (Function0) value$iv10;
                    $composer3.endReplaceGroup();
                    $composer3.startReplaceGroup(-282203778);
                    ComposerKt.sourceInformation($composer3, "CC(remember):RecipeDetailScreen.kt#9igjgp");
                    boolean invalid$iv3 = $composer3.changedInstance(viewModel);
                    Object it$iv4 = $composer3.rememberedValue();
                    if (invalid$iv3 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                        value$iv11 = new Function0() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return RecipeDetailScreenKt.RecipeDetailScreen$lambda$9$lambda$8(viewModel);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv11);
                    } else {
                        value$iv11 = it$iv4;
                    }
                    $composer3.endReplaceGroup();
                    SelectServingsDialog(selectServings, function1, function0, (Function0) value$iv11, $composer3, 0);
                    $composer3.endReplaceGroup();
                } else if (workflow instanceof CookingWorkflow.ShowComparison) {
                    $composer3.startReplaceGroup(-282200264);
                    ComposerKt.sourceInformation($composer3, "85@3769L41,86@3844L33,87@3911L30,83@3679L280");
                    CookingWorkflow.ShowComparison showComparison = (CookingWorkflow.ShowComparison) workflow;
                    $composer3.startReplaceGroup(-282197623);
                    ComposerKt.sourceInformation($composer3, "CC(remember):RecipeDetailScreen.kt#9igjgp");
                    boolean invalid$iv4 = $composer3.changedInstance(viewModel);
                    Object it$iv5 = $composer3.rememberedValue();
                    if (invalid$iv4 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                        value$iv6 = new Function1() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RecipeDetailScreenKt.RecipeDetailScreen$lambda$11$lambda$10(viewModel, (String) obj);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv6);
                    } else {
                        value$iv6 = it$iv5;
                    }
                    Function1 function2 = (Function1) value$iv6;
                    $composer3.endReplaceGroup();
                    $composer3.startReplaceGroup(-282195231);
                    ComposerKt.sourceInformation($composer3, "CC(remember):RecipeDetailScreen.kt#9igjgp");
                    boolean invalid$iv5 = $composer3.changedInstance(viewModel);
                    Object it$iv6 = $composer3.rememberedValue();
                    if (invalid$iv5 || it$iv6 == Composer.INSTANCE.getEmpty()) {
                        value$iv7 = new Function0() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return RecipeDetailScreenKt.RecipeDetailScreen$lambda$13$lambda$12(viewModel);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv7);
                    } else {
                        value$iv7 = it$iv6;
                    }
                    Function0 function3 = (Function0) value$iv7;
                    $composer3.endReplaceGroup();
                    $composer3.startReplaceGroup(-282193090);
                    ComposerKt.sourceInformation($composer3, "CC(remember):RecipeDetailScreen.kt#9igjgp");
                    boolean invalid$iv6 = $composer3.changedInstance(viewModel);
                    Object it$iv7 = $composer3.rememberedValue();
                    if (invalid$iv6 || it$iv7 == Composer.INSTANCE.getEmpty()) {
                        value$iv8 = new Function0() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return RecipeDetailScreenKt.RecipeDetailScreen$lambda$15$lambda$14(viewModel);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv8);
                    } else {
                        value$iv8 = it$iv7;
                    }
                    $composer3.endReplaceGroup();
                    ComparisonDialog(showComparison, function2, function3, (Function0) value$iv8, $composer3, 0);
                    $composer3.endReplaceGroup();
                } else {
                    if (!(workflow instanceof CookingWorkflow.ShowSummary)) {
                        $composer3.startReplaceGroup(-282213266);
                        $composer3.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    $composer3.startReplaceGroup(-282189751);
                    ComposerKt.sourceInformation($composer3, "91@4098L31,92@4163L30,89@4010L201");
                    CookingWorkflow.ShowSummary showSummary = (CookingWorkflow.ShowSummary) workflow;
                    $composer3.startReplaceGroup(-282187105);
                    ComposerKt.sourceInformation($composer3, "CC(remember):RecipeDetailScreen.kt#9igjgp");
                    boolean invalid$iv7 = $composer3.changedInstance(viewModel);
                    Object it$iv8 = $composer3.rememberedValue();
                    if (invalid$iv7 || it$iv8 == Composer.INSTANCE.getEmpty()) {
                        value$iv4 = new Function0() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return RecipeDetailScreenKt.RecipeDetailScreen$lambda$17$lambda$16(viewModel);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv4);
                    } else {
                        value$iv4 = it$iv8;
                    }
                    Function0 function4 = (Function0) value$iv4;
                    $composer3.endReplaceGroup();
                    $composer3.startReplaceGroup(-282185026);
                    ComposerKt.sourceInformation($composer3, "CC(remember):RecipeDetailScreen.kt#9igjgp");
                    boolean invalid$iv8 = $composer3.changedInstance(viewModel);
                    Object it$iv9 = $composer3.rememberedValue();
                    if (invalid$iv8 || it$iv9 == Composer.INSTANCE.getEmpty()) {
                        value$iv5 = new Function0() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return RecipeDetailScreenKt.RecipeDetailScreen$lambda$19$lambda$18(viewModel);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv5);
                    } else {
                        value$iv5 = it$iv9;
                    }
                    $composer3.endReplaceGroup();
                    SummaryDialog(showSummary, function4, (Function0) value$iv5, $composer3, 0);
                    $composer3.endReplaceGroup();
                }
                $composer3.endReplaceGroup();
                $composer2 = $composer3;
            } else if (RecipeDetailScreen$lambda$0(state$delegate).getShowCreateEdit()) {
                $composer3.startReplaceGroup(-157690511);
                ComposerKt.sourceInformation($composer3, "101@4421L33,98@4283L185");
                RecipeWithDetails editingRecipe = RecipeDetailScreen$lambda$0(state$delegate).getEditingRecipe();
                $composer3.startReplaceGroup(-282176767);
                ComposerKt.sourceInformation($composer3, "CC(remember):RecipeDetailScreen.kt#9igjgp");
                boolean invalid$iv9 = $composer3.changedInstance(viewModel);
                Object it$iv10 = $composer3.rememberedValue();
                if (invalid$iv9 || it$iv10 == Composer.INSTANCE.getEmpty()) {
                    value$iv3 = new Function0() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return RecipeDetailScreenKt.RecipeDetailScreen$lambda$21$lambda$20(viewModel);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv3);
                } else {
                    value$iv3 = it$iv10;
                }
                $composer3.endReplaceGroup();
                CreateEditRecipeScreenKt.CreateEditRecipeScreen(viewModel, editingRecipe, (Function0) value$iv3, $composer3, ($dirty2 >> 3) & 14);
                $composer3.endReplaceGroup();
                $composer2 = $composer3;
            } else {
                $composer3.startReplaceGroup(-157124079);
                ComposerKt.sourceInformation($composer3, "125@5335L1544,154@6894L8809,124@5300L10403");
                $composer3.startReplaceGroup(-282173176);
                ComposerKt.sourceInformation($composer3, "108@4603L29,111@4811L285,118@5134L120,110@4718L55,107@4551L721");
                if (RecipeDetailScreen$lambda$2(showDeleteConfirm$delegate)) {
                    $composer3.startReplaceGroup(-282170947);
                    ComposerKt.sourceInformation($composer3, "CC(remember):RecipeDetailScreen.kt#9igjgp");
                    Object it$iv11 = $composer3.rememberedValue();
                    if (it$iv11 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new Function0() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return RecipeDetailScreenKt.RecipeDetailScreen$lambda$23$lambda$22(showDeleteConfirm$delegate);
                            }
                        };
                        $composer3.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv11;
                    }
                    $composer3.endReplaceGroup();
                    AndroidAlertDialog_androidKt.m1782AlertDialogOix01E0((Function0) value$iv2, ComposableLambdaKt.rememberComposableLambda(-1302544811, true, new AnonymousClass11(viewModel, r, onBack, showDeleteConfirm$delegate), $composer3, 54), null, ComposableLambdaKt.rememberComposableLambda(-653952041, true, new AnonymousClass12(showDeleteConfirm$delegate), $composer3, 54), null, ComposableSingletons$RecipeDetailScreenKt.INSTANCE.m7206getLambda3$app_debug(), ComposableLambdaKt.rememberComposableLambda(-1828546534, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt.RecipeDetailScreen.13
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer4, int $changed2) {
                            ComposerKt.sourceInformation($composer4, "C110@4720L51:RecipeDetailScreen.kt#y43rd3");
                            if (($changed2 & 3) == 2 && $composer4.getSkipping()) {
                                $composer4.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1828546534, $changed2, -1, "com.easycompra.app.ui.recipes.RecipeDetailScreen.<anonymous> (RecipeDetailScreen.kt:110)");
                            }
                            TextKt.m2714Text4IGK_g("¿Seguro que quieres eliminar \"" + r.getName() + "\"?", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131070);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer3, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer3, 1772598, 0, 16276);
                }
                $composer3.endReplaceGroup();
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1948452804, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt.RecipeDetailScreen.14
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer4, int $changed2) {
                        ComposerKt.sourceInformation($composer4, "C128@5445L220,133@5701L876,149@6706L11,150@6794L11,148@6630L209,126@5357L1504:RecipeDetailScreen.kt#y43rd3");
                        if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1948452804, $changed2, -1, "com.easycompra.app.ui.recipes.RecipeDetailScreen.<anonymous> (RecipeDetailScreen.kt:126)");
                            }
                            Function2<Composer, Integer, Unit> function2M7207getLambda4$app_debug = ComposableSingletons$RecipeDetailScreenKt.INSTANCE.m7207getLambda4$app_debug();
                            final Function0<Unit> function5 = onBack;
                            AppBarKt.m1794TopAppBarGHTll3U(function2M7207getLambda4$app_debug, null, ComposableLambdaKt.rememberComposableLambda(2064398730, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt.RecipeDetailScreen.14.1
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                    invoke(composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer $composer5, int $changed3) {
                                    ComposerKt.sourceInformation($composer5, "C129@5475L164:RecipeDetailScreen.kt#y43rd3");
                                    if (($changed3 & 3) != 2 || !$composer5.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(2064398730, $changed3, -1, "com.easycompra.app.ui.recipes.RecipeDetailScreen.<anonymous>.<anonymous> (RecipeDetailScreen.kt:129)");
                                        }
                                        IconButtonKt.IconButton(function5, null, false, null, null, ComposableSingletons$RecipeDetailScreenKt.INSTANCE.m7208getLambda5$app_debug(), $composer5, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer5.skipToGroupEnd();
                                }
                            }, $composer4, 54), ComposableLambdaKt.rememberComposableLambda(-1615764429, true, new AnonymousClass2(viewModel, recipe, r, showDeleteConfirm$delegate), $composer4, 54), 0.0f, null, TopAppBarDefaults.INSTANCE.m2885topAppBarColorszjMxDiM(MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getPrimary(), MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getPrimary(), 0L, 0L, 0L, $composer4, TopAppBarDefaults.$stable << 15, 28), null, $composer4, 3462, 178);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }

                    /* JADX INFO: renamed from: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$RecipeDetailScreen$14$2, reason: invalid class name */
                    /* JADX INFO: compiled from: RecipeDetailScreen.kt */
                    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                    static final class AnonymousClass2 implements Function3<RowScope, Composer, Integer, Unit> {
                        final /* synthetic */ RecipeEntity $r;
                        final /* synthetic */ RecipeWithDetails $recipe;
                        final /* synthetic */ MutableState<Boolean> $showDeleteConfirm$delegate;
                        final /* synthetic */ RecipeViewModel $viewModel;

                        AnonymousClass2(RecipeViewModel recipeViewModel, RecipeWithDetails recipeWithDetails, RecipeEntity recipeEntity, MutableState<Boolean> mutableState) {
                            this.$viewModel = recipeViewModel;
                            this.$recipe = recipeWithDetails;
                            this.$r = recipeEntity;
                            this.$showDeleteConfirm$delegate = mutableState;
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                            invoke(rowScope, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final Unit invoke$lambda$1$lambda$0(RecipeViewModel $viewModel, RecipeWithDetails $recipe) {
                            $viewModel.toggleFavorite($recipe);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(RowScope TopAppBar, Composer $composer, int $changed) {
                            Object value$iv;
                            Object value$iv2;
                            Object value$iv3;
                            Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
                            ComposerKt.sourceInformation($composer, "C134@5752L36,134@5790L359,134@5731L418,141@6199L30,141@6178L171,144@6399L28,144@6378L173:RecipeDetailScreen.kt#y43rd3");
                            if (($changed & 17) == 16 && $composer.getSkipping()) {
                                $composer.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1615764429, $changed, -1, "com.easycompra.app.ui.recipes.RecipeDetailScreen.<anonymous>.<anonymous> (RecipeDetailScreen.kt:134)");
                            }
                            $composer.startReplaceGroup(861976290);
                            ComposerKt.sourceInformation($composer, "CC(remember):RecipeDetailScreen.kt#9igjgp");
                            boolean invalid$iv = $composer.changedInstance(this.$viewModel) | $composer.changedInstance(this.$recipe);
                            final RecipeViewModel recipeViewModel = this.$viewModel;
                            final RecipeWithDetails recipeWithDetails = this.$recipe;
                            Object it$iv = $composer.rememberedValue();
                            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                                value$iv = new Function0() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$RecipeDetailScreen$14$2$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return RecipeDetailScreenKt.AnonymousClass14.AnonymousClass2.invoke$lambda$1$lambda$0(recipeViewModel, recipeWithDetails);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv);
                            } else {
                                value$iv = it$iv;
                            }
                            $composer.endReplaceGroup();
                            final RecipeEntity recipeEntity = this.$r;
                            IconButtonKt.IconButton((Function0) value$iv, null, false, null, null, ComposableLambdaKt.rememberComposableLambda(-1797477450, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt.RecipeDetailScreen.14.2.2
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                    invoke(composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer $composer2, int $changed2) {
                                    ComposerKt.sourceInformation($composer2, "C135@5824L295:RecipeDetailScreen.kt#y43rd3");
                                    if (($changed2 & 3) != 2 || !$composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1797477450, $changed2, -1, "com.easycompra.app.ui.recipes.RecipeDetailScreen.<anonymous>.<anonymous>.<anonymous> (RecipeDetailScreen.kt:135)");
                                        }
                                        IconKt.m2171Iconww6aTOc(recipeEntity.isFavorite() ? FavoriteKt.getFavorite(Icons.INSTANCE.getDefault()) : FavoriteBorderKt.getFavoriteBorder(Icons.INSTANCE.getDefault()), "Favorita", (Modifier) null, recipeEntity.isFavorite() ? ColorKt.Color(4294197086L) : Color.INSTANCE.m4218getWhite0d7_KjU(), $composer2, 48, 4);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer2.skipToGroupEnd();
                                }
                            }, $composer, 54), $composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                            $composer.startReplaceGroup(861990588);
                            ComposerKt.sourceInformation($composer, "CC(remember):RecipeDetailScreen.kt#9igjgp");
                            boolean invalid$iv2 = $composer.changedInstance(this.$viewModel) | $composer.changedInstance(this.$recipe);
                            final RecipeViewModel recipeViewModel2 = this.$viewModel;
                            final RecipeWithDetails recipeWithDetails2 = this.$recipe;
                            Object it$iv2 = $composer.rememberedValue();
                            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                value$iv2 = new Function0() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$RecipeDetailScreen$14$2$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return RecipeDetailScreenKt.AnonymousClass14.AnonymousClass2.invoke$lambda$3$lambda$2(recipeViewModel2, recipeWithDetails2);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv2);
                            } else {
                                value$iv2 = it$iv2;
                            }
                            $composer.endReplaceGroup();
                            IconButtonKt.IconButton((Function0) value$iv2, null, false, null, null, ComposableSingletons$RecipeDetailScreenKt.INSTANCE.m7209getLambda6$app_debug(), $composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                            $composer.startReplaceGroup(861996986);
                            ComposerKt.sourceInformation($composer, "CC(remember):RecipeDetailScreen.kt#9igjgp");
                            final MutableState<Boolean> mutableState = this.$showDeleteConfirm$delegate;
                            Object it$iv3 = $composer.rememberedValue();
                            if (it$iv3 == Composer.INSTANCE.getEmpty()) {
                                value$iv3 = new Function0() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$RecipeDetailScreen$14$2$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return RecipeDetailScreenKt.AnonymousClass14.AnonymousClass2.invoke$lambda$5$lambda$4(mutableState);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv3);
                            } else {
                                value$iv3 = it$iv3;
                            }
                            $composer.endReplaceGroup();
                            IconButtonKt.IconButton((Function0) value$iv3, null, false, null, null, ComposableSingletons$RecipeDetailScreenKt.INSTANCE.m7210getLambda7$app_debug(), $composer, 196614, 30);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final Unit invoke$lambda$3$lambda$2(RecipeViewModel $viewModel, RecipeWithDetails $recipe) {
                            $viewModel.showEdit($recipe);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final Unit invoke$lambda$5$lambda$4(MutableState $showDeleteConfirm$delegate) {
                            RecipeDetailScreenKt.RecipeDetailScreen$lambda$3($showDeleteConfirm$delegate, true);
                            return Unit.INSTANCE;
                        }
                    }
                }, $composer3, 54);
                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(261081817, true, new AnonymousClass15(r, viewModel, recipe), $composer3, 54);
                $composer2 = $composer3;
                ScaffoldKt.m2429ScaffoldTvnljyQ(null, composableLambdaRememberComposableLambda, null, null, null, 0, 0L, 0L, null, composableLambdaRememberComposableLambda2, $composer2, 805306416, 509);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RecipeDetailScreenKt.RecipeDetailScreen$lambda$24(recipe, viewModel, onBack, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final RecipeUiState RecipeDetailScreen$lambda$0(State<RecipeUiState> state) {
        Object thisObj$iv = state.getValue();
        return (RecipeUiState) thisObj$iv;
    }

    private static final boolean RecipeDetailScreen$lambda$2(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RecipeDetailScreen$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecipeDetailScreen$lambda$5$lambda$4(RecipeViewModel $viewModel, float it) {
        $viewModel.updateServings(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecipeDetailScreen$lambda$7$lambda$6(RecipeViewModel $viewModel) {
        $viewModel.confirmServings();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecipeDetailScreen$lambda$9$lambda$8(RecipeViewModel $viewModel) {
        $viewModel.dismissCooking();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecipeDetailScreen$lambda$11$lambda$10(RecipeViewModel $viewModel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $viewModel.toggleUnlinkedAddToCart(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecipeDetailScreen$lambda$13$lambda$12(RecipeViewModel $viewModel) {
        $viewModel.confirmComparison();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecipeDetailScreen$lambda$15$lambda$14(RecipeViewModel $viewModel) {
        $viewModel.dismissCooking();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecipeDetailScreen$lambda$17$lambda$16(RecipeViewModel $viewModel) {
        $viewModel.confirmShopping();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecipeDetailScreen$lambda$19$lambda$18(RecipeViewModel $viewModel) {
        $viewModel.dismissCooking();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecipeDetailScreen$lambda$21$lambda$20(RecipeViewModel $viewModel) {
        $viewModel.dismissCreateEdit();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecipeDetailScreen$lambda$23$lambda$22(MutableState $showDeleteConfirm$delegate) {
        RecipeDetailScreen$lambda$3($showDeleteConfirm$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$RecipeDetailScreen$11, reason: invalid class name */
    /* JADX INFO: compiled from: RecipeDetailScreen.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass11 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Function0<Unit> $onBack;
        final /* synthetic */ RecipeEntity $r;
        final /* synthetic */ MutableState<Boolean> $showDeleteConfirm$delegate;
        final /* synthetic */ RecipeViewModel $viewModel;

        AnonymousClass11(RecipeViewModel recipeViewModel, RecipeEntity recipeEntity, Function0<Unit> function0, MutableState<Boolean> mutableState) {
            this.$viewModel = recipeViewModel;
            this.$r = recipeEntity;
            this.$onBack = function0;
            this.$showDeleteConfirm$delegate = mutableState;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            Object value$iv;
            ComposerKt.sourceInformation($composer, "C112@4858L175,112@4837L237:RecipeDetailScreen.kt#y43rd3");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1302544811, $changed, -1, "com.easycompra.app.ui.recipes.RecipeDetailScreen.<anonymous> (RecipeDetailScreen.kt:112)");
            }
            $composer.startReplaceGroup(317353006);
            ComposerKt.sourceInformation($composer, "CC(remember):RecipeDetailScreen.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(this.$viewModel) | $composer.changed(this.$r) | $composer.changed(this.$onBack);
            final RecipeViewModel recipeViewModel = this.$viewModel;
            final RecipeEntity recipeEntity = this.$r;
            final Function0<Unit> function0 = this.$onBack;
            final MutableState<Boolean> mutableState = this.$showDeleteConfirm$delegate;
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function0() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$RecipeDetailScreen$11$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RecipeDetailScreenKt.AnonymousClass11.invoke$lambda$1$lambda$0(recipeViewModel, recipeEntity, function0, mutableState);
                    }
                };
                $composer.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer.endReplaceGroup();
            ButtonKt.TextButton((Function0) value$iv, null, false, null, null, null, null, null, null, ComposableSingletons$RecipeDetailScreenKt.INSTANCE.m7197getLambda1$app_debug(), $composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$1$lambda$0(RecipeViewModel $viewModel, RecipeEntity $r, Function0 $onBack, MutableState $showDeleteConfirm$delegate) {
            $viewModel.deleteRecipe($r.getId());
            RecipeDetailScreenKt.RecipeDetailScreen$lambda$3($showDeleteConfirm$delegate, false);
            $onBack.invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$RecipeDetailScreen$12, reason: invalid class name */
    /* JADX INFO: compiled from: RecipeDetailScreen.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass12 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ MutableState<Boolean> $showDeleteConfirm$delegate;

        AnonymousClass12(MutableState<Boolean> mutableState) {
            this.$showDeleteConfirm$delegate = mutableState;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$1$lambda$0(MutableState $showDeleteConfirm$delegate) {
            RecipeDetailScreenKt.RecipeDetailScreen$lambda$3($showDeleteConfirm$delegate, false);
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            Object value$iv;
            ComposerKt.sourceInformation($composer, "C119@5181L29,119@5160L72:RecipeDetailScreen.kt#y43rd3");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-653952041, $changed, -1, "com.easycompra.app.ui.recipes.RecipeDetailScreen.<anonymous> (RecipeDetailScreen.kt:119)");
            }
            $composer.startReplaceGroup(317363196);
            ComposerKt.sourceInformation($composer, "CC(remember):RecipeDetailScreen.kt#9igjgp");
            final MutableState<Boolean> mutableState = this.$showDeleteConfirm$delegate;
            Object it$iv = $composer.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function0() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$RecipeDetailScreen$12$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RecipeDetailScreenKt.AnonymousClass12.invoke$lambda$1$lambda$0(mutableState);
                    }
                };
                $composer.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer.endReplaceGroup();
            ButtonKt.TextButton((Function0) value$iv, null, false, null, null, null, null, null, null, ComposableSingletons$RecipeDetailScreenKt.INSTANCE.m7205getLambda2$app_debug(), $composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$RecipeDetailScreen$15, reason: invalid class name */
    /* JADX INFO: compiled from: RecipeDetailScreen.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass15 implements Function3<PaddingValues, Composer, Integer, Unit> {
        final /* synthetic */ RecipeEntity $r;
        final /* synthetic */ RecipeWithDetails $recipe;
        final /* synthetic */ RecipeViewModel $viewModel;

        AnonymousClass15(RecipeEntity recipeEntity, RecipeViewModel recipeViewModel, RecipeWithDetails recipeWithDetails) {
            this.$r = recipeEntity;
            this.$viewModel = recipeViewModel;
            this.$recipe = recipeWithDetails;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer, Integer num) {
            invoke(paddingValues, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(PaddingValues padding, Composer $composer, int $changed) {
            Object value$iv;
            Intrinsics.checkNotNullParameter(padding, "padding");
            ComposerKt.sourceInformation($composer, "C157@7024L8665,155@6923L8766:RecipeDetailScreen.kt#y43rd3");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= $composer.changed(padding) ? 4 : 2;
            }
            int $dirty2 = $dirty;
            if (($dirty2 & 19) != 18 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(261081817, $dirty2, -1, "com.easycompra.app.ui.recipes.RecipeDetailScreen.<anonymous> (RecipeDetailScreen.kt:155)");
                }
                Modifier modifierPadding = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), padding);
                $composer.startReplaceGroup(317430808);
                ComposerKt.sourceInformation($composer, "CC(remember):RecipeDetailScreen.kt#9igjgp");
                boolean invalid$iv = $composer.changed(this.$r) | $composer.changedInstance(this.$viewModel) | $composer.changedInstance(this.$recipe);
                final RecipeEntity recipeEntity = this.$r;
                final RecipeWithDetails recipeWithDetails = this.$recipe;
                final RecipeViewModel recipeViewModel = this.$viewModel;
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function1() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$RecipeDetailScreen$15$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RecipeDetailScreenKt.AnonymousClass15.invoke$lambda$11$lambda$10(recipeEntity, recipeWithDetails, recipeViewModel, (LazyListScope) obj);
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                $composer.endReplaceGroup();
                LazyDslKt.LazyColumn(modifierPadding, null, null, false, null, null, null, false, (Function1) value$iv, $composer, 0, 254);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$11$lambda$10(final RecipeEntity $r, final RecipeWithDetails $recipe, RecipeViewModel $viewModel, LazyListScope LazyColumn) {
            Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1441323667, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$RecipeDetailScreen$15$1$1$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                    invoke(lazyItemScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
                    Function0<ComposeUiNode> function0;
                    Function0<ComposeUiNode> function1;
                    Function0<ComposeUiNode> function2;
                    Function0<ComposeUiNode> function3;
                    Intrinsics.checkNotNullParameter(item, "$this$item");
                    ComposerKt.sourceInformation($composer, "C164@7317L11,160@7110L1640,189@8775L29:RecipeDetailScreen.kt#y43rd3");
                    if (($changed & 17) != 16 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1441323667, $changed, -1, "com.easycompra.app.ui.recipes.RecipeDetailScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RecipeDetailScreen.kt:160)");
                        }
                        Modifier modifier$iv = BackgroundKt.m236backgroundbw27NRU$default(SizeKt.m712height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6663constructorimpl(220)), MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimaryContainer(), null, 2, null);
                        RecipeEntity recipeEntity = $r;
                        ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
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
                        ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int i2 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, 565592767, "C174@7831L893:RecipeDetailScreen.kt#y43rd3");
                        $composer.startReplaceGroup(156791338);
                        ComposerKt.sourceInformation($composer, "167@7466L306");
                        if (!StringsKt.isBlank(recipeEntity.getPhotoUrl())) {
                            SingletonAsyncImageKt.m7012AsyncImagegl8XCv8(recipeEntity.getPhotoUrl(), recipeEntity.getName(), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, false, null, $composer, 1573248, 0, 4024);
                        }
                        $composer.endReplaceGroup();
                        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Brush.Companion companion = Brush.INSTANCE;
                        long jM4207getBlack0d7_KjU = Color.INSTANCE.m4207getBlack0d7_KjU();
                        Modifier modifier$iv2 = BackgroundKt.background$default(modifierFillMaxSize$default, Brush.Companion.m4138verticalGradient8A3gB4$default(companion, CollectionsKt.listOf((Object[]) new Color[]{Color.m4171boximpl(Color.INSTANCE.m4216getTransparent0d7_KjU()), Color.m4171boximpl(Color.m4179copywmQWz5c(jM4207getBlack0d7_KjU, (14 & 1) != 0 ? Color.m4183getAlphaimpl(jM4207getBlack0d7_KjU) : 0.7f, (14 & 2) != 0 ? Color.m4187getRedimpl(jM4207getBlack0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m4186getGreenimpl(jM4207getBlack0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m4184getBlueimpl(jM4207getBlack0d7_KjU) : 0.0f))}), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null);
                        Alignment contentAlignment$iv2 = Alignment.INSTANCE.getBottomStart();
                        ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                        int $changed$iv$iv2 = (54 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                        CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer.startReusableNode();
                        if ($composer.getInserting()) {
                            function1 = constructor2;
                            $composer.createNode(function1);
                        } else {
                            function1 = constructor2;
                            $composer.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3674constructorimpl($composer);
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                        }
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                        int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        int i4 = ((54 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, -231547557, "C180@8200L494:RecipeDetailScreen.kt#y43rd3");
                        Modifier modifier$iv3 = PaddingKt.m681padding3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(16));
                        ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                        int $changed$iv$iv3 = (6 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                        CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer.startReusableNode();
                        if ($composer.getInserting()) {
                            function2 = constructor3;
                            $composer.createNode(function2);
                        } else {
                            function2 = constructor3;
                            $composer.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3674constructorimpl($composer);
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                            $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                            $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
                        }
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                        int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i6 = ((6 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, -900370897, "C181@8281L81,182@8399L261:RecipeDetailScreen.kt#y43rd3");
                        TextKt.m2714Text4IGK_g(recipeEntity.getName(), (Modifier) null, Color.INSTANCE.m4218getWhite0d7_KjU(), TextUnitKt.getSp(22), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 200064, 0, 131026);
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(8));
                        ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                        Modifier modifier$iv4 = Modifier.INSTANCE;
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                        MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                        int $changed$iv$iv4 = (48 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                        CompositionLocalMap localMap$iv$iv4 = $composer.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer, modifier$iv4);
                        Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer.startReusableNode();
                        if ($composer.getInserting()) {
                            function3 = constructor4;
                            $composer.createNode(function3);
                        } else {
                            function3 = constructor4;
                            $composer.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.m3674constructorimpl($composer);
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv4.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv4.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv4))) {
                            $this$Layout_u24lambda_u240$iv$iv4.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv4));
                            $this$Layout_u24lambda_u240$iv$iv4.apply(Integer.valueOf(compositeKeyHash$iv$iv4), setCompositeKeyHash4);
                        }
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                        int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        int i8 = ((48 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, 1219276750, "C183@8497L29:RecipeDetailScreen.kt#y43rd3");
                        RecipeListScreenKt.DifficultyBadge(recipeEntity.getDifficulty(), $composer, 0);
                        $composer.startReplaceGroup(1147712335);
                        ComposerKt.sourceInformation($composer, "184@8594L28");
                        if (recipeEntity.getPrepTimeMinutes() > 0) {
                            RecipeListScreenKt.TimeBadge(recipeEntity.getPrepTimeMinutes(), $composer, 0);
                        }
                        $composer.endReplaceGroup();
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
                        SpacerKt.Spacer(SizeKt.m712height3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(8)), $composer, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer.skipToGroupEnd();
                }
            }), 3, null);
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(274915492, true, new RecipeDetailScreenKt$RecipeDetailScreen$15$1$1$2($viewModel, $recipe)), 3, null);
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-119488347, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$RecipeDetailScreen$15$1$1$3
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                    invoke(lazyItemScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
                    Intrinsics.checkNotNullParameter(item, "$this$item");
                    ComposerKt.sourceInformation($composer, "C212@9906L11,212@9864L69,213@9960L907,210@9716L1151,230@10892L30:RecipeDetailScreen.kt#y43rd3");
                    if (($changed & 17) != 16 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-119488347, $changed, -1, "com.easycompra.app.ui.recipes.RecipeDetailScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RecipeDetailScreen.kt:210)");
                        }
                        Modifier modifierM683paddingVpY3zN4$default = PaddingKt.m683paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6663constructorimpl(16), 0.0f, 2, null);
                        CardColors cardColorsM1850cardColorsro_MJ88 = CardDefaults.INSTANCE.m1850cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceVariant(), 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14);
                        final RecipeEntity recipeEntity = $r;
                        CardKt.Card(modifierM683paddingVpY3zN4$default, null, cardColorsM1850cardColorsro_MJ88, null, null, ComposableLambdaKt.rememberComposableLambda(-1142381289, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$RecipeDetailScreen$15$1$1$3.1
                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                                invoke(columnScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(ColumnScope Card, Composer $composer2, int $changed2) {
                                Function0<ComposeUiNode> function0;
                                Intrinsics.checkNotNullParameter(Card, "$this$Card");
                                ComposerKt.sourceInformation($composer2, "C214@9990L851:RecipeDetailScreen.kt#y43rd3");
                                if (($changed2 & 17) != 16 || !$composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1142381289, $changed2, -1, "com.easycompra.app.ui.recipes.RecipeDetailScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RecipeDetailScreen.kt:214)");
                                    }
                                    Modifier modifier$iv = PaddingKt.m681padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6663constructorimpl(12));
                                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceEvenly();
                                    RecipeEntity recipeEntity2 = recipeEntity;
                                    ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                                    Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                                    MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                                    int $changed$iv$iv = (54 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                    int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                                    CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                    if (!($composer2.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer2.startReusableNode();
                                    if ($composer2.getInserting()) {
                                        function0 = constructor;
                                        $composer2.createNode(function0);
                                    } else {
                                        function0 = constructor;
                                        $composer2.useNode();
                                    }
                                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3674constructorimpl($composer2);
                                    Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                        $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                        $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                    }
                                    Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                    int i = ($changed$iv$iv$iv >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer2, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                    int i2 = ((54 >> 6) & 112) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer2, -229538788, "C218@10222L42,219@10297L33:RecipeDetailScreen.kt#y43rd3");
                                    RecipeDetailScreenKt.InfoItem("Porciones", String.valueOf(recipeEntity2.getBaseServings()), $composer2, 6);
                                    RecipeDetailScreenKt.InfoItem("Categoría", recipeEntity2.getCategory(), $composer2, 6);
                                    $composer2.startReplaceGroup(131147226);
                                    ComposerKt.sourceInformation($composer2, "223@10562L215");
                                    if (recipeEntity2.getPrepTimeMinutes() > 0) {
                                        int h = recipeEntity2.getPrepTimeMinutes() / 60;
                                        int m = recipeEntity2.getPrepTimeMinutes() % 60;
                                        StringBuilder $this$invoke_u24lambda_u241_u24lambda_u240 = new StringBuilder();
                                        if (h > 0) {
                                            $this$invoke_u24lambda_u241_u24lambda_u240.append(h + "h ");
                                        }
                                        if (m > 0) {
                                            $this$invoke_u24lambda_u241_u24lambda_u240.append(m + "min");
                                        }
                                        String string = $this$invoke_u24lambda_u241_u24lambda_u240.toString();
                                        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                                        RecipeDetailScreenKt.InfoItem("Tiempo", StringsKt.trim((CharSequence) string).toString(), $composer2, 6);
                                    }
                                    $composer2.endReplaceGroup();
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    $composer2.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    ComposerKt.sourceInformationMarkerEnd($composer2);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer2.skipToGroupEnd();
                            }
                        }, $composer, 54), $composer, 196614, 26);
                        SpacerKt.Spacer(SizeKt.m712height3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(12)), $composer, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer.skipToGroupEnd();
                }
            }), 3, null);
            if (!StringsKt.isBlank($r.getNotes())) {
                LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(672107208, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$RecipeDetailScreen$15$1$1$4
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                        invoke(lazyItemScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
                        Function0<ComposeUiNode> function0;
                        Intrinsics.checkNotNullParameter(item, "$this$item");
                        ComposerKt.sourceInformation($composer, "C236@11082L226,240@11337L30:RecipeDetailScreen.kt#y43rd3");
                        if (($changed & 17) != 16 || !$composer.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(672107208, $changed, -1, "com.easycompra.app.ui.recipes.RecipeDetailScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RecipeDetailScreen.kt:236)");
                            }
                            Modifier modifier$iv = PaddingKt.m683paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6663constructorimpl(16), 0.0f, 2, null);
                            RecipeEntity recipeEntity = $r;
                            ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                            int $changed$iv$iv = (6 << 3) & 112;
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
                            int i2 = ((6 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer, 569293950, "C237@11172L22,238@11227L51:RecipeDetailScreen.kt#y43rd3");
                            RecipeDetailScreenKt.SectionHeader("Notas", null, $composer, 6, 2);
                            TextKt.m2714Text4IGK_g(recipeEntity.getNotes(), (Modifier) null, Color.INSTANCE.m4211getGray0d7_KjU(), TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 3456, 0, 131058);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            $composer.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            SpacerKt.Spacer(SizeKt.m712height3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(12)), $composer, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer.skipToGroupEnd();
                    }
                }), 3, null);
            }
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-513892186, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$RecipeDetailScreen$15$1$1$5
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                    invoke(lazyItemScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
                    Intrinsics.checkNotNullParameter(item, "$this$item");
                    ComposerKt.sourceInformation($composer, "C246@11504L189:RecipeDetailScreen.kt#y43rd3");
                    if (($changed & 17) != 16 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-513892186, $changed, -1, "com.easycompra.app.ui.recipes.RecipeDetailScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RecipeDetailScreen.kt:246)");
                        }
                        RecipeDetailScreenKt.SectionHeader("Ingredientes (" + $recipe.getIngredients().size() + ")", PaddingKt.m683paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6663constructorimpl(16), 0.0f, 2, null), $composer, 48, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer.skipToGroupEnd();
                }
            }), 3, null);
            Iterable $this$sortedBy$iv = $recipe.getIngredients();
            final List sortedIngredients = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$RecipeDetailScreen$15$invoke$lambda$11$lambda$10$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    IngredientEntity it = (IngredientEntity) t;
                    IngredientEntity it2 = (IngredientEntity) t2;
                    return ComparisonsKt.compareValues(it.getName(), it2.getName());
                }
            });
            final Function2 key$iv = new Function2() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$RecipeDetailScreen$15$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RecipeDetailScreenKt.AnonymousClass15.invoke$lambda$11$lambda$10$lambda$1(((Integer) obj).intValue(), (IngredientEntity) obj2);
                }
            };
            LazyColumn.items(sortedIngredients.size(), new Function1<Integer, Object>() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$RecipeDetailScreen$15$invoke$lambda$11$lambda$10$$inlined$itemsIndexed$default$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int index) {
                    return key$iv.invoke(Integer.valueOf(index), sortedIngredients.get(index));
                }
            }, new Function1<Integer, Object>() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$RecipeDetailScreen$15$invoke$lambda$11$lambda$10$$inlined$itemsIndexed$default$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int index) {
                    sortedIngredients.get(index);
                    return null;
                }
            }, ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$RecipeDetailScreen$15$invoke$lambda$11$lambda$10$$inlined$itemsIndexed$default$3
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
                    Function0<ComposeUiNode> function0;
                    ComposerKt.sourceInformation($composer, "C188@8866L26:LazyDsl.kt#428nma");
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
                        ComposerKt.traceEventStart(-1091073711, $dirty, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:188)");
                    }
                    int i = ($dirty & 14) | ($dirty & 112);
                    IngredientEntity ing = (IngredientEntity) sortedIngredients.get(it);
                    $composer.startReplaceGroup(-1185429046);
                    ComposerKt.sourceInformation($composer, "C*253@11912L1309:RecipeDetailScreen.kt#y43rd3");
                    Modifier modifier$iv = PaddingKt.m682paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6663constructorimpl(20), Dp.m6663constructorimpl(3));
                    Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                    int $changed$iv$iv = (390 << 3) & 112;
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
                    int i2 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                    int i3 = ((390 >> 6) & 112) | 6;
                    RowScope $this$invoke_u24lambda_u2411_u24lambda_u2410_u24lambda_u243_u24lambda_u242 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer, 570363388, "C259@12223L312,265@12564L29,267@12702L55,271@12988L27:RecipeDetailScreen.kt#y43rd3");
                    BoxKt.Box(BackgroundKt.m236backgroundbw27NRU$default(ClipKt.clip(SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(6)), RoundedCornerShapeKt.getCircleShape()), ing.getLinkedProductId() != null ? ColorKt.Color(4279286145L) : ColorKt.Color(4291941851L), null, 2, null), $composer, 0);
                    SpacerKt.Spacer(SizeKt.m731width3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(10)), $composer, 6);
                    String qty = UnitConverter.INSTANCE.formatQty(ing.getBaseQuantity());
                    TextKt.m2714Text4IGK_g(qty + " " + ing.getUnit() + "  " + ing.getName(), (Modifier) null, 0L, TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 3072, 0, 131062);
                    $composer.startReplaceGroup(156963368);
                    ComposerKt.sourceInformation($composer, "269@12858L71");
                    if (!StringsKt.isBlank(ing.getIngredientNotes())) {
                        TextKt.m2714Text4IGK_g(" (" + ing.getIngredientNotes() + ")", (Modifier) null, Color.INSTANCE.m4211getGray0d7_KjU(), TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 3456, 0, 131058);
                    }
                    $composer.endReplaceGroup();
                    SpacerKt.Spacer(RowScope.weight$default($this$invoke_u24lambda_u2411_u24lambda_u2410_u24lambda_u243_u24lambda_u242, Modifier.INSTANCE, 1.0f, false, 2, null), $composer, 0);
                    $composer.startReplaceGroup(156971602);
                    ComposerKt.sourceInformation($composer, "273@13111L54");
                    if (ing.getLinkedProductId() != null) {
                        TextKt.m2714Text4IGK_g("✓", (Modifier) null, ColorKt.Color(4279286145L), TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 3462, 0, 131058);
                    }
                    $composer.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            if (!$recipe.getSteps().isEmpty()) {
                LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-237544641, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$RecipeDetailScreen$15$1$1$8
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                        invoke(lazyItemScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
                        Intrinsics.checkNotNullParameter(item, "$this$item");
                        ComposerKt.sourceInformation($composer, "C281@13386L30,282@13445L200:RecipeDetailScreen.kt#y43rd3");
                        if (($changed & 17) != 16 || !$composer.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-237544641, $changed, -1, "com.easycompra.app.ui.recipes.RecipeDetailScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RecipeDetailScreen.kt:281)");
                            }
                            SpacerKt.Spacer(SizeKt.m712height3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(12)), $composer, 6);
                            RecipeDetailScreenKt.SectionHeader("Preparación (" + $recipe.getSteps().size() + " pasos)", PaddingKt.m683paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6663constructorimpl(16), 0.0f, 2, null), $composer, 48, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer.skipToGroupEnd();
                    }
                }), 3, null);
                Iterable $this$sortedBy$iv2 = $recipe.getSteps();
                final List sortedSteps = CollectionsKt.sortedWith($this$sortedBy$iv2, new Comparator() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$RecipeDetailScreen$15$invoke$lambda$11$lambda$10$$inlined$sortedBy$2
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        RecipeStepEntity it = (RecipeStepEntity) t;
                        RecipeStepEntity it2 = (RecipeStepEntity) t2;
                        return ComparisonsKt.compareValues(Integer.valueOf(it.getStepNumber()), Integer.valueOf(it2.getStepNumber()));
                    }
                });
                final Function2 key$iv2 = new Function2() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$RecipeDetailScreen$15$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RecipeDetailScreenKt.AnonymousClass15.invoke$lambda$11$lambda$10$lambda$5(((Integer) obj).intValue(), (RecipeStepEntity) obj2);
                    }
                };
                LazyColumn.items(sortedSteps.size(), new Function1<Integer, Object>() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$RecipeDetailScreen$15$invoke$lambda$11$lambda$10$$inlined$itemsIndexed$default$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Object invoke(int index) {
                        return key$iv2.invoke(Integer.valueOf(index), sortedSteps.get(index));
                    }
                }, new Function1<Integer, Object>() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$RecipeDetailScreen$15$invoke$lambda$11$lambda$10$$inlined$itemsIndexed$default$5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Object invoke(int index) {
                        sortedSteps.get(index);
                        return null;
                    }
                }, ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$RecipeDetailScreen$15$invoke$lambda$11$lambda$10$$inlined$itemsIndexed$default$6
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
                        Function0<ComposeUiNode> function0;
                        Function0<ComposeUiNode> function1;
                        Function0<ComposeUiNode> function2;
                        ComposerKt.sourceInformation($composer, "C188@8866L26:LazyDsl.kt#428nma");
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
                            ComposerKt.traceEventStart(-1091073711, $dirty, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:188)");
                        }
                        int i = ($dirty & 14) | ($dirty & 112);
                        RecipeStepEntity step = (RecipeStepEntity) sortedSteps.get(it);
                        $composer.startReplaceGroup(-1183475798);
                        ComposerKt.sourceInformation($composer, "C*289@13869L1468,316@15366L196:RecipeDetailScreen.kt#y43rd3");
                        Modifier modifier$iv = PaddingKt.m682paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6663constructorimpl(16), Dp.m6663constructorimpl(6));
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(12));
                        ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                        int $changed$iv$iv = (54 << 3) & 112;
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
                        int i2 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        int i3 = ((54 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, 572337406, "C299@14448L11,295@14209L732,309@14974L333:RecipeDetailScreen.kt#y43rd3");
                        Modifier modifier$iv2 = BackgroundKt.m236backgroundbw27NRU$default(ClipKt.clip(SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(28)), RoundedCornerShapeKt.getCircleShape()), MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary(), null, 2, null);
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv2 = (48 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                        CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer.startReusableNode();
                        if ($composer.getInserting()) {
                            function1 = constructor2;
                            $composer.createNode(function1);
                        } else {
                            function1 = constructor2;
                            $composer.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3674constructorimpl($composer);
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                        }
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                        int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        int i5 = ((48 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, -225191100, "C302@14614L293:RecipeDetailScreen.kt#y43rd3");
                        TextKt.m2714Text4IGK_g(String.valueOf(step.getStepNumber()), (Modifier) null, Color.INSTANCE.m4218getWhite0d7_KjU(), TextUnitKt.getSp(13), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 200064, 0, 131026);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        $composer.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerEnd($composer);
                        ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                        Modifier modifier$iv3 = Modifier.INSTANCE;
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv3 = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                        CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer.startReusableNode();
                        if ($composer.getInserting()) {
                            function2 = constructor3;
                            $composer.createNode(function2);
                        } else {
                            function2 = constructor3;
                            $composer.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3674constructorimpl($composer);
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                            $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                            $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
                        }
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                        int i6 = ($changed$iv$iv$iv3 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i7 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer, -224790549, "C310@15019L40:RecipeDetailScreen.kt#y43rd3");
                        TextKt.m2714Text4IGK_g(step.getDescription(), (Modifier) null, 0L, TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 3072, 0, 131062);
                        $composer.startReplaceGroup(131298411);
                        ComposerKt.sourceInformation($composer, "312@15164L71");
                        if (step.getTimeMinutes() > 0) {
                            TextKt.m2714Text4IGK_g("⏱ " + step.getTimeMinutes() + " min", (Modifier) null, Color.INSTANCE.m4211getGray0d7_KjU(), TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 3456, 0, 131058);
                        }
                        $composer.endReplaceGroup();
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
                        Modifier modifierM683paddingVpY3zN4$default = PaddingKt.m683paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m6663constructorimpl(16), 0.0f, 2, null);
                        long jM4213getLightGray0d7_KjU = Color.INSTANCE.m4213getLightGray0d7_KjU();
                        DividerKt.m2093HorizontalDivider9IZ8Weo(modifierM683paddingVpY3zN4$default, 0.0f, Color.m4179copywmQWz5c(jM4213getLightGray0d7_KjU, (14 & 1) != 0 ? Color.m4183getAlphaimpl(jM4213getLightGray0d7_KjU) : 0.4f, (14 & 2) != 0 ? Color.m4187getRedimpl(jM4213getLightGray0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m4186getGreenimpl(jM4213getLightGray0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m4184getBlueimpl(jM4213getLightGray0d7_KjU) : 0.0f), $composer, 390, 2);
                        $composer.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
            }
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$RecipeDetailScreenKt.INSTANCE.m7212getLambda9$app_debug(), 3, null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object invoke$lambda$11$lambda$10$lambda$1(int i, IngredientEntity i2) {
            Intrinsics.checkNotNullParameter(i2, "i");
            return i2.getId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object invoke$lambda$11$lambda$10$lambda$5(int i, RecipeStepEntity s) {
            Intrinsics.checkNotNullParameter(s, "s");
            return s.getId();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void InfoItem(final String label, final String value, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-728833881);
        ComposerKt.sourceInformation($composer3, "C(InfoItem)332@15792L192:RecipeDetailScreen.kt#y43rd3");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(label) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(value) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 19) != 18 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-728833881, $dirty2, -1, "com.easycompra.app.ui.recipes.InfoItem (RecipeDetailScreen.kt:331)");
            }
            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            Modifier modifier$iv = Modifier.INSTANCE;
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(constructor);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3674constructorimpl($composer3);
            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i2 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1228765671, "C333@15861L59,334@15929L49:RecipeDetailScreen.kt#y43rd3");
            TextKt.m2714Text4IGK_g(value, (Modifier) null, 0L, TextUnitKt.getSp(16), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, (($dirty2 >> 3) & 14) | 199680, 0, 131030);
            $composer2 = $composer3;
            TextKt.m2714Text4IGK_g(label, (Modifier) null, Color.INSTANCE.m4211getGray0d7_KjU(), TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, ($dirty2 & 14) | 3456, 0, 131058);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RecipeDetailScreenKt.InfoItem$lambda$26(label, value, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SectionHeader(final String title, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(2067903106);
        ComposerKt.sourceInformation($composer3, "C(SectionHeader)P(1)340@16078L141:RecipeDetailScreen.kt#y43rd3");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(title) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 19) != 18 || !$composer3.getSkipping()) {
            Modifier modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2067903106, $dirty2, -1, "com.easycompra.app.ui.recipes.SectionHeader (RecipeDetailScreen.kt:339)");
            }
            $composer2 = $composer3;
            TextKt.m2714Text4IGK_g(title, PaddingKt.m685paddingqDBjuR0$default(modifier3, 0.0f, 0.0f, 0.0f, Dp.m6663constructorimpl(6), 7, null), 0L, TextUnitKt.getSp(16), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, ($dirty2 & 14) | 199680, 0, 131028);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RecipeDetailScreenKt.SectionHeader$lambda$27(title, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void SelectServingsDialog(final CookingWorkflow.SelectServings workflow, final Function1<? super Float, Unit> function1, final Function0<Unit> function0, final Function0<Unit> function2, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1215543915);
        ComposerKt.sourceInformation($composer2, "C(SelectServingsDialog)P(3,2)381@17559L80,384@17665L76,360@16616L917,357@16497L1250:RecipeDetailScreen.kt#y43rd3");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(workflow) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 1171) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1215543915, $dirty2, -1, "com.easycompra.app.ui.recipes.SelectServingsDialog (RecipeDetailScreen.kt:356)");
            }
            AndroidAlertDialog_androidKt.m1782AlertDialogOix01E0(function2, ComposableLambdaKt.rememberComposableLambda(-382587613, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt.SelectServingsDialog.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C382@17573L56:RecipeDetailScreen.kt#y43rd3");
                    if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-382587613, $changed2, -1, "com.easycompra.app.ui.recipes.SelectServingsDialog.<anonymous> (RecipeDetailScreen.kt:382)");
                    }
                    ButtonKt.Button(function0, null, false, null, null, null, null, null, null, ComposableSingletons$RecipeDetailScreenKt.INSTANCE.m7198getLambda10$app_debug(), $composer3, 805306368, 510);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), null, ComposableLambdaKt.rememberComposableLambda(-993856671, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt.SelectServingsDialog.2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C385@17679L52:RecipeDetailScreen.kt#y43rd3");
                    if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-993856671, $changed2, -1, "com.easycompra.app.ui.recipes.SelectServingsDialog.<anonymous> (RecipeDetailScreen.kt:385)");
                    }
                    ButtonKt.TextButton(function2, null, false, null, null, null, null, null, null, ComposableSingletons$RecipeDetailScreenKt.INSTANCE.m7199getLambda11$app_debug(), $composer3, 805306368, 510);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), null, ComposableSingletons$RecipeDetailScreenKt.INSTANCE.m7200getLambda12$app_debug(), ComposableLambdaKt.rememberComposableLambda(-1910760258, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt.SelectServingsDialog.3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C361@16630L893:RecipeDetailScreen.kt#y43rd3");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1910760258, $changed2, -1, "com.easycompra.app.ui.recipes.SelectServingsDialog.<anonymous> (RecipeDetailScreen.kt:361)");
                        }
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(8));
                        CookingWorkflow.SelectServings selectServings = workflow;
                        Function1<Float, Unit> function3 = function1;
                        ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                        Modifier modifier$iv = Modifier.INSTANCE;
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                        int $changed$iv$iv = (48 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            $composer3.createNode(constructor);
                        } else {
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3674constructorimpl($composer3);
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i2 = ((48 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1630968097, "C362@16705L62,367@17000L11,363@16784L253,369@17054L201,375@17272L237:RecipeDetailScreen.kt#y43rd3");
                        TextKt.m2714Text4IGK_g("Base: " + selectServings.getRecipe().getRecipe().getBaseServings() + " porciones", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 0, 0, 131070);
                        TextKt.m2714Text4IGK_g("Porciones: " + UnitConverter.INSTANCE.formatQty(selectServings.getServings()), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary(), TextUnitKt.getSp(18), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 199680, 0, 131026);
                        SliderKt.Slider(selectServings.getServings(), function3, null, false, RangesKt.rangeTo(0.5f, 20.0f), 37, null, null, null, $composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 460);
                        Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
                        ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                        MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                        int $changed$iv$iv2 = (54 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            $composer3.createNode(constructor2);
                        } else {
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3674constructorimpl($composer3);
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                        }
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                        int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        int i4 = ((54 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1308269936, "C376@17373L49,377@17443L48:RecipeDetailScreen.kt#y43rd3");
                        TextKt.m2714Text4IGK_g("0.5", (Modifier) null, Color.INSTANCE.m4211getGray0d7_KjU(), TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 3462, 0, 131058);
                        TextKt.m2714Text4IGK_g("20", (Modifier) null, Color.INSTANCE.m4211getGray0d7_KjU(), TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 3462, 0, 131058);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, (($dirty2 >> 9) & 14) | 1772592, 0, 16276);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RecipeDetailScreenKt.SelectServingsDialog$lambda$28(workflow, function1, function0, function2, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void ComparisonDialog(final CookingWorkflow.ShowComparison workflow, final Function1<? super String, Unit> function1, final Function0<Unit> function0, final Function0<Unit> function2, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(525866504);
        ComposerKt.sourceInformation($composer2, "C(ComparisonDialog)P(3,2)409@18434L73,412@18533L76,401@18081L85,402@18183L225,399@18014L601:RecipeDetailScreen.kt#y43rd3");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(workflow) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 1171) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(525866504, $dirty2, -1, "com.easycompra.app.ui.recipes.ComparisonDialog (RecipeDetailScreen.kt:398)");
            }
            AndroidAlertDialog_androidKt.m1782AlertDialogOix01E0(function2, ComposableLambdaKt.rememberComposableLambda(-823352128, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt.ComparisonDialog.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C410@18448L49:RecipeDetailScreen.kt#y43rd3");
                    if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-823352128, $changed2, -1, "com.easycompra.app.ui.recipes.ComparisonDialog.<anonymous> (RecipeDetailScreen.kt:410)");
                    }
                    ButtonKt.Button(function0, null, false, null, null, null, null, null, null, ComposableSingletons$RecipeDetailScreenKt.INSTANCE.m7201getLambda13$app_debug(), $composer3, 805306368, 510);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), null, ComposableLambdaKt.rememberComposableLambda(-1746519554, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt.ComparisonDialog.2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C413@18547L52:RecipeDetailScreen.kt#y43rd3");
                    if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1746519554, $changed2, -1, "com.easycompra.app.ui.recipes.ComparisonDialog.<anonymous> (RecipeDetailScreen.kt:413)");
                    }
                    ButtonKt.TextButton(function2, null, false, null, null, null, null, null, null, ComposableSingletons$RecipeDetailScreenKt.INSTANCE.m7202getLambda14$app_debug(), $composer3, 805306368, 510);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), null, ComposableLambdaKt.rememberComposableLambda(1625280316, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt.ComparisonDialog.3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C401@18083L81:RecipeDetailScreen.kt#y43rd3");
                    if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1625280316, $changed2, -1, "com.easycompra.app.ui.recipes.ComparisonDialog.<anonymous> (RecipeDetailScreen.kt:401)");
                    }
                    TextKt.m2714Text4IGK_g("Ingredientes para " + UnitConverter.INSTANCE.formatQty(workflow.getServings()) + " porciones", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 0, 0, 131070);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), ComposableLambdaKt.rememberComposableLambda(-983787045, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt.ComparisonDialog.4
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    Function0<ComposeUiNode> function3;
                    ComposerKt.sourceInformation($composer3, "C403@18197L201:RecipeDetailScreen.kt#y43rd3");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-983787045, $changed2, -1, "com.easycompra.app.ui.recipes.ComparisonDialog.<anonymous> (RecipeDetailScreen.kt:403)");
                        }
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(6));
                        CookingWorkflow.ShowComparison showComparison = workflow;
                        Function1<String, Unit> function4 = function1;
                        ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                        Modifier modifier$iv = Modifier.INSTANCE;
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                        int $changed$iv$iv = (48 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            function3 = constructor;
                            $composer3.createNode(function3);
                        } else {
                            function3 = constructor;
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3674constructorimpl($composer3);
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i2 = ((48 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1914728111, "C:RecipeDetailScreen.kt#y43rd3");
                        $composer3.startReplaceGroup(1308691939);
                        ComposerKt.sourceInformation($composer3, "*405@18329L37");
                        Iterable $this$forEach$iv = showComparison.getResults();
                        int $i$f$forEach = 0;
                        for (Object element$iv : $this$forEach$iv) {
                            Iterable $this$forEach$iv2 = $this$forEach$iv;
                            IngredientResult result = (IngredientResult) element$iv;
                            RecipeDetailScreenKt.IngredientResultRow(result, function4, $composer3, 0);
                            $this$forEach$iv = $this$forEach$iv2;
                            $i$f$forEach = $i$f$forEach;
                        }
                        $composer3.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, (($dirty2 >> 9) & 14) | 1772592, 0, 16276);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RecipeDetailScreenKt.ComparisonDialog$lambda$29(workflow, function1, function0, function2, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:64:0x036a  */
    /* JADX WARN: Code duplicated, block: B:67:0x0376  */
    /* JADX WARN: Code duplicated, block: B:68:0x037c  */
    /* JADX WARN: Code duplicated, block: B:71:0x03ad  */
    /* JADX WARN: Code duplicated, block: B:74:0x03c0  */
    /* JADX WARN: Code duplicated, block: B:75:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:79:0x04df  */
    /* JADX WARN: Code duplicated, block: B:81:0x04f4  */
    /* JADX WARN: Code duplicated, block: B:82:0x04f7  */
    /* JADX WARN: Code duplicated, block: B:86:0x04fe  */
    /* JADX WARN: Code duplicated, block: B:89:0x050b  */
    /* JADX WARN: Code duplicated, block: B:93:0x0516  */
    /* JADX WARN: Code duplicated, block: B:97:0x055b  */
    public static final void IngredientResultRow(final IngredientResult result, final Function1<? super String, Unit> function1, Composer $composer, final int $changed) {
        Triple triple;
        String str;
        MeasurePolicy measurePolicy$iv;
        int compositeKeyHash$iv$iv;
        CompositionLocalMap localMap$iv$iv;
        Function0<ComposeUiNode> constructor;
        Function0<ComposeUiNode> function0;
        Composer $this$Layout_u24lambda_u240$iv$iv;
        MeasurePolicy measurePolicy$iv2;
        CompositionLocalMap localMap$iv$iv2;
        boolean z;
        boolean invalid$iv;
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(-1464046183);
        ComposerKt.sourceInformation($composer2, "C(IngredientResultRow)P(1)430@19535L739:RecipeDetailScreen.kt#y43rd3");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(result) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        if (($dirty & 19) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1464046183, $dirty, -1, "com.easycompra.app.ui.recipes.IngredientResultRow (RecipeDetailScreen.kt:419)");
            }
            IngredientStatus s = result.getStatus();
            if (s instanceof IngredientStatus.OK) {
                triple = new Triple("✅", Color.m4171boximpl(ColorKt.Color(4279286145L)), "Tienes suficiente");
            } else if (s instanceof IngredientStatus.Partial) {
                triple = new Triple("⚠️", Color.m4171boximpl(ColorKt.Color(4294286859L)), "Faltan " + UnitConverter.INSTANCE.formatQty(((IngredientStatus.Partial) s).getDeficit()) + " " + result.getIngredient().getUnit());
            } else if (s instanceof IngredientStatus.Missing) {
                triple = new Triple("❌", Color.m4171boximpl(ColorKt.Color(4293870660L)), "No tienes (" + UnitConverter.INSTANCE.formatQty(((IngredientStatus.Missing) s).getDeficit()) + " " + result.getIngredient().getUnit() + ")");
            } else if (s instanceof IngredientStatus.UnitMismatch) {
                triple = new Triple("❓", Color.m4171boximpl(ColorKt.Color(4285231744L)), "En despensa: " + UnitConverter.INSTANCE.formatQty(((IngredientStatus.UnitMismatch) s).getPantryQty()) + " " + ((IngredientStatus.UnitMismatch) s).getPantryUnit());
            } else {
                if (!(s instanceof IngredientStatus.Unlinked)) {
                    throw new NoWhenBranchMatchedException();
                }
                triple = new Triple("🔗", Color.m4171boximpl(ColorKt.Color(4285231744L)), "Sin vincular a despensa");
            }
            String icon = (String) triple.component1();
            long color = ((Color) triple.component2()).m4191unboximpl();
            String note = (String) triple.component3();
            boolean needsCheckbox = (result.getStatus() instanceof IngredientStatus.UnitMismatch) || (result.getStatus() instanceof IngredientStatus.Unlinked);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Alignment.Vertical top = Alignment.INSTANCE.getTop();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM561spacedBy0680j_4 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(6));
            ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalOrVerticalM561spacedBy0680j_4, top, $composer2, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv = (438 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv3 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifierFillMaxWidth$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(constructor2);
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3674constructorimpl($composer2);
            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                str = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh";
            } else {
                str = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh";
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                }
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                int i = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                int i2 = ((438 >> 6) & 112) | 6;
                RowScope $this$IngredientResultRow_u24lambda_u2433 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer2, -2113043465, "C435@19702L28,436@19739L341:RecipeDetailScreen.kt#y43rd3");
                TextKt.m2714Text4IGK_g(icon, (Modifier) null, 0L, TextUnitKt.getSp(16), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 3072, 0, 131062);
                Modifier modifier$iv = RowScope.weight$default($this$IngredientResultRow_u24lambda_u2433, Modifier.INSTANCE, 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv2 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, str);
                compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    function0 = constructor;
                    $composer2.createNode(function0);
                } else {
                    function0 = constructor;
                    $composer2.useNode();
                }
                $this$Layout_u24lambda_u240$iv$iv = Updater.m3674constructorimpl($composer2);
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                    measurePolicy$iv2 = measurePolicy$iv;
                    localMap$iv$iv2 = localMap$iv$iv;
                } else {
                    measurePolicy$iv2 = measurePolicy$iv;
                    localMap$iv$iv2 = localMap$iv$iv;
                    if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                    }
                    Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                    int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    int i4 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -797717320, "C437@19792L222,442@20027L43:RecipeDetailScreen.kt#y43rd3");
                    TextKt.m2714Text4IGK_g(UnitConverter.INSTANCE.formatQty(result.getScaledQuantity()) + " " + result.getIngredient().getUnit() + "  " + result.getIngredient().getName(), (Modifier) null, 0L, TextUnitKt.getSp(13), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 199680, 0, 131030);
                    TextKt.m2714Text4IGK_g(note, (Modifier) null, color, TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 3072, 0, 131058);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.startReplaceGroup(486038633);
                    ComposerKt.sourceInformation($composer2, "447@20210L34,445@20122L136");
                    if (needsCheckbox) {
                        boolean addToCart = result.getAddToCart();
                        $composer2.startReplaceGroup(486042360);
                        ComposerKt.sourceInformation($composer2, "CC(remember):RecipeDetailScreen.kt#9igjgp");
                        if (($dirty & 112) == 32) {
                            z = true;
                        } else {
                            z = false;
                        }
                        invalid$iv = z | (($dirty & 14) == 4);
                        Object it$iv = $composer2.rememberedValue();
                        if (!invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = new Function1() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return RecipeDetailScreenKt.IngredientResultRow$lambda$33$lambda$32$lambda$31(function1, result, ((Boolean) obj).booleanValue());
                                }
                            };
                            $composer2.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        $composer2.endReplaceGroup();
                        CheckboxKt.Checkbox(addToCart, (Function1) value$iv, null, false, null, null, $composer2, 0, 60);
                    }
                    $composer2.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash2);
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                int i6 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -797717320, "C437@19792L222,442@20027L43:RecipeDetailScreen.kt#y43rd3");
                TextKt.m2714Text4IGK_g(UnitConverter.INSTANCE.formatQty(result.getScaledQuantity()) + " " + result.getIngredient().getUnit() + "  " + result.getIngredient().getName(), (Modifier) null, 0L, TextUnitKt.getSp(13), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 199680, 0, 131030);
                TextKt.m2714Text4IGK_g(note, (Modifier) null, color, TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 3072, 0, 131058);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.startReplaceGroup(486038633);
                ComposerKt.sourceInformation($composer2, "447@20210L34,445@20122L136");
                if (needsCheckbox) {
                    boolean addToCart2 = result.getAddToCart();
                    $composer2.startReplaceGroup(486042360);
                    ComposerKt.sourceInformation($composer2, "CC(remember):RecipeDetailScreen.kt#9igjgp");
                    if (($dirty & 112) == 32) {
                        z = true;
                    } else {
                        z = false;
                    }
                    invalid$iv = z | (($dirty & 14) == 4);
                    Object it$iv2 = $composer2.rememberedValue();
                    if (!invalid$iv) {
                        value$iv = new Function1() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RecipeDetailScreenKt.IngredientResultRow$lambda$33$lambda$32$lambda$31(function1, result, ((Boolean) obj).booleanValue());
                            }
                        };
                        $composer2.updateRememberedValue(value$iv);
                    } else {
                        value$iv = new Function1() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RecipeDetailScreenKt.IngredientResultRow$lambda$33$lambda$32$lambda$31(function1, result, ((Boolean) obj).booleanValue());
                            }
                        };
                        $composer2.updateRememberedValue(value$iv);
                    }
                    $composer2.endReplaceGroup();
                    CheckboxKt.Checkbox(addToCart2, (Function1) value$iv, null, false, null, null, $composer2, 0, 60);
                }
                $composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash);
            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i7 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            int i8 = ((438 >> 6) & 112) | 6;
            RowScope $this$IngredientResultRow_u24lambda_u2434 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -2113043465, "C435@19702L28,436@19739L341:RecipeDetailScreen.kt#y43rd3");
            TextKt.m2714Text4IGK_g(icon, (Modifier) null, 0L, TextUnitKt.getSp(16), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 3072, 0, 131062);
            Modifier modifier$iv2 = RowScope.weight$default($this$IngredientResultRow_u24lambda_u2434, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getStart();
            measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv3 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, str);
            compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function0 = constructor;
                $composer2.createNode(function0);
            } else {
                function0 = constructor;
                $composer2.useNode();
            }
            $this$Layout_u24lambda_u240$iv$iv = Updater.m3674constructorimpl($composer2);
            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                measurePolicy$iv2 = measurePolicy$iv;
                localMap$iv$iv2 = localMap$iv$iv;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                }
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                int i9 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                int i10 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -797717320, "C437@19792L222,442@20027L43:RecipeDetailScreen.kt#y43rd3");
                TextKt.m2714Text4IGK_g(UnitConverter.INSTANCE.formatQty(result.getScaledQuantity()) + " " + result.getIngredient().getUnit() + "  " + result.getIngredient().getName(), (Modifier) null, 0L, TextUnitKt.getSp(13), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 199680, 0, 131030);
                TextKt.m2714Text4IGK_g(note, (Modifier) null, color, TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 3072, 0, 131058);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.startReplaceGroup(486038633);
                ComposerKt.sourceInformation($composer2, "447@20210L34,445@20122L136");
                if (needsCheckbox) {
                    boolean addToCart3 = result.getAddToCart();
                    $composer2.startReplaceGroup(486042360);
                    ComposerKt.sourceInformation($composer2, "CC(remember):RecipeDetailScreen.kt#9igjgp");
                    if (($dirty & 112) == 32) {
                        z = true;
                    } else {
                        z = false;
                    }
                    invalid$iv = z | (($dirty & 14) == 4);
                    Object it$iv3 = $composer2.rememberedValue();
                    if (!invalid$iv) {
                        value$iv = new Function1() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RecipeDetailScreenKt.IngredientResultRow$lambda$33$lambda$32$lambda$31(function1, result, ((Boolean) obj).booleanValue());
                            }
                        };
                        $composer2.updateRememberedValue(value$iv);
                    } else {
                        value$iv = new Function1() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RecipeDetailScreenKt.IngredientResultRow$lambda$33$lambda$32$lambda$31(function1, result, ((Boolean) obj).booleanValue());
                            }
                        };
                        $composer2.updateRememberedValue(value$iv);
                    }
                    $composer2.endReplaceGroup();
                    CheckboxKt.Checkbox(addToCart3, (Function1) value$iv, null, false, null, null, $composer2, 0, 60);
                }
                $composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                measurePolicy$iv2 = measurePolicy$iv;
                localMap$iv$iv2 = localMap$iv$iv;
            }
            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash3);
            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
            int i11 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
            int i12 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -797717320, "C437@19792L222,442@20027L43:RecipeDetailScreen.kt#y43rd3");
            TextKt.m2714Text4IGK_g(UnitConverter.INSTANCE.formatQty(result.getScaledQuantity()) + " " + result.getIngredient().getUnit() + "  " + result.getIngredient().getName(), (Modifier) null, 0L, TextUnitKt.getSp(13), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 199680, 0, 131030);
            TextKt.m2714Text4IGK_g(note, (Modifier) null, color, TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 3072, 0, 131058);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.startReplaceGroup(486038633);
            ComposerKt.sourceInformation($composer2, "447@20210L34,445@20122L136");
            if (needsCheckbox) {
                boolean addToCart4 = result.getAddToCart();
                $composer2.startReplaceGroup(486042360);
                ComposerKt.sourceInformation($composer2, "CC(remember):RecipeDetailScreen.kt#9igjgp");
                if (($dirty & 112) == 32) {
                    z = true;
                } else {
                    z = false;
                }
                invalid$iv = z | (($dirty & 14) == 4);
                Object it$iv4 = $composer2.rememberedValue();
                if (!invalid$iv) {
                    value$iv = new Function1() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RecipeDetailScreenKt.IngredientResultRow$lambda$33$lambda$32$lambda$31(function1, result, ((Boolean) obj).booleanValue());
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                } else {
                    value$iv = new Function1() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RecipeDetailScreenKt.IngredientResultRow$lambda$33$lambda$32$lambda$31(function1, result, ((Boolean) obj).booleanValue());
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                }
                $composer2.endReplaceGroup();
                CheckboxKt.Checkbox(addToCart4, (Function1) value$iv, null, false, null, null, $composer2, 0, 60);
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RecipeDetailScreenKt.IngredientResultRow$lambda$34(result, function1, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IngredientResultRow$lambda$33$lambda$32$lambda$31(Function1 $onToggle, IngredientResult $result, boolean it) {
        $onToggle.invoke($result.getIngredient().getId());
        return Unit.INSTANCE;
    }

    private static final void SummaryDialog(final CookingWorkflow.ShowSummary workflow, final Function0<Unit> function0, final Function0<Unit> function1, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(757763533);
        ComposerKt.sourceInformation($composer3, "C(SummaryDialog)P(2)491@22042L150,496@22218L76,464@20629L1387,461@20503L1797:RecipeDetailScreen.kt#y43rd3");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(workflow) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 147) != 146 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(757763533, $dirty2, -1, "com.easycompra.app.ui.recipes.SummaryDialog (RecipeDetailScreen.kt:460)");
            }
            $composer2 = $composer3;
            AndroidAlertDialog_androidKt.m1782AlertDialogOix01E0(function1, ComposableLambdaKt.rememberComposableLambda(-933000059, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt.SummaryDialog.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C492@22084L98,492@22056L126:RecipeDetailScreen.kt#y43rd3");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-933000059, $changed2, -1, "com.easycompra.app.ui.recipes.SummaryDialog.<anonymous> (RecipeDetailScreen.kt:492)");
                        }
                        Function0<Unit> function2 = function0;
                        final CookingWorkflow.ShowSummary showSummary = workflow;
                        ButtonKt.Button(function2, null, false, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-721242475, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt.SummaryDialog.1.1
                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                                invoke(rowScope, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(RowScope Button, Composer $composer5, int $changed3) {
                                Intrinsics.checkNotNullParameter(Button, "$this$Button");
                                ComposerKt.sourceInformation($composer5, "C493@22102L66:RecipeDetailScreen.kt#y43rd3");
                                if (($changed3 & 17) == 16 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-721242475, $changed3, -1, "com.easycompra.app.ui.recipes.SummaryDialog.<anonymous>.<anonymous> (RecipeDetailScreen.kt:493)");
                                }
                                TextKt.m2714Text4IGK_g(showSummary.getToShop().isEmpty() ? "Listo" : "Añadir a lista", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer5, 0, 0, 131070);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54), $composer4, 805306368, 510);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), null, ComposableLambdaKt.rememberComposableLambda(1744526787, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt.SummaryDialog.2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C497@22232L52:RecipeDetailScreen.kt#y43rd3");
                    if (($changed2 & 3) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1744526787, $changed2, -1, "com.easycompra.app.ui.recipes.SummaryDialog.<anonymous> (RecipeDetailScreen.kt:497)");
                    }
                    ButtonKt.TextButton(function1, null, false, null, null, null, null, null, null, ComposableSingletons$RecipeDetailScreenKt.INSTANCE.m7203getLambda15$app_debug(), $composer4, 805306368, 510);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), null, ComposableSingletons$RecipeDetailScreenKt.INSTANCE.m7204getLambda16$app_debug(), ComposableLambdaKt.rememberComposableLambda(1465849760, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt.SummaryDialog.3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    Function0<ComposeUiNode> function2;
                    float deficit;
                    Function0<ComposeUiNode> function3;
                    ComposerKt.sourceInformation($composer4, "C:RecipeDetailScreen.kt#y43rd3");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1465849760, $changed2, -1, "com.easycompra.app.ui.recipes.SummaryDialog.<anonymous> (RecipeDetailScreen.kt:465)");
                        }
                        String str = "C101@5126L9:Row.kt#2w3rfo";
                        String str2 = "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo";
                        String str3 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                        if (workflow.getToShop().isEmpty()) {
                            $composer4.startReplaceGroup(66439716);
                            ComposerKt.sourceInformation($composer4, "466@20692L262");
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            Arrangement.HorizontalOrVertical horizontalOrVerticalM561spacedBy0680j_4 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(8));
                            ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                            Modifier modifier$iv = Modifier.INSTANCE;
                            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalOrVerticalM561spacedBy0680j_4, centerVertically, $composer4, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                            int $changed$iv$iv = (432 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                            CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!($composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer4.startReusableNode();
                            if ($composer4.getInserting()) {
                                $composer4.createNode(constructor);
                            } else {
                                $composer4.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3674constructorimpl($composer4);
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                            }
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                            int i = ($changed$iv$iv$iv >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                            int i2 = ((432 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1640827722, "C467@20818L63,468@20902L34:RecipeDetailScreen.kt#y43rd3");
                            IconKt.m2171Iconww6aTOc(CheckCircleKt.getCheckCircle(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, ColorKt.Color(4279286145L), $composer4, 3120, 4);
                            TextKt.m2714Text4IGK_g("¡Tienes todo lo necesario!", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 6, 0, 131070);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endReplaceGroup();
                        } else {
                            $composer4.startReplaceGroup(66760194);
                            ComposerKt.sourceInformation($composer4, "471@20992L1000");
                            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(4));
                            CookingWorkflow.ShowSummary showSummary = workflow;
                            ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                            Modifier modifier$iv2 = Modifier.INSTANCE;
                            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                            int $changed$iv$iv2 = (48 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                            CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!($composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer4.startReusableNode();
                            if ($composer4.getInserting()) {
                                function2 = constructor2;
                                $composer4.createNode(function2);
                            } else {
                                function2 = constructor2;
                                $composer4.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3674constructorimpl($composer4);
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                            }
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            int $changed3 = ((48 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1640552411, "C472@21071L79,473@21171L29:RecipeDetailScreen.kt#y43rd3");
                            TextKt.m2714Text4IGK_g("Se añadirán a tu lista de compra:", (Modifier) null, Color.INSTANCE.m4211getGray0d7_KjU(), TextUnitKt.getSp(13), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 3462, 0, 131058);
                            SpacerKt.Spacer(SizeKt.m712height3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(4)), $composer4, 6);
                            $composer4.startReplaceGroup(-468557896);
                            ComposerKt.sourceInformation($composer4, "*480@21568L384");
                            Iterable $this$forEach$iv = showSummary.getToShop();
                            int $i$f$forEach = 0;
                            Iterator it = $this$forEach$iv.iterator();
                            while (it.hasNext()) {
                                Object element$iv = it.next();
                                IngredientResult result = (IngredientResult) element$iv;
                                Iterable $this$forEach$iv2 = $this$forEach$iv;
                                IngredientStatus s = result.getStatus();
                                int $i$f$forEach2 = $i$f$forEach;
                                if (s instanceof IngredientStatus.Partial) {
                                    deficit = ((IngredientStatus.Partial) s).getDeficit();
                                } else {
                                    deficit = s instanceof IngredientStatus.Missing ? ((IngredientStatus.Missing) s).getDeficit() : result.getScaledQuantity();
                                }
                                float qty = deficit;
                                Iterator it2 = it;
                                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(6));
                                ComposerKt.sourceInformationMarkerStart($composer4, 693286680, str2);
                                Modifier modifier$iv3 = Modifier.INSTANCE;
                                String str4 = str2;
                                Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                                int $changed4 = $changed3;
                                MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                                int $changed$iv$iv3 = (48 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                                CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                                CompositionLocalMap localMap$iv$iv4 = localMap$iv$iv2;
                                ComposerKt.sourceInformationMarkerStart($composer4, -692256719, str3);
                                if (!($composer4.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer4.startReusableNode();
                                if ($composer4.getInserting()) {
                                    function3 = constructor3;
                                    $composer4.createNode(function3);
                                } else {
                                    function3 = constructor3;
                                    $composer4.useNode();
                                }
                                String str5 = str3;
                                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3674constructorimpl($composer4);
                                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                                    $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                                    $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
                                }
                                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                                int i4 = ($changed$iv$iv$iv3 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer4, -407840262, str);
                                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                                int i5 = ((48 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer4, -916605410, "C481@21654L39,482@21722L204:RecipeDetailScreen.kt#y43rd3");
                                TextKt.m2714Text4IGK_g("•", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 196614, 0, 131038);
                                TextKt.m2714Text4IGK_g(UnitConverter.INSTANCE.formatQty(qty) + " " + result.getIngredient().getUnit() + "  " + result.getIngredient().getName(), (Modifier) null, 0L, TextUnitKt.getSp(13), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 3072, 0, 131062);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                $composer4.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                ComposerKt.sourceInformationMarkerEnd($composer4);
                                $this$forEach$iv = $this$forEach$iv2;
                                $i$f$forEach = $i$f$forEach2;
                                it = it2;
                                str2 = str4;
                                $changed3 = $changed4;
                                str3 = str5;
                                localMap$iv$iv2 = localMap$iv$iv4;
                                str = str;
                            }
                            $composer4.endReplaceGroup();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer2, (($dirty2 >> 6) & 14) | 1772592, 0, 16276);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RecipeDetailScreenKt.SummaryDialog$lambda$35(workflow, function0, function1, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
