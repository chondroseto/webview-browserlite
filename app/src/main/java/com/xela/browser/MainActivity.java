package com.xela.browser;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    EditText editText;
    ProgressBar progressBar;
    ImageButton refresh_btn,mini_screen,stop_btn;
    LinearLayout bg_navigation;
    RelativeLayout fg_navigation;
    FrameLayout fragmentui;
    SwipeRefreshLayout refresh_gst;

    @Override
    public void onBackPressed() {
        if(fragmentui.getVisibility()==View.VISIBLE){
            super.onBackPressed();
            reset();
        }

        if (webView.getVisibility()==View.VISIBLE){
            webView.goBack();
        }
        return;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentui =  findViewById(R.id.fragment_container);
        fg_navigation =  findViewById(R.id.fg_nav);
        bg_navigation =  findViewById(R.id.bg_nav);

        editText =  findViewById(R.id.address);
        refresh_btn = findViewById(R.id.refresh);
        refresh_gst = findViewById(R.id.refresh_gesture);
        mini_screen = findViewById(R.id.miniscreen);
        stop_btn = findViewById(R.id.stop);

        progressBar =  findViewById(R.id.progress_bar);
        progressBar.setMax(100);

        webView =  findViewById(R.id.web_view);

        if (savedInstanceState != null) {
            webView.restoreState(savedInstanceState);
        } else {
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setUseWideViewPort(true);
            webView.getSettings().setLoadWithOverviewMode(true);
            webView.getSettings().setSupportZoom(true);
            webView.getSettings().setSupportMultipleWindows(true);
            webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            webView.setBackgroundColor(Color.WHITE);



            webView.setWebChromeClient(new WebChromeClient() {
                @Override
                public void onProgressChanged(WebView view, int newProgress) {
                    super.onProgressChanged(view, newProgress);
                    progressBar.setProgress(newProgress);
                    if ((newProgress > 0) && (newProgress < 100)) {
                        progressBar.setVisibility(ProgressBar.VISIBLE);
                        editText.setText(webView.getUrl());
                        refresh_btn.setVisibility(View.GONE);
                        stop_btn.setVisibility(View.VISIBLE);
                        refresh_gst.setRefreshing(true);


                    }
                    if (newProgress == 100) {
                        progressBar.setVisibility(ProgressBar.GONE);
                        refresh_btn.setVisibility(View.VISIBLE);
                        stop_btn.setVisibility(View.GONE);
                        refresh_gst.setRefreshing(false);
                    }
                }
            });
        }

        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if (keyCode == keyEvent.KEYCODE_ENTER){
                    webView.setVisibility(View.VISIBLE);
                    refresh_gst.setVisibility(View.VISIBLE);
                    fragmentui.setVisibility(View.GONE);
                    try {
                        if(!NetworkState.connectionAvailable(MainActivity.this)){
                            Toast.makeText(MainActivity.this, "connect", Toast.LENGTH_SHORT).show();
                        }else {
                            if (String.valueOf(editText.getText()).contains(".")){
                                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                                inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                                webView.loadUrl("https://" + editText.getText().toString());

                            }if (String.valueOf(editText.getText()).contains("https://")){
                                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                                inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                                webView.loadUrl(editText.getText().toString());

                            }if (!String.valueOf(editText.getText()).contains(".")){
                                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                                inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                                webView.loadUrl("https://www.bing.com/search?q=" + editText.getText().toString());

                            }else{
                                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                                inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                                webView.loadUrl("https://" +editText.getText().toString());
                            }
                        }

                    }catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                return false;
            }
        });

        webView.setWebViewClient(new MyWebViewClient());

        refresh_gst.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){

            @Override
            public void onRefresh() {
                fragmentui.setVisibility(View.GONE);
                webView.reload();
            }
        });

    }

    public void refresh_btn(View view) {
        fragmentui.setVisibility(View.GONE);
        webView.reload();
    }

    public void stop_btn(View view) {
        webView.stopLoading();
    }

    public void ex_menu(View view) {
        fg_navigation.setVisibility(View.GONE);
        bg_navigation.setVisibility(View.VISIBLE);

    }

    public void fullscreen_btn(View view) {
        fg_navigation.setVisibility(View.GONE);
        bg_navigation.setVisibility(View.GONE);
        mini_screen.setVisibility(View.VISIBLE);
    }

    public void link_btn(View view) {
        fg_navigation.setVisibility(View.VISIBLE);
        bg_navigation.setVisibility(View.GONE);

    }

    public void home_btn(View view) {
        if(fragmentui.getVisibility()==View.VISIBLE){
            fg_navigation.setVisibility(View.VISIBLE);
            bg_navigation.setVisibility(View.GONE);
            webView.setVisibility(View.VISIBLE);
            refresh_gst.setVisibility(View.VISIBLE);
            fragmentui.setVisibility(View.GONE);
        }else{
            fg_navigation.setVisibility(View.VISIBLE);
            bg_navigation.setVisibility(View.GONE);
            webView.setVisibility(View.GONE);
            refresh_gst.setVisibility(View.GONE);
            fragmentui.setVisibility(View.VISIBLE);
            loadFragment(new FragmentHome());
        }

    }

    public void forward_btn(View view) {
        if (webView.canGoForward()) {
            webView.goForward();
        }
    }

    public void history_btn(View view) {
        fg_navigation.setVisibility(View.GONE);
        bg_navigation.setVisibility(View.GONE);
        webView.setVisibility(View.GONE);
        refresh_gst.setVisibility(View.GONE);
        fragmentui.setVisibility(View.VISIBLE);
        loadFragment(new FragmentHistory());
    }

    public void miniscreen_btn(View view) {
        fg_navigation.setVisibility(View.GONE);
        bg_navigation.setVisibility(View.VISIBLE);
        mini_screen.setVisibility(View.GONE);
    }

    private boolean loadFragment(Fragment fragment){
        if (fragment!=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).addToBackStack("null").commit();
            return true;
        }
        return false;
    }

    public void reset(){
        fragmentui.setVisibility(View.GONE);
        fg_navigation.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        refresh_gst.setVisibility(View.VISIBLE);
        bg_navigation.setVisibility(View.GONE);
    }
}