package com.example.carolina.xlambton.helper;

import android.widget.EditText;

import com.example.carolina.xlambton.NewUser;
import com.example.carolina.xlambton.R;
import com.example.carolina.xlambton.model.User;

public class FormNewUserHelper {
    private final EditText fieldUser;
    private final EditText fieldPassword;

    private User user;

    public FormNewUserHelper(NewUser activity) {
        this.fieldUser = (EditText) activity.findViewById(R.id.newEmail);
        this.fieldPassword = (EditText) activity.findViewById(R.id.newPassword);

        user = new User();
    }

    public User helperNewUser() {
        user.setUser(fieldUser.getText().toString());
        user.setPassword(fieldPassword.getText().toString());

        return user;
    }
}
