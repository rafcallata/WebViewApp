package com.example.mywebapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class WebAppInterface {
    Context context;

    WebAppInterface(Context c){
        context = c;
    }

    @JavascriptInterface
    public void showToastMessage(String message){

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
