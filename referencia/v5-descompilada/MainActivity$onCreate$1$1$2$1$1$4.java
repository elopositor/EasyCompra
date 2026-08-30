package com.easycompra.app;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.easycompra.app.data.recipes.RecipeWithDetails;
import com.easycompra.app.ui.recipes.RecipeListScreenKt;
import com.easycompra.app.ui.recipes.RecipeViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class MainActivity$onCreate$1$1$2$1$1$4 implements Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit> {
    final /* synthetic */ NavHostController $navController;
    final /* synthetic */ MainActivity this$0;

    MainActivity$onCreate$1$1$2$1$1$4(MainActivity mainActivity, NavHostController navHostController) {
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
        ComposerKt.sourceInformation($composer, "C178@9455L194,176@9328L351:MainActivity.kt#t7ni9s");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(220697965, $changed, -1, "com.easycompra.app.MainActivity.onCreate.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:176)");
        }
        RecipeViewModel recipeViewModel = this.this$0.getRecipeViewModel();
        $composer.startReplaceGroup(-211122161);
        ComposerKt.sourceInformation($composer, "CC(remember):MainActivity.kt#9igjgp");
        boolean invalid$iv = $composer.changedInstance(this.this$0) | $composer.changedInstance(this.$navController);
        final MainActivity mainActivity = this.this$0;
        final NavHostController navHostController = this.$navController;
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new Function1() { // from class: com.easycompra.app.MainActivity$onCreate$1$1$2$1$1$4$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return MainActivity$onCreate$1$1$2$1$1$4.invoke$lambda$1$lambda$0(mainActivity, navHostController, (RecipeWithDetails) obj);
                }
            };
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        $composer.endReplaceGroup();
        RecipeListScreenKt.RecipeListScreen(recipeViewModel, (Function1) value$iv, $composer, RecipeViewModel.$stable);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(MainActivity this$0, NavHostController $navController, RecipeWithDetails recipe) {
        Intrinsics.checkNotNullParameter(recipe, "recipe");
        this$0.getRecipeViewModel().selectRecipe(recipe);
        NavController.navigate$default((NavController) $navController, "recipe_detail", (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }
}
