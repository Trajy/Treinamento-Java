package br.com.contmatic.model.empresa;

import java.util.Objects;

import br.com.contmatic.model.auditoria.Auditoria;
import br.com.contmatic.model.endereco.Endereco;
import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarExpressaoRegularETamanho;
import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarNulo;
import static br.com.contmatic.model.utils.constantes.AmbienteTrabalhoConstantes.*;
import static br.com.contmatic.model.utils.constantes.ComumConstantes.NOME_MIN;
import static br.com.contmatic.model.utils.constantes.ComumConstantes.NOME_MAX;
import static br.com.contmatic.model.utils.constantes.ExpressoesRegulares.LETRAS;
import static br.com.contmatic.model.utils.constantes.ComumConstantes.NAO_VALIDAR_CHARS_REPETIDOS;

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
        return Objects.hash(nome, responsavel);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AmbienteTrabalho other = (AmbienteTrabalho) obj;
        return Objects.equals(nome, other.nome) && Objects.equals(responsavel, other.responsavel);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder().
            append("nome: ").append(nome).
            append("\ntipo de estabelecimento: ").append(tipoEstabelecimento).
            append("\nendereco: ").append(endereco).
            append("\nresponsavel: ").append(responsavel).
            append("\ndescricao: ").append(descricao);
        return stringBuilder.toString(); 
    }
    
}
