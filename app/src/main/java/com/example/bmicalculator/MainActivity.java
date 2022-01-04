package com.example.bmicalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculate = (Button) findViewById(R.id.calculate);
        EditText age = (EditText) findViewById(R.id.age);
        EditText height = (EditText) findViewById(R.id.height);
        EditText weight = (EditText) findViewById(R.id.weight);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ageVal = age.getText().toString();
                String heightVal = height.getText().toString();
                String weightVal = weight.getText().toString();

                if(TextUtils.isEmpty(ageVal)|TextUtils.isEmpty(heightVal)|TextUtils.isEmpty(weightVal)){
                    Toast.makeText(getApplicationContext(),"Enter your data correctly", Toast.LENGTH_LONG).show();
                }else if(Integer.parseInt(ageVal)<18){
                    Toast.makeText(getApplicationContext(),"This app works for people elder than 18 years old", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent secondActivity = new Intent(MainActivity.this, MainActivity2.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("age",ageVal);
                    bundle.putString("height",heightVal);
                    bundle.putString("weight",weightVal);
                    secondActivity.putExtras(bundle);
                    startActivity(secondActivity);
                }

            }
        });
    }
    @Override
    public void onBackPressed(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Do you want to exit from the app?")
                .setTitle("Exit")
                .setCancelable(false)
                .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setPositiveButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });


        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}