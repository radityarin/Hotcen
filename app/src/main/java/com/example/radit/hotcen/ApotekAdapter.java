package com.example.radit.hotcen;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ApotekAdapter extends RecyclerView.Adapter<ApotekAdapter.ViewHolder> {

    private ArrayList<Apotek> listapotek = new ArrayList<>();
    private Context context;

    public ApotekAdapter(ArrayList<Apotek> listapotek, Context context) {
        this.listapotek = listapotek;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_apotek, parent, false);
        return new ViewHolder(v);    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_nama.setText(listapotek.get(position).getNama());
        Picasso.get().load(listapotek.get(position).getUrl()).into(holder.iv_url);
    }

    @Override
    public int getItemCount() {
        return listapotek.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_url;
        private TextView tv_nama;
        public ViewHolder(View itemView) {
            super(itemView);
            iv_url = (ImageView) itemView.findViewById(R.id.url);
            tv_nama = (TextView) itemView.findViewById(R.id.nama_apotek);
        }
    }
}
