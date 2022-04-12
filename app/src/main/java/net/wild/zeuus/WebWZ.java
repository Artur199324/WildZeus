package net.wild.zeuus;

import static net.wild.zeuus.WZ.bvgag;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class WebWZ extends WebView {

   public static WZ wz;

    public WebWZ(@NonNull Context context) {
        super(context);
    }

    public WebWZ(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        CookieManager.getInstance().setAcceptThirdPartyCookies(this, true);
        CookieManager.getInstance().setAcceptCookie(true);
        this.getSettings().setAllowFileAccessFromFileURLs(true);
        this.getSettings().setSavePassword(true);
        this.getSettings().setDatabaseEnabled(true);
        this.getSettings().setRenderPriority(android.webkit.WebSettings.RenderPriority.HIGH);
        this.getSettings().setCacheMode(android.webkit.WebSettings.LOAD_DEFAULT);
        this.getSettings().setAppCacheEnabled(true);
        this.getSettings().setLoadsImagesAutomatically(true);
        this.setSaveEnabled(true);
        this.getSettings().setMixedContentMode(0);
        this.setFocusable(true);
        this.getSettings().setAllowUniversalAccessFromFileURLs(true);
        this.getSettings().setJavaScriptEnabled(true);
        this.getSettings().setAllowContentAccess(true);
        this.getSettings().setLoadWithOverviewMode(true);
        this.getSettings().setEnableSmoothTransition(true);
        this.getSettings().setUseWideViewPort(true);
        this.getSettings().setSaveFormData(true);
        this.getSettings().setAllowFileAccess(true);
        this.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.getSettings().setDomStorageEnabled(true);
        this.setFocusableInTouchMode(true);
        this.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                if (url.contains(ProfileActivity.decodWZ("ZXJyb3I9YXBwYWZBczNm")) || url.contains(ProfileActivity.decodWZ("ZGlzYWJsZWQuaHRtbA=="))){

                    WZ.buttonStart.setVisibility(View.VISIBLE);
                    WZ.buttonClose.setVisibility(View.VISIBLE);
                    WZ.bar.setVisibility(View.INVISIBLE);
                    wz.webOfWZ.setVisibility(View.INVISIBLE);
                    Log.d("weq","bot");
                }
            }
        });
        this.setWebChromeClient(new WebChromeClient(){
            @Override
            public boolean onShowFileChooser(WebView view,
                                             ValueCallback<Uri[]> filePath,
                                             FileChooserParams fileChooserParams) {
                if (bvgag != null) {
                    bvgag.onReceiveValue(null);
                }
                bvgag = filePath;
                Intent contentSelectionIntent = new Intent(Intent.ACTION_GET_CONTENT);
                contentSelectionIntent.addCategory(Intent.CATEGORY_OPENABLE);
                contentSelectionIntent.setType("*/*");
                Intent[] intentArray = new Intent[0];
                Intent chooserIntent = new Intent(Intent.ACTION_CHOOSER);
                chooserIntent.putExtra(Intent.EXTRA_INTENT, contentSelectionIntent);
                chooserIntent.putExtra(Intent.EXTRA_TITLE,ProfileActivity.decodWZ("U2VsZWN0IE9wdGlvbjo="));
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, intentArray);
                wz.startActivityForResult(chooserIntent, 1);
                return true;
            }
        });
    }
}
