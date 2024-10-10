package org.utic.webapp.gestion.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Cripto {
    public static String generateHashMD5(String texto) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(texto.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al generar el hash MD5", e);
        }
    }
}
