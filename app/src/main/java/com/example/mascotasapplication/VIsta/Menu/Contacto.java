package com.example.mascotasapplication.VIsta.Menu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mascotasapplication.Modelo.JavaMail.GMailSender;
import com.example.mascotasapplication.R;
import com.example.mascotasapplication.Modelo.JavaMail.DialogoContacto;

import java.security.Provider;


public class Contacto extends AppCompatActivity implements DialogoContacto.DialogoListener{

    EditText destinatario;
    EditText asunto;
    EditText mensaje;
    Button enviar;
    Button button;
    String destino, asunt, mensa ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.actionbar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setTitle("Contacto");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setMessage("Ingresa el correo REAL para que funcione. \nEn el boton de Ingresar correo.");
        alerta.setTitle("Información. ");
        alerta.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              Toast.makeText(Contacto.this,"Ingresa",Toast.LENGTH_LONG).show();
              dialog.dismiss();
            }
        });
        AlertDialog dialog = alerta.create();
        dialog.show();


        destinatario     = (EditText) findViewById(R.id.Correo);
        asunto           = (EditText) findViewById(R.id.Asunto);
        mensaje          = (EditText) findViewById(R.id.Mensaje);
        enviar           = (Button) findViewById(R.id.Enviar);
        button           = (Button) findViewById(R.id.IngCorreo);
        
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
              destino    = destinatario.getText().toString();
              asunt      = asunto.getText().toString();
              mensa      = mensaje.getText().toString();
              sendEmail(destino, asunt, mensa);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }
    public void openDialog() {
        DialogoContacto ingresar = new DialogoContacto();
        ingresar.show(getSupportFragmentManager(), "DialogoContacto");
    }

    private void sendEmail(final String destino, final String asunt, final String mensa) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {

                    GMailSender envio = new GMailSender(DialogoContacto.Email, DialogoContacto.Contrase);
                    envio.sendMail(asunt, "<b>" + mensa + "</b>", DialogoContacto.Email, destino);
                    makeAlert();
                } catch (Exception e) {
                    Log.e("Enviado Mensaje...", e.getMessage(), e);
                }
            }

        }).start();
    }

    private void makeAlert() {
        this.runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(getBaseContext(), "Mensaje Enviado", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void applyTexts(String Email, String Contra) {
        
    }


    public class JSSEProvider extends Provider {

        protected JSSEProvider(String name, double version, String info) {
            super(name, version, info);
        }
    }
}
