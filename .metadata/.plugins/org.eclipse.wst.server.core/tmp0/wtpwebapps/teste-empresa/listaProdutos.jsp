<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.empresa.model.Categoria" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Produtos - JSP</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>Codigo</td>
			<td>Descrição</td>	
			<td>Quantidade</td>
			<td>Categoria</td>
		</tr>
		<c:forEach items="${produtos}" var="produto">
		<tr> 
		<td>${produto.codigo}</td>
		<td>${produto.descricao}</td>
		<td>${produto.quantidade}</td>	
		<td>${produto.categoria.nome}</td>
		<td>	
		<a href="/teste-empresa/atualizaProduto?codigo=${produto.codigo}">
		editar
		</a>
		</td>		
		
		<td>
		<a href="/teste-empresa/removeProduto?codigo=${produto.codigo}">
		remover
		</a>
		</td>		
		</tr>		
		</c:forEach>
		
	</table>

</body>
</html>