package com.example.teach_me;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teach_me.models.Usuario;

import java.util.List;

public class DestaquesAdapter extends RecyclerView.Adapter<DestaquesAdapter.DestaquesHolder> {
    private Context context;
    private List<Usuario> destaques;

    DestaquesAdapter(Context context, List<Usuario> destaques){
        this.context = context;
        this.destaques = destaques;
    }

    public static class DestaquesHolder extends RecyclerView.ViewHolder {

        public DestaquesHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    /* Retorna uma view com o layout item_destaques
    *
    * */
    public DestaquesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_destaques,parent,false);
        return new DestaquesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DestaquesHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
