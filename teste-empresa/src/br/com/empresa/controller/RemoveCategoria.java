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
import br.com.empresa.exception.NegocioException;
import br.com.empresa.model.Categoria;

@WebServlet("/removeCategoria")
public class RemoveCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoriaDAO dao = new CategoriaDAO();
		
		Long codigo = Long.parseLong(request.getParameter("codigo"));
		
		System.out.println("Codigo categoria: " + codigo);
		
		//remover a categoria do BD
		try {
			dao.excluir(codigo);
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//busca todas categorias
		List<Categoria> listaCategorias = dao.buscarTodos();
		
		RequestDispatcher rd = request.getRequestDispatcher("listaCategorias.jsp");
		request.setAttribute("categorias",listaCategorias );
		rd.forward(request, response);
		
		
	}

}
