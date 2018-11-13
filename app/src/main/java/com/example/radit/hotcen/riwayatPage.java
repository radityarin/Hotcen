package com.example.radit.hotcen;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;

public class riwayatPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat_page);

        ArrayList<Riwayat> listriwayat = new ArrayList<>();
        listriwayat.add(new Riwayat("Rumah Sakit C","Klinik THT","30 Agustus 2018"));
        listriwayat.add(new Riwayat("Rumah Sakit D","Klinik Mata","2 Agustus 2018"));
        listriwayat.add(new Riwayat("Rumah Sakit E","Klinik Mata","2 Juli 2018"));


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setAdapter(new RiwayatAdapter(listriwayat,getApplicationContext()));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.homebutton:
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.historybutton:
                        Intent intent2 = new Intent(getApplicationContext(), riwayatPage.class);
                        startActivity(intent2);
                        break;
                    case R.id.profilebutton:
//                        Intent intent3 = new Intent(context, )
                        break;
                }
                return true;
            }
        });

    }
}
