package com.king.girl.http;

import com.king.girl.Constants;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Jenly <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * @since 2016/10/11
 */
public class APIRetrofit {

    private static Retrofit mInstance;

    public static Retrofit getIntance(){

       if(mInstance == null){
           synchronized (APIRetrofit.class){

               if(mInstance == null){
                   mInstance = new Retrofit.Builder()
                           .baseUrl(Constants.HTTP_URL)
                           .addConverterFactory(GsonConverterFactory.create())
                           .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                           .client(getOkHttpClient())
                           .build();

               }

           }
       }

       return mInstance;

    }

    private static OkHttpClient getOkHttpClient(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .build();
        return okHttpClient;
    }


}
