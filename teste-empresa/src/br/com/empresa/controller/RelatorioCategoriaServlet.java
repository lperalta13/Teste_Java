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
import br.com.empresa.model.Categoria;



@WebServlet("/relatorioCategoria")
public class RelatorioCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//lista de categorias
		CategoriaDAO catDAO = new CategoriaDAO();
		List<Categoria> categorias = catDAO.buscarTodos();
		
		//dispachando para a página produto.jsp
	    RequestDispatcher rd = request.getRequestDispatcher("relatorioCategoria.jsp");
	    //setando as listas na requisição
	    
	    request.setAttribute("categorias", categorias);
	    
	    rd.forward(request, response);
		
		
	}

}
