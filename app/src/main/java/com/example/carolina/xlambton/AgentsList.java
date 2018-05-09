package com.example.carolina.xlambton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.carolina.xlambton.adapter.AgentListAdapter;
import com.example.carolina.xlambton.dao.XLambtonDAO;
import com.example.carolina.xlambton.model.Agents;
import com.example.carolina.xlambton.model.Photos;

import java.util.List;

public class AgentsList extends AppCompatActivity {

    private ListView agentsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agents_list);

        agentsListView = (ListView) findViewById(R.id.agentsList);
        registerForContextMenu(agentsListView);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Agents List");

        agentsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Agents agent = (Agents) agentsListView.getItemAtPosition(position);

                Intent intentGoToAgentProfile = new Intent(AgentsList.this, AgentProfile.class);
                intentGoToAgentProfile.putExtra("agent", agent);
                startActivity(intentGoToAgentProfile);
            }
        });
    }

    private void loadAgentsList() {
        XLambtonDAO dao = new XLambtonDAO(this);
        List<Agents> agents = dao.dbSearchAgents();
        dao.close();

        AgentListAdapter adapter = new AgentListAdapter(agents, this);

        //send information from here to view
        agentsListView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        loadAgentsList();
        super.onResume();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        final Agents agents = (Agents) agentsListView.getItemAtPosition(info.position);

        MenuItem delete = menu.add("Delete");
        delete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                //AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                //Student student = (Student) studentsList.getItemAtPosition(info.position);
                XLambtonDAO dao = new XLambtonDAO(AgentsList.this);
                dao.dbDelete(agents);
                dao.close();
                Toast.makeText(AgentsList.this, "Delete Agent " + agents.getName(), Toast.LENGTH_SHORT).show();
                loadAgentsList();
                return false;
            }
        });

        super.onCreateContextMenu(menu, v, menuInfo);
    }
}
