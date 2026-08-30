package com.easycompra.app.ui.list;

import com.easycompra.app.data.Product;
import com.easycompra.app.data.ShoppingListItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProductListViewModel.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001B¯\u0001\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0006HÆ\u0003J\t\u00103\u001a\u00020\u0006HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u00106\u001a\u00020\tHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u00108\u001a\u00020\u0006HÆ\u0003J\t\u00109\u001a\u00020\u000fHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003HÆ\u0003J\u000f\u0010<\u001a\b\u0012\u0004\u0012\u00020\t0\u0014HÆ\u0003J\t\u0010=\u001a\u00020\u0006HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\tHÆ\u0003J±\u0001\u0010?\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010@\u001a\u00020\u00062\b\u0010A\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010B\u001a\u00020.HÖ\u0001J\t\u0010C\u001a\u00020\tHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u001bR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0014¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0015\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001dR\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\t0\u00148F¢\u0006\u0006\u001a\u0004\b,\u0010(R\u0011\u0010-\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\b/\u00100¨\u0006D"}, d2 = {"Lcom/easycompra/app/ui/list/ProductListUiState;", "", "products", "", "Lcom/easycompra/app/data/Product;", "isLoading", "", "isSyncing", "syncProgress", "", "error", "query", "supermarketFilter", "excludeNata", "sortField", "Lcom/easycompra/app/ui/list/SortField;", "selectedProduct", "shoppingList", "Lcom/easycompra/app/data/ShoppingListItem;", "favoriteIds", "", "showFavoritesOnly", "nutriscoreFilter", "<init>", "(Ljava/util/List;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/easycompra/app/ui/list/SortField;Lcom/easycompra/app/data/Product;Ljava/util/List;Ljava/util/Set;ZLjava/lang/String;)V", "getProducts", "()Ljava/util/List;", "()Z", "getSyncProgress", "()Ljava/lang/String;", "getError", "getQuery", "getSupermarketFilter", "getExcludeNata", "getSortField", "()Lcom/easycompra/app/ui/list/SortField;", "getSelectedProduct", "()Lcom/easycompra/app/data/Product;", "getShoppingList", "getFavoriteIds", "()Ljava/util/Set;", "getShowFavoritesOnly", "getNutriscoreFilter", "shoppingListIds", "getShoppingListIds", "shoppingCount", "", "getShoppingCount", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", "hashCode", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class ProductListUiState {
    public static final int $stable = 8;
    private final String error;
    private final boolean excludeNata;
    private final Set<String> favoriteIds;
    private final boolean isLoading;
    private final boolean isSyncing;
    private final String nutriscoreFilter;
    private final List<Product> products;
    private final String query;
    private final Product selectedProduct;
    private final List<ShoppingListItem> shoppingList;
    private final boolean showFavoritesOnly;
    private final SortField sortField;
    private final String supermarketFilter;
    private final String syncProgress;

    public ProductListUiState() {
        this(null, false, false, null, null, null, null, false, null, null, null, null, false, null, 16383, null);
    }

    public final List<Product> component1() {
        return this.products;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Product getSelectedProduct() {
        return this.selectedProduct;
    }

    public final List<ShoppingListItem> component11() {
        return this.shoppingList;
    }

    public final Set<String> component12() {
        return this.favoriteIds;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final boolean getShowFavoritesOnly() {
        return this.showFavoritesOnly;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getNutriscoreFilter() {
        return this.nutriscoreFilter;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsSyncing() {
        return this.isSyncing;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSyncProgress() {
        return this.syncProgress;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getError() {
        return this.error;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getQuery() {
        return this.query;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getSupermarketFilter() {
        return this.supermarketFilter;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getExcludeNata() {
        return this.excludeNata;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final SortField getSortField() {
        return this.sortField;
    }

    public final ProductListUiState copy(List<Product> products, boolean isLoading, boolean isSyncing, String syncProgress, String error, String query, String supermarketFilter, boolean excludeNata, SortField sortField, Product selectedProduct, List<ShoppingListItem> shoppingList, Set<String> favoriteIds, boolean showFavoritesOnly, String nutriscoreFilter) {
        Intrinsics.checkNotNullParameter(products, "products");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(sortField, "sortField");
        Intrinsics.checkNotNullParameter(shoppingList, "shoppingList");
        Intrinsics.checkNotNullParameter(favoriteIds, "favoriteIds");
        return new ProductListUiState(products, isLoading, isSyncing, syncProgress, error, query, supermarketFilter, excludeNata, sortField, selectedProduct, shoppingList, favoriteIds, showFavoritesOnly, nutriscoreFilter);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProductListUiState)) {
            return false;
        }
        ProductListUiState productListUiState = (ProductListUiState) other;
        return Intrinsics.areEqual(this.products, productListUiState.products) && this.isLoading == productListUiState.isLoading && this.isSyncing == productListUiState.isSyncing && Intrinsics.areEqual(this.syncProgress, productListUiState.syncProgress) && Intrinsics.areEqual(this.error, productListUiState.error) && Intrinsics.areEqual(this.query, productListUiState.query) && Intrinsics.areEqual(this.supermarketFilter, productListUiState.supermarketFilter) && this.excludeNata == productListUiState.excludeNata && this.sortField == productListUiState.sortField && Intrinsics.areEqual(this.selectedProduct, productListUiState.selectedProduct) && Intrinsics.areEqual(this.shoppingList, productListUiState.shoppingList) && Intrinsics.areEqual(this.favoriteIds, productListUiState.favoriteIds) && this.showFavoritesOnly == productListUiState.showFavoritesOnly && Intrinsics.areEqual(this.nutriscoreFilter, productListUiState.nutriscoreFilter);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((this.products.hashCode() * 31) + Boolean.hashCode(this.isLoading)) * 31) + Boolean.hashCode(this.isSyncing)) * 31) + (this.syncProgress == null ? 0 : this.syncProgress.hashCode())) * 31) + (this.error == null ? 0 : this.error.hashCode())) * 31) + this.query.hashCode()) * 31) + (this.supermarketFilter == null ? 0 : this.supermarketFilter.hashCode())) * 31) + Boolean.hashCode(this.excludeNata)) * 31) + this.sortField.hashCode()) * 31) + (this.selectedProduct == null ? 0 : this.selectedProduct.hashCode())) * 31) + this.shoppingList.hashCode()) * 31) + this.favoriteIds.hashCode()) * 31) + Boolean.hashCode(this.showFavoritesOnly)) * 31) + (this.nutriscoreFilter != null ? this.nutriscoreFilter.hashCode() : 0);
    }

    public String toString() {
        return "ProductListUiState(products=" + this.products + ", isLoading=" + this.isLoading + ", isSyncing=" + this.isSyncing + ", syncProgress=" + this.syncProgress + ", error=" + this.error + ", query=" + this.query + ", supermarketFilter=" + this.supermarketFilter + ", excludeNata=" + this.excludeNata + ", sortField=" + this.sortField + ", selectedProduct=" + this.selectedProduct + ", shoppingList=" + this.shoppingList + ", favoriteIds=" + this.favoriteIds + ", showFavoritesOnly=" + this.showFavoritesOnly + ", nutriscoreFilter=" + this.nutriscoreFilter + ")";
    }

    public ProductListUiState(List<Product> products, boolean isLoading, boolean isSyncing, String syncProgress, String error, String query, String supermarketFilter, boolean excludeNata, SortField sortField, Product selectedProduct, List<ShoppingListItem> shoppingList, Set<String> favoriteIds, boolean showFavoritesOnly, String nutriscoreFilter) {
        Intrinsics.checkNotNullParameter(products, "products");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(sortField, "sortField");
        Intrinsics.checkNotNullParameter(shoppingList, "shoppingList");
        Intrinsics.checkNotNullParameter(favoriteIds, "favoriteIds");
        this.products = products;
        this.isLoading = isLoading;
        this.isSyncing = isSyncing;
        this.syncProgress = syncProgress;
        this.error = error;
        this.query = query;
        this.supermarketFilter = supermarketFilter;
        this.excludeNata = excludeNata;
        this.sortField = sortField;
        this.selectedProduct = selectedProduct;
        this.shoppingList = shoppingList;
        this.favoriteIds = favoriteIds;
        this.showFavoritesOnly = showFavoritesOnly;
        this.nutriscoreFilter = nutriscoreFilter;
    }

    public /* synthetic */ ProductListUiState(List list, boolean z, boolean z2, String str, String str2, String str3, String str4, boolean z3, SortField sortField, Product product, List list2, Set set, boolean z4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? "" : str3, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? false : z3, (i & 256) != 0 ? SortField.SUGARS : sortField, (i & 512) != 0 ? null : product, (i & 1024) != 0 ? CollectionsKt.emptyList() : list2, (i & 2048) != 0 ? SetsKt.emptySet() : set, (i & 4096) == 0 ? z4 : false, (i & 8192) == 0 ? str5 : null);
    }

    public final List<Product> getProducts() {
        return this.products;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public final boolean isSyncing() {
        return this.isSyncing;
    }

    public final String getSyncProgress() {
        return this.syncProgress;
    }

    public final String getError() {
        return this.error;
    }

    public final String getQuery() {
        return this.query;
    }

    public final String getSupermarketFilter() {
        return this.supermarketFilter;
    }

    public final boolean getExcludeNata() {
        return this.excludeNata;
    }

    public final SortField getSortField() {
        return this.sortField;
    }

    public final Product getSelectedProduct() {
        return this.selectedProduct;
    }

    public final List<ShoppingListItem> getShoppingList() {
        return this.shoppingList;
    }

    public final Set<String> getFavoriteIds() {
        return this.favoriteIds;
    }

    public final boolean getShowFavoritesOnly() {
        return this.showFavoritesOnly;
    }

    public final String getNutriscoreFilter() {
        return this.nutriscoreFilter;
    }

    public final Set<String> getShoppingListIds() {
        Iterable $this$map$iv = this.shoppingList;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ShoppingListItem it = (ShoppingListItem) item$iv$iv;
            destination$iv$iv.add(it.getProduct().getId());
        }
        return CollectionsKt.toSet((List) destination$iv$iv);
    }

    public final int getShoppingCount() {
        int quantity = 0;
        for (ShoppingListItem it : this.shoppingList) {
            quantity += it.getQuantity();
        }
        return quantity;
    }
}
