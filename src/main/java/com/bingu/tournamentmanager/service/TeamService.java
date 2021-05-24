package com.bingu.tournamentmanager.service;

import com.bingu.tournamentmanager.model.Team;
import java.util.Collection;

public interface TeamService {

    public Team saveTeam(Team team);
    public void deleteTeam(String teamName);
    public Team findTeamByTeamName(String teamName);
    public Collection<Team> findAll();
}
