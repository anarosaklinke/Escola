package utils;

import java.text.Normalizer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class validacao {

    public static String formatString(String str) {
        str = Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
        return str;
    }

    public static String formatString_E(String str) {
        str = Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
        str = str.replaceAll("[^a-zZ-Z1-9 ]", "");
        return str;
    }

    public static boolean isDateValid(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate d = LocalDate.parse(date, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean isInteger(String str) {
        return str != null && str.matches("[0-9]*");
    }


}
