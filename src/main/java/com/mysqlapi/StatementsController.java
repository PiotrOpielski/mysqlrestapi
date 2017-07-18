package com.mysqlapi;

//zrobić konfigurację w pliku java
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Component
public class StatementsController {

    public String getFileAsString(String filename) throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader(filename));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            sb.append(line);
            line = br.readLine();
        }
       return sb.toString();
    }

    public JSONArray getStringAsJSONArray(String string) throws JSONException {
        return new JSONArray(string);
    }


}
