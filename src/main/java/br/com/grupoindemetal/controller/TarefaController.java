package br.com.grupoindemetal.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.grupoindemetal.model.Desenvolvedor;
import br.com.grupoindemetal.model.Projeto;
import br.com.grupoindemetal.model.Tarefa;
import br.com.grupoindemetal.repository.DesenvolvedorRepository;
import br.com.grupoindemetal.repository.DesenvolvedorRepositoryImpl;
import br.com.grupoindemetal.repository.ProjetoRepository;
import br.com.grupoindemetal.repository.ProjetoRepositoryImpl;
import br.com.grupoindemetal.repository.TarefaRepository;
import br.com.grupoindemetal.repository.TarefaRepositoryImpl;
import br.com.grupoindemetal.util.FacesUtil;

@ManagedBean
@SessionScoped
public class TarefaController implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Projeto> projetos;
	private List<Desenvolvedor> desenvolvedores;
	private List<Tarefa> tarefas;

	private Tarefa tarefa;
	private Tarefa tarefaSelecionada;

	private Long idProjeto;
	private Long idDesenvolvedor;

	private ProjetoRepository projetoRepository = new ProjetoRepositoryImpl();
	private DesenvolvedorRepository desenvolvedorRepository = new DesenvolvedorRepositoryImpl();
	private TarefaRepository tarefaRepository = new TarefaRepositoryImpl();

	@PostConstruct
	public void init() {
		carregaListaProjetos();
		carregaListaDesenvolvedores();
		carregaListaTarefas();
	}

	// Limpa form ou prepara objeto para nova inserção
	public String criarNovaTarefa() {
		tarefa = new Tarefa();
		tarefa.setDataCriacao(new Date());
		
		carregaListaProjetos();
		carregaListaDesenvolvedores();
		
		return "tarefa_form.xhtml";
	}
	
	public String preparaParaEdicao() {
		tarefa = tarefaSelecionada;
		
		carregaListaProjetos();
		carregaListaDesenvolvedores();
		
		return "tarefa_form.xhtml";
	}

	public String gravar() {
		// Se status for igual a true seto a data de conclusão da tarefa
		if (tarefa.isStatus() && tarefa.getDataConclusao() == null) {
			tarefa.setDataConclusao(new Date());
		}
		
		if (tarefa.getId() != null) {
			tarefaRepository.alteraTarefa(tarefa);
		} else {
			tarefaRepository.criaTarefa(tarefa);
		}
		
		carregaListaTarefas();
		return "index.xhtml";
	}
	
	public void excluir() {
		try {
			tarefaRepository.removeTarefa(tarefaSelecionada);
			tarefas.remove(tarefaSelecionada);
			FacesUtil.addSuccessMessage("Tarefa: " + tarefaSelecionada.getDescricao() + " excluída com sucesso.");
		} catch (Exception ex) {
			FacesUtil.addErrorMessage(ex.getMessage());
		}
	}

	// Filtros
	public void filtrarTodasAbertas() {
		// Aqui carrego a lista, pois o default da lista é todas em aberto
		carregaListaTarefas();
	}

	public void filtrarTodasFinalizadas() {
		tarefas = tarefaRepository.buscaTodasTarefasFinalizadas();
	}

	public void filtrarPorProjeto() {
		tarefas = tarefaRepository.buscaTodasTarefasPorProjeto(idProjeto);
	}

	public void filtrarPorDesenvolvedor() {
		tarefas = tarefaRepository.buscaTodasTarefasPorDesenvolvedor(idDesenvolvedor);
	}

	// Carrega listas
	private void carregaListaProjetos() {
		projetos = projetoRepository.buscaProjetos();
	}

	private void carregaListaDesenvolvedores() {
		desenvolvedores = desenvolvedorRepository.buscaDesenvolvedores();
	}
	
	private void carregaListaTarefas() {
		tarefas = tarefaRepository.buscaTodasTarefasAbertas();
	}

	// Getters and setters
	public List<Projeto> getProjetos() {
		return projetos;
	}
	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	public List<Desenvolvedor> getDesenvolvedores() {
		return desenvolvedores;
	}
	public void setDesenvolvedores(List<Desenvolvedor> desenvolvedores) {
		this.desenvolvedores = desenvolvedores;
	}
	
	public List<Tarefa> getTarefas() {
		return tarefas;
	}
	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
	
	public Tarefa getTarefaSelecionada() {
		return tarefaSelecionada;
	}
	public void setTarefaSelecionada(Tarefa tarefaSelecionada) {
		this.tarefaSelecionada = tarefaSelecionada;
	}

	public Long getIdProjeto() {
		return idProjeto;
	}
	public void setIdProjeto(Long idProjeto) {
		this.idProjeto = idProjeto;
	}

	public Long getIdDesenvolvedor() {
		return idDesenvolvedor;
	}
	public void setIdDesenvolvedor(Long idDesenvolvedor) {
		this.idDesenvolvedor = idDesenvolvedor;
	}

	public Tarefa getTarefa() {
		return tarefa;
	}
	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

}
