package view;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import utilities.Constants;

public class ConfigView extends JFrame {
    private JPanel panel;
    private JLabel fontLabel;
    private JLabel bgColorLabel;
    private JLabel sizeLabel;
    private JLabel styleLabel;
    private JLabel textColorLabel;
    private JComboBox<String> fontNameBox;
    private JComboBox<String> fontSizeBox;
    private JComboBox<String> fontStyleBox;
    private JComboBox<String> textColorBox;
    private JComboBox<String> backgroundColorBox;
    private JButton saveButton, cancelButton;

    public ConfigView(ActionListener listener) {
        setTitle("Configuración de interfaz");
        setSize(new Dimension(400, 300));
        setLocationRelativeTo(null);
        setLayout(null);
        initComponents(listener);
    }

    public void initComponents(ActionListener listener) {

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(10, 10, 365, 240);
        add(panel);

        String[] fonts = { "Arial", "Times New Roman", "Courier New" };
        String[] sizes = { "14", "18", "20" };
        String[] styles = { "PLAIN", "BOLD", "ITALIC" };
        String[] colors = { "Rosa", "Blanco", "Azul", "Negro" };

        int labelWidth = 120, fieldWidth = 150, height = 25, gap = 35;

        saveButton = new JButton("Guardar");
        saveButton.setBounds(60, 20 + 5 * gap, 100, height);
        saveButton.setActionCommand("Guardar");
        saveButton.addActionListener(listener);
        panel.add(saveButton);

        cancelButton = new JButton("Cancelar");
        cancelButton.setBounds(180, 20 + 5 * gap, 100, height);
        cancelButton.setActionCommand("Cancelar");
        cancelButton.addActionListener(listener);
        panel.add(cancelButton);

        fontLabel = new JLabel("Fuente:");
        fontLabel.setBounds(20, 20, labelWidth, height);
        panel.add(fontLabel);

        sizeLabel = new JLabel("Tamaño:");
        sizeLabel.setBounds(20, 20 + gap, labelWidth, height);
        panel.add(sizeLabel);

        styleLabel = new JLabel("Estilo:");
        styleLabel.setBounds(20, 20 + 2 * gap, labelWidth, height);
        panel.add(styleLabel);

        textColorLabel = new JLabel("Color texto:");
        textColorLabel.setBounds(20, 20 + 3 * gap, labelWidth, height);
        panel.add(textColorLabel);

        bgColorLabel = new JLabel("Color fondo:");
        bgColorLabel.setBounds(20, 20 + 4 * gap, labelWidth, height);
        panel.add(bgColorLabel);

        fontNameBox = new JComboBox<>(fonts);
        fontNameBox.setBounds(150, 20, fieldWidth, height);
        panel.add(fontNameBox);

        fontSizeBox = new JComboBox<>(sizes);
        fontSizeBox.setBounds(150, 20 + gap, fieldWidth, height);
        panel.add(fontSizeBox);

        fontStyleBox = new JComboBox<>(styles);
        fontStyleBox.setBounds(150, 20 + 2 * gap, fieldWidth, height);
        panel.add(fontStyleBox);

        textColorBox = new JComboBox<>(colors);
        textColorBox.setBounds(150, 20 + 3 * gap, fieldWidth, height);
        panel.add(textColorBox);

        backgroundColorBox = new JComboBox<>(colors);
        backgroundColorBox.setBounds(150, 20 + 4 * gap, fieldWidth, height);
        panel.add(backgroundColorBox);

        
    }

    public String getFontName() {
        return (String) fontNameBox.getSelectedItem();
    }

    public String getFontSize() {
        return (String) fontSizeBox.getSelectedItem();
    }

    public int getFontStyle() {
        return (int) fontStyleBox.getSelectedIndex();
    }

    public String getTextColor() {
        return (String) textColorBox.getSelectedItem();
    }

    public String getBackgroundColor() {
        return (String) backgroundColorBox.getSelectedItem();
    }

    public void setBackgroundColor(Color color) {
        panel.setBackground(color);
    }

    public void setConfig(Font font, Color color) {
    saveButton.setFont(font);
    saveButton.setForeground(color);
    cancelButton.setFont(font);
    cancelButton.setForeground(color);

    fontLabel.setFont(font);
    fontLabel.setForeground(color);
    sizeLabel.setFont(font);
    sizeLabel.setForeground(color);
    styleLabel.setFont(font);
    styleLabel.setForeground(color);
    textColorLabel.setFont(font);
    textColorLabel.setForeground(color);
    bgColorLabel.setFont(font);
    bgColorLabel.setForeground(color);

    fontNameBox.setFont(font);
    fontNameBox.setForeground(color);
    fontSizeBox.setFont(font);
    fontSizeBox.setForeground(color);
    fontStyleBox.setFont(font);
    fontStyleBox.setForeground(color);
    textColorBox.setFont(font);
    textColorBox.setForeground(color);
    backgroundColorBox.setFont(font);
    backgroundColorBox.setForeground(color);
    }
}