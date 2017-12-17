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
import android.widget.Button;
import android.widget.EditText;

import android.widget.ImageView;

import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.fifa.FifaDataController;
import com.fifa.Player;
import com.fifa.PlayerData;
import com.fifa.PlayerReader;
import com.fifa.Team;
import com.fifa.TeamData;
import com.fifa.TeamReader;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
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
    private Spinner playerSpinner;
    private Spinner idSpinner;
    private EditText inputID;
    private TextView tvMainSelectedCate;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv6;
    private EditText teamInsert;
    private ImageView tou;
    private ImageView flag;
    private ImageView clublogo;
    //private ListView listView;
    private Button button;
    private ListView resultTeamView;

    private PlayerData playerData;
    private TeamData teamData;
    private ArrayList<Team> resultTeams;
    private ArrayList<String> resultTeamsNames;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                /**
                 *  When pressing home
                 */
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    resultTeamView.setVisibility(View.INVISIBLE);
                    teamInsert.setVisibility(View.INVISIBLE);
                    tvMainSelectedCate.setVisibility(View.VISIBLE);
                    tv2.setVisibility(View.VISIBLE);
                    tv3.setVisibility(View.VISIBLE);
                    tv4.setVisibility(View.VISIBLE);
                    tv5.setVisibility(View.VISIBLE);
                    tv6.setVisibility(View.VISIBLE);
                    tou.setVisibility(View.VISIBLE);
                    flag.setVisibility(View.VISIBLE);
                    clublogo.setVisibility(View.VISIBLE);
                    button.setVisibility(View.INVISIBLE);
                    playerSpinner.setVisibility(View.VISIBLE);
                    int currentPos = playerSpinner.getSelectedItemPosition();
                    tvMainSelectedCate.setText("Name: "
                            + playerData.getPlayerList().get(currentPos).getName());
                    tv2.setText("Country: "
                            + playerData.getPlayerList().get(currentPos).getNationality());
                    tv3.setText("Club: "
                            + playerData.getPlayerList().get(currentPos).getClub());
                    tv4.setText("Age: "
                            + playerData.getPlayerList().get(currentPos).getAge());
                    tv5.setText("Overall: "
                            + playerData.getPlayerList().get(currentPos).getOverall());
                    tv6.setText("Value: €"
                            + playerData.getPlayerList().get(currentPos).getValue());
                    Picasso.with(tou.getContext()).load(playerData.getPlayerList().get(currentPos).getPhoto()).into(tou);
                    Picasso.with(flag.getContext()).load(playerData.getPlayerList().get(currentPos).getFlag()).into(flag);
                    Picasso.with(clublogo.getContext()).load(playerData.getPlayerList().get(currentPos).getClubLogo()).into(clublogo);
                    return true;
                    /**
                     *  When pressing team
                     */
                    case R.id.navigation_dashboard:

                        mTextMessage.setText("Search Team");
                        teamInsert.setVisibility(View.VISIBLE);
                        resultTeamView.setVisibility(View.VISIBLE);
                        button.setVisibility(View.VISIBLE);
                        playerSpinner.setVisibility(View.INVISIBLE);
                        tvMainSelectedCate.setVisibility(View.INVISIBLE);
                        tv2.setVisibility(View.INVISIBLE);
                        tv3.setVisibility(View.INVISIBLE);
                        tv4.setVisibility(View.INVISIBLE);
                        tv5.setVisibility(View.INVISIBLE);
                        tv6.setVisibility(View.INVISIBLE);
                        tou.setVisibility(View.INVISIBLE);
                        flag.setVisibility(View.INVISIBLE);
                        clublogo.setVisibility(View.INVISIBLE);

                        return true;
                    /**
                     * When pressing About us
                     */
                    case R.id.navigation_notifications:
                        //mTextMessage.setText(R.string.title_notifications);
                        resultTeamView.setVisibility(View.INVISIBLE);
                        teamInsert.setVisibility(View.INVISIBLE);
                        tvMainSelectedCate.setVisibility(View.VISIBLE);
                        tv2.setVisibility(View.VISIBLE);
                        tv3.setVisibility(View.VISIBLE);
                        tv4.setVisibility(View.VISIBLE);
                        tv5.setVisibility(View.VISIBLE);
                        tv6.setVisibility(View.VISIBLE);
                        tou.setVisibility(View.VISIBLE);
                        flag.setVisibility(View.VISIBLE);
                        clublogo.setVisibility(View.VISIBLE);
                        mTextMessage.setText("About Us");
                        playerSpinner.setVisibility(View.INVISIBLE);
                        button.setVisibility(View.INVISIBLE);
                        tvMainSelectedCate.setText("Zhao Li");
                        tv2.setText("Qiyuan Xu");
                        tv3.setText("Hai Cao");
                        tv4.setText("");
                        tv5.setText("");
                        tv6.setText("");
                        Picasso.with(tou.getContext()).load("http://n.sinaimg.cn/news/transform/20160811/EJcb-fxutsmv0315152.png").into(tou);
                        Picasso.with(flag.getContext()).load("http://n.sinaimg.cn/news/transform/20160811/EJcb-fxutsmv0315152.png").into(flag);
                        Picasso.with(clublogo.getContext()).load("http://n.sinaimg.cn/news/transform/20160811/EJcb-fxutsmv0315152.png").into(clublogo);
                        return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        playerData = new PlayerData();
        teamData = new TeamData();
        resultTeams = new ArrayList<>();
        resultTeamsNames = new ArrayList<>();

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        playerSpinner = (Spinner) findViewById(R.id.playerSpinner);
        tvMainSelectedCate = (TextView) findViewById(R.id.tvMainSelectedCate);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);
        tv5 = (TextView) findViewById(R.id.tv5);
        tv6 = (TextView) findViewById(R.id.tv6);
        tou = (ImageView) findViewById(R.id.tou);
        flag = (ImageView) findViewById(R.id.flag);
        clublogo = (ImageView) findViewById(R.id.clublogo);
        teamInsert = (EditText) findViewById(R.id.teamInsert);
        button = (Button) findViewById(R.id.button);
        resultTeamView = findViewById(R.id.resultTeamView);


        List<String[]> list = new ArrayList<String[]>();
        String next[] = {};
        System.out.println("test!");

        //read all data
        try {
            InputStreamReader playerStream = new InputStreamReader(getAssets().open(
                            "PlayerPersonalData2.0.csv"
            ));
            InputStreamReader teamStream = new InputStreamReader(getAssets().open(
                    "Team.csv"
            ));
            InputStreamReader teamAttrStream = new InputStreamReader(getAssets().open(
                    "Team_Attributes.csv"
            ));
            FifaDataController f = new FifaDataController(playerData, teamData, playerStream, teamStream, teamAttrStream);
            f.startReading();
            System.out.println("asadd" + playerData.getPlayerList().get(0).getName());
            System.out.println("asd" + teamData.getTeamList().get(0).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, playerData.getNameList());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        playerSpinner.setAdapter(adapter);
        playerSpinner.setOnItemSelectedListener(this);

        resultTeamView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Team seletedTeam = resultTeams.get(position);
                System.out.println("codecode " + seletedTeam.getApiId());
                ArrayList<Player> seletedTeamPlayers = (ArrayList) playerData.getTeamIndex().get(seletedTeam.getApiId());
                //System.out.println("coding " + seletedTeamPlayers.get(0).toString());

                Intent intent = new Intent(Main2Activity.this, DisplayMessageActivity.class);
                intent.putExtra("seletedTeam", seletedTeam);
                intent.putExtra("playersInTheTeam", seletedTeamPlayers);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        tvMainSelectedCate.setText("Name: "
                + playerData.getPlayerList().get(arg2).getName());
        tv2.setText("Country: "
                + playerData.getPlayerList().get(arg2).getNationality());
        tv3.setText("Club: "
                + playerData.getPlayerList().get(arg2).getClub());
        tv4.setText("Age: "
                + playerData.getPlayerList().get(arg2).getAge());
        tv5.setText("Overall: "
                + playerData.getPlayerList().get(arg2).getOverall());
        tv6.setText("Value: €"
                + playerData.getPlayerList().get(arg2).getValue());


        Picasso.with(tou.getContext()).load(playerData.getPlayerList().get(arg2).getPhoto()).into(tou);
        Picasso.with(flag.getContext()).load(playerData.getPlayerList().get(arg2).getFlag()).into(flag);
        Picasso.with(clublogo.getContext()).load(playerData.getPlayerList().get(arg2).getClubLogo()).into(clublogo);
    }



    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

    public void searchTeam(View view) {
        // Do something in response to button
        String input = teamInsert.getText().toString();

        resultTeams = (ArrayList) teamData.getTeamsByPrefix(input);
        resultTeamsNames = (ArrayList) teamData.getTeamNameByPrefix(input);

        resultTeamView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,  resultTeamsNames));

       /* Intent intent = new Intent(Main2Activity.this, DisplayMessageActivity.class);
        intent.putStringArrayListExtra("namelist", resultTeamsNames);
        intent.putExtra("teamList", resultTeams);
        startActivity(intent);*/

    }

    private ArrayList<String> getData(){
        ArrayList<String> data = new ArrayList<String>();
        data.add("测试数据1");
        data.add("测试数据2");
        data.add("测试数据3");
        data.add("测试数据4");
        return data;
    }

}
