package com.api.hyperdesign.hyperdesigncodingtask.Ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.api.hyperdesign.hyperdesigncodingtask.DataModel.Product;
import com.api.hyperdesign.hyperdesigncodingtask.R;

import java.util.ArrayList;

/**
 * Created by jesus on 7/18/2018.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    ArrayList<Product> products;
    public ProductAdapter () {
        products = new ArrayList<>();
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {

        holder.bind(products.get(position));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
    public void addItems(ArrayList<Product> newProduct){
        products.addAll(newProduct);
    }
}
