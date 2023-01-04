package com.logone.abonnementservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "formule_repas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Formule implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String formuleName;
    private int nbPoints;
    @Column(columnDefinition = "text")
    private String description;
}
