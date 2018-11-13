package com.example.radit.hotcen;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


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

        View view = inflater.inflate(R.layout.fragment_menu_rumah_sakit, container, false);

        ArrayList<Klinik> listklinik = new ArrayList<>();
        listklinik.add(new Klinik("Mata"));
        listklinik.add(new Klinik("THT"));
        listklinik.add(new Klinik("Otak"));
        listklinik.add(new Klinik("Kaki"));
        listklinik.add(new Klinik("Kepala"));

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setAdapter(new KlinikAdapter(listklinik,getActivity().getApplicationContext()));
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));

        return view;
    }

}
