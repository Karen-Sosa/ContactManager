/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import utilities.Constants;
import view.IOManager;

/**
 *
 * @author ninol
 */
public class Presenter {

    private ContactBook contactBook;
    private Contact contanct;
    private IOManager frame;
    private ActionListener listener;

    public Presenter() {
        initListener();
        frame = new IOManager(listener);
        contactBook = new ContactBook();
        GsonConverter.readFromJson(Constants.CONTACTS_PATH, ContactBook.class);
    }

    public void initListener() {
        listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String action = e.getActionCommand();
                switch (action) {
                    case "Registrar":
                        register();
                        break;
                }
            }

        };
    }

    public void register() {
        try {
            String name = frame.getTextName();
            int phone = frame.getTextPhone();
            String email = frame.getTextEmail();
            contanct = new Contact(name, phone, email);
            contactBook.addContact(contanct);
            GsonConverter.saveToJson(contactBook, Constants.CONTACTS_PATH);
            frame.upLoadTable(contanct.getPersonalData());
        } catch (IllegalArgumentException e) {
            frame.setTextOutput(e.getMessage());
        }
    }
}
