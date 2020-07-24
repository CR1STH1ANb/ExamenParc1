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
/*
public class MainActivity extends AppCompatActivity implements Asynchtask {
    RecyclerView recyclerview=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview=(RecyclerView)findViewById(R.id.rcvPaises);

        //añadir un Divider a los elementos de la lista->Diseño de la linea de separacion de los items
        recyclerview.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        //Establecer el LayoutManager para definir la forma en la que se muestran los items en este caso en  forma de lista vertical
        recyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        //Solicitud WebService
        //https://my-json-server.typicode.com/SuannyTigselema/productos/producto
        //https://mercado-a4435.firebaseio.com/producto.json
        Map<String, String> datos = new HashMap<>();
        //https://mercado-a4435.firebaseio.com/producto.json
        WebService ws= new WebService("https://restcountries.eu/rest/v2/alpha/ecu",datos,
                MainActivity.this, (Asynchtask) MainActivity.this);

        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONArray JSONlistaProductos = new JSONArray(result);
        ArrayList<Pais> lstPais=new ArrayList<>();

        //Invoco al metodo de la clase productos que es para el parseo de datos-me devuelve un arraylist de producto
        lstPais = Pais.JsonObjectsBuild(JSONlistaProductos);

        //HASTA AQUÍ SÍ RECIBE LOS 11 PRODUCTOS
        //Envío la lista de productos a l
        adaptadorPais adapatorPa = new adaptadorPais(this, lstPais);
        recyclerview.setAdapter(adapatorPa);
    }
}*/




public class MainActivity extends AppCompatActivity implements Asynchtask {

    ArrayList<String> listDatos;
    RecyclerView recyclerview=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview=(RecyclerView)findViewById(R.id.rcvListaHortalizas);

        //añadir un Divider a los elementos de la lista->Diseño de la linea de separacion de los items
        recyclerview.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        //Establecer el LayoutManager para definir la forma en la que se muestran los items en este caso en  forma de lista vertical
        recyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        //Solicitud WebService
        //https://my-json-server.typicode.com/SuannyTigselema/productos/producto
        //https://mercado-a4435.firebaseio.com/producto.json
        Map<String, String> datos = new HashMap<>();
        //https://mercado-a4435.firebaseio.com/producto.json
        WebService ws= new WebService("https://restcountries.eu/rest/v2/lang/es",datos,
                MainActivity.this, (Asynchtask) MainActivity.this);

        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONArray JSONlistaProductos = new JSONArray(result);
        ArrayList<Pais> lstProductos=new ArrayList<Pais>();

        //Invoco al metodo de la clase productos que es para el parseo de datos-me devuelve un arraylist de producto
        lstProductos = Pais.JsonObjectsBuild(JSONlistaProductos);

        //HASTA AQUÍ SÍ RECIBE LOS 11 PRODUCTOS
        //Envío la lista de productos a l
        adaptadorPais adapatorHortalizas = new adaptadorPais(this, lstProductos);
        recyclerview.setAdapter(adapatorHortalizas);
    }
}