package com.example.examenparc1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.examenparc1.Model.Pais;
import com.example.examenparc1.Model.adaptadorPais;
import com.example.examenparc1.WebService.Asynchtask;
import com.example.examenparc1.WebService.WebService;


import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class MainActivity extends AppCompatActivity implements Asynchtask {

    ArrayList<String> listDatos;
    RecyclerView recyclerview=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview=(RecyclerView)findViewById(R.id.rcvListaHortalizas);

        recyclerview.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        recyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));



        Map<String, String> datos = new HashMap<>();

        WebService ws= new WebService("https://restcountries.eu/rest/v2/lang/es",datos,
                MainActivity.this, (Asynchtask) MainActivity.this);

        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONArray JSONlistaProductos = new JSONArray(result);
        ArrayList<Pais> lstProductos=new ArrayList<Pais>();


        lstProductos = Pais.JsonObjectsBuild(JSONlistaProductos);


        adaptadorPais adapatorHortalizas = new adaptadorPais(this, lstProductos);
        recyclerview.setAdapter(adapatorHortalizas);
    }
}