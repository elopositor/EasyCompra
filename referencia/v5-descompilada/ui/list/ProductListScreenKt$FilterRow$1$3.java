package com.easycompra.app.ui.list;

import androidx.compose.material3.TabKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ProductListScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class ProductListScreenKt$FilterRow$1$3 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ ProductListUiState $state;
    final /* synthetic */ ProductListViewModel $viewModel;

    ProductListScreenKt$FilterRow$1$3(ProductListUiState productListUiState, ProductListViewModel productListViewModel) {
        this.$state = productListUiState;
        this.$viewModel = productListViewModel;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer $composer, int $changed) {
        Object value$iv;
        ComposerKt.sourceInformation($composer, "C*235@10302L33,236@10364L39,233@10210L211:ProductListScreen.kt#c0t1xm");
        if (($changed & 3) != 2 || !$composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(930959298, $changed, -1, "com.easycompra.app.ui.list.FilterRow.<anonymous>.<anonymous> (ProductListScreen.kt:232)");
            }
            Iterable $this$forEach$iv = SortField.getEntries();
            ProductListUiState productListUiState = this.$state;
            final ProductListViewModel productListViewModel = this.$viewModel;
            for (Object element$iv : $this$forEach$iv) {
                final SortField field = (SortField) element$iv;
                boolean z = productListUiState.getSortField() == field;
                $composer.startReplaceGroup(1515703580);
                ComposerKt.sourceInformation($composer, "CC(remember):ProductListScreen.kt#9igjgp");
                boolean invalid$iv = $composer.changedInstance(productListViewModel) | $composer.changed(field);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function0() { // from class: com.easycompra.app.ui.list.ProductListScreenKt$FilterRow$1$3$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ProductListScreenKt$FilterRow$1$3.invoke$lambda$2$lambda$1$lambda$0(productListViewModel, field);
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                $composer.endReplaceGroup();
                TabKt.m2600TabwqdebIU(z, (Function0) value$iv, null, false, ComposableLambdaKt.rememberComposableLambda(862286285, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.list.ProductListScreenKt$FilterRow$1$3$1$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer2, int $changed2) {
                        ComposerKt.sourceInformation($composer2, "C236@10366L35:ProductListScreen.kt#c0t1xm");
                        if (($changed2 & 3) == 2 && $composer2.getSkipping()) {
                            $composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(862286285, $changed2, -1, "com.easycompra.app.ui.list.FilterRow.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ProductListScreen.kt:236)");
                        }
                        TextKt.m2714Text4IGK_g(field.getLabel(), (Modifier) null, 0L, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 3072, 0, 131062);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }, $composer, 54), null, 0L, 0L, null, $composer, 24576, 492);
                productListViewModel = productListViewModel;
                productListUiState = productListUiState;
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
    public static final Unit invoke$lambda$2$lambda$1$lambda$0(ProductListViewModel $viewModel, SortField $field) {
        $viewModel.setSortField($field);
        return Unit.INSTANCE;
    }
}
