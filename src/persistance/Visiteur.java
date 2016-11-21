package persistance;

import domaine.Personne;
/**
 * class abstract visitable
 * @author Alexandre Godon, Kevin Delporte, Teddy Lequette
 *
 */
public abstract class Visiteur {
	public void visiter(IDomainObject o) {
		o.accepter(this);
	}
	abstract public void visiter(Personne p);
}