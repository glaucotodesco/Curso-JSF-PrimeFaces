package managendbeans;

import java.util.List;

import javax.faces.model.ListDataModel;

import modelos.Fornecedor;
import modelos.Representante;

import org.primefaces.model.SelectableDataModel;

import servico.Servico;

public class RepresentanteDataModel extends ListDataModel<Representante> implements SelectableDataModel<Representante> 
{
	private static Servico servico = new Servico();
	
	public RepresentanteDataModel()
	{
		
	}

	public RepresentanteDataModel(List <Representante> list)
	{
	   super(list);	
	}

	
	@Override
	public Representante getRowData(String rowKey) {
		
		for(Representante r: servico.getRepresentantes())
		   if(Integer.parseInt(rowKey) ==  r.getCodigo())
			   return r;
		
		return null;
	}

	@Override
	public Object getRowKey(Representante representante) {
		return representante.getCodigo();
	}
	
}