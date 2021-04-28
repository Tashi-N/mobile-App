package com.example.calculation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {
   private EditText tv,tv1,tv2;
    private Button btn,btn1,btn2,btn3;
    private calcu cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.textView);
        tv1=findViewById(R.id.textView2);
        tv2=findViewById(R.id.textView3);
        cal=new calcu();

    }
    public void compute(calcu.Operator operator){
        String operation1=tv.getText().toString();
        String operation2=tv1.getText().toString();
//        double operation1;
//        double operation2;
        String result=" ";
        switch (operator){
            case ADD:
                result = String.valueOf(cal.add(Double.valueOf(operation1), Double.valueOf(operation2)));
                break;


            case SUB:
                result = String.valueOf(cal.sub(Double.valueOf(operation1), Double.valueOf(operation2)));
                break;

            case MUL:
                result = String.valueOf(cal.mul(Double.valueOf(operation1), Double.valueOf(operation2)));
                break;

            case DIV:
                result = String.valueOf(cal.div(Double.valueOf(operation1), Double.valueOf(operation2)));
                break;

            default:
                Log.d("oioi","chim na zhu");
        }

        tv2.setText(result);

    }

    public void add(View view) {
        compute(calcu.Operator.ADD);

    }

    public void sub(View view) {
        compute(calcu.Operator.SUB);

    }

    public void mul(View view) {
        compute(calcu.Operator.MUL);

    }

    public void div(View view) {
        compute(calcu.Operator.DIV);

    }
}