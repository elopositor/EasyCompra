package com.easycompra.app.ui.recipes;

import com.easycompra.app.data.recipes.RecipeDifficulty;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: RecipeViewModel.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/easycompra/app/ui/recipes/RecipeFilter;", "", "label", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "ALL", "FAVORITES", "EASY", "MEDIUM", "HARD", "FAST", "SLOW", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public enum RecipeFilter {
    ALL("Todas"),
    FAVORITES("⭐ Favoritas"),
    EASY(RecipeDifficulty.EASY),
    MEDIUM(RecipeDifficulty.MEDIUM),
    HARD(RecipeDifficulty.HARD),
    FAST("<30 min"),
    SLOW(">60 min");

    private final String label;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    RecipeFilter(String label) {
        this.label = label;
    }

    public final String getLabel() {
        return this.label;
    }

    public static EnumEntries<RecipeFilter> getEntries() {
        return $ENTRIES;
    }
}
