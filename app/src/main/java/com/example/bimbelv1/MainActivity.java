package com.example.bimbelv1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.LinearInterpolator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvBimbel;
    private ArrayList<Bimbel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvBimbel = findViewById(R.id.rv_bimbel);
        rvBimbel.setHasFixedSize(true);

        list.addAll(BimbeData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvBimbel.setLayoutManager(new LinearLayoutManager(this));
        ListBimbelAdapter listBimbelAdapter = new ListBimbelAdapter(list);
        rvBimbel.setAdapter(listBimbelAdapter);
    }
}
