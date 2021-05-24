package com.bingu.tournamentmanager.service;

import com.bingu.tournamentmanager.model.Tournament;

import java.util.Collection;

public interface TournamentService {

    public Tournament saveTournament(Tournament tournament);
    public void deleteTournament(String tournamentName);
    public Tournament findTournamentByTournamentName(String tournamentName);
    public Collection<Tournament> findAll();
}
