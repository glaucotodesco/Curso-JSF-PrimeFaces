package modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Fornecedor implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private int codigo;
	private String nome;
	private List<Produto> produtos = new ArrayList<Produto>();
	private List<Representante> representantes = new ArrayList<Representante>();
	
	public Fornecedor(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public Fornecedor() {
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public void addProduto(Produto produto)
	{
		produtos.add(produto);
		
	}
	
	
	

	/**
	 * @return the representantes
	 */
	public List<Representante> getRepresentantes() {
		return representantes;
	}

	/**
	 * @param representantes the representantes to set
	 */
	public void setRepresentantes(List<Representante> representantes) {
		this.representantes = representantes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	
	@Override
	public String toString() {
		return "Fornecedor [codigo=" + codigo + ", nome=" + nome + "]";
	}

	

	
	
	
	
}
