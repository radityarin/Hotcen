package com.example.radit.hotcen;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends Fragment {


    public OrderFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ArrayList<Order> listorder = new ArrayList<>();
        final View view = inflater.inflate(R.layout.fragment_order, container, false);

        listorder.add(new Order("RS Universitas Brawijaya","Poli Gigi","13:00 - 18:00","dr. Trisna Utami","https://1.bp.blogspot.com/-QkGMaG48qBc/V3b5YsLCtGI/AAAAAAAAEQU/ZlW7n_herxk3shnLzQGs4Q9tDgcEj5_IACLcB/s1600/brawijaya-Malang-960x480.jpg"));

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setAdapter(new OrderAdapter(listorder, getContext()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

}
