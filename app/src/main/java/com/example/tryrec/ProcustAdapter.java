package com.example.tryrec;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProcustAdapter extends RecyclerView.Adapter<ProcustAdapter.ViewHolder>{
    private List<products> listproducts;
    int qantité=0;
    Context context;

    public List<products> getListproducts() {
        return listproducts;
    }

    public void setListproducts(List<products> listproducts) {
        this.listproducts = listproducts;
    }

    public ProcustAdapter(List<products> listproducts, Context context) {
        this.listproducts = listproducts;
        this.context = context;
    }

    @NonNull
    @Override
    public ProcustAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutproduct,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ProcustAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.nom.setText(listproducts.get(position).nom);
        holder.prix.setText(listproducts.get(position).prix);
        holder.qtite.setText(String.valueOf(listproducts.get(position).quantité_product));
        String imageuri = null;
        imageuri=listproducts.get(position).img;
        Picasso.get().load(imageuri).into(holder.img);
        //int drawableRes =holder.itemView.getContext().getResources().getIdentifier(listproducts.get(position).getImg(),
        //     "drawable",holder.itemView.getContext().getPackageName());
        //Glide.with(holder.itemView.getContext()).load(drawableRes).into(holder.img);
        holder.btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listproducts.get(position).setQuantité_product(listproducts.get(position).quantité_product+1);
                holder.qtite.setText(String.valueOf(listproducts.get(position).quantité_product));
            }
        });
        holder.btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listproducts.get(position).quantité_product>1){
                    listproducts.get(position).setQuantité_product(listproducts.get(position).quantité_product-1);
                    holder.qtite.setText(String.valueOf(listproducts.get(position).quantité_product));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listproducts.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView nom, prix, qtite;
        Button btnplus, btnminus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgview);
            nom = itemView.findViewById(R.id.txtnom);
            prix = itemView.findViewById(R.id.txtprix);
            qtite = itemView.findViewById(R.id.qtite);
            btnplus = itemView.findViewById(R.id.btnplus);
            btnminus = itemView.findViewById(R.id.btnminus);
        }
    }
}
