package com.example.shiva.foodpay;

/**
 * Created by Shiva on 1/9/2018.
 */



import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.shiva.foodpay.Product;

public class Snacks extends Activity {

    private List<Product> mProductList;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snacks);

        // Obtain a reference to the Product catalog
        mProductList = ShoppingCartHelper2.getCatalog(getResources());

        // Create the list
        ListView listViewCatalog = (ListView) findViewById(R.id.list4);
        listViewCatalog.setAdapter(new ProductAdapter(mProductList, getLayoutInflater(), false));

        listViewCatalog.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent productDetailsIntent2 = new Intent(getBaseContext(),ProductDetailsActivity2.class);
                productDetailsIntent2.putExtra(ShoppingCartHelper2.PRODUCT_INDEX2, position);
                startActivity(productDetailsIntent2);
            }
        });

        Button viewShoppingCart2 = (Button) findViewById(R.id.ButtonViewCart);
        viewShoppingCart2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent viewShoppingCartIntent2 = new Intent(getBaseContext(), ShoppingCartActivity.class);
                startActivity(viewShoppingCartIntent2);
            }
        });

    }
}