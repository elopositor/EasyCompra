package com.easycompra.app;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavHostController;
import com.easycompra.app.data.recipes.RecipeWithDetails;
import com.easycompra.app.ui.recipes.RecipeDetailScreenKt;
import com.easycompra.app.ui.recipes.RecipeUiState;
import com.easycompra.app.ui.recipes.RecipeViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class MainActivity$onCreate$1$1$2$1$1$5 implements Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit> {
    final /* synthetic */ NavHostController $navController;
    final /* synthetic */ State<RecipeUiState> $recipeState$delegate;
    final /* synthetic */ MainActivity this$0;

    MainActivity$onCreate$1$1$2$1$1$5(State<RecipeUiState> state, MainActivity mainActivity, NavHostController navHostController) {
        this.$recipeState$delegate = state;
        this.this$0 = mainActivity;
        this.$navController = navHostController;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) throws Throwable {
        invoke(animatedContentScope, navBackStackEntry, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(AnimatedContentScope composable, NavBackStackEntry it, Composer $composer, int $changed) throws Throwable {
        Object value$iv;
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "C*189@10047L186,186@9864L403:MainActivity.kt#t7ni9s");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1363045550, $changed, -1, "com.easycompra.app.MainActivity.onCreate.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:185)");
        }
        RecipeWithDetails recipe = MainActivity.AnonymousClass1.C01571.invoke$lambda$2(this.$recipeState$delegate).getSelectedRecipe();
        if (recipe != null) {
            final MainActivity mainActivity = this.this$0;
            final NavHostController navHostController = this.$navController;
            RecipeViewModel recipeViewModel = mainActivity.getRecipeViewModel();
            $composer.startReplaceGroup(948459654);
            ComposerKt.sourceInformation($composer, "CC(remember):MainActivity.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(mainActivity) | $composer.changedInstance(navHostController);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function0() { // from class: com.easycompra.app.MainActivity$onCreate$1$1$2$1$1$5$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MainActivity$onCreate$1$1$2$1$1$5.invoke$lambda$2$lambda$1$lambda$0(mainActivity, navHostController);
                    }
                };
                $composer.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer.endReplaceGroup();
            RecipeDetailScreenKt.RecipeDetailScreen(recipe, recipeViewModel, (Function0) value$iv, $composer, RecipeWithDetails.$stable | (RecipeViewModel.$stable << 3));
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$2$lambda$1$lambda$0(MainActivity this$0, NavHostController $navController) {
        this$0.getRecipeViewModel().clearSelectedRecipe();
        $navController.popBackStack();
        return Unit.INSTANCE;
    }
}
