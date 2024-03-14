package com.example.yazlab21.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TextMerge {

    public static String birlestir(String[] cumleler) {
        for (String temp : cumleler) {
            String[] caunt = temp.split(" ");
            if(caunt.length != 1){

                Set<String> tekrarEdenKelimeler = new HashSet<>();
                List<String> oncekiKelimeler = new ArrayList<>();
                StringBuilder birlesikCumle = new StringBuilder();
                for (String cumle : cumleler) {
                    cumle = cumle.trim();
                    if (cumle.endsWith(".") || cumle.endsWith("?") || cumle.endsWith("!")) {
                        cumle = cumle.substring(0, cumle.length()-1);
                    }
                    String[] kelimeler = cumle.split(" ");
                    StringBuilder geciciCumle = new StringBuilder();
                    for (int i = 0; i < kelimeler.length; i++) {
                        String kelime = kelimeler[i].toLowerCase();
                        if (tekrarEdenKelimeler.contains(kelime)) {
                            kelimeler[i] = "";
                        } else if (oncekiKelimeler.contains(kelime)) {
                            kelimeler[i] = "";
                            tekrarEdenKelimeler.add(kelime);
                        } else {
                            oncekiKelimeler.add(kelime);
                        }
                        geciciCumle.append(kelimeler[i]).append(" ");
                    }
                    birlesikCumle.append(geciciCumle.toString().trim()).append(" ");
                }
                if (birlesikCumle.length() > 0) {
                    char sonKarakter = birlesikCumle.charAt(birlesikCumle.length()-1);
                    if (sonKarakter == '.' || sonKarakter == '?' || sonKarakter == '!') {
                        birlesikCumle.deleteCharAt(birlesikCumle.length()-1);
                    }
                }
                return birlesikCumle.toString().trim();

            }
        }


        StringBuilder sb = new StringBuilder();
        for (String str : cumleler) {
            str = str.trim();
            if (str.endsWith(".") || str.endsWith("?") || str.endsWith("!")) {
                str = str.substring(0, str.length()-1);
            }
            for (int i = 0; i < str.length(); i++) {
                char c = str.toLowerCase().charAt(i);
                if (sb.indexOf(Character.toString(c)) == -1) {
                    sb.append(c);
                }
            }
        }
        return sb.toString().chars()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();


    }
    public static String tekillestir(String cumle){

        String[] kelimeler = cumle.split(" ");
        StringBuilder birlesikCumle = new StringBuilder();
        StringBuilder geciciCumle = new StringBuilder();
        for (int i = 0; i < kelimeler.length; i++) {

            for (int j = 0; j < kelimeler.length; j++) {
                if(i == j){

                }else {
                    if(kelimeler[j].contains(kelimeler[i])){
                        kelimeler[i] = "";
                    }
                }

            }
            geciciCumle.append(kelimeler[i]).append(" ");

        }

        birlesikCumle.append(geciciCumle.toString().trim()).append(" ");

        return birlesikCumle.toString().trim();
    }


}
