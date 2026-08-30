package com.easycompra.app.data;

import androidx.core.location.LocationRequestCompat;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: ProductRepository.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0002\"\u001d\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"MERCADONA_CATEGORIES", "", "", "", "getMERCADONA_CATEGORIES", "()Ljava/util/Map;", "NATA_REGEX", "Lkotlin/text/Regex;", "stripHtml", "html", "app_debug"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ProductRepositoryKt {
    private static final Map<Integer, String> MERCADONA_CATEGORIES = MapsKt.mapOf(TuplesKt.to(103, "Yogures desnatados"), TuplesKt.to(Integer.valueOf(LocationRequestCompat.QUALITY_LOW_POWER), "Yogures naturales"), TuplesKt.to(105, "Bífidus"), TuplesKt.to(106, "Postres de soja"), TuplesKt.to(108, "Yogures líquidos y kéfir"), TuplesKt.to(109, "Yogures griegos"), TuplesKt.to(110, "Flan y natillas"), TuplesKt.to(72, "Leche y bebidas vegetales"), TuplesKt.to(75, "Mantequilla y margarina"), TuplesKt.to(77, "Huevos"), TuplesKt.to(53, "Queso untable y fresco"), TuplesKt.to(54, "Queso curado y semicurado"), TuplesKt.to(56, "Queso lonchas y rallado"), TuplesKt.to(78, "Cereales"), TuplesKt.to(80, "Galletas"), TuplesKt.to(90, "Mermelada y miel"), TuplesKt.to(122, "Atún y conservas de pescado"), TuplesKt.to(123, "Berberechos y mejillones"), TuplesKt.to(43, "Embutido"), TuplesKt.to(50, "Jamón serrano"), TuplesKt.to(51, "Embutido curado"), TuplesKt.to(52, "Bacón y salchichas"), TuplesKt.to(58, "Paté y sobrasada"), TuplesKt.to(118, "Arroz"), TuplesKt.to(120, "Pasta y fideos"), TuplesKt.to(121, "Legumbres"), TuplesKt.to(Integer.valueOf(WebSocketProtocol.PAYLOAD_SHORT), "Tomate"), TuplesKt.to(127, "Conservas de verdura y frutas"), TuplesKt.to(132, "Patatas fritas y snacks"), TuplesKt.to(133, "Frutos secos y fruta desecada"));
    private static final Regex NATA_REGEX = new Regex("\\bnata\\b", RegexOption.IGNORE_CASE);

    public static final Map<Integer, String> getMERCADONA_CATEGORIES() {
        return MERCADONA_CATEGORIES;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String stripHtml(String html) {
        if (html != null) {
            String strReplace = new Regex("<[^>]+>").replace(html, "");
            return strReplace == null ? "" : strReplace;
        }
        return "";
    }
}
