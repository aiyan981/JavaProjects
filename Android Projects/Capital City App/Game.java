package com.example.user.caps;

import java.util.List;
import java.util.Map;
import ca.roumani.i2c.Country;
import ca.roumani.i2c.CountryDB;

public class Game {
    private CountryDB db;
    private String answer;

    public Game(){
        this.db = new CountryDB();
    }

    public String qa(){
        List<String> capitals = this.db.getCapitals();
        int n = capitals.size();
        int index = (int)(n * Math.random());
        String c = capitals.get(index);

        Map<String, Country> data = db.getData();
        Country ref = data.get(c);

        if (Math.random() < 0.5){
            this.answer = ref.getCapital();
            return "What is the capital of " + ref.getName() + "? \n";

        }
        else{
            this.answer = ref.getName();
            return ref.getCapital() + " is the capital of? \n";
        }
    }

    public String getAnswer(){
        return this.answer;
    }
}
