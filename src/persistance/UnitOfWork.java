package persistance;

import java.util.HashSet;
import java.util.Set;

public class UnitOfWork {
	Set<IDomainObject> personnes;
	static UnitOfWork inst = null;

	public UnitOfWork() {
		personnes = new HashSet<IDomainObject>();
	}

	public static UnitOfWork getInstance() {
		if (inst == null)
			inst = new UnitOfWork();
		return inst;
	}

	public void action(IDomainObject o) {
		personnes.add(o);
	}

	public void commit() {
		Visiteur v = new Committer();
		for (IDomainObject o : personnes) {
			v.visiter(o);
		}
		personnes.clear();
	}
}
