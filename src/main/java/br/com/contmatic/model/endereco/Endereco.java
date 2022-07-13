package br.com.contmatic.model.endereco;

import static br.com.contmatic.model.utils.constantes.ComumConstantes.NAO_VALIDAR_CHARS_REPETIDOS;
import static br.com.contmatic.model.utils.constantes.ComumConstantes.VALIDAR_CHARS_REPETIDOS;
import static br.com.contmatic.model.utils.constantes.EnderecoConstantes.BAIRRO_INVALIDO;
import static br.com.contmatic.model.utils.constantes.EnderecoConstantes.BAIRRO_MAX;
import static br.com.contmatic.model.utils.constantes.EnderecoConstantes.BAIRRO_MIN;
import static br.com.contmatic.model.utils.constantes.EnderecoConstantes.CEP_INVALIDO;
import static br.com.contmatic.model.utils.constantes.EnderecoConstantes.CEP_TAMANHO;
import static br.com.contmatic.model.utils.constantes.EnderecoConstantes.ENDERECO_NUMERO_MAX;
import static br.com.contmatic.model.utils.constantes.EnderecoConstantes.ENDERECO_NUMERO_MIN;
import static br.com.contmatic.model.utils.constantes.EnderecoConstantes.NUMERO_ENDERECO_INVALIDO;
import static br.com.contmatic.model.utils.constantes.EnderecoConstantes.RUA_INVALIDO;
import static br.com.contmatic.model.utils.constantes.EnderecoConstantes.RUA_MAX;
import static br.com.contmatic.model.utils.constantes.EnderecoConstantes.RUA_MIN;
import static br.com.contmatic.model.utils.constantes.ExpressoesRegulares.LETRAS;
import static br.com.contmatic.model.utils.constantes.ExpressoesRegulares.NUMEROS;
import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarExpressaoRegularETamanho;
import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarNulo;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import java.util.Objects;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.contmatic.model.auditoria.Auditoria;

public class Endereco extends Auditoria {

    private Integer numero;

    private String cep;

    private String rua;

    private String bairro;

    private Cidade cidade;

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
        validarExpressaoRegularETamanho(numero, NUMEROS, ENDERECO_NUMERO_MIN, ENDERECO_NUMERO_MAX, NUMERO_ENDERECO_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.numero = numero;
    }

    public String getCEP() {
        return cep;
    }

    public void setCEP(String cep) {
        validarExpressaoRegularETamanho(cep, NUMEROS, CEP_TAMANHO, CEP_INVALIDO, VALIDAR_CHARS_REPETIDOS);
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        validarExpressaoRegularETamanho(rua, LETRAS, RUA_MIN, RUA_MAX, RUA_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        validarExpressaoRegularETamanho(bairro, LETRAS, BAIRRO_MIN, BAIRRO_MAX, BAIRRO_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return this.cidade;
    }

    public void setCidade(Cidade cidade) {
        validarNulo(cidade);
        this.cidade = cidade;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(this.getCEP())
                .append(this.getNumero())
                .hashCode();
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
        return reflectionToString(this, SHORT_PREFIX_STYLE);
    }

}