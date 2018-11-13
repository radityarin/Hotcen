package com.example.radit.hotcen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class jadwalDokter extends AppCompatActivity {

    private Button daftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal_dokter);
        setTitle("Jadwal Dokter");
        ArrayList<Dokter> listdokter = new ArrayList<>();
        listdokter.add(new Dokter("Bambang","10:00 - 14:00"));
        listdokter.add(new Dokter("Budi","15:00 - 18:00"));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setAdapter(new DokterAdapter(listdokter,getApplicationContext()));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        }

}
