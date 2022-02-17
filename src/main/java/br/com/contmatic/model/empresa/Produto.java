package br.com.contmatic.model.empresa;

import static br.com.contmatic.model.utils.validacao.ValidacaoComum.validarExpressaoRegularETamanho;
import static br.com.contmatic.model.utils.constantes.ExpressoesRegulares.NUMEROS_COM_PONTO;
import static br.com.contmatic.model.utils.constantes.Avisos.NOME_PRODUTO_INVALIDO;
import static br.com.contmatic.model.utils.constantes.Avisos.RAZAO_SOCIAL_INVALIDO;
import static br.com.contmatic.model.utils.constantes.Avisos.CODIGO_INVALIDO;
import static br.com.contmatic.model.utils.constantes.Avisos.VERSAO_INVALIDA;
import static br.com.contmatic.model.utils.constantes.Avisos.DESCRICAO_PRODUTO_INVALIDA;
import static br.com.contmatic.model.utils.constantes.CamposLimites.PRODUTO_VERSAO_TAMANHO_MIN;
import static br.com.contmatic.model.utils.constantes.CamposLimites.PRODUTO_VERSAO_TAMANHO_MAX;
import static br.com.contmatic.model.utils.constantes.CamposLimites.PRODUTO_CODIGO_TAMANHO_MIN;
import static br.com.contmatic.model.utils.constantes.CamposLimites.PRODUTO_CODIGO_TAMANHO_MAX;
import static br.com.contmatic.model.utils.constantes.CamposLimites.NAO_VALIDAR_CHARS_REPETIDOS;

public class Produto extends Auditoria {

    private String nome;

    private String versao;

    private String codigo;

    private String descricao;

    private String empresa;

    public Produto(String codigo) {
        setCodigo(codigo);
    }

    public Produto(String nome, String versao, String codigo) {
        setNome(nome);
        setVersao(versao);
        setCodigo(codigo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        validarExpressaoRegularETamanho(nome, NOME_PRODUTO_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.nome = nome;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        validarExpressaoRegularETamanho(versao, NUMEROS_COM_PONTO, PRODUTO_VERSAO_TAMANHO_MIN, PRODUTO_VERSAO_TAMANHO_MAX, VERSAO_INVALIDA, NAO_VALIDAR_CHARS_REPETIDOS);
        this.versao = versao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        validarExpressaoRegularETamanho(codigo, NUMEROS_COM_PONTO, PRODUTO_CODIGO_TAMANHO_MIN, PRODUTO_CODIGO_TAMANHO_MAX, CODIGO_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        validarExpressaoRegularETamanho(descricao, DESCRICAO_PRODUTO_INVALIDA, NAO_VALIDAR_CHARS_REPETIDOS);
        this.descricao = descricao;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        validarExpressaoRegularETamanho(empresa, RAZAO_SOCIAL_INVALIDO, NAO_VALIDAR_CHARS_REPETIDOS);
        this.empresa = empresa;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codigo.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Produto other = (Produto) obj;
        return codigo.equals(other.codigo);
    }

    @Override
    public String toString() {
        return "Dados do Produto.\n" + "Nome: " + nome + "\n" + "Versão: " + versao + "\n" + "Código: " + codigo + "\n";
    }

}
