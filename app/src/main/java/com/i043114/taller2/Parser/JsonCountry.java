package com.i043114.taller2.Parser;

import com.i043114.taller2.Models.Country;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 26/09/2017.
 */

public class JsonCountry {

// importar todoooo
    public static List<Country> getData(String content) throws JSONException {
        JSONArray jsonArray = new JSONArray(content);
        List<Country> countryList = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject item = jsonArray.getJSONObject(i);
            Country country = new Country();
            country.setName(item.getString("name")); //iugala a lo de internet
            country.setCapital(item.getString("capital"));
            country.setAlphacode(item.getString("alpha3Code"));
            countryList.add(country);
        }
        return countryList;
    }
}
