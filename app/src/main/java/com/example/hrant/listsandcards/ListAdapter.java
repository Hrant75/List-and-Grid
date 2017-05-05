package com.example.hrant.listsandcards;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * Created by Hrant on 04.05.2017.
 */

public class ListAdapter extends RecyclerView.Adapter<ListViewHolder> {

    private ArrayList<Country> data;
    private String type;
    View view;

    public ListAdapter(ArrayList<Country> data, String type) {
        this.type = type;
        this.data = data;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if(type.equals("list"))
            view = inflater.inflate(R.layout.activity_simple_list, parent, false);
        else
            view = inflater.inflate(R.layout.grid_simple_list, parent, false);
        return new ListViewHolder(view, type);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
