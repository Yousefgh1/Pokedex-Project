package com.yousef.pokedexproect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class PokemonDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);

        Intent intent = getIntent();
        long pokemonId = intent.getLongExtra("EXTRA_POKEMON_ID", -1);
        PokedexDetailFragment pokedexDetailFragment = (PokedexDetailFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        pokedexDetailFragment.setPokemonId(pokemonId);
    }
}