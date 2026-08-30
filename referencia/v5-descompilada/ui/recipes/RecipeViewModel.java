package com.easycompra.app.ui.recipes;

import android.app.Application;
import androidx.autofill.HintConstants;
import androidx.core.location.LocationRequestCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelKt;
import com.easycompra.app.data.recipes.IngredientEntity;
import com.easycompra.app.data.recipes.IngredientResult;
import com.easycompra.app.data.recipes.IngredientStatus;
import com.easycompra.app.data.recipes.RecipeEntity;
import com.easycompra.app.data.recipes.RecipeRepository;
import com.easycompra.app.data.recipes.RecipeShoppingItem;
import com.easycompra.app.data.recipes.RecipeShoppingStore;
import com.easycompra.app.data.recipes.RecipeStepEntity;
import com.easycompra.app.data.recipes.RecipeWithDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: RecipeViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0012J\u000e\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u0012J\u000e\u0010 \u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010!\u001a\u00020\u0012Jb\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u001a2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002000-J\u000e\u00101\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u0017J\u000e\u00104\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u00105\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u000206J\u0006\u00107\u001a\u00020\u0012J\u000e\u00108\u001a\u00020\u00122\u0006\u00109\u001a\u00020\u0017J\u0006\u0010:\u001a\u00020\u0012J\u0006\u0010;\u001a\u00020\u0012J\u0006\u0010<\u001a\u00020\u0012J\u000e\u0010=\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u0017J\u0006\u0010>\u001a\u00020\u0012J\u000e\u0010?\u001a\u00020\u00122\u0006\u0010@\u001a\u00020\u0017J\u0006\u0010A\u001a\u00020\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006B"}, d2 = {"Lcom/easycompra/app/ui/recipes/RecipeViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "repo", "Lcom/easycompra/app/data/recipes/RecipeRepository;", "shoppingStore", "Lcom/easycompra/app/data/recipes/RecipeShoppingStore;", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/easycompra/app/ui/recipes/RecipeUiState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "setFilter", "", "f", "Lcom/easycompra/app/ui/recipes/RecipeFilter;", "setQuery", "q", "", "setSearchActive", "v", "", "showCreate", "showEdit", "recipe", "Lcom/easycompra/app/data/recipes/RecipeWithDetails;", "dismissCreateEdit", "selectRecipe", "clearSelectedRecipe", "saveRecipe", HintConstants.AUTOFILL_HINT_NAME, "category", "photoUrl", "prepTime", "", "servings", "difficulty", "notes", "isFavorite", "ingredients", "", "Lcom/easycompra/app/data/recipes/IngredientEntity;", "steps", "Lcom/easycompra/app/data/recipes/RecipeStepEntity;", "toggleFavorite", "deleteRecipe", "id", "startCooking", "updateServings", "", "confirmServings", "toggleUnlinkedAddToCart", "ingredientId", "confirmComparison", "confirmShopping", "dismissCooking", "removeRecipeShoppingItem", "clearRecipeShoppingItems", "searchPantry", "query", "clearPantrySearch", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RecipeViewModel extends AndroidViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<RecipeUiState> _state;
    private final RecipeRepository repo;
    private final RecipeShoppingStore shoppingStore;
    private final StateFlow<RecipeUiState> state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecipeViewModel(Application app) {
        RecipeUiState value;
        RecipeUiState it;
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
        this.repo = new RecipeRepository(app);
        this.shoppingStore = new RecipeShoppingStore(app);
        this._state = StateFlowKt.MutableStateFlow(new RecipeUiState(null, null, null, false, false, null, null, null, null, null, 1023, null));
        this.state = this._state;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
        MutableStateFlow<RecipeUiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, it.copy((1022 & 1) != 0 ? it.allRecipes : null, (1022 & 2) != 0 ? it.filter : null, (1022 & 4) != 0 ? it.query : null, (1022 & 8) != 0 ? it.searchActive : false, (1022 & 16) != 0 ? it.showCreateEdit : false, (1022 & 32) != 0 ? it.editingRecipe : null, (1022 & 64) != 0 ? it.selectedRecipe : null, (1022 & 128) != 0 ? it.cooking : null, (1022 & 256) != 0 ? it.recipeShoppingItems : this.shoppingStore.load(), (1022 & 512) != 0 ? it.pantrySearchResults : null)));
    }

    public final StateFlow<RecipeUiState> getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.recipes.RecipeViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: RecipeViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.ui.recipes.RecipeViewModel$1", f = "RecipeViewModel.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RecipeViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Flow<List<RecipeWithDetails>> flowObserveAll = RecipeViewModel.this.repo.observeAll();
                    final RecipeViewModel recipeViewModel = RecipeViewModel.this;
                    this.label = 1;
                    if (flowObserveAll.collect(new FlowCollector() { // from class: com.easycompra.app.ui.recipes.RecipeViewModel.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((List<RecipeWithDetails>) value, (Continuation<? super Unit>) $completion);
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        public final Object emit(List<RecipeWithDetails> list, Continuation<? super Unit> continuation) {
                            Object prevValue$iv;
                            RecipeUiState it;
                            MutableStateFlow mutableStateFlow = recipeViewModel._state;
                            do {
                                prevValue$iv = mutableStateFlow.getValue();
                                it = (RecipeUiState) prevValue$iv;
                            } while (!mutableStateFlow.compareAndSet(prevValue$iv, it.copy((1022 & 1) != 0 ? it.allRecipes : list, (1022 & 2) != 0 ? it.filter : null, (1022 & 4) != 0 ? it.query : null, (1022 & 8) != 0 ? it.searchActive : false, (1022 & 16) != 0 ? it.showCreateEdit : false, (1022 & 32) != 0 ? it.editingRecipe : null, (1022 & 64) != 0 ? it.selectedRecipe : null, (1022 & 128) != 0 ? it.cooking : null, (1022 & 256) != 0 ? it.recipeShoppingItems : null, (1022 & 512) != 0 ? it.pantrySearchResults : null)));
                            return Unit.INSTANCE;
                        }
                    }, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public final void setFilter(RecipeFilter f) {
        RecipeUiState value;
        RecipeUiState it;
        Intrinsics.checkNotNullParameter(f, "f");
        MutableStateFlow<RecipeUiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, it.copy((1022 & 1) != 0 ? it.allRecipes : null, (1022 & 2) != 0 ? it.filter : f, (1022 & 4) != 0 ? it.query : null, (1022 & 8) != 0 ? it.searchActive : false, (1022 & 16) != 0 ? it.showCreateEdit : false, (1022 & 32) != 0 ? it.editingRecipe : null, (1022 & 64) != 0 ? it.selectedRecipe : null, (1022 & 128) != 0 ? it.cooking : null, (1022 & 256) != 0 ? it.recipeShoppingItems : null, (1022 & 512) != 0 ? it.pantrySearchResults : null)));
    }

    public final void setQuery(String q) {
        RecipeUiState value;
        RecipeUiState it;
        Intrinsics.checkNotNullParameter(q, "q");
        MutableStateFlow<RecipeUiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, it.copy((1022 & 1) != 0 ? it.allRecipes : null, (1022 & 2) != 0 ? it.filter : null, (1022 & 4) != 0 ? it.query : q, (1022 & 8) != 0 ? it.searchActive : false, (1022 & 16) != 0 ? it.showCreateEdit : false, (1022 & 32) != 0 ? it.editingRecipe : null, (1022 & 64) != 0 ? it.selectedRecipe : null, (1022 & 128) != 0 ? it.cooking : null, (1022 & 256) != 0 ? it.recipeShoppingItems : null, (1022 & 512) != 0 ? it.pantrySearchResults : null)));
    }

    public final void setSearchActive(boolean v) {
        RecipeUiState value;
        RecipeUiState it;
        MutableStateFlow<RecipeUiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, it.copy((1022 & 1) != 0 ? it.allRecipes : null, (1022 & 2) != 0 ? it.filter : null, (1022 & 4) != 0 ? it.query : !v ? "" : it.getQuery(), (1022 & 8) != 0 ? it.searchActive : v, (1022 & 16) != 0 ? it.showCreateEdit : false, (1022 & 32) != 0 ? it.editingRecipe : null, (1022 & 64) != 0 ? it.selectedRecipe : null, (1022 & 128) != 0 ? it.cooking : null, (1022 & 256) != 0 ? it.recipeShoppingItems : null, (1022 & 512) != 0 ? it.pantrySearchResults : null)));
    }

    public final void showCreate() {
        RecipeUiState value;
        RecipeUiState it;
        MutableStateFlow<RecipeUiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, it.copy((1022 & 1) != 0 ? it.allRecipes : null, (1022 & 2) != 0 ? it.filter : null, (1022 & 4) != 0 ? it.query : null, (1022 & 8) != 0 ? it.searchActive : false, (1022 & 16) != 0 ? it.showCreateEdit : true, (1022 & 32) != 0 ? it.editingRecipe : null, (1022 & 64) != 0 ? it.selectedRecipe : null, (1022 & 128) != 0 ? it.cooking : null, (1022 & 256) != 0 ? it.recipeShoppingItems : null, (1022 & 512) != 0 ? it.pantrySearchResults : null)));
    }

    public final void showEdit(RecipeWithDetails recipe) {
        RecipeUiState value;
        RecipeUiState it;
        Intrinsics.checkNotNullParameter(recipe, "recipe");
        MutableStateFlow<RecipeUiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, it.copy((1022 & 1) != 0 ? it.allRecipes : null, (1022 & 2) != 0 ? it.filter : null, (1022 & 4) != 0 ? it.query : null, (1022 & 8) != 0 ? it.searchActive : false, (1022 & 16) != 0 ? it.showCreateEdit : true, (1022 & 32) != 0 ? it.editingRecipe : recipe, (1022 & 64) != 0 ? it.selectedRecipe : null, (1022 & 128) != 0 ? it.cooking : null, (1022 & 256) != 0 ? it.recipeShoppingItems : null, (1022 & 512) != 0 ? it.pantrySearchResults : null)));
    }

    public final void dismissCreateEdit() {
        RecipeUiState value;
        RecipeUiState it;
        MutableStateFlow<RecipeUiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, it.copy((1022 & 1) != 0 ? it.allRecipes : null, (1022 & 2) != 0 ? it.filter : null, (1022 & 4) != 0 ? it.query : null, (1022 & 8) != 0 ? it.searchActive : false, (1022 & 16) != 0 ? it.showCreateEdit : false, (1022 & 32) != 0 ? it.editingRecipe : null, (1022 & 64) != 0 ? it.selectedRecipe : null, (1022 & 128) != 0 ? it.cooking : null, (1022 & 256) != 0 ? it.recipeShoppingItems : null, (1022 & 512) != 0 ? it.pantrySearchResults : null)));
    }

    public final void selectRecipe(RecipeWithDetails recipe) {
        RecipeUiState value;
        RecipeUiState it;
        Intrinsics.checkNotNullParameter(recipe, "recipe");
        MutableStateFlow<RecipeUiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, it.copy((1022 & 1) != 0 ? it.allRecipes : null, (1022 & 2) != 0 ? it.filter : null, (1022 & 4) != 0 ? it.query : null, (1022 & 8) != 0 ? it.searchActive : false, (1022 & 16) != 0 ? it.showCreateEdit : false, (1022 & 32) != 0 ? it.editingRecipe : null, (1022 & 64) != 0 ? it.selectedRecipe : recipe, (1022 & 128) != 0 ? it.cooking : null, (1022 & 256) != 0 ? it.recipeShoppingItems : null, (1022 & 512) != 0 ? it.pantrySearchResults : null)));
    }

    public final void clearSelectedRecipe() {
        RecipeUiState value;
        RecipeUiState it;
        MutableStateFlow<RecipeUiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, it.copy((1022 & 1) != 0 ? it.allRecipes : null, (1022 & 2) != 0 ? it.filter : null, (1022 & 4) != 0 ? it.query : null, (1022 & 8) != 0 ? it.searchActive : false, (1022 & 16) != 0 ? it.showCreateEdit : false, (1022 & 32) != 0 ? it.editingRecipe : null, (1022 & 64) != 0 ? it.selectedRecipe : null, (1022 & 128) != 0 ? it.cooking : null, (1022 & 256) != 0 ? it.recipeShoppingItems : null, (1022 & 512) != 0 ? it.pantrySearchResults : null)));
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.recipes.RecipeViewModel$saveRecipe$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RecipeViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.ui.recipes.RecipeViewModel$saveRecipe$1", f = "RecipeViewModel.kt", i = {}, l = {LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY}, m = "invokeSuspend", n = {}, s = {})
    static final class C07441 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $category;
        final /* synthetic */ String $difficulty;
        final /* synthetic */ String $editId;
        final /* synthetic */ List<IngredientEntity> $ingredients;
        final /* synthetic */ boolean $isFavorite;
        final /* synthetic */ String $name;
        final /* synthetic */ String $notes;
        final /* synthetic */ String $photoUrl;
        final /* synthetic */ int $prepTime;
        final /* synthetic */ int $servings;
        final /* synthetic */ List<RecipeStepEntity> $steps;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07441(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6, boolean z, List<IngredientEntity> list, List<RecipeStepEntity> list2, Continuation<? super C07441> continuation) {
            super(2, continuation);
            this.$editId = str;
            this.$name = str2;
            this.$category = str3;
            this.$photoUrl = str4;
            this.$prepTime = i;
            this.$servings = i2;
            this.$difficulty = str5;
            this.$notes = str6;
            this.$isFavorite = z;
            this.$ingredients = list;
            this.$steps = list2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RecipeViewModel.this.new C07441(this.$editId, this.$name, this.$category, this.$photoUrl, this.$prepTime, this.$servings, this.$difficulty, this.$notes, this.$isFavorite, this.$ingredients, this.$steps, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07441) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object prevValue$iv;
            RecipeUiState it;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (RecipeViewModel.this.repo.save(this.$editId, this.$name, this.$category, this.$photoUrl, this.$prepTime, this.$servings, this.$difficulty, this.$notes, this.$isFavorite, this.$ingredients, this.$steps, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            MutableStateFlow $this$update$iv = RecipeViewModel.this._state;
            do {
                prevValue$iv = $this$update$iv.getValue();
                it = (RecipeUiState) prevValue$iv;
            } while (!$this$update$iv.compareAndSet(prevValue$iv, it.copy((1022 & 1) != 0 ? it.allRecipes : null, (1022 & 2) != 0 ? it.filter : null, (1022 & 4) != 0 ? it.query : null, (1022 & 8) != 0 ? it.searchActive : false, (1022 & 16) != 0 ? it.showCreateEdit : false, (1022 & 32) != 0 ? it.editingRecipe : null, (1022 & 64) != 0 ? it.selectedRecipe : null, (1022 & 128) != 0 ? it.cooking : null, (1022 & 256) != 0 ? it.recipeShoppingItems : null, (1022 & 512) != 0 ? it.pantrySearchResults : null)));
            return Unit.INSTANCE;
        }
    }

    public final void saveRecipe(String name, String category, String photoUrl, int prepTime, int servings, String difficulty, String notes, boolean isFavorite, List<IngredientEntity> ingredients, List<RecipeStepEntity> steps) {
        RecipeEntity recipe;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(photoUrl, "photoUrl");
        Intrinsics.checkNotNullParameter(difficulty, "difficulty");
        Intrinsics.checkNotNullParameter(notes, "notes");
        Intrinsics.checkNotNullParameter(ingredients, "ingredients");
        Intrinsics.checkNotNullParameter(steps, "steps");
        RecipeWithDetails editingRecipe = this._state.getValue().getEditingRecipe();
        String editId = (editingRecipe == null || (recipe = editingRecipe.getRecipe()) == null) ? null : recipe.getId();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07441(editId, name, category, photoUrl, prepTime, servings, difficulty, notes, isFavorite, ingredients, steps, null), 3, null);
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.recipes.RecipeViewModel$toggleFavorite$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RecipeViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.ui.recipes.RecipeViewModel$toggleFavorite$1", f = "RecipeViewModel.kt", i = {}, l = {108}, m = "invokeSuspend", n = {}, s = {})
    static final class C07461 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ RecipeWithDetails $recipe;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07461(RecipeWithDetails recipeWithDetails, Continuation<? super C07461> continuation) {
            super(2, continuation);
            this.$recipe = recipeWithDetails;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RecipeViewModel.this.new C07461(this.$recipe, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07461) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (RecipeViewModel.this.repo.toggleFavorite(this.$recipe.getRecipe().getId(), this.$recipe.getRecipe().isFavorite(), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public final void toggleFavorite(RecipeWithDetails recipe) {
        Intrinsics.checkNotNullParameter(recipe, "recipe");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07461(recipe, null), 3, null);
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.recipes.RecipeViewModel$deleteRecipe$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RecipeViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.ui.recipes.RecipeViewModel$deleteRecipe$1", f = "RecipeViewModel.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
    static final class C07431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $id;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07431(String str, Continuation<? super C07431> continuation) {
            super(2, continuation);
            this.$id = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RecipeViewModel.this.new C07431(this.$id, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07431) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (RecipeViewModel.this.repo.delete(this.$id, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public final void deleteRecipe(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07431(id, null), 3, null);
    }

    public final void startCooking(RecipeWithDetails recipe) {
        RecipeUiState value;
        RecipeUiState it;
        Intrinsics.checkNotNullParameter(recipe, "recipe");
        MutableStateFlow<RecipeUiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, it.copy((1022 & 1) != 0 ? it.allRecipes : null, (1022 & 2) != 0 ? it.filter : null, (1022 & 4) != 0 ? it.query : null, (1022 & 8) != 0 ? it.searchActive : false, (1022 & 16) != 0 ? it.showCreateEdit : false, (1022 & 32) != 0 ? it.editingRecipe : null, (1022 & 64) != 0 ? it.selectedRecipe : null, (1022 & 128) != 0 ? it.cooking : new CookingWorkflow.SelectServings(recipe, recipe.getRecipe().getBaseServings()), (1022 & 256) != 0 ? it.recipeShoppingItems : null, (1022 & 512) != 0 ? it.pantrySearchResults : null)));
    }

    public final void updateServings(float v) {
        RecipeUiState value;
        RecipeUiState it;
        CookingWorkflow cooking = this._state.getValue().getCooking();
        CookingWorkflow.SelectServings c = cooking instanceof CookingWorkflow.SelectServings ? (CookingWorkflow.SelectServings) cooking : null;
        if (c == null) {
            return;
        }
        MutableStateFlow<RecipeUiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, it.copy((1022 & 1) != 0 ? it.allRecipes : null, (1022 & 2) != 0 ? it.filter : null, (1022 & 4) != 0 ? it.query : null, (1022 & 8) != 0 ? it.searchActive : false, (1022 & 16) != 0 ? it.showCreateEdit : false, (1022 & 32) != 0 ? it.editingRecipe : null, (1022 & 64) != 0 ? it.selectedRecipe : null, (1022 & 128) != 0 ? it.cooking : CookingWorkflow.SelectServings.copy$default(c, null, RangesKt.coerceAtLeast(v, 0.5f), 1, null), (1022 & 256) != 0 ? it.recipeShoppingItems : null, (1022 & 512) != 0 ? it.pantrySearchResults : null)));
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.recipes.RecipeViewModel$confirmServings$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RecipeViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.ui.recipes.RecipeViewModel$confirmServings$1", f = "RecipeViewModel.kt", i = {}, l = {129}, m = "invokeSuspend", n = {}, s = {})
    static final class C07411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CookingWorkflow.SelectServings $c;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07411(CookingWorkflow.SelectServings selectServings, Continuation<? super C07411> continuation) {
            super(2, continuation);
            this.$c = selectServings;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RecipeViewModel.this.new C07411(this.$c, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07411) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object $result;
            Object prevValue$iv;
            RecipeUiState it;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    Object objCompareWithPantry = RecipeViewModel.this.repo.compareWithPantry(this.$c.getRecipe(), this.$c.getServings(), this);
                    if (objCompareWithPantry == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objCompareWithPantry;
                    break;
                    break;
                case 1:
                    $result = obj;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            List results = (List) $result;
            MutableStateFlow $this$update$iv = RecipeViewModel.this._state;
            CookingWorkflow.SelectServings selectServings = this.$c;
            do {
                prevValue$iv = $this$update$iv.getValue();
                it = (RecipeUiState) prevValue$iv;
            } while (!$this$update$iv.compareAndSet(prevValue$iv, it.copy((1022 & 1) != 0 ? it.allRecipes : null, (1022 & 2) != 0 ? it.filter : null, (1022 & 4) != 0 ? it.query : null, (1022 & 8) != 0 ? it.searchActive : false, (1022 & 16) != 0 ? it.showCreateEdit : false, (1022 & 32) != 0 ? it.editingRecipe : null, (1022 & 64) != 0 ? it.selectedRecipe : null, (1022 & 128) != 0 ? it.cooking : new CookingWorkflow.ShowComparison(selectServings.getRecipe(), selectServings.getServings(), results), (1022 & 256) != 0 ? it.recipeShoppingItems : null, (1022 & 512) != 0 ? it.pantrySearchResults : null)));
            return Unit.INSTANCE;
        }
    }

    public final void confirmServings() {
        CookingWorkflow cooking = this._state.getValue().getCooking();
        CookingWorkflow.SelectServings c = cooking instanceof CookingWorkflow.SelectServings ? (CookingWorkflow.SelectServings) cooking : null;
        if (c == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07411(c, null), 3, null);
    }

    public final void toggleUnlinkedAddToCart(String ingredientId) {
        RecipeUiState value;
        RecipeUiState it;
        Intrinsics.checkNotNullParameter(ingredientId, "ingredientId");
        CookingWorkflow cooking = this._state.getValue().getCooking();
        CookingWorkflow.ShowComparison c = cooking instanceof CookingWorkflow.ShowComparison ? (CookingWorkflow.ShowComparison) cooking : null;
        if (c == null) {
            return;
        }
        Iterable $this$map$iv = c.getResults();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            IngredientResult it2 = (IngredientResult) item$iv$iv;
            destination$iv$iv.add(Intrinsics.areEqual(it2.getIngredient().getId(), ingredientId) ? IngredientResult.copy$default(it2, null, 0.0f, null, !it2.getAddToCart(), 7, null) : it2);
        }
        List updated = (List) destination$iv$iv;
        MutableStateFlow<RecipeUiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, it.copy((1022 & 1) != 0 ? it.allRecipes : null, (1022 & 2) != 0 ? it.filter : null, (1022 & 4) != 0 ? it.query : null, (1022 & 8) != 0 ? it.searchActive : false, (1022 & 16) != 0 ? it.showCreateEdit : false, (1022 & 32) != 0 ? it.editingRecipe : null, (1022 & 64) != 0 ? it.selectedRecipe : null, (1022 & 128) != 0 ? it.cooking : CookingWorkflow.ShowComparison.copy$default(c, null, 0.0f, updated, 3, null), (1022 & 256) != 0 ? it.recipeShoppingItems : null, (1022 & 512) != 0 ? it.pantrySearchResults : null)));
    }

    public final void confirmComparison() {
        RecipeUiState value;
        RecipeUiState it;
        boolean addToCart;
        CookingWorkflow cooking = this._state.getValue().getCooking();
        CookingWorkflow.ShowComparison c = cooking instanceof CookingWorkflow.ShowComparison ? (CookingWorkflow.ShowComparison) cooking : null;
        if (c == null) {
            return;
        }
        Iterable $this$filter$iv = c.getResults();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            IngredientResult result = (IngredientResult) element$iv$iv;
            IngredientStatus status = result.getStatus();
            if ((status instanceof IngredientStatus.Partial) || (status instanceof IngredientStatus.Missing)) {
                addToCart = true;
            } else if ((status instanceof IngredientStatus.UnitMismatch) || (status instanceof IngredientStatus.Unlinked)) {
                addToCart = result.getAddToCart();
            } else {
                if (!(status instanceof IngredientStatus.OK)) {
                    throw new NoWhenBranchMatchedException();
                }
                addToCart = false;
            }
            if (addToCart) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        List toShop = (List) destination$iv$iv;
        MutableStateFlow<RecipeUiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, it.copy((1022 & 1) != 0 ? it.allRecipes : null, (1022 & 2) != 0 ? it.filter : null, (1022 & 4) != 0 ? it.query : null, (1022 & 8) != 0 ? it.searchActive : false, (1022 & 16) != 0 ? it.showCreateEdit : false, (1022 & 32) != 0 ? it.editingRecipe : null, (1022 & 64) != 0 ? it.selectedRecipe : null, (1022 & 128) != 0 ? it.cooking : new CookingWorkflow.ShowSummary(c.getRecipe(), c.getServings(), toShop), (1022 & 256) != 0 ? it.recipeShoppingItems : null, (1022 & 512) != 0 ? it.pantrySearchResults : null)));
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.recipes.RecipeViewModel$confirmShopping$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RecipeViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.ui.recipes.RecipeViewModel$confirmShopping$1", f = "RecipeViewModel.kt", i = {}, l = {161}, m = "invokeSuspend", n = {}, s = {})
    static final class C07421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CookingWorkflow.ShowSummary $c;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ RecipeViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07421(CookingWorkflow.ShowSummary showSummary, RecipeViewModel recipeViewModel, Continuation<? super C07421> continuation) {
            super(2, continuation);
            this.$c = showSummary;
            this.this$0 = recipeViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07421(this.$c, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07421) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            RecipeViewModel recipeViewModel;
            Iterator it;
            CookingWorkflow.ShowSummary showSummary;
            Object prevValue$iv;
            RecipeUiState it2;
            float deficit;
            Object prevValue$iv2;
            RecipeUiState it3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Iterable $this$forEach$iv = this.$c.getToShop();
                    RecipeViewModel recipeViewModel2 = this.this$0;
                    CookingWorkflow.ShowSummary showSummary2 = this.$c;
                    recipeViewModel = recipeViewModel2;
                    it = $this$forEach$iv.iterator();
                    showSummary = showSummary2;
                    break;
                case 1:
                    it = (Iterator) this.L$2;
                    showSummary = (CookingWorkflow.ShowSummary) this.L$1;
                    recipeViewModel = (RecipeViewModel) this.L$0;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            while (it.hasNext()) {
                Object element$iv = it.next();
                IngredientResult result = (IngredientResult) element$iv;
                IngredientStatus status = result.getStatus();
                if ((status instanceof IngredientStatus.Partial) || (status instanceof IngredientStatus.Missing)) {
                    String it4 = result.getIngredient().getLinkedProductId();
                    if (it4 != null) {
                        RecipeRepository recipeRepository = recipeViewModel.repo;
                        this.L$0 = recipeViewModel;
                        this.L$1 = showSummary;
                        this.L$2 = it;
                        this.label = 1;
                        if (recipeRepository.markPantryNeedsBuy(it4, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        continue;
                    }
                } else if ((status instanceof IngredientStatus.UnitMismatch) || (status instanceof IngredientStatus.Unlinked)) {
                    if (result.getAddToCart()) {
                        IngredientStatus s = result.getStatus();
                        if (s instanceof IngredientStatus.Partial) {
                            deficit = ((IngredientStatus.Partial) s).getDeficit();
                        } else {
                            deficit = s instanceof IngredientStatus.Missing ? ((IngredientStatus.Missing) s).getDeficit() : result.getScaledQuantity();
                        }
                        List<RecipeShoppingItem> mutableList = CollectionsKt.toMutableList((Collection) recipeViewModel.shoppingStore.load());
                        mutableList.add(new RecipeShoppingItem(null, result.getIngredient().getName(), deficit, result.getIngredient().getUnit(), showSummary.getRecipe().getRecipe().getName(), 1, null));
                        recipeViewModel.shoppingStore.save(mutableList);
                        MutableStateFlow $this$update$iv = recipeViewModel._state;
                        do {
                            prevValue$iv2 = $this$update$iv.getValue();
                            it3 = (RecipeUiState) prevValue$iv2;
                        } while (!$this$update$iv.compareAndSet(prevValue$iv2, it3.copy((1022 & 1) != 0 ? it3.allRecipes : null, (1022 & 2) != 0 ? it3.filter : null, (1022 & 4) != 0 ? it3.query : null, (1022 & 8) != 0 ? it3.searchActive : false, (1022 & 16) != 0 ? it3.showCreateEdit : false, (1022 & 32) != 0 ? it3.editingRecipe : null, (1022 & 64) != 0 ? it3.selectedRecipe : null, (1022 & 128) != 0 ? it3.cooking : null, (1022 & 256) != 0 ? it3.recipeShoppingItems : mutableList, (1022 & 512) != 0 ? it3.pantrySearchResults : null)));
                    }
                } else if (!(status instanceof IngredientStatus.OK)) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            MutableStateFlow $this$update$iv2 = this.this$0._state;
            do {
                prevValue$iv = $this$update$iv2.getValue();
                it2 = (RecipeUiState) prevValue$iv;
            } while (!$this$update$iv2.compareAndSet(prevValue$iv, it2.copy((1022 & 1) != 0 ? it2.allRecipes : null, (1022 & 2) != 0 ? it2.filter : null, (1022 & 4) != 0 ? it2.query : null, (1022 & 8) != 0 ? it2.searchActive : false, (1022 & 16) != 0 ? it2.showCreateEdit : false, (1022 & 32) != 0 ? it2.editingRecipe : null, (1022 & 64) != 0 ? it2.selectedRecipe : null, (1022 & 128) != 0 ? it2.cooking : null, (1022 & 256) != 0 ? it2.recipeShoppingItems : null, (1022 & 512) != 0 ? it2.pantrySearchResults : null)));
            return Unit.INSTANCE;
        }
    }

    public final void confirmShopping() {
        CookingWorkflow cooking = this._state.getValue().getCooking();
        CookingWorkflow.ShowSummary c = cooking instanceof CookingWorkflow.ShowSummary ? (CookingWorkflow.ShowSummary) cooking : null;
        if (c == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07421(c, this, null), 3, null);
    }

    public final void dismissCooking() {
        RecipeUiState value;
        RecipeUiState it;
        MutableStateFlow<RecipeUiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, it.copy((1022 & 1) != 0 ? it.allRecipes : null, (1022 & 2) != 0 ? it.filter : null, (1022 & 4) != 0 ? it.query : null, (1022 & 8) != 0 ? it.searchActive : false, (1022 & 16) != 0 ? it.showCreateEdit : false, (1022 & 32) != 0 ? it.editingRecipe : null, (1022 & 64) != 0 ? it.selectedRecipe : null, (1022 & 128) != 0 ? it.cooking : null, (1022 & 256) != 0 ? it.recipeShoppingItems : null, (1022 & 512) != 0 ? it.pantrySearchResults : null)));
    }

    public final void removeRecipeShoppingItem(String id) {
        RecipeUiState value;
        RecipeUiState it;
        Intrinsics.checkNotNullParameter(id, "id");
        Iterable $this$filter$iv = this._state.getValue().getRecipeShoppingItems();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            if (!Intrinsics.areEqual(((RecipeShoppingItem) element$iv$iv).getId(), id)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        List updated = (List) destination$iv$iv;
        this.shoppingStore.save(updated);
        MutableStateFlow<RecipeUiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, it.copy((1022 & 1) != 0 ? it.allRecipes : null, (1022 & 2) != 0 ? it.filter : null, (1022 & 4) != 0 ? it.query : null, (1022 & 8) != 0 ? it.searchActive : false, (1022 & 16) != 0 ? it.showCreateEdit : false, (1022 & 32) != 0 ? it.editingRecipe : null, (1022 & 64) != 0 ? it.selectedRecipe : null, (1022 & 128) != 0 ? it.cooking : null, (1022 & 256) != 0 ? it.recipeShoppingItems : updated, (1022 & 512) != 0 ? it.pantrySearchResults : null)));
    }

    public final void clearRecipeShoppingItems() {
        RecipeUiState value;
        RecipeUiState it;
        this.shoppingStore.clear();
        MutableStateFlow<RecipeUiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, it.copy((1022 & 1) != 0 ? it.allRecipes : null, (1022 & 2) != 0 ? it.filter : null, (1022 & 4) != 0 ? it.query : null, (1022 & 8) != 0 ? it.searchActive : false, (1022 & 16) != 0 ? it.showCreateEdit : false, (1022 & 32) != 0 ? it.editingRecipe : null, (1022 & 64) != 0 ? it.selectedRecipe : null, (1022 & 128) != 0 ? it.cooking : null, (1022 & 256) != 0 ? it.recipeShoppingItems : CollectionsKt.emptyList(), (1022 & 512) != 0 ? it.pantrySearchResults : null)));
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.recipes.RecipeViewModel$searchPantry$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RecipeViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.ui.recipes.RecipeViewModel$searchPantry$1", f = "RecipeViewModel.kt", i = {}, l = {205}, m = "invokeSuspend", n = {}, s = {})
    static final class C07451 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $query;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07451(String str, Continuation<? super C07451> continuation) {
            super(2, continuation);
            this.$query = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RecipeViewModel.this.new C07451(this.$query, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07451) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object $result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    Object objSearchPantry = RecipeViewModel.this.repo.searchPantry(this.$query, this);
                    if (objSearchPantry == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result = objSearchPantry;
                    break;
                    break;
                case 1:
                    $result = obj;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            List results = (List) $result;
            MutableStateFlow $this$update$iv = RecipeViewModel.this._state;
            while (true) {
                Object prevValue$iv = $this$update$iv.getValue();
                RecipeUiState it = (RecipeUiState) prevValue$iv;
                MutableStateFlow $this$update$iv2 = $this$update$iv;
                if ($this$update$iv2.compareAndSet(prevValue$iv, it.copy((1022 & 1) != 0 ? it.allRecipes : null, (1022 & 2) != 0 ? it.filter : null, (1022 & 4) != 0 ? it.query : null, (1022 & 8) != 0 ? it.searchActive : false, (1022 & 16) != 0 ? it.showCreateEdit : false, (1022 & 32) != 0 ? it.editingRecipe : null, (1022 & 64) != 0 ? it.selectedRecipe : null, (1022 & 128) != 0 ? it.cooking : null, (1022 & 256) != 0 ? it.recipeShoppingItems : null, (1022 & 512) != 0 ? it.pantrySearchResults : results))) {
                    return Unit.INSTANCE;
                }
                $this$update$iv = $this$update$iv2;
            }
        }
    }

    public final void searchPantry(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07451(query, null), 3, null);
    }

    public final void clearPantrySearch() {
        RecipeUiState value;
        RecipeUiState it;
        MutableStateFlow<RecipeUiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, it.copy((1022 & 1) != 0 ? it.allRecipes : null, (1022 & 2) != 0 ? it.filter : null, (1022 & 4) != 0 ? it.query : null, (1022 & 8) != 0 ? it.searchActive : false, (1022 & 16) != 0 ? it.showCreateEdit : false, (1022 & 32) != 0 ? it.editingRecipe : null, (1022 & 64) != 0 ? it.selectedRecipe : null, (1022 & 128) != 0 ? it.cooking : null, (1022 & 256) != 0 ? it.recipeShoppingItems : null, (1022 & 512) != 0 ? it.pantrySearchResults : CollectionsKt.emptyList())));
    }
}
