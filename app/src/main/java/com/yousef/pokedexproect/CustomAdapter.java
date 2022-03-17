package com.yousef.pokedexproect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private Context context;
    private int[] imageIds;
    private String[] names;
    private String[] numbers;

    public CustomAdapter(int[] imageIds, String[] names, String[] numbers, Context context) {
        this.context = context;
        this.imageIds = imageIds;
        this.names = names;
        this.numbers = numbers;
    }

    public int getCount() {
        return imageIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if (inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.card_pokemon_list, null);
        }
        ImageView imageView = convertView.findViewById(R.id.pokedex_image_view_card);
        imageView.setImageResource(imageIds[position]);
        TextView nameView = convertView.findViewById(R.id.name_text_view_card);
        nameView.setText(names[position]);
        TextView numberView = convertView.findViewById(R.id.number_text_view_card);
        if (Integer.parseInt(numbers[position]) < 10)
            numberView.setText("#00" + numbers[position]);
        else if (Integer.parseInt(numbers[position]) >= 100)
            numberView.setText("#" + numbers[position]);
        else {
            numberView.setText("#0" + numbers[position]);
        }
        return convertView;
    }
}
