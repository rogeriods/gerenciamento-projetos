package br.com.grupoindemetal.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.grupoindemetal.model.Projeto;
import br.com.grupoindemetal.repository.ProjetoRepository;
import br.com.grupoindemetal.repository.ProjetoRepositoryImpl;

@ManagedBean
@SessionScoped
public class ProjetoController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Projeto> projetos;
	private Projeto projeto;
	
	private ProjetoRepository projetoRepository = new ProjetoRepositoryImpl();
	
	@PostConstruct
	public void init() {
		carregaListaProjetos();
	}
	
	// Limpa form ou prepara objeto para nova inserção
	public String criarNovoProjeto() {
		projeto = new Projeto();
		return "projeto_form.xhtml";
	}
	
	public String gravar() {
		projetoRepository.criaProjeto(projeto);
		carregaListaProjetos();
		return "projeto_grid.xhtml";
	}
	
	// Carrega lista
	private void carregaListaProjetos() {
		projetos = projetoRepository.buscaProjetos();
	}
	
	// Getters and setters
	public List<Projeto> getProjetos() {
		return projetos;
	}
	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}
	
	public Projeto getProjeto() {
		return projeto;
	}
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	
}
