package br.com.grupoindemetal.repository;

import java.util.List;

import br.com.grupoindemetal.model.Desenvolvedor;

public interface DesenvolvedorRepository {
	
	// Neste módulo executo somente consultas
	// Caso precise criar, alterar ou excluir um desenvolvedor executar manualmente no banco de dados
	// Lembre-se de verificar as tarefas vinculadas ao mesmo
	public Desenvolvedor buscaDesenvolvedorPorId(Long id);
	public List<Desenvolvedor> buscaDesenvolvedores();

}
