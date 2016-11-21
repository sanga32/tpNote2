package persistance;

import domaine.Personne;

/**
 * class commiter est un visiteur qui permet de faire des modifications en BDD
 * @author Alexandre Godon, Kevin Delporte, Teddy Lequette
 *
 */
class Committer extends Visiteur {
	/**
	 * On va modifier, à l'aide d'un update, une personne en BDD 
	 */
	public void visiter(Personne p) {
		PersonneMapper.getInstance().update(p);
	}
}