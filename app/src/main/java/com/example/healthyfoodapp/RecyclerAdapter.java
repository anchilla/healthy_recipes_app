package com.example.healthyfoodapp;



import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    final List<Recipe> recipeList;
    private Listener listener;

    public interface Listener{
         void onClick(int position);
    }

    public void setListener(Listener listener){
        this.listener=listener;
    }

    public RecyclerAdapter(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        final CardView cardView;
        public ViewHolder(CardView v){
            super(v);
            cardView=v;

        }

    }
    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv=(CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, final int position) {
        Recipe recipe=recipeList.get(position);
        CardView cardView=holder.cardView;

        TextView textView=cardView.findViewById(R.id.info_text);
        ImageView imageView= cardView.findViewById(R.id.icon_food);

        @SuppressLint("UseCompatLoadingForDrawables")
        Drawable drawable=cardView.getResources().getDrawable(recipe.getImageResource());
        imageView.setImageDrawable(drawable);
        textView.setText(recipe.getName());

        cardView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onClick(position);
            }

        });

    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }
}
