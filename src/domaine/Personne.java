package domaine;

import java.util.ArrayList;

import persistance.VirtualProxyListPersonne;

public class Personne {
	int id;
	String nom;
	String prenom;
	int evaluation;
	Personne pere;
	ArrayList<Personne> fils;
	
	public Personne(){
	}
	
	public void add(Personne p){
		this.fils.add(p);
	}
	public void remove(Personne p){
		this.fils.remove(p);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}
	public Personne getPere() {
		return pere;
	}
	public void setPere(Personne pere) {
		this.pere = pere;
	}
	public ArrayList<Personne> getFils() {
		return fils;
	}
	public void setFils(ArrayList<Personne> fils) {
		this.fils = fils;
	}
	
	
	
	
}
