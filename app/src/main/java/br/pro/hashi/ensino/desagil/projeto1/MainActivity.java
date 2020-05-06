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

import android.os.Bundle;



public class MainActivity extends AppCompatActivity {
    long then = 0;
    long now = 0;
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

        TextView mensagem = findViewById(R.id.textView5);

        Button botaoMorse = findViewById(R.id.button2);

        Button botaoTrad = findViewById(R.id.traduzir);

        TextView mensagem2 = findViewById(R.id.textView4);

//        botaoMorse.setOnClickListener((view) -> {
//            mensagem.setText(mensagem.getText().toString()+".");
//
//        });
//
//        botaoMorse.setOnLongClickListener((view) -> {
//            mensagem.setText(mensagem.getText().toString()+"-");
//
//            return true;
//        });
//
        Translator translator = new Translator();
//
//
//        botaoTrad.setOnClickListener((view) -> {
//            String trad = Character.toString(translator.morseToChar(mensagem.getText().toString()));
//            mensagem2.setText("Mensagem: "+trad);

//        long tempo_1 = 0;
//        long tempo_2 = 0;


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
//                        try {
//                            TimeUnit.MILLISECONDS.sleep(3000);
//                            long endTime = System.currentTimeMillis();
//                            if (endTime-now>=3000){
//                                String trad = Character.toString(translator.morseToChar(mensagem.getText().toString()));
//                                mensagem2.setText(mensagem2.getText().toString()+trad);
//                            }
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                    }
                    else if((System.currentTimeMillis() - then) > uniTempo && (System.currentTimeMillis() - then) < uniTempo*3 ){
                        mensagem.setText(mensagem.getText().toString()+"-");
                        texto += "-";
                    }

                }








                return false;
            }
        });

        botaoTrad.setOnClickListener((view) -> {
            String trad = Character.toString(translator.morseToChar(mensagem.getText().toString()));
            mensagem2.setText(mensagem2.getText().toString() + trad);
            mensagem.setText(null);
        });





    }
}
