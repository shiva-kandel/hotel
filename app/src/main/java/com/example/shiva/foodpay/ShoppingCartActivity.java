package com.example.shiva.foodpay;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

public class ShoppingCartActivity extends Activity {

    private List<Product> mCartList;
    private List<Product> mCartList2;

    private ProductAdapter mProductAdapter;
    private ProductAdapter2 mProductAdapter2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoppingcart);


        mCartList = ShoppingCartHelper.getCartList();
        mCartList2 = ShoppingCartHelper2.getCartList();

        // Make sure to clear the selections
        for (int i = 0; i < mCartList.size(); i++) {
            mCartList.get(i).selected = false;
        }
        for (int i = 0; i< mCartList2.size(); i++) {
            mCartList2.get(i).selected = false;
        }


        // Create the list




        // Create the list
        final ListView listViewCatalog = (ListView) findViewById(R.id.ListViewCatalog);
        mProductAdapter = new ProductAdapter(mCartList, getLayoutInflater(), true);
        listViewCatalog.setAdapter(mProductAdapter);

        listViewCatalog.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent productDetailsIntent = new Intent(getBaseContext(), ProductDetailsActivity.class);
                productDetailsIntent.putExtra(ShoppingCartHelper.PRODUCT_INDEX, position);
                startActivity(productDetailsIntent);
            }
        });

        final ListView listViewCatalog2 = (ListView) findViewById(R.id.ListViewCatalog);
        mProductAdapter2 = new ProductAdapter2(mCartList2, getLayoutInflater(), true);
        listViewCatalog2.setAdapter(mProductAdapter2);

        listViewCatalog2.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent productDetailsIntent2 = new Intent(getBaseContext(), ProductDetailsActivity2.class);
                productDetailsIntent2.putExtra(ShoppingCartHelper2.PRODUCT_INDEX2, position);
                startActivity(productDetailsIntent2);
            }
        });

    }



    @Override
    protected void onResume() {
        super.onResume();

        // Refresh the data
        if (mProductAdapter != null) {
            mProductAdapter.notifyDataSetChanged();
        }
        double subTotal = 0;
        for (Product p : mCartList) {
            int quantity = ShoppingCartHelper.getProductQuantity(p);

            subTotal += p.price * quantity;
        }

        for (Product p2 : mCartList2) {
            int quantity2 = ShoppingCartHelper2.getProductQuantity(p2);

            subTotal += p2.price * quantity2;
        }





        TextView productPriceTextView = (TextView) findViewById(R.id.TextViewSubtotal);
        productPriceTextView.setText("Subtotal: $" + subTotal);

    }
}