package com.i043114.taller2;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.i043114.taller2.Adapter.AdapterCountry;
import com.i043114.taller2.Adapter.AdapterCountry2;
import com.i043114.taller2.Connection.HttpManager;
import com.i043114.taller2.Models.Country;
import com.i043114.taller2.Models.Country2;
import com.i043114.taller2.Parser.JsonContry2;
import com.i043114.taller2.Parser.JsonCountry;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    Button button;
    RecyclerView recyclerView;
    RecyclerView recyclerView2;
    //List<Country> countryList;
    List<Country2> countryList2;
    //AdapterCountry adapterCountry;
    AdapterCountry2 adapterCountry2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        progressBar = (ProgressBar) findViewById(R.id.id_pb_item);
        button = (Button) findViewById(R.id.id_btn_listcountries);
        recyclerView2 = (RecyclerView) findViewById(R.id.id_rv_item);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView2.setLayoutManager(linearLayoutManager);

    }

    // Metodo para validar la conexion a internet


    public Boolean isOnLine() {
        // Hacer llamado al servicio de conectividad utilizando el ConnectivityManager 
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        // Obtener el estado de la conexion a internet en el dispositivo
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo(); // Validar el estado obtenido de la conexion
        if (networkInfo != null) {
            return true;
        } else {
            return false;
        }
    }

    public void loadData(View view) {
        if (isOnLine()) {
            TaskCountry taskCountry = new TaskCountry();
            taskCountry.execute("https://restcountries.eu/rest/v2/lang/es");
        } else {
            Toast.makeText(this, "Sin conexion", Toast.LENGTH_SHORT).show();
        }
    }


    public void processData() {
        adapterCountry2 = new AdapterCountry2(countryList2, getApplicationContext());
        recyclerView2.setAdapter(adapterCountry2);
    }


public class TaskCountry extends AsyncTask<String, String, String> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected String doInBackground(String... strings) {
        String content = null;
        try {
            content = HttpManager.getData(strings[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;

    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            countryList2 = JsonContry2.getData(s);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        processData();
        progressBar.setVisibility(View.GONE);
    }
}
}
