package com.bingu.tournamentmanager.service.impl;

import com.bingu.tournamentmanager.model.Team;
import com.bingu.tournamentmanager.repository.TeamRepository;
import com.bingu.tournamentmanager.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public void deleteTeam(String teamName) {
        teamRepository.deleteById(teamName);
    }

    @Override
    public Team findTeamByTeamName(String teamName) {
        return teamRepository.findById(teamName).orElse(null);
    }

    @Override
    public Collection<Team> findAll() {
        return teamRepository.findAll();
    }
}
