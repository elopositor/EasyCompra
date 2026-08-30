package com.easycompra.app.ui.detail;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
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
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.FavoriteBorderKt;
import androidx.compose.material.icons.filled.FavoriteKt;
import androidx.compose.material.icons.filled.ShoppingCartKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
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
import androidx.profileinstaller.ProfileVerifier;
import coil.compose.SingletonAsyncImageKt;
import com.easycompra.app.data.Product;
import com.easycompra.app.ui.components.NutriScoreBadgeKt;
import com.easycompra.app.ui.list.ProductListUiState;
import com.easycompra.app.ui.list.ProductListViewModel;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ProductDetailScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\u0015\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\n\u001a(\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u000fH\u0003¢\u0006\u0002\u0010\u0010¨\u0006\u0011²\u0006\n\u0010\u0012\u001a\u00020\u0013X\u008a\u0084\u0002"}, d2 = {"ProductDetailScreen", "", "product", "Lcom/easycompra/app/data/Product;", "viewModel", "Lcom/easycompra/app/ui/list/ProductListViewModel;", "onBack", "Lkotlin/Function0;", "(Lcom/easycompra/app/data/Product;Lcom/easycompra/app/ui/list/ProductListViewModel;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "NutritionTable", "(Lcom/easycompra/app/data/Product;Landroidx/compose/runtime/Composer;I)V", "Section", "title", "", "content", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "app_debug", "state", "Lcom/easycompra/app/ui/list/ProductListUiState;"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ProductDetailScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NutritionTable$lambda$2(Product product, int i, Composer composer, int i2) {
        NutritionTable(product, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductDetailScreen$lambda$1(Product product, ProductListViewModel productListViewModel, Function0 function0, int i, Composer composer, int i2) {
        ProductDetailScreen(product, productListViewModel, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Section$lambda$3(String str, Function2 function2, int i, Composer composer, int i2) {
        Section(str, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ProductDetailScreen(final Product product, final ProductListViewModel viewModel, final Function0<Unit> onBack, Composer $composer, final int $changed) {
        Composer $composer2;
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(onBack, "onBack");
        Composer $composer3 = $composer.startRestartGroup(-588270729);
        ComposerKt.sourceInformation($composer3, "C(ProductDetailScreen)P(1,2)53@2295L16,58@2452L577,73@3036L4178,57@2425L4789:ProductDetailScreen.kt#scc5s3");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(product) ? 4 : 2;
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
                ComposerKt.traceEventStart(-588270729, $dirty2, -1, "com.easycompra.app.ui.detail.ProductDetailScreen (ProductDetailScreen.kt:52)");
            }
            State state$delegate = SnapshotStateKt.collectAsState(viewModel.getUiState(), null, $composer3, 0, 1);
            boolean isFavorite = ProductDetailScreen$lambda$0(state$delegate).getFavoriteIds().contains(product.getId());
            boolean isInList = ProductDetailScreen$lambda$0(state$delegate).getShoppingListIds().contains(product.getId());
            $composer2 = $composer3;
            ScaffoldKt.m2429ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(1350940211, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.detail.ProductDetailScreenKt.ProductDetailScreen.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C60@2501L36,61@2572L168,67@2853L11,66@2785L220,59@2466L553:ProductDetailScreen.kt#scc5s3");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1350940211, $changed2, -1, "com.easycompra.app.ui.detail.ProductDetailScreen.<anonymous> (ProductDetailScreen.kt:59)");
                        }
                        final Product product2 = product;
                        ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1402117897, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.detail.ProductDetailScreenKt.ProductDetailScreen.1.1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer5, int $changed3) {
                                ComposerKt.sourceInformation($composer5, "C60@2503L32:ProductDetailScreen.kt#scc5s3");
                                if (($changed3 & 3) == 2 && $composer5.getSkipping()) {
                                    $composer5.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1402117897, $changed3, -1, "com.easycompra.app.ui.detail.ProductDetailScreen.<anonymous>.<anonymous> (ProductDetailScreen.kt:60)");
                                }
                                TextKt.m2714Text4IGK_g(product2.getName(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer5, 0, 3072, 122878);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }, $composer4, 54);
                        final Function0<Unit> function0 = onBack;
                        AppBarKt.m1794TopAppBarGHTll3U(composableLambdaRememberComposableLambda, null, ComposableLambdaKt.rememberComposableLambda(-499197319, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.detail.ProductDetailScreenKt.ProductDetailScreen.1.2
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer5, int $changed3) {
                                ComposerKt.sourceInformation($composer5, "C62@2594L128:ProductDetailScreen.kt#scc5s3");
                                if (($changed3 & 3) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-499197319, $changed3, -1, "com.easycompra.app.ui.detail.ProductDetailScreen.<anonymous>.<anonymous> (ProductDetailScreen.kt:62)");
                                    }
                                    IconButtonKt.IconButton(function0, null, false, null, null, ComposableSingletons$ProductDetailScreenKt.INSTANCE.m7082getLambda1$app_debug(), $composer5, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }, $composer4, 54), null, 0.0f, null, TopAppBarDefaults.INSTANCE.m2885topAppBarColorszjMxDiM(MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getPrimary(), 0L, Color.INSTANCE.m4218getWhite0d7_KjU(), Color.INSTANCE.m4218getWhite0d7_KjU(), 0L, $composer4, (TopAppBarDefaults.$stable << 15) | 3456, 18), null, $composer4, 390, 186);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-586264056, true, new AnonymousClass2(product, viewModel, isInList, isFavorite), $composer3, 54), $composer2, 805306416, 509);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.detail.ProductDetailScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProductDetailScreenKt.ProductDetailScreen$lambda$1(product, viewModel, onBack, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final ProductListUiState ProductDetailScreen$lambda$0(State<ProductListUiState> state) {
        Object thisObj$iv = state.getValue();
        return (ProductListUiState) thisObj$iv;
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.detail.ProductDetailScreenKt$ProductDetailScreen$2, reason: invalid class name */
    /* JADX INFO: compiled from: ProductDetailScreen.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass2 implements Function3<PaddingValues, Composer, Integer, Unit> {
        final /* synthetic */ boolean $isFavorite;
        final /* synthetic */ boolean $isInList;
        final /* synthetic */ Product $product;
        final /* synthetic */ ProductListViewModel $viewModel;

        AnonymousClass2(Product product, ProductListViewModel productListViewModel, boolean z, boolean z2) {
            this.$product = product;
            this.$viewModel = productListViewModel;
            this.$isInList = z;
            this.$isFavorite = z2;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer, Integer num) {
            invoke(paddingValues, composer, num.intValue());
            return Unit.INSTANCE;
        }

        /* JADX WARN: Code duplicated, block: B:108:0x086e  */
        public final void invoke(PaddingValues padding, Composer $composer, int $changed) {
            Function0<ComposeUiNode> function0;
            Function0<ComposeUiNode> function1;
            Function0<ComposeUiNode> function2;
            Function0<ComposeUiNode> function3;
            Function0<ComposeUiNode> function4;
            String lowerCase;
            Object value$iv;
            Object value$iv2;
            Intrinsics.checkNotNullParameter(padding, "padding");
            ComposerKt.sourceInformation($composer, "C78@3194L21,74@3057L4151:ProductDetailScreen.kt#scc5s3");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= $composer.changed(padding) ? 4 : 2;
            }
            if (($dirty & 19) != 18 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-586264056, $dirty, -1, "com.easycompra.app.ui.detail.ProductDetailScreen.<anonymous> (ProductDetailScreen.kt:74)");
                }
                Modifier modifier$iv = PaddingKt.m681padding3ABfNKs(ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(PaddingKt.padding(Modifier.INSTANCE, padding), 0.0f, 1, null), ScrollKt.rememberScrollState(0, $composer, 0, 1), false, null, false, 14, null), Dp.m6663constructorimpl(16));
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(16));
                final Product product = this.$product;
                final ProductListViewModel productListViewModel = this.$viewModel;
                final boolean z = this.$isInList;
                final boolean z2 = this.$isFavorite;
                ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
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
                int i2 = ((48 >> 6) & 112) | 6;
                ColumnScope $this$invoke_u24lambda_u2412 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, 603747636, "C82@3336L252,89@3602L182,94@3839L10,94@3798L93,97@3979L1311,126@5337L1326,157@6677L23:ProductDetailScreen.kt#scc5s3");
                SingletonAsyncImageKt.m7012AsyncImagegl8XCv8(product.getPhotoUrl(), product.getName(), $this$invoke_u24lambda_u2412.align(SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(180)), Alignment.INSTANCE.getCenterHorizontally()), null, null, null, ContentScale.INSTANCE.getFit(), 0.0f, null, 0, false, null, $composer, 1572864, 0, 4024);
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(8));
                ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                Modifier modifier$iv2 = Modifier.INSTANCE;
                Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                int $i$f$Column = ((48 >> 3) & 14) | ((48 >> 3) & 112);
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, $i$f$Column);
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
                int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                int i4 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 1026833869, "C90@3676L37,91@3730L40:ProductDetailScreen.kt#scc5s3");
                NutriScoreBadgeKt.SupermarketBadge(product.getSupermarket(), null, $composer, 0, 2);
                NutriScoreBadgeKt.NutriScoreBadge(product.getNutriscoreGrade(), null, $composer, 0, 2);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                TextKt.m2714Text4IGK_g(product.getName(), (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getTitleLarge(), $composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 65502);
                String it = product.getBrand();
                $composer.startReplaceGroup(989321895);
                ComposerKt.sourceInformation($composer, "*95@3925L38");
                if (it != null) {
                    TextKt.m2714Text4IGK_g("Marca: " + it, (Modifier) null, Color.INSTANCE.m4211getGray0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 384, 0, 131066);
                    Unit unit = Unit.INSTANCE;
                    Unit unit2 = Unit.INSTANCE;
                }
                $composer.endReplaceGroup();
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(24));
                ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                Modifier modifier$iv3 = Modifier.INSTANCE;
                Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                int $changed$iv$iv3 = (48 << 3) & 112;
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
                ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                int i6 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 1027243813, "C:ProductDetailScreen.kt#scc5s3");
                Double unitPrice = product.getUnitPrice();
                $composer.startReplaceGroup(1002968147);
                ComposerKt.sourceInformation($composer, "*99@4099L495");
                if (unitPrice != null) {
                    double it2 = unitPrice.doubleValue();
                    Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getCenterHorizontally();
                    ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                    Modifier modifier$iv4 = Modifier.INSTANCE;
                    Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                    MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                    int $changed$iv$iv4 = (384 << 3) & 112;
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
                    ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    int i8 = ((384 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, 1333660713, "C102@4289L10,104@4423L11,100@4184L284,106@4550L10,106@4493L79:ProductDetailScreen.kt#scc5s3");
                    String str = String.format("%.2f €", Arrays.copyOf(new Object[]{Double.valueOf(it2)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    TextKt.m2714Text4IGK_g(str, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary(), 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getHeadlineSmall(), $composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 65498);
                    TextKt.m2714Text4IGK_g("precio", (Modifier) null, Color.INSTANCE.m4211getGray0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getLabelSmall(), $composer, 390, 0, 65530);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Unit unit3 = Unit.INSTANCE;
                    Unit unit4 = Unit.INSTANCE;
                }
                $composer.endReplaceGroup();
                Double referencePrice = product.getReferencePrice();
                $composer.startReplaceGroup(1002986791);
                ComposerKt.sourceInformation($composer, "*110@4679L579");
                if (referencePrice != null) {
                    double it3 = referencePrice.doubleValue();
                    Alignment.Horizontal horizontalAlignment$iv3 = Alignment.INSTANCE.getCenterHorizontally();
                    ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                    Modifier modifier$iv5 = Modifier.INSTANCE;
                    Arrangement.Vertical verticalArrangement$iv3 = Arrangement.INSTANCE.getTop();
                    int $i$f$Column2 = ((384 >> 3) & 14) | ((384 >> 3) & 112);
                    MeasurePolicy measurePolicy$iv5 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv3, horizontalAlignment$iv3, $composer, $i$f$Column2);
                    int $changed$iv$iv5 = (384 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv5 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                    CompositionLocalMap localMap$iv$iv5 = $composer.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer, modifier$iv5);
                    Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!($composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer.startReusableNode();
                    if ($composer.getInserting()) {
                        function4 = constructor5;
                        $composer.createNode(function4);
                    } else {
                        function4 = constructor5;
                        $composer.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.m3674constructorimpl($composer);
                    Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if ($this$Layout_u24lambda_u240$iv$iv5.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv5.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv5))) {
                        $this$Layout_u24lambda_u240$iv$iv5.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv5));
                        $this$Layout_u24lambda_u240$iv$iv5.apply(Integer.valueOf(compositeKeyHash$iv$iv5), setCompositeKeyHash5);
                    }
                    Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.INSTANCE.getSetModifier());
                    int i9 = ($changed$iv$iv$iv5 >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                    int i10 = ((384 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, 1334238677, "C113@4869L10,111@4764L213,119@5189L10,116@5002L234:ProductDetailScreen.kt#scc5s3");
                    String str2 = String.format("%.2f €", Arrays.copyOf(new Object[]{Double.valueOf(it3)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    TextKt.m2714Text4IGK_g(str2, (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getHeadlineSmall(), $composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 65502);
                    String referenceFormat = product.getReferenceFormat();
                    if (referenceFormat != null) {
                        lowerCase = referenceFormat.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        if (lowerCase == null) {
                            lowerCase = "kg";
                        }
                    } else {
                        lowerCase = "kg";
                    }
                    TextKt.m2714Text4IGK_g("por " + lowerCase, (Modifier) null, Color.INSTANCE.m4211getGray0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getLabelSmall(), $composer, 384, 0, 65530);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Unit unit5 = Unit.INSTANCE;
                    Unit unit6 = Unit.INSTANCE;
                }
                $composer.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier modifier$iv6 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(12));
                ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                Alignment.Vertical verticalAlignment$iv3 = Alignment.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv6 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                int $changed$iv$iv6 = (54 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv6 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                CompositionLocalMap localMap$iv$iv6 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer, modifier$iv6);
                Function0<ComposeUiNode> constructor6 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv6 = (($changed$iv$iv6 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    $composer.createNode(constructor6);
                } else {
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv6 = Updater.m3674constructorimpl($composer);
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv6, measurePolicy$iv6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv6, localMap$iv$iv6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv6.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv6.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv6))) {
                    $this$Layout_u24lambda_u240$iv$iv6.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv6));
                    $this$Layout_u24lambda_u240$iv$iv6.apply(Integer.valueOf(compositeKeyHash$iv$iv6), setCompositeKeyHash6);
                }
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv6, materialized$iv$iv6, ComposeUiNode.INSTANCE.getSetModifier());
                int i11 = ($changed$iv$iv$iv6 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                int i12 = ((54 >> 6) & 112) | 6;
                RowScope $this$invoke_u24lambda_u2412_u24lambda_u2411 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, 1028670216, "C131@5532L40,133@5643L349,130@5494L498,143@6055L37,145@6163L486,142@6009L640:ProductDetailScreen.kt#scc5s3");
                $composer.startReplaceGroup(1003014336);
                ComposerKt.sourceInformation($composer, "CC(remember):ProductDetailScreen.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance(productListViewModel) | $composer.changed(product);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function0() { // from class: com.easycompra.app.ui.detail.ProductDetailScreenKt$ProductDetailScreen$2$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ProductDetailScreenKt.AnonymousClass2.invoke$lambda$12$lambda$11$lambda$8$lambda$7(productListViewModel, product);
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                $composer.endReplaceGroup();
                ButtonKt.Button((Function0) value$iv, RowScope.weight$default($this$invoke_u24lambda_u2412_u24lambda_u2411, Modifier.INSTANCE, 1.0f, false, 2, null), false, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-1805099318, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.detail.ProductDetailScreenKt$ProductDetailScreen$2$1$4$2
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                        invoke(rowScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope Button, Composer $composer2, int $changed2) {
                        Intrinsics.checkNotNullParameter(Button, "$this$Button");
                        ComposerKt.sourceInformation($composer2, "C134@5665L186,139@5872L27,140@5920L54:ProductDetailScreen.kt#scc5s3");
                        if (($changed2 & 17) != 16 || !$composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1805099318, $changed2, -1, "com.easycompra.app.ui.detail.ProductDetailScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ProductDetailScreen.kt:134)");
                            }
                            IconKt.m2171Iconww6aTOc(ShoppingCartKt.getShoppingCart(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(18)), 0L, $composer2, 432, 8);
                            SpacerKt.Spacer(SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(6)), $composer2, 6);
                            TextKt.m2714Text4IGK_g(z ? "Añadir más" : "Añadir a lista", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 0, 0, 131070);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer2.skipToGroupEnd();
                    }
                }, $composer, 54), $composer, 805306368, 508);
                $composer.startReplaceGroup(1003031069);
                ComposerKt.sourceInformation($composer, "CC(remember):ProductDetailScreen.kt#9igjgp");
                boolean invalid$iv2 = $composer.changedInstance(productListViewModel) | $composer.changed(product);
                Object it$iv2 = $composer.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = new Function0() { // from class: com.easycompra.app.ui.detail.ProductDetailScreenKt$ProductDetailScreen$2$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ProductDetailScreenKt.AnonymousClass2.invoke$lambda$12$lambda$11$lambda$10$lambda$9(productListViewModel, product);
                        }
                    };
                    $composer.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv2;
                }
                $composer.endReplaceGroup();
                ButtonKt.OutlinedButton((Function0) value$iv2, RowScope.weight$default($this$invoke_u24lambda_u2412_u24lambda_u2411, Modifier.INSTANCE, 1.0f, false, 2, null), false, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-627939892, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.detail.ProductDetailScreenKt$ProductDetailScreen$2$1$4$4
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                        invoke(rowScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope OutlinedButton, Composer $composer2, int $changed2) {
                        Intrinsics.checkNotNullParameter(OutlinedButton, "$this$OutlinedButton");
                        ComposerKt.sourceInformation($composer2, "C146@6185L329,152@6535L27,153@6583L48:ProductDetailScreen.kt#scc5s3");
                        if (($changed2 & 17) != 16 || !$composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-627939892, $changed2, -1, "com.easycompra.app.ui.detail.ProductDetailScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ProductDetailScreen.kt:146)");
                            }
                            ImageVector favorite = z2 ? FavoriteKt.getFavorite(Icons.INSTANCE.getDefault()) : FavoriteBorderKt.getFavoriteBorder(Icons.INSTANCE.getDefault());
                            Modifier modifierM726size3ABfNKs = SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(18));
                            $composer2.startReplaceGroup(1149474519);
                            ComposerKt.sourceInformation($composer2, "150@6473L11");
                            long jM4215getRed0d7_KjU = z2 ? Color.INSTANCE.m4215getRed0d7_KjU() : MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getPrimary();
                            $composer2.endReplaceGroup();
                            IconKt.m2171Iconww6aTOc(favorite, (String) null, modifierM726size3ABfNKs, jM4215getRed0d7_KjU, $composer2, 432, 0);
                            SpacerKt.Spacer(SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(6)), $composer2, 6);
                            TextKt.m2714Text4IGK_g(z2 ? "Guardado" : "Favorito", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 0, 0, 131070);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer2.skipToGroupEnd();
                    }
                }, $composer, 54), $composer, 805306368, 508);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ProductDetailScreenKt.NutritionTable(product, $composer, 0);
                $composer.startReplaceGroup(989411528);
                ComposerKt.sourceInformation($composer, "160@6806L133,160@6774L165");
                String ingredients = product.getIngredients();
                if (!(ingredients == null || StringsKt.isBlank(ingredients))) {
                    ProductDetailScreenKt.Section("Ingredientes", ComposableLambdaKt.rememberComposableLambda(1614741426, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.detail.ProductDetailScreenKt$ProductDetailScreen$2$1$5
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer2, int $changed2) {
                            ComposerKt.sourceInformation($composer2, "C161@6876L10,161@6828L93:ProductDetailScreen.kt#scc5s3");
                            if (($changed2 & 3) == 2 && $composer2.getSkipping()) {
                                $composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1614741426, $changed2, -1, "com.easycompra.app.ui.detail.ProductDetailScreen.<anonymous>.<anonymous>.<anonymous> (ProductDetailScreen.kt:161)");
                            }
                            TextKt.m2714Text4IGK_g(product.getIngredients(), (Modifier) null, Color.INSTANCE.m4210getDarkGray0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getBodySmall(), $composer2, 384, 0, 65530);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer, 54), $composer, 54);
                }
                $composer.endReplaceGroup();
                $composer.startReplaceGroup(989419585);
                ComposerKt.sourceInformation($composer, "165@7053L131,165@7024L160");
                String allergens = product.getAllergens();
                if (!(allergens == null || StringsKt.isBlank(allergens))) {
                    ProductDetailScreenKt.Section("Alérgenos", ComposableLambdaKt.rememberComposableLambda(-527555671, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.detail.ProductDetailScreenKt$ProductDetailScreen$2$1$6
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer2, int $changed2) {
                            ComposerKt.sourceInformation($composer2, "C166@7121L10,166@7075L91:ProductDetailScreen.kt#scc5s3");
                            if (($changed2 & 3) == 2 && $composer2.getSkipping()) {
                                $composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-527555671, $changed2, -1, "com.easycompra.app.ui.detail.ProductDetailScreen.<anonymous>.<anonymous>.<anonymous> (ProductDetailScreen.kt:166)");
                            }
                            TextKt.m2714Text4IGK_g(product.getAllergens(), (Modifier) null, Color.INSTANCE.m4210getDarkGray0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer2, MaterialTheme.$stable).getBodySmall(), $composer2, 384, 0, 65530);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer, 54), $composer, 54);
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
        public static final Unit invoke$lambda$12$lambda$11$lambda$8$lambda$7(ProductListViewModel $viewModel, Product $product) {
            $viewModel.addToShoppingList($product);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$12$lambda$11$lambda$10$lambda$9(ProductListViewModel $viewModel, Product $product) {
            $viewModel.toggleFavorite($product);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NutritionTable(final Product product, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-1883157320);
        ComposerKt.sourceInformation($composer2, "C(NutritionTable)175@7336L1203,175@7281L1258:ProductDetailScreen.kt#scc5s3");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(product) ? 4 : 2;
        }
        if (($dirty & 3) != 2 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1883157320, $dirty, -1, "com.easycompra.app.ui.detail.NutritionTable (ProductDetailScreen.kt:174)");
            }
            Section("Información nutricional (por 100 g)", ComposableLambdaKt.rememberComposableLambda(2104146431, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.detail.ProductDetailScreenKt.NutritionTable.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    String str;
                    String str2;
                    String str3;
                    String str4;
                    String str5;
                    String str6;
                    String str7;
                    Function0<ComposeUiNode> function0;
                    ComposerKt.sourceInformation($composer3, "C*186@8007L441,197@8461L62:ProductDetailScreen.kt#scc5s3");
                    if (($changed2 & 3) == 2 && $composer3.getSkipping()) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2104146431, $changed2, -1, "com.easycompra.app.ui.detail.NutritionTable.<anonymous> (ProductDetailScreen.kt:176)");
                    }
                    Pair[] pairArr = new Pair[7];
                    Double energyKcal100g = product.getEnergyKcal100g();
                    Object obj = null;
                    int i = 1;
                    if (energyKcal100g != null) {
                        double it = energyKcal100g.doubleValue();
                        str = String.format("%.0f kcal", Arrays.copyOf(new Object[]{Double.valueOf(it)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    } else {
                        str = null;
                    }
                    int i2 = 0;
                    pairArr[0] = TuplesKt.to("Energía", str);
                    Double fat100g = product.getFat100g();
                    if (fat100g != null) {
                        double it2 = fat100g.doubleValue();
                        str2 = String.format("%.1f g", Arrays.copyOf(new Object[]{Double.valueOf(it2)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    } else {
                        str2 = null;
                    }
                    pairArr[1] = TuplesKt.to("Grasas", str2);
                    Double saturatedFat100g = product.getSaturatedFat100g();
                    if (saturatedFat100g != null) {
                        double it3 = saturatedFat100g.doubleValue();
                        str3 = String.format("%.1f g", Arrays.copyOf(new Object[]{Double.valueOf(it3)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    } else {
                        str3 = null;
                    }
                    pairArr[2] = TuplesKt.to("  de las cuales saturadas", str3);
                    Double carbohydrates100g = product.getCarbohydrates100g();
                    if (carbohydrates100g != null) {
                        double it4 = carbohydrates100g.doubleValue();
                        str4 = String.format("%.1f g", Arrays.copyOf(new Object[]{Double.valueOf(it4)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    } else {
                        str4 = null;
                    }
                    pairArr[3] = TuplesKt.to("Hidratos de carbono", str4);
                    Double sugars100g = product.getSugars100g();
                    if (sugars100g != null) {
                        double it5 = sugars100g.doubleValue();
                        str5 = String.format("%.1f g", Arrays.copyOf(new Object[]{Double.valueOf(it5)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                    } else {
                        str5 = null;
                    }
                    pairArr[4] = TuplesKt.to("  de los cuales azúcares", str5);
                    Double proteins100g = product.getProteins100g();
                    if (proteins100g != null) {
                        double it6 = proteins100g.doubleValue();
                        str6 = String.format("%.1f g", Arrays.copyOf(new Object[]{Double.valueOf(it6)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                    } else {
                        str6 = null;
                    }
                    pairArr[5] = TuplesKt.to("Proteínas", str6);
                    Double salt100g = product.getSalt100g();
                    if (salt100g != null) {
                        double it7 = salt100g.doubleValue();
                        str7 = String.format("%.2f g", Arrays.copyOf(new Object[]{Double.valueOf(it7)}, 1));
                        Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                    } else {
                        str7 = null;
                    }
                    pairArr[6] = TuplesKt.to("Sal", str7);
                    Iterable rows = CollectionsKt.listOf((Object[]) pairArr);
                    Iterable $this$forEach$iv = rows;
                    for (Object element$iv : $this$forEach$iv) {
                        Pair pair = (Pair) element$iv;
                        String label = (String) pair.component1();
                        String value = (String) pair.component2();
                        Modifier modifier$iv = PaddingKt.m683paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, i, obj), 0.0f, Dp.m6663constructorimpl(4), i, obj);
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
                        ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                        int $changed$iv$iv = (54 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, i2);
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
                        int i3 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        int i4 = ((54 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -674265977, "C190@8220L10,190@8186L56,193@8341L10,191@8259L175:ProductDetailScreen.kt#scc5s3");
                        TextKt.m2714Text4IGK_g(label, (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, 0, 0, 65534);
                        TextKt.m2714Text4IGK_g(value == null ? "–" : value, (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getBodyMedium(), $composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 65502);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        DividerKt.m2093HorizontalDivider9IZ8Weo(null, Dp.m6663constructorimpl((float) 0.5d), Color.INSTANCE.m4213getLightGray0d7_KjU(), $composer3, 432, 1);
                        obj = null;
                        i = 1;
                        i2 = 0;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), $composer2, 54);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.detail.ProductDetailScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProductDetailScreenKt.NutritionTable$lambda$2(product, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Section(final String title, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-1597667250);
        ComposerKt.sourceInformation($composer3, "C(Section)P(1)206@8709L40,207@8784L19,208@8810L354,204@8629L535:ProductDetailScreen.kt#scc5s3");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(title) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 19) != 18 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1597667250, $dirty2, -1, "com.easycompra.app.ui.detail.Section (ProductDetailScreen.kt:203)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            CardColors cardColorsM1850cardColorsro_MJ88 = CardDefaults.INSTANCE.m1850cardColorsro_MJ88(Color.INSTANCE.m4218getWhite0d7_KjU(), 0L, 0L, 0L, $composer3, (CardDefaults.$stable << 12) | 6, 14);
            CardDefaults cardDefaults = CardDefaults.INSTANCE;
            float fM6663constructorimpl = Dp.m6663constructorimpl(1);
            int $i$f$getDp = CardDefaults.$stable;
            $composer2 = $composer3;
            CardKt.Card(modifierFillMaxWidth$default, null, cardColorsM1850cardColorsro_MJ88, cardDefaults.m1851cardElevationaqJV_2Y(fM6663constructorimpl, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer3, ($i$f$getDp << 18) | 6, 62), null, ComposableLambdaKt.rememberComposableLambda(-348806500, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.detail.ProductDetailScreenKt.Section.1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                    invoke(columnScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope Card, Composer $composer4, int $changed2) {
                    Intrinsics.checkNotNullParameter(Card, "$this$Card");
                    ComposerKt.sourceInformation($composer4, "C209@8820L338:ProductDetailScreen.kt#scc5s3");
                    if (($changed2 & 17) != 16 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-348806500, $changed2, -1, "com.easycompra.app.ui.detail.Section.<anonymous> (ProductDetailScreen.kt:209)");
                        }
                        Modifier modifier$iv = PaddingKt.m681padding3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(12));
                        String str = title;
                        Function2<Composer, Integer, Unit> function3 = function2;
                        ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                        int $changed$iv$iv = (6 << 3) & 112;
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
                        ComposerKt.sourceInformationMarkerStart($composer4, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i2 = ((6 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, 416145250, "C212@8944L10,214@9051L11,210@8877L207,216@9097L29,217@9139L9:ProductDetailScreen.kt#scc5s3");
                        TextStyle titleSmall = MaterialTheme.INSTANCE.getTypography($composer4, MaterialTheme.$stable).getTitleSmall();
                        FontWeight bold = FontWeight.INSTANCE.getBold();
                        MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                        int $changed$iv = MaterialTheme.$stable;
                        TextKt.m2714Text4IGK_g(str, (Modifier) null, materialTheme.getColorScheme($composer4, $changed$iv).getPrimary(), 0L, (FontStyle) null, bold, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, titleSmall, $composer4, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 65498);
                        SpacerKt.Spacer(SizeKt.m712height3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(8)), $composer4, 6);
                        function3.invoke($composer4, 0);
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
            }, $composer2, 54), $composer2, 196614, 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.detail.ProductDetailScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProductDetailScreenKt.Section$lambda$3(title, function2, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
