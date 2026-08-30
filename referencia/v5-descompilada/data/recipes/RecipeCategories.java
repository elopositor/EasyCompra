package com.easycompra.app.data.recipes;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: RecipeConstants.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/easycompra/app/data/recipes/RecipeCategories;", "", "<init>", "()V", "all", "", "", "getAll", "()Ljava/util/List;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RecipeCategories {
    public static final RecipeCategories INSTANCE = new RecipeCategories();
    private static final List<String> all = CollectionsKt.listOf((Object[]) new String[]{"Desayunos", "Comidas rápidas", "Comidas elaboradas", "Cenas", "Postres", "Snacks", "Bebidas", "Otras"});
    public static final int $stable = 8;

    private RecipeCategories() {
    }

    public final List<String> getAll() {
        return all;
    }
}
