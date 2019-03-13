package com.cscheerleader.recyclerviewexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    private MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Used this tutorial - https://stackoverflow.com/questions/40584424/simple-android-recyclerview-example

        //1. Add dependencies - appcompat and recyclerview - used project structure menu
        //2. Added code to XML layout
               /*<android.support.v7.widget.RecyclerView
                 android:id="@+id/workshopParticipants"
                 android:layout_width="match_parent"
                 android:layout_height="match_parent">
                 </android.support.v7.widget.RecyclerView>*/
        //3.  Create new xml file for the styling of each individual row
                /*LinearLayout
                xmlns:android="http://schemas.android.com/apk/res/android"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="horizontal"
                android:padding="10dp">

                <TextView
                android:id="@+id/personName"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:textSize="20sp"/>
                </LinearLayout>*/
        //4.    Created adapter class - made necessary variable name changes
        //5.    Added code to MainActivity to use adapter

        // data to populate the RecyclerView with
        ArrayList<String> workshopParticipants = new ArrayList<String>();
        workshopParticipants.add("Christine");
        workshopParticipants.add("Marty");
        workshopParticipants.add("Tom");
        workshopParticipants.add("JeanMarie");
        workshopParticipants.add("Daniel");

        // set up the RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.workshopParticipants);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, workshopParticipants);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this,PersonActivity.class);
        startActivity(i);

    }


}
