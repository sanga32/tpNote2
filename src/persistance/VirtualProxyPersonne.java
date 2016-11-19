package persistance;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import domaine.Personne;

public class VirtualProxyPersonne extends Personne{
	static int id_personne;
	static Personne personne = null;

	VirtualProxyPersonne(int id_personne) {
		System.out.println("PROXY PERSONNE");
		this.id_personne = id_personne;
	}
	
	
	public void verifieInitilisation() throws SQLException {
		if (personne == null) {
			personne = new VirtualProxyPersonne(id_personne);
			initialisation();
		}
	}
	
	public void initialisation() throws SQLException {
		System.out.println("on va chercher le pere");
		personne = PersonneMapper.getInstance().findById(id_personne);
	}
	
	public Personne getPere() throws SQLException {
		verifieInitilisation();
		return personne.getPere();
	}
}
