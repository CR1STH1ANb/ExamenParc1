package com.example.examenparc1.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Pais {

    private String name;
    private String img;
   /*  private String alpha2Code;
    private String alpha3Code;
    private String callingCodes;
    private String capital;
   private String name;
    private String topLevelDomain;
    private String alpha2Code;
    private String name;
    private String topLevelDomain;
    private String alpha2Code;*/
   public Pais(JSONObject a) throws JSONException {
       this.name  = a.getString("name").toString();
       this.img = a.getString("img").toString();

   }
    public static ArrayList<Pais> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Pais> pais = new ArrayList<>();
        for (int i = 0; i < datos.length() && i<20; i++) {
            pais.add(new Pais(datos.getJSONObject(i)));
        }
        return pais;
    }
    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }
}