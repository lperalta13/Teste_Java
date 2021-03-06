package br.com.empresa.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import br.com.emprea.jpa.EntityManagerUtil;
import br.com.empresa.exception.NegocioException;
import br.com.empresa.model.Produto;


public class ProdutoDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager em;
	

	public ProdutoDAO() {
		em = EntityManagerUtil.getEntityManager();
	}
	
	public Produto buscarPeloCodigo(Long codigo) {
		return em.find(Produto.class, codigo);
	}
	
	public Produto buscarComCategoriaPeloCodigo(Long codigo) {
		// Na edi��o do produto, � importante retornar a categoria para o combo funcionar
		return em.createQuery
			("select c from Produto c inner join fetch c.categoria where c.codigo = :codigo" 
				, Produto.class)
				.setParameter("codigo", codigo)
				.getSingleResult();
	}
	
	public void salvar(Produto produto) {
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
		System.out.println("passou pelo persist do produto");
	}

	public List<Produto> buscarTodos() {
		return em.createQuery("from Produto order by codigo", Produto.class).getResultList();
	}
	
	public List<Produto> buscaTodosPorDescricaoAsc(){
		return em.createQuery("from Produto order by descricao asc", Produto.class).getResultList();
	}
	
	public List<Produto> buscaTodosPorDescricaoDesc(){
		return em.createQuery("from Produto order by descricao desc", Produto.class).getResultList();
	}

	public List<Produto> buscaTodosPorQuantidadeAsc(){
		return em.createQuery("from Produto order by quantidade asc", Produto.class).getResultList();
	}

	public List<Produto> buscaTodosPorQuantidadeDesc(){
		return em.createQuery("from Produto order by quantidade desc", Produto.class).getResultList();
	}
	
	public List<Produto> buscaTodosPorCategoria(Long codigo){
		return em.createQuery("from Produto where codigo_categoria =: codigo", Produto.class).setParameter("codigo", codigo).getResultList();
	}

	public List<Produto> buscaMaiorMenorPorQuantidade(){
		Query q1 = em.createQuery("from Produto where quantidade=(select max(quantidade) from Produto)");
		List l1 = q1.getResultList();
		
		Query q2 = em.createQuery("from Produto where quantidade=(select min(quantidade) from Produto)");
		List l2 = q2.getResultList();
		
		l1.addAll(l2);
		return l1;
		//return em.createQuery("select max(quantidade), min(quantidade) from Produto", Produto.class).getResultList();
	}

	public void excluir(Long codigo) throws NegocioException {
		try {
			
			//Primeiro temos que buscar e setar o produto a ser removido
			Produto produtoTemp = em.find(Produto.class, codigo);
			
			em.getTransaction().begin();
			  
			//Para removermos basta usar o metodo remove e passar o objeto modelo
			em.remove(produtoTemp);
			em.getTransaction().commit();		
			} catch (PersistenceException e) {
			throw new NegocioException("Produto n�o pode ser excluido.");
		}
	}
	
	public void alterar(Produto produto) {
		em.getTransaction().begin();
		em.merge(produto);
		em.getTransaction().commit();
	}
	
}
