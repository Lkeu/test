package com.example.project;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class Adapter extends BaseAdapter {

    Context context;
    String text[];
    int image[];
    LayoutInflater inflater;
    int vubor;
    int item;
    int textField;
    int imageField;


    public Adapter(Context context, String[] text,int[] image, int vubor){
        this.context = context;
        this.text = text;
        this.image = image;
        inflater = LayoutInflater.from(context);
        this.vubor = vubor;
    }




    @Override
    public int getCount() {
        return text.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (vubor == 1){
            item = R.layout.stranu_item;
            textField = R.id.country_name;
            imageField = R.id.flag;

        } else if (vubor == 2) {
            item = R.layout.activity_divisions;
            textField = R.id.division_name;
            imageField = R.id.division_image;
        }

        View convertView = inflater.inflate(item, null);
        TextView textView = (TextView) convertView.findViewById(textField);
        ImageView imageView = (ImageView) convertView.findViewById(imageField);
        textView.setText(text[i]);
        imageView.setImageResource(image[i]);

        return convertView;
    }
}

