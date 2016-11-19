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
	List<Personne> fils;
	List<Observateur> obs;

	public Personne() {
	}

	@Override
	public String toString() {
		return nom + " " + prenom ;
	}

	public Personne(int id, String nom, String prenom, String evaluation) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.evaluation = evaluation;
		this.pere = null;
		this.fils = new VirtualProxyListPersonne();
		this.obs = new ArrayList<Observateur>();
	}

	public void addFils(Personne p) {
		fils.add(p);
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

	public Personne getPere() throws SQLException {
		return pere.getPersonne();
	}
	
	public Personne getPersonne() throws SQLException {
		return this;
	}

	public void setPere(Personne pere) {
		this.pere = pere;
		notifier();
	}

	public List<Personne> getFils() throws SQLException {
		return ((VirtualProxyListPersonne) fils).getFils();
	}

	public void setFils(List<Personne> fils) {
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
