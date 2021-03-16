package com.example.teach_me.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teach_me.R;
import com.example.teach_me.model.Usuario;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DestaquesAdapter extends RecyclerView.Adapter<DestaquesAdapter.DestaquesHolder> {
    private Context context;
    private List<Usuario> destaques;

    public DestaquesAdapter(Context context, List<Usuario> destaques){
        this.context = context;
        this.destaques = destaques;
    }

    public static class DestaquesHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView fotoUsuario;
        TextView nmUsuario;
        RatingBar ratingBar;

        public DestaquesHolder(@NonNull View itemView) {
            super(itemView);
            this.cardView = itemView.findViewById(R.id.cardview);
            this.fotoUsuario = itemView.findViewById(R.id.img_avatar);
            this.nmUsuario = itemView.findViewById(R.id.txt_nome);
            this.ratingBar = itemView.findViewById(R.id.ratingBar);
        }
    }

    @NonNull
    @Override
    /* Retorna uma view com o layout item_destaques
    *  Esse método replica o layout para cada item do Arraylist
    * */
    public DestaquesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_destaques,parent,false);
        return new DestaquesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DestaquesHolder holder, final int position) {
        holder.nmUsuario.setText(destaques.get(position).getNmUsuario());
        holder.ratingBar.setRating(Float.parseFloat(destaques.get(position).getAvaliacao()));
        Picasso.get().load(destaques.get(position).getFoto()).into(holder.fotoUsuario);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PerfilActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("NmUsuario",destaques.get(position).getNmUsuario());
                intent.putExtra("Avaliacao",destaques.get(position).getAvaliacao());
                intent.putExtra("Foto",destaques.get(position).getFoto());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return destaques.size();
    }


}
