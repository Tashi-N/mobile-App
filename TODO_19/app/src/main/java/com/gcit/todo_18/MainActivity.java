package com.gcit.todo_18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<Sport> mSportData;
    private SportsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerView);
        //set the layout manager
        int gridColumnCount=getResources().getInteger(R.integer.grid_column_count);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,gridColumnCount));
        //initialize the arraylist that will contain data
        mSportData = new ArrayList<>();
        //Initialize the adapter set it on the recyclerview
        mAdapter = new SportsAdapter(this, mSportData);
        mRecyclerView.setAdapter(mAdapter);
        //get the data
        initializationData();
    }

    private void initializationData() {
        String[] sportsList = getResources().getStringArray(R.array.sports_title);
        String[] sportsInfo = getResources().getStringArray(R.array.sports_info);
        TypedArray sportsImageResource = getResources().obtainTypedArray(R.array.sports_image);

        //clear the existing data
        mSportData.clear();

        //create the arraylist of sports obj with the title and information
        for (int i = 0; i < sportsList.length; i++){
            mSportData.add(new Sport(sportsList[i],sportsInfo[i],sportsImageResource.getResourceId(i, 0)));
        }

        mAdapter.notifyDataSetChanged();
        sportsImageResource.recycle();
    }
}