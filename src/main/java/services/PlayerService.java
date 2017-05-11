/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import models.Player;
import models.Team;
import repository.TeamRepo;

/**
 *
 * @author Conrad Letelier <Conrad@Letelier.email>
 */
public class PlayerService {
    
    public List<Player> getPlayers(int teamId){
        List<Team> teams = TeamRepo.getInstance().getTeams();
        List<Player> players= null;
        for(Team t : teams){
            if(t.getId()==teamId){
                players=t.getPlayers();
            }
        }
        return players;
    }
    
    public Player addPlayer(int teamId, Player player){
        List<Team> teams = TeamRepo.getInstance().getTeams();
        List<Player> players;
        for(int i = 0; i < teams.size(); i++){
            if(teams.get(i).getId()==teamId){
                players = teams.get(i).getPlayers();
                player.setId((players.size()+1));
                teams.get(i).getPlayers().add(player);
            }
        }
        return player;
    }
    
}
