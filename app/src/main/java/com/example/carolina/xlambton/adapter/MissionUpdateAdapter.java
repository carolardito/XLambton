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
import com.example.carolina.xlambton.model.Photos;

import java.io.File;
import java.util.List;

public class MissionUpdateAdapter extends BaseAdapter {

    private final List<Photos> photos;
    private final Context context;

    public MissionUpdateAdapter(List<Photos> photos, Context context) {
        this.photos = photos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return photos.size();
    }

    @Override
    public Object getItem(int position) {
        return photos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return photos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = ViewGroup.inflate(parent.getContext(), R.layout.update_list, null);
        }

        TextView listPhotoName = (TextView) convertView.findViewById(R.id.updateNamePhoto);
        //listPhotoName.setText(photos.get(position).getMissionPhotoName());

        ImageView listPhoto = (ImageView) convertView.findViewById(R.id.updateImgPhoto);
        String dirAppPhoto = photos.get(position).getMissionPhoto1(); //carol
        if (dirAppPhoto != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(dirAppPhoto);
            Bitmap lowdefbitmap = Bitmap.createScaledBitmap(bitmap, 100, 100, true);
            listPhoto.setImageBitmap(lowdefbitmap);
            listPhoto.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        return convertView;

        /*Photos photo = photos.get(position);

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.update_list, parent, false);
        }

        ImageView updateImgPhoto = (ImageView) view.findViewById(R.id.updateImgPhoto);
        TextView updateNamePhoto = (TextView) view.findViewById(R.id.updateNamePhoto);

        String dir = (String) getItem(position);
        if (dir != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(dir);
            Bitmap lowdefbitmap = Bitmap.createScaledBitmap(bitmap, 100, 100, true);
            updateImgPhoto.setImageBitmap(lowdefbitmap);
            updateImgPhoto.setScaleType(ImageView.ScaleType.FIT_XY);
            File file = new File(dir);
            updateNamePhoto.setText(file.getName());
        }
        ImageView fieldPhoto = (ImageView) view.findViewById(R.id.update_photo);
        String dirAppPhoto = photo.getMissionPhoto1();
        if (dirAppPhoto != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(dirAppPhoto);
            Bitmap lowdefbitmap = Bitmap.createScaledBitmap(bitmap, 100, 100, true);
            fieldPhoto.setImageBitmap(lowdefbitmap);
            fieldPhoto.setScaleType(ImageView.ScaleType.FIT_XY);
        }*/

        //return view;
    }
}
