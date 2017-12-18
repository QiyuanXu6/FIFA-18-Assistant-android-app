package com.example.lizhao.myfirstapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import android.widget.ImageView;

import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;


import com.fifa.FifaDataController;
import com.fifa.Player;
import com.fifa.PlayerData;
import com.fifa.Team;
import com.fifa.TeamData;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The Main Activity for this App
 */
public class Main2Activity extends AppCompatActivity implements OnItemSelectedListener {

    private TextView mTextMessage;
    private Spinner playerSpinner;
    private TextView tvName;
    private TextView tvCountry;
    private TextView tvClub;
    private TextView tvAge;
    private TextView tvOverall;
    private TextView tvValue;
    private EditText teamInsert;
    private ImageView photo;
    private ImageView flag;
    private ImageView clubLogo;
    private Button button;
    private ListView resultTeamView;

    private PlayerData playerData;
    private TeamData teamData;
    private ArrayList<Team> resultTeams;
    private ArrayList<String> resultTeamsNames;

    /**
     * set listener on navigation buttons
     */
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
                    tvName.setVisibility(View.VISIBLE);
                    tvCountry.setVisibility(View.VISIBLE);
                    tvClub.setVisibility(View.VISIBLE);
                    tvAge.setVisibility(View.VISIBLE);
                    tvOverall.setVisibility(View.VISIBLE);
                    tvValue.setVisibility(View.VISIBLE);
                    photo.setVisibility(View.VISIBLE);
                    flag.setVisibility(View.VISIBLE);
                    clubLogo.setVisibility(View.VISIBLE);
                    button.setVisibility(View.INVISIBLE);
                    playerSpinner.setVisibility(View.VISIBLE);
                    int currentPos = playerSpinner.getSelectedItemPosition();
                    tvName.setText("Name: "
                            + playerData.getPlayerList().get(currentPos).getName());
                    tvCountry.setText("Country: "
                            + playerData.getPlayerList().get(currentPos).getNationality());
                    tvClub.setText("Club: "
                            + playerData.getPlayerList().get(currentPos).getClub());
                    tvAge.setText("Age: "
                            + playerData.getPlayerList().get(currentPos).getAge());
                    tvOverall.setText("Overall: "
                            + playerData.getPlayerList().get(currentPos).getOverall());
                    tvValue.setText("Value: €"
                            + playerData.getPlayerList().get(currentPos).getValue());
                    Picasso.with(photo.getContext()).load(playerData.getPlayerList().get(currentPos).getPhoto()).into(photo);
                    Picasso.with(flag.getContext()).load(playerData.getPlayerList().get(currentPos).getFlag()).into(flag);
                    Picasso.with(clubLogo.getContext()).load(playerData.getPlayerList().get(currentPos).getClubLogo()).into(clubLogo);
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
                        tvName.setVisibility(View.INVISIBLE);
                        tvCountry.setVisibility(View.INVISIBLE);
                        tvClub.setVisibility(View.INVISIBLE);
                        tvAge.setVisibility(View.INVISIBLE);
                        tvOverall.setVisibility(View.INVISIBLE);
                        tvValue.setVisibility(View.INVISIBLE);
                        photo.setVisibility(View.INVISIBLE);
                        flag.setVisibility(View.INVISIBLE);
                        clubLogo.setVisibility(View.INVISIBLE);

