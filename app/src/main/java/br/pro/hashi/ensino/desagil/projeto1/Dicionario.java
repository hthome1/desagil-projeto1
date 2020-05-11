package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;



public class Dicionario extends AppCompatActivity {
    private Translator translator = new Translator();
    private char[] chars;
    private ArrayList<String> resultado = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dicionario);
        chars = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'};
        for (char lista:chars){
            String letra = String.valueOf(lista);
            String elemento = letra + " : " + translator.charToMorse(lista);
            resultado.add(elemento);
        }
        System.out.println(resultado);
    }

}


