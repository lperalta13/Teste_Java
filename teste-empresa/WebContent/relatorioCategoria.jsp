<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,br.com.empresa.model.Categoria" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html lang="pt">
<head>
<title>Listagens</title>
</head>
<body>
	<div align="center">
		<form method="get" action="relProduto1">
			<fieldset>
				<legend>Listagens</legend>
				<label>Categoria:</label>
				<select name="categoria">
					<option value="">Selecione uma Categoria</option>
					<c:forEach var="categoria" items="${categorias}">
						<option value="${categoria.codigo}" >
							${categoria.nome}</option>
					</c:forEach>
				</select> 
				<br/>
				<input type="submit" value="Enviar">
				 
				<br />
			</fieldset>
		</form>
	</div>
</body>
</html>