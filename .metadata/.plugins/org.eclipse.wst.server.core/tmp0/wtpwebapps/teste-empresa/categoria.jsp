<!DOCTYPE html>
<html lang="pt">
<head>
<title>Cadastro de Categorias</title>
</head>
<body>
	<div align="center">
		<form method="post" action="categoriaServlet">
			
			<h1>Cadastro de Categorias</h1>
			Código:
			<input  type="hidden"  name="codigo" />
			<br /> 
		    Nome:
		    <input type="text" name="nome" />
			<br/>
				 
			<input type="submit" value="Enviar">
			<input type="reset" value="Limpar"> <br />
			
		</form>
	</div>
</body>
</html>