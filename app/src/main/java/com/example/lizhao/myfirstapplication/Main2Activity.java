package com.example.lizhao.myfirstapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

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
    private ArrayList<Player> categoryList = new ArrayList<Player>();
    private ArrayList<String> nameList = new ArrayList<String>();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
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
            categoryList.add(new Player(Integer.parseInt(list.get(i)[0]), list.get(i)[2], list.get(i)[5], Integer.parseInt(list.get(i)[3])));
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
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

}
