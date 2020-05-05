package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botaoFrases = findViewById(R.id.button3);
        botaoFrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent frases = new Intent(MainActivity.this, Frases.class);
                startActivity(frases);
            }
        });

        TextView mensagem = findViewById(R.id.textView5);

        Button botaoMorse = findViewById(R.id.button2);

        Button botaoTrad = findViewById(R.id.traduzir);

        TextView mensagem2 = findViewById(R.id.textView4);

        botaoMorse.setOnClickListener((view) -> {
            mensagem.setText(mensagem.getText().toString()+".");

        });

        botaoMorse.setOnLongClickListener((view) -> {
            mensagem.setText(mensagem.getText().toString()+"-");

            return true;
        });

        Translator translator = new Translator();


        botaoTrad.setOnClickListener((view) -> {
            String trad = Character.toString(translator.morseToChar(mensagem.getText().toString()));
            mensagem2.setText("Mensagem: "+trad);

        });


    }
}
