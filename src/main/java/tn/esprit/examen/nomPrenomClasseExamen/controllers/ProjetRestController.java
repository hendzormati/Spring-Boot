package tn.esprit.examen.nomPrenomClasseExamen.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Equipe;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Projet;
import tn.esprit.examen.nomPrenomClasseExamen.services.IServices;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projet")
public class ProjetRestController {
    @Autowired
    IServices projetService;

    public ProjetRestController(IServices projetService){
        this.projetService = projetService;
    }

    @GetMapping("/retrieve-all-projets")
    public List<Projet> getProjets() {
        return projetService.retrieveAllProjet();
    }

    @GetMapping("/retrieve-projet/{projet-id}")
    public Projet retrieveProjet(@PathVariable("projet-id") long chId) {
        return projetService.retrieveProjet(chId);
    }

    @PostMapping("/add-projet")
    public Projet addProjet(@RequestBody Projet c){
        return projetService.addProjet(c);
    }

    @DeleteMapping("/remove-projet/{projet-id}")
    public void removeProjet(@PathVariable("projet-id") long chId) {
        projetService.removeProjet(chId);
    }

    @PutMapping("/modify-projet")
    public Projet modifyProjet(@RequestBody Projet c) {
        Projet projet = projetService.modifyProjet(c);
        return projet;
    }
    @PostMapping("/ajouter-projet-et-projet-detail/{projet-details-id}")
    public Projet addProjetAndProjetDetail(@RequestBody Projet p,@PathVariable("projet-details-id") Long projetDetailsId) {
        Projet projet = projetService.addProjetAndProjetDetailAndAssign(p,projetDetailsId);
        return projet;
    }
    @PutMapping("/désaffecter-projet-detail/{projet-id}")
    public Projet ProjetdesaffecterProjetDetail(@PathVariable("projet-id") Long projetId) {
        Projet projet = projetService.ProjetdesaffecterProjetDetail(projetId);
        return projet;
    }
    @PutMapping("/affecter-projet-a-projet-details/{projet-id}/{projet-details-id}")
    public void affecterProjetAProjetDetail(@PathVariable("projet-id") Long projetId,
                                            @PathVariable("projet-details-id") Long projetDetailsId) {
        projetService.assignProjetDetailToProjet(projetId, projetDetailsId);
    }
    @PutMapping("/affecter-projet-a-equipe-/{projet-id}/{equipe-id}")
    public void assignProjetToEquipe(@PathVariable("projet-id") Long projetId,
                                             @PathVariable("equipe-id") Long equipeId) {
        projetService.assignProjetToEquipe(projetId, equipeId);
    }
    @PutMapping("/désaffecter-projet-from-equipe-/{projet-id}/{equipe-id}")
    public void desaffecterProjetFromEquipe(@PathVariable("projet-id") Long projetId,
                                     @PathVariable("equipe-id") Long equipeId) {
        projetService.desaffecterProjetFromEquipe(projetId, equipeId);
    }
    @PutMapping("/affecter-projets-a-equipe-/{projet-id}/{equipe-id}")
    public void assignProjetsToEquipe(@PathVariable("projet-id") List<Long> projetsIDs,
                                     @PathVariable("equipe-id") Long equipeId) {
        for (Long i:projetsIDs
        ) {
            projetService.assignProjetToEquipe(i, equipeId);
        }
    }
    @PutMapping("/affecter-projet-a-equipes-/{projet-id}")
    public void assignProjetToEquipes(@PathVariable("projet-id") Long projetId,
                                      @RequestBody Set<Equipe> equipes) {
        for (Equipe e:equipes
             ) {
            projetService.assignProjetToEquipe(projetId,e.getId());
        }

    }
}