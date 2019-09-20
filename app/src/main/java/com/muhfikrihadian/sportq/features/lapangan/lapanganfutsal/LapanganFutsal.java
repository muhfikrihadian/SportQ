package com.muhfikrihadian.sportq.features.lapangan.lapanganfutsal;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.muhfikrihadian.sportq.R;
import com.muhfikrihadian.sportq.adapter.ListLapanganAdapter;
import com.muhfikrihadian.sportq.pojos.LapanganModel;

import java.util.ArrayList;

public class LapanganFutsal extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ListLapanganAdapter adapter;
    private ArrayList<LapanganModel> pekerjaanArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lapangan_futsal);
        getSupportActionBar();
        getSupportActionBar().setTitle("Lapangan Futsal");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        addData();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new ListLapanganAdapter(pekerjaanArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(LapanganFutsal.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    private void addData() {
        pekerjaanArrayList = new ArrayList<>();
        pekerjaanArrayList.add(new LapanganModel("Artu Futsal", "Rp.100.000 / Jam", "Jagakarsa, Jakarta Selatan"));
        pekerjaanArrayList.add(new LapanganModel("Planet Futsal", "Rp.80.000 / Jam", "Kenjeran, Surabaya"));
        pekerjaanArrayList.add(new LapanganModel("Bengkel Futsal", "Rp.90.000 / Jam", "Tebet, Jakarta Selatan"));
        pekerjaanArrayList.add(new LapanganModel("Ciputra Futsal", "Rp.150.000 / Jam", "Koja, Jakarta Utara"));
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
