package com.yousef.pokedexproect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class PokedexListActivity extends AppCompatActivity {

    SQLiteDatabase db;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar_list);
        setSupportActionBar(toolbar);

        try{
            SQLiteOpenHelper sqLiteOpenHelper = new PokedexSQLiteOpenHelper(this);
            db = sqLiteOpenHelper.getReadableDatabase();
            cursor = db.query("POKEDEX", new String[]{"IMAGE_RESOURCE_ID", "_id", "NAME"},
                    null, null, null, null, null);
            int[] images = new int[cursor.getCount()];
            String[] names = new String[cursor.getCount()];
            String[] numbers = new String[cursor.getCount()];
            int i=0;
            while(cursor.moveToNext()) {
                images[i] = cursor.getInt(0);
                names[i] = cursor.getString(2);
                numbers[i] = cursor.getString(1);
                i++;
            }

            CustomAdapter customAdapter = new CustomAdapter(images, names, numbers,this);
            GridView gridView = findViewById(R.id.pokemon_grid_view);
            gridView.setAdapter(customAdapter);

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent();
                    intent.setClass(PokedexListActivity.this, PokemonDetailActivity.class);
                    intent.putExtra("EXTRA_POKEMON_ID", Long.valueOf(position+1));
                    startActivity(intent);
                }
            });
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.favorite_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent();
        intent.setClass(this, FavoritesActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        cursor.close();
        db.close();
        super.onDestroy();
    }
}