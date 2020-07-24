package com.example.examenparc1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.examenparc1.Model.pais;
import com.example.examenparc1.Model.adaptadorPs;
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

        WebService ws= new WebService("https://restcountries.eu/rest/v2/all",datos,
                MainActivity.this, (Asynchtask) MainActivity.this);

        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONArray JSONlistaProductos = new JSONArray(result);
        ArrayList<pais> lstProductos=new ArrayList<pais>();


        lstProductos = pais.JsonObjectsBuild(JSONlistaProductos);


        adaptadorPs adapatorHortalizas = new adaptadorPs(this, lstProductos);
        recyclerview.setAdapter(adapatorHortalizas);
    }
    public void onClick(View view) {

        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);

    }

}