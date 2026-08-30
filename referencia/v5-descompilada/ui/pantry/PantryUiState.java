package com.easycompra.app.ui.pantry;

import androidx.core.app.FrameMetricsAggregator;
import com.easycompra.app.data.pantry.PantryLocationEntity;
import com.easycompra.app.data.pantry.PantryLocationEntityKt;
import com.easycompra.app.data.pantry.PantryProductWithLocations;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PantryViewModel.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\t\u0010/\u001a\u00020\bHÆ\u0003J\t\u00100\u001a\u00020\nHÆ\u0003J\t\u00101\u001a\u00020\fHÆ\u0003J\t\u00102\u001a\u00020\u000eHÆ\u0003J\t\u00103\u001a\u00020\u000eHÆ\u0003J\t\u00104\u001a\u00020\u000eHÆ\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003Jo\u00106\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0001J\u0013\u00107\u001a\u00020\u000e2\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\nHÖ\u0001J\t\u0010:\u001a\u00020\bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u0010\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0015R;\u0010&\u001a,\u0012(\u0012&\u0012\u0004\u0012\u00020\b\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u00030'0\u00030'0\u00038F¢\u0006\u0006\u001a\u0004\b(\u0010\u0015R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038F¢\u0006\u0006\u001a\u0004\b*\u0010\u0015R\u0011\u0010+\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b,\u0010\u001b¨\u0006;"}, d2 = {"Lcom/easycompra/app/ui/pantry/PantryUiState;", "", "allItems", "", "Lcom/easycompra/app/data/pantry/PantryProductWithLocations;", "filter", "Lcom/easycompra/app/ui/pantry/PantryFilter;", "query", "", "emptyCount", "", "limiteBajo", "", "showAddDialog", "", "searchActive", "reorderMode", "customOrder", "<init>", "(Ljava/util/List;Lcom/easycompra/app/ui/pantry/PantryFilter;Ljava/lang/String;IFZZZLjava/util/List;)V", "getAllItems", "()Ljava/util/List;", "getFilter", "()Lcom/easycompra/app/ui/pantry/PantryFilter;", "getQuery", "()Ljava/lang/String;", "getEmptyCount", "()I", "getLimiteBajo", "()F", "getShowAddDialog", "()Z", "getSearchActive", "getReorderMode", "getCustomOrder", "flatFiltered", "Lcom/easycompra/app/ui/pantry/PantryLocationDisplay;", "getFlatFiltered", "grouped", "Lkotlin/Pair;", "getGrouped", "needsToBuyItems", "getNeedsToBuyItems", "lowCount", "getLowCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class PantryUiState {
    public static final int $stable = 8;
    private final List<PantryProductWithLocations> allItems;
    private final List<String> customOrder;
    private final int emptyCount;
    private final PantryFilter filter;
    private final float limiteBajo;
    private final String query;
    private final boolean reorderMode;
    private final boolean searchActive;
    private final boolean showAddDialog;

    /* JADX INFO: compiled from: PantryViewModel.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PantryFilter.values().length];
            try {
                iArr[PantryFilter.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[PantryFilter.EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[PantryFilter.LOW.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PantryUiState() {
        this(null, null, null, 0, 0.0f, false, false, false, null, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    public final List<PantryProductWithLocations> component1() {
        return this.allItems;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final PantryFilter getFilter() {
        return this.filter;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getQuery() {
        return this.query;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getEmptyCount() {
        return this.emptyCount;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final float getLimiteBajo() {
        return this.limiteBajo;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getShowAddDialog() {
        return this.showAddDialog;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getSearchActive() {
        return this.searchActive;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getReorderMode() {
        return this.reorderMode;
    }

    public final List<String> component9() {
        return this.customOrder;
    }

    public final PantryUiState copy(List<PantryProductWithLocations> allItems, PantryFilter filter, String query, int emptyCount, float limiteBajo, boolean showAddDialog, boolean searchActive, boolean reorderMode, List<String> customOrder) {
        Intrinsics.checkNotNullParameter(allItems, "allItems");
        Intrinsics.checkNotNullParameter(filter, "filter");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(customOrder, "customOrder");
        return new PantryUiState(allItems, filter, query, emptyCount, limiteBajo, showAddDialog, searchActive, reorderMode, customOrder);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PantryUiState)) {
            return false;
        }
        PantryUiState pantryUiState = (PantryUiState) other;
        return Intrinsics.areEqual(this.allItems, pantryUiState.allItems) && this.filter == pantryUiState.filter && Intrinsics.areEqual(this.query, pantryUiState.query) && this.emptyCount == pantryUiState.emptyCount && Float.compare(this.limiteBajo, pantryUiState.limiteBajo) == 0 && this.showAddDialog == pantryUiState.showAddDialog && this.searchActive == pantryUiState.searchActive && this.reorderMode == pantryUiState.reorderMode && Intrinsics.areEqual(this.customOrder, pantryUiState.customOrder);
    }

    public int hashCode() {
        return (((((((((((((((this.allItems.hashCode() * 31) + this.filter.hashCode()) * 31) + this.query.hashCode()) * 31) + Integer.hashCode(this.emptyCount)) * 31) + Float.hashCode(this.limiteBajo)) * 31) + Boolean.hashCode(this.showAddDialog)) * 31) + Boolean.hashCode(this.searchActive)) * 31) + Boolean.hashCode(this.reorderMode)) * 31) + this.customOrder.hashCode();
    }

    public String toString() {
        return "PantryUiState(allItems=" + this.allItems + ", filter=" + this.filter + ", query=" + this.query + ", emptyCount=" + this.emptyCount + ", limiteBajo=" + this.limiteBajo + ", showAddDialog=" + this.showAddDialog + ", searchActive=" + this.searchActive + ", reorderMode=" + this.reorderMode + ", customOrder=" + this.customOrder + ")";
    }

    public PantryUiState(List<PantryProductWithLocations> allItems, PantryFilter filter, String query, int emptyCount, float limiteBajo, boolean showAddDialog, boolean searchActive, boolean reorderMode, List<String> customOrder) {
        Intrinsics.checkNotNullParameter(allItems, "allItems");
        Intrinsics.checkNotNullParameter(filter, "filter");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(customOrder, "customOrder");
        this.allItems = allItems;
        this.filter = filter;
        this.query = query;
        this.emptyCount = emptyCount;
        this.limiteBajo = limiteBajo;
        this.showAddDialog = showAddDialog;
        this.searchActive = searchActive;
        this.reorderMode = reorderMode;
        this.customOrder = customOrder;
    }

    public /* synthetic */ PantryUiState(List list, PantryFilter pantryFilter, String str, int i, float f, boolean z, boolean z2, boolean z3, List list2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? CollectionsKt.emptyList() : list, (i2 & 2) != 0 ? PantryFilter.ALL : pantryFilter, (i2 & 4) != 0 ? "" : str, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? 2.0f : f, (i2 & 32) != 0 ? false : z, (i2 & 64) != 0 ? false : z2, (i2 & 128) == 0 ? z3 : false, (i2 & 256) != 0 ? CollectionsKt.emptyList() : list2);
    }

    public final List<PantryProductWithLocations> getAllItems() {
        return this.allItems;
    }

    public final PantryFilter getFilter() {
        return this.filter;
    }

    public final String getQuery() {
        return this.query;
    }

    public final int getEmptyCount() {
        return this.emptyCount;
    }

    public final float getLimiteBajo() {
        return this.limiteBajo;
    }

    public final boolean getShowAddDialog() {
        return this.showAddDialog;
    }

    public final boolean getSearchActive() {
        return this.searchActive;
    }

    public final boolean getReorderMode() {
        return this.reorderMode;
    }

    public final List<String> getCustomOrder() {
        return this.customOrder;
    }

    private final List<PantryLocationDisplay> getFlatFiltered() {
        List flat;
        Iterable $this$flatMap$iv = this.allItems;
        int $i$f$flatMap = 0;
        Collection destination$iv$iv = new ArrayList();
        Iterable<PantryProductWithLocations> $this$flatMapTo$iv$iv = $this$flatMap$iv;
        for (PantryProductWithLocations pwl : $this$flatMapTo$iv$iv) {
            Iterable $this$map$iv = pwl.getLocations();
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                Iterable $this$flatMap$iv2 = $this$flatMap$iv;
                PantryLocationEntity loc = (PantryLocationEntity) item$iv$iv;
                destination$iv$iv2.add(new PantryLocationDisplay(loc, pwl.getProduct()));
                $this$flatMap$iv = $this$flatMap$iv2;
                $i$f$flatMap = $i$f$flatMap;
                $this$flatMapTo$iv$iv = $this$flatMapTo$iv$iv;
            }
            Iterable $this$flatMap$iv3 = $this$flatMap$iv;
            Iterable list$iv$iv = (List) destination$iv$iv2;
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
            $this$flatMap$iv = $this$flatMap$iv3;
        }
        List flat2 = (List) destination$iv$iv;
        if (!StringsKt.isBlank(this.query)) {
            List $this$filter$iv = flat2;
            Collection destination$iv$iv3 = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                PantryLocationDisplay it = (PantryLocationDisplay) element$iv$iv;
                if (StringsKt.contains((CharSequence) it.getProduct().getName(), (CharSequence) this.query, true) || StringsKt.contains((CharSequence) it.getLocation().getDescription(), (CharSequence) this.query, true)) {
                    destination$iv$iv3.add(element$iv$iv);
                }
            }
            flat2 = (List) destination$iv$iv3;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[this.filter.ordinal()]) {
            case 1:
                flat = flat2;
                break;
            case 2:
                Iterable $this$filter$iv2 = flat2;
                Collection destination$iv$iv4 = new ArrayList();
                for (Object element$iv$iv2 : $this$filter$iv2) {
                    if (((PantryLocationDisplay) element$iv$iv2).getLocation().getQuantity() <= 0.0f) {
                        destination$iv$iv4.add(element$iv$iv2);
                    }
                }
                flat = (List) destination$iv$iv4;
                break;
            case 3:
                Iterable $this$filter$iv3 = flat2;
                Collection destination$iv$iv5 = new ArrayList();
                for (Object element$iv$iv3 : $this$filter$iv3) {
                    PantryLocationDisplay it2 = (PantryLocationDisplay) element$iv$iv3;
                    if (it2.getLocation().getQuantity() > 0.0f && it2.getLocation().getQuantity() <= this.limiteBajo) {
                        destination$iv$iv5.add(element$iv$iv3);
                    }
                }
                flat = (List) destination$iv$iv5;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return flat;
    }

    public final List<Pair<String, List<Pair<String, List<PantryLocationDisplay>>>>> getGrouped() {
        Iterable $this$sortedByDescending$iv;
        Object answer$iv$iv$iv;
        Object answer$iv$iv$iv2;
        Iterable $this$groupBy$iv = getFlatFiltered();
        Map destination$iv$iv = new LinkedHashMap();
        for (Object element$iv$iv : $this$groupBy$iv) {
            PantryLocationDisplay it = (PantryLocationDisplay) element$iv$iv;
            String category = it.getLocation().getCategory();
            Object value$iv$iv$iv = destination$iv$iv.get(category);
            if (value$iv$iv$iv == null) {
                answer$iv$iv$iv2 = new ArrayList();
                destination$iv$iv.put(category, answer$iv$iv$iv2);
            } else {
                answer$iv$iv$iv2 = value$iv$iv$iv;
            }
            List list$iv$iv = (List) answer$iv$iv$iv2;
            list$iv$iv.add(element$iv$iv);
        }
        Map byCategory = destination$iv$iv;
        Iterable $this$filter$iv = PantryViewModelKt.getCATEGORY_ORDER();
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv2 : $this$filter$iv) {
            String it2 = (String) element$iv$iv2;
            if (byCategory.containsKey(it2)) {
                destination$iv$iv2.add(element$iv$iv2);
            }
        }
        Iterable $this$map$iv = (List) destination$iv$iv2;
        int $i$f$map = 0;
        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String cat = (String) item$iv$iv;
            Object obj = byCategory.get(cat);
            Intrinsics.checkNotNull(obj);
            Iterable $this$groupBy$iv2 = (Iterable) obj;
            Map destination$iv$iv4 = new LinkedHashMap();
            for (Object element$iv$iv3 : $this$groupBy$iv2) {
                PantryLocationDisplay it3 = (PantryLocationDisplay) element$iv$iv3;
                String subcategory = it3.getLocation().getSubcategory();
                Map byCategory2 = byCategory;
                Iterable $this$map$iv2 = $this$map$iv;
                Object value$iv$iv$iv2 = destination$iv$iv4.get(subcategory);
                if (value$iv$iv$iv2 == null) {
                    answer$iv$iv$iv = new ArrayList();
                    destination$iv$iv4.put(subcategory, answer$iv$iv$iv);
                } else {
                    answer$iv$iv$iv = value$iv$iv$iv2;
                }
                List list$iv$iv2 = (List) answer$iv$iv$iv;
                list$iv$iv2.add(element$iv$iv3);
                $this$map$iv = $this$map$iv2;
                byCategory = byCategory2;
                $i$f$map = $i$f$map;
            }
            Map byCategory3 = byCategory;
            Iterable $this$map$iv3 = $this$map$iv;
            int $i$f$map2 = $i$f$map;
            Map bySubcat = destination$iv$iv4;
            Iterable $this$sortedBy$iv = bySubcat.entrySet();
            Iterable $this$map$iv4 = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: com.easycompra.app.ui.pantry.PantryUiState$_get_grouped_$lambda$12$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Map.Entry it4 = (Map.Entry) t;
                    String str = (String) it4.getKey();
                    Map.Entry it5 = (Map.Entry) t2;
                    return ComparisonsKt.compareValues(str, (String) it5.getKey());
                }
            });
            Collection destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
            for (Object item$iv$iv2 : $this$map$iv4) {
                Map.Entry entry = (Map.Entry) item$iv$iv2;
                String subcat = (String) entry.getKey();
                Iterable locs = (List) entry.getValue();
                Map bySubcat2 = bySubcat;
                if (this.customOrder.isEmpty()) {
                    Iterable $this$sortedByDescending$iv2 = locs;
                    $this$sortedByDescending$iv = CollectionsKt.sortedWith($this$sortedByDescending$iv2, new Comparator() { // from class: com.easycompra.app.ui.pantry.PantryUiState$_get_grouped_$lambda$12$lambda$11$$inlined$sortedByDescending$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            PantryLocationDisplay it4 = (PantryLocationDisplay) t2;
                            PantryLocationDisplay it5 = (PantryLocationDisplay) t;
                            return ComparisonsKt.compareValues(Integer.valueOf(PantryLocationEntityKt.stockStatus(it4.getLocation(), this.this$0.getLimiteBajo()).ordinal()), Integer.valueOf(PantryLocationEntityKt.stockStatus(it5.getLocation(), this.this$0.getLimiteBajo()).ordinal()));
                        }
                    });
                } else {
                    Iterable $this$sortedBy$iv2 = locs;
                    $this$sortedByDescending$iv = CollectionsKt.sortedWith($this$sortedBy$iv2, new Comparator() { // from class: com.easycompra.app.ui.pantry.PantryUiState$_get_grouped_$lambda$12$lambda$11$$inlined$sortedBy$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.util.Comparator
                        public final int compare(T t, T t2) {
                            PantryLocationDisplay display = (PantryLocationDisplay) t;
                            int idx = this.this$0.getCustomOrder().indexOf(display.getProduct().getId());
                            Integer numValueOf = Integer.valueOf(idx == -1 ? Integer.MAX_VALUE : idx);
                            PantryLocationDisplay display2 = (PantryLocationDisplay) t2;
                            int idx2 = this.this$0.getCustomOrder().indexOf(display2.getProduct().getId());
                            return ComparisonsKt.compareValues(numValueOf, Integer.valueOf(idx2 != -1 ? idx2 : Integer.MAX_VALUE));
                        }
                    });
                }
                destination$iv$iv5.add(TuplesKt.to(subcat, $this$sortedByDescending$iv));
                bySubcat = bySubcat2;
                $this$map$iv4 = $this$map$iv4;
            }
            List subcats = (List) destination$iv$iv5;
            destination$iv$iv3.add(TuplesKt.to(cat, subcats));
            $this$map$iv = $this$map$iv3;
            byCategory = byCategory3;
            $i$f$map = $i$f$map2;
        }
        return (List) destination$iv$iv3;
    }

    public final List<PantryProductWithLocations> getNeedsToBuyItems() {
        Iterable $this$filter$iv = this.allItems;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            PantryProductWithLocations it = (PantryProductWithLocations) element$iv$iv;
            if (it.getProduct().getNeedsToBuy()) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    public final int getLowCount() {
        Iterable $this$flatMap$iv = this.allItems;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv) {
            Iterable list$iv$iv = ((PantryProductWithLocations) element$iv$iv).getLocations();
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        Iterable $this$count$iv = (List) destination$iv$iv;
        if (($this$count$iv instanceof Collection) && ((Collection) $this$count$iv).isEmpty()) {
            return 0;
        }
        int count$iv = 0;
        for (Object element$iv : $this$count$iv) {
            PantryLocationEntity it = (PantryLocationEntity) element$iv;
            if ((it.getQuantity() > 0.0f && it.getQuantity() <= this.limiteBajo) && (count$iv = count$iv + 1) < 0) {
                CollectionsKt.throwCountOverflow();
            }
        }
        return count$iv;
    }
}
