package br.pro.hashi.ensino.desagil.projeto1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;


public class SMSActivity extends AppCompatActivity {

    long then = 0;
    long now = 0;
    int uniTempo = 500;
    String texto = "";

    // Método de conveniência para mostrar uma bolha de texto.
    private void showToast(String text) {

        // Constrói uma bolha de duração curta.
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);

        // Mostra essa bolha.
        toast.show();
    }


    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        TextView mensagem_pronta = findViewById(R.id.mensagem_pronta);

        TextView telefone = findViewById(R.id.telefone);

        TextView telPronto = findViewById(R.id.numerotrad);

        Button botaoMorse2 = findViewById(R.id.botaoMorse2);

        Button botaoTrad2 = findViewById(R.id.traduzir2);

        Button enviar2 = findViewById(R.id.botaoenviar2);

        Intent envio = getIntent();
        Bundle bd = envio.getExtras();
        if(bd != null)
        {
            String getName = (String) bd.get("msg");
            mensagem_pronta.setText(getName);
        }


        Translator translator2 = new Translator();

        botaoMorse2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction()==MotionEvent.ACTION_DOWN){
                    then = System.currentTimeMillis();
                }
                else if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    now = System.currentTimeMillis();
                    if((now - then) < uniTempo){
                        telefone.setText(telefone.getText().toString()+".");
                        texto += ".";
                    }
                    else if((now - then) > uniTempo && (now - then) < uniTempo*3 ){
                        telefone.setText(telefone.getText().toString()+"-");
                        texto += "-";
                    }
                    else if((now-then)>=uniTempo*5){
                        telPronto.setText("");
                    }
                }

                return false;
            }
        });

        botaoTrad2.setOnClickListener((view) -> {
            String trad = Character.toString(translator2.morseToChar(telefone.getText().toString()));
            telPronto.setText(telPronto.getText().toString() + trad);
            telefone.setText("");
        });

        enviar2.setOnClickListener((view) -> {
            String message = mensagem_pronta.getText().toString();

            if (message.isEmpty()) {
                showToast("Mensagem inválida!");
                return;
            }

            String phone = telefone.getText().toString();

            // Esta verificação do número de telefone é bem
            // rígida, pois exige até mesmo o código do país.
            if (!PhoneNumberUtils.isGlobalPhoneNumber(phone)) {
                showToast("Número inválido!");
                return;
            }

            // Enviar uma mensagem de SMS. Por simplicidade,
            // não estou verificando se foi mesmo enviada,
            // mas é possível fazer uma versão que verifica.
            SmsManager manager = SmsManager.getDefault();
            manager.sendTextMessage(phone, null, message, null, null);

            // Limpar o campo para nenhum engraçadinho
            // ficar apertando o botão várias vezes.
            telefone.setText("");
        });
    }
}
