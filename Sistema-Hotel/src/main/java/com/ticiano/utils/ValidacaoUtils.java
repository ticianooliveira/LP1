package com.ticiano.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class ValidacaoUtils {

    // Validação de CPF com base em seu formato e dígitos verificadores
    public static boolean validarCPF(String cpf) {
        // CPF deve ter 11 dígitos
        if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d{11}")) {
            return false;
        }

        // Calculando os dígitos verificadores
        int[] pesoCPF = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        char dig10, dig11;
        int sm, i, r, num;

        // Calculando o primeiro dígito verificador
        sm = 0;
        for (i = 0; i < 9; i++) {
            num = (int) (cpf.charAt(i) - 48);
            sm += (num * pesoCPF[i]);
        }
        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11)) {
            dig10 = '0';
        } else {
            dig10 = (char) (r + 48);
        }

        // Calculando o segundo dígito verificador
        sm = 0;
        int[] pesoCPF2 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        for (i = 0; i < 10; i++) {
            num = (int) (cpf.charAt(i) - 48);
            sm += (num * pesoCPF2[i]);
        }
        r = 11 - (sm % 11);
        if ((r == 10) || (r == 11)) {
            dig11 = '0';
        } else {
            dig11 = (char) (r + 48);
        }

        // Verificando se os dígitos calculados conferem com os dígitos informados
        return (dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10));
    }

    // Validação de número de contato (apenas verifica se é numérico e tem 10 ou 11 dígitos)
    public static boolean validarNumeroContato(String numeroContato) {
        return numeroContato != null && numeroContato.matches("\\d{10,11}");
    }

    // Formatação de data
    public static Date formatarData(String data) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        sdf.setLenient(false);
        return sdf.parse(data);
    }
}
