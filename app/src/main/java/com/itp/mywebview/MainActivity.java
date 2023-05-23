package com.itp.mywebview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton btn_yt,btn_google,btn_java,btn_sql;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       btn_yt= findViewById(R.id.btn_youtube);
       btn_google= findViewById(R.id.btn_google);
       btn_java= findViewById(R.id.btn_java);
       btn_sql= findViewById(R.id.btn_sql);
       webView= findViewById(R.id.myWebView);


       btn_java.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               webView.loadUrl("https://www.javatpoint.com/java-tutorial");
           }
       });
        btn_sql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl("https://www.programiz.com/sql");
            }
        });
        btn_yt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl("https://www.youtube.com/");
            }
        });
        btn_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webView.loadUrl("https://www.google.com/");
            }
        });

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Toast.makeText(MainActivity.this, ""+request, Toast.LENGTH_SHORT).show();
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });
    }
}