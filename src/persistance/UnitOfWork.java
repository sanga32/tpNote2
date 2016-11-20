package persistance;

import java.util.HashSet;
import java.util.Set;

/**
 * R�cup�re les objets personnes qui ont subi une modification 
 * Permet de commiter tout les objet modifier
 * @author Alexandre Godon, Kevin Delporte, Teddy Lequette
 *
 */
public class UnitOfWork implements Observateur {
	private Set<IDomainObject> personnes;
	static UnitOfWork inst = null;

	public UnitOfWork() {
		personnes = new HashSet<IDomainObject>();
	}

	/**
	 * Initialise l'instance si ce n'est pas d�ja fait et la renvoie
	 * @return l'instance d'UnitOfWork
	 */
	public static UnitOfWork getInstance() {
		if (inst == null)
			inst = new UnitOfWork();
		return inst;
	}

	/**
	 * On ajoute la personne qui a �t� modifier
	 */
	public void action(IDomainObject o) {
		personnes.add(o);
	}
	/**
	 * on commit toute les personnes qui ont �t� modifi� et on les supprime de la liste
	 */
	public void commit() {
		Visiteur v = new Committer();
		for (IDomainObject o : personnes) {
			v.visiter(o);
		}
		personnes.clear();
	}
}
