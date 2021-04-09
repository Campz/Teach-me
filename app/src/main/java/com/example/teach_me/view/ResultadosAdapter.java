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
import com.example.teach_me.controller.DisciplinaController;
import com.example.teach_me.controller.UsuarioController;
import com.example.teach_me.model.Anuncio;
import com.example.teach_me.model.Disciplina;
import com.example.teach_me.model.Usuario;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ResultadosAdapter extends RecyclerView.Adapter<ResultadosAdapter.ResultadosHolder> {
    private Context context;
    private List<Anuncio> resultados;

    private UsuarioController usuarioController;
    private DisciplinaController disciplinaController;

    private Usuario usuarioReferente;
    private Disciplina disciplinaReferente;

    public ResultadosAdapter(Context context, List<Anuncio> resultados){
        this.context = context;
        this.resultados = resultados;
        usuarioController = UsuarioController.getInstance(context);
        disciplinaController = DisciplinaController.getInstance(context);
        usuarioReferente = new Usuario();
        disciplinaReferente = new Disciplina();
    }

    public static class ResultadosHolder extends RecyclerView.ViewHolder {
        CardView cv_anuncio;
        ImageView img_anuncio;
        TextView txt_nmProfessor;
        TextView txt_nomeCurso;
        TextView txt_nomeLocal;
        TextView txt_preco;
        TextView txt_avaliacao;


        public ResultadosHolder(@NonNull View itemView) {
            super(itemView);
            this.cv_anuncio = itemView.findViewById(R.id.cv_anuncio);
            this.img_anuncio = itemView.findViewById(R.id.img_professor);
            this.txt_nmProfessor = itemView.findViewById(R.id.txt_nomeprof);
            this.txt_nomeCurso = itemView.findViewById(R.id.txt_nomecurso);
            this.txt_nomeLocal = itemView.findViewById(R.id.txt_nomelocal);
            this.txt_preco =  itemView.findViewById(R.id.txt_preco);
            this.txt_avaliacao = itemView.findViewById(R.id.txt_avaliacao);
        }
    }

    @NonNull
    @Override
    /* Retorna uma view com o layout item_destaques
    *  Esse método replica o layout para cada item do Arraylist
    * */
    public ResultadosHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_anuncios,parent,false);
        return new ResultadosHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultadosHolder holder, final int position) {
        try {
            usuarioReferente = usuarioController.get(resultados.get(position).getCdUsuarioProfessor());
            disciplinaReferente = disciplinaController.get(resultados.get(position).getCdDisciplina());
            Picasso.get().load(usuarioReferente.getFoto()).into(holder.img_anuncio);
            holder.txt_nmProfessor.setText(usuarioReferente.getNmUsuario());
            holder.txt_avaliacao.setText(usuarioReferente.getAvaliacao());
            holder.txt_nomeCurso.setText(disciplinaReferente.getNmDisciplina());
            holder.txt_nomeLocal.setText("Cefet Timóteo");
        final String preço = "R$" + resultados.get(position).getValor() + "/h";
        holder.txt_preco.setText(preço);
        holder.cv_anuncio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AnuncioActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Professor", usuarioReferente.getId());
                intent.putExtra("idAnuncio", resultados.get(position).getId().toString());
                intent.putExtra("Valor",preço);
                context.startActivity(intent);
            }
        });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return resultados.size();
    }


}
