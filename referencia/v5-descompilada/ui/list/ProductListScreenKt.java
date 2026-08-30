package com.easycompra.app.ui.list;

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
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TabRowKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarColors;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.profileinstaller.ProfileVerifier;
import coil.compose.SingletonAsyncImageKt;
import com.easycompra.app.data.Product;
import com.easycompra.app.ui.components.NutriScoreBadgeKt;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProductListScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a\u001d\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u000b\u001a;\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u0014H\u0003¢\u0006\u0002\u0010\u0015¨\u0006\u0016²\u0006\n\u0010\t\u001a\u00020\nX\u008a\u0084\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0011X\u008a\u008e\u0002"}, d2 = {"ProductListScreen", "", "viewModel", "Lcom/easycompra/app/ui/list/ProductListViewModel;", "onProductClick", "Lkotlin/Function1;", "Lcom/easycompra/app/data/Product;", "(Lcom/easycompra/app/ui/list/ProductListViewModel;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "FilterRow", "state", "Lcom/easycompra/app/ui/list/ProductListUiState;", "(Lcom/easycompra/app/ui/list/ProductListUiState;Lcom/easycompra/app/ui/list/ProductListViewModel;Landroidx/compose/runtime/Composer;I)V", "ProductCard", "product", "sortField", "Lcom/easycompra/app/ui/list/SortField;", "isFavorite", "", "isInList", "onClick", "Lkotlin/Function0;", "(Lcom/easycompra/app/data/Product;Lcom/easycompra/app/ui/list/SortField;ZZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_debug", "searchActive"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ProductListScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilterRow$lambda$12(ProductListUiState productListUiState, ProductListViewModel productListViewModel, int i, Composer composer, int i2) {
        FilterRow(productListUiState, productListViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductCard$lambda$13(Product product, SortField sortField, boolean z, boolean z2, Function0 function0, int i, Composer composer, int i2) {
        ProductCard(product, sortField, z, z2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductListScreen$lambda$4(ProductListViewModel productListViewModel, Function1 function1, int i, Composer composer, int i2) {
        ProductListScreen(productListViewModel, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ProductListScreen(final ProductListViewModel viewModel, final Function1<? super Product, Unit> onProductClick, Composer $composer, final int $changed) {
        Object value$iv;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(onProductClick, "onProductClick");
        Composer $composer3 = $composer.startRestartGroup(-281077714);
        ComposerKt.sourceInformation($composer3, "C(ProductListScreen)P(1)69@3060L16,70@3101L34,73@3168L1813,108@4988L1774,72@3141L3621:ProductListScreen.kt#c0t1xm");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(viewModel) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(onProductClick) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 19) != 18 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-281077714, $dirty2, -1, "com.easycompra.app.ui.list.ProductListScreen (ProductListScreen.kt:68)");
            }
            final State state$delegate = SnapshotStateKt.collectAsState(viewModel.getUiState(), null, $composer3, 0, 1);
            $composer3.startReplaceGroup(-1382193801);
            ComposerKt.sourceInformation($composer3, "CC(remember):ProductListScreen.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState searchActive$delegate = (MutableState) value$iv;
            $composer3.endReplaceGroup();
            $composer2 = $composer3;
            ScaffoldKt.m2429ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(-1065987094, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.list.ProductListScreenKt.ProductListScreen.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C77@3401L11,76@3333L216,75@3217L71,81@3577L1380,74@3182L1789:ProductListScreen.kt#c0t1xm");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1065987094, $changed2, -1, "com.easycompra.app.ui.list.ProductListScreen.<anonymous> (ProductListScreen.kt:74)");
                        }
                        TopAppBarColors topAppBarColorsM2885topAppBarColorszjMxDiM = TopAppBarDefaults.INSTANCE.m2885topAppBarColorszjMxDiM(MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getPrimary(), 0L, 0L, Color.INSTANCE.m4218getWhite0d7_KjU(), Color.INSTANCE.m4218getWhite0d7_KjU(), $composer4, (TopAppBarDefaults.$stable << 15) | 27648, 6);
                        final MutableState<Boolean> mutableState = searchActive$delegate;
                        AppBarKt.m1794TopAppBarGHTll3U(ComposableLambdaKt.rememberComposableLambda(-279812690, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.list.ProductListScreenKt.ProductListScreen.1.1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer5, int $changed3) {
                                ComposerKt.sourceInformation($composer5, "C75@3238L48:ProductListScreen.kt#c0t1xm");
                                if (($changed3 & 3) == 2 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-279812690, $changed3, -1, "com.easycompra.app.ui.list.ProductListScreen.<anonymous>.<anonymous> (ProductListScreen.kt:75)");
                                }
                                if (!ProductListScreenKt.ProductListScreen$lambda$2(mutableState)) {
                                    TextKt.m2714Text4IGK_g("EasyCompra", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer5, 196614, 0, 131038);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54), null, null, ComposableLambdaKt.rememberComposableLambda(-1588962087, true, new AnonymousClass2(viewModel, state$delegate, searchActive$delegate), $composer4, 54), 0.0f, null, topAppBarColorsM2885topAppBarColorszjMxDiM, null, $composer4, 3078, 182);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }

                /* JADX INFO: renamed from: com.easycompra.app.ui.list.ProductListScreenKt$ProductListScreen$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: ProductListScreen.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                static final class AnonymousClass2 implements Function3<RowScope, Composer, Integer, Unit> {
                    final /* synthetic */ MutableState<Boolean> $searchActive$delegate;
                    final /* synthetic */ State<ProductListUiState> $state$delegate;
                    final /* synthetic */ ProductListViewModel $viewModel;

                    AnonymousClass2(ProductListViewModel productListViewModel, State<ProductListUiState> state, MutableState<Boolean> mutableState) {
                        this.$viewModel = productListViewModel;
                        this.$state$delegate = state;
                        this.$searchActive$delegate = mutableState;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                        invoke(rowScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope TopAppBar, Composer $composer, int $changed) {
                        Object value$iv;
                        Object value$iv2;
                        Object value$iv3;
                        Object value$iv4;
                        Object value$iv5;
                        Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
                        ComposerKt.sourceInformation($composer, "C:ProductListScreen.kt#c0t1xm");
                        if (($changed & 17) == 16 && $composer.getSkipping()) {
                            $composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1588962087, $changed, -1, "com.easycompra.app.ui.list.ProductListScreen.<anonymous>.<anonymous> (ProductListScreen.kt:82)");
                        }
                        if (ProductListScreenKt.ProductListScreen$lambda$2(this.$searchActive$delegate)) {
                            $composer.startReplaceGroup(2009425085);
                            ComposerKt.sourceInformation($composer, "90@4178L96,85@3755L26,83@3643L658,94@4347L48,94@4326L183");
                            String query = ProductListScreenKt.ProductListScreen$lambda$0(this.$state$delegate).getQuery();
                            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(Modifier.INSTANCE, 0.8f);
                            KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m6310getSearcheUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
                            $composer.startReplaceGroup(1173215955);
                            ComposerKt.sourceInformation($composer, "CC(remember):ProductListScreen.kt#9igjgp");
                            boolean invalid$iv = $composer.changedInstance(this.$viewModel) | $composer.changed(this.$state$delegate);
                            final ProductListViewModel productListViewModel = this.$viewModel;
                            final State<ProductListUiState> state = this.$state$delegate;
                            Object it$iv = $composer.rememberedValue();
                            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                                value$iv3 = new Function1() { // from class: com.easycompra.app.ui.list.ProductListScreenKt$ProductListScreen$1$2$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ProductListScreenKt.C07151.AnonymousClass2.invoke$lambda$1$lambda$0(productListViewModel, state, (KeyboardActionScope) obj);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv3);
                            } else {
                                value$iv3 = it$iv;
                            }
                            $composer.endReplaceGroup();
                            KeyboardActions keyboardActions = new KeyboardActions(null, null, null, null, (Function1) value$iv3, null, 47, null);
                            $composer.startReplaceGroup(1173202349);
                            ComposerKt.sourceInformation($composer, "CC(remember):ProductListScreen.kt#9igjgp");
                            boolean invalid$iv2 = $composer.changedInstance(this.$viewModel);
                            final ProductListViewModel productListViewModel2 = this.$viewModel;
                            Object it$iv2 = $composer.rememberedValue();
                            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                value$iv4 = new Function1() { // from class: com.easycompra.app.ui.list.ProductListScreenKt$ProductListScreen$1$2$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ProductListScreenKt.C07151.AnonymousClass2.invoke$lambda$3$lambda$2(productListViewModel2, (String) obj);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv4);
                            } else {
                                value$iv4 = it$iv2;
                            }
                            $composer.endReplaceGroup();
                            OutlinedTextFieldKt.OutlinedTextField(query, (Function1<? super String, Unit>) value$iv4, modifierFillMaxWidth, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$ProductListScreenKt.INSTANCE.m7085getLambda1$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptions, keyboardActions, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer, 12583296, 12779520, 0, 8159096);
                            $composer.startReplaceGroup(1173221315);
                            ComposerKt.sourceInformation($composer, "CC(remember):ProductListScreen.kt#9igjgp");
                            boolean invalid$iv3 = $composer.changedInstance(this.$viewModel);
                            final ProductListViewModel productListViewModel3 = this.$viewModel;
                            final MutableState<Boolean> mutableState = this.$searchActive$delegate;
                            Object it$iv3 = $composer.rememberedValue();
                            if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                value$iv5 = new Function0() { // from class: com.easycompra.app.ui.list.ProductListScreenKt$ProductListScreen$1$2$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return ProductListScreenKt.C07151.AnonymousClass2.invoke$lambda$5$lambda$4(productListViewModel3, mutableState);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv5);
                            } else {
                                value$iv5 = it$iv3;
                            }
                            $composer.endReplaceGroup();
                            IconButtonKt.IconButton((Function0) value$iv5, null, false, null, null, ComposableSingletons$ProductListScreenKt.INSTANCE.m7089getLambda2$app_debug(), $composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                            $composer.endReplaceGroup();
                        } else {
                            $composer.startReplaceGroup(2010321853);
                            ComposerKt.sourceInformation($composer, "98@4584L28,98@4563L170,101@4779L23,101@4758L159");
                            $composer.startReplaceGroup(1173228879);
                            ComposerKt.sourceInformation($composer, "CC(remember):ProductListScreen.kt#9igjgp");
                            boolean invalid$iv4 = $composer.changedInstance(this.$viewModel);
                            final ProductListViewModel productListViewModel4 = this.$viewModel;
                            Object it$iv4 = $composer.rememberedValue();
                            if (invalid$iv4 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                                value$iv = new Function0() { // from class: com.easycompra.app.ui.list.ProductListScreenKt$ProductListScreen$1$2$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return ProductListScreenKt.C07151.AnonymousClass2.invoke$lambda$7$lambda$6(productListViewModel4);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv);
                            } else {
                                value$iv = it$iv4;
                            }
                            $composer.endReplaceGroup();
                            IconButtonKt.IconButton((Function0) value$iv, null, false, null, null, ComposableSingletons$ProductListScreenKt.INSTANCE.m7090getLambda3$app_debug(), $composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                            $composer.startReplaceGroup(1173235114);
                            ComposerKt.sourceInformation($composer, "CC(remember):ProductListScreen.kt#9igjgp");
                            final MutableState<Boolean> mutableState2 = this.$searchActive$delegate;
                            Object it$iv5 = $composer.rememberedValue();
                            if (it$iv5 == Composer.INSTANCE.getEmpty()) {
                                value$iv2 = new Function0() { // from class: com.easycompra.app.ui.list.ProductListScreenKt$ProductListScreen$1$2$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return ProductListScreenKt.C07151.AnonymousClass2.invoke$lambda$9$lambda$8(mutableState2);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv2);
                            } else {
                                value$iv2 = it$iv5;
                            }
                            $composer.endReplaceGroup();
                            IconButtonKt.IconButton((Function0) value$iv2, null, false, null, null, ComposableSingletons$ProductListScreenKt.INSTANCE.m7091getLambda4$app_debug(), $composer, 196614, 30);
                            $composer.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$3$lambda$2(ProductListViewModel $viewModel, String it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        $viewModel.setQuery(it);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$1$lambda$0(ProductListViewModel $viewModel, State $state$delegate, KeyboardActionScope KeyboardActions) {
                        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
                        $viewModel.searchDia(ProductListScreenKt.ProductListScreen$lambda$0($state$delegate).getQuery());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$5$lambda$4(ProductListViewModel $viewModel, MutableState $searchActive$delegate) {
                        ProductListScreenKt.ProductListScreen$lambda$3($searchActive$delegate, false);
                        $viewModel.setQuery("");
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$7$lambda$6(ProductListViewModel $viewModel) {
                        $viewModel.syncDefaults();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$9$lambda$8(MutableState $searchActive$delegate) {
                        ProductListScreenKt.ProductListScreen$lambda$3($searchActive$delegate, true);
                        return Unit.INSTANCE;
                    }
                }
            }, $composer3, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-2140071809, true, new AnonymousClass2(viewModel, state$delegate, onProductClick), $composer3, 54), $composer2, 805306416, 509);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.list.ProductListScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProductListScreenKt.ProductListScreen$lambda$4(viewModel, onProductClick, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProductListUiState ProductListScreen$lambda$0(State<ProductListUiState> state) {
        Object thisObj$iv = state.getValue();
        return (ProductListUiState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ProductListScreen$lambda$2(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProductListScreen$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.list.ProductListScreenKt$ProductListScreen$2, reason: invalid class name */
    /* JADX INFO: compiled from: ProductListScreen.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass2 implements Function3<PaddingValues, Composer, Integer, Unit> {
        final /* synthetic */ Function1<Product, Unit> $onProductClick;
        final /* synthetic */ State<ProductListUiState> $state$delegate;
        final /* synthetic */ ProductListViewModel $viewModel;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(ProductListViewModel productListViewModel, State<ProductListUiState> state, Function1<? super Product, Unit> function1) {
            this.$viewModel = productListViewModel;
            this.$state$delegate = state;
            this.$onProductClick = function1;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer, Integer num) {
            invoke(paddingValues, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(PaddingValues padding, Composer $composer, int $changed) {
            Function0<ComposeUiNode> function0;
            Object value$iv;
            Function0<ComposeUiNode> function1;
            Function0<ComposeUiNode> function2;
            Intrinsics.checkNotNullParameter(padding, "padding");
            ComposerKt.sourceInformation($composer, "C109@5009L1747:ProductListScreen.kt#c0t1xm");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= $composer.changed(padding) ? 4 : 2;
            }
            if (($dirty & 19) == 18 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2140071809, $dirty, -1, "com.easycompra.app.ui.list.ProductListScreen.<anonymous> (ProductListScreen.kt:109)");
            }
            Modifier modifier$iv = SizeKt.fillMaxSize$default(PaddingKt.padding(Modifier.INSTANCE, padding), 0.0f, 1, null);
            ProductListViewModel productListViewModel = this.$viewModel;
            final State<ProductListUiState> state = this.$state$delegate;
            final Function1<Product, Unit> function3 = this.$onProductClick;
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
            ComposerKt.sourceInformationMarkerStart($composer, 2010901616, "C122@5553L27:ProductListScreen.kt#c0t1xm");
            $composer.startReplaceGroup(1173245244);
            ComposerKt.sourceInformation($composer, "111@5121L59,*115@5330L10,113@5243L264");
            if (ProductListScreenKt.ProductListScreen$lambda$0(state).isSyncing()) {
                ProgressIndicatorKt.m2397LinearProgressIndicatorrIrjwxo(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0L, 0L, 0, 0.0f, $composer, 6, 30);
                String it = ProductListScreenKt.ProductListScreen$lambda$0(state).getSyncProgress();
                if (it != null) {
                    TextKt.m2714Text4IGK_g(it, PaddingKt.m682paddingVpY3zN4(Modifier.INSTANCE, Dp.m6663constructorimpl(12), Dp.m6663constructorimpl(2)), Color.INSTANCE.m4211getGray0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getLabelSmall(), $composer, 432, 0, 65528);
                    Unit unit = Unit.INSTANCE;
                    Unit unit2 = Unit.INSTANCE;
                }
            }
            $composer.endReplaceGroup();
            ProductListScreenKt.FilterRow(ProductListScreenKt.ProductListScreen$lambda$0(state), productListViewModel, $composer, 0);
            if (ProductListScreenKt.ProductListScreen$lambda$0(state).isLoading()) {
                $composer.startReplaceGroup(1173262647);
                ComposerKt.sourceInformation($composer, "125@5636L132");
                Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
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
                    function2 = constructor2;
                    $composer.createNode(function2);
                } else {
                    function2 = constructor2;
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
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                int i4 = ((54 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 2055928950, "C126@5723L27:ProductListScreen.kt#c0t1xm");
                ProgressIndicatorKt.m2388CircularProgressIndicatorLxG7B9w(null, 0L, 0.0f, 0L, 0, $composer, 0, 31);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
            } else if (!ProductListScreenKt.ProductListScreen$lambda$0(state).getProducts().isEmpty() || ProductListScreenKt.ProductListScreen$lambda$0(state).isSyncing()) {
                $composer.startReplaceGroup(1173277871);
                ComposerKt.sourceInformation($composer, "136@6253L479,133@6096L636");
                PaddingValues paddingValuesM674PaddingValues0680j_4 = PaddingKt.m674PaddingValues0680j_4(Dp.m6663constructorimpl(8));
                Arrangement.HorizontalOrVertical horizontalOrVerticalM561spacedBy0680j_4 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(8));
                $composer.startReplaceGroup(1173282738);
                ComposerKt.sourceInformation($composer, "CC(remember):ProductListScreen.kt#9igjgp");
                boolean invalid$iv = $composer.changed(state) | $composer.changed(function3);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function1() { // from class: com.easycompra.app.ui.list.ProductListScreenKt$ProductListScreen$2$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ProductListScreenKt.AnonymousClass2.invoke$lambda$7$lambda$6$lambda$5(state, function3, (LazyListScope) obj);
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                $composer.endReplaceGroup();
                LazyDslKt.LazyColumn(null, null, paddingValuesM674PaddingValues0680j_4, false, horizontalOrVerticalM561spacedBy0680j_4, null, null, false, (Function1) value$iv, $composer, 24960, 235);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(1173269057);
                ComposerKt.sourceInformation($composer, "128@5833L238");
                Modifier modifier$iv3 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                Alignment contentAlignment$iv2 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv3 = (54 << 3) & 112;
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
                    function1 = constructor3;
                    $composer.createNode(function1);
                } else {
                    function1 = constructor3;
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
                ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                int i6 = ((54 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 2056164178, "C131@6032L10,131@5958L95:ProductListScreen.kt#c0t1xm");
                TextKt.m2714Text4IGK_g("Sin resultados.\nPulsa 🔄 para sincronizar.", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getBodyLarge(), $composer, 6, 0, 65534);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
            }
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
        public static final Unit invoke$lambda$7$lambda$6$lambda$5(final State $state$delegate, final Function1 $onProductClick, LazyListScope LazyColumn) {
            Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
            final List<Product> products = ProductListScreenKt.ProductListScreen$lambda$0($state$delegate).getProducts();
            final Function1 contentType$iv = new Function1() { // from class: com.easycompra.app.ui.list.ProductListScreenKt$ProductListScreen$2$invoke$lambda$7$lambda$6$lambda$5$$inlined$items$default$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    return invoke((Product) p1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(Product product) {
                    return null;
                }
            };
            LazyColumn.items(products.size(), null, new Function1<Integer, Object>() { // from class: com.easycompra.app.ui.list.ProductListScreenKt$ProductListScreen$2$invoke$lambda$7$lambda$6$lambda$5$$inlined$items$default$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int index) {
                    return contentType$iv.invoke(products.get(index));
                }
            }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.list.ProductListScreenKt$ProductListScreen$2$invoke$lambda$7$lambda$6$lambda$5$$inlined$items$default$4
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
                    final Product product = (Product) products.get(it);
                    $composer.startReplaceGroup(-336966547);
                    ComposerKt.sourceInformation($composer, "C*143@6639L27,138@6334L358:ProductListScreen.kt#c0t1xm");
                    SortField sortField = ProductListScreenKt.ProductListScreen$lambda$0($state$delegate).getSortField();
                    boolean zContains = ProductListScreenKt.ProductListScreen$lambda$0($state$delegate).getFavoriteIds().contains(product.getId());
                    boolean zContains2 = ProductListScreenKt.ProductListScreen$lambda$0($state$delegate).getShoppingListIds().contains(product.getId());
                    $composer.startReplaceGroup(-1396333781);
                    ComposerKt.sourceInformation($composer, "CC(remember):ProductListScreen.kt#9igjgp");
                    boolean invalid$iv = (((($changed2 & 112) ^ 48) > 32 && $composer.changed(product)) || ($changed2 & 48) == 32) | $composer.changed($onProductClick);
                    Object it$iv = $composer.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        final Function1 function1 = $onProductClick;
                        value$iv = (Function0) new Function0<Unit>() { // from class: com.easycompra.app.ui.list.ProductListScreenKt$ProductListScreen$2$1$4$1$1$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                function1.invoke(product);
                            }
                        };
                        $composer.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer.endReplaceGroup();
                    ProductListScreenKt.ProductCard(product, sortField, zContains, zContains2, (Function0) value$iv, $composer, ($changed2 >> 3) & 14);
                    $composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void FilterRow(final ProductListUiState state, final ProductListViewModel viewModel, Composer $composer, final int $changed) {
        Function0<ComposeUiNode> function0;
        Object value$iv;
        Object value$iv2;
        Composer $composer2 = $composer.startRestartGroup(1739448044);
        ComposerKt.sourceInformation($composer2, "C(FilterRow)155@6906L3545:ProductListScreen.kt#c0t1xm");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(viewModel) ? 32 : 16;
        }
        if (($dirty & 19) == 18 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1739448044, $dirty, -1, "com.easycompra.app.ui.list.FilterRow (ProductListScreen.kt:154)");
            }
            Modifier modifier$iv = PaddingKt.m682paddingVpY3zN4(Modifier.INSTANCE, Dp.m6663constructorimpl(8), Dp.m6663constructorimpl(4));
            ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv = (6 << 3) & 112;
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
            ComposerKt.sourceInformationMarkerStart($composer2, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -599612355, "C157@7104L2116,157@7044L2176,210@9361L590,210@9260L691,231@10143L302,227@9961L484:ProductListScreen.kt#c0t1xm");
            Arrangement.HorizontalOrVertical horizontalOrVerticalM561spacedBy0680j_4 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(6));
            $composer2.startReplaceGroup(119205633);
            ComposerKt.sourceInformation($composer2, "CC(remember):ProductListScreen.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(state) | $composer2.changedInstance(viewModel);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function1() { // from class: com.easycompra.app.ui.list.ProductListScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProductListScreenKt.FilterRow$lambda$11$lambda$6$lambda$5(state, viewModel, (LazyListScope) obj);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer2.endReplaceGroup();
            LazyDslKt.LazyRow(null, null, null, false, horizontalOrVerticalM561spacedBy0680j_4, null, null, false, (Function1) value$iv, $composer2, 24576, 239);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM561spacedBy0680j_5 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(6));
            Modifier modifierM685paddingqDBjuR0$default = PaddingKt.m685paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6663constructorimpl(4), 0.0f, 0.0f, 13, null);
            Arrangement.HorizontalOrVertical horizontalOrVertical = horizontalOrVerticalM561spacedBy0680j_5;
            $composer2.startReplaceGroup(119276331);
            ComposerKt.sourceInformation($composer2, "CC(remember):ProductListScreen.kt#9igjgp");
            boolean invalid$iv2 = $composer2.changedInstance(state) | $composer2.changedInstance(viewModel);
            Object it$iv2 = $composer2.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = new Function1() { // from class: com.easycompra.app.ui.list.ProductListScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProductListScreenKt.FilterRow$lambda$11$lambda$10$lambda$9(state, viewModel, (LazyListScope) obj);
                    }
                };
                $composer2.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            $composer2.endReplaceGroup();
            LazyDslKt.LazyRow(modifierM685paddingqDBjuR0$default, null, null, false, horizontalOrVertical, null, null, false, (Function1) value$iv2, $composer2, 24582, 238);
            TabRowKt.m2614ScrollableTabRowsKfQg0A(SortField.getEntries().indexOf(state.getSortField()), SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0L, 0L, Dp.m6663constructorimpl(0), null, null, ComposableLambdaKt.rememberComposableLambda(930959298, true, new ProductListScreenKt$FilterRow$1$3(state, viewModel), $composer2, 54), $composer2, 12607536, 108);
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
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.list.ProductListScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProductListScreenKt.FilterRow$lambda$12(state, viewModel, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilterRow$lambda$11$lambda$6$lambda$5(ProductListUiState $state, ProductListViewModel $viewModel, LazyListScope LazyRow) {
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        LazyListScope.item$default(LazyRow, null, null, ComposableLambdaKt.composableLambdaInstance(1815184768, true, new ProductListScreenKt$FilterRow$1$1$1$1($state, $viewModel)), 3, null);
        LazyListScope.item$default(LazyRow, null, null, ComposableLambdaKt.composableLambdaInstance(535817065, true, new ProductListScreenKt$FilterRow$1$1$1$2($state, $viewModel)), 3, null);
        LazyListScope.item$default(LazyRow, null, null, ComposableLambdaKt.composableLambdaInstance(-1068186808, true, new ProductListScreenKt$FilterRow$1$1$1$3($state, $viewModel)), 3, null);
        LazyListScope.item$default(LazyRow, null, null, ComposableLambdaKt.composableLambdaInstance(1622776615, true, new ProductListScreenKt$FilterRow$1$1$1$4($state, $viewModel)), 3, null);
        LazyListScope.item$default(LazyRow, null, null, ComposableLambdaKt.composableLambdaInstance(18772742, true, new ProductListScreenKt$FilterRow$1$1$1$5($state, $viewModel)), 3, null);
        LazyListScope.item$default(LazyRow, null, null, ComposableLambdaKt.composableLambdaInstance(-1585231131, true, new ProductListScreenKt$FilterRow$1$1$1$6($state, $viewModel)), 3, null);
        LazyListScope.item$default(LazyRow, null, null, ComposableLambdaKt.composableLambdaInstance(1105732292, true, new ProductListScreenKt$FilterRow$1$1$1$7($state, $viewModel)), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilterRow$lambda$11$lambda$10$lambda$9(final ProductListUiState $state, final ProductListViewModel $viewModel, LazyListScope LazyRow) {
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        LazyListScope.item$default(LazyRow, null, null, ComposableLambdaKt.composableLambdaInstance(584917623, true, new ProductListScreenKt$FilterRow$1$2$1$1($state, $viewModel)), 3, null);
        final List items$iv = CollectionsKt.listOf((Object[]) new String[]{"a", "b", "c", "d", "e"});
        final Function1 contentType$iv = new Function1() { // from class: com.easycompra.app.ui.list.ProductListScreenKt$FilterRow$lambda$11$lambda$10$lambda$9$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                return invoke((String) p1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(String str) {
                return null;
            }
        };
        LazyRow.items(items$iv.size(), null, new Function1<Integer, Object>() { // from class: com.easycompra.app.ui.list.ProductListScreenKt$FilterRow$lambda$11$lambda$10$lambda$9$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int index) {
                return contentType$iv.invoke(items$iv.get(index));
            }
        }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.list.ProductListScreenKt$FilterRow$lambda$11$lambda$10$lambda$9$$inlined$items$default$4
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
                final String grade = (String) items$iv.get(it);
                $composer.startReplaceGroup(-1929061939);
                ComposerKt.sourceInformation($composer, "C*221@9813L40,222@9883L26,219@9707L220:ProductListScreen.kt#c0t1xm");
                boolean zAreEqual = Intrinsics.areEqual($state.getNutriscoreFilter(), grade);
                $composer.startReplaceGroup(-1586245246);
                ComposerKt.sourceInformation($composer, "CC(remember):ProductListScreen.kt#9igjgp");
                boolean invalid$iv = (((($changed2 & 112) ^ 48) > 32 && $composer.changed(grade)) || ($changed2 & 48) == 32) | $composer.changedInstance($viewModel);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    final ProductListViewModel productListViewModel = $viewModel;
                    value$iv = (Function0) new Function0<Unit>() { // from class: com.easycompra.app.ui.list.ProductListScreenKt$FilterRow$1$2$1$2$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            productListViewModel.setNutriscoreFilter(grade);
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                $composer.endReplaceGroup();
                ChipKt.FilterChip(zAreEqual, (Function0) value$iv, ComposableLambdaKt.rememberComposableLambda(-347387417, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.list.ProductListScreenKt$FilterRow$1$2$1$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer2, int $changed3) {
                        ComposerKt.sourceInformation($composer2, "C222@9885L22:ProductListScreen.kt#c0t1xm");
                        if (($changed3 & 3) == 2 && $composer2.getSkipping()) {
                            $composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-347387417, $changed3, -1, "com.easycompra.app.ui.list.FilterRow.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ProductListScreen.kt:222)");
                        }
                        NutriScoreBadgeKt.NutriScoreBadge(grade, null, $composer2, 0, 2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer, 54), null, false, null, null, null, null, null, null, null, $composer, 384, 0, 4088);
                $composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProductCard(final Product product, final SortField sortField, final boolean isFavorite, final boolean isInList, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1796969657);
        ComposerKt.sourceInformation($composer2, "C(ProductCard)P(3,4)254@10775L38,255@10845L40,256@10892L2363,251@10620L2635:ProductListScreen.kt#c0t1xm");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(product) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(sortField) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(isFavorite) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(isInList) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 9363) != 9362 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1796969657, $dirty2, -1, "com.easycompra.app.ui.list.ProductCard (ProductListScreen.kt:250)");
            }
            Modifier modifierM269clickableXHw0xAI$default = ClickableKt.m269clickableXHw0xAI$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, null, null, function0, 7, null);
            RoundedCornerShape roundedCornerShapeM964RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m964RoundedCornerShape0680j_4(Dp.m6663constructorimpl(12));
            CardDefaults cardDefaults = CardDefaults.INSTANCE;
            float fM6663constructorimpl = Dp.m6663constructorimpl(2);
            int $this$dp$iv = CardDefaults.$stable;
            CardKt.Card(modifierM269clickableXHw0xAI$default, roundedCornerShapeM964RoundedCornerShape0680j_4, CardDefaults.INSTANCE.m1850cardColorsro_MJ88(Color.INSTANCE.m4218getWhite0d7_KjU(), 0L, 0L, 0L, $composer2, (CardDefaults.$stable << 12) | 6, 14), cardDefaults.m1851cardElevationaqJV_2Y(fM6663constructorimpl, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer2, ($this$dp$iv << 18) | 6, 62), null, ComposableLambdaKt.rememberComposableLambda(68526123, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.list.ProductListScreenKt.ProductCard.1

                /* JADX INFO: renamed from: com.easycompra.app.ui.list.ProductListScreenKt$ProductCard$1$WhenMappings */
                /* JADX INFO: compiled from: ProductListScreen.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[SortField.values().length];
                        try {
                            iArr[SortField.SUGARS.ordinal()] = 1;
                        } catch (NoSuchFieldError e) {
                        }
                        try {
                            iArr[SortField.CALORIES.ordinal()] = 2;
                        } catch (NoSuchFieldError e2) {
                        }
                        try {
                            iArr[SortField.FAT.ordinal()] = 3;
                        } catch (NoSuchFieldError e3) {
                        }
                        try {
                            iArr[SortField.PROTEINS.ordinal()] = 4;
                        } catch (NoSuchFieldError e4) {
                        }
                        try {
                            iArr[SortField.PRICE.ordinal()] = 5;
                        } catch (NoSuchFieldError e5) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                    invoke(columnScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope Card, Composer $composer3, int $changed2) {
                    Function0<ComposeUiNode> function1;
                    Function0<ComposeUiNode> function2;
                    Function0<ComposeUiNode> function3;
                    Function0<ComposeUiNode> function4;
                    String str;
                    Intrinsics.checkNotNullParameter(Card, "$this$Card");
                    ComposerKt.sourceInformation($composer3, "C257@10902L2347:ProductListScreen.kt#c0t1xm");
                    if (($changed2 & 17) == 16 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(68526123, $changed2, -1, "com.easycompra.app.ui.list.ProductCard.<anonymous> (ProductListScreen.kt:257)");
                    }
                    Modifier modifier$iv = PaddingKt.m681padding3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(10));
                    Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                    Product product2 = product;
                    boolean z = isFavorite;
                    boolean z2 = isInList;
                    SortField sortField2 = sortField;
                    ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                    int $changed$iv$iv = (390 << 3) & 112;
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
                        function1 = constructor;
                        $composer3.createNode(function1);
                    } else {
                        function1 = constructor;
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
                    int i2 = ((390 >> 6) & 112) | 6;
                    RowScope $this$invoke_u24lambda_u2410 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1084636399, "C258@11004L215,264@11232L29,265@11274L1965:ProductListScreen.kt#c0t1xm");
                    SingletonAsyncImageKt.m7012AsyncImagegl8XCv8(product2.getPhotoUrl(), product2.getName(), SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(72)), null, null, null, ContentScale.INSTANCE.getFit(), 0.0f, null, 0, false, null, $composer3, 1573248, 0, 4024);
                    SpacerKt.Spacer(SizeKt.m731width3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(12)), $composer3, 6);
                    Modifier modifier$iv2 = RowScope.weight$default($this$invoke_u24lambda_u2410, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                    MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv2 = (0 << 3) & 112;
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
                        function2 = constructor2;
                        $composer3.createNode(function2);
                    } else {
                        function2 = constructor2;
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
                    int i4 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1304465957, "C266@11331L521,277@11869L29,278@11915L243,285@12175L29,286@12221L1004:ProductListScreen.kt#c0t1xm");
                    Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(6));
                    Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                    Modifier modifier$iv3 = Modifier.INSTANCE;
                    MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                    int $changed$iv$iv3 = (432 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                    CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        function3 = constructor3;
                        $composer3.createNode(function3);
                    } else {
                        function3 = constructor3;
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
                    int i6 = ((432 >> 6) & 112) | 6;
                    RowScope $this$invoke_u24lambda_u2410_u24lambda_u249_u24lambda_u240 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer3, -410706355, "C270@11515L37,271@11573L40,272@11634L27:ProductListScreen.kt#c0t1xm");
                    NutriScoreBadgeKt.SupermarketBadge(product2.getSupermarket(), null, $composer3, 0, 2);
                    NutriScoreBadgeKt.NutriScoreBadge(product2.getNutriscoreGrade(), null, $composer3, 0, 2);
                    SpacerKt.Spacer(RowScope.weight$default($this$invoke_u24lambda_u2410_u24lambda_u249_u24lambda_u240, Modifier.INSTANCE, 1.0f, false, 2, null), $composer3, 0);
                    $composer3.startReplaceGroup(-1952904733);
                    ComposerKt.sourceInformation($composer3, "274@11743L28");
                    if (z) {
                        TextKt.m2714Text4IGK_g("❤️", (Modifier) null, 0L, TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 3078, 0, 131062);
                    }
                    $composer3.endReplaceGroup();
                    $composer3.startReplaceGroup(-1952902655);
                    ComposerKt.sourceInformation($composer3, "275@11806L28");
                    if (z2) {
                        TextKt.m2714Text4IGK_g("🛒", (Modifier) null, 0L, TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 3078, 0, 131062);
                    }
                    $composer3.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    SpacerKt.Spacer(SizeKt.m712height3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(4)), $composer3, 6);
                    TextKt.m2714Text4IGK_g(product2.getName(), (Modifier) null, 0L, TextUnitKt.getSp(14), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6580getEllipsisgIe3tQ8(), false, 2, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 199680, 3120, 120790);
                    SpacerKt.Spacer(SizeKt.m712height3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(4)), $composer3, 6);
                    Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(12));
                    ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                    Modifier modifier$iv4 = Modifier.INSTANCE;
                    Alignment.Vertical verticalAlignment$iv3 = Alignment.INSTANCE.getTop();
                    MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer3, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                    int $changed$iv$iv4 = (48 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                    CompositionLocalMap localMap$iv$iv4 = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
                    Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        function4 = constructor4;
                        $composer3.createNode(function4);
                    } else {
                        function4 = constructor4;
                        $composer3.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.m3674constructorimpl($composer3);
                    Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if ($this$Layout_u24lambda_u240$iv$iv4.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv4.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv4))) {
                        $this$Layout_u24lambda_u240$iv$iv4.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv4));
                        $this$Layout_u24lambda_u240$iv$iv4.apply(Integer.valueOf(compositeKeyHash$iv$iv4), setCompositeKeyHash4);
                    }
                    Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                    int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    int i8 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -409909407, "C:ProductListScreen.kt#c0t1xm");
                    Double unitPrice = product2.getUnitPrice();
                    $composer3.startReplaceGroup(-1952885683);
                    ComposerKt.sourceInformation($composer3, "*288@12397L11,288@12349L98");
                    if (unitPrice != null) {
                        double it = unitPrice.doubleValue();
                        String str2 = String.format("%.2f €", Arrays.copyOf(new Object[]{Double.valueOf(it)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                        TextKt.m2714Text4IGK_g(str2, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary(), 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 131034);
                        Unit unit = Unit.INSTANCE;
                        Unit unit2 = Unit.INSTANCE;
                    }
                    $composer3.endReplaceGroup();
                    switch (WhenMappings.$EnumSwitchMapping$0[sortField2.ordinal()]) {
                        case 1:
                            Double sugars100g = product2.getSugars100g();
                            if (sugars100g == null) {
                                str = null;
                            } else {
                                double it2 = sugars100g.doubleValue();
                                String str3 = String.format("%.1f g az.", Arrays.copyOf(new Object[]{Double.valueOf(it2)}, 1));
                                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                                str = str3;
                            }
                            break;
                        case 2:
                            Double energyKcal100g = product2.getEnergyKcal100g();
                            if (energyKcal100g == null) {
                                str = null;
                            } else {
                                double it3 = energyKcal100g.doubleValue();
                                String str4 = String.format("%.0f kcal", Arrays.copyOf(new Object[]{Double.valueOf(it3)}, 1));
                                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                                str = str4;
                            }
                            break;
                        case 3:
                            Double fat100g = product2.getFat100g();
                            if (fat100g == null) {
                                str = null;
                            } else {
                                double it4 = fat100g.doubleValue();
                                String str5 = String.format("%.1f g grasas", Arrays.copyOf(new Object[]{Double.valueOf(it4)}, 1));
                                Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                                str = str5;
                            }
                            break;
                        case 4:
                            Double proteins100g = product2.getProteins100g();
                            if (proteins100g == null) {
                                str = null;
                            } else {
                                double it5 = proteins100g.doubleValue();
                                String str6 = String.format("%.1f g prot.", Arrays.copyOf(new Object[]{Double.valueOf(it5)}, 1));
                                Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                                str = str6;
                            }
                            break;
                        case 5:
                            Double referencePrice = product2.getReferencePrice();
                            if (referencePrice == null) {
                                str = null;
                            } else {
                                double it6 = referencePrice.doubleValue();
                                String referenceFormat = product2.getReferenceFormat();
                                if (referenceFormat == null) {
                                    referenceFormat = "u";
                                }
                                String str7 = String.format("%.2f €/" + referenceFormat, Arrays.copyOf(new Object[]{Double.valueOf(it6)}, 1));
                                Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                                str = str7;
                            }
                            break;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                    String highlightValue = str;
                    $composer3.startReplaceGroup(-1952860455);
                    ComposerKt.sourceInformation($composer3, "*298@13139L46");
                    if (highlightValue != null) {
                        TextKt.m2714Text4IGK_g(highlightValue, (Modifier) null, Color.INSTANCE.m4211getGray0d7_KjU(), TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 3456, 0, 131058);
                        Unit unit3 = Unit.INSTANCE;
                        Unit unit4 = Unit.INSTANCE;
                    }
                    $composer3.endReplaceGroup();
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
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), $composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.list.ProductListScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProductListScreenKt.ProductCard$lambda$13(product, sortField, isFavorite, isInList, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
