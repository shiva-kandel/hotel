package com.example.shiva.foodpay;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProductDetailsActivity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.productdetails2);

        List<Product> catalog2 = ShoppingCartHelper2.getCatalog(getResources());

        int productIndex = getIntent().getExtras().getInt(
                ShoppingCartHelper2.PRODUCT_INDEX2);
        final Product selectedProduct = catalog2.get(productIndex);

        // Set the proper image and text
        ImageView productImageView = (ImageView) findViewById(R.id.ImageViewProduct1);
        productImageView.setImageDrawable(selectedProduct.productImage);
        TextView productTitleTextView = (TextView) findViewById(R.id.TextViewProductTitle1);
        productTitleTextView.setText(selectedProduct.title);
        TextView productDetailsTextView = (TextView) findViewById(R.id.TextViewProductDetails1);
        productDetailsTextView.setText(selectedProduct.description);


        TextView productPriceTextView = (TextView) findViewById(R.id.TextViewProductPrice1);
        productPriceTextView.setText("$" + selectedProduct.price);

        // Update the current quantity in the cart
        TextView textViewCurrentQuantity = (TextView) findViewById(R.id.textViewCurrentlyInCart1);
        textViewCurrentQuantity.setText("Currently in Cart: "
                + ShoppingCartHelper2.getProductQuantity(selectedProduct));

        // Save a reference to the quantity edit text
        final EditText editTextQuantity = (EditText) findViewById(R.id.editTextQuantity1);

        Button addToCartButton = (Button) findViewById(R.id.ButtonAddToCart);
        addToCartButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                // Check to see that a valid quantity was entered
                int quantity2 = 0;
                try {
                    quantity2 = Integer.parseInt(editTextQuantity.getText()
                            .toString());

                    if (quantity2 < 0) {
                        Toast.makeText(getBaseContext(),
                                "Please enter a quantity of 0 or higher",
                                Toast.LENGTH_SHORT).show();
                        return;
                    }

                } catch (Exception e) {
                    Toast.makeText(getBaseContext(),
                            "Please enter a numeric quantity",
                            Toast.LENGTH_SHORT).show();

                    return;
                }

                // If we make it here, a valid quantity was entered
                ShoppingCartHelper2.setQuantity(selectedProduct, quantity2);

                // Close the activity
                finish();
            }
        });

    }

}
