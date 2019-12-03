package com.example.bimbelv1.BimbelActivity;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bimbelv1.MapsGO;
import com.example.bimbelv1.R;

import org.json.JSONException;
import org.json.JSONObject;

public class GoActivity extends AppCompatActivity {

    TextView tvName, tvJenjang, tvAlamat, tvDeskripsi;
    static String JSON_URL;
    private Button btnMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tvName = findViewById(R.id.tv_name);
        tvJenjang = findViewById(R.id.tv_jenjang);
        tvAlamat = findViewById(R.id.tv_alamat);
        tvDeskripsi = findViewById(R.id.tv_deskripsi);
        btnMap = findViewById(R.id.btnMap);

        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent map = new Intent(GoActivity.this, MapsGO.class);
                startActivity(map);
            }
        });

        JSON_URL = "https://raw.githubusercontent.com/BaariqAzhar/BimbelData/master/BimbelData.json";
        if (isConnected()) {
            loadBimbelData();
        } else {
            finish();
            Toast.makeText(this, "Nyalakan Koneksi Internet", Toast.LENGTH_LONG);
        }
    }

    private void loadBimbelData() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);
                    JSONObject bimbel = obj.getJSONObject("go");
                    tvName.setText(bimbel.getString("name"));
                    tvJenjang.setText(bimbel.getString("jenjang"));
                    tvAlamat.setText(bimbel.getString("alamat"));
                    tvDeskripsi.setText(bimbel.getString("deskripsi"));
                } catch (JSONException e) {
                    System.out.println("ambil json gak berhasil");
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    private boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        //we are connected to a network
        return connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }


}
