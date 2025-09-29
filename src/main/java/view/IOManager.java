/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author ninol
 */
public class IOManager extends JFrame {
    private JTable table;
    private JLabel labelName;
    private JLabel labelPhone;
    private JLabel labelEmail;
    private JLabel labelTitle;
    private JPanel panel;
    private JButton button;
    private JButton buttonConfig;
    private JScrollPane scroll;
    private JTextField textName;
    private JFormattedTextField textPhone;
    private JTextField textEmail;
    private JLabel textOutput;
    private DefaultTableModel modelTable;
    private ActionListener listener;

    public IOManager(ActionListener listener) {
        this.listener = listener;
        this.setSize(new Dimension(400, 460));
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setResizable(false);
        initComponents();
    }

    public void initComponents() {

        panel = new JPanel();
        this.add(panel);
        this.panel.setLayout(null);
        this.panel.setSize(new Dimension(365, 405));
        this.panel.setLocation(10, 10);

        labelTitle = new JLabel("Agenda de contactos");
        labelTitle.setSize(380, 30);
        labelTitle.setLocation(0, 0);
        labelTitle.setHorizontalAlignment(JLabel.CENTER);
        this.panel.add(labelTitle);

        textName = new JTextField();
        textName.setSize(200, 25);
        textName.setLocation(150, 40);
        this.panel.add(this.textName);

        NumberFormat intFormat = NumberFormat.getIntegerInstance();
        NumberFormatter intFormatter = new NumberFormatter(intFormat);
        intFormatter.setValueClass(Integer.class);
        textPhone = new JFormattedTextField(intFormatter);
        textPhone.setSize(200, 25);
        textPhone.setLocation(150, 80);
        this.panel.add(this.textPhone);

        textEmail = new JTextField();
        textEmail.setSize(200, 25);
        textEmail.setLocation(150, 120);
        this.panel.add(this.textEmail);

        labelName = new JLabel("Nombre");
        labelName.setSize(120, 25);
        labelName.setLocation(20, 40);
        this.panel.add(labelName);

        labelPhone = new JLabel("Teléfono");
        labelPhone.setSize(120, 25);
        labelPhone.setLocation(20, 80);
        this.panel.add(labelPhone);

        labelEmail = new JLabel("Correo");
        labelEmail.setSize(120, 25);
        labelEmail.setLocation(20, 120);
        this.panel.add(labelEmail);

        button = new JButton("Registrar");
        button.setActionCommand("Registrar");
        button.setSize(90, 25);
        button.setLocation(259, 160);
        button.addActionListener(listener);
        this.panel.add(button);

        buttonConfig = new JButton("Configurar");
        buttonConfig.setActionCommand("Configurar");
        buttonConfig.setSize(110, 25);
        buttonConfig.setLocation(130, 160);
        buttonConfig.addActionListener(listener);
        this.panel.add(buttonConfig);

        textOutput = new JLabel();
        textOutput.setSize(325, 25);
        textOutput.setLocation(20, 205);
        textOutput.setForeground(Color.red);
        this.panel.add(textOutput);

        // TABLA
        String[] columns = { "Nombre", "Teléfono", "Correo" };
        modelTable = new DefaultTableModel(columns, 0);
        table = new JTable(modelTable);
        table.getTableHeader().setReorderingAllowed(false);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setSize(new Dimension(330, 130));
        scroll.setLocation(20, 260);
        this.panel.add(scroll);

        this.setVisible(true);
    }

    public void clear(){
        textName.setText("");
        textPhone.setText("");
        textEmail.setText("");
    }

    public void upLoadTable(String[] newContact) {
        modelTable.addRow(newContact);
    }

    public void setTextOutput(String textOutput) {
        this.textOutput.setText(textOutput);
    }

    public String getTextName() {
        return textName.getText();
    }

    public int getTextPhone() {
        Number value = (Number) textPhone.getValue();
        return value == null? 0 : value.intValue();
    }

    public String getTextEmail() {
        return textEmail.getText();
    }

    public void setBackgroundColor(Color color){
        panel.setBackground(color);
    }

    public void setConfig(Font font, Color color) {
    labelName.setFont(font);
    labelName.setForeground(color);

    labelPhone.setFont(font);
    labelPhone.setForeground(color);

    labelEmail.setFont(font);
    labelEmail.setForeground(color);

    labelTitle.setFont(font);
    labelTitle.setForeground(color);

    textOutput.setFont(font);
    textOutput.setForeground(color);

    button.setFont(font);
    button.setForeground(color);

    buttonConfig.setFont(font);
    buttonConfig.setForeground(color);

    textName.setFont(font);
    textName.setForeground(color);

    textPhone.setFont(font);
    textPhone.setForeground(color);

    textEmail.setFont(font);
    textEmail.setForeground(color);

    table.setFont(font);
    table.setForeground(color);
    table.getTableHeader().setFont(font);
    table.getTableHeader().setForeground(color);

    }    
}
