package com.easycompra.app.ui.recipes;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
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
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.DeleteKt;
import androidx.compose.material.icons.filled.LinkKt;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ExposedDropdownMenuBoxScope;
import androidx.compose.material3.ExposedDropdownMenuDefaults;
import androidx.compose.material3.ExposedDropdownMenu_androidKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.MenuAnchorType;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.core.view.PointerIconCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.easycompra.app.data.pantry.PantryProductWithLocations;
import com.easycompra.app.data.recipes.IngredientEntity;
import com.easycompra.app.data.recipes.RecipeCategories;
import com.easycompra.app.data.recipes.RecipeDifficulty;
import com.easycompra.app.data.recipes.RecipeEntity;
import com.easycompra.app.data.recipes.RecipeStepEntity;
import com.easycompra.app.data.recipes.RecipeUnits;
import com.easycompra.app.data.recipes.RecipeWithDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CreateEditRecipeScreen.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b\u001aI\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0003¢\u0006\u0002\u0010\u0013¨\u0006\u0014²\u0006\n\u0010\u0015\u001a\u00020\u0016X\u008a\u0084\u0002²\u0006\n\u0010\u0017\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u0010\u0018\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u0010\u0019\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u0010\u001a\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u0010\u001b\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u0010\u001c\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u0010\u001d\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u0010\u001e\u001a\u00020\u001fX\u008a\u008e\u0002²\u0006\f\u0010 \u001a\u0004\u0018\u00010!X\u008a\u008e\u0002²\u0006\n\u0010\"\u001a\u00020\u000bX\u008a\u008e\u0002²\u0006\n\u0010#\u001a\u00020\u001fX\u008a\u008e\u0002"}, d2 = {"CreateEditRecipeScreen", "", "viewModel", "Lcom/easycompra/app/ui/recipes/RecipeViewModel;", "editing", "Lcom/easycompra/app/data/recipes/RecipeWithDetails;", "onDismiss", "Lkotlin/Function0;", "(Lcom/easycompra/app/ui/recipes/RecipeViewModel;Lcom/easycompra/app/data/recipes/RecipeWithDetails;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SimpleDropdown", "label", "", "selected", "options", "", "onSelect", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "app_debug", "state", "Lcom/easycompra/app/ui/recipes/RecipeUiState;", HintConstants.AUTOFILL_HINT_NAME, "category", "photoUrl", "prepTime", "baseServings", "difficulty", "notes", "nameError", "", "linkingIngredientIndex", "", "pantryQuery", "expanded"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CreateEditRecipeScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateEditRecipeScreen$lambda$52(RecipeViewModel recipeViewModel, RecipeWithDetails recipeWithDetails, Function0 function0, int i, Composer composer, int i2) throws Throwable {
        CreateEditRecipeScreen(recipeViewModel, recipeWithDetails, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SimpleDropdown$lambda$58(String str, String str2, List list, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SimpleDropdown(str, str2, list, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void CreateEditRecipeScreen(final RecipeViewModel viewModel, final RecipeWithDetails editing, final Function0<Unit> onDismiss, Composer $composer, int $changed) throws Throwable {
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
        Object value$iv12;
        CreateEditRecipeScreenKt$CreateEditRecipeScreen$1$1 value$iv13;
        boolean z;
        int i;
        Composer $composer2;
        final int i2;
        Object value$iv14;
        Iterable $this$sortedBy$iv;
        Iterable $this$sortedBy$iv2;
        String string;
        Iterable $this$sortedBy$iv3;
        Iterable $this$sortedBy$iv4;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer $composer3 = $composer.startRestartGroup(-903929271);
        ComposerKt.sourceInformation($composer3, "C(CreateEditRecipeScreen)P(2)89@3725L16,92@3812L47,92@3795L64,93@3897L77,93@3880L94,94@4012L51,94@3995L68,95@4101L89,95@4084L106,96@4232L68,96@4215L85,97@4340L72,97@4323L89,98@4447L48,98@4430L65,99@4534L25,99@4517L42,101@4583L580,116@5181L327,124@5544L39,125@5607L31,127@5672L123,127@5644L151,196@8866L2697,250@11570L10936,195@8839L13667:CreateEditRecipeScreen.kt#y43rd3");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(viewModel) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(editing) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(onDismiss) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 147) != 146 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-903929271, $dirty2, -1, "com.easycompra.app.ui.recipes.CreateEditRecipeScreen (CreateEditRecipeScreen.kt:88)");
            }
            State state$delegate = SnapshotStateKt.collectAsState(viewModel.getState(), null, $composer3, 0, 1);
            boolean isEditing = editing != null;
            Object[] objArr = new Object[0];
            $composer3.startReplaceGroup(-173884860);
            ComposerKt.sourceInformation($composer3, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
            boolean invalid$iv = $composer3.changedInstance(editing);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function0() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$2$lambda$1(editing);
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer3.endReplaceGroup();
            final MutableState name$delegate = (MutableState) RememberSaveableKt.m3767rememberSaveable(objArr, (Saver) null, (String) null, (Function0) value$iv, $composer3, 0, 6);
            Object[] objArr2 = new Object[0];
            $composer3.startReplaceGroup(-173882110);
            ComposerKt.sourceInformation($composer3, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
            boolean invalid$iv2 = $composer3.changedInstance(editing);
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new Function0() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$6$lambda$5(editing);
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            $composer3.endReplaceGroup();
            final MutableState category$delegate = (MutableState) RememberSaveableKt.m3767rememberSaveable(objArr2, (Saver) null, (String) null, (Function0) value$iv2, $composer3, 0, 6);
            Object[] objArr3 = new Object[0];
            $composer3.startReplaceGroup(-173878456);
            ComposerKt.sourceInformation($composer3, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
            boolean invalid$iv3 = $composer3.changedInstance(editing);
            Object it$iv3 = $composer3.rememberedValue();
            if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                value$iv3 = new Function0() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$10$lambda$9(editing);
                    }
                };
                $composer3.updateRememberedValue(value$iv3);
            } else {
                value$iv3 = it$iv3;
            }
            $composer3.endReplaceGroup();
            final MutableState photoUrl$delegate = (MutableState) RememberSaveableKt.m3767rememberSaveable(objArr3, (Saver) null, (String) null, (Function0) value$iv3, $composer3, 0, 6);
            Object[] objArr4 = new Object[0];
            $composer3.startReplaceGroup(-173875570);
            ComposerKt.sourceInformation($composer3, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
            boolean invalid$iv4 = $composer3.changedInstance(editing);
            Object it$iv4 = $composer3.rememberedValue();
            if (invalid$iv4 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = new Function0() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$15$lambda$14(editing);
                    }
                };
                $composer3.updateRememberedValue(value$iv4);
            } else {
                value$iv4 = it$iv4;
            }
            $composer3.endReplaceGroup();
            final MutableState prepTime$delegate = (MutableState) RememberSaveableKt.m3767rememberSaveable(objArr4, (Saver) null, (String) null, (Function0) value$iv4, $composer3, 0, 6);
            Object[] objArr5 = new Object[0];
            $composer3.startReplaceGroup(-173871399);
            ComposerKt.sourceInformation($composer3, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
            boolean invalid$iv5 = $composer3.changedInstance(editing);
            Object it$iv5 = $composer3.rememberedValue();
            if (invalid$iv5 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                value$iv5 = new Function0() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$19$lambda$18(editing);
                    }
                };
                $composer3.updateRememberedValue(value$iv5);
            } else {
                value$iv5 = it$iv5;
            }
            $composer3.endReplaceGroup();
            final MutableState baseServings$delegate = (MutableState) RememberSaveableKt.m3767rememberSaveable(objArr5, (Saver) null, (String) null, (Function0) value$iv5, $composer3, 0, 6);
            Object[] objArr6 = new Object[0];
            $composer3.startReplaceGroup(-173867939);
            ComposerKt.sourceInformation($composer3, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
            boolean invalid$iv6 = $composer3.changedInstance(editing);
            Object it$iv6 = $composer3.rememberedValue();
            if (invalid$iv6 || it$iv6 == Composer.INSTANCE.getEmpty()) {
                value$iv6 = new Function0() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$23$lambda$22(editing);
                    }
                };
                $composer3.updateRememberedValue(value$iv6);
            } else {
                value$iv6 = it$iv6;
            }
            $composer3.endReplaceGroup();
            final MutableState difficulty$delegate = (MutableState) RememberSaveableKt.m3767rememberSaveable(objArr6, (Saver) null, (String) null, (Function0) value$iv6, $composer3, 0, 6);
            Object[] objArr7 = new Object[0];
            $composer3.startReplaceGroup(-173864539);
            ComposerKt.sourceInformation($composer3, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
            boolean invalid$iv7 = $composer3.changedInstance(editing);
            Object it$iv7 = $composer3.rememberedValue();
            if (invalid$iv7 || it$iv7 == Composer.INSTANCE.getEmpty()) {
                value$iv7 = new Function0() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$27$lambda$26(editing);
                    }
                };
                $composer3.updateRememberedValue(value$iv7);
            } else {
                value$iv7 = it$iv7;
            }
            $composer3.endReplaceGroup();
            final MutableState notes$delegate = (MutableState) RememberSaveableKt.m3767rememberSaveable(objArr7, (Saver) null, (String) null, (Function0) value$iv7, $composer3, 0, 6);
            Object[] objArr8 = new Object[0];
            $composer3.startReplaceGroup(-173861778);
            ComposerKt.sourceInformation($composer3, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
            Object it$iv8 = $composer3.rememberedValue();
            if (it$iv8 == Composer.INSTANCE.getEmpty()) {
                value$iv8 = new Function0() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$31$lambda$30();
                    }
                };
                $composer3.updateRememberedValue(value$iv8);
            } else {
                value$iv8 = it$iv8;
            }
            $composer3.endReplaceGroup();
            final MutableState nameError$delegate = (MutableState) RememberSaveableKt.m3767rememberSaveable(objArr8, (Saver) null, (String) null, (Function0) value$iv8, $composer3, 3072, 6);
            $composer3.startReplaceGroup(-173859655);
            ComposerKt.sourceInformation($composer3, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
            Object it$iv9 = $composer3.rememberedValue();
            int i3 = 0;
            if (it$iv9 == Composer.INSTANCE.getEmpty()) {
                SnapshotStateList $this$CreateEditRecipeScreen_u24lambda_u2437_u24lambda_u2436 = SnapshotStateKt.mutableStateListOf();
                if (editing == null || ($this$sortedBy$iv3 = editing.getIngredients()) == null || ($this$sortedBy$iv4 = CollectionsKt.sortedWith($this$sortedBy$iv3, new Comparator() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$lambda$37$lambda$36$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        IngredientEntity it = (IngredientEntity) t;
                        IngredientEntity it2 = (IngredientEntity) t2;
                        return ComparisonsKt.compareValues(it.getName(), it2.getName());
                    }
                })) == null) {
                    Boolean.valueOf($this$CreateEditRecipeScreen_u24lambda_u2437_u24lambda_u2436.add(new IngredientDraft(null, null, null, null, null, null, null, 127, null)));
                } else {
                    Iterable $this$forEach$iv = $this$sortedBy$iv4;
                    int $i$f$forEach = 0;
                    for (Object element$iv : $this$forEach$iv) {
                        IngredientEntity ing = (IngredientEntity) element$iv;
                        Iterable $this$forEach$iv2 = $this$forEach$iv;
                        $this$CreateEditRecipeScreen_u24lambda_u2437_u24lambda_u2436.add(new IngredientDraft(ing.getId(), ing.getName(), (ing.getBaseQuantity() > 0.0f ? 1 : (ing.getBaseQuantity() == 0.0f ? 0 : -1)) == 0 ? "" : StringsKt.trimEnd(StringsKt.trimEnd(String.valueOf(ing.getBaseQuantity()), '0'), '.'), ing.getUnit(), ing.getIngredientNotes(), ing.getLinkedProductId(), null, 64, null));
                        $this$forEach$iv = $this$forEach$iv2;
                        $i$f$forEach = $i$f$forEach;
                        it$iv9 = it$iv9;
                        i3 = i3;
                    }
                    Unit unit = Unit.INSTANCE;
                }
                value$iv9 = $this$CreateEditRecipeScreen_u24lambda_u2437_u24lambda_u2436;
                $composer3.updateRememberedValue(value$iv9);
            } else {
                value$iv9 = it$iv9;
            }
            final SnapshotStateList ingredients = (SnapshotStateList) value$iv9;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-173840772);
            ComposerKt.sourceInformation($composer3, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
            Object it$iv10 = $composer3.rememberedValue();
            int i4 = 0;
            if (it$iv10 == Composer.INSTANCE.getEmpty()) {
                SnapshotStateList $this$CreateEditRecipeScreen_u24lambda_u2442_u24lambda_u2441 = SnapshotStateKt.mutableStateListOf();
                if (editing == null || ($this$sortedBy$iv = editing.getSteps()) == null || ($this$sortedBy$iv2 = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$lambda$42$lambda$41$$inlined$sortedBy$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        RecipeStepEntity it = (RecipeStepEntity) t;
                        RecipeStepEntity it2 = (RecipeStepEntity) t2;
                        return ComparisonsKt.compareValues(Integer.valueOf(it.getStepNumber()), Integer.valueOf(it2.getStepNumber()));
                    }
                })) == null) {
                    Boolean.valueOf($this$CreateEditRecipeScreen_u24lambda_u2442_u24lambda_u2441.add(new StepDraft(null, null, null, 7, null)));
                } else {
                    Iterable $this$forEach$iv3 = $this$sortedBy$iv2;
                    int $i$f$forEach2 = 0;
                    for (Object element$iv2 : $this$forEach$iv3) {
                        RecipeStepEntity step = (RecipeStepEntity) element$iv2;
                        Iterable $this$forEach$iv4 = $this$forEach$iv3;
                        String id = step.getId();
                        int $i$f$forEach3 = $i$f$forEach2;
                        String description = step.getDescription();
                        Integer numValueOf = Integer.valueOf(step.getTimeMinutes());
                        int it = numValueOf.intValue();
                        int it2 = it > 0 ? 1 : 0;
                        if (it2 == 0) {
                            numValueOf = null;
                        }
                        $this$CreateEditRecipeScreen_u24lambda_u2442_u24lambda_u2441.add(new StepDraft(id, description, (numValueOf == null || (string = numValueOf.toString()) == null) ? "" : string));
                        $this$forEach$iv3 = $this$forEach$iv4;
                        $i$f$forEach2 = $i$f$forEach3;
                        it$iv10 = it$iv10;
                        i4 = i4;
                    }
                    Unit unit2 = Unit.INSTANCE;
                }
                value$iv10 = $this$CreateEditRecipeScreen_u24lambda_u2442_u24lambda_u2441;
                $composer3.updateRememberedValue(value$iv10);
            } else {
                value$iv10 = it$iv10;
            }
            final SnapshotStateList steps = (SnapshotStateList) value$iv10;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-173829444);
            ComposerKt.sourceInformation($composer3, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
            Object it$iv11 = $composer3.rememberedValue();
            if (it$iv11 == Composer.INSTANCE.getEmpty()) {
                value$iv11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                $composer3.updateRememberedValue(value$iv11);
            } else {
                value$iv11 = it$iv11;
            }
            final MutableState linkingIngredientIndex$delegate = (MutableState) value$iv11;
            $composer3.endReplaceGroup();
            $composer3.startReplaceGroup(-173827436);
            ComposerKt.sourceInformation($composer3, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
            Object it$iv12 = $composer3.rememberedValue();
            if (it$iv12 == Composer.INSTANCE.getEmpty()) {
                value$iv12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                $composer3.updateRememberedValue(value$iv12);
            } else {
                value$iv12 = it$iv12;
            }
            final MutableState pantryQuery$delegate = (MutableState) value$iv12;
            $composer3.endReplaceGroup();
            String strCreateEditRecipeScreen$lambda$47 = CreateEditRecipeScreen$lambda$47(pantryQuery$delegate);
            $composer3.startReplaceGroup(-173825264);
            ComposerKt.sourceInformation($composer3, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
            boolean invalid$iv8 = $composer3.changedInstance(viewModel);
            Object it$iv13 = $composer3.rememberedValue();
            if (invalid$iv8 || it$iv13 == Composer.INSTANCE.getEmpty()) {
                value$iv13 = new CreateEditRecipeScreenKt$CreateEditRecipeScreen$1$1(viewModel, pantryQuery$delegate, null);
                $composer3.updateRememberedValue(value$iv13);
            } else {
                value$iv13 = it$iv13;
            }
            $composer3.endReplaceGroup();
            EffectsKt.LaunchedEffect(strCreateEditRecipeScreen$lambda$47, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv13, $composer3, 0);
            $composer3.startReplaceGroup(-173818227);
            ComposerKt.sourceInformation($composer3, "135@5934L140,187@8632L185,141@6148L2422,134@5890L2937");
            if (CreateEditRecipeScreen$lambda$44(linkingIngredientIndex$delegate) != null) {
                Integer numCreateEditRecipeScreen$lambda$44 = CreateEditRecipeScreen$lambda$44(linkingIngredientIndex$delegate);
                Intrinsics.checkNotNull(numCreateEditRecipeScreen$lambda$44);
                int idx = numCreateEditRecipeScreen$lambda$44.intValue();
                $composer3.startReplaceGroup(-173816863);
                ComposerKt.sourceInformation($composer3, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
                boolean invalid$iv9 = $composer3.changedInstance(viewModel);
                Object it$iv14 = $composer3.rememberedValue();
                if (invalid$iv9 || it$iv14 == Composer.INSTANCE.getEmpty()) {
                    value$iv14 = new Function0() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$51$lambda$50(viewModel, linkingIngredientIndex$delegate, pantryQuery$delegate);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv14);
                } else {
                    value$iv14 = it$iv14;
                }
                $composer3.endReplaceGroup();
                i = 54;
                z = true;
                AndroidAlertDialog_androidKt.m1782AlertDialogOix01E0((Function0) value$iv14, ComposableSingletons$CreateEditRecipeScreenKt.INSTANCE.m7175getLambda1$app_debug(), null, ComposableLambdaKt.rememberComposableLambda(1208043480, true, new AnonymousClass3(viewModel, linkingIngredientIndex$delegate, pantryQuery$delegate), $composer3, 54), null, ComposableSingletons$CreateEditRecipeScreenKt.INSTANCE.m7190getLambda3$app_debug(), ComposableLambdaKt.rememberComposableLambda(-804349733, true, new AnonymousClass4(ingredients, idx, viewModel, pantryQuery$delegate, state$delegate, linkingIngredientIndex$delegate), $composer3, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, $composer3, 1772592, 0, 16276);
            } else {
                z = true;
                i = 54;
            }
            $composer3.endReplaceGroup();
            boolean z2 = z;
            $composer2 = $composer3;
            i2 = $changed;
            int i5 = i;
            final boolean isEditing2 = isEditing;
            ScaffoldKt.m2429ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(-1157960955, z2, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt.CreateEditRecipeScreen.5
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C198@8915L90,199@9040L191,204@9259L2077,245@11449L11,244@11381L158,197@8880L2673:CreateEditRecipeScreen.kt#y43rd3");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1157960955, $changed2, -1, "com.easycompra.app.ui.recipes.CreateEditRecipeScreen.<anonymous> (CreateEditRecipeScreen.kt:197)");
                        }
                        final boolean z3 = isEditing2;
                        ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(319066057, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt.CreateEditRecipeScreen.5.1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer5, int $changed3) {
                                ComposerKt.sourceInformation($composer5, "C198@8917L86:CreateEditRecipeScreen.kt#y43rd3");
                                if (($changed3 & 3) == 2 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(319066057, $changed3, -1, "com.easycompra.app.ui.recipes.CreateEditRecipeScreen.<anonymous>.<anonymous> (CreateEditRecipeScreen.kt:198)");
                                }
                                TextKt.m2714Text4IGK_g(z3 ? "Editar receta" : "Nueva receta", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer5, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 131038);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54);
                        final Function0<Unit> function0 = onDismiss;
                        AppBarKt.m1794TopAppBarGHTll3U(composableLambdaRememberComposableLambda, null, ComposableLambdaKt.rememberComposableLambda(603051595, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt.CreateEditRecipeScreen.5.2
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer5, int $changed3) {
                                ComposerKt.sourceInformation($composer5, "C200@9062L151:CreateEditRecipeScreen.kt#y43rd3");
                                if (($changed3 & 3) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(603051595, $changed3, -1, "com.easycompra.app.ui.recipes.CreateEditRecipeScreen.<anonymous>.<anonymous> (CreateEditRecipeScreen.kt:200)");
                                    }
                                    IconButtonKt.IconButton(function0, null, false, null, null, ComposableSingletons$CreateEditRecipeScreenKt.INSTANCE.m7193getLambda6$app_debug(), $composer5, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }, $composer4, 54), ComposableLambdaKt.rememberComposableLambda(-2046585036, true, new AnonymousClass3(name$delegate, nameError$delegate, viewModel, category$delegate, photoUrl$delegate, prepTime$delegate, baseServings$delegate, difficulty$delegate, notes$delegate, editing, ingredients, steps), $composer4, 54), 0.0f, null, TopAppBarDefaults.INSTANCE.m2885topAppBarColorszjMxDiM(MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getPrimary(), 0L, 0L, Color.INSTANCE.m4218getWhite0d7_KjU(), 0L, $composer4, (TopAppBarDefaults.$stable << 15) | 3072, 22), null, $composer4, 3462, 178);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }

                /* JADX INFO: renamed from: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$5$3, reason: invalid class name */
                /* JADX INFO: compiled from: CreateEditRecipeScreen.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                static final class AnonymousClass3 implements Function3<RowScope, Composer, Integer, Unit> {
                    final /* synthetic */ MutableState<String> $baseServings$delegate;
                    final /* synthetic */ MutableState<String> $category$delegate;
                    final /* synthetic */ MutableState<String> $difficulty$delegate;
                    final /* synthetic */ RecipeWithDetails $editing;
                    final /* synthetic */ SnapshotStateList<IngredientDraft> $ingredients;
                    final /* synthetic */ MutableState<String> $name$delegate;
                    final /* synthetic */ MutableState<Boolean> $nameError$delegate;
                    final /* synthetic */ MutableState<String> $notes$delegate;
                    final /* synthetic */ MutableState<String> $photoUrl$delegate;
                    final /* synthetic */ MutableState<String> $prepTime$delegate;
                    final /* synthetic */ SnapshotStateList<StepDraft> $steps;
                    final /* synthetic */ RecipeViewModel $viewModel;

                    AnonymousClass3(MutableState<String> mutableState, MutableState<Boolean> mutableState2, RecipeViewModel recipeViewModel, MutableState<String> mutableState3, MutableState<String> mutableState4, MutableState<String> mutableState5, MutableState<String> mutableState6, MutableState<String> mutableState7, MutableState<String> mutableState8, RecipeWithDetails recipeWithDetails, SnapshotStateList<IngredientDraft> snapshotStateList, SnapshotStateList<StepDraft> snapshotStateList2) {
                        this.$name$delegate = mutableState;
                        this.$nameError$delegate = mutableState2;
                        this.$viewModel = recipeViewModel;
                        this.$category$delegate = mutableState3;
                        this.$photoUrl$delegate = mutableState4;
                        this.$prepTime$delegate = mutableState5;
                        this.$baseServings$delegate = mutableState6;
                        this.$difficulty$delegate = mutableState7;
                        this.$notes$delegate = mutableState8;
                        this.$editing = recipeWithDetails;
                        this.$ingredients = snapshotStateList;
                        this.$steps = snapshotStateList2;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                        invoke(rowScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope TopAppBar, Composer $composer, int $changed) {
                        Object value$iv;
                        Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
                        ComposerKt.sourceInformation($composer, "C205@9302L1900,205@9281L2037:CreateEditRecipeScreen.kt#y43rd3");
                        if (($changed & 17) == 16 && $composer.getSkipping()) {
                            $composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-2046585036, $changed, -1, "com.easycompra.app.ui.recipes.CreateEditRecipeScreen.<anonymous>.<anonymous> (CreateEditRecipeScreen.kt:205)");
                        }
                        $composer.startReplaceGroup(-944259521);
                        ComposerKt.sourceInformation($composer, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
                        boolean invalid$iv = $composer.changed(this.$name$delegate) | $composer.changed(this.$nameError$delegate) | $composer.changedInstance(this.$viewModel) | $composer.changed(this.$category$delegate) | $composer.changed(this.$photoUrl$delegate) | $composer.changed(this.$prepTime$delegate) | $composer.changed(this.$baseServings$delegate) | $composer.changed(this.$difficulty$delegate) | $composer.changed(this.$notes$delegate) | $composer.changedInstance(this.$editing);
                        final SnapshotStateList<IngredientDraft> snapshotStateList = this.$ingredients;
                        final SnapshotStateList<StepDraft> snapshotStateList2 = this.$steps;
                        final RecipeViewModel recipeViewModel = this.$viewModel;
                        final RecipeWithDetails recipeWithDetails = this.$editing;
                        final MutableState<String> mutableState = this.$name$delegate;
                        final MutableState<Boolean> mutableState2 = this.$nameError$delegate;
                        final MutableState<String> mutableState3 = this.$category$delegate;
                        final MutableState<String> mutableState4 = this.$photoUrl$delegate;
                        final MutableState<String> mutableState5 = this.$prepTime$delegate;
                        final MutableState<String> mutableState6 = this.$baseServings$delegate;
                        final MutableState<String> mutableState7 = this.$difficulty$delegate;
                        final MutableState<String> mutableState8 = this.$notes$delegate;
                        Object it$iv = $composer.rememberedValue();
                        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = new Function0() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$5$3$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CreateEditRecipeScreenKt.AnonymousClass5.AnonymousClass3.invoke$lambda$5$lambda$4(snapshotStateList, snapshotStateList2, recipeViewModel, recipeWithDetails, mutableState, mutableState2, mutableState3, mutableState4, mutableState5, mutableState6, mutableState7, mutableState8);
                                }
                            };
                            $composer.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        $composer.endReplaceGroup();
                        ButtonKt.TextButton((Function0) value$iv, null, false, null, null, null, null, null, null, ComposableSingletons$CreateEditRecipeScreenKt.INSTANCE.m7194getLambda7$app_debug(), $composer, 805306368, 510);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$5$lambda$4(SnapshotStateList $ingredients, SnapshotStateList $steps, RecipeViewModel $viewModel, RecipeWithDetails $editing, MutableState $name$delegate, MutableState $nameError$delegate, MutableState $category$delegate, MutableState $photoUrl$delegate, MutableState $prepTime$delegate, MutableState $baseServings$delegate, MutableState $difficulty$delegate, MutableState $notes$delegate) {
                        RecipeEntity recipe;
                        if (StringsKt.isBlank(CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$3($name$delegate))) {
                            CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$33($nameError$delegate, true);
                            return Unit.INSTANCE;
                        }
                        CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$33($nameError$delegate, false);
                        SnapshotStateList $this$filter$iv = $ingredients;
                        Collection destination$iv$iv = new ArrayList();
                        for (Object element$iv$iv : $this$filter$iv) {
                            IngredientDraft it = (IngredientDraft) element$iv$iv;
                            if (!StringsKt.isBlank(it.getName())) {
                                destination$iv$iv.add(element$iv$iv);
                            }
                        }
                        Iterable $this$map$iv = (List) destination$iv$iv;
                        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                        for (Object item$iv$iv : $this$map$iv) {
                            IngredientDraft d = (IngredientDraft) item$iv$iv;
                            String id = d.getId();
                            String string = StringsKt.trim((CharSequence) d.getName()).toString();
                            Float floatOrNull = StringsKt.toFloatOrNull(d.getQty());
                            destination$iv$iv2.add(new IngredientEntity(id, "", string, floatOrNull != null ? floatOrNull.floatValue() : 0.0f, d.getUnit(), d.getLinkedProductId(), StringsKt.trim((CharSequence) d.getNotes()).toString()));
                        }
                        List ingEntities = (List) destination$iv$iv2;
                        SnapshotStateList $this$filter$iv2 = $steps;
                        Collection destination$iv$iv3 = new ArrayList();
                        for (Object element$iv$iv2 : $this$filter$iv2) {
                            StepDraft it2 = (StepDraft) element$iv$iv2;
                            if (!StringsKt.isBlank(it2.getDescription())) {
                                destination$iv$iv3.add(element$iv$iv2);
                            }
                        }
                        Iterable $this$mapIndexed$iv = (List) destination$iv$iv3;
                        Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                        int index$iv$iv = 0;
                        for (Object item$iv$iv2 : $this$mapIndexed$iv) {
                            int index$iv$iv2 = index$iv$iv + 1;
                            if (index$iv$iv < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            StepDraft d2 = (StepDraft) item$iv$iv2;
                            String id2 = d2.getId();
                            int i = index$iv$iv + 1;
                            String string2 = StringsKt.trim((CharSequence) d2.getDescription()).toString();
                            Integer intOrNull = StringsKt.toIntOrNull(d2.getTimeMinutes());
                            destination$iv$iv4.add(new RecipeStepEntity(id2, "", i, string2, intOrNull != null ? intOrNull.intValue() : 0));
                            index$iv$iv = index$iv$iv2;
                        }
                        List stepEntities = (List) destination$iv$iv4;
                        String string3 = StringsKt.trim((CharSequence) CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$3($name$delegate)).toString();
                        String strCreateEditRecipeScreen$lambda$7 = CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$7($category$delegate);
                        String string4 = StringsKt.trim((CharSequence) CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$11($photoUrl$delegate)).toString();
                        Integer intOrNull2 = StringsKt.toIntOrNull(CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$16($prepTime$delegate));
                        int iIntValue = intOrNull2 != null ? intOrNull2.intValue() : 0;
                        Integer intOrNull3 = StringsKt.toIntOrNull(CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$20($baseServings$delegate));
                        $viewModel.saveRecipe(string3, strCreateEditRecipeScreen$lambda$7, string4, iIntValue, intOrNull3 != null ? intOrNull3.intValue() : 4, CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$24($difficulty$delegate), StringsKt.trim((CharSequence) CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$28($notes$delegate)).toString(), ($editing == null || (recipe = $editing.getRecipe()) == null) ? false : recipe.isFavorite(), ingEntities, stepEntities);
                        return Unit.INSTANCE;
                    }
                }
            }, $composer2, i5), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-2089324710, z2, new AnonymousClass6(name$delegate, nameError$delegate, category$delegate, difficulty$delegate, prepTime$delegate, baseServings$delegate, photoUrl$delegate, notes$delegate, ingredients, steps, linkingIngredientIndex$delegate), $composer2, i5), $composer2, 805306416, 509);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            i2 = $changed;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$52(viewModel, editing, onDismiss, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RecipeUiState CreateEditRecipeScreen$lambda$0(State<RecipeUiState> state) {
        Object thisObj$iv = state.getValue();
        return (RecipeUiState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState CreateEditRecipeScreen$lambda$2$lambda$1(RecipeWithDetails $editing) {
        String name;
        RecipeEntity recipe;
        if ($editing == null || (recipe = $editing.getRecipe()) == null || (name = recipe.getName()) == null) {
            name = "";
        }
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(name, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String CreateEditRecipeScreen$lambda$3(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState CreateEditRecipeScreen$lambda$6$lambda$5(RecipeWithDetails $editing) {
        String category;
        RecipeEntity recipe;
        if ($editing == null || (recipe = $editing.getRecipe()) == null || (category = recipe.getCategory()) == null) {
            category = (String) CollectionsKt.first((List) RecipeCategories.INSTANCE.getAll());
        }
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(category, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String CreateEditRecipeScreen$lambda$7(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState CreateEditRecipeScreen$lambda$10$lambda$9(RecipeWithDetails $editing) {
        String photoUrl;
        RecipeEntity recipe;
        if ($editing == null || (recipe = $editing.getRecipe()) == null || (photoUrl = recipe.getPhotoUrl()) == null) {
            photoUrl = "";
        }
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(photoUrl, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String CreateEditRecipeScreen$lambda$11(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:16:0x002a  */
    public static final MutableState CreateEditRecipeScreen$lambda$15$lambda$14(RecipeWithDetails $editing) {
        String string;
        RecipeEntity recipe;
        if ($editing == null || (recipe = $editing.getRecipe()) == null) {
            string = "";
        } else {
            Integer numValueOf = Integer.valueOf(recipe.getPrepTimeMinutes());
            int it = numValueOf.intValue();
            if (!(it > 0)) {
                numValueOf = null;
            }
            if (numValueOf == null || (string = numValueOf.toString()) == null) {
                string = "";
            }
        }
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(string, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String CreateEditRecipeScreen$lambda$16(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState CreateEditRecipeScreen$lambda$19$lambda$18(RecipeWithDetails $editing) {
        String string;
        RecipeEntity recipe;
        if ($editing == null || (recipe = $editing.getRecipe()) == null || (string = Integer.valueOf(recipe.getBaseServings()).toString()) == null) {
            string = "4";
        }
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(string, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String CreateEditRecipeScreen$lambda$20(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState CreateEditRecipeScreen$lambda$23$lambda$22(RecipeWithDetails $editing) {
        String difficulty;
        RecipeEntity recipe;
        if ($editing == null || (recipe = $editing.getRecipe()) == null || (difficulty = recipe.getDifficulty()) == null) {
            difficulty = RecipeDifficulty.EASY;
        }
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(difficulty, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String CreateEditRecipeScreen$lambda$24(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState CreateEditRecipeScreen$lambda$27$lambda$26(RecipeWithDetails $editing) {
        String notes;
        RecipeEntity recipe;
        if ($editing == null || (recipe = $editing.getRecipe()) == null || (notes = recipe.getNotes()) == null) {
            notes = "";
        }
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(notes, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String CreateEditRecipeScreen$lambda$28(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState CreateEditRecipeScreen$lambda$31$lambda$30() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CreateEditRecipeScreen$lambda$32(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CreateEditRecipeScreen$lambda$33(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final Integer CreateEditRecipeScreen$lambda$44(MutableState<Integer> mutableState) {
        MutableState<Integer> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CreateEditRecipeScreen$lambda$45(MutableState<Integer> mutableState, Integer num) {
        mutableState.setValue(num);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String CreateEditRecipeScreen$lambda$47(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CreateEditRecipeScreen$lambda$48(MutableState<String> mutableState, String str) {
        mutableState.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CreateEditRecipeScreen$lambda$51$lambda$50(RecipeViewModel $viewModel, MutableState $linkingIngredientIndex$delegate, MutableState $pantryQuery$delegate) {
        $linkingIngredientIndex$delegate.setValue(null);
        $pantryQuery$delegate.setValue("");
        $viewModel.clearPantrySearch();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$4, reason: invalid class name */
    /* JADX INFO: compiled from: CreateEditRecipeScreen.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass4 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ int $idx;
        final /* synthetic */ SnapshotStateList<IngredientDraft> $ingredients;
        final /* synthetic */ MutableState<Integer> $linkingIngredientIndex$delegate;
        final /* synthetic */ MutableState<String> $pantryQuery$delegate;
        final /* synthetic */ State<RecipeUiState> $state$delegate;
        final /* synthetic */ RecipeViewModel $viewModel;

        AnonymousClass4(SnapshotStateList<IngredientDraft> snapshotStateList, int i, RecipeViewModel recipeViewModel, MutableState<String> mutableState, State<RecipeUiState> state, MutableState<Integer> mutableState2) {
            this.$ingredients = snapshotStateList;
            this.$idx = i;
            this.$viewModel = recipeViewModel;
            this.$pantryQuery$delegate = mutableState;
            this.$state$delegate = state;
            this.$linkingIngredientIndex$delegate = mutableState2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            Object value$iv;
            Object value$iv2;
            final PantryProductWithLocations pantryItem;
            Object value$iv3;
            ComposerKt.sourceInformation($composer, "C142@6166L2390:CreateEditRecipeScreen.kt#y43rd3");
            if (($changed & 3) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-804349733, $changed, -1, "com.easycompra.app.ui.recipes.CreateEditRecipeScreen.<anonymous> (CreateEditRecipeScreen.kt:142)");
                }
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(8));
                final SnapshotStateList<IngredientDraft> snapshotStateList = this.$ingredients;
                final int i = this.$idx;
                final RecipeViewModel recipeViewModel = this.$viewModel;
                final MutableState<String> mutableState = this.$pantryQuery$delegate;
                State<RecipeUiState> state = this.$state$delegate;
                MutableState<Integer> mutableState2 = this.$linkingIngredientIndex$delegate;
                ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                Modifier modifier$iv = Modifier.INSTANCE;
                Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                int $changed$iv$iv = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    $composer.createNode(constructor);
                } else {
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
                ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                int i3 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 789705563, "C143@6245L102,146@6472L20,144@6368L310:CreateEditRecipeScreen.kt#y43rd3");
                TextKt.m2714Text4IGK_g("Busca el producto de tu despensa que corresponde a: " + snapshotStateList.get(i).getName(), (Modifier) null, 0L, TextUnitKt.getSp(13), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 3072, 0, 131062);
                String strCreateEditRecipeScreen$lambda$47 = CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$47(mutableState);
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                $composer.startReplaceGroup(-944351961);
                ComposerKt.sourceInformation($composer, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
                Object it$iv = $composer.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function1() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$4$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CreateEditRecipeScreenKt.AnonymousClass4.invoke$lambda$7$lambda$1$lambda$0(mutableState, (String) obj);
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                $composer.endReplaceGroup();
                OutlinedTextFieldKt.OutlinedTextField(strCreateEditRecipeScreen$lambda$47, (Function1<? super String, Unit>) value$iv, modifierFillMaxWidth$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$CreateEditRecipeScreenKt.INSTANCE.m7191getLambda4$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer, 1573296, 12582912, 0, 8257464);
                $composer.startReplaceGroup(-944344541);
                ComposerKt.sourceInformation($composer, "152@6793L60");
                if (CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$0(state).getPantrySearchResults().isEmpty() && CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$47(mutableState).length() >= 2) {
                    TextKt.m2714Text4IGK_g("Sin resultados", (Modifier) null, Color.INSTANCE.m4211getGray0d7_KjU(), TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 3462, 0, 131058);
                }
                $composer.endReplaceGroup();
                $composer.startReplaceGroup(-944336452);
                ComposerKt.sourceInformation($composer, "*158@7115L501,167@7710L11,167@7668L69,168@7764L265,155@6970L1059");
                Iterable $this$forEach$iv = CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$0(state).getPantrySearchResults();
                int $i$f$forEach = 0;
                for (Object element$iv : $this$forEach$iv) {
                    PantryProductWithLocations pantryItem2 = (PantryProductWithLocations) element$iv;
                    Iterable $this$forEach$iv2 = $this$forEach$iv;
                    int $i$f$forEach2 = $i$f$forEach;
                    Function0<ComposeUiNode> function0 = constructor;
                    Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    $composer.startReplaceGroup(1912038631);
                    ComposerKt.sourceInformation($composer, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
                    boolean invalid$iv = $composer.changed(i) | $composer.changedInstance(pantryItem2) | $composer.changedInstance(recipeViewModel);
                    Object it$iv2 = $composer.rememberedValue();
                    if (invalid$iv || it$iv2 == Composer.INSTANCE.getEmpty()) {
                        pantryItem = pantryItem2;
                        final MutableState<Integer> mutableState3 = mutableState2;
                        value$iv3 = new Function0() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$4$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CreateEditRecipeScreenKt.AnonymousClass4.invoke$lambda$7$lambda$4$lambda$3$lambda$2(snapshotStateList, i, pantryItem, recipeViewModel, mutableState3, mutableState);
                            }
                        };
                        $composer.updateRememberedValue(value$iv3);
                    } else {
                        value$iv3 = it$iv2;
                        pantryItem = pantryItem2;
                    }
                    $composer.endReplaceGroup();
                    final PantryProductWithLocations pantryItem3 = pantryItem;
                    CardKt.Card(ClickableKt.m269clickableXHw0xAI$default(modifierFillMaxWidth$default2, false, null, null, (Function0) value$iv3, 7, null), null, CardDefaults.INSTANCE.m1850cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceVariant(), 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14), null, null, ComposableLambdaKt.rememberComposableLambda(-1001198587, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$4$1$2$2
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                            invoke(columnScope, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ColumnScope Card, Composer $composer2, int $changed2) {
                            Intrinsics.checkNotNullParameter(Card, "$this$Card");
                            ComposerKt.sourceInformation($composer2, "C169@7794L209:CreateEditRecipeScreen.kt#y43rd3");
                            if (($changed2 & 17) != 16 || !$composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1001198587, $changed2, -1, "com.easycompra.app.ui.recipes.CreateEditRecipeScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CreateEditRecipeScreen.kt:169)");
                                }
                                TextKt.m2714Text4IGK_g(pantryItem3.getProduct().getName(), PaddingKt.m681padding3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(10)), 0L, TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 3120, 0, 131060);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer2.skipToGroupEnd();
                        }
                    }, $composer, 54), $composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 26);
                    $this$forEach$iv = $this$forEach$iv2;
                    $i$f$forEach = $i$f$forEach2;
                    constructor = function0;
                    localMap$iv$iv = localMap$iv$iv;
                    measurePolicy$iv = measurePolicy$iv;
                    horizontalAlignment$iv = horizontalAlignment$iv;
                    modifier$iv = modifier$iv;
                    mutableState2 = mutableState2;
                }
                final MutableState<Integer> mutableState4 = mutableState2;
                $composer.endReplaceGroup();
                $composer.startReplaceGroup(-944300315);
                ComposerKt.sourceInformation($composer, "177@8165L307,177@8144L372");
                if (snapshotStateList.get(i).getLinkedProductId() != null) {
                    $composer.startReplaceGroup(-944297498);
                    ComposerKt.sourceInformation($composer, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
                    boolean invalid$iv2 = $composer.changed(i) | $composer.changedInstance(recipeViewModel);
                    Object it$iv3 = $composer.rememberedValue();
                    if (invalid$iv2 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new Function0() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$4$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return CreateEditRecipeScreenKt.AnonymousClass4.invoke$lambda$7$lambda$6$lambda$5(snapshotStateList, i, recipeViewModel, mutableState4, mutableState);
                            }
                        };
                        $composer.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv3;
                    }
                    $composer.endReplaceGroup();
                    ButtonKt.TextButton((Function0) value$iv2, null, false, null, null, null, null, null, null, ComposableSingletons$CreateEditRecipeScreenKt.INSTANCE.m7192getLambda5$app_debug(), $composer, 805306368, 510);
                }
                $composer.endReplaceGroup();
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
        public static final Unit invoke$lambda$7$lambda$1$lambda$0(MutableState $pantryQuery$delegate, String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$48($pantryQuery$delegate, it);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$7$lambda$4$lambda$3$lambda$2(SnapshotStateList $ingredients, int $idx, PantryProductWithLocations $pantryItem, RecipeViewModel $viewModel, MutableState $linkingIngredientIndex$delegate, MutableState $pantryQuery$delegate) {
            $ingredients.set($idx, IngredientDraft.copy$default((IngredientDraft) $ingredients.get($idx), null, null, null, null, null, $pantryItem.getProduct().getId(), $pantryItem.getProduct().getName(), 31, null));
            CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$45($linkingIngredientIndex$delegate, null);
            CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$48($pantryQuery$delegate, "");
            $viewModel.clearPantrySearch();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$7$lambda$6$lambda$5(SnapshotStateList $ingredients, int $idx, RecipeViewModel $viewModel, MutableState $linkingIngredientIndex$delegate, MutableState $pantryQuery$delegate) {
            $ingredients.set($idx, IngredientDraft.copy$default((IngredientDraft) $ingredients.get($idx), null, null, null, null, null, null, null, 31, null));
            CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$45($linkingIngredientIndex$delegate, null);
            CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$48($pantryQuery$delegate, "");
            $viewModel.clearPantrySearch();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$3, reason: invalid class name */
    /* JADX INFO: compiled from: CreateEditRecipeScreen.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass3 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ MutableState<Integer> $linkingIngredientIndex$delegate;
        final /* synthetic */ MutableState<String> $pantryQuery$delegate;
        final /* synthetic */ RecipeViewModel $viewModel;

        AnonymousClass3(RecipeViewModel recipeViewModel, MutableState<Integer> mutableState, MutableState<String> mutableState2) {
            this.$viewModel = recipeViewModel;
            this.$linkingIngredientIndex$delegate = mutableState;
            this.$pantryQuery$delegate = mutableState2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            Object value$iv;
            ComposerKt.sourceInformation($composer, "C187@8655L140,187@8634L181:CreateEditRecipeScreen.kt#y43rd3");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1208043480, $changed, -1, "com.easycompra.app.ui.recipes.CreateEditRecipeScreen.<anonymous> (CreateEditRecipeScreen.kt:187)");
            }
            $composer.startReplaceGroup(-630349184);
            ComposerKt.sourceInformation($composer, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(this.$viewModel);
            final RecipeViewModel recipeViewModel = this.$viewModel;
            final MutableState<Integer> mutableState = this.$linkingIngredientIndex$delegate;
            final MutableState<String> mutableState2 = this.$pantryQuery$delegate;
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function0() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$3$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CreateEditRecipeScreenKt.AnonymousClass3.invoke$lambda$1$lambda$0(recipeViewModel, mutableState, mutableState2);
                    }
                };
                $composer.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer.endReplaceGroup();
            ButtonKt.TextButton((Function0) value$iv, null, false, null, null, null, null, null, null, ComposableSingletons$CreateEditRecipeScreenKt.INSTANCE.m7186getLambda2$app_debug(), $composer, 805306368, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$1$lambda$0(RecipeViewModel $viewModel, MutableState $linkingIngredientIndex$delegate, MutableState $pantryQuery$delegate) {
            CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$45($linkingIngredientIndex$delegate, null);
            CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$48($pantryQuery$delegate, "");
            $viewModel.clearPantrySearch();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$6, reason: invalid class name */
    /* JADX INFO: compiled from: CreateEditRecipeScreen.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass6 implements Function3<PaddingValues, Composer, Integer, Unit> {
        final /* synthetic */ MutableState<String> $baseServings$delegate;
        final /* synthetic */ MutableState<String> $category$delegate;
        final /* synthetic */ MutableState<String> $difficulty$delegate;
        final /* synthetic */ SnapshotStateList<IngredientDraft> $ingredients;
        final /* synthetic */ MutableState<Integer> $linkingIngredientIndex$delegate;
        final /* synthetic */ MutableState<String> $name$delegate;
        final /* synthetic */ MutableState<Boolean> $nameError$delegate;
        final /* synthetic */ MutableState<String> $notes$delegate;
        final /* synthetic */ MutableState<String> $photoUrl$delegate;
        final /* synthetic */ MutableState<String> $prepTime$delegate;
        final /* synthetic */ SnapshotStateList<StepDraft> $steps;

        AnonymousClass6(MutableState<String> mutableState, MutableState<Boolean> mutableState2, MutableState<String> mutableState3, MutableState<String> mutableState4, MutableState<String> mutableState5, MutableState<String> mutableState6, MutableState<String> mutableState7, MutableState<String> mutableState8, SnapshotStateList<IngredientDraft> snapshotStateList, SnapshotStateList<StepDraft> snapshotStateList2, MutableState<Integer> mutableState9) {
            this.$name$delegate = mutableState;
            this.$nameError$delegate = mutableState2;
            this.$category$delegate = mutableState3;
            this.$difficulty$delegate = mutableState4;
            this.$prepTime$delegate = mutableState5;
            this.$baseServings$delegate = mutableState6;
            this.$photoUrl$delegate = mutableState7;
            this.$notes$delegate = mutableState8;
            this.$ingredients = snapshotStateList;
            this.$steps = snapshotStateList2;
            this.$linkingIngredientIndex$delegate = mutableState9;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer, Integer num) {
            invoke(paddingValues, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(PaddingValues padding, Composer $composer, int $changed) {
            Object value$iv;
            Intrinsics.checkNotNullParameter(padding, "padding");
            ComposerKt.sourceInformation($composer, "C257@11818L10682,251@11591L10909:CreateEditRecipeScreen.kt#y43rd3");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= $composer.changed(padding) ? 4 : 2;
            }
            int $dirty2 = $dirty;
            if (($dirty2 & 19) != 18 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2089324710, $dirty2, -1, "com.easycompra.app.ui.recipes.CreateEditRecipeScreen.<anonymous> (CreateEditRecipeScreen.kt:251)");
                }
                Modifier modifierM683paddingVpY3zN4$default = PaddingKt.m683paddingVpY3zN4$default(PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), padding), Dp.m6663constructorimpl(16), 0.0f, 2, null);
                Arrangement.HorizontalOrVertical horizontalOrVerticalM561spacedBy0680j_4 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(10));
                $composer.startReplaceGroup(-630237426);
                ComposerKt.sourceInformation($composer, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
                boolean invalid$iv = $composer.changed(this.$name$delegate) | $composer.changed(this.$nameError$delegate) | $composer.changed(this.$category$delegate) | $composer.changed(this.$difficulty$delegate) | $composer.changed(this.$prepTime$delegate) | $composer.changed(this.$baseServings$delegate) | $composer.changed(this.$photoUrl$delegate) | $composer.changed(this.$notes$delegate);
                final SnapshotStateList<IngredientDraft> snapshotStateList = this.$ingredients;
                final SnapshotStateList<StepDraft> snapshotStateList2 = this.$steps;
                final MutableState<String> mutableState = this.$name$delegate;
                final MutableState<Boolean> mutableState2 = this.$nameError$delegate;
                final MutableState<String> mutableState3 = this.$category$delegate;
                final MutableState<String> mutableState4 = this.$difficulty$delegate;
                final MutableState<String> mutableState5 = this.$prepTime$delegate;
                final MutableState<String> mutableState6 = this.$baseServings$delegate;
                final MutableState<String> mutableState7 = this.$photoUrl$delegate;
                final MutableState<String> mutableState8 = this.$notes$delegate;
                final MutableState<Integer> mutableState9 = this.$linkingIngredientIndex$delegate;
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function1() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CreateEditRecipeScreenKt.AnonymousClass6.invoke$lambda$5$lambda$4(snapshotStateList, snapshotStateList2, mutableState, mutableState2, mutableState3, mutableState4, mutableState5, mutableState6, mutableState7, mutableState8, mutableState9, (LazyListScope) obj);
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                $composer.endReplaceGroup();
                LazyDslKt.LazyColumn(modifierM683paddingVpY3zN4$default, null, null, false, horizontalOrVerticalM561spacedBy0680j_4, null, null, false, (Function1) value$iv, $composer, 24576, 238);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$5$lambda$4(final SnapshotStateList $ingredients, final SnapshotStateList $steps, MutableState $name$delegate, MutableState $nameError$delegate, MutableState $category$delegate, MutableState $difficulty$delegate, MutableState $prepTime$delegate, MutableState $baseServings$delegate, MutableState $photoUrl$delegate, MutableState $notes$delegate, final MutableState $linkingIngredientIndex$delegate, LazyListScope LazyColumn) {
            Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$CreateEditRecipeScreenKt.INSTANCE.m7195getLambda8$app_debug(), 3, null);
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1562082277, true, new CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$1$1$1($name$delegate, $nameError$delegate)), 3, null);
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-672962522, true, new CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$1$1$2($category$delegate)), 3, null);
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1386959975, true, new CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$1$1$3($difficulty$delegate)), 3, null);
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-848084824, true, new CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$1$1$4($prepTime$delegate, $baseServings$delegate)), 3, null);
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1211837673, true, new CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$1$1$5($photoUrl$delegate)), 3, null);
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1023207126, true, new CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$1$1$6($notes$delegate)), 3, null);
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1036715371, true, new CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$1$1$7($ingredients)), 3, null);
            final Function2 key$iv = new Function2() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CreateEditRecipeScreenKt.AnonymousClass6.invoke$lambda$5$lambda$4$lambda$0(((Integer) obj).intValue(), (IngredientDraft) obj2);
                }
            };
            final SnapshotStateList snapshotStateList = $ingredients;
            final SnapshotStateList snapshotStateList2 = $ingredients;
            final SnapshotStateList snapshotStateList3 = $ingredients;
            LazyColumn.items($ingredients.size(), new Function1<Integer, Object>() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$invoke$lambda$5$lambda$4$$inlined$itemsIndexed$default$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int index) {
                    return key$iv.invoke(Integer.valueOf(index), snapshotStateList.get(index));
                }
            }, new Function1<Integer, Object>() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$invoke$lambda$5$lambda$4$$inlined$itemsIndexed$default$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int index) {
                    snapshotStateList2.get(index);
                    return null;
                }
            }, ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$invoke$lambda$5$lambda$4$$inlined$itemsIndexed$default$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                    invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope $this$items, final int it, Composer $composer, int $changed) {
                    long surfaceVariant;
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
                    final IngredientDraft draft = (IngredientDraft) snapshotStateList3.get(it);
                    $composer.startReplaceGroup(-1776867273);
                    ComposerKt.sourceInformation($composer, "CP(1)*354@15613L213,358@15845L3275,352@15509L3611:CreateEditRecipeScreen.kt#y43rd3");
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    CardDefaults cardDefaults = CardDefaults.INSTANCE;
                    $composer.startReplaceGroup(-888600741);
                    ComposerKt.sourceInformation($composer, "356@15778L11");
                    if (draft.getLinkedProductId() != null) {
                        long jColor = ColorKt.Color(4279286145L);
                        surfaceVariant = Color.m4179copywmQWz5c(jColor, (14 & 1) != 0 ? Color.m4183getAlphaimpl(jColor) : 0.08f, (14 & 2) != 0 ? Color.m4187getRedimpl(jColor) : 0.0f, (14 & 4) != 0 ? Color.m4186getGreenimpl(jColor) : 0.0f, (14 & 8) != 0 ? Color.m4184getBlueimpl(jColor) : 0.0f);
                    } else {
                        surfaceVariant = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceVariant();
                    }
                    $composer.endReplaceGroup();
                    CardColors cardColorsM1850cardColorsro_MJ88 = cardDefaults.m1850cardColorsro_MJ88(surfaceVariant, 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14);
                    final SnapshotStateList snapshotStateList4 = $ingredients;
                    final MutableState mutableState = $linkingIngredientIndex$delegate;
                    CardKt.Card(modifierFillMaxWidth$default, null, cardColorsM1850cardColorsro_MJ88, null, null, ComposableLambdaKt.rememberComposableLambda(1759794240, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$1$1$9$1
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                            invoke(columnScope, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ColumnScope Card, Composer $composer2, int $changed2) {
                            Function0<ComposeUiNode> function0;
                            Function0<ComposeUiNode> function1;
                            Object value$iv;
                            Object value$iv2;
                            Function0<ComposeUiNode> function2;
                            Object value$iv3;
                            Object value$iv4;
                            Object value$iv5;
                            Intrinsics.checkNotNullParameter(Card, "$this$Card");
                            ComposerKt.sourceInformation($composer2, "C359@15867L3235:CreateEditRecipeScreen.kt#y43rd3");
                            if (($changed2 & 17) == 16 && $composer2.getSkipping()) {
                                $composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1759794240, $changed2, -1, "com.easycompra.app.ui.recipes.CreateEditRecipeScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CreateEditRecipeScreen.kt:359)");
                            }
                            Modifier modifier$iv = PaddingKt.m681padding3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(10));
                            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(6));
                            final IngredientDraft ingredientDraft = draft;
                            final int i2 = it;
                            final SnapshotStateList<IngredientDraft> snapshotStateList5 = snapshotStateList4;
                            final MutableState<Integer> mutableState2 = mutableState;
                            ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((54 >> 3) & 14) | ((54 >> 3) & 112));
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
                            int i3 = ($changed$iv$iv$iv >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer2, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                            int i4 = ((54 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer2, 1416189758, "C360@15986L1331,383@17342L974,402@18453L45,400@18341L369:CreateEditRecipeScreen.kt#y43rd3");
                            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                            ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                            Modifier modifier$iv2 = Modifier.INSTANCE;
                            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                            int $changed$iv$iv2 = (384 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!($composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer2.startReusableNode();
                            if ($composer2.getInserting()) {
                                function1 = constructor2;
                                $composer2.createNode(function1);
                            } else {
                                function1 = constructor2;
                                $composer2.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3674constructorimpl($composer2);
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                            }
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer2, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                            int i6 = ((384 >> 6) & 112) | 6;
                            RowScope $this$invoke_u24lambda_u248_u24lambda_u243 = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer2, -1795686706, "C363@16187L44,361@16068L368,368@16465L28,369@16543L32,369@16577L319,369@16522L374,377@16979L55,379@17129L162,376@16925L366:CreateEditRecipeScreen.kt#y43rd3");
                            String name = ingredientDraft.getName();
                            Modifier modifierWeight$default = RowScope.weight$default($this$invoke_u24lambda_u248_u24lambda_u243, Modifier.INSTANCE, 1.0f, false, 2, null);
                            $composer2.startReplaceGroup(-1443396070);
                            ComposerKt.sourceInformation($composer2, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
                            boolean invalid$iv = $composer2.changed(i2) | $composer2.changed(ingredientDraft);
                            Object value$iv6 = $composer2.rememberedValue();
                            if (invalid$iv || value$iv6 == Composer.INSTANCE.getEmpty()) {
                                value$iv6 = (Function1) new Function1<String, Unit>() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$1$1$9$1$1$1$1$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                        invoke2(str);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(String it2) {
                                        Intrinsics.checkNotNullParameter(it2, "it");
                                        snapshotStateList5.set(i2, IngredientDraft.copy$default(ingredientDraft, null, it2, null, null, null, null, null, 125, null));
                                    }
                                };
                                $composer2.updateRememberedValue(value$iv6);
                            }
                            $composer2.endReplaceGroup();
                            OutlinedTextFieldKt.OutlinedTextField(name, (Function1<? super String, Unit>) value$iv6, modifierWeight$default, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$CreateEditRecipeScreenKt.INSTANCE.m7182getLambda16$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer2, 1572864, 12582912, 0, 8257464);
                            SpacerKt.Spacer(SizeKt.m731width3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(4)), $composer2, 6);
                            $composer2.startReplaceGroup(-1443384690);
                            ComposerKt.sourceInformation($composer2, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
                            boolean invalid$iv2 = $composer2.changed(i2);
                            Object it$iv = $composer2.rememberedValue();
                            if (invalid$iv2 || it$iv == Composer.INSTANCE.getEmpty()) {
                                value$iv = new Function0<Unit>() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$1$1$9$1$1$1$2$1
                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$45(mutableState2, Integer.valueOf(i2));
                                    }
                                };
                                $composer2.updateRememberedValue(value$iv);
                            } else {
                                value$iv = it$iv;
                            }
                            $composer2.endReplaceGroup();
                            IconButtonKt.IconButton((Function0) value$iv, null, false, null, null, ComposableLambdaKt.rememberComposableLambda(-448642903, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$1$1$9$1$1$1$3
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                    invoke(composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer $composer3, int $changed3) {
                                    ComposerKt.sourceInformation($composer3, "C370@16611L255:CreateEditRecipeScreen.kt#y43rd3");
                                    if (($changed3 & 3) != 2 || !$composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-448642903, $changed3, -1, "com.easycompra.app.ui.recipes.CreateEditRecipeScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CreateEditRecipeScreen.kt:370)");
                                        }
                                        IconKt.m2171Iconww6aTOc(LinkKt.getLink(Icons.INSTANCE.getDefault()), "Vincular", (Modifier) null, ingredientDraft.getLinkedProductId() != null ? ColorKt.Color(4279286145L) : Color.INSTANCE.m4211getGray0d7_KjU(), $composer3, 48, 4);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer3.skipToGroupEnd();
                                }
                            }, $composer2, 54), $composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                            $composer2.startReplaceGroup(-1443370715);
                            ComposerKt.sourceInformation($composer2, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
                            boolean invalid$iv3 = $composer2.changed(i2);
                            Object it$iv2 = $composer2.rememberedValue();
                            if (invalid$iv3 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                value$iv2 = (Function0) new Function0<Unit>() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$1$1$9$1$1$1$4$1
                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        if (snapshotStateList5.size() > 1) {
                                            snapshotStateList5.remove(i2);
                                        }
                                    }
                                };
                                $composer2.updateRememberedValue(value$iv2);
                            } else {
                                value$iv2 = it$iv2;
                            }
                            Function0 function3 = (Function0) value$iv2;
                            $composer2.endReplaceGroup();
                            IconButtonKt.IconButton(function3, null, snapshotStateList5.size() > 1, null, null, ComposableLambdaKt.rememberComposableLambda(1680809810, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$1$1$9$1$1$1$5
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                    invoke(composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer $composer3, int $changed3) {
                                    ComposerKt.sourceInformation($composer3, "C380@17163L98:CreateEditRecipeScreen.kt#y43rd3");
                                    if (($changed3 & 3) == 2 && $composer3.getSkipping()) {
                                        $composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1680809810, $changed3, -1, "com.easycompra.app.ui.recipes.CreateEditRecipeScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CreateEditRecipeScreen.kt:380)");
                                    }
                                    IconKt.m2171Iconww6aTOc(DeleteKt.getDelete(Icons.INSTANCE.getDefault()), "Eliminar", (Modifier) null, snapshotStateList5.size() > 1 ? Color.INSTANCE.m4215getRed0d7_KjU() : Color.INSTANCE.m4211getGray0d7_KjU(), $composer3, 48, 4);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, $composer2, 54), $composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 26);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            $composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(6));
                            ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                            Modifier modifier$iv3 = Modifier.INSTANCE;
                            Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getTop();
                            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer2, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                            int $changed$iv$iv3 = (48 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                            int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                            CompositionLocalMap localMap$iv$iv3 = $composer2.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer2, modifier$iv3);
                            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!($composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer2.startReusableNode();
                            if ($composer2.getInserting()) {
                                function2 = constructor3;
                                $composer2.createNode(function2);
                            } else {
                                function2 = constructor3;
                                $composer2.useNode();
                            }
                            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3674constructorimpl($composer2);
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                                $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                                $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
                            }
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                            int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer2, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                            int i8 = ((48 >> 6) & 112) | 6;
                            RowScope $this$invoke_u24lambda_u248_u24lambda_u246 = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer2, -1794348777, "C386@17546L43,384@17428L472,396@18152L44,392@17929L361:CreateEditRecipeScreen.kt#y43rd3");
                            String qty = ingredientDraft.getQty();
                            KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m6359getDecimalPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 123, (DefaultConstructorMarker) null);
                            Modifier modifierWeight$default2 = RowScope.weight$default($this$invoke_u24lambda_u248_u24lambda_u246, Modifier.INSTANCE, 1.0f, false, 2, null);
                            $composer2.startReplaceGroup(-1443352583);
                            ComposerKt.sourceInformation($composer2, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
                            boolean invalid$iv4 = $composer2.changed(i2) | $composer2.changed(ingredientDraft);
                            Object it$iv3 = $composer2.rememberedValue();
                            if (invalid$iv4 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                value$iv3 = (Function1) new Function1<String, Unit>() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$1$1$9$1$1$2$1$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                        invoke2(str);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(String it2) {
                                        Intrinsics.checkNotNullParameter(it2, "it");
                                        snapshotStateList5.set(i2, IngredientDraft.copy$default(ingredientDraft, null, null, it2, null, null, null, null, 123, null));
                                    }
                                };
                                $composer2.updateRememberedValue(value$iv3);
                            } else {
                                value$iv3 = it$iv3;
                            }
                            $composer2.endReplaceGroup();
                            OutlinedTextFieldKt.OutlinedTextField(qty, (Function1<? super String, Unit>) value$iv3, modifierWeight$default2, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$CreateEditRecipeScreenKt.INSTANCE.m7183getLambda17$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptions, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer2, 1572864, 12779520, 0, 8224696);
                            String unit = ingredientDraft.getUnit();
                            List<String> all = RecipeUnits.INSTANCE.getAll();
                            $composer2.startReplaceGroup(-1443333190);
                            ComposerKt.sourceInformation($composer2, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
                            boolean invalid$iv5 = $composer2.changed(i2) | $composer2.changed(ingredientDraft);
                            Object it$iv4 = $composer2.rememberedValue();
                            if (invalid$iv5 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                                value$iv4 = (Function1) new Function1<String, Unit>() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$1$1$9$1$1$2$2$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                        invoke2(str);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(String it2) {
                                        Intrinsics.checkNotNullParameter(it2, "it");
                                        snapshotStateList5.set(i2, IngredientDraft.copy$default(ingredientDraft, null, null, null, it2, null, null, null, 119, null));
                                    }
                                };
                                $composer2.updateRememberedValue(value$iv4);
                            } else {
                                value$iv4 = it$iv4;
                            }
                            $composer2.endReplaceGroup();
                            CreateEditRecipeScreenKt.SimpleDropdown("Unidad", unit, all, (Function1) value$iv4, RowScope.weight$default($this$invoke_u24lambda_u248_u24lambda_u246, Modifier.INSTANCE, 1.0f, false, 2, null), $composer2, 6, 0);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            $composer2.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            ComposerKt.sourceInformationMarkerEnd($composer2);
                            String notes = ingredientDraft.getNotes();
                            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                            $composer2.startReplaceGroup(599948764);
                            ComposerKt.sourceInformation($composer2, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
                            boolean invalid$iv6 = $composer2.changed(i2) | $composer2.changed(ingredientDraft);
                            Object it$iv5 = $composer2.rememberedValue();
                            if (invalid$iv6 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                                value$iv5 = new Function1<String, Unit>() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$1$1$9$1$1$3$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                        invoke2(str);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(String it2) {
                                        Intrinsics.checkNotNullParameter(it2, "it");
                                        snapshotStateList5.set(i2, IngredientDraft.copy$default(ingredientDraft, null, null, null, null, it2, null, null, 111, null));
                                    }
                                };
                                $composer2.updateRememberedValue(value$iv5);
                            } else {
                                value$iv5 = it$iv5;
                            }
                            $composer2.endReplaceGroup();
                            OutlinedTextFieldKt.OutlinedTextField(notes, (Function1<? super String, Unit>) value$iv5, modifierFillMaxWidth$default2, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$CreateEditRecipeScreenKt.INSTANCE.m7184getLambda18$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer2, 1573248, 12582912, 0, 8257464);
                            $composer2.startReplaceGroup(599958088);
                            ComposerKt.sourceInformation($composer2, "408@18800L254");
                            if (ingredientDraft.getLinkedProductId() != null) {
                                String linkedProductName = ingredientDraft.getLinkedProductName();
                                if (linkedProductName == null) {
                                    linkedProductName = ingredientDraft.getLinkedProductId();
                                }
                                TextKt.m2714Text4IGK_g("✓ Vinculado a despensa: " + linkedProductName, (Modifier) null, ColorKt.Color(4279286145L), TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 3456, 0, 131058);
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
                    }, $composer, 54), $composer, 196614, 26);
                    $composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1198329428, true, new CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$1$1$10($steps)), 3, null);
            final Function2 key$iv2 = new Function2() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CreateEditRecipeScreenKt.AnonymousClass6.invoke$lambda$5$lambda$4$lambda$2(((Integer) obj).intValue(), (StepDraft) obj2);
                }
            };
            final SnapshotStateList snapshotStateList4 = $steps;
            final SnapshotStateList snapshotStateList5 = $steps;
            final SnapshotStateList snapshotStateList6 = $steps;
            LazyColumn.items($steps.size(), new Function1<Integer, Object>() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$invoke$lambda$5$lambda$4$$inlined$itemsIndexed$default$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int index) {
                    return key$iv2.invoke(Integer.valueOf(index), snapshotStateList4.get(index));
                }
            }, new Function1<Integer, Object>() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$invoke$lambda$5$lambda$4$$inlined$itemsIndexed$default$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int index) {
                    snapshotStateList5.get(index);
                    return null;
                }
            }, ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$invoke$lambda$5$lambda$4$$inlined$itemsIndexed$default$6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                    invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope $this$items, final int it, Composer $composer, int $changed) {
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
                    final StepDraft draft = (StepDraft) snapshotStateList6.get(it);
                    $composer.startReplaceGroup(-1772536480);
                    ComposerKt.sourceInformation($composer, "CP(1)*435@20055L11,435@20013L69,436@20101L2322,433@19909L2514:CreateEditRecipeScreen.kt#y43rd3");
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    CardColors cardColorsM1850cardColorsro_MJ88 = CardDefaults.INSTANCE.m1850cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSurfaceVariant(), 0L, 0L, 0L, $composer, CardDefaults.$stable << 12, 14);
                    final SnapshotStateList snapshotStateList7 = $steps;
                    CardKt.Card(modifierFillMaxWidth$default, null, cardColorsM1850cardColorsro_MJ88, null, null, ComposableLambdaKt.rememberComposableLambda(-212149198, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$1$1$12$1
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                            invoke(columnScope, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(ColumnScope Card, Composer $composer2, int $changed2) {
                            Function0<ComposeUiNode> function0;
                            Function0<ComposeUiNode> function1;
                            Function0<ComposeUiNode> function2;
                            Object value$iv;
                            Object value$iv2;
                            Object value$iv3;
                            Intrinsics.checkNotNullParameter(Card, "$this$Card");
                            ComposerKt.sourceInformation($composer2, "C437@20123L2282:CreateEditRecipeScreen.kt#y43rd3");
                            if (($changed2 & 17) != 16 || !$composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-212149198, $changed2, -1, "com.easycompra.app.ui.recipes.CreateEditRecipeScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CreateEditRecipeScreen.kt:437)");
                                }
                                Modifier modifierM681padding3ABfNKs = PaddingKt.m681padding3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(10));
                                Alignment.Vertical top = Alignment.INSTANCE.getTop();
                                Arrangement.HorizontalOrVertical horizontalOrVerticalM561spacedBy0680j_4 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(8));
                                final int i2 = it;
                                final SnapshotStateList<StepDraft> snapshotStateList8 = snapshotStateList7;
                                final StepDraft stepDraft = draft;
                                ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                                MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalOrVerticalM561spacedBy0680j_4, top, $composer2, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                                int $changed$iv$iv = (438 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                                CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifierM681padding3ABfNKs);
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
                                int i3 = ($changed$iv$iv$iv >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer2, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                                int i4 = ((438 >> 6) & 112) | 6;
                                RowScope $this$invoke_u24lambda_u245 = RowScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart($composer2, 1420505175, "C442@20370L579,455@20974L1062,473@22111L43,475@22235L148,472@22061L322:CreateEditRecipeScreen.kt#y43rd3");
                                Modifier modifier$iv = $this$invoke_u24lambda_u245.align(SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(28)), Alignment.INSTANCE.getCenterVertically());
                                Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
                                ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                                int $changed$iv$iv2 = (48 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                                CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!($composer2.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer2.startReusableNode();
                                if ($composer2.getInserting()) {
                                    function1 = constructor2;
                                    $composer2.createNode(function1);
                                } else {
                                    function1 = constructor2;
                                    $composer2.useNode();
                                }
                                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3674constructorimpl($composer2);
                                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                                }
                                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                                int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                int i6 = ((48 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer2, -1791165046, "C451@20824L11,448@20656L267:CreateEditRecipeScreen.kt#y43rd3");
                                TextKt.m2714Text4IGK_g(String.valueOf(i2 + 1), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getPrimary(), TextUnitKt.getSp(16), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 199680, 0, 131026);
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                $composer2.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                Modifier modifier$iv2 = RowScope.weight$default($this$invoke_u24lambda_u245, Modifier.INSTANCE, 1.0f, false, 2, null);
                                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(6));
                                ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                                Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                                MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                                int $changed$iv$iv3 = (48 << 3) & 112;
                                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                                CompositionLocalMap localMap$iv$iv3 = $composer2.getCurrentCompositionLocalMap();
                                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
                                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                if (!($composer2.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                $composer2.startReusableNode();
                                if ($composer2.getInserting()) {
                                    function2 = constructor3;
                                    $composer2.createNode(function2);
                                } else {
                                    function2 = constructor3;
                                    $composer2.useNode();
                                }
                                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3674constructorimpl($composer2);
                                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                                    $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                                    $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
                                }
                                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                                int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
                                ComposerKt.sourceInformationMarkerStart($composer2, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                int i8 = ((48 >> 6) & 112) | 6;
                                ComposerKt.sourceInformationMarkerStart($composer2, -1790711392, "C458@21219L45,456@21093L389,465@21637L45,463@21511L499:CreateEditRecipeScreen.kt#y43rd3");
                                String description = stepDraft.getDescription();
                                Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                $composer2.startReplaceGroup(-1443235045);
                                ComposerKt.sourceInformation($composer2, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
                                boolean invalid$iv = $composer2.changed(i2) | $composer2.changed(stepDraft);
                                Object it$iv = $composer2.rememberedValue();
                                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                                    value$iv = new Function1<String, Unit>() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$1$1$12$1$1$2$1$1
                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                            invoke2(str);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(String it2) {
                                            Intrinsics.checkNotNullParameter(it2, "it");
                                            snapshotStateList8.set(i2, StepDraft.copy$default(stepDraft, null, it2, null, 5, null));
                                        }
                                    };
                                    $composer2.updateRememberedValue(value$iv);
                                } else {
                                    value$iv = it$iv;
                                }
                                $composer2.endReplaceGroup();
                                OutlinedTextFieldKt.OutlinedTextField(description, (Function1<? super String, Unit>) value$iv, modifierFillMaxWidth$default2, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$CreateEditRecipeScreenKt.INSTANCE.m7187getLambda20$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, 2, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer2, 1573248, 805306368, 0, 7864248);
                                String timeMinutes = stepDraft.getTimeMinutes();
                                KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, KeyboardType.INSTANCE.m6361getNumberPjHm6EE(), 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 123, (DefaultConstructorMarker) null);
                                Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                                $composer2.startReplaceGroup(-1443221669);
                                ComposerKt.sourceInformation($composer2, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
                                boolean invalid$iv2 = $composer2.changed(i2) | $composer2.changed(stepDraft);
                                Object it$iv2 = $composer2.rememberedValue();
                                if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                    value$iv2 = (Function1) new Function1<String, Unit>() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$1$1$12$1$1$2$2$1
                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                            invoke2(str);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(String it2) {
                                            Intrinsics.checkNotNullParameter(it2, "it");
                                            snapshotStateList8.set(i2, StepDraft.copy$default(stepDraft, null, null, it2, 3, null));
                                        }
                                    };
                                    $composer2.updateRememberedValue(value$iv2);
                                } else {
                                    value$iv2 = it$iv2;
                                }
                                $composer2.endReplaceGroup();
                                OutlinedTextFieldKt.OutlinedTextField(timeMinutes, (Function1<? super String, Unit>) value$iv2, modifierFillMaxWidth$default3, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$CreateEditRecipeScreenKt.INSTANCE.m7188getLambda21$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptions, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer2, 1573248, 12779520, 0, 8224696);
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                $composer2.endNode();
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                                $composer2.startReplaceGroup(600065818);
                                ComposerKt.sourceInformation($composer2, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
                                boolean invalid$iv3 = $composer2.changed(i2);
                                Object it$iv3 = $composer2.rememberedValue();
                                if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                    value$iv3 = new Function0<Unit>() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$1$1$12$1$1$3$1
                                        @Override // kotlin.jvm.functions.Function0
                                        public /* bridge */ /* synthetic */ Unit invoke() {
                                            invoke2();
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2() {
                                            if (snapshotStateList8.size() > 1) {
                                                snapshotStateList8.remove(i2);
                                            }
                                        }
                                    };
                                    $composer2.updateRememberedValue(value$iv3);
                                } else {
                                    value$iv3 = it$iv3;
                                }
                                Function0 function3 = (Function0) value$iv3;
                                $composer2.endReplaceGroup();
                                IconButtonKt.IconButton(function3, null, snapshotStateList8.size() > 1, null, null, ComposableLambdaKt.rememberComposableLambda(1897638225, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$1$1$12$1$1$4
                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                        invoke(composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer $composer3, int $changed3) {
                                        ComposerKt.sourceInformation($composer3, "C476@22265L92:CreateEditRecipeScreen.kt#y43rd3");
                                        if (($changed3 & 3) == 2 && $composer3.getSkipping()) {
                                            $composer3.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1897638225, $changed3, -1, "com.easycompra.app.ui.recipes.CreateEditRecipeScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CreateEditRecipeScreen.kt:476)");
                                        }
                                        IconKt.m2171Iconww6aTOc(DeleteKt.getDelete(Icons.INSTANCE.getDefault()), "Eliminar", (Modifier) null, snapshotStateList8.size() > 1 ? Color.INSTANCE.m4215getRed0d7_KjU() : Color.INSTANCE.m4211getGray0d7_KjU(), $composer3, 48, 4);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, $composer2, 54), $composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 26);
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
                    $composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$CreateEditRecipeScreenKt.INSTANCE.m7189getLambda22$app_debug(), 3, null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object invoke$lambda$5$lambda$4$lambda$0(int i, IngredientDraft d) {
            Intrinsics.checkNotNullParameter(d, "d");
            return d.getId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object invoke$lambda$5$lambda$4$lambda$2(int i, StepDraft d) {
            Intrinsics.checkNotNullParameter(d, "d");
            return d.getId();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SimpleDropdown(final String label, final String selected, final List<String> list, final Function1<? super String, Unit> function1, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Object value$iv;
        Object value$iv2;
        Composer $composer2 = $composer.startRestartGroup(438409600);
        ComposerKt.sourceInformation($composer2, "C(SimpleDropdown)P(!1,4,3,2)496@22748L34,499@22867L17,501@22920L692,497@22787L825:CreateEditRecipeScreen.kt#y43rd3");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(label) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(selected) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        if (($dirty & 9363) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            Modifier modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(438409600, $dirty, -1, "com.easycompra.app.ui.recipes.SimpleDropdown (CreateEditRecipeScreen.kt:495)");
            }
            $composer2.startReplaceGroup(-681246342);
            ComposerKt.sourceInformation($composer2, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState expanded$delegate = (MutableState) value$iv;
            $composer2.endReplaceGroup();
            boolean zSimpleDropdown$lambda$54 = SimpleDropdown$lambda$54(expanded$delegate);
            $composer2.startReplaceGroup(-681242551);
            ComposerKt.sourceInformation($composer2, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new Function1() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CreateEditRecipeScreenKt.SimpleDropdown$lambda$57$lambda$56(expanded$delegate, ((Boolean) obj).booleanValue());
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            $composer2.endReplaceGroup();
            ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox(zSimpleDropdown$lambda$54, (Function1) value$iv2, modifier3, ComposableLambdaKt.rememberComposableLambda(-686089174, true, new AnonymousClass2(selected, label, expanded$delegate, list, function1), $composer2, 54), $composer2, (($dirty >> 6) & 896) | 3120, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CreateEditRecipeScreenKt.SimpleDropdown$lambda$58(label, selected, list, function1, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean SimpleDropdown$lambda$54(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SimpleDropdown$lambda$55(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SimpleDropdown$lambda$57$lambda$56(MutableState $expanded$delegate, boolean it) {
        SimpleDropdown$lambda$55($expanded$delegate, it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$SimpleDropdown$2, reason: invalid class name */
    /* JADX INFO: compiled from: CreateEditRecipeScreen.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass2 implements Function3<ExposedDropdownMenuBoxScope, Composer, Integer, Unit> {
        final /* synthetic */ MutableState<Boolean> $expanded$delegate;
        final /* synthetic */ String $label;
        final /* synthetic */ Function1<String, Unit> $onSelect;
        final /* synthetic */ List<String> $options;
        final /* synthetic */ String $selected;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(String str, String str2, MutableState<Boolean> mutableState, List<String> list, Function1<? super String, Unit> function1) {
            this.$selected = str;
            this.$label = str2;
            this.$expanded$delegate = mutableState;
            this.$options = list;
            this.$onSelect = function1;
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
            ComposerKt.sourceInformation($composer, "C504@23007L2,506@23060L15,507@23104L54,502@22930L363,511@23362L20,511@23384L222,511@23302L304:CreateEditRecipeScreen.kt#y43rd3");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= ($changed & 8) == 0 ? $composer.changed(ExposedDropdownMenuBox) : $composer.changedInstance(ExposedDropdownMenuBox) ? 4 : 2;
            }
            int $dirty2 = $dirty;
            if (($dirty2 & 19) != 18 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-686089174, $dirty2, -1, "com.easycompra.app.ui.recipes.SimpleDropdown.<anonymous> (CreateEditRecipeScreen.kt:502)");
                }
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(ExposedDropdownMenuBoxScope.m2100menuAnchorfsE2BvY$default(ExposedDropdownMenuBox, Modifier.INSTANCE, MenuAnchorType.INSTANCE.m2246getPrimaryNotEditableMg6Rgbw(), false, 2, null), 0.0f, 1, null);
                String str = this.$selected;
                $composer.startReplaceGroup(1932287929);
                ComposerKt.sourceInformation($composer, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
                Object it$iv = $composer.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function1() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$SimpleDropdown$2$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CreateEditRecipeScreenKt.AnonymousClass2.invoke$lambda$1$lambda$0((String) obj);
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                $composer.endReplaceGroup();
                final String str2 = this.$label;
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(710167376, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt.SimpleDropdown.2.2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer2, int $changed2) {
                        ComposerKt.sourceInformation($composer2, "C506@23062L11:CreateEditRecipeScreen.kt#y43rd3");
                        if (($changed2 & 3) == 2 && $composer2.getSkipping()) {
                            $composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(710167376, $changed2, -1, "com.easycompra.app.ui.recipes.SimpleDropdown.<anonymous>.<anonymous> (CreateEditRecipeScreen.kt:506)");
                        }
                        TextKt.m2714Text4IGK_g(str2, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 0, 0, 131070);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer, 54);
                final MutableState<Boolean> mutableState = this.$expanded$delegate;
                OutlinedTextFieldKt.OutlinedTextField(str, (Function1<? super String, Unit>) value$iv, modifierFillMaxWidth$default, false, true, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) composableLambdaRememberComposableLambda, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-963784813, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt.SimpleDropdown.2.3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer2, int $changed2) {
                        ComposerKt.sourceInformation($composer2, "C507@23134L22:CreateEditRecipeScreen.kt#y43rd3");
                        if (($changed2 & 3) == 2 && $composer2.getSkipping()) {
                            $composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-963784813, $changed2, -1, "com.easycompra.app.ui.recipes.SimpleDropdown.<anonymous>.<anonymous> (CreateEditRecipeScreen.kt:507)");
                        }
                        ExposedDropdownMenuDefaults.INSTANCE.TrailingIcon(CreateEditRecipeScreenKt.SimpleDropdown$lambda$54(mutableState), null, $composer2, ExposedDropdownMenuDefaults.$stable << 6, 2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer, 54), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer, 806903856, 12582912, 0, 8256936);
                boolean zSimpleDropdown$lambda$54 = CreateEditRecipeScreenKt.SimpleDropdown$lambda$54(this.$expanded$delegate);
                $composer.startReplaceGroup(1932299307);
                ComposerKt.sourceInformation($composer, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
                final MutableState<Boolean> mutableState2 = this.$expanded$delegate;
                Object it$iv2 = $composer.rememberedValue();
                if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = new Function0() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$SimpleDropdown$2$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CreateEditRecipeScreenKt.AnonymousClass2.invoke$lambda$3$lambda$2(mutableState2);
                        }
                    };
                    $composer.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv2;
                }
                $composer.endReplaceGroup();
                ExposedDropdownMenuBox.m2102ExposedDropdownMenuvNxi1II(zSimpleDropdown$lambda$54, (Function0) value$iv2, null, null, false, null, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-1602355412, true, new AnonymousClass5(this.$options, this.$onSelect, this.$expanded$delegate), $composer, 54), $composer, 48, (ExposedDropdownMenuBoxScope.$stable << 3) | 6 | (($dirty2 << 3) & 112), PointerIconCompat.TYPE_GRAB);
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

        /* JADX INFO: renamed from: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$SimpleDropdown$2$5, reason: invalid class name */
        /* JADX INFO: compiled from: CreateEditRecipeScreen.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        static final class AnonymousClass5 implements Function3<ColumnScope, Composer, Integer, Unit> {
            final /* synthetic */ MutableState<Boolean> $expanded$delegate;
            final /* synthetic */ Function1<String, Unit> $onSelect;
            final /* synthetic */ List<String> $options;

            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass5(List<String> list, Function1<? super String, Unit> function1, MutableState<Boolean> mutableState) {
                this.$options = list;
                this.$onSelect = function1;
                this.$expanded$delegate = mutableState;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                invoke(columnScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(ColumnScope ExposedDropdownMenu, Composer $composer, int $changed) {
                Object value$iv;
                Intrinsics.checkNotNullParameter(ExposedDropdownMenu, "$this$ExposedDropdownMenu");
                ComposerKt.sourceInformation($composer, "C*514@23484L13,515@23529L35,513@23439L143:CreateEditRecipeScreen.kt#y43rd3");
                if (($changed & 17) != 16 || !$composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1602355412, $changed, -1, "com.easycompra.app.ui.recipes.SimpleDropdown.<anonymous>.<anonymous> (CreateEditRecipeScreen.kt:512)");
                    }
                    Iterable $this$forEach$iv = this.$options;
                    final Function1<String, Unit> function1 = this.$onSelect;
                    final MutableState<Boolean> mutableState = this.$expanded$delegate;
                    for (Object element$iv : $this$forEach$iv) {
                        final String opt = (String) element$iv;
                        ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1222342484, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$SimpleDropdown$2$5$1$1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer2, int $changed2) {
                                ComposerKt.sourceInformation($composer2, "C514@23486L9:CreateEditRecipeScreen.kt#y43rd3");
                                if (($changed2 & 3) == 2 && $composer2.getSkipping()) {
                                    $composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1222342484, $changed2, -1, "com.easycompra.app.ui.recipes.SimpleDropdown.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CreateEditRecipeScreen.kt:514)");
                                }
                                TextKt.m2714Text4IGK_g(opt, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 0, 0, 131070);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer, 54);
                        $composer.startReplaceGroup(247515544);
                        ComposerKt.sourceInformation($composer, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
                        boolean invalid$iv = $composer.changed(function1) | $composer.changed(opt);
                        Object it$iv = $composer.rememberedValue();
                        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = new Function0() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$SimpleDropdown$2$5$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return CreateEditRecipeScreenKt.AnonymousClass2.AnonymousClass5.invoke$lambda$2$lambda$1$lambda$0(function1, opt, mutableState);
                                }
                            };
                            $composer.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        $composer.endReplaceGroup();
                        AndroidMenu_androidKt.DropdownMenuItem(composableLambdaRememberComposableLambda, (Function0) value$iv, null, null, null, false, null, null, null, $composer, 6, 508);
                        function1 = function1;
                        mutableState = mutableState;
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
            public static final Unit invoke$lambda$2$lambda$1$lambda$0(Function1 $onSelect, String $opt, MutableState $expanded$delegate) {
                $onSelect.invoke($opt);
                CreateEditRecipeScreenKt.SimpleDropdown$lambda$55($expanded$delegate, false);
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$3$lambda$2(MutableState $expanded$delegate) {
            CreateEditRecipeScreenKt.SimpleDropdown$lambda$55($expanded$delegate, false);
            return Unit.INSTANCE;
        }
    }
}
