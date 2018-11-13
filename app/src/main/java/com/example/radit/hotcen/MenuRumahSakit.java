package com.example.radit.hotcen;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MenuRumahSakit extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            switch (item.getItemId()) {
                case R.id.orderbutton:
                    MenuRumahSakitFragment menuRumahSakitFragment = new MenuRumahSakitFragment();
                    fragmentTransaction.replace(R.id.main_frame,menuRumahSakitFragment,"Home Fragment");
                    fragmentTransaction.commit();
                    return true;
                case R.id.callbutton:
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:0123456789"));
                    startActivity(intent);
                    return true;
                case R.id.mapsbutton:
                    Intent intent2 = new Intent(MenuRumahSakit.this,MapsLokasiRumahSakit.class);
                    startActivity(intent2);
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_rumah_sakit);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        MenuRumahSakitFragment menuRumahSakitFragment= new MenuRumahSakitFragment();
        fragmentTransaction.replace(R.id.main_frame,menuRumahSakitFragment,"Home Fragment");
        fragmentTransaction.commit();

    }

}