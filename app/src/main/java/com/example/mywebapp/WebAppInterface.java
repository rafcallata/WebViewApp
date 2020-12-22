package com.example.mywebapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class WebAppInterface {
    Context context;

    WebAppInterface(Context c){
        context = c;
    }

    @JavascriptInterface
    public void showToastMessage(String message){

        //Esto es lo que se hiso en clase para que muestre el mensaje creado
        //Toast.makeText(context,message,Toast.LENGTH_SHORT).show();

        //esto crara una ventana emergente donde al hacer click para que muestre el mensaje que quereos que muestre
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setMessage(message).setNeutralButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                }
        );
        builder.create().show();
    }
}
