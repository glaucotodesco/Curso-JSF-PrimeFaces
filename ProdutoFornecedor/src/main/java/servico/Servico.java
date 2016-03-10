package servico;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import modelos.Fornecedor;
import modelos.Produto;
import modelos.Representante;

@ManagedBean(name="servico",eager=true)
@ApplicationScoped
public class Servico {
	
	private static List <Fornecedor>      fornecedores = new ArrayList <Fornecedor>(); 
	private static List <Produto>             produtos  = new ArrayList <Produto>();
	private static List <Representante>      representantes  = new ArrayList <Representante>();
	
	public Servico()
	{
	}
	
	
	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}
	public  void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public void saveFornecedor(Fornecedor fornecedor)
	{
		fornecedores.add(fornecedor);
	}
	
	public void saveProduto(Produto produto)
	{
		produtos.add(produto);
	}


	public void removeProduto(Produto produto) {
		
		produtos.remove(produto);
		
		
	}


	public void removeFornecedor(Fornecedor fornecedor) {
		fornecedores.remove(fornecedor);
		
	}


	public void saveRepresentante(Representante representante) {
		representantes.add(representante);
		
	}


	public List <Representante> getRepresentantes() {
		return representantes;	
	}


	public void removeRepresentante(Representante representante) {
		representantes.remove(representante);
		
		//Remove esse representante dos seus fornecedores
		for(Fornecedor f : representante.getFornecedores())
			f.getRepresentantes().remove(representante);
		
	}
	
	

}
