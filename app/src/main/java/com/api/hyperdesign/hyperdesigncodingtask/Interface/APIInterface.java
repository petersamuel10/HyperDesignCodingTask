package com.api.hyperdesign.hyperdesigncodingtask.Interface;

import com.api.hyperdesign.hyperdesigncodingtask.DataModel.Product;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jesus on 7/17/2018.
 */

public interface APIInterface {

    @GET("products")
    Call<ArrayList<Product>>getProducts(@Query("count") int count);
}
