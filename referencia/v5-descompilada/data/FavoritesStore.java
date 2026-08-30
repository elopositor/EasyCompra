package com.easycompra.app.data;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FavoritesStore.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0014\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000bR\u0018\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/easycompra/app/data/FavoritesStore;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "Landroid/content/SharedPreferences;", "load", "", "", "save", "", "ids", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FavoritesStore {
    public static final int $stable = 8;
    private final SharedPreferences prefs;

    public FavoritesStore(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.prefs = context.getSharedPreferences("easycompra_prefs", 0);
    }

    public final Set<String> load() {
        Set<String> stringSet = this.prefs.getStringSet("favorites", SetsKt.emptySet());
        return stringSet == null ? SetsKt.emptySet() : stringSet;
    }

    public final void save(Set<String> ids) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        this.prefs.edit().putStringSet("favorites", ids).apply();
    }
}
