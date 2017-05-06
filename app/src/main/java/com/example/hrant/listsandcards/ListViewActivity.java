package com.example.hrant.listsandcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity implements ListViewHolder.ListItemClickListener{
    Countries countries;
    ArrayList<Country> countryList;
    private RecyclerView recyclerView;
    private ListAdapter adapter;

    // scroll -------------------------------------
    LinearLayoutManager mLayoutManager;
    boolean loading = true;
    int pastVisiblesItems, visibleItemCount, totalItemCount, firstVisibleItem, previousTotal, visibleThreshold;

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
            mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(mLayoutManager);
        } else {
            recyclerView = (RecyclerView) findViewById(R.id.simpleListView);
            mLayoutManager = new GridLayoutManager(this, 3);
            recyclerView.setLayoutManager(mLayoutManager);
        }

        adapter = new ListAdapter(countryList, this, type);

        recyclerView.setAdapter(adapter);

        // scroll -------------------------------------
        loading = true;
        previousTotal = 0;
        visibleThreshold = 5;

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener()
        {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy)
            {
                super.onScrolled(recyclerView, dx, dy);

                visibleItemCount = recyclerView.getChildCount();
                totalItemCount = mLayoutManager.getItemCount();
                firstVisibleItem = mLayoutManager.findFirstVisibleItemPosition();

//                Log.d("testt", String.valueOf(dx) + " " + String.valueOf(dy) + " visibleItemCount" + String.valueOf(visibleItemCount)
//          + " totalItemCount " + String.valueOf(totalItemCount) + " firstVisibleItem " + String.valueOf(firstVisibleItem));

                if (loading) {
                    if (totalItemCount > previousTotal) {
                        loading = false;
                        previousTotal = totalItemCount;
                        Log.d("testt", "loading");
                    }
                }
                if (!loading && (totalItemCount - visibleItemCount)
                        <= (firstVisibleItem + visibleThreshold)) {
                    // End has been reached

                    Log.d("testt", "end called");

                    loading = true;
                }
            }
            public void onScrollStateChanged(RecyclerView recyclerView, int newState){
                //SCROLL_STATE_IDLE - 0, SCROLL_STATE_DRAGGING - 1 or SCROLL_STATE_SETTLING - 2.
                Log.d("testt", "scroll state" + String.valueOf(newState));
            }
        });

    }

    @Override
    public void onListItemClicked(Country country) {
        Log.d("testt", "onListItemClick " + country.getIso());
    }

    @Override
    public void onGridItemClicked(Country country) {
        Log.d("testt", "onGridItemClick " + country.getIso());
    }
}
