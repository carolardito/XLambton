package com.example.carolina.xlambton.helper;

import android.widget.EditText;

import com.example.carolina.xlambton.LogIn;
import com.example.carolina.xlambton.R;
import com.example.carolina.xlambton.model.User;

public class FormLoginHelper {
    private final EditText fieldUser;
    private final EditText fieldPassword;

    private User user;

    public FormLoginHelper(LogIn activity) {
        this.fieldUser = (EditText) activity.findViewById(R.id.login_user);
        this.fieldPassword = (EditText) activity.findViewById(R.id.login_password);

        user = new User();
    }

    public User helperLogin() {
        user.setUser(fieldUser.getText().toString());
        user.setPassword(fieldPassword.getText().toString());

        return user;
    }
}
