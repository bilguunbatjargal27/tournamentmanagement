package com.bingu.tournamentmanager.controller;

import com.bingu.tournamentmanager.model.Matchup;
import com.bingu.tournamentmanager.service.MatchupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("matchup")
@CrossOrigin(origins = "*")
public class MatchupController {

    @Autowired
    private MatchupService matchupService;

    @GetMapping("")
    public ResponseEntity<?> getAllMatchups() {
        List<Matchup> matchups = (List<Matchup>) matchupService.findAll();
        return ResponseEntity.ok(matchups);
    }


    @GetMapping("/{matchupId}")
    public ResponseEntity<?> getMatchupById(@PathVariable("matchupId") Long matchupId) {
        Matchup matchup = matchupService.findMatchupByMatchupId(matchupId);
        return ResponseEntity.ok(matchup);
    }


    @PostMapping("/add")
    public ResponseEntity<?> saveMatchup(@RequestBody final Matchup matchup) {
        Matchup responseMatchup = matchupService.saveMatchup(matchup);
        return ResponseEntity.ok(responseMatchup);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateMatchup(@RequestBody final Matchup updatedMatchup) {
        Matchup responseMatchup = matchupService.saveMatchup(updatedMatchup);
        return ResponseEntity.ok(responseMatchup);
    }

    @DeleteMapping("/delete/{matchupId}")
    public ResponseEntity<?> deleteMatchup(@PathVariable("matchupId") Long matchupId) {
        Matchup matchup = matchupService.findMatchupByMatchupId(matchupId);
        if(matchup == null) return ResponseEntity.badRequest().body("No matchup with given matchupname = " + matchupId);
        matchupService.deleteMatchup(matchupId);
        return ResponseEntity.ok("Successfully deleted");
    }

}
