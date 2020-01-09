package br.com.empresa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.empresa.dao.CategoriaDAO;
import br.com.empresa.dao.ProdutoDAO;
import br.com.empresa.model.Categoria;
import br.com.empresa.model.Produto;


@WebServlet("/atualizaProduto")
public class AtualizaProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProdutoDAO dao = new ProdutoDAO();
		
		Long codigo = Long.parseLong(request.getParameter("codigo"));
		
		//buscar o produto no BD para realizar alteração
		Produto produto = dao.buscarPeloCodigo(codigo);
		
		//lista de categorias
		CategoriaDAO catDAO = new CategoriaDAO();
		List<Categoria> categorias = catDAO.buscarTodos();
				
		//redirecionar para a pagina que o usuario pode alterar os dados do produto
		RequestDispatcher rd = request.getRequestDispatcher("formAlteraProduto.jsp");
		
		//colocar objeto produto em memoria
		request.setAttribute("produto", produto);
		
		//setando as listas na requisição
	    request.setAttribute("categorias", categorias);
	    
		rd.forward(request, response);
		
		
		
	}

}
