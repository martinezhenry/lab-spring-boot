package com.hvs.lib;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<String> hashList;
    static List<String> wordList;

    public static void main(String[] args) {

        WordReader wordReader = new WordReader();

        wordList = new ArrayList<>();
        wordList.add("hello");
        wordList.add("world");
        wordList.add("world2");
        wordList.add("world3");
        wordList.add("world4");

        hashList = new ArrayList<>();
        hashList.add("d29ybGQ=");
        hashList.add("aGVsbG8=");
        hashList.add("d29ybGQ=");

        String result;

        for (String hash: hashList) {
            boolean found = false;
            for (String word: wordList) {
                result = wordReader.cipher(word);
                if (result.equals(hash)) {
                    System.out.println("la clave es para el hash (" + hash + ") es: " + word);
                    wordList.remove(word);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("clave para hash (" + hash + ") no encontrada");
            }
        }

    }
}