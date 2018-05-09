package com.example.carolina.xlambton.helper;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;

import com.example.carolina.xlambton.AgentProfile;
import com.example.carolina.xlambton.R;
import com.example.carolina.xlambton.model.Agents;

public class FormAgentProfile {

    private final EditText fieldName;
    private final EditText fieldLevel;
    private final EditText fieldAgency;
    private final EditText fieldWebsite;
    private final EditText fieldCountry;
    private final EditText fieldPhone;
    private final EditText fieldAddress;
    private final ImageView fieldPhoto;

    private Agents agents;

    public FormAgentProfile(AgentProfile activity) {
        this.fieldName = (EditText) activity.findViewById(R.id.profileName);
        this.fieldLevel = (EditText) activity.findViewById(R.id.profileLevel);
        this.fieldAgency = (EditText) activity.findViewById(R.id.profileAgency);
        this.fieldWebsite = (EditText) activity.findViewById(R.id.profileSite);
        this.fieldCountry = (EditText) activity.findViewById(R.id.profileCountry);
        this.fieldPhone = (EditText) activity.findViewById(R.id.profilePhone);
        this.fieldAddress = (EditText) activity.findViewById(R.id.profileAddress);
        this.fieldPhoto = (ImageView) activity.findViewById(R.id.profilePhoto);

        agents = new Agents();
    }

    public Agents helperAgents() {
        agents.setName(fieldName.getText().toString());
        agents.setLevel(fieldLevel.getText().toString());
        agents.setAgency(fieldAgency.getText().toString());
        agents.setWebsite(fieldWebsite.getText().toString());
        agents.setCountry(fieldCountry.getText().toString());
        agents.setPhone(fieldPhone.getText().toString());
        agents.setAddress(fieldAddress.getText().toString());
        agents.setPhoto((String) fieldPhoto.getTag());

        return agents;
    }

    public void fillForm(Agents agent) {
        fieldName.setText(agent.getName());
        fieldLevel.setText(agent.getLevel());
        fieldAgency.setText(agent.getAgency());
        fieldWebsite.setText(agent.getWebsite());
        fieldCountry.setText(agent.getCountry());
        fieldPhone.setText(agent.getPhone());
        fieldAddress.setText(agent.getAddress());
        loadImage(agent.getPhoto());

        this.agents = agent;
    }

    public void loadImage(String dirAppPhoto) {
        if (dirAppPhoto != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(dirAppPhoto);

            Bitmap lowDefBitmap = Bitmap.createScaledBitmap(bitmap, 300, 300, true);

            fieldPhoto.setImageBitmap(lowDefBitmap);

            fieldPhoto.setScaleType(ImageView.ScaleType.FIT_XY);

            fieldPhoto.setTag(dirAppPhoto);
        }
    }
}
