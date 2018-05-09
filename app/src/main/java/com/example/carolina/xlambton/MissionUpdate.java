package com.example.carolina.xlambton;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Color;
import android.net.Uri;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carolina.xlambton.adapter.HistoricalListAdapter;
import com.example.carolina.xlambton.adapter.MissionUpdateAdapter;
import com.example.carolina.xlambton.dao.XLambtonDAO;
import com.example.carolina.xlambton.helper.FormMissionUpdate;
import com.example.carolina.xlambton.model.Agents;
import com.example.carolina.xlambton.model.Historical;
import com.example.carolina.xlambton.model.Photos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MissionUpdate extends AppCompatActivity {

    private Agents agent;
    private GridView updateList;
    private FormMissionUpdate helper;
    private static final int CAMERA_CODE = 990;
    private String dirAppPhoto1, fileName1, dirAppPhoto2, fileName2, dirAppPhoto3, fileName3, dirAppPhoto4, fileName4;
    private List<String> dir = new ArrayList<>();
    String dirAppPhoto, fileName;
    ArrayList<Photos> photosTaken = new ArrayList<Photos>();
    //XLambtonDAO dao;
    MissionUpdateAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission_update);

        Intent intent = getIntent();
        agent = (Agents) intent.getSerializableExtra("agent");
        //photosTaken = (ArrayList<Photos>) intent.getSerializableExtra("photosTaken");

        //dao = new XLambtonDAO(this);
        helper = new FormMissionUpdate(this);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.camera);
        getSupportActionBar().setTitle("Mission Update");

        /*Button updateBtnCamera = (Button) findViewById(R.id.updateBtnCamera);
        updateBtnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fileName = System.currentTimeMillis() + "";
                dirAppPhoto = getExternalFilesDir(null) + "/" + fileName + ".jpg";
                camera(dirAppPhoto);

                /*Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                fileName = System.currentTimeMillis() + "";
                dirAppPhoto = getExternalFilesDir(null) + "/" + fileName + ".jpg";

                File filePhoto = new File(dirAppPhoto);

                intentCamera.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(filePhoto));

                StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
                StrictMode.setVmPolicy(builder.build());
                startActivityForResult(intentCamera, CAMERA_CODE);*
            }
        });

        updateList = (GridView) findViewById(R.id.updateList);
        updateList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                photosTaken.get(position).undoPhotoSelected();
                ((MissionUpdateAdapter) updateList.getAdapter()).notifyDataSetChanged();
                if (photosTaken.get(position).getPhotoSelected()) {
                    view.setBackgroundColor(Color.BLUE);
                }else{
                    view.setBackgroundColor(Color.WHITE);
                }

                return true;
            }
        });*/

        final TextView updateLabel1 = (TextView) findViewById(R.id.updateLabel1);
        final LinearLayout updateLinearView1 = (LinearLayout) findViewById(R.id.updateLinearView1);
        final ImageView photo1 = (ImageView) findViewById(R.id.update1);
        photo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fileName1 = System.currentTimeMillis() + "";
                dirAppPhoto1 = getExternalFilesDir(null) + "/" + fileName1 + ".jpg";
                camera(dirAppPhoto1);
                updateLabel1.setText(fileName1);
            }
        });

        photo1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (!updateLabel1.getText().equals("Photo 1")){
                    photosTaken.get(0).undoPhotoSelected1();
                    if (photosTaken.get(0).isPhotoSelected1()){
                        updateLinearView1.setBackgroundColor(Color.LTGRAY);
                    }else {
                        updateLinearView1.setBackgroundColor(Color.TRANSPARENT);
                    }
                }

                return true;
            }
        });

        final TextView updateLabel2 = (TextView) findViewById(R.id.updateLabel2);
        final LinearLayout updateLinearView2 = (LinearLayout) findViewById(R.id.updateLinearView2);
        final ImageView photo2 = (ImageView) findViewById(R.id.update2);
        photo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fileName2 = System.currentTimeMillis() + "";
                dirAppPhoto2 = getExternalFilesDir(null) + "/" + fileName2 + ".jpg";
                camera(dirAppPhoto2);
                updateLabel2.setText(fileName2);
            }
        });

        photo2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (!updateLabel2.getText().equals("Photo 2")) {
                    photosTaken.get(1).undoPhotoSelected2();
                    if (photosTaken.get(1).isPhotoSelected2()) {
                        updateLinearView2.setBackgroundColor(Color.LTGRAY);
                    } else {
                        updateLinearView2.setBackgroundColor(Color.TRANSPARENT);
                    }
                }

                return true;
            }
        });

        final TextView updateLabel3 = (TextView) findViewById(R.id.updateLabel3);
        final LinearLayout updateLinearView3 = (LinearLayout) findViewById(R.id.updateLinearView3);
        final ImageView photo3 = (ImageView) findViewById(R.id.update3);
        photo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fileName3 = System.currentTimeMillis() + "";
                dirAppPhoto3 = getExternalFilesDir(null) + "/" + fileName3 + ".jpg";
                camera(dirAppPhoto3);
                updateLabel3.setText(fileName3);
            }
        });

        photo3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (!updateLabel3.getText().equals("Photo 3")) {
                    photosTaken.get(2).undoPhotoSelected3();
                    if (photosTaken.get(2).isPhotoSelected3()) {
                        updateLinearView3.setBackgroundColor(Color.LTGRAY);
                    } else {
                        updateLinearView3.setBackgroundColor(Color.TRANSPARENT);
                    }
                }
                return true;
            }
        });

        final TextView updateLabel4 = (TextView) findViewById(R.id.updateLabel4);
        final LinearLayout updateLinearView4 = (LinearLayout) findViewById(R.id.updateLinearView4);
        final ImageView photo4 = (ImageView) findViewById(R.id.update4);
        photo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fileName4 = System.currentTimeMillis() + "";
                dirAppPhoto4 = getExternalFilesDir(null) + "/" + fileName4 + ".jpg";
                camera(dirAppPhoto4);
                updateLabel4.setText(fileName4);
            }
        });

        photo4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (!updateLabel4.getText().equals("Photo 4")) {
                    photosTaken.get(3).undoPhotoSelected4();
                    if (photosTaken.get(3).isPhotoSelected4()) {
                        updateLinearView4.setBackgroundColor(Color.LTGRAY);
                    } else {
                        updateLinearView4.setBackgroundColor(Color.TRANSPARENT);
                    }
                }
                return true;
            }
        });

        Button updateBack = (Button) findViewById(R.id.updateBack);
        updateBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dao.close();
                finish();
            }
        });

        Button updateSMS = (Button) findViewById(R.id.updateSMS);
        updateSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int size = photosTaken.size();
                if (size < 1) {
                    Toast.makeText(MissionUpdate.this, "You have to take at least one photo!", Toast.LENGTH_SHORT).show();
                }else {

                    ArrayList<Uri> imageUris = new ArrayList<Uri>();

                    if (size == 1) {
                        if (photosTaken.get(0).isPhotoSelected1()) {
                            imageUris.add(Uri.fromFile(new File(dirAppPhoto1)));
                        }
                    }else if (size == 2) {
                        if (photosTaken.get(0).isPhotoSelected1()) {
                            imageUris.add(Uri.fromFile(new File(dirAppPhoto1)));
                        }
                        if (photosTaken.get(1).isPhotoSelected2()) {
                            imageUris.add(Uri.fromFile(new File(dirAppPhoto2)));
                        }
                    }else if (size == 3) {
                        if (photosTaken.get(0).isPhotoSelected1()) {
                            imageUris.add(Uri.fromFile(new File(dirAppPhoto1)));
                        }
                        if (photosTaken.get(1).isPhotoSelected2()) {
                            imageUris.add(Uri.fromFile(new File(dirAppPhoto2)));
                        }
                        if (photosTaken.get(2).isPhotoSelected3()) {
                            imageUris.add(Uri.fromFile(new File(dirAppPhoto3)));
                        }
                    }else{
                        if (photosTaken.get(0).isPhotoSelected1()) {
                            imageUris.add(Uri.fromFile(new File(dirAppPhoto1)));
                        }
                        if (photosTaken.get(1).isPhotoSelected2()) {
                            imageUris.add(Uri.fromFile(new File(dirAppPhoto2)));
                        }
                        if (photosTaken.get(2).isPhotoSelected3()) {
                            imageUris.add(Uri.fromFile(new File(dirAppPhoto3)));
                        }
                        if (photosTaken.get(3).isPhotoSelected4()) {
                            imageUris.add(Uri.fromFile(new File(dirAppPhoto4)));
                        }
                    }

                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
                    //sendIntent.putExtra("address", agent.getPhone());
                    sendIntent.putExtra(Intent.EXTRA_PHONE_NUMBER , agent.getPhone());
                    //sendIntent.putExtra(Intent.EXTRA_TEXT, message);
                    if (imageUris.size() > 0 ) {
                        sendIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, imageUris);
                    }
                    sendIntent.setType("image/*");
                    sendIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(sendIntent);
                }
            }
        });
    }

    private void camera(String dirAppPhoto) {
        Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        //dirAppPhoto = getExternalFilesDir(null) + "/" + System.currentTimeMillis() + ".jpg";

        File filePhoto = new File(dirAppPhoto);

        intentCamera.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(filePhoto));

        StrictMode.VmPolicy.Builder builder1 = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder1.build());
        startActivityForResult(intentCamera, CAMERA_CODE);
    }

    private void loadPhotoList() {
        /*XLambtonDAO dao = new XLambtonDAO(this);
        List<Photos> photo = dao.dbSearchPhotos();
        dao.close();

        for (int i = 0; i < photo.size(); i++) {
            if (agent.getId().equals(photo.get(i).getAgentID())){
                photosTaken.add(photo.get(i));
            }
        }*/

        adapter = new MissionUpdateAdapter(photosTaken, MissionUpdate.this);

        //send information from here to view
        updateList.setAdapter(adapter);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == CAMERA_CODE) {
                /*Photos photo = new Photos();
                photo.setMissionPhoto(dirAppPhoto);
                photo.setMissionPhotoName(fileName);
                photo.setAgentID(agent.getId());
                photosTaken.add(photo);
                updateList.invalidateViews();
                updateList.setAdapter(adapter);*/
                //((MissionUpdateAdapter) updateList.getAdapter()).notifyDataSetChanged();
                //dao.dbInsert(photo);
                //loadPhotoList();
                if (dirAppPhoto1 != null) {
                    helper.loadImage1(dirAppPhoto1);
                    Photos photo1 = new Photos();
                    photo1.setMissionPhoto1(dirAppPhoto1);
                    photo1.setAgentID(agent.getId());
                    photosTaken.add(photo1);
                }

                if (dirAppPhoto2 != null) {
                    helper.loadImage2(dirAppPhoto2);
                    Photos photo2 = new Photos();
                    photo2.setMissionPhoto2(dirAppPhoto2);
                    photo2.setAgentID(agent.getId());
                    photosTaken.add(photo2);
                }

                if (dirAppPhoto3 != null) {
                    helper.loadImage3(dirAppPhoto3);
                    Photos photo3 = new Photos();
                    photo3.setMissionPhoto3(dirAppPhoto3);
                    photo3.setAgentID(agent.getId());
                    photosTaken.add(photo3);
                }

                if (dirAppPhoto4 != null) {
                    helper.loadImage4(dirAppPhoto4);
                    Photos photo4 = new Photos();
                    photo4.setMissionPhoto4(dirAppPhoto4);
                    photo4.setAgentID(agent.getId());
                    photosTaken.add(photo4);
                }
            }
        }
    }

    /*private void loadUpdateList() {
        XLambtonDAO dao = new XLambtonDAO(this);
        List<Photos> photo = dao.dbSearchPhotos();
        dao.close();

        MissionUpdateAdapter adapter = new MissionUpdateAdapter(photo, MissionUpdate.this);

        //send information from here to view
        updateList.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        loadPhotoList();
        super.onResume();
    }*/

}
