package com.example.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class focus extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    RadioButton same,next,pick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus);
//        Spinner spinner=findViewById(R.id.spinner)
        Intent intent= getIntent();
        String message =intent.getStringExtra("list");
        TextView tv=findViewById(R.id.toast);
        tv.setText(message);
        same=findViewById(R.id.radioButton);
        next=findViewById(R.id.radioButton2);
        pick=findViewById(R.id.radioButton3);

        Spinner spinner= findViewById(R.id.spinner);
        if (spinner !=null){
            spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.labels_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        if (spinner!=null){
            spinner.setAdapter(adapter);
        }
    }

    public void RadioButton(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.radioButton:
                if (checked)
                    displayToast("Same day messenger service");
                    break;
            case R.id.radioButton2:
                if (checked)
                    displayToast("Next day ground delivery");
                    break;

            case R.id.radioButton3:
                if (checked)
                    displayToast("Pick Up");
                    break;


            default:
                break;
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String spinnerMessage=parent.getItemAtPosition(position).toString();
            displayToast(spinnerMessage);
    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}