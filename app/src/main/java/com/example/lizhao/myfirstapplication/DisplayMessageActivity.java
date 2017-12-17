package com.example.lizhao.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.fifa.Player;
import com.fifa.PlayerData;
import com.fifa.Team;

import java.util.ArrayList;
import java.util.List;

public class DisplayMessageActivity extends AppCompatActivity {
    private ListView listView;
    private Team displayTeam;
    private ListView resultPlayersView;
    private ArrayList<String> namelist;
    private ArrayList<Team> teamlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        resultPlayersView = findViewById(R.id.resultPlayersView);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        //String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        displayTeam  = (Team) intent.getSerializableExtra("seletedTeam");

        // Capture the layout's TextView and set the string as its text
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setText(displayTeam.getShortName());
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(displayTeam.getLongName());
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setText(displayTeam.getBuildUpPlaySpeedClass());

        ArrayList<Player> playersInTheTeam = (ArrayList<Player>) intent.getSerializableExtra("playersInTheTeam");
        namelist = getNames(playersInTheTeam);
        resultPlayersView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,  namelist));
    }

    public ArrayList<String> getNames(ArrayList<Player> input){
        ArrayList<String> names = new ArrayList<>();
        if (input == null){
            return names;
        }
        for (Player p : input){
            names.add(p.getName());
        }
        return names;
    }

}
