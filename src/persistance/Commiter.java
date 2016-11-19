package persistance;

import domaine.Personne;

class Committer extends Visiteur {
	public void visiter(Personne p) {
		System.out.println("UPDATE DE LA BASE");
		PersonneMapper.getInstance().update(p);
	}
}