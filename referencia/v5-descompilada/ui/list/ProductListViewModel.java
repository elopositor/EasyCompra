package com.easycompra.app.ui.list;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelKt;
import com.easycompra.app.data.FavoritesStore;
import com.easycompra.app.data.Product;
import com.easycompra.app.data.ProductCache;
import com.easycompra.app.data.ProductRepository;
import com.easycompra.app.data.ShoppingListItem;
import com.easycompra.app.data.ShoppingListStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: ProductListViewModel.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001bJ\u0010\u0010\u001e\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u00020\u00172\b\u0010'\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010(\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"J\u0010\u0010)\u001a\u00020\u00172\b\u0010*\u001a\u0004\u0018\u00010\u0015J\u000e\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u0015J\u000e\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u001bJ\u0016\u0010/\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u001b2\u0006\u00100\u001a\u000201J\u0006\u00102\u001a\u00020\u0017J\u000e\u00103\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u0015J\b\u00104\u001a\u00020\u0017H\u0002J\u0016\u00105\u001a\u00020\u00172\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001707H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/easycompra/app/ui/list/ProductListViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "repo", "Lcom/easycompra/app/data/ProductRepository;", "shoppingStore", "Lcom/easycompra/app/data/ShoppingListStore;", "favoritesStore", "Lcom/easycompra/app/data/FavoritesStore;", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/easycompra/app/ui/list/ProductListUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "allProducts", "", "Lcom/easycompra/app/data/Product;", "syncCloudSupermarkets", "", "syncDefaults", "searchDia", "query", "", "setQuery", "q", "setSupermarketFilter", "s", "setExcludeNata", "v", "", "setSortField", "f", "Lcom/easycompra/app/ui/list/SortField;", "setNutriscoreFilter", "grade", "setShowFavoritesOnly", "selectProduct", "p", "addToShoppingList", "product", "removeFromShoppingList", "productId", "updateQuantity", "quantity", "", "clearShoppingList", "toggleFavorite", "applyFilters", "persist", "block", "Lkotlin/Function0;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProductListViewModel extends AndroidViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<ProductListUiState> _uiState;
    private List<Product> allProducts;
    private final FavoritesStore favoritesStore;
    private final ProductRepository repo;
    private final ShoppingListStore shoppingStore;
    private final StateFlow<ProductListUiState> uiState;

    /* JADX INFO: compiled from: ProductListViewModel.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SortField.values().length];
            try {
                iArr[SortField.SUGARS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[SortField.CALORIES.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[SortField.FAT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[SortField.PROTEINS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[SortField.PRICE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductListViewModel(Application app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
        this.repo = new ProductRepository(new ProductCache(app));
        this.shoppingStore = new ShoppingListStore(app);
        this.favoritesStore = new FavoritesStore(app);
        this._uiState = StateFlowKt.MutableStateFlow(new ProductListUiState(null, false, false, null, null, null, null, false, null, null, null, null, false, null, 16383, null));
        this.uiState = this._uiState;
        this.allProducts = CollectionsKt.emptyList();
        this.allProducts = this.repo.loadCached();
        MutableStateFlow<ProductListUiState> mutableStateFlow = this._uiState;
        ProductListUiState value = this._uiState.getValue();
        mutableStateFlow.setValue(value.copy((16379 & 1) != 0 ? value.products : null, (16379 & 2) != 0 ? value.isLoading : false, (16379 & 4) != 0 ? value.isSyncing : false, (16379 & 8) != 0 ? value.syncProgress : null, (16379 & 16) != 0 ? value.error : null, (16379 & 32) != 0 ? value.query : null, (16379 & 64) != 0 ? value.supermarketFilter : null, (16379 & 128) != 0 ? value.excludeNata : false, (16379 & 256) != 0 ? value.sortField : null, (16379 & 512) != 0 ? value.selectedProduct : null, (16379 & 1024) != 0 ? value.shoppingList : this.shoppingStore.load(), (16379 & 2048) != 0 ? value.favoriteIds : this.favoritesStore.load(), (16379 & 4096) != 0 ? value.showFavoritesOnly : false, (16379 & 8192) != 0 ? value.nutriscoreFilter : null));
        applyFilters();
        if (this.allProducts.isEmpty()) {
            syncDefaults();
        } else {
            syncCloudSupermarkets();
        }
    }

    public final StateFlow<ProductListUiState> getUiState() {
        return this.uiState;
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.list.ProductListViewModel$syncCloudSupermarkets$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ProductListViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.ui.list.ProductListViewModel$syncCloudSupermarkets$1", f = "ProductListViewModel.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {})
    static final class C07171 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        C07171(Continuation<? super C07171> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ProductListViewModel.this.new C07171(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07171) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0049  */
        /* JADX WARN: Code duplicated, block: B:17:0x00b0 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:18:0x00b1  */
        /* JADX WARN: Code duplicated, block: B:21:0x00c5 A[Catch: Exception -> 0x0152, TryCatch #2 {Exception -> 0x0152, blocks: (B:19:0x00b8, B:21:0x00c5, B:22:0x00db, B:24:0x00e1, B:25:0x00f1, B:26:0x0113, B:28:0x0119, B:33:0x0131, B:35:0x0136), top: B:47:0x00b8 }] */
        /* JADX WARN: Code duplicated, block: B:24:0x00e1 A[Catch: Exception -> 0x0152, LOOP:0: B:22:0x00db->B:24:0x00e1, LOOP_END, TryCatch #2 {Exception -> 0x0152, blocks: (B:19:0x00b8, B:21:0x00c5, B:22:0x00db, B:24:0x00e1, B:25:0x00f1, B:26:0x0113, B:28:0x0119, B:33:0x0131, B:35:0x0136), top: B:47:0x00b8 }] */
        /* JADX WARN: Code duplicated, block: B:28:0x0119 A[Catch: Exception -> 0x0152, TryCatch #2 {Exception -> 0x0152, blocks: (B:19:0x00b8, B:21:0x00c5, B:22:0x00db, B:24:0x00e1, B:25:0x00f1, B:26:0x0113, B:28:0x0119, B:33:0x0131, B:35:0x0136), top: B:47:0x00b8 }] */
        /* JADX WARN: Code duplicated, block: B:30:0x012c  */
        /* JADX WARN: Code duplicated, block: B:31:0x012e  */
        /* JADX WARN: Code duplicated, block: B:33:0x0131 A[Catch: Exception -> 0x0152, TryCatch #2 {Exception -> 0x0152, blocks: (B:19:0x00b8, B:21:0x00c5, B:22:0x00db, B:24:0x00e1, B:25:0x00f1, B:26:0x0113, B:28:0x0119, B:33:0x0131, B:35:0x0136), top: B:47:0x00b8 }] */
        /* JADX WARN: Code duplicated, block: B:52:0x0134 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00b1 -> B:47:0x00b8). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0158 -> B:12:0x0043). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r29) {
            /*
                Method dump skipped, instruction units count: 410
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.easycompra.app.ui.list.ProductListViewModel.C07171.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final void syncCloudSupermarkets() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07171(null), 3, null);
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.list.ProductListViewModel$syncDefaults$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ProductListViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.ui.list.ProductListViewModel$syncDefaults$1", f = "ProductListViewModel.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5}, l = {116, 116, 123, 123, 128, 128}, m = "invokeSuspend", n = {"seen", "diaQueries", "totalSteps", "step", "seen", "diaQueries", "totalSteps", "step", "seen", "totalSteps", "step", "seen", "totalSteps", "step", "seen", "totalSteps", "step", "seen", "totalSteps", "step"}, s = {"L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1", "L$0", "I$0", "I$1", "L$0", "I$0", "I$1", "L$0", "I$0", "I$1", "L$0", "I$0", "I$1"})
    static final class C07181 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        C07181(Continuation<? super C07181> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ProductListViewModel.this.new C07181(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07181) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:43:0x020a  */
        /* JADX WARN: Code duplicated, block: B:46:0x029b A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:47:0x029c  */
        /* JADX WARN: Code duplicated, block: B:50:0x02c6 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:51:0x02c7  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:101:0x0479 -> B:82:0x03c7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:103:0x047f -> B:82:0x03c7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x0485 -> B:82:0x03c7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:107:0x048c -> B:82:0x03c7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x02c7 -> B:55:0x02df). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x02d3 -> B:55:0x02df). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0396 -> B:57:0x02ec). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x039b -> B:57:0x02ec). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x03a0 -> B:57:0x02ec). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r40) {
            /*
                Method dump skipped, instruction units count: 1266
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.easycompra.app.ui.list.ProductListViewModel.C07181.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Object invokeSuspend$addBatch(ProductListViewModel this$0, Set<String> set, List<Product> list, Continuation<? super Unit> continuation) {
            List<Product> $this$filter$iv = list;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                Product it = (Product) element$iv$iv;
                if (!set.contains(it.getId())) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Iterable fresh = (List) destination$iv$iv;
            if (!((Collection) fresh).isEmpty()) {
                Iterable $this$forEach$iv = fresh;
                for (Object element$iv : $this$forEach$iv) {
                    Product it2 = (Product) element$iv;
                    set.add(it2.getId());
                }
                Iterable $this$forEach$iv2 = this$0.allProducts;
                this$0.allProducts = CollectionsKt.plus((Collection) $this$forEach$iv2, fresh);
                this$0.applyFilters();
            }
            return Unit.INSTANCE;
        }
    }

    public final void syncDefaults() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07181(null), 3, null);
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.list.ProductListViewModel$searchDia$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ProductListViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.ui.list.ProductListViewModel$searchDia$1", f = "ProductListViewModel.kt", i = {}, l = {140}, m = "invokeSuspend", n = {}, s = {})
    static final class C07161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $query;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07161(String str, Continuation<? super C07161> continuation) {
            super(2, continuation);
            this.$query = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ProductListViewModel.this.new C07161(this.$query, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07161) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [int] */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v7 */
        /* JADX WARN: Type inference failed for: r2v9, types: [com.easycompra.app.ui.list.ProductListViewModel] */
        /* JADX WARN: Type inference failed for: r3v9 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object $result) throws Throwable {
            Object $result2;
            Object $result3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ?? r2 = this.label;
            try {
                try {
                    switch (r2) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            MutableStateFlow mutableStateFlow = ProductListViewModel.this._uiState;
                            ProductListUiState productListUiState = (ProductListUiState) ProductListViewModel.this._uiState.getValue();
                            mutableStateFlow.setValue(productListUiState.copy((16379 & 1) != 0 ? productListUiState.products : null, (16379 & 2) != 0 ? productListUiState.isLoading : false, (16379 & 4) != 0 ? productListUiState.isSyncing : true, (16379 & 8) != 0 ? productListUiState.syncProgress : null, (16379 & 16) != 0 ? productListUiState.error : null, (16379 & 32) != 0 ? productListUiState.query : null, (16379 & 64) != 0 ? productListUiState.supermarketFilter : null, (16379 & 128) != 0 ? productListUiState.excludeNata : false, (16379 & 256) != 0 ? productListUiState.sortField : null, (16379 & 512) != 0 ? productListUiState.selectedProduct : null, (16379 & 1024) != 0 ? productListUiState.shoppingList : null, (16379 & 2048) != 0 ? productListUiState.favoriteIds : null, (16379 & 4096) != 0 ? productListUiState.showFavoritesOnly : false, (16379 & 8192) != 0 ? productListUiState.nutriscoreFilter : null));
                            this.label = 1;
                            Object objSyncDiaSearch = ProductListViewModel.this.repo.syncDiaSearch(this.$query, this);
                            if (objSyncDiaSearch == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result2 = $result;
                            $result3 = objSyncDiaSearch;
                            break;
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
                        List newProducts = (List) $result3;
                        r2 = ProductListViewModel.this;
                        Iterable $this$distinctBy$iv = CollectionsKt.plus((Collection) ProductListViewModel.this.allProducts, (Iterable) newProducts);
                        HashSet set$iv = new HashSet();
                        ArrayList list$iv = new ArrayList();
                        for (Object e$iv : $this$distinctBy$iv) {
                            Product it = (Product) e$iv;
                            if (set$iv.add(it.getId())) {
                                list$iv.add(e$iv);
                            }
                        }
                        ((ProductListViewModel) r2).allProducts = list$iv;
                        MutableStateFlow mutableStateFlow2 = ProductListViewModel.this._uiState;
                        ProductListUiState productListUiState2 = (ProductListUiState) ProductListViewModel.this._uiState.getValue();
                        mutableStateFlow2.setValue(productListUiState2.copy((16379 & 1) != 0 ? productListUiState2.products : null, (16379 & 2) != 0 ? productListUiState2.isLoading : false, (16379 & 4) != 0 ? productListUiState2.isSyncing : false, (16379 & 8) != 0 ? productListUiState2.syncProgress : null, (16379 & 16) != 0 ? productListUiState2.error : null, (16379 & 32) != 0 ? productListUiState2.query : null, (16379 & 64) != 0 ? productListUiState2.supermarketFilter : null, (16379 & 128) != 0 ? productListUiState2.excludeNata : false, (16379 & 256) != 0 ? productListUiState2.sortField : null, (16379 & 512) != 0 ? productListUiState2.selectedProduct : null, (16379 & 1024) != 0 ? productListUiState2.shoppingList : null, (16379 & 2048) != 0 ? productListUiState2.favoriteIds : null, (16379 & 4096) != 0 ? productListUiState2.showFavoritesOnly : false, (16379 & 8192) != 0 ? productListUiState2.nutriscoreFilter : null));
                        ProductListViewModel.this.applyFilters();
                    } catch (Exception e) {
                        e = e;
                        r2 = $result2;
                        MutableStateFlow mutableStateFlow3 = ProductListViewModel.this._uiState;
                        ProductListUiState productListUiState3 = (ProductListUiState) ProductListViewModel.this._uiState.getValue();
                        mutableStateFlow3.setValue(productListUiState3.copy((16379 & 1) != 0 ? productListUiState3.products : null, (16379 & 2) != 0 ? productListUiState3.isLoading : false, (16379 & 4) != 0 ? productListUiState3.isSyncing : false, (16379 & 8) != 0 ? productListUiState3.syncProgress : null, (16379 & 16) != 0 ? productListUiState3.error : "Error de red: " + e.getMessage(), (16379 & 32) != 0 ? productListUiState3.query : null, (16379 & 64) != 0 ? productListUiState3.supermarketFilter : null, (16379 & 128) != 0 ? productListUiState3.excludeNata : false, (16379 & 256) != 0 ? productListUiState3.sortField : null, (16379 & 512) != 0 ? productListUiState3.selectedProduct : null, (16379 & 1024) != 0 ? productListUiState3.shoppingList : null, (16379 & 2048) != 0 ? productListUiState3.favoriteIds : null, (16379 & 4096) != 0 ? productListUiState3.showFavoritesOnly : false, (16379 & 8192) != 0 ? productListUiState3.nutriscoreFilter : null));
                        MutableStateFlow mutableStateFlow4 = ProductListViewModel.this._uiState;
                        ProductListUiState productListUiState4 = (ProductListUiState) ProductListViewModel.this._uiState.getValue();
                        mutableStateFlow4.setValue(productListUiState4.copy((16379 & 1) != 0 ? productListUiState4.products : null, (16379 & 2) != 0 ? productListUiState4.isLoading : false, (16379 & 4) != 0 ? productListUiState4.isSyncing : false, (16379 & 8) != 0 ? productListUiState4.syncProgress : null, (16379 & 16) != 0 ? productListUiState4.error : null, (16379 & 32) != 0 ? productListUiState4.query : null, (16379 & 64) != 0 ? productListUiState4.supermarketFilter : null, (16379 & 128) != 0 ? productListUiState4.excludeNata : false, (16379 & 256) != 0 ? productListUiState4.sortField : null, (16379 & 512) != 0 ? productListUiState4.selectedProduct : null, (16379 & 1024) != 0 ? productListUiState4.shoppingList : null, (16379 & 2048) != 0 ? productListUiState4.favoriteIds : null, (16379 & 4096) != 0 ? productListUiState4.showFavoritesOnly : false, (16379 & 8192) != 0 ? productListUiState4.nutriscoreFilter : null));
                        ProductListViewModel.this.applyFilters();
                    } catch (Throwable th) {
                        th = th;
                        MutableStateFlow mutableStateFlow5 = ProductListViewModel.this._uiState;
                        ProductListUiState productListUiState5 = (ProductListUiState) ProductListViewModel.this._uiState.getValue();
                        mutableStateFlow5.setValue(productListUiState5.copy((16379 & 1) != 0 ? productListUiState5.products : null, (16379 & 2) != 0 ? productListUiState5.isLoading : false, (16379 & 4) != 0 ? productListUiState5.isSyncing : false, (16379 & 8) != 0 ? productListUiState5.syncProgress : null, (16379 & 16) != 0 ? productListUiState5.error : null, (16379 & 32) != 0 ? productListUiState5.query : null, (16379 & 64) != 0 ? productListUiState5.supermarketFilter : null, (16379 & 128) != 0 ? productListUiState5.excludeNata : false, (16379 & 256) != 0 ? productListUiState5.sortField : null, (16379 & 512) != 0 ? productListUiState5.selectedProduct : null, (16379 & 1024) != 0 ? productListUiState5.shoppingList : null, (16379 & 2048) != 0 ? productListUiState5.favoriteIds : null, (16379 & 4096) != 0 ? productListUiState5.showFavoritesOnly : false, (16379 & 8192) != 0 ? productListUiState5.nutriscoreFilter : null));
                        ProductListViewModel.this.applyFilters();
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                return Unit.INSTANCE;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void searchDia(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        if (StringsKt.isBlank(query)) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07161(query, null), 3, null);
    }

    public final void setQuery(String q) {
        Intrinsics.checkNotNullParameter(q, "q");
        MutableStateFlow<ProductListUiState> mutableStateFlow = this._uiState;
        ProductListUiState value = this._uiState.getValue();
        mutableStateFlow.setValue(value.copy((16379 & 1) != 0 ? value.products : null, (16379 & 2) != 0 ? value.isLoading : false, (16379 & 4) != 0 ? value.isSyncing : false, (16379 & 8) != 0 ? value.syncProgress : null, (16379 & 16) != 0 ? value.error : null, (16379 & 32) != 0 ? value.query : q, (16379 & 64) != 0 ? value.supermarketFilter : null, (16379 & 128) != 0 ? value.excludeNata : false, (16379 & 256) != 0 ? value.sortField : null, (16379 & 512) != 0 ? value.selectedProduct : null, (16379 & 1024) != 0 ? value.shoppingList : null, (16379 & 2048) != 0 ? value.favoriteIds : null, (16379 & 4096) != 0 ? value.showFavoritesOnly : false, (16379 & 8192) != 0 ? value.nutriscoreFilter : null));
        applyFilters();
    }

    public final void setSupermarketFilter(String s) {
        MutableStateFlow<ProductListUiState> mutableStateFlow = this._uiState;
        ProductListUiState value = this._uiState.getValue();
        mutableStateFlow.setValue(value.copy((16379 & 1) != 0 ? value.products : null, (16379 & 2) != 0 ? value.isLoading : false, (16379 & 4) != 0 ? value.isSyncing : false, (16379 & 8) != 0 ? value.syncProgress : null, (16379 & 16) != 0 ? value.error : null, (16379 & 32) != 0 ? value.query : null, (16379 & 64) != 0 ? value.supermarketFilter : s, (16379 & 128) != 0 ? value.excludeNata : false, (16379 & 256) != 0 ? value.sortField : null, (16379 & 512) != 0 ? value.selectedProduct : null, (16379 & 1024) != 0 ? value.shoppingList : null, (16379 & 2048) != 0 ? value.favoriteIds : null, (16379 & 4096) != 0 ? value.showFavoritesOnly : false, (16379 & 8192) != 0 ? value.nutriscoreFilter : null));
        applyFilters();
    }

    public final void setExcludeNata(boolean v) {
        MutableStateFlow<ProductListUiState> mutableStateFlow = this._uiState;
        ProductListUiState value = this._uiState.getValue();
        mutableStateFlow.setValue(value.copy((16379 & 1) != 0 ? value.products : null, (16379 & 2) != 0 ? value.isLoading : false, (16379 & 4) != 0 ? value.isSyncing : false, (16379 & 8) != 0 ? value.syncProgress : null, (16379 & 16) != 0 ? value.error : null, (16379 & 32) != 0 ? value.query : null, (16379 & 64) != 0 ? value.supermarketFilter : null, (16379 & 128) != 0 ? value.excludeNata : v, (16379 & 256) != 0 ? value.sortField : null, (16379 & 512) != 0 ? value.selectedProduct : null, (16379 & 1024) != 0 ? value.shoppingList : null, (16379 & 2048) != 0 ? value.favoriteIds : null, (16379 & 4096) != 0 ? value.showFavoritesOnly : false, (16379 & 8192) != 0 ? value.nutriscoreFilter : null));
        applyFilters();
    }

    public final void setSortField(SortField f) {
        Intrinsics.checkNotNullParameter(f, "f");
        MutableStateFlow<ProductListUiState> mutableStateFlow = this._uiState;
        ProductListUiState value = this._uiState.getValue();
        mutableStateFlow.setValue(value.copy((16379 & 1) != 0 ? value.products : null, (16379 & 2) != 0 ? value.isLoading : false, (16379 & 4) != 0 ? value.isSyncing : false, (16379 & 8) != 0 ? value.syncProgress : null, (16379 & 16) != 0 ? value.error : null, (16379 & 32) != 0 ? value.query : null, (16379 & 64) != 0 ? value.supermarketFilter : null, (16379 & 128) != 0 ? value.excludeNata : false, (16379 & 256) != 0 ? value.sortField : f, (16379 & 512) != 0 ? value.selectedProduct : null, (16379 & 1024) != 0 ? value.shoppingList : null, (16379 & 2048) != 0 ? value.favoriteIds : null, (16379 & 4096) != 0 ? value.showFavoritesOnly : false, (16379 & 8192) != 0 ? value.nutriscoreFilter : null));
        applyFilters();
    }

    public final void setNutriscoreFilter(String grade) {
        MutableStateFlow<ProductListUiState> mutableStateFlow = this._uiState;
        ProductListUiState value = this._uiState.getValue();
        mutableStateFlow.setValue(value.copy((16379 & 1) != 0 ? value.products : null, (16379 & 2) != 0 ? value.isLoading : false, (16379 & 4) != 0 ? value.isSyncing : false, (16379 & 8) != 0 ? value.syncProgress : null, (16379 & 16) != 0 ? value.error : null, (16379 & 32) != 0 ? value.query : null, (16379 & 64) != 0 ? value.supermarketFilter : null, (16379 & 128) != 0 ? value.excludeNata : false, (16379 & 256) != 0 ? value.sortField : null, (16379 & 512) != 0 ? value.selectedProduct : null, (16379 & 1024) != 0 ? value.shoppingList : null, (16379 & 2048) != 0 ? value.favoriteIds : null, (16379 & 4096) != 0 ? value.showFavoritesOnly : false, (16379 & 8192) != 0 ? value.nutriscoreFilter : grade));
        applyFilters();
    }

    public final void setShowFavoritesOnly(boolean v) {
        MutableStateFlow<ProductListUiState> mutableStateFlow = this._uiState;
        ProductListUiState value = this._uiState.getValue();
        mutableStateFlow.setValue(value.copy((16379 & 1) != 0 ? value.products : null, (16379 & 2) != 0 ? value.isLoading : false, (16379 & 4) != 0 ? value.isSyncing : false, (16379 & 8) != 0 ? value.syncProgress : null, (16379 & 16) != 0 ? value.error : null, (16379 & 32) != 0 ? value.query : null, (16379 & 64) != 0 ? value.supermarketFilter : null, (16379 & 128) != 0 ? value.excludeNata : false, (16379 & 256) != 0 ? value.sortField : null, (16379 & 512) != 0 ? value.selectedProduct : null, (16379 & 1024) != 0 ? value.shoppingList : null, (16379 & 2048) != 0 ? value.favoriteIds : null, (16379 & 4096) != 0 ? value.showFavoritesOnly : v, (16379 & 8192) != 0 ? value.nutriscoreFilter : null));
        applyFilters();
    }

    public final void selectProduct(Product p) {
        MutableStateFlow<ProductListUiState> mutableStateFlow = this._uiState;
        ProductListUiState value = this._uiState.getValue();
        mutableStateFlow.setValue(value.copy((16379 & 1) != 0 ? value.products : null, (16379 & 2) != 0 ? value.isLoading : false, (16379 & 4) != 0 ? value.isSyncing : false, (16379 & 8) != 0 ? value.syncProgress : null, (16379 & 16) != 0 ? value.error : null, (16379 & 32) != 0 ? value.query : null, (16379 & 64) != 0 ? value.supermarketFilter : null, (16379 & 128) != 0 ? value.excludeNata : false, (16379 & 256) != 0 ? value.sortField : null, (16379 & 512) != 0 ? value.selectedProduct : p, (16379 & 1024) != 0 ? value.shoppingList : null, (16379 & 2048) != 0 ? value.favoriteIds : null, (16379 & 4096) != 0 ? value.showFavoritesOnly : false, (16379 & 8192) != 0 ? value.nutriscoreFilter : null));
    }

    public final void addToShoppingList(Product product) {
        Object next;
        List listPlus;
        Intrinsics.checkNotNullParameter(product, "product");
        Iterable shoppingList = this._uiState.getValue().getShoppingList();
        Iterator<T> it = shoppingList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((ShoppingListItem) next).getProduct().getId(), product.getId()));
        ShoppingListItem existing = (ShoppingListItem) next;
        if (existing != null) {
            Iterable $this$map$iv = shoppingList;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                ShoppingListItem it2 = (ShoppingListItem) item$iv$iv;
                if (Intrinsics.areEqual(it2.getProduct().getId(), product.getId())) {
                    it2 = ShoppingListItem.copy$default(it2, null, it2.getQuantity() + 1, 1, null);
                }
                destination$iv$iv.add(it2);
            }
            listPlus = (List) destination$iv$iv;
        } else {
            listPlus = CollectionsKt.plus((Collection<? extends ShoppingListItem>) shoppingList, new ShoppingListItem(product, 0, 2, null));
        }
        final List updated = listPlus;
        MutableStateFlow<ProductListUiState> mutableStateFlow = this._uiState;
        ProductListUiState value = this._uiState.getValue();
        mutableStateFlow.setValue(value.copy((16379 & 1) != 0 ? value.products : null, (16379 & 2) != 0 ? value.isLoading : false, (16379 & 4) != 0 ? value.isSyncing : false, (16379 & 8) != 0 ? value.syncProgress : null, (16379 & 16) != 0 ? value.error : null, (16379 & 32) != 0 ? value.query : null, (16379 & 64) != 0 ? value.supermarketFilter : null, (16379 & 128) != 0 ? value.excludeNata : false, (16379 & 256) != 0 ? value.sortField : null, (16379 & 512) != 0 ? value.selectedProduct : null, (16379 & 1024) != 0 ? value.shoppingList : updated, (16379 & 2048) != 0 ? value.favoriteIds : null, (16379 & 4096) != 0 ? value.showFavoritesOnly : false, (16379 & 8192) != 0 ? value.nutriscoreFilter : null));
        persist(new Function0() { // from class: com.easycompra.app.ui.list.ProductListViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProductListViewModel.addToShoppingList$lambda$2(this.f$0, updated);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addToShoppingList$lambda$2(ProductListViewModel this$0, List $updated) {
        this$0.shoppingStore.save($updated);
        return Unit.INSTANCE;
    }

    public final void removeFromShoppingList(String productId) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Iterable $this$filter$iv = this._uiState.getValue().getShoppingList();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            ShoppingListItem it = (ShoppingListItem) element$iv$iv;
            if (!Intrinsics.areEqual(it.getProduct().getId(), productId)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        final List updated = (List) destination$iv$iv;
        MutableStateFlow<ProductListUiState> mutableStateFlow = this._uiState;
        ProductListUiState value = this._uiState.getValue();
        mutableStateFlow.setValue(value.copy((16379 & 1) != 0 ? value.products : null, (16379 & 2) != 0 ? value.isLoading : false, (16379 & 4) != 0 ? value.isSyncing : false, (16379 & 8) != 0 ? value.syncProgress : null, (16379 & 16) != 0 ? value.error : null, (16379 & 32) != 0 ? value.query : null, (16379 & 64) != 0 ? value.supermarketFilter : null, (16379 & 128) != 0 ? value.excludeNata : false, (16379 & 256) != 0 ? value.sortField : null, (16379 & 512) != 0 ? value.selectedProduct : null, (16379 & 1024) != 0 ? value.shoppingList : updated, (16379 & 2048) != 0 ? value.favoriteIds : null, (16379 & 4096) != 0 ? value.showFavoritesOnly : false, (16379 & 8192) != 0 ? value.nutriscoreFilter : null));
        persist(new Function0() { // from class: com.easycompra.app.ui.list.ProductListViewModel$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProductListViewModel.removeFromShoppingList$lambda$4(this.f$0, updated);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit removeFromShoppingList$lambda$4(ProductListViewModel this$0, List $updated) {
        this$0.shoppingStore.save($updated);
        return Unit.INSTANCE;
    }

    public final void updateQuantity(String productId, int quantity) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Iterable $this$map$iv = this._uiState.getValue().getShoppingList();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ShoppingListItem it = (ShoppingListItem) item$iv$iv;
            if (Intrinsics.areEqual(it.getProduct().getId(), productId)) {
                it = ShoppingListItem.copy$default(it, null, RangesKt.coerceAtLeast(quantity, 1), 1, null);
            }
            destination$iv$iv.add(it);
        }
        final List updated = (List) destination$iv$iv;
        MutableStateFlow<ProductListUiState> mutableStateFlow = this._uiState;
        ProductListUiState value = this._uiState.getValue();
        mutableStateFlow.setValue(value.copy((16379 & 1) != 0 ? value.products : null, (16379 & 2) != 0 ? value.isLoading : false, (16379 & 4) != 0 ? value.isSyncing : false, (16379 & 8) != 0 ? value.syncProgress : null, (16379 & 16) != 0 ? value.error : null, (16379 & 32) != 0 ? value.query : null, (16379 & 64) != 0 ? value.supermarketFilter : null, (16379 & 128) != 0 ? value.excludeNata : false, (16379 & 256) != 0 ? value.sortField : null, (16379 & 512) != 0 ? value.selectedProduct : null, (16379 & 1024) != 0 ? value.shoppingList : updated, (16379 & 2048) != 0 ? value.favoriteIds : null, (16379 & 4096) != 0 ? value.showFavoritesOnly : false, (16379 & 8192) != 0 ? value.nutriscoreFilter : null));
        persist(new Function0() { // from class: com.easycompra.app.ui.list.ProductListViewModel$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProductListViewModel.updateQuantity$lambda$6(this.f$0, updated);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateQuantity$lambda$6(ProductListViewModel this$0, List $updated) {
        this$0.shoppingStore.save($updated);
        return Unit.INSTANCE;
    }

    public final void clearShoppingList() {
        MutableStateFlow<ProductListUiState> mutableStateFlow = this._uiState;
        ProductListUiState value = this._uiState.getValue();
        mutableStateFlow.setValue(value.copy((16379 & 1) != 0 ? value.products : null, (16379 & 2) != 0 ? value.isLoading : false, (16379 & 4) != 0 ? value.isSyncing : false, (16379 & 8) != 0 ? value.syncProgress : null, (16379 & 16) != 0 ? value.error : null, (16379 & 32) != 0 ? value.query : null, (16379 & 64) != 0 ? value.supermarketFilter : null, (16379 & 128) != 0 ? value.excludeNata : false, (16379 & 256) != 0 ? value.sortField : null, (16379 & 512) != 0 ? value.selectedProduct : null, (16379 & 1024) != 0 ? value.shoppingList : CollectionsKt.emptyList(), (16379 & 2048) != 0 ? value.favoriteIds : null, (16379 & 4096) != 0 ? value.showFavoritesOnly : false, (16379 & 8192) != 0 ? value.nutriscoreFilter : null));
        persist(new Function0() { // from class: com.easycompra.app.ui.list.ProductListViewModel$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProductListViewModel.clearShoppingList$lambda$7(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit clearShoppingList$lambda$7(ProductListViewModel this$0) {
        this$0.shoppingStore.save(CollectionsKt.emptyList());
        return Unit.INSTANCE;
    }

    public final void toggleFavorite(Product product) {
        Intrinsics.checkNotNullParameter(product, "product");
        Set<String> favoriteIds = this._uiState.getValue().getFavoriteIds();
        final Set updated = favoriteIds.contains(product.getId()) ? SetsKt.minus(favoriteIds, product.getId()) : SetsKt.plus(favoriteIds, product.getId());
        MutableStateFlow<ProductListUiState> mutableStateFlow = this._uiState;
        ProductListUiState value = this._uiState.getValue();
        mutableStateFlow.setValue(value.copy((16379 & 1) != 0 ? value.products : null, (16379 & 2) != 0 ? value.isLoading : false, (16379 & 4) != 0 ? value.isSyncing : false, (16379 & 8) != 0 ? value.syncProgress : null, (16379 & 16) != 0 ? value.error : null, (16379 & 32) != 0 ? value.query : null, (16379 & 64) != 0 ? value.supermarketFilter : null, (16379 & 128) != 0 ? value.excludeNata : false, (16379 & 256) != 0 ? value.sortField : null, (16379 & 512) != 0 ? value.selectedProduct : null, (16379 & 1024) != 0 ? value.shoppingList : null, (16379 & 2048) != 0 ? value.favoriteIds : updated, (16379 & 4096) != 0 ? value.showFavoritesOnly : false, (16379 & 8192) != 0 ? value.nutriscoreFilter : null));
        persist(new Function0() { // from class: com.easycompra.app.ui.list.ProductListViewModel$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProductListViewModel.toggleFavorite$lambda$8(this.f$0, updated);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toggleFavorite$lambda$8(ProductListViewModel this$0, Set $updated) {
        this$0.favoritesStore.save($updated);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyFilters() {
        String lowerCase;
        final ProductListUiState state = this._uiState.getValue();
        List result = this.allProducts;
        if (!StringsKt.isBlank(state.getQuery())) {
            List $this$filter$iv = result;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                Product it = (Product) element$iv$iv;
                if (StringsKt.contains((CharSequence) it.getName(), (CharSequence) state.getQuery(), true)) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            result = (List) destination$iv$iv;
        }
        if (state.getSupermarketFilter() != null) {
            List $this$filter$iv2 = result;
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv2 : $this$filter$iv2) {
                Product it2 = (Product) element$iv$iv2;
                if (Intrinsics.areEqual(it2.getSupermarket(), state.getSupermarketFilter())) {
                    destination$iv$iv2.add(element$iv$iv2);
                }
            }
            result = (List) destination$iv$iv2;
        }
        if (state.getExcludeNata()) {
            List $this$filter$iv3 = result;
            Collection destination$iv$iv3 = new ArrayList();
            for (Object element$iv$iv3 : $this$filter$iv3) {
                Product it3 = (Product) element$iv$iv3;
                if (!it3.getContainsNata()) {
                    destination$iv$iv3.add(element$iv$iv3);
                }
            }
            result = (List) destination$iv$iv3;
        }
        if (state.getNutriscoreFilter() != null) {
            List $this$filter$iv4 = result;
            Collection destination$iv$iv4 = new ArrayList();
            for (Object element$iv$iv4 : $this$filter$iv4) {
                Product it4 = (Product) element$iv$iv4;
                String nutriscoreGrade = it4.getNutriscoreGrade();
                if (nutriscoreGrade != null) {
                    lowerCase = nutriscoreGrade.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                } else {
                    lowerCase = null;
                }
                if (Intrinsics.areEqual(lowerCase, state.getNutriscoreFilter())) {
                    destination$iv$iv4.add(element$iv$iv4);
                }
            }
            result = (List) destination$iv$iv4;
        }
        if (state.getShowFavoritesOnly()) {
            List $this$filter$iv5 = result;
            Collection destination$iv$iv5 = new ArrayList();
            for (Object element$iv$iv5 : $this$filter$iv5) {
                Product it5 = (Product) element$iv$iv5;
                if (state.getFavoriteIds().contains(it5.getId())) {
                    destination$iv$iv5.add(element$iv$iv5);
                }
            }
            result = (List) destination$iv$iv5;
        }
        List $this$sortedBy$iv = result;
        this._uiState.setValue(state.copy((16379 & 1) != 0 ? state.products : CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: com.easycompra.app.ui.list.ProductListViewModel$applyFilters$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Double sugars100g;
                Product p = (Product) t;
                Double sugars100g2 = null;
                switch (ProductListViewModel.WhenMappings.$EnumSwitchMapping$0[state.getSortField().ordinal()]) {
                    case 1:
                        sugars100g = p.getSugars100g();
                        break;
                    case 2:
                        sugars100g = p.getEnergyKcal100g();
                        break;
                    case 3:
                        sugars100g = p.getFat100g();
                        break;
                    case 4:
                        Double proteins100g = p.getProteins100g();
                        if (proteins100g == null) {
                            sugars100g = null;
                        } else {
                            double it6 = proteins100g.doubleValue();
                            sugars100g = Double.valueOf(-it6);
                        }
                        break;
                    case 5:
                        sugars100g = p.getUnitPrice();
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                Double dValueOf = Double.valueOf(sugars100g != null ? sugars100g.doubleValue() : Double.MAX_VALUE);
                Product p2 = (Product) t2;
                switch (ProductListViewModel.WhenMappings.$EnumSwitchMapping$0[state.getSortField().ordinal()]) {
                    case 1:
                        sugars100g2 = p2.getSugars100g();
                        break;
                    case 2:
                        sugars100g2 = p2.getEnergyKcal100g();
                        break;
                    case 3:
                        sugars100g2 = p2.getFat100g();
                        break;
                    case 4:
                        Double proteins100g2 = p2.getProteins100g();
                        if (proteins100g2 != null) {
                            double it7 = proteins100g2.doubleValue();
                            sugars100g2 = Double.valueOf(-it7);
                        }
                        break;
                    case 5:
                        sugars100g2 = p2.getUnitPrice();
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                return ComparisonsKt.compareValues(dValueOf, Double.valueOf(sugars100g2 != null ? sugars100g2.doubleValue() : Double.MAX_VALUE));
            }
        }), (16379 & 2) != 0 ? state.isLoading : false, (16379 & 4) != 0 ? state.isSyncing : false, (16379 & 8) != 0 ? state.syncProgress : null, (16379 & 16) != 0 ? state.error : null, (16379 & 32) != 0 ? state.query : null, (16379 & 64) != 0 ? state.supermarketFilter : null, (16379 & 128) != 0 ? state.excludeNata : false, (16379 & 256) != 0 ? state.sortField : null, (16379 & 512) != 0 ? state.selectedProduct : null, (16379 & 1024) != 0 ? state.shoppingList : null, (16379 & 2048) != 0 ? state.favoriteIds : null, (16379 & 4096) != 0 ? state.showFavoritesOnly : false, (16379 & 8192) != 0 ? state.nutriscoreFilter : null));
    }

    /* JADX INFO: renamed from: com.easycompra.app.ui.list.ProductListViewModel$persist$1, reason: invalid class name */
    /* JADX INFO: compiled from: ProductListViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.ui.list.ProductListViewModel$persist$1", f = "ProductListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function0<Unit> function0, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$block = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    this.$block.invoke();
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    private final void persist(Function0<Unit> block) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(block, null), 2, null);
    }
}
