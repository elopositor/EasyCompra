package com.easycompra.app.data.pantry;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: PantryDao.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H'J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH§@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ\u0016\u0010\u0010\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH§@¢\u0006\u0002\u0010\u000eJ(\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017H§@¢\u0006\u0002\u0010\u0018J\u001e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH§@¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH§@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H§@¢\u0006\u0002\u0010\u001fJ\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0003H'J\u0018\u0010\"\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0013H§@¢\u0006\u0002\u0010\u001fJ\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010$\u001a\u00020\u0013H§@¢\u0006\u0002\u0010\u001fJ\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H§@¢\u0006\u0002\u0010&¨\u0006'"}, d2 = {"Lcom/easycompra/app/data/pantry/PantryDao;", "", "observeAll", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/easycompra/app/data/pantry/PantryProductWithLocations;", "insertProduct", "", "product", "Lcom/easycompra/app/data/pantry/PantryProductEntity;", "(Lcom/easycompra/app/data/pantry/PantryProductEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertLocation", "location", "Lcom/easycompra/app/data/pantry/PantryLocationEntity;", "(Lcom/easycompra/app/data/pantry/PantryLocationEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateProduct", "updateLocation", "updateQuantity", "id", "", "qty", "", "ts", "", "(Ljava/lang/String;FJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setNeedsToBuy", "needs", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteLocation", "deleteProduct", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeEmptyCount", "", "getProductWithLocations", "searchByName", "query", "getAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface PantryDao {
    Object deleteLocation(PantryLocationEntity pantryLocationEntity, Continuation<? super Unit> continuation);

    Object deleteProduct(String str, Continuation<? super Unit> continuation);

    Object getAll(Continuation<? super List<PantryProductWithLocations>> continuation);

    Object getProductWithLocations(String str, Continuation<? super PantryProductWithLocations> continuation);

    Object insertLocation(PantryLocationEntity pantryLocationEntity, Continuation<? super Unit> continuation);

    Object insertProduct(PantryProductEntity pantryProductEntity, Continuation<? super Unit> continuation);

    Flow<List<PantryProductWithLocations>> observeAll();

    Flow<Integer> observeEmptyCount();

    Object searchByName(String str, Continuation<? super List<PantryProductWithLocations>> continuation);

    Object setNeedsToBuy(String str, boolean z, Continuation<? super Unit> continuation);

    Object updateLocation(PantryLocationEntity pantryLocationEntity, Continuation<? super Unit> continuation);

    Object updateProduct(PantryProductEntity pantryProductEntity, Continuation<? super Unit> continuation);

    Object updateQuantity(String str, float f, long j, Continuation<? super Unit> continuation);

    /* JADX INFO: compiled from: PantryDao.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object updateQuantity$default(PantryDao pantryDao, String str, float f, long j, Continuation continuation, int i, Object obj) {
            long jCurrentTimeMillis;
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateQuantity");
            }
            if ((i & 4) == 0) {
                jCurrentTimeMillis = j;
            } else {
                jCurrentTimeMillis = System.currentTimeMillis();
            }
            return pantryDao.updateQuantity(str, f, jCurrentTimeMillis, continuation);
        }
    }
}
