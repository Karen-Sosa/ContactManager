package model;

import java.util.ArrayList;

import utilities.Constants;

public class ContactBook {

    private ArrayList<Contact> contacts;

    public ContactBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        if (contacts.stream().anyMatch(x -> x.getPhone().equals(contact.getPhone()))) {
            throw new IllegalArgumentException(Constants.PHONE_EXISTING);
        }
        contacts.add(contact);
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }
}
