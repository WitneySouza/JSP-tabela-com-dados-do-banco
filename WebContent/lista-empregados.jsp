<%@ page import="br.edu.ifg.proi.trabalho2.*" %>
<%@ page import="java.util.*, java.sql.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Trabalho 2 - Witney Reinande</title>
</head>
<body>
	<h1>Trabalho 02 JSP: Witney Reinande</h1>
	
	<table border="1" style="width:50%; text-align:center"  >
	<caption>Lista de Empregados</caption>

	<tr style="color:white; background-color:#41754d">
		<th>Matrícula </th>
		<th>Nome</th>
		<th>Endereço</th>
	</tr>
		
	<%
	Connection connection = new ConnectionFactory().getConnection();
	EmpregadoDAO empregadodao = new EmpregadoDAO();
	List<Empregado> empregados = empregadodao.listaEmpregados();
	
		for(int i = 0; i< empregados.size();i++){
			Empregado empregado = empregados.get(i);
			if(i%2 == 0){
				%>
				<tr>
				<td><%out.print(empregado.getMatricula()); %></td>
				<td><%out.print(empregado.getNome()); %></td>
				<td><%out.print(empregado.getEndereco()); %></td>
				</tr>
				<%
			}else{
				%>
				<tr style="background-color:#9de0b3">
				<td><%out.print(empregado.getMatricula()); %></td>
				<td><%out.print(empregado.getNome()); %></td>
				<td><%out.print(empregado.getEndereco()); %></td>
				</tr>
				<%
			}
		}
	%>
		
	</table>
	
	<%System.out.println("Tudo foi executado com sucesso!"); %>
	
	
</body>
</html>