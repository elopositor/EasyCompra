package com.easycompra.app.network;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: compiled from: ApiServices.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/easycompra/app/network/ApiClients;", "", "<init>", "()V", "httpClient", "Lokhttp3/OkHttpClient;", "cloudHttpClient", "mercadona", "Lcom/easycompra/app/network/MercadonaService;", "getMercadona", "()Lcom/easycompra/app/network/MercadonaService;", "dia", "Lcom/easycompra/app/network/DiaService;", "getDia", "()Lcom/easycompra/app/network/DiaService;", "openFoodFacts", "Lcom/easycompra/app/network/OpenFoodFactsService;", "getOpenFoodFacts", "()Lcom/easycompra/app/network/OpenFoodFactsService;", "cloud", "Lcom/easycompra/app/network/CloudService;", "getCloud", "()Lcom/easycompra/app/network/CloudService;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ApiClients {
    public static final int $stable;
    public static final ApiClients INSTANCE = new ApiClients();
    private static final CloudService cloud;
    private static final OkHttpClient cloudHttpClient;
    private static final DiaService dia;
    private static final OkHttpClient httpClient;
    private static final MercadonaService mercadona;
    private static final OpenFoodFactsService openFoodFacts;

    private ApiClients() {
    }

    static {
        CloudService cloudService;
        OkHttpClient.Builder this_$iv = new OkHttpClient.Builder();
        httpClient = this_$iv.addInterceptor(new Interceptor() { // from class: com.easycompra.app.network.ApiClients$special$$inlined$-addInterceptor$1
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                Intrinsics.checkNotNullParameter(chain, "chain");
                return chain.proceed(chain.request().newBuilder().header("User-Agent", "EasyCompra/1.0").build());
            }
        }).build();
        OkHttpClient.Builder this_$iv2 = new OkHttpClient.Builder();
        cloudHttpClient = this_$iv2.addInterceptor(new Interceptor() { // from class: com.easycompra.app.network.ApiClients$special$$inlined$-addInterceptor$2
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                Intrinsics.checkNotNullParameter(chain, "chain");
                return chain.proceed(chain.request().newBuilder().header("User-Agent", "EasyCompra/1.0").header("ngrok-skip-browser-warning", "true").build());
            }
        }).build();
        Object objCreate = new Retrofit.Builder().baseUrl("https://tienda.mercadona.es/").client(httpClient).addConverterFactory(GsonConverterFactory.create()).build().create(MercadonaService.class);
        Intrinsics.checkNotNullExpressionValue(objCreate, "create(...)");
        mercadona = (MercadonaService) objCreate;
        Object objCreate2 = new Retrofit.Builder().baseUrl("https://www.dia.es/").client(httpClient).addConverterFactory(GsonConverterFactory.create()).build().create(DiaService.class);
        Intrinsics.checkNotNullExpressionValue(objCreate2, "create(...)");
        dia = (DiaService) objCreate2;
        Object objCreate3 = new Retrofit.Builder().baseUrl("https://world.openfoodfacts.org/").client(httpClient).addConverterFactory(GsonConverterFactory.create()).build().create(OpenFoodFactsService.class);
        Intrinsics.checkNotNullExpressionValue(objCreate3, "create(...)");
        openFoodFacts = (OpenFoodFactsService) objCreate3;
        if (!StringsKt.isBlank(ApiServicesKt.CLOUD_BASE_URL)) {
            cloudService = (CloudService) new Retrofit.Builder().baseUrl(StringsKt.trimEnd(ApiServicesKt.CLOUD_BASE_URL, '/') + "/").client(cloudHttpClient).addConverterFactory(GsonConverterFactory.create()).build().create(CloudService.class);
        } else {
            cloudService = null;
        }
        cloud = cloudService;
        $stable = 8;
    }

    public final MercadonaService getMercadona() {
        return mercadona;
    }

    public final DiaService getDia() {
        return dia;
    }

    public final OpenFoodFactsService getOpenFoodFacts() {
        return openFoodFacts;
    }

    public final CloudService getCloud() {
        return cloud;
    }
}
