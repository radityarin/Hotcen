package com.example.radit.hotcen;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class RSAdapter extends RecyclerView.Adapter<RSAdapter.ViewHolder> {

    private ArrayList<RumahSakit> listrumahsakit;
    private Context context;

    public RSAdapter(ArrayList<RumahSakit> listrumahsakit, Context context) {
        this.listrumahsakit = listrumahsakit;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_rs, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tv_nama.setText(listrumahsakit.get(position).getNama());
        holder.tv_alamat.setText(listrumahsakit.get(position).getAlamat());
        holder.tv_notelepon.setText(listrumahsakit.get(position).getNohp());

        holder.iv_url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,MenuRumahSakit.class);
                intent.putExtra("judul", listrumahsakit.get(position).getNama());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listrumahsakit.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_url;
        private TextView tv_nama,tv_alamat,tv_notelepon;
        public ViewHolder(View itemView) {
            super(itemView);
            iv_url = (ImageView) itemView.findViewById(R.id.url);
            tv_nama = (TextView) itemView.findViewById(R.id.nama_rumahsakit);
            tv_alamat = (TextView) itemView.findViewById(R.id.alamat_rumahsakit);
            tv_notelepon = (TextView) itemView.findViewById(R.id.nomortelepon_rumahsakit);
        }
    }
}
