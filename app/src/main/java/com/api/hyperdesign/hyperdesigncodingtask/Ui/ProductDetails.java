package com.api.hyperdesign.hyperdesigncodingtask.Ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.api.hyperdesign.hyperdesigncodingtask.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductDetails extends AppCompatActivity {

    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.productImage)
    ImageView image;
    Bundle data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details2);
        ButterKnife.bind(this);
        data = getIntent().getExtras();
        Bind();
    }

    private void Bind() {

        price.setText("$"+data.getInt("price"));
        description.setText(data.getString("desc"));
        Picasso.get().load(data.getString("url"))
                .resize(data.getInt("height"),data.getInt("width"))
                .into(image);
    }

}
