package com.logone.abonneservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Entity
@Table(name = "abonnes")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Abonne  implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rfid;
}
