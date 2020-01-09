package br.com.empresa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.empresa.dao.CategoriaDAO;
import br.com.empresa.model.Categoria;


@WebServlet("/atualizaCategoria")
public class AtualizaCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoriaDAO dao = new CategoriaDAO();
		
		Long codigo = Long.parseLong(request.getParameter("codigo"));
		
		//buscar o categoria no BD para realizar alteração
		Categoria categoria = dao.buscarPeloCodigo(codigo);
		
		//redirecionar para a pagina que o usuario pode alterar os dados da categoria
		RequestDispatcher rd = request.getRequestDispatcher("formAlteraCategoria.jsp");
		
		//colocar objeto categoria em memoria
		request.setAttribute("categoria", categoria);
		
		rd.forward(request, response);
		
		
		
	}

}
