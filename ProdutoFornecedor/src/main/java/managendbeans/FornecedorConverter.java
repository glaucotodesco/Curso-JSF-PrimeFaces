package managendbeans;



import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import servico.Servico;
import modelos.Fornecedor;

@FacesConverter("converterFornecedor")
public class FornecedorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

		
		if (value != null && !value.isEmpty()) {
			
			Servico servico = (Servico) fc.getExternalContext().getApplicationMap().get("servico");
			  for(Fornecedor f : servico.getFornecedores())
				 if(f.getNome().equals(value))
				  	return f;
					
		}

		return null;

	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic,
			Object fornecedor) {
		if (fornecedor == null || fornecedor.equals("")) {
			return null;
		} else {
			return ((Fornecedor) fornecedor).getNome();

		}
	}

}
