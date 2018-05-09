package com.example.carolina.xlambton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.carolina.xlambton.dao.XLambtonDAO;
import com.example.carolina.xlambton.helper.FormAgentHistorical;
import com.example.carolina.xlambton.model.Agents;
import com.example.carolina.xlambton.model.Historical;

public class AgentNewHistorical extends AppCompatActivity {

    private FormAgentHistorical helper;
    private Agents agent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_new_historical);

        Intent intent = getIntent();
        agent = (Agents) intent.getSerializableExtra("agentHistorical");

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("New Agent Historical");

        helper = new FormAgentHistorical(this);
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

                Historical histories = helper.helperHistorical(agent.getId());
                XLambtonDAO dao = new XLambtonDAO(this);

                if (histories.getId() == null) {
                    dao.dbInsert(histories);
                }else{
                    dao.dbAlter(histories);
                }
                dao.close();

                //Toast.makeText(FormActivity.this, "Button was Clicked", Toast.LENGTH_SHORT).show();
                Toast.makeText(AgentNewHistorical.this, "Mission " + histories.getMissionName() + " Saved", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
