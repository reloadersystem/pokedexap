package com.academiamoviles.pokedexap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.academiamoviles.pokedexap.adapter.PokeAdapter;
import com.academiamoviles.pokedexap.entity.Pokemon;
import com.academiamoviles.pokedexap.entity.response.PokemonResponse;
import com.academiamoviles.pokedexap.rest.HelperWS;
import com.academiamoviles.pokedexap.rest.MethodWS;
import com.academiamoviles.pokedexap.util.Constantes;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerPoke;
    int offset=0;


    private static final String TAG="jledesma";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarUI();

        obtenerDatos(20);
    }

    private void inicializarUI() {
        recyclerPoke=findViewById(R.id.recyclerPokedex);
    }

    private  void implementarAdapter(ArrayList<Pokemon> list_pokemon)
    {
        recyclerPoke.setAdapter(new PokeAdapter(this,R.layout.item_pokedex,list_pokemon));

        recyclerPoke.hasFixedSize();


        final GridLayoutManager layoutManager=new GridLayoutManager(this,3);

        recyclerPoke.setLayoutManager(layoutManager);



    }

    private void obtenerDatos( int offset) {

        //TODO

        MethodWS methodWS= HelperWS.getComfiguration().create(MethodWS.class);

        final Call<PokemonResponse> pokemonResponseCall =methodWS.getListPokemon(150,offset);

        pokemonResponseCall.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                if (response.isSuccessful()) {
                    PokemonResponse pokemonResponse = response.body();
                    ArrayList<Pokemon> list_pokemon_response = pokemonResponse.getResults();
                    for (int i =0; i<list_pokemon_response.size();i++)

                    {
                        Pokemon pokemon = list_pokemon_response.get(i);
                        Log.i(Constantes.TAG, pokemon.getName());
                    }

                    implementarAdapter(list_pokemon_response);

                }else{
                    Log.i(Constantes.TAG,response.errorBody().toString());
                }


            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                Log.i(Constantes.TAG,t.getMessage().toString());
            }
        });

    }
}
