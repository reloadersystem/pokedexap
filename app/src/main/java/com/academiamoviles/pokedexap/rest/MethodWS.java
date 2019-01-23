package com.academiamoviles.pokedexap.rest;

import com.academiamoviles.pokedexap.entity.Pokemon;
import com.academiamoviles.pokedexap.entity.response.PokemonResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by AcademiaMoviles on 18/06/2018.
 */

public interface MethodWS {

    @GET("pokemon")
    Call<PokemonResponse> getListPokemon(@Query("limit") int limit, @Query("offset")int offset);

    //Call<ArrayList<Post>> getPost();





}
