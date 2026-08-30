package com.easycompra.app.network;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* JADX INFO: compiled from: ApiServices.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/easycompra/app/network/DiaService;", "", "searchProducts", "Lcom/easycompra/app/network/DiaSearchResponse;", "query", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProductDetail", "Lcom/easycompra/app/network/DiaDetailResponse;", "productId", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface DiaService {
    @GET("api/v1/pdp-back/{id}")
    Object getProductDetail(@Path("id") String str, Continuation<? super DiaDetailResponse> continuation);

    @GET("api/v1/search-back/search")
    Object searchProducts(@Query("q") String str, Continuation<? super DiaSearchResponse> continuation);
}
