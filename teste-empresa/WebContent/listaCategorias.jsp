<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.empresa.model.Categoria" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Categorias - JSP</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>Codigo</td>
			<td>Nome</td>			
		</tr>
		<c:forEach items="${categorias}" var="categoria">
		<tr> 
		<td>${categoria.codigo}</td>
		<td>${categoria.nome}</td>	
		<td>	
		<a href="/teste-empresa/atualizaCategoria?codigo=${categoria.codigo}">
		editar
		</a>
		</td>		
		
		<td>
		<a href="/teste-empresa/removeCategoria?codigo=${categoria.codigo}">
		remover
		</a>
		</td>		
		</tr>		
		</c:forEach>
		
	</table>

</body>
</html>