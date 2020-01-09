package br.com.empresa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.empresa.dao.ProdutoDAO;
import br.com.empresa.exception.NegocioException;
import br.com.empresa.model.Produto;

@WebServlet("/removeProduto")
public class RemoveProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProdutoDAO dao = new ProdutoDAO();
		
		Long codigo = Long.parseLong(request.getParameter("codigo"));
		
		System.out.println("Codigo do produto: " + codigo);
		
		//remover o produto do BD
		try {
			dao.excluir(codigo);
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//busca todos produtos
		List<Produto> listaProdutos = dao.buscarTodos();
		
		RequestDispatcher rd = request.getRequestDispatcher("listaProdutos.jsp");
		request.setAttribute("produtos",listaProdutos );
		rd.forward(request, response);
		
		
	}

}
