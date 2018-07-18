package com.api.hyperdesign.hyperdesigncodingtask.Ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.api.hyperdesign.hyperdesigncodingtask.DataModel.Product;
import com.api.hyperdesign.hyperdesigncodingtask.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jesus on 7/18/2018.
 */

public class ProductViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.productImage)
    ImageView image;
    @BindView(R.id.description)
    TextView description;

    public ProductViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void bind(Product product) {

        price.setText("$"+product.getPrice());
        description.setText(product.getProductDescription());

        Picasso.get().load(product.getImage().getUrl())
                .resize(product.getImage().getWidth(),product.getImage().getHeight())
                .into(image);
    }
}
