package persistance;

interface Observable {
	void add(Observateur o);
	void notifier();
}