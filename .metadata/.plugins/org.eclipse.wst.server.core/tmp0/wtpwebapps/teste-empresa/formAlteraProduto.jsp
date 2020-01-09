<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Altera Produto</title>
</head>
<body>
<form action="alteraProduto" method="get">
		Codigo: <input type="hidden" name="codigo" value="${produto.codigo}"> <br/> 
		Descrição: <input type="text" name="descricao" value="${produto.descricao}"> <br/> 
		Quantidade: <input type="text" name="quantidade" value="${produto.quantidade}"> <br/>		
		Categoria:
				<select name="categoria" >
					<option value="${produto.categoria.codigo }">${produto.categoria.nome}</option>
					<c:forEach var="categoria" items="${categorias}">
						<option value="${categoria.codigo}" >
							${categoria.nome}</option>
					</c:forEach>
				</select> 
				<br/>
				
		
		<input type="submit" value="Alterar">
	</form>

</body>
</html>