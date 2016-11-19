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
		this.id_personne = id_personne;
	}
	
	public static void initialisation() throws SQLException {
		PersonneMapper pm = new PersonneMapper();
		personne = pm.findById(String.valueOf(id_personne));
	}
	
	public void verifieInitilisation() {
		if (personne == null) {
			personne = new Personne();
			(VirtualProxyPersonne) personne.initialisation();
		}
	}
	
	public ArrayList<Personne> getFils() {
		verifieInitilisation();
		return personne.getFils();
	}
}
