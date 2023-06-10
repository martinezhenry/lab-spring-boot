package com.hvs.lib;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class WordReader {


    public String cipher(String word){
        return Base64.getEncoder().encodeToString(word.getBytes(StandardCharsets.UTF_8));
    }



}
