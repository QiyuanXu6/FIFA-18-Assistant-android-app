package com.example.lizhao.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.fifa.PlayerData;
import com.fifa.Team;

import java.util.ArrayList;
import java.util.List;

public class DisplayMessageActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> namelist;
    private ArrayList<Team> teamlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        //String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        namelist  = intent.getStringArrayListExtra("namelist");
        teamlist = (ArrayList<Team>) intent.getSerializableExtra("teamlist");
        
        listView = new ListView(this);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,  namelist));
        setContentView(listView);
        // Capture the layout's TextView and set the string as its text
        //TextView textView = (TextView) findViewById(R.id.textView2);
        //textView.setText("Teams Display");
    }


}
