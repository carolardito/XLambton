package com.example.carolina.xlambton;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.StrictMode;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.carolina.xlambton.dao.XLambtonDAO;
import com.example.carolina.xlambton.helper.FormAgentProfile;
import com.example.carolina.xlambton.model.Agents;
import com.example.carolina.xlambton.model.Photos;

import java.io.File;
import java.util.ArrayList;

public class AgentProfile extends AppCompatActivity {

    private FormAgentProfile helper;
    private Agents agent;
    private static final int CAMERA_CODE = 990;
    private String dirAppPhoto, fileName;
    //private XLambtonDAO dao = new XLambtonDAO(AgentProfile.this);
    ArrayList<Photos> photosTaken = new ArrayList<Photos>();
    boolean btnCamera = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_profile);

        helper = new FormAgentProfile(this);

        Intent intent = getIntent();
        agent = (Agents) intent.getSerializableExtra("agent");

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Agents Profile");

        //LinearLayout profileLinearContent = (LinearLayout) findViewById(R.id.profileLinearContent);
        LinearLayout profileLinearButtons = (LinearLayout) findViewById(R.id.profileLinearButtons);
        Button profileBtnSite = (Button) findViewById(R.id.profileBtnSite);
        Button profileBtnPhone = (Button) findViewById(R.id.profileBtnPhone);
        Button profileBtnMaps = (Button) findViewById(R.id.profileBtnMaps);
        Button profileBtnInfo = (Button) findViewById(R.id.profileBtnInfo);
        Button profileBtnSMS = (Button) findViewById(R.id.profileBtnSMS);
        Button profileBtnCamera = (Button) findViewById(R.id.profileBtnCamera);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        if (agent != null) {
            getSupportActionBar().setTitle("Agents Profile");
            profileLinearButtons.setVisibility(View.VISIBLE);
            helper.fillForm(agent);
        }else{
            getSupportActionBar().setTitle("New Agents");
            profileLinearButtons.setVisibility(View.INVISIBLE);
        }

        profileBtnSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSite = new Intent(Intent.ACTION_VIEW);

                String site = agent.getWebsite();

                if (!site.startsWith("http://")){
                    site = "http://" + site;
                }
                intentSite.setData(Uri.parse(site));
                startActivity(intentSite);
            }
        });

        profileBtnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(AgentProfile.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(AgentProfile.this, new String[] {Manifest.permission.CALL_PHONE},123);
                }else{
                    Intent itemCALL = new Intent(Intent.ACTION_CALL);
                    itemCALL.setData(Uri.parse("tel:" + agent.getPhone()));
                    startActivity(itemCALL);
                }
            }
        });

        profileBtnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMAP = new Intent(Intent.ACTION_VIEW);
                intentMAP.setData(Uri.parse("geo:0,0?q=" + agent.getAddress()));
                startActivity(intentMAP);
            }
        });

        profileBtnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGoToHistorical = new Intent(AgentProfile.this, AgentHistorical.class);
                intentGoToHistorical.putExtra("agentHistorical", agent);
                startActivity(intentGoToHistorical);
            }
        });

        profileBtnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSMS = new Intent(Intent.ACTION_VIEW);
                intentSMS.setData(Uri.parse("sms:" + agent.getPhone()));
                startActivity(intentSMS);
            }
        });

        profileBtnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*int size = photosTaken.size();
                int left = 4 - size;
                if (size < 4) {
                    btnCamera = true;
                    Toast.makeText(AgentProfile.this, "You have " + size + ", " + left + " to take!", Toast.LENGTH_LONG).show();
                    Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                    fileName = System.currentTimeMillis() + "";
                    dirAppPhoto = getExternalFilesDir(null) + "/" + fileName + ".jpg";

                    File filePhoto = new File(dirAppPhoto);

                    intentCamera.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(filePhoto));

                    StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
                    StrictMode.setVmPolicy(builder.build());
                    startActivityForResult(intentCamera, CAMERA_CODE);
                }else {
                    XLambtonDAO dao = new XLambtonDAO(AgentProfile.this);
                    for (int i = 0; i < photosTaken.size(); i++) {
                        Photos photo = new Photos();
                        photo.setMissionPhoto(photosTaken.get(i).getMissionPhoto());
                        photo.setMissionPhotoName(photosTaken.get(i).getMissionPhotoName());
                        photo.setAgentID(photosTaken.get(i).getAgentID());
                        dao.dbInsertPhotos(photo);
                    }
                    dao.close();*/

                    Intent intentCamera = new Intent(AgentProfile.this, MissionUpdate.class);
                    //intentCamera.putExtra("photosTaken", photosTaken);
                    intentCamera.putExtra("agent", agent);
                    startActivity(intentCamera);
                //}
            }
        });

        Button buttonFormPhoto = (Button) findViewById(R.id.button_form_photo);
        buttonFormPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnCamera = false;
                Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                dirAppPhoto = getExternalFilesDir(null) + "/" + System.currentTimeMillis() + ".jpg";

                File filePhoto = new File(dirAppPhoto);

                intentCamera.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(filePhoto));

                StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
                StrictMode.setVmPolicy(builder.build());
                startActivityForResult(intentCamera, CAMERA_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == CAMERA_CODE) {
                if (btnCamera){
                    /*Photos photo = new Photos();
                    photo.setMissionPhoto(dirAppPhoto);
                    photo.setMissionPhotoName(fileName);
                    photo.setAgentID(agent.getId());
                    photosTaken.add(photo);*/
                }else{
                    helper.loadImage(dirAppPhoto);
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_form, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_form_ok:

                Agents agents = helper.helperAgents();
                XLambtonDAO dao = new XLambtonDAO(this);

                if (agents.getId() == null) {
                    dao.dbInsert(agents);
                }else{
                    dao.dbAlter(agents);
                }
                dao.close();

                //Toast.makeText(FormActivity.this, "Button was Clicked", Toast.LENGTH_SHORT).show();
                Toast.makeText(AgentProfile.this, "Agent " + agents.getName() + " Saved", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
