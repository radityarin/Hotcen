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

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private ArrayList<Order> listorder;
    private Context context;

    public OrderAdapter(ArrayList<Order> listorder, Context context) {
        this.listorder = listorder;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_order, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.ViewHolder holder, final int position) {
        holder.tv_namarumahsakit.setText(listorder.get(position).getNamarumahsakit());
        holder.tv_namapoli.setText(listorder.get(position).getNamapoli());
        holder.tv_namadokter.setText(listorder.get(position).getNamadokter());
        holder.tv_jadwal.setText(listorder.get(position).getJadwal());
        Picasso.get().load(listorder.get(position).getUrl()).into(holder.iv_url);
        holder.cv_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AntrianPage.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listorder.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_namarumahsakit, tv_namapoli,tv_namadokter,tv_jadwal;
        private CardView cv_order;
        private ImageView iv_url;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_namarumahsakit = (TextView) itemView.findViewById(R.id.nama_rumahsakit);
            tv_namapoli = (TextView) itemView.findViewById(R.id.nama_poli);
            tv_namadokter = (TextView) itemView.findViewById(R.id.nama_dokter);
            tv_jadwal = (TextView) itemView.findViewById(R.id.jadwal);
            iv_url = (ImageView) itemView.findViewById(R.id.url);
            cv_order = (CardView) itemView.findViewById(R.id.cardorder);
        }
    }
}
