package br.com.contmatic.model.endereco;

import static br.com.contmatic.model.utils.validacao.ValidacaoEndereco.*;
import static br.com.contmatic.model.utils.validacao.ValidacaoGeral.validarNulo;

import java.util.Objects;

public class Endereco {
    
    private Integer numero;
    private String cep;
    private String rua;
    private String bairro;
    private Cidade enderecoDb;

    public Endereco(Integer numero, String cep) {
        setNumero(numero);
        setCEP(cep);
    }
    
    public Endereco(Integer numero, String cep, String rua, String bairro, Cidade cidade) {
        setNumero(numero);
        setCEP(cep);
        setRua(rua);
        setBairro(bairro);
        setCidade(cidade);
    }

    public Integer getNumero() {
        return numero;
    }
    
    public void setNumero(Integer numero) {
        validarNumeroEndereco(numero);
        this.numero = numero;
    }

    public String getCEP() {
        return cep;
    }

    public void setCEP(String cep) {
        validarCep(cep);
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        validarRua(rua);
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        validarBairro(bairro);
        this.bairro = bairro;
    }
    
    public Cidade getCidade() {
    	return this.enderecoDb;
    }
    
    public void setCidade(Cidade enderecoDb) {
    	validarNulo(enderecoDb);
    	this.enderecoDb = enderecoDb;
    }
    
    @Override
	public int hashCode() {
		return Objects.hash(cep, numero);
	}

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(numero, other.numero);
	}

	@Override
	public String toString() {
		return "Endereco [numero=" + numero + ", cep=" + cep + ", rua=" + rua + ", bairro=" + bairro + ", enderecoDb="
				+ enderecoDb + "]";
	}
 
}