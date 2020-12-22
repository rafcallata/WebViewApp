package com.example.mywebapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    //private static String DIRECTION = "http://127.0.0.1:8080/Labejerphp/index.html";
    private static String DIRECTION = "https://www.ionos.es/digitalguide/hosting/cuestiones-tecnicas/err-connection-refused/";

    ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout = (ConstraintLayout)findViewById(R.id.idMain);

        createSnackbar();

        WebView webView = (WebView)findViewById(R.id.webView);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.addJavascriptInterface(new WebAppInterface(this),"Android");
        webView.setWebViewClient(new MyWebViewClient());
        webView.loadUrl(DIRECTION);

        constraintLayout = (ConstraintLayout)findViewById(R.id.idMain);

        createSnackbar();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        WebView webView = (WebView)findViewById(R.id.webView);
        if((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private class MyWebViewClient extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }
    }

    private void createSnackbar(){
        Snackbar snackbar = Snackbar.make(constraintLayout, "Bienvenido esta es una pagina para ver el error de conexion rechazada", Snackbar.LENGTH_LONG)
                .setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE)
                .setBackgroundTint(Color.parseColor("#778899"));
        snackbar.show();

    }
}