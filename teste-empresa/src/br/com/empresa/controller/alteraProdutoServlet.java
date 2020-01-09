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
import br.com.empresa.model.Produto;


@WebServlet("/alteraProduto")
public class alteraProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
			
		 CategoriaDAO catDAO = new CategoriaDAO();
		 ProdutoDAO produtoDAO = new ProdutoDAO();
		 
		 Long codigo = Long.parseLong(request.getParameter("codigo"));
		 Produto produto = produtoDAO.buscarPeloCodigo(codigo);
		 
		 Long codigoCategoria = Long.parseLong(request.getParameter("categoria"));
		 System.out.println("atributo categoria: " + request.getParameter("categoria") );
		 
		 
		 //buscar a categoria e setar na classe Produto
		 produto.setCategoria(catDAO.buscarPeloCodigo(codigoCategoria));
		 
		 produto.setDescricao(request.getParameter("descricao"));
		 System.out.println("atributo descrição: " + request.getParameter("descricao") );
		 
		 produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
		 System.out.println("atributo quantidade: " + request.getParameter("quantidade") );
		 
		produtoDAO.alterar(produto);
						
		// buscar os produtos no BD
		List<Produto> listaProdutos = produtoDAO.buscarTodos();
				 		
		//O sistema é direcionado para a página 
		//listaProdutos.jsp 
		RequestDispatcher rd = request.getRequestDispatcher("listaProdutos.jsp");
		request.setAttribute("produtos", listaProdutos);
		rd.forward(request, response);
		
		
	}

}
