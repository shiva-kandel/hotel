package com.example.shiva.foodpay;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Shiva on 1/8/2018.
 */

public class Home extends Fragment {




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_menu_1, container, false);
       CardView cardView1=(CardView)view.findViewById(R.id.id_drinks);
        CardView cardView2=(CardView)view.findViewById(R.id.id_veg);
        CardView cardView3=(CardView)view.findViewById(R.id.nonveg);
        CardView cardView4=(CardView)view.findViewById(R.id.id_snacks);
        CardView cardView5=(CardView)view.findViewById(R.id.id_breakfast);

        CardView cardView6=(CardView)view.findViewById(R.id.id_combo);
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in =new Intent(getActivity(),Drinks.class);
                startActivity(in);
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in2 =new Intent(getActivity(),Vegetarian.class);
                startActivity(in2);
            }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in3 =new Intent(getActivity(),Nonveg.class);
                startActivity(in3);
            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in4 =new Intent(getActivity(),Snacks.class);
                startActivity(in4);
            }
        });
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in5 =new Intent(getActivity(),Breakfast.class);
                startActivity(in5);
            }
        });
        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in6 =new Intent(getActivity(),Extra.class);
                startActivity(in6);
            }
        });

        return  view;
    }


        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            //you can set the title for your toolbar here for different fragments different titles
            getActivity().setTitle("Home");
    }

}
