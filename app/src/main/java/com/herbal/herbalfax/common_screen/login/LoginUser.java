package com.herbal.herbalfax.common_screen.login;

import android.util.Patterns;

public class LoginUser {
    private final String strEmailAddress;
    private final String strPassword;

    /**
     *
     * @param EmailAddress
     * @param Password
     */
    public LoginUser(String EmailAddress, String Password) {
        strEmailAddress = EmailAddress;
        strPassword = Password;
    }

    public String getStrEmailAddress() {
        return strEmailAddress;
    }

    public String getStrPassword() {
        return strPassword;
    }

    public boolean isEmailValid() {
        return Patterns.EMAIL_ADDRESS.matcher(getStrEmailAddress()).matches();
    }


    public boolean isPasswordLengthGreaterThan5() {
        return getStrPassword().length() > 3;
    }

}