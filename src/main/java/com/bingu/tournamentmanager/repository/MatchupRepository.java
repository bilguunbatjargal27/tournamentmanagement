package com.bingu.tournamentmanager.repository;

import com.bingu.tournamentmanager.model.Matchup;
import com.bingu.tournamentmanager.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchupRepository extends JpaRepository<Matchup, Long> {

}
