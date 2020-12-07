package com.example.mascotasapplication.Modelo.JavaMail;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.mascotasapplication.R;


public class DialogoContacto extends AppCompatDialogFragment {
    EditText email;
    EditText contraseña;
    Button ingCorreo;
    DialogoListener listener;
    public static String Email=null;
    public static String Contrase=null;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.ingresarcorreo, null);

        email           = view.findViewById(R.id.email);
        contraseña      = view.findViewById(R.id.contraseña);
        ingCorreo       = view.findViewById(R.id.IngCorreo);

        builder.setView(view).setTitle("Iniciar Sesiòn")
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Email       = email.getText().toString();
                        Contrase  = contraseña.getText().toString();

                        listener.applyTexts(Email, Contrase);

                    }
                });
        return builder.create();
    }




    public void applyTexts(String Email, String Contrase) {
       this.Email       = Email;
       this.Contrase    = Contrase;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (DialogoListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement ExampleDialogListener");
        }
    }

    public interface DialogoListener {
        void applyTexts(String Email, String Contrase);
    }



}