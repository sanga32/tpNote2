package persistance;

import java.util.HashSet;
import java.util.Set;

public class UnitOfWork {
	Set<IDomainObject> dirty;
	static UnitOfWork inst = null;

	public UnitOfWork() {
		dirty = new HashSet<IDomainObject>();
	}

	public static UnitOfWork getInstance() {
		if (inst == null)
			inst = new UnitOfWork();
		return inst;
	}

	public void action(IDomainObject o) {
		dirty.add(o);
	}

	void commit() {
		Visiteur v = new Committer();
		for (IDomainObject o : dirty) {
			v.visiter(o);
		}
		dirty.clear();
	}
}
