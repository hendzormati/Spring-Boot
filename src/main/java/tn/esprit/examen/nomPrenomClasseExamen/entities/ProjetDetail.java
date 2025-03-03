package tn.esprit.examen.nomPrenomClasseExamen.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjetDetail {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    String descrption;
    String technologie;
    Long cout;
    Date dateDebut;
    @OneToOne(mappedBy = "projetDetail")
    @ToString.Exclude
    @JsonIgnore
    private Projet projet;
}
