package com.bingu.tournamentmanager.service.impl;

import com.bingu.tournamentmanager.model.Matchup;
import com.bingu.tournamentmanager.repository.MatchupRepository;
import com.bingu.tournamentmanager.service.MatchupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@Transactional
public class MatchupServiceImpl implements MatchupService {

    @Autowired
    private MatchupRepository matchupRepository;

    @Override
    public Matchup saveMatchup(Matchup matchup) {
        return matchupRepository.save(matchup);
    }

    @Override
    public void deleteMatchup(Long matchupId) {
        matchupRepository.deleteById(matchupId);
    }

    @Override
    public Matchup findMatchupByMatchupId(Long matchupId) {
        return matchupRepository.findById(matchupId).orElse(null);
    }

    @Override
    public Collection<Matchup> findAll() {
        return matchupRepository.findAll();
    }
}
