package com.easycompra.app.ui.components;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
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
import com.easycompra.app.ui.theme.ColorKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NutriScoreBadge.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0002\u0010\u0004\u001a!\u0010\u0005\u001a\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001a\u001f\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t¨\u0006\f"}, d2 = {"nutriColor", "Landroidx/compose/ui/graphics/Color;", "grade", "", "(Ljava/lang/String;)J", "NutriScoreBadge", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "SupermarketBadge", "supermarket", "app_debug"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class NutriScoreBadgeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NutriScoreBadge$lambda$1(String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        NutriScoreBadge(str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SupermarketBadge$lambda$3(String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        SupermarketBadge(str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static final long nutriColor(String grade) {
        String lowerCase;
        if (grade != null) {
            lowerCase = grade.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        } else {
            lowerCase = null;
        }
        if (lowerCase != null) {
            switch (lowerCase.hashCode()) {
                case 97:
                    if (lowerCase.equals("a")) {
                        return ColorKt.getNutriA();
                    }
                    break;
                case 98:
                    if (lowerCase.equals("b")) {
                        return ColorKt.getNutriB();
                    }
                    break;
                case 99:
                    if (lowerCase.equals("c")) {
                        return ColorKt.getNutriC();
                    }
                    break;
                case 100:
                    if (lowerCase.equals("d")) {
                        return ColorKt.getNutriD();
                    }
                    break;
                case 101:
                    if (lowerCase.equals("e")) {
                        return ColorKt.getNutriE();
                    }
                    break;
            }
        }
        return ColorKt.getNutriUnknown();
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0080  */
    public static final void NutriScoreBadge(final String grade, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        String label;
        Function0<ComposeUiNode> function0;
        Composer $composer2 = $composer.startRestartGroup(278170650);
        ComposerKt.sourceInformation($composer2, "C(NutriScoreBadge)33@1132L380:NutriScoreBadge.kt#i2dwn6");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(grade) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($dirty & 19) != 18 || !$composer2.getSkipping()) {
            Modifier.Companion modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(278170650, $dirty, -1, "com.easycompra.app.ui.components.NutriScoreBadge (NutriScoreBadge.kt:31)");
            }
            if (grade != null) {
                label = grade.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(label, "toUpperCase(...)");
                if (label == null) {
                    label = "?";
                }
            } else {
                label = "?";
            }
            Modifier modifier$iv = PaddingKt.m682paddingVpY3zN4(BackgroundKt.m235backgroundbw27NRU(modifier3, nutriColor(grade), RoundedCornerShapeKt.m964RoundedCornerShape0680j_4(Dp.m6663constructorimpl(4))), Dp.m6663constructorimpl(8), Dp.m6663constructorimpl(2));
            Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier modifier4 = modifier3;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function0 = constructor;
                $composer2.createNode(function0);
            } else {
                function0 = constructor;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3674constructorimpl($composer2);
            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i4 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -1025703903, "C39@1352L154:NutriScoreBadge.kt#i2dwn6");
            TextKt.m2714Text4IGK_g("Nutri " + label, (Modifier) null, Color.INSTANCE.m4218getWhite0d7_KjU(), TextUnitKt.getSp(11), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 200064, 0, 131026);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.components.NutriScoreBadgeKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NutriScoreBadgeKt.NutriScoreBadge$lambda$1(grade, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:53:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:75:0x0267  */
    public static final void SupermarketBadge(final String supermarket, Modifier modifier, Composer $composer, final int $changed, final int i) {
        final Modifier modifier2;
        long nutriUnknown;
        MeasurePolicy measurePolicy$iv;
        CompositionLocalMap localMap$iv$iv;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(supermarket, "supermarket");
        Composer $composer3 = $composer.startRestartGroup(-1856247539);
        ComposerKt.sourceInformation($composer3, "C(SupermarketBadge)P(1)58@1997L309:NutriScoreBadge.kt#i2dwn6");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(supermarket) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 19) == 18 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            Modifier modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1856247539, $dirty2, -1, "com.easycompra.app.ui.components.SupermarketBadge (NutriScoreBadge.kt:49)");
            }
            switch (supermarket) {
                case "Carrefour":
                    nutriUnknown = ColorKt.getSuperCarrefour();
                    break;
                case "Mercadona":
                    nutriUnknown = ColorKt.getSuperMercadona();
                    break;
                case "Dia":
                    nutriUnknown = ColorKt.getSuperDia();
                    break;
                case "Lidl":
                    nutriUnknown = ColorKt.getSuperLidl();
                    break;
                default:
                    nutriUnknown = ColorKt.getNutriUnknown();
                    break;
            }
            long color = nutriUnknown;
            long textColor = Intrinsics.areEqual(supermarket, "Lidl") ? Color.INSTANCE.m4207getBlack0d7_KjU() : Color.INSTANCE.m4218getWhite0d7_KjU();
            Modifier modifier$iv = PaddingKt.m682paddingVpY3zN4(BackgroundKt.m235backgroundbw27NRU(modifier3, color, RoundedCornerShapeKt.m964RoundedCornerShape0680j_4(Dp.m6663constructorimpl(4))), Dp.m6663constructorimpl(8), Dp.m6663constructorimpl(2));
            Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(constructor);
            } else {
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3674constructorimpl($composer3);
            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                measurePolicy$iv = measurePolicy$iv2;
                localMap$iv$iv = localMap$iv$iv2;
            } else {
                measurePolicy$iv = measurePolicy$iv2;
                localMap$iv$iv = localMap$iv$iv2;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                }
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                int i3 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                int i4 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 1348230221, "C64@2205L95:NutriScoreBadge.kt#i2dwn6");
                Modifier modifier4 = modifier3;
                $composer2 = $composer3;
                TextKt.m2714Text4IGK_g(supermarket, (Modifier) null, textColor, TextUnitKt.getSp(11), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, ($dirty2 & 14) | 199680, 0, 131026);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier4;
            }
            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            int i6 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1348230221, "C64@2205L95:NutriScoreBadge.kt#i2dwn6");
            Modifier modifier5 = modifier3;
            $composer2 = $composer3;
            TextKt.m2714Text4IGK_g(supermarket, (Modifier) null, textColor, TextUnitKt.getSp(11), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, ($dirty2 & 14) | 199680, 0, 131026);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.components.NutriScoreBadgeKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NutriScoreBadgeKt.SupermarketBadge$lambda$3(supermarket, modifier2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
