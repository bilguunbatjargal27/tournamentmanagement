package com.bingu.tournamentmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tournament")
public class Tournament {

    @Id
    private String name;
    private String logo;

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

    public Tournament() {
    }


}
