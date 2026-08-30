package com.easycompra.app.ui.pantry;

import android.app.Application;
import androidx.autofill.HintConstants;
import androidx.core.app.FrameMetricsAggregator;
import androidx.core.location.LocationRequestCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelKt;
import com.easycompra.app.data.pantry.PantryLocationEntity;
import com.easycompra.app.data.pantry.PantryOrderStore;
import com.easycompra.app.data.pantry.PantryProductEntity;
import com.easycompra.app.data.pantry.PantryProductWithLocations;
import com.easycompra.app.data.pantry.PantryRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
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
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: PantryViewModel.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001aJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$J6\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0017J\u000e\u0010-\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010.\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u0017J\u0006\u00100\u001a\u00020\u0012J\u000e\u00101\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u0017J\u000e\u00102\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u0017J\"\u00103\u001a\u0004\u0018\u00010\u00172\u0006\u00104\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u00172\u0006\u00105\u001a\u00020\u001aH\u0002J\u0018\u00106\u001a\u00020\u00122\u0006\u00107\u001a\u00020\u00172\u0006\u00108\u001a\u00020\u0017H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u00069"}, d2 = {"Lcom/easycompra/app/ui/pantry/PantryViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "repo", "Lcom/easycompra/app/data/pantry/PantryRepository;", "orderStore", "Lcom/easycompra/app/data/pantry/PantryOrderStore;", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/easycompra/app/ui/pantry/PantryUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "setFilter", "", "f", "Lcom/easycompra/app/ui/pantry/PantryFilter;", "setQuery", "q", "", "setSearchActive", "v", "", "showAddDialog", "show", "increment", "Lkotlinx/coroutines/Job;", "location", "Lcom/easycompra/app/data/pantry/PantryLocationEntity;", "decrement", "toggleNeedsToBuy", "product", "Lcom/easycompra/app/data/pantry/PantryProductEntity;", "addItem", HintConstants.AUTOFILL_HINT_NAME, "category", "subcategory", "description", "quantity", "", "unit", "deleteLocation", "deleteProduct", "productId", "toggleReorderMode", "moveUp", "moveDown", "findNeighbor", "state", "above", "swapInOrder", "idA", "idB", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PantryViewModel extends AndroidViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<PantryUiState> _uiState;
    private final PantryOrderStore orderStore;
    private final PantryRepository repo;
    private final StateFlow<PantryUiState> uiState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PantryViewModel(Application app) {
        PantryUiState value;
        PantryUiState it;
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
        this.repo = new PantryRepository(app);
        this.orderStore = new PantryOrderStore(app);
        this._uiState = StateFlowKt.MutableStateFlow(new PantryUiState(null, null, null, 0, 0.0f, false, false, false, null, FrameMetricsAggregator.EVERY_DURATION, null));
        this.uiState = this._uiState;
        MutableStateFlow<PantryUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, it.copy((510 & 1) != 0 ? it.allItems : null, (510 & 2) != 0 ? it.filter : null, (510 & 4) != 0 ? it.query : null, (510 & 8) != 0 ? it.emptyCount : 0, (510 & 16) != 0 ? it.limiteBajo : 0.0f, (510 & 32) != 0 ? it.showAddDialog : false, (510 & 64) != 0 ? it.searchActive : false, (510 & 128) != 0 ? it.reorderMode : false, (510 & 256) != 0 ? it.customOrder : this.orderStore.load())));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass3(null), 3, null);
    }

    public final StateFlow<PantryUiState> getUiState() {
        return this.uiState;
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.pantry.PantryViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: PantryViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.ui.pantry.PantryViewModel$2", f = "PantryViewModel.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PantryViewModel.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Flow<List<PantryProductWithLocations>> flowObserveAll = PantryViewModel.this.repo.observeAll();
                    final PantryViewModel pantryViewModel = PantryViewModel.this;
                    this.label = 1;
                    if (flowObserveAll.collect(new FlowCollector() { // from class: com.easycompra.app.ui.pantry.PantryViewModel.2.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((List<PantryProductWithLocations>) value, (Continuation<? super Unit>) $completion);
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        public final Object emit(List<PantryProductWithLocations> list, Continuation<? super Unit> continuation) {
                            Object prevValue$iv;
                            PantryUiState it;
                            MutableStateFlow mutableStateFlow = pantryViewModel._uiState;
                            do {
                                prevValue$iv = mutableStateFlow.getValue();
                                it = (PantryUiState) prevValue$iv;
                            } while (!mutableStateFlow.compareAndSet(prevValue$iv, it.copy((510 & 1) != 0 ? it.allItems : list, (510 & 2) != 0 ? it.filter : null, (510 & 4) != 0 ? it.query : null, (510 & 8) != 0 ? it.emptyCount : 0, (510 & 16) != 0 ? it.limiteBajo : 0.0f, (510 & 32) != 0 ? it.showAddDialog : false, (510 & 64) != 0 ? it.searchActive : false, (510 & 128) != 0 ? it.reorderMode : false, (510 & 256) != 0 ? it.customOrder : null)));
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

    /* JADX INFO: renamed from: com.easycompra.app.ui.pantry.PantryViewModel$3, reason: invalid class name */
    /* JADX INFO: compiled from: PantryViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.ui.pantry.PantryViewModel$3", f = "PantryViewModel.kt", i = {}, l = {LocationRequestCompat.QUALITY_LOW_POWER}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PantryViewModel.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    Flow<Integer> flowObserveEmptyCount = PantryViewModel.this.repo.observeEmptyCount();
                    final PantryViewModel pantryViewModel = PantryViewModel.this;
                    this.label = 1;
                    if (flowObserveEmptyCount.collect(new FlowCollector() { // from class: com.easycompra.app.ui.pantry.PantryViewModel.3.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit(((Number) value).intValue(), (Continuation<? super Unit>) $completion);
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        public final Object emit(int count, Continuation<? super Unit> continuation) {
                            Object prevValue$iv;
                            PantryUiState it;
                            MutableStateFlow mutableStateFlow = pantryViewModel._uiState;
                            do {
                                prevValue$iv = mutableStateFlow.getValue();
                                it = (PantryUiState) prevValue$iv;
                            } while (!mutableStateFlow.compareAndSet(prevValue$iv, it.copy((510 & 1) != 0 ? it.allItems : null, (510 & 2) != 0 ? it.filter : null, (510 & 4) != 0 ? it.query : null, (510 & 8) != 0 ? it.emptyCount : count, (510 & 16) != 0 ? it.limiteBajo : 0.0f, (510 & 32) != 0 ? it.showAddDialog : false, (510 & 64) != 0 ? it.searchActive : false, (510 & 128) != 0 ? it.reorderMode : false, (510 & 256) != 0 ? it.customOrder : null)));
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

    public final void setFilter(PantryFilter f) {
        PantryUiState value;
        PantryUiState it;
        Intrinsics.checkNotNullParameter(f, "f");
        MutableStateFlow<PantryUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, it.copy((510 & 1) != 0 ? it.allItems : null, (510 & 2) != 0 ? it.filter : f, (510 & 4) != 0 ? it.query : null, (510 & 8) != 0 ? it.emptyCount : 0, (510 & 16) != 0 ? it.limiteBajo : 0.0f, (510 & 32) != 0 ? it.showAddDialog : false, (510 & 64) != 0 ? it.searchActive : false, (510 & 128) != 0 ? it.reorderMode : false, (510 & 256) != 0 ? it.customOrder : null)));
    }

    public final void setQuery(String q) {
        PantryUiState value;
        PantryUiState it;
        Intrinsics.checkNotNullParameter(q, "q");
        MutableStateFlow<PantryUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, it.copy((510 & 1) != 0 ? it.allItems : null, (510 & 2) != 0 ? it.filter : null, (510 & 4) != 0 ? it.query : q, (510 & 8) != 0 ? it.emptyCount : 0, (510 & 16) != 0 ? it.limiteBajo : 0.0f, (510 & 32) != 0 ? it.showAddDialog : false, (510 & 64) != 0 ? it.searchActive : false, (510 & 128) != 0 ? it.reorderMode : false, (510 & 256) != 0 ? it.customOrder : null)));
    }

    public final void setSearchActive(boolean v) {
        PantryUiState value;
        PantryUiState it;
        MutableStateFlow<PantryUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, it.copy((510 & 1) != 0 ? it.allItems : null, (510 & 2) != 0 ? it.filter : null, (510 & 4) != 0 ? it.query : !v ? "" : it.getQuery(), (510 & 8) != 0 ? it.emptyCount : 0, (510 & 16) != 0 ? it.limiteBajo : 0.0f, (510 & 32) != 0 ? it.showAddDialog : false, (510 & 64) != 0 ? it.searchActive : v, (510 & 128) != 0 ? it.reorderMode : false, (510 & 256) != 0 ? it.customOrder : null)));
    }

    public final void showAddDialog(boolean show) {
        PantryUiState value;
        PantryUiState it;
        MutableStateFlow<PantryUiState> mutableStateFlow = this._uiState;
        do {
            value = mutableStateFlow.getValue();
            it = value;
        } while (!mutableStateFlow.compareAndSet(value, it.copy((510 & 1) != 0 ? it.allItems : null, (510 & 2) != 0 ? it.filter : null, (510 & 4) != 0 ? it.query : null, (510 & 8) != 0 ? it.emptyCount : 0, (510 & 16) != 0 ? it.limiteBajo : 0.0f, (510 & 32) != 0 ? it.showAddDialog : show, (510 & 64) != 0 ? it.searchActive : false, (510 & 128) != 0 ? it.reorderMode : false, (510 & 256) != 0 ? it.customOrder : null)));
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.pantry.PantryViewModel$increment$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PantryViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.ui.pantry.PantryViewModel$increment$1", f = "PantryViewModel.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {})
    static final class C07221 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PantryLocationEntity $location;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07221(PantryLocationEntity pantryLocationEntity, Continuation<? super C07221> continuation) {
            super(2, continuation);
            this.$location = pantryLocationEntity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PantryViewModel.this.new C07221(this.$location, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07221) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (PantryViewModel.this.repo.increment(this.$location, this) == coroutine_suspended) {
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

    public final Job increment(PantryLocationEntity location) {
        Intrinsics.checkNotNullParameter(location, "location");
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07221(location, null), 3, null);
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.pantry.PantryViewModel$decrement$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PantryViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.ui.pantry.PantryViewModel$decrement$1", f = "PantryViewModel.kt", i = {}, l = {119}, m = "invokeSuspend", n = {}, s = {})
    static final class C07191 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PantryLocationEntity $location;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07191(PantryLocationEntity pantryLocationEntity, Continuation<? super C07191> continuation) {
            super(2, continuation);
            this.$location = pantryLocationEntity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PantryViewModel.this.new C07191(this.$location, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07191) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (PantryViewModel.this.repo.decrement(this.$location, this) == coroutine_suspended) {
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

    public final Job decrement(PantryLocationEntity location) {
        Intrinsics.checkNotNullParameter(location, "location");
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07191(location, null), 3, null);
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.pantry.PantryViewModel$toggleNeedsToBuy$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PantryViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.ui.pantry.PantryViewModel$toggleNeedsToBuy$1", f = "PantryViewModel.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
    static final class C07231 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PantryProductEntity $product;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07231(PantryProductEntity pantryProductEntity, Continuation<? super C07231> continuation) {
            super(2, continuation);
            this.$product = pantryProductEntity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PantryViewModel.this.new C07231(this.$product, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07231) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (PantryViewModel.this.repo.setNeedsToBuy(this.$product.getId(), !this.$product.getNeedsToBuy(), this) == coroutine_suspended) {
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

    public final Job toggleNeedsToBuy(PantryProductEntity product) {
        Intrinsics.checkNotNullParameter(product, "product");
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07231(product, null), 3, null);
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.pantry.PantryViewModel$addItem$1, reason: invalid class name */
    /* JADX INFO: compiled from: PantryViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.ui.pantry.PantryViewModel$addItem$1", f = "PantryViewModel.kt", i = {}, l = {133}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $category;
        final /* synthetic */ String $description;
        final /* synthetic */ String $name;
        final /* synthetic */ float $quantity;
        final /* synthetic */ String $subcategory;
        final /* synthetic */ String $unit;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, String str3, String str4, float f, String str5, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$name = str;
            this.$category = str2;
            this.$subcategory = str3;
            this.$description = str4;
            this.$quantity = f;
            this.$unit = str5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PantryViewModel.this.new AnonymousClass1(this.$name, this.$category, this.$subcategory, this.$description, this.$quantity, this.$unit, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object $result;
            Object $result2;
            Object prevValue$iv;
            PantryUiState it;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    $result = obj;
                    this.label = 1;
                    Object objAddProductWithLocation = PantryViewModel.this.repo.addProductWithLocation(this.$name, this.$category, this.$subcategory, this.$description, this.$quantity, this.$unit, this);
                    if (objAddProductWithLocation == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result2 = objAddProductWithLocation;
                    break;
                    break;
                case 1:
                    $result2 = obj;
                    ResultKt.throwOnFailure($result2);
                    $result = $result2;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String newProductId = (String) $result2;
            List<String> mutableList = CollectionsKt.toMutableList((Collection) ((PantryUiState) PantryViewModel.this._uiState.getValue()).getCustomOrder());
            if (newProductId == null || mutableList.contains(newProductId)) {
                MutableStateFlow $this$update$iv = PantryViewModel.this._uiState;
                do {
                    prevValue$iv = $this$update$iv.getValue();
                    it = (PantryUiState) prevValue$iv;
                } while (!$this$update$iv.compareAndSet(prevValue$iv, it.copy((510 & 1) != 0 ? it.allItems : null, (510 & 2) != 0 ? it.filter : null, (510 & 4) != 0 ? it.query : null, (510 & 8) != 0 ? it.emptyCount : 0, (510 & 16) != 0 ? it.limiteBajo : 0.0f, (510 & 32) != 0 ? it.showAddDialog : false, (510 & 64) != 0 ? it.searchActive : false, (510 & 128) != 0 ? it.reorderMode : false, (510 & 256) != 0 ? it.customOrder : null)));
            } else {
                mutableList.add(newProductId);
                PantryViewModel.this.orderStore.save(mutableList);
                MutableStateFlow $this$update$iv2 = PantryViewModel.this._uiState;
                while (true) {
                    Object prevValue$iv2 = $this$update$iv2.getValue();
                    PantryUiState it2 = (PantryUiState) prevValue$iv2;
                    Object $result3 = $result;
                    if (!$this$update$iv2.compareAndSet(prevValue$iv2, it2.copy((510 & 1) != 0 ? it2.allItems : null, (510 & 2) != 0 ? it2.filter : null, (510 & 4) != 0 ? it2.query : null, (510 & 8) != 0 ? it2.emptyCount : 0, (510 & 16) != 0 ? it2.limiteBajo : 0.0f, (510 & 32) != 0 ? it2.showAddDialog : false, (510 & 64) != 0 ? it2.searchActive : false, (510 & 128) != 0 ? it2.reorderMode : false, (510 & 256) != 0 ? it2.customOrder : mutableList))) {
                        $result = $result3;
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    public final void addItem(String name, String category, String subcategory, String description, float quantity, String unit) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(subcategory, "subcategory");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(unit, "unit");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(name, category, subcategory, description, quantity, unit, null), 3, null);
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.pantry.PantryViewModel$deleteLocation$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PantryViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.ui.pantry.PantryViewModel$deleteLocation$1", f = "PantryViewModel.kt", i = {}, l = {147}, m = "invokeSuspend", n = {}, s = {})
    static final class C07201 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PantryLocationEntity $location;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07201(PantryLocationEntity pantryLocationEntity, Continuation<? super C07201> continuation) {
            super(2, continuation);
            this.$location = pantryLocationEntity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PantryViewModel.this.new C07201(this.$location, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07201) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (PantryViewModel.this.repo.deleteLocation(this.$location, this) == coroutine_suspended) {
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

    public final Job deleteLocation(PantryLocationEntity location) {
        Intrinsics.checkNotNullParameter(location, "location");
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07201(location, null), 3, null);
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.pantry.PantryViewModel$deleteProduct$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PantryViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.ui.pantry.PantryViewModel$deleteProduct$1", f = "PantryViewModel.kt", i = {}, l = {151}, m = "invokeSuspend", n = {}, s = {})
    static final class C07211 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $productId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07211(String str, Continuation<? super C07211> continuation) {
            super(2, continuation);
            this.$productId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PantryViewModel.this.new C07211(this.$productId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07211) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) {
            Object prevValue$iv;
            PantryUiState it;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (PantryViewModel.this.repo.deleteProduct(this.$productId, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Iterable $this$filterTo$iv$iv = ((PantryUiState) PantryViewModel.this._uiState.getValue()).getCustomOrder();
            String str = this.$productId;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filterTo$iv$iv) {
                if (!Intrinsics.areEqual((String) element$iv$iv, str)) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            List updated = (List) destination$iv$iv;
            PantryViewModel.this.orderStore.save(updated);
            MutableStateFlow $this$update$iv = PantryViewModel.this._uiState;
            do {
                prevValue$iv = $this$update$iv.getValue();
                it = (PantryUiState) prevValue$iv;
            } while (!$this$update$iv.compareAndSet(prevValue$iv, it.copy((510 & 1) != 0 ? it.allItems : null, (510 & 2) != 0 ? it.filter : null, (510 & 4) != 0 ? it.query : null, (510 & 8) != 0 ? it.emptyCount : 0, (510 & 16) != 0 ? it.limiteBajo : 0.0f, (510 & 32) != 0 ? it.showAddDialog : false, (510 & 64) != 0 ? it.searchActive : false, (510 & 128) != 0 ? it.reorderMode : false, (510 & 256) != 0 ? it.customOrder : updated)));
            return Unit.INSTANCE;
        }
    }

    public final void deleteProduct(String productId) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07211(productId, null), 3, null);
    }

    public final void toggleReorderMode() {
        PantryUiState value;
        PantryUiState it;
        List<String> customOrder;
        PantryUiState current = this._uiState.getValue();
        if (current.getReorderMode()) {
            MutableStateFlow<PantryUiState> mutableStateFlow = this._uiState;
            do {
                value = mutableStateFlow.getValue();
                it = value;
            } while (!mutableStateFlow.compareAndSet(value, it.copy((510 & 1) != 0 ? it.allItems : null, (510 & 2) != 0 ? it.filter : null, (510 & 4) != 0 ? it.query : null, (510 & 8) != 0 ? it.emptyCount : 0, (510 & 16) != 0 ? it.limiteBajo : 0.0f, (510 & 32) != 0 ? it.showAddDialog : false, (510 & 64) != 0 ? it.searchActive : false, (510 & 128) != 0 ? it.reorderMode : false, (510 & 256) != 0 ? it.customOrder : null)));
            return;
        }
        if (current.getCustomOrder().isEmpty()) {
            Iterable $this$flatMap$iv = current.getGrouped();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$flatMap$iv) {
                Iterable subcats = (List) ((Pair) element$iv$iv).component2();
                Iterable list$iv$iv = subcats;
                CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
            }
            Iterable $this$flatMap$iv2 = (List) destination$iv$iv;
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv2 : $this$flatMap$iv2) {
                Iterable locs = (List) ((Pair) element$iv$iv2).component2();
                Iterable list$iv$iv2 = locs;
                CollectionsKt.addAll(destination$iv$iv2, list$iv$iv2);
            }
            Iterable $this$map$iv = (List) destination$iv$iv2;
            Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                destination$iv$iv3.add(((PantryLocationDisplay) item$iv$iv).getProduct().getId());
            }
            customOrder = CollectionsKt.distinct((List) destination$iv$iv3);
        } else {
            customOrder = current.getCustomOrder();
        }
        this.orderStore.save(customOrder);
        MutableStateFlow<PantryUiState> mutableStateFlow2 = this._uiState;
        while (true) {
            PantryUiState value2 = mutableStateFlow2.getValue();
            PantryUiState it2 = value2;
            PantryUiState current2 = current;
            if (mutableStateFlow2.compareAndSet(value2, it2.copy((510 & 1) != 0 ? it2.allItems : null, (510 & 2) != 0 ? it2.filter : null, (510 & 4) != 0 ? it2.query : null, (510 & 8) != 0 ? it2.emptyCount : 0, (510 & 16) != 0 ? it2.limiteBajo : 0.0f, (510 & 32) != 0 ? it2.showAddDialog : false, (510 & 64) != 0 ? it2.searchActive : false, (510 & 128) != 0 ? it2.reorderMode : true, (510 & 256) != 0 ? it2.customOrder : customOrder))) {
                return;
            } else {
                current = current2;
            }
        }
    }

    public final void moveUp(String productId) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        PantryUiState current = this._uiState.getValue();
        String neighborAbove = findNeighbor(current, productId, true);
        if (neighborAbove == null) {
            return;
        }
        swapInOrder(productId, neighborAbove);
    }

    public final void moveDown(String productId) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        PantryUiState current = this._uiState.getValue();
        String neighborBelow = findNeighbor(current, productId, false);
        if (neighborBelow == null) {
            return;
        }
        swapInOrder(productId, neighborBelow);
    }

    private final String findNeighbor(PantryUiState state, String productId, boolean above) {
        Iterator<Pair<String, List<Pair<String, List<PantryLocationDisplay>>>>> it = state.getGrouped().iterator();
        while (it.hasNext()) {
            Iterator<Pair<String, List<PantryLocationDisplay>>> it2 = it.next().component2().iterator();
            while (it2.hasNext()) {
                Iterable $this$map$iv = (List) it2.next().component2();
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    PantryLocationDisplay it3 = (PantryLocationDisplay) item$iv$iv;
                    destination$iv$iv.add(it3.getProduct().getId());
                }
                List ids = (List) destination$iv$iv;
                int idx = ids.indexOf(productId);
                if (idx != -1) {
                    int neighborIdx = above ? idx - 1 : idx + 1;
                    return (String) CollectionsKt.getOrNull(ids, neighborIdx);
                }
            }
        }
        return null;
    }

    private final void swapInOrder(String idA, String idB) {
        List<String> mutableList = CollectionsKt.toMutableList((Collection) this._uiState.getValue().getCustomOrder());
        if (!mutableList.contains(idA)) {
            mutableList.add(idA);
        }
        if (!mutableList.contains(idB)) {
            mutableList.add(idB);
        }
        int i = mutableList.indexOf(idA);
        int j = mutableList.indexOf(idB);
        mutableList.set(i, idB);
        mutableList.set(j, idA);
        this.orderStore.save(mutableList);
        MutableStateFlow<PantryUiState> mutableStateFlow = this._uiState;
        while (true) {
            PantryUiState value = mutableStateFlow.getValue();
            PantryUiState it = value;
            MutableStateFlow<PantryUiState> mutableStateFlow2 = mutableStateFlow;
            int j2 = j;
            int i2 = i;
            if (mutableStateFlow2.compareAndSet(value, it.copy((510 & 1) != 0 ? it.allItems : null, (510 & 2) != 0 ? it.filter : null, (510 & 4) != 0 ? it.query : null, (510 & 8) != 0 ? it.emptyCount : 0, (510 & 16) != 0 ? it.limiteBajo : 0.0f, (510 & 32) != 0 ? it.showAddDialog : false, (510 & 64) != 0 ? it.searchActive : false, (510 & 128) != 0 ? it.reorderMode : false, (510 & 256) != 0 ? it.customOrder : mutableList))) {
                return;
            }
            mutableStateFlow = mutableStateFlow2;
            i = i2;
            j = j2;
        }
    }
}
