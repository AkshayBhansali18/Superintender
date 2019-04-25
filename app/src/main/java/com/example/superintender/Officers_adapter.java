package com.example.superintender;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Officers_adapter extends BaseAdapter {
      ImageView officer_imageview;
    TextView officer_textview;

   private ArrayList<String> names=new ArrayList<>();
  private   ArrayList<Integer> images=new ArrayList<>();
    private Context context;

    public Officers_adapter(ArrayList<String> names, ArrayList<Integer> images, Context context) {
        this.names = names;
        this.images = images;
        this.context = context;
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int position) {
        return names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       View view= LayoutInflater.from(context).inflate(R.layout.listview_layout,parent,false);
       officer_imageview=view.findViewById(R.id.officer_imageView);
       officer_textview=view.findViewById(R.id.officer_textView);
       officer_imageview.setImageResource(images.get(position));
       officer_textview.setText(names.get(position));
       return view;
    }
}
