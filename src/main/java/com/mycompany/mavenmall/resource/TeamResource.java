/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenmall.resource;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import models.Team;
import repository.TeamRepo;
import services.TeamService;

/**
 *
 * @author Conrad Letelier <Conrad@Letelier.email>
 */
@Path("/teams")
@Consumes (MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeamResource {
    
    TeamService teamservice = new TeamService();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Team> getTeams(){
        return teamservice.getTeams();
    }
    
    @GET
    @Path("/{teamId}")
    public Team getTeam(@PathParam("teamId")int id){
       return teamservice.getTeam(id);
    }
    
    @POST
    public Team addTeam(Team team){
        return teamservice.addTeam(team);
    }
    
    @PUT
    @Path("/{teamId}")
    public Team updateTeam(@PathParam("teamId")int id, Team team) {
        team.setId(id);
        return teamservice.updateTeam(team);
    }
    
    @DELETE
    @Path("/{teamId}")
    public void deleteTeam(@PathParam("teamId")int id) {
        teamservice.removeTeam(id);
    }
   
    @Path("/{teamId}/players")
    public PlayerResource getPlayerResource(){
        return new PlayerResource();
    }

}
