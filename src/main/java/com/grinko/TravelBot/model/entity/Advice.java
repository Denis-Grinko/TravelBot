package com.grinko.TravelBot.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "city_advice")
public class Advice {

    @Id
    @GeneratedValue
    private UUID id;
    @JoinColumn(name = "city_id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private City city;
    private String advice;

}
