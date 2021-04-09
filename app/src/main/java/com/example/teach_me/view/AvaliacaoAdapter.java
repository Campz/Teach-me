package com.example.teach_me.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teach_me.R;
import com.example.teach_me.controller.AnuncioController;
import com.example.teach_me.controller.DisciplinaController;
import com.example.teach_me.controller.UsuarioController;
import com.example.teach_me.model.Anuncio;
import com.example.teach_me.model.Aula;
import com.example.teach_me.model.Disciplina;
import com.example.teach_me.model.Usuario;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AvaliacaoAdapter extends RecyclerView.Adapter<AvaliacaoAdapter.AvaliacaoHolder> {
    private Context context;
    private List<Aula> aulas;
    private AnuncioController anuncioController;
    private UsuarioController usuarioController;
    private Usuario usuarioReferente;

    public AvaliacaoAdapter(Context context, List<Aula> aulas){
        this.context = context;
        this.aulas = aulas;
        anuncioController = AnuncioController.getInstance(context);
        usuarioController = UsuarioController.getInstance(context);
        usuarioReferente = new Usuario();
    }

    public static class AvaliacaoHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        CircleImageView fotoUsuario;
        TextView txt_tituloAvaliacao, txt_descricaoAvaliacao;
        RatingBar avaliacaoValor;

        public AvaliacaoHolder(@NonNull View itemView) {
            super(itemView);
            this.cardView = itemView.findViewById(R.id.cv_avalicao);
            this.fotoUsuario = itemView.findViewById(R.id.img_usuarioAvaliacao);
            this.txt_tituloAvaliacao = itemView.findViewById(R.id.txt_tituloAvaliacao);
            this.txt_descricaoAvaliacao = itemView.findViewById(R.id.txt_descricaoAvaliacao);
            this.avaliacaoValor = itemView.findViewById(R.id.rating_avaliacao);
        }
    }

    @NonNull
    @Override
    /* Retorna uma view com o layout item_destaques
    *  Esse método replica o layout para cada item do Arraylist
    * */
    public AvaliacaoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_avaliacao,parent,false);
        return new AvaliacaoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AvaliacaoHolder holder, final int position) {
            try {
                usuarioReferente = usuarioController.get(aulas.get(position).getCdUsuarioAluno());
                if (usuarioReferente.getFoto() != null) {
                    Picasso.get().load(usuarioReferente.getFoto()).into(holder.fotoUsuario);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            holder.txt_tituloAvaliacao.setText(aulas.get(position).getTitulo());
            holder.txt_descricaoAvaliacao.setText(aulas.get(position).getDescricao());
            holder.avaliacaoValor.setRating((float) aulas.get(position).getAvaliacao());
    }

    @Override
    public int getItemCount() {
        return aulas.size();
    }


}
