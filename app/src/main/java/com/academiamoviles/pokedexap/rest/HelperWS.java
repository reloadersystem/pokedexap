package com.academiamoviles.pokedexap.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by AcademiaMoviles on 18/06/2018.
 */

public class HelperWS {

    public  static Retrofit getComfiguration()

    {

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public  static Retrofit getComfigurationPlaceHolder()

    {

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/posts")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
