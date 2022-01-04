package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView bmiValue = (TextView) findViewById(R.id.bmiValue);
        TextView status = (TextView) findViewById(R.id.status);

        Bundle bundle = getIntent().getExtras();
        String age = bundle.getString("age");
        String height = bundle.getString("height");
        String weight = bundle.getString("weight");

        status.setText(SelectCategory(Double.parseDouble(countBMI(height,weight))));
        textColorSelection(status,Double.parseDouble(countBMI(height,weight)));
        bmiValue.setText("BMI = " + countBMI(height,weight) +" kg/m2");
    }

    public String countBMI(String Height, String Weight){
        double BMI =Double.parseDouble(Weight)/((Double.parseDouble(Height)/100)*(Double.parseDouble(Height)/100));
        String rounded =String.format("%.1f",BMI);
        return rounded;
    }

    public String SelectCategory(double bmi){
        String category;
        if (bmi<16){
            category = "Severe Thinness";
        }else if(bmi>=16 && bmi<17){
            category ="Moderate Thinness";
        }else if(bmi>=17 && bmi<18.5){
            category ="Mild thinness";
        }else if(bmi>=18.5 && bmi<25){
            category ="Normal";
        }else if(bmi>=25 && bmi<30){
            category ="Overweight";
        }else if(bmi>=30 && bmi<35){
            category ="Obese Class I";
        }else if(bmi>=35 && bmi<40){
            category ="Obese Class II";
        }else{
            category = "Obese Class III";
        }
        return category;
    }

    public void textColorSelection(TextView tv,double bmi){
        if (bmi<16){
            tv.setTextColor(0xff993300);
        }else if(bmi>=16 && bmi<17){
            tv.setTextColor(0xff993333);
        }else if(bmi>=17 && bmi<18.5){
            tv.setTextColor(0xffffcc33);
        }else if(bmi>=18.5 && bmi<25){
            tv.setTextColor(0xff009933);
        }else if(bmi>=25 && bmi<30){
            tv.setTextColor(0xffffcc00);
        }else if(bmi>=30 && bmi<35){
            tv.setTextColor(0xffff3333);
        }else if(bmi>=35 && bmi<40){
            tv.setTextColor(0xffcc3333);
        }else{
            tv.setTextColor(0xffcc0000);
        }
    }

}