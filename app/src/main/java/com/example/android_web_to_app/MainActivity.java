package com.example.android_web_to_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;
    private ProgressBar mProgrssbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = findViewById(R.id.webView_page);
        mProgrssbar = findViewById(R.id.progrssBar_webView);

        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setDisplayZoomControls(true);
        mWebView.getSettings().setSupportZoom(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.setWebViewClient(new WebClient(mProgrssbar));

        // Specify the app cache path
        mWebView.getSettings().setAppCachePath(this.getCacheDir().getPath());

        // Enable the caching for web view
        mWebView.getSettings().setAppCacheEnabled(true);
        // Set the cache mode
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);

        mWebView.loadUrl("https://www.google.com/");

        // For local URL
        //mWebView.loadUrl("file:///android_asset/index.html");
    }
}
