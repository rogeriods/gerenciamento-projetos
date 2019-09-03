package br.com.grupoindemetal.repository;

import java.util.List;

import br.com.grupoindemetal.model.Tarefa;

public interface TarefaRepository {
	
	// Nesta interface eu criei estas duas assinaturas, mas na verdade pode ser alterado para apenas
	// um método exemplo criar e alterar para somente salvar() e aplicar um em.merge(objeto)
	public void criaTarefa(Tarefa tarefa);
	public void alteraTarefa(Tarefa tarefa);
	
	public void removeTarefa(Tarefa tarefaToDelete);
	
	public List<Tarefa> buscaTodasTarefasFinalizadas();
	public List<Tarefa> buscaTodasTarefasAbertas();
	public List<Tarefa> buscaTodasTarefasPorDesenvolvedor(Long idDesenvolvedor);
	public List<Tarefa> buscaTodasTarefasPorProjeto(Long idProjeto);
	
}
