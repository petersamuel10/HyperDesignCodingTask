package com.api.hyperdesign.hyperdesigncodingtask;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ProgressBar;

import com.api.hyperdesign.hyperdesigncodingtask.DataModel.Product;
import com.api.hyperdesign.hyperdesigncodingtask.Interface.APIInterface;
import com.api.hyperdesign.hyperdesigncodingtask.Interface.DataManager;
import com.api.hyperdesign.hyperdesigncodingtask.Ui.ProductAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.progress)
    ProgressBar progress;

    ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupRecyclerView();
        requestData();
    }

    private void requestData() {

        progress.setVisibility(View.VISIBLE);
        DataManager dataManager =new DataManager();

        Call<ArrayList<Product>> call = dataManager.getProducts();
        call.enqueue(new Callback<ArrayList<Product>>() {
        @Override
        public void onResponse(Call<ArrayList<Product>> call, Response<ArrayList<Product>> response) {

            adapter.addItems(response.body());
            adapter.notifyDataSetChanged();
            progress.setVisibility(View.GONE);
        }

        @Override
        public void onFailure(Call<ArrayList<Product>> call, Throwable t) {

            Snackbar snackbar = Snackbar.make(recyclerView,"Connection error",Snackbar.LENGTH_LONG);
            snackbar.show();
        }
    });
    }

    private void setupRecyclerView() {

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,1);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ProductAdapter();
        recyclerView.setAdapter(adapter);
    }
}