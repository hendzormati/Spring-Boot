package tn.esprit.examen.nomPrenomClasseExamen.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Projet {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    String sujet;
    @OneToOne(cascade = CascadeType.ALL)
    private ProjetDetail projetDetail;

}
