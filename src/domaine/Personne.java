package domaine;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistance.*;

public class Personne implements IDomainObject {
	int id;
	String nom;
	String prenom;
	String evaluation;
	Personne pere;
	ArrayList<Personne> fils;
	ArrayList<Observateur> obs;

	public Personne() {
	}

	public Personne(int id, String nom, String prenom, String evaluation) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.evaluation = evaluation;
		this.fils = new ArrayList<Personne>();
		this.obs = new ArrayList<Observateur>();
	}

	public void addFils(Personne p) {
		this.fils.add(p);
	}

	public void removeFils(Personne p) {
		this.fils.remove(p);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		notifier();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
		notifier();
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
		notifier();
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
		notifier();

	}

	public Personne getPere() {
		return pere;
	}

	public void setPere(Personne pere) {
		this.pere = pere;
		notifier();
	}

	public ArrayList<Personne> getFils() throws SQLException {
		return fils;
	}

	public void setFils(ArrayList<Personne> fils) {
		this.fils = fils;
		notifier();
	}

	@Override
	public void add(Observateur o) {
		obs.add(o);
	}

	@Override
	public void notifier() {
		for (Observateur o : obs)
			o.action(this);
	}

	@Override
	public void accepter(Visiteur v) {
		v.visiter(this);
	}

}
