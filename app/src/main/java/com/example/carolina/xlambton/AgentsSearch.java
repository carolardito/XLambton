package com.example.carolina.xlambton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.carolina.xlambton.adapter.AgentListAdapter;
import com.example.carolina.xlambton.dao.XLambtonDAO;
import com.example.carolina.xlambton.model.Agents;

import java.util.ArrayList;
import java.util.List;

public class AgentsSearch extends AppCompatActivity {

    private List<Agents> agents;
    private ArrayList<Agents> agentsList = new ArrayList<Agents>();
    private ListView searchList;
    private EditText searchField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agents_search);

        searchField = (EditText) findViewById(R.id.searchField);
        searchList = (ListView) findViewById(R.id.searchList);

        Button searchBtn = (Button) findViewById(R.id.searchBtn);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agentsList.clear();
                final String agentName = (String) searchField.getText().toString();

                XLambtonDAO dao = new XLambtonDAO(AgentsSearch.this);
                agents = dao.dbSearchAgents();
                dao.close();

                for (int i = 0; i < agents.size(); i++) {
                    if (agents.get(i).getName().toUpperCase().contains(agentName.toUpperCase())){
                        agentsList.add(agents.get(i));
                    }
                }

                loadList();
            }
        });

        searchList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Agents agent = (Agents) searchList.getItemAtPosition(position);

                Intent intentGoToAgentProfile = new Intent(AgentsSearch.this, AgentProfile.class);
                intentGoToAgentProfile.putExtra("agent", agent);
                startActivity(intentGoToAgentProfile);
            }
        });

    }

    private void loadList() {
        AgentListAdapter adapter = new AgentListAdapter(agentsList, this);

        //send information from here to view
        searchList.setAdapter(adapter);
    }
}
