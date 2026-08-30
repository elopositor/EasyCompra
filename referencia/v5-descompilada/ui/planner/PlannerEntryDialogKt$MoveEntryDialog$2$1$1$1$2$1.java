package com.easycompra.app.ui.planner;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
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
import androidx.compose.ui.unit.TextUnitKt;
import com.easycompra.app.data.planner.MealSlots;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlannerEntryDialog.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class PlannerEntryDialogKt$MoveEntryDialog$2$1$1$1$2$1 implements Function3<LazyItemScope, Composer, Integer, Unit> {
    final /* synthetic */ String $dateStr;
    final /* synthetic */ boolean $isCurrent;
    final /* synthetic */ Function2<String, String, Unit> $onMove;
    final /* synthetic */ String $slot;

    /* JADX WARN: Multi-variable type inference failed */
    PlannerEntryDialogKt$MoveEntryDialog$2$1$1$1$2$1(boolean z, Function2<? super String, ? super String, Unit> function2, String str, String str2) {
        this.$isCurrent = z;
        this.$onMove = function2;
        this.$dateStr = str;
        this.$slot = str2;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
        invoke(lazyItemScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
        Object value$iv;
        Function0<ComposeUiNode> function0;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        ComposerKt.sourceInformation($composer, "C327@13849L25,324@13671L914,339@14614L19:PlannerEntryDialog.kt#auin6u");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(658705984, $changed, -1, "com.easycompra.app.ui.planner.MoveEntryDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PlannerEntryDialog.kt:324)");
        }
        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
        boolean z = !this.$isCurrent;
        $composer.startReplaceGroup(-1318385132);
        ComposerKt.sourceInformation($composer, "CC(remember):PlannerEntryDialog.kt#9igjgp");
        boolean invalid$iv = $composer.changed(this.$onMove) | $composer.changed(this.$dateStr) | $composer.changed(this.$slot);
        final Function2<String, String, Unit> function2 = this.$onMove;
        final String str = this.$dateStr;
        final String str2 = this.$slot;
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = new Function0() { // from class: com.easycompra.app.ui.planner.PlannerEntryDialogKt$MoveEntryDialog$2$1$1$1$2$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return PlannerEntryDialogKt$MoveEntryDialog$2$1$1$1$2$1.invoke$lambda$1$lambda$0(function2, str, str2);
                }
            };
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        $composer.endReplaceGroup();
        Modifier modifier$iv = PaddingKt.m682paddingVpY3zN4(ClickableKt.m269clickableXHw0xAI$default(modifierFillMaxWidth$default, z, null, null, (Function0) value$iv, 6, null), Dp.m6663constructorimpl(8), Dp.m6663constructorimpl(6));
        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(8));
        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
        String str3 = this.$slot;
        boolean z2 = this.$isCurrent;
        ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((432 >> 3) & 14) | ((432 >> 3) & 112));
        int $changed$iv$iv = (432 << 3) & 112;
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
        ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        int i2 = ((432 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, -418458922, "C332@14184L44,333@14261L192:PlannerEntryDialog.kt#auin6u");
        TextKt.m2714Text4IGK_g(MealSlots.INSTANCE.icon(str3), (Modifier) null, 0L, TextUnitKt.getSp(16), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 3072, 0, 131062);
        $composer.startReplaceGroup(-13493572);
        ComposerKt.sourceInformation($composer, "335@14398L11");
        long jM4211getGray0d7_KjU = z2 ? Color.INSTANCE.m4211getGray0d7_KjU() : MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getOnSurface();
        $composer.endReplaceGroup();
        TextKt.m2714Text4IGK_g(str3, (Modifier) null, jM4211getGray0d7_KjU, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 0, 0, 131066);
        $composer.startReplaceGroup(-13489313);
        ComposerKt.sourceInformation($composer, "337@14501L54");
        if (z2) {
            TextKt.m2714Text4IGK_g("(actual)", (Modifier) null, Color.INSTANCE.m4211getGray0d7_KjU(), TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 3462, 0, 131058);
        }
        $composer.endReplaceGroup();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        DividerKt.m2093HorizontalDivider9IZ8Weo(null, 0.0f, 0L, $composer, 0, 7);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(Function2 $onMove, String $dateStr, String $slot) {
        Intrinsics.checkNotNull($dateStr);
        $onMove.invoke($dateStr, $slot);
        return Unit.INSTANCE;
    }
}
