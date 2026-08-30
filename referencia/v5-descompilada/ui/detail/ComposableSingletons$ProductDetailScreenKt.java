package com.easycompra.app.ui.detail;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.filled.ArrowBackKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ProductDetailScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class ComposableSingletons$ProductDetailScreenKt {
    public static final ComposableSingletons$ProductDetailScreenKt INSTANCE = new ComposableSingletons$ProductDetailScreenKt();

    /* JADX INFO: renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f100lambda1 = ComposableLambdaKt.composableLambdaInstance(1319570006, false, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.detail.ComposableSingletons$ProductDetailScreenKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C63@2649L51:ProductDetailScreen.kt#scc5s3");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1319570006, $changed, -1, "com.easycompra.app.ui.detail.ComposableSingletons$ProductDetailScreenKt.lambda-1.<anonymous> (ProductDetailScreen.kt:63)");
            }
            IconKt.m2171Iconww6aTOc(ArrowBackKt.getArrowBack(Icons.AutoMirrored.Filled.INSTANCE), "Volver", (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: getLambda-1$app_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m7082getLambda1$app_debug() {
        return f100lambda1;
    }
}
