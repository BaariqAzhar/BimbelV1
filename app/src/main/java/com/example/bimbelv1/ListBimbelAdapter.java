package com.example.bimbelv1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListBimbelAdapter extends RecyclerView.Adapter<ListBimbelAdapter.ListViewHolder> {
    private ArrayList<Bimbel> listBimbel;

    private OnItemClickCallback onItemClickCallBack;

    public void setOnItemClickCallBack(OnItemClickCallback onItemClickCallBack){
        this.onItemClickCallBack = onItemClickCallBack;
    }


    public ListBimbelAdapter(ArrayList<Bimbel> list) {
        this.listBimbel = list;
    }

    @NonNull
    @Override
    public ListBimbelAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_bimbel, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListBimbelAdapter.ListViewHolder holder, int position) {
        Bimbel bimbel = listBimbel.get(position);
        Glide.with(holder.itemView.getContext())
                .load(bimbel.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(bimbel.getName());
        holder.tvAlamat.setText(bimbel.getAlamat());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallBack.onItemClicked(listBimbel.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBimbel.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvAlamat;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvAlamat = itemView.findViewById(R.id.tv_item_alamat);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Bimbel data);
    }
}
