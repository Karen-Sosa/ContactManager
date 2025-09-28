/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.IOManager;

/**
 *
 * @author ninol
 */
public class Presenter {
    private IOManager frame;
    private ActionListener listener;

    public Presenter(){
        initListener();
        frame = new IOManager(listener);
    }
    
    public void initListener(){
        listener = new ActionListener(){
             @Override
            public void actionPerformed(ActionEvent e){
                
            }
            
        };
    }
}
