package com.example.teach_me;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DestaquesAdapter extends RecyclerView.Adapter<DestaquesAdapter.DestaquesHolder> {

    public static class DestaquesHolder extends RecyclerView.ViewHolder {

        public DestaquesHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    public DestaquesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull DestaquesHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


}
