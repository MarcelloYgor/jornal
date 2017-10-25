package jornal.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jornal.datasource.JornalDatasource;
import jornal.model.Usuario;

public class UsuarioDAO {
	
	private JornalDatasource connection;
	
	public void cadastrarUsuario() {
		PreparedStatement stmt = null;
		try {
			connection = new JornalDatasource();
			String sql = "INSERT INTO usuarios VALUES(?,?,?,?,?);";
			stmt = connection.getPreparedStatement(sql);
			
			stmt.setString(1, "marcellosilva");
			stmt.setString(2, "Marcello");
			stmt.setString(3, "marcello@hotmail.com");
			stmt.setString(4, "1199999999");
			stmt.setString(5, "abcd12");
			
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
	
	public Usuario consultarUsuario(String usuario) {
		Usuario retorno = null;
		PreparedStatement stmt = null;
		try {
			connection = new JornalDatasource();
			String sql = "SELECT usuario, nome, email, telefone, password FROM usuarios"
					+ " WHERE usuario = ?;";
			stmt = connection.getPreparedStatement(sql);
			stmt.setString(1, usuario);
			
			ResultSet result = stmt.executeQuery();
			if (result.isBeforeFirst()) {
				result.next();
				retorno = new Usuario();
				retorno.setUsuario(result.getString("usuario"));
				retorno.setNome(result.getString("nome"));
				retorno.setEmail(result.getString("email"));
				retorno.setTelefone(result.getString("telefone"));
				retorno.setPassword(result.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.closeConnection(stmt);
			}
		}
		return retorno;
	}
	
	public void excluirUsuario(String nome) {
		PreparedStatement stmt = null;
		try {
			connection = new JornalDatasource();
			String sql = "DELETE FROM usuarios WHERE nome = ?;";
			stmt = connection.getPreparedStatement(sql);
			stmt.setString(1, nome);
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.closeConnection(stmt);
			}
		}
	}
	
	public void alterarUsuario(String upt, String nome) {
		PreparedStatement stmt = null;
		try {
			connection = new JornalDatasource();
			String sql = "UPDATE usuarios SET telefone = ? WHERE nome = ?;";
			stmt = connection.getPreparedStatement(sql);
			stmt.setString(1, upt);
			stmt.setString(2, nome);
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.closeConnection(stmt);
			}
		}
	}
}
