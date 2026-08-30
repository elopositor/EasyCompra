package com.easycompra.app.ui.planner;

import android.app.Application;
import androidx.autofill.HintConstants;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelKt;
import com.easycompra.app.data.planner.PlannerEntry;
import com.easycompra.app.data.planner.PlannerRepository;
import com.easycompra.app.data.planner.WeekAnalysis;
import com.easycompra.app.data.recipes.RecipeDao;
import com.easycompra.app.data.recipes.RecipeDatabase;
import com.easycompra.app.data.recipes.RecipeShoppingItem;
import com.easycompra.app.data.recipes.RecipeShoppingStore;
import com.easycompra.app.data.recipes.RecipeWithDetails;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: PlannerViewModel.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0006\u0010\u0014\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u0012J8\u0010 \u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001eJ\u0016\u0010&\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001eJ\u001e\u0010'\u001a\u00020\u00122\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020\u001eJ\u0006\u0010,\u001a\u00020\u0012J\u001e\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020$R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u00061"}, d2 = {"Lcom/easycompra/app/ui/planner/PlannerViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "repo", "Lcom/easycompra/app/data/planner/PlannerRepository;", "recipeDao", "Lcom/easycompra/app/data/recipes/RecipeDao;", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/easycompra/app/ui/planner/PlannerUiState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "observeCurrentWeek", "", "refreshAnalysis", "prevWeek", "nextWeek", "goToCurrentWeek", "selectDay", "index", "", "openSlot", "date", "Ljava/time/LocalDate;", "slot", "", "dismissDialog", "saveEntry", "recipeId", "displayName", "servings", "", "notes", "clearSlot", "moveEntry", "entry", "Lcom/easycompra/app/data/planner/PlannerEntry;", "newDate", "newSlot", "showMoveDialog", "addMissingToShoppingList", HintConstants.AUTOFILL_HINT_NAME, "unit", "deficit", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PlannerViewModel extends AndroidViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<PlannerUiState> _state;
    private final RecipeDao recipeDao;
    private final PlannerRepository repo;
    private final StateFlow<PlannerUiState> state;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlannerViewModel(Application app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
        this.repo = new PlannerRepository(app);
        this.recipeDao = RecipeDatabase.INSTANCE.get(app).recipeDao();
        this._state = StateFlowKt.MutableStateFlow(new PlannerUiState(null, 0, null, null, null, null, null, false, 255, null));
        this.state = this._state;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
        observeCurrentWeek();
    }

    public final StateFlow<PlannerUiState> getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.planner.PlannerViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: PlannerViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.ui.planner.PlannerViewModel$1", f = "PlannerViewModel.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PlannerViewModel.this.new AnonymousClass1(continuation);
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
                    Flow<List<RecipeWithDetails>> flowObserveAll = PlannerViewModel.this.recipeDao.observeAll();
                    final PlannerViewModel plannerViewModel = PlannerViewModel.this;
                    this.label = 1;
                    if (flowObserveAll.collect(new FlowCollector() { // from class: com.easycompra.app.ui.planner.PlannerViewModel.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((List<RecipeWithDetails>) value, (Continuation<? super Unit>) $completion);
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        public final Object emit(List<RecipeWithDetails> list, Continuation<? super Unit> continuation) {
                            Object prevValue$iv;
                            PlannerUiState it;
                            MutableStateFlow mutableStateFlow = plannerViewModel._state;
                            do {
                                prevValue$iv = mutableStateFlow.getValue();
                                it = (PlannerUiState) prevValue$iv;
                            } while (!mutableStateFlow.compareAndSet(prevValue$iv, it.copy((239 & 1) != 0 ? it.weekStart : null, (239 & 2) != 0 ? it.selectedDayIndex : 0, (239 & 4) != 0 ? it.entries : null, (239 & 8) != 0 ? it.analysis : null, (239 & 16) != 0 ? it.allRecipes : list, (239 & 32) != 0 ? it.editingSlot : null, (239 & 64) != 0 ? it.editingEntry : null, (239 & 128) != 0 ? it.showMoveDialog : false)));
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

    /* JADX INFO: renamed from: com.easycompra.app.ui.planner.PlannerViewModel$observeCurrentWeek$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PlannerViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.ui.planner.PlannerViewModel$observeCurrentWeek$1", f = "PlannerViewModel.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
    static final class C07321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C07321(Continuation<? super C07321> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PlannerViewModel.this.new C07321(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07321) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Flow<List<PlannerEntry>> flowObserveWeek = PlannerViewModel.this.repo.observeWeek(((PlannerUiState) PlannerViewModel.this._state.getValue()).getWeekStart());
                    final PlannerViewModel plannerViewModel = PlannerViewModel.this;
                    this.label = 1;
                    if (flowObserveWeek.collect(new FlowCollector() { // from class: com.easycompra.app.ui.planner.PlannerViewModel.observeCurrentWeek.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((List<PlannerEntry>) value, (Continuation<? super Unit>) $completion);
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        public final Object emit(List<PlannerEntry> list, Continuation<? super Unit> continuation) {
                            Object prevValue$iv;
                            PlannerUiState it;
                            MutableStateFlow mutableStateFlow = plannerViewModel._state;
                            do {
                                prevValue$iv = mutableStateFlow.getValue();
                                it = (PlannerUiState) prevValue$iv;
                            } while (!mutableStateFlow.compareAndSet(prevValue$iv, it.copy((239 & 1) != 0 ? it.weekStart : null, (239 & 2) != 0 ? it.selectedDayIndex : 0, (239 & 4) != 0 ? it.entries : list, (239 & 8) != 0 ? it.analysis : null, (239 & 16) != 0 ? it.allRecipes : null, (239 & 32) != 0 ? it.editingSlot : null, (239 & 64) != 0 ? it.editingEntry : null, (239 & 128) != 0 ? it.showMoveDialog : false)));
                            plannerViewModel.refreshAnalysis();
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

    private final void observeCurrentWeek() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07321(null), 3, null);
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.planner.PlannerViewModel$refreshAnalysis$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PlannerViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.ui.planner.PlannerViewModel$refreshAnalysis$1", f = "PlannerViewModel.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
    static final class C07331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C07331(Continuation<? super C07331> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PlannerViewModel.this.new C07331(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07331) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [int] */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v8 */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r7v0 */
        /* JADX WARN: Type inference failed for: r7v1 */
        /* JADX WARN: Type inference failed for: r7v4 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            ?? r7;
            Object prevValue$iv;
            PlannerUiState it;
            Object prevValue$iv2;
            PlannerUiState it2;
            Object $result2;
            Object $result3;
            Object prevValue$iv3;
            PlannerUiState it3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r2 = this.label;
            try {
                switch (r2) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        MutableStateFlow $this$update$iv = PlannerViewModel.this._state;
                        do {
                            prevValue$iv2 = $this$update$iv.getValue();
                            it2 = (PlannerUiState) prevValue$iv2;
                        } while (!$this$update$iv.compareAndSet(prevValue$iv2, it2.copy((239 & 1) != 0 ? it2.weekStart : null, (239 & 2) != 0 ? it2.selectedDayIndex : 0, (239 & 4) != 0 ? it2.entries : null, (239 & 8) != 0 ? it2.analysis : WeekAnalysis.copy$default(it2.getAnalysis(), null, null, null, true, 7, null), (239 & 16) != 0 ? it2.allRecipes : null, (239 & 32) != 0 ? it2.editingSlot : null, (239 & 64) != 0 ? it2.editingEntry : null, (239 & 128) != 0 ? it2.showMoveDialog : false)));
                        this.label = 1;
                        Object objAnalyzeWeek = PlannerViewModel.this.repo.analyzeWeek(((PlannerUiState) PlannerViewModel.this._state.getValue()).getWeekStart(), this);
                        if (objAnalyzeWeek == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result2 = $result;
                        $result3 = objAnalyzeWeek;
                        break;
                    case 1:
                        $result3 = $result;
                        ResultKt.throwOnFailure($result3);
                        $result2 = $result3;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                try {
                    WeekAnalysis analysis = (WeekAnalysis) $result3;
                    MutableStateFlow $this$update$iv2 = PlannerViewModel.this._state;
                    r2 = 0;
                    do {
                        prevValue$iv3 = $this$update$iv2.getValue();
                        it3 = (PlannerUiState) prevValue$iv3;
                    } while (!$this$update$iv2.compareAndSet(prevValue$iv3, it3.copy((239 & 1) != 0 ? it3.weekStart : null, (239 & 2) != 0 ? it3.selectedDayIndex : 0, (239 & 4) != 0 ? it3.entries : null, (239 & 8) != 0 ? it3.analysis : analysis, (239 & 16) != 0 ? it3.allRecipes : null, (239 & 32) != 0 ? it3.editingSlot : null, (239 & 64) != 0 ? it3.editingEntry : null, (239 & 128) != 0 ? it3.showMoveDialog : false)));
                } catch (Exception e) {
                    r7 = $result2;
                    MutableStateFlow $this$update$iv3 = PlannerViewModel.this._state;
                    do {
                        prevValue$iv = $this$update$iv3.getValue();
                        it = (PlannerUiState) prevValue$iv;
                    } while (!$this$update$iv3.compareAndSet(prevValue$iv, it.copy((239 & 1) != 0 ? it.weekStart : null, (239 & 2) != 0 ? it.selectedDayIndex : 0, (239 & 4) != 0 ? it.entries : null, (239 & 8) != 0 ? it.analysis : new WeekAnalysis(null, null, null, false, 15, null), (239 & 16) != 0 ? it.allRecipes : null, (239 & 32) != 0 ? it.editingSlot : null, (239 & 64) != 0 ? it.editingEntry : null, (239 & 128) != 0 ? it.showMoveDialog : false)));
                }
            } catch (Exception e2) {
                r7 = r2;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshAnalysis() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07331(null), 2, null);
    }

    public final void prevWeek() {
        PlannerUiState value;
        PlannerUiState it;
        LocalDate newStart = this._state.getValue().getWeekStart().minusWeeks(1L);
        MutableStateFlow<PlannerUiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            it = value;
            Intrinsics.checkNotNull(newStart);
        } while (!mutableStateFlow.compareAndSet(value, it.copy((239 & 1) != 0 ? it.weekStart : newStart, (239 & 2) != 0 ? it.selectedDayIndex : 0, (239 & 4) != 0 ? it.entries : null, (239 & 8) != 0 ? it.analysis : null, (239 & 16) != 0 ? it.allRecipes : null, (239 & 32) != 0 ? it.editingSlot : null, (239 & 64) != 0 ? it.editingEntry : null, (239 & 128) != 0 ? it.showMoveDialog : false)));
        observeCurrentWeek();
    }

    public final void nextWeek() {
        PlannerUiState value;
        PlannerUiState it;
        LocalDate newStart = this._state.getValue().getWeekStart().plusWeeks(1L);
        MutableStateFlow<PlannerUiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            it = value;
            Intrinsics.checkNotNull(newStart);
        } while (!mutableStateFlow.compareAndSet(value, it.copy((239 & 1) != 0 ? it.weekStart : newStart, (239 & 2) != 0 ? it.selectedDayIndex : 0, (239 & 4) != 0 ? it.entries : null, (239 & 8) != 0 ? it.analysis : null, (239 & 16) != 0 ? it.allRecipes : null, (239 & 32) != 0 ? it.editingSlot : null, (239 & 64) != 0 ? it.editingEntry : null, (239 & 128) != 0 ? it.showMoveDialog : false)));
        observeCurrentWeek();
    }

    public final void goToCurrentWeek() {
        PlannerUiState value;
        PlannerUiState it;
        LocalDate newStart = PlannerViewModelKt.currentWeekStart();
        MutableStateFlow<PlannerUiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, it.copy((239 & 1) != 0 ? it.weekStart : newStart, (239 & 2) != 0 ? it.selectedDayIndex : PlannerViewModelKt.todayIndex(), (239 & 4) != 0 ? it.entries : null, (239 & 8) != 0 ? it.analysis : null, (239 & 16) != 0 ? it.allRecipes : null, (239 & 32) != 0 ? it.editingSlot : null, (239 & 64) != 0 ? it.editingEntry : null, (239 & 128) != 0 ? it.showMoveDialog : false)));
        observeCurrentWeek();
    }

    public final void selectDay(int index) {
        PlannerUiState value;
        PlannerUiState it;
        MutableStateFlow<PlannerUiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, it.copy((239 & 1) != 0 ? it.weekStart : null, (239 & 2) != 0 ? it.selectedDayIndex : index, (239 & 4) != 0 ? it.entries : null, (239 & 8) != 0 ? it.analysis : null, (239 & 16) != 0 ? it.allRecipes : null, (239 & 32) != 0 ? it.editingSlot : null, (239 & 64) != 0 ? it.editingEntry : null, (239 & 128) != 0 ? it.showMoveDialog : false)));
    }

    public final void openSlot(LocalDate date, String slot) {
        Object next;
        PlannerUiState value;
        PlannerUiState it;
        PlannerEntry it2;
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(slot, "slot");
        String dateStr = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        Iterator<T> it3 = this._state.getValue().getEntries().iterator();
        do {
            if (!it3.hasNext()) {
                next = null;
                break;
            } else {
                next = it3.next();
                it2 = (PlannerEntry) next;
            }
        } while (!(Intrinsics.areEqual(it2.getDate(), dateStr) && Intrinsics.areEqual(it2.getMealSlot(), slot)));
        PlannerEntry existing = (PlannerEntry) next;
        MutableStateFlow<PlannerUiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, it.copy((239 & 1) != 0 ? it.weekStart : null, (239 & 2) != 0 ? it.selectedDayIndex : 0, (239 & 4) != 0 ? it.entries : null, (239 & 8) != 0 ? it.analysis : null, (239 & 16) != 0 ? it.allRecipes : null, (239 & 32) != 0 ? it.editingSlot : TuplesKt.to(dateStr, slot), (239 & 64) != 0 ? it.editingEntry : existing, (239 & 128) != 0 ? it.showMoveDialog : false)));
    }

    public final void dismissDialog() {
        PlannerUiState value;
        PlannerUiState it;
        MutableStateFlow<PlannerUiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, it.copy((239 & 1) != 0 ? it.weekStart : null, (239 & 2) != 0 ? it.selectedDayIndex : 0, (239 & 4) != 0 ? it.entries : null, (239 & 8) != 0 ? it.analysis : null, (239 & 16) != 0 ? it.allRecipes : null, (239 & 32) != 0 ? it.editingSlot : null, (239 & 64) != 0 ? it.editingEntry : null, (239 & 128) != 0 ? it.showMoveDialog : false)));
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.planner.PlannerViewModel$saveEntry$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PlannerViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.ui.planner.PlannerViewModel$saveEntry$1", f = "PlannerViewModel.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {})
    static final class C07341 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $date;
        final /* synthetic */ String $displayName;
        final /* synthetic */ String $notes;
        final /* synthetic */ String $recipeId;
        final /* synthetic */ float $servings;
        final /* synthetic */ String $slot;
        int label;
        final /* synthetic */ PlannerViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07341(String str, String str2, String str3, String str4, float f, String str5, PlannerViewModel plannerViewModel, Continuation<? super C07341> continuation) {
            super(2, continuation);
            this.$date = str;
            this.$slot = str2;
            this.$recipeId = str3;
            this.$displayName = str4;
            this.$servings = f;
            this.$notes = str5;
            this.this$0 = plannerViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07341(this.$date, this.$slot, this.$recipeId, this.$displayName, this.$servings, this.$notes, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07341) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object prevValue$iv;
            PlannerUiState it;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    PlannerEntry entry = new PlannerEntry(null, this.$date, this.$slot, this.$recipeId, this.$displayName, this.$servings, this.$notes, 0L, 129, null);
                    this.label = 1;
                    if (this.this$0.repo.setSlot(entry, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            MutableStateFlow $this$update$iv = this.this$0._state;
            do {
                prevValue$iv = $this$update$iv.getValue();
                it = (PlannerUiState) prevValue$iv;
            } while (!$this$update$iv.compareAndSet(prevValue$iv, it.copy((239 & 1) != 0 ? it.weekStart : null, (239 & 2) != 0 ? it.selectedDayIndex : 0, (239 & 4) != 0 ? it.entries : null, (239 & 8) != 0 ? it.analysis : null, (239 & 16) != 0 ? it.allRecipes : null, (239 & 32) != 0 ? it.editingSlot : null, (239 & 64) != 0 ? it.editingEntry : null, (239 & 128) != 0 ? it.showMoveDialog : false)));
            return Unit.INSTANCE;
        }
    }

    public final void saveEntry(String date, String slot, String recipeId, String displayName, float servings, String notes) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(slot, "slot");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(notes, "notes");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07341(date, slot, recipeId, displayName, servings, notes, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.planner.PlannerViewModel$clearSlot$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PlannerViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.ui.planner.PlannerViewModel$clearSlot$1", f = "PlannerViewModel.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {})
    static final class C07301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $date;
        final /* synthetic */ String $slot;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07301(String str, String str2, Continuation<? super C07301> continuation) {
            super(2, continuation);
            this.$date = str;
            this.$slot = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PlannerViewModel.this.new C07301(this.$date, this.$slot, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07301) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object prevValue$iv;
            PlannerUiState it;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (PlannerViewModel.this.repo.clearSlot(this.$date, this.$slot, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            MutableStateFlow $this$update$iv = PlannerViewModel.this._state;
            do {
                prevValue$iv = $this$update$iv.getValue();
                it = (PlannerUiState) prevValue$iv;
            } while (!$this$update$iv.compareAndSet(prevValue$iv, it.copy((239 & 1) != 0 ? it.weekStart : null, (239 & 2) != 0 ? it.selectedDayIndex : 0, (239 & 4) != 0 ? it.entries : null, (239 & 8) != 0 ? it.analysis : null, (239 & 16) != 0 ? it.allRecipes : null, (239 & 32) != 0 ? it.editingSlot : null, (239 & 64) != 0 ? it.editingEntry : null, (239 & 128) != 0 ? it.showMoveDialog : false)));
            return Unit.INSTANCE;
        }
    }

    public final void clearSlot(String date, String slot) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(slot, "slot");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07301(date, slot, null), 3, null);
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.planner.PlannerViewModel$moveEntry$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PlannerViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.ui.planner.PlannerViewModel$moveEntry$1", f = "PlannerViewModel.kt", i = {}, l = {149}, m = "invokeSuspend", n = {}, s = {})
    static final class C07311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PlannerEntry $entry;
        final /* synthetic */ String $newDate;
        final /* synthetic */ String $newSlot;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07311(PlannerEntry plannerEntry, String str, String str2, Continuation<? super C07311> continuation) {
            super(2, continuation);
            this.$entry = plannerEntry;
            this.$newDate = str;
            this.$newSlot = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PlannerViewModel.this.new C07311(this.$entry, this.$newDate, this.$newSlot, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07311) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object prevValue$iv;
            PlannerUiState it;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (PlannerViewModel.this.repo.moveEntry(this.$entry, this.$newDate, this.$newSlot, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            MutableStateFlow $this$update$iv = PlannerViewModel.this._state;
            do {
                prevValue$iv = $this$update$iv.getValue();
                it = (PlannerUiState) prevValue$iv;
            } while (!$this$update$iv.compareAndSet(prevValue$iv, it.copy((239 & 1) != 0 ? it.weekStart : null, (239 & 2) != 0 ? it.selectedDayIndex : 0, (239 & 4) != 0 ? it.entries : null, (239 & 8) != 0 ? it.analysis : null, (239 & 16) != 0 ? it.allRecipes : null, (239 & 32) != 0 ? it.editingSlot : null, (239 & 64) != 0 ? it.editingEntry : null, (239 & 128) != 0 ? it.showMoveDialog : false)));
            return Unit.INSTANCE;
        }
    }

    public final void moveEntry(PlannerEntry entry, String newDate, String newSlot) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        Intrinsics.checkNotNullParameter(newDate, "newDate");
        Intrinsics.checkNotNullParameter(newSlot, "newSlot");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07311(entry, newDate, newSlot, null), 3, null);
    }

    public final void showMoveDialog() {
        PlannerUiState value;
        PlannerUiState it;
        MutableStateFlow<PlannerUiState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, it.copy((239 & 1) != 0 ? it.weekStart : null, (239 & 2) != 0 ? it.selectedDayIndex : 0, (239 & 4) != 0 ? it.entries : null, (239 & 8) != 0 ? it.analysis : null, (239 & 16) != 0 ? it.allRecipes : null, (239 & 32) != 0 ? it.editingSlot : null, (239 & 64) != 0 ? it.editingEntry : null, (239 & 128) != 0 ? it.showMoveDialog : true)));
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.planner.PlannerViewModel$addMissingToShoppingList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PlannerViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.ui.planner.PlannerViewModel$addMissingToShoppingList$1", f = "PlannerViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C07291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $deficit;
        final /* synthetic */ String $name;
        final /* synthetic */ String $unit;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07291(String str, float f, String str2, Continuation<? super C07291> continuation) {
            super(2, continuation);
            this.$name = str;
            this.$deficit = f;
            this.$unit = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PlannerViewModel.this.new C07291(this.$name, this.$deficit, this.$unit, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07291) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    RecipeShoppingStore store = new RecipeShoppingStore(PlannerViewModel.this.getApplication());
                    List<RecipeShoppingItem> mutableList = CollectionsKt.toMutableList((Collection) store.load());
                    mutableList.add(new RecipeShoppingItem(null, this.$name, this.$deficit, this.$unit, "Planificador semanal", 1, null));
                    store.save(mutableList);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final void addMissingToShoppingList(String name, String unit, float deficit) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(unit, "unit");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07291(name, deficit, unit, null), 3, null);
    }
}
