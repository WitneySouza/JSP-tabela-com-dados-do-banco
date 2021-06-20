package br.edu.ifg.proi.trabalho2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpregadoDAO {

	// a conexão com o banco de dados
	private Connection connection;
	 
		 
	 public EmpregadoDAO() {
		 new ConnectionFactory();
		this.connection = ConnectionFactory.getConnection();
	 }
	
	 public void inserirEmpregado(Empregado empregado) {
		 
		 String sql = "insert into trabalho01" + "(matricula, nome, endereco)" + "values (?,?,?)";
		 
		 try {
			 PreparedStatement stmt = connection.prepareCall(sql);
			 stmt.setInt(1,empregado.getMatricula());
			 stmt.setString(2,empregado.getNome());
			 stmt.setString(3,empregado.getEndereco());
			 
			 stmt.execute();
			 stmt.close();
		 }catch (SQLException e) {
			 throw new RuntimeException(e);
		 }
	 }
	 
	 
	 public void atualizaNomeEmpregado(Empregado empregado, String nome) {

		 try {
			 	Connection connection = ConnectionFactory.getConnection();
			 	String sql = "SELECT * FROM trabalho01 WHERE matricula = ?";
			 	PreparedStatement stmt = connection.prepareStatement(sql);
			 	stmt.setInt(1,empregado.getMatricula());
			 	ResultSet res = stmt.executeQuery();
			 	if(res.next()) {
			 		String sqlAtualiza = "UPDATE trabalho01 "
			 				+ "SET nome =? WHERE matricula = ?";
			 		PreparedStatement stmtAtualiza = connection.prepareStatement(sqlAtualiza);
			 		stmtAtualiza.setString(1, nome);
			 		stmtAtualiza.setInt(2, empregado.getMatricula());
			 		stmtAtualiza.executeUpdate();
			 		
			 	}else {
			 		throw new DaoException("Empregado não existe no banco");
			 	}
			 
		 }catch (SQLException e) {
			 throw new RuntimeException(e);
		 }
	 }
	 

	 public void atualizaEndEmpregado(Empregado empregado, String endereco) {
		 

		 try {
			 	Connection connection = ConnectionFactory.getConnection();
			 	String sql = "SELECT * FROM trabalho01 WHERE matricula = ?";
			 	PreparedStatement stmt = connection.prepareStatement(sql);
			 	stmt.setInt(1,empregado.getMatricula());
			 	ResultSet res = stmt.executeQuery();
			 	if(res.next()) {
			 		String sqlAtualiza = "UPDATE trabalho01 "
			 				+ "SET endereco =? WHERE matricula = ?";
			 		PreparedStatement stmtAtualiza = connection.prepareStatement(sqlAtualiza);
			 		stmtAtualiza.setString(1, endereco);
			 		stmtAtualiza.setInt(2, empregado.getMatricula());
			 		stmtAtualiza.executeUpdate();
			 	}else {
			 		throw new DaoException("Empregado não existe no banco!");
			 	}
			 
		 }catch (SQLException e) {
			 throw new RuntimeException(e);
		 }
	 }
	 
	 public void deletaEmpregado(int matricula) {
		 	
		 Empregado empregado = new Empregado(matricula);
		 
			 try {
				 Connection connection = ConnectionFactory.getConnection();
				 String sql = "SELECT * FROM trabalho01 WHERE matricula = ?";
				 PreparedStatement stmt = connection.prepareStatement(sql);
				 stmt.setInt(1, matricula);
				 ResultSet res = stmt.executeQuery();
				 if(res.next()) {
					 String sqlDeleta = "DELETE FROM trabalho01 where matricula =?";
					 PreparedStatement stmtDeleta = connection.prepareStatement(sqlDeleta);
					 stmtDeleta.setInt(1, empregado.getMatricula());
					 stmtDeleta.execute();
				 }else {
					 
					 throw new DaoException("Empregado não existe no banco!");
				 }
				 
				 
			 }catch (SQLException e) {
				 throw new RuntimeException(e);
			 }
	 }
	 
	 public Empregado buscaEmpregado(int matricula) {
		 	
		 	
		 try{
			 PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM trabalho01 WHERE matricula = ?");
			 stmt.setInt(1, matricula);
			 ResultSet rs = stmt.executeQuery();
			 			 
			 while(rs.next()) {
				Empregado empregado = new Empregado();
				empregado.setMatricula(rs.getInt("matricula"));
				empregado.setNome( rs.getString("nome"));
				empregado.setEndereco(rs.getString("endereco"));
				return empregado;
			 }
			 rs.close();
			 stmt.close();
			 			 
		 }catch (SQLException e) {
			 throw new RuntimeException(e);
		 }
		return null;
					 
		 
	 }
	 


	public List<Empregado> listaEmpregados(){
		
		try {
			List<Empregado> empregados = new ArrayList<Empregado>();
			PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM trabalho01");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Empregado empregado = new Empregado();
				empregado.setMatricula(rs.getInt("matricula"));
				empregado.setNome(rs.getString("nome"));
				empregado.setEndereco(rs.getString("endereco"));
				
				empregados.add(empregado);
			}
			rs.close();
			stmt.close();
			return empregados;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	 }
	
}
