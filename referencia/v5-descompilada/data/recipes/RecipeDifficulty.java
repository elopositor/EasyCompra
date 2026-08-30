package com.easycompra.app.data.recipes;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: RecipeConstants.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/easycompra/app/data/recipes/RecipeDifficulty;", "", "<init>", "()V", "EASY", "", "MEDIUM", "HARD", "all", "", "getAll", "()Ljava/util/List;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RecipeDifficulty {
    public static final RecipeDifficulty INSTANCE = new RecipeDifficulty();
    public static final String EASY = "Fácil";
    public static final String MEDIUM = "Media";
    public static final String HARD = "Difícil";
    private static final List<String> all = CollectionsKt.listOf((Object[]) new String[]{EASY, MEDIUM, HARD});
    public static final int $stable = 8;

    private RecipeDifficulty() {
    }

    public final List<String> getAll() {
        return all;
    }
}
