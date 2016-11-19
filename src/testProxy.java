import java.sql.SQLException;

import domaine.Personne;
import persistance.PersonneMapper;

public class testProxy {

	public static void main(String[] args) throws SQLException {
		PersonneMapper.getInstance().clear();
		Personne p1 = new Personne(1,"Alex","Godon",null);
		Personne p2 = new Personne(2,"Kevin","Delporte",null);
		System.out.println("on ajoute le pere et le fils");
		p2.setPere(p1);p1.addFils(p2);
		PersonneMapper.getInstance().insert(p1);
		PersonneMapper.getInstance().insert(p2);
		System.out.println("affichage");
		System.out.println(PersonneMapper.getInstance().findById("1").toString());
		System.out.println(PersonneMapper.getInstance().findById("2").getPere().toString());
		System.out.println(PersonneMapper.getInstance().getFilsById("1").get(1).toString());
		for(int i=0;i<p1.getFils().size();i++){
			System.out.println("yo");
			System.out.println(p1.getFils().get(1).toString());
		}
	}

}
