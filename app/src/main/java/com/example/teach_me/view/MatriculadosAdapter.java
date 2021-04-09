package com.example.teach_me.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teach_me.R;
import com.example.teach_me.controller.UsuarioController;
import com.example.teach_me.model.Aula;
import com.example.teach_me.model.Usuario;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MatriculadosAdapter extends RecyclerView.Adapter<MatriculadosAdapter.MatriculadosHolder> {
    private Context context;
    private List<Aula> matriculados;
    UsuarioController usuarioController;
    Usuario usuarioReferente;

    public MatriculadosAdapter(Context context, List<Aula> matriculados){
        this.context = context;
        this.matriculados = matriculados;
        usuarioController = UsuarioController.getInstance(context);
        usuarioReferente = new Usuario();
    }

    public static class MatriculadosHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView fotoUsuario;
        TextView nmUsuario, horario;

        public MatriculadosHolder(@NonNull View itemView) {
            super(itemView);
            this.cardView = itemView.findViewById(R.id.cardview);
            this.fotoUsuario = itemView.findViewById(R.id.img_avatar);
            this.nmUsuario = itemView.findViewById(R.id.txt_nome);
            horario = itemView.findViewById(R.id.txt_horario);
        }
    }

    @NonNull
    @Override
    /* Retorna uma view com o layout item_destaques
    *  Esse método replica o layout para cada item do Arraylist
    * */
    public MatriculadosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_matriculados,parent,false);
        return new MatriculadosHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatriculadosHolder holder, final int position) {
        try {
            usuarioReferente = usuarioController.get(matriculados.get(position).getCdUsuarioAluno());
            holder.nmUsuario.setText(usuarioReferente.getNmUsuario());
            if(usuarioReferente.getFoto() != null){
                Picasso.get().load(usuarioReferente.getFoto()).into(holder.fotoUsuario);
            }
            holder.horario.setText(matriculados.get(position).getHorario());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return matriculados.size();
    }


}
