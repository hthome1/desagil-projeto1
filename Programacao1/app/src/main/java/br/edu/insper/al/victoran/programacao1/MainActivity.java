package br.edu.insper.al.victoran.programacao1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int contador = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<String> listaFrases = new ArrayList<String>();


        TextView textExample = findViewById(R.id.text_example);
        TextView textExample2 = findViewById(R.id.text_example2);
        TextView textExample3 = findViewById(R.id.text_example3);
        TextView textExample4 = findViewById(R.id.text_example4);
        TextView textExample5 = findViewById(R.id.text_example5);
        TextView textExample6 = findViewById(R.id.text_example6);
        TextView textExample7 = findViewById(R.id.text_example7);
        TextView textExample8 = findViewById(R.id.text_example8);
        TextView textExample9 = findViewById(R.id.text_example9);
        TextView textExample10 = findViewById(R.id.text_example10);

//        EditText editExample = findViewById(R.id.edit_example);
        Button botao1 = findViewById(R.id.button_example1);
        Button botao2 = findViewById(R.id.button_example2);

        listaFrases.add(textExample3.getText().toString());
        listaFrases.add(textExample4.getText().toString());
        listaFrases.add(textExample5.getText().toString());
        listaFrases.add(textExample6.getText().toString());
        listaFrases.add(textExample7.getText().toString());
        listaFrases.add(textExample8.getText().toString());
        listaFrases.add(textExample9.getText().toString());
        listaFrases.add(textExample10.getText().toString());




        botao1.setOnClickListener((view) -> {
            this.contador -= 1;
            String content = listaFrases.get(this.contador);
            textExample.setText("Ferrão: "+content);
        });

        botao2.setOnClickListener((view) -> {
            this.contador += 1;
            if(this.contador<=8) {
                String content = listaFrases.get(this.contador);
                textExample.setText("Ferrão: " + content);

            }

            else{

                this.contador = 0;
            }
        });




    }
}
