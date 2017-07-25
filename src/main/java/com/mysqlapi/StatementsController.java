package com.mysqlapi;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
public class StatementsController {

    private String JSONFileString = null;
    private JSONArray JSONFileArray = null;

    public StatementsController(String filename) throws IOException, JSONException {
        JSONFileString = getFileAsString(filename);
        JSONFileArray = getStringAsJSONArray(JSONFileString);
    }

    public String getJSONFileString() {
        return JSONFileString;
    }

    public JSONArray getJSONFileArray() {
        return JSONFileArray;
    }

    public JSONObject getJSONObjectFromArray(int x) {
        return JSONFileArray.getJSONObject(x);
    }


    public String getStatementFromId(String id) {
        for(int x=0;x<getJSONObjectsNumberInJSONArray();x++){
            if(getJSONObjectFromArray(x).getString("id").equals(id)){
                return getJSONObjectFromArray(x).getString("query");
            }
        }
        return null;
    }

    private int getJSONObjectsNumberInJSONArray(){
        return JSONFileArray.length();
    }

    private String getFileAsString(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            sb.append(line);
            line = br.readLine();
        }
        return sb.toString();
    }

    private JSONArray getStringAsJSONArray(String string) throws JSONException {
        return new JSONArray(string);
    }


}
