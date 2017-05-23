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
import models.Player;
import models.Team;
import org.hibernate.Query;
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

    public List<Team> getTeams() {
        Session session = NewHibernateUtil.getSession();
        List<Team> teams = session.createCriteria(Team.class).list();
        return teams;
    }
    
    public Team getTeam(int teamId) {
        Session session = NewHibernateUtil.getSession();
        Team team = (Team) session.get(Team.class, teamId);
        team.getPlayers().size();
        session.close();
        return team;
    }

    public void updateTeam(Team team) {
        Session session = NewHibernateUtil.getSession();
        session.beginTransaction();
        session.update(team);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteTeam(int id) {
        Session session = NewHibernateUtil.getSession();
        session.beginTransaction();
        Team persistentInstance = (Team) session.load(Team.class, id);
        session.delete(persistentInstance);
        session.getTransaction().commit();
        session.close();
    }
    
    public Player addPlayer(Team team, Player newPlayer) {
        Session session = NewHibernateUtil.getSession();
        session.beginTransaction();
        newPlayer.setTeam(team);
        session.save(newPlayer);
        session.getTransaction().commit();
        session.close();
        return newPlayer;
    }
    
    public Player getPlayer(int playerId) {
        Session session = NewHibernateUtil.getSession();
        Player Player = (Player) session.get(Player.class, playerId);
        session.close();
        return Player;
    }
    
    public void updatePlayer(Player player) {
        Session session = NewHibernateUtil.getSession();
        session.beginTransaction();
        session.update(player);
        session.getTransaction().commit();
        session.close();
    }
    
    public void deletePlayer(int playerId) {
        Session session = NewHibernateUtil.getSession();
        session.beginTransaction();
        Player playerToDelete = (Player) session.load(Player.class, playerId);
        session.delete(playerToDelete);
        session.getTransaction().commit();
        session.close();
    }

}
