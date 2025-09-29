package model;

import utilities.Constants;

public class Contact {
    String[] personalData = new String[3];

    public Contact(String name, int phone, String mail) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException(Constants.ERROR_EMPTY_NAME);
        if (phone <= 0)
            throw new IllegalArgumentException(Constants.ERROR_INVALID_PHONE);
        if (!mail.contains(Constants.AT))
            throw new IllegalArgumentException(Constants.ERROR_INVALID_EMAIL);
        personalData[0] = name;
        personalData[1] = String.valueOf(phone);
        personalData[2] = mail;
    }

    public String[] getPersonalData() {
        return personalData;
    }

    public String getPhone() {
        return personalData[1];
    }
}