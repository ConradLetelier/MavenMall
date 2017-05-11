package com.mycompany.mavenmall;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import models.Team;
import services.TeamService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    TeamService teamservice = new TeamService();
   @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Team> getTeams(){
        return teamservice.getTeams();
    }
}
