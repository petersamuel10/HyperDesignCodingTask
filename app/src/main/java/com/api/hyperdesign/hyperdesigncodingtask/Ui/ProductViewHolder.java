package com.api.hyperdesign.hyperdesigncodingtask.Ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.api.hyperdesign.hyperdesigncodingtask.DataModel.Product;
import com.api.hyperdesign.hyperdesigncodingtask.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jesus on 7/18/2018.
 */

public class ProductViewHolder extends RecyclerView.ViewHolder {

    Product myProduct ;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.productImage)
    ImageView image;
    @BindView(R.id.description)
    TextView description;
    @OnClick(R.id.itemCard)
    public void itemDetails(){

        Bundle data = new Bundle();
        data.putInt("price",myProduct.getPrice());
        data.putString("url",myProduct.getImage().getUrl());
        data.putInt("height",myProduct.getImage().getHeight());
        data.putInt("width",myProduct.getImage().getWidth());
        data.putString("desc",myProduct.getProductDescription());

        Intent itemDetails = new Intent(ProductAdapter.mContext,ProductDetails.class);
        itemDetails.putExtras(data);
        (ProductAdapter.mContext).startActivity(itemDetails);
    }

    public ProductViewHolder(View itemView) {

        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void bind(Product product) {

        myProduct = product;
        price.setText("$"+product.getPrice());
        description.setText(product.getProductDescription());
        Picasso.get().load(product.getImage().getUrl())
                .resize(product.getImage().getWidth(),product.getImage().getHeight())
                .into(image);
    }
}
