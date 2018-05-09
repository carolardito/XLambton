package com.example.carolina.xlambton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuOptionList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_option_list);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("XLambton");

        Button menuOptionAgentsList = (Button) findViewById(R.id.menuOptionAgentsList);
        Button menuOptionSearch = (Button) findViewById(R.id.menuOptionSearch);
        Button menuOptionAdd = (Button) findViewById(R.id.menuOptionAdd);

        menuOptionAgentsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGoToAgentsList = new Intent(MenuOptionList.this, AgentsList.class);
                startActivity(intentGoToAgentsList);
            }
        });

        menuOptionSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGoToAgentsSearch = new Intent(MenuOptionList.this, AgentsSearch.class);
                startActivity(intentGoToAgentsSearch);
            }
        });

        menuOptionAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGoToNewAgent = new Intent(MenuOptionList.this, AgentProfile.class);
                startActivity(intentGoToNewAgent);
            }
        });
    }
}
