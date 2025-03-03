package tn.esprit.examen.nomPrenomClasseExamen.services;

import tn.esprit.examen.nomPrenomClasseExamen.entities.Client;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Equipe;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Projet;
import tn.esprit.examen.nomPrenomClasseExamen.entities.ProjetDetail;

import java.util.List;

public interface IServices {
    Client add(Client client);
    void test();
    public List<Equipe> retrieveAllEquipe();
    public Equipe retrieveEquipe(Long EquipeId);
    public Equipe addEquipe(Equipe b);
    public void removeEquipe(Long equipeId);
    public Equipe modifyEquipe(Equipe equipe);
    public List<Projet> retrieveAllProjet();
    public Projet retrieveProjet(Long ProjetId);
    public Projet addProjet(Projet b);
    public void removeProjet(Long projetId);
    public Projet modifyProjet(Projet projet);
    public List<ProjetDetail> retrieveAllProjetDetail();
    public ProjetDetail retrieveProjetDetail(Long ProjetDetailId);
    public ProjetDetail addProjetDetail(ProjetDetail b);
    public void removeProjetDetail(Long projetDetailId);
    public ProjetDetail modifyProjetDetail(ProjetDetail projetDetail);
    public Projet addProjetAndProjetDetailAndAssign(Projet projet, Long projetDetailId);
    public void assignProjetDetailToProjet(Long projetId, Long projetDetailId);
    public void assignProjetToEquipe(Long projetId, Long equipeId);

    Projet ProjetdesaffecterProjetDetail(Long projetId);

    void desaffecterProjetFromEquipe(Long projetId, Long equipeId);
}
