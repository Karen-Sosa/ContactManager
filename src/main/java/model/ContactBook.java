package model;

import java.util.ArrayList;

public class ContactBook {

    private ArrayList<Contact> contacts;

    public ContactBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        if (contacts.stream().anyMatch(x -> x.getPhone().equals(contact.getPhone()))) {
            throw new IllegalArgumentException("Ya existe un contacto con ese teléfono");
        }
        contacts.add(contact);
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }
}
