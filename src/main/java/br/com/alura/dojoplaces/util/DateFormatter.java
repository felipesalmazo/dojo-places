package br.com.alura.dojoplaces.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateFormatter {

    public static String formatDDMMYYYY (LocalDateTime date) {
        if (date != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return date.format(formatter);
        }
        return "";
    }

    public static String formatDifferenceToMessage(LocalDateTime date) {
        if (date != null) {
            long seconds = ChronoUnit.SECONDS.between(date, LocalDateTime.now());

            String message;
            if (seconds < 60) {
                message = "Atualizado há poucos segundos atrás.";
            } else if (seconds < 3600) {
                long minutes = seconds / 60;
                message = "Atualizado há " + minutes + " minutos atrás.";
            } else if (seconds < 86400) {
                long hours = seconds / 3600;
                message = "Atualizado há " + hours + " horas atrás.";
            } else if (seconds < 2592000) {
                long days = seconds / 86400;
                message = "Atualizado há " + days + " dias atrás.";
            } else if (seconds < 31536000) {
                long months = seconds / 2592000;
                message = "Atualizado há " + months + " meses atrás.";
            } else {
                long years = seconds / 31536000;
                message = "Atualizado há " + years + " anos atrás.";
            }

            return message;
        }

        return "";
    }

}
