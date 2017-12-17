package com.fifa;

import java.io.IOException;
import java.io.InputStreamReader;

import au.com.bytecode.opencsv.CSVReader;

/**
 * Created by qiyuanxu on 12/16/17.
 */

public class TeamReader {
    private InputStreamReader teamStream;
    private InputStreamReader teamAttrStream;
    private TeamData teamData;

    public TeamReader(InputStreamReader teamStream, InputStreamReader teamAttrStream, TeamData teamData) {
        this.teamStream = teamStream;
        this.teamAttrStream = teamAttrStream;
        this.teamData = teamData;
    }

    public void read() {
        CSVReader reader = new CSVReader(teamStream);
        String[] line;
        try {
            reader.readNext();
            while (true) {
                line = reader.readNext();
                if (line == null) {
                    break;
                }
                int id = line[0].length() == 0 ? 0 : Integer.parseInt(line[0]);
                int apiId = line[1].length() == 0 ? 0 :Integer.parseInt(line[1]);
                int fifaId = line[2].length() == 0 ? 0 : Integer.parseInt(line[2]);
                String longName = line[3];
                String shortName = line[4];
                Team cur = new Team(id, apiId, fifaId, longName, shortName);
                teamData.addTeam(cur);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        teamData.createIndexByName();
        teamData.createIndexById();

        reader = new CSVReader(teamAttrStream);

        try {
            reader.readNext();
            while (true) {
                line = reader.readNext();
                if (line == null) {
                    break;
                }
                int id = Integer.parseInt(line[0]);
                Team t = teamData.getTeamById(id);
                if (t != null) {
                    t.setDate(line[3]);
                    t.setBuildUpPlaySpeed(Integer.parseInt(line[4]));
                    t.setBuildUpPlaySpeedClass(line[5]);
                    t.setBuildUpPlayDribbling(Integer.parseInt(line[6]));
                    t.setBuildUpPlayDribblingClass(line[7]);
                    t.setBuildUpPlayPassing(Integer.parseInt(line[8]));
                    t.setBuildUpPlayPassingClass(line[9]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
