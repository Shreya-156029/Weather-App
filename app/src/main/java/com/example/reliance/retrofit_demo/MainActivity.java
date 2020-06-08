package com.example.reliance.retrofit_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.reliance.retrofit_demo.retrofit.ApiInterface;
import com.example.reliance.retrofit_demo.retrofit.Apiclient;
import com.example.reliance.retrofit_demo.retrofit.Example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    ImageView imageView;TextView descText;TextView humdityText,tempText;
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=(ImageView)findViewById(R.id.search);
        descText=(TextView)findViewById(R.id.descText);
        humdityText=(TextView)findViewById(R.id.humidityText);
        text=(EditText)findViewById(R.id.textField);
        tempText=(TextView)findViewById(R.id.tempText);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getWeatherData(text.getText().toString().trim());
            }
        });
    }

    private  void getWeatherData(String name)
    {
        ApiInterface apiInterface=Apiclient.getClient().create(ApiInterface.class);
        Call<Example> call=apiInterface.getWeatherData(name);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
//                Log.d("DATA",response.body().getMain().getTemp());
                tempText.setText("Temprature"+" "+response.body().getMain().getTemp()+" C");
                descText.setText("Feels like"+" "+response.body().getMain().getFeels_like());
                humdityText.setText("Humidity"+" "+response.body().getMain().getHumidity());
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });
    }
}
