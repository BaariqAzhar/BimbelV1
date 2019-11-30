package com.example.bimbelv1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.example.bimbelv1.BimbelActivity.BrawActivity;
import com.example.bimbelv1.BimbelActivity.CahayaActivity;
import com.example.bimbelv1.BimbelActivity.EfActivity;
import com.example.bimbelv1.BimbelActivity.GoActivity;
import com.example.bimbelv1.BimbelActivity.InsanActivity;
import com.example.bimbelv1.BimbelActivity.IpiActivity;
import com.example.bimbelv1.BimbelActivity.MitraActivity;
import com.example.bimbelv1.BimbelActivity.NeutronActivity;
import com.example.bimbelv1.BimbelActivity.NurulActivity;
import com.example.bimbelv1.BimbelActivity.SonyActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvBimbel;
    private ArrayList<Bimbel> list = new ArrayList<>();

    private TextView tvCobaJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvBimbel = findViewById(R.id.rv_bimbel);
        rvBimbel.setHasFixedSize(true);

        list.addAll(BimbeData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvBimbel.setLayoutManager(new LinearLayoutManager(this));
        ListBimbelAdapter listBimbelAdapter = new ListBimbelAdapter(list);
        rvBimbel.setAdapter(listBimbelAdapter);

        listBimbelAdapter.setOnItemClickCallBack(new ListBimbelAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Bimbel data) {
                showSelectedBimbel(data);
            }
        });
    }

    private void showAboutUs() {
        Intent moveIntent = new Intent(MainActivity.this, AboutUs.class);
        startActivity(moveIntent);
    }

    private void showSelectedBimbel(Bimbel bimbel) {
//        Toast.makeText(this, "Kamu memilih " + bimbel.getName(), Toast.LENGTH_LONG).show();
        showBimbelActivity(bimbel);
    }

    private void showBimbelActivity(Bimbel bimbel) {
        Intent intent = new Intent();
        switch (bimbel.getName()) {
            case "English First":
                intent = new Intent(MainActivity.this, EfActivity.class);
                startActivity(intent);
                break;
            case "Ganesha Operation":
                intent = new Intent(MainActivity.this, GoActivity.class);
                startActivity(intent);
                break;
            case "Neutron":
                intent = new Intent(MainActivity.this, NeutronActivity.class);
                startActivity(intent);
                break;
            case "Sony Sugema College":
                intent = new Intent(MainActivity.this, SonyActivity.class);
                startActivity(intent);
                break;
            case "Nurul Fikri":
                intent = new Intent(MainActivity.this, NurulActivity.class);
                startActivity(intent);
                break;
            case "Cahaya Ilmu":
                intent = new Intent(MainActivity.this, CahayaActivity.class);
                startActivity(intent);
                break;
            case "Brawijaya Study Club":
                intent = new Intent(MainActivity.this, BrawActivity.class);
                startActivity(intent);
                break;
            case "Insan Madani Institute":
                intent = new Intent(MainActivity.this, InsanActivity.class);
                startActivity(intent);
                break;
            case "IPIEMS":
                intent = new Intent(MainActivity.this, IpiActivity.class);
                startActivity(intent);
                break;
            case "Mitra Walet":
                intent = new Intent(MainActivity.this, MitraActivity.class);
                startActivity(intent);
                break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_list:
                showRecyclerList();
                break;

            case R.id.action_aboutus:
                showAboutUs();
                break;
        }
    }
}
