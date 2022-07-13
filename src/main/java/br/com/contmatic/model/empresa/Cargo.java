package br.com.contmatic.model.empresa;

import br.com.contmatic.model.auditoria.Auditoria;
import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarNulo;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarExpressaoRegularETamanho;
import static br.com.contmatic.model.utils.constantes.CargoConstantes.*;
import static br.com.contmatic.model.utils.constantes.AmbienteTrabalhoConstantes.NOME_AMBIENTE_TRABALHO_INVALIDO;
import static br.com.contmatic.model.utils.constantes.ExpressoesRegulares.NUMEROS;
import static br.com.contmatic.model.utils.constantes.ComumConstantes.NAO_VALIDAR_CHARS_REPETIDOS;

public class Cargo extends Auditoria {

    private String cbo;

    private String nome;

    private String descricao;

    private Empresa empresa;

    public Cargo(String cbo) {
        setCBO(cbo);
    }

    public Cargo(String cbo, String nome, String descricao) {
        setCBO(cbo);
        setNome(nome);
        setDescricao(descricao);
    }

    public String getCBO() {
        return cbo;
    }

    public void setCBO(String cbo) {
        validarExpressaoRegularETamanho(cbo, NUMEROS, CBO_MIN, CBO_MAX, CBO_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.cbo = cbo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validarExpressaoRegularETamanho(nome, NOME_AMBIENTE_TRABALHO_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        validarExpressaoRegularETamanho(descricao, DESCRICAO_CARGO_INVALIDA, NAO_VALIDAR_CHARS_REPETIDOS);
        this.descricao = descricao;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        validarNulo(empresa);
        this.empresa = empresa;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.getCBO()).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cargo other = (Cargo) obj;
        return cbo.equals(other.cbo);
    }

    @Override
    public String toString() {
        return reflectionToString(this, SHORT_PREFIX_STYLE);
    }

}
