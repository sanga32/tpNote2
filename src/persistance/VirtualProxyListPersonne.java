package persistance;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import domaine.Personne;
public class VirtualProxyListPersonne implements List<Personne>{
	static int id_personne;
	static List<Personne> personnes = null;

	VirtualProxyListPersonne(int id_personne) {
		this.id_personne = id_personne;
		List<Personne> personnes = new ArrayList<Personne>();
	}
	
	public VirtualProxyListPersonne() {
		List<Personne> personnes = new ArrayList<Personne>();
	}
	
	
	public void verifieInitilisation() throws SQLException {
		if (personnes == null) {
			personnes = new VirtualProxyListPersonne(id_personne);
			initialisation();
		}
	}
	
	public void initialisation() throws SQLException {
		personnes = PersonneMapper.getInstance().getFilsById(String.valueOf(id_personne));
	}
	
	public List<Personne> getFils() throws SQLException {
		verifieInitilisation();
		return personnes;
	}


	@Override
	public boolean add(Personne e) {
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Iterator<Personne> iterator() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return 0;
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
