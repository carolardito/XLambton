package com.example.carolina.xlambton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.carolina.xlambton.dao.XLambtonDAO;
import com.example.carolina.xlambton.helper.FormNewUserHelper;
import com.example.carolina.xlambton.model.User;

public class NewUser extends AppCompatActivity {

    private FormNewUserHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        helper = new FormNewUserHelper(this);

        Button btnSave = (Button) findViewById(R.id.btnNewSave);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("NEW USER");

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUser();
                finish();
            }
        });
    }

    private void saveUser(){
        User login = helper.helperNewUser();
        XLambtonDAO dao = new XLambtonDAO(this);
        dao.dbInsert(login);
        dao.close();
    }
}
