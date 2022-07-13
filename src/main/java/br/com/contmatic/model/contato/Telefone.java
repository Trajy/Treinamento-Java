package br.com.contmatic.model.contato;

import java.util.Objects;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarExpressaoRegularETamanho;
import static br.com.contmatic.model.utils.constantes.TelefoneConstantes.*;
import static br.com.contmatic.model.utils.constantes.ExpressoesRegulares.NUMEROS;
import static br.com.contmatic.model.utils.constantes.ComumConstantes.NAO_VALIDAR_CHARS_REPETIDOS;

public class Telefone {

    private Integer ddi;

    private Integer ddd;

    private String numero;

    public Telefone(Integer ddd, String telefone) {
        setDdd(ddd);
        setNumero(telefone);
    }

    public Telefone(Integer ddi, Integer ddd, String numero) {
        setDdi(ddi);
        setDdd(ddd);
        setNumero(numero);
    }

    public Integer getDdi() {
        return this.ddi;
    }

    public void setDdi(Integer ddi) {
        validarExpressaoRegularETamanho(ddi, NUMEROS, DDI_TAMANHO_MIN, DDI_TAMANHO_MAX, DDI_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.ddi = ddi;
    }

    public Integer getDdd() {
        return this.ddd;
    }

    public void setDdd(Integer ddd) {
        validarExpressaoRegularETamanho(ddd, NUMEROS, DDD_TAMANHO_MIN, DDD_TAMANHO_MAX, DDD_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.ddd = ddd;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        validarExpressaoRegularETamanho(numero, NUMEROS, TELEFONE_MIN, TELEFONE_MAX, TELEFONE_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        return reflectionHashCode(this, "ddi");
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
        return reflectionToString(this, SHORT_PREFIX_STYLE);
    }

}
