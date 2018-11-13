package com.example.radit.hotcen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class DokterAdapter extends RecyclerView.Adapter<DokterAdapter.ViewHolder> {

    private ArrayList<Dokter> listdokter;
    private Context context;

    public DokterAdapter(ArrayList<Dokter> listdokter, Context context) {
        this.listdokter = listdokter;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_dokter, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_namadokter.setText(listdokter.get(position).getNamadokter());
        holder.tv_jadwalpraktek.setText(listdokter.get(position).getJadwaldokter());
    }

    @Override
    public int getItemCount() {
        return listdokter.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_url;
        private TextView tv_namadokter,tv_jadwalpraktek;
        public ViewHolder(View itemView) {
            super(itemView);
            iv_url = (ImageView) itemView.findViewById(R.id.url);
            tv_namadokter = (TextView) itemView.findViewById(R.id.nama_dokter);
            tv_jadwalpraktek = (TextView) itemView.findViewById(R.id.jadwalpraktek);
        }
    }
}
