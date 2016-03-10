package managendbeans;

import java.util.List;

import javax.faces.model.ListDataModel;

import modelos.Fornecedor;

import org.primefaces.model.SelectableDataModel;

import servico.Servico;

public class FornecedorDataModel extends ListDataModel<Fornecedor> implements SelectableDataModel<Fornecedor> 
{
	private static Servico servico = new Servico();
	
	public FornecedorDataModel()
	{
		
	}

	public FornecedorDataModel(List <Fornecedor> list)
	{
	   super(list);	
	}

	
	@Override
	public Fornecedor getRowData(String rowKey) {
		
		for(Fornecedor f: servico.getFornecedores())
		   if(Integer.parseInt(rowKey) ==  f.getCodigo())
			   return f;
		
		return null;
	}

	@Override
	public Object getRowKey(Fornecedor fornecedor) {
		return fornecedor.getCodigo();
	}
	
}