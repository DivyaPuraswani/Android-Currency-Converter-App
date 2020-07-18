package com.divyap.mycurrencyconverterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mEtValue; //Global Variables
    TextView mTvValue;
    Button mBtnCad;
    Button mBtnInr;
    Button mBtnEur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEtValue=findViewById(R.id.et_value); //Resources is R
        mTvValue=findViewById(R.id.tv_value);
        mBtnCad=findViewById(R.id.btn_cad);
        mBtnInr=findViewById(R.id.btn_inr);
        mBtnEur=findViewById(R.id.btn_eur);

    }
    public void onBtnCadClicked(View view) //It will be grey if not set in layout
    {
        //Log.d("DEBUG", "Button CLicked");
        //double initalValue= Double.parseDouble(mEtValue.getText().toString());
        double convertedValue = 0;
        try {
            double amount = getAmount();
            if (amount < 0) throw new Exception();
            convertedValue = amount * 1.36;
        }
        catch(Exception e){
            Toast.makeText(this, "Invalid input, bakchodi nahi!!", Toast.LENGTH_SHORT).show();
        }
        //String.format("= %.2f"); //for formatting
        mTvValue.setText(String.format("= %.2f CAD", convertedValue));

    }
    public void onBtnInrClicked(View view)
    {
        double convertedValue = 0;
        try{
        double amount=getAmount();
        if (amount < 0) throw new Exception();
            convertedValue=amount*74.93;
    }
        catch(Exception e){
        Toast.makeText(this, "Invalid input, bakchodi nahi!!", Toast.LENGTH_SHORT).show();
    }
        //String.format("= %.2f"); //for formatting
        mTvValue.setText(String.format("= %.2f INR", convertedValue));
    }
    public void onBtnEurClicked(View view)
    {
        double convertedValue = 0;
        try{
        double amount=getAmount();
        if (amount < 0) throw new Exception();
        convertedValue=amount*0.88;
    }
        catch(Exception e){
                Toast.makeText(this, "Invalid input, bakchodi nahi!!", Toast.LENGTH_SHORT).show();
                }
        //String.format("= %.2f"); //for formatting
        mTvValue.setText(String.format("= %.2f EUR",convertedValue));
    }

    private double getAmount() throws Exception {
        String amountString = mEtValue.getText().toString();
        if(amountString.length()>15){
            throw new Exception();
        }
        double amount;
        if (amountString.equals("")) {
            amount = 0;
        } else {
            amount = Double.parseDouble(amountString);
        }
        return amount;
    }
}