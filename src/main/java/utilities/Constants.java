/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

/**
 *
 * @author ninol
 */
public class Constants {
    public static final String CONFIG_PATH = "src/main/java/config.properties";
    public static final String CONTACTS_PATH = "src\\main\\java\\Contacts\\Contacts.json";

    // Actions
    public static final String ACTION_REGISTER = "Registrar";
    public static final String ACTION_CONFIG = "Configurar";
    public static final String ACTION_SAVE = "Guardar";
    public static final String ACTION_CANCEL = "Cancelar";

    // UI text
    public static final String LABEL_NAME = "Nombre";
    public static final String LABEL_PHONE = "Teléfono";
    public static final String LABEL_EMAIL = "Correo";
    public static final String LABEL_TITLE = "Agenda de contactos";
    public static final String LABEL_FONT = "Fuente:";
    public static final String LABEL_SIZE = "Tamaño:";
    public static final String LABEL_STYLE = "Estilo:";
    public static final String LABEL_TEXT_COLOR = "Color texto:";
    public static final String LABEL_BG_COLOR = "Color fondo:";

    // Symbols
    public static final String AT = "@";
    public static final String NUMERIC = "#";

    // Nombres de colores
    public static final String COLOR_NAME_PINK = "Rosa";
    public static final String COLOR_NAME_WHITE = "Blanco";
    public static final String COLOR_NAME_BLACK = "Negro";
    public static final String COLOR_NAME_BLUE = "Azul";

    // Códigos hex de colores
    public static final String COLOR_HEX_PINK = "E989CF";
    public static final String COLOR_HEX_WHITE = "FFFFFF";
    public static final String COLOR_HEX_BLACK = "000000";
    public static final String COLOR_HEX_BLUE = "4896D1";

    // Keys de configuración
    public static final String CONFIG_COLOR_BG = "color";
    public static final String CONFIG_COLOR_TEXT = "color.text";
    public static final String CONFIG_FONT_NAME = "font.name";
    public static final String CONFIG_FONT_SIZE = "font.size";
    public static final String CONFIG_FONT_STYLE = "font.style";

    // Table columns
    public static final String[] TABLE_COLUMNS = { "Nombre", "Teléfono", "Correo" };

    // Styles
    public static final String[] FONTS = { "Arial", "Times New Roman", "Courier New" };
    public static final String[] FONT_SIZES = { "14", "18", "20" };
    public static final String[] FONT_STYLES = { "PLAIN", "BOLD", "ITALIC" };
    public static final String[] COLOR_NAMES = { "Rosa", "Blanco", "Azul", "Negro" };

    // Frames
    public static final String TTTLE_CONFIG_FRAME = "Configuración de interfaz";

    // Errors
    public static final String PHONE_EXISTING = "Ya existe un contacto con ese teléfono";
    public static final String ERROR_EMPTY_NAME = "Nombre vacío";
    public static final String ERROR_INVALID_PHONE = "Teléfono inválido";
    public static final String ERROR_INVALID_EMAIL = "Correo inválido";
}
