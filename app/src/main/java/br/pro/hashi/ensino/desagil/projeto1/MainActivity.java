package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity {
    long then = 0;
    long now = 0;
    long temp_final = 0;
    int uniTempo = 500;
    String texto = "";
//    long endTime = 0;
    @SuppressLint({"SetTextI18n", "ClickableViewAccessibility"})
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

        Button botaoDicionario = findViewById(R.id.button8);
        botaoDicionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dicio = new Intent(MainActivity.this, Dicionario.class);
                startActivity(dicio);
            }
        });

        TextView mensagem = findViewById(R.id.textView5);

        Button botaoMorse = findViewById(R.id.button2);

        Button botaoTrad = findViewById(R.id.traduzir);

        TextView mensagem2 = findViewById(R.id.textView4);

        Translator translator = new Translator();

        botaoMorse.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    then = System.currentTimeMillis();
                }
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    now = System.currentTimeMillis();
                    if((now - then) < uniTempo){
                        mensagem.setText(mensagem.getText().toString()+".");
                        texto += ".";
                    }
                    else if((now - then) > uniTempo && (now - then) < uniTempo*3 ){
                        mensagem.setText(mensagem.getText().toString()+"-");
                        texto += "-";
                    }
                    else if((now-then)>=uniTempo*5){
                        mensagem2.setText("Mensagem: ");
                    }
                }

                return false;
            }
        });

        botaoTrad.setOnClickListener((view) -> {
            String trad = Character.toString(translator.morseToChar(mensagem.getText().toString()));
            mensagem2.setText(mensagem2.getText().toString() + trad);
            mensagem.setText("");
        });





    }
}
