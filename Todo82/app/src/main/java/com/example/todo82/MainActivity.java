package com.example.todo82;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Intent intent=new Intent();
//        Uri uri =intent.getData();
//        if (uri!=null){
//            String uri_string="URI:"+uri.toString();
//            TextView txt=findViewById(R.id.ti);
//            txt.setText(uri_string);
//        }
    }
}