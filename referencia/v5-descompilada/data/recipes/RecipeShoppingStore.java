package com.easycompra.app.data.recipes;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecipeShoppingStore.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0014\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0006\u0010\u0010\u001a\u00020\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/easycompra/app/data/recipes/RecipeShoppingStore;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "file", "Ljava/io/File;", "gson", "Lcom/google/gson/Gson;", "load", "", "Lcom/easycompra/app/data/recipes/RecipeShoppingItem;", "save", "", "items", "clear", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RecipeShoppingStore {
    public static final int $stable = 8;
    private final File file;
    private final Gson gson;

    public RecipeShoppingStore(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File filesDir = context.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "getFilesDir(...)");
        this.file = FilesKt.resolve(filesDir, "recipe_shopping.json");
        this.gson = new Gson();
    }

    public final List<RecipeShoppingItem> load() {
        if (!this.file.exists()) {
            return CollectionsKt.emptyList();
        }
        try {
            Type type = new TypeToken<List<? extends RecipeShoppingItem>>() { // from class: com.easycompra.app.data.recipes.RecipeShoppingStore$load$type$1
            }.getType();
            List<RecipeShoppingItem> list = (List) this.gson.fromJson(FilesKt.readText$default(this.file, null, 1, null), type);
            return list == null ? CollectionsKt.emptyList() : list;
        } catch (Exception e) {
            return CollectionsKt.emptyList();
        }
    }

    public final void save(List<RecipeShoppingItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        File file = this.file;
        String json = this.gson.toJson(items);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        FilesKt.writeText$default(file, json, null, 2, null);
    }

    public final void clear() {
        save(CollectionsKt.emptyList());
    }
}
