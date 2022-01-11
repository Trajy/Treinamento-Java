package br.com.contmatic.model.endereco;

import java.util.Objects;
import static br.com.contmatic.model.utils.validacao.ValidacaoEndereco.validarCidade;
import static br.com.contmatic.model.utils.validacao.ValidacaoEndereco.validarEstado;
import static br.com.contmatic.model.utils.validacao.ValidacaoEndereco.validarPais;

public final class Cidade {
	
	private String nome;
    private String uf;
    private String pais;
	
	public Cidade(String nome, String uf, String pais){
		setNome(nome);
        setUf(uf);
        setPais(pais);
	}
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validarCidade(nome);
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        validarEstado(uf);
        this.uf = uf;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        validarPais(pais);
        this.pais = pais;
    }

	@Override
	public int hashCode() {
		return Objects.hash(nome, uf, pais);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(uf, other.uf)
				&& Objects.equals(pais, other.pais);
	}

	@Override
	public String toString() {
		return "EnderecoDataBase [cidade=" + nome + ", estado=" + uf + ", pais=" + pais + "]";
	}
    
}
