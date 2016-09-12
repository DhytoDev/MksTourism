package com.lawbatechno.makassartourism.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.lawbatechno.makassartourism.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WebPemkotFragment extends Fragment {

    private ProgressBar progressBar ;
    private WebView webView ;


    public WebPemkotFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_web_pemkot, container, false);

        progressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);
        webView = (WebView) rootView.findViewById(R.id.webView);

        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setScrollBarStyle(WebView.SCROLL_AXIS_HORIZONTAL);
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setProgress(newProgress);
                if (newProgress == 100) {
                    progressBar.setVisibility(View.GONE);
                }
            }

        });

        //progressBar.setVisibility(View.INVISIBLE);
        webView.loadUrl("http://www.makassarkota.go.id");

        return rootView;

    }

}
