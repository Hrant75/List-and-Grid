package com.example.hrant.listsandcards;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Hrant on 04.05.2017.
 */

public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, CompoundButton.OnCheckedChangeListener{
    private View rootView;
    private TextView country_name;
    private ImageView country_flag;
    private CheckBox checkBox;
    private String type;
    private Country country;

    private ListItemClickListener itemClickListener;

    public ListViewHolder(View itemView, ListItemClickListener itemClickListener, String type) {
        super(itemView);
        this.type = type;
        this.itemClickListener = itemClickListener;

        if(type.equals("list")) {
            country_name = (TextView) itemView.findViewById(R.id.country_name_textView);
            country_flag = (ImageView) itemView.findViewById(R.id.country_flag_icon);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);
            rootView = itemView.findViewById(R.id.list_root);
        }
        else {
            country_name = (TextView) itemView.findViewById(R.id.grid_textView);
            country_flag = (ImageView) itemView.findViewById(R.id.icon);
            checkBox = (CheckBox) itemView.findViewById(R.id.grid_checkBox);
            rootView = itemView.findViewById(R.id.grid_root);
        }
        checkBox.setOnCheckedChangeListener(this);
        rootView.setOnClickListener(this);
    }

    public void bind(Country country){
        this.country = country;
            country_name.setText(country_name != null ? country.getName() : "");
            if(type.equals("list"))
                country_flag.setImageResource(country_flag != null ? country.getFlag() : R.drawable.flag_unknown);
            else
                country_flag.setImageResource(country_flag != null ? country.getRound_flag() : R.drawable.flag_unknown);
            checkBox.setChecked(country.isChecked());
        }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.list_root:
                notifyListItemClicked();
                break;

            case R.id.grid_root:
                notifyGridItemClicked();
                break;
        }
    }


    private void notifyListItemClicked(){
        if(itemClickListener != null){
            itemClickListener.onListItemClicked(country);
        }
    }

    private void notifyGridItemClicked(){
        if(itemClickListener != null){
            itemClickListener.onGridItemClicked(country);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        country.setChecked(isChecked);
        Log.d("testt", "onCheckedChanged checked " + country.getIso());
    }



    public interface ListItemClickListener{
        void onListItemClicked(Country country);
        void onGridItemClicked(Country country);
    }

//        if (country.isClickable()){
//            arrowView.setVisibility(View.VISIBLE);
//        } else {
//            arrowView.setVisibility(View.GONE);
//        }
}
