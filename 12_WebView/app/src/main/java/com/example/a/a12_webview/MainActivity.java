package com.example.a.a12_webview;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {



    WebView webView;
    ProgressDialog dlg;
    class MyWebViewClient extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {

            super.onPageStarted(view, url, favicon);
            dlg.show();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            dlg.dismiss();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dlg = new ProgressDialog(this);
        webView = (WebView) findViewById(R.id.webView);
        // 자바스크립트 활성화
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new MyWebViewClient());
        webView.loadUrl("http://www.naver.com");
    }

    public void onBtnClick(View v){
        EditText editURL = (EditText) findViewById(R.id.editURL);
        String str = editURL.getText().toString();
        webView.loadUrl(str);

    }

}
