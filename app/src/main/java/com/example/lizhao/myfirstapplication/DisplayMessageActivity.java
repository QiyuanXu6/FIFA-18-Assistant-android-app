package com.example.lizhao.myfirstapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import com.fifa.Player;
import com.fifa.Team;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is the Activity to display team information and its players
 */
public class DisplayMessageActivity extends AppCompatActivity {
    private Team displayTeam;
    private ListView resultPlayersView;
    private ArrayList<Player> playersInTheTeam;

    /**
     * define things when creating this activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        /**
         *  Get the Intent that started this activity and extract the team and players passing here
         */
        Intent intent = getIntent();
        displayTeam  = (Team) intent.getSerializableExtra("seletedTeam");
        playersInTheTeam = (ArrayList<Player>) intent.getSerializableExtra("playersInTheTeam");
        /**
         *Capture the layout's TextView and set the string as its text
         */
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView1.setText(displayTeam.getLongName());
        textView2.setText("Short name: " + displayTeam.getShortName());
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setText("Playing Style: " + displayTeam.getBuildUpPlaySpeedClass());

        resultPlayersView = findViewById(R.id.resultPlayersView);
        /**
         * set the adapter to display players' photos and names
         */
        List<HashMap<String,Object>> mListData = getListData(playersInTheTeam);
        SimpleAdapter adapter = new SimpleAdapter(this, mListData, R.layout.list_view_layout,
                new String[]{"photo", "name"}, new int[]{R.id.photo, R.id.name});
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
        /**
         * apply the adaptor
         */
        resultPlayersView.setAdapter(adapter);
    }
    /**
     * get list for adaptor
     * @param playersInTheTeam a list of players in this team
     * @return a lish of HaspMap, which has keys and values for adaptor to use
     */
    public List<HashMap<String,Object>> getListData(ArrayList<Player> playersInTheTeam){
        List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
        HashMap<String,Object> map = null;
        for(Player p: playersInTheTeam){
            map = new HashMap<String, Object>();
            map.put("photo",getBitmap(p.getPhoto()));
            map.put("name",p.getName());
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

