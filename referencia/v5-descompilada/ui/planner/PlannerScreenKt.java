package com.easycompra.app.ui.planner;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.AddKt;
import androidx.compose.material.icons.filled.KeyboardArrowDownKt;
import androidx.compose.material.icons.filled.KeyboardArrowUpKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarColors;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.profileinstaller.ProfileVerifier;
import com.easycompra.app.data.planner.IngredientNeed;
import com.easycompra.app.data.planner.MealSlots;
import com.easycompra.app.data.planner.PlannerEntry;
import com.easycompra.app.data.planner.WeekAnalysis;
import com.easycompra.app.data.recipes.RecipeWithDetails;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PlannerScreen.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001aK\u0010\u0005\u001a\u00020\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\fH\u0003¢\u0006\u0002\u0010\u000e\u001a5\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017H\u0003¢\u0006\u0002\u0010\u0018\u001a)\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\fH\u0003¢\u0006\u0002\u0010\u001c\u001a\u0015\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0011H\u0003¢\u0006\u0002\u0010\u001f\u001a\u0010\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0002¨\u0006#²\u0006\n\u0010$\u001a\u00020%X\u008a\u0084\u0002²\u0006\n\u0010&\u001a\u00020'X\u008a\u008e\u0002"}, d2 = {"PlannerScreen", "", "viewModel", "Lcom/easycompra/app/ui/planner/PlannerViewModel;", "(Lcom/easycompra/app/ui/planner/PlannerViewModel;Landroidx/compose/runtime/Composer;I)V", "WeekStrip", "dates", "", "Ljava/time/LocalDate;", "selectedIndex", "", "getEntryCount", "Lkotlin/Function1;", "onSelectDay", "(Ljava/util/List;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "MealSlotCard", "slot", "", "entry", "Lcom/easycompra/app/data/planner/PlannerEntry;", "analysis", "Lcom/easycompra/app/data/planner/WeekAnalysis;", "onClick", "Lkotlin/Function0;", "(Ljava/lang/String;Lcom/easycompra/app/data/planner/PlannerEntry;Lcom/easycompra/app/data/planner/WeekAnalysis;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "AnalysisPanel", "onAddToCart", "Lcom/easycompra/app/data/planner/IngredientNeed;", "(Lcom/easycompra/app/data/planner/WeekAnalysis;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "SectionLabel", "text", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "formatServings", "v", "", "app_debug", "state", "Lcom/easycompra/app/ui/planner/PlannerUiState;", "expanded", ""}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PlannerScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnalysisPanel$lambda$27(WeekAnalysis weekAnalysis, Function1 function1, int i, Composer composer, int i2) {
        AnalysisPanel(weekAnalysis, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MealSlotCard$lambda$23(String str, PlannerEntry plannerEntry, WeekAnalysis weekAnalysis, Function0 function0, int i, Composer composer, int i2) {
        MealSlotCard(str, plannerEntry, weekAnalysis, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlannerScreen$lambda$11(PlannerViewModel plannerViewModel, int i, Composer composer, int i2) {
        PlannerScreen(plannerViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SectionLabel$lambda$28(String str, int i, Composer composer, int i2) {
        SectionLabel(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WeekStrip$lambda$20(List list, int i, Function1 function1, Function1 function2, int i2, Composer composer, int i3) {
        WeekStrip(list, i, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final void PlannerScreen(final PlannerViewModel viewModel, Composer $composer, final int $changed) {
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        Object value$iv4;
        boolean z;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer $composer3 = $composer.startRestartGroup(504081460);
        ComposerKt.sourceInformation($composer3, "C(PlannerScreen)69@3125L16,91@3868L1173,119@5048L2865,90@3841L4072:PlannerScreen.kt#auin6u");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(viewModel) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 3) != 2 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(504081460, $dirty2, -1, "com.easycompra.app.ui.planner.PlannerScreen (PlannerScreen.kt:68)");
            }
            final State state$delegate = SnapshotStateKt.collectAsState(viewModel.getState(), null, $composer3, 0, 1);
            Pair<String, String> editingSlot = PlannerScreen$lambda$0(state$delegate).getEditingSlot();
            $composer3.startReplaceGroup(-1935814843);
            ComposerKt.sourceInformation($composer3, "*79@3428L121,82@3573L35,83@3631L133,86@3790L29,73@3210L619");
            if (editingSlot == null) {
                z = true;
            } else {
                final String date = editingSlot.component1();
                final String slot = editingSlot.component2();
                PlannerEntry editingEntry = PlannerScreen$lambda$0(state$delegate).getEditingEntry();
                List<RecipeWithDetails> allRecipes = PlannerScreen$lambda$0(state$delegate).getAllRecipes();
                List<LocalDate> weekDates = PlannerScreen$lambda$0(state$delegate).getWeekDates();
                $composer3.startReplaceGroup(1992559918);
                ComposerKt.sourceInformation($composer3, "CC(remember):PlannerScreen.kt#9igjgp");
                boolean invalid$iv = $composer3.changedInstance(viewModel);
                Object it$iv = $composer3.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function6() { // from class: com.easycompra.app.ui.planner.PlannerScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function6
                        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                            return PlannerScreenKt.PlannerScreen$lambda$10$lambda$2$lambda$1(viewModel, (String) obj, (String) obj2, (String) obj3, (String) obj4, ((Float) obj5).floatValue(), (String) obj6);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                Function6 function6 = (Function6) value$iv;
                $composer3.endReplaceGroup();
                $composer3.startReplaceGroup(1992564472);
                ComposerKt.sourceInformation($composer3, "CC(remember):PlannerScreen.kt#9igjgp");
                boolean invalid$iv2 = $composer3.changedInstance(viewModel) | $composer3.changed(date) | $composer3.changed(slot);
                Object it$iv2 = $composer3.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = new Function0() { // from class: com.easycompra.app.ui.planner.PlannerScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PlannerScreenKt.PlannerScreen$lambda$10$lambda$4$lambda$3(viewModel, date, slot);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv2;
                }
                Function0 function0 = (Function0) value$iv2;
                $composer3.endReplaceGroup();
                $composer3.startReplaceGroup(1992566426);
                ComposerKt.sourceInformation($composer3, "CC(remember):PlannerScreen.kt#9igjgp");
                boolean invalid$iv3 = $composer3.changed(state$delegate) | $composer3.changedInstance(viewModel);
                Object it$iv3 = $composer3.rememberedValue();
                if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                    value$iv3 = new Function2() { // from class: com.easycompra.app.ui.planner.PlannerScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return PlannerScreenKt.PlannerScreen$lambda$10$lambda$7$lambda$6(state$delegate, viewModel, (String) obj, (String) obj2);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv3);
                } else {
                    value$iv3 = it$iv3;
                }
                Function2 function2 = (Function2) value$iv3;
                $composer3.endReplaceGroup();
                $composer3.startReplaceGroup(1992571410);
                ComposerKt.sourceInformation($composer3, "CC(remember):PlannerScreen.kt#9igjgp");
                boolean invalid$iv4 = $composer3.changedInstance(viewModel);
                Object it$iv4 = $composer3.rememberedValue();
                if (invalid$iv4 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                    value$iv4 = new Function0() { // from class: com.easycompra.app.ui.planner.PlannerScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PlannerScreenKt.PlannerScreen$lambda$10$lambda$9$lambda$8(viewModel);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv4);
                } else {
                    value$iv4 = it$iv4;
                }
                $composer3.endReplaceGroup();
                z = true;
                PlannerEntryDialogKt.PlannerEntryDialog(date, slot, editingEntry, allRecipes, weekDates, function6, function0, function2, (Function0) value$iv4, $composer3, 0);
                Unit unit = Unit.INSTANCE;
            }
            $composer3.endReplaceGroup();
            $composer2 = $composer3;
            ScaffoldKt.m2429ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(2108977656, z, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.planner.PlannerScreenKt.PlannerScreen.2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C100@4279L11,99@4211L216,93@3917L249,104@4462L185,109@4675L342,92@3882L1149:PlannerScreen.kt#auin6u");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2108977656, $changed2, -1, "com.easycompra.app.ui.planner.PlannerScreen.<anonymous> (PlannerScreen.kt:92)");
                        }
                        TopAppBarColors topAppBarColorsM2885topAppBarColorszjMxDiM = TopAppBarDefaults.INSTANCE.m2885topAppBarColorszjMxDiM(MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getPrimary(), 0L, 0L, Color.INSTANCE.m4218getWhite0d7_KjU(), Color.INSTANCE.m4218getWhite0d7_KjU(), $composer4, (TopAppBarDefaults.$stable << 15) | 27648, 6);
                        final State<PlannerUiState> state = state$delegate;
                        AppBarKt.m1794TopAppBarGHTll3U(ComposableLambdaKt.rememberComposableLambda(1217154740, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.planner.PlannerScreenKt.PlannerScreen.2.1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer5, int $changed3) {
                                ComposerKt.sourceInformation($composer5, "C94@3939L209:PlannerScreen.kt#auin6u");
                                if (($changed3 & 3) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1217154740, $changed3, -1, "com.easycompra.app.ui.planner.PlannerScreen.<anonymous>.<anonymous> (PlannerScreen.kt:94)");
                                    }
                                    State<PlannerUiState> state2 = state;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                                    Modifier modifier$iv = Modifier.INSTANCE;
                                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                    Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                                    MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer5, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                    int $changed$iv$iv = (0 << 3) & 112;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                    int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer5, 0);
                                    CompositionLocalMap localMap$iv$iv = $composer5.getCurrentCompositionLocalMap();
                                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer5, modifier$iv);
                                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                    if (!($composer5.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    $composer5.startReusableNode();
                                    if ($composer5.getInserting()) {
                                        $composer5.createNode(constructor);
                                    } else {
                                        $composer5.useNode();
                                    }
                                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3674constructorimpl($composer5);
                                    Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                    Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                    if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                        $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                        $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                                    }
                                    Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                                    int i = ($changed$iv$iv$iv >> 6) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer5, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                    int i2 = ((0 >> 6) & 112) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer5, 150419926, "C95@3972L58,96@4055L71:PlannerScreen.kt#auin6u");
                                    TextKt.m2714Text4IGK_g("Planificador semanal", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer5, 196614, 0, 131038);
                                    String weekLabel = PlannerScreenKt.PlannerScreen$lambda$0(state2).getWeekLabel();
                                    long sp = TextUnitKt.getSp(12);
                                    long jM4218getWhite0d7_KjU = Color.INSTANCE.m4218getWhite0d7_KjU();
                                    TextKt.m2714Text4IGK_g(weekLabel, (Modifier) null, Color.m4179copywmQWz5c(jM4218getWhite0d7_KjU, (14 & 1) != 0 ? Color.m4183getAlphaimpl(jM4218getWhite0d7_KjU) : 0.8f, (14 & 2) != 0 ? Color.m4187getRedimpl(jM4218getWhite0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m4186getGreenimpl(jM4218getWhite0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m4184getBlueimpl(jM4218getWhite0d7_KjU) : 0.0f), sp, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer5, 3456, 0, 131058);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    $composer5.endNode();
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    ComposerKt.sourceInformationMarkerEnd($composer5);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }, $composer4, 54), null, ComposableLambdaKt.rememberComposableLambda(605885682, true, new C01692(viewModel), $composer4, 54), ComposableLambdaKt.rememberComposableLambda(-1541494423, true, new AnonymousClass3(viewModel), $composer4, 54), 0.0f, null, topAppBarColorsM2885topAppBarColorszjMxDiM, null, $composer4, 3462, 178);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }

                /* JADX INFO: renamed from: com.easycompra.app.ui.planner.PlannerScreenKt$PlannerScreen$2$2, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: PlannerScreen.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                static final class C01692 implements Function2<Composer, Integer, Unit> {
                    final /* synthetic */ PlannerViewModel $viewModel;

                    C01692(PlannerViewModel plannerViewModel) {
                        this.$viewModel = plannerViewModel;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$1$lambda$0(PlannerViewModel $viewModel) {
                        $viewModel.prevWeek();
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer, int $changed) {
                        Object value$iv;
                        ComposerKt.sourceInformation($composer, "C105@4505L24,105@4484L145:PlannerScreen.kt#auin6u");
                        if (($changed & 3) == 2 && $composer.getSkipping()) {
                            $composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(605885682, $changed, -1, "com.easycompra.app.ui.planner.PlannerScreen.<anonymous>.<anonymous> (PlannerScreen.kt:105)");
                        }
                        $composer.startReplaceGroup(1295920620);
                        ComposerKt.sourceInformation($composer, "CC(remember):PlannerScreen.kt#9igjgp");
                        boolean invalid$iv = $composer.changedInstance(this.$viewModel);
                        final PlannerViewModel plannerViewModel = this.$viewModel;
                        Object it$iv = $composer.rememberedValue();
                        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = new Function0() { // from class: com.easycompra.app.ui.planner.PlannerScreenKt$PlannerScreen$2$2$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return PlannerScreenKt.AnonymousClass2.C01692.invoke$lambda$1$lambda$0(plannerViewModel);
                                }
                            };
                            $composer.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        $composer.endReplaceGroup();
                        IconButtonKt.IconButton((Function0) value$iv, null, false, null, null, ComposableSingletons$PlannerScreenKt.INSTANCE.m7155getLambda1$app_debug(), $composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }

                /* JADX INFO: renamed from: com.easycompra.app.ui.planner.PlannerScreenKt$PlannerScreen$2$3, reason: invalid class name */
                /* JADX INFO: compiled from: PlannerScreen.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                static final class AnonymousClass3 implements Function3<RowScope, Composer, Integer, Unit> {
                    final /* synthetic */ PlannerViewModel $viewModel;

                    AnonymousClass3(PlannerViewModel plannerViewModel) {
                        this.$viewModel = plannerViewModel;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                        invoke(rowScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$1$lambda$0(PlannerViewModel $viewModel) {
                        $viewModel.goToCurrentWeek();
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope TopAppBar, Composer $composer, int $changed) {
                        Object value$iv;
                        Object value$iv2;
                        Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
                        ComposerKt.sourceInformation($composer, "C110@4718L31,110@4697L134,113@4873L24,113@4852L147:PlannerScreen.kt#auin6u");
                        if (($changed & 17) == 16 && $composer.getSkipping()) {
                            $composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1541494423, $changed, -1, "com.easycompra.app.ui.planner.PlannerScreen.<anonymous>.<anonymous> (PlannerScreen.kt:110)");
                        }
                        $composer.startReplaceGroup(1295927443);
                        ComposerKt.sourceInformation($composer, "CC(remember):PlannerScreen.kt#9igjgp");
                        boolean invalid$iv = $composer.changedInstance(this.$viewModel);
                        final PlannerViewModel plannerViewModel = this.$viewModel;
                        Object it$iv = $composer.rememberedValue();
                        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv = new Function0() { // from class: com.easycompra.app.ui.planner.PlannerScreenKt$PlannerScreen$2$3$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return PlannerScreenKt.AnonymousClass2.AnonymousClass3.invoke$lambda$1$lambda$0(plannerViewModel);
                                }
                            };
                            $composer.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        $composer.endReplaceGroup();
                        IconButtonKt.IconButton((Function0) value$iv, null, false, null, null, ComposableSingletons$PlannerScreenKt.INSTANCE.m7156getLambda2$app_debug(), $composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                        $composer.startReplaceGroup(1295932396);
                        ComposerKt.sourceInformation($composer, "CC(remember):PlannerScreen.kt#9igjgp");
                        boolean invalid$iv2 = $composer.changedInstance(this.$viewModel);
                        final PlannerViewModel plannerViewModel2 = this.$viewModel;
                        Object it$iv2 = $composer.rememberedValue();
                        if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv2 = new Function0() { // from class: com.easycompra.app.ui.planner.PlannerScreenKt$PlannerScreen$2$3$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return PlannerScreenKt.AnonymousClass2.AnonymousClass3.invoke$lambda$3$lambda$2(plannerViewModel2);
                                }
                            };
                            $composer.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv2;
                        }
                        $composer.endReplaceGroup();
                        IconButtonKt.IconButton((Function0) value$iv2, null, false, null, null, ComposableSingletons$PlannerScreenKt.INSTANCE.m7157getLambda3$app_debug(), $composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$3$lambda$2(PlannerViewModel $viewModel) {
                        $viewModel.nextWeek();
                        return Unit.INSTANCE;
                    }
                }
            }, $composer3, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1217360771, z, new AnonymousClass3(state$delegate, viewModel), $composer3, 54), $composer3, 805306416, 509);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.planner.PlannerScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PlannerScreenKt.PlannerScreen$lambda$11(viewModel, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlannerUiState PlannerScreen$lambda$0(State<PlannerUiState> state) {
        Object thisObj$iv = state.getValue();
        return (PlannerUiState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlannerScreen$lambda$10$lambda$2$lambda$1(PlannerViewModel $viewModel, String d, String s, String rId, String name, float servings, String notes) {
        Intrinsics.checkNotNullParameter(d, "d");
        Intrinsics.checkNotNullParameter(s, "s");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(notes, "notes");
        $viewModel.saveEntry(d, s, rId, name, servings, notes);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlannerScreen$lambda$10$lambda$4$lambda$3(PlannerViewModel $viewModel, String $date, String $slot) {
        $viewModel.clearSlot($date, $slot);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlannerScreen$lambda$10$lambda$7$lambda$6(State $state$delegate, PlannerViewModel $viewModel, String newDate, String newSlot) {
        Intrinsics.checkNotNullParameter(newDate, "newDate");
        Intrinsics.checkNotNullParameter(newSlot, "newSlot");
        PlannerEntry entry = PlannerScreen$lambda$0($state$delegate).getEditingEntry();
        if (entry != null) {
            $viewModel.moveEntry(entry, newDate, newSlot);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PlannerScreen$lambda$10$lambda$9$lambda$8(PlannerViewModel $viewModel) {
        $viewModel.dismissDialog();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.planner.PlannerScreenKt$PlannerScreen$3, reason: invalid class name */
    /* JADX INFO: compiled from: PlannerScreen.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass3 implements Function3<PaddingValues, Composer, Integer, Unit> {
        final /* synthetic */ State<PlannerUiState> $state$delegate;
        final /* synthetic */ PlannerViewModel $viewModel;

        AnonymousClass3(State<PlannerUiState> state, PlannerViewModel plannerViewModel) {
            this.$state$delegate = state;
            this.$viewModel = plannerViewModel;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer, Integer num) {
            invoke(paddingValues, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(PaddingValues padding, Composer $composer, int $changed) {
            Function0<ComposeUiNode> function0;
            Object value$iv;
            Object value$iv2;
            Object value$iv3;
            Intrinsics.checkNotNullParameter(padding, "padding");
            ComposerKt.sourceInformation($composer, "C120@5069L2838:PlannerScreen.kt#auin6u");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= $composer.changed(padding) ? 4 : 2;
            }
            if (($dirty & 19) != 18 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1217360771, $dirty, -1, "com.easycompra.app.ui.planner.PlannerScreen.<anonymous> (PlannerScreen.kt:120)");
                }
                Modifier modifier$iv = SizeKt.fillMaxSize$default(PaddingKt.padding(Modifier.INSTANCE, padding), 0.0f, 1, null);
                final State<PlannerUiState> state = this.$state$delegate;
                final PlannerViewModel plannerViewModel = this.$viewModel;
                ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv = (0 << 3) & 112;
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
                ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                int i2 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 1519628926, "C126@5364L32,127@5428L27,123@5224L245,133@5625L2272,130@5483L2414:PlannerScreen.kt#auin6u");
                List<LocalDate> weekDates = PlannerScreenKt.PlannerScreen$lambda$0(state).getWeekDates();
                int selectedDayIndex = PlannerScreenKt.PlannerScreen$lambda$0(state).getSelectedDayIndex();
                $composer.startReplaceGroup(1295948116);
                ComposerKt.sourceInformation($composer, "CC(remember):PlannerScreen.kt#9igjgp");
                boolean invalid$iv = $composer.changed(state);
                Object it$iv = $composer.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function1() { // from class: com.easycompra.app.ui.planner.PlannerScreenKt$PlannerScreen$3$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Integer.valueOf(PlannerScreenKt.AnonymousClass3.invoke$lambda$7$lambda$1$lambda$0(state, (LocalDate) obj));
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                Function1 function1 = (Function1) value$iv;
                $composer.endReplaceGroup();
                $composer.startReplaceGroup(1295950159);
                ComposerKt.sourceInformation($composer, "CC(remember):PlannerScreen.kt#9igjgp");
                boolean invalid$iv2 = $composer.changedInstance(plannerViewModel);
                Object it$iv2 = $composer.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = new Function1() { // from class: com.easycompra.app.ui.planner.PlannerScreenKt$PlannerScreen$3$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PlannerScreenKt.AnonymousClass3.invoke$lambda$7$lambda$3$lambda$2(plannerViewModel, ((Integer) obj).intValue());
                        }
                    };
                    $composer.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv2;
                }
                $composer.endReplaceGroup();
                PlannerScreenKt.WeekStrip(weekDates, selectedDayIndex, function1, (Function1) value$iv2, $composer, 0);
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.HorizontalOrVertical horizontalOrVerticalM561spacedBy0680j_4 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(0));
                $composer.startReplaceGroup(1295958708);
                ComposerKt.sourceInformation($composer, "CC(remember):PlannerScreen.kt#9igjgp");
                boolean invalid$iv3 = $composer.changed(state) | $composer.changedInstance(plannerViewModel);
                Object it$iv3 = $composer.rememberedValue();
                if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                    value$iv3 = new Function1() { // from class: com.easycompra.app.ui.planner.PlannerScreenKt$PlannerScreen$3$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PlannerScreenKt.AnonymousClass3.invoke$lambda$7$lambda$6$lambda$5(state, plannerViewModel, (LazyListScope) obj);
                        }
                    };
                    $composer.updateRememberedValue(value$iv3);
                } else {
                    value$iv3 = it$iv3;
                }
                $composer.endReplaceGroup();
                LazyDslKt.LazyColumn(modifierFillMaxSize$default, null, null, false, horizontalOrVerticalM561spacedBy0680j_4, null, null, false, (Function1) value$iv3, $composer, 24582, 238);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int invoke$lambda$7$lambda$1$lambda$0(State $state$delegate, LocalDate it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return PlannerScreenKt.PlannerScreen$lambda$0($state$delegate).entryStatusForDate(it);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$7$lambda$3$lambda$2(PlannerViewModel $viewModel, int it) {
            $viewModel.selectDay(it);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$7$lambda$6$lambda$5(State $state$delegate, PlannerViewModel $viewModel, LazyListScope LazyColumn) {
            Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
            final LocalDate selectedDate = PlannerScreenKt.PlannerScreen$lambda$0($state$delegate).getWeekDates().get(PlannerScreenKt.PlannerScreen$lambda$0($state$delegate).getSelectedDayIndex());
            Map<String, PlannerEntry> mapEntriesForDate = PlannerScreenKt.PlannerScreen$lambda$0($state$delegate).entriesForDate(selectedDate);
            WeekAnalysis analysis = PlannerScreenKt.PlannerScreen$lambda$0($state$delegate).getAnalysis();
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1238638521, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.planner.PlannerScreenKt$PlannerScreen$3$1$3$1$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                    invoke(lazyItemScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
                    Intrinsics.checkNotNullParameter(item, "$this$item");
                    ComposerKt.sourceInformation($composer, "C146@6373L11,149@6536L11,140@5942L730:PlannerScreen.kt#auin6u");
                    if (($changed & 17) == 16 && $composer.getSkipping()) {
                        $composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1238638521, $changed, -1, "com.easycompra.app.ui.planner.PlannerScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PlannerScreen.kt:140)");
                    }
                    String displayName = selectedDate.getDayOfWeek().getDisplayName(java.time.format.TextStyle.FULL, new Locale("es"));
                    Intrinsics.checkNotNullExpressionValue(displayName, "getDisplayName(...)");
                    if (displayName.length() > 0) {
                        StringBuilder sb = new StringBuilder();
                        char it = displayName.charAt(0);
                        String strValueOf = String.valueOf(it);
                        Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
                        String upperCase = strValueOf.toUpperCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                        StringBuilder sbAppend = sb.append((Object) upperCase);
                        String strSubstring = displayName.substring(1);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                        displayName = sbAppend.append(strSubstring).toString();
                    }
                    String str = displayName + ", " + selectedDate.getDayOfMonth() + " de " + selectedDate.getMonth().getDisplayName(java.time.format.TextStyle.FULL, new Locale("es"));
                    FontWeight bold = FontWeight.INSTANCE.getBold();
                    long primary = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary();
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    long primaryContainer = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimaryContainer();
                    TextKt.m2714Text4IGK_g(str, PaddingKt.m682paddingVpY3zN4(BackgroundKt.m236backgroundbw27NRU$default(modifierFillMaxWidth$default, Color.m4179copywmQWz5c(primaryContainer, (14 & 1) != 0 ? Color.m4183getAlphaimpl(primaryContainer) : 0.3f, (14 & 2) != 0 ? Color.m4187getRedimpl(primaryContainer) : 0.0f, (14 & 4) != 0 ? Color.m4186getGreenimpl(primaryContainer) : 0.0f, (14 & 8) != 0 ? Color.m4184getBlueimpl(primaryContainer) : 0.0f), null, 2, null), Dp.m6663constructorimpl(16), Dp.m6663constructorimpl(8)), primary, 0L, (FontStyle) null, bold, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 131032);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 3, null);
            Iterable $this$forEach$iv = MealSlots.INSTANCE.getAll();
            for (Object element$iv : $this$forEach$iv) {
                String slot = (String) element$iv;
                LazyListScope.item$default(LazyColumn, "slot_" + selectedDate + "_" + slot, null, ComposableLambdaKt.composableLambdaInstance(-1622605941, true, new PlannerScreenKt$PlannerScreen$3$1$3$1$2$1(slot, mapEntriesForDate, analysis, $viewModel, selectedDate)), 2, null);
            }
            if (!analysis.isLoading() && ((!analysis.getMissingIngredients().isEmpty()) || (!analysis.getDefrostAlerts().isEmpty()) || (!analysis.getPantryTips().isEmpty()))) {
                LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1147413698, true, new PlannerScreenKt$PlannerScreen$3$1$3$1$3(analysis, $viewModel)), 3, null);
            }
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$PlannerScreenKt.INSTANCE.m7158getLambda4$app_debug(), 3, null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void WeekStrip(final List<LocalDate> list, final int selectedIndex, final Function1<? super LocalDate, Integer> function1, final Function1<? super Integer, Unit> function2, Composer $composer, final int $changed) {
        Function0<ComposeUiNode> function0;
        int $dirty;
        long jM4216getTransparent0d7_KjU;
        Object value$iv;
        Function0<ComposeUiNode> function3;
        Function0<ComposeUiNode> function4;
        int i = selectedIndex;
        Function1<? super LocalDate, Integer> function5 = function1;
        final Function1<? super Integer, Unit> function6 = function2;
        Composer $composer2 = $composer.startRestartGroup(-843547983);
        ComposerKt.sourceInformation($composer2, "C(WeekStrip)P(!1,3)196@8213L11,193@8114L2541,251@10660L19:PlannerScreen.kt#auin6u");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(i) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changedInstance(function5) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changedInstance(function6) ? 2048 : 1024;
        }
        int $dirty3 = $dirty2;
        if (($dirty3 & 1171) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-843547983, $dirty3, -1, "com.easycompra.app.ui.planner.WeekStrip (PlannerScreen.kt:191)");
            }
            LocalDate today = LocalDate.now();
            Modifier modifier$iv = PaddingKt.m683paddingVpY3zN4$default(BackgroundKt.m236backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getSurface(), null, 2, null), 0.0f, Dp.m6663constructorimpl(6), 1, null);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceEvenly();
            ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv = (48 << 3) & 112;
            String str = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
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
            String str2 = "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo";
            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int $changed$iv = ($changed$iv$iv$iv >> 6) & 14;
            Composer $composer$iv = $composer2;
            int i2 = 0;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            int i3 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 530685672, "C:PlannerScreen.kt#auin6u");
            $composer$iv.startReplaceGroup(-1645448907);
            ComposerKt.sourceInformation($composer$iv, "*222@9434L20,207@8668L1971");
            List<LocalDate> $this$forEachIndexed$iv = list;
            int $i$f$forEachIndexed = 0;
            int index$iv = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Iterable $this$forEachIndexed$iv2 = $this$forEachIndexed$iv;
                LocalDate date = (LocalDate) item$iv;
                final int idx = index$iv;
                boolean isSelected = idx == i;
                boolean isToday = Intrinsics.areEqual(date, today);
                LocalDate today2 = today;
                int count = function5.invoke(date).intValue();
                Modifier materialized$iv$iv2 = materialized$iv$iv;
                int $changed$iv2 = $changed$iv;
                String dayName = date.getDayOfWeek().getDisplayName(java.time.format.TextStyle.SHORT, new Locale("es"));
                Intrinsics.checkNotNullExpressionValue(dayName, "getDisplayName(...)");
                if (dayName.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    char it = dayName.charAt(0);
                    String strValueOf = String.valueOf(it);
                    Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
                    String upperCase = strValueOf.toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    StringBuilder sbAppend = sb.append((Object) upperCase);
                    String strSubstring = dayName.substring(1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    dayName = sbAppend.append(strSubstring).toString();
                }
                Modifier modifierClip = ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.m964RoundedCornerShape0680j_4(Dp.m6663constructorimpl(10)));
                if (isSelected) {
                    $composer$iv.startReplaceGroup(780877313);
                    ComposerKt.sourceInformation($composer$iv, "212@8885L11");
                    long primary = MaterialTheme.INSTANCE.getColorScheme($composer$iv, MaterialTheme.$stable).getPrimary();
                    $composer$iv.endReplaceGroup();
                    jM4216getTransparent0d7_KjU = primary;
                } else if (!isToday) {
                    $composer$iv.startReplaceGroup(780881893);
                    $composer$iv.endReplaceGroup();
                    jM4216getTransparent0d7_KjU = Color.INSTANCE.m4216getTransparent0d7_KjU();
                } else {
                    $composer$iv.startReplaceGroup(780880196);
                    ComposerKt.sourceInformation($composer$iv, "213@8958L11");
                    long primaryContainer = MaterialTheme.INSTANCE.getColorScheme($composer$iv, MaterialTheme.$stable).getPrimaryContainer();
                    long jM4179copywmQWz5c = Color.m4179copywmQWz5c(primaryContainer, (14 & 1) != 0 ? Color.m4183getAlphaimpl(primaryContainer) : 0.4f, (14 & 2) != 0 ? Color.m4187getRedimpl(primaryContainer) : 0.0f, (14 & 4) != 0 ? Color.m4186getGreenimpl(primaryContainer) : 0.0f, (14 & 8) != 0 ? Color.m4184getBlueimpl(primaryContainer) : 0.0f);
                    $composer$iv.endReplaceGroup();
                    jM4216getTransparent0d7_KjU = jM4179copywmQWz5c;
                }
                Modifier modifierM236backgroundbw27NRU$default = BackgroundKt.m236backgroundbw27NRU$default(modifierClip, jM4216getTransparent0d7_KjU, null, 2, null);
                float fM6663constructorimpl = (!isToday || isSelected) ? Dp.m6663constructorimpl(0) : Dp.m6663constructorimpl(1);
                $composer$iv.startReplaceGroup(-1645422769);
                ComposerKt.sourceInformation($composer$iv, "219@9279L11");
                Composer $composer$iv2 = $composer$iv;
                long jM4216getTransparent0d7_KjU2 = (!isToday || isSelected) ? Color.INSTANCE.m4216getTransparent0d7_KjU() : MaterialTheme.INSTANCE.getColorScheme($composer$iv, MaterialTheme.$stable).getPrimary();
                $composer$iv.endReplaceGroup();
                int $i$f$forEachIndexed2 = $i$f$forEachIndexed;
                Modifier modifierM247borderxT4_qwU = BorderKt.m247borderxT4_qwU(modifierM236backgroundbw27NRU$default, fM6663constructorimpl, jM4216getTransparent0d7_KjU2, RoundedCornerShapeKt.m964RoundedCornerShape0680j_4(Dp.m6663constructorimpl(10)));
                $composer$iv.startReplaceGroup(780894510);
                ComposerKt.sourceInformation($composer$iv, "CC(remember):PlannerScreen.kt#9igjgp");
                boolean invalid$iv = (($dirty3 & 7168) == 2048) | $composer2.changed(idx);
                Object it$iv = $composer$iv.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function0() { // from class: com.easycompra.app.ui.planner.PlannerScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PlannerScreenKt.WeekStrip$lambda$19$lambda$18$lambda$14$lambda$13(function6, idx);
                        }
                    };
                    $composer$iv.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                $composer$iv.endReplaceGroup();
                Modifier modifier$iv2 = PaddingKt.m682paddingVpY3zN4(ClickableKt.m269clickableXHw0xAI$default(modifierM247borderxT4_qwU, false, null, null, (Function0) value$iv, 7, null), Dp.m6663constructorimpl(8), Dp.m6663constructorimpl(4));
                Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getCenterHorizontally();
                ComposerKt.sourceInformationMarkerStart($composer$iv, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer$iv, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                int $changed$iv$iv2 = (384 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv, -1323940314, str);
                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer$iv, 0);
                CompositionLocalMap localMap$iv$iv2 = $composer$iv.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer$iv, modifier$iv2);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer$iv.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv.startReusableNode();
                if ($composer$iv.getInserting()) {
                    function3 = constructor2;
                    $composer$iv.createNode(function3);
                } else {
                    function3 = constructor2;
                    $composer$iv.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3674constructorimpl($composer$iv);
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                }
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                int i5 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv, 792985981, "C226@9620L170,231@9807L300,238@10166L459:PlannerScreen.kt#auin6u");
                String strTake = StringsKt.take(dayName, 2);
                long sp = TextUnitKt.getSp(11);
                Color.Companion companion = Color.INSTANCE;
                TextKt.m2714Text4IGK_g(strTake, (Modifier) null, isSelected ? companion.m4218getWhite0d7_KjU() : companion.m4211getGray0d7_KjU(), sp, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer$iv, 3072, 0, 131058);
                String strValueOf2 = String.valueOf(date.getDayOfMonth());
                FontWeight bold = (isSelected || isToday) ? FontWeight.INSTANCE.getBold() : FontWeight.INSTANCE.getNormal();
                long sp2 = TextUnitKt.getSp(15);
                $composer$iv.startReplaceGroup(1272518077);
                ComposerKt.sourceInformation($composer$iv, "235@10068L11");
                long jM4218getWhite0d7_KjU = isSelected ? Color.INSTANCE.m4218getWhite0d7_KjU() : MaterialTheme.INSTANCE.getColorScheme($composer$iv, MaterialTheme.$stable).getOnSurface();
                $composer$iv.endReplaceGroup();
                TextKt.m2714Text4IGK_g(strValueOf2, (Modifier) null, jM4218getWhite0d7_KjU, sp2, (FontStyle) null, bold, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer$iv, 3072, 0, 131026);
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(2));
                String str3 = str2;
                ComposerKt.sourceInformationMarkerStart($composer$iv, 693286680, str3);
                Modifier modifier$iv3 = Modifier.INSTANCE;
                Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getTop();
                int $changed$iv3 = ((48 >> 3) & 14) | ((48 >> 3) & 112);
                MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer$iv, $changed$iv3);
                int $changed$iv$iv3 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer$iv, -1323940314, str);
                int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer$iv, 0);
                CompositionLocalMap localMap$iv$iv3 = $composer$iv.getCurrentCompositionLocalMap();
                String str4 = str;
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer$iv, modifier$iv3);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer$iv.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer$iv.startReusableNode();
                if ($composer$iv.getInserting()) {
                    function4 = constructor3;
                    $composer$iv.createNode(function4);
                } else {
                    function4 = constructor3;
                    $composer$iv.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3674constructorimpl($composer$iv);
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                    $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                    $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
                }
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                int i6 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer$iv, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                int i7 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv, -279711456, "C:PlannerScreen.kt#auin6u");
                $composer$iv.startReplaceGroup(1376450371);
                ComposerKt.sourceInformation($composer$iv, "*240@10300L285");
                int iCoerceAtMost = RangesKt.coerceAtMost(count, 4);
                int i8 = 0;
                while (i8 < iCoerceAtMost) {
                    int count2 = count;
                    int i9 = iCoerceAtMost;
                    int $changed$iv$iv$iv4 = $changed$iv$iv$iv3;
                    Modifier modifierClip2 = ClipKt.clip(SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(4)), RoundedCornerShapeKt.getCircleShape());
                    $composer$iv.startReplaceGroup(1376458010);
                    ComposerKt.sourceInformation($composer$iv, "244@10539L11");
                    long jM4218getWhite0d7_KjU2 = isSelected ? Color.INSTANCE.m4218getWhite0d7_KjU() : MaterialTheme.INSTANCE.getColorScheme($composer$iv, MaterialTheme.$stable).getPrimary();
                    $composer$iv.endReplaceGroup();
                    BoxKt.Box(BackgroundKt.m236backgroundbw27NRU$default(modifierClip2, jM4218getWhite0d7_KjU2, null, 2, null), $composer$iv, 0);
                    i8++;
                    iCoerceAtMost = i9;
                    count = count2;
                    $changed$iv$iv$iv3 = $changed$iv$iv$iv4;
                }
                $composer$iv.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                $composer$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                i = selectedIndex;
                function5 = function1;
                function6 = function2;
                $dirty3 = $dirty3;
                i2 = i2;
                index$iv = index$iv2;
                $this$forEachIndexed$iv = $this$forEachIndexed$iv2;
                materialized$iv$iv = materialized$iv$iv2;
                today = today2;
                $changed$iv = $changed$iv2;
                $i$f$forEachIndexed = $i$f$forEachIndexed2;
                $composer$iv = $composer$iv2;
                str2 = str3;
                str = str4;
            }
            $dirty = $dirty3;
            $composer$iv.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            DividerKt.m2093HorizontalDivider9IZ8Weo(null, 0.0f, 0L, $composer2, 0, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            $dirty = $dirty3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.planner.PlannerScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PlannerScreenKt.WeekStrip$lambda$20(list, selectedIndex, function1, function2, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WeekStrip$lambda$19$lambda$18$lambda$14$lambda$13(Function1 $onSelectDay, int $idx) {
        $onSelectDay.invoke(Integer.valueOf($idx));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:72:0x00fa  */
    public static final void MealSlotCard(final String slot, final PlannerEntry entry, final WeekAnalysis analysis, final Function0<Unit> function0, Composer $composer, final int $changed) {
        boolean z;
        int $dirty;
        long jM4179copywmQWz5c;
        boolean z2;
        boolean z3;
        Composer $composer2 = $composer.startRestartGroup(-1707105816);
        ComposerKt.sourceInformation($composer2, "C(MealSlotCard)P(3,1)270@11215L262,277@11512L48,278@11567L1982,264@10979L2570:PlannerScreen.kt#auin6u");
        int $dirty2 = $changed;
        if (($changed & 6) == 0) {
            $dirty2 |= $composer2.changed(slot) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty2 |= $composer2.changed(entry) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty2 |= $composer2.changedInstance(analysis) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 2048 : 1024;
        }
        int $dirty3 = $dirty2;
        if (($dirty3 & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            $dirty = $dirty3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1707105816, $dirty3, -1, "com.easycompra.app.ui.planner.MealSlotCard (PlannerScreen.kt:260)");
            }
            if ((entry != null ? entry.getRecipeId() : null) != null) {
                Iterable $this$any$iv = analysis.getMissingIngredients();
                if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                    Iterator it = $this$any$iv.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z2 = false;
                            break;
                        }
                        Object element$iv = it.next();
                        IngredientNeed need = (IngredientNeed) element$iv;
                        Iterable $this$any$iv2 = need.getRecipeNames();
                        if (!($this$any$iv2 instanceof Collection) || !((Collection) $this$any$iv2).isEmpty()) {
                            Iterator it2 = $this$any$iv2.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    z3 = false;
                                    break;
                                }
                                Object element$iv2 = it2.next();
                                String it3 = (String) element$iv2;
                                Iterator it4 = it2;
                                if (Intrinsics.areEqual(it3, entry.getDisplayName())) {
                                    z3 = true;
                                    break;
                                }
                                it2 = it4;
                            }
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            z2 = true;
                            break;
                        }
                    }
                } else {
                    z2 = false;
                }
                if (z2) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            final boolean hasMissing = z;
            $dirty = $dirty3;
            Modifier modifierM269clickableXHw0xAI$default = ClickableKt.m269clickableXHw0xAI$default(PaddingKt.m682paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6663constructorimpl(12), Dp.m6663constructorimpl(4)), false, null, null, function0, 7, null);
            RoundedCornerShape roundedCornerShapeM964RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m964RoundedCornerShape0680j_4(Dp.m6663constructorimpl(10));
            CardDefaults cardDefaults = CardDefaults.INSTANCE;
            if (hasMissing) {
                $composer2.startReplaceGroup(-946404950);
                $composer2.endReplaceGroup();
                jM4179copywmQWz5c = ColorKt.Color(4294964173L);
            } else if (entry != null) {
                $composer2.startReplaceGroup(-946402496);
                ComposerKt.sourceInformation($composer2, "273@11358L11");
                jM4179copywmQWz5c = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getSurface();
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-946400157);
                ComposerKt.sourceInformation($composer2, "274@11416L11");
                long surfaceVariant = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getSurfaceVariant();
                jM4179copywmQWz5c = Color.m4179copywmQWz5c(surfaceVariant, (14 & 1) != 0 ? Color.m4183getAlphaimpl(surfaceVariant) : 0.5f, (14 & 2) != 0 ? Color.m4187getRedimpl(surfaceVariant) : 0.0f, (14 & 4) != 0 ? Color.m4186getGreenimpl(surfaceVariant) : 0.0f, (14 & 8) != 0 ? Color.m4184getBlueimpl(surfaceVariant) : 0.0f);
                $composer2.endReplaceGroup();
            }
            CardColors cardColorsM1850cardColorsro_MJ88 = cardDefaults.m1850cardColorsro_MJ88(jM4179copywmQWz5c, 0L, 0L, 0L, $composer2, CardDefaults.$stable << 12, 14);
            CardDefaults cardDefaults2 = CardDefaults.INSTANCE;
            float fM6663constructorimpl = entry != null ? Dp.m6663constructorimpl(2) : Dp.m6663constructorimpl(0);
            int $i$f$getDp = CardDefaults.$stable;
            CardKt.Card(modifierM269clickableXHw0xAI$default, roundedCornerShapeM964RoundedCornerShape0680j_4, cardColorsM1850cardColorsro_MJ88, cardDefaults2.m1851cardElevationaqJV_2Y(fM6663constructorimpl, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer2, $i$f$getDp << 18, 62), null, ComposableLambdaKt.rememberComposableLambda(-654483402, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.planner.PlannerScreenKt.MealSlotCard.1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                    invoke(columnScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope Card, Composer $composer3, int $changed2) {
                    Function0<ComposeUiNode> function1;
                    Intrinsics.checkNotNullParameter(Card, "$this$Card");
                    ComposerKt.sourceInformation($composer3, "C279@11577L1966:PlannerScreen.kt#auin6u");
                    if (($changed2 & 17) != 16 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-654483402, $changed2, -1, "com.easycompra.app.ui.planner.MealSlotCard.<anonymous> (PlannerScreen.kt:279)");
                        }
                        Modifier modifierM682paddingVpY3zN4 = PaddingKt.m682paddingVpY3zN4(Modifier.INSTANCE, Dp.m6663constructorimpl(14), Dp.m6663constructorimpl(10));
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM561spacedBy0680j_4 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(10));
                        String str = slot;
                        PlannerEntry plannerEntry = entry;
                        boolean z4 = hasMissing;
                        ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalOrVerticalM561spacedBy0680j_4, centerVertically, $composer3, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                        int $changed$iv$iv = (438 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifierM682paddingVpY3zN4);
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
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
                        }
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                        int i2 = ((438 >> 6) & 112) | 6;
                        RowScope $this$invoke_u24lambda_u241 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer3, -129122544, "C284@11809L44,285@11866L1196:PlannerScreen.kt#auin6u");
                        TextKt.m2714Text4IGK_g(MealSlots.INSTANCE.icon(str), (Modifier) null, 0L, TextUnitKt.getSp(20), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 3072, 0, 131062);
                        Modifier modifier$iv = RowScope.weight$default($this$invoke_u24lambda_u241, Modifier.INSTANCE, 1.0f, false, 2, null);
                        ComposerKt.sourceInformationMarkerStart($composer3, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv2 = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            function1 = constructor2;
                            $composer3.createNode(function1);
                        } else {
                            function1 = constructor2;
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3674constructorimpl($composer3);
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                            $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                            $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                        }
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                        int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i4 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 393664680, "C286@11923L178:PlannerScreen.kt#auin6u");
                        TextKt.m2714Text4IGK_g(str, (Modifier) null, Color.INSTANCE.m4211getGray0d7_KjU(), TextUnitKt.getSp(11), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 200064, 0, 131026);
                        if (plannerEntry != null) {
                            $composer3.startReplaceGroup(393867109);
                            ComposerKt.sourceInformation($composer3, "293@12159L265,307@12859L11,304@12677L227");
                            TextKt.m2714Text4IGK_g(plannerEntry.getDisplayName(), (Modifier) null, 0L, TextUnitKt.getSp(14), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6580getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 199680, 3120, 120790);
                            $composer3.startReplaceGroup(-1649853413);
                            ComposerKt.sourceInformation($composer3, "301@12501L55");
                            if (!StringsKt.isBlank(plannerEntry.getNotes())) {
                                TextKt.m2714Text4IGK_g(plannerEntry.getNotes(), (Modifier) null, Color.INSTANCE.m4211getGray0d7_KjU(), TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 3456, 0, 131058);
                            }
                            $composer3.endReplaceGroup();
                            if (plannerEntry.getRecipeId() != null) {
                                if (!(plannerEntry.getServings() == 1.0f)) {
                                    TextKt.m2714Text4IGK_g("Para " + PlannerScreenKt.formatServings(plannerEntry.getServings()) + " porciones", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary(), TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 3072, 0, 131058);
                                }
                            }
                            $composer3.endReplaceGroup();
                        } else {
                            $composer3.startReplaceGroup(394651626);
                            ComposerKt.sourceInformation($composer3, "311@12972L58");
                            TextKt.m2714Text4IGK_g("Añadir…", (Modifier) null, Color.INSTANCE.m4213getLightGray0d7_KjU(), TextUnitKt.getSp(13), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 3462, 0, 131058);
                            $composer3.endReplaceGroup();
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (plannerEntry != null) {
                            $composer3.startReplaceGroup(-127894542);
                            ComposerKt.sourceInformation($composer3, "");
                            if (z4) {
                                $composer3.startReplaceGroup(-127865433);
                                ComposerKt.sourceInformation($composer3, "316@13150L28");
                                TextKt.m2714Text4IGK_g("⚠️", (Modifier) null, 0L, TextUnitKt.getSp(18), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 3078, 0, 131062);
                                $composer3.endReplaceGroup();
                            } else if (plannerEntry.getRecipeId() != null) {
                                $composer3.startReplaceGroup(-127764280);
                                ComposerKt.sourceInformation($composer3, "318@13252L27");
                                TextKt.m2714Text4IGK_g("✅", (Modifier) null, 0L, TextUnitKt.getSp(16), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 3078, 0, 131062);
                                $composer3.endReplaceGroup();
                            } else {
                                $composer3.startReplaceGroup(-127699893);
                                $composer3.endReplaceGroup();
                            }
                            $composer3.endReplaceGroup();
                        } else {
                            $composer3.startReplaceGroup(-127673357);
                            ComposerKt.sourceInformation($composer3, "321@13335L184");
                            IconKt.m2171Iconww6aTOc(AddKt.getAdd(Icons.INSTANCE.getDefault()), (String) null, SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(20)), Color.INSTANCE.m4213getLightGray0d7_KjU(), $composer3, 3504, 0);
                            $composer3.endReplaceGroup();
                        }
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.planner.PlannerScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PlannerScreenKt.MealSlotCard$lambda$23(slot, entry, analysis, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AnalysisPanel(final WeekAnalysis analysis, final Function1<? super IngredientNeed, Unit> function1, Composer $composer, final int $changed) {
        Object value$iv;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-1463498989);
        ComposerKt.sourceInformation($composer3, "C(AnalysisPanel)337@13686L33,344@13944L11,344@13902L69,345@13978L4053,339@13725L4306:PlannerScreen.kt#auin6u");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(analysis) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 19) != 18 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1463498989, $dirty2, -1, "com.easycompra.app.ui.planner.AnalysisPanel (PlannerScreen.kt:336)");
            }
            $composer3.startReplaceGroup(2065404737);
            ComposerKt.sourceInformation($composer3, "CC(remember):PlannerScreen.kt#9igjgp");
            Object it$iv = $composer3.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MutableState expanded$delegate = (MutableState) value$iv;
            $composer3.endReplaceGroup();
            $composer2 = $composer3;
            CardKt.Card(PaddingKt.m683paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6663constructorimpl(12), 0.0f, 2, null), RoundedCornerShapeKt.m964RoundedCornerShape0680j_4(Dp.m6663constructorimpl(12)), CardDefaults.INSTANCE.m1850cardColorsro_MJ88(MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getSurfaceVariant(), 0L, 0L, 0L, $composer3, CardDefaults.$stable << 12, 14), null, null, ComposableLambdaKt.rememberComposableLambda(-114458747, true, new AnonymousClass1(expanded$delegate, analysis, function1), $composer2, 54), $composer2, 196614, 24);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.planner.PlannerScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PlannerScreenKt.AnalysisPanel$lambda$27(analysis, function1, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean AnalysisPanel$lambda$25(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AnalysisPanel$lambda$26(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.planner.PlannerScreenKt$AnalysisPanel$1, reason: invalid class name */
    /* JADX INFO: compiled from: PlannerScreen.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass1 implements Function3<ColumnScope, Composer, Integer, Unit> {
        final /* synthetic */ WeekAnalysis $analysis;
        final /* synthetic */ MutableState<Boolean> $expanded$delegate;
        final /* synthetic */ Function1<IngredientNeed, Unit> $onAddToCart;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(MutableState<Boolean> mutableState, WeekAnalysis weekAnalysis, Function1<? super IngredientNeed, Unit> function1) {
            this.$expanded$delegate = mutableState;
            this.$analysis = weekAnalysis;
            this.$onAddToCart = function1;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
            invoke(columnScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(ColumnScope Card, Composer $composer, int $changed) {
            Function0<ComposeUiNode> function0;
            Object value$iv;
            Function0<ComposeUiNode> function1;
            Intrinsics.checkNotNullParameter(Card, "$this$Card");
            ComposerKt.sourceInformation($composer, "C346@13988L4037:PlannerScreen.kt#auin6u");
            if (($changed & 17) != 16 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-114458747, $changed, -1, "com.easycompra.app.ui.planner.AnalysisPanel.<anonymous> (PlannerScreen.kt:346)");
                }
                final MutableState<Boolean> mutableState = this.$expanded$delegate;
                WeekAnalysis weekAnalysis = this.$analysis;
                Function1<IngredientNeed, Unit> function2 = this.$onAddToCart;
                ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                Modifier modifier$iv = Modifier.INSTANCE;
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv = (0 << 3) & 112;
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
                ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                int $changed2 = ((0 >> 6) & 112) | 6;
                ColumnScope $this$invoke_u24lambda_u243 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, -2082711364, "C351@14146L24,348@14038L685,371@14893L3122,367@14737L3278:PlannerScreen.kt#auin6u");
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                $composer.startReplaceGroup(625551926);
                ComposerKt.sourceInformation($composer, "CC(remember):PlannerScreen.kt#9igjgp");
                Object it$iv = $composer.rememberedValue();
                if (it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function0() { // from class: com.easycompra.app.ui.planner.PlannerScreenKt$AnalysisPanel$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PlannerScreenKt.AnonymousClass1.invoke$lambda$3$lambda$1$lambda$0(mutableState);
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                $composer.endReplaceGroup();
                Modifier modifier$iv2 = PaddingKt.m682paddingVpY3zN4(ClickableKt.m269clickableXHw0xAI$default(modifierFillMaxWidth$default, false, null, null, (Function0) value$iv, 7, null), Dp.m6663constructorimpl(14), Dp.m6663constructorimpl(10));
                Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                int $changed$iv$iv2 = (384 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    function1 = constructor2;
                    $composer.createNode(function1);
                } else {
                    function1 = constructor2;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3674constructorimpl($composer);
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                    $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                    $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash2);
                }
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                int i2 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                int i3 = ((384 >> 6) & 112) | 6;
                RowScope $this$invoke_u24lambda_u243_u24lambda_u242 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, 2090621551, "C355@14334L169,360@14520L189:PlannerScreen.kt#auin6u");
                TextKt.m2714Text4IGK_g("Análisis de la semana", RowScope.weight$default($this$invoke_u24lambda_u243_u24lambda_u242, Modifier.INSTANCE, 1.0f, false, 2, null), 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 196614, 0, 131036);
                IconKt.m2171Iconww6aTOc(PlannerScreenKt.AnalysisPanel$lambda$25(mutableState) ? KeyboardArrowUpKt.getKeyboardArrowUp(Icons.INSTANCE.getDefault()) : KeyboardArrowDownKt.getKeyboardArrowDown(Icons.INSTANCE.getDefault()), (String) null, (Modifier) null, Color.INSTANCE.m4211getGray0d7_KjU(), $composer, 3120, 4);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                AnimatedVisibilityKt.AnimatedVisibility($this$invoke_u24lambda_u243, PlannerScreenKt.AnalysisPanel$lambda$25(mutableState), (Modifier) null, EnterExitTransitionKt.expandVertically$default(null, null, false, null, 15, null), EnterExitTransitionKt.shrinkVertically$default(null, null, false, null, 15, null), (String) null, ComposableLambdaKt.rememberComposableLambda(108819795, true, new PlannerScreenKt$AnalysisPanel$1$1$3(weekAnalysis, function2), $composer, 54), $composer, ($changed2 & 14) | 1600512, 18);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$3$lambda$1$lambda$0(MutableState $expanded$delegate) {
            PlannerScreenKt.AnalysisPanel$lambda$26($expanded$delegate, !PlannerScreenKt.AnalysisPanel$lambda$25($expanded$delegate));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SectionLabel(final String text, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-2035460702);
        ComposerKt.sourceInformation($composer3, "C(SectionLabel)443@18210L11,439@18092L207:PlannerScreen.kt#auin6u");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(text) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 3) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2035460702, $dirty2, -1, "com.easycompra.app.ui.planner.SectionLabel (PlannerScreen.kt:438)");
            }
            $composer2 = $composer3;
            TextKt.m2714Text4IGK_g(text, PaddingKt.m685paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m6663constructorimpl(4), 0.0f, Dp.m6663constructorimpl(2), 5, null), MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary(), TextUnitKt.getSp(13), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, ($dirty2 & 14) | 199728, 0, 131024);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.planner.PlannerScreenKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PlannerScreenKt.SectionLabel$lambda$28(text, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String formatServings(float v) {
        if (v == ((float) ((int) v))) {
            return String.valueOf((int) v);
        }
        String str = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(v)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
