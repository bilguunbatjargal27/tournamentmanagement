package com.bingu.tournamentmanager.controller;

import com.bingu.tournamentmanager.model.Team;
import com.bingu.tournamentmanager.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("team")
@CrossOrigin(origins = "*")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("")
    public ResponseEntity<?> getAllTeams() {
        List<Team> teams = (List<Team>) teamService.findAll();
        return ResponseEntity.ok(teams);
    }


    @GetMapping("/{teamName}")
    public ResponseEntity<?> getTeamById(@PathVariable("teamName") String teamName) {
        Team team = teamService.findTeamByTeamName(teamName);
        return ResponseEntity.ok(team);
    }


    @PostMapping("/add")
    public ResponseEntity<?> saveTeam(@RequestBody final Team team) {
        Team responseTeam = teamService.saveTeam(team);
        return ResponseEntity.ok(responseTeam);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateTeam(@RequestBody final Team updatedTeam) {
        Team responseTeam = teamService.saveTeam(updatedTeam);
        return ResponseEntity.ok(responseTeam);
    }

    @DeleteMapping("/delete/{teamName}")
    public ResponseEntity<?> deleteTeam(@PathVariable("teamName") String teamName) {
        Team team = teamService.findTeamByTeamName(teamName);
        if(team == null) return ResponseEntity.badRequest().body("No team with given teamname = " + teamName);
        teamService.deleteTeam(teamName);
        return ResponseEntity.ok("Successfully deleted");
    }

}
