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
import com.example.carolina.xlambton.model.Agents;

import java.util.List;

public class AgentListAdapter extends BaseAdapter {

    private final List<Agents> agents;
    private final Context context;

    public AgentListAdapter(List<Agents> agents, Context context) {
        this.agents = agents;
        this.context = context;
    }

    @Override
    public int getCount() {
        return agents.size();
    }

    @Override
    public Object getItem(int position) {
        return agents.get(position);
    }

    @Override
    public long getItemId(int position) {
        return agents.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Agents agent = agents.get(position);

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.agents_list, parent, false);
        }

        TextView fieldName = (TextView) view.findViewById(R.id.item_name);
        fieldName.setText("Nome: " + agent.getName());
        TextView fieldLevel = (TextView) view.findViewById(R.id.item_level);
        fieldLevel.setText("Level: " + agent.getLevel());
        ImageView fieldPhoto = (ImageView) view.findViewById(R.id.item_photo);
        String dirAppPhoto = agent.getPhoto();
        if (dirAppPhoto != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(dirAppPhoto);
            Bitmap lowdefbitmap = Bitmap.createScaledBitmap(bitmap, 100, 100, true);
            fieldPhoto.setImageBitmap(lowdefbitmap);
            fieldPhoto.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        return view;
    }
}
