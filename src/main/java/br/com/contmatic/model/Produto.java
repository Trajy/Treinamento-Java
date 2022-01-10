package br.com.contmatic.model;

import static br.com.contmatic.model.utils.validacao.ValidacaoGeral.*;
import static br.com.contmatic.model.utils.validacao.ValidacaoProduto.*;

public class Produto {
	
	private String nome;
	private String versao;
	private String codigo;
	
	public Produto (String nome) {
		setNome(nome);
	}
		
	public Produto(String nome, String versao, String codigo) {
		setNome(nome);
		setVersao(versao);
		setCodigo(codigo);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		validarComumAlfanumerico(nome);
		this.nome = nome;
	}

	public String getVersao() {
		return versao;
	}
	
	public void setVersao(String versao) {
		validarVersao(versao);
		this.versao = versao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		validarCodigo(codigo);
		this.codigo = codigo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Produto other = (Produto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dados do Produto.\n"
				+ "Nome: " + nome + "\n"
				+ "Versão: " + versao + "\n"
				+ "Código: " + codigo + "\n";
	}
	
}
