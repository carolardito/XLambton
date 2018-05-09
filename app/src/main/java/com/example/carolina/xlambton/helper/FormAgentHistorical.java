package com.example.carolina.xlambton.helper;

import android.widget.EditText;

import com.example.carolina.xlambton.AgentNewHistorical;
import com.example.carolina.xlambton.R;
import com.example.carolina.xlambton.model.Historical;

public class FormAgentHistorical {

    private final EditText fieldName;
    private final EditText fieldDate;
    private final EditText fieldStatus;

    private Historical histories;

    public FormAgentHistorical(AgentNewHistorical activity) {
        this.fieldName = (EditText) activity.findViewById(R.id.historicalNewName);
        this.fieldDate = (EditText) activity.findViewById(R.id.historicalNewDate);
        this.fieldStatus = (EditText) activity.findViewById(R.id.historicalNewStatus);

        histories = new Historical();
    }

    public Historical helperHistorical(Long agentId) {
        histories.setMissionName(fieldName.getText().toString());
        histories.setDate(fieldDate.getText().toString());
        histories.setStatus(fieldStatus.getText().toString());
        histories.setAgentID(agentId);

        return histories;
    }
}
