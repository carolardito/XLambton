package com.example.carolina.xlambton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.carolina.xlambton.dao.XLambtonDAO;
import com.example.carolina.xlambton.helper.FormLoginHelper;
import com.example.carolina.xlambton.model.User;

import java.util.List;

public class LogIn extends AppCompatActivity {

    private FormLoginHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("XLambton");

        helper = new FormLoginHelper(this);

        Button btnLoginOk = (Button) findViewById(R.id.login_ok);
        Button btnLoginCancel = (Button) findViewById(R.id.login_cancel);
        Button btnLoginNewUser = (Button) findViewById(R.id.login_newUser);

        btnLoginCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnLoginNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGoToNewUser = new Intent(LogIn.this, NewUser.class);
                //intentGoToNewUser.putExtra("agent", "");
                startActivity(intentGoToNewUser);
            }
        });

        btnLoginOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean loginOk = false;
                User login = helper.helperLogin();

                XLambtonDAO dao = new XLambtonDAO(LogIn.this);
                List<User> loginList = dao.dbSearchUser();
                dao.close();

                for (int i = 0; i < loginList.size(); i++) {
                    if (login.getUser().equals(loginList.get(i).getUser()) && login.getPassword().equals(loginList.get(i).getPassword())) {
                        loginOk = true;
                        Intent intentGoToMenu = new Intent(LogIn.this, MenuOptionList.class);
                        startActivity(intentGoToMenu);
                    }
                }

                if (loginOk == false) {
                    Toast.makeText(LogIn.this, "User and/or password wrong!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
