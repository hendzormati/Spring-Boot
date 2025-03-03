package tn.esprit.examen.nomPrenomClasseExamen.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.nomPrenomClasseExamen.entities.ProjetDetail;
import tn.esprit.examen.nomPrenomClasseExamen.services.IServices;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projetDetail")
public class ProjetDetailRestController {
    IServices projetService;

    @Autowired
    public ProjetDetailRestController(IServices projetService){
        this.projetService = projetService;
    }

    @GetMapping("/retrieve-all-projets")
    public List<ProjetDetail> getProjetDetails() {
        return projetService.retrieveAllProjetDetail();
    }

    @GetMapping("/retrieve-projetDetail/{projetDetail-id}")
    public ProjetDetail retrieveProjetDetail(@PathVariable("projetDetail-id") long chId) {
        return projetService.retrieveProjetDetail(chId);
    }

    @PostMapping("/add-projetDetail")
    public ProjetDetail addProjetDetail(@RequestBody ProjetDetail c){
        return projetService.addProjetDetail(c);
    }

    @DeleteMapping("/remove-projetDetail/{projetDetail-id}")
    public void removeProjetDetail(@PathVariable("projetDetail-id") long chId) {
        projetService.removeProjetDetail(chId);
    }

    @PutMapping("/modify-projetDetail")
    public ProjetDetail modifyProjetDetail(@RequestBody ProjetDetail c) {
        ProjetDetail projetDetail = projetService.modifyProjetDetail(c);
        return projetDetail;
    }
}