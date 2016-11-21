package persistance;

/**
 * interface observable
 * @author Alexandre Godon, Kevin Delporte, Teddy Lequette
 *
 */
interface Observable {
	void add(Observateur o);
	void notifier();
}