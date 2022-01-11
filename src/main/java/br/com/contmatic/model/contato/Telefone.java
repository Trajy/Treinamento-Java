package br.com.contmatic.model.contato;

import java.util.Objects;
import static br.com.contmatic.model.utils.validacao.ValidacaoContato.validarDdd;
import static br.com.contmatic.model.utils.validacao.ValidacaoContato.validarDdi;
import static br.com.contmatic.model.utils.validacao.ValidacaoContato.validarNumeroTelefone;

public class Telefone {
	
	private Integer ddi;
	private Integer ddd;
	private String numero;
	
	public Telefone(Integer ddd, String telefone) {
		setDdd(ddd);
		setNumero(telefone);
	}
	
	public Telefone(Integer ddi ,Integer ddd, String numero) {
		setDdi(ddi);
		setDdd(ddd);
		setNumero(numero);
	}
	
	public Integer getDdi() {
		return this.ddi;
	}
	
	public void setDdi(Integer ddi) {
		validarDdi(ddi);
		this.ddi = ddi;
	}
	
	public Integer getDdd() {
		return this.ddd;
	}
	
	public void setDdd(Integer ddd) {
		validarDdd(ddd);
		this.ddd = ddd;
	}
	
	public String getNumero() {
		return this.numero;
	}
	
	public void setNumero(String numero) {
		validarNumeroTelefone(numero);
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ddd, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		return Objects.equals(ddd, other.ddd) && Objects.equals(numero, other.numero);
	}

	@Override
	public String toString() {
		return "Telefone [ddi=" + ddi + ", ddd=" + ddd + ", numero=" + numero + "]";
	}
	
}
