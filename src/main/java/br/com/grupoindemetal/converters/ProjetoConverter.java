package br.com.grupoindemetal.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.grupoindemetal.model.Projeto;
import br.com.grupoindemetal.repository.ProjetoRepository;
import br.com.grupoindemetal.repository.ProjetoRepositoryImpl;

@FacesConverter(value = "projetoConverter", forClass = Projeto.class)
public class ProjetoConverter implements Converter {

	private ProjetoRepository projetoRepository;

	public ProjetoConverter() {
		projetoRepository = new ProjetoRepositoryImpl();
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Projeto retorno = null;

		if (value != null) {
			retorno = projetoRepository.buscaProjetoPorId(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long id = ((Projeto) value).getId();
			String retorno = (id == null ? null : id.toString());
			return retorno;
		}

		return "";
	}

}
