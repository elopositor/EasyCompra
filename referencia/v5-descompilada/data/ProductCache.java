package com.easycompra.app.data;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ProductCache.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u000e\u001a\u00020\u000fJ\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011R\u0018\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/easycompra/app/data/ProductCache;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "dir", "Ljava/io/File;", "kotlin.jvm.PlatformType", "Ljava/io/File;", "gson", "Lcom/google/gson/Gson;", "save", "", "key", "", "products", "", "Lcom/easycompra/app/data/Product;", "load", "loadAll", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProductCache {
    public static final int $stable = 8;
    private final File dir;
    private final Gson gson;

    public ProductCache(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.dir = context.getFilesDir();
        this.gson = new Gson();
    }

    public final void save(String key, List<Product> products) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(products, "products");
        File dir = this.dir;
        Intrinsics.checkNotNullExpressionValue(dir, "dir");
        File fileResolve = FilesKt.resolve(dir, key + ".json");
        String json = this.gson.toJson(products);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        FilesKt.writeText$default(fileResolve, json, null, 2, null);
    }

    public final List<Product> load(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        File dir = this.dir;
        Intrinsics.checkNotNullExpressionValue(dir, "dir");
        File file = FilesKt.resolve(dir, key + ".json");
        if (!file.exists()) {
            return CollectionsKt.emptyList();
        }
        try {
            Type type = new TypeToken<List<? extends Product>>() { // from class: com.easycompra.app.data.ProductCache$load$type$1
            }.getType();
            List<Product> list = (List) this.gson.fromJson(FilesKt.readText$default(file, null, 1, null), type);
            return list == null ? CollectionsKt.emptyList() : list;
        } catch (Exception e) {
            return CollectionsKt.emptyList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean loadAll$lambda$0(File f) {
        String name = f.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return StringsKt.endsWith$default(name, ".json", false, 2, (Object) null);
    }

    public final List<Product> loadAll() {
        File[] fileArrListFiles = this.dir.listFiles(new FileFilter() { // from class: com.easycompra.app.data.ProductCache$$ExternalSyntheticLambda0
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                return ProductCache.loadAll$lambda$0(file);
            }
        });
        if (fileArrListFiles == null) {
            return CollectionsKt.emptyList();
        }
        Collection destination$iv$iv = new ArrayList();
        for (File file : fileArrListFiles) {
            Intrinsics.checkNotNull(file);
            Iterable list$iv$iv = load(FilesKt.getNameWithoutExtension(file));
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        return (List) destination$iv$iv;
    }
}
