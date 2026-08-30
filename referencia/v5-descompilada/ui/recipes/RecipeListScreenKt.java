package com.easycompra.app.ui.recipes;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
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
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.FavoriteBorderKt;
import androidx.compose.material.icons.filled.FavoriteKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
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
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.ContentScale;
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
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.profileinstaller.ProfileVerifier;
import coil.compose.SingletonAsyncImageKt;
import com.easycompra.app.data.recipes.RecipeDifficulty;
import com.easycompra.app.data.recipes.RecipeEntity;
import com.easycompra.app.data.recipes.RecipeWithDetails;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: RecipeListScreen.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0007\u001a1\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0003¢\u0006\u0002\u0010\r\u001a\u0015\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001a\u0015\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0014H\u0007¢\u0006\u0002\u0010\u0015¨\u0006\u0016²\u0006\n\u0010\u0017\u001a\u00020\u0018X\u008a\u0084\u0002"}, d2 = {"RecipeListScreen", "", "viewModel", "Lcom/easycompra/app/ui/recipes/RecipeViewModel;", "onRecipeClick", "Lkotlin/Function1;", "Lcom/easycompra/app/data/recipes/RecipeWithDetails;", "(Lcom/easycompra/app/ui/recipes/RecipeViewModel;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "RecipeCard", "recipe", "onClick", "Lkotlin/Function0;", "onFavorite", "(Lcom/easycompra/app/data/recipes/RecipeWithDetails;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "DifficultyBadge", "difficulty", "", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "TimeBadge", "minutes", "", "(ILandroidx/compose/runtime/Composer;I)V", "app_debug", "state", "Lcom/easycompra/app/ui/recipes/RecipeUiState;"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RecipeListScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DifficultyBadge$lambda$7(String str, int i, Composer composer, int i2) {
        DifficultyBadge(str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecipeCard$lambda$5(RecipeWithDetails recipeWithDetails, Function0 function0, Function0 function1, int i, Composer composer, int i2) {
        RecipeCard(recipeWithDetails, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecipeListScreen$lambda$3(RecipeViewModel recipeViewModel, Function1 function1, int i, Composer composer, int i2) throws Throwable {
        RecipeListScreen(recipeViewModel, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecipeListScreen$lambda$4(RecipeViewModel recipeViewModel, Function1 function1, int i, Composer composer, int i2) throws Throwable {
        RecipeListScreen(recipeViewModel, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TimeBadge$lambda$10(int i, int i2, Composer composer, int i3) {
        TimeBadge(i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final void RecipeListScreen(final RecipeViewModel viewModel, final Function1<? super RecipeWithDetails, Unit> onRecipeClick, Composer $composer, final int $changed) throws Throwable {
        Composer $composer2;
        Object value$iv;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(onRecipeClick, "onRecipeClick");
        Composer $composer3 = $composer.startRestartGroup(2024016232);
        ComposerKt.sourceInformation($composer3, "C(RecipeListScreen)P(1)64@2847L16,76@3128L1545,108@4706L154,113@4867L2885,75@3101L4651:RecipeListScreen.kt#y43rd3");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(viewModel) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(onRecipeClick) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 19) != 18 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2024016232, $dirty2, -1, "com.easycompra.app.ui.recipes.RecipeListScreen (RecipeListScreen.kt:63)");
            }
            final State state$delegate = SnapshotStateKt.collectAsState(viewModel.getState(), null, $composer3, 0, 1);
            $composer3.startReplaceGroup(1579715023);
            ComposerKt.sourceInformation($composer3, "70@3031L33,67@2905L169");
            if (RecipeListScreen$lambda$0(state$delegate).getShowCreateEdit()) {
                RecipeWithDetails editingRecipe = RecipeListScreen$lambda$0(state$delegate).getEditingRecipe();
                $composer3.startReplaceGroup(1579720014);
                ComposerKt.sourceInformation($composer3, "CC(remember):RecipeListScreen.kt#9igjgp");
                boolean invalid$iv = $composer3.changedInstance(viewModel);
                Object it$iv = $composer3.rememberedValue();
                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv = new Function0() { // from class: com.easycompra.app.ui.recipes.RecipeListScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return RecipeListScreenKt.RecipeListScreen$lambda$2$lambda$1(viewModel);
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                } else {
                    value$iv = it$iv;
                }
                $composer3.endReplaceGroup();
                CreateEditRecipeScreenKt.CreateEditRecipeScreen(viewModel, editingRecipe, (Function0) value$iv, $composer3, $dirty2 & 14);
                $composer3.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer3.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.recipes.RecipeListScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return RecipeListScreenKt.RecipeListScreen$lambda$3(viewModel, onRecipeClick, $changed, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            $composer3.endReplaceGroup();
            $composer2 = $composer3;
            ScaffoldKt.m2429ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(-949583068, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeListScreenKt.RecipeListScreen.3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C82@3400L11,81@3332L216,78@3177L110,86@3576L1073,77@3142L1521:RecipeListScreen.kt#y43rd3");
                    if (($changed2 & 3) != 2 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-949583068, $changed2, -1, "com.easycompra.app.ui.recipes.RecipeListScreen.<anonymous> (RecipeListScreen.kt:77)");
                        }
                        TopAppBarColors topAppBarColorsM2885topAppBarColorszjMxDiM = TopAppBarDefaults.INSTANCE.m2885topAppBarColorszjMxDiM(MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getPrimary(), 0L, 0L, Color.INSTANCE.m4218getWhite0d7_KjU(), Color.INSTANCE.m4218getWhite0d7_KjU(), $composer4, (TopAppBarDefaults.$stable << 15) | 27648, 6);
                        final State<RecipeUiState> state = state$delegate;
                        AppBarKt.m1794TopAppBarGHTll3U(ComposableLambdaKt.rememberComposableLambda(360322792, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeListScreenKt.RecipeListScreen.3.1
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer5, int $changed3) {
                                ComposerKt.sourceInformation($composer5, "C79@3224L45:RecipeListScreen.kt#y43rd3");
                                if (($changed3 & 3) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(360322792, $changed3, -1, "com.easycompra.app.ui.recipes.RecipeListScreen.<anonymous>.<anonymous> (RecipeListScreen.kt:79)");
                                    }
                                    if (!RecipeListScreenKt.RecipeListScreen$lambda$0(state).getSearchActive()) {
                                        TextKt.m2714Text4IGK_g("Recetas", (Modifier) null, 0L, 0L, (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer5, 196614, 0, 131038);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }, $composer4, 54), null, null, ComposableLambdaKt.rememberComposableLambda(-1479910509, true, new AnonymousClass2(viewModel, state$delegate), $composer4, 54), 0.0f, null, topAppBarColorsM2885topAppBarColorszjMxDiM, null, $composer4, 3078, 182);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }

                /* JADX INFO: renamed from: com.easycompra.app.ui.recipes.RecipeListScreenKt$RecipeListScreen$3$2, reason: invalid class name */
                /* JADX INFO: compiled from: RecipeListScreen.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                static final class AnonymousClass2 implements Function3<RowScope, Composer, Integer, Unit> {
                    final /* synthetic */ State<RecipeUiState> $state$delegate;
                    final /* synthetic */ RecipeViewModel $viewModel;

                    AnonymousClass2(RecipeViewModel recipeViewModel, State<RecipeUiState> state) {
                        this.$viewModel = recipeViewModel;
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
                        Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
                        ComposerKt.sourceInformation($composer, "C:RecipeListScreen.kt#y43rd3");
                        if (($changed & 17) == 16 && $composer.getSkipping()) {
                            $composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1479910509, $changed, -1, "com.easycompra.app.ui.recipes.RecipeListScreen.<anonymous>.<anonymous> (RecipeListScreen.kt:87)");
                        }
                        if (RecipeListScreenKt.RecipeListScreen$lambda$0(this.$state$delegate).getSearchActive()) {
                            $composer.startReplaceGroup(1466664274);
                            ComposerKt.sourceInformation($composer, "95@4167L36,90@3760L26,88@3648L582,97@4276L36,97@4255L150");
                            String query = RecipeListScreenKt.RecipeListScreen$lambda$0(this.$state$delegate).getQuery();
                            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(Modifier.INSTANCE, 0.8f);
                            KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m6305getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
                            $composer.startReplaceGroup(1432801743);
                            ComposerKt.sourceInformation($composer, "CC(remember):RecipeListScreen.kt#9igjgp");
                            boolean invalid$iv = $composer.changedInstance(this.$viewModel);
                            final RecipeViewModel recipeViewModel = this.$viewModel;
                            Object it$iv = $composer.rememberedValue();
                            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                                value$iv2 = new Function1() { // from class: com.easycompra.app.ui.recipes.RecipeListScreenKt$RecipeListScreen$3$2$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return RecipeListScreenKt.AnonymousClass3.AnonymousClass2.invoke$lambda$1$lambda$0(recipeViewModel, (KeyboardActionScope) obj);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv2);
                            } else {
                                value$iv2 = it$iv;
                            }
                            $composer.endReplaceGroup();
                            KeyboardActions keyboardActions = new KeyboardActions((Function1) value$iv2, null, null, null, null, null, 62, null);
                            $composer.startReplaceGroup(1432788709);
                            ComposerKt.sourceInformation($composer, "CC(remember):RecipeListScreen.kt#9igjgp");
                            boolean invalid$iv2 = $composer.changedInstance(this.$viewModel);
                            final RecipeViewModel recipeViewModel2 = this.$viewModel;
                            Object it$iv2 = $composer.rememberedValue();
                            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                value$iv3 = new Function1() { // from class: com.easycompra.app.ui.recipes.RecipeListScreenKt$RecipeListScreen$3$2$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return RecipeListScreenKt.AnonymousClass3.AnonymousClass2.invoke$lambda$3$lambda$2(recipeViewModel2, (String) obj);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv3);
                            } else {
                                value$iv3 = it$iv2;
                            }
                            $composer.endReplaceGroup();
                            OutlinedTextFieldKt.OutlinedTextField(query, (Function1<? super String, Unit>) value$iv3, modifierFillMaxWidth, false, false, (TextStyle) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$RecipeListScreenKt.INSTANCE.m7213getLambda1$app_debug(), (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, false, (VisualTransformation) null, keyboardOptions, keyboardActions, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer, 12583296, 12779520, 0, 8159096);
                            $composer.startReplaceGroup(1432805231);
                            ComposerKt.sourceInformation($composer, "CC(remember):RecipeListScreen.kt#9igjgp");
                            boolean invalid$iv3 = $composer.changedInstance(this.$viewModel);
                            final RecipeViewModel recipeViewModel3 = this.$viewModel;
                            Object it$iv3 = $composer.rememberedValue();
                            if (invalid$iv3 || it$iv3 == Composer.INSTANCE.getEmpty()) {
                                value$iv4 = new Function0() { // from class: com.easycompra.app.ui.recipes.RecipeListScreenKt$RecipeListScreen$3$2$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return RecipeListScreenKt.AnonymousClass3.AnonymousClass2.invoke$lambda$5$lambda$4(recipeViewModel3);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv4);
                            } else {
                                value$iv4 = it$iv3;
                            }
                            $composer.endReplaceGroup();
                            IconButtonKt.IconButton((Function0) value$iv4, null, false, null, null, ComposableSingletons$RecipeListScreenKt.INSTANCE.m7214getLambda2$app_debug(), $composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                            $composer.endReplaceGroup();
                        } else {
                            $composer.startReplaceGroup(1467449969);
                            ComposerKt.sourceInformation($composer, "101@4480L35,101@4459L150");
                            $composer.startReplaceGroup(1432811758);
                            ComposerKt.sourceInformation($composer, "CC(remember):RecipeListScreen.kt#9igjgp");
                            boolean invalid$iv4 = $composer.changedInstance(this.$viewModel);
                            final RecipeViewModel recipeViewModel4 = this.$viewModel;
                            Object it$iv4 = $composer.rememberedValue();
                            if (invalid$iv4 || it$iv4 == Composer.INSTANCE.getEmpty()) {
                                value$iv = new Function0() { // from class: com.easycompra.app.ui.recipes.RecipeListScreenKt$RecipeListScreen$3$2$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return RecipeListScreenKt.AnonymousClass3.AnonymousClass2.invoke$lambda$7$lambda$6(recipeViewModel4);
                                    }
                                };
                                $composer.updateRememberedValue(value$iv);
                            } else {
                                value$iv = it$iv4;
                            }
                            $composer.endReplaceGroup();
                            IconButtonKt.IconButton((Function0) value$iv, null, false, null, null, ComposableSingletons$RecipeListScreenKt.INSTANCE.m7215getLambda3$app_debug(), $composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
                            $composer.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$3$lambda$2(RecipeViewModel $viewModel, String it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        $viewModel.setQuery(it);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$1$lambda$0(RecipeViewModel $viewModel, KeyboardActionScope KeyboardActions) {
                        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
                        $viewModel.setSearchActive(false);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$5$lambda$4(RecipeViewModel $viewModel) {
                        $viewModel.setSearchActive(false);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final Unit invoke$lambda$7$lambda$6(RecipeViewModel $viewModel) {
                        $viewModel.setSearchActive(true);
                        return Unit.INSTANCE;
                    }
                }
            }, $composer3, 54), null, null, ComposableLambdaKt.rememberComposableLambda(-1594070527, true, new AnonymousClass4(viewModel), $composer3, 54), 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-1757619655, true, new AnonymousClass5(state$delegate, viewModel, onRecipeClick), $composer3, 54), $composer2, 805330992, 493);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.easycompra.app.ui.recipes.RecipeListScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RecipeListScreenKt.RecipeListScreen$lambda$4(viewModel, onRecipeClick, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RecipeUiState RecipeListScreen$lambda$0(State<RecipeUiState> state) {
        Object thisObj$iv = state.getValue();
        return (RecipeUiState) thisObj$iv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecipeListScreen$lambda$2$lambda$1(RecipeViewModel $viewModel) {
        $viewModel.dismissCreateEdit();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.recipes.RecipeListScreenKt$RecipeListScreen$4, reason: invalid class name */
    /* JADX INFO: compiled from: RecipeListScreen.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass4 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ RecipeViewModel $viewModel;

        AnonymousClass4(RecipeViewModel recipeViewModel) {
            this.$viewModel = recipeViewModel;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$1$lambda$0(RecipeViewModel $viewModel) {
            $viewModel.showCreate();
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            Object value$iv;
            ComposerKt.sourceInformation($composer, "C109@4751L26,109@4720L130:RecipeListScreen.kt#y43rd3");
            if (($changed & 3) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1594070527, $changed, -1, "com.easycompra.app.ui.recipes.RecipeListScreen.<anonymous> (RecipeListScreen.kt:109)");
            }
            $composer.startReplaceGroup(-438785338);
            ComposerKt.sourceInformation($composer, "CC(remember):RecipeListScreen.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance(this.$viewModel);
            final RecipeViewModel recipeViewModel = this.$viewModel;
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function0() { // from class: com.easycompra.app.ui.recipes.RecipeListScreenKt$RecipeListScreen$4$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RecipeListScreenKt.AnonymousClass4.invoke$lambda$1$lambda$0(recipeViewModel);
                    }
                };
                $composer.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer.endReplaceGroup();
            FloatingActionButtonKt.m2146FloatingActionButtonXz6DiA((Function0) value$iv, null, null, 0L, 0L, null, null, ComposableSingletons$RecipeListScreenKt.INSTANCE.m7216getLambda4$app_debug(), $composer, 12582912, WebSocketProtocol.PAYLOAD_SHORT);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.recipes.RecipeListScreenKt$RecipeListScreen$5, reason: invalid class name */
    /* JADX INFO: compiled from: RecipeListScreen.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class AnonymousClass5 implements Function3<PaddingValues, Composer, Integer, Unit> {
        final /* synthetic */ Function1<RecipeWithDetails, Unit> $onRecipeClick;
        final /* synthetic */ State<RecipeUiState> $state$delegate;
        final /* synthetic */ RecipeViewModel $viewModel;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass5(State<RecipeUiState> state, RecipeViewModel recipeViewModel, Function1<? super RecipeWithDetails, Unit> function1) {
            this.$state$delegate = state;
            this.$viewModel = recipeViewModel;
            this.$onRecipeClick = function1;
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
            Function0<ComposeUiNode> function1;
            Function0<ComposeUiNode> function2;
            Function0<ComposeUiNode> function3;
            Intrinsics.checkNotNullParameter(padding, "padding");
            ComposerKt.sourceInformation($composer, "C114@4888L2858:RecipeListScreen.kt#y43rd3");
            int $dirty = $changed;
            if (($changed & 6) == 0) {
                $dirty |= $composer.changed(padding) ? 4 : 2;
            }
            if (($dirty & 19) == 18 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1757619655, $dirty, -1, "com.easycompra.app.ui.recipes.RecipeListScreen.<anonymous> (RecipeListScreen.kt:114)");
            }
            Modifier modifier$iv = SizeKt.fillMaxSize$default(PaddingKt.padding(Modifier.INSTANCE, padding), 0.0f, 1, null);
            final State<RecipeUiState> state = this.$state$delegate;
            final RecipeViewModel recipeViewModel = this.$viewModel;
            final Function1<RecipeWithDetails, Unit> function4 = this.$onRecipeClick;
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
            ComposerKt.sourceInformationMarkerStart($composer, 1468075736, "C120@5222L322,116@4984L560:RecipeListScreen.kt#y43rd3");
            Modifier modifierM682paddingVpY3zN4 = PaddingKt.m682paddingVpY3zN4(Modifier.INSTANCE, Dp.m6663constructorimpl(8), Dp.m6663constructorimpl(4));
            Arrangement.HorizontalOrVertical horizontalOrVerticalM561spacedBy0680j_4 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(6));
            PaddingValues paddingValuesM676PaddingValuesYgX7TsA$default = PaddingKt.m676PaddingValuesYgX7TsA$default(Dp.m6663constructorimpl(4), 0.0f, 2, null);
            Arrangement.HorizontalOrVertical horizontalOrVertical = horizontalOrVerticalM561spacedBy0680j_4;
            $composer.startReplaceGroup(1432835789);
            ComposerKt.sourceInformation($composer, "CC(remember):RecipeListScreen.kt#9igjgp");
            boolean invalid$iv = $composer.changed(state) | $composer.changedInstance(recipeViewModel);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new Function1() { // from class: com.easycompra.app.ui.recipes.RecipeListScreenKt$RecipeListScreen$5$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RecipeListScreenKt.AnonymousClass5.invoke$lambda$14$lambda$3$lambda$2(recipeViewModel, state, (LazyListScope) obj);
                    }
                };
                $composer.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            $composer.endReplaceGroup();
            LazyDslKt.LazyRow(modifierM682paddingVpY3zN4, null, paddingValuesM676PaddingValuesYgX7TsA$default, false, horizontalOrVertical, null, null, false, (Function1) value$iv, $composer, 24966, 234);
            if (RecipeListScreenKt.RecipeListScreen$lambda$0(state).getAllRecipes().isEmpty()) {
                $composer.startReplaceGroup(1468608532);
                ComposerKt.sourceInformation($composer, "131@5608L515");
                Modifier modifier$iv2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
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
                ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                int i4 = ((54 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 1158970559, "C132@5695L410:RecipeListScreen.kt#y43rd3");
                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                Arrangement.HorizontalOrVertical horizontalOrVerticalM561spacedBy0680j_5 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(8));
                ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                Modifier modifier$iv3 = Modifier.INSTANCE;
                MeasurePolicy measurePolicy$iv3 = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM561spacedBy0680j_5, centerHorizontally, $composer, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                int $changed$iv$iv3 = (432 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                CompositionLocalMap localMap$iv$iv3 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    function3 = constructor3;
                    $composer.createNode(function3);
                } else {
                    function3 = constructor3;
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
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                int i6 = ((432 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -473057149, "C136@5953L10,136@5900L96,137@6021L62:RecipeListScreen.kt#y43rd3");
                TextKt.m2714Text4IGK_g("No hay recetas todavía", (Modifier) null, Color.INSTANCE.m4211getGray0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getTitleMedium(), $composer, 390, 0, 65530);
                TextKt.m2714Text4IGK_g("Pulsa + para crear la primera", (Modifier) null, Color.INSTANCE.m4213getLightGray0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 390, 0, 131066);
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
            } else if (RecipeListScreenKt.RecipeListScreen$lambda$0(state).getGrouped().isEmpty()) {
                $composer.startReplaceGroup(1469174468);
                ComposerKt.sourceInformation($composer, "141@6190L147");
                Modifier modifier$iv4 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                Alignment contentAlignment$iv2 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv4 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                int $changed$iv$iv4 = (54 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                CompositionLocalMap localMap$iv$iv4 = $composer.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer, modifier$iv4);
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer.startReusableNode();
                if ($composer.getInserting()) {
                    function1 = constructor4;
                    $composer.createNode(function1);
                } else {
                    function1 = constructor4;
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
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                int i8 = ((54 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer, 1159536495, "C142@6277L42:RecipeListScreen.kt#y43rd3");
                TextKt.m2714Text4IGK_g("Sin resultados", (Modifier) null, Color.INSTANCE.m4211getGray0d7_KjU(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 390, 0, 131066);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                ComposerKt.sourceInformationMarkerEnd($composer);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(1469395188);
                ComposerKt.sourceInformation($composer, "148@6527L1195,145@6375L1347");
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                PaddingValues paddingValuesM678PaddingValuesa9UjIt4$default = PaddingKt.m678PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m6663constructorimpl(80), 7, null);
                $composer.startReplaceGroup(1432878422);
                ComposerKt.sourceInformation($composer, "CC(remember):RecipeListScreen.kt#9igjgp");
                boolean invalid$iv2 = $composer.changed(state) | $composer.changed(function4) | $composer.changedInstance(recipeViewModel);
                Object it$iv2 = $composer.rememberedValue();
                if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv2 = new Function1() { // from class: com.easycompra.app.ui.recipes.RecipeListScreenKt$RecipeListScreen$5$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return RecipeListScreenKt.AnonymousClass5.invoke$lambda$14$lambda$13$lambda$12(state, function4, recipeViewModel, (LazyListScope) obj);
                        }
                    };
                    $composer.updateRememberedValue(value$iv2);
                } else {
                    value$iv2 = it$iv2;
                }
                $composer.endReplaceGroup();
                LazyDslKt.LazyColumn(modifierFillMaxSize$default, null, paddingValuesM678PaddingValuesa9UjIt4$default, false, null, null, null, false, (Function1) value$iv2, $composer, 390, 250);
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
        public static final Unit invoke$lambda$14$lambda$3$lambda$2(final RecipeViewModel $viewModel, final State $state$delegate, LazyListScope LazyRow) {
            Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
            final List items$iv = RecipeFilter.getEntries();
            final Function1 contentType$iv = new Function1() { // from class: com.easycompra.app.ui.recipes.RecipeListScreenKt$RecipeListScreen$5$invoke$lambda$14$lambda$3$lambda$2$$inlined$items$default$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                    return invoke((RecipeFilter) p1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(RecipeFilter recipeFilter) {
                    return null;
                }
            };
            LazyRow.items(items$iv.size(), null, new Function1<Integer, Object>() { // from class: com.easycompra.app.ui.recipes.RecipeListScreenKt$RecipeListScreen$5$invoke$lambda$14$lambda$3$lambda$2$$inlined$items$default$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                    return invoke(num.intValue());
                }

                public final Object invoke(int index) {
                    return contentType$iv.invoke(items$iv.get(index));
                }
            }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeListScreenKt$RecipeListScreen$5$invoke$lambda$14$lambda$3$lambda$2$$inlined$items$default$4
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
                    final RecipeFilter f = (RecipeFilter) items$iv.get(it);
                    $composer.startReplaceGroup(2015987618);
                    ComposerKt.sourceInformation($composer, "C*124@5395L26,125@5455L35,122@5295L217:RecipeListScreen.kt#y43rd3");
                    boolean z = RecipeListScreenKt.RecipeListScreen$lambda$0($state$delegate).getFilter() == f;
                    $composer.startReplaceGroup(-1597533118);
                    ComposerKt.sourceInformation($composer, "CC(remember):RecipeListScreen.kt#9igjgp");
                    boolean invalid$iv = $composer.changedInstance($viewModel) | (((($changed2 & 112) ^ 48) > 32 && $composer.changed(f)) || ($changed2 & 48) == 32);
                    Object it$iv = $composer.rememberedValue();
                    if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                        final RecipeViewModel recipeViewModel = $viewModel;
                        value$iv = (Function0) new Function0<Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeListScreenKt$RecipeListScreen$5$1$1$1$1$1$1
                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                recipeViewModel.setFilter(f);
                            }
                        };
                        $composer.updateRememberedValue(value$iv);
                    } else {
                        value$iv = it$iv;
                    }
                    $composer.endReplaceGroup();
                    ChipKt.FilterChip(z, (Function0) value$iv, ComposableLambdaKt.rememberComposableLambda(-1394057784, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeListScreenKt$RecipeListScreen$5$1$1$1$1$2
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer2, int $changed3) {
                            ComposerKt.sourceInformation($composer2, "C125@5457L31:RecipeListScreen.kt#y43rd3");
                            if (($changed3 & 3) == 2 && $composer2.getSkipping()) {
                                $composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1394057784, $changed3, -1, "com.easycompra.app.ui.recipes.RecipeListScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RecipeListScreen.kt:125)");
                            }
                            TextKt.m2714Text4IGK_g(f.getLabel(), (Modifier) null, 0L, TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 3072, 0, 131062);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, $composer, 54), null, false, null, null, null, null, null, null, null, $composer, 384, 0, 4088);
                    $composer.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$14$lambda$13$lambda$12(State $state$delegate, final Function1 $onRecipeClick, final RecipeViewModel $viewModel, LazyListScope LazyColumn) {
            Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
            Iterable $this$forEach$iv = RecipeListScreenKt.RecipeListScreen$lambda$0($state$delegate).getGrouped().entrySet();
            for (Object element$iv : $this$forEach$iv) {
                Map.Entry entry = (Map.Entry) element$iv;
                final String category = (String) entry.getKey();
                final List recipes = (List) entry.getValue();
                LazyListScope.item$default(LazyColumn, "cat_" + category, null, ComposableLambdaKt.composableLambdaInstance(55675138, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeListScreenKt$RecipeListScreen$5$1$4$1$1$1
                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                        invoke(lazyItemScope, composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LazyItemScope item, Composer $composer, int $changed) {
                        Intrinsics.checkNotNullParameter(item, "$this$item");
                        ComposerKt.sourceInformation($composer, "C153@6807L10,155@6946L11,158@7133L11,151@6686L599:RecipeListScreen.kt#y43rd3");
                        if (($changed & 17) == 16 && $composer.getSkipping()) {
                            $composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(55675138, $changed, -1, "com.easycompra.app.ui.recipes.RecipeListScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RecipeListScreen.kt:151)");
                        }
                        String upperCase = category.toUpperCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                        TextStyle labelLarge = MaterialTheme.INSTANCE.getTypography($composer, MaterialTheme.$stable).getLabelLarge();
                        FontWeight bold = FontWeight.INSTANCE.getBold();
                        long primary = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary();
                        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        long primaryContainer = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimaryContainer();
                        TextKt.m2714Text4IGK_g(upperCase, PaddingKt.m682paddingVpY3zN4(BackgroundKt.m236backgroundbw27NRU$default(modifierFillMaxWidth$default, Color.m4179copywmQWz5c(primaryContainer, (14 & 1) != 0 ? Color.m4183getAlphaimpl(primaryContainer) : 0.4f, (14 & 2) != 0 ? Color.m4187getRedimpl(primaryContainer) : 0.0f, (14 & 4) != 0 ? Color.m4186getGreenimpl(primaryContainer) : 0.0f, (14 & 8) != 0 ? Color.m4184getBlueimpl(primaryContainer) : 0.0f), null, 2, null), Dp.m6663constructorimpl(16), Dp.m6663constructorimpl(6)), primary, 0L, (FontStyle) null, bold, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, labelLarge, $composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 0, 65496);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), 2, null);
                final Function1 key$iv = new Function1() { // from class: com.easycompra.app.ui.recipes.RecipeListScreenKt$RecipeListScreen$5$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RecipeListScreenKt.AnonymousClass5.invoke$lambda$14$lambda$13$lambda$12$lambda$11$lambda$7((RecipeWithDetails) obj);
                    }
                };
                final Function1 contentType$iv = new Function1() { // from class: com.easycompra.app.ui.recipes.RecipeListScreenKt$RecipeListScreen$5$invoke$lambda$14$lambda$13$lambda$12$lambda$11$$inlined$items$default$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                        return invoke((RecipeWithDetails) p1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Void invoke(RecipeWithDetails recipeWithDetails) {
                        return null;
                    }
                };
                LazyColumn.items(recipes.size(), new Function1<Integer, Object>() { // from class: com.easycompra.app.ui.recipes.RecipeListScreenKt$RecipeListScreen$5$invoke$lambda$14$lambda$13$lambda$12$lambda$11$$inlined$items$default$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Object invoke(int index) {
                        return key$iv.invoke(recipes.get(index));
                    }
                }, new Function1<Integer, Object>() { // from class: com.easycompra.app.ui.recipes.RecipeListScreenKt$RecipeListScreen$5$invoke$lambda$14$lambda$13$lambda$12$lambda$11$$inlined$items$default$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Object invoke(int index) {
                        return contentType$iv.invoke(recipes.get(index));
                    }
                }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeListScreenKt$RecipeListScreen$5$invoke$lambda$14$lambda$13$lambda$12$lambda$11$$inlined$items$default$4
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
                        final RecipeWithDetails recipe = (RecipeWithDetails) recipes.get(it);
                        $composer.startReplaceGroup(1434422123);
                        ComposerKt.sourceInformation($composer, "C*165@7518L25,166@7590L36,163@7415L241:RecipeListScreen.kt#y43rd3");
                        $composer.startReplaceGroup(-1339198560);
                        ComposerKt.sourceInformation($composer, "CC(remember):RecipeListScreen.kt#9igjgp");
                        boolean invalid$iv = $composer.changed($onRecipeClick) | $composer.changedInstance(recipe);
                        Object it$iv = $composer.rememberedValue();
                        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                            final Function1 function1 = $onRecipeClick;
                            value$iv = (Function0) new Function0<Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeListScreenKt$RecipeListScreen$5$1$4$1$1$3$1$1
                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    function1.invoke(recipe);
                                }
                            };
                            $composer.updateRememberedValue(value$iv);
                        } else {
                            value$iv = it$iv;
                        }
                        Function0 function0 = (Function0) value$iv;
                        $composer.endReplaceGroup();
                        $composer.startReplaceGroup(-1339196245);
                        ComposerKt.sourceInformation($composer, "CC(remember):RecipeListScreen.kt#9igjgp");
                        boolean invalid$iv2 = $composer.changedInstance($viewModel) | $composer.changedInstance(recipe);
                        Object it$iv2 = $composer.rememberedValue();
                        if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                            final RecipeViewModel recipeViewModel = $viewModel;
                            value$iv2 = new Function0<Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeListScreenKt$RecipeListScreen$5$1$4$1$1$3$2$1
                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    recipeViewModel.toggleFavorite(recipe);
                                }
                            };
                            $composer.updateRememberedValue(value$iv2);
                        } else {
                            value$iv2 = it$iv2;
                        }
                        $composer.endReplaceGroup();
                        RecipeListScreenKt.RecipeCard(recipe, function0, (Function0) value$iv2, $composer, ($changed2 >> 3) & 14);
                        $composer.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }));
                $this$forEach$iv = $this$forEach$iv;
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object invoke$lambda$14$lambda$13$lambda$12$lambda$11$lambda$7(RecipeWithDetails it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getRecipe().getId();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RecipeCard(final RecipeWithDetails recipe, final Function0<Unit> function0, final Function0<Unit> function1, Composer $composer, final int $changed) {
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-603367951);
        ComposerKt.sourceInformation($composer3, "C(RecipeCard)P(2)189@8148L19,190@8199L40,191@8246L2549,183@7909L2886:RecipeListScreen.kt#y43rd3");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(recipe) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 147) != 146 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-603367951, $dirty2, -1, "com.easycompra.app.ui.recipes.RecipeCard (RecipeListScreen.kt:181)");
            }
            final RecipeEntity r = recipe.getRecipe();
            Modifier modifierM269clickableXHw0xAI$default = ClickableKt.m269clickableXHw0xAI$default(PaddingKt.m682paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m6663constructorimpl(12), Dp.m6663constructorimpl(4)), false, null, null, function0, 7, null);
            RoundedCornerShape roundedCornerShapeM964RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m964RoundedCornerShape0680j_4(Dp.m6663constructorimpl(12));
            CardDefaults cardDefaults = CardDefaults.INSTANCE;
            float fM6663constructorimpl = Dp.m6663constructorimpl(2);
            int $i$f$getDp = CardDefaults.$stable;
            $composer2 = $composer3;
            CardKt.Card(modifierM269clickableXHw0xAI$default, roundedCornerShapeM964RoundedCornerShape0680j_4, CardDefaults.INSTANCE.m1850cardColorsro_MJ88(Color.INSTANCE.m4218getWhite0d7_KjU(), 0L, 0L, 0L, $composer2, (CardDefaults.$stable << 12) | 6, 14), cardDefaults.m1851cardElevationaqJV_2Y(fM6663constructorimpl, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer2, ($i$f$getDp << 18) | 6, 62), null, ComposableLambdaKt.rememberComposableLambda(-116495553, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeListScreenKt.RecipeCard.1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
                    invoke(columnScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code duplicated, block: B:42:0x02ad  */
                /* JADX WARN: Code duplicated, block: B:43:0x02eb  */
                /* JADX WARN: Code duplicated, block: B:46:0x03a0  */
                /* JADX WARN: Code duplicated, block: B:49:0x03ac  */
                /* JADX WARN: Code duplicated, block: B:50:0x03b2  */
                /* JADX WARN: Code duplicated, block: B:61:0x05b4  */
                /* JADX WARN: Code duplicated, block: B:64:0x05c0  */
                /* JADX WARN: Code duplicated, block: B:65:0x05c6  */
                /* JADX WARN: Code duplicated, block: B:76:0x0673  */
                /* JADX WARN: Code duplicated, block: B:79:0x06a6  */
                /* JADX WARN: Code duplicated, block: B:80:0x06a9  */
                /* JADX WARN: Code duplicated, block: B:83:0x072c  */
                /* JADX WARN: Code duplicated, block: B:86:? A[RETURN, SYNTHETIC] */
                public final void invoke(ColumnScope Card, Composer $composer4, int $changed2) {
                    Function0<ComposeUiNode> function2;
                    Function0<ComposeUiNode> function3;
                    CompositionLocalMap localMap$iv$iv;
                    int compositeKeyHash$iv$iv;
                    Function0<ComposeUiNode> constructor;
                    Composer $this$Layout_u24lambda_u240$iv$iv;
                    int compositeKeyHash$iv$iv2;
                    Function0<ComposeUiNode> constructor2;
                    Function0<ComposeUiNode> function4;
                    Composer $this$Layout_u24lambda_u240$iv$iv2;
                    String str;
                    Intrinsics.checkNotNullParameter(Card, "$this$Card");
                    ComposerKt.sourceInformation($composer4, "C192@8256L2533:RecipeListScreen.kt#y43rd3");
                    if (($changed2 & 17) != 16 || !$composer4.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-116495553, $changed2, -1, "com.easycompra.app.ui.recipes.RecipeCard.<anonymous> (RecipeListScreen.kt:192)");
                        }
                        final RecipeEntity recipeEntity = r;
                        Function0<Unit> function5 = function1;
                        RecipeWithDetails recipeWithDetails = recipe;
                        ComposerKt.sourceInformationMarkerStart($composer4, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                        Modifier modifier$iv = Modifier.INSTANCE;
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv3 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv2 = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            function2 = constructor3;
                            $composer4.createNode(function2);
                        } else {
                            function2 = constructor3;
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.m3674constructorimpl($composer4);
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv3.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv3.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv3))) {
                            $this$Layout_u24lambda_u240$iv$iv3.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv3));
                            $this$Layout_u24lambda_u240$iv$iv3.apply(Integer.valueOf(compositeKeyHash$iv$iv3), setCompositeKeyHash);
                        }
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        int i2 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -205447540, "C198@8523L11,193@8277L1872,238@10163L616:RecipeListScreen.kt#y43rd3");
                        Modifier modifier$iv2 = BackgroundKt.m236backgroundbw27NRU$default(ClipKt.clip(AspectRatioKt.aspectRatio$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 2.2857144f, false, 2, null), RoundedCornerShapeKt.m966RoundedCornerShapea9UjIt4$default(Dp.m6663constructorimpl(12), Dp.m6663constructorimpl(12), 0.0f, 0.0f, 12, null)), MaterialTheme.INSTANCE.getColorScheme($composer4, MaterialTheme.$stable).getPrimaryContainer(), null, 2, null);
                        ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                        MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv2 = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv4 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
                        Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            function3 = constructor4;
                            $composer4.createNode(function3);
                        } else {
                            function3 = constructor4;
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv4 = Updater.m3674constructorimpl($composer4);
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv4, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv4, localMap$iv$iv3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!$this$Layout_u24lambda_u240$iv$iv4.getInserting()) {
                            localMap$iv$iv = localMap$iv$iv3;
                            if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv4.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv4))) {
                            }
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                            int i4 = ((0 >> 6) & 112) | 6;
                            BoxScope $this$invoke_u24lambda_u243_u24lambda_u241 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer4, 944342053, "C209@8969L677,229@9827L308,226@9691L444:RecipeListScreen.kt#y43rd3");
                            $composer4.startReplaceGroup(-800822581);
                            ComposerKt.sourceInformation($composer4, "201@8636L246");
                            if (!StringsKt.isBlank(recipeEntity.getPhotoUrl())) {
                                SingletonAsyncImageKt.m7012AsyncImagegl8XCv8(recipeEntity.getPhotoUrl(), recipeEntity.getName(), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, false, null, $composer4, 1573248, 0, 4024);
                            }
                            $composer4.endReplaceGroup();
                            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                            Brush.Companion companion = Brush.INSTANCE;
                            long jM4207getBlack0d7_KjU = Color.INSTANCE.m4207getBlack0d7_KjU();
                            Modifier modifier$iv3 = BackgroundKt.background$default(modifierFillMaxSize$default, Brush.Companion.m4138verticalGradient8A3gB4$default(companion, CollectionsKt.listOf((Object[]) new Color[]{Color.m4171boximpl(Color.INSTANCE.m4216getTransparent0d7_KjU()), Color.m4171boximpl(Color.m4179copywmQWz5c(jM4207getBlack0d7_KjU, (14 & 1) != 0 ? Color.m4183getAlphaimpl(jM4207getBlack0d7_KjU) : 0.6f, (14 & 2) != 0 ? Color.m4187getRedimpl(jM4207getBlack0d7_KjU) : 0.0f, (14 & 4) != 0 ? Color.m4186getGreenimpl(jM4207getBlack0d7_KjU) : 0.0f, (14 & 8) != 0 ? Color.m4184getBlueimpl(jM4207getBlack0d7_KjU) : 0.0f))}), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null);
                            Alignment contentAlignment$iv2 = Alignment.INSTANCE.getBottomStart();
                            ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                            int $changed$iv$iv3 = (54 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                            compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                            CompositionLocalMap localMap$iv$iv4 = $composer4.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!($composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer4.startReusableNode();
                            if ($composer4.getInserting()) {
                                $composer4.createNode(constructor);
                            } else {
                                $composer4.useNode();
                            }
                            $this$Layout_u24lambda_u240$iv$iv = Updater.m3674constructorimpl($composer4);
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!$this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash3);
                            }
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv3, ComposeUiNode.INSTANCE.getSetModifier());
                            int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            int i6 = ((54 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, 1152280842, "C215@9266L362:RecipeListScreen.kt#y43rd3");
                            TextKt.m2714Text4IGK_g(recipeEntity.getName(), PaddingKt.m681padding3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(10)), Color.INSTANCE.m4218getWhite0d7_KjU(), TextUnitKt.getSp(16), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6580getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 200112, 3120, 120784);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            IconButtonKt.IconButton(function5, $this$invoke_u24lambda_u243_u24lambda_u241.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopEnd()), false, null, null, ComposableLambdaKt.rememberComposableLambda(1584618054, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeListScreenKt$RecipeCard$1$1$1$2
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                    invoke(composer, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer $composer5, int $changed3) {
                                    ComposerKt.sourceInformation($composer5, "C230@9849L268:RecipeListScreen.kt#y43rd3");
                                    if (($changed3 & 3) != 2 || !$composer5.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1584618054, $changed3, -1, "com.easycompra.app.ui.recipes.RecipeCard.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RecipeListScreen.kt:230)");
                                        }
                                        IconKt.m2171Iconww6aTOc(recipeEntity.isFavorite() ? FavoriteKt.getFavorite(Icons.INSTANCE.getDefault()) : FavoriteBorderKt.getFavoriteBorder(Icons.INSTANCE.getDefault()), "Favorita", (Modifier) null, recipeEntity.isFavorite() ? ColorKt.Color(4294197086L) : Color.INSTANCE.m4218getWhite0d7_KjU(), $composer5, 48, 4);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    $composer5.skipToGroupEnd();
                                }
                            }, $composer4, 54), $composer4, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            Modifier modifier$iv4 = PaddingKt.m682paddingVpY3zN4(Modifier.INSTANCE, Dp.m6663constructorimpl(12), Dp.m6663constructorimpl(8));
                            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(8));
                            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                            ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                            MeasurePolicy measurePolicy$iv4 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer4, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                            int $changed$iv$iv4 = (438 << 3) & 112;
                            ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                            compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                            CompositionLocalMap localMap$iv$iv5 = $composer4.getCurrentCompositionLocalMap();
                            Modifier materialized$iv$iv4 = ComposedModifierKt.materializeModifier($composer4, modifier$iv4);
                            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                            int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 6) & 896) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                            if (!($composer4.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer4.startReusableNode();
                            if ($composer4.getInserting()) {
                                function4 = constructor2;
                                $composer4.createNode(function4);
                            } else {
                                function4 = constructor2;
                                $composer4.useNode();
                            }
                            $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3674constructorimpl($composer4);
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                            if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash4);
                            }
                            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv4, ComposeUiNode.INSTANCE.getSetModifier());
                            int i7 = ($changed$iv$iv$iv4 >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer4, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                            int i8 = ((438 >> 6) & 112) | 6;
                            RowScope $this$invoke_u24lambda_u243_u24lambda_u242 = RowScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart($composer4, 946118291, "C243@10413L29,245@10531L27,246@10575L190:RecipeListScreen.kt#y43rd3");
                            RecipeListScreenKt.DifficultyBadge(recipeEntity.getDifficulty(), $composer4, 0);
                            $composer4.startReplaceGroup(-800762873);
                            ComposerKt.sourceInformation($composer4, "244@10486L28");
                            if (recipeEntity.getPrepTimeMinutes() > 0) {
                                RecipeListScreenKt.TimeBadge(recipeEntity.getPrepTimeMinutes(), $composer4, 0);
                            }
                            $composer4.endReplaceGroup();
                            SpacerKt.Spacer(RowScope.weight$default($this$invoke_u24lambda_u243_u24lambda_u242, Modifier.INSTANCE, 1.0f, false, 2, null), $composer4, 0);
                            int size = recipeWithDetails.getIngredients().size();
                            if (recipeWithDetails.getIngredients().size() != 1) {
                                str = "s";
                            } else {
                                str = "";
                            }
                            TextKt.m2714Text4IGK_g(size + " ingrediente" + str, (Modifier) null, Color.INSTANCE.m4211getGray0d7_KjU(), TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 3456, 0, 131058);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            $composer4.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            ComposerKt.sourceInformationMarkerEnd($composer4);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        localMap$iv$iv = localMap$iv$iv3;
                        $this$Layout_u24lambda_u240$iv$iv4.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv4));
                        $this$Layout_u24lambda_u240$iv$iv4.apply(Integer.valueOf(compositeKeyHash$iv$iv4), setCompositeKeyHash2);
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv4, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                        int i9 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        int i10 = ((0 >> 6) & 112) | 6;
                        BoxScope $this$invoke_u24lambda_u243_u24lambda_u243 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer4, 944342053, "C209@8969L677,229@9827L308,226@9691L444:RecipeListScreen.kt#y43rd3");
                        $composer4.startReplaceGroup(-800822581);
                        ComposerKt.sourceInformation($composer4, "201@8636L246");
                        if (!StringsKt.isBlank(recipeEntity.getPhotoUrl())) {
                            SingletonAsyncImageKt.m7012AsyncImagegl8XCv8(recipeEntity.getPhotoUrl(), recipeEntity.getName(), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, false, null, $composer4, 1573248, 0, 4024);
                        }
                        $composer4.endReplaceGroup();
                        Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Brush.Companion companion2 = Brush.INSTANCE;
                        long jM4207getBlack0d7_KjU2 = Color.INSTANCE.m4207getBlack0d7_KjU();
                        Modifier modifier$iv5 = BackgroundKt.background$default(modifierFillMaxSize$default2, Brush.Companion.m4138verticalGradient8A3gB4$default(companion2, CollectionsKt.listOf((Object[]) new Color[]{Color.m4171boximpl(Color.INSTANCE.m4216getTransparent0d7_KjU()), Color.m4171boximpl(Color.m4179copywmQWz5c(jM4207getBlack0d7_KjU2, (14 & 1) != 0 ? Color.m4183getAlphaimpl(jM4207getBlack0d7_KjU2) : 0.6f, (14 & 2) != 0 ? Color.m4187getRedimpl(jM4207getBlack0d7_KjU2) : 0.0f, (14 & 4) != 0 ? Color.m4186getGreenimpl(jM4207getBlack0d7_KjU2) : 0.0f, (14 & 8) != 0 ? Color.m4184getBlueimpl(jM4207getBlack0d7_KjU2) : 0.0f))}), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null);
                        Alignment contentAlignment$iv3 = Alignment.INSTANCE.getBottomStart();
                        ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv5 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv3, false);
                        int $changed$iv$iv5 = (54 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv6 = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv5 = ComposedModifierKt.materializeModifier($composer4, modifier$iv5);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv5 = (($changed$iv$iv5 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            $composer4.createNode(constructor);
                        } else {
                            $composer4.useNode();
                        }
                        $this$Layout_u24lambda_u240$iv$iv = Updater.m3674constructorimpl($composer4);
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!$this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                        }
                        $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                        $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash5);
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv5, ComposeUiNode.INSTANCE.getSetModifier());
                        int i11 = ($changed$iv$iv$iv5 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                        int i12 = ((54 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, 1152280842, "C215@9266L362:RecipeListScreen.kt#y43rd3");
                        TextKt.m2714Text4IGK_g(recipeEntity.getName(), PaddingKt.m681padding3ABfNKs(Modifier.INSTANCE, Dp.m6663constructorimpl(10)), Color.INSTANCE.m4218getWhite0d7_KjU(), TextUnitKt.getSp(16), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, TextOverflow.INSTANCE.m6580getEllipsisgIe3tQ8(), false, 1, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 200112, 3120, 120784);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        IconButtonKt.IconButton(function5, $this$invoke_u24lambda_u243_u24lambda_u243.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopEnd()), false, null, null, ComposableLambdaKt.rememberComposableLambda(1584618054, true, new Function2<Composer, Integer, Unit>() { // from class: com.easycompra.app.ui.recipes.RecipeListScreenKt$RecipeCard$1$1$1$2
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer5, int $changed3) {
                                ComposerKt.sourceInformation($composer5, "C230@9849L268:RecipeListScreen.kt#y43rd3");
                                if (($changed3 & 3) != 2 || !$composer5.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1584618054, $changed3, -1, "com.easycompra.app.ui.recipes.RecipeCard.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RecipeListScreen.kt:230)");
                                    }
                                    IconKt.m2171Iconww6aTOc(recipeEntity.isFavorite() ? FavoriteKt.getFavorite(Icons.INSTANCE.getDefault()) : FavoriteBorderKt.getFavoriteBorder(Icons.INSTANCE.getDefault()), "Favorita", (Modifier) null, recipeEntity.isFavorite() ? ColorKt.Color(4294197086L) : Color.INSTANCE.m4218getWhite0d7_KjU(), $composer5, 48, 4);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer5.skipToGroupEnd();
                            }
                        }, $composer4, 54), $composer4, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        Modifier modifier$iv6 = PaddingKt.m682paddingVpY3zN4(Modifier.INSTANCE, Dp.m6663constructorimpl(12), Dp.m6663constructorimpl(8));
                        Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.m561spacedBy0680j_4(Dp.m6663constructorimpl(8));
                        Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart($composer4, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv6 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer4, ((438 >> 3) & 14) | ((438 >> 3) & 112));
                        int $changed$iv$iv6 = (438 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                        CompositionLocalMap localMap$iv$iv7 = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv6 = ComposedModifierKt.materializeModifier($composer4, modifier$iv6);
                        constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv6 = (($changed$iv$iv6 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            function4 = constructor2;
                            $composer4.createNode(function4);
                        } else {
                            function4 = constructor2;
                            $composer4.useNode();
                        }
                        $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3674constructorimpl($composer4);
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (!$this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                        }
                        $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                        $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), setCompositeKeyHash6);
                        Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv6, ComposeUiNode.INSTANCE.getSetModifier());
                        int i13 = ($changed$iv$iv$iv6 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                        int i14 = ((438 >> 6) & 112) | 6;
                        RowScope $this$invoke_u24lambda_u243_u24lambda_u244 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer4, 946118291, "C243@10413L29,245@10531L27,246@10575L190:RecipeListScreen.kt#y43rd3");
                        RecipeListScreenKt.DifficultyBadge(recipeEntity.getDifficulty(), $composer4, 0);
                        $composer4.startReplaceGroup(-800762873);
                        ComposerKt.sourceInformation($composer4, "244@10486L28");
                        if (recipeEntity.getPrepTimeMinutes() > 0) {
                            RecipeListScreenKt.TimeBadge(recipeEntity.getPrepTimeMinutes(), $composer4, 0);
                        }
                        $composer4.endReplaceGroup();
                        SpacerKt.Spacer(RowScope.weight$default($this$invoke_u24lambda_u243_u24lambda_u244, Modifier.INSTANCE, 1.0f, false, 2, null), $composer4, 0);
                        int size2 = recipeWithDetails.getIngredients().size();
                        if (recipeWithDetails.getIngredients().size() != 1) {
                            str = "s";
                        } else {
                            str = "";
                        }
                        TextKt.m2714Text4IGK_g(size2 + " ingrediente" + str, (Modifier) null, Color.INSTANCE.m4211getGray0d7_KjU(), TextUnitKt.getSp(12), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 3456, 0, 131058);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.recipes.RecipeListScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RecipeListScreenKt.RecipeCard$lambda$5(recipe, function0, function1, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x020e  */
    public static final void DifficultyBadge(final String difficulty, Composer $composer, final int $changed) {
        long color;
        Modifier modifier$iv;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(difficulty, "difficulty");
        Composer $composer3 = $composer.startRestartGroup(2104670438);
        ComposerKt.sourceInformation($composer3, "C(DifficultyBadge)262@11007L282:RecipeListScreen.kt#y43rd3");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(difficulty) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 3) != 2 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2104670438, $dirty2, -1, "com.easycompra.app.ui.recipes.DifficultyBadge (RecipeListScreen.kt:256)");
            }
            if (Intrinsics.areEqual(difficulty, RecipeDifficulty.EASY)) {
                color = ColorKt.Color(4279286145L);
            } else {
                color = Intrinsics.areEqual(difficulty, RecipeDifficulty.MEDIUM) ? ColorKt.Color(4294286859L) : ColorKt.Color(4293870660L);
            }
            Modifier modifier$iv2 = PaddingKt.m682paddingVpY3zN4(BackgroundKt.m236backgroundbw27NRU$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.m964RoundedCornerShape0680j_4(Dp.m6663constructorimpl(4))), Color.m4179copywmQWz5c(color, (14 & 1) != 0 ? Color.m4183getAlphaimpl(color) : 0.15f, (14 & 2) != 0 ? Color.m4187getRedimpl(color) : 0.0f, (14 & 4) != 0 ? Color.m4186getGreenimpl(color) : 0.0f, (14 & 8) != 0 ? Color.m4184getBlueimpl(color) : 0.0f), null, 2, null), Dp.m6663constructorimpl(6), Dp.m6663constructorimpl(2));
            ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
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
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting()) {
                modifier$iv = modifier$iv2;
            } else {
                modifier$iv = modifier$iv2;
                if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                }
                Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                int i = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                int i2 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -853097410, "C268@11200L83:RecipeListScreen.kt#y43rd3");
                $composer2 = $composer3;
                TextKt.m2714Text4IGK_g(difficulty, (Modifier) null, color, TextUnitKt.getSp(11), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, ($dirty2 & 14) | 199680, 0, 131026);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -853097410, "C268@11200L83:RecipeListScreen.kt#y43rd3");
            $composer2 = $composer3;
            TextKt.m2714Text4IGK_g(difficulty, (Modifier) null, color, TextUnitKt.getSp(11), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, ($dirty2 & 14) | 199680, 0, 131026);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.recipes.RecipeListScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RecipeListScreenKt.DifficultyBadge$lambda$7(difficulty, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void TimeBadge(final int minutes, Composer $composer, final int $changed) {
        Function0<ComposeUiNode> function0;
        Composer $composer2 = $composer.startRestartGroup(-1125818218);
        ComposerKt.sourceInformation($composer2, "C(TimeBadge)283@11620L11,280@11505L327:RecipeListScreen.kt#y43rd3");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(minutes) ? 4 : 2;
        }
        if (($dirty & 3) != 2 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1125818218, $dirty, -1, "com.easycompra.app.ui.recipes.TimeBadge (RecipeListScreen.kt:273)");
            }
            int h = minutes / 60;
            int m = minutes % 60;
            StringBuilder $this$TimeBadge_u24lambda_u248 = new StringBuilder();
            if (h > 0) {
                $this$TimeBadge_u24lambda_u248.append(h + "h ");
            }
            if (m > 0) {
                $this$TimeBadge_u24lambda_u248.append(m + "min");
            }
            String string = $this$TimeBadge_u24lambda_u248.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            String label = StringsKt.trim((CharSequence) string).toString();
            Modifier modifierClip = ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.m964RoundedCornerShape0680j_4(Dp.m6663constructorimpl(4)));
            long secondaryContainer = MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getSecondaryContainer();
            Modifier modifier$iv = PaddingKt.m682paddingVpY3zN4(BackgroundKt.m236backgroundbw27NRU$default(modifierClip, Color.m4179copywmQWz5c(secondaryContainer, (14 & 1) != 0 ? Color.m4183getAlphaimpl(secondaryContainer) : 0.6f, (14 & 2) != 0 ? Color.m4187getRedimpl(secondaryContainer) : 0.0f, (14 & 4) != 0 ? Color.m4186getGreenimpl(secondaryContainer) : 0.0f, (14 & 8) != 0 ? Color.m4184getBlueimpl(secondaryContainer) : 0.0f), null, 2, null), Dp.m6663constructorimpl(6), Dp.m6663constructorimpl(2));
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
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
            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), setCompositeKeyHash);
            }
            Updater.m3681setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 427744233, "C286@11793L11,286@11736L90:RecipeListScreen.kt#y43rd3");
            TextKt.m2714Text4IGK_g("⏱ " + label, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer2, MaterialTheme.$stable).getOnSecondaryContainer(), TextUnitKt.getSp(11), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer2, 3072, 0, 131058);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.easycompra.app.ui.recipes.RecipeListScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RecipeListScreenKt.TimeBadge$lambda$10(minutes, $changed, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
