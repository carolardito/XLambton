package com.example.carolina.xlambton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.carolina.xlambton.adapter.AgentListAdapter;
import com.example.carolina.xlambton.adapter.HistoricalListAdapter;
import com.example.carolina.xlambton.dao.XLambtonDAO;
import com.example.carolina.xlambton.helper.FormAgentHistorical;
import com.example.carolina.xlambton.model.Agents;
import com.example.carolina.xlambton.model.Historical;
import com.example.carolina.xlambton.model.Photos;

import java.util.ArrayList;
import java.util.List;

public class AgentHistorical extends AppCompatActivity {

    private Agents agent;
    private ListView historicalList;
    private List<Historical> historicalOfAgent = new ArrayList<Historical>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_historical);

        Intent intent = getIntent();
        agent = (Agents) intent.getSerializableExtra("agentHistorical");

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Agent Historical");

        historicalList = (ListView) findViewById(R.id.historicalList);

        Button historicalAdd = (Button) findViewById(R.id.historicalAdd);
        historicalAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGoToForm = new Intent(AgentHistorical.this, AgentNewHistorical.class);
                intentGoToForm.putExtra("agentHistorical", agent);
                startActivity(intentGoToForm);
            }
        });

        Button historicalBack = (Button) findViewById(R.id.historicalBack);
        historicalBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void loadAgentsList() {
        historicalOfAgent.clear();
        XLambtonDAO dao = new XLambtonDAO(this);
        List<Historical> history = dao.dbSearchHistorical();
        dao.close();

        for (int i = 0; i < history.size(); i++){
            if (history.get(i).getAgentID().equals(agent.getId())) {
                historicalOfAgent.add(history.get(i));
            }
        }

        HistoricalListAdapter adapter = new HistoricalListAdapter(historicalOfAgent, AgentHistorical.this);

        //send information from here to view
        historicalList.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        loadAgentsList();
        super.onResume();
    }

}
