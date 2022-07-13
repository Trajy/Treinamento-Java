package br.com.contmatic.model.endereco;

import static br.com.contmatic.model.utils.constantes.ComumConstantes.NAO_VALIDAR_CHARS_REPETIDOS;
import static br.com.contmatic.model.utils.constantes.ExpressoesRegulares.ALFANUMERICO;
import static br.com.contmatic.model.utils.constantes.ExpressoesRegulares.NUMEROS;
import static br.com.contmatic.model.utils.constantes.UnidadeFederativaConstantes.CODIGO_UF_INVALIDO;
import static br.com.contmatic.model.utils.constantes.UnidadeFederativaConstantes.NOME_UF_INVALIDO;
import static br.com.contmatic.model.utils.constantes.UnidadeFederativaConstantes.SIGLA_UF_INVALIDA;
import static br.com.contmatic.model.utils.constantes.UnidadeFederativaConstantes.TAMANHO_MAX_CODIGO;
import static br.com.contmatic.model.utils.constantes.UnidadeFederativaConstantes.TAMANHO_MIN_CODIGO;
import static br.com.contmatic.model.utils.constantes.UnidadeFederativaConstantes.TAMANHO_SIGLA;
import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarExpressaoRegularETamanho;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import java.util.Objects;

import org.apache.commons.lang3.builder.HashCodeBuilder;

public class UnidadeFederativa {
    
    private Integer codigo;
    
    private String nome;
    
    private String sigla;
    
    public UnidadeFederativa(Integer codigo){
        setCodigo(codigo);
    }
    
    public UnidadeFederativa(Integer codigo, String nome, String sigla){
        setCodigo(codigo);
        setNome(nome);
        setSigla(sigla);
    }
    
    public Integer getCodigo() {
        return codigo;
    }
    
    public void setCodigo(Integer codigo) {
        validarExpressaoRegularETamanho(codigo, NUMEROS, TAMANHO_MIN_CODIGO, TAMANHO_MAX_CODIGO, CODIGO_UF_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        validarExpressaoRegularETamanho(nome, NOME_UF_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.nome = nome;
    }
    public String getSigla() {
        return sigla;
    }
    public void setSigla(String uf) {
        validarExpressaoRegularETamanho(codigo, ALFANUMERICO, TAMANHO_SIGLA, SIGLA_UF_INVALIDA, NAO_VALIDAR_CHARS_REPETIDOS);
        this.sigla = uf;
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.getCodigo()).hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UnidadeFederativa other = (UnidadeFederativa) obj;
        return Objects.equals(codigo, other.codigo);
    }
    
    @Override
    public String toString() {
        return reflectionToString(this, SHORT_PREFIX_STYLE);
    }

}
