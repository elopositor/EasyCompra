package com.easycompra.app.data.pantry;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: compiled from: PantryLocationEntity.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R#\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/easycompra/app/data/pantry/PantryCategories;", "", "<init>", "()V", "all", "", "", "", "getAll", "()Ljava/util/Map;", "units", "getUnits", "()Ljava/util/List;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PantryCategories {
    public static final PantryCategories INSTANCE = new PantryCategories();
    private static final Map<String, List<String>> all = MapsKt.mapOf(TuplesKt.to("Nevera", CollectionsKt.listOf((Object[]) new String[]{"Lácteos", "Carnes", "Pescados y Mariscos", "Verduras y Frutas", "Quesos y Embutidos", "Huevos", "Platos preparados", "Otros"})), TuplesKt.to("Congelador", CollectionsKt.listOf((Object[]) new String[]{"Carnes", "Pescados", "Verduras y Frutas", "Precocinados", "Helados", "Otros"})), TuplesKt.to("Despensa", CollectionsKt.listOf((Object[]) new String[]{"Harinas y Cereales", "Pasta y Arroces", "Legumbres", "Conservas", "Salsas y Condimentos", "Especias", "Aceites y Vinagres", "Frutos secos", "Dulces y Snacks", "Pan y Bollería", "Otros"})), TuplesKt.to("Bebidas", CollectionsKt.listOf((Object[]) new String[]{"Agua", "Zumos", "Refrescos", "Bebidas alcohólicas", "Infusiones y Café", "Otros"})), TuplesKt.to("Otros", CollectionsKt.listOf((Object[]) new String[]{"Higiene personal", "Limpieza del hogar", "Mascotas", "Farmacia", "Varios"})), TuplesKt.to("Bebidas y Otros", CollectionsKt.listOf((Object[]) new String[]{"Bebidas", "Varios"})));
    private static final List<String> units = CollectionsKt.listOf((Object[]) new String[]{"unidad", "ración", "g", "kg", "ml", "l", "lata", "bote", "paquete", "caja", "bolsa", "botella", "docena", "taza", "cucharada"});
    public static final int $stable = 8;

    private PantryCategories() {
    }

    public final Map<String, List<String>> getAll() {
        return all;
    }

    public final List<String> getUnits() {
        return units;
    }
}
