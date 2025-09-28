/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import view.IOManager;

/**
 *
 * @author ninol
 */
public class Presenter {

    private Contact model;
    private IOManager frame;
    private ActionListener listener;

    public Presenter(){
        model = new Contact();
        initListener();
        frame = new IOManager(listener);
    }
    
    public void initListener(){
        listener = new ActionListener(){
             @Override
            public void actionPerformed(ActionEvent e){
                String action = e.getActionCommand();
                switch (action) {
                    case "Registar":
                        register();
                        break;
                }
            }
            
        };
    }

    public void register(){

    }
}
