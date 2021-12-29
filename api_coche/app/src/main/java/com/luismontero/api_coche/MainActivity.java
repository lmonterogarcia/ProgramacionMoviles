package com.luismontero.api_coche;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.luismontero.api_coche.model.Coche;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String hosting = "http://bestipescook.es/Luis/";
    private Coche coche;
    private List<Coche> lstCoches;
    private TextView txtResult;
    EditText txtId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResult = findViewById(R.id.lblResult);
        txtId = findViewById(R.id.txtId);

        findViewById(R.id.btnGet).setOnClickListener( v -> getCoche());
        findViewById(R.id.btnGetAll).setOnClickListener( v -> getAllCoche());

    }

    private void getCoche() {
        String url = hosting + "get_coche.php?txtId=" + txtId.getText().toString();
        //Toast.makeText(getApplicationContext(), url,Toast.LENGTH_LONG).show();

        Volley.newRequestQueue(this).add(new StringRequest(Request.Method.GET,url,
                s -> {
                    if(s.equals("")) {
                        Toast.makeText(getApplicationContext(), "No se ha encontrado el coche con la id " + txtId.getText().toString(),Toast.LENGTH_LONG).show();
                    } else {
                        coche = new Gson().fromJson(s,new TypeToken<Coche>() {}.getType());
                        showCoche();
                    }

                }
                , VolleyError -> {

        }));
    }

    private void showCoche() {
        txtResult.setText(coche.toString());
    }

    private void getAllCoche() {
        String url = hosting + "lst_coche.php";
        //Toast.makeText(getApplicationContext(), url,Toast.LENGTH_LONG).show();

        Volley.newRequestQueue(this).add(new StringRequest(Request.Method.GET,url,
                s -> {
                    if(s.equals("null")) {
                        Toast.makeText(getApplicationContext(), "No hay coches " + txtId.getText().toString(),Toast.LENGTH_LONG).show();
                    } else {
                        lstCoches = new ArrayList<>();
                        lstCoches = new Gson().fromJson(s,new TypeToken<List<Coche>>() {}.getType());
                        showAllCoche();
                    }
                }
                , VolleyError -> {

        }));
    }

    private void showAllCoche() {

        StringBuffer str = new StringBuffer();
        lstCoches.forEach( c -> str.append(c.toString()).append("\n\n"));

        txtResult.setText(str);
    }
}