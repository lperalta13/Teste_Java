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
import br.com.empresa.model.Produto;


@WebServlet("/relProduto")
public class RelatorioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		 Produto produto = new Produto();
//		 CategoriaDAO catDAO = new CategoriaDAO();
		 ProdutoDAO produtoDAO = new ProdutoDAO();
		 
//		 Long codigoCategoria = Long.parseLong(request.getParameter("categoria"));
//		 System.out.println("atributo categoria: " + request.getParameter("categoria") );
		 
		 //buscar a categoria e setar na classe Produto
		 
		 
		 //System.out.println("atributo categoria: " + request.getParameter("categoria") );
		 switch (request.getParameter("acao")) {
		   case "list1":
			   	List<Produto> listaProdutos = produtoDAO.buscaTodosPorDescricaoAsc();
				 RequestDispatcher rd = request.getRequestDispatcher("listaProdutos.jsp");
				 request.setAttribute("produtos", listaProdutos);
				 rd.forward(request, response);

			   	break;

		   case "list2":
			   	List<Produto> listaProdutos1 = produtoDAO.buscaTodosPorDescricaoDesc();
				 RequestDispatcher rd1 = request.getRequestDispatcher("listaProdutos.jsp");
				 request.setAttribute("produtos", listaProdutos1);
				 rd1.forward(request, response);

			   	break;

		   case "list3":
			   	List<Produto> listaProdutos2 = produtoDAO.buscaTodosPorQuantidadeAsc();
				 RequestDispatcher rd2 = request.getRequestDispatcher("listaProdutos.jsp");
				 request.setAttribute("produtos", listaProdutos2);
				 rd2.forward(request, response);

			   	break;
		           
		   case "list4":
			   	List<Produto> listaProdutos3 = produtoDAO.buscaTodosPorQuantidadeDesc();
				 RequestDispatcher rd3 = request.getRequestDispatcher("listaProdutos.jsp");
				 request.setAttribute("produtos", listaProdutos3);
				 rd3.forward(request, response);

			   	break;
		           
		   case "list5":
			   	List<Produto> listaProdutos4 = produtoDAO.buscaMaiorMenorPorQuantidade();
				 RequestDispatcher rd4 = request.getRequestDispatcher("listaProdutos.jsp");
				 request.setAttribute("produtos", listaProdutos4);
				 rd4.forward(request, response);

			   	break;

			   	
		}

//		   	List<Produto> listaProdutos5 = (List<Produto>) produtoDAO.buscarComCategoriaPeloCodigo(codigoCategoria);
//			 RequestDispatcher rd5 = request.getRequestDispatcher("listaProdutos.jsp");
//			 request.setAttribute("produtos", listaProdutos5);
//			 rd5.forward(request, response);


	 
		 
	}

}
