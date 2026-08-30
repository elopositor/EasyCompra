package com.easycompra.app.ui.pantry;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: PantryViewModel.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"CATEGORY_ORDER", "", "", "getCATEGORY_ORDER", "()Ljava/util/List;", "app_debug"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PantryViewModelKt {
    private static final List<String> CATEGORY_ORDER = CollectionsKt.listOf((Object[]) new String[]{"Nevera", "Congelador", "Despensa", "Bebidas", "Otros", "Bebidas y Otros"});

    public static final List<String> getCATEGORY_ORDER() {
        return CATEGORY_ORDER;
    }
}
