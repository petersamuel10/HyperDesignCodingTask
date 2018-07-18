package com.api.hyperdesign.hyperdesigncodingtask.Interface;

import com.api.hyperdesign.hyperdesigncodingtask.DataModel.Product;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jesus on 7/18/2018.
 */

public class DataManager {

    private APIInterface service;

    public DataManager ()
    {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://grapesnberries.getsandbox.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        service = retrofit.create(APIInterface.class);
    }

    public Call<ArrayList<Product>> getProducts(){
    return service.getProducts(100);
    }

}
