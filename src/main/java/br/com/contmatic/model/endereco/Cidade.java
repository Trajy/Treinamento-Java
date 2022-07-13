package br.com.contmatic.model.endereco;

import java.util.Objects;

import org.apache.commons.lang3.builder.EqualsBuilder;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarExpressaoRegularETamanho;
import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarNulo;
import static br.com.contmatic.model.utils.constantes.ExpressoesRegulares.LETRAS;
import static br.com.contmatic.model.utils.constantes.EnderecoConstantes.CIDADE_INVALIDO;
import static br.com.contmatic.model.utils.constantes.EnderecoConstantes.PAIS_INVALIDO;
import static br.com.contmatic.model.utils.constantes.EnderecoConstantes.CIDADE_MIN;
import static br.com.contmatic.model.utils.constantes.EnderecoConstantes.CIDADE_MAX;
import static br.com.contmatic.model.utils.constantes.EnderecoConstantes.PAIS_MIN;
import static br.com.contmatic.model.utils.constantes.EnderecoConstantes.PAIS_MAX;
import static br.com.contmatic.model.utils.constantes.ComumConstantes.NAO_VALIDAR_CHARS_REPETIDOS;


public final class Cidade {

    private String nome;
    
    private UnidadeFederativa uf;
    
    private String pais;

    public Cidade(String nome, UnidadeFederativa uf, String pais) {
        setNome(nome);
        setUf(uf);
        setPais(pais);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validarExpressaoRegularETamanho(nome, LETRAS, CIDADE_MIN, CIDADE_MAX, CIDADE_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.nome = nome;
    }

    public UnidadeFederativa getUf() {
        return uf;
    }

    public void setUf(UnidadeFederativa uf) {
        validarNulo(uf);
        this.uf = uf;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        validarExpressaoRegularETamanho(pais, LETRAS, PAIS_MIN, PAIS_MAX, PAIS_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.pais = pais;
    }

    @Override
    public int hashCode() {
        return reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if(!(obj instanceof Cidade)) {
            return false;
        }
        Cidade o = (Cidade) obj;
        return new EqualsBuilder()
                .append(this.getNome(), o.getNome())
                .append(this.getUf(), o.getUf())
                .append(this.getPais(), o.getPais())
                .isEquals();
    }

    @Override
    public String toString() {
        return reflectionToString(this, SHORT_PREFIX_STYLE);
    }

}
