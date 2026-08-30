package com.easycompra.app;

import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.BadgeKt;
import androidx.compose.material3.NavigationBarKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.core.view.PointerIconCompat;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.Navigator;
import androidx.navigation.PopUpToBuilder;
import androidx.navigation.compose.NavGraphBuilderKt;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.navigation.compose.NavHostKt;
import androidx.profileinstaller.ProfileVerifier;
import com.easycompra.app.ui.list.ProductListUiState;
import com.easycompra.app.ui.list.ProductListViewModel;
import com.easycompra.app.ui.pantry.PantryScreenKt;
import com.easycompra.app.ui.pantry.PantryUiState;
import com.easycompra.app.ui.pantry.PantryViewModel;
import com.easycompra.app.ui.planner.PlannerScreenKt;
import com.easycompra.app.ui.planner.PlannerViewModel;
import com.easycompra.app.ui.recipes.RecipeUiState;
import com.easycompra.app.ui.recipes.RecipeViewModel;
import com.easycompra.app.ui.theme.ThemeKt;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001d²\u0006\n\u0010\u001e\u001a\u00020\u001fX\u008a\u0084\u0002²\u0006\n\u0010 \u001a\u00020!X\u008a\u0084\u0002²\u0006\n\u0010\"\u001a\u00020#X\u008a\u0084\u0002"}, d2 = {"Lcom/easycompra/app/MainActivity;", "Landroidx/activity/ComponentActivity;", "<init>", "()V", "viewModel", "Lcom/easycompra/app/ui/list/ProductListViewModel;", "getViewModel", "()Lcom/easycompra/app/ui/list/ProductListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "pantryViewModel", "Lcom/easycompra/app/ui/pantry/PantryViewModel;", "getPantryViewModel", "()Lcom/easycompra/app/ui/pantry/PantryViewModel;", "pantryViewModel$delegate", "recipeViewModel", "Lcom/easycompra/app/ui/recipes/RecipeViewModel;", "getRecipeViewModel", "()Lcom/easycompra/app/ui/recipes/RecipeViewModel;", "recipeViewModel$delegate", "plannerViewModel", "Lcom/easycompra/app/ui/planner/PlannerViewModel;", "getPlannerViewModel", "()Lcom/easycompra/app/ui/planner/PlannerViewModel;", "plannerViewModel$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_debug", "state", "Lcom/easycompra/app/ui/list/ProductListUiState;", "pantryState", "Lcom/easycompra/app/ui/pantry/PantryUiState;", "recipeState", "Lcom/easycompra/app/ui/recipes/RecipeUiState;"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MainActivity extends ComponentActivity {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: pantryViewModel$delegate, reason: from kotlin metadata */
    private final Lazy pantryViewModel;

    /* JADX INFO: renamed from: plannerViewModel$delegate, reason: from kotlin metadata */
    private final Lazy plannerViewModel;

    /* JADX INFO: renamed from: recipeViewModel$delegate, reason: from kotlin metadata */
    private final Lazy recipeViewModel;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public MainActivity() {
        final MainActivity $this$viewModels_u24default$iv = this;
        final Function0 extrasProducer$iv = null;
        this.viewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ProductListViewModel.class), new Function0<ViewModelStore>() { // from class: com.easycompra.app.MainActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return $this$viewModels_u24default$iv.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.easycompra.app.MainActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return $this$viewModels_u24default$iv.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.easycompra.app.MainActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function0 = extrasProducer$iv;
                return (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) ? $this$viewModels_u24default$iv.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        final MainActivity $this$viewModels_u24default$iv2 = this;
        final Function0 extrasProducer$iv2 = null;
        this.pantryViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(PantryViewModel.class), new Function0<ViewModelStore>() { // from class: com.easycompra.app.MainActivity$special$$inlined$viewModels$default$5
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return $this$viewModels_u24default$iv2.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.easycompra.app.MainActivity$special$$inlined$viewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return $this$viewModels_u24default$iv2.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.easycompra.app.MainActivity$special$$inlined$viewModels$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function0 = extrasProducer$iv2;
                return (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) ? $this$viewModels_u24default$iv2.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        final MainActivity $this$viewModels_u24default$iv3 = this;
        final Function0 extrasProducer$iv3 = null;
        this.recipeViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(RecipeViewModel.class), new Function0<ViewModelStore>() { // from class: com.easycompra.app.MainActivity$special$$inlined$viewModels$default$8
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return $this$viewModels_u24default$iv3.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.easycompra.app.MainActivity$special$$inlined$viewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return $this$viewModels_u24default$iv3.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.easycompra.app.MainActivity$special$$inlined$viewModels$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function0 = extrasProducer$iv3;
                return (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) ? $this$viewModels_u24default$iv3.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        final MainActivity $this$viewModels_u24default$iv4 = this;
        final Function0 extrasProducer$iv4 = null;
        this.plannerViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(PlannerViewModel.class), new Function0<ViewModelStore>() { // from class: com.easycompra.app.MainActivity$special$$inlined$viewModels$default$11
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return $this$viewModels_u24default$iv4.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.easycompra.app.MainActivity$special$$inlined$viewModels$default$10
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return $this$viewModels_u24default$iv4.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.easycompra.app.MainActivity$special$$inlined$viewModels$default$12
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function0 = extrasProducer$iv4;
                return (function0 == null || (creationExtras = (CreationExtras) function0.invoke()) == null) ? $this$viewModels_u24default$iv4.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProductListViewModel getViewModel() {
        return (ProductListViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PantryViewModel getPantryViewModel() {
        return (PantryViewModel) this.pantryViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecipeViewModel getRecipeViewModel() {
        return (RecipeViewModel) this.recipeViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PlannerViewModel getPlannerViewModel() {
        return (PlannerViewModel) this.plannerViewModel.getValue();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(-1412942238, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.MainActivity.onCreate.1

            /* JADX INFO: renamed from: com.easycompra.app.MainActivity$onCreate$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: MainActivity.kt */
            @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
            static final class C01571 implements Function2<Composer, Integer, Unit> {
                final /* synthetic */ MainActivity this$0;

                C01571(MainActivity mainActivity) {
                    this.this$0 = mainActivity;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer, int $changed) {
                    NavDestination destination;
                    ComposerKt.sourceInformation($composer, "C52@2421L23,53@2492L16,54@2568L16,55@2642L16,56@2708L30,61@2918L4916,146@7853L3106,60@2876L8083:MainActivity.kt#t7ni9s");
                    if (($changed & 3) != 2 || !$composer.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2004897216, $changed, -1, "com.easycompra.app.MainActivity.onCreate.<anonymous>.<anonymous> (MainActivity.kt:52)");
                        }
                        final NavHostController navController = NavHostControllerKt.rememberNavController(new Navigator[0], $composer, 0);
                        final State state$delegate = SnapshotStateKt.collectAsState(this.this$0.getViewModel().getUiState(), null, $composer, 0, 1);
                        final State pantryState$delegate = SnapshotStateKt.collectAsState(this.this$0.getPantryViewModel().getUiState(), null, $composer, 0, 1);
                        final State recipeState$delegate = SnapshotStateKt.collectAsState(this.this$0.getRecipeViewModel().getState(), null, $composer, 0, 1);
                        NavBackStackEntry value = NavHostControllerKt.currentBackStackEntryAsState(navController, $composer, 0).getValue();
                        final String currentRoute = (value == null || (destination = value.getDestination()) == null) ? null : destination.getRoute();
                        final Set bottomRoutes = SetsKt.setOf((Object[]) new String[]{"list", "shopping", "pantry", "recipes", "planner"});
                        ScaffoldKt.m2429ScaffoldTvnljyQ(null, null, ComposableLambdaKt.rememberComposableLambda(-585320741, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.MainActivity.onCreate.1.1.1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: com.easycompra.app.MainActivity$onCreate$1$1$1$1, reason: invalid class name and collision with other inner class name */
                            /* JADX INFO: compiled from: MainActivity.kt */
                            @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                            static final class C01591 implements Function3<RowScope, Composer, Integer, Unit> {
                                final /* synthetic */ String $currentRoute;
                                final /* synthetic */ NavHostController $navController;
                                final /* synthetic */ State<PantryUiState> $pantryState$delegate;
                                final /* synthetic */ State<RecipeUiState> $recipeState$delegate;
                                final /* synthetic */ State<ProductListUiState> $state$delegate;

                                C01591(String str, NavHostController navHostController, State<ProductListUiState> state, State<PantryUiState> state2, State<RecipeUiState> state3) {
                                    this.$currentRoute = str;
                                    this.$navController = navHostController;
                                    this.$state$delegate = state;
                                    this.$pantryState$delegate = state2;
                                    this.$recipeState$delegate = state3;
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                                    invoke(rowScope, composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(RowScope NavigationBar, Composer $composer, int $changed) {
                                    Object value$iv;
                                    Object value$iv2;
                                    Object value$iv3;
                                    Object value$iv4;
                                    Object value$iv5;
                                    Intrinsics.checkNotNullParameter(NavigationBar, "$this$NavigationBar");
                                    ComposerKt.sourceInformation($composer, "C66@3192L359,64@3056L696,78@3925L346,85@4316L452,76@3785L1083,97@5039L342,104@5426L453,95@4901L1078,116@6151L344,123@6540L486,114@6012L1113,135@7297L252,133@7158L598:MainActivity.kt#t7ni9s");
                                    int $dirty = $changed;
                                    if (($changed & 6) == 0) {
                                        $dirty |= $composer.changed(NavigationBar) ? 4 : 2;
                                    }
                                    int $dirty2 = $dirty;
                                    if (($dirty2 & 19) != 18 || !$composer.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1840931417, $dirty2, -1, "com.easycompra.app.MainActivity.onCreate.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:64)");
                                        }
                                        boolean zAreEqual = Intrinsics.areEqual(this.$currentRoute, "list");
                                        $composer.startReplaceGroup(-1125443242);
                                        ComposerKt.sourceInformation($composer, "CC(remember):MainActivity.kt#9igjgp");
                                        boolean invalid$iv = $composer.changed(this.$currentRoute) | $composer.changedInstance(this.$navController);
                                        final String str = this.$currentRoute;
                                        final NavHostController navHostController = this.$navController;
                                        Object it$iv = $composer.rememberedValue();
                                        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                                            value$iv = new Function0() { // from class: com.easycompra.app.MainActivity$onCreate$1$1$1$1$$ExternalSyntheticLambda0
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Object invoke() {
                                                    return MainActivity.AnonymousClass1.C01571.C01581.C01591.invoke$lambda$3$lambda$2(str, navHostController);
                                                }
                                            };
                                            $composer.updateRememberedValue(value$iv);
                                        } else {
                                            value$iv = it$iv;
                                        }
                                        $composer.endReplaceGroup();
                                        NavigationBarKt.NavigationBarItem(NavigationBar, zAreEqual, (Function0) value$iv, ComposableSingletons$MainActivityKt.INSTANCE.m7037getLambda1$app_debug(), null, false, ComposableSingletons$MainActivityKt.INSTANCE.m7039getLambda2$app_debug(), false, null, null, $composer, ($dirty2 & 14) | 1575936, 472);
                                        boolean zAreEqual2 = Intrinsics.areEqual(this.$currentRoute, "shopping");
                                        $composer.startReplaceGroup(-1125419799);
                                        ComposerKt.sourceInformation($composer, "CC(remember):MainActivity.kt#9igjgp");
                                        boolean invalid$iv2 = $composer.changed(this.$currentRoute) | $composer.changedInstance(this.$navController);
                                        final String str2 = this.$currentRoute;
                                        final NavHostController navHostController2 = this.$navController;
                                        Object it$iv2 = $composer.rememberedValue();
                                        if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                            value$iv2 = new Function0() { // from class: com.easycompra.app.MainActivity$onCreate$1$1$1$1$$ExternalSyntheticLambda2
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Object invoke() {
                                                    return MainActivity.AnonymousClass1.C01571.C01581.C01591.invoke$lambda$6$lambda$5(str2, navHostController2);
                                                }
                                            };
                                            $composer.updateRememberedValue(value$iv2);
                                        } else {
                                            value$iv2 = it$iv2;
                                        }
                                        $composer.endReplaceGroup();
                                        final State<ProductListUiState> state = this.$state$delegate;
                                        NavigationBarKt.NavigationBarItem(NavigationBar, zAreEqual2, (Function0) value$iv2, ComposableLambdaKt.rememberComposableLambda(1977130237, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.MainActivity.onCreate.1.1.1.1.3
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                                invoke(composer, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer $composer2, int $changed2) {
                                                ComposerKt.sourceInformation($composer2, "C86@4376L205,86@4358L372:MainActivity.kt#t7ni9s");
                                                if (($changed2 & 3) != 2 || !$composer2.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1977130237, $changed2, -1, "com.easycompra.app.MainActivity.onCreate.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:86)");
                                                    }
                                                    final State<ProductListUiState> state2 = state;
                                                    BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(1210213765, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.MainActivity.onCreate.1.1.1.1.3.1
                                                        @Override // kotlin.jvm.functions.Function3
                                                        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer, Integer num) {
                                                            invoke(boxScope, composer, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(BoxScope BadgedBox, Composer $composer3, int $changed3) {
                                                            Intrinsics.checkNotNullParameter(BadgedBox, "$this$BadgedBox");
                                                            ComposerKt.sourceInformation($composer3, "C88@4505L34,88@4499L40:MainActivity.kt#t7ni9s");
                                                            if (($changed3 & 17) != 16 || !$composer3.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(1210213765, $changed3, -1, "com.easycompra.app.MainActivity.onCreate.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:87)");
                                                                }
                                                                if (C01571.invoke$lambda$0(state2).getShoppingCount() > 0) {
                                                                    final State<ProductListUiState> state3 = state2;
                                                                    BadgeKt.m1810BadgeeopBjH0(null, 0L, 0L, ComposableLambdaKt.rememberComposableLambda(1696825037, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.MainActivity.onCreate.1.1.1.1.3.1.1
                                                                        @Override // kotlin.jvm.functions.Function3
                                                                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                                                                            invoke(rowScope, composer, num.intValue());
                                                                            return Unit.INSTANCE;
                                                                        }

                                                                        public final void invoke(RowScope Badge, Composer $composer4, int $changed4) {
                                                                            Intrinsics.checkNotNullParameter(Badge, "$this$Badge");
                                                                            ComposerKt.sourceInformation($composer4, "C88@4507L30:MainActivity.kt#t7ni9s");
                                                                            if (($changed4 & 17) == 16 && $composer4.getSkipping()) {
                                                                                $composer4.skipToGroupEnd();
                                                                                return;
                                                                            }
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(1696825037, $changed4, -1, "com.easycompra.app.MainActivity.onCreate.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:88)");
                                                                            }
                                                                            TextKt.m2714Text4IGK_g(String.valueOf(C01571.invoke$lambda$0(state3).getShoppingCount()), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131070);
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                            }
                                                                        }
                                                                    }, $composer3, 54), $composer3, 3072, 7);
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            $composer3.skipToGroupEnd();
                                                        }
                                                    }, $composer2, 54), null, ComposableSingletons$MainActivityKt.INSTANCE.m7040getLambda3$app_debug(), $composer2, 390, 2);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                $composer2.skipToGroupEnd();
                                            }
                                        }, $composer, 54), null, false, ComposableSingletons$MainActivityKt.INSTANCE.m7041getLambda4$app_debug(), false, null, null, $composer, ($dirty2 & 14) | 1575936, 472);
                                        boolean zAreEqual3 = Intrinsics.areEqual(this.$currentRoute, "pantry");
                                        $composer.startReplaceGroup(-1125384155);
                                        ComposerKt.sourceInformation($composer, "CC(remember):MainActivity.kt#9igjgp");
                                        boolean invalid$iv3 = $composer.changed(this.$currentRoute) | $composer.changedInstance(this.$navController);
                                        final String str3 = this.$currentRoute;
                                        final NavHostController navHostController3 = this.$navController;
                                        Object it$iv3 = $composer.rememberedValue();
                                        if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                            value$iv3 = new Function0() { // from class: com.easycompra.app.MainActivity$onCreate$1$1$1$1$$ExternalSyntheticLambda3
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Object invoke() {
                                                    return MainActivity.AnonymousClass1.C01571.C01581.C01591.invoke$lambda$9$lambda$8(str3, navHostController3);
                                                }
                                            };
                                            $composer.updateRememberedValue(value$iv3);
                                        } else {
                                            value$iv3 = it$iv3;
                                        }
                                        $composer.endReplaceGroup();
                                        final State<PantryUiState> state2 = this.$pantryState$delegate;
                                        NavigationBarKt.NavigationBarItem(NavigationBar, zAreEqual3, (Function0) value$iv3, ComposableLambdaKt.rememberComposableLambda(1505132828, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.MainActivity.onCreate.1.1.1.1.5
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                                invoke(composer, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer $composer2, int $changed2) {
                                                ComposerKt.sourceInformation($composer2, "C105@5486L211,105@5468L373:MainActivity.kt#t7ni9s");
                                                if (($changed2 & 3) != 2 || !$composer2.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1505132828, $changed2, -1, "com.easycompra.app.MainActivity.onCreate.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:105)");
                                                    }
                                                    final State<PantryUiState> state3 = state2;
                                                    BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(738216356, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.MainActivity.onCreate.1.1.1.1.5.1
                                                        @Override // kotlin.jvm.functions.Function3
                                                        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer, Integer num) {
                                                            invoke(boxScope, composer, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(BoxScope BadgedBox, Composer $composer3, int $changed3) {
                                                            Intrinsics.checkNotNullParameter(BadgedBox, "$this$BadgedBox");
                                                            ComposerKt.sourceInformation($composer3, "C107@5618L37,107@5612L43:MainActivity.kt#t7ni9s");
                                                            if (($changed3 & 17) != 16 || !$composer3.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(738216356, $changed3, -1, "com.easycompra.app.MainActivity.onCreate.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:106)");
                                                                }
                                                                if (C01571.invoke$lambda$1(state3).getEmptyCount() > 0) {
                                                                    final State<PantryUiState> state4 = state3;
                                                                    BadgeKt.m1810BadgeeopBjH0(null, 0L, 0L, ComposableLambdaKt.rememberComposableLambda(1224827628, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.MainActivity.onCreate.1.1.1.1.5.1.1
                                                                        @Override // kotlin.jvm.functions.Function3
                                                                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                                                                            invoke(rowScope, composer, num.intValue());
                                                                            return Unit.INSTANCE;
                                                                        }

                                                                        public final void invoke(RowScope Badge, Composer $composer4, int $changed4) {
                                                                            Intrinsics.checkNotNullParameter(Badge, "$this$Badge");
                                                                            ComposerKt.sourceInformation($composer4, "C107@5620L33:MainActivity.kt#t7ni9s");
                                                                            if (($changed4 & 17) == 16 && $composer4.getSkipping()) {
                                                                                $composer4.skipToGroupEnd();
                                                                                return;
                                                                            }
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(1224827628, $changed4, -1, "com.easycompra.app.MainActivity.onCreate.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:107)");
                                                                            }
                                                                            TextKt.m2714Text4IGK_g(String.valueOf(C01571.invoke$lambda$1(state4).getEmptyCount()), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131070);
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                            }
                                                                        }
                                                                    }, $composer3, 54), $composer3, 3072, 7);
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            $composer3.skipToGroupEnd();
                                                        }
                                                    }, $composer2, 54), null, ComposableSingletons$MainActivityKt.INSTANCE.m7042getLambda5$app_debug(), $composer2, 390, 2);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                $composer2.skipToGroupEnd();
                                            }
                                        }, $composer, 54), null, false, ComposableSingletons$MainActivityKt.INSTANCE.m7043getLambda6$app_debug(), false, null, null, $composer, ($dirty2 & 14) | 1575936, 472);
                                        boolean zAreEqual4 = Intrinsics.areEqual(this.$currentRoute, "recipes");
                                        $composer.startReplaceGroup(-1125348569);
                                        ComposerKt.sourceInformation($composer, "CC(remember):MainActivity.kt#9igjgp");
                                        boolean invalid$iv4 = $composer.changed(this.$currentRoute) | $composer.changedInstance(this.$navController);
                                        final String str4 = this.$currentRoute;
                                        final NavHostController navHostController4 = this.$navController;
                                        Object it$iv4 = $composer.rememberedValue();
                                        if (invalid$iv4 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                                            value$iv4 = new Function0() { // from class: com.easycompra.app.MainActivity$onCreate$1$1$1$1$$ExternalSyntheticLambda4
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Object invoke() {
                                                    return MainActivity.AnonymousClass1.C01571.C01581.C01591.invoke$lambda$12$lambda$11(str4, navHostController4);
                                                }
                                            };
                                            $composer.updateRememberedValue(value$iv4);
                                        } else {
                                            value$iv4 = it$iv4;
                                        }
                                        $composer.endReplaceGroup();
                                        final State<RecipeUiState> state3 = this.$recipeState$delegate;
                                        NavigationBarKt.NavigationBarItem(NavigationBar, zAreEqual4, (Function0) value$iv4, ComposableLambdaKt.rememberComposableLambda(1033135419, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.MainActivity.onCreate.1.1.1.1.7
                                            @Override // kotlin.jvm.functions.Function2
                                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                                invoke(composer, num.intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer $composer2, int $changed2) {
                                                ComposerKt.sourceInformation($composer2, "C124@6600L243,124@6582L406:MainActivity.kt#t7ni9s");
                                                if (($changed2 & 3) != 2 || !$composer2.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1033135419, $changed2, -1, "com.easycompra.app.MainActivity.onCreate.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:124)");
                                                    }
                                                    final State<RecipeUiState> state4 = state3;
                                                    BadgeKt.BadgedBox(ComposableLambdaKt.rememberComposableLambda(266218947, true, new Function3<BoxScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.MainActivity.onCreate.1.1.1.1.7.1
                                                        @Override // kotlin.jvm.functions.Function3
                                                        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Composer composer, Integer num) {
                                                            invoke(boxScope, composer, num.intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(BoxScope BadgedBox, Composer $composer3, int $changed3) {
                                                            Intrinsics.checkNotNullParameter(BadgedBox, "$this$BadgedBox");
                                                            ComposerKt.sourceInformation($composer3, "C126@6750L51,126@6744L57:MainActivity.kt#t7ni9s");
                                                            if (($changed3 & 17) != 16 || !$composer3.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(266218947, $changed3, -1, "com.easycompra.app.MainActivity.onCreate.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:125)");
                                                                }
                                                                if (!C01571.invoke$lambda$2(state4).getRecipeShoppingItems().isEmpty()) {
                                                                    final State<RecipeUiState> state5 = state4;
                                                                    BadgeKt.m1810BadgeeopBjH0(null, 0L, 0L, ComposableLambdaKt.rememberComposableLambda(752830219, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.MainActivity.onCreate.1.1.1.1.7.1.1
                                                                        @Override // kotlin.jvm.functions.Function3
                                                                        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                                                                            invoke(rowScope, composer, num.intValue());
                                                                            return Unit.INSTANCE;
                                                                        }

                                                                        public final void invoke(RowScope Badge, Composer $composer4, int $changed4) {
                                                                            Intrinsics.checkNotNullParameter(Badge, "$this$Badge");
                                                                            ComposerKt.sourceInformation($composer4, "C126@6752L47:MainActivity.kt#t7ni9s");
                                                                            if (($changed4 & 17) == 16 && $composer4.getSkipping()) {
                                                                                $composer4.skipToGroupEnd();
                                                                                return;
                                                                            }
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventStart(752830219, $changed4, -1, "com.easycompra.app.MainActivity.onCreate.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:126)");
                                                                            }
                                                                            TextKt.m2714Text4IGK_g(String.valueOf(C01571.invoke$lambda$2(state5).getRecipeShoppingItems().size()), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131070);
                                                                            if (ComposerKt.isTraceInProgress()) {
                                                                                ComposerKt.traceEventEnd();
                                                                            }
                                                                        }
                                                                    }, $composer3, 54), $composer3, 3072, 7);
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            $composer3.skipToGroupEnd();
                                                        }
                                                    }, $composer2, 54), null, ComposableSingletons$MainActivityKt.INSTANCE.m7044getLambda7$app_debug(), $composer2, 390, 2);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                $composer2.skipToGroupEnd();
                                            }
                                        }, $composer, 54), null, false, ComposableSingletons$MainActivityKt.INSTANCE.m7045getLambda8$app_debug(), false, null, null, $composer, ($dirty2 & 14) | 1575936, 472);
                                        boolean zAreEqual5 = Intrinsics.areEqual(this.$currentRoute, "planner");
                                        $composer.startReplaceGroup(-1125311989);
                                        ComposerKt.sourceInformation($composer, "CC(remember):MainActivity.kt#9igjgp");
                                        boolean invalid$iv5 = $composer.changed(this.$currentRoute) | $composer.changedInstance(this.$navController);
                                        final String str5 = this.$currentRoute;
                                        final NavHostController navHostController5 = this.$navController;
                                        Object it$iv5 = $composer.rememberedValue();
                                        if (invalid$iv5 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                                            value$iv5 = new Function0() { // from class: com.easycompra.app.MainActivity$onCreate$1$1$1$1$$ExternalSyntheticLambda5
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Object invoke() {
                                                    return MainActivity.AnonymousClass1.C01571.C01581.C01591.invoke$lambda$15$lambda$14(str5, navHostController5);
                                                }
                                            };
                                            $composer.updateRememberedValue(value$iv5);
                                        } else {
                                            value$iv5 = it$iv5;
                                        }
                                        $composer.endReplaceGroup();
                                        NavigationBarKt.NavigationBarItem(NavigationBar, zAreEqual5, (Function0) value$iv5, ComposableSingletons$MainActivityKt.INSTANCE.m7046getLambda9$app_debug(), null, false, ComposableSingletons$MainActivityKt.INSTANCE.m7038getLambda10$app_debug(), false, null, null, $composer, ($dirty2 & 14) | 1575936, 472);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer.skipToGroupEnd();
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public static final Unit invoke$lambda$3$lambda$2(String $currentRoute, NavHostController $navController) {
                                    if (!Intrinsics.areEqual($currentRoute, "list")) {
                                        $navController.navigate("list", new Function1() { // from class: com.easycompra.app.MainActivity$onCreate$1$1$1$1$$ExternalSyntheticLambda1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return MainActivity.AnonymousClass1.C01571.C01581.C01591.invoke$lambda$3$lambda$2$lambda$1((NavOptionsBuilder) obj);
                                            }
                                        });
                                    }
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public static final Unit invoke$lambda$3$lambda$2$lambda$1(NavOptionsBuilder navigate) {
                                    Intrinsics.checkNotNullParameter(navigate, "$this$navigate");
                                    navigate.popUpTo("list", new Function1() { // from class: com.easycompra.app.MainActivity$onCreate$1$1$1$1$$ExternalSyntheticLambda10
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return MainActivity.AnonymousClass1.C01571.C01581.C01591.invoke$lambda$3$lambda$2$lambda$1$lambda$0((PopUpToBuilder) obj);
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public static final Unit invoke$lambda$3$lambda$2$lambda$1$lambda$0(PopUpToBuilder popUpTo) {
                                    Intrinsics.checkNotNullParameter(popUpTo, "$this$popUpTo");
                                    popUpTo.setInclusive(true);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public static final Unit invoke$lambda$6$lambda$5(String $currentRoute, NavHostController $navController) {
                                    if (!Intrinsics.areEqual($currentRoute, "shopping")) {
                                        $navController.navigate("shopping", new Function1() { // from class: com.easycompra.app.MainActivity$onCreate$1$1$1$1$$ExternalSyntheticLambda7
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return MainActivity.AnonymousClass1.C01571.C01581.C01591.invoke$lambda$6$lambda$5$lambda$4((NavOptionsBuilder) obj);
                                            }
                                        });
                                    }
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public static final Unit invoke$lambda$6$lambda$5$lambda$4(NavOptionsBuilder navigate) {
                                    Intrinsics.checkNotNullParameter(navigate, "$this$navigate");
                                    NavOptionsBuilder.popUpTo$default(navigate, "list", (Function1) null, 2, (Object) null);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public static final Unit invoke$lambda$9$lambda$8(String $currentRoute, NavHostController $navController) {
                                    if (!Intrinsics.areEqual($currentRoute, "pantry")) {
                                        $navController.navigate("pantry", new Function1() { // from class: com.easycompra.app.MainActivity$onCreate$1$1$1$1$$ExternalSyntheticLambda6
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return MainActivity.AnonymousClass1.C01571.C01581.C01591.invoke$lambda$9$lambda$8$lambda$7((NavOptionsBuilder) obj);
                                            }
                                        });
                                    }
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public static final Unit invoke$lambda$9$lambda$8$lambda$7(NavOptionsBuilder navigate) {
                                    Intrinsics.checkNotNullParameter(navigate, "$this$navigate");
                                    NavOptionsBuilder.popUpTo$default(navigate, "list", (Function1) null, 2, (Object) null);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public static final Unit invoke$lambda$12$lambda$11(String $currentRoute, NavHostController $navController) {
                                    if (!Intrinsics.areEqual($currentRoute, "recipes")) {
                                        $navController.navigate("recipes", new Function1() { // from class: com.easycompra.app.MainActivity$onCreate$1$1$1$1$$ExternalSyntheticLambda8
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return MainActivity.AnonymousClass1.C01571.C01581.C01591.invoke$lambda$12$lambda$11$lambda$10((NavOptionsBuilder) obj);
                                            }
                                        });
                                    }
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public static final Unit invoke$lambda$12$lambda$11$lambda$10(NavOptionsBuilder navigate) {
                                    Intrinsics.checkNotNullParameter(navigate, "$this$navigate");
                                    NavOptionsBuilder.popUpTo$default(navigate, "list", (Function1) null, 2, (Object) null);
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public static final Unit invoke$lambda$15$lambda$14(String $currentRoute, NavHostController $navController) {
                                    if (!Intrinsics.areEqual($currentRoute, "planner")) {
                                        $navController.navigate("planner", new Function1() { // from class: com.easycompra.app.MainActivity$onCreate$1$1$1$1$$ExternalSyntheticLambda9
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return MainActivity.AnonymousClass1.C01571.C01581.C01591.invoke$lambda$15$lambda$14$lambda$13((NavOptionsBuilder) obj);
                                            }
                                        });
                                    }
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: Access modifiers changed from: private */
                                public static final Unit invoke$lambda$15$lambda$14$lambda$13(NavOptionsBuilder navigate) {
                                    Intrinsics.checkNotNullParameter(navigate, "$this$navigate");
                                    NavOptionsBuilder.popUpTo$default(navigate, "list", (Function1) null, 2, (Object) null);
                                    return Unit.INSTANCE;
                                }
                            }

                            public final void invoke(Composer $composer2, int $changed2) {
                                ComposerKt.sourceInformation($composer2, "C63@3022L4764,63@3008L4778:MainActivity.kt#t7ni9s");
                                if (($changed2 & 3) != 2 || !$composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-585320741, $changed2, -1, "com.easycompra.app.MainActivity.onCreate.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:62)");
                                    }
                                    if (CollectionsKt.contains(bottomRoutes, currentRoute)) {
                                        NavigationBarKt.m2294NavigationBarHsRjFd4(null, 0L, 0L, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1840931417, true, new C01591(currentRoute, navController, state$delegate, pantryState$delegate, recipeState$delegate), $composer2, 54), $composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer2.skipToGroupEnd();
                            }
                        }, $composer, 54), null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(2087351761, true, new AnonymousClass2(navController, this.this$0, recipeState$delegate, state$delegate), $composer, 54), $composer, 805306752, 507);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer.skipToGroupEnd();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final ProductListUiState invoke$lambda$0(State<ProductListUiState> state) {
                    Object thisObj$iv = state.getValue();
                    return (ProductListUiState) thisObj$iv;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final PantryUiState invoke$lambda$1(State<PantryUiState> state) {
                    Object thisObj$iv = state.getValue();
                    return (PantryUiState) thisObj$iv;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final RecipeUiState invoke$lambda$2(State<RecipeUiState> state) {
                    Object thisObj$iv = state.getValue();
                    return (RecipeUiState) thisObj$iv;
                }

                /* JADX INFO: renamed from: com.easycompra.app.MainActivity$onCreate$1$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: MainActivity.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                static final class AnonymousClass2 implements Function3<PaddingValues, Composer, Integer, Unit> {
                    final /* synthetic */ NavHostController $navController;
                    final /* synthetic */ State<RecipeUiState> $recipeState$delegate;
                    final /* synthetic */ State<ProductListUiState> $state$delegate;
                    final /* synthetic */ MainActivity this$0;

                    AnonymousClass2(NavHostController navHostController, MainActivity mainActivity, State<RecipeUiState> state, State<ProductListUiState> state2) {
                        this.$navController = navHostController;
                        this.this$0 = mainActivity;
                        this.$recipeState$delegate = state;
                        this.$state$delegate = state2;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer, Integer num) throws Throwable {
                        invoke(paddingValues, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(PaddingValues innerPadding, Composer $composer, int $changed) throws Throwable {
                        Object value$iv;
                        Intrinsics.checkNotNullParameter(innerPadding, "innerPadding");
                        ComposerKt.sourceInformation($composer, "C151@8094L2847,147@7891L3050:MainActivity.kt#t7ni9s");
                        int $dirty = $changed;
                        if (($changed & 6) == 0) {
                            $dirty |= $composer.changed(innerPadding) ? 4 : 2;
                        }
                        int $dirty2 = $dirty;
                        if (($dirty2 & 19) != 18 || !$composer.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2087351761, $dirty2, -1, "com.easycompra.app.MainActivity.onCreate.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:147)");
                            }
                            NavHostController navHostController = this.$navController;
                            Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, innerPadding);
                            $composer.startReplaceGroup(2005085647);
                            ComposerKt.sourceInformation($composer, "CC(remember):MainActivity.kt#9igjgp");
                            boolean invalid$iv = $composer.changedInstance(this.this$0) | $composer.changedInstance(this.$navController) | $composer.changed(this.$recipeState$delegate) | $composer.changed(this.$state$delegate);
                            final MainActivity mainActivity = this.this$0;
                            final NavHostController navHostController2 = this.$navController;
                            final State<RecipeUiState> state = this.$recipeState$delegate;
                            final State<ProductListUiState> state2 = this.$state$delegate;
                            Object it$iv = $composer.rememberedValue();
                            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                                value$iv = new Function1() { // from class: com.easycompra.app.MainActivity$onCreate$1$1$2$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return MainActivity.AnonymousClass1.C01571.AnonymousClass2.invoke$lambda$1$lambda$0(mainActivity, navHostController2, state, state2, (NavGraphBuilder) obj);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv);
                            } else {
                                value$iv = it$iv;
                            }
                            $composer.endReplaceGroup();
                            NavHostKt.NavHost(navHostController, "list", modifierPadding, null, null, null, null, null, null, null, (Function1) value$iv, $composer, 48, 0, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer.skipToGroupEnd();
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$1$lambda$0(final MainActivity this$0, NavHostController $navController, State $recipeState$delegate, State $state$delegate, NavGraphBuilder NavHost) {
                        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
                        NavGraphBuilderKt.composable$default(NavHost, "list", null, null, null, null, null, null, null, ComposableLambdaKt.composableLambdaInstance(2046170804, true, new MainActivity$onCreate$1$1$2$1$1$1(this$0, $navController)), 254, null);
                        NavGraphBuilderKt.composable$default(NavHost, "shopping", null, null, null, null, null, null, null, ComposableLambdaKt.composableLambdaInstance(-2063997205, true, new MainActivity$onCreate$1$1$2$1$1$2(this$0, $navController)), 254, null);
                        NavGraphBuilderKt.composable$default(NavHost, "pantry", null, null, null, null, null, null, null, ComposableLambdaKt.composableLambdaInstance(-921649620, true, new Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.easycompra.app.MainActivity$onCreate$1$1$2$1$1$3
                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                                invoke(animatedContentScope, navBackStackEntry, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(AnimatedContentScope composable, NavBackStackEntry it, Composer $composer, int $changed) {
                                Intrinsics.checkNotNullParameter(composable, "$this$composable");
                                Intrinsics.checkNotNullParameter(it, "it");
                                ComposerKt.sourceInformation($composer, "C173@9184L41:MainActivity.kt#t7ni9s");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-921649620, $changed, -1, "com.easycompra.app.MainActivity.onCreate.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:173)");
                                }
                                PantryScreenKt.PantryScreen(this$0.getPantryViewModel(), $composer, PantryViewModel.$stable);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), 254, null);
                        NavGraphBuilderKt.composable$default(NavHost, "recipes", null, null, null, null, null, null, null, ComposableLambdaKt.composableLambdaInstance(220697965, true, new MainActivity$onCreate$1$1$2$1$1$4(this$0, $navController)), 254, null);
                        NavGraphBuilderKt.composable$default(NavHost, "recipe_detail", null, null, null, null, null, null, null, ComposableLambdaKt.composableLambdaInstance(1363045550, true, new MainActivity$onCreate$1$1$2$1$1$5($recipeState$delegate, this$0, $navController)), 254, null);
                        NavGraphBuilderKt.composable$default(NavHost, "planner", null, null, null, null, null, null, null, ComposableLambdaKt.composableLambdaInstance(-1789574161, true, new Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: com.easycompra.app.MainActivity$onCreate$1$1$2$1$1$6
                            @Override // kotlin.jvm.functions.Function4
                            public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
                                invoke(animatedContentScope, navBackStackEntry, composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(AnimatedContentScope composable, NavBackStackEntry it, Composer $composer, int $changed) {
                                Intrinsics.checkNotNullParameter(composable, "$this$composable");
                                Intrinsics.checkNotNullParameter(it, "it");
                                ComposerKt.sourceInformation($composer, "C197@10400L43:MainActivity.kt#t7ni9s");
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1789574161, $changed, -1, "com.easycompra.app.MainActivity.onCreate.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:197)");
                                }
                                PlannerScreenKt.PlannerScreen(this$0.getPlannerViewModel(), $composer, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }), 254, null);
                        NavGraphBuilderKt.composable$default(NavHost, "detail", null, null, null, null, null, null, null, ComposableLambdaKt.composableLambdaInstance(-647226576, true, new MainActivity$onCreate$1$1$2$1$1$7($state$delegate, this$0, $navController)), 254, null);
                        return Unit.INSTANCE;
                    }
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer $composer, int $changed) {
                ComposerKt.sourceInformation($composer, "C51@2383L8590,51@2367L8606:MainActivity.kt#t7ni9s");
                if (($changed & 3) != 2 || !$composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1412942238, $changed, -1, "com.easycompra.app.MainActivity.onCreate.<anonymous> (MainActivity.kt:51)");
                    }
                    ThemeKt.EasyCompraTheme(ComposableLambdaKt.rememberComposableLambda(2004897216, true, new C01571(MainActivity.this), $composer, 54), $composer, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer.skipToGroupEnd();
            }
        }), 1, null);
    }
}
