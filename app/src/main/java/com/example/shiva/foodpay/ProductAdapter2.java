package com.example.shiva.foodpay;

import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductAdapter2 extends BaseAdapter {

    private List<Product> mProductList2;
    private LayoutInflater mInflater;
    private boolean mShowQuantity;

    public ProductAdapter2(List<Product> list, LayoutInflater inflater, boolean showQuantity) {
        mProductList2= list;
        mInflater = inflater;
        mShowQuantity = showQuantity;
    }



    @Override
    public int getCount() {
        return mProductList2.size();
    }

    @Override
    public Object getItem(int position) {
        return mProductList2.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewItem item;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item2, null);
            item = new ViewItem();

            item.productImageView = (ImageView) convertView
                    .findViewById(R.id.ImageViewItem1);

            item.productTitle = (TextView) convertView
                    .findViewById(R.id.TextViewItem1);

            item.productQuantity = (TextView) convertView
                    .findViewById(R.id.textViewQuantity1);

            convertView.setTag(item);
        } else {
            item = (ViewItem) convertView.getTag();
        }

        Product curProduct = mProductList2.get(position);

        item.productImageView.setImageDrawable(curProduct.productImage);
        item.productTitle.setText(curProduct.title);

        // Show the quantity in the cart or not
        if (mShowQuantity) {
            item.productQuantity.setText("Quantity: "
                    + ShoppingCartHelper2.getProductQuantity(curProduct));
        } else {
            // Hid the view
            item.productQuantity.setVisibility(View.GONE);
        }

        return convertView;
    }

    private class ViewItem {
        ImageView productImageView;
        TextView productTitle;
        TextView productQuantity;
    }

}