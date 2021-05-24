package com.bingu.tournamentmanager.controller;

import com.bingu.tournamentmanager.model.Tournament;
import com.bingu.tournamentmanager.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tournament")
@CrossOrigin(origins = "*")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @GetMapping("")
    public ResponseEntity<?> getAllTournaments() {
        List<Tournament> tournaments = (List<Tournament>) tournamentService.findAll();
        return ResponseEntity.ok(tournaments);
    }


    @GetMapping("/{tournamentName}")
    public ResponseEntity<?> getTournamentById(@PathVariable("tournamentName") String tournamentName) {
        Tournament tournament = tournamentService.findTournamentByTournamentName(tournamentName);
        return ResponseEntity.ok(tournament);
    }


    @PostMapping("/add")
    public ResponseEntity<?> saveTournament(@RequestBody final Tournament tournament) {
        Tournament responseTournament = tournamentService.saveTournament(tournament);
        return ResponseEntity.ok(responseTournament);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateTournament(@RequestBody final Tournament updatedTournament) {
        Tournament responseTournament = tournamentService.saveTournament(updatedTournament);
        return ResponseEntity.ok(responseTournament);
    }

    @DeleteMapping("/delete/{tournamentName}")
    public ResponseEntity<?> deleteTournament(@PathVariable("tournamentName") String tournamentName) {
        Tournament tournament = tournamentService.findTournamentByTournamentName(tournamentName);
        if(tournament == null) return ResponseEntity.badRequest().body("No tournament with given tournamentname = " + tournamentName);
        tournamentService.deleteTournament(tournamentName);
        return ResponseEntity.ok("Successfully deleted");
    }

}
