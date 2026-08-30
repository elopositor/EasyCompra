package com.easycompra.app.network;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* JADX INFO: compiled from: ApiServices.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/easycompra/app/network/MercadonaService;", "", "getCategoryProducts", "Lcom/easycompra/app/network/MercadonaCategoryResponse;", "categoryId", "", "lang", "", "warehouse", "(ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProductDetail", "Lcom/easycompra/app/network/MercadonaProductDetail;", "productId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MercadonaService {
    @GET("api/categories/{id}/")
    Object getCategoryProducts(@Path("id") int i, @Query("lang") String str, @Query("wh") String str2, Continuation<? super MercadonaCategoryResponse> continuation);

    @GET("api/products/{id}/")
    Object getProductDetail(@Path("id") String str, Continuation<? super MercadonaProductDetail> continuation);

    /* JADX INFO: compiled from: ApiServices.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object getCategoryProducts$default(MercadonaService mercadonaService, int i, String str, String str2, Continuation continuation, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCategoryProducts");
            }
            if ((i2 & 2) != 0) {
                str = "es";
            }
            if ((i2 & 4) != 0) {
                str2 = "mad1";
            }
            return mercadonaService.getCategoryProducts(i, str, str2, continuation);
        }
    }
}
