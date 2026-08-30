package com.easycompra.app.ui.recipes;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import com.easycompra.app.data.recipes.RecipeDifficulty;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateEditRecipeScreen.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$1$1$3 implements Function3<LazyItemScope, Composer, Integer, Unit> {
    final /* synthetic */ MutableState<String> $difficulty$delegate;

    CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$1$1$3(MutableState<String> mutableState) {
        this.$difficulty$delegate = mutableState;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
        invoke(lazyItemScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
        Object value$iv;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C289@12979L19,285@12738L278:CreateEditRecipeScreen.kt#y43rd3");
        if (($changed & 17) != 16 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1386959975, $changed, -1, "com.easycompra.app.ui.recipes.CreateEditRecipeScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CreateEditRecipeScreen.kt:285)");
            }
            String strCreateEditRecipeScreen$lambda$24 = CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$24(this.$difficulty$delegate);
            List listListOf = CollectionsKt.listOf((Object[]) new String[]{RecipeDifficulty.EASY, RecipeDifficulty.MEDIUM, RecipeDifficulty.HARD});
            $composer.startReplaceGroup(-888686844);
            ComposerKt.sourceInformation($composer, "CC(remember):CreateEditRecipeScreen.kt#9igjgp");
            boolean invalid$iv = $composer.changed(this.$difficulty$delegate);
            final MutableState<String> mutableState = this.$difficulty$delegate;
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function1() { // from class: com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$1$1$3$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CreateEditRecipeScreenKt$CreateEditRecipeScreen$6$1$1$3.invoke$lambda$1$lambda$0(mutableState, (String) obj);
                    }
                };
                $composer.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer.endReplaceGroup();
            CreateEditRecipeScreenKt.SimpleDropdown("Dificultad", strCreateEditRecipeScreen$lambda$24, listListOf, (Function1) value$iv, null, $composer, 390, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        $composer.skipToGroupEnd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(MutableState $difficulty$delegate, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $difficulty$delegate.setValue(it);
        return Unit.INSTANCE;
    }
}
