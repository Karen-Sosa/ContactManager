/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        configView = new ConfigView(listener);
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
                    case Constants.ACTION_REGISTER:
                        register();
                        break;
                    case Constants.ACTION_CONFIG:
                        configView.setVisible(true);
                        break;
                    case Constants.ACTION_SAVE:
                        saveConfig();
                        break;
                    case Constants.ACTION_CANCEL:
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

    public void applyConfig() {
        try {
            String background = config.readerConfig(Constants.CONFIG_COLOR_BG);
            frame.setBackgroundColor(Color.decode(Constants.NUMERIC + background));
            configView.setBackgroundColor(Color.decode(Constants.NUMERIC + background));

            String fontName = config.readerConfig(Constants.CONFIG_FONT_NAME);
            int titleSize = Integer.parseInt(config.readerConfig(Constants.CONFIG_FONT_SIZE));
            int titleStyle = Integer.parseInt(config.readerConfig(Constants.CONFIG_FONT_STYLE));

            Font titleFont = new Font(fontName, titleStyle, titleSize);
            String textColor = config.readerConfig(Constants.CONFIG_COLOR_TEXT);
            frame.setConfig(titleFont, Color.decode(Constants.NUMERIC + textColor));
            configView.setConfig(titleFont, Color.decode(Constants.NUMERIC + textColor));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String chooseColor(String nameColor) {
        switch (nameColor) {
            case Constants.COLOR_NAME_PINK:
                return Constants.COLOR_HEX_PINK;
            case Constants.COLOR_NAME_WHITE:
                return Constants.COLOR_HEX_WHITE;
            case Constants.COLOR_NAME_BLACK:
                return Constants.COLOR_HEX_BLACK;
            case Constants.COLOR_NAME_BLUE:
                return Constants.COLOR_HEX_BLUE;
            default:
                return "";
        }
    }

    public void saveConfig() {
        changeColorBackground();
        changeColorText();
        changeFont();
        applyConfig();
    }

    public void changeColorText() {
        String color = chooseColor(configView.getTextColor());
        configManager.writerConfig(Constants.CONFIG_COLOR_TEXT, color);
    }

    public void changeColorBackground() {
        String color = chooseColor(configView.getBackgroundColor());
        configManager.writerConfig(Constants.CONFIG_COLOR_BG, color);
    }

    public void changeFont() {
        String sizeFont = configView.getFontSize();
        String fontStyle = String.valueOf(configView.getFontStyle());
        String fontName = configView.getFontName();
        configManager.writerConfig(Constants.CONFIG_FONT_SIZE, sizeFont);
        configManager.writerConfig(Constants.CONFIG_FONT_STYLE, fontStyle);
        configManager.writerConfig(Constants.CONFIG_FONT_NAME, fontName);
    }
}
