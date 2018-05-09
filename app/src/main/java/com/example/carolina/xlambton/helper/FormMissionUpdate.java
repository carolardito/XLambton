package com.example.carolina.xlambton.helper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.example.carolina.xlambton.MissionUpdate;
import com.example.carolina.xlambton.R;
import com.example.carolina.xlambton.model.Photos;

public class FormMissionUpdate {
    private final ImageView fieldPhoto1;
    private final ImageView fieldPhoto2;
    private final ImageView fieldPhoto3;
    private final ImageView fieldPhoto4;

    private Photos photos;

    public FormMissionUpdate(MissionUpdate activity) {
        this.fieldPhoto1 = (ImageView) activity.findViewById(R.id.update1);
        this.fieldPhoto2 = (ImageView) activity.findViewById(R.id.update2);
        this.fieldPhoto3 = (ImageView) activity.findViewById(R.id.update3);
        this.fieldPhoto4 = (ImageView) activity.findViewById(R.id.update4);


        photos = new Photos();
    }

    public Photos helperPhotos(Long agentID) {
        photos.setAgentID(agentID);
        photos.setMissionPhoto1((String) fieldPhoto1.getTag());
        photos.setMissionPhoto2((String) fieldPhoto2.getTag());
        photos.setMissionPhoto3((String) fieldPhoto3.getTag());
        photos.setMissionPhoto4((String) fieldPhoto4.getTag());

        return photos;
    }

    public void loadImage1(String dirAppPhoto1) {
        if (dirAppPhoto1 != null) {
            Bitmap bitmap1 = BitmapFactory.decodeFile(dirAppPhoto1);

            Bitmap lowDefBitmap1 = Bitmap.createScaledBitmap(bitmap1, 300, 300, true);

            fieldPhoto1.setImageBitmap(lowDefBitmap1);

            fieldPhoto1.setScaleType(ImageView.ScaleType.FIT_XY);

            fieldPhoto1.setTag(dirAppPhoto1);
        }
    }

    public void loadImage2(String dirAppPhoto2) {
        if (dirAppPhoto2 != null) {
            Bitmap bitmap2 = BitmapFactory.decodeFile(dirAppPhoto2);

            Bitmap lowDefBitmap2 = Bitmap.createScaledBitmap(bitmap2, 300, 300, true);

            fieldPhoto2.setImageBitmap(lowDefBitmap2);

            fieldPhoto2.setScaleType(ImageView.ScaleType.FIT_XY);

            fieldPhoto2.setTag(dirAppPhoto2);
        }
    }

    public void loadImage3(String dirAppPhoto3) {
        if (dirAppPhoto3 != null) {
            Bitmap bitmap3 = BitmapFactory.decodeFile(dirAppPhoto3);

            Bitmap lowDefBitmap3 = Bitmap.createScaledBitmap(bitmap3, 300, 300, true);

            fieldPhoto3.setImageBitmap(lowDefBitmap3);

            fieldPhoto3.setScaleType(ImageView.ScaleType.FIT_XY);

            fieldPhoto3.setTag(dirAppPhoto3);
        }
    }
    public void loadImage4(String dirAppPhoto4) {
        if (dirAppPhoto4 != null) {
            Bitmap bitmap4 = BitmapFactory.decodeFile(dirAppPhoto4);

            Bitmap lowDefBitmap4 = Bitmap.createScaledBitmap(bitmap4, 300, 300, true);

            fieldPhoto4.setImageBitmap(lowDefBitmap4);

            fieldPhoto4.setScaleType(ImageView.ScaleType.FIT_XY);

            fieldPhoto4.setTag(dirAppPhoto4);
        }
    }
}
