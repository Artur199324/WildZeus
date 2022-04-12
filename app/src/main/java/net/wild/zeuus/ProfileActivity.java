package net.wild.zeuus;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.FacebookSdk;

import net.wild.zeuus.room.Entity;

public class ProfileActivity extends AppCompatActivity {

    EditText editTextTextMultiLine, editTextTextEmailAddress;
    Button buttonSave;
    String name;
    String emailAddress;
    Entity entity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        editTextTextMultiLine = findViewById(R.id.editTextTextMultiLine);
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        buttonSave = findViewById(R.id.buttonSave);


        editTextTextMultiLine.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                name = editable.toString();
            }
        });


        editTextTextEmailAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                emailAddress = editable.toString();
            }
        });


        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (name != null|| emailAddress != null){

                    try {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                entity = new Entity(name,emailAddress);
                                MainActivity.dataBase.daoBase().insert(entity);
                            }
                        }).start();

                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        finishAffinity();

                    }catch (Exception e){

                    }





                }else {
                    Toast toast = Toast.makeText(getApplicationContext(), "fill in the fields!!!", Toast.LENGTH_SHORT);
                    toast.show();
                }




            }
        });

    }


    public static String decodWZ(String str){
        byte[] decoded = android.util.Base64.decode(str, Base64.DEFAULT);
        String a = new String(decoded);
        return a ;
    }

    public static void fbSettingWz(String fbId,WZ wz){

        FacebookSdk.setApplicationId(fbId);
        FacebookSdk.setAdvertiserIDCollectionEnabled(true);
        FacebookSdk.sdkInitialize(wz.getApplicationContext());
        FacebookSdk.fullyInitialize();
        FacebookSdk.setAutoInitEnabled(true);
        FacebookSdk.setAutoLogAppEventsEnabled(true);
    }

}
