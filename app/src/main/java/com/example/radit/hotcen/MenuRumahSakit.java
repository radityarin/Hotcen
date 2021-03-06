package com.example.radit.hotcen;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MenuRumahSakit extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth menuRS;
    private ImageView cardPoli;


    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            switch (item.getItemId()) {
                case R.id.orderbutton:
                    MenuRumahSakitFragment menuRumahSakitFragment = new MenuRumahSakitFragment();
                    fragmentTransaction.replace(R.id.main_frame, menuRumahSakitFragment, "Home Fragment");
                    fragmentTransaction.commit();
                    return true;
                case R.id.callbutton:
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    String notelepon = getIntent().getStringExtra("notelpon");
                    intent.setData(Uri.parse("tel:"+notelepon));
                    startActivity(intent);
                    return true;
                case R.id.mapsbutton:
                    Intent intent2 = new Intent(MenuRumahSakit.this, LokasiRumahSakit.class);
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
//        menuRS = FirebaseAuth.getInstance();
//        LinearLayout kartuPoli = (LinearLayout) findViewById(R.id.cardklinik);
//        kartuPoli.setOnClickListener(this);


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        MenuRumahSakitFragment menuRumahSakitFragment = new MenuRumahSakitFragment();
        Bundle bundle = new Bundle();
        String mJudul = getIntent().getStringExtra("judul");
        bundle.putString("gambar", getIntent().getStringExtra("gambar"));
        bundle.putString("judul", mJudul);
        bundle.putString("notelpon", getIntent().getStringExtra("notelpon"));
        menuRumahSakitFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.main_frame, menuRumahSakitFragment, "Home Fragment");
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {

        FirebaseUser user = menuRS.getCurrentUser();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("RumahSakitA").child(user.getUid());
//        DataPoli polidata = new DataPoli();

    }
}
