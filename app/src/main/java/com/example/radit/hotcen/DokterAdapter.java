package com.example.radit.hotcen;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DokterAdapter extends RecyclerView.Adapter<DokterAdapter.ViewHolder> {

    private ArrayList<Dokter> listdokter;
    private Context context;
    int i = 0;

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

//    @Override
//    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
//        holder.bindingData(listdokter.get(position));
//    }

    @Override
    public void onBindViewHolder(@NonNull final DokterAdapter.ViewHolder holder, final int position) {
        holder.tv_namadokter.setText(listdokter.get(position).getNama());
        Picasso.get().load(listdokter.get(position).getUrl()).into(holder.iv_url);
        holder.tv_jadwalpraktek.setText(listdokter.get(position).getJadwal());
        holder.tv_spesialis.setText(listdokter.get(position).getSpesialis());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, jadwalDokter.class);
                intent.putExtra("namadokter", listdokter.get(position).getNama());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                if (i % 2 == 0) {
                    holder.card.setCardBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
                    i++;
                }else{
                    holder.card.setCardBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent));
                    i++;
                }
            }});
        }


    @Override
    public int getItemCount() {
        return listdokter.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_url;
        private TextView tv_namadokter, tv_jadwalpraktek, tv_spesialis;
        private CardView card;

        public ViewHolder(View itemView) {
            super(itemView);
            iv_url = (ImageView) itemView.findViewById(R.id.url);
            tv_namadokter = (TextView) itemView.findViewById(R.id.nama_dokter);
            tv_jadwalpraktek = (TextView) itemView.findViewById(R.id.jadwalpraktek);
            tv_spesialis = (TextView) itemView.findViewById(R.id.spesialis_dokter);
            card = itemView.findViewById(R.id.carddokter);

        }
//        public void bindingData(Dokter data){
//            tv_namadokter.setText(data.getNama());
//            Picasso.get().load(listdokter.get.getUrl()).into(holder.iv_url);
//
//            tv_jadwalpraktek.setText(data.getJadwal());
//            card.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(context,AntrianPage.class);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(intent);
//                }
//            });
//        }
    }
}
