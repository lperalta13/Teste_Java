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
 

 
@WebServlet("/categoriaServlet")
public class CategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	 
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		 
        Categoria categoria = new Categoria();
        CategoriaDAO dao = new CategoriaDAO();
							
		categoria.setNome(request.getParameter("nome"));
		System.out.println("Nome: " + categoria.getNome());

		dao.salvar(categoria);
			
		// buscar as categorias no BD
		List<Categoria> listaCategorias = dao.buscarTodos();
		 		
		//O sistema é direcionado para a página 
		//listaCategorias.jsp 
		RequestDispatcher rd = request.getRequestDispatcher("listaCategorias.jsp");
		request.setAttribute("categorias", listaCategorias);
		rd.forward(request, response);
	}
}