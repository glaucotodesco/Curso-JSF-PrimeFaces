package managendbeans;


import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

import servico.Servico;
import sun.misc.FpUtils;
import modelos.Fornecedor;
import modelos.Produto;

@ManagedBean
@SessionScoped
public class FornecedorManagedBean {

	private Fornecedor fornecedor = new Fornecedor();
	private Fornecedor fornecedorSelecionado;
    private Servico servico = new Servico();
	

	/**
	 * @return the fornecedorSelecionado
	 */
	public Fornecedor getFornecedorSelecionado() {
		return fornecedorSelecionado;
	}

	/**
	 * @param fornecedorSelecionado the fornecedorSelecionado to set
	 */
	public void setFornecedorSelecionado(Fornecedor fornecedorSelecionado) {
		this.fornecedorSelecionado = fornecedorSelecionado;
	}

	public void salvar()
	{
		servico.saveFornecedor(fornecedor);
		fornecedor = new Fornecedor();
		
	}
	
	public DataModel<Fornecedor> getFornecedores()
	{
		return new FornecedorDataModel(servico.getFornecedores());
		
	}
	
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}


	public void remove(Fornecedor fornecedor)
	{
		servico.removeFornecedor(fornecedor);
		
	}
	
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List <Produto> getProdutosFornecedor()
	{
		if(fornecedorSelecionado != null)
			return fornecedorSelecionado.getProdutos();
		else
			return null;
	}
	
	public void onRowSelect(SelectEvent event) {
	     System.out.println("Evento Select: fornecedorSelecionado : " +  (Fornecedor) event.getObject());
	}
	
	public void onRowUnselect(SelectEvent event) {
		System.out.println("Evento UnSelect " +  (Fornecedor) event.getObject());
			 
     }

	
	
}
