package net.wild.zeuus;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.appevents.AppEventsLogger;
import com.facebook.applinks.AppLinkData;

public class NoIternetWz extends AppCompatActivity {

    Button buttonOk;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nointer);

        buttonOk = findViewById(R.id.buttonOk);

        startActivity(new Intent(getApplicationContext(),WZ.class));
        finishAffinity();
    }

    public static void deepWz(WZ wz){

        AppEventsLogger.activateApp(wz.getApplication());
        AppLinkData.fetchDeferredAppLinkData(wz.getApplicationContext(), new AppLinkData.CompletionHandler() {
            @Override
            public void onDeferredAppLinkDataFetched(@Nullable AppLinkData appLinkData) {
                if (appLinkData == null) {
                    appLinkData = AppLinkData.createFromActivity(wz);

                }
                if (appLinkData != null) {

                    String[] as = appLinkData.getTargetUri().toString().split("://");
                    WZ.nhcbah = as[1];
                    WZ.nvhsh = MainActivity.parserWZ(WZ.nhcbah,wz);

                } else {

                }
            }
        });
    }
}
