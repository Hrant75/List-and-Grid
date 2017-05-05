package com.example.hrant.listsandcards;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Hrant on 04.05.2017.
 */

public class ListViewHolder extends RecyclerView.ViewHolder {

    private TextView country_name;
    private ImageView country_flag;
    private CheckBox checkBox;
    private String type;

    public ListViewHolder(View itemView, String type) {
        super(itemView);
        this.type = type;

        if(type.equals("list")) {
            country_name = (TextView) itemView.findViewById(R.id.country_name_textView);
            country_flag = (ImageView) itemView.findViewById(R.id.country_flag_icon);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);
        }
        else {
            country_name = (TextView) itemView.findViewById(R.id.grid_textView);
            country_flag = (ImageView) itemView.findViewById(R.id.icon);
            checkBox = (CheckBox) itemView.findViewById(R.id.grid_checkBox);
        }
    }

    public void bind(Country country){
            country_name.setText(country_name != null ? country.getName() : "");
            if(type.equals("list"))
                country_flag.setImageResource(country_flag != null ? country.getFlag() : R.drawable.flag_unknown);
            else
                country_flag.setImageResource(country_flag != null ? country.getRound_flag() : R.drawable.flag_unknown);
            checkBox.setChecked(country.isChecked());
        }

//        if (country.isClickable()){
//            arrowView.setVisibility(View.VISIBLE);
//        } else {
//            arrowView.setVisibility(View.GONE);
//        }
    }
