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

	public PersonneMapper() {
		try {
			conn = DriverManager.getConnection(ConnectionInfo.DB_URL, Utilisateur.COMPTE, Utilisateur.MDP);
			conn.setAutoCommit(false);
		} catch (SQLException e) {

		}
	}

	public void insert(Personne p) {
		try {
			String req = "insert into TPNOTE_personne values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(req);
			ps.setInt(1, p.getId());
			ps.setString(2, p.getNom());
			ps.setString(3, p.getPrenom());
			ps.setString(4, p.getEvaluation());
			ps.setInt(5, p.getPere().getId());
		} catch (SQLException e) {
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
		}
	}


	public Personne findById(String id) throws SQLException {
		//on va chercher la personne
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
		p.setPere(new VirtualProxyListPersonne(rs.getInt(5)));
		//Ici on va chercher ses fils
		String req2 = "SELECT id FROM TPNOTE_personne WHERE pere=?";
		PreparedStatement ps2 = conn.prepareStatement(req);
		ps2.setString(1, id);
		ResultSet rs2 = ps.executeQuery();
		while(rs2.next()){
			p.addFils(new VirtualProxyListPersonne(rs2.getInt(1)));
		}

		return p;
	}

	public List<Personne> getFilsById(String id) throws SQLException {
		List<Personne> p = new ArrayList<Personne>();
		return p;
	}

}
