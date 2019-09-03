package br.com.grupoindemetal.repository;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.grupoindemetal.model.Tarefa;
import br.com.grupoindemetal.util.JPAUtil;

public class TarefaRepositoryImpl implements TarefaRepository {

	@Override
	public void criaTarefa(Tarefa tarefa) {
		EntityManager em = JPAUtil.createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(tarefa);
			em.getTransaction().commit();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		} finally {
			em.close();
		}
	}

	@Override
	public void alteraTarefa(Tarefa tarefa) {
		EntityManager em = JPAUtil.createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.merge(tarefa);
			em.getTransaction().commit();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		} finally {
			em.close();
		}
	}

	@Override
	public void removeTarefa(Tarefa tarefaToDelete) {
		EntityManager em = JPAUtil.createEntityManager();
		Tarefa tarefa = em.find(Tarefa.class, tarefaToDelete.getId());
		
		try {
			//tarefa = em.find(Tarefa.class, id);
			em.getTransaction().begin();
			em.remove(tarefa);
			em.getTransaction().commit();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		} finally {
			em.close();
		}	
	}

	@Override
	public List<Tarefa> buscaTodasTarefasFinalizadas() {
		EntityManager em = JPAUtil.createEntityManager();
		List<Tarefa> tarefas = null;
		
		try {
			tarefas = em.createQuery("from Tarefa t where t.status = 1", Tarefa.class).getResultList();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		} finally {
			em.close();
		}
		
		return tarefas;
	}

	@Override
	public List<Tarefa> buscaTodasTarefasAbertas() {
		EntityManager em = JPAUtil.createEntityManager();
		List<Tarefa> tarefas = null;
		
		try {
			tarefas = em.createQuery("from Tarefa t where t.status = 0", Tarefa.class).getResultList();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		} finally {
			em.close();
		}
		
		return tarefas;
	}

	@Override
	public List<Tarefa> buscaTodasTarefasPorDesenvolvedor(Long idDesenvolvedor) {
		EntityManager em = JPAUtil.createEntityManager();
		List<Tarefa> tarefas = null;
		
		try {
			tarefas = em.createQuery("from Tarefa t where t.desenvolvedor.id = " + idDesenvolvedor, Tarefa.class)
					.getResultList();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		} finally {
			em.close();
		}
		
		return tarefas;
	}

	@Override
	public List<Tarefa> buscaTodasTarefasPorProjeto(Long idProjeto) {
		EntityManager em = JPAUtil.createEntityManager();
		List<Tarefa> tarefas = null;
		
		try {
			tarefas = em.createQuery("from Tarefa t where t.projeto.id = " + idProjeto, Tarefa.class)
					.getResultList();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		} finally {
			em.close();
		}
		
		return tarefas;
	}

}
