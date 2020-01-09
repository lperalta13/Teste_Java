<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alterar Categoria</title>
</head>
<body>
<form action="alteraCategoria" method="get">
		Codigo: <input type="hidden" name="codigo" value="${categoria.codigo}"> <br/> 
		Nome: <input type="text" name="nome" value="${categoria.nome}"> <br/> 
		
		<input type="submit" value="Enviar">
	</form>

</body>
</html>