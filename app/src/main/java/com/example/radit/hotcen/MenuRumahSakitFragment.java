package com.example.radit.hotcen;


import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuRumahSakitFragment extends Fragment {

    public MenuRumahSakitFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final ArrayList<Klinik> listklinik = new ArrayList<>();
        final View view = inflater.inflate(R.layout.fragment_menu_rumah_sakit, container, false);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Rumah Sakit Universitas Brawijaya");
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dt : dataSnapshot.getChildren()) {
                    Klinik mKlinik = dt.getValue(Klinik.class);
                    listklinik.add(mKlinik);
                }

                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
                recyclerView.setAdapter(new KlinikAdapter(listklinik, getActivity().getApplicationContext()));
                recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        TextView mNama = view.findViewById(R.id.nama_rumahsakit);
        ImageView mUrl = view.findViewById(R.id.foto_rumahsakit);
        mNama.setText(getArguments().getString("judul"));
        Picasso.get().load(getArguments().getString("gambar")).into(mUrl);
        return view;
    }


}
