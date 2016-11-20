package persistance;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import domaine.Personne;

/**
 * ProxyListPersonne permet de charger les fils d'une personne uniquement
 * lorsqu'on lui demande
 * @author Alexandre Godon, Kevin Delporte, Teddy Lequette
 *
 */
public class VirtualProxyListPersonne implements List<Personne>{
	private int id_personne;
	private List<Personne> personnes = null;

	/**
	 * Contructeur du virtualProxyListPersonne qui 
	 * récupère l'id de la personne
	 * @param id_personne
	 */
	public VirtualProxyListPersonne(int id_personne) {
		this.id_personne = id_personne;
	}
	
	public VirtualProxyListPersonne() {
	}
	
	/**
	 * On vérifie si on a déja initialisé la liste de fils
	 * sinon on l'inisialise
	 * @throws SQLException
	 */
	public void verifieInitilisation() throws SQLException {
		if (personnes == null) {
			personnes = new ArrayList<Personne>();
			initialisation();
		}

	}
	/**
	 * C'est ici qu'on récupère les fils en BDD
	 * @throws SQLException
	 */
	public void initialisation() throws SQLException {
		personnes = PersonneMapper.getInstance().getFilsById(id_personne);
	}
	
	/**
	 * On va chercher les fils d'une personne
	 * @return une liste de personne 
	 * @throws SQLException
	 */
	public List<Personne> getFils() throws SQLException {
		verifieInitilisation();
		return personnes; 
	}

	/**
	 * On ajoute un fils à la liste de personne
	 * 
	 * @return true si tout s'est bien passé
	 */
	@Override
	public boolean add(Personne e) {
		try {
			verifieInitilisation();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		this.personnes.add(e);
		return true;
	}

	@Override
	public void add(int index, Personne element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addAll(Collection<? extends Personne> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends Personne> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		try {
			verifieInitilisation();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		personnes.clear();
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Personne get(int index) {
		try {
			verifieInitilisation();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return personnes.get(index);
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		try {
			verifieInitilisation();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if(personnes.isEmpty())return true;
		return false;
	}

	@Override
	public Iterator<Personne> iterator() {
		// TODO Auto-generated method stub
		return personnes.iterator();
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<Personne> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<Personne> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Personne remove(int index) {
		return personnes.remove(index);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Personne set(int index, Personne element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		try {
			verifieInitilisation();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return personnes.size();
	}

	@Override
	public List<Personne> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}
}
