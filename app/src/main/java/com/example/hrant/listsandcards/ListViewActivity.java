package com.example.hrant.listsandcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

//    String countryList[] = {"India", "China", "australia", "Portugle", "America", "NewZealand"};
//    int flags[] = {R.drawable.flag_in, R.drawable.flag_cn, R.drawable.flag_au, R.drawable.flag_pl, R.drawable.flag_us, R.drawable.flag_nz};
ListView simpleList;
    Countries countries;
    ArrayList<Country> countryList;
    private RecyclerView recyclerView;
    private ListAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        countries = new Countries(this);
        countryList = countries.getcountries();

        if(type.equals("list")) {
            recyclerView = (RecyclerView) findViewById(R.id.simpleListView);
            recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        } else {
            recyclerView = (RecyclerView) findViewById(R.id.simpleListView);
            recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        }

        adapter = new ListAdapter(countryList, type);

        recyclerView.setAdapter(adapter);

    }
}
