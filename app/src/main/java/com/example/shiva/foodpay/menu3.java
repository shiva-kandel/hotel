package com.example.shiva.foodpay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Shiva on 1/8/2018.
 */

public class menu3 extends Fragment {

    Activity context;



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context=getActivity();
        //Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_3, container, false);
    }

    public void onStart() {
        super.onStart();
        Button bt = (Button) context.findViewById(R.id.buttttt);
        bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                //create an Intent object
                Intent intent = new Intent(context, Drinks.class);
                //add data to the Intent object
                //start the second activity
                startActivity(intent);
            }

        });
    }
        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            //you can set the title for your toolbar here for different fragments different titles
            getActivity().setTitle("Feedback");
    }
}
