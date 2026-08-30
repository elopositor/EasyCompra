package com.easycompra.app.ui.list;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material3.ChipKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProductListScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class ProductListScreenKt$FilterRow$1$2$1$1 implements Function3<LazyItemScope, Composer, Integer, Unit> {
    final /* synthetic */ ProductListUiState $state;
    final /* synthetic */ ProductListViewModel $viewModel;

    ProductListScreenKt$FilterRow$1$2$1$1(ProductListUiState productListUiState, ProductListViewModel productListViewModel) {
        this.$state = productListUiState;
        this.$viewModel = productListViewModel;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
        invoke(lazyItemScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
        Object value$iv;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C214@9503L39,212@9398L216:ProductListScreen.kt#c0t1xm");
        if (($changed & 17) != 16 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(584917623, $changed, -1, "com.easycompra.app.ui.list.FilterRow.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ProductListScreen.kt:212)");
            }
            boolean z = this.$state.getNutriscoreFilter() == null;
            $composer.startReplaceGroup(-1586255167);
            ComposerKt.sourceInformation($composer, "CC(remember):ProductListScreen.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(this.$viewModel);
            final ProductListViewModel productListViewModel = this.$viewModel;
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function0() { // from class: com.easycompra.app.ui.list.ProductListScreenKt$FilterRow$1$2$1$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ProductListScreenKt$FilterRow$1$2$1$1.invoke$lambda$1$lambda$0(productListViewModel);
                    }
                };
                $composer.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer.endReplaceGroup();
            ChipKt.FilterChip(z, (Function0) value$iv, ComposableSingletons$ProductListScreenKt.INSTANCE.m7088getLambda12$app_debug(), null, false, null, null, null, null, null, null, null, $composer, 384, 0, 4088);
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
        $viewModel.setNutriscoreFilter(null);
        return Unit.INSTANCE;
    }
}
