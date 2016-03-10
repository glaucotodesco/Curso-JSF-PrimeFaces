package modelos;

import java.util.ArrayList;
import java.util.List;

public class Representante {

	private int codigo;
	private String nome;
	private List <Fornecedor> fornecedores = new ArrayList <Fornecedor>();
	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the fornecedores
	 */
	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}
	/**
	 * @param fornecedores the fornecedores to set
	 */
	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}
	
	
	
}
