package tn.esprit.examen.nomPrenomClasseExamen.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Equipe;
import tn.esprit.examen.nomPrenomClasseExamen.services.IServices;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/equipe")
public class EquipeRestController {
    IServices equipeService;

    @Autowired
    public EquipeRestController(IServices equipeService){
        this.equipeService = equipeService;
    }

    @GetMapping("/retrieve-all-equipes")
    public List<Equipe> getEquipes() {
        return equipeService.retrieveAllEquipe();
    }

    @GetMapping("/retrieve-equipe/{equipe-id}")
    public Equipe retrieveEquipe(@PathVariable("equipe-id") long chId) {
        return equipeService.retrieveEquipe(chId);
    }

    @PostMapping("/add-equipe")
    public Equipe addEquipe(@RequestBody Equipe c){
        return equipeService.addEquipe(c);
    }

    @DeleteMapping("/remove-equipe/{equipe-id}")
    public void removeEquipe(@PathVariable("equipe-id") long chId) {
        equipeService.removeEquipe(chId);
    }

    @PutMapping("/modify-equipe")
    public Equipe modifyEquipe(@RequestBody Equipe c) {
        Equipe equipe = equipeService.modifyEquipe(c);
        return equipe;
    }
}