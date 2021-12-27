package br.com.contmatic.model.endereco;

import java.util.Objects;
import static br.com.contmatic.model.utils.validacao.ValidacaoEndereco.validarCidade;
import static br.com.contmatic.model.utils.validacao.ValidacaoEndereco.validarEstado;
import static br.com.contmatic.model.utils.validacao.ValidacaoEndereco.validarPais;

public final class Cidade {
	
	private String nome;
    private String estado;
    private String pais;
    
    public Cidade() {
    	
    }
	
    // mudar para cidade e o atributo cidade para nome
	public Cidade(String cidade, String estado, String pais){
		setCidade(cidade);
        setEstado(estado);
        setPais(pais);
	}
    
    public String getCidade() {
        return nome;
    }

    public void setCidade(String cidade) {
        validarCidade(cidade);
        this.nome = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        validarEstado(estado);
        this.estado = estado;
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
		return Objects.hash(nome, estado, pais);
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
		return Objects.equals(nome, other.nome) && Objects.equals(estado, other.estado)
				&& Objects.equals(pais, other.pais);
	}

	@Override
	public String toString() {
		return "EnderecoDataBase [cidade=" + nome + ", estado=" + estado + ", pais=" + pais + "]";
	}
    
}
