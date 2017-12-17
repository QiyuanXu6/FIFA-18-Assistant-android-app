package com.example.lizhao.myfirstapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.fifa.Player;
import com.fifa.PlayerData;
import com.fifa.Team;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisplayMessageActivity extends AppCompatActivity {
    private ListView listView;
    private Team displayTeam;
    private ListView resultPlayersView;
    private ArrayList<String> namelist;
    private ArrayList<Team> teamlist;
    private List<Map<String, ?>> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        //String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        displayTeam  = (Team) intent.getSerializableExtra("seletedTeam");

        // Capture the layout's TextView and set the string as its text
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView1.setText(displayTeam.getLongName());
        textView2.setText("Short name: " + displayTeam.getShortName());
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setText("Playing Style: " + displayTeam.getBuildUpPlaySpeedClass());

        final ArrayList<Player> playersInTheTeam = (ArrayList<Player>) intent.getSerializableExtra("playersInTheTeam");
        namelist = getNames(playersInTheTeam);

       /* SimpleAdapter  adapter2 = new SimpleAdapter(this, getData(playersInTheTeam),
                R.layout.list_view_layout, new String[] { "photo", "name"},
                new int[] { R.id.photo, R.id.name});
        resultPlayersView.setAdapter(adapter2);*/
        //resultPlayersView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,  namelist));
        resultPlayersView = findViewById(R.id.resultPlayersView);

        List<HashMap<String,Object>> mListData = getListData(playersInTheTeam);
        SimpleAdapter adapter = new SimpleAdapter(this, mListData, R.layout.list_view_layout,
                new String[]{"icon", "name"}, new int[]{R.id.photo, R.id.name});

        adapter.setViewBinder(new SimpleAdapter.ViewBinder() {

            public boolean setViewValue(View view, Object data,
                                        String textRepresentation) {
                //判断是否为我们要处理的对象
                if(view instanceof ImageView  && data instanceof Bitmap){
                    ImageView iv = (ImageView) view;
                    iv.setImageBitmap((Bitmap) data);
                    return true;
                }else
                    return false;
            }
        });
        resultPlayersView.setAdapter(adapter);
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

    /*private List<Map<String, Object>> getData(ArrayList<Player> playersInTheTeam) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;
        for (Player p : playersInTheTeam) {
            map = new HashMap<String, Object>();
            map.put("photo", R.drawable.ic_home_black_24dp);
            map.put("name", p.getName());
            list.add(map);
        }
        return list;
    }*/

    public List<HashMap<String,Object>> getListData(ArrayList<Player> playersInTheTeam){
        List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
        HashMap<String,Object> map = null;
        for(Player p: playersInTheTeam){
            map = new HashMap<String, Object>();
            map.put("icon",getBitmap(p.getPhoto()));
            map.put("name",p.getName());
            list.add(map);
        }
        return list;
    }

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

