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
import repository.TeamRepository;

/**
 *
 * @author Conrad Letelier <Conrad@Letelier.email>
 */
public class PlayerService {
    TeamService teamService;
    TeamRepository teamDB;
    
    public PlayerService() {
        teamService = new TeamService();
        teamDB = new TeamRepository();
    }
    
    public List<Player> getPlayers(int id) {
        return teamDB.getTeam(id).getPlayers();
    }

    public void addPlayer(int teamId, Player player) {
        Team teamToAddPlayerOn = teamDB.getTeam(teamId);
        teamDB.addPlayer(teamToAddPlayerOn, player);
    }
    
    public Player getPlayer(int playerId) {
        return teamDB.getPlayer(playerId);
    }

    public void updatePlayer(int teamId, int playerId, Player player) {
        Team teamToUpdatePlayerIn = teamDB.getTeam(teamId);
        player.setId(playerId);
        player.setTeam(teamToUpdatePlayerIn);
        teamDB.updatePlayer(player);
        
    }

    public void deletePlayer(int playerId) {
        teamDB.deletePlayer(playerId);
    }
    
}
