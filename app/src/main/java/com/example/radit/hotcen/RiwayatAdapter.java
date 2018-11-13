package com.example.radit.hotcen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RiwayatAdapter extends RecyclerView.Adapter<RiwayatAdapter.ViewHolder> {

    private ArrayList<Riwayat> listriwayat;
    private Context context;

    public RiwayatAdapter(ArrayList<Riwayat> listriwayat, Context context) {
        this.listriwayat = listriwayat;
        this.context = context;
    }

    @NonNull
    @Override
    public RiwayatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_history, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RiwayatAdapter.ViewHolder holder, int position) {
        holder.tv_namaklinik.setText(listriwayat.get(position).getNamaklinik());
        holder.tv_namarumahsakit.setText(listriwayat.get(position).getNamarumahsakit());
        holder.tv_tanggalkunjung.setText(listriwayat.get(position).getTanggalkunjungan());
    }

    @Override
    public int getItemCount() {
        return listriwayat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_namarumahsakit,tv_namaklinik, tv_tanggalkunjung;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_namarumahsakit = (TextView) itemView.findViewById(R.id.nama_rumahsakit);
            tv_namaklinik = (TextView) itemView.findViewById(R.id.nama_klinik);
            tv_tanggalkunjung = (TextView) itemView.findViewById(R.id.tanggalkunjung);
        }
    }
}
