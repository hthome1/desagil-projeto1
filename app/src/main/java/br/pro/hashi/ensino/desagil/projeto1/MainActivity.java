package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

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



        botaoMorse.setOnClickListener((view) -> {
            mensagem.setText(mensagem.getText().toString()+".");

        });

        botaoMorse.setOnLongClickListener((view) -> {
            mensagem.setText(mensagem.getText().toString()+"-");

            return true;
        });


    }
}
