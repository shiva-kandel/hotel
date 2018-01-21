package com.example.shiva.foodpay;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import android.content.res.Resources;

public class ShoppingCartHelper2 {

    public static final String PRODUCT_INDEX2 = "PRODUCT_INDEX2";

    private static List<Product> catalog2;
    private static Map<Product, ShoppingCartEntry2> cartMap = new HashMap<Product, ShoppingCartEntry2>();
    public static List<Product> getCatalog(Resources res){
        if(catalog2 == null) {
            catalog2 = new Vector<>();
            catalog2.add(new Product("Alive", res
                    .getDrawable(R.drawable.breakfast),
                    "Hello", 20));
            catalog2.add(new Product("Switch", res
                    .getDrawable(R.drawable.veg),
                    "Hello", 20));
            catalog2.add(new Product("Watchmen", res
                    .getDrawable(R.drawable.nonveg),
                    "hello", 20));
        }

        return catalog2;
    }

    public static void setQuantity(Product product, int quantity) {
        // Get the current cart entry
        ShoppingCartEntry2 curEntry = cartMap.get(product);

        // If the quantity is zero or less, remove the products
        if(quantity <= 0) {
            if(curEntry != null)
                removeProduct(product);
            return;
        }

        // If a current cart entry doesn't exist, create one
        if(curEntry == null) {
            curEntry = new ShoppingCartEntry2(product, quantity);
            cartMap.put(product, curEntry);
            return;
        }

        // Update the quantity
        curEntry.setQuantity(quantity);
    }

    public static int getProductQuantity(Product product) {
        // Get the current cart entry
        ShoppingCartEntry2 curEntry = cartMap.get(product);

        if(curEntry != null)
            return curEntry.getQuantity();

        return 0;
    }

    public static void removeProduct(Product product) {
        cartMap.remove(product);
    }

    public static List<Product> getCartList() {
        List<Product> cartList = new Vector<Product>(cartMap.keySet().size());
        for(Product p2 : cartMap.keySet()) {
            cartList.add(p2);
        }

        return cartList;
    }


}