package com.example.radit.hotcen;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class KlinikAdapter extends RecyclerView.Adapter<KlinikAdapter.ViewHolder> {

    private ArrayList<Klinik> listklinik;
    private Context context;

    public KlinikAdapter(ArrayList<Klinik> listklinik, Context context) {
        this.listklinik = listklinik;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_klinik, parent, false);
        return new KlinikAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull KlinikAdapter.ViewHolder holder, int position) {
        holder.tv_namaklinik.setText(listklinik.get(position).getNamaPoli());
        Picasso.get().load(listklinik.get(position).getUrl()).into(holder.iv_url);
        holder.cv_klinik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,jadwalDokter.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listklinik.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_url;
        private TextView tv_namaklinik;
        private CardView cv_klinik;
        public ViewHolder(View itemView) {
            super(itemView);
            iv_url = (ImageView) itemView.findViewById(R.id.url);
            tv_namaklinik = (TextView) itemView.findViewById(R.id.nama_klinik);
            cv_klinik = (CardView) itemView.findViewById(R.id.cardklinik);
        }
    }
}
