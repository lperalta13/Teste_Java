package br.com.empresa.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.com.emprea.jpa.EntityManagerUtil;
import br.com.empresa.exception.NegocioException;
import br.com.empresa.model.Categoria;

public class CategoriaDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	private EntityManager em;

	public CategoriaDAO() {
		em = EntityManagerUtil.getEntityManager();
	}

	public void salvar(Categoria categoria) {
		em.getTransaction().begin();
		em.persist(categoria);
		em.getTransaction().commit();
	}
	
	public void alterar(Categoria categoria) {
		em.getTransaction().begin();
		em.merge(categoria);
		em.getTransaction().commit();
	}

	public List<Categoria> buscarTodos() {
		return em.createQuery("from Categoria order by codigo", 
				        Categoria.class).getResultList();
	}

	public void excluir(Long codigo) throws NegocioException {
		try {
			
			//Primeiro temos que buscar e setar a categoria a ser removida
			Categoria categoriaTemp = em.find(Categoria.class, codigo);
			
			em.getTransaction().begin();
			  
			//Para removermos basta usar o metodo remove e passar o objeto categoria
			em.remove(categoriaTemp);
			em.getTransaction().commit();		
			} catch (PersistenceException e) {
			throw new NegocioException("Categoria não pode ser excluida.");
		}
	}

	public Categoria buscarPeloCodigo(Long codigo) {
		return em.find(Categoria.class, codigo);
	}

}
