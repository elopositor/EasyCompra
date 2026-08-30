package com.easycompra.app.network;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* JADX INFO: compiled from: ApiServices.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/easycompra/app/network/CloudService;", "", "getProducts", "", "Lcom/easycompra/app/network/CloudProduct;", "supermarket", "", "sortBy", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface CloudService {
    @GET("products")
    Object getProducts(@Query("supermarket") String str, @Query("sort_by") String str2, Continuation<? super List<CloudProduct>> continuation);

    /* JADX INFO: compiled from: ApiServices.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object getProducts$default(CloudService cloudService, String str, String str2, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getProducts");
            }
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                str2 = "sugars_100g";
            }
            return cloudService.getProducts(str, str2, continuation);
        }
    }
}
