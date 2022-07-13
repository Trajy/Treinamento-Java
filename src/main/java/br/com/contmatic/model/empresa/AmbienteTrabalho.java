package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.utils.constantes.AmbienteTrabalhoConstantes.NOME_AMBIENTE_TRABALHO_INVALIDO;
import static br.com.contmatic.model.utils.constantes.AmbienteTrabalhoConstantes.RESPONSAVEL_AMBIENTE_TRABALHO_INVALIDO;
import static br.com.contmatic.model.utils.constantes.AmbienteTrabalhoConstantes.TIPO_AMBIENTE_TRABALHO_INVALIDO;
import static br.com.contmatic.model.utils.constantes.ComumConstantes.NAO_VALIDAR_CHARS_REPETIDOS;
import static br.com.contmatic.model.utils.constantes.ComumConstantes.NOME_MAX;
import static br.com.contmatic.model.utils.constantes.ComumConstantes.NOME_MIN;
import static br.com.contmatic.model.utils.constantes.ExpressoesRegulares.LETRAS;
import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarExpressaoRegularETamanho;
import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarNulo;
import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

import java.util.Objects;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.contmatic.model.auditoria.Auditoria;
import br.com.contmatic.model.endereco.Endereco;

public class AmbienteTrabalho extends Auditoria {

    private String nome;
    
    private String tipoEstabelecimento;
    
    private Endereco endereco;
    
    private String responsavel;
    
    private String descricao;
    
    private Empresa empresa;

    public AmbienteTrabalho(String nome, String resposavel) {
        setNome(nome);
        setResponsavel(resposavel);
    }

    public AmbienteTrabalho(String nome, String tipoEstabelecimento, Endereco endereco, String responsavel, String descricao) {
        setNome(nome);
        setTipoEstabelecimento(tipoEstabelecimento);
        setEndereco(endereco);
        setResponsavel(responsavel);
        setDescricao(descricao);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validarExpressaoRegularETamanho(nome, LETRAS, NOME_AMBIENTE_TRABALHO_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.nome = nome;
    }

    public String getTipoEstabelecimento() {
        return tipoEstabelecimento;
    }

    public void setTipoEstabelecimento(String tipoEstabelecimento) {
        validarExpressaoRegularETamanho(tipoEstabelecimento, LETRAS, TIPO_AMBIENTE_TRABALHO_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.tipoEstabelecimento = tipoEstabelecimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        validarNulo(endereco);
        this.endereco = endereco;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        validarExpressaoRegularETamanho(responsavel, LETRAS, NOME_MIN, NOME_MAX, RESPONSAVEL_AMBIENTE_TRABALHO_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.responsavel = responsavel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
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
        return new HashCodeBuilder()
            .append(this.getNome())
            .append(this.getResponsavel())
            .hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if(!(obj instanceof AmbienteTrabalho)) {
            return false;
        }
        AmbienteTrabalho o = (AmbienteTrabalho) obj;
        return new EqualsBuilder()
                .append(this.getNome(), o.getNome())
                .append(this.getResponsavel(), o.getResponsavel())
                .isEquals();
    }

    @Override
    public String toString() {
        return reflectionToString(this, SHORT_PREFIX_STYLE); 
    }
    
}
