package com.easycompra.app.data.pantry;

import android.content.Context;
import androidx.autofill.HintConstants;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: PantryRepository.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tJ\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\tJ>\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0017J>\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0017J\u0016\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0086@¢\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0086@¢\u0006\u0002\u0010\u001eJ\u001e\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010#J\u001e\u0010$\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020&H\u0086@¢\u0006\u0002\u0010'J\u0016\u0010(\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0086@¢\u0006\u0002\u0010\u001eJ\u0016\u0010)\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010*R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/easycompra/app/data/pantry/PantryRepository;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "dao", "Lcom/easycompra/app/data/pantry/PantryDao;", "observeAll", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/easycompra/app/data/pantry/PantryProductWithLocations;", "observeEmptyCount", "", "addProductWithLocation", "", HintConstants.AUTOFILL_HINT_NAME, "category", "subcategory", "description", "quantity", "", "unit", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addLocationToProduct", "", "productId", "increment", "location", "Lcom/easycompra/app/data/pantry/PantryLocationEntity;", "(Lcom/easycompra/app/data/pantry/PantryLocationEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "decrement", "setQuantity", "locationId", "qty", "(Ljava/lang/String;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setNeedsToBuy", "needs", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteLocation", "deleteProduct", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PantryRepository {
    public static final int $stable = 8;
    private final PantryDao dao;

    /* JADX INFO: renamed from: com.easycompra.app.data.pantry.PantryRepository$addProductWithLocation$1, reason: invalid class name */
    /* JADX INFO: compiled from: PantryRepository.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.data.pantry.PantryRepository", f = "PantryRepository.kt", i = {0, 0, 0, 0, 0, 0, 0, 1}, l = {23, 24}, m = "addProductWithLocation", n = {"this", "category", "subcategory", "description", "unit", "productId", "quantity", "productId"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "F$0", "L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        float F$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PantryRepository.this.addProductWithLocation(null, null, null, null, 0.0f, null, this);
        }
    }

    public PantryRepository(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.dao = PantryDatabase.INSTANCE.get(context).pantryDao();
    }

    public final Flow<List<PantryProductWithLocations>> observeAll() {
        return this.dao.observeAll();
    }

    public final Flow<Integer> observeEmptyCount() {
        return this.dao.observeEmptyCount();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object addProductWithLocation(String name, String category, String subcategory, String description, float quantity, String unit, Continuation<? super String> continuation) {
        AnonymousClass1 anonymousClass1;
        PantryRepository pantryRepository;
        String productId;
        float quantity2;
        String unit2;
        String description2;
        String subcategory2;
        String category2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object $result = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (anonymousClass1.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                pantryRepository = this;
                productId = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(productId, "toString(...)");
                PantryDao pantryDao = pantryRepository.dao;
                PantryProductEntity pantryProductEntity = new PantryProductEntity(productId, name, false, 0L, 12, null);
                anonymousClass1.L$0 = pantryRepository;
                anonymousClass1.L$1 = category;
                anonymousClass1.L$2 = subcategory;
                anonymousClass1.L$3 = description;
                anonymousClass1.L$4 = unit;
                anonymousClass1.L$5 = productId;
                anonymousClass1.F$0 = quantity;
                anonymousClass1.label = 1;
                if (pantryDao.insertProduct(pantryProductEntity, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                quantity2 = quantity;
                unit2 = unit;
                description2 = description;
                subcategory2 = subcategory;
                category2 = category;
                break;
                break;
            case 1:
                float quantity3 = anonymousClass1.F$0;
                productId = (String) anonymousClass1.L$5;
                String unit3 = (String) anonymousClass1.L$4;
                String description3 = (String) anonymousClass1.L$3;
                String subcategory3 = (String) anonymousClass1.L$2;
                String category3 = (String) anonymousClass1.L$1;
                pantryRepository = (PantryRepository) anonymousClass1.L$0;
                ResultKt.throwOnFailure($result);
                quantity2 = quantity3;
                unit2 = unit3;
                description2 = description3;
                subcategory2 = subcategory3;
                category2 = category3;
                break;
            case 2:
                String productId2 = (String) anonymousClass1.L$0;
                ResultKt.throwOnFailure($result);
                return productId2;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        PantryDao pantryDao2 = pantryRepository.dao;
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        PantryLocationEntity pantryLocationEntity = new PantryLocationEntity(string, productId, category2, subcategory2, description2, quantity2, unit2, 0L, 128, null);
        anonymousClass1.L$0 = productId;
        anonymousClass1.L$1 = null;
        anonymousClass1.L$2 = null;
        anonymousClass1.L$3 = null;
        anonymousClass1.L$4 = null;
        anonymousClass1.L$5 = null;
        anonymousClass1.label = 2;
        if (pantryDao2.insertLocation(pantryLocationEntity, anonymousClass1) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return productId;
    }

    public final Object addLocationToProduct(String productId, String category, String subcategory, String description, float quantity, String unit, Continuation<? super Unit> continuation) {
        PantryDao pantryDao = this.dao;
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Object objInsertLocation = pantryDao.insertLocation(new PantryLocationEntity(string, productId, category, subcategory, description, quantity, unit, 0L, 128, null), continuation);
        return objInsertLocation == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInsertLocation : Unit.INSTANCE;
    }

    public final Object increment(PantryLocationEntity location, Continuation<? super Unit> continuation) {
        Object objUpdateQuantity$default = PantryDao.DefaultImpls.updateQuantity$default(this.dao, location.getId(), location.getQuantity() + 1.0f, 0L, continuation, 4, null);
        return objUpdateQuantity$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateQuantity$default : Unit.INSTANCE;
    }

    public final Object decrement(PantryLocationEntity location, Continuation<? super Unit> continuation) {
        float newQty = RangesKt.coerceAtLeast(location.getQuantity() - 1.0f, 0.0f);
        Object objUpdateQuantity$default = PantryDao.DefaultImpls.updateQuantity$default(this.dao, location.getId(), newQty, 0L, continuation, 4, null);
        return objUpdateQuantity$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateQuantity$default : Unit.INSTANCE;
    }

    public final Object setQuantity(String locationId, float qty, Continuation<? super Unit> continuation) {
        Object objUpdateQuantity$default = PantryDao.DefaultImpls.updateQuantity$default(this.dao, locationId, RangesKt.coerceAtLeast(qty, 0.0f), 0L, continuation, 4, null);
        return objUpdateQuantity$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateQuantity$default : Unit.INSTANCE;
    }

    public final Object setNeedsToBuy(String productId, boolean needs, Continuation<? super Unit> continuation) {
        Object needsToBuy = this.dao.setNeedsToBuy(productId, needs, continuation);
        return needsToBuy == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? needsToBuy : Unit.INSTANCE;
    }

    public final Object deleteLocation(PantryLocationEntity location, Continuation<? super Unit> continuation) {
        Object objDeleteLocation = this.dao.deleteLocation(location, continuation);
        return objDeleteLocation == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteLocation : Unit.INSTANCE;
    }

    public final Object deleteProduct(String productId, Continuation<? super Unit> continuation) {
        Object objDeleteProduct = this.dao.deleteProduct(productId, continuation);
        return objDeleteProduct == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteProduct : Unit.INSTANCE;
    }
}
