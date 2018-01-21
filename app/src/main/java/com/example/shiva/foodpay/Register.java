package com.example.shiva.foodpay;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Register extends AppCompatActivity {
    EditText fullname, username, address, phone_number, password, email;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fullname = (EditText) findViewById(R.id.id_fullname);
        password = (EditText) findViewById(R.id.id_password);
        address = (EditText) findViewById(R.id.id_address);
        phone_number = (EditText) findViewById(R.id.id_phone);
        email = (EditText) findViewById(R.id.id_email);
        username = (EditText) findViewById(R.id.id_username);
        submit = (Button) findViewById(R.id.rsubmit);
    }

    public void Register(View view) {
        String user_name = username.getText().toString();
        String pass_word = password.getText().toString();
        String email1=email.getText().toString();
        String phone_number1=phone_number.getText().toString();
        String fullname1=fullname.getText().toString();
        String address1=address.getText().toString();
        String type="Register";
        Signupbackground signupbackground=new Signupbackground(this);
        signupbackground.execute(type,fullname1,email1,phone_number1,address1,user_name,pass_word);
    }
}

