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
        contactBook = new ContactBook();
        GsonConverter.readFromJson(Constants.CONTACTS_PATH, ContactBook.class);
        applyConfig();
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

    public void saveConfig(){
        if (configView != null) {
        config.writerConfig("font.name", configView.getFontName());
        config.writerConfig("font.size", String.valueOf(configView.getFontSize()));
        config.writerConfig("font.style", String.valueOf(configView.getFontStyle()));
        config.writerConfig("color.text", configView.getTextColor());
        config.writerConfig("color", configView.getBackgroundColor());

        configView.dispose();
        applyConfig();
        }
    }

    public void applyConfig(){
        try {
            String background = config.readerCofig("color");
            frame.setBackgroundColor(Color.decode(background));

            String fontName = config.readerCofig("font.name");
            int titleSize = Integer.parseInt(config.readerCofig("font.size"));
            int titleStyle = Integer.parseInt(config.readerCofig("font.style"));

            Font titleFont = new Font(fontName, titleStyle, titleSize);

            String textColor = config.readerCofig("color.text");
            
            frame.setConfig(titleFont, Color.decode(textColor));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
