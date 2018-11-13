package com.example.radit.hotcen;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {


    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_history, container, false);


        ArrayList<Riwayat> listriwayat = new ArrayList<>();
        listriwayat.add(new Riwayat("Rumah Sakit C","Klinik THT","30 Agustus 2018"));
        listriwayat.add(new Riwayat("Rumah Sakit D","Klinik Mata","2 Agustus 2018"));
        listriwayat.add(new Riwayat("Rumah Sakit E","Klinik Mata","2 Juli 2018"));

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setAdapter(new RiwayatAdapter(listriwayat,getActivity().getApplicationContext()));
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        return view;
    }

}
