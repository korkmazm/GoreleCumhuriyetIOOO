package com.korkmazm.gorelecumhuriyetiooo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by KorkmazM on 04/03/2017.
 */

public class WebDetails extends AppCompatActivity {

    private AdView mAdView;
    WebView webViewDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.webdetail);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.cumilogo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        getSupportActionBar().hide();

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        webViewDetail = (WebView) findViewById(R.id.webViewDetail);
        webViewDetail.getSettings().setJavaScriptEnabled(true);
        webViewDetail.getSettings().setPluginState(WebSettings.PluginState.ON);
        String url = getIntent().getStringExtra("URL");
        webViewDetail.loadUrl(url);
        webViewDetail.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }
        });

    }
}
