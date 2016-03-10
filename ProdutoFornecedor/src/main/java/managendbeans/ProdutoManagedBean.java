package managendbeans;


import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import servico.Servico;
import modelos.Fornecedor;
import modelos.Produto;

@ManagedBean(name="produtoManagedBean")
@SessionScoped
public class ProdutoManagedBean {

	private Produto produto = new Produto();
	private Fornecedor fornecedor;
	
    private Servico servico = new Servico();
	
	
	public void salvar()
	{
		fornecedor.addProduto(produto);
		produto.setFornecedor(fornecedor);
		
		servico.saveProduto(produto);
		
		produto = new Produto();
		fornecedor = null;
		
	}
	
	
	
	public List <Fornecedor> getFornecedores()
	{
		return servico.getFornecedores();
		
	}
	
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}


	public void remove(Produto produto)
	{
		servico.removeProduto(produto);
		
	}
	
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public List<Produto> getListaProdutos() {
		return servico.getProdutos();
	}
	
	
	
	
	
	
}
