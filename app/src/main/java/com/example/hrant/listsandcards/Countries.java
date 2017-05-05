package com.example.hrant.listsandcards;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Hrant on 04.05.2017.
 */

public class Countries extends ListViewActivity{
    ArrayList<Country> countryList = new ArrayList<>();
    Context context;

//    private static Countries instance;

    public Countries(Context context) {
        this.context = context;
        readFromFile();
    }

//    public static Countries getInstance(){
//        if(instance == null){
//            instance = new Countries(Context context);
//        }
//
//        return instance;
//    }

    public  ArrayList<Country> getcountries(){
        Collections.sort(countryList, new CountryComparator());
        return countryList;
    }

    private void readFromFile() {
        AssetManager assetManager = context.getAssets();

        try {
            InputStreamReader is = new InputStreamReader(assetManager.open("countries.csv"));
            BufferedReader reader = new BufferedReader(is);
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splittedLine = line.split(",");
                String iso = splittedLine[0];
                String name = splittedLine[1];

                int transparent = context.getResources().getIdentifier("flag_transparent", "drawable", "com.example.hrant.listsandcards");
                int flagId = context.getResources().getIdentifier("flag_" + splittedLine[0].toLowerCase(), "drawable", "com.example.hrant.listsandcards");
                int roundId = context.getResources().getIdentifier("s_flag_" + splittedLine[0].toLowerCase(), "drawable", "com.example.hrant.listsandcards");

                int flag = (flagId > 0)? flagId : transparent;
                int round_flag = (roundId > 0)? roundId : transparent;
                countryList.add(new Country(iso, name, flag, round_flag, false));
            }
        } catch (IOException e) {

        }
    }

    public class CountryComparator implements Comparator<Country> {
        @Override
        public int compare(Country o1, Country o2) {
            return o1.getName().compareTo(o2.getName());
        }

    }
}
