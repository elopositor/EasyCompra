package com.easycompra.app.ui.pantry;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
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
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.KeyboardArrowDownKt;
import androidx.compose.material.icons.filled.KeyboardArrowUpKt;
import androidx.compose.material.icons.filled.SwapVertKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.CheckboxKt;
import androidx.compose.material3.ChipKt;
import androidx.compose.material3.FloatingActionButtonKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextFieldColors;
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
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import com.easycompra.app.data.pantry.PantryLocationEntity;
import com.easycompra.app.data.pantry.PantryLocationEntityKt;
import com.easycompra.app.data.pantry.PantryProductEntity;
import com.easycompra.app.data.pantry.StockStatus;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: PantryScreen.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001a\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0003¢\u0006\u0002\u0010\r\u001a\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0003¢\u0006\u0002\u0010\r\u001a\u0089\u0001\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u00192\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u00192\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0019H\u0003¢\u0006\u0002\u0010\u001f\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006 ²\u0006\n\u0010!\u001a\u00020\"X\u008a\u0084\u0002²\u0006\n\u0010#\u001a\u00020\u0015X\u008a\u008e\u0002"}, d2 = {"ColorOK", "Landroidx/compose/ui/graphics/Color;", "J", "ColorLow", "ColorEmpty", "PantryScreen", "", "viewModel", "Lcom/easycompra/app/ui/pantry/PantryViewModel;", "(Lcom/easycompra/app/ui/pantry/PantryViewModel;Landroidx/compose/runtime/Composer;I)V", "CategoryHeader", HintConstants.AUTOFILL_HINT_NAME, "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "SubcategoryHeader", "PantryItemRow", "display", "Lcom/easycompra/app/ui/pantry/PantryLocationDisplay;", "limiteBajo", "", "reorderMode", "", "canMoveUp", "canMoveDown", "onIncrement", "Lkotlin/Function0;", "onDecrement", "onToggleNeedsBuy", "onDelete", "onMoveUp", "onMoveDown", "(Lcom/easycompra/app/ui/pantry/PantryLocationDisplay;FZZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "app_debug", "state", "Lcom/easycompra/app/ui/pantry/PantryUiState;", "menuExpanded"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PantryScreenKt {
    private static final long ColorOK = ColorKt.Color(4279286145L);
    private static final long ColorLow = ColorKt.Color(4294286859L);
    private static final long ColorEmpty = ColorKt.Color(4293870660L);

    /* JADX INFO: compiled from: PantryScreen.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StockStatus.values().length];
            try {
                iArr[StockStatus.OK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[StockStatus.LOW.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[StockStatus.EMPTY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CategoryHeader$lambda$6(String str, int i, Composer composer, int i2) {
        CategoryHeader(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PantryItemRow$lambda$11(PantryLocationDisplay pantryLocationDisplay, float f, boolean z, boolean z2, boolean z3, Function0 function0, Function0 function1, Function0 function2, Function0 function3, Function0 function4, Function0 function5, int i, int i2, Composer composer, int i3) {
        PantryItemRow(pantryLocationDisplay, f, z, z2, z3, function0, function1, function2, function3, function4, function5, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PantryScreen$lambda$5(PantryViewModel pantryViewModel, int i, Composer composer, int i2) {
        PantryScreen(pantryViewModel, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SubcategoryHeader$lambda$7(String str, int i, Composer composer, int i2) {
        SubcategoryHeader(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void PantryScreen(final PantryViewModel viewModel, Composer $composer, final int $changed) {
        Composer $composer2;
        Object value$iv;
        Object value$iv2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer $composer3 = $composer.startRestartGroup(443960456);
        ComposerKt.sourceInformation($composer3, "C(PantryScreen)71@3246L16,83@3580L2773,138@6386L228,145@6621L3908,82@3553L6976:PantryScreen.kt#mq3b12");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(viewModel) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 3) != 2 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(443960456, $dirty2, -1, "com.easycompra.app.ui.pantry.PantryScreen (PantryScreen.kt:70)");
            }
            final State state$delegate = SnapshotStateKt.collectAsState(viewModel.getUiState(), null, $composer3, 0, 1);
            $composer3.startReplaceGroup(1528304709);
            ComposerKt.sourceInformation($composer3, "75@3348L34,76@3408L123,74@3303L238");
            if (PantryScreen$lambda$0(state$delegate).getShowAddDialog()) {
                $composer3.startReplaceGroup(1528307024);
                ComposerKt.sourceInformation($composer3, "CC(remember):PantryScreen.kt#9igjgp");
                boolean invalid$iv = $composer3.changedInstance(viewModel);
                Object it$iv = $composer3.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function0() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PantryScreenKt.PantryScreen$lambda$2$lambda$1(viewModel);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                Function0 function0 = (Function0) value$iv;
                $composer3.endReplaceGroup();
                $composer3.startReplaceGroup(1528309033);
                ComposerKt.sourceInformation($composer3, "CC(remember):PantryScreen.kt#9igjgp");
                boolean invalid$iv2 = $composer3.changedInstance(viewModel);
                Object it$iv2 = $composer3.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = new Function6() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function6
                        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                            return PantryScreenKt.PantryScreen$lambda$4$lambda$3(viewModel, (String) obj, (String) obj2, (String) obj3, (String) obj4, ((Float) obj5).floatValue(), (String) obj6);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv2;
                }
                $composer3.endReplaceGroup();
                AddPantryItemDialogKt.AddPantryItemDialog(function0, (Function6) value$iv2, $composer3, 0);
            }
            $composer3.endReplaceGroup();
            $composer2 = $composer3;
            ScaffoldKt.m2429ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(-1009740724, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt.PantryScreen.3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C104@4669L11,103@4601L216,85@3629L927,108@4845L1484,84@3594L2749:PantryScreen.kt#mq3b12");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1009740724, $changed2, -1, "com.easycompra.app.ui.pantry.PantryScreen.<anonymous> (PantryScreen.kt:84)");
                        }
                        TopAppBarColors topAppBarColorsM2885topAppBarColorszjMxDiM = TopAppBarDefaults.INSTANCE.m2885topAppBarColorszjMxDiM(MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getPrimary(), 0L, 0L, Color.INSTANCE.m4218getWhite0d7_KjU(), Color.INSTANCE.m4218getWhite0d7_KjU(), $composer4, (TopAppBarDefaults.$stable << 15) | 27648, 6);
                        final State<PantryUiState> state = state$delegate;
                        AppBarKt.m1794TopAppBarGHTll3U(ComposableLambdaKt.rememberComposableLambda(1873555208, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt.PantryScreen.3.1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer5, int $changed3) {
                                ComposerKt.sourceInformation($composer5, "C87@3702L814:PantryScreen.kt#mq3b12");
                                if (($changed3 & 3) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1873555208, $changed3, -1, "com.easycompra.app.ui.pantry.PantryScreen.<anonymous>.<anonymous> (PantryScreen.kt:86)");
                                    }
                                    if (!PantryScreenKt.PantryScreen$lambda$0(state).getSearchActive()) {
                                        State<PantryUiState> state2 = state;
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
                                        ComposerKt.sourceInformationMarkerStart($composer5, 1200360137, "C88@3739L46:PantryScreen.kt#mq3b12");
                                        TextKt.m2714Text4IGK_g("Despensa", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer5, 196614, 0, 131038);
                                        $composer5.startReplaceGroup(-654013041);
                                        ComposerKt.sourceInformation($composer5, "90@3896L564");
                                        if (PantryScreenKt.PantryScreen$lambda$0(state2).getEmptyCount() > 0 || PantryScreenKt.PantryScreen$lambda$0(state2).getLowCount() > 0) {
                                            StringBuilder $this$invoke_u24lambda_u241_u24lambda_u240 = new StringBuilder();
                                            if (PantryScreenKt.PantryScreen$lambda$0(state2).getEmptyCount() > 0) {
                                                $this$invoke_u24lambda_u241_u24lambda_u240.append(PantryScreenKt.PantryScreen$lambda$0(state2).getEmptyCount() + " agotados");
                                            }
                                            if (PantryScreenKt.PantryScreen$lambda$0(state2).getEmptyCount() > 0 && PantryScreenKt.PantryScreen$lambda$0(state2).getLowCount() > 0) {
                                                $this$invoke_u24lambda_u241_u24lambda_u240.append("  ·  ");
                                            }
                                            if (PantryScreenKt.PantryScreen$lambda$0(state2).getLowCount() > 0) {
                                                $this$invoke_u24lambda_u241_u24lambda_u240.append(PantryScreenKt.PantryScreen$lambda$0(state2).getLowCount() + " pocos");
                                            }
                                            String string = $this$invoke_u24lambda_u241_u24lambda_u240.toString();
                                            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                                            long sp = TextUnitKt.getSp(12);
                                            long jM4218getWhite0d7_KjU = Color.INSTANCE.m4218getWhite0d7_KjU();
                                            TextKt.m2714Text4IGK_g(string, (Modifier) null, Color.m4179copywmQWz5c(jM4218getWhite0d7_KjU, (14 & 1) != 0 ? Color.m4183getAlphaimpl(jM4218getWhite0d7_KjU) : 0.8f, (14 & 2) != 0 ? Color.m4187getRedimpl(jM4218getWhite0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m4186getGreenimpl(jM4218getWhite0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m4184getBlueimpl(jM4218getWhite0d7_KjU) : 0.0f), sp, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer5, 3456, 0, 131058);
                                        }
                                        $composer5.endReplaceGroup();
                                        ComposerKt.sourceInformationMarkerEnd($composer5);
                                        ComposerKt.sourceInformationMarkerEnd($composer5);
                                        $composer5.endNode();
                                        ComposerKt.sourceInformationMarkerEnd($composer5);
                                        ComposerKt.sourceInformationMarkerEnd($composer5);
                                        ComposerKt.sourceInformationMarkerEnd($composer5);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }, $composer4, 54), null, null, ComposableLambdaKt.rememberComposableLambda(-1717949379, true, new AnonymousClass2(viewModel, state$delegate), $composer4, 54), 0.0f, null, topAppBarColorsM2885topAppBarColorszjMxDiM, null, $composer4, 3078, 182);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }

                /* JADX INFO: renamed from: com.easycompra.app.ui.pantry.PantryScreenKt$PantryScreen$3$2, reason: invalid class name */
                /* JADX INFO: compiled from: PantryScreen.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                static final class AnonymousClass2 implements Function3<RowScope, Composer, Integer, Unit> {
                    final /* synthetic */ State<PantryUiState> $state$delegate;
                    final /* synthetic */ PantryViewModel $viewModel;

                    AnonymousClass2(PantryViewModel pantryViewModel, State<PantryUiState> state) {
                        this.$viewModel = pantryViewModel;
                        this.$state$delegate = state;
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                        invoke(rowScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(RowScope TopAppBar, Composer $composer, int $changed) {
                        Object value$iv;
                        Object value$iv2;
                        Object value$iv3;
                        Object value$iv4;
                        Object value$iv5;
                        Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
                        ComposerKt.sourceInformation($composer, "C:PantryScreen.kt#mq3b12");
                        if (($changed & 17) == 16 && $composer.getSkipping()) {
                            $composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1717949379, $changed, -1, "com.easycompra.app.ui.pantry.PantryScreen.<anonymous>.<anonymous> (PantryScreen.kt:109)");
                        }
                        if (PantryScreenKt.PantryScreen$lambda$0(this.$state$delegate).getSearchActive()) {
                            $composer.startReplaceGroup(-581246514);
                            ComposerKt.sourceInformation($composer, "117@5430L36,112@5029L26,110@4917L576,119@5539L36,119@5518L159");
                            String query = PantryScreenKt.PantryScreen$lambda$0(this.$state$delegate).getQuery();
                            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(Modifier.INSTANCE, 0.75f);
                            KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m6305getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
                            $composer.startReplaceGroup(-434375408);
                            ComposerKt.sourceInformation($composer, "CC(remember):PantryScreen.kt#9igjgp");
                            boolean invalid$iv = $composer.changedInstance(this.$viewModel);
                            final PantryViewModel pantryViewModel = this.$viewModel;
                            Object it$iv = $composer.rememberedValue();
                            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                                value$iv3 = new Function1() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$PantryScreen$3$2$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return PantryScreenKt.AnonymousClass3.AnonymousClass2.invoke$lambda$1$lambda$0(pantryViewModel, (KeyboardActionScope) obj);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv3);
                            } else {
                                value$iv3 = it$iv;
                            }
                            $composer.endReplaceGroup();
                            KeyboardActions keyboardActions = new KeyboardActions((Function1) value$iv3, null, null, null, null, null, 62, null);
                            $composer.startReplaceGroup(-434388250);
                            ComposerKt.sourceInformation($composer, "CC(remember):PantryScreen.kt#9igjgp");
                            boolean invalid$iv2 = $composer.changedInstance(this.$viewModel);
                            final PantryViewModel pantryViewModel2 = this.$viewModel;
                            Object it$iv2 = $composer.rememberedValue();
                            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                value$iv4 = new Function1() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$PantryScreen$3$2$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return PantryScreenKt.AnonymousClass3.AnonymousClass2.invoke$lambda$3$lambda$2(pantryViewModel2, (String) obj);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv4);
                            } else {
                                value$iv4 = it$iv2;
                            }
                            $composer.endReplaceGroup();
                            OutlinedTextFieldKt.OutlinedTextField(query, (Function1<? super String, Unit>) value$iv4, modifierFillMaxWidth, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$PantryScreenKt.INSTANCE.m7121getLambda1$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptions, keyboardActions, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer, 12583296, 12779520, 0, 8159096);
                            $composer.startReplaceGroup(-434371920);
                            ComposerKt.sourceInformation($composer, "CC(remember):PantryScreen.kt#9igjgp");
                            boolean invalid$iv3 = $composer.changedInstance(this.$viewModel);
                            final PantryViewModel pantryViewModel3 = this.$viewModel;
                            Object it$iv3 = $composer.rememberedValue();
                            if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                value$iv5 = new Function0() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$PantryScreen$3$2$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return PantryScreenKt.AnonymousClass3.AnonymousClass2.invoke$lambda$5$lambda$4(pantryViewModel3);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv5);
                            } else {
                                value$iv5 = it$iv3;
                            }
                            $composer.endReplaceGroup();
                            IconButtonKt.IconButton((Function0) value$iv5, null, false, null, null, ComposableSingletons$PantryScreenKt.INSTANCE.m7123getLambda2$app_debug(), $composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                            $composer.endReplaceGroup();
                        } else {
                            $composer.startReplaceGroup(-580445288);
                            ComposerKt.sourceInformation($composer, "124@5795L33,124@5830L284,124@5774L340,131@6160L35,131@6139L150");
                            $composer.startReplaceGroup(-434363731);
                            ComposerKt.sourceInformation($composer, "CC(remember):PantryScreen.kt#9igjgp");
                            boolean invalid$iv4 = $composer.changedInstance(this.$viewModel);
                            final PantryViewModel pantryViewModel4 = this.$viewModel;
                            Object it$iv4 = $composer.rememberedValue();
                            if (invalid$iv4 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                                value$iv = new Function0() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$PantryScreen$3$2$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return PantryScreenKt.AnonymousClass3.AnonymousClass2.invoke$lambda$7$lambda$6(pantryViewModel4);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv);
                            } else {
                                value$iv = it$iv4;
                            }
                            $composer.endReplaceGroup();
                            final State<PantryUiState> state = this.$state$delegate;
                            IconButtonKt.IconButton((Function0) value$iv, null, false, null, null, ComposableLambdaKt.rememberComposableLambda(1691553598, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt.PantryScreen.3.2.5
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                    invoke(composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer $composer2, int $changed2) {
                                    ComposerKt.sourceInformation($composer2, "C125@5860L228:PantryScreen.kt#mq3b12");
                                    if (($changed2 & 3) != 2 || !$composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1691553598, $changed2, -1, "com.easycompra.app.ui.pantry.PantryScreen.<anonymous>.<anonymous>.<anonymous> (PantryScreen.kt:125)");
                                        }
                                        IconKt.m2171Iconww6aTOc(SwapVertKt.getSwapVert(Icons.INSTANCE.getDefault()), "Reordenar", (Modifier) null, PantryScreenKt.PantryScreen$lambda$0(state).getReorderMode() ? Color.INSTANCE.m4219getYellow0d7_KjU() : Color.INSTANCE.m4218getWhite0d7_KjU(), $composer2, 48, 4);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer2.skipToGroupEnd();
                                }
                            }, $composer, 54), $composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                            $composer.startReplaceGroup(-434352049);
                            ComposerKt.sourceInformation($composer, "CC(remember):PantryScreen.kt#9igjgp");
                            boolean invalid$iv5 = $composer.changedInstance(this.$viewModel);
                            final PantryViewModel pantryViewModel5 = this.$viewModel;
                            Object it$iv5 = $composer.rememberedValue();
                            if (invalid$iv5 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                                value$iv2 = new Function0() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$PantryScreen$3$2$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return PantryScreenKt.AnonymousClass3.AnonymousClass2.invoke$lambda$9$lambda$8(pantryViewModel5);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv2);
                            } else {
                                value$iv2 = it$iv5;
                            }
                            $composer.endReplaceGroup();
                            IconButtonKt.IconButton((Function0) value$iv2, null, false, null, null, ComposableSingletons$PantryScreenKt.INSTANCE.m7124getLambda3$app_debug(), $composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                            $composer.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$3$lambda$2(PantryViewModel $viewModel, String it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        $viewModel.setQuery(it);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$1$lambda$0(PantryViewModel $viewModel, KeyboardActionScope KeyboardActions) {
                        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
                        $viewModel.setSearchActive(false);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$5$lambda$4(PantryViewModel $viewModel) {
                        $viewModel.setSearchActive(false);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$7$lambda$6(PantryViewModel $viewModel) {
                        $viewModel.toggleReorderMode();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$9$lambda$8(PantryViewModel $viewModel) {
                        $viewModel.setSearchActive(true);
                        return Unit.INSTANCE;
                    }
                }
            }, $composer3, 54), null, null, ComposableLambdaKt.rememberComposableLambda(-2075047793, true, new AnonymousClass4(viewModel, state$delegate), $composer3, 54), 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1944589143, true, new AnonymousClass5(state$delegate, viewModel), $composer3, 54), $composer3, 805330992, 493);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PantryScreenKt.PantryScreen$lambda$5(viewModel, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PantryUiState PantryScreen$lambda$0(State<PantryUiState> state) {
        Object thisObj$iv = state.getValue();
        return (PantryUiState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PantryScreen$lambda$2$lambda$1(PantryViewModel $viewModel) {
        $viewModel.showAddDialog(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PantryScreen$lambda$4$lambda$3(PantryViewModel $viewModel, String name, String cat, String subcat, String desc, float qty, String unit) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(cat, "cat");
        Intrinsics.checkNotNullParameter(subcat, "subcat");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(unit, "unit");
        $viewModel.addItem(name, cat, subcat, desc, qty, unit);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.pantry.PantryScreenKt$PantryScreen$4, reason: invalid class name */
    /* JADX INFO: compiled from: PantryScreen.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass4 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ State<PantryUiState> $state$delegate;
        final /* synthetic */ PantryViewModel $viewModel;

        AnonymousClass4(PantryViewModel pantryViewModel, State<PantryUiState> state) {
            this.$viewModel = pantryViewModel;
            this.$state$delegate = state;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            Object value$iv;
            ComposerKt.sourceInformation($composer, "C140@6473L33,140@6442L148:PantryScreen.kt#mq3b12");
            if (($changed & 3) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-2075047793, $changed, -1, "com.easycompra.app.ui.pantry.PantryScreen.<anonymous> (PantryScreen.kt:139)");
                }
                if (!PantryScreenKt.PantryScreen$lambda$0(this.$state$delegate).getReorderMode()) {
                    $composer.startReplaceGroup(1579831534);
                    ComposerKt.sourceInformation($composer, "CC(remember):PantryScreen.kt#9igjgp");
                    boolean invalid$iv = $composer.changedInstance(this.$viewModel);
                    final PantryViewModel pantryViewModel = this.$viewModel;
                    Object it$iv = $composer.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv = new Function0() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$PantryScreen$4$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return PantryScreenKt.AnonymousClass4.invoke$lambda$1$lambda$0(pantryViewModel);
                            }
                        };
                        $composer.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer.endReplaceGroup();
                    FloatingActionButtonKt.m2146FloatingActionButtonXz6DiA((Function0) value$iv, null, null, 0L, 0L, null, null, ComposableSingletons$PantryScreenKt.INSTANCE.m7125getLambda4$app_debug(), $composer, 12582912, WebSocketProtocol.PAYLOAD_SHORT);
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
        public static final Unit invoke$lambda$1$lambda$0(PantryViewModel $viewModel) {
            $viewModel.showAddDialog(true);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.pantry.PantryScreenKt$PantryScreen$5, reason: invalid class name */
    /* JADX INFO: compiled from: PantryScreen.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass5 implements Function3<PaddingValues, Composer, Integer, Unit> {
        final /* synthetic */ State<PantryUiState> $state$delegate;
        final /* synthetic */ PantryViewModel $viewModel;

        AnonymousClass5(State<PantryUiState> state, PantryViewModel pantryViewModel) {
            this.$state$delegate = state;
            this.$viewModel = pantryViewModel;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer, Integer num) {
            invoke(paddingValues, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(PaddingValues padding, Composer $composer, int $changed) {
            Function0<ComposeUiNode> function0;
            Object value$iv;
            Function0<ComposeUiNode> function1;
            Function0<ComposeUiNode> function2;
            Function0<ComposeUiNode> function3;
            Object value$iv2;
            Intrinsics.checkNotNullParameter(padding, "padding");
            ComposerKt.sourceInformation($composer, "C146@6642L3881:PantryScreen.kt#mq3b12");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= $composer.changed(padding) ? 4 : 2;
            }
            if (($dirty & 19) == 18 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1944589143, $dirty, -1, "com.easycompra.app.ui.pantry.PantryScreen.<anonymous> (PantryScreen.kt:146)");
            }
            Modifier modifier$iv = SizeKt.fillMaxSize$default(PaddingKt.padding(Modifier.INSTANCE, padding), 0.0f, 1, null);
            final State<PantryUiState> state = this.$state$delegate;
            final PantryViewModel pantryViewModel = this.$viewModel;
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
            ComposerKt.sourceInformationMarkerStart($composer, -579295404, "C:PantryScreen.kt#mq3b12");
            if (PantryScreenKt.PantryScreen$lambda$0(state).getReorderMode()) {
                $composer.startReplaceGroup(-578823771);
                ComposerKt.sourceInformation($composer, "165@7516L11,168@7667L11,162@7362L433");
                long sp = TextUnitKt.getSp(12);
                long primary = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary();
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                long primaryContainer = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimaryContainer();
                TextKt.m2714Text4IGK_g("Modo reordenar — usa ↑↓ para mover productos", PaddingKt.m682paddingVpY3zN4(BackgroundKt.m236backgroundbw27NRU$default(modifierFillMaxWidth$default, Color.m4179copywmQWz5c(primaryContainer, (14 & 1) != 0 ? Color.m4183getAlphaimpl(primaryContainer) : 0.3f, (14 & 2) != 0 ? Color.m4187getRedimpl(primaryContainer) : 0.0f, (14 & 4) != 0 ? Color.m4186getGreenimpl(primaryContainer) : 0.0f, (14 & 8) != 0 ? Color.m4184getBlueimpl(primaryContainer) : 0.0f), null, 2, null), Dp.m6663constructorimpl(16), Dp.m6663constructorimpl(6)), primary, sp, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 3078, 0, 131056);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(-579370766);
                ComposerKt.sourceInformation($composer, "149@6808L516");
                Modifier modifier$iv2 = PaddingKt.m682paddingVpY3zN4(Modifier.INSTANCE, Dp.m6663constructorimpl(8), Dp.m6663constructorimpl(4));
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(6));
                int $changed$iv = 54;
                ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((54 >> 3) & 14) | ((54 >> 3) & 112));
                int $changed$iv$iv2 = (54 << 3) & 112;
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
                    function3 = constructor2;
                    $composer.createNode(function3);
                } else {
                    function3 = constructor2;
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
                int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                int i4 = ((54 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 1203589903, "C:PantryScreen.kt#mq3b12");
                $composer.startReplaceGroup(-653910529);
                ComposerKt.sourceInformation($composer, "*156@7177L26,157@7241L17,154@7069L215");
                Iterable $this$forEach$iv = PantryFilter.getEntries();
                int $i$f$forEach = 0;
                for (Object element$iv : $this$forEach$iv) {
                    Iterable $this$forEach$iv2 = $this$forEach$iv;
                    final PantryFilter f = (PantryFilter) element$iv;
                    int $i$f$forEach2 = $i$f$forEach;
                    boolean z = PantryScreenKt.PantryScreen$lambda$0(state).getFilter() == f;
                    $composer.startReplaceGroup(-363034396);
                    ComposerKt.sourceInformation($composer, "CC(remember):PantryScreen.kt#9igjgp");
                    boolean invalid$iv = $composer.changedInstance(pantryViewModel) | $composer.changed(f);
                    Modifier materialized$iv$iv3 = materialized$iv$iv2;
                    Object it$iv = $composer.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv2 = new Function0() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$PantryScreen$5$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return PantryScreenKt.AnonymousClass5.invoke$lambda$19$lambda$3$lambda$2$lambda$1$lambda$0(pantryViewModel, f);
                            }
                        };
                        $composer.updateRememberedValue(value$iv2);
                    } else {
                        value$iv2 = it$iv;
                    }
                    $composer.endReplaceGroup();
                    ChipKt.FilterChip(z, (Function0) value$iv2, ComposableLambdaKt.rememberComposableLambda(-644934912, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$PantryScreen$5$1$1$1$2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer2, int $changed2) {
                            ComposerKt.sourceInformation($composer2, "C157@7243L13:PantryScreen.kt#mq3b12");
                            if (($changed2 & 3) == 2 && $composer2.getSkipping()) {
                                $composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-644934912, $changed2, -1, "com.easycompra.app.ui.pantry.PantryScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PantryScreen.kt:157)");
                            }
                            TextKt.m2714Text4IGK_g(f.getLabel(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 0, 0, 131070);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer, 54), null, false, null, null, null, null, null, null, null, $composer, 384, 0, 4088);
                    $changed$iv = $changed$iv;
                    $this$forEach$iv = $this$forEach$iv2;
                    $i$f$forEach = $i$f$forEach2;
                    materialized$iv$iv2 = materialized$iv$iv3;
                }
                $composer.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
            }
            if (PantryScreenKt.PantryScreen$lambda$0(state).getAllItems().isEmpty()) {
                $composer.startReplaceGroup(-578316022);
                ComposerKt.sourceInformation($composer, "174@7871L524");
                Modifier modifier$iv3 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv3 = (54 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    function1 = constructor3;
                    $composer.createNode(function1);
                } else {
                    function1 = constructor3;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3674constructorimpl($composer);
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                    $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                    $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
                }
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                int i6 = ((54 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 1204535093, "C175@7958L419:PantryScreen.kt#mq3b12");
                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                Arrangement.HorizontalOrVertical horizontalOrVerticalM561spacedBy0680j_4 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(8));
                ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                Modifier modifier$iv4 = Modifier.INSTANCE;
                MeasurePolicy measurePolicy$iv4 = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM561spacedBy0680j_4, centerHorizontally, $composer, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                int $changed$iv$iv4 = (432 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                CompositionLocalMap localMap$iv$iv4 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer, modifier$iv4);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    function2 = constructor4;
                    $composer.createNode(function2);
                } else {
                    function2 = constructor4;
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.m3674constructorimpl($composer);
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv4.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv4.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv4))) {
                    $this$Layout_u24lambda_u240$iv$iv4.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv4));
                    $this$Layout_u24lambda_u240$iv$iv4.apply(Integer.valueOf(compositeKeyHash$iv$iv4), setCompositeKeyHash4);
                }
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv5, ComposeUiNode.INSTANCE.getSetModifier());
                int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                int i8 = ((432 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 1631818873, "C179@8216L10,179@8163L96,180@8284L71:PantryScreen.kt#mq3b12");
                TextKt.m2714Text4IGK_g("Tu despensa está vacía", (Modifier) null, Color.INSTANCE.m4211getGray0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getTitleMedium(), $composer, 390, 0, 65530);
                TextKt.m2714Text4IGK_g("Pulsa + para añadir el primer producto", (Modifier) null, Color.INSTANCE.m4213getLightGray0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 390, 0, 131066);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
            } else if (PantryScreenKt.PantryScreen$lambda$0(state).getGrouped().isEmpty()) {
                $composer.startReplaceGroup(-577740693);
                ComposerKt.sourceInformation($composer, "184@8462L171");
                Modifier modifier$iv5 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                Alignment contentAlignment$iv2 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv5 = (54 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv5 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                CompositionLocalMap localMap$iv$iv5 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer, modifier$iv5);
                Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    $composer.createNode(constructor5);
                } else {
                    $composer.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.m3674constructorimpl($composer);
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv5.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv5.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv5))) {
                    $this$Layout_u24lambda_u240$iv$iv5.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv5));
                    $this$Layout_u24lambda_u240$iv$iv5.apply(Integer.valueOf(compositeKeyHash$iv$iv5), setCompositeKeyHash5);
                }
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv6, ComposeUiNode.INSTANCE.getSetModifier());
                int i9 = ($changed$iv$iv$iv5 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                int i10 = ((54 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 1205110422, "C185@8549L66:PantryScreen.kt#mq3b12");
                TextKt.m2714Text4IGK_g("Sin resultados para \"" + PantryScreenKt.PantryScreen$lambda$0(state).getQuery() + "\"", (Modifier) null, Color.INSTANCE.m4211getGray0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 384, 0, 131066);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(-577481998);
                ComposerKt.sourceInformation($composer, "191@8825L1674,188@8671L1828");
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                Arrangement.HorizontalOrVertical horizontalOrVerticalM561spacedBy0680j_5 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(0));
                $composer.startReplaceGroup(-434265130);
                ComposerKt.sourceInformation($composer, "CC(remember):PantryScreen.kt#9igjgp");
                boolean invalid$iv2 = $composer.changed(state) | $composer.changedInstance(pantryViewModel);
                Object it$iv2 = $composer.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function1() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$PantryScreen$5$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PantryScreenKt.AnonymousClass5.invoke$lambda$19$lambda$18$lambda$17(state, pantryViewModel, (LazyListScope) obj);
                        }
                    };
                    $composer.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv2;
                }
                $composer.endReplaceGroup();
                LazyDslKt.LazyColumn(modifierFillMaxSize$default, null, null, false, horizontalOrVerticalM561spacedBy0680j_5, null, null, false, (Function1) value$iv, $composer, 24582, 238);
                $composer.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$19$lambda$3$lambda$2$lambda$1$lambda$0(PantryViewModel $viewModel, PantryFilter $f) {
            $viewModel.setFilter($f);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$19$lambda$18$lambda$17(final State $state$delegate, final PantryViewModel $viewModel, LazyListScope LazyColumn) {
            Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
            Iterable $this$forEach$iv = PantryScreenKt.PantryScreen$lambda$0($state$delegate).getGrouped();
            for (Object element$iv : $this$forEach$iv) {
                Pair pair = (Pair) element$iv;
                final String category = (String) pair.component1();
                Iterable subcats = (List) pair.component2();
                boolean z = true;
                LazyListScope.item$default(LazyColumn, "cat_" + category, null, ComposableLambdaKt.composableLambdaInstance(550575483, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$PantryScreen$5$1$4$1$1$1
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                        invoke(lazyItemScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
                        Intrinsics.checkNotNullParameter(item, "$this$item");
                        ComposerKt.sourceInformation($composer, "C193@8948L24:PantryScreen.kt#mq3b12");
                        if (($changed & 17) == 16 && $composer.getSkipping()) {
                            $composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(550575483, $changed, -1, "com.easycompra.app.ui.pantry.PantryScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PantryScreen.kt:193)");
                        }
                        PantryScreenKt.CategoryHeader(category, $composer, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), 2, null);
                for (Object element$iv2 : subcats) {
                    Pair pair2 = (Pair) element$iv2;
                    final String subcat = (String) pair2.component1();
                    final List locs = (List) pair2.component2();
                    LazyListScope.item$default(LazyColumn, "sub_" + category + "_" + subcat, null, ComposableLambdaKt.composableLambdaInstance(-584003662, z, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$PantryScreen$5$1$4$1$1$2$1
                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                            invoke(lazyItemScope, composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
                            Intrinsics.checkNotNullParameter(item, "$this$item");
                            ComposerKt.sourceInformation($composer, "C195@9103L25:PantryScreen.kt#mq3b12");
                            if (($changed & 17) == 16 && $composer.getSkipping()) {
                                $composer.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-584003662, $changed, -1, "com.easycompra.app.ui.pantry.PantryScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PantryScreen.kt:195)");
                            }
                            PantryScreenKt.SubcategoryHeader(subcat, $composer, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), 2, null);
                    final Function1 key$iv = new Function1() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$PantryScreen$5$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PantryScreenKt.AnonymousClass5.invoke$lambda$19$lambda$18$lambda$17$lambda$16$lambda$15$lambda$7((PantryLocationDisplay) obj);
                        }
                    };
                    final Function1 contentType$iv = new Function1() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$PantryScreen$5$invoke$lambda$19$lambda$18$lambda$17$lambda$16$lambda$15$$inlined$items$default$1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                            return invoke((PantryLocationDisplay) p1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Void invoke(PantryLocationDisplay pantryLocationDisplay) {
                            return null;
                        }
                    };
                    LazyColumn.items(locs.size(), new Function1<Integer, Object>() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$PantryScreen$5$invoke$lambda$19$lambda$18$lambda$17$lambda$16$lambda$15$$inlined$items$default$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                            return invoke(num.intValue());
                        }

                        public final Object invoke(int index) {
                            return key$iv.invoke(locs.get(index));
                        }
                    }, new Function1<Integer, Object>() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$PantryScreen$5$invoke$lambda$19$lambda$18$lambda$17$lambda$16$lambda$15$$inlined$items$default$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                            return invoke(num.intValue());
                        }

                        public final Object invoke(int index) {
                            return contentType$iv.invoke(locs.get(index));
                        }
                    }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$PantryScreen$5$invoke$lambda$19$lambda$18$lambda$17$lambda$16$lambda$15$$inlined$items$default$4
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(LazyItemScope $this$items, int it, Composer $composer, int $changed) {
                            Object value$iv;
                            Object value$iv2;
                            Object value$iv3;
                            Object value$iv4;
                            Object value$iv5;
                            Object value$iv6;
                            ComposerKt.sourceInformation($composer, "C152@7074L22:LazyDsl.kt#428nma");
                            int $dirty = $changed;
                            if (($changed & 6) == 0) {
                                $dirty |= $composer.changed($this$items) ? 4 : 2;
                            }
                            if (($changed & 48) == 0) {
                                $dirty |= $composer.changed(it) ? 32 : 16;
                            }
                            if (($dirty & 147) == 146 && $composer.getSkipping()) {
                                $composer.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-632812321, $dirty, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:152)");
                            }
                            int $changed2 = $dirty & 14;
                            final PantryLocationDisplay display = (PantryLocationDisplay) locs.get(it);
                            $composer.startReplaceGroup(1960325111);
                            ComposerKt.sourceInformation($composer, "C*205@9796L41,206@9889L41,207@9987L47,208@10083L46,209@10178L40,210@10269L42,199@9412L933:PantryScreen.kt#mq3b12");
                            int idx = locs.indexOf(display);
                            float limiteBajo = PantryScreenKt.PantryScreen$lambda$0($state$delegate).getLimiteBajo();
                            boolean reorderMode = PantryScreenKt.PantryScreen$lambda$0($state$delegate).getReorderMode();
                            boolean z2 = idx > 0;
                            boolean z3 = idx < locs.size() - 1;
                            $composer.startReplaceGroup(-1876412976);
                            ComposerKt.sourceInformation($composer, "CC(remember):PantryScreen.kt#9igjgp");
                            boolean invalid$iv = (((($changed2 & 112) ^ 48) > 32 && $composer.changed(display)) || ($changed2 & 48) == 32) | $composer.changedInstance($viewModel);
                            Object it$iv = $composer.rememberedValue();
                            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                                final PantryViewModel pantryViewModel = $viewModel;
                                value$iv = (Function0) new Function0<Unit>() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$PantryScreen$5$1$4$1$1$2$3$1$1
                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        pantryViewModel.increment(display.getLocation());
                                    }
                                };
                                $composer.updateRememberedValue(value$iv);
                            } else {
                                value$iv = it$iv;
                            }
                            Function0 function0 = (Function0) value$iv;
                            $composer.endReplaceGroup();
                            $composer.startReplaceGroup(-1876410000);
                            ComposerKt.sourceInformation($composer, "CC(remember):PantryScreen.kt#9igjgp");
                            boolean invalid$iv2 = $composer.changedInstance($viewModel) | (((($changed2 & 112) ^ 48) > 32 && $composer.changed(display)) || ($changed2 & 48) == 32);
                            Object it$iv2 = $composer.rememberedValue();
                            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                final PantryViewModel pantryViewModel2 = $viewModel;
                                value$iv2 = (Function0) new Function0<Unit>() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$PantryScreen$5$1$4$1$1$2$3$2$1
                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        pantryViewModel2.decrement(display.getLocation());
                                    }
                                };
                                $composer.updateRememberedValue(value$iv2);
                            } else {
                                value$iv2 = it$iv2;
                            }
                            Function0 function1 = (Function0) value$iv2;
                            $composer.endReplaceGroup();
                            $composer.startReplaceGroup(-1876406858);
                            ComposerKt.sourceInformation($composer, "CC(remember):PantryScreen.kt#9igjgp");
                            boolean invalid$iv3 = $composer.changedInstance($viewModel) | (((($changed2 & 112) ^ 48) > 32 && $composer.changed(display)) || ($changed2 & 48) == 32);
                            Object it$iv3 = $composer.rememberedValue();
                            if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                final PantryViewModel pantryViewModel3 = $viewModel;
                                value$iv3 = (Function0) new Function0<Unit>() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$PantryScreen$5$1$4$1$1$2$3$3$1
                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        pantryViewModel3.toggleNeedsToBuy(display.getProduct());
                                    }
                                };
                                $composer.updateRememberedValue(value$iv3);
                            } else {
                                value$iv3 = it$iv3;
                            }
                            Function0 function2 = (Function0) value$iv3;
                            $composer.endReplaceGroup();
                            $composer.startReplaceGroup(-1876403787);
                            ComposerKt.sourceInformation($composer, "CC(remember):PantryScreen.kt#9igjgp");
                            boolean invalid$iv4 = $composer.changedInstance($viewModel) | (((($changed2 & 112) ^ 48) > 32 && $composer.changed(display)) || ($changed2 & 48) == 32);
                            Object it$iv4 = $composer.rememberedValue();
                            if (invalid$iv4 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                                final PantryViewModel pantryViewModel4 = $viewModel;
                                value$iv4 = (Function0) new Function0<Unit>() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$PantryScreen$5$1$4$1$1$2$3$4$1
                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        pantryViewModel4.deleteLocation(display.getLocation());
                                    }
                                };
                                $composer.updateRememberedValue(value$iv4);
                            } else {
                                value$iv4 = it$iv4;
                            }
                            Function0 function3 = (Function0) value$iv4;
                            $composer.endReplaceGroup();
                            $composer.startReplaceGroup(-1876400753);
                            ComposerKt.sourceInformation($composer, "CC(remember):PantryScreen.kt#9igjgp");
                            boolean invalid$iv5 = $composer.changedInstance($viewModel) | (((($changed2 & 112) ^ 48) > 32 && $composer.changed(display)) || ($changed2 & 48) == 32);
                            Object it$iv5 = $composer.rememberedValue();
                            if (invalid$iv5 || it$iv5 == Composer.INSTANCE.getEmpty()) {
                                final PantryViewModel pantryViewModel5 = $viewModel;
                                value$iv5 = (Function0) new Function0<Unit>() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$PantryScreen$5$1$4$1$1$2$3$5$1
                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        pantryViewModel5.moveUp(display.getProduct().getId());
                                    }
                                };
                                $composer.updateRememberedValue(value$iv5);
                            } else {
                                value$iv5 = it$iv5;
                            }
                            Function0 function4 = (Function0) value$iv5;
                            $composer.endReplaceGroup();
                            $composer.startReplaceGroup(-1876397839);
                            ComposerKt.sourceInformation($composer, "CC(remember):PantryScreen.kt#9igjgp");
                            boolean invalid$iv6 = $composer.changedInstance($viewModel) | (((($changed2 & 112) ^ 48) > 32 && $composer.changed(display)) || ($changed2 & 48) == 32);
                            Object it$iv6 = $composer.rememberedValue();
                            if (invalid$iv6 || it$iv6 == Composer.INSTANCE.getEmpty()) {
                                final PantryViewModel pantryViewModel6 = $viewModel;
                                value$iv6 = (Function0) new Function0<Unit>() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$PantryScreen$5$1$4$1$1$2$3$6$1
                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        pantryViewModel6.moveDown(display.getProduct().getId());
                                    }
                                };
                                $composer.updateRememberedValue(value$iv6);
                            } else {
                                value$iv6 = it$iv6;
                            }
                            $composer.endReplaceGroup();
                            PantryScreenKt.PantryItemRow(display, limiteBajo, reorderMode, z2, z3, function0, function1, function2, function3, function4, (Function0) value$iv6, $composer, ($changed2 >> 3) & 14, 0);
                            $composer.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }));
                    z = true;
                    $this$forEach$iv = $this$forEach$iv;
                }
            }
            LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$PantryScreenKt.INSTANCE.m7126getLambda5$app_debug(), 3, null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object invoke$lambda$19$lambda$18$lambda$17$lambda$16$lambda$15$lambda$7(PantryLocationDisplay it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return "loc_" + it.getLocation().getId();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CategoryHeader(final String name, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-1186789122);
        ComposerKt.sourceInformation($composer3, "C(CategoryHeader)226@10661L10,228@10752L11,231@10867L11,224@10592L387:PantryScreen.kt#mq3b12");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(name) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 3) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1186789122, $dirty2, -1, "com.easycompra.app.ui.pantry.CategoryHeader (PantryScreen.kt:223)");
            }
            String upperCase = name.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            TextStyle labelLarge = MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelLarge();
            FontWeight bold = FontWeight.INSTANCE.getBold();
            long primary = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimary();
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            long primaryContainer = MaterialTheme.INSTANCE.getColorScheme($composer3, MaterialTheme.$stable).getPrimaryContainer();
            $composer2 = $composer3;
            TextKt.m2714Text4IGK_g(upperCase, PaddingKt.m682paddingVpY3zN4(BackgroundKt.m236backgroundbw27NRU$default(modifierFillMaxWidth$default, Color.m4179copywmQWz5c(primaryContainer, (14 & 1) != 0 ? Color.m4183getAlphaimpl(primaryContainer) : 0.4f, (14 & 2) != 0 ? Color.m4187getRedimpl(primaryContainer) : 0.0f, (14 & 4) != 0 ? Color.m4186getGreenimpl(primaryContainer) : 0.0f, (14 & 8) != 0 ? Color.m4184getBlueimpl(primaryContainer) : 0.0f), null, 2, null), Dp.m6663constructorimpl(16), Dp.m6663constructorimpl(6)), primary, 0L, (FontStyle) null, bold, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, labelLarge, $composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 65496);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PantryScreenKt.CategoryHeader$lambda$6(name, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SubcategoryHeader(final String name, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-713757918);
        ComposerKt.sourceInformation($composer3, "C(SubcategoryHeader)240@11102L10,238@11045L275:PantryScreen.kt#mq3b12");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(name) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 3) == 2 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-713757918, $dirty2, -1, "com.easycompra.app.ui.pantry.SubcategoryHeader (PantryScreen.kt:237)");
            }
            $composer2 = $composer3;
            TextKt.m2714Text4IGK_g(name, PaddingKt.m685paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6663constructorimpl(16), Dp.m6663constructorimpl(8), 0.0f, Dp.m6663constructorimpl(2), 4, null), Color.INSTANCE.m4211getGray0d7_KjU(), 0L, (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer3, MaterialTheme.$stable).getLabelMedium(), $composer2, ($dirty2 & 14) | 197040, 0, 65496);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PantryScreenKt.SubcategoryHeader$lambda$7(name, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PantryItemRow(final PantryLocationDisplay display, final float limiteBajo, final boolean reorderMode, final boolean canMoveUp, final boolean canMoveDown, final Function0<Unit> function0, final Function0<Unit> function1, final Function0<Unit> function2, final Function0<Unit> function3, final Function0<Unit> function4, final Function0<Unit> function5, Composer $composer, final int $changed, final int $changed1) {
        long dotColor;
        Object value$iv;
        Composer $composer2 = $composer.startRestartGroup(-1672024880);
        ComposerKt.sourceInformation($composer2, "C(PantryItemRow)P(2,3,10,1!1,6!1,9!1,8)271@11958L34,278@12190L40,279@12265L19,280@12291L4487,273@11998L4780:PantryScreen.kt#mq3b12");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(display) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(limiteBajo) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(reorderMode) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(canMoveUp) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changed(canMoveDown) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 1048576 : 524288;
        }
        if ((12582912 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 8388608 : 4194304;
        }
        if ((100663296 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function3) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if (($changed & 805306368) == 0) {
            $dirty |= $composer2.changedInstance(function4) ? 536870912 : 268435456;
        }
        if (($changed1 & 6) == 0) {
            $dirty1 |= $composer2.changedInstance(function5) ? 4 : 2;
        }
        int $dirty2 = $dirty1;
        if ((306783379 & $dirty) != 306783378 || ($dirty2 & 3) != 2 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1672024880, $dirty, $dirty2, "com.easycompra.app.ui.pantry.PantryItemRow (PantryScreen.kt:262)");
            }
            PantryLocationEntity loc = display.getLocation();
            PantryProductEntity product = display.getProduct();
            StockStatus status = PantryLocationEntityKt.stockStatus(loc, limiteBajo);
            switch (WhenMappings.$EnumSwitchMapping$0[status.ordinal()]) {
                case 1:
                    dotColor = ColorOK;
                    break;
                case 2:
                    dotColor = ColorLow;
                    break;
                case 3:
                    dotColor = ColorEmpty;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            $composer2.startReplaceGroup(2146602471);
            ComposerKt.sourceInformation($composer2, "CC(remember):PantryScreen.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MutableState menuExpanded$delegate = (MutableState) value$iv;
            $composer2.endReplaceGroup();
            Modifier modifierM682paddingVpY3zN4 = PaddingKt.m682paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6663constructorimpl(8), Dp.m6663constructorimpl(2));
            RoundedCornerShape roundedCornerShapeM964RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m964RoundedCornerShape0680j_4(Dp.m6663constructorimpl(8));
            CardColors cardColorsM1850cardColorsro_MJ88 = CardDefaults.INSTANCE.m1850cardColorsro_MJ88(Color.INSTANCE.m4218getWhite0d7_KjU(), 0L, 0L, 0L, $composer2, (CardDefaults.$stable << 12) | 6, 14);
            CardDefaults cardDefaults = CardDefaults.INSTANCE;
            float fM6663constructorimpl = Dp.m6663constructorimpl(1);
            int $i$f$getDp = CardDefaults.$stable;
            CardKt.Card(modifierM682paddingVpY3zN4, roundedCornerShapeM964RoundedCornerShape0680j_4, cardColorsM1850cardColorsro_MJ88, cardDefaults.m1851cardElevationaqJV_2Y(fM6663constructorimpl, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer2, ($i$f$getDp << 18) | 6, 62), null, ComposableLambdaKt.rememberComposableLambda(-605068258, true, new AnonymousClass1(reorderMode, dotColor, product, function2, function4, canMoveUp, function5, canMoveDown, loc, function1, function0, menuExpanded$delegate, function3), $composer2, 54), $composer2, 196614, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PantryScreenKt.PantryItemRow$lambda$11(display, limiteBajo, reorderMode, canMoveUp, canMoveDown, function0, function1, function2, function3, function4, function5, $changed, $changed1, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PantryItemRow$lambda$10(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean PantryItemRow$lambda$9(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.pantry.PantryScreenKt$PantryItemRow$1, reason: invalid class name */
    /* JADX INFO: compiled from: PantryScreen.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass1 implements Function3<ColumnScope, Composer, Integer, Unit> {
        final /* synthetic */ boolean $canMoveDown;
        final /* synthetic */ boolean $canMoveUp;
        final /* synthetic */ long $dotColor;
        final /* synthetic */ PantryLocationEntity $loc;
        final /* synthetic */ MutableState<Boolean> $menuExpanded$delegate;
        final /* synthetic */ Function0<Unit> $onDecrement;
        final /* synthetic */ Function0<Unit> $onDelete;
        final /* synthetic */ Function0<Unit> $onIncrement;
        final /* synthetic */ Function0<Unit> $onMoveDown;
        final /* synthetic */ Function0<Unit> $onMoveUp;
        final /* synthetic */ Function0<Unit> $onToggleNeedsBuy;
        final /* synthetic */ PantryProductEntity $product;
        final /* synthetic */ boolean $reorderMode;

        AnonymousClass1(boolean z, long j, PantryProductEntity pantryProductEntity, Function0<Unit> function0, Function0<Unit> function1, boolean z2, Function0<Unit> function2, boolean z3, PantryLocationEntity pantryLocationEntity, Function0<Unit> function3, Function0<Unit> function4, MutableState<Boolean> mutableState, Function0<Unit> function5) {
            this.$reorderMode = z;
            this.$dotColor = j;
            this.$product = pantryProductEntity;
            this.$onToggleNeedsBuy = function0;
            this.$onMoveUp = function1;
            this.$canMoveUp = z2;
            this.$onMoveDown = function2;
            this.$canMoveDown = z3;
            this.$loc = pantryLocationEntity;
            this.$onDecrement = function3;
            this.$onIncrement = function4;
            this.$menuExpanded$delegate = mutableState;
            this.$onDelete = function5;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
            invoke(columnScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(ColumnScope Card, Composer $composer, int $changed) {
            Function0<ComposeUiNode> function0;
            String str;
            Composer $composer2;
            Function0<ComposeUiNode> function1;
            Composer $composer3;
            Object value$iv;
            final MutableState<Boolean> mutableState;
            Object value$iv2;
            Function0<ComposeUiNode> function2;
            Intrinsics.checkNotNullParameter(Card, "$this$Card");
            ComposerKt.sourceInformation($composer, "C281@12301L4471:PantryScreen.kt#mq3b12");
            if (($changed & 17) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-605068258, $changed, -1, "com.easycompra.app.ui.pantry.PantryItemRow.<anonymous> (PantryScreen.kt:281)");
            }
            Modifier modifierM682paddingVpY3zN4 = PaddingKt.m682paddingVpY3zN4(Modifier.INSTANCE, Dp.m6663constructorimpl(8), Dp.m6663constructorimpl(8));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM561spacedBy0680j_4 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(8));
            boolean z = this.$reorderMode;
            long j = this.$dotColor;
            PantryProductEntity pantryProductEntity = this.$product;
            final Function0<Unit> function3 = this.$onToggleNeedsBuy;
            Function0<Unit> function4 = this.$onMoveUp;
            final boolean z2 = this.$canMoveUp;
            Function0<Unit> function5 = this.$onMoveDown;
            final boolean z3 = this.$canMoveDown;
            PantryLocationEntity pantryLocationEntity = this.$loc;
            Function0<Unit> function6 = this.$onDecrement;
            Function0<Unit> function7 = this.$onIncrement;
            MutableState<Boolean> mutableState2 = this.$menuExpanded$delegate;
            Function0<Unit> function8 = this.$onDelete;
            ComposerKt.sourceInformationMarkerStart($composer, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalOrVerticalM561spacedBy0680j_4, centerVertically, $composer, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            int $changed$iv$iv = (438 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifierM682paddingVpY3zN4);
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
            int i2 = ((438 >> 6) & 112) | 6;
            RowScope $this$invoke_u24lambda_u2411 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 1175495960, "C324@14061L513:PantryScreen.kt#mq3b12");
            if (z) {
                $composer.startReplaceGroup(1175420102);
                ComposerKt.sourceInformation($composer, "288@12608L1166");
                Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(0));
                ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                Modifier modifier$iv = Modifier.INSTANCE;
                Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                int $changed$iv$iv2 = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    function2 = constructor2;
                    $composer.createNode(function2);
                } else {
                    function2 = constructor2;
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
                int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                int i4 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 12984532, "C293@12866L341,289@12687L520,305@13411L345,301@13228L528:PantryScreen.kt#mq3b12");
                IconButtonKt.IconButton(function4, SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(28)), z2, null, null, ComposableLambdaKt.rememberComposableLambda(1942440460, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$PantryItemRow$1$1$1$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer4, int $changed2) {
                        ComposerKt.sourceInformation($composer4, "C294@12892L293:PantryScreen.kt#mq3b12");
                        if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1942440460, $changed2, -1, "com.easycompra.app.ui.pantry.PantryItemRow.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PantryScreen.kt:294)");
                            }
                            ImageVector keyboardArrowUp = KeyboardArrowUpKt.getKeyboardArrowUp(Icons.INSTANCE.getDefault());
                            $composer4.startReplaceGroup(-485427482);
                            ComposerKt.sourceInformation($composer4, "297@13058L11");
                            long primary = z2 ? MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getPrimary() : Color.INSTANCE.m4213getLightGray0d7_KjU();
                            $composer4.endReplaceGroup();
                            IconKt.m2171Iconww6aTOc(keyboardArrowUp, "Subir", SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(20)), primary, $composer4, 432, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }
                }, $composer, 54), $composer, 196656, 24);
                IconButtonKt.IconButton(function5, SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(28)), z3, null, null, ComposableLambdaKt.rememberComposableLambda(-2004472971, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$PantryItemRow$1$1$1$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer4, int $changed2) {
                        ComposerKt.sourceInformation($composer4, "C306@13437L297:PantryScreen.kt#mq3b12");
                        if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-2004472971, $changed2, -1, "com.easycompra.app.ui.pantry.PantryItemRow.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PantryScreen.kt:306)");
                            }
                            ImageVector keyboardArrowDown = KeyboardArrowDownKt.getKeyboardArrowDown(Icons.INSTANCE.getDefault());
                            $composer4.startReplaceGroup(-485409976);
                            ComposerKt.sourceInformation($composer4, "309@13607L11");
                            long primary = z3 ? MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getPrimary() : Color.INSTANCE.m4213getLightGray0d7_KjU();
                            $composer4.endReplaceGroup();
                            IconKt.m2171Iconww6aTOc(keyboardArrowDown, "Bajar", SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(20)), primary, $composer4, 432, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer4.skipToGroupEnd();
                    }
                }, $composer, 54), $composer, 196656, 24);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
                str = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh";
                $composer2 = $composer;
            } else {
                $composer.startReplaceGroup(1176625475);
                ComposerKt.sourceInformation($composer, "315@13812L188");
                str = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh";
                $composer2 = $composer;
                BoxKt.Box(BackgroundKt.m236backgroundbw27NRU$default(ClipKt.clip(SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(12)), RoundedCornerShapeKt.getCircleShape()), j, null, 2, null), $composer2, 0);
                $composer2.endReplaceGroup();
            }
            Modifier modifier$iv2 = RowScope.weight$default($this$invoke_u24lambda_u2411, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv3 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, str);
            int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv3 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                function1 = constructor3;
                $composer2.createNode(function1);
            } else {
                function1 = constructor3;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3674constructorimpl($composer2);
            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash3);
            }
            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
            int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
            Composer $composer$iv = $composer2;
            ComposerKt.sourceInformationMarkerStart($composer$iv, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer$iv, 14384647, "C325@14118L155,334@14511L49:PantryScreen.kt#mq3b12");
            TextKt.m2714Text4IGK_g(r25.getName(), (Modifier) null, 0L, TextUnitKt.getSp(15), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer$iv, 199680, 0, 131030);
            StringBuilder $this$invoke_u24lambda_u2411_u24lambda_u242_u24lambda_u241 = new StringBuilder();
            $this$invoke_u24lambda_u2411_u24lambda_u242_u24lambda_u241.append(PantryLocationEntityKt.formatPantryQty(r26.getQuantity()) + " " + r26.getUnit());
            if (!StringsKt.isBlank(r26.getDescription())) {
                $this$invoke_u24lambda_u2411_u24lambda_u242_u24lambda_u241.append(" · " + pantryLocationEntity.getDescription());
            }
            String label = $this$invoke_u24lambda_u2411_u24lambda_u242_u24lambda_u241.toString();
            Intrinsics.checkNotNullExpressionValue(label, "toString(...)");
            TextKt.m2714Text4IGK_g(label, (Modifier) null, Color.INSTANCE.m4211getGray0d7_KjU(), TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer$iv, 3456, 0, 131058);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.startReplaceGroup(-1486037631);
            ComposerKt.sourceInformation($composer2, "341@14769L22,339@14671L191,346@14918L998,369@15934L814");
            if (z) {
                $composer3 = $composer2;
            } else {
                boolean needsToBuy = pantryProductEntity.getNeedsToBuy();
                $composer2.startReplaceGroup(-1486033991);
                ComposerKt.sourceInformation($composer2, "CC(remember):PantryScreen.kt#9igjgp");
                boolean invalid$iv = $composer2.changed(r31);
                Composer $this$cache$iv = $composer2;
                Object it$iv = $this$cache$iv.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function1() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$PantryItemRow$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return PantryScreenKt.AnonymousClass1.invoke$lambda$11$lambda$4$lambda$3(function3, ((Boolean) obj).booleanValue());
                        }
                    };
                    $this$cache$iv.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                $composer2.endReplaceGroup();
                CheckboxKt.Checkbox(needsToBuy, (Function1) value$iv, SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(24)), false, null, null, $composer2, 384, 56);
                Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart($composer2, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                Modifier modifier$iv3 = Modifier.INSTANCE;
                Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                int $changed$iv$iv4 = (384 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, str);
                int compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
                CompositionLocalMap localMap$iv$iv4 = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer2, modifier$iv3);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    $composer2.createNode(constructor4);
                } else {
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.m3674constructorimpl($composer2);
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv4.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv4.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv4))) {
                    $this$Layout_u24lambda_u240$iv$iv4.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv4));
                    $this$Layout_u24lambda_u240$iv$iv4.apply(Integer.valueOf(compositeKeyHash$iv$iv4), setCompositeKeyHash4);
                }
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
                Composer $composer$iv2 = $composer2;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                int i8 = ((384 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, 15266039, "C347@14992L318,354@15331L284,361@15636L262:PantryScreen.kt#mq3b12");
                IconButtonKt.FilledTonalIconButton(function6, SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(32)), r26.getQuantity() > 0.0f, null, null, null, ComposableSingletons$PantryScreenKt.INSTANCE.m7127getLambda6$app_debug(), $composer$iv2, 1572912, 56);
                $composer3 = $composer2;
                TextKt.m2714Text4IGK_g(PantryLocationEntityKt.formatPantryQty(r26.getQuantity()), SizeKt.m731width3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(28)), j, TextUnitKt.getSp(14), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer$iv2, 199728, 0, 131024);
                IconButtonKt.FilledTonalIconButton(function7, SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(32)), false, null, null, null, ComposableSingletons$PantryScreenKt.INSTANCE.m7128getLambda7$app_debug(), $composer$iv2, 1572912, 60);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Modifier modifier$iv4 = Modifier.INSTANCE;
                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv5 = (0 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, str);
                int compositeKeyHash$iv$iv5 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                CompositionLocalMap localMap$iv$iv5 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
                Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    $composer3.createNode(constructor5);
                } else {
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv5 = Updater.m3674constructorimpl($composer3);
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv5, measurePolicy$iv5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv5, localMap$iv$iv5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv5.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv5.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv5))) {
                    $this$Layout_u24lambda_u240$iv$iv5.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv5));
                    $this$Layout_u24lambda_u240$iv$iv5.apply(Integer.valueOf(compositeKeyHash$iv$iv5), setCompositeKeyHash5);
                }
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv5, materialized$iv$iv5, ComposeUiNode.INSTANCE.getSetModifier());
                int i9 = ($changed$iv$iv$iv5 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                int i10 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, 16222079, "C370@15981L23,370@15960L222,373@16260L24,373@16286L444,373@16203L527:PantryScreen.kt#mq3b12");
                $composer3.startReplaceGroup(-830760775);
                ComposerKt.sourceInformation($composer3, "CC(remember):PantryScreen.kt#9igjgp");
                Object value$iv3 = $composer3.rememberedValue();
                if (value$iv3 == Composer.INSTANCE.getEmpty()) {
                    mutableState = mutableState2;
                    value$iv3 = new Function0() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$PantryItemRow$1$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PantryScreenKt.AnonymousClass1.invoke$lambda$11$lambda$10$lambda$7$lambda$6(mutableState);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv3);
                } else {
                    mutableState = r29;
                }
                $composer3.endReplaceGroup();
                IconButtonKt.IconButton((Function0) value$iv3, SizeKt.m726size3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(32)), false, null, null, ComposableSingletons$PantryScreenKt.INSTANCE.m7129getLambda8$app_debug(), $composer3, 196662, 28);
                boolean zPantryItemRow$lambda$9 = PantryScreenKt.PantryItemRow$lambda$9(mutableState);
                $composer3.startReplaceGroup(-830751846);
                ComposerKt.sourceInformation($composer3, "CC(remember):PantryScreen.kt#9igjgp");
                Object it$iv2 = $composer3.rememberedValue();
                if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = new Function0() { // from class: com.easycompra.app.ui.pantry.PantryScreenKt$PantryItemRow$1$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PantryScreenKt.AnonymousClass1.invoke$lambda$11$lambda$10$lambda$9$lambda$8(mutableState);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv2;
                }
                $composer3.endReplaceGroup();
                AndroidMenu_androidKt.m1785DropdownMenuIlH_yew(zPantryItemRow$lambda$9, (Function0) value$iv2, null, 0L, null, null, null, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(-2034627235, true, new PantryScreenKt$PantryItemRow$1$1$5$3(function8, mutableState), $composer3, 54), $composer3, 48, 48, 2044);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$11$lambda$4$lambda$3(Function0 $onToggleNeedsBuy, boolean it) {
            $onToggleNeedsBuy.invoke();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$11$lambda$10$lambda$7$lambda$6(MutableState $menuExpanded$delegate) {
            PantryScreenKt.PantryItemRow$lambda$10($menuExpanded$delegate, true);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$11$lambda$10$lambda$9$lambda$8(MutableState $menuExpanded$delegate) {
            PantryScreenKt.PantryItemRow$lambda$10($menuExpanded$delegate, false);
            return Unit.INSTANCE;
        }
    }
}
