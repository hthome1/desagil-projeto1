package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;



public class Frases extends AppCompatActivity {

    private int contador = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frases);

        ArrayList<String> listaFrases = new ArrayList<String>();



        TextView textExample = findViewById(R.id.text_example);
        TextView textExample0 = findViewById(R.id.text_example0);
        TextView textExample1 = findViewById(R.id.text_example1);
        TextView textExample2 = findViewById(R.id.text_example2);
        TextView textExample3 = findViewById(R.id.text_example3);
        TextView textExample4 = findViewById(R.id.text_example4);
        TextView textExample5 = findViewById(R.id.text_example5);
        TextView textExample6 = findViewById(R.id.text_example6);
        TextView textExample7 = findViewById(R.id.text_example7);


//        EditText editExample = findViewById(R.id.edit_example);
        Button botao1 = findViewById(R.id.button_example1);
        Button botao2 = findViewById(R.id.button_example2);

        listaFrases.add(textExample0.getText().toString());
        listaFrases.add(textExample1.getText().toString());
        listaFrases.add(textExample2.getText().toString());
        listaFrases.add(textExample3.getText().toString());
        listaFrases.add(textExample4.getText().toString());
        listaFrases.add(textExample5.getText().toString());
        listaFrases.add(textExample6.getText().toString());
        listaFrases.add(textExample7.getText().toString());






        botao1.setOnClickListener((view) -> {
            this.contador -= 1;
            if(contador <  0){
                contador = 7;
            }
            String content = listaFrases.get(this.contador);
            textExample.setText("Ferrão: " + content);

            if(contador == 0){
                textExample0.setTextColor(Color.RED);
            }
            else{
                textExample0.setTextColor(Color.GRAY);
            }
            if(contador == 1){
                textExample1.setTextColor(Color.RED);
            }
            else{
                textExample1.setTextColor(Color.GRAY);
            }
            if(contador == 2){
                textExample2.setTextColor(Color.RED);
            }
            else{
                textExample2.setTextColor(Color.GRAY);
            }
            if(contador == 3){
                textExample3.setTextColor(Color.RED);
            }
            else{
                textExample3.setTextColor(Color.GRAY);
            }
            if(contador == 4){
                textExample4.setTextColor(Color.RED);
            }
            else{
                textExample4.setTextColor(Color.GRAY);
            }
            if(contador == 5){
                textExample5.setTextColor(Color.RED);
            }
            else{
                textExample5.setTextColor(Color.GRAY);
            }
            if(contador == 6){
                textExample6.setTextColor(Color.RED);
            }
            else{
                textExample6.setTextColor(Color.GRAY);
            }
            if(contador == 7){
                textExample7.setTextColor(Color.RED);
            }
            else{
                textExample7.setTextColor(Color.GRAY);
            }

        });

        botao2.setOnClickListener((view) -> {
            this.contador += 1;
            if(this.contador==8) {
                this.contador = 0;
            }
            String content = listaFrases.get(this.contador);
            textExample.setText("Ferrão: " + content);

            if(contador == 0){
                textExample0.setTextColor(Color.RED);
            }
            else{
                textExample0.setTextColor(Color.GRAY);
            }
            if(contador == 1){
                textExample1.setTextColor(Color.RED);
            }
            else{
                textExample1.setTextColor(Color.GRAY);
            }
            if(contador == 2){
                textExample2.setTextColor(Color.RED);
            }
            else{
                textExample2.setTextColor(Color.GRAY);
            }
            if(contador == 3){
                textExample3.setTextColor(Color.RED);
            }
            else{
                textExample3.setTextColor(Color.GRAY);
            }
            if(contador == 4){
                textExample4.setTextColor(Color.RED);
            }
            else{
                textExample4.setTextColor(Color.GRAY);
            }
            if(contador == 5){
                textExample5.setTextColor(Color.RED);
            }
            else{
                textExample5.setTextColor(Color.GRAY);
            }
            if(contador == 6){
                textExample6.setTextColor(Color.RED);
            }
            else{
                textExample6.setTextColor(Color.GRAY);
            }
            if(contador == 7){
                textExample7.setTextColor(Color.RED);
            }
            else{
                textExample7.setTextColor(Color.GRAY);
            }

        });






    }
}
