package com.yousef.pokedexproect;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;


public class PokedexDetailFragment extends Fragment {

    private long pokemonId = 0;

    public long getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(long pokemonId) {
        this.pokemonId = pokemonId;
    }

    public PokedexDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        View view = getView();
        super.onCreate(savedInstanceState);
    }

    private int imageId;
    private String idTextView;
    private String nameTextView;
    private String typeTextView;
    private String abilitiesTextView;
    private String classificationTextView;
    private String levelTextView;
    private HorizontalBarChart horizontalBarChart;

    @Override
    public void onStart() {
        super.onStart();

        View view = getView();

        Toolbar myToolbar = (Toolbar) view.findViewById(R.id.my_toolbar_detail);
        ((AppCompatActivity) getActivity()).setSupportActionBar(myToolbar);
        setHasOptionsMenu(true);

        ImageView image = view.findViewById(R.id.image_pokemon);
        TextView id = view.findViewById(R.id.number);
        TextView name = view.findViewById(R.id.name);
        TextView type = view.findViewById(R.id.type);
        TextView abilities = view.findViewById(R.id.abilities);
        TextView classification = view.findViewById(R.id.classification);
        TextView level = view.findViewById(R.id.level);

        try {

            SQLiteOpenHelper sqLiteOpenHelper = new PokedexSQLiteOpenHelper(getContext());
            SQLiteDatabase db = sqLiteOpenHelper.getReadableDatabase();
            Cursor cursor = db.query("POKEDEX", new String[]{"IMAGE_RESOURCE_ID",
                            "_id", "NAME", "TYPE", "ABILITIES", "CLASSIFICATION", "EVOLUTION_LEVEL"},
                    "_id = ?", new String[]{"" + pokemonId},
                    null, null, null);

            if (cursor.moveToFirst()) {
                imageId = cursor.getInt(0);
                idTextView = cursor.getString(1);
                nameTextView = cursor.getString(2);
                typeTextView = cursor.getString(3);
                abilitiesTextView = cursor.getString(4);
                classificationTextView = cursor.getString(5);
                levelTextView = cursor.getString(6);
                image.setImageResource(imageId);
                name.setText(nameTextView);
                type.setText(typeTextView);
                abilities.setText(abilitiesTextView);
                classification.setText(classificationTextView);
                level.setText(levelTextView);
                if (Integer.parseInt(idTextView) < 10)
                    id.setText("#00" + idTextView);
                else if (Integer.parseInt(idTextView) >= 100)
                    id.setText("#" + idTextView);
                else
                    id.setText("#0" + idTextView);

                String typeSubstring = typeTextView.substring(0, 3);
                if (typeSubstring.equals("Nor"))
                    type.setBackgroundColor(getResources().getColor(R.color.normal_gray));
                else if (typeSubstring.equals("Gra"))
                    type.setBackgroundColor(getResources().getColor(R.color.grass_green));
                else if (typeSubstring.equals("Fir"))
                    type.setBackgroundColor(getResources().getColor(R.color.fire_red));
                else if (typeSubstring.equals("Wat"))
                    type.setBackgroundColor(getResources().getColor(R.color.water_blue));
                else if (typeSubstring.equals("Fig"))
                    type.setBackgroundColor(getResources().getColor(R.color.fight_brown));
                else if (typeSubstring.equals("Fly"))
                    type.setBackgroundColor(getResources().getColor(R.color.flying_blue));
                else if (typeSubstring.equals("Poi"))
                    type.setBackgroundColor(getResources().getColor(R.color.poison_purple));
                else if (typeSubstring.equals("Gro"))
                    type.setBackgroundColor(getResources().getColor(R.color.ground_brown));
                else if (typeSubstring.equals("Roc"))
                    type.setBackgroundColor(getResources().getColor(R.color.rock_brown));
                else if (typeSubstring.equals("Bug"))
                    type.setBackgroundColor(getResources().getColor(R.color.bug_green));
                else if (typeSubstring.equals("Gho"))
                    type.setBackgroundColor(getResources().getColor(R.color.ghost_blue));
                else if (typeSubstring.equals("Ele"))
                    type.setBackgroundColor(getResources().getColor(R.color.electric_yellow));
                else if (typeSubstring.equals("Psy"))
                    type.setBackgroundColor(getResources().getColor(R.color.psychic_pink));
                else if (typeSubstring.equals("Ice"))
                    type.setBackgroundColor(getResources().getColor(R.color.ice_blue));
                else if (typeSubstring.equals("Dra"))
                    type.setBackgroundColor(getResources().getColor(R.color.dragon_purple));
                else if (typeSubstring.equals("Fai"))
                    type.setBackgroundColor(getResources().getColor(R.color.fairy_pink));
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {

            SQLiteOpenHelper sqLiteOpenHelper = new PokedexSQLiteOpenHelper(getContext());
            SQLiteDatabase db = sqLiteOpenHelper.getReadableDatabase();
            Cursor cursor = db.query("STATS", new String[]{"HP", "ATTACK", "DEFENSE",
                            "SPATTACK", "SPDEFENSE", "SPEED"}, "_id = ?", new String[]{"" + pokemonId},
                    null, null, null);

            if (cursor.moveToFirst()) {
                createHorizontalBarChart(cursor.getInt(0), cursor.getInt(1), cursor.getInt(2),
                        cursor.getInt(3), cursor.getInt(4), cursor.getInt(5));
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createHorizontalBarChart(int hp, int attack, int defense, int spattck, int spdef, int speed) {
        View view = getView();
        horizontalBarChart = (HorizontalBarChart) view.findViewById(R.id.stats_graph);

        ArrayList<BarEntry> entries = new ArrayList<>();

        entries.add(new BarEntry(1f, speed));
        entries.add(new BarEntry(2f, spdef));
        entries.add(new BarEntry(3f, spattck));
        entries.add(new BarEntry(4f, defense));
        entries.add(new BarEntry(5f, attack));
        entries.add(new BarEntry(6f, hp));

        ArrayList<String> xAxisLabel = new ArrayList<>();
        xAxisLabel.add("Speed");
        xAxisLabel.add("Sp. Def");
        xAxisLabel.add("Sp. Atk");
        xAxisLabel.add("Defense");
        xAxisLabel.add("Attack");
        xAxisLabel.add("HP");

        XAxis xAxis = horizontalBarChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(false);
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return xAxisLabel.get((int) value - 1);
            }
        });
        xAxis.setTextSize(15f);

        YAxis yAxis1 = horizontalBarChart.getAxisLeft();
        yAxis1.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART);
        yAxis1.setDrawGridLines(false);
        yAxis1.setEnabled(false);
        yAxis1.setAxisMinimum(0f);
        if (pokemonId != 113)
            yAxis1.setAxisMaximum(200f);
        else
            yAxis1.setAxisMaximum(280f);
        YAxis yAxis2 = horizontalBarChart.getAxisRight();
        yAxis2.setPosition(YAxis.YAxisLabelPosition.INSIDE_CHART);
        yAxis2.setDrawGridLines(false);
        yAxis2.setEnabled(false);
        if (pokemonId != 113)
            yAxis2.setAxisMaximum(200f);
        else
            yAxis2.setAxisMaximum(280f);
        yAxis2.setAxisMinimum(0f);

        BarDataSet set = new BarDataSet(entries, "BarDataSet");
        set.setValueTextSize(15f);
        set.setColor(Color.parseColor("#68E1D3"));
        BarData data = new BarData(set);
        data.setBarWidth(0.8f);
        horizontalBarChart.setData(data);
        horizontalBarChart.setFitBars(true);
        horizontalBarChart.setDrawGridBackground(false);
        horizontalBarChart.getDescription().setEnabled(true);
        horizontalBarChart.setDrawValueAboveBar(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.add_favorite_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add_favorites) {
            try {
                SQLiteOpenHelper sqLiteOpenHelper = new PokedexSQLiteOpenHelper(getContext());
                SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();

                if (findPokemon())
                    Toast.makeText(getContext(), "Pokemon already in favorites", Toast.LENGTH_SHORT).show();
                else {
                    insertFavorites(db, (int) pokemonId, imageId, nameTextView);
                    Toast.makeText(getContext(), "Pokemon added to favorites", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                SQLiteOpenHelper sqLiteOpenHelper = new PokedexSQLiteOpenHelper(getContext());
                SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();

                if (findPokemon()) {
                    db.delete("FAVORITES", "_id = ?", new String[]{"" + pokemonId});
                    Toast.makeText(getContext(), "Pokemon removed from favorites", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Pokemon not in favorites", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return super.onOptionsItemSelected(item);
    }


    public boolean findPokemon() {
        try {
            SQLiteOpenHelper sqLiteOpenHelper = new PokedexSQLiteOpenHelper(getContext());
            SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();

            Cursor cursor = db.query("FAVORITES", new String[]{"_id"},
                    null, null, null, null, null);

            int[] ids = new int[cursor.getCount()];
            int i = 0;
            while (cursor.moveToNext()) {
                ids[i] = cursor.getInt(0);
                i++;
            }
            for (int j = 0; j < ids.length; j++) {
                if (ids[j] == pokemonId) {
                    return true;
                }
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public void insertFavorites(SQLiteDatabase db, int id, int imageId, String name) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", id);
        contentValues.put("IMAGE_RESOURCE_ID", imageId);
        contentValues.put("NAME", name);
        db.insert("FAVORITES", null, contentValues);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = getView();
        return inflater.inflate(R.layout.fragment_pokedex_detail, container, false);
    }
}