package com.gcit.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText moperand1,moperand2;
    private TextView mresult;
    private calculator mcalculator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moperand1 = findViewById(R.id.number1);
        moperand2 = findViewById(R.id.number1);
        mresult = findViewById(R.id.textView);
        mcalculator = new calculator();
    }
    public void compute(calculator.operator operator){
        String operand1 = moperand1.getText().toString();
        String operand2 = moperand2.getText().toString();
        String result = " ";
        switch (operator){
            case ADD:
                result = String.valueOf(mcalculator.add(Double.valueOf(operand1),Double.valueOf(operand2)));
                break;

            case SUB:
                result = String.valueOf(mcalculator.sub(Double.valueOf(operand1),Double.valueOf(operand2)));
                break;

            case MUL:
                result = String.valueOf(mcalculator.mul(Double.valueOf(operand1),Double.valueOf(operand2)));
                break;

            case DIV:
                result = String.valueOf(mcalculator.div(Double.valueOf(operand1),Double.valueOf(operand2)));
                break;

            default:
                Log.d("CALCULATOR","ERROR MESSAGE");
                break;
        }
        mresult.setText(result);

    }

    public void addition(View view) {
        compute(calculator.operator.ADD);
    }

    public void subtraction(View view) {
        compute(calculator.operator.SUB);
    }

    public void multiply(View view) {
        compute(calculator.operator.MUL);
    }

    public void divide(View view) {
        compute(calculator.operator.DIV);
    }
}