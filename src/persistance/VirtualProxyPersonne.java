package persistance;

import java.sql.SQLException;

import domaine.Personne;

public class VirtualProxyPersonne extends Personne{
	private int id_personne;
	private Personne personne = null;

	public VirtualProxyPersonne(int id_personne) {
		this.id_personne = id_personne;
	}
	
	
	public void verifieInitilisation() throws SQLException {
		if (personne == null && id_personne != 0) {
			personne = new VirtualProxyPersonne(id_personne);
			initialisation();
		}
	}
	
	public void initialisation() throws SQLException {
		personne = PersonneMapper.getInstance().findById(id_personne);
	}
	
	public Personne getPersonne() throws SQLException {
		verifieInitilisation();
		return personne;
	}
}
