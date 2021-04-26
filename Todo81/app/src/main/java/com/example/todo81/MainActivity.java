package com.example.todo81;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText tv, tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.textView3);
        tv1=findViewById(R.id.textView2);
        tv2=findViewById(R.id.textView);

    }

    public void open(View view) {
        String website=tv.getText().toString();
        Uri uri= Uri.parse(website);
        Intent intent= new Intent(Intent.ACTION_VIEW,uri);
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
        else {
            Log.d("implicit Intent","error");
        }
    }

    public void location(View view) {
        String txt=tv1.getText().toString();
        Uri uri= Uri.parse("geo:0,0?q="+txt);
        Intent intent= new Intent(Intent.ACTION_VIEW,uri);
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
        else {
            Log.d("implicit Intent","error here");
        }
    }

    public void share(View view) {
        String text1=tv2.getText().toString();
        String mimeType="text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("share this text with:")
                .setText(text1)
                .startChooser();
    }
}