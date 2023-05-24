package com.itp.mywebview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton btn_yt,btn_google,btn_java,btn_sql,btn_search;
    WebView webView;
    ProgressBar progressBar;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       btn_yt= findViewById(R.id.btn_youtube);
       btn_google= findViewById(R.id.btn_google);
       btn_java= findViewById(R.id.btn_java);
       btn_sql= findViewById(R.id.btn_sql);
       btn_search=findViewById(R.id.btn_search);

       webView= findViewById(R.id.myWebView);
       progressBar=findViewById(R.id.progressBar);
       editText=findViewById(R.id.et_url);


       btn_search.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String url=editText.getText().toString();
               if(!url.startsWith("www")&&!url.endsWith(".com"))
               {
                   Toast.makeText(MainActivity.this, "please enter valid URL:", Toast.LENGTH_SHORT).show();
               }else {
                   webView.loadUrl(url);
               }
           }
       });
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
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Toast.makeText(MainActivity.this, ""+request, Toast.LENGTH_SHORT).show();
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
            }
        });

        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setJavaScriptEnabled(true);
    }
}