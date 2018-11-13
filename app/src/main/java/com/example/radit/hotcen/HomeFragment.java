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
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ArrayList<RumahSakit> listrumahsakit = new ArrayList<>();
        listrumahsakit.add(new RumahSakit("dssdsd","Rumah Sakit A","Jl Soekarno Hatta","081321323"));
        listrumahsakit.add(new RumahSakit("dasdd","Rumah Sakit B","Jl MT Haryono","023112323"));
        listrumahsakit.add(new RumahSakit("dasdd","Rumah Sakit C","Jl MT Haryono2","023112323"));
        listrumahsakit.add(new RumahSakit("dasdd","Rumah Sakit D","Jl MT Haryono3","023112323"));
        listrumahsakit.add(new RumahSakit("dasdd","Rumah Sakit E","Jl MT Haryono4","023112323"));
        listrumahsakit.add(new RumahSakit("dasdd","Rumah Sakit F","Jl MT Haryono5","023112323"));

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setAdapter(new RSAdapter(listrumahsakit,getActivity().getApplicationContext()));
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));


        return view;
    }

}
