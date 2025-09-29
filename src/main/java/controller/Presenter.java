/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.*;
import utilities.Constants;
import view.ConfigView;
import view.IOManager;

/**
 *
 * @author ninol
 */
public class Presenter {

    private ConfigManager configManager;
    private ContactBook contactBook;
    private Contact contanct;
    private IOManager frame;
    private ActionListener listener;
    private ConfigManager config;
    private ConfigView configView;

    public Presenter() {
        initListener();
        frame = new IOManager(listener);
        config = new ConfigManager();
        configManager = new ConfigManager();
        contactBook = GsonConverter.readFromJson(Constants.CONTACTS_PATH, ContactBook.class);
        initTable();
        applyConfig();
    }

    public void initTable() {
        for (Contact contact : contactBook.getContacts()) {
            frame.upLoadTable(contact.getPersonalData());
        }
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
                    case "Configurar":
                        openConfigView();
                        break;
                    case "Guardar":
                        saveConfig();
                        break;
                    case  "Cancelar":
                        if (configView != null) {
                            configView.dispose();
                        }
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
            frame.clear();
        } catch (IllegalArgumentException e) {
            frame.setTextOutput(e.getMessage());
        }
    }

    public void openConfigView(){
        configView = new ConfigView(listener);
        configView.setVisible(true);
    }

    public void applyConfig(){
        try {
            String background = config.readerConfig("color");
            frame.setBackgroundColor(Color.decode("#"+background));

            String fontName = config.readerConfig("font.name");
            int titleSize = Integer.parseInt(config.readerConfig("font.size"));
            int titleStyle = Integer.parseInt(config.readerConfig("font.style"));

            Font titleFont = new Font(fontName, titleStyle, titleSize);
            String textColor = config.readerConfig("color.text");
            frame.setConfig(titleFont, Color.decode("#"+textColor));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String chooseColor(String nameColor) {
        String color = ""; 
        switch (nameColor) {
            case "Rosa":
                color = "E989CF";
                break;
            case "Blanco":
                color = "FFFFFF";
                break;
            case "Negro":
                color = "000000";
                break;
            case "Azul":
                color = "4896D1";
                break;
        }
        return color;
    }

    public void saveConfig() {
        changeColorBackground();
        changeColorText();
        changeFont();
        applyConfig();
    }

    public void changeColorText() {
        String color = chooseColor(configView.getTextColor());
        configManager.writerConfig("color.text", color);
    }

    public void changeColorBackground() {
        String color = chooseColor(configView.getBackgroundColor());
        configManager.writerConfig("color", color);
    }

    public void changeFont() {
        String sizeFont = configView.getFontSize();
        String fontStyle = String.valueOf(configView.getFontStyle());
        String fontName = configView.getFontName();
        configManager.writerConfig("font.size", sizeFont);
        configManager.writerConfig("font.style", fontStyle);
        configManager.writerConfig("font.name", fontName);
    }
}
