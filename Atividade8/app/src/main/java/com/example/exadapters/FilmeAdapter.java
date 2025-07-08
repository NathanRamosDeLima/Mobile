package com.example.exadapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FilmeAdapter extends RecyclerView.Adapter<FilmeAdapter.ViewHolder> {

    private final List<Filme> localDataSet;

    public FilmeAdapter(List<Filme> localDataSet) {
        this.localDataSet = localDataSet;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_row_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Filme filme = localDataSet.get(position);
        holder.getImageView().setImageResource(filme.img);
        holder.textView2.setText(filme.franquia);
        holder.textView.setText(filme.nome);
    }


    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView textView;
        private final TextView textView2;
        private final ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txtFilmeNome);
            textView2 = itemView.findViewById(R.id.txtFilmeFranquia);
            imageView = itemView.findViewById(R.id.imgFilme);

            itemView.setOnClickListener(this);
        }

        public TextView getTextView() {
            return textView;
        }

        public ImageView getImageView() {
            return imageView;
        }

        @Override
        public void onClick(View v) {
            Context context = imageView.getContext();

            ImageView imageViewDialog = new ImageView(context);
            imageViewDialog.setImageResource(localDataSet.get(getAdapterPosition()).img);
            imageViewDialog.setAdjustViewBounds(true);
            imageViewDialog.setPadding(16, 16, 16, 16);

            new AlertDialog.Builder(context)
                    .setTitle("Imagem do Filme")
                    .setView(imageViewDialog)
                    .setPositiveButton("Fechar", null)
                    .show();
        }

    }
}
