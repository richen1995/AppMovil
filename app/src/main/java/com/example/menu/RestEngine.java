package com.example.menu;

import com.example.menu.entidades.Servicio;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestEngine {
    private static Retrofit retrofit = null;
    public static Retrofit getRestEngine(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                //.baseUrl("http://demo5302785.mockable.io/")
                .baseUrl("http://192.168.1.32:8080/luxAD/webADluxflame/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }

    public static Servicio getServicio(){
        Servicio objServicio = getRestEngine().create(Servicio.class);
        return objServicio;
    }
}
