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


@WebServlet("/alteraCategoria")
public class alteraCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
			
		CategoriaDAO dao = new CategoriaDAO();
		Long codigo = Long.parseLong(request.getParameter("codigo"));
		String nome = request.getParameter("nome");
		
		Categoria categoria = dao.buscarPeloCodigo(codigo);
		
		categoria.setNome(nome);
		
		dao.alterar(categoria);
						
		// buscar os categorias no BD
		List<Categoria> listaCategorias = dao.buscarTodos();
				 		
		//O sistema é direcionado para a página 
		//listaCategorias.jsp 
		RequestDispatcher rd = request.getRequestDispatcher("listaCategorias.jsp");
		request.setAttribute("categorias", listaCategorias);
		rd.forward(request, response);
		
		
	}

}
