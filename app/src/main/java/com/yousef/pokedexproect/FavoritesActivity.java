package com.yousef.pokedexproect;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.GridView;

public class FavoritesActivity extends AppCompatActivity {
    SQLiteDatabase db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        try {
            SQLiteOpenHelper sqLiteOpenHelper = new PokedexSQLiteOpenHelper(this);
            db = sqLiteOpenHelper.getReadableDatabase();
            cursor = db.query("FAVORITES", new String[]{"IMAGE_RESOURCE_ID", "_id", "NAME"},
                    null, null, null, null, null);
            int[] images = new int[cursor.getCount()];
            String[] names = new String[cursor.getCount()];
            String[] numbers = new String[cursor.getCount()];
            int i = 0;
            while (cursor.moveToNext()) {
                images[i] = cursor.getInt(0);
                names[i] = cursor.getString(2);
                numbers[i] = cursor.getString(1);
                i++;
            }

            CustomAdapter customAdapter = new CustomAdapter(images, names, numbers, this);
            GridView gridView = findViewById(R.id.pokemon_grid_view_favorites);
            gridView.setAdapter(customAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        cursor.close();
        db.close();
        super.onDestroy();
    }
}