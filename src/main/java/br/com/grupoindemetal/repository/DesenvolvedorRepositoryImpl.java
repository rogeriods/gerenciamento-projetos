package br.com.grupoindemetal.repository;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.grupoindemetal.model.Desenvolvedor;
import br.com.grupoindemetal.util.JPAUtil;

public class DesenvolvedorRepositoryImpl implements DesenvolvedorRepository {

	@Override
	public Desenvolvedor buscaDesenvolvedorPorId(Long id) {
		EntityManager em = JPAUtil.createEntityManager();
		Desenvolvedor desenvolvedor = null;
		
		try {
			desenvolvedor = em.find(Desenvolvedor.class, id);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		} finally {
			em.close();
		}
		
		return desenvolvedor;
	}

	@Override
	public List<Desenvolvedor> buscaDesenvolvedores() {
		EntityManager em = JPAUtil.createEntityManager();
		List<Desenvolvedor> desenvolvedores = null;
		
		try {
			desenvolvedores = em.createQuery("from Desenvolvedor", Desenvolvedor.class).getResultList();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		} finally {
			em.close();
		}
		
		return desenvolvedores;
	}

}
