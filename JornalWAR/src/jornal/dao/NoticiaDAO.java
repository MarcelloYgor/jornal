package jornal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jornal.datasource.JornalDatasource;
import jornal.model.Noticia;

public class NoticiaDAO {
	
	private JornalDatasource connection;
	
	public void cadastrarNoticia() {
		PreparedStatement stmt = null;
		try {
			connection = new JornalDatasource();
			String sql = "INSERT INTO noticias VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
			stmt = connection.getPreparedStatement(sql);
			stmt.setString(1, "Esportes");
			stmt.setString(2, "Gotino");
			stmt.setString(3, "Neymar faz gol");
			stmt.setString(4, "Neymar recebe na área e marca");
			stmt.setDate(5, pegaDataAtual());
			stmt.setString(6, "1");
			stmt.setDate(7, pegaDataAtual());
			stmt.setInt(8, 5);
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Couldnt save object in database!\n SqlState: " + e.getSQLState() + "\nErrorCode: "
					+ e.getErrorCode() + " " + "\nMessage: " + e.getMessage());
		} finally {
			if (stmt != null) {
				connection.closeConnection(stmt);
			}
		}
	}
	
	public Noticia consultarNoticia(String titulo) {
		PreparedStatement stmt = null;
		Noticia retorno = null;
		try {
			connection = new JornalDatasource();
			String sql = "SELECT * FROM noticias WHERE titulo = ?";
			stmt = connection.getPreparedStatement(sql);
			stmt.setString(1, titulo);
			
			ResultSet result = stmt.executeQuery();
			if (result.isBeforeFirst()) {
				result.next();
				retorno = new Noticia();
				retorno.setTipo(result.getString("tipo"));
				retorno.setJornalista(result.getString("jornalista"));
				retorno.setTitulo(result.getString("titulo"));
				retorno.setDescricao(result.getString("descricao"));
				retorno.setDatacriacao(result.getDate("datacriacao"));
				retorno.setAprovadorId(result.getString("aprovador_id"));
				retorno.setAprovadordata(result.getDate("aprovador_data"));
				retorno.setAssinantes(result.getInt("assinantes"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				connection.closeConnection(stmt);
			}
		}
		return retorno;
	}
	
	public void excluirNoticia() {
		
	}
	
	public void alterarNoticia() {
		
	}
	
	public java.sql.Date pegaDataAtual() {
		java.util.Date dataAtual = new java.util.Date();
		java.sql.Date dataSql = new java.sql.Date(dataAtual.getTime());
		return dataSql;
	}
}
