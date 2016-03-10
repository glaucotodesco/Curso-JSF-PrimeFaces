package managendbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.DualListModel;

import servico.Servico;
import modelos.Fornecedor;
import modelos.Representante;

@ManagedBean
public class RepresentanteManagedBean {

	  private Representante representante = new Representante();
	  private Representante representanteSelecionado = new Representante();
	  private Servico servico = new Servico();
	  private DualListModel<Fornecedor> dualList = new DualListModel<Fornecedor>();
	  
	  
	  public void salvar()
	  {
		  servico.saveRepresentante(representante);
		  representante = new Representante();
		  
	  }
	  
	  public void addFornecedorToRepresentante(Representante representante)
	  {
		representanteSelecionado = representante;  
		  
	  }
	  
	  public DualListModel<Fornecedor> getFornecedores()
	  {
		   List <Fornecedor> source  = servico.getFornecedores();
		   List <Fornecedor> target = new ArrayList<Fornecedor>();
		
		   if(representanteSelecionado != null)
		   {
			   target.addAll(representanteSelecionado.getFornecedores());
			   source.removeAll(representanteSelecionado.getFornecedores());
		   }
		   
		   dualList.setSource(source);
		   dualList.setTarget(target);
		   
		   return dualList;
		   
	  }
	  
	  
	  
	  public void remove(Representante representante)
	  {
		  servico.removeRepresentante(representante);
		  
	  }


	/**
	 * @return the representanteSelecionado
	 */
	public Representante getRepresentanteSelecionado() {
		return representanteSelecionado;
	}

   public void associar()
   {
	   List <Fornecedor> selecao = dualList.getTarget();
	   
	   for(Fornecedor f : selecao)
		   f.getRepresentantes().add(representanteSelecionado);
	   
	   representanteSelecionado.getFornecedores().addAll(selecao);
	   
   }


	/**
	 * @param representanteSelecionado the representanteSelecionado to set
	 */
	public void setRepresentanteSelecionado(Representante representanteSelecionado) {
		this.representanteSelecionado = representanteSelecionado;
	}




	/**
	 * @return the representante
	 */
	public Representante getRepresentante() {
		return representante;
	}


	/**
	 * @param representante the representante to set
	 */
	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}
	
	  
	public RepresentanteDataModel getRepresentantes()
	{
		return new RepresentanteDataModel(servico.getRepresentantes());
	}
	  
	
}
