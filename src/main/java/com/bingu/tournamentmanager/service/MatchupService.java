package com.bingu.tournamentmanager.service;

import com.bingu.tournamentmanager.model.Matchup;
import com.bingu.tournamentmanager.model.Team;

import java.util.Collection;

public interface MatchupService {

    public Matchup saveMatchup(Matchup matchup);
    public void deleteMatchup(Long matchupId);
    public Matchup findMatchupByMatchupId(Long matchupId);
    public Collection<Matchup> findAll();
}
