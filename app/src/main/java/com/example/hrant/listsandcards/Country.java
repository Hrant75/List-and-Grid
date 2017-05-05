package com.example.hrant.listsandcards;

/**
 * Created by Hrant on 04.05.2017.
 */

public class Country {
    String iso;
    String name;
    int flag;
    int round_flag;
    boolean checked;

    public Country(String iso, String name, Integer flag, Integer round_flag, boolean checked) {
        this.iso = iso;
        this.name = name;
        this.flag = flag;
        this.round_flag = round_flag;
        this.checked = checked;
    }

    public String getIso() {
        return iso;
    }

    public String getName() {
        return name;
    }

    public Integer getFlag() {
        return flag;
    }

    public Integer getRound_flag() {
        return round_flag;
    }

    public boolean isChecked() {
        return checked;
    }
}
