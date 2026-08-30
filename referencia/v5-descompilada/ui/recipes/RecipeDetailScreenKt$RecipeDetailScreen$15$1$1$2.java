package com.easycompra.app.ui.recipes;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import com.easycompra.app.data.recipes.RecipeWithDetails;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecipeDetailScreen.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class RecipeDetailScreenKt$RecipeDetailScreen$15$1$1$2 implements Function3<LazyItemScope, Composer, Integer, Unit> {
    final /* synthetic */ RecipeWithDetails $recipe;
    final /* synthetic */ RecipeViewModel $viewModel;

    RecipeDetailScreenKt$RecipeDetailScreen$15$1$1$2(RecipeViewModel recipeViewModel, RecipeWithDetails recipeWithDetails) {
        this.$viewModel = recipeViewModel;
        this.$recipe = recipeWithDetails;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
        invoke(lazyItemScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
        Object value$iv;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C195@8969L34,201@9342L48,194@8923L629,205@9577L29:RecipeDetailScreen.kt#y43rd3");
        if (($changed & 17) != 16 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(274915492, $changed, -1, "com.easycompra.app.ui.recipes.RecipeDetailScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RecipeDetailScreen.kt:194)");
            }
            $composer.startReplaceGroup(-315429762);
            ComposerKt.sourceInformation($composer, "CC(remember):RecipeDetailScreen.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(this.$viewModel) | $composer.changedInstance(this.$recipe);
            final RecipeViewModel recipeViewModel = this.$viewModel;
            final RecipeWithDetails recipeWithDetails = this.$recipe;
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function0() { // from class: com.easycompra.app.ui.recipes.RecipeDetailScreenKt$RecipeDetailScreen$15$1$1$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RecipeDetailScreenKt$RecipeDetailScreen$15$1$1$2.invoke$lambda$1$lambda$0(recipeViewModel, recipeWithDetails);
                    }
                };
                $composer.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer.endReplaceGroup();
            ButtonKt.Button((Function0) value$iv, SizeKt.m712height3ABfNKs(PaddingKt.m682paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6663constructorimpl(16), Dp.m6663constructorimpl(4)), Dp.m6663constructorimpl(52)), false, RoundedCornerShapeKt.m964RoundedCornerShape0680j_4(Dp.m6663constructorimpl(12)), ButtonDefaults.INSTANCE.m1830buttonColorsro_MJ88(ColorKt.Color(4294538006L), 0L, 0L, 0L, $composer, (ButtonDefaults.$stable << 12) | 6, 14), null, null, null, null, ComposableSingletons$RecipeDetailScreenKt.INSTANCE.m7211getLambda8$app_debug(), $composer, 805306416, 484);
            SpacerKt.Spacer(SizeKt.m712height3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(8)), $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(RecipeViewModel $viewModel, RecipeWithDetails $recipe) {
        $viewModel.startCooking($recipe);
        return Unit.INSTANCE;
    }
}
