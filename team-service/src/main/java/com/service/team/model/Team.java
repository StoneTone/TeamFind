package com.service.team.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.service.team.events.TeamRequest;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamId;
    private String teamName;
    private String standing;
    private Integer playersNeeded;

    @OneToMany
    private List<PlayerSummary> playerList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    @JsonIgnoreProperties("team")
    private List<TeamRequest> teamRequest;
}
