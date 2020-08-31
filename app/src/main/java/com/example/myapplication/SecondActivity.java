package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textView;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

//        textView = findViewById(R.id.secondTextView);
//        String str = getIntent().getStringExtra(MainActivity.BUNDLE_STRING);
//        textView.setText(str);

        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        String url = getIntent().getDataString();
        webView.loadUrl(url);
    }
}