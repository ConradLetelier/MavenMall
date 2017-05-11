/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import models.Team;
import repository.TeamRepo;
import repository.TeamRepository;

/**
 *
 * @author Conrad Letelier <Conrad@Letelier.email>
 */
public class TeamService {
    
    public List<Team> getTeams(){
        //TeamRepo tm = TeamRepo.getInstance();
       // return tm.getTeams();
       TeamRepository tm = new TeamRepository();
       return tm.getTeams();
    }
    Team tt = null;
    public Team getTeam(int id){
        //TeamRepo tm = TeamRepo.getInstance();
        //List<Team> myTeams = tm.getTeams();
        TeamRepository tm = new TeamRepository();
        List<Team> myTeams = tm.getTeams();
        for(Team t : myTeams){
            if(t.getId()==id){
                tt = t;
            }
        }
        return tt;
    }
    
    public Team addTeam(Team team){
        //TeamRepo tm = TeamRepo.getInstance();
        //tm.addTeam(team);
        
        TeamRepository teamDB = new TeamRepository();
        return teamDB.addTeam(team);
    }

        public Team updateTeam(Team team){
        TeamRepo tm = TeamRepo.getInstance();
        for(int i = 0; i < tm.getTeams().size(); i++){
            if(tm.getTeams().get(i).getId()==team.getId()){
                tm.getTeams().set(i, team);
            }
        }
        return team;
    }
}
