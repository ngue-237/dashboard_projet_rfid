package com.logone.abonnementservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "abonnements")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Abonnement implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "type_abonnement")
    private String typeAbon;
    @Column(name = "date_debut")
    private Date dateDeb;
    @Column(name = "date_fin")
    private Date dateFin;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Formule formule;

}
