package tn.esprit.examen.nomPrenomClasseExamen.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.examen.nomPrenomClasseExamen.entities.*;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.IClientRepository;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.IEquipeRepository;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.IProjetDetailRepository;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.IProjetRepository;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@AllArgsConstructor
@Service
public class ServicesImpl implements IServices {

    @Autowired
    IClientRepository clientRepository;

    @Override
    public Client add(Client client) {
        return clientRepository.save(client);
    }

   @Scheduled(cron = "*/15 * * * * *")
    @Override
    public void test() {
        log.info("testing");
    }
    @Autowired
    IEquipeRepository equipeRepository;
    @Override
    public List<Equipe> retrieveAllEquipe() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe retrieveEquipe(Long equipeId) {
        return equipeRepository.findById(equipeId).get();
    }

    @Override
    public Equipe addEquipe(Equipe b) {
        return equipeRepository.save(b);
    }

    @Override
    public void removeEquipe(Long equipeId) {
        equipeRepository.deleteById(equipeId);
    }

    @Override
    public Equipe modifyEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }
    @Autowired
    IProjetRepository projetRepository;
    @Override
    public List<Projet> retrieveAllProjet() {
        return projetRepository.findAll();
    }

    @Override
    public Projet retrieveProjet(Long projetId) {
        return projetRepository.findById(projetId).get();
    }

    @Override
    public Projet addProjet(Projet b) {
        return projetRepository.save(b);
    }

    @Override
    public void removeProjet(Long projetId) {
        projetRepository.deleteById(projetId);
    }

    @Override
    public Projet modifyProjet(Projet projet) {
        return projetRepository.save(projet);
    }
    @Autowired
    IProjetDetailRepository projetDetailRepository;
    @Override
    public List<ProjetDetail> retrieveAllProjetDetail() {
        return projetDetailRepository.findAll();
    }

    @Override
    public ProjetDetail retrieveProjetDetail(Long projetDetailId) {
        return projetDetailRepository.findById(projetDetailId).get();
    }

    @Override
    public ProjetDetail addProjetDetail(ProjetDetail b) {
        return projetDetailRepository.save(b);
    }

    @Override
    public void removeProjetDetail(Long projetDetailId) {
        projetDetailRepository.deleteById(projetDetailId);
    }

    @Override
    public ProjetDetail modifyProjetDetail(ProjetDetail projetDetail) {
        return projetDetailRepository.save(projetDetail);
    }
    @Override
    public Projet addProjetAndProjetDetailAndAssign(Projet projet, Long projetDetailId) {
        ProjetDetail projetDetail = projetDetailRepository.findById(projetDetailId).get();
        projet.setProjetDetail(projetDetail);
        return projetRepository.save(projet);
    }

    @Override
    public void assignProjetDetailToProjet(Long projetId, Long projetDetailId) {
        Projet projet = projetRepository.findById(projetId).get();
        ProjetDetail projetDetail = projetDetailRepository.findById(projetDetailId).get();
        projet.setProjetDetail(projetDetail);
        projetRepository.save(projet);
    }

    @Override
    public void assignProjetToEquipe(Long projetId, Long equipeId) {
        Projet projet = projetRepository.findById(projetId).get();
        Equipe equipe = equipeRepository.findById(equipeId).get();
// on set le fils dans le parent :
        equipe.getProjets().add(projet);
        equipeRepository.save(equipe);
    }

    @Override
    public Projet ProjetdesaffecterProjetDetail(Long projetId) {
        Projet projet = projetRepository.findById(projetId).get();
        projet.setProjetDetail(null);
        return projetRepository.save(projet);
    }

    @Override
    public void desaffecterProjetFromEquipe(Long projetId, Long equipeId) {
        Projet projet = projetRepository.findById(projetId).get();
        Equipe equipe = equipeRepository.findById(equipeId).get();
        equipe.getProjets().remove(projet);
        equipeRepository.save(equipe);
    }
}
