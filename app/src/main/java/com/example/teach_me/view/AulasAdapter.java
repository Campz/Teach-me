package com.example.teach_me.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class AulasAdapter extends RecyclerView.Adapter<AulasAdapter.AulasHolder> {
    private Context context;
    private List<Aula> aulas;
    private AnuncioController anuncioController;
    private DisciplinaController disciplinaController;
    private UsuarioController usuarioController;

    public AulasAdapter(Context context, List<Aula> aulas){
        this.context = context;
        this.aulas = aulas;
        anuncioController = AnuncioController.getInstance(context);
        disciplinaController = DisciplinaController.getInstance(context);
        usuarioController = UsuarioController.getInstance(context);
    }

    public static class AulasHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        CircleImageView fotoUsuario;
        TextView nmDisciplina, nmProfessor, horario;

        public AulasHolder(@NonNull View itemView) {
            super(itemView);
            this.cardView = itemView.findViewById(R.id.cv_aula);
            this.fotoUsuario = itemView.findViewById(R.id.img_professorAula);
            this.nmDisciplina = itemView.findViewById(R.id.txt_disciplinaAula);
            this.nmProfessor = itemView.findViewById(R.id.txt_professorAula);
            this.horario = itemView.findViewById(R.id.txt_horarioAula);
        }
    }

    @NonNull
    @Override
    /* Retorna uma view com o layout item_destaques
    *  Esse método replica o layout para cada item do Arraylist
    * */
    public AulasHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_aulas,parent,false);
        return new AulasHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AulasHolder holder, final int position) {
        Anuncio anuncioReferente = new Anuncio();
        Disciplina disciplinaReferente = new Disciplina();
        Usuario usuarioReferente = new Usuario();
        try {
            anuncioReferente = anuncioController.get(aulas.get(position).getCdAnuncio());
            disciplinaReferente = disciplinaController.get(anuncioReferente.getCdDisciplina());
            usuarioReferente = usuarioController.get(anuncioReferente.getCdUsuarioProfessor());
        } catch (Exception e) {
            e.printStackTrace();
        }
        holder.nmDisciplina.setText(disciplinaReferente.getNmDisciplina());
        String aux = "Professor: " + usuarioReferente.getNmUsuario();
        holder.nmProfessor.setText(aux);
        aux = "Horário: " + aulas.get(position).getHorario();
        holder.horario.setText(aux);

        if(usuarioReferente.getFoto() != null){
             Picasso.get().load(usuarioReferente.getFoto()).into(holder.fotoUsuario);
        }
//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, PerfilActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                intent.putExtra("NmUsuario", destaques.get(position).getNmUsuario());
//                intent.putExtra("Avaliacao", destaques.get(position).getAvaliacao());
//                intent.putExtra("Foto", destaques.get(position).getFoto());
//                intent.putExtra("Biografia", destaques.get(position).getDescricao());
//                intent.putExtra("Instituicao", destaques.get(position).getCdInstituicao());
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return aulas.size();
    }


}
