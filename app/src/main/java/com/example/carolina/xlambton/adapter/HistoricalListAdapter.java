package com.example.carolina.xlambton.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.carolina.xlambton.R;
import com.example.carolina.xlambton.model.Historical;

import java.util.List;

public class HistoricalListAdapter extends BaseAdapter {

    private final List<Historical> historicals;
    private final Context context;

    public HistoricalListAdapter(List<Historical> historical, Context context) {
        this.historicals = historical;
        this.context = context;
    }

    @Override
    public int getCount() {
        return historicals.size();
    }

    @Override
    public Object getItem(int position) {
        return historicals.get(position);
    }

    @Override
    public long getItemId(int position) {
        return historicals.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Historical historical = historicals.get(position);

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.historical_list, parent, false);
        }

        TextView fieldName = (TextView) view.findViewById(R.id.historicalName);
        fieldName.setText("Nome: " + historical.getMissionName());
        TextView fieldDate = (TextView) view.findViewById(R.id.historicalDate);
        fieldDate.setText("Level: " + historical.getDate());
        TextView fieldStatus = (TextView) view.findViewById(R.id.historicalStatus);
        fieldStatus.setText("Level: " + historical.getStatus());

        return view;
    }
}
