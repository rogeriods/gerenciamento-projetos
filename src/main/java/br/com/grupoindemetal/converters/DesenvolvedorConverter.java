package br.com.grupoindemetal.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.grupoindemetal.model.Desenvolvedor;
import br.com.grupoindemetal.repository.DesenvolvedorRepository;
import br.com.grupoindemetal.repository.DesenvolvedorRepositoryImpl;

@FacesConverter(value = "desenvolvedorConverter", forClass = Desenvolvedor.class)
public class DesenvolvedorConverter implements Converter {

	private DesenvolvedorRepository desenvolvedorRepository;

	public DesenvolvedorConverter() {
		desenvolvedorRepository = new DesenvolvedorRepositoryImpl();
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Desenvolvedor retorno = null;

		if (value != null) {
			retorno = desenvolvedorRepository.buscaDesenvolvedorPorId(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long id = ((Desenvolvedor) value).getId();
			String retorno = (id == null ? null : id.toString());
			return retorno;
		}

		return "";
	}

}
