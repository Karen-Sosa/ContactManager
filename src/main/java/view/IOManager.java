/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
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
    private JLabel label;
    private JPanel panel;
    private JButton button;
    private JScrollPane scroll;
    private JTextField textName;
    private JFormattedTextField textPhone;
    private JTextField textEmail;
    private JLabel textOutput;
    private DefaultTableModel modelTable;
    private ActionListener listener;

    public IOManager(ActionListener listener) {
        this.listener = listener;
        this.setSize(new Dimension(400, 500));
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
        this.panel.setSize(new Dimension(390, 430));
        this.panel.setLocation(10, 10);

        label = new JLabel("Agenda de contactos");
        label.setSize(380, 30);
        label.setLocation(0, 0);
        label.setHorizontalAlignment(JLabel.CENTER);
        this.panel.add(label);

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

        label = new JLabel("Nombre");
        label.setSize(120, 25);
        label.setLocation(20, 40);
        this.panel.add(label);

        label = new JLabel("Teléfono");
        label.setSize(120, 25);
        label.setLocation(20, 80);
        this.panel.add(label);

        label = new JLabel("Correo");
        label.setSize(120, 25);
        label.setLocation(20, 120);
        this.panel.add(label);

        button = new JButton("Registrar");
        button.setActionCommand("Registrar");
        button.setSize(90, 25);
        button.setLocation(259, 160);
        button.addActionListener(listener);
        this.panel.add(button);

        textOutput = new JLabel();
        textOutput.setSize(325, 25);
        textOutput.setLocation(20, 200);
        textOutput.setForeground(Color.red);
        this.panel.add(textOutput);

        // TABLA
        String[] columns = { "Nombre", "Teléfono", "Correo" };
        modelTable = new DefaultTableModel(columns, 0);
        table = new JTable(modelTable);
        table.getTableHeader().setReorderingAllowed(false);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setSize(new Dimension(330, 130));
        scroll.setLocation(20, 300);
        this.panel.add(scroll);

        this.setVisible(true);
    }

    public void upLoadTable(String[] newContact) {
        modelTable.addRow(newContact);
    }

    // public void setEvent() {
    //     button.addActionListener(
    //             new ActionListener() {
    //                 @Override
    //                 public void actionPerformed(ActionEvent e) {
    //                     register();
    //                 }
    //             });
    // }

    // public void register() {
    //     String name = textName.getText();
    //     String phone = textPhone.getText();
    //     String email = textEmail.getText();

    //     if (!name.isBlank() && !phone.isBlank() && !email.isBlank()) {
    //         modelTable.addRow(new Object[] { name, phone, email });
    //         // envio de datos a Gson
    //         textName.setText("");
    //         textPhone.setText("");
    //         textEmail.setText("");
    //     } else {
    //         textOutput.setText("Debe completar los tres campos de texto");

    //     }
    // }

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

}
