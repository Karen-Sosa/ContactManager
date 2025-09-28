package model;

public class Contact {
    String[] personalData = new String[3];

    public Contact(String name, int phone, String mail) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Nombre vacío");
        if (phone <= 0) throw new IllegalArgumentException("Teléfono inválido");
        if (!mail.contains("@")) throw new IllegalArgumentException("Correo inválido");
        personalData[0] = name;
        personalData[1] = String.valueOf(phone);
        personalData[2] = mail;
    }

    public String[] getPersonalData() {
        return personalData;
    }

    public String getPhone(){
        return personalData[1];
    }
}