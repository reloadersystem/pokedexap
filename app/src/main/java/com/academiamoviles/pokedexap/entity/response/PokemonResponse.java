package com.academiamoviles.pokedexap.entity.response;

import com.academiamoviles.pokedexap.entity.Pokemon;

import java.util.ArrayList;

/**
 * Created by AcademiaMoviles on 18/06/2018.
 */

public class PokemonResponse {
    private ArrayList<Pokemon> results;

    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }
}