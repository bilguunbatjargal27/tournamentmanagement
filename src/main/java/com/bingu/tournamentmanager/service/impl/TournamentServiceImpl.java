package com.bingu.tournamentmanager.service.impl;

import com.bingu.tournamentmanager.model.Tournament;
import com.bingu.tournamentmanager.repository.TournamentRepository;
import com.bingu.tournamentmanager.repository.TournamentRepository;
import com.bingu.tournamentmanager.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class TournamentServiceImpl implements TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Override
    public Tournament saveTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    @Override
    public void deleteTournament(String tournamentName) {
        tournamentRepository.deleteById(tournamentName);
    }

    @Override
    public Tournament findTournamentByTournamentName(String tournamentName) {
        return tournamentRepository.findById(tournamentName).orElse(null);
    }

    @Override
    public Collection<Tournament> findAll() {
        return tournamentRepository.findAll();
    }
}
