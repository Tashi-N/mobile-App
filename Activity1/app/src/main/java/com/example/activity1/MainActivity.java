package com.example.activity1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//    public static final String EXTRA_MESSAGE("com.example.activity1.EXTRA.SEND");
    public static final int TEXT_REQUEST=1;
private EditText edittext;
private TextView t1;
private TextView t2;
public final static String Extra_Message="com.example.activity1.message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittext=findViewById(R.id.editTextsend);
        t1=findViewById(R.id.textreply);
        t2= findViewById(R.id.editTextreply);
    }

    public void send(View view) {
        Intent intent= new Intent(this,MainActivity2.class);
        String message=edittext.getText().toString();
        intent.putExtra(Extra_Message,message);
        startActivityForResult(intent,TEXT_REQUEST);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent obj1){
     super.onActivityResult(requestCode,resultCode,obj1);
     if (requestCode==TEXT_REQUEST){
         String message =obj1.getStringExtra(MainActivity2.extra_reply);
         t1.setVisibility(View.VISIBLE);
         //t1.setText(message);
         t2.setVisibility(View.VISIBLE);
         t2.setText(message);
     }
    }
}