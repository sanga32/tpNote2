package persistance;

import java.sql.SQLException;

import domaine.Personne;

/**
 * ProxyPersonne permet de charger une personne uniquement
 * lorsqu'on lui demande
 * @author Alexandre Godon, Kevin Delporte, Teddy Lequette
 *
 */
public class VirtualProxyPersonne extends Personne{
	private int id_personne;
	private Personne personne = null;

	/**
	 * Contructeur du virtualProxyListPersonne qui 
	 * r�cup�re l'id de la personne qu'on r�cup�ra en BDD plus tard
	 * @param id_personne
	 */
	public VirtualProxyPersonne(int id_personne) {
		this.id_personne = id_personne;
	}
	
	/**
	 * On v�rifie si on a d�ja initialis� la personne
	 * sinon on l'inisialise
	 * @throws SQLException
	 */
	public void verifieInitilisation() throws SQLException {
		// on v�rifie id != 0 car c'est ce qui est retourn� par la BDD si id est null
		if (personne == null && id_personne != 0) {
			personne = new VirtualProxyPersonne(id_personne);
			initialisation();
		}
	}
	/**
	 * C'est ici qu'on r�cup�re la personne en BDD
	 * @throws SQLException
	 */
	public void initialisation() throws SQLException {
		personne = PersonneMapper.getInstance().findById(id_personne);
	}
	
	/**
	 * On va chercher la personne en BDD si �a n'est pas d�ja fait et on le retourne 
	 * @return une personne 
	 * @throws SQLException
	 */
	public Personne getPersonne() throws SQLException {
		verifieInitilisation();
		return personne;
	}
}
