package com.example.hrant.listsandcards;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    void openListView(View view){
        Intent intent = new Intent(this, ListViewActivity.class);
        intent.putExtra("type", "list");
        startActivity(intent);
    }

    void openGridView(View view){
//        Intent intent = new Intent(this, GridViewActivity.class);
        Intent intent = new Intent(this, ListViewActivity.class);
        intent.putExtra("type", "grid");
        startActivity(intent);
    }
}
