package com.example.shiva.foodpay;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Shiva on 1/8/2018.
 */

public class Signupbackground extends AsyncTask<String,Void,String> {
    Context ctx;
    ProgressDialog progressDialog;
    public Signupbackground(Context context){
        ctx=context;
    }
    @Override
    protected String doInBackground(String... strings) {
        String type=strings[0];
        String path="http://192.168.0.106/details.php";
        if(type.equals("Register")){
            try {
                String fullname=strings[1];
                String email=strings[2];
                String phone_number=strings[3];

                String address=strings[4];
                String user_name=strings[5];
                String pass_word=strings[6];

                URL url=new URL(path);

                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);

                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWrite=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));

                String post_data=URLEncoder.encode("fullname","UTF-8")+"="+URLEncoder.encode(fullname,"UTF-8")+"&"
                        +URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"
                        +URLEncoder.encode("phone_number","UTF-8")+"="+URLEncoder.encode(phone_number,"UTF-8")+"&"
                        +URLEncoder.encode("address","UTF-8")+"="+URLEncoder.encode(address,"UTF-8")+"&"
                       + URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+"&"
                        +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(pass_word,"UTF-8");

                       ;

                bufferedWrite.write(post_data);

                bufferedWrite.flush();
                bufferedWrite.close();
                outputStream.close();

                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));

                String result="";
                String line="";
                while((line=bufferedReader.readLine())!=null){
                    result+=line;

                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;




            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




        return null;
    }

    @Override
    protected void onPreExecute() {
        progressDialog = ProgressDialog.show(ctx, "Loading",
                "Please wait...", true);
    }

    @Override
    protected void onPostExecute(String s) {
        progressDialog.dismiss();

            Intent intent=new Intent(ctx,MainActivity.class);
            ctx.startActivity(intent);



    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
