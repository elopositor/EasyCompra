package com.easycompra.app.ui.recipes;

import com.easycompra.app.data.pantry.PantryProductWithLocations;
import com.easycompra.app.data.recipes.IngredientEntity;
import com.easycompra.app.data.recipes.RecipeDifficulty;
import com.easycompra.app.data.recipes.RecipeShoppingItem;
import com.easycompra.app.data.recipes.RecipeWithDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: RecipeViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010$\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\t\u0010.\u001a\u00020\bHÆ\u0003J\t\u0010/\u001a\u00020\nHÆ\u0003J\t\u00100\u001a\u00020\nHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003HÆ\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003HÆ\u0003J\u0085\u0001\u00106\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003HÆ\u0001J\u0013\u00107\u001a\u00020\n2\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020:HÖ\u0001J\t\u0010;\u001a\u00020\bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038F¢\u0006\u0006\u001a\u0004\b'\u0010\u0017R#\u0010(\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030)8F¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006<"}, d2 = {"Lcom/easycompra/app/ui/recipes/RecipeUiState;", "", "allRecipes", "", "Lcom/easycompra/app/data/recipes/RecipeWithDetails;", "filter", "Lcom/easycompra/app/ui/recipes/RecipeFilter;", "query", "", "searchActive", "", "showCreateEdit", "editingRecipe", "selectedRecipe", "cooking", "Lcom/easycompra/app/ui/recipes/CookingWorkflow;", "recipeShoppingItems", "Lcom/easycompra/app/data/recipes/RecipeShoppingItem;", "pantrySearchResults", "Lcom/easycompra/app/data/pantry/PantryProductWithLocations;", "<init>", "(Ljava/util/List;Lcom/easycompra/app/ui/recipes/RecipeFilter;Ljava/lang/String;ZZLcom/easycompra/app/data/recipes/RecipeWithDetails;Lcom/easycompra/app/data/recipes/RecipeWithDetails;Lcom/easycompra/app/ui/recipes/CookingWorkflow;Ljava/util/List;Ljava/util/List;)V", "getAllRecipes", "()Ljava/util/List;", "getFilter", "()Lcom/easycompra/app/ui/recipes/RecipeFilter;", "getQuery", "()Ljava/lang/String;", "getSearchActive", "()Z", "getShowCreateEdit", "getEditingRecipe", "()Lcom/easycompra/app/data/recipes/RecipeWithDetails;", "getSelectedRecipe", "getCooking", "()Lcom/easycompra/app/ui/recipes/CookingWorkflow;", "getRecipeShoppingItems", "getPantrySearchResults", "filtered", "getFiltered", "grouped", "", "getGrouped", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class RecipeUiState {
    public static final int $stable = 8;
    private final List<RecipeWithDetails> allRecipes;
    private final CookingWorkflow cooking;
    private final RecipeWithDetails editingRecipe;
    private final RecipeFilter filter;
    private final List<PantryProductWithLocations> pantrySearchResults;
    private final String query;
    private final List<RecipeShoppingItem> recipeShoppingItems;
    private final boolean searchActive;
    private final RecipeWithDetails selectedRecipe;
    private final boolean showCreateEdit;

    /* JADX INFO: compiled from: RecipeViewModel.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RecipeFilter.values().length];
            try {
                iArr[RecipeFilter.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[RecipeFilter.FAVORITES.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[RecipeFilter.EASY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[RecipeFilter.MEDIUM.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[RecipeFilter.HARD.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[RecipeFilter.FAST.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[RecipeFilter.SLOW.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public RecipeUiState() {
        this(null, null, null, false, false, null, null, null, null, null, 1023, null);
    }

    public final List<RecipeWithDetails> component1() {
        return this.allRecipes;
    }

    public final List<PantryProductWithLocations> component10() {
        return this.pantrySearchResults;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final RecipeFilter getFilter() {
        return this.filter;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getQuery() {
        return this.query;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getSearchActive() {
        return this.searchActive;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getShowCreateEdit() {
        return this.showCreateEdit;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final RecipeWithDetails getEditingRecipe() {
        return this.editingRecipe;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final RecipeWithDetails getSelectedRecipe() {
        return this.selectedRecipe;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final CookingWorkflow getCooking() {
        return this.cooking;
    }

    public final List<RecipeShoppingItem> component9() {
        return this.recipeShoppingItems;
    }

    public final RecipeUiState copy(List<RecipeWithDetails> allRecipes, RecipeFilter filter, String query, boolean searchActive, boolean showCreateEdit, RecipeWithDetails editingRecipe, RecipeWithDetails selectedRecipe, CookingWorkflow cooking, List<RecipeShoppingItem> recipeShoppingItems, List<PantryProductWithLocations> pantrySearchResults) {
        Intrinsics.checkNotNullParameter(allRecipes, "allRecipes");
        Intrinsics.checkNotNullParameter(filter, "filter");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(recipeShoppingItems, "recipeShoppingItems");
        Intrinsics.checkNotNullParameter(pantrySearchResults, "pantrySearchResults");
        return new RecipeUiState(allRecipes, filter, query, searchActive, showCreateEdit, editingRecipe, selectedRecipe, cooking, recipeShoppingItems, pantrySearchResults);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecipeUiState)) {
            return false;
        }
        RecipeUiState recipeUiState = (RecipeUiState) other;
        return Intrinsics.areEqual(this.allRecipes, recipeUiState.allRecipes) && this.filter == recipeUiState.filter && Intrinsics.areEqual(this.query, recipeUiState.query) && this.searchActive == recipeUiState.searchActive && this.showCreateEdit == recipeUiState.showCreateEdit && Intrinsics.areEqual(this.editingRecipe, recipeUiState.editingRecipe) && Intrinsics.areEqual(this.selectedRecipe, recipeUiState.selectedRecipe) && Intrinsics.areEqual(this.cooking, recipeUiState.cooking) && Intrinsics.areEqual(this.recipeShoppingItems, recipeUiState.recipeShoppingItems) && Intrinsics.areEqual(this.pantrySearchResults, recipeUiState.pantrySearchResults);
    }

    public int hashCode() {
        return (((((((((((((((((this.allRecipes.hashCode() * 31) + this.filter.hashCode()) * 31) + this.query.hashCode()) * 31) + Boolean.hashCode(this.searchActive)) * 31) + Boolean.hashCode(this.showCreateEdit)) * 31) + (this.editingRecipe == null ? 0 : this.editingRecipe.hashCode())) * 31) + (this.selectedRecipe == null ? 0 : this.selectedRecipe.hashCode())) * 31) + (this.cooking != null ? this.cooking.hashCode() : 0)) * 31) + this.recipeShoppingItems.hashCode()) * 31) + this.pantrySearchResults.hashCode();
    }

    public String toString() {
        return "RecipeUiState(allRecipes=" + this.allRecipes + ", filter=" + this.filter + ", query=" + this.query + ", searchActive=" + this.searchActive + ", showCreateEdit=" + this.showCreateEdit + ", editingRecipe=" + this.editingRecipe + ", selectedRecipe=" + this.selectedRecipe + ", cooking=" + this.cooking + ", recipeShoppingItems=" + this.recipeShoppingItems + ", pantrySearchResults=" + this.pantrySearchResults + ")";
    }

    public RecipeUiState(List<RecipeWithDetails> allRecipes, RecipeFilter filter, String query, boolean searchActive, boolean showCreateEdit, RecipeWithDetails editingRecipe, RecipeWithDetails selectedRecipe, CookingWorkflow cooking, List<RecipeShoppingItem> recipeShoppingItems, List<PantryProductWithLocations> pantrySearchResults) {
        Intrinsics.checkNotNullParameter(allRecipes, "allRecipes");
        Intrinsics.checkNotNullParameter(filter, "filter");
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(recipeShoppingItems, "recipeShoppingItems");
        Intrinsics.checkNotNullParameter(pantrySearchResults, "pantrySearchResults");
        this.allRecipes = allRecipes;
        this.filter = filter;
        this.query = query;
        this.searchActive = searchActive;
        this.showCreateEdit = showCreateEdit;
        this.editingRecipe = editingRecipe;
        this.selectedRecipe = selectedRecipe;
        this.cooking = cooking;
        this.recipeShoppingItems = recipeShoppingItems;
        this.pantrySearchResults = pantrySearchResults;
    }

    public /* synthetic */ RecipeUiState(List list, RecipeFilter recipeFilter, String str, boolean z, boolean z2, RecipeWithDetails recipeWithDetails, RecipeWithDetails recipeWithDetails2, CookingWorkflow cookingWorkflow, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? RecipeFilter.ALL : recipeFilter, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? false : z, (i & 16) == 0 ? z2 : false, (i & 32) != 0 ? null : recipeWithDetails, (i & 64) != 0 ? null : recipeWithDetails2, (i & 128) == 0 ? cookingWorkflow : null, (i & 256) != 0 ? CollectionsKt.emptyList() : list2, (i & 512) != 0 ? CollectionsKt.emptyList() : list3);
    }

    public final List<RecipeWithDetails> getAllRecipes() {
        return this.allRecipes;
    }

    public final RecipeFilter getFilter() {
        return this.filter;
    }

    public final String getQuery() {
        return this.query;
    }

    public final boolean getSearchActive() {
        return this.searchActive;
    }

    public final boolean getShowCreateEdit() {
        return this.showCreateEdit;
    }

    public final RecipeWithDetails getEditingRecipe() {
        return this.editingRecipe;
    }

    public final RecipeWithDetails getSelectedRecipe() {
        return this.selectedRecipe;
    }

    public final CookingWorkflow getCooking() {
        return this.cooking;
    }

    public final List<RecipeShoppingItem> getRecipeShoppingItems() {
        return this.recipeShoppingItems;
    }

    public final List<PantryProductWithLocations> getPantrySearchResults() {
        return this.pantrySearchResults;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0095  */
    /* JADX WARN: Code duplicated, block: B:91:0x0098 A[SYNTHETIC] */
    public final List<RecipeWithDetails> getFiltered() {
        List<RecipeWithDetails> list;
        List<RecipeWithDetails> list2;
        boolean z;
        boolean z2;
        List<RecipeWithDetails> list3 = this.allRecipes;
        if (!StringsKt.isBlank(this.query)) {
            List<RecipeWithDetails> $this$filter$iv = list3;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                RecipeWithDetails r = (RecipeWithDetails) element$iv$iv;
                if (StringsKt.contains((CharSequence) r.getRecipe().getName(), (CharSequence) this.query, true)) {
                    list2 = list3;
                } else {
                    Iterable $this$any$iv = r.getIngredients();
                    if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
                        list2 = list3;
                        z2 = false;
                    } else {
                        Iterator it = $this$any$iv.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                list2 = list3;
                                z2 = false;
                                break;
                            }
                            Object element$iv = it.next();
                            IngredientEntity it2 = (IngredientEntity) element$iv;
                            list2 = list3;
                            if (StringsKt.contains((CharSequence) it2.getName(), (CharSequence) this.query, true)) {
                                z2 = true;
                                break;
                            }
                            list3 = list2;
                        }
                    }
                    if (!z2) {
                        z = false;
                    }
                    if (z) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                    list3 = list2;
                }
                z = true;
                if (z) {
                    destination$iv$iv.add(element$iv$iv);
                }
                list3 = list2;
            }
            list3 = (List) destination$iv$iv;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[this.filter.ordinal()]) {
            case 1:
                list = list3;
                break;
            case 2:
                Iterable $this$filter$iv2 = list3;
                Collection destination$iv$iv2 = new ArrayList();
                for (Object element$iv$iv2 : $this$filter$iv2) {
                    RecipeWithDetails it3 = (RecipeWithDetails) element$iv$iv2;
                    if (it3.getRecipe().isFavorite()) {
                        destination$iv$iv2.add(element$iv$iv2);
                    }
                }
                list = (List) destination$iv$iv2;
                break;
            case 3:
                Iterable $this$filter$iv3 = list3;
                Collection destination$iv$iv3 = new ArrayList();
                for (Object element$iv$iv3 : $this$filter$iv3) {
                    RecipeWithDetails it4 = (RecipeWithDetails) element$iv$iv3;
                    if (Intrinsics.areEqual(it4.getRecipe().getDifficulty(), RecipeDifficulty.EASY)) {
                        destination$iv$iv3.add(element$iv$iv3);
                    }
                }
                list = (List) destination$iv$iv3;
                break;
            case 4:
                Iterable $this$filter$iv4 = list3;
                Collection destination$iv$iv4 = new ArrayList();
                for (Object element$iv$iv4 : $this$filter$iv4) {
                    RecipeWithDetails it5 = (RecipeWithDetails) element$iv$iv4;
                    if (Intrinsics.areEqual(it5.getRecipe().getDifficulty(), RecipeDifficulty.MEDIUM)) {
                        destination$iv$iv4.add(element$iv$iv4);
                    }
                }
                list = (List) destination$iv$iv4;
                break;
            case 5:
                Iterable $this$filter$iv5 = list3;
                Collection destination$iv$iv5 = new ArrayList();
                for (Object element$iv$iv5 : $this$filter$iv5) {
                    RecipeWithDetails it6 = (RecipeWithDetails) element$iv$iv5;
                    if (Intrinsics.areEqual(it6.getRecipe().getDifficulty(), RecipeDifficulty.HARD)) {
                        destination$iv$iv5.add(element$iv$iv5);
                    }
                }
                list = (List) destination$iv$iv5;
                break;
            case 6:
                Iterable $this$filter$iv6 = list3;
                Collection destination$iv$iv6 = new ArrayList();
                for (Object element$iv$iv6 : $this$filter$iv6) {
                    RecipeWithDetails it7 = (RecipeWithDetails) element$iv$iv6;
                    int prepTimeMinutes = it7.getRecipe().getPrepTimeMinutes();
                    if (1 <= prepTimeMinutes && prepTimeMinutes < 30) {
                        destination$iv$iv6.add(element$iv$iv6);
                    }
                }
                list = (List) destination$iv$iv6;
                break;
            case 7:
                Iterable $this$filter$iv7 = list3;
                Collection destination$iv$iv7 = new ArrayList();
                for (Object element$iv$iv7 : $this$filter$iv7) {
                    RecipeWithDetails it8 = (RecipeWithDetails) element$iv$iv7;
                    if (it8.getRecipe().getPrepTimeMinutes() > 60) {
                        destination$iv$iv7.add(element$iv$iv7);
                    }
                }
                list = (List) destination$iv$iv7;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return list;
    }

    public final Map<String, List<RecipeWithDetails>> getGrouped() {
        Object answer$iv$iv$iv;
        Iterable $this$groupBy$iv = getFiltered();
        Map destination$iv$iv = new LinkedHashMap();
        for (Object element$iv$iv : $this$groupBy$iv) {
            RecipeWithDetails it = (RecipeWithDetails) element$iv$iv;
            String category = it.getRecipe().getCategory();
            Object value$iv$iv$iv = destination$iv$iv.get(category);
            if (value$iv$iv$iv == null) {
                answer$iv$iv$iv = new ArrayList();
                destination$iv$iv.put(category, answer$iv$iv$iv);
            } else {
                answer$iv$iv$iv = value$iv$iv$iv;
            }
            List list$iv$iv = (List) answer$iv$iv$iv;
            list$iv$iv.add(element$iv$iv);
        }
        return destination$iv$iv;
    }
}
