package com.easycompra.app.ui.list;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: ProductListViewModel.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/easycompra/app/ui/list/SortField;", "", "label", "", "displayUnit", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "getDisplayUnit", "SUGARS", "CALORIES", "FAT", "PROTEINS", "PRICE", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public enum SortField {
    SUGARS("Azúcares", "g/100g"),
    CALORIES("Calorías", "kcal/100g"),
    FAT("Grasas", "g/100g"),
    PROTEINS("Proteínas", "g/100g"),
    PRICE("Precio", "€");

    private final String displayUnit;
    private final String label;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    SortField(String label, String displayUnit) {
        this.label = label;
        this.displayUnit = displayUnit;
    }

    public final String getDisplayUnit() {
        return this.displayUnit;
    }

    public final String getLabel() {
        return this.label;
    }

    public static EnumEntries<SortField> getEntries() {
        return $ENTRIES;
    }
}
