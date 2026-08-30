package com.easycompra.app.ui.shopping;

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
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CheckCircleKt;
import androidx.compose.material.icons.filled.ShoppingCartKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.CheckboxKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarColors;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
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
import com.easycompra.app.data.Product;
import com.easycompra.app.data.ShoppingListItem;
import com.easycompra.app.data.pantry.PantryLocationEntity;
import com.easycompra.app.data.pantry.PantryProductWithLocations;
import com.easycompra.app.data.recipes.RecipeShoppingItem;
import com.easycompra.app.ui.components.NutriScoreBadgeKt;
import com.easycompra.app.ui.list.ProductListUiState;
import com.easycompra.app.ui.list.ProductListViewModel;
import com.easycompra.app.ui.pantry.PantryUiState;
import com.easycompra.app.ui.pantry.PantryViewModel;
import com.easycompra.app.ui.recipes.RecipeUiState;
import com.easycompra.app.ui.recipes.RecipeViewModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: ShoppingListScreen.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\u001aA\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\u000b\u001a\u0015\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0003¢\u0006\u0002\u0010\u000f\u001a#\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H\u0003¢\u0006\u0002\u0010\u0015\u001a#\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H\u0003¢\u0006\u0002\u0010\u0019\u001aM\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H\u0003¢\u0006\u0002\u0010\u001f\u001a\u001b\u0010 \u001a\u00020\u00012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001b0\"H\u0003¢\u0006\u0002\u0010#¨\u0006$²\u0006\n\u0010%\u001a\u00020&X\u008a\u0084\u0002"}, d2 = {"ShoppingListScreen", "", "viewModel", "Lcom/easycompra/app/ui/list/ProductListViewModel;", "pantryViewModel", "Lcom/easycompra/app/ui/pantry/PantryViewModel;", "recipeViewModel", "Lcom/easycompra/app/ui/recipes/RecipeViewModel;", "onProductClick", "Lkotlin/Function1;", "Lcom/easycompra/app/data/Product;", "(Lcom/easycompra/app/ui/list/ProductListViewModel;Lcom/easycompra/app/ui/pantry/PantryViewModel;Lcom/easycompra/app/ui/recipes/RecipeViewModel;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "SectionHeader", "title", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "PantryNeedsBuyCard", "item", "Lcom/easycompra/app/data/pantry/PantryProductWithLocations;", "onUncheck", "Lkotlin/Function0;", "(Lcom/easycompra/app/data/pantry/PantryProductWithLocations;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "RecipeShoppingItemCard", "Lcom/easycompra/app/data/recipes/RecipeShoppingItem;", "onRemove", "(Lcom/easycompra/app/data/recipes/RecipeShoppingItem;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ShoppingItemCard", "Lcom/easycompra/app/data/ShoppingListItem;", "onIncrease", "onDecrease", "onClick", "(Lcom/easycompra/app/data/ShoppingListItem;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ShoppingTotalsCard", "items", "", "(Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "app_debug", "state", "Lcom/easycompra/app/ui/list/ProductListUiState;"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ShoppingListScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PantryNeedsBuyCard$lambda$5(PantryProductWithLocations pantryProductWithLocations, Function0 function0, int i, Composer composer, int i2) {
        PantryNeedsBuyCard(pantryProductWithLocations, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecipeShoppingItemCard$lambda$6(RecipeShoppingItem recipeShoppingItem, Function0 function0, int i, Composer composer, int i2) {
        RecipeShoppingItemCard(recipeShoppingItem, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SectionHeader$lambda$2(String str, int i, Composer composer, int i2) {
        SectionHeader(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShoppingItemCard$lambda$7(ShoppingListItem shoppingListItem, Function0 function0, Function0 function1, Function0 function2, Function0 function3, int i, Composer composer, int i2) {
        ShoppingItemCard(shoppingListItem, function0, function1, function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShoppingListScreen$lambda$1(ProductListViewModel productListViewModel, PantryViewModel pantryViewModel, RecipeViewModel recipeViewModel, Function1 function1, int i, int i2, Composer composer, int i3) {
        ShoppingListScreen(productListViewModel, pantryViewModel, recipeViewModel, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShoppingTotalsCard$lambda$14(List list, int i, Composer composer, int i2) {
        ShoppingTotalsCard(list, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShoppingTotalsCard$lambda$15(List list, int i, Composer composer, int i2) {
        ShoppingTotalsCard(list, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ShoppingListScreen(final ProductListViewModel viewModel, PantryViewModel pantryViewModel, RecipeViewModel recipeViewModel, final Function1<? super Product, Unit> onProductClick, Composer $composer, final int $changed, final int i) {
        PantryViewModel pantryViewModel2;
        RecipeViewModel recipeViewModel2;
        List<PantryProductWithLocations> listEmptyList;
        List<RecipeShoppingItem> listEmptyList2;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(onProductClick, "onProductClick");
        Composer $composer3 = $composer.startRestartGroup(-2002717860);
        ComposerKt.sourceInformation($composer3, "C(ShoppingListScreen)P(3,1,2)65@2933L16,73@3306L1218,102@4531L3967,72@3279L5219:ShoppingListScreen.kt#fjjmxg");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer3.changed(viewModel) : $composer3.changedInstance(viewModel) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= ($changed & 64) == 0 ? $composer3.changed(pantryViewModel) : $composer3.changedInstance(pantryViewModel) ? 32 : 16;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= ($changed & 512) == 0 ? $composer3.changed(recipeViewModel) : $composer3.changedInstance(recipeViewModel) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(onProductClick) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 1171) == 1170 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            pantryViewModel2 = pantryViewModel;
            recipeViewModel2 = recipeViewModel;
            $composer2 = $composer3;
        } else {
            pantryViewModel2 = i2 != 0 ? null : pantryViewModel;
            recipeViewModel2 = i3 != 0 ? null : recipeViewModel;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2002717860, $dirty2, -1, "com.easycompra.app.ui.shopping.ShoppingListScreen (ShoppingListScreen.kt:64)");
            }
            State state$delegate = SnapshotStateKt.collectAsState(viewModel.getUiState(), null, $composer3, 0, 1);
            final List<ShoppingListItem> shoppingList = ShoppingListScreen$lambda$0(state$delegate).getShoppingList();
            StateFlow<PantryUiState> uiState = pantryViewModel2 != null ? pantryViewModel2.getUiState() : null;
            $composer3.startReplaceGroup(-628505380);
            ComposerKt.sourceInformation($composer3, "67@3033L16");
            State stateCollectAsState = uiState == null ? null : SnapshotStateKt.collectAsState(uiState, null, $composer3, 0, 1);
            $composer3.endReplaceGroup();
            PantryUiState pantryState = stateCollectAsState != null ? (PantryUiState) stateCollectAsState.getValue() : null;
            if (pantryState == null || (listEmptyList = pantryState.getNeedsToBuyItems()) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            final List<PantryProductWithLocations> list = listEmptyList;
            StateFlow<RecipeUiState> state = recipeViewModel2 != null ? recipeViewModel2.getState() : null;
            $composer3.startReplaceGroup(-628500932);
            ComposerKt.sourceInformation($composer3, "69@3172L16");
            State stateCollectAsState2 = state == null ? null : SnapshotStateKt.collectAsState(state, null, $composer3, 0, 1);
            $composer3.endReplaceGroup();
            RecipeUiState recipeState = stateCollectAsState2 != null ? (RecipeUiState) stateCollectAsState2.getValue() : null;
            if (recipeState == null || (listEmptyList2 = recipeState.getRecipeShoppingItems()) == null) {
                listEmptyList2 = CollectionsKt.emptyList();
            }
            final List<RecipeShoppingItem> list2 = listEmptyList2;
            $composer2 = $composer3;
            ScaffoldKt.m2429ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(-1907785192, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt.ShoppingListScreen.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C89@4038L11,88@3970L216,75@3355L570,93@4214L286,74@3320L1194:ShoppingListScreen.kt#fjjmxg");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1907785192, $changed2, -1, "com.easycompra.app.ui.shopping.ShoppingListScreen.<anonymous> (ShoppingListScreen.kt:74)");
                        }
                        TopAppBarColors topAppBarColorsM2885topAppBarColorszjMxDiM = TopAppBarDefaults.INSTANCE.m2885topAppBarColorszjMxDiM(MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getPrimary(), 0L, 0L, Color.INSTANCE.m4218getWhite0d7_KjU(), Color.INSTANCE.m4218getWhite0d7_KjU(), $composer4, (TopAppBarDefaults.$stable << 15) | 27648, 6);
                        final List<ShoppingListItem> list3 = shoppingList;
                        final List<PantryProductWithLocations> list4 = list;
                        final List<RecipeShoppingItem> list5 = list2;
                        AppBarKt.m1794TopAppBarGHTll3U(ComposableLambdaKt.rememberComposableLambda(-1387388708, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt.ShoppingListScreen.1.1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer5, int $changed3) {
                                Function0<ComposeUiNode> function0;
                                ComposerKt.sourceInformation($composer5, "C76@3377L530:ShoppingListScreen.kt#fjjmxg");
                                if (($changed3 & 3) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1387388708, $changed3, -1, "com.easycompra.app.ui.shopping.ShoppingListScreen.<anonymous>.<anonymous> (ShoppingListScreen.kt:76)");
                                    }
                                    List<ShoppingListItem> list6 = list3;
                                    List<PantryProductWithLocations> list7 = list4;
                                    List<RecipeShoppingItem> list8 = list5;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                                    Modifier modifier$iv = Modifier.INSTANCE;
                                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                    Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                                    MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer5, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                    int $changed$iv$iv = (0 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                    int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                                    CompositionLocalMap localMap$iv$iv = $composer5.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer5, modifier$iv);
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                    if (!($composer5.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer5.startReusableNode();
                                    if ($composer5.getInserting()) {
                                        function0 = constructor;
                                        $composer5.createNode(function0);
                                    } else {
                                        function0 = constructor;
                                        $composer5.useNode();
                                    }
                                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3674constructorimpl($composer5);
                                    Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                        $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                        $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                    }
                                    Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                    int i4 = ($changed$iv$iv$iv >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                    int i5 = ((0 >> 6) & 112) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer5, 1421166143, "C77@3410L46:ShoppingListScreen.kt#fjjmxg");
                                    TextKt.m2714Text4IGK_g("Mi Lista", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer5, 196614, 0, 131038);
                                    int total = list6.size() + list7.size() + list8.size();
                                    $composer5.startReplaceGroup(-1062529411);
                                    ComposerKt.sourceInformation($composer5, "80@3622L237");
                                    if (total > 0) {
                                        String str = total + " elemento" + (total != 1 ? "s" : "");
                                        long sp = TextUnitKt.getSp(12);
                                        long jM4218getWhite0d7_KjU = Color.INSTANCE.m4218getWhite0d7_KjU();
                                        TextKt.m2714Text4IGK_g(str, (Modifier) null, Color.m4179copywmQWz5c(jM4218getWhite0d7_KjU, (14 & 1) != 0 ? Color.m4183getAlphaimpl(jM4218getWhite0d7_KjU) : 0.8f, (14 & 2) != 0 ? Color.m4187getRedimpl(jM4218getWhite0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m4186getGreenimpl(jM4218getWhite0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m4184getBlueimpl(jM4218getWhite0d7_KjU) : 0.0f), sp, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer5, 3456, 0, 131058);
                                    }
                                    $composer5.endReplaceGroup();
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    $composer5.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }, $composer4, 54), null, null, ComposableLambdaKt.rememberComposableLambda(-541171769, true, new AnonymousClass2(shoppingList, viewModel), $composer4, 54), 0.0f, null, topAppBarColorsM2885topAppBarColorszjMxDiM, null, $composer4, 3078, 182);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }

                /* JADX INFO: renamed from: com.easycompra.app.ui.shopping.ShoppingListScreenKt$ShoppingListScreen$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: ShoppingListScreen.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                static final class AnonymousClass2 implements Function3<RowScope, Composer, Integer, Unit> {
                    final /* synthetic */ List<ShoppingListItem> $items;
                    final /* synthetic */ ProductListViewModel $viewModel;

                    AnonymousClass2(List<ShoppingListItem> list, ProductListViewModel productListViewModel) {
                        this.$items = list;
                        this.$viewModel = productListViewModel;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                        invoke(rowScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope TopAppBar, Composer $composer, int $changed) {
                        Object value$iv;
                        Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
                        ComposerKt.sourceInformation($composer, "C95@4307L33,95@4286L174:ShoppingListScreen.kt#fjjmxg");
                        if (($changed & 17) != 16 || !$composer.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-541171769, $changed, -1, "com.easycompra.app.ui.shopping.ShoppingListScreen.<anonymous>.<anonymous> (ShoppingListScreen.kt:94)");
                            }
                            if (!this.$items.isEmpty()) {
                                $composer.startReplaceGroup(1752145323);
                                ComposerKt.sourceInformation($composer, "CC(remember):ShoppingListScreen.kt#9igjgp");
                                boolean invalid$iv = $composer.changedInstance(this.$viewModel);
                                final ProductListViewModel productListViewModel = this.$viewModel;
                                Object it$iv = $composer.rememberedValue();
                                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                                    value$iv = new Function0() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$ShoppingListScreen$1$2$$ExternalSyntheticLambda0
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return ShoppingListScreenKt.C07491.AnonymousClass2.invoke$lambda$1$lambda$0(productListViewModel);
                                        }
                                    };
                                    $composer.updateRememberedValue(value$iv);
                                } else {
                                    value$iv = it$iv;
                                }
                                $composer.endReplaceGroup();
                                IconButtonKt.IconButton((Function0) value$iv, null, false, null, null, ComposableSingletons$ShoppingListScreenKt.INSTANCE.m7239getLambda1$app_debug(), $composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
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
                    public static final Unit invoke$lambda$1$lambda$0(ProductListViewModel $viewModel) {
                        $viewModel.clearShoppingList();
                        return Unit.INSTANCE;
                    }
                }
            }, $composer3, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1033973485, true, new AnonymousClass2(shoppingList, list, list2, pantryViewModel2, recipeViewModel2, viewModel, onProductClick), $composer3, 54), $composer2, 805306416, 509);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final PantryViewModel pantryViewModel3 = pantryViewModel2;
            final RecipeViewModel recipeViewModel3 = recipeViewModel2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ShoppingListScreenKt.ShoppingListScreen$lambda$1(viewModel, pantryViewModel3, recipeViewModel3, onProductClick, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final ProductListUiState ShoppingListScreen$lambda$0(State<ProductListUiState> state) {
        Object thisObj$iv = state.getValue();
        return (ProductListUiState) thisObj$iv;
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.shopping.ShoppingListScreenKt$ShoppingListScreen$2, reason: invalid class name */
    /* JADX INFO: compiled from: ShoppingListScreen.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass2 implements Function3<PaddingValues, Composer, Integer, Unit> {
        final /* synthetic */ List<ShoppingListItem> $items;
        final /* synthetic */ Function1<Product, Unit> $onProductClick;
        final /* synthetic */ List<PantryProductWithLocations> $pantryNeedsBuy;
        final /* synthetic */ PantryViewModel $pantryViewModel;
        final /* synthetic */ List<RecipeShoppingItem> $recipeShoppingItems;
        final /* synthetic */ RecipeViewModel $recipeViewModel;
        final /* synthetic */ ProductListViewModel $viewModel;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(List<ShoppingListItem> list, List<PantryProductWithLocations> list2, List<RecipeShoppingItem> list3, PantryViewModel pantryViewModel, RecipeViewModel recipeViewModel, ProductListViewModel productListViewModel, Function1<? super Product, Unit> function1) {
            this.$items = list;
            this.$pantryNeedsBuy = list2;
            this.$recipeShoppingItems = list3;
            this.$pantryViewModel = pantryViewModel;
            this.$recipeViewModel = recipeViewModel;
            this.$viewModel = productListViewModel;
            this.$onProductClick = function1;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer, Integer num) {
            invoke(paddingValues, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(PaddingValues padding, Composer $composer, int $changed) {
            Object value$iv;
            Function0<ComposeUiNode> function0;
            Function0<ComposeUiNode> function1;
            Intrinsics.checkNotNullParameter(padding, "padding");
            ComposerKt.sourceInformation($composer, "C:ShoppingListScreen.kt#fjjmxg");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= $composer.changed(padding) ? 4 : 2;
            }
            int $dirty2 = $dirty;
            if (($dirty2 & 19) != 18 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1033973485, $dirty2, -1, "com.easycompra.app.ui.shopping.ShoppingListScreen.<anonymous> (ShoppingListScreen.kt:103)");
                }
                if (this.$items.isEmpty() && this.$pantryNeedsBuy.isEmpty() && this.$recipeShoppingItems.isEmpty()) {
                    $composer.startReplaceGroup(-645957144);
                    ComposerKt.sourceInformation($composer, "104@4648L1111");
                    Modifier modifier$iv = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), padding);
                    Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
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
                    ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    int i2 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, -1517547699, "C108@4805L940:ShoppingListScreen.kt#fjjmxg");
                    Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM561spacedBy0680j_4 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(12));
                    ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                    Modifier modifier$iv2 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM561spacedBy0680j_4, centerHorizontally, $composer, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                    int $changed$iv$iv2 = (432 << 3) & 112;
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
                    ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    int i4 = ((432 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, 1422746430, "C112@4995L234,120@5349L10,118@5250L187,125@5635L10,123@5458L269:ShoppingListScreen.kt#fjjmxg");
                    IconKt.m2171Iconww6aTOc(ShoppingCartKt.getShoppingCart(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(72)), Color.INSTANCE.m4213getLightGray0d7_KjU(), $composer, 3504, 0);
                    TextKt.m2714Text4IGK_g("Tu lista está vacía", (Modifier) null, Color.INSTANCE.m4211getGray0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getTitleMedium(), $composer, 390, 0, 65530);
                    TextKt.m2714Text4IGK_g("Añade productos desde el detalle, marca\n\"Necesito comprar\" en tu Despensa\no cocina una Receta", (Modifier) null, Color.INSTANCE.m4213getLightGray0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodyMedium(), $composer, 390, 0, 65530);
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
                    $composer.endReplaceGroup();
                } else {
                    $composer.startReplaceGroup(-644776230);
                    ComposerKt.sourceInformation($composer, "135@6018L2464,131@5789L2693");
                    Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, padding);
                    PaddingValues paddingValuesM675PaddingValuesYgX7TsA = PaddingKt.m675PaddingValuesYgX7TsA(Dp.m6663constructorimpl(8), Dp.m6663constructorimpl(8));
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM561spacedBy0680j_5 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(6));
                    $composer.startReplaceGroup(1364681611);
                    ComposerKt.sourceInformation($composer, "CC(remember):ShoppingListScreen.kt#9igjgp");
                    boolean invalid$iv = $composer.changedInstance(this.$pantryNeedsBuy) | $composer.changedInstance(this.$pantryViewModel) | $composer.changedInstance(this.$items) | $composer.changedInstance(this.$recipeShoppingItems) | $composer.changedInstance(this.$recipeViewModel) | $composer.changedInstance(this.$viewModel) | $composer.changed(this.$onProductClick);
                    final List<PantryProductWithLocations> list = this.$pantryNeedsBuy;
                    final List<ShoppingListItem> list2 = this.$items;
                    final List<RecipeShoppingItem> list3 = this.$recipeShoppingItems;
                    final PantryViewModel pantryViewModel = this.$pantryViewModel;
                    final RecipeViewModel recipeViewModel = this.$recipeViewModel;
                    final ProductListViewModel productListViewModel = this.$viewModel;
                    final Function1<Product, Unit> function2 = this.$onProductClick;
                    Object it$iv = $composer.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = new Function1() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$ShoppingListScreen$2$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ShoppingListScreenKt.AnonymousClass2.invoke$lambda$15$lambda$14(list, list2, list3, pantryViewModel, recipeViewModel, productListViewModel, function2, (LazyListScope) obj);
                            }
                        };
                        $composer.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer.endReplaceGroup();
                    LazyDslKt.LazyColumn(modifierPadding, null, paddingValuesM675PaddingValuesYgX7TsA, false, horizontalOrVerticalM561spacedBy0680j_5, null, null, false, (Function1) value$iv, $composer, 24960, 234);
                    $composer.endReplaceGroup();
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
        public static final Unit invoke$lambda$15$lambda$14(final List $pantryNeedsBuy, final List $items, final List $recipeShoppingItems, final PantryViewModel $pantryViewModel, final RecipeViewModel $recipeViewModel, final ProductListViewModel $viewModel, final Function1 $onProductClick, LazyListScope LazyColumn) {
            Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
            if (!$pantryNeedsBuy.isEmpty()) {
                LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$ShoppingListScreenKt.INSTANCE.m7240getLambda2$app_debug(), 3, null);
                final Function1 key$iv = new Function1() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$ShoppingListScreen$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ShoppingListScreenKt.AnonymousClass2.invoke$lambda$15$lambda$14$lambda$2((PantryProductWithLocations) obj);
                    }
                };
                final Function1 contentType$iv = new Function1() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$ShoppingListScreen$2$invoke$lambda$15$lambda$14$$inlined$items$default$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                        return invoke((PantryProductWithLocations) p1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Void invoke(PantryProductWithLocations pantryProductWithLocations) {
                        return null;
                    }
                };
                LazyColumn.items($pantryNeedsBuy.size(), new Function1<Integer, Object>() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$ShoppingListScreen$2$invoke$lambda$15$lambda$14$$inlined$items$default$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Object invoke(int index) {
                        return key$iv.invoke($pantryNeedsBuy.get(index));
                    }
                }, new Function1<Integer, Object>() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$ShoppingListScreen$2$invoke$lambda$15$lambda$14$$inlined$items$default$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Object invoke(int index) {
                        return contentType$iv.invoke($pantryNeedsBuy.get(index));
                    }
                }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$ShoppingListScreen$2$invoke$lambda$15$lambda$14$$inlined$items$default$4
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
                        final PantryProductWithLocations pwl = (PantryProductWithLocations) $pantryNeedsBuy.get(it);
                        $composer.startReplaceGroup(1607896267);
                        ComposerKt.sourceInformation($composer, "C*144@6427L50,142@6327L176:ShoppingListScreen.kt#fjjmxg");
                        $composer.startReplaceGroup(-1472149958);
                        ComposerKt.sourceInformation($composer, "CC(remember):ShoppingListScreen.kt#9igjgp");
                        boolean invalid$iv = (((($changed2 & 112) ^ 48) > 32 && $composer.changedInstance(pwl)) || ($changed2 & 48) == 32) | $composer.changedInstance($pantryViewModel);
                        Object it$iv = $composer.rememberedValue();
                        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                            final PantryViewModel pantryViewModel = $pantryViewModel;
                            value$iv = (Function0) new Function0<Unit>() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$ShoppingListScreen$2$2$1$2$1$1
                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    PantryViewModel pantryViewModel2 = pantryViewModel;
                                    if (pantryViewModel2 != null) {
                                        pantryViewModel2.toggleNeedsToBuy(pwl.getProduct());
                                    }
                                }
                            };
                            $composer.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        $composer.endReplaceGroup();
                        ShoppingListScreenKt.PantryNeedsBuyCard(pwl, (Function0) value$iv, $composer, PantryProductWithLocations.$stable | (($changed2 >> 3) & 14));
                        $composer.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
                if (!$items.isEmpty()) {
                    LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$ShoppingListScreenKt.INSTANCE.m7241getLambda3$app_debug(), 3, null);
                }
            }
            if (!$recipeShoppingItems.isEmpty()) {
                LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$ShoppingListScreenKt.INSTANCE.m7242getLambda4$app_debug(), 3, null);
                final Function1 key$iv2 = new Function1() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$ShoppingListScreen$2$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ShoppingListScreenKt.AnonymousClass2.invoke$lambda$15$lambda$14$lambda$5((RecipeShoppingItem) obj);
                    }
                };
                final Function1 contentType$iv2 = new Function1() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$ShoppingListScreen$2$invoke$lambda$15$lambda$14$$inlined$items$default$5
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                        return invoke((RecipeShoppingItem) p1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Void invoke(RecipeShoppingItem recipeShoppingItem) {
                        return null;
                    }
                };
                LazyColumn.items($recipeShoppingItems.size(), new Function1<Integer, Object>() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$ShoppingListScreen$2$invoke$lambda$15$lambda$14$$inlined$items$default$6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Object invoke(int index) {
                        return key$iv2.invoke($recipeShoppingItems.get(index));
                    }
                }, new Function1<Integer, Object>() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$ShoppingListScreen$2$invoke$lambda$15$lambda$14$$inlined$items$default$7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Object invoke(int index) {
                        return contentType$iv2.invoke($recipeShoppingItems.get(index));
                    }
                }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$ShoppingListScreen$2$invoke$lambda$15$lambda$14$$inlined$items$default$8
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
                        final RecipeShoppingItem rsi = (RecipeShoppingItem) $recipeShoppingItems.get(it);
                        $composer.startReplaceGroup(1608544229);
                        ComposerKt.sourceInformation($composer, "C*160@7083L53,158@6980L182:ShoppingListScreen.kt#fjjmxg");
                        $composer.startReplaceGroup(-1472128963);
                        ComposerKt.sourceInformation($composer, "CC(remember):ShoppingListScreen.kt#9igjgp");
                        boolean invalid$iv = (((($changed2 & 112) ^ 48) > 32 && $composer.changed(rsi)) || ($changed2 & 48) == 32) | $composer.changedInstance($recipeViewModel);
                        Object it$iv = $composer.rememberedValue();
                        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                            final RecipeViewModel recipeViewModel = $recipeViewModel;
                            value$iv = (Function0) new Function0<Unit>() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$ShoppingListScreen$2$2$1$4$1$1
                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    RecipeViewModel recipeViewModel2 = recipeViewModel;
                                    if (recipeViewModel2 != null) {
                                        recipeViewModel2.removeRecipeShoppingItem(rsi.getId());
                                    }
                                }
                            };
                            $composer.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        $composer.endReplaceGroup();
                        ShoppingListScreenKt.RecipeShoppingItemCard(rsi, (Function0) value$iv, $composer, ($changed2 >> 3) & 14);
                        $composer.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
                if (!$items.isEmpty()) {
                    LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$ShoppingListScreenKt.INSTANCE.m7243getLambda5$app_debug(), 3, null);
                }
            }
            if (!$items.isEmpty()) {
                LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$ShoppingListScreenKt.INSTANCE.m7244getLambda6$app_debug(), 3, null);
                final Function1 key$iv3 = new Function1() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$ShoppingListScreen$2$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ShoppingListScreenKt.AnonymousClass2.invoke$lambda$15$lambda$14$lambda$8((ShoppingListItem) obj);
                    }
                };
                final Function1 contentType$iv3 = new Function1() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$ShoppingListScreen$2$invoke$lambda$15$lambda$14$$inlined$items$default$9
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                        return invoke((ShoppingListItem) p1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Void invoke(ShoppingListItem shoppingListItem) {
                        return null;
                    }
                };
                LazyColumn.items($items.size(), new Function1<Integer, Object>() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$ShoppingListScreen$2$invoke$lambda$15$lambda$14$$inlined$items$default$10
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Object invoke(int index) {
                        return key$iv3.invoke($items.get(index));
                    }
                }, new Function1<Integer, Object>() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$ShoppingListScreen$2$invoke$lambda$15$lambda$14$$inlined$items$default$11
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Object invoke(int index) {
                        return contentType$iv3.invoke($items.get(index));
                    }
                }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$ShoppingListScreen$2$invoke$lambda$15$lambda$14$$inlined$items$default$12
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
                        Object value$iv2;
                        Object value$iv3;
                        Object value$iv4;
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
                        final ShoppingListItem item = (ShoppingListItem) $items.get(it);
                        $composer.startReplaceGroup(1609214914);
                        ComposerKt.sourceInformation($composer, "C*176@7742L64,177@7849L234,181@8124L53,182@8217L32,174@7642L633:ShoppingListScreen.kt#fjjmxg");
                        $composer.startReplaceGroup(-1472107864);
                        ComposerKt.sourceInformation($composer, "CC(remember):ShoppingListScreen.kt#9igjgp");
                        boolean invalid$iv = $composer.changedInstance($viewModel) | (((($changed2 & 112) ^ 48) > 32 && $composer.changed(item)) || ($changed2 & 48) == 32);
                        Object it$iv = $composer.rememberedValue();
                        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                            final ProductListViewModel productListViewModel = $viewModel;
                            value$iv = new Function0<Unit>() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$ShoppingListScreen$2$2$1$6$1$1
                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    productListViewModel.updateQuantity(item.getProduct().getId(), item.getQuantity() + 1);
                                }
                            };
                            $composer.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        Function0 function0 = (Function0) value$iv;
                        $composer.endReplaceGroup();
                        $composer.startReplaceGroup(-1472104270);
                        ComposerKt.sourceInformation($composer, "CC(remember):ShoppingListScreen.kt#9igjgp");
                        boolean invalid$iv2 = (((($changed2 & 112) ^ 48) > 32 && $composer.changed(item)) || ($changed2 & 48) == 32) | $composer.changedInstance($viewModel);
                        Object it$iv2 = $composer.rememberedValue();
                        if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                            final ProductListViewModel productListViewModel2 = $viewModel;
                            value$iv2 = (Function0) new Function0<Unit>() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$ShoppingListScreen$2$2$1$6$2$1
                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    if (item.getQuantity() <= 1) {
                                        productListViewModel2.removeFromShoppingList(item.getProduct().getId());
                                    } else {
                                        productListViewModel2.updateQuantity(item.getProduct().getId(), item.getQuantity() - 1);
                                    }
                                }
                            };
                            $composer.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv2;
                        }
                        Function0 function1 = (Function0) value$iv2;
                        $composer.endReplaceGroup();
                        $composer.startReplaceGroup(-1472095651);
                        ComposerKt.sourceInformation($composer, "CC(remember):ShoppingListScreen.kt#9igjgp");
                        boolean invalid$iv3 = $composer.changedInstance($viewModel) | (((($changed2 & 112) ^ 48) > 32 && $composer.changed(item)) || ($changed2 & 48) == 32);
                        Object it$iv3 = $composer.rememberedValue();
                        if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                            final ProductListViewModel productListViewModel3 = $viewModel;
                            value$iv3 = (Function0) new Function0<Unit>() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$ShoppingListScreen$2$2$1$6$3$1
                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    productListViewModel3.removeFromShoppingList(item.getProduct().getId());
                                }
                            };
                            $composer.updateRememberedValue(value$iv3);
                        } else {
                            value$iv3 = it$iv3;
                        }
                        Function0 function2 = (Function0) value$iv3;
                        $composer.endReplaceGroup();
                        $composer.startReplaceGroup(-1472092696);
                        ComposerKt.sourceInformation($composer, "CC(remember):ShoppingListScreen.kt#9igjgp");
                        boolean invalid$iv4 = $composer.changed($onProductClick) | (((($changed2 & 112) ^ 48) > 32 && $composer.changed(item)) || ($changed2 & 48) == 32);
                        Object it$iv4 = $composer.rememberedValue();
                        if (invalid$iv4 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                            final Function1 function3 = $onProductClick;
                            value$iv4 = new Function0<Unit>() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$ShoppingListScreen$2$2$1$6$4$1
                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    function3.invoke(item.getProduct());
                                }
                            };
                            $composer.updateRememberedValue(value$iv4);
                        } else {
                            value$iv4 = it$iv4;
                        }
                        $composer.endReplaceGroup();
                        ShoppingListScreenKt.ShoppingItemCard(item, function0, function1, function2, (Function0) value$iv4, $composer, ($changed2 >> 3) & 14);
                        $composer.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
                LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-2013264849, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$ShoppingListScreen$2$2$1$7
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                        invoke(lazyItemScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
                        Intrinsics.checkNotNullParameter(item, "$this$item");
                        ComposerKt.sourceInformation($composer, "C186@8349L29,187@8403L25:ShoppingListScreen.kt#fjjmxg");
                        if (($changed & 17) != 16 || !$composer.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2013264849, $changed, -1, "com.easycompra.app.ui.shopping.ShoppingListScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ShoppingListScreen.kt:186)");
                            }
                            SpacerKt.Spacer(SizeKt.m712height3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(8)), $composer, 6);
                            ShoppingListScreenKt.ShoppingTotalsCard($items, $composer, 0);
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
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object invoke$lambda$15$lambda$14$lambda$2(PantryProductWithLocations it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return "pantry_" + it.getProduct().getId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object invoke$lambda$15$lambda$14$lambda$5(RecipeShoppingItem it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return "recipe_" + it.getId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object invoke$lambda$15$lambda$14$lambda$8(ShoppingListItem it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return "shop_" + it.getProduct().getId();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SectionHeader(final String title, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-880598025);
        ComposerKt.sourceInformation($composer3, "C(SectionHeader)199@8631L10,201@8722L11,197@8561L259:ShoppingListScreen.kt#fjjmxg");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(title) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 3) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-880598025, $dirty2, -1, "com.easycompra.app.ui.shopping.SectionHeader (ShoppingListScreen.kt:196)");
            }
            String upperCase = title.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            $composer2 = $composer3;
            TextKt.m2714Text4IGK_g(upperCase, PaddingKt.m682paddingVpY3zN4(Modifier.INSTANCE, Dp.m6663constructorimpl(4), Dp.m6663constructorimpl(4)), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary(), 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelLarge(), $composer2, 196656, 0, 65496);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ShoppingListScreenKt.SectionHeader$lambda$2(title, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PantryNeedsBuyCard(final PantryProductWithLocations item, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Object value$iv;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-802290922);
        ComposerKt.sourceInformation($composer3, "C(PantryNeedsBuyCard)211@8992L195,221@9371L11,220@9316L114,223@9465L19,224@9491L857,217@9193L1155:ShoppingListScreen.kt#fjjmxg");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer3.changed(item) : $composer3.changedInstance(item) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 19) != 18 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-802290922, $dirty2, -1, "com.easycompra.app.ui.shopping.PantryNeedsBuyCard (ShoppingListScreen.kt:210)");
            }
            List<PantryLocationEntity> locations = item.getLocations();
            $composer3.startReplaceGroup(872274804);
            ComposerKt.sourceInformation($composer3, "CC(remember):ShoppingListScreen.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function1() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ShoppingListScreenKt.PantryNeedsBuyCard$lambda$4$lambda$3((PantryLocationEntity) obj);
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer3.endReplaceGroup();
            String locSummary = CollectionsKt.joinToString$default(locations, str, null, null, 0, null, (Function1) value$iv, 30, null);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            RoundedCornerShape roundedCornerShapeM964RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m964RoundedCornerShape0680j_4(Dp.m6663constructorimpl(10));
            CardDefaults cardDefaults = CardDefaults.INSTANCE;
            long jM1936getSecondaryContainer0d7_KjU = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getSecondaryContainer();
            CardColors cardColorsM1850cardColorsro_MJ88 = cardDefaults.m1850cardColorsro_MJ88(Color.m4179copywmQWz5c(jM1936getSecondaryContainer0d7_KjU, (14 & 1) != 0 ? Color.m4183getAlphaimpl(jM1936getSecondaryContainer0d7_KjU) : 0.5f, (14 & 2) != 0 ? Color.m4187getRedimpl(jM1936getSecondaryContainer0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m4186getGreenimpl(jM1936getSecondaryContainer0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m4184getBlueimpl(jM1936getSecondaryContainer0d7_KjU) : 0.0f), 0L, 0L, 0L, $composer3, CardDefaults.$stable << 12, 14);
            CardDefaults cardDefaults2 = CardDefaults.INSTANCE;
            float fM6663constructorimpl = Dp.m6663constructorimpl(1);
            int $i$f$getDp = CardDefaults.$stable;
            $composer2 = $composer3;
            CardKt.Card(modifierFillMaxWidth$default, roundedCornerShapeM964RoundedCornerShape0680j_4, cardColorsM1850cardColorsro_MJ88, cardDefaults2.m1851cardElevationaqJV_2Y(fM6663constructorimpl, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer3, ($i$f$getDp << 18) | 6, 62), null, ComposableLambdaKt.rememberComposableLambda(1263226596, true, new AnonymousClass1(function0, item, locSummary), $composer2, 54), $composer2, 196614, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ShoppingListScreenKt.PantryNeedsBuyCard$lambda$5(item, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence PantryNeedsBuyCard$lambda$4$lambda$3(PantryLocationEntity it) {
        String qty;
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getQuantity() == ((float) ((long) it.getQuantity()))) {
            qty = String.valueOf((long) it.getQuantity());
        } else {
            qty = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(it.getQuantity())}, 1));
            Intrinsics.checkNotNullExpressionValue(qty, "format(...)");
        }
        return qty + " " + it.getUnit() + " (" + it.getCategory() + ")";
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.shopping.ShoppingListScreenKt$PantryNeedsBuyCard$1, reason: invalid class name */
    /* JADX INFO: compiled from: ShoppingListScreen.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass1 implements Function3<ColumnScope, Composer, Integer, Unit> {
        final /* synthetic */ PantryProductWithLocations $item;
        final /* synthetic */ String $locSummary;
        final /* synthetic */ Function0<Unit> $onUncheck;

        AnonymousClass1(Function0<Unit> function0, PantryProductWithLocations pantryProductWithLocations, String str) {
            this.$onUncheck = function0;
            this.$item = pantryProductWithLocations;
            this.$locSummary = str;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
            invoke(columnScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(ColumnScope Card, Composer $composer, int $changed) {
            Function0<ComposeUiNode> function0;
            Composer $composer2;
            Object value$iv;
            Intrinsics.checkNotNullParameter(Card, "$this$Card");
            ComposerKt.sourceInformation($composer, "C225@9501L841:ShoppingListScreen.kt#fjjmxg");
            if (($changed & 17) != 16 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1263226596, $changed, -1, "com.easycompra.app.ui.shopping.PantryNeedsBuyCard.<anonymous> (ShoppingListScreen.kt:225)");
                }
                Modifier modifierM681padding3ABfNKs = PaddingKt.m681padding3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(12));
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                Arrangement.HorizontalOrVertical horizontalOrVerticalM561spacedBy0680j_4 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(10));
                final Function0<Unit> function1 = this.$onUncheck;
                PantryProductWithLocations pantryProductWithLocations = this.$item;
                String str = this.$locSummary;
                ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalOrVerticalM561spacedBy0680j_4, centerVertically, $composer, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                int $changed$iv$iv = (438 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifierM681padding3ABfNKs);
                Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
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
                int i = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                int i2 = ((438 >> 6) & 112) | 6;
                RowScope $this$invoke_u24lambda_u243 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, 1516248126, "C233@9831L11,230@9702L213,236@9928L286,244@10303L15,242@10227L105:ShoppingListScreen.kt#fjjmxg");
                IconKt.m2171Iconww6aTOc(CheckCircleKt.getCheckCircle(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(20)), MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSecondary(), $composer, 432, 0);
                Modifier modifier$iv = RowScope.weight$default($this$invoke_u24lambda_u243, Modifier.INSTANCE, 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv2 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    function0 = constructor2;
                    $composer.createNode(function0);
                } else {
                    function0 = constructor2;
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
                ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                int i4 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 711765758, "C237@9985L75:ShoppingListScreen.kt#fjjmxg");
                TextKt.m2714Text4IGK_g(pantryProductWithLocations.getProduct().getName(), (Modifier) null, 0L, TextUnitKt.getSp(14), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 199680, 0, 131030);
                $composer.startReplaceGroup(-669773623);
                ComposerKt.sourceInformation($composer, "239@10128L54");
                if (!(!StringsKt.isBlank(str))) {
                    $composer2 = $composer;
                } else {
                    $composer2 = $composer;
                    TextKt.m2714Text4IGK_g(str, (Modifier) null, Color.INSTANCE.m4211getGray0d7_KjU(), TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 3456, 0, 131058);
                }
                $composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer);
                r11.endNode();
                ComposerKt.sourceInformationMarkerEnd(r11);
                ComposerKt.sourceInformationMarkerEnd(r11);
                ComposerKt.sourceInformationMarkerEnd(r11);
                r11.startReplaceGroup(-782354146);
                ComposerKt.sourceInformation(r11, "CC(remember):ShoppingListScreen.kt#9igjgp");
                boolean invalid$iv = r11.changed(function1);
                Object it$iv = r11.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function1() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$PantryNeedsBuyCard$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ShoppingListScreenKt.AnonymousClass1.invoke$lambda$3$lambda$2$lambda$1(function1, ((Boolean) obj).booleanValue());
                        }
                    };
                    r11.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                r11.endReplaceGroup();
                CheckboxKt.Checkbox(true, (Function1) value$iv, null, false, null, null, r11, 6, 60);
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
        public static final Unit invoke$lambda$3$lambda$2$lambda$1(Function0 $onUncheck, boolean it) {
            $onUncheck.invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RecipeShoppingItemCard(final RecipeShoppingItem item, final Function0<Unit> function0, Composer $composer, final int $changed) {
        final String qty;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(1947128886);
        ComposerKt.sourceInformation($composer3, "C(RecipeShoppingItemCard)261@10732L68,264@10835L19,265@10861L765,258@10609L1017:ShoppingListScreen.kt#fjjmxg");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(item) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 19) != 18 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1947128886, $dirty2, -1, "com.easycompra.app.ui.shopping.RecipeShoppingItemCard (ShoppingListScreen.kt:254)");
            }
            if (item.getQuantity() == ((float) ((long) item.getQuantity()))) {
                qty = String.valueOf((long) item.getQuantity());
            } else {
                qty = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(item.getQuantity())}, 1));
                Intrinsics.checkNotNullExpressionValue(qty, "format(...)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            RoundedCornerShape roundedCornerShapeM964RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m964RoundedCornerShape0680j_4(Dp.m6663constructorimpl(10));
            CardColors cardColorsM1850cardColorsro_MJ88 = CardDefaults.INSTANCE.m1850cardColorsro_MJ88(ColorKt.Color(4294965229L), 0L, 0L, 0L, $composer3, (CardDefaults.$stable << 12) | 6, 14);
            CardDefaults cardDefaults = CardDefaults.INSTANCE;
            float fM6663constructorimpl = Dp.m6663constructorimpl(1);
            int $i$f$getDp = CardDefaults.$stable;
            $composer2 = $composer3;
            CardKt.Card(modifierFillMaxWidth$default, roundedCornerShapeM964RoundedCornerShape0680j_4, cardColorsM1850cardColorsro_MJ88, cardDefaults.m1851cardElevationaqJV_2Y(fM6663constructorimpl, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer3, ($i$f$getDp << 18) | 6, 62), null, ComposableLambdaKt.rememberComposableLambda(-95013116, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt.RecipeShoppingItemCard.1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                    invoke(columnScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope Card, Composer $composer4, int $changed2) {
                    Function0<ComposeUiNode> function1;
                    Intrinsics.checkNotNullParameter(Card, "$this$Card");
                    ComposerKt.sourceInformation($composer4, "C266@10871L749:ShoppingListScreen.kt#fjjmxg");
                    if (($changed2 & 17) != 16 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-95013116, $changed2, -1, "com.easycompra.app.ui.shopping.RecipeShoppingItemCard.<anonymous> (ShoppingListScreen.kt:266)");
                        }
                        Modifier modifierM681padding3ABfNKs = PaddingKt.m681padding3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(12));
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM561spacedBy0680j_4 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(10));
                        Function0<Unit> function2 = function0;
                        RecipeShoppingItem recipeShoppingItem = item;
                        String str = qty;
                        ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalOrVerticalM561spacedBy0680j_4, centerVertically, $composer4, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                        int $changed$iv$iv = (438 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifierM681padding3ABfNKs);
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
                        int i2 = ((438 >> 6) & 112) | 6;
                        RowScope $this$invoke_u24lambda_u241 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1819085336, "C271@11072L28,272@11113L299,279@11425L185:ShoppingListScreen.kt#fjjmxg");
                        TextKt.m2714Text4IGK_g("🍳", (Modifier) null, 0L, TextUnitKt.getSp(20), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 3078, 0, 131062);
                        Modifier modifier$iv = RowScope.weight$default($this$invoke_u24lambda_u241, Modifier.INSTANCE, 1.0f, false, 2, null);
                        ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv2 = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            function1 = constructor2;
                            $composer4.createNode(function1);
                        } else {
                            function1 = constructor2;
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
                        int i4 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -2118619217, "C273@11170L67,274@11254L144:ShoppingListScreen.kt#fjjmxg");
                        TextKt.m2714Text4IGK_g(recipeShoppingItem.getName(), (Modifier) null, 0L, TextUnitKt.getSp(14), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 199680, 0, 131030);
                        TextKt.m2714Text4IGK_g(str + " " + recipeShoppingItem.getUnit() + "  ·  " + recipeShoppingItem.getFromRecipe(), (Modifier) null, Color.INSTANCE.m4211getGray0d7_KjU(), TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 3456, 0, 131058);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        IconButtonKt.IconButton(function2, SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(32)), false, null, null, ComposableSingletons$ShoppingListScreenKt.INSTANCE.m7245getLambda7$app_debug(), $composer4, 196656, 28);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, 196614, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ShoppingListScreenKt.RecipeShoppingItemCard$lambda$6(item, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ShoppingItemCard(final ShoppingListItem item, final Function0<Unit> function0, final Function0<Unit> function1, final Function0<Unit> function2, final Function0<Unit> function3, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1535040020);
        ComposerKt.sourceInformation($composer2, "C(ShoppingItemCard)P(!1,3,2,4)298@11980L19,299@12031L40,301@12105L2058,295@11854L2309:ShoppingListScreen.kt#fjjmxg");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(item) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 256 : 128;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 8339) != 8338 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1535040020, $dirty2, -1, "com.easycompra.app.ui.shopping.ShoppingItemCard (ShoppingListScreen.kt:294)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            RoundedCornerShape roundedCornerShapeM964RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m964RoundedCornerShape0680j_4(Dp.m6663constructorimpl(12));
            CardDefaults cardDefaults = CardDefaults.INSTANCE;
            float fM6663constructorimpl = Dp.m6663constructorimpl(2);
            int $this$dp$iv = CardDefaults.$stable;
            CardKt.Card(function3, modifierFillMaxWidth$default, false, roundedCornerShapeM964RoundedCornerShape0680j_4, CardDefaults.INSTANCE.m1850cardColorsro_MJ88(Color.INSTANCE.m4218getWhite0d7_KjU(), 0L, 0L, 0L, $composer2, (CardDefaults.$stable << 12) | 6, 14), cardDefaults.m1851cardElevationaqJV_2Y(fM6663constructorimpl, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer2, ($this$dp$iv << 18) | 6, 62), null, null, ComposableLambdaKt.rememberComposableLambda(1791906943, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt.ShoppingItemCard.1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                    invoke(columnScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope Card, Composer $composer3, int $changed2) {
                    Function0<ComposeUiNode> function4;
                    String str;
                    Intrinsics.checkNotNullParameter(Card, "$this$Card");
                    ComposerKt.sourceInformation($composer3, "C302@12115L2042:ShoppingListScreen.kt#fjjmxg");
                    if (($changed2 & 17) != 16 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1791906943, $changed2, -1, "com.easycompra.app.ui.shopping.ShoppingItemCard.<anonymous> (ShoppingListScreen.kt:302)");
                        }
                        Modifier modifierM681padding3ABfNKs = PaddingKt.m681padding3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(10));
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM561spacedBy0680j_4 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(10));
                        ShoppingListItem shoppingListItem = item;
                        Function0<Unit> function5 = function1;
                        Function0<Unit> function6 = function0;
                        ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalOrVerticalM561spacedBy0680j_4, centerVertically, $composer3, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                        int $changed$iv$iv = (438 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifierM681padding3ABfNKs);
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
                        ComposerKt.sourceInformationMarkerStart($composer3, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                        int i2 = ((438 >> 6) & 112) | 6;
                        RowScope $this$invoke_u24lambda_u243 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1750007271, "C307@12316L225,313@12554L816,331@13383L764:ShoppingListScreen.kt#fjjmxg");
                        SingletonAsyncImageKt.m7012AsyncImagegl8XCv8(shoppingListItem.getProduct().getPhotoUrl(), shoppingListItem.getProduct().getName(), SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(60)), null, null, null, ContentScale.INSTANCE.getFit(), 0.0f, null, 0, false, null, $composer3, 1573248, 0, 4024);
                        Modifier modifier$iv = RowScope.weight$default($this$invoke_u24lambda_u243, Modifier.INSTANCE, 1.0f, false, 2, null);
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(4));
                        ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                        int $changed$iv$iv2 = (48 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            function4 = constructor2;
                            $composer3.createNode(function4);
                        } else {
                            function4 = constructor2;
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
                        ComposerKt.sourceInformationMarkerStart($composer3, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i4 = ((48 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1204368438, "C314@12661L42,315@12720L187:ShoppingListScreen.kt#fjjmxg");
                        NutriScoreBadgeKt.SupermarketBadge(shoppingListItem.getProduct().getSupermarket(), null, $composer3, 0, 2);
                        TextKt.m2714Text4IGK_g(shoppingListItem.getProduct().getName(), (Modifier) null, 0L, TextUnitKt.getSp(13), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 199680, 3072, 122838);
                        Double unitPrice = shoppingListItem.getProduct().getUnitPrice();
                        $composer3.startReplaceGroup(-177389030);
                        ComposerKt.sourceInformation($composer3, "*325@13201L11,323@13029L309");
                        if (unitPrice != null) {
                            double it = unitPrice.doubleValue();
                            double lineTotal = ((double) shoppingListItem.getQuantity()) * it;
                            String str2 = String.format("%.2f € c/u", Arrays.copyOf(new Object[]{Double.valueOf(it)}, 1));
                            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                            if (shoppingListItem.getQuantity() > 1) {
                                str = String.format("  ·  total %.2f €", Arrays.copyOf(new Object[]{Double.valueOf(lineTotal)}, 1));
                                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                            } else {
                                str = "";
                            }
                            TextKt.m2714Text4IGK_g(str2 + str, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary(), TextUnitKt.getSp(12), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 199680, 0, 131026);
                            Unit unit = Unit.INSTANCE;
                            Unit unit2 = Unit.INSTANCE;
                        }
                        $composer3.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                        Modifier modifier$iv2 = Modifier.INSTANCE;
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                        int $changed$iv$iv3 = (384 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            $composer3.createNode(constructor3);
                        } else {
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3674constructorimpl($composer3);
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                            $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                            $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
                        }
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                        int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        int i6 = ((384 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1203583239, "C332@13453L190,340@13890L11,335@13660L269,342@13946L187:ShoppingListScreen.kt#fjjmxg");
                        IconButtonKt.FilledTonalIconButton(function5, SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(32)), false, null, null, null, ComposableSingletons$ShoppingListScreenKt.INSTANCE.m7246getLambda8$app_debug(), $composer3, 1572912, 60);
                        TextKt.m2714Text4IGK_g(String.valueOf(shoppingListItem.getQuantity()), SizeKt.m731width3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(28)), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getOnSurface(), TextUnitKt.getSp(15), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 199728, 0, 131024);
                        IconButtonKt.FilledTonalIconButton(function6, SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(32)), false, null, null, null, ComposableSingletons$ShoppingListScreenKt.INSTANCE.m7247getLambda9$app_debug(), $composer3, 1572912, 60);
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
            }, $composer2, 54), $composer2, (($dirty2 >> 12) & 14) | 100663344, 196);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ShoppingListScreenKt.ShoppingItemCard$lambda$7(item, function0, function1, function2, function3, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ShoppingTotalsCard(final List<ShoppingListItem> list, Composer $composer, final int $changed) {
        Object answer$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(1544659067);
        ComposerKt.sourceInformation($composer2, "C(ShoppingTotalsCard)363@14759L11,363@14717L71,364@14795L1659,360@14594L1860:ShoppingListScreen.kt#fjjmxg");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 3) != 2 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1544659067, $dirty2, -1, "com.easycompra.app.ui.shopping.ShoppingTotalsCard (ShoppingListScreen.kt:351)");
            }
            List<ShoppingListItem> $this$groupBy$iv = list;
            Map destination$iv$iv = new LinkedHashMap();
            for (Object element$iv$iv : $this$groupBy$iv) {
                ShoppingListItem it = (ShoppingListItem) element$iv$iv;
                String supermarket = it.getProduct().getSupermarket();
                Object value$iv$iv$iv = destination$iv$iv.get(supermarket);
                if (value$iv$iv$iv == null) {
                    answer$iv$iv$iv = new ArrayList();
                    destination$iv$iv.put(supermarket, answer$iv$iv$iv);
                } else {
                    answer$iv$iv$iv = value$iv$iv$iv;
                }
                List list$iv$iv = (List) answer$iv$iv$iv;
                list$iv$iv.add(element$iv$iv);
            }
            Map destination$iv$iv2 = new LinkedHashMap(MapsKt.mapCapacity(destination$iv$iv.size()));
            Iterable $this$associateByTo$iv$iv$iv = destination$iv$iv.entrySet();
            for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
                Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv;
                Object key = it$iv$iv.getKey();
                List<ShoppingListItem> v = (List) ((Map.Entry) element$iv$iv$iv).getValue();
                double dDoubleValue = 0.0d;
                for (ShoppingListItem it2 : v) {
                    Double unitPrice = it2.getProduct().getUnitPrice();
                    dDoubleValue += (unitPrice != null ? unitPrice.doubleValue() : 0.0d) * ((double) it2.getQuantity());
                }
                destination$iv$iv2.put(key, Double.valueOf(dDoubleValue));
            }
            Iterable $this$sortedByDescending$iv = destination$iv$iv2.entrySet();
            final List<Map.Entry> totals = CollectionsKt.sortedWith($this$sortedByDescending$iv, new Comparator() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$ShoppingTotalsCard$$inlined$sortedByDescending$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Map.Entry it3 = (Map.Entry) t2;
                    Double d = (Double) it3.getValue();
                    Map.Entry it4 = (Map.Entry) t;
                    return ComparisonsKt.compareValues(d, (Double) it4.getValue());
                }
            });
            double dDoubleValue2 = 0.0d;
            for (Map.Entry it3 : totals) {
                dDoubleValue2 += ((Number) it3.getValue()).doubleValue();
            }
            final double grandTotal = dDoubleValue2;
            List<ShoppingListItem> $this$any$iv = list;
            boolean z = false;
            if (!($this$any$iv instanceof Collection) || !$this$any$iv.isEmpty()) {
                for (Object element$iv : $this$any$iv) {
                    ShoppingListItem it4 = (ShoppingListItem) element$iv;
                    if (it4.getProduct().getUnitPrice() != null) {
                        z = true;
                        break;
                    }
                }
            }
            boolean hasAnyPrice = z;
            if (!hasAnyPrice) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ShoppingListScreenKt.ShoppingTotalsCard$lambda$14(list, $changed, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            CardKt.Card(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m964RoundedCornerShape0680j_4(Dp.m6663constructorimpl(12)), CardDefaults.INSTANCE.m1850cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getPrimaryContainer(), 0L, 0L, 0L, $composer2, CardDefaults.$stable << 12, 14), null, null, ComposableLambdaKt.rememberComposableLambda(1281467465, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt.ShoppingTotalsCard.2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                    invoke(columnScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope Card, Composer $composer3, int $changed2) {
                    Function0<ComposeUiNode> function0;
                    Function0<ComposeUiNode> function1;
                    Function0<ComposeUiNode> function2;
                    Intrinsics.checkNotNullParameter(Card, "$this$Card");
                    ComposerKt.sourceInformation($composer3, "C365@14805L1643:ShoppingListScreen.kt#fjjmxg");
                    if (($changed2 & 17) == 16 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1281467465, $changed2, -1, "com.easycompra.app.ui.shopping.ShoppingTotalsCard.<anonymous> (ShoppingListScreen.kt:365)");
                    }
                    Modifier modifier$iv = PaddingKt.m681padding3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(16));
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(8));
                    List<Map.Entry<String, Double>> list2 = totals;
                    double d = grandTotal;
                    int $changed$iv = 54;
                    ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                    int $changed$iv$iv = (54 << 3) & 112;
                    int $i$f$Layout = 0;
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
                        function0 = constructor;
                        $composer3.createNode(function0);
                    } else {
                        function0 = constructor;
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
                    Composer $composer$iv = $composer3;
                    int i2 = 0;
                    ComposerKt.sourceInformationMarkerStart($composer$iv, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    int $changed3 = ((54 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv, 2129046286, "C369@15048L10,370@15109L11,366@14912L241,392@16375L11,389@16229L209:ShoppingListScreen.kt#fjjmxg");
                    TextKt.m2714Text4IGK_g("Resumen de costes estimado", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer$iv, MaterialTheme.$stable).getOnPrimaryContainer(), 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer$iv, MaterialTheme.$stable).getTitleSmall(), $composer$iv, 196614, 0, 65498);
                    $composer$iv.startReplaceGroup(761422895);
                    ComposerKt.sourceInformation($composer$iv, "*373@15223L432");
                    List<Map.Entry<String, Double>> $this$forEach$iv = list2;
                    int $i$f$forEach = 0;
                    Iterator it5 = $this$forEach$iv.iterator();
                    while (true) {
                        Iterable $this$forEach$iv2 = $this$forEach$iv;
                        int $i$f$forEach2 = $i$f$forEach;
                        int $changed$iv2 = $changed$iv;
                        int i3 = i2;
                        int $changed4 = $changed3;
                        if (!it5.hasNext()) {
                            break;
                        }
                        Object element$iv2 = it5.next();
                        Map.Entry entry = (Map.Entry) element$iv2;
                        String supermarket2 = (String) entry.getKey();
                        double total = ((Number) entry.getValue()).doubleValue();
                        MeasurePolicy measurePolicy$iv2 = measurePolicy$iv;
                        int $changed$iv$iv2 = $changed$iv$iv;
                        int $i$f$Layout2 = $i$f$Layout;
                        Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
                        ComposerKt.sourceInformationMarkerStart($composer$iv, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                        MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer$iv, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                        ComposerKt.sourceInformationMarkerStart($composer$iv, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer$iv, 0);
                        CompositionLocalMap localMap$iv$iv2 = $composer$iv.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer$iv, modifier$iv2);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv2 = ((((54 << 3) & 112) << 6) & 896) | 6;
                        CompositionLocalMap localMap$iv$iv3 = localMap$iv$iv;
                        ComposerKt.sourceInformationMarkerStart($composer$iv, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer$iv.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer$iv.startReusableNode();
                        if ($composer$iv.getInserting()) {
                            function2 = constructor2;
                            $composer$iv.createNode(function2);
                        } else {
                            function2 = constructor2;
                            $composer$iv.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3674constructorimpl($composer$iv);
                        Composer $composer$iv2 = $composer$iv;
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                        }
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                        int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer$iv, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        int i5 = ((54 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer$iv, 347422008, "C374@15375L11,374@15335L71,378@15585L11,375@15427L210:ShoppingListScreen.kt#fjjmxg");
                        TextKt.m2714Text4IGK_g(supermarket2, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer$iv, MaterialTheme.$stable).getOnPrimaryContainer(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer$iv, 0, 0, 131066);
                        String str = String.format("%.2f €", Arrays.copyOf(new Object[]{Double.valueOf(total)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        TextKt.m2714Text4IGK_g(str, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer$iv, MaterialTheme.$stable).getOnPrimaryContainer(), 0L, (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer$iv, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 131034);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        $composer$iv.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        $this$forEach$iv = $this$forEach$iv2;
                        $i$f$forEach = $i$f$forEach2;
                        $changed$iv = $changed$iv2;
                        i2 = i3;
                        $changed3 = $changed4;
                        measurePolicy$iv = measurePolicy$iv2;
                        $changed$iv$iv = $changed$iv$iv2;
                        $i$f$Layout = $i$f$Layout2;
                        localMap$iv$iv = localMap$iv$iv3;
                        $composer$iv = $composer$iv2;
                    }
                    Composer $composer$iv3 = $composer$iv;
                    $composer$iv.endReplaceGroup();
                    $composer$iv.startReplaceGroup(761439221);
                    ComposerKt.sourceInformation($composer$iv, "383@15761L11,383@15721L90,384@15828L374");
                    if (list2.size() > 1) {
                        long jM1923getOnPrimaryContainer0d7_KjU = MaterialTheme.INSTANCE.getColorScheme($composer$iv, MaterialTheme.$stable).getOnPrimaryContainer();
                        DividerKt.m2093HorizontalDivider9IZ8Weo(null, 0.0f, Color.m4179copywmQWz5c(jM1923getOnPrimaryContainer0d7_KjU, (14 & 1) != 0 ? Color.m4183getAlphaimpl(jM1923getOnPrimaryContainer0d7_KjU) : 0.2f, (14 & 2) != 0 ? Color.m4187getRedimpl(jM1923getOnPrimaryContainer0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m4186getGreenimpl(jM1923getOnPrimaryContainer0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m4184getBlueimpl(jM1923getOnPrimaryContainer0d7_KjU) : 0.0f), $composer$iv, 0, 3);
                        Modifier modifier$iv3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getSpaceBetween();
                        ComposerKt.sourceInformationMarkerStart($composer$iv, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                        Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getTop();
                        MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer$iv, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                        ComposerKt.sourceInformationMarkerStart($composer$iv, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer$iv, 0);
                        CompositionLocalMap localMap$iv$iv4 = $composer$iv.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer$iv, modifier$iv3);
                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv3 = ((((54 << 3) & 112) << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer$iv, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer$iv.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer$iv.startReusableNode();
                        if ($composer$iv.getInserting()) {
                            function1 = constructor3;
                            $composer$iv.createNode(function1);
                        } else {
                            function1 = constructor3;
                            $composer$iv.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3674constructorimpl($composer$iv);
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                            $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                            $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
                        }
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                        int i6 = ($changed$iv$iv$iv3 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer$iv, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                        int i7 = ((54 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer$iv, 787628977, "C385@16015L11,385@15940L106,386@16153L11,386@16067L117:ShoppingListScreen.kt#fjjmxg");
                        TextKt.m2714Text4IGK_g("Total estimado", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer$iv, MaterialTheme.$stable).getOnPrimaryContainer(), 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer$iv, 196614, 0, 131034);
                        String str2 = String.format("%.2f €", Arrays.copyOf(new Object[]{Double.valueOf(d)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                        TextKt.m2714Text4IGK_g(str2, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer$iv, MaterialTheme.$stable).getOnPrimaryContainer(), 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer$iv, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 131034);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        $composer$iv.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                        ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    }
                    $composer$iv.endReplaceGroup();
                    long sp = TextUnitKt.getSp(10);
                    long jM1923getOnPrimaryContainer0d7_KjU2 = MaterialTheme.INSTANCE.getColorScheme($composer$iv, MaterialTheme.$stable).getOnPrimaryContainer();
                    TextKt.m2714Text4IGK_g("* Precios orientativos. Pueden variar en tienda.", (Modifier) null, Color.m4179copywmQWz5c(jM1923getOnPrimaryContainer0d7_KjU2, (14 & 1) != 0 ? Color.m4183getAlphaimpl(jM1923getOnPrimaryContainer0d7_KjU2) : 0.6f, (14 & 2) != 0 ? Color.m4187getRedimpl(jM1923getOnPrimaryContainer0d7_KjU2) : 0.0f, (14 & 4) != 0 ? Color.m4186getGreenimpl(jM1923getOnPrimaryContainer0d7_KjU2) : 0.0f, (14 & 8) != 0 ? Color.m4184getBlueimpl(jM1923getOnPrimaryContainer0d7_KjU2) : 0.0f), sp, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer$iv, 3078, 0, 131058);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), $composer2, 196614, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.easycompra.app.ui.shopping.ShoppingListScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ShoppingListScreenKt.ShoppingTotalsCard$lambda$15(list, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
