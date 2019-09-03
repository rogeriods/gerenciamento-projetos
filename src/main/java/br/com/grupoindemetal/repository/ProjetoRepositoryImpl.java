package br.com.grupoindemetal.repository;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.grupoindemetal.model.Projeto;
import br.com.grupoindemetal.util.JPAUtil;

public class ProjetoRepositoryImpl implements ProjetoRepository {

	@Override
	public void criaProjeto(Projeto projeto) {
		EntityManager em = JPAUtil.createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(projeto);
			em.getTransaction().commit();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		} finally {
			em.close();
		}
	}

	@Override
	public Projeto buscaProjetoPorId(Long id) {
		EntityManager em = JPAUtil.createEntityManager();
		Projeto projeto = null;
		
		try {
			projeto = em.find(Projeto.class, id);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		} finally {
			em.close();
		}
		
		return projeto;
	}

	@Override
	public List<Projeto> buscaProjetos() {
		EntityManager em = JPAUtil.createEntityManager();
		List<Projeto> projetos = null;
		
		try {
			projetos = em.createQuery("from Projeto", Projeto.class).getResultList();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		} finally {
			em.close();
		}
		
		return projetos;
	}
	
}
