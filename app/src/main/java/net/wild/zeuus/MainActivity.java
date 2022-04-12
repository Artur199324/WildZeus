package net.wild.zeuus;

import static net.wild.zeuus.WZ.ndfhs;
import static net.wild.zeuus.WZ.bhvvs;
import static net.wild.zeuus.WZ.nbhds;
import static net.wild.zeuus.WZ.bhvaj;
import static net.wild.zeuus.WZ.bhsa;
import static net.wild.zeuus.WZ.bvhahw;
import static net.wild.zeuus.WZ.jsajas;
import static net.wild.zeuus.WZ.iusah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.wild.zeuus.room.DataBase;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView, imageView2, imageView3, imageViewSpin,imageViewMenu;
    private TextView textView,textView2,textView3,textViewName;
    private ConstraintLayout constraintLayout;
    private Display display;
    private int h;
    private int w;
    private int size;
    private Handler handler;
    private String name = null;

    private int b = 0;
    private Random random;
    private int suA;
    private int suB;
    private int suC;
    public static DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageViewSpin = findViewById(R.id.imageView2);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        constraintLayout = findViewById(R.id.constraintLayout);
        imageViewMenu = findViewById(R.id.imageViewMenu);
        textViewName = findViewById(R.id.textViewName);

        display = getWindowManager().getDefaultDisplay();
        w = display.getWidth();
        h = display.getHeight();
        size = w / 3;

        handler = new Handler();
        random = new Random();


        new Thread(new Runnable() {
            @Override
            public void run() {
                dataBase = Room.databaseBuilder(getApplicationContext(),
                        DataBase.class, "profile").build();

                try {
                    name = dataBase.daoBase().getlastWeDao().getName();
                    Log.d("weq",name);
                }catch (Exception e){
                    name = null;
                }

                if (name != null){
                    textViewName.setVisibility(View.VISIBLE);
                    textViewName.setText(name);
                    imageViewMenu.setVisibility(View.INVISIBLE);
                }
            }
        }).start();





        imageViewMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
            }
        });



        handler.post(new Runnable() {
            @Override
            public void run() {

                imageView = new ImageView(getApplicationContext());
                int e = random.nextInt(4);

                if (e == 0) {
                    imageView.setImageResource(R.drawable.ic_slot_1);
                    suA = 5;
                    textView.setText(suA+"");
                }
                if (e == 1) {
                    imageView.setImageResource(R.drawable.ic_slot_2);
                    suA = 6;
                    textView.setText(suA+"");
                }
                if (e == 2) {
                    imageView.setImageResource(R.drawable.ic_slot_3);
                    suA = 7;
                    textView.setText(suA+"");
                }
                if (e == 3) {
                    imageView.setImageResource(R.drawable.ic_slot_4);
                    suA = 8;
                    textView.setText(suA+"");
                }

                ConstraintLayout.LayoutParams imageViewLayoutParams =
                        new ConstraintLayout.LayoutParams(size, size);
                imageView.setLayoutParams(imageViewLayoutParams);

                imageView2 = new ImageView(getApplicationContext());
                int r = random.nextInt(4);
                if (r == 0) {
                    imageView2.setImageResource(R.drawable.ic_slot_1);
                    suB = 5;
                    textView2.setText(suB+"");
                }
                if (r == 1) {
                    imageView2.setImageResource(R.drawable.ic_slot_2);
                    suB = 6;
                    textView2.setText(suB+"");
                }
                if (r == 2) {
                    imageView2.setImageResource(R.drawable.ic_slot_3);
                    suB = 7;
                    textView2.setText(suB+"");
                }
                if (r == 3) {
                    imageView2.setImageResource(R.drawable.ic_slot_4);
                    suB = 8;
                    textView2.setText(suB+"");
                }

                ConstraintLayout.LayoutParams imageViewLayoutParams2 =
                        new ConstraintLayout.LayoutParams(size, size);
                imageView2.setLayoutParams(imageViewLayoutParams2);


                imageView3 = new ImageView(getApplicationContext());
                int u = random.nextInt(4);
                if (u == 0) {
                    imageView3.setImageResource(R.drawable.ic_slot_1);
                    suC = 5;
                    textView3.setText(suC+"");
                }
                if (u == 1) {
                    imageView3.setImageResource(R.drawable.ic_slot_2);
                    suC = 6;
                    textView3.setText(suC+"");
                }
                if (u == 2) {
                    imageView3.setImageResource(R.drawable.ic_slot_3);
                    suC = 7;
                    textView3.setText(suC+"");
                }
                if (u == 3) {
                    imageView3.setImageResource(R.drawable.ic_slot_4);
                    suC = 8;
                    textView2.setText(suC+"");
                }

                ConstraintLayout.LayoutParams imageViewLayoutParams3 =
                        new ConstraintLayout.LayoutParams(size, size);
                imageView3.setLayoutParams(imageViewLayoutParams3);

                constraintLayout.addView(imageView);
                constraintLayout.addView(imageView2);
                constraintLayout.addView(imageView3);

                imageView.setX(w / 3);
                imageView.setY(h / 3);
                imageView2.setX(w - size);
                imageView2.setY(h / 3);
                imageView3.setX(0);
                imageView3.setY(h / 3);



            }
        });

        clic();

    }

    private void clic() {
        imageViewSpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {


                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                setIm();
                            }
                        });

                        b++;
                        if (b != 20) {
                            handler.postDelayed(this::run, 10);


                        } else {
                            b = 0;
                            if (suA == suB || suA == suC){

                                Toast toast = Toast.makeText(getApplicationContext(), "You won!!!", Toast.LENGTH_SHORT);
                                toast.show();
                            }
                        }
                    }
                });


            }
        });

    }


    private void setIm() {

        Random random = new Random();
        int a = random.nextInt(3);
        int b = random.nextInt(3);
        int c = random.nextInt(3);

        if (a == 0) {

            imageView.setImageResource(R.drawable.ic_slot_1);
            suA = 5;
            textView.setText(suA+"");
        }
        if (a == 1) {
            imageView.setImageResource(R.drawable.ic_slot_2);
            suA = 6;
            textView.setText(suA+"");
        }

        if (a == 2) {
            imageView.setImageResource(R.drawable.ic_slot_3);
            suA = 7;
            textView.setText(suA+"");
        }

        if (a == 3) {
            imageView.setImageResource(R.drawable.ic_slot_4);
            suA = 8;
            textView.setText(suA+"");
        }

        switch (b) {
            case 0:
                imageView2.setImageResource(R.drawable.ic_slot_1);
                suB = 5;
                textView2.setText(suB+"");
                break;
            case 1:
                imageView2.setImageResource(R.drawable.ic_slot_2);
                suB = 6;
                textView2.setText(suB+"");
                break;
            case 2:
                imageView2.setImageResource(R.drawable.ic_slot_3);
                suB = 7;
                textView2.setText(suB+"");
                break;
            case 3:
                imageView2.setImageResource(R.drawable.ic_slot_4);
                suB = 8;
                textView2.setText(suB+"");
                break;
        }

        if (c == 0) {
            imageView3.setImageResource(R.drawable.ic_slot_1);
            suC = 5;
            textView3.setText(suC+"");
        }
        if (c == 1) {
            imageView3.setImageResource(R.drawable.ic_slot_2);
            suC = 6;
            textView3.setText(suC+"");
        }
        if (c == 2) {
            imageView3.setImageResource(R.drawable.ic_slot_3);
            suC = 7;
            textView3.setText(suC+"");
        }
        if (c == 3) {
            imageView3.setImageResource(R.drawable.ic_slot_4);
            suC = 8;
            textView3.setText(suC+"");
        }
    }
    private static String cczz;
    private static String vcxz;
    private static String bvcz;
    private static String bvxcz;
    private static String nhyu;
    private static String njuyh;


    public static String parserWZ(String s, WZ wz){

        String[] njgf = s.split("_");

        try {
            cczz = njgf[0];
        } catch (Exception e) {

            cczz = "";
        }
        try {
            vcxz = njgf[1];
        } catch (Exception e) {

            vcxz = "";
        }
        try {
            bvcz = njgf[2];
        } catch (Exception e) {
            bvcz = "";

        }
        try {
            bvxcz = njgf[3];
        } catch (Exception e) {
            bvxcz = "";

        }
        try {
            nhyu = njgf[4];
        } catch (Exception e) {
            nhyu = "";
            ;
        }
        try {
            njuyh = njgf[5];
        } catch (Exception e) {
            njuyh = "";

        }

        return ProfileActivity.decodWZ("P21lZGlhX3NvdXJjZT0=") + bhsa +
                ProfileActivity.decodWZ("JnN1YjE9") + cczz +
                ProfileActivity.decodWZ("JnN1YjI9") + vcxz +
                ProfileActivity.decodWZ("JnN1YjM9") + bvcz +
                ProfileActivity.decodWZ("JnN1YjQ9") + bvxcz +
                ProfileActivity.decodWZ("JnN1YjU9") + nhyu +
                ProfileActivity.decodWZ("JnN1YjY9") + njuyh +
                ProfileActivity.decodWZ("JmNhbXBhaWduPQ==") + jsajas +
                ProfileActivity.decodWZ("Jmdvb2dsZV9hZGlkPQ==") + bvhahw +
                ProfileActivity.decodWZ("JmFmX3VzZXJpZD0=") + ndfhs +
                ProfileActivity.decodWZ("JmFmX2NoYW5uZWw9") + iusah +
                ProfileActivity.decodWZ("JmRldl9rZXk9") + bhvaj +
                ProfileActivity.decodWZ("JmJ1bmRsZT0=") + wz.getPackageName() +
                ProfileActivity.decodWZ("JmZiX2FwcF9pZD0=") + bhvvs +
                ProfileActivity.decodWZ("JmZiX2F0PQ==") + nbhds;

    }

}