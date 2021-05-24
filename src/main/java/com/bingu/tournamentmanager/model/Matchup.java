package com.bingu.tournamentmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "matchup")
public class Matchup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String lobbyName;
    private String password;
    private String lobbyHost;
    private String matchResultImg;
    private String winnerTeam;

    @ManyToOne
    @JoinColumn(name = "tournament")
    @JsonIgnore
    private Tournament tournament;

    @OneToOne
    private Team unoTeam;

    @OneToOne
    private Team duoTeam;


    @ManyToOne
    @JoinColumn(name = "createdBy", nullable = false)
    @JsonIgnore
    private User createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @OneToMany(mappedBy = "tournament")
    private List<Team> teams = new ArrayList<>();

    public Matchup() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getLobbyName() {
        return lobbyName;
    }

    public void setLobbyName(String lobbyName) {
        this.lobbyName = lobbyName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLobbyHost() {
        return lobbyHost;
    }

    public void setLobbyHost(String lobbyHost) {
        this.lobbyHost = lobbyHost;
    }

    public String getMatchResultImg() {
        return matchResultImg;
    }

    public void setMatchResultImg(String matchResultImg) {
        this.matchResultImg = matchResultImg;
    }

    public String getWinnerTeam() {
        return winnerTeam;
    }

    public void setWinnerTeam(String winnerTeam) {
        this.winnerTeam = winnerTeam;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Team getUnoTeam() {
        return unoTeam;
    }

    public void setUnoTeam(Team unoTeam) {
        this.unoTeam = unoTeam;
    }

    public Team getDuoTeam() {
        return duoTeam;
    }

    public void setDuoTeam(Team duoTeam) {
        this.duoTeam = duoTeam;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
