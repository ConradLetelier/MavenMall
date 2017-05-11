/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenmall.resource;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import models.Player;
import services.PlayerService;

/**
 *
 * @author Conrad Letelier <Conrad@Letelier.email>
 */ 
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public class PlayerResource{
        
        PlayerService playerService = new PlayerService();
        
        @GET
        public List<Player> getPlayers(@PathParam("teamId") int teamId){
            return playerService.getPlayers(teamId);
        }
        
        @POST
        public Player addPlayer(@PathParam("teamId") int teamId, Player player){
            return playerService.addPlayer(teamId, player);
        }
    
}
