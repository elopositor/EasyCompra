package com.easycompra.app.data;

import com.easycompra.app.network.ApiClients;
import com.easycompra.app.network.CloudProduct;
import com.easycompra.app.network.CloudService;
import com.easycompra.app.network.DiaNutrientEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ProductRepository.kt */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0011\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fJ\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/easycompra/app/data/ProductRepository;", "", "cache", "Lcom/easycompra/app/data/ProductCache;", "<init>", "(Lcom/easycompra/app/data/ProductCache;)V", "syncMercadonaCategory", "", "Lcom/easycompra/app/data/Product;", "categoryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncDiaSearch", "query", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncFromCloud", "supermarket", "loadCached", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProductRepository {
    public static final int $stable = 8;
    private final ProductCache cache;

    /* JADX INFO: renamed from: com.easycompra.app.data.ProductRepository$syncDiaSearch$1, reason: invalid class name */
    /* JADX INFO: compiled from: ProductRepository.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.data.ProductRepository", f = "ProductRepository.kt", i = {0, 0, 1, 1, 1, 1}, l = {120, 124}, m = "syncDiaSearch", n = {"this", "query", "this", "query", "products", "item"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$4"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProductRepository.this.syncDiaSearch(null, this);
        }
    }

    /* JADX INFO: renamed from: com.easycompra.app.data.ProductRepository$syncFromCloud$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ProductRepository.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.data.ProductRepository", f = "ProductRepository.kt", i = {0, 0}, l = {181}, m = "syncFromCloud", n = {"this", "supermarket"}, s = {"L$0", "L$1"})
    static final class C07081 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C07081(Continuation<? super C07081> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProductRepository.this.syncFromCloud(null, this);
        }
    }

    /* JADX INFO: renamed from: com.easycompra.app.data.ProductRepository$syncMercadonaCategory$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ProductRepository.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.data.ProductRepository", f = "ProductRepository.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {52, 57, 70, 84}, m = "syncMercadonaCategory", n = {"this", "categoryId", "this", "products", "categoryId", "this", "products", "detail", "ean", "energyKcal", "fat", "saturatedFat", "carbs", "sugars", "proteins", "salt", "categoryId", "this", "products", "detail", "ean", "nutriscoreGrade", "energyKcal", "fat", "saturatedFat", "carbs", "sugars", "proteins", "salt", "categoryId"}, s = {"L$0", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0", "L$0", "L$1", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "I$0"})
    static final class C07091 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        C07091(Continuation<? super C07091> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ProductRepository.this.syncMercadonaCategory(0, this);
        }
    }

    public ProductRepository(ProductCache cache) {
        Intrinsics.checkNotNullParameter(cache, "cache");
        this.cache = cache;
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0436 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:104:0x0437  */
    /* JADX WARN: Code duplicated, block: B:108:0x045f  */
    /* JADX WARN: Code duplicated, block: B:115:0x048a  */
    /* JADX WARN: Code duplicated, block: B:126:0x04be A[Catch: Exception -> 0x0586, TryCatch #19 {Exception -> 0x0586, blocks: (B:124:0x04a6, B:126:0x04be, B:128:0x04c7, B:130:0x04cd, B:132:0x04d5, B:135:0x04df, B:137:0x04e7, B:139:0x04ed, B:141:0x04f6, B:143:0x04fc, B:145:0x0502, B:147:0x050b, B:149:0x0511, B:151:0x051a, B:153:0x0522, B:155:0x0528, B:134:0x04db), top: B:212:0x04a6 }] */
    /* JADX WARN: Code duplicated, block: B:127:0x04c5  */
    /* JADX WARN: Code duplicated, block: B:130:0x04cd A[Catch: Exception -> 0x0586, TryCatch #19 {Exception -> 0x0586, blocks: (B:124:0x04a6, B:126:0x04be, B:128:0x04c7, B:130:0x04cd, B:132:0x04d5, B:135:0x04df, B:137:0x04e7, B:139:0x04ed, B:141:0x04f6, B:143:0x04fc, B:145:0x0502, B:147:0x050b, B:149:0x0511, B:151:0x051a, B:153:0x0522, B:155:0x0528, B:134:0x04db), top: B:212:0x04a6 }] */
    /* JADX WARN: Code duplicated, block: B:134:0x04db A[Catch: Exception -> 0x0586, TryCatch #19 {Exception -> 0x0586, blocks: (B:124:0x04a6, B:126:0x04be, B:128:0x04c7, B:130:0x04cd, B:132:0x04d5, B:135:0x04df, B:137:0x04e7, B:139:0x04ed, B:141:0x04f6, B:143:0x04fc, B:145:0x0502, B:147:0x050b, B:149:0x0511, B:151:0x051a, B:153:0x0522, B:155:0x0528, B:134:0x04db), top: B:212:0x04a6 }] */
    /* JADX WARN: Code duplicated, block: B:137:0x04e7 A[Catch: Exception -> 0x0586, TryCatch #19 {Exception -> 0x0586, blocks: (B:124:0x04a6, B:126:0x04be, B:128:0x04c7, B:130:0x04cd, B:132:0x04d5, B:135:0x04df, B:137:0x04e7, B:139:0x04ed, B:141:0x04f6, B:143:0x04fc, B:145:0x0502, B:147:0x050b, B:149:0x0511, B:151:0x051a, B:153:0x0522, B:155:0x0528, B:134:0x04db), top: B:212:0x04a6 }] */
    /* JADX WARN: Code duplicated, block: B:140:0x04f4  */
    /* JADX WARN: Code duplicated, block: B:143:0x04fc A[Catch: Exception -> 0x0586, TryCatch #19 {Exception -> 0x0586, blocks: (B:124:0x04a6, B:126:0x04be, B:128:0x04c7, B:130:0x04cd, B:132:0x04d5, B:135:0x04df, B:137:0x04e7, B:139:0x04ed, B:141:0x04f6, B:143:0x04fc, B:145:0x0502, B:147:0x050b, B:149:0x0511, B:151:0x051a, B:153:0x0522, B:155:0x0528, B:134:0x04db), top: B:212:0x04a6 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x0509  */
    /* JADX WARN: Code duplicated, block: B:149:0x0511 A[Catch: Exception -> 0x0586, TryCatch #19 {Exception -> 0x0586, blocks: (B:124:0x04a6, B:126:0x04be, B:128:0x04c7, B:130:0x04cd, B:132:0x04d5, B:135:0x04df, B:137:0x04e7, B:139:0x04ed, B:141:0x04f6, B:143:0x04fc, B:145:0x0502, B:147:0x050b, B:149:0x0511, B:151:0x051a, B:153:0x0522, B:155:0x0528, B:134:0x04db), top: B:212:0x04a6 }] */
    /* JADX WARN: Code duplicated, block: B:150:0x0518  */
    /* JADX WARN: Code duplicated, block: B:153:0x0522 A[Catch: Exception -> 0x0586, TryCatch #19 {Exception -> 0x0586, blocks: (B:124:0x04a6, B:126:0x04be, B:128:0x04c7, B:130:0x04cd, B:132:0x04d5, B:135:0x04df, B:137:0x04e7, B:139:0x04ed, B:141:0x04f6, B:143:0x04fc, B:145:0x0502, B:147:0x050b, B:149:0x0511, B:151:0x051a, B:153:0x0522, B:155:0x0528, B:134:0x04db), top: B:212:0x04a6 }] */
    /* JADX WARN: Code duplicated, block: B:154:0x0527  */
    /* JADX WARN: Code duplicated, block: B:180:0x0200 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:184:0x026c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:215:0x047c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0186  */
    /* JADX WARN: Code duplicated, block: B:40:0x01bd A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x01be  */
    /* JADX WARN: Code duplicated, block: B:61:0x0241 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:62:0x0242  */
    /* JADX WARN: Code duplicated, block: B:68:0x0272 A[Catch: Exception -> 0x02d2, TRY_LEAVE, TryCatch #5 {Exception -> 0x02d2, blocks: (B:66:0x026c, B:68:0x0272), top: B:184:0x026c }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0277  */
    /* JADX WARN: Code duplicated, block: B:73:0x027e A[Catch: Exception -> 0x02c6, TryCatch #18 {Exception -> 0x02c6, blocks: (B:71:0x0278, B:73:0x027e, B:75:0x0284), top: B:210:0x0278 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:81:0x02dc  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 18, insn: 0x0105: MOVE (r6 I:??[OBJECT, ARRAY]) = (r18 I:??[OBJECT, ARRAY]), block:B:24:0x0105 */
    /* JADX WARN: Not initialized variable reg: 19, insn: 0x0107: MOVE (r5 I:??[OBJECT, ARRAY]) = (r19 I:??[OBJECT, ARRAY] A[D('products' java.util.List)]), block:B:24:0x0105 */
    /* JADX WARN: Not initialized variable reg: 20, insn: 0x0109: MOVE (r4 I:??[OBJECT, ARRAY]) = (r20 I:??[OBJECT, ARRAY] A[D('this' com.easycompra.app.data.ProductRepository)]), block:B:24:0x0105 */
    /* JADX WARN: Type inference failed for: r1v12, types: [T, java.lang.Double] */
    /* JADX WARN: Type inference failed for: r1v13, types: [T, java.lang.Double] */
    /* JADX WARN: Type inference failed for: r1v14, types: [T, java.lang.Double] */
    /* JADX WARN: Type inference failed for: r1v15, types: [T, java.lang.Double] */
    /* JADX WARN: Type inference failed for: r1v16, types: [T, java.lang.Double] */
    /* JADX WARN: Type inference failed for: r1v17, types: [T, java.lang.Double] */
    /* JADX WARN: Type inference failed for: r1v18, types: [T, java.lang.Double] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:104:0x0437 -> B:105:0x0441). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x045f -> B:196:0x0476). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:171:0x05d8 -> B:35:0x0180). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object syncMercadonaCategory(int r48, kotlin.coroutines.Continuation<? super java.util.List<com.easycompra.app.data.Product>> r49) {
        /*
            Method dump skipped, instruction units count: 1544
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easycompra.app.data.ProductRepository.syncMercadonaCategory(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:24:0x009c  */
    /* JADX WARN: Code duplicated, block: B:27:0x00c0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:28:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:35:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:39:0x00f8 A[Catch: Exception -> 0x00db, TRY_ENTER, TryCatch #2 {Exception -> 0x00db, blocks: (B:31:0x00d6, B:39:0x00f8, B:41:0x00fe, B:45:0x012f), top: B:90:0x00d6 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x012f A[Catch: Exception -> 0x00db, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x00db, blocks: (B:31:0x00d6, B:39:0x00f8, B:41:0x00fe, B:45:0x012f), top: B:90:0x00d6 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x0135 A[Catch: Exception -> 0x0237, TRY_ENTER, TryCatch #3 {Exception -> 0x0237, blocks: (B:29:0x00c9, B:36:0x00e3, B:43:0x0112, B:48:0x0139, B:51:0x0147, B:47:0x0135), top: B:92:0x00c9 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x0147 A[Catch: Exception -> 0x0237, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x0237, blocks: (B:29:0x00c9, B:36:0x00e3, B:43:0x0112, B:48:0x0139, B:51:0x0147, B:47:0x0135), top: B:92:0x00c9 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x0167  */
    /* JADX WARN: Code duplicated, block: B:58:0x0171 A[Catch: Exception -> 0x022f, TryCatch #1 {Exception -> 0x022f, blocks: (B:54:0x0153, B:56:0x016b, B:58:0x0171, B:60:0x017a, B:62:0x0180, B:64:0x0189, B:66:0x018f, B:68:0x0198, B:70:0x01f2, B:72:0x020a, B:76:0x0214), top: B:88:0x0153 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0178  */
    /* JADX WARN: Code duplicated, block: B:62:0x0180 A[Catch: Exception -> 0x022f, TryCatch #1 {Exception -> 0x022f, blocks: (B:54:0x0153, B:56:0x016b, B:58:0x0171, B:60:0x017a, B:62:0x0180, B:64:0x0189, B:66:0x018f, B:68:0x0198, B:70:0x01f2, B:72:0x020a, B:76:0x0214), top: B:88:0x0153 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0187  */
    /* JADX WARN: Code duplicated, block: B:66:0x018f A[Catch: Exception -> 0x022f, TryCatch #1 {Exception -> 0x022f, blocks: (B:54:0x0153, B:56:0x016b, B:58:0x0171, B:60:0x017a, B:62:0x0180, B:64:0x0189, B:66:0x018f, B:68:0x0198, B:70:0x01f2, B:72:0x020a, B:76:0x0214), top: B:88:0x0153 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x0196  */
    /* JADX WARN: Code duplicated, block: B:70:0x01f2 A[Catch: Exception -> 0x022f, TryCatch #1 {Exception -> 0x022f, blocks: (B:54:0x0153, B:56:0x016b, B:58:0x0171, B:60:0x017a, B:62:0x0180, B:64:0x0189, B:66:0x018f, B:68:0x0198, B:70:0x01f2, B:72:0x020a, B:76:0x0214), top: B:88:0x0153 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0208  */
    /* JADX WARN: Code duplicated, block: B:74:0x020e  */
    /* JADX WARN: Code duplicated, block: B:75:0x0211  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:90:0x00d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00c1 -> B:92:0x00c9). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:83:0x0240 -> B:22:0x0096). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object syncDiaSearch(java.lang.String r40, kotlin.coroutines.Continuation<? super java.util.List<com.easycompra.app.data.Product>> r41) {
        /*
            Method dump skipped, instruction units count: 628
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easycompra.app.data.ProductRepository.syncDiaSearch(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static final void syncDiaSearch$lambda$3$processEntries(Map<String, Double> map, List<DiaNutrientEntry> list) {
        String strReplace$default;
        String title;
        if (list != null) {
            List<DiaNutrientEntry> $this$forEach$iv = list;
            for (Object element$iv : $this$forEach$iv) {
                DiaNutrientEntry entry = (DiaNutrientEntry) element$iv;
                String title2 = entry.getTitle();
                if (title2 != null && (strReplace$default = StringsKt.replace$default(title2, " ", " ", false, 4, (Object) null)) != null && (title = StringsKt.trim((CharSequence) strReplace$default).toString()) != null) {
                    switch (title.hashCode()) {
                        case -1174883075:
                            if (title.equals("Hidratos de Carbono")) {
                                map.put("carbs", entry.getValuePer100g());
                            }
                            break;
                        case -984044473:
                            if (title.equals("de los cuales azúcares")) {
                                map.put("sugars", entry.getValuePer100g());
                            }
                            break;
                        case 82878:
                            if (title.equals("Sal")) {
                                map.put("salt", entry.getValuePer100g());
                            }
                            break;
                        case 1399533521:
                            if (title.equals("Proteínas")) {
                                map.put("proteins", entry.getValuePer100g());
                            }
                            break;
                        case 1566177092:
                            if (title.equals("de las cuales saturadas")) {
                                map.put("saturated_fat", entry.getValuePer100g());
                            }
                            break;
                        case 2140954479:
                            if (title.equals("Grasas")) {
                                map.put("fat", entry.getValuePer100g());
                            }
                            break;
                    }
                    syncDiaSearch$lambda$3$processEntries(map, entry.getItems());
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object syncFromCloud(String str, Continuation<? super List<Product>> continuation) {
        C07081 c07081;
        String supermarket;
        Object products$default;
        ProductRepository productRepository;
        if (continuation instanceof C07081) {
            c07081 = (C07081) continuation;
            if ((c07081.label & Integer.MIN_VALUE) != 0) {
                c07081.label -= Integer.MIN_VALUE;
            } else {
                c07081 = new C07081(continuation);
            }
        } else {
            c07081 = new C07081(continuation);
        }
        Object $result = c07081.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c07081.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                supermarket = str;
                CloudService cloud = ApiClients.INSTANCE.getCloud();
                if (cloud == null) {
                    return CollectionsKt.emptyList();
                }
                c07081.L$0 = this;
                c07081.L$1 = supermarket;
                c07081.label = 1;
                products$default = CloudService.DefaultImpls.getProducts$default(cloud, supermarket, null, c07081, 2, null);
                if (products$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                productRepository = this;
                break;
                break;
            case 1:
                String supermarket2 = (String) c07081.L$1;
                productRepository = (ProductRepository) c07081.L$0;
                ResultKt.throwOnFailure($result);
                supermarket = supermarket2;
                products$default = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Iterable cloudProducts = (List) products$default;
        Iterable $this$map$iv = cloudProducts;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            CloudProduct cp = (CloudProduct) item$iv$iv;
            String lowerCase = cp.getSupermarket().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            destination$iv$iv.add(new Product(lowerCase + "_" + cp.getExternal_id(), cp.getSupermarket(), cp.getName(), cp.getBrand(), cp.getPhoto_url(), cp.getUnit_price(), cp.getReference_price(), cp.getReference_format(), null, cp.getIngredients(), null, cp.getContains_nata(), cp.getNutriscore_grade(), cp.getEnergy_kcal_100g(), cp.getFat_100g(), cp.getSaturated_fat_100g(), cp.getCarbohydrates_100g(), cp.getSugars_100g(), cp.getProteins_100g(), cp.getSalt_100g(), cp.getShare_url()));
            c07081 = c07081;
        }
        List products = (List) destination$iv$iv;
        if (!products.isEmpty()) {
            productRepository.cache.save("cloud_" + supermarket, products);
        }
        return products;
    }

    public final List<Product> loadCached() {
        return this.cache.loadAll();
    }
}
