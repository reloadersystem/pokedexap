package com.academiamoviles.pokedexap.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.academiamoviles.pokedexap.MainActivity;
import com.academiamoviles.pokedexap.R;
import com.academiamoviles.pokedexap.entity.Pokemon;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

/**
 * Created by AcademiaMoviles on 18/06/2018.
 */

public class PokeAdapter extends RecyclerView.Adapter<PokeAdapter.PokeAdapterHolder> {

    Context context;
    int item_pokedex;
    ArrayList<Pokemon> list_pokemon;

    public PokeAdapter(Context context, int item_pokedex, ArrayList<Pokemon> list_pokemon) {
        this.context=context;
        this.item_pokedex=item_pokedex;
        this.list_pokemon=list_pokemon;

    }

    @Override
    public PokeAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokedex,parent,false);

        return new PokeAdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(PokeAdapterHolder holder, int position) {

        Pokemon pokemon=list_pokemon.get(position);
        holder.namePoke.setText(pokemon.getName().toString());



        Glide.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" +pokemon.getNumber()+".png")
        .centerCrop()
        .crossFade()
        .diskCacheStrategy(DiskCacheStrategy.ALL)
         .into(holder.imagePoke);




    }

    @Override
    public int getItemCount() {
        return list_pokemon.size();
    }

    public class PokeAdapterHolder extends RecyclerView.ViewHolder {

        TextView namePoke;
        ImageView imagePoke;
        public PokeAdapterHolder(View itemView) {
            super(itemView);

            namePoke=itemView.findViewById(R.id.namePokedex);
            imagePoke=itemView.findViewById(R.id.imagePokedex);



        }
    }
}
