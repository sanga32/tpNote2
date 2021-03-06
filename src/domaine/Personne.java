package domaine;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistance.IDomainObject;
import persistance.Observateur;
import persistance.VirtualProxyListPersonne;
import persistance.Visiteur;

/**
 * D�finit une personne avec son nom, prenom, un �ventuelle pere et �valuation
 * de ce dernier et de potentielle fils
 * 
 * @author Alexandre Godon, Kevin Delporte, Teddy Lequette
 *
 */
public class Personne implements IDomainObject {
	private int id;
	private String nom;
	private String prenom;
	private String evaluation;
	private Personne pere;
	private List<Personne> fils;
	private List<Observateur> obs;

	/**
	 * constructeur de personne
	 */
	public Personne() {
		this.fils = new VirtualProxyListPersonne(id);
		this.obs = new ArrayList<Observateur>();
	}

	public Personne(int id, String nom, String prenom, String evaluation) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.evaluation = evaluation;
		this.pere = null;
		this.fils = new VirtualProxyListPersonne(id);
		this.obs = new ArrayList<Observateur>();
	}

	public Personne(int id, String nom, String prenom, String evaluation, Personne pere, List<Personne> fils) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.evaluation = evaluation;
		this.pere = pere;
		this.fils = fils;
		this.obs = new ArrayList<Observateur>();
	}

	/**
	 * @return le nom et prenom de la personne
	 */
	@Override
	public String toString() {
		return nom + " " + prenom;
	}

	/**
	 * ajoute un fils
	 * 
	 * @param p
	 *            le fils � rajouter
	 */
	public void addFils(Personne p) {
		fils.add(p);
	}

	/**
	 * supprime un fils
	 * 
	 * @param p
	 *            fils � supprimer
	 */
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
	
	/**
	 * ajoute un observeur sur la personne
	 */
	@Override
	public void add(Observateur o) {
		obs.add(o);
	}
	/**
	 * effectue les actions des observeur lors d'une modification de la personne
	 */
	@Override
	public void notifier() {
		for (Observateur o : obs)
			o.action(this);
	}
	
	/**
	 * Permet � un visiteur de visiter la personne
	 */
	@Override
	public void accepter(Visiteur v) {
		v.visiter(this);
	}

}
