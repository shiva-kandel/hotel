package com.example.shiva.foodpay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   private EditText username;
  private  EditText password;
    private  TextView submit;
    private TextView Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=(EditText) findViewById(R.id.id_username);
        password=(EditText) findViewById(R.id.id_password);
        Register=(TextView)findViewById(R.id.register);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerintent= new Intent(MainActivity.this,Register.class);
                startActivity(registerintent);
            }
        });

           }

    public  void Login(View view){
        String user_name=username.getText().toString();
        String pass_word=password.getText().toString();
        String type="Login";
        LoginBackground loginBackground=new LoginBackground(this);
        loginBackground.execute(type,user_name,pass_word);
    }
}
