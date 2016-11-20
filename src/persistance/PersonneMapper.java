package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domaine.Personne;
import settings.ConnectionInfo;
import settings.Utilisateur;
/**
 * PersonneMapper est la classe permettant de faire le lien avec la BDD 
 * Elle permet d'insérer, modifier, supprimer ou chercher une personne
 * @author Alexandre Godon, Kevin Delporte, Teddy Lequette
 *
 */
public class PersonneMapper {
	private Connection conn;
	static PersonneMapper inst;
	
	/**
	 * Permet d'initialiser le PersonneMapper
	 */
	public PersonneMapper() {
		try {
			conn = DriverManager.getConnection(ConnectionInfo.DB_URL, Utilisateur.COMPTE, Utilisateur.MDP);
			conn.setAutoCommit(false);
		} catch (SQLException e) {

		}
	}
	
	/**
	 * Retourne l'instance de PersonneMapper
	 */
	
	public static PersonneMapper getInstance() {
		if (inst == null)
			inst = new PersonneMapper();
		return inst;
	}

	/**
	 * Supprime le contenue de la table TPNOTE_personne
	 */
	
	public void clear() {
		try {
			String req = "delete from TPNOTE_personne";
			PreparedStatement ps = conn.prepareStatement(req);
			ps.execute();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Insert en BDD une personne
	 * @param p
	 * 			personne à insérer en BDD
	 */
	public void insert(Personne p) {
		try {
			String req = "insert into TPNOTE_personne(id,nom,prenom,evaluation,pere) values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(req);
			ps.setInt(1, p.getId());
			ps.setString(2, p.getNom());
			ps.setString(3, p.getPrenom());
			if (p.getEvaluation() == null) {
				ps.setString(4, null);
			} else {
				ps.setString(4, p.getEvaluation());
			}
			if (p.getPere() == null) {
				ps.setString(5, null);
			} else {
				ps.setInt(5, p.getPere().getId());
			}
			ps.execute();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Delete la personne de la table
	 * @param p
	 * 			personne à supprimer de la BDD
	 */
	public void delete(Personne p) {
		try {
			String req = "delete from TPNOTE_personne whene id =?";
			PreparedStatement ps = conn.prepareStatement(req);
			ps.setInt(1, p.getId());
			ps.execute();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Modifie une personne dans la BDD
	 * @param p
	 * 			personne à modifier
	 */
	public void update(Personne p) {
		try {
			String req = "UPDATE TPNOTE_personne SET nom=? , prenom=? , evaluation=?, pere = ? WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(req);
			ps.setString(1, p.getNom());
			ps.setString(2, p.getPrenom());
			ps.setString(3, p.getEvaluation());
			if (p.getPere() == null) {
				ps.setString(4, null);
			} else {
				ps.setInt(4, p.getPere().getId());
			}
			ps.setInt(5, p.getId());
			ps.execute();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Recherche une personne à partir de son ID
	 * @param id
	 * 			id de la personne à trouver en BDD
	 * @return une personne
	 */
	public Personne findById(int id) {
		try {
			// on va chercher la personne
			String req = "SELECT id, nom, prenom, evaluation, pere  FROM TPNOTE_personne WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(req);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int id_personne = rs.getInt(1);
			String nom = rs.getString(2);
			String prenom = rs.getString(3);
			String evaluation = rs.getString(4);
			Personne pere = new VirtualProxyPersonne(rs.getInt(5));
			List<Personne> fils = new VirtualProxyListPersonne(id);
			Personne p = new Personne(id_personne,nom,prenom,evaluation,pere,fils);
			p.add(UnitOfWork.getInstance());
			return p;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * recherche les fils d'une personne à partir de son ID
	 * @param id
	 * 			id de personne à qui on veut connaitre les fils
	 * @return une liste de personne qui sont les fils
	 */

	public List<Personne> getFilsById(int id) {
		try {
			List<Personne> fils = new ArrayList<Personne>();
			String req = "SELECT id FROM TPNOTE_personne WHERE pere=?";
			PreparedStatement ps = conn.prepareStatement(req);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				fils.add(findById(rs.getInt(1)));
			}
			return fils;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
