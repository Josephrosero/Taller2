package com.i043114.taller2.Parser;

import com.i043114.taller2.Models.Country2;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 26/09/2017.
 */

public class JsonContry2 {
    public static List<Country2> getData(String content) throws JSONException {
        JSONArray jsonArray = new JSONArray(content);
        List<Country2> countryList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject item2 = jsonArray.getJSONObject(i);
            Country2 country2 = new Country2();
            country2.setName(item2.getString("name")); //iugala a lo de internet
            country2.setCapital(item2.getString("capital"));
            country2.setAlphacode(item2.getString("alpha3Code"));
            country2.setRegion(item2.getString("region"));
            country2.setPopulation(item2.getString("population"));
            countryList.add(country2);
        }
        return countryList;
    }
}
