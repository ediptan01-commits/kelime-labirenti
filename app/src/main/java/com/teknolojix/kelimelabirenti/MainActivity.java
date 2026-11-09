package com.teknolojix.kelimelabirenti;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.view.View;

public class MainActivity extends Activity {
    private WebView game;
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        game = new WebView(this);
        game.setBackgroundColor(0xFFF1EEFF);
        game.setWebChromeClient(new WebChromeClient());
        WebSettings s = game.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setAllowFileAccess(true);
        s.setMediaPlaybackRequiresUserGesture(false);
        game.loadUrl("file:///android_asset/index.html");
        setContentView(game);
    }
    @Override public void onBackPressed() {
        if (game.canGoBack()) game.goBack(); else super.onBackPressed();
    }
    @Override protected void onDestroy() {
        game.destroy();
        super.onDestroy();
    }
}
