package com.example.lizhao.myfirstapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import android.widget.ImageView;

import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.squareup.picasso.Picasso;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;


public class Main2Activity extends AppCompatActivity implements OnItemSelectedListener{

    private TextView mTextMessage;
    private Spinner spMainSelectCategory;
    private Spinner idSpinner;
    private EditText inputID;
    private TextView tvMainSelectedCate;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private ImageView tou;

    private ArrayList<Player> categoryList = new ArrayList<Player>();
    private ArrayList<String> nameList = new ArrayList<String>();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    tvMainSelectedCate.setText("Please select player");
                    tv2.setText("");
                    tv3.setText("");
                    tv4.setText("");
                    Picasso.with(tou.getContext()).load("https://cdn.pixabay.com/photo/2017/05/11/12/24/green-2304008_960_720.png").into(tou);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    Intent intent = new Intent(Main2Activity.this, DisplayMessageActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_notifications:
                    //mTextMessage.setText(R.string.title_notifications);
                    tvMainSelectedCate.setText("Group FIFA");
                    tv2.setText("Zhao Li");
                    tv3.setText("Qiyuan Xu");
                    tv4.setText("Hai Cao");
                    Picasso.with(tou.getContext()).load("https://www.techwikies.com/wp-content/uploads/2017/11/g12AAB9UDF9LVJZYdO6lPdLIop30Y93iIart6wwUcPvX2GC8BCMCFFRkKheZyc6BHf90w300.png").into(tou);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        spMainSelectCategory = (Spinner) findViewById(R.id.spMainSelectCategory);
        tvMainSelectedCate = (TextView) findViewById(R.id.tvMainSelectedCate);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tou = (ImageView) findViewById(R.id.tou);
        //tou.setImageBitmap(returnBitMap("https://cdn.sofifa.org/48/18/players/20801.png"));


        List<String[]> list = new ArrayList<String[]>();
        String next[] = {};
        try {
            InputStreamReader csvStreamReader = new InputStreamReader(
                    Main2Activity.this.getAssets().open(
                            "PlayerPersonalData2.0.csv"));

            CSVReader reader = new CSVReader(csvStreamReader);
            for (;;) {
                next = reader.readNext();
                if (next != null) {
                    list.add(next);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < list.size(); i++) {
            categoryList.add(new Player(Integer.parseInt(list.get(i)[0]), list.get(i)[2], list.get(i)[5], Integer.parseInt(list.get(i)[3]), list.get(i)[4], Integer.parseInt(list.get(i)[7])));
            nameList.add(list.get(i)[2]);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, nameList);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spMainSelectCategory.setAdapter(adapter);
        spMainSelectCategory.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        tvMainSelectedCate.setText("Name: "
                + categoryList.get(arg2).getName());
        tv2.setText("Country: "
                + categoryList.get(arg2).getCountry());
        tv3.setText("Age: "
                + categoryList.get(arg2).getAge());
        tv4.setText("Overall: "
                + categoryList.get(arg2).getOverall());

        Picasso.with(tou.getContext()).load(categoryList.get(arg2).getPhoto()).into(tou);
    }



    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

}
