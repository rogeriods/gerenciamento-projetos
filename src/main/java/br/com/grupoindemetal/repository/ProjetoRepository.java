package br.com.grupoindemetal.repository;

import java.util.List;

import br.com.grupoindemetal.model.Projeto;

public interface ProjetoRepository {
	
	// Neste módulo só é possível criar e realizar consultas
	// Caso precise deletar ou atualizar algum projeto, por favor executar manualmente no banco de dados
	// Lembre-se de verificar as tarefas vinculadas ao mesmo
	public void criaProjeto(Projeto projeto);
	public Projeto buscaProjetoPorId(Long id);
	public List<Projeto> buscaProjetos();

}
