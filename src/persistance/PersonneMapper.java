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

public class PersonneMapper {
	static Connection conn;
	static PersonneMapper inst;

	public PersonneMapper() {
		try {
			conn = DriverManager.getConnection(ConnectionInfo.DB_URL, Utilisateur.COMPTE, Utilisateur.MDP);
			conn.setAutoCommit(false);
		} catch (SQLException e) {

		}
	}

	public static PersonneMapper getInstance() {
		if (inst == null)
			inst = new PersonneMapper();
		return inst;
	}

	public void clear() {
		try {
			String req = "delete from TPNOTE_personne";
			PreparedStatement ps = conn.prepareStatement(req);
			ps.execute();
			conn.commit();
		} catch (SQLException e) {
			System.out.println("erreur lors de l'insertion");
		}
	}

	public void insert(Personne p) {
		try {
			String req = "insert into TPNOTE_personne(id,nom,prenom,evaluation,pere) values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(req);
			ps.setInt(1, p.getId());
			ps.setString(2, p.getNom());
			ps.setString(3, p.getPrenom());
			if (p.getEvaluation() == null) {
				System.out.println("evaluation null");
				ps.setString(4, null);
			} else {
				ps.setString(4, p.getEvaluation());
			}
			if (p.getPere() == null) {
				System.out.println("pere null");
				ps.setString(5, null);
			} else {
				ps.setInt(5, p.getPere().getId());
			}
			ps.execute();
			conn.commit();
		} catch (SQLException e) {
			System.out.println("erreur lors de l'insertion");
		}

	}

	public void delete(Personne p) {
		try {
			String req = "delete from TPNOTE_personne whene id =?";
			PreparedStatement ps = conn.prepareStatement(req);
			ps.setInt(1, p.getId());
			ps.execute();
			conn.commit();
		} catch (SQLException e) {
			System.out.println("erreur lors de la supression");
		}
	}

	public void update(Personne p) {
		try {
			String req = "UPDATE TPNOTE_personne SET nom=?, prenom=?, evaluation=?, pere=? WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(req);
			ps.setString(1, p.getNom());
			ps.setString(2, p.getPrenom());
			ps.setString(3, p.getEvaluation());
			ps.setInt(4, p.getPere().getId());
			ps.setInt(5, p.getId());
			ps.execute();
			conn.commit();
		} catch (SQLException e) {
			System.out.println("erreur lors de l'update");
		}
	}

	public Personne findById(String id) {
		try {
			// on va chercher la personne
			String req = "SELECT id, nom, prenom, evaluation, pere  FROM TPNOTE_personne WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(req);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			Personne p = new Personne();
			p.setId(rs.getInt(1));
			p.setNom(rs.getString(2));
			p.setPrenom(rs.getString(3));
			p.setEvaluation(rs.getString(4));
			p.setPere(new VirtualProxyPersonne(rs.getInt(5)));
			p.setFils(new VirtualProxyListPersonne(Integer.parseInt(id)));
			p.add(UnitOfWork.getInstance());
			return p;
		} catch (SQLException e) {
			System.out.println("erreur lors de la recherche de personne");
		}
		return null;
	}

	public List<Personne> getFilsById(String id) {
		try {
			List<Personne> fils = new ArrayList<Personne>();
			String req = "SELECT id FROM TPNOTE_personne WHERE pere=?";
			PreparedStatement ps = conn.prepareStatement(req);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				fils.add(findById(String.valueOf(rs.getInt(1))));
			}
			return fils;
		} catch (SQLException e) {
			System.out.println("erreur lors de la recherche de fils");
		}
		return null;
	}

}
