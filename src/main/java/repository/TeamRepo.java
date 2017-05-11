/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import models.Player;
import models.Team;

/**
 *
 * @author Conrad Letelier <Conrad@Letelier.email>
 */
public class TeamRepo {
    
    private static TeamRepo DBinstance;
    private List<Team> teams;
    
    private TeamRepo(){
        teams=new ArrayList();
        teams.add(new Team(1,"Barcelona"));
        teams.add(new Team(2,"Malmö FF"));
        teams.add(new Team(3,"Valencia"));
        
        List<Player> players1 = new ArrayList();
        players1.add(new Player(1, "Messi"));
        players1.add(new Player(2, "Xavi"));
        
        teams.get(0).setPlayers(players1);
    }
    
    public static TeamRepo getInstance(){
        if(DBinstance == null){
            DBinstance = new TeamRepo();
        }
        return DBinstance;
    }

    public List<Team> getTeams() {
        return teams;
    }
    
    public void addTeam(Team team){
        teams.add(team);
    }
    
    
    
}
