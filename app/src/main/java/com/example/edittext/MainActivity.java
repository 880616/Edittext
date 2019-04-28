package com.example.edittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText ed1,ed2,ed3;
    private TextView txv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setBackgroundDrawableResource(R.drawable.backg);
    }

    int size = 30;
    public void response(View view){

        ed1 = findViewById(R.id.editText);
        ed2 = findViewById(R.id.editText2);
        ed3 = findViewById(R.id.editText3);
        txv = findViewById(R.id.TextView);
        float height = Float.parseFloat(ed2.getText().toString());
        float weight = Float.parseFloat(ed3.getText().toString());
        float BMI1 = calculateBMI(height,weight);


        txv.setTextSize(size);
        txv.setText(ed1.getText().toString() + " Hello!" + "\n" + "your BMI is " + String.format("%.2f",BMI1));

        Toast.makeText(this, standardBMI(BMI1), Toast.LENGTH_SHORT).show();
    }


    private float calculateBMI(float ht ,float wt){
        float BMI = (float)(wt/Math.pow((ht/100),2));
        return BMI;
    }

    private String standardBMI(double st){
        String alert = "";

        if(st>25){
            alert = String.valueOf("You are too heavy!!!");
            getWindow().setBackgroundDrawableResource(R.drawable.heavy);
        }
        else if (st<18.5){
            alert = String.valueOf("You are too slim!!!");
            getWindow().setBackgroundDrawableResource(R.drawable.silm);
        }
        else{
            alert = String.valueOf("Your body is good!");
            getWindow().setBackgroundDrawableResource(R.drawable.normal);
        }
        return alert;

    }
}