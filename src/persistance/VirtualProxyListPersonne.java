package persistance;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import domaine.Personne;

public class VirtualProxyListPersonne extends Personne{
	List<Personne> personnes = null;
	int id_personne;

	VirtualProxyListPersonne(int id_personne) {
		this.id_personne = id_personne;
	}

	void invoke(Method m, Object[] args) throws SQLException {
		if (personnes == null) {
			PersonneMapper pm = new PersonneMapper();
			personnes = pm.getFilsById(String.valueOf(id_personne));
		}
	}
}