                        return true;
                    /**
                     * When pressing About us
                     */
                    case R.id.navigation_notifications:
                        resultTeamView.setVisibility(View.INVISIBLE);
                        teamInsert.setVisibility(View.INVISIBLE);
                        tvName.setVisibility(View.VISIBLE);
                        tvCountry.setVisibility(View.VISIBLE);
                        tvClub.setVisibility(View.VISIBLE);
                        tvAge.setVisibility(View.VISIBLE);
                        tvOverall.setVisibility(View.VISIBLE);
                        tvValue.setVisibility(View.VISIBLE);
                        photo.setVisibility(View.VISIBLE);
                        flag.setVisibility(View.VISIBLE);
                        clubLogo.setVisibility(View.VISIBLE);
                        mTextMessage.setText("About Us");
                        playerSpinner.setVisibility(View.INVISIBLE);
                        button.setVisibility(View.INVISIBLE);
                        tvName.setText("Zhao Li");
                        tvCountry.setText("Qiyuan Xu");
                        tvClub.setText("Hai Cao");
                        tvAge.setText("");
                        tvOverall.setText("");
                        tvValue.setText("");
                        Picasso.with(photo.getContext()).load("https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Flag_of_the_People%27s_Republic_of_China.svg/250px-Flag_of_the_People%27s_Republic_of_China.svg.png").into(photo);
                        Picasso.with(flag.getContext()).load("https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Flag_of_the_People%27s_Republic_of_China.svg/250px-Flag_of_the_People%27s_Republic_of_China.svg.png").into(flag);
                        Picasso.with(clubLogo.getContext()).load("https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Flag_of_the_People%27s_Republic_of_China.svg/250px-Flag_of_the_People%27s_Republic_of_China.svg.png").into(clubLogo);
                        return true;
            }
            return false;
        }
    };

    /**
     * Define things when creating the activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        /**
         * find all the widgets by ID
         */
        playerData = new PlayerData();
        teamData = new TeamData();
        resultTeams = new ArrayList<>();
        resultTeamsNames = new ArrayList<>();
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        playerSpinner = (Spinner) findViewById(R.id.playerSpinner);
        tvName = (TextView) findViewById(R.id.tvMainSelectedCate);
        tvCountry = (TextView) findViewById(R.id.tv2);
        tvClub = (TextView) findViewById(R.id.tv3);
        tvAge = (TextView) findViewById(R.id.tv4);
        tvOverall = (TextView) findViewById(R.id.tv5);
        tvValue = (TextView) findViewById(R.id.tv6);
        photo = (ImageView) findViewById(R.id.tou);
        flag = (ImageView) findViewById(R.id.flag);
        clubLogo = (ImageView) findViewById(R.id.clublogo);
        teamInsert = (EditText) findViewById(R.id.teamInsert);
        button = (Button) findViewById(R.id.button);
        resultTeamView = findViewById(R.id.resultTeamView);

        /**
         * read all data from csv
         */
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
        } catch (IOException e) {   //handle exceptions
            e.printStackTrace();
        }
        /**
         * set the Player spinner
         */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, playerData.getNameList());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        playerSpinner.setAdapter(adapter);
        playerSpinner.setOnItemSelectedListener(this);
        /**
         * set on item click listener on reasultTeam ListView
         */
        resultTeamView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Team seletedTeam = resultTeams.get(position);
                System.out.println("codecode " + seletedTeam.getApiId());
                ArrayList<Player> seletedTeamPlayers = (ArrayList) playerData.getTeamIndex().get(seletedTeam.getApiId());
                /**
                 * pass the team and the players in the team to the New activity
                 */
                Intent intent = new Intent(Main2Activity.this, DisplayMessageActivity.class);
                intent.putExtra("seletedTeam", seletedTeam);
                intent.putExtra("playersInTheTeam", seletedTeamPlayers);
                startActivity(intent);
            }
        });
        /**
         * set listener for pressing ENTER in Team Search
         */
        teamInsert.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    searchTeam(findViewById(android.R.id.content));
                }
                return false;
            }
        });

    }

    /**
     * set response when seleted a player in the spinner
     * @param arg0 current adapterview
     * @param arg1  current view
     * @param arg2  the seleted position in spinner
     */
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        tvName.setText("Name: "
                + playerData.getPlayerList().get(arg2).getName());
        tvCountry.setText("Country: "
                + playerData.getPlayerList().get(arg2).getNationality());
        tvClub.setText("Club: "
                + playerData.getPlayerList().get(arg2).getClub());
        tvAge.setText("Age: "
                + playerData.getPlayerList().get(arg2).getAge());
        tvOverall.setText("Overall: "
                + playerData.getPlayerList().get(arg2).getOverall());
        tvValue.setText("Value: €"
                + playerData.getPlayerList().get(arg2).getValue());
        Picasso.with(photo.getContext()).load(playerData.getPlayerList().get(arg2).getPhoto()).into(photo);
        Picasso.with(flag.getContext()).load(playerData.getPlayerList().get(arg2).getFlag()).into(flag);
        Picasso.with(clubLogo.getContext()).load(playerData.getPlayerList().get(arg2).getClubLogo()).into(clubLogo);
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }
    /**
     * define the SearchTeam method when in team feature and press "search" button
     */
    public void searchTeam(View view) {
        /**
         * hide keyboard
         */
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        /**
         * get the input text from EditText teamInsert
         */
        String input = teamInsert.getText().toString();
        /**
         * search the teams according to input-text as prefix
         */
        resultTeams = (ArrayList) teamData.getTeamsByPrefix(input);
        resultTeamsNames = (ArrayList) teamData.getTeamNameByPrefix(input);
        /**
         * build the adaptor for ListView
         */
        List<HashMap<String,Object>> mListData = getListData(resultTeams);
        SimpleAdapter adapter = new SimpleAdapter(this, mListData, R.layout.list_view_layout,
                new String[]{"icon", "name"}, new int[]{R.id.photo, R.id.name});
        adapter.setViewBinder(new SimpleAdapter.ViewBinder() {
            public boolean setViewValue(View view, Object data,
                                        String textRepresentation) {
                if(view instanceof ImageView  && data instanceof Bitmap){
                    ImageView iv = (ImageView) view;
                    iv.setImageBitmap((Bitmap) data);
                    return true;
                }else
                    return false;
            }
        });
        resultTeamView.setAdapter(adapter);
    }

    /**
     * get list for adaptor
     * @param resultTeams resulting teams after search
     * @return a lish of HaspMap, which has keys and values for adaptor to use
     */
    public List<HashMap<String,Object>> getListData(ArrayList<Team> resultTeams){
        List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
        HashMap<String,Object> map = null;
        for(Team t: resultTeams){
            map = new HashMap<String, Object>();
            map.put("icon",getBitmap(teamData.getTeamLogoWithId(playerData, t.getApiId())));
            map.put("name",t.getLongName());
            list.add(map);
        }
        return list;
    }

    /**
     * get Bitmap from Internet URL for showing on ImageView
     * @param photoUrl
     * @return
     */
    public Bitmap getBitmap(String photoUrl){
        Bitmap mBitmap = null;
        try {
            URL url = new URL(photoUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStream is = conn.getInputStream();
            mBitmap = BitmapFactory.decodeStream(is);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mBitmap;
    }

}
