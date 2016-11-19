package persistance;

import domaine.Personne;

class Committer extends Visiteur {
	public void visiter(Personne p) {
		PersonneMapper.getInstance().update(p);
	}

}