/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

/**
 *
 * @author Conrad Letelier <Conrad@Letelier.email>
 */


import java.util.List;
import models.Team;
import org.hibernate.Session;

public class TeamRepository {

    public Team addTeam(Team team) {
        Session session = NewHibernateUtil.getSession();
        session.beginTransaction();
        session.save(team);
        session.getTransaction().commit();
        session.close();

        // Behövs inte, endast för att testa
        return team;
    }
    
    public List<Team> getTeams(){
        Session session = NewHibernateUtil.getSession();
        List<Team> teams = session.createCriteria(Team.class).list();
        return teams;
    }

}
