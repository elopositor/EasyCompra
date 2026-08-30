package com.easycompra.app.ui.planner;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.ButtonKt;
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
import com.easycompra.app.data.planner.DefrostAlert;
import com.easycompra.app.data.planner.IngredientNeed;
import com.easycompra.app.data.planner.PantryTip;
import com.easycompra.app.data.planner.WeekAnalysis;
import com.easycompra.app.data.recipes.UnitConverter;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlannerScreen.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
final class PlannerScreenKt$AnalysisPanel$1$1$3 implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {
    final /* synthetic */ WeekAnalysis $analysis;
    final /* synthetic */ Function1<IngredientNeed, Unit> $onAddToCart;

    /* JADX WARN: Multi-variable type inference failed */
    PlannerScreenKt$AnalysisPanel$1$1$3(WeekAnalysis weekAnalysis, Function1<? super IngredientNeed, Unit> function1) {
        this.$analysis = weekAnalysis;
        this.$onAddToCart = function1;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
        invoke(animatedVisibilityScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer $composer, int $changed) {
        Function0<ComposeUiNode> function0;
        Composer $composer$iv;
        Function0<ComposeUiNode> function1;
        Function0<ComposeUiNode> function2;
        Object value$iv;
        String str;
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation($composer, "C372@14911L3090:PlannerScreen.kt#auin6u");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(108819795, $changed, -1, "com.easycompra.app.ui.planner.AnalysisPanel.<anonymous>.<anonymous>.<anonymous> (PlannerScreen.kt:372)");
        }
        Modifier modifier$iv = PaddingKt.m682paddingVpY3zN4(Modifier.INSTANCE, Dp.m6663constructorimpl(14), Dp.m6663constructorimpl(0));
        WeekAnalysis weekAnalysis = this.$analysis;
        final Function1<IngredientNeed, Unit> function3 = this.$onAddToCart;
        int $changed$iv = 6;
        String str2 = "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo";
        ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
        int $changed$iv$iv = (6 << 3) & 112;
        int $i$f$Layout = 0;
        String str3 = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh";
        ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
        CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
        String str4 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
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
        Composer $composer$iv2 = $composer;
        int i2 = 0;
        String str5 = "C88@4444L9:Column.kt#2w3rfo";
        ComposerKt.sourceInformationMarkerStart($composer$iv2, -384784025, "C88@4444L9:Column.kt#2w3rfo");
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        int i3 = ((6 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer$iv2, -1836628659, "C430@17953L30:PlannerScreen.kt#auin6u");
        $composer$iv2.startReplaceGroup(-197795532);
        ComposerKt.sourceInformation($composer$iv2, "376@15112L30,389@15818L29");
        if (!weekAnalysis.getDefrostAlerts().isEmpty()) {
            PlannerScreenKt.SectionLabel("🧊 Descongelar", $composer$iv2, 6);
            $composer$iv2.startReplaceGroup(-197791113);
            ComposerKt.sourceInformation($composer$iv2, "*383@15492L275");
            Iterable $this$forEach$iv = weekAnalysis.getDefrostAlerts();
            int $i$f$forEach = 0;
            for (Object element$iv : $this$forEach$iv) {
                DefrostAlert alert = (DefrostAlert) element$iv;
                switch (alert.getDaysUntil()) {
                    case 0:
                        str = "hoy";
                        break;
                    case 1:
                        str = "mañana";
                        break;
                    default:
                        String lowerCase = alert.getNeededOnDate().toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                        str = lowerCase;
                        break;
                }
                String when_ = str;
                TextKt.m2714Text4IGK_g("• Saca «" + alert.getProductName() + "» del congelador " + when_ + " (para " + alert.getNeededFor() + ")", PaddingKt.m683paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m6663constructorimpl(3), 1, null), 0L, TextUnitKt.getSp(13), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer$iv2, 3120, 0, 131060);
                $this$forEach$iv = $this$forEach$iv;
                $changed$iv = $changed$iv;
                i2 = i2;
                $i$f$forEach = $i$f$forEach;
                horizontalAlignment$iv = horizontalAlignment$iv;
            }
            $composer$iv2.endReplaceGroup();
            SpacerKt.Spacer(SizeKt.m712height3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(8)), $composer$iv2, 6);
        }
        $composer$iv2.endReplaceGroup();
        $composer$iv2.startReplaceGroup(-197766282);
        ComposerKt.sourceInformation($composer$iv2, "394@16006L38,419@17509L29");
        if (!weekAnalysis.getMissingIngredients().isEmpty()) {
            PlannerScreenKt.SectionLabel("🛒 Faltan ingredientes", $composer$iv2, 6);
            $composer$iv2.startReplaceGroup(-197761305);
            ComposerKt.sourceInformation($composer$iv2, "*396@16143L1315");
            Iterable $this$forEach$iv2 = weekAnalysis.getMissingIngredients();
            int $i$f$forEach2 = 0;
            Iterator it = $this$forEach$iv2.iterator();
            while (it.hasNext()) {
                Object element$iv2 = it.next();
                Iterable $this$forEach$iv3 = $this$forEach$iv2;
                final IngredientNeed need = (IngredientNeed) element$iv2;
                int $i$f$forEach3 = $i$f$forEach2;
                Iterator it2 = it;
                MeasurePolicy measurePolicy$iv2 = measurePolicy$iv;
                int $changed$iv$iv2 = $changed$iv$iv;
                Modifier modifierM683paddingVpY3zN4$default = PaddingKt.m683paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, Dp.m6663constructorimpl(3), 1, null);
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                Arrangement.HorizontalOrVertical horizontalOrVerticalM561spacedBy0680j_4 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(8));
                int $i$f$Layout2 = $i$f$Layout;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalOrVerticalM561spacedBy0680j_4, centerVertically, $composer$iv2, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                ComposerKt.sourceInformationMarkerStart($composer$iv2, -1323940314, str3);
                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer$iv2, 0);
                CompositionLocalMap localMap$iv$iv2 = $composer$iv2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer$iv2, modifierM683paddingVpY3zN4$default);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                int $i$f$Layout3 = ((438 << 3) & 112) << 6;
                int $changed$iv$iv$iv2 = ($i$f$Layout3 & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, -692256719, str4);
                if (!($composer$iv2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv2.startReusableNode();
                if ($composer$iv2.getInserting()) {
                    function1 = constructor2;
                    $composer$iv2.createNode(function1);
                } else {
                    function1 = constructor2;
                    $composer$iv2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3674constructorimpl($composer$iv2);
                Composer $composer$iv3 = $composer$iv2;
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                }
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                int i5 = ((438 >> 6) & 112) | 6;
                RowScope $this$invoke_u24lambda_u247_u24lambda_u245_u24lambda_u244 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, -286792151, "C401@16468L569,412@17128L21,411@17070L358:PlannerScreen.kt#auin6u");
                Modifier modifier$iv2 = RowScope.weight$default($this$invoke_u24lambda_u247_u24lambda_u245_u24lambda_u244, Modifier.INSTANCE, 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart($composer$iv2, -483455358, str2);
                Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                String str6 = str2;
                int $changed$iv$iv$iv3 = ((0 >> 3) & 14) | ((0 >> 3) & 112);
                MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, Alignment.INSTANCE.getStart(), $composer$iv2, $changed$iv$iv$iv3);
                ComposerKt.sourceInformationMarkerStart($composer$iv2, -1323940314, str3);
                int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer$iv2, 0);
                CompositionLocalMap localMap$iv$iv3 = $composer$iv2.getCurrentCompositionLocalMap();
                String str7 = str3;
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer$iv2, modifier$iv2);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv4 = ((((0 << 3) & 112) << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, -692256719, str4);
                if (!($composer$iv2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv2.startReusableNode();
                if ($composer$iv2.getInserting()) {
                    function2 = constructor3;
                    $composer$iv2.createNode(function2);
                } else {
                    function2 = constructor3;
                    $composer$iv2.useNode();
                }
                String str8 = str4;
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3674constructorimpl($composer$iv2);
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                    $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                    $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
                }
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                int i6 = ($changed$iv$iv$iv4 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, -384784025, str5);
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                int i7 = ((0 >> 6) & 112) | 6;
                String str9 = str5;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, 1585080480, "C402@16545L213,406@16795L208:PlannerScreen.kt#auin6u");
                TextKt.m2714Text4IGK_g("• " + need.getName() + ": " + UnitConverter.INSTANCE.formatQty(need.getDeficit()) + " " + need.getUnit(), (Modifier) null, 0L, TextUnitKt.getSp(13), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer$iv2, 3072, 0, 131062);
                TextKt.m2714Text4IGK_g("Para: " + CollectionsKt.joinToString$default(need.getRecipeNames(), ", ", null, null, 0, null, null, 62, null), (Modifier) null, Color.INSTANCE.m4211getGray0d7_KjU(), TextUnitKt.getSp(10), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer$iv2, 3456, 0, 131058);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $composer$iv2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $composer$iv2.startReplaceGroup(1930431471);
                ComposerKt.sourceInformation($composer$iv2, "CC(remember):PlannerScreen.kt#9igjgp");
                boolean invalid$iv = $composer$iv2.changed(function3) | $composer$iv2.changedInstance(need);
                Object it$iv = $composer$iv2.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function0() { // from class: com.easycompra.app.ui.planner.PlannerScreenKt$AnalysisPanel$1$1$3$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PlannerScreenKt$AnalysisPanel$1$1$3.invoke$lambda$7$lambda$5$lambda$4$lambda$3$lambda$2(function3, need);
                        }
                    };
                    $composer$iv2.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                $composer$iv2.endReplaceGroup();
                ButtonKt.TextButton((Function0) value$iv, null, false, null, null, null, null, PaddingKt.m675PaddingValuesYgX7TsA(Dp.m6663constructorimpl(8), Dp.m6663constructorimpl(4)), null, ComposableSingletons$PlannerScreenKt.INSTANCE.m7159getLambda5$app_debug(), $composer$iv2, 817889280, 382);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $composer$iv2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $this$forEach$iv2 = $this$forEach$iv3;
                it = it2;
                $i$f$forEach2 = $i$f$forEach3;
                str2 = str6;
                measurePolicy$iv = measurePolicy$iv2;
                $changed$iv$iv = $changed$iv$iv2;
                $i$f$Layout = $i$f$Layout2;
                $composer$iv2 = $composer$iv3;
                str3 = str7;
                str4 = str8;
                str5 = str9;
            }
            $composer$iv = $composer$iv2;
            $composer$iv2.endReplaceGroup();
            SpacerKt.Spacer(SizeKt.m712height3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(8)), $composer$iv2, 6);
        } else {
            $composer$iv = $composer$iv2;
        }
        $composer$iv2.endReplaceGroup();
        $composer$iv2.startReplaceGroup(-197713738);
        ComposerKt.sourceInformation($composer$iv2, "424@17681L27,*426@17798L85");
        if (!weekAnalysis.getPantryTips().isEmpty()) {
            PlannerScreenKt.SectionLabel("💡 Consejos", $composer$iv2, 6);
            for (Object element$iv3 : weekAnalysis.getPantryTips()) {
                PantryTip tip = (PantryTip) element$iv3;
                TextKt.m2714Text4IGK_g("• " + tip.getText(), PaddingKt.m683paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m6663constructorimpl(3), 1, null), 0L, TextUnitKt.getSp(13), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer$iv2, 3120, 0, 131060);
            }
        }
        $composer$iv2.endReplaceGroup();
        SpacerKt.Spacer(SizeKt.m712height3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(10)), $composer$iv2, 6);
        ComposerKt.sourceInformationMarkerEnd($composer$iv2);
        ComposerKt.sourceInformationMarkerEnd($composer$iv);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$7$lambda$5$lambda$4$lambda$3$lambda$2(Function1 $onAddToCart, IngredientNeed $need) {
        $onAddToCart.invoke($need);
        return Unit.INSTANCE;
    }
}
